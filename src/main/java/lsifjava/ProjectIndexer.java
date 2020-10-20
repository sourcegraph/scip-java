package lsifjava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ProjectIndexer {
    public int numFiles;
    public int numDefinitions;

    private final Arguments arguments;
    private final Emitter emitter;

    public ProjectIndexer(Arguments arguments, Emitter emitter) {
        this.arguments = arguments;
        this.emitter = emitter;
    }

    public void index() throws IOException {
        emitter.emitVertex("metaData", Map.of(
            "version", "0.4.0",
            "positionEncoding", "utf-16",
            "projectRoot", String.format("file://%s", Paths.get(arguments.projectRoot).toFile().getCanonicalPath()),
            "toolInfo", Map.of("name", "lsif-java", "version", "0.1.0")
        ));

        var projectId = emitter.emitVertex("project", Map.of(
            "kind", "java"
        ));

        var indexers = new HashMap<Path, DocumentIndexer>();
        var collector = new FileCollector(projectId, arguments, emitter, indexers);

        try(GradleInterface gradleInterface = new GradleInterface(arguments.projectRoot)) {
            for (String it : gradleInterface.sourceDirectories()) {
                Files.walkFileTree(Paths.get(it), collector);
            }
        }

        var fileManager = new SourceFileManager(indexers.keySet());

        for(var indexer : indexers.values()) {
            indexer.preIndex(fileManager);
        }

        for(var indexer : indexers.values()) {
            indexer.index();
        }

        /* if(arguments.verbose)
            System.out.println("\nEMITTING DEFINITIONS\n-------------------------------------------------");

        for(var indexer : indexers.values()) {
            indexer.visitDefinitions();
        }

        if(arguments.verbose)
            System.out.println("\nEMITTING REFERENCES\n-------------------------------------------------");

        for(var indexer : indexers.values()) {
            indexer.visitReferences();
        }
 */
        for(var indexer : indexers.values()) {
            indexer.postIndex();
        }

        for(var indexer : indexers.values()) {
            numFiles++;
            numDefinitions += indexer.numDefinitions();
        }
    }
}
