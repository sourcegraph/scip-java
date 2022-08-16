package com.sourcegraph.scip_java.buildtools

import java.nio.file.Files

import com.sourcegraph.scip_java.Embedded

object SystemJavaVersion {
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
