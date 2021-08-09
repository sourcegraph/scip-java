package com.sourcegraph.semanticdb_javac;

import com.sun.source.util.JavacTask;
import com.sun.source.util.TaskEvent;
import com.sun.source.util.TaskListener;
import com.sourcegraph.semanticdb_javac.Semanticdb;
import com.sun.tools.javac.model.JavacTypes;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Callback hook that generates SemanticDB when the compiler has completed typechecking a Java
 * source file.
 */
public final class SemanticdbTaskListener implements TaskListener {
  private final SemanticdbJavacOptions options;
  private final JavacTask task;
  private final GlobalSymbolsCache globals;
  private final SemanticdbReporter reporter;
  private final JavacTypes javacTypes;

  public SemanticdbTaskListener(
      SemanticdbJavacOptions options,
      JavacTask task,
      GlobalSymbolsCache globals,
      SemanticdbReporter reporter,
      JavacTypes javacTypes) {
    this.options = options;
    this.task = task;
    this.globals = globals;
    this.reporter = reporter;
    this.javacTypes = javacTypes;
  }

  @Override
  public void started(TaskEvent e) {}

  @Override
  public void finished(TaskEvent e) {
    if (e.getKind() != TaskEvent.Kind.ANALYZE) return;
    try {
      onFinishedAnalyze(e);
    } catch (Exception ex) {
      // Catch exceptions because we don't want to stop the compilation even if this plugin has a
      // bug. We report the full stack trace because it's helpful for bug reports. Exceptions
      // should only happen in *exceptional* situations and they should be reported upstream.
      reporter.exception(ex);
    }
  }

  private void onFinishedAnalyze(TaskEvent e) {
    Result<Path, String> path = semanticdbOutputPath(options, e);
    if (path.isOk()) {
      Semanticdb.TextDocument textDocument =
          new SemanticdbVisitor(task, globals, e, options, javacTypes)
              .buildTextDocument(e.getCompilationUnit());
      writeSemanticdb(path.getOrThrow(), textDocument);
    } else {
      reporter.error(path.getErrorOrThrow());
    }
  }

  private void writeSemanticdb(Path output, Semanticdb.TextDocument textDocument) {
    try {
      byte[] bytes =
          Semanticdb.TextDocuments.newBuilder().addDocuments(textDocument).build().toByteArray();
      Files.write(output, bytes);
    } catch (IOException e) {
      reporter.exception(e);
    }
  }

  public static Path absolutePathFromUri(SemanticdbJavacOptions options, URI uri) {
    if (options.uriScheme == UriScheme.SBT
        && uri.getScheme().equals("vf")
        && uri.toString().startsWith("vf://tmp/")) {
      String[] parts = uri.toString().split("/", 5);
      if (parts.length == 5) {
        return options.sourceroot.resolve(Paths.get(parts[4]));
      } else {
        throw new IllegalArgumentException("unsupported URI: " + uri);
      }
    } else {
      return Paths.get(uri);
    }
  }

  private Result<Path, String> semanticdbOutputPath(SemanticdbJavacOptions options, TaskEvent e) {
    Path absolutePath = absolutePathFromUri(options, e.getSourceFile().toUri());
    if (absolutePath.startsWith(options.sourceroot)) {
      Path relativePath = options.sourceroot.relativize(absolutePath);
      String filename = relativePath.getFileName().toString() + ".semanticdb";
      Path semanticdbOutputPath =
          options
              .targetroot
              .resolve("META-INF")
              .resolve("semanticdb")
              .resolve(relativePath)
              .resolveSibling(filename);
      try {
        Files.createDirectories(semanticdbOutputPath.getParent());
        return Result.ok(semanticdbOutputPath);
      } catch (IOException exception) {
        return Result.error(
            String.format(
                "failed to create parent directory for '%s'. Error message: %s",
                semanticdbOutputPath, exception.getMessage()));
      }
    } else {
      return Result.error(
          String.format(
              "sourceroot '%s does not contain path '%s'. To fix this problem, update the -sourceroot flag to "
                  + "be a parent directory of this source file.",
              options.sourceroot, absolutePath));
    }
  }
}
