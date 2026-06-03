package com.sourcegraph.semanticdb_kotlinc

import com.sourcegraph.semanticdb.Semanticdb
import com.sourcegraph.semanticdb.SemanticdbPaths
import com.sourcegraph.semanticdb.SemanticdbWriter

import java.io.PrintWriter
import java.io.Writer
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.contracts.ExperimentalContracts
import org.jetbrains.kotlin.KtSourceFile
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageRenderer
import org.jetbrains.kotlin.cli.common.messages.PrintingMessageCollector
import org.jetbrains.kotlin.config.CommonConfigurationKeys
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment

class PostAnalysisExtension(
    private val sourceRoot: Path,
    private val targetRoot: Path,
    private val callback: (Semanticdb.TextDocument) -> Unit
) : IrGenerationExtension {
    @OptIn(ExperimentalContracts::class)
    override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {
        try {
            for ((ktSourceFile, visitor) in AnalyzerCheckers.visitors) {
                try {
                    val document = visitor.build()
                    semanticdbOutPathForFile(ktSourceFile)?.let { outPath ->
                        SemanticdbWriter.writeTextDocument(outPath, document)
                    }
                    callback(document)
                } catch (e: Exception) {
                    handleException(e)
                }
            }
        } catch (e: Exception) {
            handleException(e)
        }
    }

    private fun semanticdbOutPathForFile(file: KtSourceFile): Path? {
        val normalizedPath = Paths.get(file.path).normalize()
        val outPath = SemanticdbPaths.semanticdbPath(targetRoot, sourceRoot, normalizedPath)
        if (outPath.isPresent) {
            return outPath.get()
        }
        System.err.println(
            "given file is not under the sourceroot.\n\tSourceroot: $sourceRoot\n\tFile path: ${file.path}\n\tNormalized file path: $normalizedPath")
        return null
    }

    private val messageCollector =
        CompilerConfiguration()
            .get(
                CommonConfigurationKeys.MESSAGE_COLLECTOR_KEY,
                PrintingMessageCollector(System.err, MessageRenderer.PLAIN_FULL_PATHS, false))

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
            "Please report a bug to https://github.com/sourcegraph/scip-kotlin with the stack trace above.")
        writer.close()
    }
}
