package com.sourcegraph.semanticdb_kotlinc

import org.scip_code.scip.Index
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.contracts.ExperimentalContracts
import org.jetbrains.kotlin.KtSourceElement
import org.jetbrains.kotlin.KtSourceFile
import org.jetbrains.kotlin.fir.analysis.checkers.context.CheckerContext
import org.jetbrains.kotlin.fir.declarations.*
import org.jetbrains.kotlin.fir.references.FirResolvedNamedReference
import org.jetbrains.kotlin.fir.symbols.FirBasedSymbol
import org.jetbrains.kotlin.fir.symbols.impl.FirCallableSymbol
import org.jetbrains.kotlin.fir.symbols.impl.FirClassLikeSymbol
import org.jetbrains.kotlin.name.FqName

/**
 * Walks the FIR analysis tree for a single Kotlin source file and builds a self-contained
 * `Index` shard via [ScipTextDocumentBuilder]. The legacy SemanticDB protobuf path has been
 * removed; the visitor only emits SCIP.
 */
@ExperimentalContracts
class SemanticdbVisitor(
    sourceroot: Path,
    file: KtSourceFile,
    lineMap: LineMap,
    globals: GlobalSymbolsCache,
    locals: LocalSymbolsCache = LocalSymbolsCache()
) {
    private val cache = SymbolsCache(globals, locals)
    private val relativePath: String = computeRelativePath(sourceroot, file)
    private val scipBuilder = ScipTextDocumentBuilder(file, lineMap, cache, relativePath)

    private data class SymbolDescriptorPair(
        val firBasedSymbol: FirBasedSymbol<*>?,
        val symbol: Symbol
    )

    fun buildScipIndex(): Index = scipBuilder.buildIndex()

    fun scipRelativePath(): String = relativePath

    private fun Sequence<SymbolDescriptorPair>?.emitAll(
        element: KtSourceElement,
        role: ScipRole,
        context: CheckerContext,
        enclosingSource: KtSourceElement? = null,
    ): List<Symbol>? =
        this?.onEach { (firBasedSymbol, symbol) ->
                scipBuilder.emitScipData(firBasedSymbol, symbol, element, role, context, enclosingSource)
            }
            ?.map { it.symbol }
            ?.toList()

    private fun Sequence<Symbol>.with(firBasedSymbol: FirBasedSymbol<*>?) =
        this.map { SymbolDescriptorPair(firBasedSymbol, it) }

    fun visitPackage(pkg: FqName, element: KtSourceElement, context: CheckerContext) {
        cache[pkg].with(null).emitAll(element, ScipRole.REFERENCE, context)
    }

    fun visitClassReference(firClassSymbol: FirClassLikeSymbol<*>, element: KtSourceElement, context: CheckerContext) {
        cache[firClassSymbol].with(firClassSymbol).emitAll(element, ScipRole.REFERENCE, context)
    }

    fun visitCallableReference(firClassSymbol: FirCallableSymbol<*>, element: KtSourceElement, context: CheckerContext) {
        cache[firClassSymbol].with(firClassSymbol).emitAll(element, ScipRole.REFERENCE, context)
    }

    fun visitClassOrObject(firClass: FirClassLikeDeclaration, element: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firClass.symbol].with(firClass.symbol).emitAll(element, ScipRole.DEFINITION, context, enclosingSource)
    }

    fun visitPrimaryConstructor(firConstructor: FirConstructor, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firConstructor.symbol].with(firConstructor.symbol).emitAll(source, ScipRole.DEFINITION, context, enclosingSource)
    }

    fun visitSecondaryConstructor(firConstructor: FirConstructor, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firConstructor.symbol].with(firConstructor.symbol).emitAll(source, ScipRole.DEFINITION, context, enclosingSource)
    }

    fun visitNamedFunction(firFunction: FirFunction, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firFunction.symbol].with(firFunction.symbol).emitAll(source, ScipRole.DEFINITION, context, enclosingSource)
    }

    fun visitProperty(firProperty: FirProperty, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firProperty.symbol].with(firProperty.symbol).emitAll(source, ScipRole.DEFINITION, context, enclosingSource)
    }

    fun visitParameter(firParameter: FirValueParameter, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firParameter.symbol].with(firParameter.symbol).emitAll(source, ScipRole.DEFINITION, context, enclosingSource)
    }

    fun visitTypeParameter(firTypeParameter: FirTypeParameter, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firTypeParameter.symbol]
            .with(firTypeParameter.symbol)
            .emitAll(source, ScipRole.DEFINITION, context, enclosingSource)
    }

    fun visitTypeAlias(firTypeAlias: FirTypeAlias, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firTypeAlias.symbol].with(firTypeAlias.symbol).emitAll(source, ScipRole.DEFINITION, context, enclosingSource)
    }

    fun visitPropertyAccessor(firPropertyAccessor: FirPropertyAccessor, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firPropertyAccessor.symbol]
            .with(firPropertyAccessor.symbol)
            .emitAll(source, ScipRole.DEFINITION, context, enclosingSource)
    }

    fun visitSimpleNameExpression(
        firResolvedNamedReference: FirResolvedNamedReference,
        source: KtSourceElement, context: CheckerContext,
    ) {
        cache[firResolvedNamedReference.resolvedSymbol]
            .with(firResolvedNamedReference.resolvedSymbol)
            .emitAll(source, ScipRole.REFERENCE, context)
    }
}

/**
 * Computes the SCIP `Document.relative_path` for [file] relative to [sourceroot]. Falls back to
 * the raw file path if the file is not under the sourceroot (the PostAnalysisExtension warns and
 * skips writing in that case, so the value is best-effort here).
 */
private fun computeRelativePath(sourceroot: Path, file: KtSourceFile): String {
    val normalized = Paths.get(file.path ?: "").normalize()
    return if (normalized.startsWith(sourceroot)) {
        sourceroot.relativize(normalized).toString().replace('\\', '/')
    } else {
        normalized.toString().replace('\\', '/')
    }
}
