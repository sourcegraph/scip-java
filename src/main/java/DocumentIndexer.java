import com.github.javaparser.Position;
import com.github.javaparser.Range;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithSimpleName;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.resolution.Resolvable;
import com.github.javaparser.resolution.UnsolvedSymbolException;
import com.github.javaparser.resolution.declarations.ResolvedClassDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.*;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.reflectionmodel.ReflectionMethodDeclaration;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.github.javaparser.symbolsolver.utils.SymbolSolverCollectionStrategy;
import com.github.javaparser.utils.ProjectRoot;

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
    private CompilationUnit cu;

    public DocumentIndexer(
            String projectRoot,
            boolean noContents,
            String pathname,
            String projectId,
            Emitter emitter,
            Map<String, DocumentIndexer> indexers,
            CompilationUnit cu
    ) {
        this.projectRoot = projectRoot;
        this.noContents = noContents;
        this.pathname = pathname;
        this.projectId = projectId;
        this.emitter = emitter;
        this.indexers = indexers;
        this.cu = cu;
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
        this.cu.accept(new LSIFVisitor(), null);
    }

    public void postIndex() {
        for (DefinitionMeta meta : definitions.values()) {
            linkUses(meta, documentId);
        }

        emitter.emitEdge("contains", Map.of("outV", projectId, "inVs", new String[]{documentId}));
        emitter.emitEdge("contains", Map.of("outV", documentId, "inVs", rangeIds.stream().sorted().toArray()));
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
        private boolean log;

        public LSIFVisitor() {
        }

        // TODO - field access
        // TODO - types to classes
        // TODO - enums
        // TODO - inner classes?

        @Override
        public void visit(final MethodCallExpr n, final Void arg) {
            super.visit(n, arg);
            if (n.getName().getIdentifier().equals("postIndex")) {
                this.log = true;
            }
            try {
                System.out.println(n.resolve());
                emitUse(n, n.getScope().resolve());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            this.log = false;
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
            try {
                emitUse(n, n.resolve());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
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

        private void emitUse(Node n, ResolvedDeclaration decl) {
            Node definitionNode = getNode(decl);
            if (this.log) System.out.println(decl);
            if (definitionNode == null) {
                if (this.log) System.out.println("NO DEF");
                return;
            } else {
                if (this.log) System.out.println("DEF");
            }

            Optional<String> definitionPathContainer = definitionNode.findCompilationUnit()
                    .flatMap(cu -> cu.getStorage())
                    .map(s -> s.getPath().toString());

            if (definitionPathContainer.isPresent() && definitionPathContainer.get().equals(pathname)) {
                emitDefinition(definitionNode);
            } else {
                indexers.get(definitionPathContainer.get()).index();
            }

            emitUse(n, definitionNode, definitionPathContainer.orElse(pathname));
        }

        private Node getNode(ResolvedDeclaration def) {
            return
                    JavaParserClassDeclaration.class.isInstance(def) ? JavaParserClassDeclaration.class.cast(def).getWrappedNode()
                            : JavaParserConstructorDeclaration.class.isInstance(def) ? JavaParserConstructorDeclaration.class.cast(def).getWrappedNode()
//                    : JavaParserEnumConstantDeclaration.class.isInstance(def) ? JavaParserEnumConstantDeclaration.class.cast(def).getWrappedNode()
//                    : JavaParserEnumDeclaration.class.isInstance(def) ? JavaParserEnumDeclaration.class.cast(def).getWrappedNode()
                            : JavaParserFieldDeclaration.class.isInstance(def) ? JavaParserFieldDeclaration.class.cast(def).getWrappedNode()
//                    : JavaParserInterfaceDeclaration.class.isInstance(def) ? JavaParserInterfaceDeclaration.class.cast(def).getWrappedNode()
                            : JavaParserMethodDeclaration.class.isInstance(def) ? JavaParserMethodDeclaration.class.cast(def).getWrappedNode()
                            : JavaParserParameterDeclaration.class.isInstance(def) ? JavaParserParameterDeclaration.class.cast(def).getWrappedNode()
                            : JavaParserSymbolDeclaration.class.isInstance(def) ? JavaParserSymbolDeclaration.class.cast(def).getWrappedNode()
//                    : JavaParserTypeVariableDeclaration.class.isInstance(def) ? JavaParserTypeVariableDeclaration.class.cast(def).getWrappedNode()
                            : JavaParserVariableDeclaration.class.isInstance(def) ? JavaParserVariableDeclaration.class.cast(def).getWrappedNode()
//                            : ReflectionMethodDeclaration.class.isInstance(def) ? JavaParserMethodDeclaration.class.cast(def).getWrappedNode()
                            : null;
        }

        private void emitUse(Node n, Node definition, String definitionPath) {
            if (this.log) System.out.println("emitUse2...");

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
            if (this.log) System.out.println("emitUse2 edge...");

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
                decl = ((VariableDeclarationExpr) decl).getVariables().get(0); // TODO - how to support multiple?
            }

            if (decl.getClass().isAssignableFrom(FieldDeclaration.class)) {
                // Unwrap variable declarations
                decl = ((FieldDeclaration) decl).getVariables().get(0); // TODO - how to support multiple?
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
