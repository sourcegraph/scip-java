package com.sourcegraph.scip_java

import com.sourcegraph.scip_java.buildtools.ProcessResult
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

object Embedded {

    /** `javac` launcher flags required by the SCIP plugin to access internal javac APIs. */
    val javacModuleOptions: List<String> =
        listOf(
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED",
        )

    fun scipJar(tmpDir: Path): Path = copyFile(tmpDir, "scip-plugin.jar")

    fun gradlePluginJar(tmpDir: Path): Path = copyFile(tmpDir, "gradle-plugin.jar")

    fun scipKotlincJar(tmpDir: Path): Path = copyFile(tmpDir, "scip-kotlinc.jar")

    private fun javacErrorpath(tmp: Path): Path = tmp.resolve("errorpath.txt")

    fun customJavac(sourceroot: Path, targetroot: Path, tmp: Path): Path {
        val bin = tmp.resolve("bin")
        val javac = bin.resolve("javac")
        val java = bin.resolve("java")
        val pluginpath = scipJar(tmp)
        val errorpath = javacErrorpath(tmp)
        val javacopts = targetroot.resolve("javacopts.txt")
        Files.createDirectories(targetroot)
        Files.createDirectories(bin)
        Files.write(
            java,
            ("#!/usr/bin/env bash\n" + "java \"\$@\"\n").toByteArray(StandardCharsets.UTF_8),
        )
        val newJavacopts = tmp.resolve("javac_newarguments")
        // --add-exports flags required to access internal javac APIs from our
        // SCIP plugin. Always set; Java 11+ is the supported baseline.
        val javacModuleOptionsText = javacModuleOptions.joinToString(" ")
        val injectScipArguments =
            listOf(
                    "java",
                    "-Dscip.errorpath=$errorpath",
                    "-Dscip.pluginpath=$pluginpath",
                    "-Dscip.sourceroot=$sourceroot",
                    "-Dscip.targetroot=$targetroot",
                    "-Dscip.output=\$NEW_JAVAC_OPTS",
                    "-Dscip.old-output=$javacopts",
                    "-classpath $pluginpath",
                    "com.sourcegraph.scip_javac.InjectScipOptions",
                    "\"\$@\"",
                )
                .joinToString(" ")
        val script = buildString {
            append("#!/usr/bin/env bash\n")
            append("set -eu\n")
            append("LAUNCHER_ARGS=()\n")
            append("NEW_JAVAC_OPTS=\"$newJavacopts-\$RANDOM\"\n")
            append("for arg in \"\$@\"; do\n")
            append("  if [[ \$arg == -J* ]]; then\n")
            append("    LAUNCHER_ARGS+=(\"\$arg\")\n")
            append("  fi\n")
            append("done\n")
            append(injectScipArguments).append('\n')
            append("if [ \${#LAUNCHER_ARGS[@]} -eq 0 ]; then\n")
            append("  javac $javacModuleOptionsText \"@\$NEW_JAVAC_OPTS\"\n")
            append("else\n")
            append(
                "  javac $javacModuleOptionsText \"@\$NEW_JAVAC_OPTS\" \"\${LAUNCHER_ARGS[@]}\"\n"
            )
            append("fi\n")
        }
        Files.write(javac, script.toByteArray(StandardCharsets.UTF_8))
        javac.toFile().setExecutable(true)
        java.toFile().setExecutable(true)
        return javac
    }

    /**
     * The custom javac wrapper reports errors to a specific file if unexpected errors happen. The
     * javac wrapper gets invoked by builds tools like Gradle/Maven, which hide the actual errors
     * from the script because they assume the standard output is from javac. This file is used a
     * side-channel to avoid relying on the error reporting from Gradle/Maven.
     */
    fun reportUnexpectedJavacErrors(reporter: CliReporter, tmp: Path): ProcessResult? {
        val errorpath = javacErrorpath(tmp)
        if (!Files.isRegularFile(errorpath)) return null
        reporter.error("unexpected javac compile errors")
        Files.readAllLines(errorpath).forEach { reporter.error(it) }
        return ProcessResult(1)
    }

    /** Returns the string contents of the scip_java.bzl file on disk. */
    fun bazelAspectFile(tmpDir: Path): String {
        val tmpFile = copyFile(tmpDir, "scip-java/scip_java.bzl")
        val contents = String(Files.readAllBytes(tmpFile), StandardCharsets.UTF_8)
        Files.deleteIfExists(tmpFile)
        return contents
    }

    private fun copyFile(tmpDir: Path, filename: String): Path {
        val input =
            Embedded::class.java.getResourceAsStream("/$filename")
                ?: error("missing embedded resource: /$filename")
        val out = tmpDir.resolve(filename)
        Files.createDirectories(out.parent)
        input.use { Files.copy(it, out, StandardCopyOption.REPLACE_EXISTING) }
        return out
    }
}
