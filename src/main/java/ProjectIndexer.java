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

        List<String> files = createFileStream()
                .map(x -> x.toString())
                .filter(f -> f.endsWith(".java"))
                .sorted()
                .collect(Collectors.toList());

        Map<String, DocumentIndexer> indexers = new HashMap<>();
        for (String pathname : files) {
            indexers.put(pathname, new DocumentIndexer(
                    arguments.projectRoot,
                    arguments.noContents,
                    pathname,
                    projectId,
                    emitter,
                    indexers
            ));
        }

        for (String pathname : files) {
            indexers.get(pathname).index();
        }

        for (String pathname : files) {
            indexers.get(pathname).postIndex();
        }

        for (DocumentIndexer indexer : indexers.values()) {
            numFiles++;
            numDefinitions += indexer.numDefinitions();
        }
    }

    private Stream<Path> createFileStream() {
        try {
            return Files.walk(Paths.get(arguments.projectRoot));
        } catch (IOException ex) {
            throw new RuntimeException(String.format("Failed to walk files in %s", arguments.projectRoot));
        }
    }
}
