import com.github.javaparser.Position;
import com.github.javaparser.Range;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithSimpleName;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.resolution.declarations.ResolvedDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserMethodDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserVariableDeclaration;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DocumentIndexer {
    private String projectRoot;
    private boolean noContents;
    private String pathname;
    private String projectId;
    private Emitter emitter;
    private Map<String, DocumentIndexer> indexers;
    private String documentId;
    private boolean indexed = false;
    private Set<String> rangeIds = new HashSet<>();
    private Map<Range, DefinitionMeta> definitions = new HashMap<>();

    public DocumentIndexer(
            String projectRoot,
            boolean noContents,
            String pathname,
            String projectId,
            Emitter emitter,
            Map<String, DocumentIndexer> indexers
    ) {
        this.projectRoot = projectRoot;
        this.noContents = noContents;
        this.pathname = pathname;
        this.projectId = projectId;
        this.emitter = emitter;
        this.indexers = indexers;
    }

    public int numDefinitions() {
        return definitions.size();
    }

    public void index() {
        if (indexed) {
            return;
        }

        doIndex();
        indexed = true;
    }

    private void doIndex() {
        JavaSymbolSolver symbolSolver = getSymbolSolver();
        StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);
        CompilationUnit cu = parse();

        Map<String, Object> args = Map.of(
                "languageId", "java",
                "uri", String.format("file://%s", Paths.get(pathname).toAbsolutePath().toString())
        );

        if (!noContents) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(pathname), StandardCharsets.UTF_8);
                args = Util.union(args, Map.of("contents", String.join("\n", lines)));
            } catch (IOException ex) {
                throw new RuntimeException(String.format("Failed to read file %s", pathname));
            }
        }

        this.documentId = emitter.emitVertex("document", args);
        cu.accept(new LSIFVisitor(symbolSolver), null);
    }

    public void postIndex() {
        for (DefinitionMeta meta : definitions.values()) {
            linkUses(meta, documentId);
        }

        emitter.emitEdge("contains", Map.of("outV", projectId, "inVs", new String[]{documentId}));
        emitter.emitEdge("contains", Map.of("outV", documentId, "inVs", rangeIds.stream().sorted().toArray()));
    }

    private JavaSymbolSolver getSymbolSolver() {
        return new JavaSymbolSolver(getTypeSolver());
    }

    private TypeSolver getTypeSolver() {
        CombinedTypeSolver typeSolver = new CombinedTypeSolver();
        typeSolver.add(new JavaParserTypeSolver(projectRoot));
        typeSolver.add(new ReflectionTypeSolver());
        return typeSolver;
    }

    private CompilationUnit parse() {
        try {
            return StaticJavaParser.parse(new File(pathname));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(String.format("Failed to parse %s", pathname));
        }
    }

    private void linkUses(DefinitionMeta meta, String documentId) {
        String resultId = emitter.emitVertex("referenceResult", Map.of());

        emitter.emitEdge("textDocument/references", Map.of("outV", meta.resultSetId, "inV", resultId));
        emitter.emitEdge("item", Map.of(
                "property", "definitions",
                "outV", resultId,
                "inVs", new String[]{meta.rangeId},
                "document", documentId
        ));

        for (Map.Entry<String, Set<String>> entry : meta.referenceRangeIds.entrySet()) {
            emitter.emitEdge("item", Map.of(
                    "property", "references",
                    "outV", resultId,
                    "inVs", entry.getValue().stream().sorted().toArray(),
                    "document", entry.getKey()
            ));
        }
    }

    private class LSIFVisitor extends VoidVisitorAdapter<Void> {
        private JavaSymbolSolver symbolSolver;

        public LSIFVisitor(JavaSymbolSolver symbolSolver) {
            this.symbolSolver = symbolSolver;
        }

        @Override
        public void visit(final MethodCallExpr n, final Void arg) {
            super.visit(n, arg);
            emitUse(n, ResolvedMethodDeclaration.class);
        }

        @Override
        public void visit(final VariableDeclarationExpr n, final Void arg) {
            super.visit(n, arg);
            emitDefinition(n);
        }

        @Override
        public void visit(final MethodDeclaration n, final Void arg) {
            super.visit(n, arg);
            emitDefinition(n);
        }

        @Override
        public void visit(final NameExpr n, final Void arg) {
            super.visit(n, arg);
            emitUse(n, ResolvedValueDeclaration.class);
        }

        @Override
        public void visit(final Parameter n, final Void arg) {
            super.visit(n, arg);
            emitDefinition(n);
        }

        private void emitDefinition(Node n) {
            Optional<Range> rangeContainer = getRange(n);
            if (!rangeContainer.isPresent()) {
                throw new RuntimeException("Unexpected range-less AST node: " + n.toString());
            }

            Range range = rangeContainer.get();
            if (definitions.containsKey(range)) {
                return;
            }

            String hoverId = emitter.emitVertex("hoverResult", Map.of(
                    "result", Map.of(
                            "contents", Map.of(
                                    "language", "java",
                                    "value", n.toString()
                            )
                    )
            ));

            String resultSetId = emitter.emitVertex("resultSet", Map.of());
            emitter.emitEdge("textDocument/hover", Map.of("outV", resultSetId, "inV", hoverId));
            String rangeId = emitter.emitVertex("range", createRange(range));
            emitter.emitEdge("next", Map.of("outV", rangeId, "inV", resultSetId));

            rangeIds.add(rangeId);
            definitions.put(range, new DefinitionMeta(rangeId, resultSetId)); // + contents?
        }

        private <T extends ResolvedDeclaration> void emitUse(Node n, Class<T> cls) {
            T definition;
            try {
                definition = symbolSolver.resolveDeclaration(n, cls);
            } catch (RuntimeException ex) {
                // ignore
                return;
            }

            Node definitionNode = getNode(definition);
            if (definitionNode == null) {
                return;
            }

            String definitionPath = definitionNode.findCompilationUnit()
                    .flatMap(cu -> cu.getStorage())
                    .map(s -> s.getPath().toString())
                    .orElse("");

            if (definitionPath.equals(pathname)) {
                emitDefinition(definitionNode);
                emitUse(n, definitionNode);
            } else {
                indexers.get(definitionPath).index();
                emitUse(n, definitionNode, definitionPath);
            }
        }

        private Node getNode(ResolvedDeclaration def) {
            return
//                    JavaParserClassDeclaration.class.isInstance(def) ? JavaParserClassDeclaration.class.cast(def).getWrappedNode()
//                    : JavaParserConstructorDeclaration.class.isInstance(def) ? JavaParserConstructorDeclaration.class.cast(def).getWrappedNode()
//                    : JavaParserEnumConstantDeclaration.class.isInstance(def) ? JavaParserEnumConstantDeclaration.class.cast(def).getWrappedNode()
//                    : JavaParserEnumDeclaration.class.isInstance(def) ? JavaParserEnumDeclaration.class.cast(def).getWrappedNode()
//                    : JavaParserFieldDeclaration.class.isInstance(def) ? JavaParserFieldDeclaration.class.cast(def).getWrappedNode()
//                    : JavaParserInterfaceDeclaration.class.isInstance(def) ? JavaParserInterfaceDeclaration.class.cast(def).getWrappedNode()
                    JavaParserMethodDeclaration.class.isInstance(def) ? JavaParserMethodDeclaration.class.cast(def).getWrappedNode()
//                    : JavaParserParameterDeclaration.class.isInstance(def) ? JavaParserParameterDeclaration.class.cast(def).getWrappedNode()
//                    : JavaParserTypeVariableDeclaration.class.isInstance(def) ? JavaParserTypeVariableDeclaration.class.cast(def).getWrappedNode()
                            : JavaParserVariableDeclaration.class.isInstance(def) ? JavaParserVariableDeclaration.class.cast(def).getWrappedNode()
                            : null;
        }

        private void emitUse(Node n, Node definition) {
            emitUse(n, definition, pathname);
        }

        private void emitUse(Node n, Node definition, String definitionPath) {
            DocumentIndexer indexer = indexers.get(definitionPath);

            Optional<Range> rangeContainer = getRange(n);
            Optional<Range> definitionRangeContainer = getRange(definition);

            if (!rangeContainer.isPresent()) {
                throw new RuntimeException("Unexpected range-less AST node: " + n.toString());
            }

            if (!definitionRangeContainer.isPresent()) {
                throw new RuntimeException("Unexpected range-less AST node: " + definition.toString());
            }

            Range range = rangeContainer.get();
            Range definitionRange = definitionRangeContainer.get();
            DefinitionMeta meta = indexer.definitions.get(definitionRange);

            String rangeId = emitter.emitVertex("range", createRange(range));
            emitter.emitEdge("next", Map.of("outV", rangeId, "inV", meta.resultSetId));

            if (meta.definitionResultId == null) {
                String resultId = emitter.emitVertex("definitionResult", Map.of());
                emitter.emitEdge("textDocument/definition", Map.of("outV", meta.resultSetId, "inV", resultId));
                meta.definitionResultId = resultId;
            }

            emitter.emitEdge("item", Map.of(
                    "outV", meta.definitionResultId,
                    "inVs", new String[]{meta.rangeId},
                    "document", indexer.documentId
            ));

            rangeIds.add(rangeId);

            Set<String> set = meta.referenceRangeIds.getOrDefault(documentId, new HashSet<>());
            set.add(rangeId);
            meta.referenceRangeIds.put(documentId, set);
        }

        private Optional<Range> getRange(Node decl) {
            if (decl.getClass().isAssignableFrom(VariableDeclarationExpr.class)) {
                // Unwrap variable declarations
                decl = ((VariableDeclarationExpr) decl).getVariables().get(0);
            }

            try {
                // Extract only the name portion of the AST node
                return ((NodeWithSimpleName) decl).getName().getRange();
            } catch (ClassCastException ex) {
                // ignore
            }

            return decl.getRange();
        }


        private Map<String, Object> createRange(Range range) {
            return Map.of("start", createPosition(range.begin), "end", createPosition(range.end));
        }

        private Map<String, Object> createPosition(Position position) {
            return Map.of("line", position.line - 1, "character", position.column - 1);
        }
    }
}
