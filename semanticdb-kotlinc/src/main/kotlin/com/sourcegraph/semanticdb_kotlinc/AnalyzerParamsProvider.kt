package com.sourcegraph.semanticdb_kotlinc

import java.nio.file.Path
import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.extensions.FirExtensionSessionComponent
import org.jetbrains.kotlin.fir.extensions.FirExtensionSessionComponent.Factory

open class AnalyzerParamsProvider(
    session: FirSession,
    val sourceroot: Path,
) : FirExtensionSessionComponent(session) {
    companion object {
        fun getFactory(sourceroot: Path): Factory {
            return Factory { AnalyzerParamsProvider(it, sourceroot) }
        }
    }
}

val FirSession.analyzerParamsProvider: AnalyzerParamsProvider by FirSession
    .sessionComponentAccessor()
