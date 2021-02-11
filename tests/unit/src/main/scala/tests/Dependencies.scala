package tests

import java.io.File
import java.nio.file.FileSystems

import scala.concurrent.duration.Duration
import scala.xml.XML

import scala.meta.io.AbsolutePath

import coursier.Fetch
import coursier.Resolve
import coursier.cache.Cache
import coursier.cache.CachePolicy
import coursier.cache.FileCache
import coursier.core._
import coursier.parse.DependencyParser
import coursier.util.Task

case class Dependencies(
    sources: Seq[AbsolutePath],
    classpath: Seq[AbsolutePath]
) {
  def classpathSyntax: String = classpath.mkString(File.pathSeparator)
}

object Dependencies {
  private val cache: FileCache[Task] = FileCache[Task]()
    .noCredentials
    .withCachePolicies(List(CachePolicy.LocalOnly, CachePolicy.Update))
    .withTtl(Duration.Inf)
    .withChecksums(Nil)
  private val jarPattern = FileSystems.getDefault.getPathMatcher("glob:**.jar")

  def resolveDependencies(
      dependencies: List[String],
      repos: List[Repository]
  ): Dependencies = {
    val deps = dependencies.map(parseDependency)
    val provided = deps.flatMap(d => resolveProvidedDeps(d, repos))
    val fetch = Fetch[Task](Cache.default)
      .addDependencies(deps: _*)
      .addDependencies(provided: _*)
      .addRepositories(repos: _*)

    val classpath = fetch.run()
    val sources = fetch.withClassifiers(Set(Classifier.sources)).run()
    Dependencies(
      sources = sources.map(AbsolutePath(_)),
      classpath = classpath.map(AbsolutePath(_))
    )
  }

  private def resolveProvidedDeps(
      dep: Dependency,
      repos: List[Repository]
  ): Seq[Dependency] = {
    val artifacts = Resolve[Task](Cache.default)
      .addDependencies(dep)
      .addRepositories(repos: _*)
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

  private def parseDependency(lib: String): Dependency = {
    val dep = DependencyParser
      .dependency(lib, defaultScalaVersion = BuildInfo.scalaVersion)
    dep match {
      case Left(error) =>
        throw new IllegalArgumentException(error)
      case Right(value) =>
        value
    }
  }
}
