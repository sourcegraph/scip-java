package org.scip_code.scip_java.buildlogic

import java.io.File
import org.gradle.api.Task
import org.gradle.api.artifacts.Configuration
import org.gradle.api.file.Directory
import org.gradle.api.file.FileSystemLocation
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.compile.JavaCompile

/**
 * Wires this [JavaCompile] task to run the scip-javac compiler plugin: puts the shaded plugin jar
 * [javacShadowJar] on the compile classpath and forks javac with the internal-API flags from
 * gradle/javac-internals.properties, recording [targetroot] as an output directory.
 *
 * Callers still add the case-specific `-Xplugin:scip ...` arguments and annotation processors.
 */
fun JavaCompile.useScipJavac(
    rootDir: File,
    javacShadowJar: Configuration,
    targetroot: Provider<Directory>,
) {
    classpath = classpath.plus(javacShadowJar)
    outputs.dir(targetroot)
    options.isFork = true
    options.forkOptions.jvmArgs =
        (options.forkOptions.jvmArgs ?: emptyList()) + JavacInternals.jvmOptions(rootDir)
}

/**
 * Builds the `kotlinc` arguments that load the scip-kotlinc compiler plugin from [pluginClasspath]
 * (the resolved shaded jar) and point it at [sourceroot]/[targetroot].
 *
 * The mapping lives here, in compiled build logic, rather than in a build script: a `.map {}`
 * lambda declared in a `.gradle.kts` file captures a hidden reference to the script object, which
 * the configuration cache cannot serialize.
 */
fun scipKotlincPluginArgs(
    pluginClasspath: Provider<Set<FileSystemLocation>>,
    sourceroot: String,
    targetroot: String,
): Provider<List<String>> =
    pluginClasspath.map { locations ->
        listOf(
            "-Xplugin=${locations.single().asFile.absolutePath}",
            "-P",
            "plugin:scip-kotlinc:sourceroot=$sourceroot",
            "-P",
            "plugin:scip-kotlinc:targetroot=$targetroot",
        )
    }

/**
 * Registers a `doFirst` action that empties [dir] (deletes then recreates it) before the task runs.
 *
 * The action lives here, in compiled build logic, rather than in a `.gradle.kts` script: a lambda
 * declared in a build script captures a hidden reference to the script object, which the
 * configuration cache cannot serialize.
 */
fun Task.cleanDirectoryBeforeRunning(dir: Provider<Directory>) {
    doFirst {
        val file = dir.get().asFile
        file.deleteRecursively()
        file.mkdirs()
    }
}
