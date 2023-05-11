package com.sourcegraph.gradle.semanticdb

import java.nio.file.Files
import java.nio.file.Paths
import java.{util => ju}

import scala.jdk.CollectionConverters._

import com.sourcegraph.scip_java.BuildInfo
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.component.ModuleComponentIdentifier
import org.gradle.api.provider.Property
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.scala.ScalaCompile

class SemanticdbGradlePlugin extends Plugin[Project] {
  override def apply(project: Project): Unit = {
    val gradle = new GradleVersion(project.getGradle().getGradleVersion())
    project.afterEvaluate { project =>
      project.getRepositories().add(project.getRepositories().mavenCentral())
      project.getRepositories().add(project.getRepositories().mavenLocal())

      val extra = project.getExtensions().getExtraProperties()
      val extraProperties = extra.getProperties().asScala

      val targetRoot = extra
        .getProperties()
        .asScala
        .getOrElse("semanticdbTarget", project.getBuildDir())

      val javacPluginVersion = BuildInfo.version

      val javacPluginJar = extraProperties
        .get("javacPluginJar")
        .map(_.asInstanceOf[String])

      val javacDep = javacPluginJar
        .map[Object](jar => project.files(jar))
        // we fallback to javac plugin published to maven if there is no jar specified
        // the JAR would usually be provided by auto-indexer
        .getOrElse(s"com.sourcegraph:semanticdb-javac:${javacPluginVersion}")

      val sourceRoot = project.getRootDir()
      val agentJar = extraProperties.get("javacAgentPath").map(_.toString)

      val tasks = project.getTasks()

      // List of compilation commands that we will need to trigger
      // to index all the sources in the project we care about.
      // This list is built progressively as we check for java, kotlin, and
      // scala plugins
      val triggers = List.newBuilder[String]

      if (project.getPlugins().hasPlugin("java")) {

        triggers += "compileJava"
        triggers += "compileTestJava"

        val hasAnnotationPath = {
          val apConfig = project
            .getConfigurations()
            .getByName("annotationProcessor")
          if (apConfig.isCanBeResolved()) {
            apConfig.getDependencies().size() > 0
          } else
            false
        }

        val compilerPluginAdded =
          try {
            project.getDependencies().add("compileOnly", javacDep)
            if (hasAnnotationPath)
              project.getDependencies().add("annotationProcessor", javacDep)
            project.getDependencies().add("testCompileOnly", javacDep)
            true
          } catch {
            case exc: Exception =>
              // If the `compileOnly` configuration has already been evaluated
              // by the build, we need to fallback on agent injected into javac
              System
                .err
                .println(
                  s"Failed to add compiler plugin to javac, will go through the agent route: ${exc.getMessage()}"
                )
              false
          }

        project
          .getTasks()
          .withType(classOf[JavaCompile])
          .configureEach { task =>
            // If we run on JDK 17, we need to add special flags to the JVM
            // to allow access to the compiler.

            // JDK 17 support was only introduced in 7.3 so
            // we don't need to do it for earlier versions
            // https://docs.gradle.org/current/userguide/compatibility.html
            if (!gradle.is5 && !gradle.is6) {
              type JavaCompiler = {
                type Metadata = {
                  type LangVersion = {
                    def asInt(): Int
                  }
                  def getLanguageVersion(): LangVersion
                }
                def getMetadata(): Metadata
              }
              type HasCompilerProperty = {
                def getJavaCompiler(): Property[JavaCompiler]
              }

              val toolchainCompiler = Option(
                task
                  .asInstanceOf[HasCompilerProperty]
                  .getJavaCompiler()
                  .getOrNull()
              ).map(_.getMetadata().getLanguageVersion().asInt())

              val host = System
                .getProperty("java.version")
                .split("\\.")
                .headOption
                .map(_.toInt)

              toolchainCompiler
                .orElse(host)
                .foreach { version =>
                  if (version >= 17) {
                    val newValue = task.getOptions().getForkOptions()
                    val jvmArgs =
                      BuildInfo
                        .javacModuleOptions
                        .map(_.stripPrefix("-J"))
                        .asJava

                    newValue.getJvmArgs() match {
                      case null =>
                        newValue.setJvmArgs(jvmArgs)
                      case other =>
                        newValue.getJvmArgs().addAll(jvmArgs)

                    }
                  }
                }
            }

            task.getOptions().setFork(true)
            task.getOptions().setIncremental(false)

            if (compilerPluginAdded)
              task
                .getOptions()
                .getCompilerArgs()
                .addAll(
                  List(
                    // We add this to ensure that the sources are _always_
                    // recompiled, so that Gradle doesn't cache any state
                    // TODO: before this plugin is published to Maven Central,
                    // we will need to revert this change - as it can have detrimental
                    // effect on people's builds
                    s"-Arandomtimestamp=${System.currentTimeMillis()}",
                    s"-Xplugin:semanticdb -targetroot:$targetRoot -sourceroot:$sourceRoot"
                  ).asJava
                )
            else
              agentJar.foreach { agentpath =>
                javacPluginJar.foreach { pluginpath =>
                  val jvmArgs = task.getOptions.getForkOptions.getJvmArgs

                  jvmArgs.addAll(
                    List(
                      s"-javaagent:$agentpath",
                      s"-Dsemanticdb.pluginpath=$pluginpath",
                      s"-Dsemanticdb.sourceroot=$sourceRoot",
                      s"-Dsemanticdb.targetroot=$targetRoot"
                    ).asJava
                  )
                }
              }

          }
      }

      if (project.getPlugins().hasPlugin("scala")) {
        triggers += "compileScala"
        triggers += "compileTestScala"

        project
          .getTasks()
          .withType(classOf[ScalaCompile])
          .configureEach { task =>
            // Detect scala version
            var foundScalaVersion = Option.empty[String]
            project
              .getConfigurations()
              .forEach { conf =>
                if (conf.isCanBeResolved() && conf.getName != "zinc") {
                  conf
                    .getIncoming()
                    .artifactView(view => view.lenient(true))
                    .getArtifacts()
                    .forEach { artif =>
                      val id = artif.getId().getComponentIdentifier()
                      id match {
                        case id: ModuleComponentIdentifier =>
                          if (
                            id.getGroup() == "org.scala-lang" &&
                            id.getModule() == "scala-library"
                          )
                            foundScalaVersion = Some(id.getVersion())
                        case _ =>
                      }
                    }
                }
              }

            val scalaVersion = foundScalaVersion.get

            val semanticdbVersion = BuildInfo
              .semanticdbScalacVersions(scalaVersion)
            val semanticdbScalacDependency =
              s"org.scalameta:semanticdb-scalac_$scalaVersion:$semanticdbVersion"

            val semanticdbScalac =
              project
                .getConfigurations()
                .detachedConfiguration(
                  project.getDependencies.create(semanticdbScalacDependency)
                )
                .getFiles()
                .asScala
                .toList
                .head

            val args = List(
              s"-Xplugin:$semanticdbScalac",
              s"-P:semanticdb:sourceroot:$sourceRoot",
              s"-P:semanticdb:targetroot:$targetRoot",
              s"-P:semanticdb:exclude:(src/play/twirl|src/play/routes|src/${System.currentTimeMillis()})", // Ignore autogenerated Playframework files
              "-P:semanticdb:failures:warning",
              "-Xplugin-require:semanticdb"
            )

            val mutableArgs = new ju.ArrayList[String](args.asJava)

            val scalaCompileOptions = task.getScalaCompileOptions()

            val forkOptions = scalaCompileOptions.getForkOptions()
            val jvmArgs = forkOptions.getJvmArgs()

            agentJar.foreach { agentpath =>
              javacPluginJar.foreach { pluginpath =>
                jvmArgs.addAll(
                  List(
                    s"-javaagent:$agentpath",
                    s"-Dsemanticdb.pluginpath=$pluginpath",
                    s"-Dsemanticdb.sourceroot=$sourceRoot",
                    s"-Dsemanticdb.targetroot=$targetRoot"
                  ).asJava
                )
              }
            }

            if (scalaCompileOptions.getAdditionalParameters == null)
              scalaCompileOptions.setAdditionalParameters(mutableArgs)
            else
              scalaCompileOptions.getAdditionalParameters.addAll(args.asJava)

          }

      }

      val isKotlinMultiplatform = project
        .getPlugins()
        .asScala
        .exists(_.getClass().getName().contains("KotlinMultiplatform"))

      if (project.getPlugins().hasPlugin("kotlin") || isKotlinMultiplatform) {
        if (isKotlinMultiplatform) {
          triggers += "compileKotlinJvm"
          triggers += "compileTestKotlinJvm"
        } else {
          triggers += "compileKotlin"
          triggers += "compileTestKotlin"
        }

        project
          .getTasks
          .configureEach { task =>
            if (task.getClass().getSimpleName().contains("KotlinCompile")) {

              // I we actually refer to KotlinCompile at _any_ point here, then
              // plugin fails with NoClassDefFoundError - because the plugin
              // classpath is murky
              //
              // We also don't want to bundle kotlin plugin with this one as it
              // can cause all sorts of troubles.
              //
              // Instead, we commit the sins of reflection for our limited
              // needs.
              val compilerArgs = task
                .asInstanceOf[{
                    def getKotlinOptions(): {
                      def getFreeCompilerArgs(): ju.List[String]
                      def setFreeCompilerArgs(args: ju.List[String]): Unit
                    }
                  }
                ]
                .getKotlinOptions()

              val semanticdbkotlincDependency =
                s"com.sourcegraph:semanticdb-kotlinc:${BuildInfo.semanticdbKotlincVersion}"

              val semanticdbKotlinc =
                project
                  .getConfigurations()
                  .detachedConfiguration(
                    project.getDependencies.create(semanticdbkotlincDependency)
                  )
                  .getFiles()
                  .asScala
                  .toList
                  .head

              val newArgs =
                new ju.ArrayList[String](
                  compilerArgs.getFreeCompilerArgs().size + 5
                )
              newArgs.addAll(compilerArgs.getFreeCompilerArgs())
              newArgs.addAll(
                List(
                  "-Xplugin=" + semanticdbKotlinc,
                  "-P",
                  s"plugin:semanticdb-kotlinc:sourceroot=$sourceRoot",
                  "-P",
                  s"plugin:semanticdb-kotlinc:targetroot=$targetRoot"
                ).asJava
              )

              compilerArgs.setFreeCompilerArgs(newArgs)
            }
          }
      }

      tasks.register(
        "scipCompileAll",
        { task =>
          triggers
            .result()
            .foldLeft(task) { case (tsk, trig) =>
              tsk.dependsOn(tasks.getByName(trig))
            }

        }
      )

      tasks.register("scipPrintDependencies", classOf[WriteDependencies])

    }

  }

  class GradleVersion(ver: String) {
    override def toString(): String = s"[GradleVersion: $ver]"
    def is7 = ver.startsWith("7.")
    def is8 = ver.startsWith("8.")
    def is6 = ver.startsWith("6.")
    // 6.7 introduced toolchains support https://blog.gradle.org/java-toolchains
    // And javaCompiler property
    def is6_7_plus = {
      ver match {
        case s"6.$x.$y" if x.toInt >= 7 =>
          true
        case s"6.$x" if x.toInt >= 7 =>
          true
        case _ =>
          false
      }
    }
    def is5 = ver.startsWith("5.")
  }
}

class WriteDependencies extends DefaultTask {
  @TaskAction
  def printResolvedDependencies(): Unit = {

    val depsOut = Option(
      getProject().getExtensions().getExtraProperties().get("dependenciesOut")
    ).map(_.toString).map(Paths.get(_))

    depsOut
      .foreach(path => java.nio.file.Files.createDirectories(path.getParent()))

    val deps = List.newBuilder[String]

    getProject()
      .getConfigurations()
      .forEach { conf =>
        if (conf.isCanBeResolved()) {
          try {
            val resolved = conf.getResolvedConfiguration()
            resolved
              .getResolvedArtifacts()
              .forEach { artif =>
                deps +=
                  List(
                    artif.getModuleVersion().getId().getGroup(),
                    artif.getModuleVersion().getId().getName(),
                    artif.getModuleVersion().getId().getVersion(),
                    artif.getFile().getAbsolutePath()
                  ).mkString("\t")

              }
          } catch {
            case exc: Exception =>
              println(
                s"Skipping configuration '${conf
                  .getName()}' due to resolution failure: ${exc.getMessage()}"
              )
          }

        }
      }

    val dependencies = deps.result().distinct

    depsOut match {
      case None =>
        dependencies.foreach(println)
      case Some(path) =>
        Files.write(
          path,
          dependencies.asJava,
          java.nio.file.StandardOpenOption.APPEND,
          java.nio.file.StandardOpenOption.CREATE
        )
    }
  }
}
