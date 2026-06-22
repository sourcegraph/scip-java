package com.sourcegraph.gradle.scip;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Build metadata for the SCIP Gradle plugin.
 *
 * <p>Replaces the previously sbt-generated {@code com.sourcegraph.scip_java.BuildInfo}. The static
 * {@link #javacModuleOptions} live here directly; the build-time {@link #version} is injected by
 * sbt into the {@code scip-gradle.properties} classpath resource (see the {@code
 * resourceGenerators} for the {@code gradlePlugin} project in build.sbt).
 */
final class BuildInfo {

  private BuildInfo() {}

  /**
   * {@code --add-exports} flags required to access internal javac APIs from the SCIP compiler
   * plugin. Java 11+ is the supported baseline.
   *
   * <p>Kept in sync with {@code javacModuleOptions} in build.sbt, which applies the same flags when
   * compiling the plugin and the test fixtures.
   */
  static final List<String> javacModuleOptions =
      Collections.unmodifiableList(
          Arrays.asList(
              "-J--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
              "-J--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED",
              "-J--add-exports=jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
              "-J--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
              "-J--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED"));

  /**
   * The scip-java release version. Read from the {@code scip-gradle.properties} resource that sbt
   * generates into the jar. Falls back to a placeholder when running without the generated resource
   * on the classpath.
   */
  static final String version = loadVersion();

  private static String loadVersion() {
    Properties props = new Properties();
    try (InputStream in = BuildInfo.class.getResourceAsStream("/scip-gradle.properties")) {
      if (in != null) {
        props.load(in);
      }
    } catch (IOException e) {
      // Fall back to the placeholder below.
    }
    return props.getProperty("version", "0.0.0-SNAPSHOT");
  }
}
