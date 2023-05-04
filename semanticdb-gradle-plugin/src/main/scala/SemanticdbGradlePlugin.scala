package com.sourcegraph.gradle.semanticdb

import java.{util => ju}

import scala.jdk.CollectionConverters._

import com.sourcegraph.scip_java.BuildInfo
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.component.ModuleComponentIdentifier
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.scala.ScalaCompile

class SemanticdbGradlePlugin extends Plugin[Project] {
  override def apply(project: Project) = {
    val gradle = new GradleVersion(project.getGradle().getGradleVersion())
    project.afterEvaluate { project =>
      project.getRepositories().add(project.getRepositories().mavenCentral())
      project.getRepositories().add(project.getRepositories().mavenLocal())

      val extra = project.getExtensions().getExtraProperties()

      val targetRoot = extra
        .getProperties()
        .asScala
        .getOrElse("semanticdbTarget", project.getBuildDir())

      val javacPluginVersion = BuildInfo.version
      val javacDep = extra
        .getProperties()
        .asScala
        .get("javacPluginJar")
        .map(_.asInstanceOf[String])
        .map[Object](jar => project.files(jar))
        .getOrElse(s"com.sourcegraph:semanticdb-javac:${javacPluginVersion}")

      val sourceRoot = project.getRootDir()

      val tasks = project.getTasks()

      val triggers = List.newBuilder[String]

      if (project.getPlugins().hasPlugin("java")) {

        triggers += "compileJava"
        triggers += "compileTestJava"

        project.getDependencies().add("compileOnly", javacDep)
        project.getDependencies().add("testCompileOnly", javacDep)

        project
          .getTasks()
          .withType(classOf[JavaCompile])
          .configureEach { task =>
            if (gradle.is5 || (gradle.is6 && !gradle.is6_7_plus))
              println(
                task
                  .asInstanceOf[{
                      def getToolChain(): Any
                    }
                  ]
                  .getToolChain()
              )
            else {
              val toolchainCompiler = Option(task.getJavaCompiler().getOrNull())
                .map(_.getMetadata().getLanguageVersion().asInt())

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
            task
              .getOptions()
              .getCompilerArgs()
              .addAll(
                ju.List
                  .of(
                    s"-Arandomtimestamp=${System.currentTimeMillis()}",
                    s"-Xplugin:semanticdb -targetroot:$targetRoot -sourceroot:$sourceRoot"
                  )
              )

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

            val args = ju
              .List
              .of(
                s"-Xplugin:$semanticdbScalac",
                s"-P:semanticdb:sourceroot:$sourceRoot",
                s"-P:semanticdb:targetroot:$targetRoot",
                s"-P:semanticdb:exclude:(src/play/twirl|src/play/routes|src/${System.currentTimeMillis()})", // Ignore autogenerated Playframework files
                "-P:semanticdb:failures:warning",
                "-Xplugin-require:semanticdb"
              )

            val mutableArgs = new ju.ArrayList[String](args)

            val scalaCompileOptions = task.getScalaCompileOptions()

            if (scalaCompileOptions.getAdditionalParameters == null)
              scalaCompileOptions.setAdditionalParameters(mutableArgs)
            else
              scalaCompileOptions.getAdditionalParameters.addAll(args)

          }

      }

      if (project.getPlugins().hasPlugin("kotlin")) {
        triggers += "compileKotlin"
        triggers += "compileTestKotlin"

        project
          .getTasks
          .configureEach { task =>
            if (task.getClass().getSimpleName().contains("KotlinCompile")) {

              /**
               * I we actually refer to KotlinCompile at _any_ point here, then
               * plugin fails with NoClassDefFoundError - because the plugin
               * classpath is murky
               *
               * We also don't want to bundle kotlin plugin with this one as it
               * can cause all sorts of troubles.
               *
               * Instead, we commit the sins of reflection for our limited
               * needs.
               */
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
                ju.List
                  .of(
                    "-Xplugin=" + semanticdbKotlinc,
                    "-P",
                    s"plugin:semanticdb-kotlinc:sourceroot=$sourceRoot",
                    "-P",
                    s"plugin:semanticdb-kotlinc:targetroot=$targetRoot"
                  )
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

    }

  }

  class GradleVersion(ver: String) {
    override def toString(): String = s"[GradleVersion: $ver]"
    def is7 = ver.startsWith("7.")
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
