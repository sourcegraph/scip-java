package com.sourcegraph.semanticdb_kotlinc

import com.sourcegraph.semanticdb.SemanticdbOptions
import org.jetbrains.kotlin.fir.extensions.FirExtensionRegistrar

class AnalyzerFirExtensionRegistrar(
    private val options: SemanticdbOptions,
) : FirExtensionRegistrar() {
    override fun ExtensionRegistrarContext.configurePlugin() {
        +AnalyzerParamsProvider.getFactory(options)
        +::AnalyzerCheckers
    }
}
