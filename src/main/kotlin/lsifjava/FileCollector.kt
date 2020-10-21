package lsifjava

import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes


class FileCollector(private val projectId: String, private val args: Arguments, private val emitter: Emitter, private val indexers: MutableMap<Path, DocumentIndexer>) : SimpleFileVisitor<Path>() {
    var classpath: Classpath? = null
    override fun preVisitDirectory(dir: Path, attrs: BasicFileAttributes): FileVisitResult {
        return if (attrs.isSymbolicLink) {
            FileVisitResult.SKIP_SUBTREE
        } else FileVisitResult.CONTINUE
    }

    override fun visitFile(file: Path, _attrs: BasicFileAttributes): FileVisitResult {
        if (isJavaFile(file)) {
            indexers[file] = DocumentIndexer(
                args.projectRoot,
                args.verbose,
                file,
                projectId,
                emitter,
                indexers,
                classpath!!)
        }
        return FileVisitResult.CONTINUE
    }

    companion object {
        fun isJavaFile(file: Path): Boolean {
            val name = file.fileName.toString()
            // We hide module-info.java from javac, because when javac sees module-info.java
            // it goes into "module mode" and starts looking for classes on the module class path.
            // This becomes evident when javac starts recompiling *way too much* on each task,
            // because it doesn't realize there are already up-to-date .class files.
            // The better solution would be for java-language server to detect the presence of module-info.java,
            // and go into its own "module mode" where it infers a module source path and a module class path.
            return name.endsWith(".java") && !Files.isDirectory(file) && name != "module-info.java"
        }
    }
}
