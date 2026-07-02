package org.scip_code.scip_java.commands

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
import java.nio.file.FileSystems
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes
import org.scip_code.scip.Index
import org.scip_code.scip_java.ScipJavaApp
import org.scip_code.scip_java.buildtools.ProcessRunner

/**
 * `scip-java snapshot`: generates annotated snapshots for each `*.scip` file in the given target
 * roots.
 */
class SnapshotCommand : CliktCommand(name = "snapshot") {

    override fun help(context: Context) =
        "Generates annotated snapshots for each `*.scip` file in the given target roots."

    private val app: ScipJavaApp by requireObject()

    private val targetroot: List<Path> by
        argument(help = "List of directories containing SCIP files").path().multiple()

    private val output: Path by
        option("--output", help = "Output directory for the annotated snapshots")
            .path()
            .default(Paths.get("generated"))

    private val cleanup: Boolean by
        option("--cleanup", "--no-cleanup").flag("--no-cleanup", default = true)

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
                    override fun visitFile(
                        file: Path,
                        attrs: BasicFileAttributes,
                    ): FileVisitResult {
                        if (scipPattern.matches(file)) {
                            val index = Index.parseFrom(Files.readAllBytes(file))
                            // Per-source SCIP shards under META-INF/scip/ carry no Metadata;
                            // only the aggregated index does. Skip shards so `scip-java
                            // snapshot <targetroot>` doesn't trip over them.
                            if (index.metadata.projectRoot.isNotEmpty()) {
                                foundScipFile = true
                                renderSnapshots(file, index)
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
                    "in ${targetroot.joinToString(", ")} contains a `*.scip` file."
            )
            throw ProgramResult(1)
        }
    }

    /**
     * Renders [scipFile] into per-document snapshot files by shelling out to the `scip` CLI
     * (expected on `PATH`; provided by the nix devShell). scip reads each document's source from
     * disk via the project root recorded in the index and writes one annotated snapshot file per
     * document.
     *
     * `scip snapshot --to` wipes its output directory on each run, so render into a temp directory
     * and copy the per-document files into [output]. That keeps snapshots from sibling indexes
     * (across multiple target roots) intact and preserves the previous command's output layout.
     */
    private fun renderSnapshots(scipFile: Path, index: Index) {
        val tmp = Files.createTempDirectory("scip-snapshot")
        try {
            val result =
                ProcessRunner.run(
                    command =
                        listOf(
                            "scip",
                            "snapshot",
                            "--from",
                            scipFile.toString(),
                            "--to",
                            tmp.toString(),
                            "--strict=false",
                        ),
                    cwd = output,
                    onStdout = { app.info(it) },
                    onStderr = { app.warning(it) },
                )
            if (result.exitCode != 0) {
                app.error(
                    "`scip snapshot` exited with code ${result.exitCode} for $scipFile. " +
                        "Make sure the `scip` CLI is installed and on your PATH."
                )
                throw ProgramResult(1)
            }
            for (doc in index.documentsList) {
                val rendered = tmp.resolve(doc.relativePath)
                if (Files.exists(rendered)) {
                    val snapshotOutput = output.resolve(doc.relativePath)
                    Files.createDirectories(snapshotOutput.parent)
                    Files.write(snapshotOutput, Files.readAllBytes(rendered))
                }
            }
        } finally {
            tmp.toFile().deleteRecursively()
        }
    }
}
