package com.sourcegraph.semanticdb_kotlinc

import com.sourcegraph.semanticdb_kotlinc.SemanticdbSymbolDescriptor.Kind
import java.lang.System.err
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import org.jetbrains.kotlin.fir.analysis.checkers.declaration.isLocalMember
import org.jetbrains.kotlin.fir.analysis.checkers.getContainingSymbol
import org.jetbrains.kotlin.fir.declarations.DirectDeclarationsAccess
import org.jetbrains.kotlin.fir.declarations.FirClass
import org.jetbrains.kotlin.fir.declarations.FirDeclarationOrigin
import org.jetbrains.kotlin.fir.declarations.utils.memberDeclarationNameOrNull
import org.jetbrains.kotlin.fir.packageFqName
import org.jetbrains.kotlin.fir.resolve.getContainingDeclaration
import org.jetbrains.kotlin.fir.resolve.providers.symbolProvider
import org.jetbrains.kotlin.fir.symbols.FirBasedSymbol
import org.jetbrains.kotlin.fir.symbols.SymbolInternals
import org.jetbrains.kotlin.fir.symbols.impl.*
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.util.capitalizeDecapitalize.capitalizeAsciiOnly

@ExperimentalContracts
class GlobalSymbolsCache(testing: Boolean = false) : Iterable<Symbol> {
    private val globals =
        if (testing) LinkedHashMap<FirBasedSymbol<*>, Symbol>()
        else HashMap<FirBasedSymbol<*>, Symbol>()
    private val packages =
        if (testing) LinkedHashMap<FqName, Symbol>() else HashMap<FqName, Symbol>()

    operator fun get(symbol: FirBasedSymbol<*>, locals: LocalSymbolsCache): Sequence<Symbol> =
        sequence {
        emitSymbols(symbol, locals)
    }

    operator fun get(symbol: FqName): Sequence<Symbol> = sequence { emitSymbols(symbol) }

    /**
     * called whenever a new symbol should be yielded in the sequence e.g. for properties we also
     * want to yield for every implicit getter/setter, but wouldn't want to yield for e.g. the
     * package symbol parts that a class symbol is composed of.
     */
    @OptIn(SymbolInternals::class)
    private suspend fun SequenceScope<Symbol>.emitSymbols(
        symbol: FirBasedSymbol<*>,
        locals: LocalSymbolsCache
    ) {
        yield(getSymbol(symbol, locals))
        if (symbol is FirPropertySymbol) {
            if (symbol.fir.getter?.origin is FirDeclarationOrigin.Synthetic)
                emitSymbols(symbol.fir.getter!!.symbol, locals)
            if (symbol.fir.setter?.origin is FirDeclarationOrigin.Synthetic)
                emitSymbols(symbol.fir.setter!!.symbol, locals)
        }
    }

    private suspend fun SequenceScope<Symbol>.emitSymbols(symbol: FqName) {
        yield(getSymbol(symbol))
    }

    /**
     * Entrypoint for building or looking-up a symbol without yielding a value in the sequence.
     * Called recursively for every part of a symbol, unless a cached result short circuits.
     */
    private fun getSymbol(symbol: FirBasedSymbol<*>, locals: LocalSymbolsCache): Symbol {
        globals[symbol]?.let {
            return it
        }
        locals[symbol]?.let {
            return it
        }
        return uncachedSemanticdbSymbol(symbol, locals).also {
            if (it.isGlobal()) globals[symbol] = it
        }
    }
    private fun getSymbol(symbol: FqName): Symbol {
        packages[symbol]?.let {
            return it
        }
        return uncachedSemanticdbSymbol(symbol).also { if (it.isGlobal()) packages[symbol] = it }
    }

    private fun skip(symbol: FirBasedSymbol<*>?): Boolean {
        contract { returns(false) implies (symbol != null) }
        return symbol == null || symbol is FirAnonymousFunctionSymbol
    }

    @OptIn(SymbolInternals::class)
    private fun uncachedSemanticdbSymbol(
        symbol: FirBasedSymbol<*>?,
        locals: LocalSymbolsCache
    ): Symbol {
        if (skip(symbol)) return Symbol.NONE

        if (symbol.fir.isLocalMember) return locals + symbol

        val owner = getParentSymbol(symbol, locals)

        if (owner.isLocal() || owner == Symbol.NONE) return locals + symbol

        val semanticdbDescriptor = semanticdbDescriptor(symbol)

        return Symbol.createGlobal(owner, semanticdbDescriptor)
    }

    private fun uncachedSemanticdbSymbol(symbol: FqName): Symbol {
        if (symbol.isRoot) return Symbol.ROOT_PACKAGE

        val owner = this.getSymbol(symbol.parent())
        return Symbol.createGlobal(
            owner, SemanticdbSymbolDescriptor(Kind.PACKAGE, symbol.shortName().asString()))
    }

    /**
     * Returns the parent DeclarationDescriptor for a given DeclarationDescriptor. For most
     * descriptor types, this simply returns the 'containing' descriptor. For Module- or
     * PackageFragmentDescriptors, it returns the descriptor for the parent fqName of the current
     * descriptors fqName e.g. for the fqName `test.sample.main`, the parent fqName would be
     * `test.sample`.
     */
    @OptIn(SymbolInternals::class)
    private fun getParentSymbol(symbol: FirBasedSymbol<*>, locals: LocalSymbolsCache): Symbol {
        when (symbol) {
            is FirTypeParameterSymbol ->
                return getSymbol(symbol.containingDeclarationSymbol, locals)
            is FirValueParameterSymbol -> return getSymbol(symbol.containingDeclarationSymbol, locals)
            is FirCallableSymbol -> {
                val session = symbol.fir.moduleData.session
                return symbol.getContainingSymbol(session)?.let { getSymbol(it, locals) }
                    ?: getSymbol(symbol.packageFqName())
            }
            is FirClassLikeSymbol -> {
                val session = symbol.fir.moduleData.session
                return symbol.getContainingDeclaration(session)?.let { getSymbol(it, locals) }
                    ?: getSymbol(symbol.packageFqName())
            }
            is FirFileSymbol -> {
                return getSymbol(symbol.fir.packageFqName)
            }
            else -> return Symbol.NONE
        }
    }

    @OptIn(SymbolInternals::class)
    private fun semanticdbDescriptor(symbol: FirBasedSymbol<*>): SemanticdbSymbolDescriptor {
        return when {
            symbol is FirAnonymousObjectSymbol ->
                symbol.source?.let { source ->
                    SemanticdbSymbolDescriptor(Kind.TYPE, "<anonymous object at ${source.startOffset}>")
                } ?: SemanticdbSymbolDescriptor.NONE
            symbol is FirClassLikeSymbol ->
                SemanticdbSymbolDescriptor(Kind.TYPE, symbol.classId.shortClassName.asString())
            symbol is FirPropertyAccessorSymbol && symbol.isSetter ->
                SemanticdbSymbolDescriptor(
                    Kind.METHOD,
                    "set" + symbol.propertySymbol.fir.name.toString().capitalizeAsciiOnly())
            symbol is FirPropertyAccessorSymbol && symbol.isGetter ->
                SemanticdbSymbolDescriptor(
                    Kind.METHOD,
                    "get" + symbol.propertySymbol.fir.name.toString().capitalizeAsciiOnly())
            symbol is FirConstructorSymbol ->
                SemanticdbSymbolDescriptor(Kind.METHOD, "<init>", methodDisambiguator(symbol))
            symbol is FirFunctionSymbol ->
                SemanticdbSymbolDescriptor(
                    Kind.METHOD, symbol.name.toString(), methodDisambiguator(symbol))
            symbol is FirTypeParameterSymbol ->
                SemanticdbSymbolDescriptor(Kind.TYPE_PARAMETER, symbol.name.toString())
            symbol is FirValueParameterSymbol ->
                SemanticdbSymbolDescriptor(Kind.PARAMETER, symbol.name.toString())
            symbol is FirVariableSymbol ->
                SemanticdbSymbolDescriptor(Kind.TERM, symbol.name.toString())
            else -> {
                err.println("unknown symbol kind ${symbol.javaClass.simpleName}")
                SemanticdbSymbolDescriptor.NONE
            }
        }
    }

    @OptIn(SymbolInternals::class, DirectDeclarationsAccess::class)
    private fun methodDisambiguator(symbol: FirFunctionSymbol<*>): String {
        val session = symbol.moduleData.session

        val siblings =
            when (val containingSymbol = symbol.getContainingSymbol(session)) {
                is FirClassSymbol ->
                    (containingSymbol.fir as FirClass).declarations.map { it.symbol }
                is FirFileSymbol -> containingSymbol.fir.declarations.map { it.symbol }
                null ->
                    symbol.moduleData.session.symbolProvider.getTopLevelCallableSymbols(
                        symbol.packageFqName(), symbol.name)
                else -> return "()"
            }

        var count = 0
        var found = false
        for (decl in siblings) {
            if (decl == symbol) {
                found = true
                break
            }

            if (decl.memberDeclarationNameOrNull?.equals(symbol.name) == true) {
                count++
            }
        }

        if (count == 0 || !found) return "()"
        return "(+${count})"
    }

    override fun iterator(): Iterator<Symbol> = globals.values.iterator()
}

class LocalSymbolsCache : Iterable<Symbol> {
    private val symbols = HashMap<FirBasedSymbol<*>, Symbol>()
    private var localsCounter = 0

    val iterator: Iterable<Map.Entry<FirBasedSymbol<*>, Symbol>>
        get() = symbols.asIterable()

    val size: Int
        get() = symbols.size

    operator fun get(symbol: FirBasedSymbol<*>): Symbol? = symbols[symbol]

    operator fun plus(symbol: FirBasedSymbol<*>): Symbol {
        val result = Symbol.createLocal(localsCounter++)
        symbols[symbol] = result
        return result
    }

    override fun iterator(): Iterator<Symbol> = symbols.values.iterator()
}

@ExperimentalContracts
class SymbolsCache(private val globals: GlobalSymbolsCache, private val locals: LocalSymbolsCache) {
    operator fun get(symbol: FirBasedSymbol<*>) = globals[symbol, locals]
    operator fun get(symbol: FqName) = globals[symbol]
}
