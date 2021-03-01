package com.sourcegraph.semanticdb_javac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InjectSemanticdbOptions {
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
