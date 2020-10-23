package lsifjava

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class ProjectIndexer(private val arguments: Arguments, private val emitter: Emitter) {
    var numFiles = 0
    var numDefinitions = 0
    fun index() {
        emitter.emitVertex("metaData", mapOf(
            "version" to "0.4.0",
            "positionEncoding" to "utf-16",
            "projectRoot" to String.format("file://%s", Paths.get(arguments.projectRoot).toFile().canonicalPath),
            "toolInfo" to mapOf("name" to "lsif-java", "version" to "0.1.0")
        ))

        val projectId = emitter.emitVertex("project", mapOf(
            "kind" to "java"
        ))

        val indexers = HashMap<Path, DocumentIndexer>()
        val collector = FileCollector(projectId, arguments, emitter, indexers)
        GradleInterface(arguments.projectRoot).use { gradleInterface ->
            val classpaths = gradleInterface.getClasspaths()
            gradleInterface.getSourceDirectories().forEachIndexed { i, paths ->
                collector.classpath = classpaths[i]
                paths.forEach {
                    if (Files.notExists(it)) return@forEach
                    Files.walkFileTree(it, collector)
                }
            }
        }

        val fileManager = SourceFileManager(indexers.keys)

        for (indexer in indexers.values) {
            indexer.preIndex(fileManager)
        }
        for (indexer in indexers.values) {
            indexer.index()
        }

        for (indexer in indexers.values) {
            indexer.postIndex()
        }

        for (indexer in indexers.values) {
            numFiles++
            numDefinitions += indexer.numDefinitions()
        }
    }
}


