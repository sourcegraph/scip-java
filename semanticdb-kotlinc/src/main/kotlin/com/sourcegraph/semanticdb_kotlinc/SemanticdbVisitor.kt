package com.sourcegraph.semanticdb_kotlinc

import java.nio.file.Path
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
import org.scip_code.scip.Document
import org.scip_code.scip.SymbolRole

/**
 * Per-file accumulator of SCIP occurrences and symbols. The FIR checkers in
 * [AnalyzerCheckers] call into this and the resulting [Document] is written as a
 * `.scip` shard at the end of compilation.
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
    private val documentBuilder = SemanticdbTextDocumentBuilder(sourceroot, file, lineMap, cache)

    private data class SymbolDescriptorPair(
        val firBasedSymbol: FirBasedSymbol<*>?,
        val symbol: Symbol
    )

    fun build(): Document = documentBuilder.build()

    private fun Sequence<SymbolDescriptorPair>?.emitAll(
        element: KtSourceElement,
        role: Int,
        context: CheckerContext,
        enclosingSource: KtSourceElement? = null,
    ): List<Symbol>? =
        this?.onEach { (firBasedSymbol, symbol) ->
                documentBuilder.emitSemanticdbData(firBasedSymbol, symbol, element, role, context, enclosingSource)
            }
            ?.map { it.symbol }
            ?.toList()

    private fun Sequence<Symbol>.with(firBasedSymbol: FirBasedSymbol<*>?) =
        this.map { SymbolDescriptorPair(firBasedSymbol, it) }

    fun visitPackage(pkg: FqName, element: KtSourceElement, context: CheckerContext) {
        cache[pkg].with(null).emitAll(element, SymbolRole.UnspecifiedSymbolRole_VALUE, context)
    }

    fun visitClassReference(firClassSymbol: FirClassLikeSymbol<*>, element: KtSourceElement, context: CheckerContext) {
        cache[firClassSymbol].with(firClassSymbol).emitAll(element, SymbolRole.UnspecifiedSymbolRole_VALUE, context)
    }

    fun visitCallableReference(firClassSymbol: FirCallableSymbol<*>, element: KtSourceElement, context: CheckerContext) {
        cache[firClassSymbol].with(firClassSymbol).emitAll(element, SymbolRole.UnspecifiedSymbolRole_VALUE, context)
    }

    fun visitClassOrObject(firClass: FirClassLikeDeclaration, element: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firClass.symbol].with(firClass.symbol).emitAll(element, SymbolRole.Definition_VALUE, context, enclosingSource)
    }

    fun visitPrimaryConstructor(firConstructor: FirConstructor, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firConstructor.symbol].with(firConstructor.symbol).emitAll(source, SymbolRole.Definition_VALUE, context, enclosingSource)
    }

    fun visitSecondaryConstructor(firConstructor: FirConstructor, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firConstructor.symbol].with(firConstructor.symbol).emitAll(source, SymbolRole.Definition_VALUE, context, enclosingSource)
    }

    fun visitNamedFunction(firFunction: FirFunction, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firFunction.symbol].with(firFunction.symbol).emitAll(source, SymbolRole.Definition_VALUE, context, enclosingSource)
    }

    fun visitProperty(firProperty: FirProperty, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firProperty.symbol].with(firProperty.symbol).emitAll(source, SymbolRole.Definition_VALUE, context, enclosingSource)
    }

    fun visitParameter(firParameter: FirValueParameter, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firParameter.symbol].with(firParameter.symbol).emitAll(source, SymbolRole.Definition_VALUE, context, enclosingSource)
    }

    fun visitTypeParameter(firTypeParameter: FirTypeParameter, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firTypeParameter.symbol]
            .with(firTypeParameter.symbol)
            .emitAll(source, SymbolRole.Definition_VALUE, context, enclosingSource)
    }

    fun visitTypeAlias(firTypeAlias: FirTypeAlias, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firTypeAlias.symbol].with(firTypeAlias.symbol).emitAll(source, SymbolRole.Definition_VALUE, context, enclosingSource)
    }

    fun visitPropertyAccessor(firPropertyAccessor: FirPropertyAccessor, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firPropertyAccessor.symbol]
            .with(firPropertyAccessor.symbol)
            .emitAll(source, SymbolRole.Definition_VALUE, context, enclosingSource)
    }

    fun visitSimpleNameExpression(
        firResolvedNamedReference: FirResolvedNamedReference,
        source: KtSourceElement, context: CheckerContext,
    ) {
        cache[firResolvedNamedReference.resolvedSymbol]
            .with(firResolvedNamedReference.resolvedSymbol)
            .emitAll(source, SymbolRole.UnspecifiedSymbolRole_VALUE, context)
    }
}
