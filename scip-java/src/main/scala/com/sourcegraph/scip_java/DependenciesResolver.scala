package com.sourcegraph.scip_java

import coursier._
import coursier.cache._
import coursier.util.Task
import scala.concurrent.duration.Duration
import java.nio.file.Path
import scala.util.Try
import java.io.File
import scala.xml.XML
import coursier.parse.DependencyParser

class DependenciesResolver(repositories: List[Repository]) {
  private val cache: FileCache[Task] = FileCache[Task]()
    .noCredentials
    .withCachePolicies(List(CachePolicy.LocalOnly, CachePolicy.Update))
    .withTtl(Duration.Inf)
    .withChecksums(Nil)

  /**
   * Attempts to find the "common definitions" JAR for a potentially
   * MultiPlatform Project. We only support JVM for now, native and JS are not
   * supported. If it ends with '-jvm', we search for a JAR with the classifier
   * truncated. If it does not end with -jvm, we search for a JAR with the
   * -common classifier. This is non-exhaustive, and the classifiers are
   * completely arbitrary.
   */
  def kotlinMPPCommon(
      group: String,
      artifact: String,
      version: String
  ): Option[Path] =
    Try {
      val task = Fetch[Task](Cache.default)
        .withClassifiers(Set(Classifier.sources))
        .withRepositories(repositories)

      if (artifact.endsWith("-jvm")) {
        val dependency = parseDependency(
          s"$group:${artifact.stripSuffix("-jvm")}:$version"
        )
        val result = task.addDependencies(dependency).runResult()
        return Some(result.files.head.toPath)
      }

      val dependency = parseDependency(s"$group:$artifact-common:$version")
      val result = task.addDependencies(dependency).runResult()
      result.files.head.toPath
    }.toOption

  def resolveDependencies(
      dependencies: List[String],
      transitive: Boolean = true
  ): Dependencies = {
    val deps = dependencies.map(parseDependency)
    val provided = deps.flatMap(d => resolveProvidedDeps(d))
    def nonTransitiveDeps = deps.map(_.withTransitive(false))
    val fetch = Fetch[Task](Cache.default)
      .addDependencies(deps: _*)
      .addDependencies(provided: _*)
      .withRepositories(repositories)

    val classpath = fetch.runResult()
    val sources = fetch
      .withDependencies(
        if (transitive)
          fetch.dependencies
        else
          nonTransitiveDeps
      )
      .withClassifiers(Set(Classifier.sources))
      .runResult()
    Dependencies(
      dependencies = deps,
      sourcesResult = sources,
      classpathResult = classpath
    )
  }

  def resolveProvidedDeps(dep: Dependency): Seq[Dependency] = {
    val artifacts = Resolve[Task](Cache.default)
      .addDependencies(dep)
      .withRepositories(repositories)
      .run()
      .artifacts()
    for {
      artifact <- artifacts
      metadata <- artifact.extra.get("metadata").toList
      file = cache.localFile(metadata.url)
      dep <- parseProvidedDependencies(file)
    } yield dep
  }

  private def parseProvidedDependencies(file: File): List[Dependency] = {
    for {
      dep <- XML.loadFile(file) \ "dependencies" \ "dependency"
      if (dep \ "scope").text == "provided"
      org = (dep \ "groupId").text
      module = (dep \ "artifactId").text
      version = (dep \ "version").text
      if org.nonEmpty && module.nonEmpty && version.nonEmpty &&
        !version.startsWith("${")
    } yield Dependency(
      Module(Organization(org), ModuleName(module), Map.empty),
      version
    )
  }.toList

  def parseDependencyEither(lib: String): Either[String, Dependency] = {
    DependencyParser
      .dependency(lib, defaultScalaVersion = BuildInfo.scalaVersion)
  }

  private def parseDependency(lib: String): Dependency = {
    parseDependencyEither(lib) match {
      case Left(error) =>
        throw new IllegalArgumentException(error)
      case Right(value) =>
        value
    }
  }

}
