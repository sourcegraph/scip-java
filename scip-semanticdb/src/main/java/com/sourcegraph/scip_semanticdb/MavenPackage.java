package com.sourcegraph.scip_semanticdb;

import java.nio.file.Path;

public class MavenPackage extends Package {
  public final Path jar;
  public final String groupId;
  public final String artifactId;
  public final String version;

  public MavenPackage(Path jar, String groupId, String artifactId, String version) {
    this.jar = jar;
    this.groupId = groupId;
    this.artifactId = artifactId;
    this.version = version;
  }

  public MavenPackage withJar(Path newJar) {
    return new MavenPackage(newJar, this.groupId, this.artifactId, this.version);
  }

  @Override
  public String repoName() {
    return String.format("maven/%s/%s", groupId, artifactId);
  }

  @Override
  public String version() {
    return version;
  }

  @Override
  public String toString() {
    return "MavenPackage{"
        + "jar="
        + jar
        + ", groupId='"
        + groupId
        + '\''
        + ", artifactId='"
        + artifactId
        + '\''
        + ", version='"
        + version
        + '\''
        + '}';
  }
}
