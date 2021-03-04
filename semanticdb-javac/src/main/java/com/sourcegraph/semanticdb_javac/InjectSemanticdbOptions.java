package com.sourcegraph.semanticdb_javac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InjectSemanticdbOptions {
  /**
   * Updates a list of Java compiler arguments to include -Xplugin:semanticdb.
   *
   * <p>This main method should be used by a `javac` wrapper script like this:
   *
   * <pre>
   *     NEW_OPTIONS_PATH=$(mktemp)
   *     java -cp semanticdb.jar \
   *         -Dsemanticdb.output=NEW_OPTIONS_PATH \
   *         com.sourcegraph.semanticdb_javac.InjectSemanticdbOptions $@
   *     javac @$NEW_OPTIONS_PATH
   * </pre>
   *
   * Requires the following system properties:
   *
   * <ul>
   *   <li>-Dsemanticdb.output=PATH: the file to write the updated compiler options
   *   <li>-Dsemanticdb.old-output=PATH: the file to write the original compiler options. Only used
   *       for debugging purposes.
   *   <li>-Dsemanticdb.pluginpath=PATH: the path to the SemanticDB compiler plugin jar
   *   <li>-Dsemanticdb.sourceroot=PATH: the path to use in -Xplugin:semanticdb -sourceroot:PATH
   *   <li>-Dsemanticdb.targetroot=PATH: the path to use in -Xplugin:semanticdb -targetroot:PATH
   * </ul>
   *
   * @param args the Java compiler arguments to update.
   */
  public static void main(String[] args) throws IOException {
    SemanticdbOptionBuilder newArgs = new SemanticdbOptionBuilder();
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
