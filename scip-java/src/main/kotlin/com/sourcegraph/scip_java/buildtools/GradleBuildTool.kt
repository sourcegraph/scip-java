package com.sourcegraph.scip_java.buildtools

import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.scip_java.Embedded
import com.sourcegraph.scip_java.commands.IndexCommand
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class GradleBuildTool(index: IndexCommand) : BuildTool("Gradle", index) {

    override fun usedInCurrentDirectory(): Boolean {
        val gradleFiles = listOf("settings.gradle", "gradlew", "build.gradle", "build.gradle.kts")
        return gradleFiles.any { name -> Files.isRegularFile(index.workingDirectory.resolve(name)) }
    }

    override fun generateScip(): Int {
        val gradleResult = runBuild()
        if (gradleResult.exitCode == 0) {
            reportMissingScipOutput()
        }
        return generateScipFromTargetroot(gradleResult, targetroot(), index)
    }

    /**
     * Diagnose the case where Gradle finished successfully but our SCIP
     * compiler plugin never produced any `.scip` shards. This used to be
     * silently rescued by a `-javaagent` fallback; now it surfaces as a
     * clear error pointing at the two known causes.
     */
    private fun reportMissingScipOutput() {
        if (containsFileWithSuffix(targetroot(), ".scip")) return
        if (!containsFileWithSuffix(index.workingDirectory, ".class")) {
            // Project produced no compiled JVM output — nothing to index, stay quiet.
            return
        }
        index.app.reporter.error(
            """scip-java: Gradle finished successfully but produced no SCIP shards in ${targetroot()}.

This means our SCIP compiler plugin was not attached to one or more JavaCompile tasks. Two known causes:

  1. The 'compileOnly' configuration was already resolved before our init script ran.
     Check the Gradle output above for warnings of the form:
       "scip-java: failed to attach SCIP compiler plugin to project '<name>'"
     Workaround: apply the SCIP plugin earlier (e.g. via a settings plugin),
     or restructure the build so that 'compileOnly' is not resolved at evaluation time.

  2. Another Gradle plugin is replacing the compiler arguments we add (rather than appending).
     Verify with:  ./gradlew compileJava --info | grep -- '-Xplugin:scip'
     If '-Xplugin:scip' is missing from the printed javac command, another plugin
     is overwriting JavaCompile.options.compilerArgs.
""",
        )
    }

    private fun containsFileWithSuffix(root: Path, suffix: String): Boolean {
        if (!Files.isDirectory(root)) return false
        return try {
            Files.find(
                root,
                Integer.MAX_VALUE,
                { p, attrs -> attrs.isRegularFile && p.fileName.toString().endsWith(suffix) },
            ).use { stream -> stream.findFirst().isPresent }
        } catch (_: Exception) {
            false
        }
    }

    fun targetroot(): Path = index.finalTargetroot(defaultTargetroot)

    private val defaultTargetroot: Path = Paths.get("build", "scip-targetroot")

    private fun runBuild(): ProcessResult {
        val gradleWrapperName =
            if (System.getProperty("os.name").lowercase().contains("win")) "gradlew.bat" else "gradlew"
        val gradleWrapper = index.workingDirectory.resolve(gradleWrapperName)
        val gradleCommand =
            if (Files.isRegularFile(gradleWrapper) && Files.isExecutable(gradleWrapper))
                gradleWrapper.toString()
            else "gradle"
        return TemporaryFiles.withDirectory(index) { tmp ->
            runCompileCommand(tmp, gradleCommand)
        }
    }

    private fun runCompileCommand(tmp: Path, gradleCommand: String): ProcessResult {
        val script = initScript(tmp).toString()
        val cmd = mutableListOf<String>()
        cmd += gradleCommand
        cmd += "--no-daemon"
        cmd += "--init-script"
        cmd += script
        cmd += "-Pkotlin.compiler.execution.strategy=in-process"
        cmd += "-Dscip.targetroot=${targetroot()}"
        cmd += index.finalBuildCommand(listOf("clean", "scipPrintDependencies", "scipCompileAll"))

        if (Files.exists(targetroot())) {
            Files.walkFileTree(targetroot(), DeleteVisitor())
        }
        val result = index.app.runProcess(cmd, env = mapOf("TERM" to "dumb"))
        return Embedded.reportUnexpectedJavacErrors(index.app.reporter, tmp) ?: result
    }

    private fun initScript(tmp: Path): Path {
        val pluginpath = Embedded.scipJar(tmp)
        val gradlePluginPath = Embedded.gradlePluginJar(tmp)
        val scipKotlincPath = Embedded.scipKotlincJar(tmp)
        val dependenciesPath = targetroot().resolve("dependencies.txt")
        Files.deleteIfExists(dependenciesPath)

        val script =
            """
             initscript {
                 dependencies{ 
                     classpath(files("${gradlePluginPath}"))
                 }
             }

             import com.sourcegraph.gradle.scip.ScipGradlePlugin

             allprojects {
               project.ext["scipTarget"] = "${targetroot()}"
               project.ext["javacPluginJar"] = "$pluginpath"
               project.ext["dependenciesOut"] = "$dependenciesPath"
               project.ext["scipKotlincJar"] = "$scipKotlincPath"
               apply plugin: ScipGradlePlugin
             }
            """.trimIndent()

        val out = tmp.resolve("init-script.gradle")
        Files.write(out, script.toByteArray(StandardCharsets.UTF_8))
        return out
    }
}
