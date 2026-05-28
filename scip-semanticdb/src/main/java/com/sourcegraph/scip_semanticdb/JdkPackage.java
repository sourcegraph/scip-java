package com.sourcegraph.scip_semanticdb;

public class JdkPackage extends Package {
  public final String version;

  public JdkPackage(String version) {
    this.version = version;
  }

  /** Returns a {@link JdkPackage} for the currently running JVM. */
  public static JdkPackage forRuntime() {
    return new JdkPackage(Integer.toString(Runtime.version().feature()));
  }

  /** Parses a {@code java.version}-style string, keeping only the major version. */
  public static JdkPackage parse(String version) {
    int dot = version.indexOf('.');
    return new JdkPackage(dot < 0 ? version : version.substring(0, dot));
  }

  @Override
  public String repoName() {
    return "jdk";
  }

  @Override
  public String version() {
    return version;
  }

  @Override
  public String toString() {
    return "JdkPackage{" + "version='" + version + '\'' + '}';
  }
}
