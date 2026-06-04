package com.sourcegraph.scip_aggregator;

public class OperatingSystem {
  public static boolean isWindows() {
    return System.getProperty("os.name").startsWith("Windows");
  }
}
