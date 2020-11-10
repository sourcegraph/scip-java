@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")
package lsifjava

import com.sun.source.tree.CompilationUnitTree
import com.sun.source.util.JavacTask
import com.sun.tools.javac.api.JavacTool
import com.sun.tools.javac.main.JavaCompiler
import com.sun.tools.javac.util.Context
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import java.nio.file.Path
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class DocumentIndexer(
    private val filepath: CanonicalPath,
    private val classpath: Classpath,
    private val sourcespaths: List<Path>,
    private val javaSourceVersion: String,
    private val indexers: Map<Path, DocumentIndexer>,
    private val emitter: Emitter,
    private val diagnosticListener: CountingDiagnosticListener,
    private val verbose: Boolean,
) {
    companion object {
        private val systemProvider by lazy { JavacTool.create() }
    }
    
    data class DefinitionMeta(val definitionRangeId: String, val resultSetId: String) {
        var definitionResultId: String? = null
        val referenceRangeIds: MutableMap<String, MutableSet<String>> = HashMap()
    }

    data class ExternalDefinitionMeta(val resultSetId: String) {
        val referenceRangeIds: MutableMap<String, MutableSet<String>> = HashMap()
    }

    private var documentId: String = emitter.emitVertex("document", mapOf(
        "languageId" to "java",
        "uri" to "file://$filepath"
    ))
    private val rangeIds: MutableSet<String> = HashSet()
    private val definitions: MutableMap<Range, DefinitionMeta> = HashMap()

    val numDefinitions get() = definitions.size

    lateinit var fileManager: SourceFileManager

    private val referencesBacklog: LinkedList<() -> Unit> = LinkedList()

    private var indexed = AtomicBoolean(false)

    fun index() {
        if(!indexed.compareAndSet(false, true)) return
        val (task, compUnit) = analyzeFile()
        IndexingVisitor(task, systemProvider, sourcespaths, compUnit, this, indexers).scan(compUnit, null)
        referencesBacklog.forEach { it() }

        println("finished analyzing and visiting $filepath")
    }

    private fun analyzeFile(): Pair<JavacTask, CompilationUnitTree> {
        val context = SimpleContext()

        val task = systemProvider.getTask(
            NoopWriter, fileManager, diagnosticListener,
            listOf("-proc:none", "-nowarn", "-source", javaSourceVersion, "-classpath", classpath.toString() /*, "--enable-preview" */),
            listOf(), listOf(SourceFileObject(filepath.path)), context
        )
        val compUnit = task.parse().iterator().next()
        task.analyze()
        
        return Pair(task, compUnit)
    }

    internal class SimpleContext: Context() {
        init {
            put(SimpleCompiler.contextKey, SimpleCompiler.factory)
        }
    }

    internal class SimpleCompiler(context: Context?): JavaCompiler(context) {
        companion object {
            val factory = Context.Factory<JavaCompiler> { context: Context? -> SimpleCompiler(context) }
            val contextKey: Context.Key<JavaCompiler> by lazy {
                if(javaVersion == 8) run {
                    val field = SimpleCompiler::class.java.superclass.getDeclaredField("compilerKey")
                    field.isAccessible = true
                    val key: Context.Key<JavaCompiler> = Context.Key() // dummy value to be overwritten
                    return@lazy field.get(key) as Context.Key<JavaCompiler>
                }
                compilerKey  
            }
        }

        init {
            genEndPos = true
            lineDebugInfo = true
            keepComments = true
        }
    }

    fun postIndex(projectId: String) {
        for (meta in definitions.values)
            linkUses(meta)
        emitter.emitEdge("contains", mapOf("outV" to projectId, "inVs" to arrayOf(documentId)))
        emitter.emitEdge("contains", mapOf("outV" to documentId, "inVs" to rangeIds.sorted().toList()))
    }

    private fun linkUses(meta: DefinitionMeta) {
        val resultId = emitter.emitVertex("referenceResult", mapOf())
        emitter.emitEdge("textDocument/references", mapOf("outV" to meta.resultSetId, "inV" to resultId))
        emitter.emitEdge("item", mapOf(
            "property" to "definitions",
            "outV" to resultId,
            "inVs" to arrayOf(meta.definitionRangeId),
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

    private fun linkUses(meta: ExternalDefinitionMeta) {
        val resultId = emitter.emitVertex("referenceResult", mapOf())
        emitter.emitEdge("textDocument/references", mapOf("outV" to meta.resultSetId, "inV" to resultId))
        for ((key, value) in meta.referenceRangeIds) {
            emitter.emitEdge("item", mapOf(
                "property" to "references",
                "outV" to resultId,
                "inVs" to value.stream().sorted().toArray(),
                "document" to key
            ))
        }
    }

    internal fun emitDefinition(range: Range, signature: String, doc: String? = null) {
        if (verbose) println("DEF ${filepath}:${humanRange(range)}")
        val hoverId = emitter.emitVertex("hoverResult", mapOf(
            "result" to mapOf(
                "contents" to mapOf(
                    "kind" to "markdown",
                    "value" to mkDoc(signature, doc)
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

    // TODO(nsc): GLOBAL CACHE SO WE DONT HAVE MULTIPLE REFS FOR SAME DEF
    internal fun emitExternalHoverAndUse(signature: String, doc: String, use: Range) {
        val hoverId = emitter.emitVertex("hoverResult", mapOf(
            "result" to mapOf(
                "contents" to mapOf(
                    "kind" to "markdown",
                    "value" to mkDoc(signature, doc)
                )
            )
        ))
        
        val resultSetId = emitter.emitVertex("resultSet", mapOf())
        emitter.emitEdge("textDocument/hover", mapOf("outV" to resultSetId, "inV" to hoverId))
        val rangeId = emitter.emitVertex("range", createRange(use))
        emitter.emitEdge("next", mapOf("outV" to rangeId, "inV" to resultSetId))
        rangeIds.add(rangeId)
        val meta = ExternalDefinitionMeta(resultSetId).apply {
            this.referenceRangeIds[documentId] = hashSetOf(rangeId)
        }
        linkUses(meta)
    }

    internal fun emitUse(use: Range, def: Range, defPath: Path) {
        referencesBacklog.add {
            val indexer = indexers[defPath] ?: error("expected indexer for $defPath")
            val link = "${filepath}:${humanRange(use)} -> ${defPath}:${humanRange(def)}"

            if (verbose) println("Linking use to definition: $link")

            val meta = indexer.definitions[def]
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
                "inVs" to arrayOf(meta.definitionRangeId),
                "document" to indexer.documentId
            ))
            rangeIds.add(rangeId)
            meta.referenceRangeIds.getOrDefault(documentId, HashSet()).apply {
                this.add(rangeId)
                // TODO(nsc) ~~figure it out~~ this links it back to the ref range. Why doc id?
                meta.referenceRangeIds[documentId] = this
            }
        }
    }
    
    private fun mkDoc(signature: String, docComment: String?) = 
        "```java\n$signature\n```" +
        if (docComment == null || docComment == "") "" 
        else "\n---\n${docComment.trim()}"

    /**
     * Returns the stringified range with the lines+1 to make clicking the links in your editor's terminal
     * direct to the correct line
     */
    private fun humanRange(r: Range): String {
        return "${r.start.line+1}:${r.start.character+1}-${r.end.line+1}:${r.end.character+1}"
    }

    private fun createRange(range: Range): Map<String, Any> {
        return mapOf("start" to createPosition(range.start), "end" to createPosition(range.end))
    }

    private fun createPosition(position: Position): Map<String, Any> {
        return mapOf("line" to position.line, "character" to position.character)
    }
}