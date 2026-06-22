package com.sourcegraph.gradle.scip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.tasks.compile.JavaCompile;

public class ScipGradlePlugin implements Plugin<Project> {

  @Override
  public void apply(Project project) {
    project.afterEvaluate(this::configureProject);
  }

  private void configureProject(Project project) {
    // Inject Maven Central/local so the indexer (and plugins like protobuf that
    // resolve their own artifacts) can resolve dependencies even when the build
    // being indexed doesn't declare any repositories of its own.
    project.getRepositories().add(project.getRepositories().mavenCentral());
    project.getRepositories().add(project.getRepositories().mavenLocal());

    Map<String, Object> extraProperties =
        project.getExtensions().getExtraProperties().getProperties();

    String targetRoot = requiredExtra(extraProperties, "scipTarget").toString();
    String sourceRoot = project.getRootDir().toString();

    // Compilation tasks we need to trigger to index all the sources we care
    // about. Built up as we detect the java and kotlin plugins.
    List<String> triggers = new ArrayList<>();

    if (project.getPlugins().hasPlugin("java")) {
      triggers.add("compileJava");
      triggers.add("compileTestJava");

      boolean hasAnnotationPath;
      try {
        Configuration apConfig = project.getConfigurations().getByName("annotationProcessor");
        hasAnnotationPath = apConfig.isCanBeResolved() && !apConfig.getDependencies().isEmpty();
      } catch (Exception exc) {
        hasAnnotationPath = false;
      }

      Object javacPluginDep = project.files(requiredExtra(extraProperties, "javacPluginJar"));
      boolean pluginAdded = tryAddJavacPlugin(project, javacPluginDep, hasAnnotationPath);

      project
          .getTasks()
          .withType(JavaCompile.class)
          .configureEach(
              task -> {
                // Disable incremental compilation so the random timestamp added
                // below forces a full recompile and Gradle doesn't cache stale
                // SCIP state.
                task.getOptions().setIncremental(false);

                if (pluginAdded) {
                  List<String> args = task.getOptions().getCompilerArgs();

                  // It's important we don't add the plugin configuration more
                  // than once, as javac considers that an error.
                  boolean alreadyAdded =
                      args.stream().anyMatch(arg -> arg.startsWith("-Xplugin:scip"));
                  if (!alreadyAdded) {
                    // The random timestamp ensures the sources are _always_
                    // recompiled, so Gradle doesn't cache any state.
                    // TODO: before this plugin is published to Maven Central, we
                    // will need to revert this change - as it can have
                    // detrimental effect on people's builds.
                    args.add(
                        "-Xplugin:scip -targetroot:"
                            + targetRoot
                            + " -sourceroot:"
                            + sourceRoot
                            + " -randomtimestamp="
                            + System.nanoTime());
                  }
                }
              });
    }

    boolean isKotlinMultiplatform = false;
    for (Plugin<?> plugin : project.getPlugins()) {
      if (plugin.getClass().getName().contains("KotlinMultiplatform")) {
        isKotlinMultiplatform = true;
        break;
      }
    }

    if (project.getPlugins().hasPlugin("kotlin") || isKotlinMultiplatform) {
      if (isKotlinMultiplatform) {
        triggers.add("compileKotlinJvm");
        triggers.add("compileTestKotlinJvm");
      } else {
        triggers.add("compileKotlin");
        triggers.add("compileTestKotlin");
      }

      // The CLI's init script provides the path of the embedded scip-kotlinc jar.
      Object scipKotlinc = requiredExtra(extraProperties, "scipKotlincJar");
      project
          .getTasks()
          .configureEach(
              task -> configureKotlinCompileTask(task, scipKotlinc, sourceRoot, targetRoot));
    }

    project.getTasks().create("scipCompileAll").dependsOn(triggers);

    project.getTasks().create("scipPrintDependencies", WriteDependencies.class);
  }

  private static boolean tryAddJavacPlugin(
      Project project, Object javacPluginDep, boolean hasAnnotationPath) {
    try {
      project.getDependencies().add("compileOnly", javacPluginDep);
      if (hasAnnotationPath) {
        project.getDependencies().add("annotationProcessor", javacPluginDep);
      }
      project.getDependencies().add("testCompileOnly", javacPluginDep);
      return true;
    } catch (Exception exc) {
      // The `compileOnly` configuration has likely already been resolved by
      // another plugin or buildscript, so we can no longer add new dependencies
      // to it. The project will be skipped (no SCIP output) and the post-build
      // check in `GradleBuildTool` will surface a clearer error.
      project
          .getLogger()
          .warn(
              "scip-java: failed to attach SCIP compiler plugin to project '"
                  + project.getName()
                  + "' ("
                  + exc.getClass().getSimpleName()
                  + ": "
                  + exc.getMessage()
                  + "). This subproject will not be indexed.");
      return false;
    }
  }

  private static void configureKotlinCompileTask(
      Task task, Object scipKotlinc, String sourceRoot, String targetRoot) {
    if (!task.getClass().getSimpleName().contains("KotlinCompile")) {
      return;
    }

    // Referring to KotlinCompile directly here triggers NoClassDefFoundError -
    // the plugin classpath is murky and we deliberately don't bundle the Kotlin
    // Gradle plugin. So we commit the sins of reflection for our limited needs.
    try {
      Object kotlinOptions = task.getClass().getMethod("getKotlinOptions").invoke(task);

      @SuppressWarnings("unchecked")
      List<String> freeCompilerArgs =
          (List<String>)
              kotlinOptions.getClass().getMethod("getFreeCompilerArgs").invoke(kotlinOptions);

      List<String> newArgs = new ArrayList<>(freeCompilerArgs.size() + 5);
      newArgs.addAll(freeCompilerArgs);
      newArgs.add("-Xplugin=" + scipKotlinc);
      newArgs.add("-P");
      newArgs.add("plugin:scip-kotlinc:sourceroot=" + sourceRoot);
      newArgs.add("-P");
      newArgs.add("plugin:scip-kotlinc:targetroot=" + targetRoot);

      kotlinOptions
          .getClass()
          .getMethod("setFreeCompilerArgs", List.class)
          .invoke(kotlinOptions, newArgs);
    } catch (ReflectiveOperationException exc) {
      throw new RuntimeException(
          "scip-java: failed to configure Kotlin compile task '" + task.getName() + "'", exc);
    }
  }

  private static Object requiredExtra(Map<String, Object> extraProperties, String name) {
    Object value = extraProperties.get(name);
    if (value == null) {
      throw new IllegalStateException(
          name + " extra property must be set by the scip-java Gradle init script");
    }
    return value;
  }
}
