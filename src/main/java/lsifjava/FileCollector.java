package lsifjava;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;

public class FileCollector extends SimpleFileVisitor<Path> {

    private final Map<Path, DocumentIndexer> indexers;
    private final Emitter emitter;
    private final Arguments args;
    private final String projectId;

    public FileCollector(String projectId, Arguments args, Emitter emitter, Map<Path, DocumentIndexer> indexers) {
        this.emitter = emitter;
        this.projectId = projectId;
        this.args = args;
        this.indexers = indexers;
    }
    
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        if (attrs.isSymbolicLink()) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes _attrs) {
        if (isJavaFile(file)) {
            indexers.put(file, new DocumentIndexer(
                args.projectRoot,
                args.verbose,
                file,
                projectId,
                emitter,
                indexers)
            );
        }
        return FileVisitResult.CONTINUE;
    }

    static boolean isJavaFile(Path file) {
        var name = file.getFileName().toString();
        // We hide module-info.java from javac, because when javac sees module-info.java
        // it goes into "module mode" and starts looking for classes on the module class path.
        // This becomes evident when javac starts recompiling *way too much* on each task,
        // because it doesn't realize there are already up-to-date .class files.
        // The better solution would be for java-language server to detect the presence of module-info.java,
        // and go into its own "module mode" where it infers a module source path and a module class path.
        return name.endsWith(".java") && !Files.isDirectory(file) && !name.equals("module-info.java");
    }
}
