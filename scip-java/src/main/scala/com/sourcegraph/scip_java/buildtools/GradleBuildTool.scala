package com.sourcegraph.scip_java.buildtools

import java.nio.charset.StandardCharsets
import java.nio.file._

import scala.collection.mutable.ListBuffer
import scala.util.Properties

import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.scip_java.BuildInfo
import com.sourcegraph.scip_java.Embedded
import com.sourcegraph.scip_java.commands.IndexCommand
import org.intellij.lang.annotations.Language
import os.CommandResult

class GradleBuildTool(index: IndexCommand) extends BuildTool("Gradle", index) {

  override def usedInCurrentDirectory(): Boolean = {
    Files.isRegularFile(index.workingDirectory.resolve("settings.gradle")) ||
    Files.isRegularFile(index.workingDirectory.resolve("gradlew")) ||
    Files.isRegularFile(index.workingDirectory.resolve("build.gradle")) ||
    Files.isRegularFile(index.workingDirectory.resolve("build.gradle.kts"))
  }

  override def generateScip(): Int = {
    BuildTool
      .generateScipFromTargetroot(generateSemanticdb(), targetroot, index)
  }

  def targetroot: Path = index.finalTargetroot(defaultTargetroot)

  private def defaultTargetroot: Path =
    Paths.get("build", "semanticdb-targetroot")
  private def generateSemanticdb(): CommandResult = {
    val gradleWrapper: Path = index
      .workingDirectory
      .resolve(
        if (Properties.isWin)
          "gradlew.bat"
        else
          "gradlew"
      )
    val gradleCommand: String =
      if (
        Files.isRegularFile(gradleWrapper) && Files.isExecutable(gradleWrapper)
      )
        gradleWrapper.toString
      else
        "gradle"

    TemporaryFiles.withDirectory(index) { tmp =>
      val toolchains = GradleJavaToolchains
        .fromWorkspace(this, index, gradleCommand, tmp)
      toolchains.gradleVersion match {
        case Some(gradleVersion)
            if gradleVersion.startsWith("6.7") &&
              toolchains.toolchains.nonEmpty =>
          index
            .app
            .error(
              "scip-java does not support Gradle 6.7 when used together with Java toolchains. " +
                "To fix this problem, upgrade to Gradle version 6.8 or newer and try again."
            )
          CommandResult(1, Nil)
        case _ =>
          runCompileCommand(toolchains)
      }
    }
  }

  private def runCompileCommand(
      toolchains: GradleJavaToolchains
  ): CommandResult = {
    val script = initScript(toolchains, toolchains.tmp).toString
    val buildCommand = ListBuffer.empty[String]
    buildCommand += toolchains.gradleCommand
    buildCommand += "--no-daemon"
    buildCommand += "--init-script"
    buildCommand += script
    if (toolchains.toolchains.nonEmpty) {
      buildCommand += "-Porg.gradle.java.installations.auto-detect=false"
      buildCommand += "-Porg.gradle.java.installations.auto-download=false"
      buildCommand +=
        s"-Porg.gradle.java.installations.paths=${toolchains.paths()}"
    }
    buildCommand += "-Pkotlin.compiler.execution.strategy=in-process"
    buildCommand ++=
      index.finalBuildCommand(
        List[Option[String]](
          Some("clean"),
          if (toolchains.isJavaEnabled)
            Some("compileTestJava")
          else
            None,
          if (toolchains.isScalaEnabled)
            Some("compileTestScala")
          else
            None,
          if (toolchains.isKotlinEnabled)
            Some("compileTestKotlin")
          else
            None,
          if (toolchains.isKotlinMultiplatformEnabled)
            Some("compileTestKotlinJvm")
          else
            None
        ).flatten
      )
    buildCommand += scipJavaDependencies

    Files.walkFileTree(targetroot, new DeleteVisitor())
    val result = index.process(buildCommand, env = Map("TERM" -> "dumb"))
    printDebugLogs(toolchains.tmp)
    Embedded
      .reportUnexpectedJavacErrors(index.app.reporter, toolchains.tmp)
      .getOrElse(result)
  }

  private def scipJavaDependencies = "scipJavaDependencies"

  private def printDebugLogs(tmp: Path): Unit = {
    val path = GradleJavaCompiler.debugPath(tmp)
    if (index.verbose && Files.isRegularFile(path)) {
      Files
        .readAllLines(path)
        .forEach { line =>
          index.app.info(line)
        }
    }
  }

  private def initScript(toolchains: GradleJavaToolchains, tmp: Path): Path = {
    val executable =
      toolchains.executableJavacPath() match {
        case Some(path) =>
          s"options.forkOptions.executable = '$path'"
        case None =>
          ""
      }

    val agentpath = Embedded.agentJar(tmp)
    val pluginpath = Embedded.semanticdbJar(tmp)
    def handleExceptionGroovySyntax(): String =
      if (index.verbose)
        "e.printStackTrace()"
      else
        ""
    val dependenciesPath = targetroot.resolve("dependencies.txt")
    val kotlinSemanticdbVersion = BuildInfo.semanticdbKotlincVersion
    Files.deleteIfExists(dependenciesPath)
    @Language("Groovy")
    val script =
      s"""|allprojects {
          |  gradle.projectsEvaluated {
          |    boolean isJavaEnabled = project.plugins.any {
          |       it.getClass().getName().endsWith("org.gradle.api.plugins.JavaPlugin")
          |    }
          |    boolean isScalaEnabled = project.plugins.any {
          |       it.getClass().getName().endsWith("org.gradle.api.plugins.scala.ScalaPlugin")
          |    }
          |    boolean isKotlinEnabled = project.plugins.any {
          |       it.getClass().getName().startsWith("org.jetbrains.kotlin.gradle.plugin")
          |    }
          |    if (isJavaEnabled) {
          |      tasks.withType(JavaCompile) {
          |        options.fork = true
          |        options.incremental = false
          |        $executable
          |      }
          |    }
          |    if (isScalaEnabled) {
          |      // The Scala plugin runs Zinc, an incremental compiler, in a separate daemon process.
          |      // Zinc invokes the Java compiler directly to compile mixed Java/Scala projects
          |      // instead of respecting the `JavaCompile` fork options from the Gradle Java plugin.
          |      // By enabling the SemanticDB Java agent on the Zinc daemon process, we manage
          |      // to configure Zinc to use the semanticdb-javac compiler plugin for Java compilation.
          |      tasks.withType(ScalaCompile) {
          |
          |        if (scalaCompileOptions.additionalParameters == null) scalaCompileOptions.additionalParameters = []
          |        try {
          |          def scalaVersion = scipJavaScalaVersion(project, configurations)
          |          def semanticdbVersion = scipJavaSemanticdbScalacVersions(scalaVersion)
          |          def semanticdbScalacDependency ="org.scalameta:semanticdb-scalac_$$scalaVersion:$$semanticdbVersion"
          |          def semanticdbScalac = project.configurations.detachedConfiguration(dependencies.create(semanticdbScalacDependency)).files[0]
          |          scalaCompileOptions.additionalParameters << '-Xplugin:' + semanticdbScalac
          |          scalaCompileOptions.additionalParameters << '-P:semanticdb:sourceroot:$sourceroot'
          |          scalaCompileOptions.additionalParameters << '-P:semanticdb:targetroot:$targetroot'
          |          scalaCompileOptions.additionalParameters << '-P:semanticdb:exclude:(src/play/twirl|src/play/routes)' // Ignore autogenerated Playframework files
          |          scalaCompileOptions.additionalParameters << '-P:semanticdb:failures:warning'
          |          scalaCompileOptions.additionalParameters << '-Xplugin-require:semanticdb'
          |        } catch (Exception e) {
          |          ${handleExceptionGroovySyntax()}
          |        }
          |        scalaCompileOptions.forkOptions.with {
          |          jvmArgs << '-javaagent:$agentpath'
          |          jvmArgs << '-Dsemanticdb.pluginpath=$pluginpath'
          |          jvmArgs << '-Dsemanticdb.sourceroot=$sourceroot'
          |          jvmArgs << '-Dsemanticdb.targetroot=$targetroot'
          |        }
          |      }
          |    }
          |    if (isKotlinEnabled) {
          |      tasks.configureEach {
          |        if (it.getClass().getName().contains("KotlinCompile")) {
          |          try {
          |            def semanticdbKotlincDependency = "com.sourcegraph:semanticdb-kotlinc:$kotlinSemanticdbVersion"
          |            def semanticdbKotlinc = project.configurations.detachedConfiguration(dependencies.create(semanticdbKotlincDependency)).files[0]
          |            kotlinOptions {
          |              freeCompilerArgs << "-Xplugin=" + semanticdbKotlinc
          |              freeCompilerArgs << "-P"
          |              freeCompilerArgs << "plugin:semanticdb-kotlinc:sourceroot=$sourceroot"
          |              freeCompilerArgs << "-P"
          |              freeCompilerArgs << "plugin:semanticdb-kotlinc:targetroot=$targetroot"
          |            }
          |          } catch (Throwable e) {
          |            e.printStackTrace()
          |          }
          |        }
          |      }
          |    }
          |  }
          |  task $scipJavaDependencies(type: WriteDependencies)
          |}
          |def scipJavaSemanticdbScalacVersions(scalaVersion) {
          |  ${semanticdbScalacGroovySyntax()}[scalaVersion]
          |}
          |def scipJavaScalaVersion(project, configurations) {
          |  for (config in configurations) {
          |    if (config.name == "zinc") continue
          |    if (config.canBeResolved) {
          |      def artifacts = config.incoming.artifactView { view ->
          |        view.lenient = true
          |      }.artifacts
          |      for (artifact in artifacts) {
          |        def id = artifact.id.componentIdentifier
          |        if (id instanceof org.gradle.api.artifacts.component.ModuleComponentIdentifier 
          |              && id.group == "org.scala-lang"
          |              && id.module == "scala-library") {
          |          return id.version
          |        }
          |      }
          |    }
          |  }
          |  return null
          |}
          |
          |class WriteDependencies extends DefaultTask {
          |    @TaskAction
          |    void printResolvedDependencies() {
          |        def depsOut = java.nio.file.Paths.get(
          |            java.net.URI.create('${dependenciesPath.toUri}'))
          |        java.nio.file.Files.createDirectories(depsOut.getParent())
          |        def configurations = project.configurations
          |        configurations.each { configuration ->
          |            if (!configuration.canBeResolved || java.lang.reflect.Modifier.isAbstract(configuration.getClass().getModifiers())) {
          |                return
          |            }
          |            try {
          |                def resolvedConfiguration = configuration.resolvedConfiguration
          |                def lines = resolvedConfiguration.resolvedArtifacts.collect { artifact ->
          |                    return "$$artifact.moduleVersion.id.group\t$$artifact.moduleVersion.id.name\t$$artifact.moduleVersion.id.version\t$$artifact.file.absolutePath"
          |                }
          |                java.nio.file.Files.write(
          |                    depsOut,
          |                    lines.unique(false),
          |                    java.nio.file.StandardOpenOption.APPEND,
          |                    java.nio.file.StandardOpenOption.CREATE)
          |            } catch (Exception e) {
          |                println "Skipping configuration '$$configuration.name' due to resolution failure: $$e.message"
          |                return
          |            }
          |        }
          |    }
          |}
          |""".stripMargin
    Files.write(
      tmp.resolve("init-script.gradle"),
      script.getBytes(StandardCharsets.UTF_8)
    )
  }

  def semanticdbScalacGroovySyntax(): String =
    BuildInfo
      .semanticdbScalacVersions
      .removed(
        "2.12.3"
      ) // Not supported because the last semanticdb-scalac_2.12.3 release doesn't support the option -P:semanticdb:targetroot:PATH.
      .map { case (key, value) =>
        s"'$key':'$value'"
      }.mkString("[", ", ", "]")

}
