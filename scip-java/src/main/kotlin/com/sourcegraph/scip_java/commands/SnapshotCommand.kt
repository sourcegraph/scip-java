package com.sourcegraph.scip_java.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.core.ProgramResult
import com.github.ajalt.clikt.core.requireObject
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.multiple
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.path
import com.sourcegraph.scip_java.ScipJavaApp
import com.sourcegraph.scip_java.ScipPrinters
import java.net.URI
import java.nio.charset.StandardCharsets
import java.nio.file.FileSystems
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes
import org.scip_code.scip.Index

/**
 * `scip-java snapshot`: generates annotated snapshots for each `*.scip`
 * file in the given target roots.
 */
class SnapshotCommand : CliktCommand(name = "snapshot") {

    override fun help(context: Context) =
        "Generates annotated snapshots for each `*.scip` file in the given target roots."

    private val app: ScipJavaApp by requireObject()

    private val targetroot: List<Path> by argument(
        help = "List of directories containing SCIP files",
    ).path().multiple()

    private val output: Path by option(
        "--output",
        help = "Output directory for the annotated snapshots",
    ).path().default(Paths.get("generated"))

    private val cleanup: Boolean by option(
        "--cleanup",
        "--no-cleanup",
    ).flag("--no-cleanup", default = true)

    override fun run() {
        val scipPattern = FileSystems.getDefault().getPathMatcher("glob:**.scip")
        if (cleanup) {
            output.toFile().deleteRecursively()
        }
        Files.createDirectories(output)
        var foundScipFile = false
        for (root in targetroot) {
            if (!Files.exists(root)) {
                app.warning("ignoring target root that does not exist: $root")
                continue
            }
            Files.walkFileTree(
                root,
                object : SimpleFileVisitor<Path>() {
                    override fun visitFile(file: Path, attrs: BasicFileAttributes): FileVisitResult {
                        if (scipPattern.matches(file)) {
                            val index = Index.parseFrom(Files.readAllBytes(file))
                            // Per-source SCIP shards under META-INF/scip/ carry no Metadata;
                            // only the aggregated index does. Skip shards so `scip-java
                            // snapshot <targetroot>` doesn't trip over them.
                            val projectRoot = index.metadata.projectRoot
                            if (projectRoot.isNotEmpty()) {
                                foundScipFile = true
                                val rootUri = URI.create(projectRoot)
                                for (doc in index.documentsList) {
                                    val sourcepath = Paths.get(rootUri.resolve(doc.relativePath))
                                    val source =
                                        String(Files.readAllBytes(sourcepath), StandardCharsets.UTF_8)
                                    val document = ScipPrinters.printTextDocument(doc, source)
                                    val snapshotOutput = output.resolve(doc.relativePath)
                                    Files.createDirectories(snapshotOutput.parent)
                                    Files.write(
                                        snapshotOutput,
                                        document.toByteArray(StandardCharsets.UTF_8),
                                    )
                                }
                            }
                        }
                        return super.visitFile(file, attrs)
                    }
                },
            )
        }
        if (!foundScipFile) {
            app.error(
                "no SCIP files found. To fix this problem, make sure that one of the directories " +
                    "in ${targetroot.joinToString(", ")} contains a `*.scip` file.",
            )
            throw ProgramResult(1)
        }
    }
}
