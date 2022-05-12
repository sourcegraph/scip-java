package com.sourcegraph.scip_java.buildtools

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path

import scala.jdk.CollectionConverters._

import com.sourcegraph.scip_java.Embedded
import com.sourcegraph.scip_java.commands.IndexCommand

case class GradleJavaToolchains(
    toolchains: List[GradleJavaCompiler],
    tool: GradleBuildTool,
    index: IndexCommand,
    gradleVersion: Option[String],
    isJavaEnabled: Boolean,
    isScalaEnabled: Boolean,
    isKotlinEnabled: Boolean,
    isKotlinMultiplatformEnabled: Boolean,
    gradleCommand: String,
    tmp: Path
) {

  def isEmpty: Boolean = toolchains.isEmpty

  def executableJavacPath(): Option[Path] = {
    if (toolchains.isEmpty) {
      Some(Embedded.customJavac(index.workingDirectory, tool.targetroot, tmp))
    } else {
      None
    }
  }

  def paths(): String = {
    val processorPath = Embedded.semanticdbJar(tmp)
    toolchains
      .map(
        _.createForwardingToolchain(index, tmp, tool.targetroot, processorPath)
      )
      .mkString(",")
  }

}

object GradleJavaToolchains {

  /**
   * Extracts the "Java toolchains" that are used in this Gradle workspace.
   *
   * @see
   *   https://docs.gradle.org/6.7/userguide/toolchains.html
   */
  def fromWorkspace(
      tool: GradleBuildTool,
      index: IndexCommand,
      gradleCommand: String,
      tmp: Path
  ): GradleJavaToolchains = {
    val scriptPath = tmp.resolve("java-toolchains.gradle")
    val toolchainsPath = tmp.resolve("java-toolchains.txt")
    val javaEnabledPath = tmp.resolve("java-enabled.txt")
    val scalaEnabledPath = tmp.resolve("scala-enabled.txt")
    val kotlinEnabledPath = tmp.resolve("kotlin-enabled.txt")
    val kotlinMultiplatformEnabledPath = tmp
      .resolve("kotlin-multiplatform-enabled.txt")
    val gradleVersionPath = tmp.resolve("gradle-version.txt")
    val taskName = "scipDetectJavaToolchains"
    val script =
      s"""|
          |try {
          |  java.nio.file.Files.write(
          |    java.nio.file.Paths.get(
          |      java.net.URI.create('${gradleVersionPath.toUri}')),
          |    [gradle.gradleVersion],
          |    java.nio.file.StandardOpenOption.TRUNCATE_EXISTING,
          |    java.nio.file.StandardOpenOption.CREATE)
          |} catch (Exception e) {
          |  // Ignore errors.
          |}
          |
          |def scipJavaAppendLine(path, line) {
          |  java.nio.file.Files.write(
          |    java.nio.file.Paths.get(path),
          |    [line],
          |    java.nio.file.StandardOpenOption.APPEND,
          |    java.nio.file.StandardOpenOption.CREATE)
          |}
          |
          |allprojects {
          |  task $taskName {
          |    def toolchainsOut = java.nio.file.Paths.get(
          |      java.net.URI.create('${toolchainsPath.toUri}'))
          |    doLast {
          |      try {
          |        tasks.withType(JavaCompile) {
          |          def lines = new ArrayList<String>()
          |          def path = javaCompiler.get().getExecutablePath()
          |          def version = javaCompiler.get().getMetadata().getLanguageVersion().asInt()
          |          def line = "$$version $$path"
          |          java.nio.file.Files.write(
          |            toolchainsOut,
          |            [line],
          |            java.nio.file.StandardOpenOption.APPEND,
          |            java.nio.file.StandardOpenOption.CREATE)
          |          scipJavaAppendLine(toolchainsOut, line)
          |        }
          |      } catch (Exception e) {
          |        // Ignore errors.
          |      }
          |      project.plugins.each {
          |        def name = it.getClass().getName()
          |        if (name.endsWith("org.gradle.api.plugins.JavaPlugin"))
          |          scipJavaAppendLine('$javaEnabledPath', 'true')
          |        if (name.endsWith("org.gradle.api.plugins.scala.ScalaPlugin"))
          |          scipJavaAppendLine('$scalaEnabledPath', 'true')
          |        if (name.startsWith("org.jetbrains.kotlin.gradle.plugin"))
          |          scipJavaAppendLine('$kotlinEnabledPath', 'true')
          |        if (name.equals("org.jetbrains.kotlin.gradle.plugin.KotlinMultiplatformPluginWrapper"))
          |          scipJavaAppendLine('$kotlinMultiplatformEnabledPath', 'true')
          |      }
          |    }
          |  }
          |}
          |""".stripMargin
    Files.write(scriptPath, script.getBytes(StandardCharsets.UTF_8))
    index.process(
      List(gradleCommand, "--init-script", scriptPath.toString, taskName)
    )
    val toolchains: List[GradleJavaCompiler] =
      if (Files.isRegularFile(toolchainsPath)) {
        Files
          .readAllLines(toolchainsPath)
          .asScala
          .flatMap(GradleJavaCompiler.fromLine)
          .toList
          .distinct
      } else {
        Nil
      }

    val gradleVersion =
      if (Files.isRegularFile(gradleVersionPath)) {
        Some(new String(Files.readAllBytes(gradleVersionPath)).trim)
      } else {
        None
      }

    GradleJavaToolchains(
      toolchains,
      tool,
      index,
      gradleVersion = gradleVersion,
      isJavaEnabled = Files.isRegularFile(javaEnabledPath),
      isScalaEnabled = Files.isRegularFile(scalaEnabledPath),
      isKotlinEnabled = Files.isRegularFile(kotlinEnabledPath),
      isKotlinMultiplatformEnabled = Files
        .isRegularFile(kotlinMultiplatformEnabledPath),
      gradleCommand = gradleCommand,
      tmp = tmp
    )
  }
}
