package com.sourcegraph.lsif_semanticdb;

public class JavaVersion {
  public final boolean isJava8;
  public final JdkPackage pkg;

  public JavaVersion() {
    this(System.getProperty("java.version"));
  }

  public JavaVersion(String version) {
    isJava8 = version.startsWith("1.8");
    pkg = new JdkPackage(isJava8 ? "8" : javaVersion(version));
  }

  private String javaVersion(String version) {
    if (version.startsWith("1.8")) return "8";
    String[] parts = version.split("\\.");
    if (parts.length > 0) return parts[0];
    else return version;
  }
}
