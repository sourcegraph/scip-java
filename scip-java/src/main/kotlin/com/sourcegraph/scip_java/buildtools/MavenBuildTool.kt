package com.sourcegraph.scip_java.buildtools

import com.sourcegraph.scip_java.Embedded
import com.sourcegraph.scip_java.commands.IndexCommand
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class MavenBuildTool(index: IndexCommand) : BuildTool("Maven", index) {

    override fun usedInCurrentDirectory(): Boolean =
        Files.isRegularFile(index.workingDirectory.resolve("pom.xml"))

    override fun generateScip(): Int {
        val result = runBuild()
        return generateScipFromTargetroot(
            result,
            index.finalTargetroot(defaultTargetroot),
            index,
        )
    }

    private val defaultTargetroot: Path = Paths.get("target", "scip-targetroot")

    private fun runBuild(): ProcessResult =
        TemporaryFiles.withDirectory(index) { tmp ->
            val mvnw = index.workingDirectory.resolve("mvnw")
            val mavenScript =
                if (Files.isRegularFile(mvnw) && Files.isExecutable(mvnw)) mvnw.toString()
                else "mvn"
            val executable =
                Embedded.customJavac(
                    index.workingDirectory,
                    index.finalTargetroot(defaultTargetroot),
                    tmp,
                )
            val command = mutableListOf<String>()
            command += mavenScript
            command += "-Dmaven.compiler.useIncrementalCompilation=false"
            // NOTE(olafur): the square/javapoet repo sets compilerId to
            // 'javac-with-javac', which appears to override the
            // '-Dmaven.compiler.executable' setting. Forcing the compilerId to
            // 'javac' fixes the issue for this repo.
            command += "-Dmaven.compiler.compilerId=javac"
            command += "-Dmaven.compiler.executable=$executable"
            command += "-Dmaven.compiler.fork=true"
            command += index.finalBuildCommand(
                listOf(
                    "--batch-mode",
                    "clean",
                    // Default to the "verify" command, as recommended by the official docs
                    // https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html#usual-command-line-calls
                    "verify",
                    "-DskipTests",
                ),
            )

            val exit = index.app.runProcess(command)
            Embedded.reportUnexpectedJavacErrors(index.app.reporter, tmp) ?: exit
        }
}
