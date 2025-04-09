package com.sourcegraph.semanticdb_kotlinc

import com.sourcegraph.semanticdb_javac.Semanticdb
import java.io.PrintWriter
import java.io.Writer
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.contracts.ExperimentalContracts
import org.jetbrains.kotlin.analyzer.AnalysisResult
import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageRenderer
import org.jetbrains.kotlin.cli.common.messages.PrintingMessageCollector
import org.jetbrains.kotlin.com.intellij.openapi.project.Project
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.resolve.BindingTrace
import org.jetbrains.kotlin.resolve.jvm.extensions.AnalysisHandlerExtension

@ExperimentalContracts
class Analyzer(
    val sourceroot: Path,
    val targetroot: Path,
    val callback: (Semanticdb.TextDocument) -> Unit
) : AnalysisHandlerExtension {
    private val globals = GlobalSymbolsCache()

    private val messageCollector =
        CompilerConfiguration()
            .get(
                CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY,
                PrintingMessageCollector(System.err, MessageRenderer.PLAIN_FULL_PATHS, false))

    override fun analysisCompleted(
        project: Project,
        module: ModuleDescriptor,
        bindingTrace: BindingTrace,
        files: Collection<KtFile>
    ): AnalysisResult? =
        try {
            val resolver = DescriptorResolver(bindingTrace).also { globals.resolver = it }
            for (file in files) {
                try {
                    val lineMap = LineMap(project, file)
                    val document =
                        SemanticdbVisitor(sourceroot, resolver, file, lineMap, globals).build()
                    semanticdbOutPathForFile(file)?.apply {
                        val builder = Semanticdb.TextDocuments.newBuilder()
                        builder.addDocuments(document)
                        Files.write(this, builder.build().toByteArray())
                    }
                    callback(document)
                } catch (e: Exception) {
                    handleException(e)
                }
            }

            super.analysisCompleted(project, module, bindingTrace, files)
        } catch (e: Exception) {
            handleException(e)
            super.analysisCompleted(project, module, bindingTrace, files)
        }

    private fun semanticdbOutPathForFile(file: KtFile): Path? {
        val normalizedPath = Paths.get(file.virtualFilePath).normalize()
        if (normalizedPath.startsWith(sourceroot)) {
            val relative = sourceroot.relativize(normalizedPath)
            val filename = relative.fileName.toString() + ".semanticdb"
            val semanticdbOutPath =
                targetroot
                    .resolve("META-INF")
                    .resolve("semanticdb")
                    .resolve(relative)
                    .resolveSibling(filename)

            Files.createDirectories(semanticdbOutPath.parent)
            return semanticdbOutPath
        }
        System.err.println(
            "given file is not under the sourceroot.\n\tSourceroot: $sourceroot\n\tFile path: ${file.virtualFilePath}\n\tNormalized file path: $normalizedPath")
        return null
    }

    private fun handleException(e: Exception) {
        val writer =
            PrintWriter(
                object : Writer() {
                    val buf = StringBuffer()
                    override fun close() =
                        messageCollector.report(CompilerMessageSeverity.EXCEPTION, buf.toString())

                    override fun flush() = Unit
                    override fun write(data: CharArray, offset: Int, len: Int) {
                        buf.append(data, offset, len)
                    }
                },
                false)
        writer.println("Exception in semanticdb-kotlin compiler plugin:")
        e.printStackTrace(writer)
        writer.println(
            "Please report a bug to https://github.com/sourcegraph/lsif-kotlin with the stack trace above.")
        writer.close()
    }
}
