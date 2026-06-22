package com.sourcegraph.gradle.scip;

final class Logging {

  private Logging() {}

  static void warn(String message) {
    System.err.println("[WARNING] [scip-java.gradle] " + message);
  }
}
