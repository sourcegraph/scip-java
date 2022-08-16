package com.sourcegraph.scip_java.buildtools

import java.nio.file.Files

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
}
