package com.sourcegraph.semanticdb_javac;

import com.sun.source.util.JavacTask;
import com.sun.source.util.TaskEvent;
import com.sun.source.util.TaskListener;
import com.sun.source.util.Trees;
import com.sun.tools.javac.model.JavacTypes;

import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
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
  private final Trees trees;
  private boolean sourceGeneratorsMessageIsLogged = false;

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
    this.trees = Trees.instance(task);
  }

  @Override
  public void started(TaskEvent e) {}

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
      // Catch exceptions because we don't want to stop the compilation even if this
      // plugin has a
      // bug. We report the full stack trace because it's helpful for bug reports.
      // Exceptions
      // should only happen in *exceptional* situations and they should be reported
      // upstream.
      Throwable throwable = ex;
      if (e.getSourceFile() != null) {
        throwable =
            new CompilationUnitException(
                String.valueOf(e.getSourceFile().toUri().toString()), throwable);
      }
      reporter.exception(throwable, e.getCompilationUnit(), e.getCompilationUnit());
      throw new RuntimeException(ex.getMessage(), throwable);
    }
  }

  private void onFinishedAnalyze(TaskEvent e) {
    Result<Path, String> path = semanticdbOutputPath(options, e);
    if (path != null) {
      if (path.isOk()) {
        Semanticdb.TextDocument textDocument =
            new SemanticdbVisitor(task, globals, e, options, javacTypes)
                .buildTextDocument(e.getCompilationUnit());
        writeSemanticdb(e, path.getOrThrow(), textDocument);
      } else {
        reporter.error(path.getErrorOrThrow(), e);
      }
    }
  }

  private void writeSemanticdb(TaskEvent event, Path output, Semanticdb.TextDocument textDocument) {
    try {
      byte[] bytes =
          Semanticdb.TextDocuments.newBuilder().addDocuments(textDocument).build().toByteArray();
      Files.createDirectories(output.getParent());
      Files.write(output, bytes);
    } catch (IOException e) {
      reporter.exception(e, event.getCompilationUnit(), event.getCompilationUnit());
    }
  }

  public static Path absolutePathFromUri(SemanticdbJavacOptions options, JavaFileObject file) {
    URI uri = file.toUri();
    if ((options.uriScheme == UriScheme.SBT || options.uriScheme == UriScheme.ZINC)
        && uri.getScheme().equals("vf")
        && uri.toString().startsWith("vf://tmp/")) {
      String[] parts = uri.toString().split("/", 5);
      if (parts.length == 5) {
        return options.sourceroot.resolve(Paths.get(parts[4]));
      } else {
        throw new IllegalArgumentException("unsupported URI: " + uri);
      }
    } else if (options.uriScheme == UriScheme.BAZEL) {
      String toString = file.toString().replace(":", "/");
      // This solution is hacky, and it would be very nice to use a dedicated API
      // instead.
      // The Bazel Java compiler constructs `SimpleFileObject/DirectoryFileObject`
      // with a
      // "user-friendly" name that points to the original source file and an
      // underlying/actual
      // file path in a temporary directory. We're constrained by having to use only
      // public APIs of
      // the Java compiler and `toString()` seems to be the only way to access the
      // user-friendly
      // path.
      String[] knownBazelToStringPatterns =
          new String[] {"SimpleFileObject[", "DirectoryFileObject["};
      for (String pattern : knownBazelToStringPatterns) {
        if (toString.startsWith(pattern) && toString.endsWith("]")) {
          return Paths.get(toString.substring(pattern.length(), toString.length() - 1));
        }
      }
      throw new IllegalArgumentException("unsupported source file: " + toString);
    } else {
      return Paths.get(uri);
    }
  }

  // Infers the `-sourceroot:` flag from the provided file.
  // FIXME: add unit tests https://github.com/sourcegraph/scip-java/issues/444
  private void inferBazelSourceroot(JavaFileObject file) {
    if (options.uriScheme != UriScheme.BAZEL || options.sourceroot != null) {
      return;
    }
    Path absolutePath = absolutePathFromUri(options, file);
    Path uriPath = Paths.get(file.toUri());
    // absolutePath is the "human-readable" original path, for example
    // /home/repo/com/example/Hello.java
    // uriPath is the sandbox/temporary file path, for example
    // /private/var/tmp/com/example/Hello.java
    //
    // We infer sourceroot by iterating the names of both files in reverse order
    // and stop at the first entry where the two paths are different. For the
    // example above, we compare "Hello.java", then "example", then "com", and
    // when we reach "repo" != "tmp" then we guess that "/home/repo" is the
    // sourceroot. This logic is brittle and it would be nice to use more
    // dedicated APIs, but Bazel actively makes an effort to sandbox
    // compilation and hide access to the original workspace, which is why we
    // resort to solutions like this.
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

  private Result<Path, String> semanticdbOutputPath(SemanticdbJavacOptions options, TaskEvent e) {
    Path absolutePath = absolutePathFromUri(options, e.getSourceFile());
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
      return Result.ok(semanticdbOutputPath);
    } else {

      if (options.uriScheme == UriScheme.BAZEL && options.generatedTargetRoot != null) {
        try {
          if (absolutePath.toRealPath().startsWith(options.generatedTargetRoot)) {
            if (!sourceGeneratorsMessageIsLogged) {
              sourceGeneratorsMessageIsLogged = true;
              reporter.info(
                  "Usage of source generators detected - scip-java does not produce SemanticDB files for generated files.\n"
                      + "This message is logged only once",
                  e);
            }

            return null;
          }
        } catch (IOException exc) {
          reporter.exception(exc, e);
          return null;
        }
      }

      return Result.error(
          String.format(
              "sourceroot '%s does not contain path '%s'. To fix this problem, update the -sourceroot flag to "
                  + "be a parent directory of this source file.",
              options.sourceroot, absolutePath));
    }
  }
}
