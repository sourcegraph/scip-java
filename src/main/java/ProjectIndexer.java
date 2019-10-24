import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.symbolsolver.utils.SymbolSolverCollectionStrategy;
import com.github.javaparser.utils.ProjectRoot;
import com.github.javaparser.utils.SourceRoot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProjectIndexer {
    public int numFiles;
    public int numDefinitions;

    private Arguments arguments;
    private Emitter emitter;

    public ProjectIndexer(Arguments arguments, Emitter emitter) {
        this.arguments = arguments;
        this.emitter = emitter;
    }

    public void index() {
        emitter.emitVertex("metaData", Map.of(
                "version", "0.4.0",
                "positionEncoding", "utf-16",
                "projectRoot", String.format("file://%s", Paths.get(arguments.projectRoot).toAbsolutePath().toString())
        ));

        String projectId = emitter.emitVertex("project", Map.of(
                "kind", "java"
        ));

        Map<String, DocumentIndexer> indexers = new HashMap<>();

        ProjectRoot root = new SymbolSolverCollectionStrategy().collect(Paths.get(arguments.projectRoot));
        for (SourceRoot sr : root.getSourceRoots()) {
            try {
                sr.tryToParse();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (CompilationUnit cu : sr.getCompilationUnits()) {
                // .accept(visitor)
                String pathname = cu.getStorage().get().getPath().toAbsolutePath().toString();
                indexers.put(pathname, new DocumentIndexer(
                        arguments.projectRoot,
                        arguments.noContents,
                        pathname,
                        projectId,
                        emitter,
                        indexers,
                        cu
                ));
            }
        }

        for (DocumentIndexer indexer : indexers.values()) {
            indexer.index();
        }

        for (DocumentIndexer indexer : indexers.values()) {
            indexer.postIndex();
        }

        for (DocumentIndexer indexer : indexers.values()) {
            numFiles++;
            numDefinitions += indexer.numDefinitions();
        }
    }
}
