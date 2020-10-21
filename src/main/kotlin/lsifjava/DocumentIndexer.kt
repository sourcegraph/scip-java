@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")
package lsifjava

import com.sun.source.tree.CompilationUnitTree
import com.sun.source.util.JavacTask
import com.sun.tools.javac.api.JavacTool
import com.sun.tools.javac.main.JavaCompiler
import com.sun.tools.javac.util.Context
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import java.io.OutputStreamWriter
import java.nio.file.Path
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class DocumentIndexer(
    private val projectRoot: String,
    private val verbose: Boolean,
    private val path: Path,
    private val projectId: String,
    private val emitter: Emitter,
    private val indexers: Map<Path, DocumentIndexer>
) {
    companion object {
        private val systemProvider = JavacTool.create()
    }
    
    data class DefinitionMeta(val rangeId: String, val resultSetId: String) {
        var definitionResultId: String? = null
        val referenceRangeIds = HashMap<String, MutableSet<String>>()
    }

    private lateinit var documentId: String
    private var indexed = false
    private val rangeIds: MutableSet<String> = HashSet()
    private val definitions: MutableMap<Range, DefinitionMeta> = HashMap()
    private lateinit var fileManager: SourceFileManager
    
    private val referencesBacklog: LinkedList<() -> Unit> = LinkedList()

    fun numDefinitions(): Int {
        return definitions.size
    }

    fun preIndex(fileManager: SourceFileManager) {
        this.fileManager = fileManager
        val args = mapOf(
            "languageId" to "java",
            "uri" to String.format("file://%s", path.toAbsolutePath().toString())
        )
        documentId = emitter.emitVertex("document", args)
    }

    @Synchronized
    fun index() {
        if (indexed) return
        indexed = true
        
        val (task, compUnit) = analyzeFile()
        IndexingVisitor(task, compUnit, this, indexers).scan(compUnit, null)
        referencesBacklog.forEach { it() }
    }

    private fun analyzeFile(): Pair<JavacTask, CompilationUnitTree> {
        val context = SimpleContext()
        val task = systemProvider.getTask(
            OutputStreamWriter.nullWriter(), fileManager, null,
            listOf("--enable-preview", "-source", "15", "--add-exports",
                "jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
                "--add-exports",
                "jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED",
                "--add-exports",
                "jdk.compiler/com.sun.tools.javac.comp=ALL-UNNAMED",
                "--add-exports",
                "jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED",
                "--add-exports",
                "jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
                "--add-exports",
                "jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
                "--add-exports",
                "jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED",
                "--add-exports",
                "jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED"),
            listOf(), listOf(SourceFileObject(path)), context
        )
        val compUnit = task.parse().iterator().next()
        task.analyze()
        
        return Pair(task, compUnit)
    }

    internal class SimpleContext: Context() {
        init {
            put(JavaCompiler.compilerKey, SimpleCompiler.factory)
        }
    }

    internal class SimpleCompiler(context: Context?): JavaCompiler(context) {
        companion object {
            var factory = Context.Factory<JavaCompiler> { context: Context? -> SimpleCompiler(context) }
        }

        init {
            genEndPos = true
            lineDebugInfo = true
            keepComments = true
        }
    }

    fun postIndex() {
        for (meta in definitions.values)
            linkUses(meta, documentId)
        emitter.emitEdge("contains", mapOf("outV" to projectId, "inVs" to arrayOf(documentId)))
        emitter.emitEdge("contains", mapOf("outV" to documentId, "inVs" to rangeIds.stream().sorted().toArray()))
    }

    private fun linkUses(meta: DefinitionMeta, documentId: String) {
        val resultId = emitter.emitVertex("referenceResult", mapOf())
        emitter.emitEdge("textDocument/references", mapOf("outV" to meta.resultSetId, "inV" to resultId))
        emitter.emitEdge("item", mapOf(
            "property" to "definitions",
            "outV" to resultId,
            "inVs" to arrayOf(meta.rangeId),
            "document" to documentId
        ))
        for ((key, value) in meta.referenceRangeIds) {
            emitter.emitEdge("item", mapOf(
                "property" to "references",
                "outV" to resultId,
                "inVs" to value.stream().sorted().toArray(),
                "document" to key
            ))
        }
    }

    private fun emitDefinition(range: Range, hover: String) {
        if (verbose) println("DEF " + path.toString() + ":" + humanRange(range))
        val hoverId = emitter.emitVertex("hoverResult", mapOf(
            "result" to mapOf(
                "contents" to mapOf(
                    "kind" to "markdown",
                    "value" to hover
                )
            )
        ))
        val resultSetId = emitter.emitVertex("resultSet", mapOf())
        emitter.emitEdge("textDocument/hover", mapOf("outV" to resultSetId, "inV" to hoverId))
        val rangeId = emitter.emitVertex("range", createRange(range))
        emitter.emitEdge("next", mapOf("outV" to rangeId, "inV" to resultSetId))
        rangeIds.add(rangeId)
        definitions[range] = DefinitionMeta(rangeId, resultSetId) // + contents?
    }

    internal fun emitDefinition(range: Range, signature: String, doc: String? = null) {
        val hover = mkDoc(signature, doc)
        emitDefinition(range, hover)
    }

    internal fun emitUse(use: Range, def: Range, defPath: Path) {
        referencesBacklog.add {
            val indexer = indexers[defPath]
            val link = path.toString() + ":" + humanRange(use) + " -> " + defPath.toString() + ":" + humanRange(def)

            if (verbose) println("Linking use to definition: $link")

            val meta = indexer!!.definitions[def]
            if (meta == null) {
                if (verbose) println("WARNING missing definition for: $link")
                return@add
            }

            val rangeId = emitter.emitVertex("range", createRange(use))
            emitter.emitEdge("next", mapOf("outV" to rangeId, "inV" to meta.resultSetId))

            if (meta.definitionResultId == null) {
                val resultId = emitter.emitVertex("definitionResult", mapOf())
                emitter.emitEdge("textDocument/definition", mapOf("outV" to meta.resultSetId, "inV" to resultId))
                meta.definitionResultId = resultId
            }

            emitter.emitEdge("item", mapOf(
                "outV" to meta.definitionResultId!!,
                "inVs" to arrayOf(meta.rangeId),
                "document" to indexer.documentId
            ))
            rangeIds.add(rangeId)
            meta.referenceRangeIds.getOrDefault(documentId, HashSet()).let {
                it.add(rangeId)
                meta.referenceRangeIds[documentId] = it
            }
        }
    }
    
    private fun mkDoc(signature: String, docComment: String?): String {
        return """
            ```java
            $signature
            ```""".trimIndent() +
            if (docComment == null || docComment == "") "" else
                "\n---\n${docComment.trim()}"
    }

    /**
     * Returns the stringified range with the lines+1 to make clicking the links in your editor's terminal
     * direct to the correct line
     */
    private fun humanRange(r: Range): String {
        return (r.start.line+1).toString() + ":" + (r.start.character+1)+ "-" + (r.end.line+1) + ":" + (r.end.character+1)
    }

    private fun createRange(range: Range): Map<String, Any> {
        return mapOf("start" to createPosition(range.start), "end" to createPosition(range.end))
    }

    private fun createPosition(position: Position): Map<String, Any> {
        return mapOf("line" to position.line, "character" to position.character)
    }
}