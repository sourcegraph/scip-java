package com.sourcegraph.gradle.scip;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.plugins.ExtraPropertiesExtension;
import org.gradle.api.tasks.compile.ForkOptions;
import org.gradle.api.tasks.compile.JavaCompile;

public class ScipGradlePlugin implements Plugin<Project> {

  // `--add-exports` flags required so our compiler plugin can access javac
  // internals. Required on JDK 17+ (JEP 403), no-op on 11-16. Kept in sync with
  // `javacModuleOptions` in build.sbt.
  private static final List<String> JAVAC_MODULE_OPTIONS =
      List.of(
          "-J--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
          "-J--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED",
          "-J--add-exports=jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
          "-J--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
          "-J--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED");

  @Override
  public void apply(Project project) {
    project.afterEvaluate(this::configureProject);
  }

  private void configureProject(Project project) {
    project.getRepositories().add(project.getRepositories().mavenCentral());
    project.getRepositories().add(project.getRepositories().mavenLocal());

    ExtraPropertiesExtension extra = project.getExtensions().getExtraProperties();
    Map<String, Object> extraProperties = extra.getProperties();

    Object targetRoot = extraProperties.getOrDefault("scipTarget", project.getBuildDir());

    File sourceRoot = project.getRootDir();

    // List of compilation commands that we will need to trigger to index all
    // the sources in the project we care about. This list is built
    // progressively as we check for java and kotlin plugins.
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

      boolean compilerPluginAdded;
      try {
        // The CLI's init script writes the absolute path of the embedded
        // scip-javac jar into the `javacPluginJar` extra property.
        Object javacPluginJar = extraProperties.get("javacPluginJar");
        if (javacPluginJar == null) {
          throw new IllegalStateException(
              "javacPluginJar extra property must be set by the "
                  + "scip-java init script when indexing Java sources");
        }
        Object javacPluginDep = project.files(javacPluginJar);

        project.getDependencies().add("compileOnly", javacPluginDep);

        if (hasAnnotationPath) {
          project.getDependencies().add("annotationProcessor", javacPluginDep);
        }

        project.getDependencies().add("testCompileOnly", javacPluginDep);

        compilerPluginAdded = true;
      } catch (Exception exc) {
        // The `compileOnly` configuration has likely already been resolved by
        // another plugin or buildscript, so we can no longer add new
        // dependencies to it. The project will be skipped (no SCIP output) and
        // the post-build check in `GradleBuildTool` will surface a clearer
        // error.
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
        compilerPluginAdded = false;
      }

      boolean pluginAdded = compilerPluginAdded;
      project
          .getTasks()
          .withType(JavaCompile.class)
          .configureEach(
              task -> {
                // Add --add-exports JVM args so our compiler plugin can access
                // javac internals. Required on JDK 17+ (JEP 403), no-op on
                // 11-16.
                ForkOptions forkOptions = task.getOptions().getForkOptions();
                List<String> jvmArgs =
                    JAVAC_MODULE_OPTIONS.stream()
                        .map(arg -> arg.startsWith("-J") ? arg.substring(2) : arg)
                        .collect(Collectors.toList());
                if (forkOptions.getJvmArgs() == null) {
                  forkOptions.setJvmArgs(jvmArgs);
                } else {
                  forkOptions.getJvmArgs().addAll(jvmArgs);
                }

                task.getOptions().setFork(true);
                task.getOptions().setIncremental(false);

                if (pluginAdded) {
                  List<String> args = task.getOptions().getCompilerArgs();

                  // It's important we don't add the plugin configuration more
                  // than once, as javac considers that an error.
                  boolean alreadyAdded =
                      args.stream().anyMatch(arg -> arg.startsWith("-Xplugin:scip"));
                  if (!alreadyAdded) {
                    // We add the random timestamp to ensure that the sources
                    // are _always_ recompiled, so that Gradle doesn't cache any
                    // state.
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

      project
          .getTasks()
          .configureEach(
              task -> configureKotlinCompileTask(task, extraProperties, sourceRoot, targetRoot));
    }

    project
        .getTasks()
        .create(
            "scipCompileAll",
            task -> {
              for (String trigger : triggers) {
                task.dependsOn(project.getTasks().getByName(trigger));
              }
            });

    project.getTasks().create("scipPrintDependencies", WriteDependencies.class);
  }

  private static void configureKotlinCompileTask(
      Task task, Map<String, Object> extraProperties, Object sourceRoot, Object targetRoot) {
    if (!task.getClass().getSimpleName().contains("KotlinCompile")) {
      return;
    }

    // If we actually refer to KotlinCompile at _any_ point here, then the
    // plugin fails with NoClassDefFoundError - because the plugin classpath is
    // murky.
    //
    // We also don't want to bundle the kotlin plugin with this one as it can
    // cause all sorts of troubles.
    //
    // Instead, we commit the sins of reflection for our limited needs.
    try {
      Object kotlinOptions = task.getClass().getMethod("getKotlinOptions").invoke(task);

      // The scip-kotlinc compiler plugin is now built and shipped together with
      // the scip-java CLI. The CLI's init script writes the absolute path of
      // the embedded jar into the `scipKotlincJar` extra property so we no
      // longer need to resolve a separately-published artifact at apply-time.
      Object scipKotlinc = extraProperties.get("scipKotlincJar");
      if (scipKotlinc == null) {
        throw new IllegalStateException(
            "scipKotlincJar extra property must be set by the "
                + "scip-java init script when indexing Kotlin sources");
      }

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
}
