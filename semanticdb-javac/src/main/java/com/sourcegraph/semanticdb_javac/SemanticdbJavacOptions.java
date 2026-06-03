package com.sourcegraph.semanticdb_javac;

import com.sourcegraph.semanticdb.NoRelativePathMode;
import com.sourcegraph.semanticdb.SemanticdbOptions;
import com.sourcegraph.semanticdb.UriScheme;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;

import com.sun.source.util.JavacTask;

import static javax.tools.StandardLocation.CLASS_OUTPUT;

/** Settings that can be configured alongside the -Xplugin compiler option. */
public class SemanticdbJavacOptions extends SemanticdbOptions {

  public boolean verboseEnabled = false;
  public final ArrayList<String> errors = new ArrayList<>();
  public boolean alreadyReportedErrors = false;

  public static String missingRequiredDirectoryOption(String option) {
    return String.format(
        "missing argument '-%s'. To fix this problem, update the Java compiler option "
            + "'-Xplugin:semanticdb -%s:DIRECTORY' where DIRECTORY is the path to a valid directory.",
        option, option);
  }

  public static String JAVAC_CLASSES_DIR_ARG = "javac-classes-directory";

  public static SemanticdbJavacOptions parse(String[] args, JavacTask task) {
    SemanticdbJavacOptions result = new SemanticdbJavacOptions();

    boolean useJavacClassesDir = false;
    for (String arg : args) {
      if (arg.startsWith("-targetroot:")) {
        String argValue = arg.substring("-targetroot:".length());
        if (argValue.equals(JAVAC_CLASSES_DIR_ARG)) {
          useJavacClassesDir = true;
          result.targetroot = getJavacClassesDir(result, task);
        } else {
          result.targetroot = Paths.get(argValue);
        }
      } else if (arg.startsWith("-sourceroot:")) {
        result.sourceroot = Paths.get(arg.substring("-sourceroot:".length())).normalize();
      } else if (arg.startsWith("-no-relative-path:")) {
        String value = arg.substring("-no-relative-path:".length());
        switch (value) {
          case "index_anyway":
            result.noRelativePath = NoRelativePathMode.INDEX_ANYWAY;
            break;
          case "skip":
            result.noRelativePath = NoRelativePathMode.SKIP;
            break;
          case "error":
            result.noRelativePath = NoRelativePathMode.ERROR;
            break;
          case "warning":
            result.noRelativePath = NoRelativePathMode.WARNING;
            break;
          default:
            result.errors.add(
                String.format(
                    "unknown -no-relative-path mode '%s'. Valid values are %s.",
                    value, NoRelativePathMode.validStringValues()));
        }
      } else if (arg.equals("-build-tool:bazel")) {
        result.uriScheme = UriScheme.BAZEL;
        useJavacClassesDir = true;
        result.targetroot = getJavacClassesDir(result, task);
      } else if (arg.equals("-text:on")) {
        result.includeText = true;
      } else if (arg.equals("-text:off")) {
        result.includeText = false;
      } else if (arg.equals("-verbose")) {
        result.verboseEnabled = true;
      } else if (arg.equals("-verbose:on")) {
        result.verboseEnabled = true;
      } else if (arg.equals("-verbose:off")) {
        result.verboseEnabled = false;
      } else if (arg.startsWith("-randomtimestamp")) {
      } else {
        result.errors.add(String.format("unknown flag '%s'\n", arg));
      }
    }
    if (result.targetroot == null && !useJavacClassesDir) {
      result.errors.add(missingRequiredDirectoryOption("targetroot"));
    }
    if (!isSourcerootDefined(result)) {
      // When using -build-tool:bazel, the sourceroot is automatically inferred from
      // the first
      // compilation unit.
      // See `SemanticdbTaskListener.inferBazelSourceroot()` for the method that
      // infers the
      // sourceroot.
      result.errors.add(missingRequiredDirectoryOption("sourceroot"));
    }
    return result;
  }

  private static boolean isSourcerootDefined(SemanticdbJavacOptions options) {
    if (options.uriScheme == UriScheme.BAZEL) {
      return true; // The sourceroot is automatically inferred for Bazel.
    }
    return options.sourceroot != null;
  }

  // warning - use of internal API
  // requires --add-exports jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED
  private static Path getJavacClassesDir(SemanticdbJavacOptions result, JavacTask task) {
    // both Context and BasicJavacTask are internal JDK classes so not exported
    // under >= JDK 17
    // com.sun.tools.javac.util.Context ctx =
    // ((com.sun.tools.javac.api.BasicJavacTask)
    // task).getContext();
    // I'm not aware of a better way to get the class output directory from javac
    try {
      Method getContext = task.getClass().getMethod("getContext");
      Object context = getContext.invoke(task);
      Method get = context.getClass().getMethod("get", Class.class);
      JavaFileManager fm = (JavaFileManager) get.invoke(context, JavaFileManager.class);
      FileObject classOutputDirStub =
          fm.getJavaFileForOutput(
              CLASS_OUTPUT, SemanticdbPlugin.stubClassName, JavaFileObject.Kind.CLASS, null);
      return Paths.get(classOutputDirStub.toUri()).toAbsolutePath().getParent();
    } catch (Exception e) {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      e.printStackTrace(new PrintStream(out));
      String errorMsg =
          String.format(
              "exception while processing SemanticDB option '-targetroot:%s'\n%s",
              JAVAC_CLASSES_DIR_ARG, out.toString());
      result.errors.add(errorMsg);
      return null;
    }
  }
}
