package com.sourcegraph.lsif_java.commands

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.nio.file.StandardOpenOption
import java.util.jar.JarFile

import com.sourcegraph.io.AbsolutePath
import com.sourcegraph.lsif_java.Dependencies
import com.sourcegraph.lsif_semanticdb.JavaVersion
import moped.cli.Command
import moped.cli.CommandParser

final case class IndexDependencyCommand(
    target: Path = Paths.get("maven"),
    index: IndexCommand = IndexCommand(),
    dependency: String = ""
) extends Command {
  def app = index.app
  private val absoluteTarget = AbsolutePath
    .of(target, app.env.workingDirectory)
    .resolve(dependency.replace(":", "__"))
  def run(): Int = {
    if (dependency == "") {
      app.reporter.error("dependency can't be empty")
      1
    } else {
      val deps = Dependencies
        .resolveDependencies(List(dependency), transitive = false)
      deps.sources.headOption match {
        case Some(sources) =>
          unzipJar(sources)
          deps.classpath.headOption match {
            case Some(classpath) =>
              Option(
                JavaVersion.classfileJvmVersion(classpath).orElse(8)
              ) match {
                case Some(jvmVersion) =>
                  val config =
                    s"""{"kind":"maven","jvm":"$jvmVersion","dependencies":["$dependency"]}"""
                  Files.createDirectories(absoluteTarget)
                  Files.write(
                    absoluteTarget.resolve("lsif-java.json"),
                    config.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
                  )
                  index
                    .copy(
                      buildTool = Some("lsif"),
                      app = app
                        .withEnv(app.env.withWorkingDirectory(absoluteTarget))
                    )
                    .run()
                case None =>
                  app
                    .reporter
                    .error(
                      s"failed to infer JVM version for classpath '$classpath'"
                    )
                  1
              }
            case None =>
              app.reporter.error(s"no classpath for dependency '$dependency'")
              1
          }
        case None =>
          app.reporter.error(s"no sources for dependency '$dependency'")
          1
      }
      1
    }
  }

  private def unzipJar(file: Path): Unit = {
    val jar = new JarFile(file.toFile())
    try {
      val entries = jar.entries()
      while (entries.hasMoreElements()) {
        val entry = entries.nextElement()
        if (!entry.isDirectory()) {
          val out = absoluteTarget.resolve(entry.getName())
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
