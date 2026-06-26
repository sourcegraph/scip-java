package com.sourcegraph.buildlogic

import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration

/**
 * Declares a resolvable view of another project's shaded jar, published by its
 * `shadowJarElements` consumable configuration (the `scip.shadow-producer`
 * convention plugin).
 *
 * Returns a [Configuration] (a `FileCollection`) that resolves to the single
 * shaded jar and carries the task dependency on the producing `shadowJar`.
 * Sharing the artifact this way, instead of referencing the task across
 * projects, keeps project evaluation order and the configuration cache intact.
 */
fun Project.shadowJarArtifact(producerPath: String, name: String): Configuration {
    val bucket = configurations.dependencyScope("${name}Classpath")
    dependencies.add(
        bucket.name,
        dependencies.project(mapOf("path" to producerPath, "configuration" to "shadowJarElements")),
    )
    return configurations.resolvable(name) { extendsFrom(bucket.get()) }.get()
}
