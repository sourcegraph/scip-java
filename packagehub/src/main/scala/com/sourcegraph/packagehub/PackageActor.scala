package com.sourcegraph.packagehub

import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.PrintStream
import java.nio.file.FileSystems
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.SimpleFileVisitor
import java.nio.file.StandardOpenOption
import java.nio.file.attribute.BasicFileAttributes

import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._

import scala.meta.internal.io.FileIO
import scala.meta.io.AbsolutePath

import castor.Context
import castor.SimpleActor
import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.lsif_java.Dependencies
import com.sourcegraph.lsif_java.LsifJava
import coursier.core.Dependency
import moped.reporters.ConsoleReporter
import os.Shellable
import os.SubProcess
import ujson.Arr
import ujson.Bool
import ujson.Obj

/**
 * Actor that creates git repos from package sources and (optionally LSIF
 * indexes the sources.
 *
 * This class is implemented as an actor in order to support the use-case:
 * "schedule an LSIF index job for this package after 1 minute". We don't care
 * about the return value of that scheduled LSIF index job so the "fire and
 * forget" nature of actors is OK.
 */
class PackageActor(
    src: String,
    coursier: String,
    store: PackageStore,
    packagehubUrl: String,
    val dir: Path,
    val addr: Int = 3434
)(implicit ctx: Context, log: cask.Logger)
    extends SimpleActor[Package] {
  createGitConfig()

  def run(msg: Package): Unit = {
    lsifIndex(msg, lsifUpload = true)
  }
  private def tmpDir = dir.resolve("lsif-java-tmp")
  private var serveGit = Option.empty[SubProcess]
  private def createGitConfig(): Unit = {
    def setConfig(key: String, value: String): Unit = {
      val result = os.proc("git", "config", "--get", key).call(check = false)
      if (result.exitCode != 0) {
        os.proc("git", "config", "--global", key, value).call()
      }
    }
    setConfig("user.name", "lsif-java")
    setConfig("user.email", "lsif-java@sourcegraph.com")
  }
  def lsifIndex(msg: Package, lsifUpload: Boolean): Path = {
    commitSources(msg)
    val dump = indexClasspathArtifact(msg)
    if (lsifUpload && Files.isRegularFile(dump)) {
      os.proc(src, "login").call(stdout = os.Pipe, stderr = os.Pipe)
      os.proc(src, "lsif", "upload", "--no-progress", "--repo", msg.path)
        .call(
          stdout = os.Pipe,
          stderr = os.Pipe,
          cwd = os.Path(packageDir(msg))
        )
      store.addIndexedPackage(msg)
    }
    dump
  }

  def commitSources(pkg: Package): Unit = {
    if (isCached(pkg))
      return
    pkg match {
      case JdkPackage(version) =>
        val home = os
          .proc(coursier, "java-home", "--jvm", version)
          .call()
          .out
          .trim()
        val srcs = List(
          Paths.get(home, "src.zip"),
          Paths.get(home, "lib", "src.zip")
        )
        srcs.find(Files.isRegularFile(_)) match {
          case Some(src) =>
            commitSourcesArtifact(pkg, src)
          case None =>
            throw new IllegalArgumentException(s"no such files: $srcs")
        }
      case mvn @ MavenPackage(dep) =>
        val deps = Dependencies
          .resolveDependencies(List(mvn.repr), transitive = false)
        indexDeps(mvn, deps)
    }
  }

  private def indexDeps(dep: MavenPackage, deps: Dependencies): Unit = {
    deps
      .sourcesResult
      .fullDetailedArtifacts
      .foreach {
        case (dep, _, _, Some(file)) =>
          val dependency = s"${dep.module.repr}:${dep.version}"
          commitSourcesArtifact(MavenPackage(dep), file.toPath)
        case _ =>
      }
  }

  private def packageId(dep: Dependency): String = {
    s"${dep.module.organization.value}:${dep.module.name.value}:${dep.version}"
  }
  private def packageRelDir(dep: Dependency): Path = {
    Paths.get(dep.module.organization.value, dep.module.name.value, dep.version)
  }
  def packageTmpDir(dep: Dependency): Path = {
    tmpDir.resolve(packageRelDir(dep))
  }
  def packageDir(dep: Dependency): Path = {
    Paths.get(dep.module.organization.value, dep.module.name.value, dep.version)
  }
  def packageDir(pkg: Package): Path = {
    dir.resolve(pkg.relativePath)
  }
  private def collectAllJavaFiles(dir: Path): List[Path] = {
    val javaPattern = FileSystems.getDefault.getPathMatcher("glob:**.java")
    val buf = ListBuffer.empty[Path]
    Files.walkFileTree(
      dir,
      new SimpleFileVisitor[Path] {
        override def visitFile(
            file: Path,
            attrs: BasicFileAttributes
        ): FileVisitResult = {
          if (javaPattern.matches(file)) {
            buf += file
          }
          FileVisitResult.CONTINUE
        }
        override def visitFileFailed(
            file: Path,
            exc: IOException
        ): FileVisitResult = FileVisitResult.CONTINUE
      }
    )
    buf.toList
  }

  def indexClasspathArtifact(pkg: Package): Path = {
    val sourceroot = packageDir(pkg)
    val dump = sourceroot.resolve("dump.lsif")
    if (!Files.isDirectory(sourceroot))
      return dump
    val out = new ByteArrayOutputStream
    val ps =
      new PrintStream(out) {
        override def toString(): String = "foobar"
      }
    val env = LsifJava.app.env.withStandardOutput(ps).withStandardError(ps)
    val app = LsifJava.app.withEnv(env).withReporter(ConsoleReporter(ps))
    val index = app.run(
      List(
        "index",
        "--cwd",
        sourceroot.toString(),
        "--output",
        dump.toString(),
        "--build-tool",
        "lsif"
      )
    )
    if (index != 0) {
      ps.flush()
      sys.error(out.toString())
    }
    dump
  }

  private def commitSourcesArtifact(dep: Package, file: Path): Unit = {
    val repo = packageDir(dep)
    val date = "Thu Apr 8 14:24:52 2021 +0200"
    def proc(command: String*) = {
      os.proc(Shellable(command))
        .call(cwd = os.Path(repo), env = Map("GIT_COMMITTER_DATE" -> date))
    }
    Files.createDirectories(repo)
    proc("git", "init")
    val gitDir = repo.resolve(".git")
    val deleteNonGitFiles =
      new DeleteVisitor(deleteFile = file => !file.startsWith(gitDir))
    Files.walkFileTree(repo, deleteNonGitFiles)
    FileIO.withJarFileSystem(AbsolutePath(file), create = false, close = true) {
      root =>
        FileIO
          .listAllFilesRecursively(root)
          .foreach { file =>
            val bytes = Files.readAllBytes(file.toNIO)
            val rel = file.toRelative(root).toURI(false).toString()
            val out = repo.resolve(rel)
            Files.createDirectories(out.getParent())
            Files.write(
              out,
              bytes,
              StandardOpenOption.CREATE,
              StandardOpenOption.TRUNCATE_EXISTING
            )
          }
        Files.walkFileTree(
          root.toNIO,
          new SimpleFileVisitor[Path] {
            override def visitFile(
                file: Path,
                attrs: BasicFileAttributes
            ): FileVisitResult = {
              FileVisitResult.CONTINUE
            }
          }
        )
    }
    val message = s"Version ${dep.version}"
    Files.write(
      repo.resolve(".gitignore"),
      List("dump.lsif", packagehubCached).asJava
    )
    val build = Obj()
    val dependencies =
      dep match {
        case MavenPackage(dep) =>
          build("dependencies") = Arr(packageId(dep))
        case _ =>
          build("indexJdk") = Bool(false)
      }
    Files.write(
      repo.resolve("lsif-java.json"),
      List(ujson.write(build, indent = 2)).asJava
    )
    Files.write(repo.resolve(packagehubCached), List[String]().asJava)
    proc("git", "add", ".")
    proc("git", "commit", "--allow-empty", "--date", date, "-m", message)
    proc("git", "tag", "-f", "-m", message, s"v${dep.version}")
  }

  private val packagehubCached = "packagehub_cached"

  private def isCached(pkg: Package): Boolean = {
    Files.exists(packageDir(pkg).resolve(packagehubCached))
  }

}
