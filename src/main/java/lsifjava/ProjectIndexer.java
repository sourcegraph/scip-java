package lsifjava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ProjectIndexer {
    public int numFiles;
    public int numDefinitions;

    private Arguments arguments;
    private Emitter emitter;

    public ProjectIndexer(Arguments arguments, Emitter emitter) {
        this.arguments = arguments;
        this.emitter = emitter;
    }

    public void index() throws IOException {
        emitter.emitVertex("metaData", Util.mapOf(
                "version", "0.4.0",
                "positionEncoding", "utf-16",
                "projectRoot", String.format("file://%s", Paths.get(arguments.projectRoot).toFile().getCanonicalPath()),
                "toolInfo", Util.mapOf("name", "lsif-java", "version", "0.1.0")
        ));

        var projectId = emitter.emitVertex("project", Util.mapOf(
                "kind", "java"
        ));

        var indexers = new HashMap<Path, DocumentIndexer>();
        var collector = new FileCollector(projectId, arguments, emitter, indexers);
        Files.walkFileTree(Paths.get(arguments.projectRoot), collector);

        for(var file : indexers.keySet()) {
            System.out.println(file);
        }

        for(var indexer : indexers.values()) {
            indexer.preIndex();
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
