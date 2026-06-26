package com.sourcegraph.buildlogic

import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.file.FileSystemLocation
import org.gradle.api.provider.Provider

/**
 * Declares a resolvable view of another project's shaded jar, published by its `shadowJarElements`
 * consumable configuration (the `scip.shadow-producer` convention plugin).
 *
 * Returns a [Configuration] (a `FileCollection`) that resolves to the single shaded jar and carries
 * the task dependency on the producing `shadowJar`. Sharing the artifact this way, instead of
 * referencing the task across projects, keeps project evaluation order and the configuration cache
 * intact.
 */
fun Project.shadowJarArtifact(producerPath: String, name: String): Configuration {
    val bucket = configurations.dependencyScope("${name}Classpath")
    dependencies.add(
        bucket.name,
        dependencies.project(mapOf("path" to producerPath, "configuration" to "shadowJarElements")),
    )
    return configurations.resolvable(name) { extendsFrom(bucket.get()) }.get()
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
