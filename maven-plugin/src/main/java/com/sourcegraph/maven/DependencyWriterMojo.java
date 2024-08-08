package com.sourcegraph.maven;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.*;
import org.apache.maven.project.MavenProject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

@Mojo(
    name = "sourcegraphDependencies",
    defaultPhase = LifecyclePhase.COMPILE,
    requiresDependencyResolution = ResolutionScope.TEST,
    requiresProject = true)
public class DependencyWriterMojo extends AbstractMojo {
  @Parameter(defaultValue = "${project}", required = true, readonly = true)
  MavenProject project;

  @Parameter(
      property = "semanticdb.targetRoot",
      defaultValue = "${session.executionRootDirectory}/target/semanticdb-targetroot")
  private String targetRoot;

  public void execute() throws MojoExecutionException, MojoFailureException {
    String sanitisedProjectId = project.getId().replaceAll("[^0-9_a-zA-Z()%\\-.]", "_");
    Set artifacts = project.getArtifacts();
    StringBuilder builder = new StringBuilder();

    String groupID = project.getGroupId();
    String artifactID = project.getArtifactId();
    String version = project.getVersion();
    List sourceRoots = project.getCompileSourceRoots();

    if (groupID == null || artifactID == null) {
      getLog()
          .warn(
              "Failed to extract groupID and artifactID from the project.\n"
                  + "This will not prevent a SCIP index from being created, but the symbols \n"
                  + "extracted from this project won't be available for cross-repository navigation,\n"
                  + "as this project doesn't define any Maven coordinates by which it can be referred back to.\n"
                  + "See here for more details: https://sourcegraph.github.io/scip-java/docs/manual-configuration.html#step-5-optional-enable-cross-repository-navigation\n");
    } else {
      for (Object root : sourceRoots) {
        getLog().info(root.toString());
        if (root instanceof String) {
          String rootString = (String) root;
          builder.append(
              String.format("%s\t%s\t%s\t%s\n", groupID, artifactID, version, rootString));
        }
      }
    }

    for (Object dep : artifacts) {
      if (dep instanceof Artifact) {
        Artifact artifact = (Artifact) dep;
        if (artifact.getFile() != null) {
          builder.append(
              String.format(
                  "%s\t%s\t%s\t%s\n",
                  artifact.getGroupId(),
                  artifact.getArtifactId(),
                  artifact.getVersion(),
                  artifact.getFile()));
        } else {
          getLog()
              .warn(
                  "Dependency "
                      + summariseArtifact(artifact)
                      + " does not have a resolved file, so it won't be added to the dependencies.txt");
        }
      }
    }

    Path dependenciesFile = Paths.get(targetRoot).resolve(sanitisedProjectId + ".dependencies.txt");

    try {
      Files.createDirectories(dependenciesFile.getParent());
      try (BufferedWriter writer = Files.newBufferedWriter(dependenciesFile)) {
        writer.write(builder.toString());
      }
    } catch (IOException e) {
      throw new MojoFailureException(
          "Failed to write dependencies to file " + dependenciesFile, e);
    }

    getLog().info("Dependencies were written to " + dependenciesFile.toAbsolutePath());
  }

  private String summariseArtifact(Artifact artifact) {
    return String.format(
        "%s:%s:%s", artifact.getGroupId(), artifact.getArtifactId(), artifact.getVersion());
  }
}
