package com.sourcegraph.semanticdb_kotlinc

import org.scip_code.scip.Document
import org.scip_code.scip.Index
import org.scip_code.scip.Occurrence
import org.scip_code.scip.Relationship
import org.scip_code.scip.Signature
import org.scip_code.scip.SymbolInformation
import org.scip_code.scip.SymbolRole
import kotlin.contracts.ExperimentalContracts
import org.jetbrains.kotlin.KtSourceElement
import org.jetbrains.kotlin.descriptors.ClassKind
import org.jetbrains.kotlin.fir.analysis.checkers.context.CheckerContext
import org.jetbrains.kotlin.fir.analysis.checkers.directOverriddenSymbolsSafe
import org.jetbrains.kotlin.fir.analysis.checkers.toClassLikeSymbol
import org.jetbrains.kotlin.fir.analysis.getChild
import org.jetbrains.kotlin.fir.renderer.*
import org.jetbrains.kotlin.fir.symbols.FirBasedSymbol
import org.jetbrains.kotlin.fir.symbols.SymbolInternals
import org.jetbrains.kotlin.fir.symbols.impl.*
import org.jetbrains.kotlin.fir.types.impl.FirImplicitAnyTypeRef
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.text

/**
 * Builds a single-document [Index] shard for one Kotlin source from callbacks fired by
 * [SemanticdbVisitor]. Symbols use the [ScipSymbols.PLACEHOLDER_PREFIX] scheme; signature
 * documentation is rendered via [FirRenderer] as raw Kotlin source.
 */
@ExperimentalContracts
class ScipTextDocumentBuilder(
    private val lineMap: LineMap,
    private val cache: SymbolsCache,
    private val relativePath: String,
) {
    private val occurrences = ScipOccurrences()
    // Keyed by symbol so re-encounters (multi-round compilation, synthetic accessors) don't dup.
    private val symbols = LinkedHashMap<String, SymbolInformation>()

    fun buildIndex(): Index =
        Index.newBuilder()
            .addDocuments(
                Document.newBuilder()
                    .setRelativePath(relativePath)
                    .setLanguage(LANGUAGE_KOTLIN)
                    .addAllOccurrences(occurrences.values())
                    .addAllSymbols(symbols.values)
                    .build())
            .build()

    fun emitScipData(
        firBasedSymbol: FirBasedSymbol<*>?,
        symbol: Symbol,
        element: KtSourceElement,
        roles: Int,
        context: CheckerContext,
        enclosingSource: KtSourceElement? = null,
    ) {
        if (symbol == Symbol.NONE) return

        emitOccurrence(symbol, element, roles, enclosingSource)
        if (roles == SymbolRole.Definition_VALUE) {
            emitSymbolInformation(firBasedSymbol, symbol, element, context)
        }
    }

    private fun emitOccurrence(
        symbol: Symbol,
        element: KtSourceElement,
        roles: Int,
        enclosingSource: KtSourceElement?,
    ) {
        val builder =
            Occurrence
                .newBuilder()
                .addAllRange(scipRange(element))
                .setSymbol(ScipSymbols.format(symbol))
                .setSymbolRoles(roles)
        if (enclosingSource != null) {
            builder.addAllEnclosingRange(scipEnclosingRange(enclosingSource))
        }
        occurrences.add(builder.build())
    }

    @OptIn(SymbolInternals::class)
    private fun emitSymbolInformation(
        firBasedSymbol: FirBasedSymbol<*>?,
        symbol: Symbol,
        element: KtSourceElement,
        context: CheckerContext,
    ) {
        val scipSymbolStr = ScipSymbols.format(symbol)
        val builder =
            SymbolInformation
                .newBuilder()
                .setSymbol(scipSymbolStr)
                .setDisplayName(displayName(firBasedSymbol, element))
                .setKind(scipKind(firBasedSymbol))

        val signature = signatureText(firBasedSymbol)
        if (signature.isNotEmpty()) {
            builder.setSignatureDocumentation(
                Signature.newBuilder().setLanguage(LANGUAGE_KOTLIN).setText(signature))
        }

        val kdoc = kdocText(firBasedSymbol)
        if (kdoc.isNotEmpty()) {
            builder.addDocumentation(kdoc)
        }

        val supportsRefRel = supportsReferenceRelationship(firBasedSymbol)
        for (parent in parentOrOverriddenSymbols(firBasedSymbol, context)) {
            val parentSymbolStr = ScipSymbols.format(parent)
            if (parentSymbolStr.isEmpty()) continue
            builder.addRelationships(
                Relationship.newBuilder()
                    .setSymbol(parentSymbolStr)
                    .setIsImplementation(true)
                    .setIsReference(supportsRefRel))
        }

        // Last write wins: newly discovered metadata takes precedence.
        symbols[scipSymbolStr] = builder.build()
    }

    @OptIn(SymbolInternals::class)
    private fun parentOrOverriddenSymbols(
        firBasedSymbol: FirBasedSymbol<*>?,
        context: CheckerContext,
    ): List<Symbol> {
        return when (firBasedSymbol) {
            is FirClassSymbol ->
                firBasedSymbol
                    .resolvedSuperTypeRefs
                    .filter { it !is FirImplicitAnyTypeRef }
                    .mapNotNull { it.toClassLikeSymbol(firBasedSymbol.moduleData.session) }
                    .flatMap { cache[it].toList() }
            is FirFunctionSymbol<*> ->
                firBasedSymbol
                    .directOverriddenSymbolsSafe(context)
                    .flatMap { cache[it].toList() }
            else -> emptyList()
        }
    }

    private fun supportsReferenceRelationship(firBasedSymbol: FirBasedSymbol<*>?): Boolean {
        return when (firBasedSymbol) {
            is FirClassSymbol,
            is FirTypeAliasSymbol -> false
            else -> true
        }
    }

    private fun scipRange(element: KtSourceElement): List<Int> {
        val startLine = lineMap.lineNumber(element) - 1
        val startCharacter = lineMap.startCharacter(element)
        val endCharacter = lineMap.endCharacter(element)
        // SemanticdbVisitor only emits single-line ranges, so 3 ints suffice.
        return listOf(startLine, startCharacter, endCharacter)
    }

    private fun scipEnclosingRange(element: KtSourceElement): List<Int> {
        val startLine = lineMap.lineNumber(element) - 1
        val startCharacter = lineMap.startCharacter(element)
        val endLine = lineMap.lineNumberForOffset(element.endOffset) - 1
        val endCharacter = lineMap.columnForOffset(element.endOffset)
        return if (startLine == endLine) {
            listOf(startLine, startCharacter, endCharacter)
        } else {
            listOf(startLine, startCharacter, endLine, endCharacter)
        }
    }

    @OptIn(SymbolInternals::class)
    private fun signatureText(firBasedSymbol: FirBasedSymbol<*>?): String {
        if (firBasedSymbol == null) return ""
        return try {
            renderer.renderElementAsString(firBasedSymbol.fir).trimEnd()
        } catch (_: Throwable) {
            ""
        }
    }

    private fun kdocText(firBasedSymbol: FirBasedSymbol<*>?): String {
        if (firBasedSymbol == null) return ""
        val kdoc =
            firBasedSymbol.source?.getChild(KtTokens.DOC_COMMENT)?.text?.toString() ?: return ""
        return stripKDocAsterisks(kdoc)
    }

    /** Strips leading/trailing slash and asterisk tokens from each line of a kdoc string. */
    private fun stripKDocAsterisks(kdoc: String): String {
        if (kdoc.isEmpty()) return kdoc
        val out = StringBuilder()
        kdoc.lineSequence().forEach { line ->
            if (line.isEmpty()) return@forEach
            var start = 0
            while (start < line.length && line[start].isWhitespace()) {
                start++
            }
            if (start < line.length && line[start] == '/') {
                start++
            }
            while (start < line.length && line[start] == '*') {
                start++
            }
            var end = line.length - 1
            if (end > start && line[end] == '/') {
                end--
            }
            while (end > start && line[end] == '*') {
                end--
            }
            while (end > start && line[end].isWhitespace()) {
                end--
            }
            start = minOf(start, line.length - 1)
            if (end > start) {
                end++
            }
            if (out.isNotEmpty()) out.append('\n')
            out.append(line, start, end)
        }
        return out.toString()
    }

    companion object {
        private const val LANGUAGE_KOTLIN: String = "kotlin"

        @OptIn(SymbolInternals::class)
        private fun displayName(
            firBasedSymbol: FirBasedSymbol<*>?,
            element: KtSourceElement,
        ): String =
            when (firBasedSymbol) {
                null -> element.text?.toString() ?: ""
                is FirClassSymbol -> firBasedSymbol.classId.shortClassName.asString()
                is FirPropertyAccessorSymbol -> firBasedSymbol.fir.propertySymbol.name.asString()
                is FirFunctionSymbol<*> -> firBasedSymbol.callableId.callableName.asString()
                is FirPropertySymbol -> firBasedSymbol.callableId.callableName.asString()
                is FirVariableSymbol<*> -> firBasedSymbol.name.asString()
                else -> firBasedSymbol.toString()
            }

        private fun scipKind(firBasedSymbol: FirBasedSymbol<*>?): SymbolInformation.Kind =
            when (firBasedSymbol) {
                null -> SymbolInformation.Kind.UnspecifiedKind
                is FirRegularClassSymbol ->
                    when (firBasedSymbol.classKind) {
                        ClassKind.INTERFACE -> SymbolInformation.Kind.Interface
                        ClassKind.ENUM_CLASS -> SymbolInformation.Kind.Enum
                        ClassKind.ENUM_ENTRY -> SymbolInformation.Kind.EnumMember
                        ClassKind.OBJECT -> SymbolInformation.Kind.Object
                        ClassKind.ANNOTATION_CLASS -> SymbolInformation.Kind.Interface
                        else -> SymbolInformation.Kind.Class
                    }
                is FirAnonymousObjectSymbol -> SymbolInformation.Kind.Object
                is FirTypeAliasSymbol -> SymbolInformation.Kind.TypeAlias
                is FirConstructorSymbol -> SymbolInformation.Kind.Constructor
                is FirPropertyAccessorSymbol -> SymbolInformation.Kind.Method
                is FirFunctionSymbol<*> -> SymbolInformation.Kind.Method
                is FirPropertySymbol -> SymbolInformation.Kind.Property
                is FirFieldSymbol -> SymbolInformation.Kind.Field
                is FirEnumEntrySymbol -> SymbolInformation.Kind.EnumMember
                is FirValueParameterSymbol -> SymbolInformation.Kind.Parameter
                is FirTypeParameterSymbol -> SymbolInformation.Kind.TypeParameter
                is FirVariableSymbol<*> -> SymbolInformation.Kind.Variable
                else -> SymbolInformation.Kind.UnspecifiedKind
            }

        // Renders declarations as raw Kotlin source for SymbolInformation.signature_documentation.
        private val renderer: FirRenderer
            get() =
                FirRenderer(
                    typeRenderer = ConeTypeRenderer(),
                    idRenderer = ConeIdShortRenderer(),
                    classMemberRenderer = FirNoClassMemberRenderer(),
                    bodyRenderer = null,
                    propertyAccessorRenderer = null,
                    callArgumentsRenderer = FirCallNoArgumentsRenderer(),
                    modifierRenderer = FirAllModifierRenderer(),
                    callableSignatureRenderer =
                        FirCallableSignatureRendererForReadability(),
                    declarationRenderer = FirDeclarationRenderer("local "),
                )
    }
}
