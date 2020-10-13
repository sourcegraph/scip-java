package lsifjava;

import com.sun.source.tree.*;
import com.sun.source.util.JavacTask;
import com.sun.tools.javac.api.JavacTool;
import com.sun.tools.javac.util.Context;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.Position;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

import com.sun.tools.javac.main.JavaCompiler;

public class DocumentIndexer {
    private final String projectRoot;
    private final String projectId;
    private final Path path;
    
    private final Emitter emitter;
    private final Map<Path, DocumentIndexer> indexers;
    private final boolean verbose;
    
    private String documentId;

    private boolean indexed;
    private final Set<String> rangeIds = new HashSet<>();
    private final Map<Range, DefinitionMeta> definitions = new HashMap<>();

    private JavacTask task;
    private static final JavacTool systemProvider = JavacTool.create();
    private SourceFileManager fileManager;

    public DocumentIndexer(String projectRoot, boolean verbose, Path path, String projectId, Emitter emitter, Map<Path, DocumentIndexer> indexers) {
        this.projectRoot = projectRoot;
        this.verbose = verbose;
        this.path = path;
        this.projectId = projectId;
        this.emitter = emitter;
        this.indexers = indexers;
    }

    public int numDefinitions() {
        return definitions.size();
    }

    public void preIndex(SourceFileManager fileManager) {
        this.fileManager = fileManager;

        var args = Util.mapOf(
            "languageId", "java",
            "uri", String.format("file://%s", path.toAbsolutePath().toString())
        );

        documentId = emitter.emitVertex("document", args);
    }

    public synchronized void index() throws IOException {
        if(indexed) return;
        indexed = true;

        var compUnit = analyzeFile();

        new IndexingVisitor(task, compUnit, this, indexers).scan(compUnit, null);
    }
    
    private CompilationUnitTree analyzeFile() throws IOException {
        var context = new SimpleContext();

        task = systemProvider.getTask(
                null, fileManager, null, List.of("--enable-preview", "-source", "15", "--add-exports",
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
                        "jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED"),  List.of(), List.of(new SourceFileObject(path)), context
        );
        var compUnit = task.parse().iterator().next();
        for(var element : task.analyze()) {}

        System.out.println("analyzed and parsed " + path);

        return compUnit;
    }

    static class SimpleContext extends Context {
        SimpleContext() {
            super();
            put(JavaCompiler.compilerKey, SimpleCompiler.factory);
        }
    }

    static class SimpleCompiler extends JavaCompiler {
        public static Context.Factory<JavaCompiler> factory = SimpleCompiler::new;
        
        SimpleCompiler(Context context) {
            super(context);
            this.genEndPos = true;
            this.lineDebugInfo = true;
            this.keepComments = true;
        }
    }

    public void postIndex() {
        for (var meta : definitions.values()) {
            linkUses(meta, documentId);
        }

        emitter.emitEdge("contains", Util.mapOf("outV", projectId, "inVs", new String[]{documentId}));
        emitter.emitEdge("contains", Util.mapOf("outV", documentId, "inVs", rangeIds.stream().sorted().toArray()));
    }

    protected void linkUses(DefinitionMeta meta, String documentId) {
        var resultId = emitter.emitVertex("referenceResult", Util.mapOf());

        emitter.emitEdge("textDocument/references", Util.mapOf("outV", meta.resultSetId, "inV", resultId));
        emitter.emitEdge("item", Util.mapOf(
                "property", "definitions",
                "outV", resultId,
                "inVs", new String[]{meta.rangeId},
                "document", documentId
        ));

        for (var entry : meta.referenceRangeIds.entrySet()) {
            emitter.emitEdge("item", Util.mapOf(
                    "property", "references",
                    "outV", resultId,
                    "inVs", entry.getValue().stream().sorted().toArray(),
                    "document", entry.getKey()
            ));
        }
    }

    protected void emitDefinition(Range range, String doc) {
        if(verbose)
            System.out.println("DEF " + path.toString().replaceFirst("^"+projectRoot, ".") + ":" + humanRange(range));

        var hoverId = emitter.emitVertex("hoverResult", Util.mapOf(
                "result", Util.mapOf(
                        "contents", Util.mapOf(
                                "kind", "markdown",
                                "value", doc
                        )
                )
        ));

        var resultSetId = emitter.emitVertex("resultSet", Util.mapOf());
        emitter.emitEdge("textDocument/hover", Util.mapOf("outV", resultSetId, "inV", hoverId));
        var rangeId = emitter.emitVertex("range", createRange(range));
        emitter.emitEdge("next", Util.mapOf("outV", rangeId, "inV", resultSetId));

        rangeIds.add(rangeId);
        definitions.put(range, new DefinitionMeta(rangeId, resultSetId)); // + contents?
    }

    protected void emitUse(Range use, Range def, Path defPath) {
        var indexer = indexers.get(defPath);

        var link = path.toString().replaceFirst("^"+projectRoot, ".") + ":" + humanRange(use) + " -> " + defPath.toString().replaceFirst("^"+projectRoot, ".") + ":" + humanRange(def);
            
        if(verbose)
            System.out.println("Linking use to definition: " + link);

        var meta = indexer.definitions.get(def);
        if (meta == null) {
            if(verbose)
                System.out.println("WARNING Skipping linking use to definition: " + link);
            return;
        }

        var rangeId = emitter.emitVertex("range", createRange(use));
        emitter.emitEdge("next", Util.mapOf("outV", rangeId, "inV", meta.resultSetId));

        if (meta.definitionResultId == null) {
            var resultId = emitter.emitVertex("definitionResult", Util.mapOf());
            emitter.emitEdge("textDocument/definition", Util.mapOf("outV", meta.resultSetId, "inV", resultId));
            meta.definitionResultId = resultId;
        }

        emitter.emitEdge("item", Util.mapOf(
                "outV", meta.definitionResultId,
                "inVs", new String[]{meta.rangeId},
                "document", indexer.documentId
        ));

        rangeIds.add(rangeId);

        var set = meta.referenceRangeIds.getOrDefault(documentId, new HashSet<>());
        set.add(rangeId);
        meta.referenceRangeIds.put(documentId, set);
    }

    private Range nameRange(Range a, String name) {
        return new Range(
                new Position(
                    a.getStart().getLine(),
                    a.getStart().getCharacter()
                ),
                new Position(
                    a.getEnd().getLine(),
                    a.getEnd().getCharacter() + name.length()
                )
        );
    }

    private String humanRange(Range r) {
        return r.getStart().getLine() + ":" + r.getStart().getCharacter() + "-" + r.getEnd().getLine() + ":" + r.getEnd().getCharacter();
    }

    private Map<String, Object> createRange(Range range) {
        return Util.mapOf("start", createPosition(range.getStart()), "end", createPosition(range.getEnd()));
    }

    private Map<String, Object> createPosition(Position position) {
        return Util.mapOf("line", position.getLine(), "character", position.getCharacter());
    }
}
