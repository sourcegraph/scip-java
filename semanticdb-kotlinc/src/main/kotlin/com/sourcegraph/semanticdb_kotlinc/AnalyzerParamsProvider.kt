package com.sourcegraph.semanticdb_kotlinc

import com.sourcegraph.semanticdb.SemanticdbOptions
import java.nio.file.Path
import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.extensions.FirExtensionSessionComponent
import org.jetbrains.kotlin.fir.extensions.FirExtensionSessionComponent.Factory

open class AnalyzerParamsProvider(
    session: FirSession,
    val options: SemanticdbOptions,
) : FirExtensionSessionComponent(session) {
    val sourceroot: Path get() = options.sourceroot

    companion object {
        fun getFactory(options: SemanticdbOptions): Factory {
            return Factory { AnalyzerParamsProvider(it, options) }
        }
    }
}

val FirSession.analyzerParamsProvider: AnalyzerParamsProvider by FirSession
    .sessionComponentAccessor()
