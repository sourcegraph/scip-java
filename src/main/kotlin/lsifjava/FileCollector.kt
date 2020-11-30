package lsifjava

import kotlinx.coroutines.*
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes
import kotlinx.coroutines.channels.Channel

private data class FileBuildInfo(val filepath: Path, val classpath: Classpath, val javaVersion: String?)

/**
 * Builds a map of Java filepaths to DocumentIndexers,
 * with build info derived from `buildToolInterface`
 */
fun buildIndexerMap(
    buildToolInterface: BuildToolInterface,
    emitter: Emitter,
    verbose: Boolean,
    javacDiagListener: CountingDiagnosticListener,
): Map<Path, DocumentIndexer> {
    val indexers = mutableMapOf<Path, DocumentIndexer>()
    
    val classpaths = buildToolInterface.classpaths.merge()

    val sourceVersions = buildToolInterface.javaSourceVersions

    // TODO(nsc) where to move this
    val externalDocManager = ExternalDocs(buildToolInterface.sourcesList, javacDiagListener)

    val fileBuildInfo = Channel<FileBuildInfo>()

    runBlocking {
        launchFileTreeWalkers(
            buildToolInterface, fileBuildInfo, classpaths, sourceVersions,
        ).invokeOnCompletion(fileBuildInfo::close)

        launch {
            for(info in fileBuildInfo) {
                indexers[info.filepath] = DocumentIndexer(
                    CanonicalPath(info.filepath), info.classpath, info.javaVersion ?: "1.8",
                    indexers, externalDocManager, emitter, javacDiagListener, verbose,
                )
            }
        }
    }

    return indexers
}

// NOTE: classpaths is the total collection of the found classpaths for all
// sub-projects. This is a bit of a brute force mash together but it appears to please
// the javac
private fun CoroutineScope.launchFileTreeWalkers(
    buildToolInterface: BuildToolInterface,
    fileBuildInfoChannel: Channel<FileBuildInfo>,
    classpaths: Classpath,
    sourceVersions: List<String?>,
) =  launch(Dispatchers.IO) {
    buildToolInterface.sourceDirectories.forEachIndexed { i, paths ->
        launch {
            val collector = AsyncFileCollector(fileBuildInfoChannel, classpaths, sourceVersions.getOrNull(i), this)
            paths.asSequence().filter { Files.exists(it) }.forEach { Files.walkFileTree(it, collector) }
        }
    }
}

/**
 * A weakly asynchronous file-tree visitor. Sends discovered and valid
 * files+build info into the provided channel asynchronously
 */
private class AsyncFileCollector(
    private val fileInfoChannel: Channel<FileBuildInfo>,
    private val classpath: Classpath,
    private val sourceVersion: String?,
    private val coroutineScope: CoroutineScope,
) : SimpleFileVisitor<Path>() {

    override fun preVisitDirectory(dir: Path, attrs: BasicFileAttributes): FileVisitResult =
        if (attrs.isSymbolicLink) FileVisitResult.SKIP_SUBTREE
        else FileVisitResult.CONTINUE

    override fun visitFile(file: Path, _attrs: BasicFileAttributes): FileVisitResult {
        if (isJavaFile(file)) {
            coroutineScope.launch {
                fileInfoChannel.send(FileBuildInfo(file, classpath, sourceVersion))
            }
        }
        return FileVisitResult.CONTINUE
    }

    companion object {
        fun isJavaFile(file: Path): Boolean {
            val name = file.fileName.toString()
            // We hide module-info.java from javac, because when javac sees module-info.java
            // it goes into "module mode" and starts looking for classes on the module class path.
            // The better solution would be for java-language server to detect the presence of module-info.java,
            // and go into its own "module mode" where it infers a module source path and a module class path.
            return name.endsWith(".java") && !Files.isDirectory(file) && name != "module-info.java"
        }
    }
}
