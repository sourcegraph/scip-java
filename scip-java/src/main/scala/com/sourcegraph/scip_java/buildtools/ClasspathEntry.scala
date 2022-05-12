package com.sourcegraph.scip_java.buildtools

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import scala.jdk.CollectionConverters._

import com.sourcegraph.scip_semanticdb.MavenPackage

/**
 * Represents a single jar file on the classpath of a project, used to emit SCIP
 * "packageInformation" nodes.
 */
case class ClasspathEntry(
    jar: Path,
    sources: Option[Path],
    groupId: String,
    artifactId: String,
    version: String
) {
  def toPackageHubId: String = s"maven:$groupId:$artifactId:$version"
  def toPackageInformation: MavenPackage =
    new MavenPackage(jar, groupId, artifactId, version)
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
   * @param targetroot
   *   @return
   */
  def fromTargetroot(targetroot: Path): List[ClasspathEntry] = {
    val javacopts = targetroot.resolve("javacopts.txt")
    val dependencies = targetroot.resolve("dependencies.txt")
    if (Files.isRegularFile(dependencies)) {
      fromDependencies(dependencies)
    } else if (Files.isRegularFile(javacopts)) {
      fromJavacopts(javacopts)
    } else {
      Nil
    }
  }

  /**
   * Parses ClasspathEntry from a "dependencies.txt" file in the targetroot.
   *
   * Every line of the file is a tab separated value with the following columns:
   * groupId, artifactId, version, path to the jar file.
   */
  private def fromDependencies(dependencies: Path): List[ClasspathEntry] = {
    Files
      .readAllLines(dependencies, StandardCharsets.UTF_8)
      .asScala
      .iterator
      .map(_.split("\t"))
      .collect { case Array(groupId, artifactId, version, jar) =>
        ClasspathEntry(
          jar = Paths.get(jar),
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
  private def fromJavacopts(javacopts: Path): List[ClasspathEntry] = {
    Files
      .readAllLines(javacopts, StandardCharsets.UTF_8)
      .asScala
      .iterator
      .map(_.stripPrefix("\"").stripSuffix("\""))
      .sliding(2)
      .collect { case Seq("-cp" | "-classpath", classpath) =>
        classpath.split(File.pathSeparator).iterator
      }
      .flatten
      .map(Paths.get(_))
      .toSet
      .iterator
      .flatMap(ClasspathEntry.fromPom)
      .toList
  }

  /**
   * Tries to parse a ClasspathEntry from the POM file that lies next to the
   * given jar file.
   */
  private def fromPom(jar: Path): Option[ClasspathEntry] = {
    val pom = jar
      .resolveSibling(jar.getFileName.toString.stripSuffix(".jar") + ".pom")
    val sources = Option(
      jar.resolveSibling(
        jar.getFileName.toString.stripSuffix(".jar") + ".sources"
      )
    ).filter(Files.isRegularFile(_))
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
      Some(ClasspathEntry(jar, sources, groupId, artifactId, version))
    } else {
      None
    }
  }
}
