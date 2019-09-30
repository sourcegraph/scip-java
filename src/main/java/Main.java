import com.github.javaparser.Position;
import com.github.javaparser.Range;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.resolution.UnsolvedSymbolException;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserParameterDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserSymbolDeclaration;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.google.gson.Gson;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static int nextId = 1;
    private static Map<Range, DefinitionMeta> defs = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Arguments arguments = parseArguments(args);

        try {
            index(arguments);
        } finally {
            if (arguments.mustClose) {
                arguments.printer.close();
            }
        }
    }

    private static Arguments parseArguments(String[] args) throws FileNotFoundException{
        Options options = new Options();
        // TODO - version
        // TODO - description (lsif-java is an LSIF indexer for Java.)

        Option debugOption = new Option("", "debug", false, "Display debug information.");
        options.addOption(debugOption);

        Option verboseOption = new Option("", "verbose", false, "Display verbose information.");
        options.addOption(verboseOption);

        Option projectRootOption = new Option("", "projectRoot", true, "Specifies the project root. Defaults to the current working directory.");
        options.addOption(projectRootOption);

        Option noContentsOption = new Option("", "noContents", false, "File contents will not be embedded into the dump.");
        options.addOption(noContentsOption);

        Option outOption = new Option("", "out", true, "The output file the dump is save to.");
        options.addOption(outOption);

        Option stdoutOption = new Option("", "stdout", false, "Writes the dump to stdout.");
        options.addOption(stdoutOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);
            System.exit(1);
            return null;
        }

        boolean debug = cmd.hasOption("debug");
        boolean verbose = cmd.hasOption("verbose");
        String projectRoot = cmd.getOptionValue("projectRoot", ".");
        boolean noContents = cmd.hasOption("noContents");
        String outFile = cmd.getOptionValue("out");
        boolean stdout = cmd.hasOption("stdout");

        if (outFile == null && !stdout) {
            System.err.println("either an output file using --out or --stdout must be specified");
            System.exit(1);
        }

        if (stdout && (verbose || debug)) {
            System.err.println("debug and verbose options cannot be enabled with --stdout");
            System.exit(1);
        }

        return new Arguments(
                projectRoot,
                noContents,
                stdout ? new PrintWriter(System.out) : new PrintWriter(new File(outFile)),
                !stdout
        );
    }

    private static void index(Arguments arguments) throws IOException {
        emitVertex("metadata", Map.of(
                "version", "0.4.0",
                "positionEncoding", "utf-16",
                "projectRoot", arguments.projectRoot
        ));

        String projectId = emitVertex("project", Map.of("kind", "java"));

        List<String> files = Files.walk(Paths.get(arguments.projectRoot))
                .map(x -> x.toString())
                .filter(f -> f.endsWith(".java"))
                .collect(Collectors.toList());

        for (String pathname : files) {
            emitDocument(arguments.projectRoot, pathname, projectId);
        }
    }

    private static void emitDocument(String projectRoot, String pathname, String projectId) throws FileNotFoundException {
        final JavaSymbolSolver symbolSolver = new JavaSymbolSolver(getTypeSolver(projectRoot));
        StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);

        final String documentId = emitVertex("document", Map.of(
                "languageId", "java",
                "uri", pathname,
                "contents", "unimplemented" // TODO - extract text
        ));

        CompilationUnit cu = StaticJavaParser.parse(new File(pathname));
        VoidVisitorAdapter visitor = new VoidVisitorAdapter<Void>() {
            @Override
            public void visit(final VariableDeclarationExpr n, final Void arg) {
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
        };

        cu.accept(visitor, null);

        Set<String> allRangeIds = new HashSet<>();
        for (DefinitionMeta meta : defs.values()) {
            linkUses(meta, documentId);

            allRangeIds.add(meta.rangeId);
            allRangeIds.addAll(meta.referenceRangeIds);
        }

        emitEdge("contains", Map.of("outV", projectId, "inVs", documentId));
        emitEdge("contains", Map.of("outV", documentId, "inVs", allRangeIds));
    }

    private static TypeSolver getTypeSolver(String projectRoot) {
        CombinedTypeSolver typeSolver = new CombinedTypeSolver();
        typeSolver.add(new JavaParserTypeSolver(projectRoot));
        typeSolver.add(new ReflectionTypeSolver());
        return typeSolver;
    }

    private static Node getNode(ResolvedValueDeclaration decl) {
        if (decl.getClass().isAssignableFrom(JavaParserSymbolDeclaration.class)) {
            return ((JavaParserSymbolDeclaration) decl).getWrappedNode();
        }

        if (decl.getClass().isAssignableFrom(JavaParserParameterDeclaration.class)) {
            return ((JavaParserParameterDeclaration) decl).getWrappedNode();
        }

        return null;
    }

    private static void emitDefinition(Node n) {
        if (!n.getRange().isPresent()) {
            System.out.println("D WTF: " + n);
            return;
        }

        Range range = n.getRange().get();

        if (defs.containsKey(range)) {
            return;
        }


        String hoverId = emitVertex("hoverResult", Map.of("result", Map.of(
                "language", "java",
                "value", n.toString() // TODO - vet output
        )));

        String resultSetId = emitVertex("resultSet", Map.of());
        emitEdge("textDocument/hover", Map.of("outV", resultSetId, "inV", hoverId));
        String rangeId = emitVertex("range", createRange(range));
        emitEdge("next", Map.of("outV", rangeId, "inV", resultSetId));

        defs.put(range, new DefinitionMeta(rangeId, resultSetId)); // + contents?
    }

    private static Map<String, Object> createRange(Range range) {
        return Map.of("start", createPosition(range.begin), "end", createPosition(range.end));
    }

    private static Map<String, Object> createPosition(Position position) {
        return Map.of("line", position.line - 1, "character", position.column - 1);
    }

    private static void emitUse(Node n, Node definition, String documentId) {
        if (!definition.getRange().isPresent()) {
            System.out.println("A WTF: " + n);
            return;
        }

        if (!n.getRange().isPresent()) {
            System.out.println("B WTF: " + n);
            return;
        }

        Range range = n.getRange().get();
        Range definitionRange = definition.getRange().get();
        DefinitionMeta meta = defs.get(definitionRange);
        if (meta == null) {
            System.out.println("C WTF: " + n);
            System.out.println(definitionRange);
            System.out.println(defs);
            return;
        }

        String rangeId = emitVertex("range", createRange(range));
        emitEdge("next", Map.of("outV", rangeId, "inV", meta.resultSetId));

        if (meta.definitionResultId == null) {
            String resultId = emitVertex("definitionResult", Map.of());
            emitEdge("textDocument/definition", Map.of("outV", meta.resultSetId, "inV", resultId));
            meta.definitionResultId = resultId;
        }

        emitEdge("item", Map.of(
                "outV", meta.definitionResultId,
                "inVs", new String[]{meta.rangeId},
                "document", documentId
        ));

        meta.referenceRangeIds.add(rangeId);
    }

    private static void linkUses(DefinitionMeta meta, String documentId) {
        String resultId = emitVertex("referenceResult", Map.of());

        // TODO - are these outVs correct? see other indexer issue

        emitEdge("textDocument/references", Map.of("outV", meta.resultSetId, "inV", resultId));

        emitEdge("item", Map.of(
                "property", "definitions",
                "outV", resultId,
                "inVs", new String[]{meta.rangeId},
                "document", documentId
        ));

        if (!meta.referenceRangeIds.isEmpty()) {
            emitEdge("item", Map.of(
                    "property", "references",
                    "outV", resultId,
                    "inVs", meta.referenceRangeIds,
                    "document", documentId
            ));
        }
    }

    private static String emitVertex(String labelName, Map<String, Object> args) {
        return emit("vertex", labelName, args);
    }

    private static String emitEdge(String labelName, Map<String, Object> args) {
        return emit("edge", labelName, args);
    }

    private static String emit(String typeName, String labelName, Map<String, Object> args) {
        String id = String.format("%d", nextId++);

        HashMap<String, Object> allArgs = new HashMap<>(args);
        allArgs.putAll(Map.of(
                "id", id,
                "type", typeName,
                "label", labelName
        ));

        Gson gson = new Gson();
        String x = gson.toJson(allArgs);
        System.out.println(x);
        return id;
    }

    private static class Arguments {
        public final String projectRoot;
        public final boolean noContents;
        public final PrintWriter printer;
        public final boolean mustClose;

        public Arguments(String projectRoot, boolean noContents, PrintWriter printer, boolean mustClose) {
            this.projectRoot = projectRoot;
            this.noContents = noContents;
            this.printer = printer;
            this.mustClose = mustClose;
        }
    }

    private static class DefinitionMeta {
        public String rangeId;
        public String resultSetId;
        public String definitionResultId;
        public List<String> referenceRangeIds = new ArrayList<>();

        public DefinitionMeta(String rangeId, String resultSetId) {
            this.rangeId = rangeId;
            this.resultSetId = resultSetId;
        }
    }
}
