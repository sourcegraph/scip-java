package com.sourcegraph.gradle.semanticdb

// This file is part of plugin source for test purposes only
// When the plugin gets injected, a version of this file is written from the BuildInfo of scip-java project
object PluginConfig {
    val defaultSemanticdbJavacVersion = "0.8.16"
    val semanticdbScalacVersions = mapOf(
            "2.12.12" to "4.5.9", "2.13.7" to "4.5.9",
            "2.13.4" to "4.5.9", "2.12.4" to "4.1.9", "2.12.7" to "4.2.3", "2.11.10" to "4.1.9", "2.12.16" to "4.5.9",
            "semanticdb-javac" to "0.8.0",
            "2.13.8" to "4.5.9", "2.12.11" to "4.5.9", "2.11.11" to "4.1.9", "2.12.10" to "4.5.9",
            "2.13.5" to "4.5.9", "2.12.15" to "4.5.9", "2.12.3" to "2.1.3", "2.13.2" to "4.5.9",
            "2.11.9" to "4.1.9", "2.12.6" to "4.1.9", "2.12.5" to "4.1.9", "2.13.1" to "4.5.9",
            "2.13.0" to "4.5.9", "2.11.12" to "4.5.9", "2.12.14" to "4.5.9", "2.13.0-RC1" to "4.1.11",
            "2.12.13" to "4.5.9", "2.13.3" to "4.5.9", "2.13.6" to "4.5.9", "2.12.9" to "4.5.9", "2.12.8" to "4.5.9"
    )

    val javacModuleExports = arrayOf(
            "--add-exports",
            "jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
            "--add-exports",
            "jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED",
            "--add-exports",
            "jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
            "--add-exports",
            "jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
            "--add-exports",
            "jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED"
    )

}
