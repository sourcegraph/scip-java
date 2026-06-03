package com.sourcegraph.scip_java.buildtools

import java.nio.file.Files

import com.sourcegraph.scip_java.Embedded

object SystemJavaVersion {
  // Returns the major version of the JVM that `java` on PATH resolves to. We
  // can't just use `Properties.javaSpecVersion` because the current process
  // may be a different JVM (e.g. when running `sbt test`).
  //
  // Examples:
  //   "1.8.0_372" => 8   (Java 8 reports as "1.8.x")
  //   "11.0.2"    => 11
  //   "17.0.5"    => 17
  def detectMajor(): Int = {
    val tmp = Files.createTempDirectory("java-version")
    val jar = Embedded.semanticdbJar(tmp)
    try {
      val version = os
        .proc(
          "java",
          "-cp",
          jar.toString(),
          "com.sourcegraph.semanticdb_javac.PrintJavaVersion"
        )
        .call()
        .out
        .text()
        .trim()
      if (version.startsWith("1."))
        8
      else
        version.takeWhile(_.isDigit).toInt
    } finally {
      Files.deleteIfExists(jar)
    }
  }
}
