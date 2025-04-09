package com.sourcegraph.semanticdb_kotlinc.test

import com.sourcegraph.semanticdb_kotlinc.*
import com.tschuchort.compiletesting.KotlinCompilation
import com.tschuchort.compiletesting.SourceFile
import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe
import java.nio.file.Path
import kotlin.contracts.ExperimentalContracts
import org.intellij.lang.annotations.Language
import org.jetbrains.kotlin.analyzer.AnalysisResult
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.com.intellij.openapi.project.Project
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.resolve.BindingTrace
import org.jetbrains.kotlin.resolve.jvm.extensions.AnalysisHandlerExtension
import org.junit.jupiter.api.Assumptions.assumeFalse
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest

data class ExpectedSymbols(
    val testName: String,
    val source: SourceFile,
    val symbolsCacheData: SymbolCacheData? = null,
    val semanticdb: SemanticdbData? = null
) {
    data class SemanticdbData(
        val expectedOccurrences: List<Semanticdb.SymbolOccurrence>? = null,
        val expectedSymbols: List<Semanticdb.SymbolInformation>? = null
    )

    data class SymbolCacheData(
        val expectedGlobals: List<Symbol>? = null,
        val localsCount: Int? = null
    )
}

fun SourceFile.Companion.testKt(@Language("kotlin") contents: String): SourceFile =
    kotlin("Test.kt", contents)

@ExperimentalCompilerApi
@ExperimentalContracts
fun List<ExpectedSymbols>.mapCheckExpectedSymbols(): List<DynamicTest> =
    this.flatMap { (testName, source, symbolsData, semanticdbData) ->
        val globals = GlobalSymbolsCache(testing = true)
        val locals = LocalSymbolsCache()
        lateinit var document: Semanticdb.TextDocument
        val compilation = configureTestCompiler(source, globals, locals) { document = it }
        listOf(
            dynamicTest("$testName - compilation") {
                val result = shouldNotThrowAny { compilation.compile() }
                result.exitCode shouldBe KotlinCompilation.ExitCode.OK
            },
            dynamicTest("$testName - symbols") {
                symbolsData?.apply {
                    println(
                        "checking symbols: ${expectedGlobals?.size ?: 0} globals and presence of $localsCount locals")
                    checkContainsExpectedSymbols(globals, locals, expectedGlobals, localsCount)
                }
                    ?: assumeFalse(true)
            },
            dynamicTest("$testName - semanticdb") {
                semanticdbData?.apply {
                    println(
                        "checking semanticdb: ${expectedOccurrences?.size ?: 0} occurrences and ${expectedSymbols?.size ?: 0} symbols")
                    checkContainsExpectedSemanticdb(document, expectedOccurrences, expectedSymbols)
                }
                    ?: assumeFalse(true)
            })
    }

@ExperimentalContracts
fun checkContainsExpectedSymbols(
    globals: GlobalSymbolsCache,
    locals: LocalSymbolsCache,
    expectedGlobals: List<Symbol>?,
    localsCount: Int? = null
) {
    assertSoftly(globals) { expectedGlobals?.let { this.shouldContainInOrder(it) } }
    localsCount?.also { locals.size shouldBe it }
}

@ExperimentalContracts
fun checkContainsExpectedSemanticdb(
    document: Semanticdb.TextDocument,
    expectedOccurrences: List<Semanticdb.SymbolOccurrence>?,
    expectedSymbols: List<Semanticdb.SymbolInformation>?
) {
    assertSoftly(document.occurrencesList) {
        expectedOccurrences?.let { this.shouldContainInOrder(it) }
    }
    assertSoftly(document.symbolsList) { expectedSymbols?.let { this.shouldContainInOrder(it) } }
}

@OptIn(ExperimentalCompilerApi::class)
@ExperimentalContracts
private fun configureTestCompiler(
    source: SourceFile,
    globals: GlobalSymbolsCache,
    locals: LocalSymbolsCache,
    hook: (Semanticdb.TextDocument) -> Unit = {}
): KotlinCompilation {
    val compilation =
        KotlinCompilation().apply {
            sources = listOf(source)
            inheritClassPath = true
            verbose = false
        }

    val analyzer = semanticdbVisitorAnalyzer(globals, locals, compilation.workingDir.toPath(), hook)
    compilation.apply { componentRegistrars = listOf(analyzer) }
    return compilation
}

@OptIn(ExperimentalCompilerApi::class)
@ExperimentalContracts
fun semanticdbVisitorAnalyzer(
    globals: GlobalSymbolsCache,
    locals: LocalSymbolsCache,
    sourceroot: Path,
    hook: (Semanticdb.TextDocument) -> Unit = {}
): ComponentRegistrar {
    return object : ComponentRegistrar {
        override fun registerProjectComponents(
            project: MockProject,
            configuration: CompilerConfiguration
        ) {
            AnalysisHandlerExtension.registerExtension(
                project,
                object : AnalysisHandlerExtension {
                    override fun analysisCompleted(
                        project: Project,
                        module: ModuleDescriptor,
                        bindingTrace: BindingTrace,
                        files: Collection<KtFile>
                    ): AnalysisResult? {
                        val resolver =
                            DescriptorResolver(bindingTrace).also { globals.resolver = it }
                        val lineMap = LineMap(project, files.first())
                        hook(
                            SemanticdbVisitor(
                                    sourceroot, resolver, files.first(), lineMap, globals, locals)
                                .build())
                        return super.analysisCompleted(project, module, bindingTrace, files)
                    }
                })
        }
    }
}
