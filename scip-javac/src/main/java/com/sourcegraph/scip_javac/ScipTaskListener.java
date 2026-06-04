package com.sourcegraph.scip_javac;

import com.sourcegraph.scip.LocalSymbolsCache;
import com.sourcegraph.scip.NoRelativePathMode;
import com.sourcegraph.scip.ScipDocumentBuilder;
import com.sourcegraph.scip.ScipShardPaths;
import com.sourcegraph.scip.ScipShardWriter;
import com.sourcegraph.scip.ScipSymbols;
import com.sourcegraph.scip.UriScheme;
import com.sun.source.util.JavacTask;
import com.sun.source.util.TaskEvent;
import com.sun.source.util.TaskListener;
import com.sun.source.util.Trees;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Optional;
import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.JavaFileObject;
import org.scip_code.scip.Document;

/**
 * Callback hook that emits a per-source SCIP shard once the compiler has finished typechecking a
 * Java compilation unit. Shards are merged into the final SCIP index by the aggregator.
 */
public final class ScipTaskListener implements TaskListener {
  private final ScipJavacOptions options;
  private final GlobalSymbolsCache globals;
  private final ScipReporter reporter;
  private final Types types;
  private final Trees trees;
  private final Elements elements;
  // Javac fires ANALYZE once per top-level type; accumulate across rounds per output path.
  private final Map<Path, PerSourceState> perSourceState = new HashMap<>();
  private int noRelativePathCounter = 0;

  public ScipTaskListener(
      ScipJavacOptions options,
      JavacTask task,
      Trees trees,
      GlobalSymbolsCache globals,
      ScipReporter reporter) {
    this.options = options;
    this.globals = globals;
    this.reporter = reporter;
    this.types = task.getTypes();
    this.trees = trees;
    this.elements = task.getElements();
  }

  @Override
  public void started(TaskEvent e) {
    if (e.getKind() != TaskEvent.Kind.ENTER) return;
    inferBazelSourceroot(e.getSourceFile());
    Result<Path, String> shardPath = scipShardOutputPath(e);
    if (!shardPath.isOk()) return;
    Path output = shardPath.getOrThrow();
    perSourceState.remove(output);
    try {
      Files.deleteIfExists(output);
    } catch (IOException ex) {
      reportException(ex, e);
    }
  }

  @Override
  public void finished(TaskEvent e) {
    if (e.getKind() != TaskEvent.Kind.ANALYZE) return;
    if (!options.errors.isEmpty()) {
      if (!options.alreadyReportedErrors) {
        options.alreadyReportedErrors = true;
        for (String error : options.errors) reporter.error(error, e);
      }
      return;
    }
    inferBazelSourceroot(e.getSourceFile());
    try {
      onFinishedAnalyze(e);
    } catch (Throwable ex) {
      // Catch exceptions because we don't want to stop the compilation even if this
      // plugin has a bug. We report the full stack trace because it's helpful for bug
      // reports. Exceptions should only happen in *exceptional* situations and they
      // should be reported upstream.
      Throwable throwable = ex;
      if (e.getSourceFile() != null) {
        throwable =
            new CompilationUnitException(
                String.valueOf(e.getSourceFile().toUri().toString()), throwable);
      }
      reportException(throwable, e);
    }
  }

  // Uses reporter.error with the full stack trace instead of reporter.exception because
  // the latter doesn't print any meaningful information about the exception.
  private void reportException(Throwable exception, TaskEvent e) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintWriter pw = new PrintWriter(baos);
    exception.printStackTrace(pw);
    pw.close();
    reporter.error(baos.toString(), e.getCompilationUnit(), e.getCompilationUnit());
  }

  private void onFinishedAnalyze(TaskEvent e) {
    Result<Path, String> path = scipShardOutputPath(e);
    if (path == null) return;
    if (!path.isOk()) {
      reporter.error(path.getErrorOrThrow(), e);
      return;
    }
    Path output = path.getOrThrow();
    PerSourceState state = perSourceState.computeIfAbsent(output, k -> new PerSourceState());
    ScipVisitor visitor =
        new ScipVisitor(
            globals,
            state.locals,
            e.getCompilationUnit(),
            types,
            trees,
            elements,
            state.documentBuilder);
    visitor.visitCompilationUnit();
    String relativePath = scipRelativePath(e);
    String text = options.includeText ? visitor.getSource() : "";
    Document document = state.documentBuilder.build("java", relativePath, text);
    writeShard(e, output, document);
  }

  private String scipRelativePath(TaskEvent e) {
    Path absolutePath = absolutePathFromUri(options, e.getSourceFile());
    return ScipShardPaths.relativePath(options.sourceroot, absolutePath);
  }

  private void writeShard(TaskEvent event, Path output, Document document) {
    try {
      ScipShardWriter.writeShard(output, document);
    } catch (IOException e) {
      reportException(e, event);
    }
  }

  private static final class PerSourceState {
    final ScipDocumentBuilder documentBuilder = new ScipDocumentBuilder();
    final LocalSymbolsCache<Element, String> locals =
        new LocalSymbolsCache<>(new IdentityHashMap<>(), ScipSymbols::local);
  }

  public static Path absolutePathFromUri(ScipJavacOptions options, JavaFileObject file) {
    URI uri = file.toUri();
    if (options.uriScheme == UriScheme.BAZEL) {
      String toString = file.toString().replace(":", "/");
      // Bazel's Java compiler constructs `SimpleFileObject/DirectoryFileObject` with a
      // "user-friendly" name that points to the original source file and an underlying
      // file path in a temporary directory. We're constrained by having to use only
      // public APIs of the Java compiler and `toString()` seems to be the only way to
      // access the user-friendly path.
      String[] knownBazelToStringPatterns =
          new String[] {"SimpleFileObject[", "DirectoryFileObject["};
      for (String pattern : knownBazelToStringPatterns) {
        if (toString.startsWith(pattern) && toString.endsWith("]")) {
          Path path = Paths.get(toString.substring(pattern.length(), toString.length() - 1));
          if (path.isAbsolute()) return path;
          return options.sourceroot.resolve(path);
        }
      }
    }
    return Paths.get(uri);
  }

  // Infers the `-sourceroot:` flag from the provided file.
  // FIXME: add unit tests https://github.com/sourcegraph/scip-java/issues/444
  private void inferBazelSourceroot(JavaFileObject file) {
    if (options.uriScheme != UriScheme.BAZEL || options.sourceroot != null) return;
    Path absolutePath = absolutePathFromUri(options, file);
    Path uriPath = Paths.get(file.toUri());
    // absolutePath is the "human-readable" original path, e.g. /home/repo/com/example/Hello.java.
    // uriPath is the sandbox/temporary file path, e.g. /private/var/tmp/com/example/Hello.java.
    // Infer sourceroot by iterating the names of both files in reverse order and stopping at
    // the first entry where the two paths differ.
    int relativePathDepth = 0;
    int uriPathDepth = uriPath.getNameCount();
    int absolutePathDepth = absolutePath.getNameCount();
    while (relativePathDepth < uriPathDepth && relativePathDepth < absolutePathDepth) {
      String uriName = uriPath.getName(uriPathDepth - relativePathDepth - 1).toString();
      String pathName = absolutePath.getName(absolutePathDepth - relativePathDepth - 1).toString();
      if (!uriName.equals(pathName)) break;
      relativePathDepth++;
    }
    options.sourceroot =
        absolutePath
            .getRoot()
            .resolve(absolutePath.subpath(0, absolutePathDepth - relativePathDepth));
  }

  private Result<Path, String> scipShardOutputPath(TaskEvent e) {
    Path absolutePath = absolutePathFromUri(options, e.getSourceFile());
    Optional<Path> happyPath =
        ScipShardPaths.shardPath(options.targetroot, options.sourceroot, absolutePath);
    if (happyPath.isPresent()) return Result.ok(happyPath.get());

    switch (options.noRelativePath) {
      case INDEX_ANYWAY:
        String uniqueFilename =
            String.format("%d.%s.scip", ++noRelativePathCounter, absolutePath.getFileName());
        Path output =
            options
                .targetroot
                .resolve("META-INF")
                .resolve("scip")
                .resolve("no-relative-path")
                .resolve(uniqueFilename);
        return Result.ok(output);
      case WARNING:
        reporter.info(
            String.format(
                "Skipping file '%s' because it is not under the sourceroot '%s'",
                absolutePath, options.sourceroot),
            e);
        // fall through
      case SKIP:
        return null;
      case ERROR:
      default:
        String baseMessage =
            String.format(
                "Unable to detect the relative path of '%s'. A common reason for this error is that the file is auto-generated. "
                    + "To fix this problem update the flag -no-relative-path:VALUE to have one of the following values: %s.",
                absolutePath, NoRelativePathMode.validStringValuesWithoutError());
        if (options.uriScheme == UriScheme.BAZEL) return Result.error(baseMessage);
        return Result.error(
            baseMessage
                + " Alternatively, configure the -sourceroot:PATH flag to point to a directory path that is the parent of all indexed files.");
    }
  }
}
