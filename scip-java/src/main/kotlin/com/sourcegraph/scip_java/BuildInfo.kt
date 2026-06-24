package com.sourcegraph.scip_java

import java.util.Properties

/**
 * Build metadata for the scip-java CLI.
 *
 * The static [javacModuleOptions] live here directly; the build-time [version] is injected by
 * Gradle into the `scip-java.properties` classpath resource.
 */
object BuildInfo {

    /**
     * `--add-exports` flags required to access internal javac APIs from the SCIP compiler plugin.
     * Java 11+ is the supported baseline.
     *
     * Kept in sync with `javacModuleOptions` in build.gradle.kts, which applies the same flags when
     * compiling the plugin and the test fixtures.
     */
    val javacModuleOptions: List<String> =
        listOf(
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED",
        )

    /**
     * The scip-java release version. Read from the `scip-java.properties` resource that Gradle
     * generates into the jar. Falls back to a placeholder when running without the generated
     * resource on the classpath.
     */
    val version: String by lazy {
        val props = Properties()
        BuildInfo::class.java.getResourceAsStream("/scip-java.properties")?.use { props.load(it) }
        props.getProperty("version") ?: "0.0.0-SNAPSHOT"
    }
}
