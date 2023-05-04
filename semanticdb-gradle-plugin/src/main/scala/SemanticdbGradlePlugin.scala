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

      val sourceRoot = project.getRootDir()

      val tasks = project.getTasks()

      val triggers = List.newBuilder[String]

      project.files()

      if (project.getPlugins().hasPlugin("java")) {

        triggers += "compileJava"
        triggers += "compileTestJava"

        val javacPluginVersion = BuildInfo.version
        project
          .getDependencies()
          .add(
            "compileOnly",
            s"com.sourcegraph:semanticdb-javac:${javacPluginVersion}"
          )
        project
          .getDependencies()
          .add(
            "testCompileOnly",
            s"com.sourcegraph:semanticdb-javac:${javacPluginVersion}"
          )

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

            val args = java
              .util
              .List
              .of(
                s"-Xplugin:$semanticdbScalac",
                s"-P:semanticdb:sourceroot:$sourceRoot",
                s"-P:semanticdb:targetroot:$targetRoot",
                s"-P:semanticdb:exclude:(src/play/twirl|src/play/routes|src/${System.currentTimeMillis()})", // Ignore autogenerated Playframework files
                "-P:semanticdb:failures:warning",
                "-Xplugin-require:semanticdb"
              )

            val scalaCompileOptions = task.getScalaCompileOptions()

            if (scalaCompileOptions.getAdditionalParameters == null)
              scalaCompileOptions.setAdditionalParameters(args)
            else
              scalaCompileOptions.getAdditionalParameters.addAll(args)

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
