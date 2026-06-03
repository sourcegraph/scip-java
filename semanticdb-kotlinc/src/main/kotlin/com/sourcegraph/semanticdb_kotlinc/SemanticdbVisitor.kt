package com.sourcegraph.semanticdb_kotlinc

import org.scip_code.scip.Index
import com.sourcegraph.semanticdb_kotlinc.Semanticdb.SymbolOccurrence.Role
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
    private val documentBuilder = SemanticdbTextDocumentBuilder(sourceroot, file, lineMap, cache)
    private val scipBuilder = ScipTextDocumentBuilder(file, lineMap, cache, relativePath)

    private data class SymbolDescriptorPair(
        val firBasedSymbol: FirBasedSymbol<*>?,
        val symbol: Symbol
    )

    fun build(): Semanticdb.TextDocument {
        return documentBuilder.build()
    }

    fun buildScipIndex(): Index = scipBuilder.buildIndex()

    fun scipRelativePath(): String = relativePath

    private fun Sequence<SymbolDescriptorPair>?.emitAll(
        element: KtSourceElement,
        role: Role,
        context: CheckerContext,
        enclosingSource: KtSourceElement? = null,
    ): List<Symbol>? =
        this?.onEach { (firBasedSymbol, symbol) ->
                documentBuilder.emitSemanticdbData(firBasedSymbol, symbol, element, role, context, enclosingSource)
                scipBuilder.emitScipData(firBasedSymbol, symbol, element, role, context, enclosingSource)
            }
            ?.map { it.symbol }
            ?.toList()

    private fun Sequence<Symbol>.with(firBasedSymbol: FirBasedSymbol<*>?) =
        this.map { SymbolDescriptorPair(firBasedSymbol, it) }

    fun visitPackage(pkg: FqName, element: KtSourceElement, context: CheckerContext) {
        cache[pkg].with(null).emitAll(element, Role.REFERENCE, context)
    }

    fun visitClassReference(firClassSymbol: FirClassLikeSymbol<*>, element: KtSourceElement, context: CheckerContext) {
        cache[firClassSymbol].with(firClassSymbol).emitAll(element, Role.REFERENCE, context)
    }

    fun visitCallableReference(firClassSymbol: FirCallableSymbol<*>, element: KtSourceElement, context: CheckerContext) {
        cache[firClassSymbol].with(firClassSymbol).emitAll(element, Role.REFERENCE, context)
    }

    fun visitClassOrObject(firClass: FirClassLikeDeclaration, element: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firClass.symbol].with(firClass.symbol).emitAll(element, Role.DEFINITION, context, enclosingSource)
    }

    fun visitPrimaryConstructor(firConstructor: FirConstructor, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        // if the constructor is not denoted by the 'constructor' keyword, we want to link it to the
        // class ident
        cache[firConstructor.symbol].with(firConstructor.symbol).emitAll(source, Role.DEFINITION, context, enclosingSource)
    }

    fun visitSecondaryConstructor(firConstructor: FirConstructor, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firConstructor.symbol].with(firConstructor.symbol).emitAll(source, Role.DEFINITION, context, enclosingSource)
    }

    fun visitNamedFunction(firFunction: FirFunction, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firFunction.symbol].with(firFunction.symbol).emitAll(source, Role.DEFINITION, context, enclosingSource)
    }

    fun visitProperty(firProperty: FirProperty, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firProperty.symbol].with(firProperty.symbol).emitAll(source, Role.DEFINITION, context, enclosingSource)
    }

    fun visitParameter(firParameter: FirValueParameter, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firParameter.symbol].with(firParameter.symbol).emitAll(source, Role.DEFINITION, context, enclosingSource)
    }

    fun visitTypeParameter(firTypeParameter: FirTypeParameter, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firTypeParameter.symbol]
            .with(firTypeParameter.symbol)
            .emitAll(source, Role.DEFINITION, context, enclosingSource)
    }

    fun visitTypeAlias(firTypeAlias: FirTypeAlias, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firTypeAlias.symbol].with(firTypeAlias.symbol).emitAll(source, Role.DEFINITION, context, enclosingSource)
    }

    fun visitPropertyAccessor(firPropertyAccessor: FirPropertyAccessor, source: KtSourceElement, context: CheckerContext, enclosingSource: KtSourceElement? = null) {
        cache[firPropertyAccessor.symbol]
            .with(firPropertyAccessor.symbol)
            .emitAll(source, Role.DEFINITION, context, enclosingSource)
    }

    fun visitSimpleNameExpression(
        firResolvedNamedReference: FirResolvedNamedReference,
        source: KtSourceElement, context: CheckerContext,
    ) {
        cache[firResolvedNamedReference.resolvedSymbol]
            .with(firResolvedNamedReference.resolvedSymbol)
            .emitAll(source, Role.REFERENCE, context)
    }
}

/**
 * SCIP `Document.relative_path` for [file] relative to [sourceroot]. Best-effort: falls back to
 * the raw path when the file is outside the sourceroot (PostAnalysisExtension skips writing then).
 */
private fun computeRelativePath(sourceroot: Path, file: KtSourceFile): String {
    val normalized = Paths.get(file.path ?: "").normalize()
    return if (normalized.startsWith(sourceroot)) {
        sourceroot.relativize(normalized).toString().replace('\\', '/')
    } else {
        normalized.toString().replace('\\', '/')
    }
}

