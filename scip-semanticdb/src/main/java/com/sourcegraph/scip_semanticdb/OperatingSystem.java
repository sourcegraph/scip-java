package com.sourcegraph.scip_semanticdb;

public class OperatingSystem {
  public static boolean isWindows() {
    return System.getProperty("os.name").startsWith("Windows");
  }
}
