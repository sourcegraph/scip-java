import com.github.javaparser.Position;
import com.github.javaparser.Range;
import spoon.reflect.code.*;
import spoon.reflect.cu.SourcePosition;
import spoon.reflect.cu.position.NoSourcePosition;
import spoon.reflect.declaration.*;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.CtScanner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DocumentIndexer {
    private String projectRoot;
    private boolean noContents;
    private String pathname;
    private CtElement spoonElement;
    private String projectId;
    private Emitter emitter;
    private Map<String, DocumentIndexer> indexers;
    private String documentId;
    private Set<String> rangeIds = new HashSet<>();
    private Map<Range, DefinitionMeta> definitions = new HashMap<>();

    public DocumentIndexer(
            String projectRoot,
            boolean noContents,
            String pathname,
            CtElement spoonElement,
            String projectId,
            Emitter emitter,
            Map<String, DocumentIndexer> indexers
    ) {
        this.projectRoot = projectRoot;
        this.noContents = noContents;
        this.pathname = pathname;
        this.spoonElement = spoonElement;
        this.projectId = projectId;
        this.emitter = emitter;
        this.indexers = indexers;
    }

    public int numDefinitions() {
        return definitions.size();
    }

    public void visitDefinitions() {
        this.spoonElement.accept(new DefinitionsVisitor());
    }

    public void visitReferences() {
        this.spoonElement.accept(new ReferencesVisitor());
    }

    public void preIndex() {
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

    // TODO add support for more language constructs:
    // https://github.com/INRIA/spoon/blob/master/src/main/java/spoon/reflect/visitor/CtScanner.java

    private class DefinitionsVisitor extends CtScanner {
        @Override
        public <T> void visitCtParameter(CtParameter<T> el) {
            super.visitCtParameter(el);
            emitDefinition(mkRange(el.getPosition()), mkDoc(el.getType(), el.getDocComment()));
        }

        @Override
        public <T> void visitCtLocalVariable(CtLocalVariable<T> el) {
            super.visitCtLocalVariable(el);
            emitDefinition(mkRange(el.getPosition()), mkDoc(el.getType(), el.getDocComment()));
        }

        @Override
        public <T> void visitCtCatchVariable(CtCatchVariable<T> el) {
            super.visitCtCatchVariable(el);
            emitDefinition(mkRange(el.getPosition()), mkDoc(el.getType(), el.getDocComment()));
        }

        @Override
        public <T> void visitCtMethod(CtMethod<T> el) {
            super.visitCtMethod(el);
            emitDefinition(nameRange(el), mkDoc(el.getType(), el.getDocComment()));
        }

        @Override
        public <T> void visitCtField(CtField<T> el) {
            super.visitCtField(el);
            emitDefinition(nameRange(el), mkDoc(el.getType(), el.getDocComment()));
        }

        @Override
        public <T> void visitCtClass(CtClass<T> el) {
            super.visitCtClass(el);
            emitDefinition(nameRange(el), el.getDocComment());
        }

        private void emitDefinition(Range range, String doc) {
            System.out.println("DEF " + pathname + ":" + humanRange(range));

            String hoverId = emitter.emitVertex("hoverResult", Map.of(
                    "result", Map.of(
                            "contents", Map.of(
                                    "kind", "markdown",
                                    "value", doc
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
    }

    private class ReferencesVisitor extends CtScanner {
        @Override
        public <T> void visitCtVariableRead(CtVariableRead<T> el) {
            super.visitCtVariableRead(el);
            emitUse(
                    mkRange(el.getPosition()),
                    mkRange(el.getVariable().getDeclaration().getPosition()),
                    el.getVariable().getDeclaration().getPosition().getFile().getPath()
            );
        }

        @Override
        public <T> void visitCtInvocation(CtInvocation<T> el) {
            super.visitCtInvocation(el);
            if (el.getPosition() instanceof NoSourcePosition) {
                return;
            }
            if (el.getExecutable() == null || el.getExecutable().getDeclaration() == null) {
                return;
            }
            Range useRange = identifierRange(el, el.getExecutable().getSimpleName());
            emitUse(
                    useRange,
                    nameRange(el.getExecutable().getDeclaration()),
                    el.getExecutable().getDeclaration().getPosition().getFile().getPath()
            );
        }

        @Override
        public <T> void visitCtFieldRead(CtFieldRead<T> el) {
            super.visitCtFieldRead(el);
            if (el.getPosition() instanceof NoSourcePosition) {
                return;
            }
            Range useRange = identifierRange(el, el.getVariable().getSimpleName());
            CtField decl = el.getVariable().getDeclaration();
            if (decl == null) {
                return;
            }
            emitUse(
                    useRange,
                    nameRange(decl),
                    decl.getPosition().getFile().getPath()
            );
        }

        @Override
        public <T> void visitCtTypeReference(CtTypeReference<T> el) {
            super.visitCtTypeReference(el);
            if (el.getPosition() instanceof NoSourcePosition) {
                return;
            }
            CtType decl = el.getDeclaration();
            if (decl == null) {
                return;
            }
            emitUse(
                    mkRange(el.getPosition()),
                    nameRange(decl),
                    decl.getPosition().getFile().getPath()
            );
        }

        private void emitUse(Range use, Range def, String defPath) {
            DocumentIndexer indexer = indexers.get(defPath);

            System.out.println(pathname + ":" + humanRange(use) + " -> " + defPath + ":" + humanRange(def));

            DefinitionMeta meta = indexer.definitions.get(def);
            if (meta == null) {
                throw new RuntimeException("BUG definition doesn't exist, usePath " + pathname + ", use " + humanRange(use) + ", defPath " + defPath + ", def " + humanRange(def));
            }

            String rangeId = emitter.emitVertex("range", createRange(use));
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
    }

    private Range nameRange(CtNamedElement a) {
        return nameRange(a.getPosition(), a.getSimpleName());
    }

    private Range nameRange(SourcePosition a, String name) {
        return Range.range(
                a.getLine(),
                a.getColumn(),
                a.getLine(),
                a.getColumn() + name.length()
        );
    }

    private Range nameRange(Range a, String name) {
        return Range.range(
                a.begin.line,
                a.begin.column,
                a.end.line,
                a.end.column + name.length()
        );
    }

    private String mkDoc(CtTypeReference t, String docComment) {
        return "```java\n" + t + "\n```" + (docComment.equals("") ? "" : "\n---\n" + docComment);
    }

    private String humanRange(Range r) {
        return r.begin.line + ":" + r.begin.column + "-" + r.end.line + ":" + r.end.column;
    }

    private Range mkRange(SourcePosition pos) {
        return Range.range(pos.getLine(), pos.getColumn(), pos.getEndLine(), pos.getEndColumn());
    }

    private Map<String, Object> createRange(Range range) {
        return Map.of("start", createPosition(range.begin), "end", createPosition(range.end));
    }

    private Map<String, Object> createPosition(Position position) {
        return Map.of("line", position.line - 1, "character", position.column - 1);
    }

    private Range identifierRange(CtTargetedExpression a, String b) {
        // Ugh, we only want the range for the identifier, not the whole expression.
        // This will probably break on fields/methods that are spread across lines.
        // +1 for `.`, +1 because (I'm guessing) end is inclusive
        SourcePosition p = a.getTarget().getPosition();
        return p instanceof NoSourcePosition ?
                mkRange(a.getPosition()) :
                Range.range(p.getEndLine(), p.getEndColumn() + 1 + 1, p.getEndLine(), p.getEndColumn() + 1 + 1 + b.length());
    }
}
