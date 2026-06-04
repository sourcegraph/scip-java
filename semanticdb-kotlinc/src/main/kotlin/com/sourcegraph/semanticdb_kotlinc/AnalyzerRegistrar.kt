package com.sourcegraph.semanticdb_kotlinc

import com.sourcegraph.semanticdb.SemanticdbOptions
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.compiler.plugin.CompilerPluginRegistrar
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.fir.extensions.FirExtensionRegistrarAdapter
import org.scip_code.scip.Document

@OptIn(ExperimentalCompilerApi::class)
class AnalyzerRegistrar(private val callback: (Document) -> Unit = {}) :
    CompilerPluginRegistrar() {
    override fun ExtensionStorage.registerExtensions(configuration: CompilerConfiguration) {
        val options =
            SemanticdbOptions().apply {
                sourceroot = configuration[KEY_SOURCES]!!
                targetroot = configuration[KEY_TARGET]!!
            }
        FirExtensionRegistrarAdapter.registerExtension(AnalyzerFirExtensionRegistrar(options))
        IrGenerationExtension.registerExtension(
            PostAnalysisExtension(
                sourceRoot = options.sourceroot,
                targetRoot = options.targetroot,
                callback = callback))
    }

    override val supportsK2: Boolean
        get() = true
}
