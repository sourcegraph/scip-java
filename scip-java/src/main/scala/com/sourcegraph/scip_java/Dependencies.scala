package com.sourcegraph.scip_java

import java.io.File
import java.nio.file.Path

import coursier.Fetch
import coursier.LocalRepositories
import coursier.Repositories
import coursier.Resolve
import coursier.core._
import coursier.maven.MavenRepository

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
  val empty = Dependencies(Nil, Fetch.Result(), Fetch.Result())
  def resolver(userRepositories: Option[List[String]]) =
    new DependenciesResolver(calculateRepositories(userRepositories))

  private def calculateRepositories(
      userRepositories: Option[List[String]]
  ): List[Repository] = {
    val defaultExtraRepositories = List[Repository](
      Repositories.google,
      Repositories.clojars,
      Repositories.jitpack,
      Repositories.centralGcs
    )

    userRepositories match {
      case None =>
        Resolve.defaultRepositories.toList ++ defaultExtraRepositories
      case Some(value) =>
        LocalRepositories.ivy2Local +:
          value.map {
            case "central" =>
              Repositories.central
            case other =>
              MavenRepository(other): Repository
          }

    }

  }
}
