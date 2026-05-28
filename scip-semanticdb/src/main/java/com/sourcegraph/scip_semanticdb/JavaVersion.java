package com.sourcegraph.scip_semanticdb;

public class JavaVersion {
  public final JdkPackage pkg;

  public static final int JAVA11_VERSION = 11;
  public static final int DEFAULT_JAVA_VERSION = JAVA11_VERSION;

  public JavaVersion() {
    this(System.getProperty("java.version"));
  }

  public JavaVersion(String version) {
    pkg = new JdkPackage(javaVersion(version));
  }

  private String javaVersion(String version) {
    String[] parts = version.split("\\.");
    if (parts.length > 0) return parts[0];
    else return version;
  }
}
