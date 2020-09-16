package lsifjava;

import spoon.MavenLauncher;
import spoon.compiler.Environment;
import spoon.reflect.declaration.CtElement;
import spoon.support.StandardEnvironment;
import spoon.support.compiler.SpoonPom;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Sets;

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

        String projectId = emitter.emitVertex("project", Util.mapOf(
                "kind", "java"
        ));

        MavenLauncher spoon = new MavenLauncher(arguments.projectRoot, MavenLauncher.SOURCE_TYPE.ALL_SOURCE/* , Pattern.compile(".+") */);
        spoon.getEnvironment().setIgnoreDuplicateDeclarations(true);
        spoon.getEnvironment().setComplianceLevel(9);
        spoon.buildModel();

        Set<String> allFiles = new HashSet<>();
        Set<String> visitedFiles = new HashSet<>();
        if(arguments.verbose) {
            FileVisitor<Path> filetreeWalker = new FileVisitor<Path>() {
                @Override
                public FileVisitResult postVisitDirectory(Path arg0, IOException arg1) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path arg0, BasicFileAttributes arg1) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes meta) throws IOException {
                    if (meta.isDirectory()) return FileVisitResult.CONTINUE;

                    String filename = path.getFileName().toString();
                    if (filename.endsWith(".java") && !filename.equals("package-info.java") && !filename.equals("module-info.java"))
                        allFiles.add(path.toFile().getCanonicalPath());

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path arg0, IOException arg1) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            };
            
            Files.walkFileTree(Paths.get(arguments.projectRoot), filetreeWalker);

            System.out.print("\nDISCOVERED MODULES\n-------------------------------------------------\n");
            
            printModule(spoon.getPomFile());
            for (SpoonPom pom : spoon.getPomFile().getModules()) {
                printModule(pom);
                for (SpoonPom child : pom.getModules()) {
                    printModule(child);
                }
            }

            System.out.println("\nDISCOVERED SOURCE DIRECTORIES\n-------------------------------------------------");
            System.out.println(spoon.getPomFile().getSourceDirectories().stream().map(row -> {
                String path = null; try { path = String.join(",", row.getCanonicalPath().replaceFirst("^"+arguments.projectRoot, ".")); } catch (IOException e) {}; return path;
            }).sorted().collect(Collectors.joining("\n")));
        }
        
        Map<String, CtElement> typeByFile = new HashMap<>();
        for (CtElement el : spoon.getModel().getAllTypes()) {
            visitedFiles.add(el.getPosition().getFile().getAbsolutePath());
            typeByFile.put(el.getPosition().getFile().getPath(), el);
        }

        Map<String, DocumentIndexer> indexers = new HashMap<>();
        for (Map.Entry<String, CtElement> pathname : typeByFile.entrySet()) {
            indexers.put(pathname.getKey(), new DocumentIndexer(
                    arguments.projectRoot,
                    arguments.verbose,
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

        if(arguments.verbose)
            System.out.println("\nEMITTING DEFINITIONS\n-------------------------------------------------");

        for (DocumentIndexer indexer : indexers.values()) {
            indexer.visitDefinitions();
        }

        if(arguments.verbose)
            System.out.println("\nEMITTING REFERENCES\n-------------------------------------------------");

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

        if(arguments.verbose) {
            System.out.println("\nMISSED JAVA FILES\n-------------------------------------------------");
            System.out.println(
                Sets.difference(allFiles, visitedFiles)
                    .stream()
                    .map(row -> String.join(",", row))
                    .sorted()
                    .collect(Collectors.joining("\n")));
            System.out.println("All: " + allFiles.size() + " Visited: "  + visitedFiles.size());
        }
    }

    private Stream<Path> createFileStream() {
        try {
            return Files.walk(Paths.get(arguments.projectRoot));
        } catch (IOException ex) {
            throw new RuntimeException(String.format("Failed to walk files in %s", arguments.projectRoot));
        }
    }

    private void printModule(SpoonPom pom) throws IOException {
        System.out.println("Found module '" + pom.getName() + "' at " + Paths.get(pom.getPath()).getParent().toFile().getCanonicalPath().replaceFirst("^"+arguments.projectRoot, "."));
    }
}
