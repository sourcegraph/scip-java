package com.sourcegraph.scip_java.buildtools

import java.nio.file.Path

import com.sourcegraph.scip_java.BuildInfo

object ScalaVersion {

  /**
   * Returns a best-effort guess for which Scala version to compile with the
   * given jar filename.
   *
   * The implementation of this method may seem hacky but it's the best approach
   * I can think of that solves this problem with the given constraints:
   *
   *   - We can't assume scala-library.jar is on the classpath because Scala
   *     libraries like `com.lihaoyi:geny` don't include an explicit dependency
   *     on scala-library. See https://github.com/com-lihaoyi/geny/issues/32
   *   - We want to support Scala 3, which uses the same scala-library as Scala
   *     2.13.
   *   - We should only infer Scala versions that are supported by the
   *     `org.scalameta:mtags` module, which we use to compile SemanticDB files.
   *     Currently, mtags supports the latest patch releases of Scala 2.13 and
   *     Scala 3.
   */
  def inferFromJar(jar: Path): Option[String] = {
    val Scala3 = ".*_3\\b.*".r
    val Scala213 = ".*_2.13\\b.*".r
    val ScalaOfficial =
      ".*scala(p|-compiler|-reflect|-library)?-2.([^\\.]+).*.jar".r
    Option(jar.getFileName.toString).collect {
      case Scala3() =>
        BuildInfo.scala3
      case Scala213() =>
        BuildInfo.scala213
      case ScalaOfficial(_, "13") =>
        BuildInfo.scala213
    }
  }

}
