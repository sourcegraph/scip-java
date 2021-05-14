package com.sourcegraph.packagehub

import java.io.File
import java.io.IOException
import java.net.URL
import java.nio.file.FileSystems
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.SimpleFileVisitor
import java.nio.file.StandardCopyOption
import java.nio.file.StandardOpenOption
import java.nio.file.attribute.BasicFileAttributes

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._

import scala.meta.internal.io.FileIO
import scala.meta.io.AbsolutePath

import castor.Context
import castor.SimpleActor
import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.lsif_java.Dependencies
import com.sourcegraph.lsif_java.buildtools.LsifBuildTool
import com.sourcegraph.lsif_semanticdb.JavaVersion
import coursier.core.Dependency
import org.rauschig.jarchivelib.ArchiverFactory
import os.CommandResult
import os.ProcessOutput.Readlines
import os.Shellable
import os.SubProcess
import ujson.Arr
import ujson.Obj
import ujson.Str

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
    lsifJavaVersion: String,
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
    val dump: Path = lsifIndexPackage(msg)
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
      case mvn @ MavenPackage(_) =>
        val deps = Dependencies
          .resolveDependencies(List(mvn.repr), transitive = false)
        indexDeps(mvn, deps)
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
            commitSourcesArtifact(pkg, src, Dependencies.empty)
          case None =>
            throw new IllegalArgumentException(s"no such files: $srcs")
        }
      case npm: NpmPackage =>
        commitNpmPackage(npm)
    }
  }

  private def commitNpmPackage(npm: NpmPackage): Unit = {
    val repo = packageDir(npm)
    if (!isCached(npm)) {
      val tmp = Files.createTempDirectory("packagehub")
      val filename = tmp.resolve(npm.tarballFilename)
      val url = os
        .proc("npm", "info", npm.npmName, "dist.tarball")
        .call(env = Map("NO_UPDATE_NOTIFIER" -> "true"))
        .out
        .trim()
      val in = new URL(url).openStream()
      try Files.copy(in, filename, StandardCopyOption.REPLACE_EXISTING)
      finally in.close()
      ArchiverFactory
        .createArchiver(new File("archive.tgz"))
        .extract(filename.toFile, tmp.toFile)
      val allFiles = FileIO.listAllFilesRecursively(AbsolutePath(tmp))
      val packageJson = allFiles
        .filter(_.toNIO.endsWith("package.json"))
        .sortBy(_.toNIO.iterator().asScala.length)
        .headOption
        .getOrElse(
          sys.error(s"no such file: package.json (${allFiles.mkString(", ")})")
        )
      Files.createDirectories(repo.getParent)
      val parent = Paths.get(
        packageJson
          .toNIO
          .getParent
          .toRealPath()
          .toString
          .stripPrefix("/private")
      )
      moveDirectory(parent, repo)
      Files.write(
        repo.resolve(".gitignore"),
        List("/tsconfig.json", "node_modules/").asJava
      )
      cacheDirectory(npm)
      Files.walkFileTree(tmp, new DeleteVisitor())
      gitInit(repo)
      gitCommitAll(npm.version, repo)
    }
  }
  private def moveDirectory(from: Path, to: Path): Unit = {
    Files.walkFileTree(
      from,
      new SimpleFileVisitor[Path] {
        override def visitFile(
            file: Path,
            attrs: BasicFileAttributes
        ): FileVisitResult = {
          val relpath = from.relativize(file)
          Files.copy(
            file,
            to.resolve(relpath),
            StandardCopyOption.REPLACE_EXISTING
          )
          FileVisitResult.CONTINUE

        }
        override def preVisitDirectory(
            dir: Path,
            attrs: BasicFileAttributes
        ): FileVisitResult = {
          val relpath = from.relativize(dir)
          val out = to.resolve(relpath)
          if (!Files.isDirectory(out))
            Files.createDirectory(out)
          FileVisitResult.CONTINUE
        }
      }
    )
  }
  private def indexDeps(dep: MavenPackage, deps: Dependencies): Unit = {
    deps
      .sourcesResult
      .fullDetailedArtifacts
      .foreach {
        case (dep, _, _, Some(file)) =>
          commitSourcesArtifact(MavenPackage(dep), file.toPath, deps)
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

  def lsifIndexPackage(pkg: Package): Path = {
    val sourceroot = packageDir(pkg)
    val dump = sourceroot.resolve("dump.lsif")
    if (!Files.isDirectory(sourceroot))
      return dump
    pkg match {
      case _: NpmPackage =>
        exec(sourceroot, List("yarn", "install"))
        val tsconfig = sourceroot.resolve("tsconfig.json")
        if (!Files.isRegularFile(tsconfig)) {
          val config = Obj(
            "include" -> Arr("**/*"),
            "compilerOptions" -> Obj("allowJs" -> true)
          )
          Files.write(tsconfig, List(ujson.write(config, indent = 2)).asJava)
        }
        exec(
          sourceroot,
          List("npx", "@olafurpg/lsif-tsc", "-p", sourceroot.toString)
        )
      case _ =>
        val jvm: String =
          pkg match {
            case JdkPackage(version) =>
              version
            case _ =>
              val configVersion: Option[String] =
                for {
                  config <- Option(
                    sourceroot.resolve(LsifBuildTool.ConfigFileName)
                  )
                  if Files.isRegularFile(config)
                  obj <- ujson.read(os.read(os.Path(config))).objOpt
                  version <- obj.get("jvm")
                  versionStr <- version.strOpt
                } yield versionStr
              configVersion.getOrElse(JavaVersion.DEFAULT_JAVA_VERSION.toString)
          }
        exec(
          sourceroot,
          List(
            coursier,
            "launch",
            "--jvm",
            jvm,
            s"com.sourcegraph:lsif-java_2.13:${lsifJavaVersion}",
            "-r",
            "sonatype:snapshots",
            "--",
            "index",
            "--output",
            dump.toString(),
            "--build-tool",
            "lsif"
          )
        )
    }
    dump
  }

  private def commitSourcesArtifact(
      dep: Package,
      file: Path,
      deps: Dependencies
  ): Unit = {
    val repo = packageDir(dep)
    Files.createDirectories(repo)
    gitInit(repo)
    deleteAllNonGitFiles(repo)
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
    Files.write(
      repo.resolve(".gitignore"),
      List("dump.lsif", packagehubCached).asJava
    )
    val build = Obj()
    dep match {
      case MavenPackage(dep) =>
        val inferredJvmVersion =
          for {
            jar <- deps.classpath.headOption
            version <- Option(JavaVersion.classfileJvmVersion(jar).orElse(null))
            // Some libraries like JUnit target Java 3 but we can still compile them with Java 8.
          } yield JavaVersion.roundToNearestStableRelease(version).toString
        val jvmVersion = inferredJvmVersion
          .getOrElse(JavaVersion.DEFAULT_JAVA_VERSION.toString)

        build("kind") = Str("maven")
        build("jvm") = Str(jvmVersion)
        build("dependencies") = Arr(packageId(dep))
      case JdkPackage(version) =>
        build("kind") = Str("jdk")
        build("jvm") = Str(version)
        build("dependencies") = Arr()
      case _ =>
    }
    Files.write(
      repo.resolve(LsifBuildTool.ConfigFileName),
      List(ujson.write(build, indent = 2)).asJava
    )
    cacheDirectory(dep)
    gitCommitAll(dep.version, repo)
  }

  def exec(cwd: Path, command: List[String]): CommandResult = {
    val lines = ArrayBuffer.empty[String]
    val out = Readlines(line => lines += line)
    val result = os
      .proc(Shellable(command))
      .call(stdout = out, stderr = out, cwd = os.Path(cwd), check = false)
    if (result.exitCode == 0)
      result
    else {
      throw CommandFailed(command, cwd, lines, result)
    }
  }

  case class CommandFailed(
      command: List[String],
      cwd: Path,
      stdout: collection.Seq[String],
      result: CommandResult
  ) extends RuntimeException(
        ujson.write(
          Obj(
            "command" -> Arr.from(command),
            "cwd" -> cwd.toString,
            "exit" -> result.exitCode,
            "stdout" -> Arr.from(stdout)
          ),
          indent = 2
        )
      )

  val date = "Thu Apr 8 14:24:52 2021 +0200"
  def proc(repo: Path, command: String*): CommandResult = {
    os.proc(Shellable(command))
      .call(cwd = os.Path(repo), env = Map("GIT_COMMITTER_DATE" -> date))
  }

  private def gitCommitAll(version: String, repo: Path): Unit = {
    val message = s"Version ${version}"
    proc(repo, "git", "add", ".")
    proc(repo, "git", "commit", "--allow-empty", "--date", date, "-m", message)
    proc(repo, "git", "tag", "-f", "-m", message, s"v${version}")
  }

  private def gitInit(repo: Path): Unit = {
    proc(repo, "git", "init")
  }
  private def deleteAllNonGitFiles(repo: Path): Unit = {
    val gitDir = repo.resolve(".git")
    val deleteNonGitFiles =
      new DeleteVisitor(deleteFile = file => !file.startsWith(gitDir))
    Files.walkFileTree(repo, deleteNonGitFiles)
  }

  private val packagehubCached = "packagehub_cached"

  private def cacheDirectory(pkg: Package): Unit = {
    Files
      .write(packageDir(pkg).resolve(packagehubCached), List[String]().asJava)
  }
  private def isCached(pkg: Package): Boolean = {
    Files.exists(packageDir(pkg).resolve(packagehubCached))
  }

}
