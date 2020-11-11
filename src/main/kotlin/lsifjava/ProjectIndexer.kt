package lsifjava

internal class IndexingException(path: String, cause: Throwable): Throwable("failed to index $path", cause)

class ProjectIndexer(private val arguments: Arguments, private val emitter: Emitter) {
    var numFiles = 0
    var numDefinitions = 0
    var numJavacErrors = 0
    
    fun index() {
        emitter.emitVertex("metaData", mapOf(
            "version" to "0.4.0",
            "positionEncoding" to "utf-16",
            "projectRoot" to "file://${arguments.projectRoot}",
            "toolInfo" to mapOf("name" to "lsif-java", "version" to "0.7.0")
        ))

        val projectId = emitter.emitVertex("project", mapOf(
            "kind" to "java"
        ))

        createJavacDiagnosticListener(arguments.javacOutWriter).use { javacDiagListener ->
            val indexers = GradleInterface(arguments.projectRoot).use {
                buildIndexerMap(it, emitter, arguments.verbose, javacDiagListener)
            }

            val fileManager = SourceFileManager(indexers.keys)

            // can we do this earlier???
            for (indexer in indexers.values) {
                indexer.fileManager = fileManager
            }

            for (indexer in indexers.values) {
                try {
                    indexer.index()
                } catch(e: IndexingException) {
                    println(e)
                }
            }

            for (indexer in indexers.values) {
                indexer.postIndex(projectId)
            }

            for (indexer in indexers.values) {
                numFiles++
                numDefinitions += indexer.numDefinitions
            }

            numJavacErrors = javacDiagListener.count
        }
    }
}