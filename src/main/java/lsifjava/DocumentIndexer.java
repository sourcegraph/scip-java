package lsifjava;

import com.sun.source.tree.*;
import com.sun.source.util.JavacTask;
import com.sun.tools.javac.api.JavacTool;
import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.file.JavacFileManager;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.code.Type;
import com.sun.source.util.TreePath;
import com.sun.source.util.Trees;
import com.sun.source.util.TreePathScanner;
import com.sun.tools.javac.util.Context;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.Position;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

import com.sun.tools.javac.main.JavaCompiler;

import javax.lang.model.element.Element;
import javax.tools.JavaFileManager;
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

    private JavacTask task;
    private static final JavacTool systemProvider = JavacTool.create();
    private CompilationUnitTree compUnit;
    private SourceFileManager fileManager;
    private Context context;

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

    public void preIndex(SourceFileManager fileManager, Context context) throws IOException {
        this.fileManager = fileManager;
        this.context = context;

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
        var context = new Context();
        //var fileManager = new JavacFileManager(context, true, Charset.defaultCharset());
        var fileManager = new SourceFileManager(indexers.keySet(), context);
        //JavacTrees.instance(context);
        var compiler = JavaCompiler.instance(context);
        compiler.genEndPos = true;
        compiler.lineDebugInfo = true;
        compiler.keepComments = true;

        task = systemProvider.getTask(
                null, fileManager, null, null,  List.of(), List.of(new SourceFileObject(path)), context
        );
        var compUnit = task.parse().iterator().next();
        for(var element : task.analyze()) {}

        System.out.println("analyzed and parsed " + path);
        
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
        public Void visitMethod(MethodTree node, Void p) {
            var methodDecl = (JCTree.JCMethodDecl) getCurrentPath().getLeaf();

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

            var range = location(task, getCurrentPath(), methodName).getRange();
            emitDefinition(
                range,
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
            var packagePrefix = "";
            if (getCurrentPath().getCompilationUnit().getPackageName() != null) {
                packagePrefix = getCurrentPath().getCompilationUnit().getPackageName() + ".";
            }

            // gets the range of the def ident
            var range = location(task, getCurrentPath(), classDecl.getSimpleName().toString()).getRange();
            emitDefinition(
                range,
                classDecl.getModifiers().toString() + "class " + packagePrefix + classDecl.getSimpleName()
            );

            return super.visitClass(node, p);
        }

        @Override
        public Void visitVariable(VariableTree node, Void p) {
            var path = getCurrentPath();
            var varExpr = (JCTree.JCVariableDecl) path.getLeaf();

            // emit def for var
            var defRange = location(task, path, varExpr.name.toString()).getRange();

            emitDefinition(defRange, varExpr.toString());

            // emit use for type
            // TODO(noahsc): handle generic types
            var name = "";
            Range refRange = null;
            Range useRange = null;
            if(varExpr.type instanceof Type.ClassType type) {
                //var range = location(task, new TreePath(getCurrentPath(), varExpr.getType()), ((JCTree.JCFieldAccess) varExpr.vartype).name.toString());
                if(type.tsym instanceof Symbol.ClassSymbol clazz) {
                    name = clazz.name.toString();
                    var identPath = new TreePath(
                            getCurrentPath(), varExpr.getType()
                    );
                    var identElement = trees.getElement(identPath);

                    var defContainer = LanguageUtils.getTopLevelClass(identElement);
                    if(defContainer == null) return super.visitVariable(node, p);

                    useRange = location(task, identPath, name).getRange();

                    var location = findDefinition(task, defContainer);
                    if(location == null) return super.visitVariable(node, p);
                    refRange = location.getRange();
                }
            }

            if(refRange == null || useRange == null) return super.visitVariable(node, p);

            emitUse(
                    useRange,
                    refRange,
                    Paths.get(getCurrentPath().getCompilationUnit().getSourceFile().toUri())
            );


            return super.visitVariable(node, p);
        }

        @Override
        public Void visitNewClass(NewClassTree node, Void p) {
            var path = getCurrentPath();
            var newClassExpr = (JCTree.JCNewClass) path.getLeaf();

            var ident = (JCTree.JCIdent)newClassExpr.getIdentifier();
            var identPath = new TreePath(getCurrentPath(), newClassExpr.getIdentifier());
            var identElement = newClassExpr.constructor; //trees.getElement(identPath);

            /*var defContainer = LanguageUtils.getTopLevelClass(identElement);
            if(defContainer == null) return super.visitNewClass(node, p);*/
            
            var range = location(task, identPath, ident.name.toString()).getRange();

            // first search for constructor
            var location = findDefinition(task, identElement);
            if(location == null) {
                // fallback to class def
                location = findDefinition(task, trees.getElement(identPath));
                if(location == null) return super.visitNewClass(node, p);
            }

            emitUse(
                    range,
                    location.getRange(),
                    Paths.get(getCurrentPath().getCompilationUnit().getSourceFile().toUri())
            );

            return super.visitNewClass(node, p);
        }

        // from https://github.com/georgewfraser/java-language-server/blob/3555762fa35ab99575130911b3c930cc4d2d7b26/src/main/java/org/javacs/FindHelper.java
        private Location findDefinition(JavacTask task, Element element) {
            var trees = Trees.instance(task);
            var path = trees.getPath(element);
            if (path == null) return null;
            var name = element.getSimpleName();
            if (name.contentEquals("<init>")) name = element.getEnclosingElement().getSimpleName();
            return location(task, path, name);
        }

        public Location location(JavacTask task, TreePath path, CharSequence name) {
            var lines = path.getCompilationUnit().getLineMap();
            var pos = Trees.instance(task).getSourcePositions();
            var start = (int) pos.getStartPosition(path.getCompilationUnit(), path.getLeaf());
            var end = (int) pos.getEndPosition(path.getCompilationUnit(), path.getLeaf());
            if(end == -1) return null;
            if(name.length() > 0) {
                start = findNameIn(path.getCompilationUnit(), name, start, end);
                end = start + name.length();
            }
            var startLine = (int) lines.getLineNumber(start);
            var startColumn = (int) lines.getColumnNumber(start);
            var startPos = new Position(startLine - 1, startColumn - 1);
            var endLine = (int) lines.getLineNumber(end);
            var endColumn = (int) lines.getColumnNumber(end);
            var endPos = new Position(endLine - 1, endColumn - 1);
            var range = new Range(startPos, endPos);
            var uri = path.getCompilationUnit().getSourceFile().toUri();
            return new Location(uri.toString(), range);
        }

        public int findNameIn(CompilationUnitTree root, CharSequence name, int start, int end) {
            CharSequence contents;
            try {
                contents = root.getSourceFile().getCharContent(true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            var matcher = Pattern.compile("\\b" + name + "\\b").matcher(contents);
            matcher.region(start, end);
            if (matcher.find()) {
                return matcher.start();
            }
            return -1;
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
        return Util.mapOf("line", position.getLine(), "character", position.getCharacter());
    }
}
