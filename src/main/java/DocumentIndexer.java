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
import com.github.javaparser.resolution.declarations.AssociableToAST;
import com.github.javaparser.resolution.declarations.ResolvedDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.*;

public class DocumentIndexer {
    public int numDefinitions;

    private String projectRoot;
    private String pathname;
    private String projectId;
    private Emitter emitter;
    private Map<String, DocumentIndexer> indexers;
    private boolean indexed = false;
    private Map<Range, DefinitionMeta> defs = new HashMap<>();

    public DocumentIndexer(String projectRoot, String pathname, String projectId, Emitter emitter, Map<String, DocumentIndexer> indexers) {
        this.projectRoot = projectRoot;
        this.pathname = pathname;
        this.projectId = projectId;
        this.emitter = emitter;
        this.indexers = indexers;
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

        // TODO - file contents if not flagged
        final String documentId = emitter.emitVertex("document", Map.of(
                "languageId", "java",
                "uri", String.format("file://%s", Paths.get(pathname).toAbsolutePath().toString())
        ));

        cu.accept(new LSIFVisitor(symbolSolver, documentId), null);

        Set<String> allRangeIds = new HashSet<>();
        for (DefinitionMeta meta : defs.values()) {
            linkUses(meta, documentId);

            numDefinitions++;
            allRangeIds.add(meta.rangeId);
            allRangeIds.addAll(meta.referenceRangeIds);
        }

        emitter.emitEdge("contains", Map.of("outV", projectId, "inVs", new String[]{documentId}));
        emitter.emitEdge("contains", Map.of("outV", documentId, "inVs", allRangeIds));
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

        if (!meta.referenceRangeIds.isEmpty()) {
            emitter.emitEdge("item", Map.of(
                    "property", "references",
                    "outV", resultId,
                    "inVs", meta.referenceRangeIds,
                    "document", documentId
            ));
        }
    }

    private class LSIFVisitor extends VoidVisitorAdapter<Void> {
        private JavaSymbolSolver symbolSolver;
        private String documentId;

        public LSIFVisitor(JavaSymbolSolver symbolSolver, String documentId) {
            this.symbolSolver = symbolSolver;
            this.documentId = documentId;
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

            if (defs.containsKey(range)) {
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

            defs.put(range, new DefinitionMeta(rangeId, resultSetId)); // + contents?
        }

        private <T extends ResolvedDeclaration> void emitUse(Node n, Class<T> cls) {
            T definition;
            try {
                definition = symbolSolver.resolveDeclaration(n, cls);
            } catch (RuntimeException ex) {
                // ignore
                return;
            }

            if (!definition.getClass().isAssignableFrom(AssociableToAST.class)) {
                return;
            }

            Optional<Node> definitionNodeContainer = ((AssociableToAST<Node>) definition).toAst();
            if (!definitionNodeContainer.isPresent()) {
                return;
            }

            Node definitionNode = definitionNodeContainer.get();
            if (definitionNode == null) {
                return;
            }

            String definitionPath = definitionNode.findCompilationUnit()
                    .flatMap(cu -> cu.getStorage())
                    .map(s -> s.getPath().toString())
                    .orElse("");

            if (definitionPath.equals(pathname)) {
                emitDefinition(definitionNode);
                emitUse(n, definitionNode, documentId);
            } else {
                // TODO - need to still link use here
                indexers.get(definitionPath).index();
            }
        }

        private void emitUse(Node n, Node definition, String documentId) {
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
            DefinitionMeta meta = defs.get(definitionRange);

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
                    "document", documentId
            ));

            meta.referenceRangeIds.add(rangeId);
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
