package lsifjava;

import com.sun.source.util.JavacTask;
import com.sun.tools.javac.api.JavacTool;
import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.file.JavacFileManager;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.NewClassTree;
import com.sun.tools.javac.tree.JCTree;
import com.sun.source.tree.ClassTree;
import com.sun.source.tree.PackageTree;
import com.sun.source.util.TreePath;
import com.sun.source.util.Trees;
import com.sun.source.util.TreePathScanner;
import com.sun.tools.javac.util.Context;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.Position;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.*;

import com.sun.tools.javac.main.JavaCompiler;

import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.tools.JavaFileObject;

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

    private JavaCompiler compiler;
    private JavacTask task;
    private static final JavacTool systemProvider = JavacTool.create();
    private CompilationUnitTree compUnit;

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

    public void preIndex() throws IOException {
        var args = Util.mapOf(
            "languageId", "java",
            "uri", String.format("file://%s", path.toAbsolutePath().toString())
        );

        documentId = emitter.emitVertex("document", args);

        compUnit = analyzeFile();
    }

    public synchronized void index() {
        if(indexed) return;
        indexed = true;

        new IndexingVisitor(compUnit, Trees.instance(task)).scan(compUnit, null);
    }
    
    private CompilationUnitTree analyzeFile() throws IOException {
        JavaFileObject file = new SourceFileObject(path);
        var context = new Context();
        var fileManager = new JavacFileManager(context, true, Charset.defaultCharset());
        var trees = JavacTrees.instance(context);
        compiler = JavaCompiler.instance(context);
        compiler.genEndPos = true;
        compiler.keepComments = true;

        task = systemProvider.getTask(
                null, fileManager, null, null,  List.of(), List.of(file), context
        );
        var compUnit = task.parse().iterator().next();
        for(var element : task.analyze()) {
            /*if(LanguageUtils.isTopLevel(element.getKind())) {
                var typeName = ((TypeElement) element).getQualifiedName().toString();
            }*/
        }
        
        return compUnit;
    }

    public void postIndex() {
        for (var meta : definitions.values()) {
            linkUses(meta, documentId);
        }

        emitter.emitEdge("contains", Util.mapOf("outV", projectId, "inVs", new String[]{documentId}));
        emitter.emitEdge("contains", Util.mapOf("outV", documentId, "inVs", rangeIds.stream().sorted().toArray()));
    }

    public class IndexingVisitor extends TreePathScanner<Void, Void> {
        private final CompilationUnitTree unit;
        private final Trees trees;

        public IndexingVisitor(CompilationUnitTree unit, Trees trees) {
            this.unit = unit;
            this.trees = trees;
        }
        
        @Override
        public Void visitPackage(PackageTree node, Void p) {
            super.visitPackage(node, p);
            var path = getCurrentPath();
            return null;
        }

        @Override
        public Void visitMethod(MethodTree node, Void p) {
            var methodDecl = (JCTree.JCMethodDecl) getCurrentPath().getLeaf();
            var linemap = unit.getLineMap();

            var startLine = (int)linemap.getLineNumber(methodDecl.getStartPosition());
            var endLine = (int)linemap.getLineNumber(methodDecl.getEndPosition(null));
            var startCol = (int)linemap.getColumnNumber(methodDecl.getStartPosition());
            var endCol = (int)linemap.getColumnNumber(methodDecl.getEndPosition(null) + methodDecl.getName().length());

            // constructors not in code still exist in the AST. If they point to the "class " part
            // of the class declaration, ignore it
            try {
                if(compUnit.getSourceFile().getCharContent(true).subSequence(
                        methodDecl.getStartPosition(),
                        methodDecl.getEndPosition(null) + methodDecl.getName().length()
                ).equals("class ")) {
                    return null;
                }
            } catch(IOException e) {
                return null;
            }

            var methodName = methodDecl.getName().toString();
            if(methodName.equals("<init>")) {
                methodName = LanguageUtils.getTopLevelClass(trees.getElement(getCurrentPath())).getSimpleName().toString();
            }
            
            var returnType = "";
            if(methodDecl.getReturnType() != null) {
                returnType = methodDecl.getReturnType().toString() + " ";
            }

            emitDefinition(
                new Range(
                    new Position(startLine, startCol),
                    new Position(endLine, endCol)
                ),
                methodDecl.getModifiers().toString() +
                    returnType +
                    methodName + "(" +
                    methodDecl.params.toString() + ")"
            );

            return super.visitMethod(node, p);
        }

        @Override
        public Void visitClass(ClassTree node, Void p) {
            var path = getCurrentPath();
            var classDecl = (JCTree.JCClassDecl) path.getLeaf();
            var linemap = unit.getLineMap();
            var startLine = (int)linemap.getLineNumber(classDecl.getStartPosition());
            var endLine = (int)linemap.getLineNumber(classDecl.getEndPosition(null));
            var startCol = (int)linemap.getColumnNumber(classDecl.getStartPosition());
            var endCol = (int)linemap.getColumnNumber(classDecl.getEndPosition(null) + "class ".length() + classDecl.getSimpleName().length());

            var packagePrefix = "";
            if (getCurrentPath().getCompilationUnit().getPackageName() != null) {
                packagePrefix = getCurrentPath().getCompilationUnit().getPackageName() + ".";
            }

            emitDefinition(
                new Range(
                    new Position(startLine, startCol),
                    new Position(endLine, endCol)
                ),
                classDecl.getModifiers().toString() + "class " + packagePrefix + classDecl.getSimpleName()
            );

            return super.visitClass(node, p);
        }

        @Override
        public Void visitNewClass(NewClassTree node, Void p) {
            var path = getCurrentPath();
            var newClassExpr = (JCTree.JCNewClass) path.getLeaf();

            /*var hoverData = unit.accept(new ReferenceVisitor(trees, unit, newClassExpr.getStartPosition() + "new ".length()), null);//.scan(unit, (long) newClassExpr.getStartPosition() + 5);
            if(hoverData == null) return super.visitNewClass(node, p);

            var refElement = hoverData.getElement();
            var defContainer = LanguageUtils.getTopLevelClass(refElement);
            if(defContainer == null) return super.visitNewClass(node, p);

            var defName = LanguageUtils.getQualifiedName(defContainer);
            
            if(LanguageUtils.isTopLevel(defContainer.getKind())) {
                
            }*/

            return super.visitNewClass(node, p);
        }
    }

    private void linkUses(DefinitionMeta meta, String documentId) {
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

    private void emitDefinition(Range range, String doc) {
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

    private void emitUse(Range use, Range def, Path defPath) {
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
        return Util.mapOf("line", position.getLine() - 1, "character", position.getCharacter() - 1);
    }
}
