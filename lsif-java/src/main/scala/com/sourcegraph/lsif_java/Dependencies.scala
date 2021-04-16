package com.sourcegraph.lsif_java

import java.io.File
import java.nio.file.Path

import scala.concurrent.duration.Duration
import scala.xml.XML

import com.sourcegraph.lsif_java.BuildInfo
import coursier.Fetch
import coursier.Repositories
import coursier.Resolve
import coursier.cache.Cache
import coursier.cache.CachePolicy
import coursier.cache.FileCache
import coursier.core._
import coursier.parse.DependencyParser
import coursier.util.Task

case class Dependencies(
    dependencies: List[Dependency],
    sourcesResult: Fetch.Result,
    classpathResult: Fetch.Result
) {
  val sources: Seq[Path] = sourcesResult.files.map(_.toPath())
  val classpath: Seq[Path] = classpathResult.files.map(_.toPath())
  def classpathSyntax: String = classpath.mkString(File.pathSeparator)
}

object Dependencies {
  private val cache: FileCache[Task] = FileCache[Task]()
    .noCredentials
    .withCachePolicies(List(CachePolicy.LocalOnly, CachePolicy.Update))
    .withTtl(Duration.Inf)
    .withChecksums(Nil)
  private val defaultExtraRepositories = List[Repository](
    Repositories.google,
    Repositories.clojars,
    Repositories.jitpack,
    Repositories.centralGcs
  )

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
      .addRepositories(defaultExtraRepositories: _*)

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
      .addRepositories(defaultExtraRepositories: _*)
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
