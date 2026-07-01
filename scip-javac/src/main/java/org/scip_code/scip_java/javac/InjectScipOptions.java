package org.scip_code.scip_java.javac;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InjectScipOptions {

  /**
   * Updates a list of Java compiler arguments to include -Xplugin:scip.
   *
   * <p>This main method should be used by a `javac` wrapper script like this:
   *
   * <pre>
   *     NEW_OPTIONS_PATH=$(mktemp)
   *     java -cp scip.jar \
   *         -Dscip.output=NEW_OPTIONS_PATH \
   *         org.scip_code.scip_java.javac.InjectScipOptions $@
   *     javac @$NEW_OPTIONS_PATH
   * </pre>
   *
   * <p>Requires the following system properties:
   *
   * <ul>
   *   <li>-Dscip.output=PATH: the file to write the updated compiler options
   *   <li>-Dscip.old-output=PATH: the file to write the original compiler options. Only used for
   *       debugging purposes.
   *   <li>-Dscip.pluginpath=PATH: the path to the SCIP compiler plugin jar
   *   <li>-Dscip.sourceroot=PATH: the path to use in -Xplugin:scip -sourceroot:PATH
   *   <li>-Dscip.targetroot=PATH: the path to use in -Xplugin:scip -targetroot:PATH
   * </ul>
   *
   * @param args the Java compiler arguments to update.
   */
  public static void main(String[] args) {
    try {
      runMain(args);
    } catch (IOException e) {
      if (!ScipOptionBuilder.ERRORPATH.isEmpty()) {
        try {
          Path path = Paths.get(ScipOptionBuilder.ERRORPATH);
          Files.createDirectories(path.getParent());
          try (OutputStream out = Files.newOutputStream(path)) {
            e.printStackTrace(new PrintStream(out));
          }
        } catch (Exception ignored) {
        }
      }
    }
  }

  public static void runMain(String[] args) throws IOException {
    ScipOptionBuilder newArgs = new ScipOptionBuilder();
    for (String arg : args) {
      if (arg.startsWith("@")) {
        String filepath = arg.substring(1);
        Path path = Paths.get(filepath);
        if (Files.isRegularFile(path)) {
          List<String> lines = Files.readAllLines(path);
          for (String line : lines) {
            newArgs.processArgument(line);
          }
        }
      } else {
        newArgs.processArgument(arg);
      }
    }
    newArgs.write();
  }
}
