package com.sourcegraph.semanticdb_javac;

import com.sun.source.util.JavacTask;
import com.sun.source.util.TaskEvent;
import com.sun.source.util.TaskListener;
import com.sun.source.util.Trees;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import org.scip_code.scip.Index;

import javax.tools.JavaFileObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Callback hook that drives {@link ScipVisitor} after javac finishes typechecking a Java source
 * file. The visitor builds a self-contained {@code *.scip} shard which is written (or merged) under
 * {@code META-INF/scip/...}.
 */
public final class SemanticdbTaskListener implements TaskListener {
  private final SemanticdbJavacOptions options;
  private final GlobalSymbolsCache globals;
  private final SemanticdbReporter reporter;
  private final Types types;
  private final Trees trees;
  private final Elements elements;
  private int noRelativePathCounter = 0;

  public SemanticdbTaskListener(
      SemanticdbJavacOptions options,
      JavacTask task,
      Trees trees,
      GlobalSymbolsCache globals,
      SemanticdbReporter reporter) {
    this.options = options;
    this.globals = globals;
    this.reporter = reporter;
    this.types = task.getTypes();
    this.trees = trees;
    this.elements = task.getElements();
  }

  @Override
  public void started(TaskEvent e) {
    // Upon first encounter with a file (before any other tasks are run) we remove any prior SCIP
    // shard for this source file to avoid accumulating stale occurrences across builds.
    if (e.getKind() == TaskEvent.Kind.ENTER) {
      inferBazelSourceroot(e.getSourceFile());
      Result<Path, String> shardPath = scipShardOutputPath(options, e);
      if (shardPath != null && shardPath.isOk()) {
        try {
          Files.deleteIfExists(shardPath.getOrThrow());
        } catch (IOException ex) {
          this.reportException(ex, e);
        }
      }
    }
  }

  @Override
  public void finished(TaskEvent e) {
    if (e.getKind() != TaskEvent.Kind.ANALYZE) return;
    if (!options.errors.isEmpty()) {
      if (!options.alreadyReportedErrors) {
        options.alreadyReportedErrors = true;
        for (String error : options.errors) {
          reporter.error(error, e);
        }
      }
      return;
    }
    inferBazelSourceroot(e.getSourceFile());
    try {
      onFinishedAnalyze(e);
    } catch (Throwable ex) {
      // Catch exceptions because we don't want to stop the compilation even if this plugin has a
      // bug. We report the full stack trace because it's helpful for bug reports.
      Throwable throwable = ex;
      if (e.getSourceFile() != null) {
        throwable =
            new CompilationUnitException(
                String.valueOf(e.getSourceFile().toUri().toString()), throwable);
      }
      this.reportException(throwable, e);
    }
  }

  // Uses reporter.error with the full stack trace of the exception instead of reporter.exception
  // because reporter.exception doesn't seem to print any meaningful information about the
  // exception, it just prints the location with an empty message.
  private void reportException(Throwable exception, TaskEvent e) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintWriter pw = new PrintWriter(baos);
    exception.printStackTrace(pw);
    pw.close();
    reporter.error(baos.toString(), e.getCompilationUnit(), e.getCompilationUnit());
  }

  private void onFinishedAnalyze(TaskEvent e) {
    Result<Path, String> path = scipShardOutputPath(options, e);
    if (path == null) return;
    if (!path.isOk()) {
      reporter.error(path.getErrorOrThrow(), e);
      return;
    }

    Path shardPath = path.getOrThrow();
    try {
      Index shard =
          new ScipVisitor(globals, e.getCompilationUnit(), options, types, trees, elements)
              .buildShard(e.getCompilationUnit());
      ScipShardWriter.writeOrMerge(shardPath, shard);
    } catch (IOException ex) {
      this.reportException(ex, e);
    }
  }

  public static Path absolutePathFromUri(SemanticdbJavacOptions options, JavaFileObject file) {
    URI uri = file.toUri();
    if (options.uriScheme == UriScheme.BAZEL) {
      String toString = file.toString().replace(":", "/");
      // This solution is hacky, and it would be very nice to use a dedicated API instead.
      // The Bazel Java compiler constructs `SimpleFileObject/DirectoryFileObject` with a
      // "user-friendly" name that points to the original source file and an underlying/actual
      // file path in a temporary directory. We're constrained by having to use only public APIs of
      // the Java compiler and `toString()` seems to be the only way to access the user-friendly
      // path.
      String[] knownBazelToStringPatterns =
          new String[] {"SimpleFileObject[", "DirectoryFileObject["};
      for (String pattern : knownBazelToStringPatterns) {
        if (toString.startsWith(pattern) && toString.endsWith("]")) {
          Path path = Paths.get(toString.substring(pattern.length(), toString.length() - 1));
          if (path.isAbsolute()) {
            return path;
          }
          return options.sourceroot.resolve(path);
        }
      }
      // Fallback to default behavior.
    }

    return Paths.get(uri);
  }

  // Infers the `-sourceroot:` flag from the provided file.
  // FIXME: add unit tests https://github.com/sourcegraph/scip-java/issues/444
  private void inferBazelSourceroot(JavaFileObject file) {
    if (options.uriScheme != UriScheme.BAZEL || options.sourceroot != null) {
      return;
    }
    Path absolutePath = absolutePathFromUri(options, file);
    Path uriPath = Paths.get(file.toUri());
    // See comments in the previous implementation for the rationale of the inference loop below.
    int relativePathDepth = 0;
    int uriPathDepth = uriPath.getNameCount();
    int absolutePathDepth = absolutePath.getNameCount();
    while (relativePathDepth < uriPathDepth && relativePathDepth < absolutePathDepth) {
      String uriName = uriPath.getName(uriPathDepth - relativePathDepth - 1).toString();
      String pathName = absolutePath.getName(absolutePathDepth - relativePathDepth - 1).toString();
      if (!uriName.equals(pathName)) {
        break;
      }
      relativePathDepth++;
    }
    options.sourceroot =
        absolutePath
            .getRoot()
            .resolve(absolutePath.subpath(0, absolutePathDepth - relativePathDepth));
  }

  private Result<Path, String> scipShardOutputPath(SemanticdbJavacOptions options, TaskEvent e) {
    Path absolutePath = absolutePathFromUri(options, e.getSourceFile());
    if (absolutePath.startsWith(options.sourceroot)) {
      Path relativePath = options.sourceroot.relativize(absolutePath);
      String filename = relativePath.getFileName().toString() + ".scip";
      Path scipOutputPath =
          options
              .targetroot
              .resolve("META-INF")
              .resolve("scip")
              .resolve(relativePath)
              .resolveSibling(filename);
      return Result.ok(scipOutputPath);
    }

    switch (options.noRelativePath) {
      case INDEX_ANYWAY:
        // Come up with a unique relative path for this file even if it's not under the sourceroot.
        // By indexing auto-generated files, we collect SymbolInformation for auto-generated
        // symbols, which results in more useful hover tooltips in the editor.
        String uniqueFilename =
            String.format("%d.%s.scip", ++noRelativePathCounter, absolutePath.getFileName());
        Path scipOutputPath =
            options
                .targetroot
                .resolve("META-INF")
                .resolve("scip")
                .resolve("no-relative-path")
                .resolve(uniqueFilename);
        return Result.ok(scipOutputPath);
      case WARNING:
        reporter.info(
            String.format(
                "Skipping file '%s' because it is not under the sourceroot '%s'",
                absolutePath, options.sourceroot),
            e);
      case SKIP:
        return null;
      case ERROR:
      default:
        String baseMessage =
            String.format(
                "Unable to detect the relative path of '%s'. A common reason for this error is that the file is that this file is auto-generated. "
                    + "To fix this problem update the flag -no-relative-path:VALUE to have one of the following values: %s.",
                absolutePath, NoRelativePathMode.validStringValuesWithoutError());
        if (options.uriScheme == UriScheme.BAZEL) {
          return Result.error(baseMessage);
        }

        return Result.error(
            baseMessage
                + " Alternatively, configure the -sourceroot:PATH flag to point to a directory path that is the parent of all indexed files.");
    }
  }
}
