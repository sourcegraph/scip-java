package com.sourcegraph.semanticdb_kotlinc

import kotlin.contracts.ExperimentalContracts
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.compiler.plugin.CompilerPluginRegistrar
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.fir.extensions.FirExtensionRegistrarAdapter

@OptIn(ExperimentalCompilerApi::class)
@ExperimentalContracts
class AnalyzerRegistrar(private val callback: (Semanticdb.TextDocument) -> Unit = {}) :
    CompilerPluginRegistrar() {
    override fun ExtensionStorage.registerExtensions(configuration: CompilerConfiguration) {
        FirExtensionRegistrarAdapter.registerExtension(
            AnalyzerFirExtensionRegistrar(sourceroot = configuration[KEY_SOURCES]!!)
        )
        IrGenerationExtension.registerExtension(
            PostAnalysisExtension(
                sourceRoot = configuration[KEY_SOURCES]!!,
                targetRoot = configuration[KEY_TARGET]!!,
                callback = callback))
    }

    override val supportsK2: Boolean
        get() = true
}
