import com.google.common.collect.ImmutableMap;
import spoon.MavenLauncher;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtModule;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtType;
import spoon.reflect.visitor.CtIterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
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
        emitter.emitVertex("metaData", Util.mapOf(
                "version", "0.4.0",
                "positionEncoding", "utf-16",
                "projectRoot", String.format("file://%s", Paths.get(arguments.projectRoot).toAbsolutePath().toString())
        ));

        String projectId = emitter.emitVertex("project", Util.mapOf(
                "kind", "java"
        ));

        MavenLauncher spoon = new MavenLauncher(arguments.projectRoot, MavenLauncher.SOURCE_TYPE.ALL_SOURCE);
        spoon.getEnvironment().setIgnoreDuplicateDeclarations(true);
        spoon.getEnvironment().setComplianceLevel(9);
        spoon.buildModel();
        Map<String, CtElement> typeByFile = new HashMap();
        for (CtElement el : spoon.getModel().getAllTypes()) {
            System.out.println("Found " + el.getPosition().getFile().getPath());
            typeByFile.put(el.getPosition().getFile().getPath(), el);
        }

        Map<String, DocumentIndexer> indexers = new HashMap<>();
        for (Map.Entry<String, CtElement> pathname : typeByFile.entrySet()) {
            indexers.put(pathname.getKey(), new DocumentIndexer(
                    arguments.projectRoot,
                    arguments.contents,
                    pathname.getKey(),
                    pathname.getValue(),
                    projectId,
                    emitter,
                    indexers
            ));
        }

        for (DocumentIndexer indexer : indexers.values()) {
            indexer.preIndex();
        }

        for (DocumentIndexer indexer : indexers.values()) {
            indexer.visitDefinitions();
        }

        for (DocumentIndexer indexer : indexers.values()) {
            indexer.visitReferences();
        }

        for (DocumentIndexer indexer : indexers.values()) {
            indexer.postIndex();
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
