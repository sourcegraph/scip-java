package com.sourcegraph.scip_semanticdb;

public class JdkPackage extends Package {
  public final String version;

  public JdkPackage(String version) {
    this.version = version;
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
