package com.sourcegraph.semanticdb_kotlinc

import com.sourcegraph.semanticdb_javac.Semanticdb
import java.lang.IllegalArgumentException
import kotlin.contracts.ExperimentalContracts
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.resolve.jvm.extensions.AnalysisHandlerExtension

@OptIn(ExperimentalCompilerApi::class)
@ExperimentalContracts
class AnalyzerRegistrar(private val callback: (Semanticdb.TextDocument) -> Unit = {}) :
    ComponentRegistrar {
    override fun registerProjectComponents(
        project: MockProject,
        configuration: CompilerConfiguration
    ) {
        AnalysisHandlerExtension.registerExtension(
            project,
            Analyzer(
                sourceroot = configuration[KEY_SOURCES]
                        ?: throw IllegalArgumentException("configuration key $KEY_SOURCES missing"),
                targetroot = configuration[KEY_TARGET]
                        ?: throw IllegalArgumentException("configuration key $KEY_TARGET missing"),
                callback = callback))
    }
}
