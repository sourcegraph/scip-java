package com.sourcegraph.scip_java.buildtools

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import scala.annotation.tailrec
import scala.jdk.CollectionConverters._

import com.sourcegraph.scip_semanticdb.MavenPackage

/**
 * Represents a single classpath entry on the classpath of a project, used to
 * emit SCIP "packageInformation" nodes. A classpath entry can either be a jar
 * file or a directory path.
 */
case class ClasspathEntry(
    entry: Path,
    sources: Option[Path],
    groupId: String,
    artifactId: String,
    version: String
) {
  def toPackageHubId: String = s"maven:$groupId:$artifactId:$version"
  def toPackageInformation: MavenPackage =
    new MavenPackage(entry, groupId, artifactId, version)
}

object ClasspathEntry {

  /**
   * Parses ClasspathEntry from the SemanticDB targetroot directory.
   *
   * Two separate formats are supported:
   *
   *   - javacopts.txt: line-separated list of Java compiler options.
   *   - dependencies.txt: line-separated list of dependency information.
   *
   * Note that the targetroot can contain several files with names ending in
   * "dependencies.txt" - for example if they come from a multi-module build.
   *
   * @param targetroot
   *   @return
   */
  def fromTargetroot(
      targetroot: Path,
      sourceroot: Path
  ): List[ClasspathEntry] = {
    val javacopts = targetroot.resolve("javacopts.txt")
    if (Files.isRegularFile(javacopts))
      fromJavacopts(javacopts, sourceroot)
    else
      discoverDependenciesFromFiles(targetroot)
  }

  /**
   * Discover all files that end in "dependencies.txt" directly under
   * targetroot. There can be many files because we will be writing dependencies
   * for multiple projects.
   *
   * @param targetroot
   *   @return classpath entries read from the discovered files
   */
  private def discoverDependenciesFromFiles(
      targetroot: Path
  ): List[ClasspathEntry] = {
    os.list
      .stream(os.Path(targetroot))
      .filter(p => os.isFile(p) && p.last.endsWith("dependencies.txt"))
      .map(path => fromDependencies(path.toNIO))
      .toList
      .flatten
      .distinct
  }

  /**
   * Parses ClasspathEntry from a "dependencies.txt" file
   *
   * Every line of the file is a tab separated value with the following columns:
   * groupId, artifactId, version, path to the jar file OR classes directory
   * path.
   */
  private def fromDependencies(dependencies: Path): List[ClasspathEntry] = {
    Files
      .readAllLines(dependencies, StandardCharsets.UTF_8)
      .asScala
      .iterator
      .map(_.split("\t"))
      .collect { case Array(groupId, artifactId, version, entry) =>
        ClasspathEntry(
          entry = Paths.get(entry),
          sources = None,
          groupId = groupId,
          artifactId = artifactId,
          version = version
        )
      }
      .toList
  }

  /**
   * Parses ClasspathEntry from a "javacopts.txt" file in the targetroot.
   *
   * Every line of the file represents a Java compiler options, such as
   * "-classpath" or "-encoding".
   */
  private def fromJavacopts(
      javacopts: Path,
      sourceroot: Path
  ): List[ClasspathEntry] = {
    Files
      .readAllLines(javacopts, StandardCharsets.UTF_8)
      .asScala
      .iterator
      .map(_.stripPrefix("\"").stripSuffix("\""))
      .sliding(2)
      .collect {
        case Seq("-d", classesDirectory) =>
          fromClassesDirectory(Paths.get(classesDirectory), sourceroot).toList
        case Seq("-cp" | "-classpath", classpath) =>
          classpath
            .split(File.pathSeparator)
            .iterator
            .map(Paths.get(_))
            .flatMap(ClasspathEntry.fromClasspathJarFile)
            .toList
      }
      .flatten
      .toList
  }

  private def fromClassesDirectory(
      classesDirectory: Path,
      sourceroot: Path
  ): Option[ClasspathEntry] = {
    @tailrec
    def loop(dir: Path): Option[ClasspathEntry] = {
      if (dir == null || !dir.startsWith(sourceroot))
        None
      else
        fromPomXml(dir.resolve("pom.xml"), classesDirectory, None) match {
          case None =>
            loop(dir.getParent())
          case Some(value) =>
            Some(value)
        }
    }
    loop(classesDirectory.getParent())
  }

  /**
   * Tries to parse a ClasspathEntry from the POM file that lies next to the
   * given jar file.
   */
  private def fromClasspathJarFile(jar: Path): Option[ClasspathEntry] = {
    val pom = jar
      .resolveSibling(jar.getFileName.toString.stripSuffix(".jar") + ".pom")
    val sources = Option(
      jar.resolveSibling(
        jar.getFileName.toString.stripSuffix(".jar") + ".sources"
      )
    ).filter(Files.isRegularFile(_))
    fromPomXml(pom, jar, sources)
  }

  private def fromPomXml(
      pom: Path,
      classpathEntry: Path,
      sources: Option[Path]
  ): Option[ClasspathEntry] = {
    if (Files.isRegularFile(pom)) {
      val xml = scala.xml.XML.loadFile(pom.toFile)
      def xmlValue(key: String): String = {
        val node = xml \ key
        if (node.isEmpty)
          (xml \ "parent" \ key).text
        else
          node.text
      }.trim
      val groupId = xmlValue("groupId")
      val artifactId = xmlValue("artifactId")
      val version = xmlValue("version")
      Some(
        ClasspathEntry(classpathEntry, sources, groupId, artifactId, version)
      )
    } else {
      None
    }
  }
}
