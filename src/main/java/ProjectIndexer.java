import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProjectIndexer {
    public int numPackages;
    public int numFiles;
    public int numDefinitions;

    private Arguments arguments;
    private Emitter emitter;

    public ProjectIndexer(Arguments arguments, Emitter emitter) {
        this.arguments = arguments;
        this.emitter = emitter;
    }

    public void index() throws IOException {
        emitter.emitVertex("metadata", Map.of(
                "version", "0.4.0",
                "positionEncoding", "utf-16",
                "projectRoot", arguments.projectRoot
        ));

        String projectId = emitter.emitVertex("project", Map.of(
                "kind", "java"
        ));

        List<String> files = Files.walk(Paths.get(arguments.projectRoot))
                .map(x -> x.toString())
                .filter(f -> f.endsWith(".java"))
                .collect(Collectors.toList());

        for (String pathname : files) {
            DocumentIndexer indexer = new DocumentIndexer(arguments.projectRoot, pathname, projectId, emitter);
            indexer.index();

            numFiles++;
            numDefinitions += indexer.numDefinitions;
        }
    }
}
