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
    }
  }
  def fromPath(path: List[String]): Option[(Package, List[String])] =
    path match {
      case "maven" :: org :: name :: version :: requestPath =>
        Some(Package.maven(org, name, version) -> requestPath)
      case "jdk" :: version :: requestPath =>
        Some(Package.jdk(version) -> requestPath)
      case _ =>
        None
    }
  def fromString(value: String, coursier: String): Either[String, Package] = {
    value match {
      case s"jdk:$version" =>
        val exit = os
          .proc(coursier, "java-home", "--jvm", version)
          .call(check = false)
        if (exit.exitCode == 0)
          Right(JdkPackage(version))
        else
          Left(exit.out.trim())
      case s"maven:$library" =>
        Dependencies
          .parseDependencyEither(library)
          .flatMap { dep =>
            try {
              // Report an error if the dependency can't be resolved.
              Dependencies.resolveProvidedDeps(dep)
              Right(MavenPackage(dep))
            } catch {
              case NonFatal(e) =>
                Left(e.getMessage())
            }
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
