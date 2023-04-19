package com.sourcegraph.scip_java.buildtools

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path

import scala.annotation.tailrec
import scala.jdk.CollectionConverters._

import com.sourcegraph.scip_java.Embedded
import com.sourcegraph.scip_java.commands.IndexCommand
import org.intellij.lang.annotations.Language

case class GradleJavaToolchains(
    toolchains: List[GradleJavaCompiler],
    tool: GradleBuildTool,
    index: IndexCommand,
    gradleVersion: Option[String],
    javaVersion: Option[String],
    isJavaEnabled: Boolean,
    isScalaEnabled: Boolean,
    isKotlinEnabled: Boolean,
    isKotlinMultiplatformEnabled: Boolean,
    gradleCommand: String,
    tmp: Path
) {

  def isEmpty: Boolean = toolchains.isEmpty

  def isJavaAtLeast(version: Int): Boolean = {
    val actualVersion = javaVersion.getOrElse(sys.props("java.version"))
    GradleJavaToolchains
      .isJavaAtLeast(actualVersion, math.max(version, 0).toString())
  }

  def executableJavacPath(): Option[Path] = {
    if (toolchains.isEmpty) {
      Some(
        Embedded.customJavac(
          index.workingDirectory,
          tool.targetroot,
          tmp,
          isJavaAtLeast(17)
        )
      )
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
    val javaVersionPath = tmp.resolve("java-version.txt")
    val kotlinMultiplatformEnabledPath = tmp
      .resolve("kotlin-multiplatform-enabled.txt")
    val gradleVersionPath = tmp.resolve("gradle-version.txt")
    val taskName = "scipDetectJavaToolchains"
    @Language("Groovy")
    val script =
      s"""|
          |try {
          |  java.nio.file.Files.write(
          |    java.nio.file.Paths.get(
          |      java.net.URI.create('${gradleVersionPath.toUri}')),
          |    [gradle.gradleVersion],
          |    java.nio.file.StandardOpenOption.TRUNCATE_EXISTING,
          |    java.nio.file.StandardOpenOption.CREATE)
          |  java.nio.file.Files.write(
          |    java.nio.file.Paths.get(
          |      java.net.URI.create('${javaVersionPath.toUri}')),
          |    [System.getProperty("java.version")],
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

    val javaVersion =
      if (Files.isRegularFile(javaVersionPath)) {
        Some(new String(Files.readAllBytes(javaVersionPath)).trim)
      } else {
        None
      }

    GradleJavaToolchains(
      toolchains,
      tool,
      index,
      gradleVersion = gradleVersion,
      javaVersion = javaVersion,
      isJavaEnabled = Files.isRegularFile(javaEnabledPath),
      isScalaEnabled = Files.isRegularFile(scalaEnabledPath),
      isKotlinEnabled = Files.isRegularFile(kotlinEnabledPath),
      isKotlinMultiplatformEnabled = Files
        .isRegularFile(kotlinMultiplatformEnabledPath),
      gradleCommand = gradleCommand,
      tmp = tmp
    )
  }

  // Copy-pasted from scala.util.Properties.isJavaAtLeast but makes the actual
  // version a parameterizeable instead of being hard-coded to
  // `Properties.javaVersionSpec`.
  def isJavaAtLeast(
      actualVersion: String,
      comparisonVersion: String
  ): Boolean = {
    def versionOf(s: String, depth: Int): (Int, String) =
      s.indexOf('.') match {
        case 0 =>
          (-2, s.substring(1))
        case 1 if depth == 0 && s.charAt(0) == '1' =>
          val r0 = s.substring(2)
          val (v, r) = versionOf(r0, 1)
          val n =
            if (v > 8 || r0.isEmpty)
              -2
            else
              v // accept 1.8, not 1.9 or 1.
          (n, r)
        case -1 =>
          val n =
            if (!s.isEmpty)
              s.toInt
            else if (depth == 0)
              -2
            else
              0
          (n, "")
        case i =>
          val r = s.substring(i + 1)
          val n =
            if (depth < 2 && r.isEmpty)
              -2
            else
              s.substring(0, i).toInt
          (n, r)
      }
    @tailrec
    def compareVersions(s: String, v: String, depth: Int): Int = {
      if (depth >= 3)
        0
      else {
        val (sn, srest) = versionOf(s, depth)
        val (vn, vrest) = versionOf(v, depth)
        if (vn < 0)
          -2
        else if (sn < vn)
          -1
        else if (sn > vn)
          1
        else
          compareVersions(srest, vrest, depth + 1)
      }
    }

    compareVersions(actualVersion, comparisonVersion, 0) match {
      case -2 =>
        throw new NumberFormatException(s"Not a version: $comparisonVersion")
      case i =>
        i >= 0
    }
  }
}
