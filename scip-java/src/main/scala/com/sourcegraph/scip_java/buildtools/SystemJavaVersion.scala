package com.sourcegraph.scip_java.buildtools

import java.nio.file.Files

import scala.annotation.tailrec

import com.sourcegraph.scip_java.Embedded

object SystemJavaVersion {
  // Returns the output of `System.getProperty("java.version")` from a fresh JVM
  // instance using the system JVM installation. We can't use this process since
  // it may be running on a separate JVM process (that's the case when we run
  // `sbt test` in this build at least).
  def detect(): String = {
    val tmp = Files.createTempDirectory("java-version")
    val jar = Embedded.semanticdbJar(tmp)
    try {
      os.proc(
          "java",
          "-cp",
          jar.toString(),
          "com.sourcegraph.semanticdb_javac.PrintJavaVersion"
        )
        .call()
        .out
        .text()
        .trim()
    } finally {
      Files.deleteIfExists(jar)
    }
  }

  // Copy-pasted from scala.util.Properties.isJavaAtLeast but makes the actual
  // version a parameterizeable instead of being hard-coded to
  // `Properties.javaVersionSpec`.
  def isAtLeast(actualVersion: String, comparisonVersion: String): Boolean = {
    def versionOf(s: String, depth: Int): (Int, String) =
      s.indexOf('.') match {
        case 0 =>
          (-2, s.substring(1))
        case 1 if depth == 0 && s.charAt(0) == '1' =>
          val r0 = s.substring(2)
          val (v, r) = versionOf(r0, 1)
          val n =
            if (v > 8 || r0.isEmpty)
              -2
            else
              v // accept 1.8, not 1.9 or 1.
          (n, r)
        case -1 =>
          val n =
            if (!s.isEmpty)
              s.toInt
            else if (depth == 0)
              -2
            else
              0
          (n, "")
        case i =>
          val r = s.substring(i + 1)
          val n =
            if (depth < 2 && r.isEmpty)
              -2
            else
              s.substring(0, i).toInt
          (n, r)
      }
    @tailrec
    def compareVersions(s: String, v: String, depth: Int): Int = {
      if (depth >= 3)
        0
      else {
        val (sn, srest) = versionOf(s, depth)
        val (vn, vrest) = versionOf(v, depth)
        if (vn < 0)
          -2
        else if (sn < vn)
          -1
        else if (sn > vn)
          1
        else
          compareVersions(srest, vrest, depth + 1)
      }
    }

    compareVersions(actualVersion, comparisonVersion, 0) match {
      case -2 =>
        throw new NumberFormatException(s"Not a version: $comparisonVersion")
      case i =>
        i >= 0
    }
  }
}
