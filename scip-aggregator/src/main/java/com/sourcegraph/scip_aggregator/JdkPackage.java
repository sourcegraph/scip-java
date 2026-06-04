package com.sourcegraph.scip_aggregator;

public class JdkPackage extends Package {
  public final String version;

  public JdkPackage(String version) {
    this.version = version;
  }

  /**
   * Returns a {@link JdkPackage} for the currently running JVM, or the value of the {@code
   * scip.jdk.version} system property if set. The override exists so that tests can produce
   * JDK-independent snapshots.
   */
  public static JdkPackage forRuntime() {
    String override = System.getProperty("scip.jdk.version");
    if (override != null && !override.isEmpty()) {
      return new JdkPackage(override);
    }
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
