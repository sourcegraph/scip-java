package com.sourcegraph.lsif_semanticdb;

public class OperatingSystem {
  public static boolean isWindows() {
    return System.getProperty("os.name").startsWith("Windows");
  }
}
