package com.sourcegraph.semanticdb_kotlinc

import java.nio.file.Path
import org.jetbrains.kotlin.fir.extensions.FirExtensionRegistrar

class AnalyzerFirExtensionRegistrar(
    private val sourceroot: Path,
) : FirExtensionRegistrar() {
    override fun ExtensionRegistrarContext.configurePlugin() {
        +AnalyzerParamsProvider.getFactory(sourceroot)
        +::AnalyzerCheckers
    }
}
