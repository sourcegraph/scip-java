package org.scip_code.scip_java.kotlinc

import org.jetbrains.kotlin.fir.extensions.FirExtensionRegistrar
import org.scip_code.scip_java.shared.ScipOptions

class AnalyzerFirExtensionRegistrar(private val options: ScipOptions) : FirExtensionRegistrar() {
    override fun ExtensionRegistrarContext.configurePlugin() {
        +AnalyzerParamsProvider.getFactory(options)
        +::AnalyzerCheckers
    }
}
