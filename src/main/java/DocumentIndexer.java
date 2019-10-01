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
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.resolution.UnsolvedSymbolException;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserMethodDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserParameterDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserSymbolDeclaration;
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
    private Map<Range, DefinitionMeta> defs = new HashMap<>();

    public DocumentIndexer(String projectRoot, String pathname, String projectId, Emitter emitter) {
        this.projectRoot = projectRoot;
        this.pathname = pathname;
        this.projectId = projectId;
        this.emitter = emitter;
    }

    public void index() throws FileNotFoundException {
        final JavaSymbolSolver symbolSolver = new JavaSymbolSolver(getTypeSolver(projectRoot));
        StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);

        // TODO - file contents if not flagged
        final String documentId = emitter.emitVertex("document", Map.of(
                "languageId", "java",
                "uri", String.format("file://%s", Paths.get(pathname).toAbsolutePath().toString())
        ));

        CompilationUnit cu = StaticJavaParser.parse(new File(pathname));
        VoidVisitorAdapter visitor = new VoidVisitorAdapter<Void>() {
            @Override
            public void visit(final MethodCallExpr n, final Void arg) {
                super.visit(n, arg);

                ResolvedMethodDeclaration definition;
                try {
                    definition = symbolSolver.resolveDeclaration(n, ResolvedMethodDeclaration.class);
                } catch (UnsolvedSymbolException ex) {
                    return;
                } catch (UnsupportedOperationException ex) {
                    return;
                } catch (RuntimeException ex) {
                    // TODO - why this one?
                    return;
                }

                Node definitionNode = getNode(definition);
                if (definitionNode != null) {
                    emitDefinition(definitionNode);
                    emitUse(n, definitionNode, documentId);
                }
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

                ResolvedValueDeclaration definition;
                try {
                    definition = symbolSolver.resolveDeclaration(n, ResolvedValueDeclaration.class);
                } catch (UnsolvedSymbolException ex) {
                    return;
                } catch (UnsupportedOperationException ex) {
                    return;
                }

                Node definitionNode = getNode(definition);
                if (definitionNode != null) {
                    emitDefinition(definitionNode);
                    emitUse(n, definitionNode, documentId);
                }
            }

            @Override
            public void visit(final Parameter n, final Void arg) {
                super.visit(n, arg);
                emitDefinition(n);
            }
        };

        cu.accept(visitor, null);

        Set<String> allRangeIds = new HashSet<>();
        for (DefinitionMeta meta : defs.values()) {
            linkUses(meta, documentId);

            numDefinitions++;
            allRangeIds.add(meta.rangeId);
            allRangeIds.addAll(meta.referenceRangeIds);
        }

        emitter.emitEdge("contains", Map.of("outV", projectId, "inVs", documentId));
        emitter.emitEdge("contains", Map.of("outV", documentId, "inVs", allRangeIds));
    }

    private TypeSolver getTypeSolver(String projectRoot) {
        CombinedTypeSolver typeSolver = new CombinedTypeSolver();
        typeSolver.add(new JavaParserTypeSolver(projectRoot));
        typeSolver.add(new ReflectionTypeSolver());
        return typeSolver;
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

    private Map<String, Object> createRange(Range range) {
        return Map.of("start", createPosition(range.begin, -1), "end", createPosition(range.end));
    }

    private Map<String, Object> createPosition(Position position) {
        return createPosition(position, 0);
    }

    private Map<String, Object> createPosition(Position position, int delta) {
        return Map.of("line", position.line + delta, "character", position.column + delta);
    }


    private void emitUse(Node n, Node definition, String documentId) {
        Optional<Range> rangeContainer = getRange(n);
        Optional<Range> definitionRangeContainer = getRange(definition);

        if (!rangeContainer.isPresent()) {
            throw new RuntimeException("Unexpected range-less AST node: " + n.toString());
        }

        if (!rangeContainer.isPresent()) {
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

    private void linkUses(DefinitionMeta meta, String documentId) {
        String resultId = emitter.emitVertex("referenceResult", Map.of());

        // TODO - are these outVs correct? see other indexer issue

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

    private Node getNode(ResolvedMethodDeclaration decl) {
        if (decl.getClass().isAssignableFrom(JavaParserMethodDeclaration.class)) {
            return ((JavaParserMethodDeclaration) decl).getWrappedNode();
        }

        return null;
    }

    private Node getNode(ResolvedValueDeclaration decl) {
        if (decl.getClass().isAssignableFrom(JavaParserSymbolDeclaration.class)) {
            return ((JavaParserSymbolDeclaration) decl).getWrappedNode();
        }

        if (decl.getClass().isAssignableFrom(JavaParserParameterDeclaration.class)) {
            return ((JavaParserParameterDeclaration) decl).getWrappedNode();
        }

        return null;
    }

    private Optional<Range> getRange(Node decl) {
        if (decl.getClass().isAssignableFrom(MethodDeclaration.class)) {
            return ((MethodDeclaration) decl).getName().getRange();
        }

        if (decl.getClass().isAssignableFrom(Parameter.class)) {
            return ((Parameter) decl).getName().getRange();
        }

        if (decl.getClass().isAssignableFrom(VariableDeclarationExpr.class)) {
            return ((VariableDeclarationExpr) decl).getVariables().get(0).getRange();
        }

        return decl.getRange();
    }
}
