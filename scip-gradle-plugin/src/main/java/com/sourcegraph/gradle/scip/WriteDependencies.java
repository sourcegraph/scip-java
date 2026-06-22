package com.sourcegraph.gradle.scip;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.publish.PublishingExtension;
import org.gradle.api.publish.maven.MavenPublication;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.api.tasks.TaskAction;

public class WriteDependencies extends DefaultTask {

  private static final String CROSS_REPO_BANNER =
      "This will not prevent a SCIP index from being created, but the symbols\n"
          + "extracted from this project won't be available for cross-repository navigation,\n"
          + "as this project doesn't define any Maven coordinates by which it can be referred back"
          + " to.\n"
          + "See here for more details:"
          + " https://sourcegraph.github.io/scip-java/docs/manual-configuration.html#step-5-optional-enable-cross-repository-navigation";

  @TaskAction
  public void printResolvedDependencies() throws IOException {
    Project project = getProject();

    Optional<Path> depsOut =
        Optional.ofNullable(project.getExtensions().getExtraProperties().get("dependenciesOut"))
            .map(Object::toString)
            .map(Paths::get);

    if (depsOut.isPresent()) {
      Files.createDirectories(depsOut.get().getParent());
    }

    List<String> deps = new ArrayList<>();
    String projectName = project.getName();
    String projectPath = project.getPath().replaceAll("[^a-z0-9A-Z_-]", "_");

    // List the project itself as a dependency so that we can assign project
    // name/version to symbols that are defined in this project.
    Optional<Path> dependenciesPath =
        depsOut.map(
            path -> {
              Path filename = path.getFileName();
              if (filename.endsWith("dependencies.txt")) {
                String last = projectPath + "." + filename.toString();
                return path.getParent().resolve(last);
              } else {
                return path;
              }
            });

    try {
      PublishingExtension publishing =
          project.getExtensions().findByType(PublishingExtension.class);
      for (MavenPublication publication :
          publishing.getPublications().withType(MavenPublication.class)) {
        try {
          SourceSet main =
              project.getExtensions().getByType(SourceSetContainer.class).getByName("main");
          main.getOutput().getClassesDirs().getFiles().stream()
              .map(File::getAbsolutePath)
              .sorted()
              .limit(1)
              .forEach(
                  classesDirectory ->
                      deps.add(
                          String.join(
                              "\t",
                              publication.getGroupId(),
                              publication.getArtifactId(),
                              publication.getVersion(),
                              classesDirectory)));
        } catch (Exception exception) {
          String publicationName =
              String.join(
                  ":",
                  publication.getGroupId(),
                  publication.getArtifactId(),
                  publication.getVersion());
          Logging.warn(
              "Failed to extract `main` source set from publication `"
                  + publicationName
                  + "` in project `"
                  + projectName
                  + "`.\n"
                  + CROSS_REPO_BANNER
                  + "\nHere's the raw error message:\n  \""
                  + exception.getMessage()
                  + "\"\nContinuing without cross-repository support.");
        }
      }
    } catch (Exception exception) {
      Logging.warn(
          "Failed to extract Maven publication from the project `"
              + projectName
              + "`.\n"
              + CROSS_REPO_BANNER
              + "\nHere's the raw error message ("
              + exception.getClass()
              + "):\n  \""
              + exception.getMessage()
              + "\"\nContinuing without cross-repository support.");
    }

    project
        .getConfigurations()
        .forEach(
            conf -> {
              if (conf.isCanBeResolved()) {
                try {
                  conf.getResolvedConfiguration()
                      .getResolvedArtifacts()
                      .forEach(
                          artifact ->
                              deps.add(
                                  String.join(
                                      "\t",
                                      artifact.getModuleVersion().getId().getGroup(),
                                      artifact.getModuleVersion().getId().getName(),
                                      artifact.getModuleVersion().getId().getVersion(),
                                      artifact.getFile().getAbsolutePath())));
                } catch (Exception exc) {
                  System.out.println(
                      "Skipping configuration '"
                          + conf.getName()
                          + "' due to resolution failure: "
                          + exc.getMessage());
                }
              }
            });

    List<String> dependencies = deps.stream().distinct().collect(Collectors.toList());

    if (dependenciesPath.isPresent()) {
      Files.write(
          dependenciesPath.get(),
          dependencies,
          StandardOpenOption.APPEND,
          StandardOpenOption.CREATE);
    } else {
      dependencies.forEach(System.out::println);
    }
  }
}
