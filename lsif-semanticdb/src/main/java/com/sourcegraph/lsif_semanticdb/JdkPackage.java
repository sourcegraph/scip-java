package com.sourcegraph.lsif_semanticdb;

public class JdkPackage extends Package {
  public final String version;

  public JdkPackage(String version) {
    this.version = version;
  }

  @Override
  public String repoName() {
    return String.format("jdk:%s", version);
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
