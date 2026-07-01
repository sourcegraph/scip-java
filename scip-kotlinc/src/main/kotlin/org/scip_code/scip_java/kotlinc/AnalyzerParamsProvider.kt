package org.scip_code.scip_java.kotlinc

import java.nio.file.Path
import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.extensions.FirExtensionSessionComponent
import org.jetbrains.kotlin.fir.extensions.FirExtensionSessionComponent.Factory
import org.scip_code.scip_java.shared.ScipOptions

open class AnalyzerParamsProvider(session: FirSession, val options: ScipOptions) :
    FirExtensionSessionComponent(session) {
    val sourceroot: Path
        get() = options.sourceroot

    companion object {
        fun getFactory(options: ScipOptions): Factory {
            return Factory { AnalyzerParamsProvider(it, options) }
        }
    }
}

val FirSession.analyzerParamsProvider: AnalyzerParamsProvider by
    FirSession.sessionComponentAccessor()
