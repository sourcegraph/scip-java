package com.sourcegraph.scip_kotlinc

import com.sourcegraph.scip.ScipOptions
import org.jetbrains.kotlin.fir.extensions.FirExtensionRegistrar

class AnalyzerFirExtensionRegistrar(
    private val options: ScipOptions,
) : FirExtensionRegistrar() {
    override fun ExtensionRegistrarContext.configurePlugin() {
        +AnalyzerParamsProvider.getFactory(options)
        +::AnalyzerCheckers
    }
}
