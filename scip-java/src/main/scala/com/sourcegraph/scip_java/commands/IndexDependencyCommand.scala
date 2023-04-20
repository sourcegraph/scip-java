package com.sourcegraph.scip_java.commands

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.nio.file.StandardOpenOption
import java.util.jar.JarFile

import com.sourcegraph.io.AbsolutePath
import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.scip_java.Dependencies
import com.sourcegraph.scip_semanticdb.JavaVersion
import moped.annotations.DeprecatedName
import moped.annotations.Description
import moped.annotations.Hidden
import moped.cli.Command
import moped.cli.CommandParser

final case class IndexDependencyCommand(
    @DeprecatedName("target", "Use --output instead", "0.6.10") output: Path =
      Paths.get("maven"),
    index: IndexCommand = IndexCommand(),
    @Hidden
    snapshotCommand: SnapshotCommand = SnapshotCommand(),
    dependency: String = "",
    provided: List[String] = Nil,
    @Description(
      "If true, deletes temporary files that are created during indexing"
    ) cleanup: Boolean = true,
    snapshot: Boolean = false
) extends Command {
  def app = index.app
  private val absoluteTarget = AbsolutePath
    .of(output, app.env.workingDirectory)
    .resolve(dependency.replace(":", "__"))
  private val indexTarget =
    if (snapshot)
      Files.createTempDirectory("scip-java-index")
    else
      absoluteTarget
  private val snapshotTarget = absoluteTarget
  def run(): Int = {
    if (dependency == "") {
      app.reporter.error("dependency can't be empty")
      1
    } else {
      val deps = Dependencies
        .resolveDependencies(dependency :: provided, transitive = false)
      deps.sources.headOption match {
        case None =>
          app.reporter.error(s"no sources for dependency '$dependency'")
          1
        case Some(sources) =>
          unzipJar(sources)
          deps.classpath.headOption match {
            case None =>
              app.reporter.error(s"no classpath for dependency '$dependency'")
              1
            case Some(classpath) =>
              inferJvmVersion(classpath) match {
                case None =>
                  app
                    .reporter
                    .error(
                      s"failed to infer JVM version for classpath '$classpath'"
                    )
                  1
                case Some(jvmVersion) =>
                  val exit = indexJar(jvmVersion)
                  if (exit == 0 && snapshot) {
                    try {
                      snapshotCommand
                        .copy(
                          output = snapshotTarget,
                          cleanup = cleanup,
                          targetroot = List(indexTarget),
                          app = app
                            .withEnv(app.env.withWorkingDirectory(indexTarget))
                        )
                        .run()
                    } finally {
                      if (cleanup) {
                        Files.walkFileTree(indexTarget, new DeleteVisitor())
                      }
                    }
                  } else {
                    exit
                  }
              }
          }
      }
    }
  }

  private def inferJvmVersion(jar: Path): Option[Int] = {
    Option(JavaVersion.classfileJvmVersion(jar).orElse(8))
      .map(JavaVersion.roundToNearestStableRelease(_))
  }

  private def indexJar(jvmVersion: Int): Int = {
    val config =
      s"""{"kind":"maven","jvm":"$jvmVersion","dependencies":["$dependency"]}"""
    Files.createDirectories(indexTarget)
    Files.write(
      indexTarget.resolve("lsif-java.json"),
      config.getBytes(StandardCharsets.UTF_8),
      StandardOpenOption.CREATE,
      StandardOpenOption.TRUNCATE_EXISTING
    )
    index
      .copy(
        buildTool = Some("scip"),
        cleanup = cleanup,
        app = app.withEnv(app.env.withWorkingDirectory(indexTarget))
      )
      .run()
  }

  private def unzipJar(file: Path): Unit = {
    val jar = new JarFile(file.toFile())
    try {
      val entries = jar.entries()
      while (entries.hasMoreElements()) {
        val entry = entries.nextElement()
        if (!entry.isDirectory()) {
          val out = indexTarget.resolve(entry.getName())
          Files.createDirectories(out.getParent())
          val in = jar.getInputStream(entry)
          try Files.copy(in, out, StandardCopyOption.REPLACE_EXISTING)
          finally in.close()
        }
      }
    } finally {
      jar.close()
    }
  }
}

object IndexDependencyCommand {
  implicit val parser = CommandParser.derive(IndexDependencyCommand())
}
