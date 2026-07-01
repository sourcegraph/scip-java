package org.scip_code.scip_java.buildlogic

import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.file.Directory
import org.gradle.api.provider.Provider

/**
 * Declares a resolvable [Configuration] consuming the [configuration] artifact published by the
 * project at [producerPath]. The returned `FileCollection` resolves to that project's output and
 * carries the task dependency that builds it, so consumers avoid `evaluationDependsOn` and reaching
 * across project boundaries, keeping evaluation order and the configuration cache intact.
 */
fun Project.projectArtifact(
    producerPath: String,
    configuration: String,
    name: String,
): Configuration {
    val bucket = configurations.dependencyScope("${name}Classpath")
    dependencies.add(
        bucket.name,
        dependencies.project(mapOf("path" to producerPath, "configuration" to configuration)),
    )
    return configurations.resolvable(name) { extendsFrom(bucket.get()) }.get()
}

/**
 * Resolvable view of another project's shaded jar (the `scip.shadow-producer` convention plugin).
 */
fun Project.shadowJarArtifact(producerPath: String, name: String): Configuration =
    projectArtifact(producerPath, "shadowJarElements", name)

/**
 * Publishes [directory] (produced by [producedBy]) as a consumable artifact in a [name]
 * configuration, so a sibling project can resolve it with [projectArtifact].
 */
fun Project.publishDirectoryArtifact(
    name: String,
    directory: Provider<Directory>,
    producedBy: Any,
) {
    val elements = configurations.consumable(name).get()
    artifacts.add(elements.name, directory) { builtBy(producedBy) }
}
