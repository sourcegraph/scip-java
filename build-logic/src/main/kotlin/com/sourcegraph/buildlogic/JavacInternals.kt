package com.sourcegraph.buildlogic

import java.io.File
import java.util.Properties

/**
 * Reads the JVM flags scip-javac needs to access internal javac APIs on Java 9+,
 * keeping gradle/javac-internals.properties the single source of truth.
 */
object JavacInternals {
    fun propertiesFile(rootDir: File): File = rootDir.resolve("gradle/javac-internals.properties")

    fun jvmOptions(rootDir: File): List<String> {
        val file = propertiesFile(rootDir)
        val raw =
            Properties()
                .apply { file.inputStream().use { load(it) } }
                .getProperty("javac.jvmOptions")
                ?: error("Missing javac.jvmOptions in $file")
        return raw.split(',').map { it.trim() }.filter { it.isNotEmpty() }
    }
}
