package com.sourcegraph.semanticdb_kotlinc.test

import com.sourcegraph.semanticdb_kotlinc.*
import com.sourcegraph.semanticdb_kotlinc.AnalyzerCheckers.Companion.visitors
import com.tschuchort.compiletesting.KotlinCompilation
import com.tschuchort.compiletesting.SourceFile
import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.contracts.ExperimentalContracts
import org.intellij.lang.annotations.Language
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.compiler.plugin.CompilerPluginRegistrar
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.diagnostics.DiagnosticReporter
import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.analysis.checkers.MppCheckerKind
import org.jetbrains.kotlin.fir.analysis.checkers.context.CheckerContext
import org.jetbrains.kotlin.fir.analysis.checkers.declaration.DeclarationCheckers
import org.jetbrains.kotlin.fir.analysis.checkers.declaration.FirFileChecker
import org.jetbrains.kotlin.fir.declarations.FirFile
import org.jetbrains.kotlin.fir.extensions.FirExtensionRegistrar
import org.jetbrains.kotlin.fir.extensions.FirExtensionRegistrarAdapter
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
    compilation.apply { compilerPluginRegistrars = listOf(analyzer) }
    return compilation
}

@OptIn(ExperimentalContracts::class)
private class TestAnalyzerDeclarationCheckers(
    globals: GlobalSymbolsCache,
    locals: LocalSymbolsCache,
    sourceRoot: Path
) : AnalyzerCheckers.AnalyzerDeclarationCheckers(sourceRoot) {
    override val fileCheckers: Set<FirFileChecker> =
        setOf(
            object : FirFileChecker(MppCheckerKind.Common) {
                context(context: CheckerContext, reporter: DiagnosticReporter)
                override fun check(declaration: FirFile) {
                    val ktFile = declaration.sourceFile ?: return
                    val lineMap = LineMap(declaration)
                    val visitor = SemanticdbVisitor(sourceRoot, ktFile, lineMap, globals, locals)
                    visitors[ktFile] = visitor
                }
            },
            AnalyzerCheckers.SemanticImportsChecker())
}

private class TestAnalyzerCheckers(session: FirSession) : AnalyzerCheckers(session) {
    @OptIn(ExperimentalContracts::class)
    override val declarationCheckers: DeclarationCheckers
        get() =
            TestAnalyzerDeclarationCheckers(
                session.testAnalyzerParamsProvider.globals,
                session.testAnalyzerParamsProvider.locals,
                session.testAnalyzerParamsProvider.sourceroot
            )
}

@OptIn(ExperimentalContracts::class)
class TestAnalyzerParamsProvider(
    session: FirSession,
    var globals: GlobalSymbolsCache,
    var locals: LocalSymbolsCache,
    sourceroot: Path,
) : AnalyzerParamsProvider(session, sourceroot) {
    companion object {
        fun getFactory(
            globals: GlobalSymbolsCache,
            locals: LocalSymbolsCache,
            sourceroot: Path,
        ): Factory {
            return Factory { TestAnalyzerParamsProvider(it, globals, locals, sourceroot) }
        }
    }
}

val FirSession.testAnalyzerParamsProvider: TestAnalyzerParamsProvider by FirSession
    .sessionComponentAccessor()

@OptIn(ExperimentalCompilerApi::class)
@ExperimentalContracts
fun semanticdbVisitorAnalyzer(
    globals: GlobalSymbolsCache,
    locals: LocalSymbolsCache,
    sourceroot: Path,
    hook: (Semanticdb.TextDocument) -> Unit = {}
): CompilerPluginRegistrar {
    return object : CompilerPluginRegistrar() {
        override fun ExtensionStorage.registerExtensions(configuration: CompilerConfiguration) {
            FirExtensionRegistrarAdapter.registerExtension(
                object : FirExtensionRegistrar() {
                    override fun ExtensionRegistrarContext.configurePlugin() {
                        +TestAnalyzerParamsProvider.getFactory(globals, locals, sourceroot)
                        +::TestAnalyzerCheckers
                    }
                })
            IrGenerationExtension.registerExtension(
                PostAnalysisExtension(
                    sourceRoot = sourceroot, targetRoot = Paths.get(""), callback = hook))
        }

        override val supportsK2: Boolean
            get() = true
    }
}
