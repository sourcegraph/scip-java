package com.sourcegraph.packagehub

import java.nio.file.Path
import java.nio.file.Paths

import scala.util.control.NonFatal

import com.sourcegraph.lsif_java.Dependencies
import coursier.core.Dependency
import coursier.core.Module
import coursier.core.ModuleName
import coursier.core.Organization
import ujson.Obj

/**
 * Package represents a published library such as a Java artifact, or the JDK.
 *
 * @param id
 *   unique representation for this package that does not include the forward
 *   slash character. Can be used as the primary key in a relational database.
 *   Should ideally be human-readable and be easy to parse.
 * @param path
 *   relative URL of this package.
 */
sealed abstract class Package(
    val id: String,
    val path: String,
    val version: String
) {
  def toJsonRepo: Obj = Obj("Name" -> path, "URI" -> s"/repos/$path")
  def relativePath: Path = Paths.get(path)
}
object Package {
  def npm(name: String, version: String): NpmPackage = {
    NpmPackage(name, version)
  }
  def jdk(version: String): JdkPackage = {
    JdkPackage(version)
  }
  def maven(org: String, name: String, version: String): MavenPackage = {
    MavenPackage(
      Dependency(
        Module(Organization(org), ModuleName(name), Map.empty),
        version
      )
    )
  }
  def parse(value: String): Package = {
    value match {
      case s"jdk:$version" =>
        JdkPackage(version)
      case s"maven:$library" =>
        val Right(dep) = Dependencies.parseDependencyEither(library)
        MavenPackage(dep)
      case s"npm:$name:$version" =>
        NpmPackage(name, version)
    }
  }
  def fromPath(path: List[String]): Option[(Package, List[String])] =
    path match {
      case "maven" :: org :: name :: version :: requestPath =>
        Some(Package.maven(org, name, version) -> requestPath)
      case "jdk" :: version :: requestPath =>
        Some(Package.jdk(version) -> requestPath)
      case "npm" :: GitRequestPrefix(parts, requestPath) =>
        val name = parts.init.mkString("/")
        val version = parts.last
        val actualName =
          if (name.startsWith("-"))
            "@" + name.stripPrefix("-")
          else
            name
        Some(Package.npm(actualName, version) -> requestPath)
      case _ =>
        None
    }

  object GitRequestPrefix {
    private val suffixes = List(
      ".git" :: "info" :: "refs" :: Nil,
      "info" :: "refs" :: Nil,
      ".git" :: "git-upload-pack" :: Nil,
      "git-upload-pack" :: Nil
    )
    def unapply(path: List[String]): Option[(List[String], List[String])] = {
      suffixes.find(path.endsWith) match {
        case Some(suffix) =>
          Some(path.dropRight(suffix.length) -> suffix)
        case None =>
          None
      }
    }
  }
  def fromString(value: String, coursier: String): Either[String, Package] = {
    value match {
      case s"maven:$library" =>
        try {
          val deps = Dependencies
            .resolveDependencies(List(library), transitive = false)
          if (deps.sources.isEmpty) {
            Left(s"no sources for package '$library'")
          } else if (deps.dependencies.length != 1) {
            Left(s"expected a single dependency, got ${deps.dependencies}")
          } else {
            Right(MavenPackage(deps.dependencies.head))
          }
        } catch {
          case NonFatal(e) =>
            Left(e.getMessage())
        }
      case s"jdk:$version" =>
        val exit = os
          .proc(coursier, "java-home", "--jvm", version)
          .call(check = false)
        if (exit.exitCode == 0)
          Right(JdkPackage(version))
        else
          Left(exit.out.trim())
      case s"npm:$name:$version" =>
        try {
          val out = os
            .proc("npm", "info", s"$name@$version")
            .call(check = false)
            .out
            .trim()
          if (out.nonEmpty)
            Right(NpmPackage(name, version))
          else
            Left(s"no such npm package: $name@$version")
        } catch {
          case NonFatal(e) =>
            Left(e.getMessage)
        }
      case other =>
        Left(
          s"unsupported package '$other'. To fix this problem, use a valid syntax " +
            s"such as 'maven:ORGANIZATION:ARTIFACT_NAME_VERSION' for Java libraries."
        )
    }
  }
}

/**
 * A Java library that is published "Maven style".
 *
 * The most widely used Maven package host is "Maven Central"
 * https://search.maven.org/. Most companies self-host an Artifactory instance
 * to publish internal libraries and to proxy Maven Central.
 */
case class MavenPackage(dep: Dependency)
    extends Package(
      s"maven:${dep.module.repr}:${dep.version}",
      s"maven/${dep.module.organization.value}/${dep.module.name.value}/${dep.version}",
      dep.version
    ) {
  def repr = id.stripPrefix("maven:")
}

/**
 * The Java standard library.
 *
 * The sources of the Java standard library are typically available under
 * JAVA_HOME.
 */
case class JdkPackage(override val version: String)
    extends Package(s"jdk:${version}", s"jdk/${version}", version) {
  def repr = id.stripPrefix("jdk:")
}

case class NpmPackage(packageName: String, override val version: String)
    extends Package(
      s"npm:$packageName:$version",
      s"npm/$packageName/$version".replace("@", "-"),
      version
    ) {
  def npmName = s"$packageName@$version"
  def tarballFilename = s"$packageName-$version.tgz".replace('/', '-')
}
