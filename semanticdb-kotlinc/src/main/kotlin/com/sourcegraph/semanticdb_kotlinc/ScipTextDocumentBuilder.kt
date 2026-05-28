package com.sourcegraph.semanticdb_kotlinc

import com.sourcegraph.Scip
import com.sourcegraph.semanticdb_kotlinc.Semanticdb.SymbolOccurrence.Role
import kotlin.contracts.ExperimentalContracts
import org.jetbrains.kotlin.KtSourceElement
import org.jetbrains.kotlin.KtSourceFile
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
 * Builds a single-document [Scip.Index] shard for one Kotlin source file from per-element callbacks
 * fired by [SemanticdbVisitor]. This is the SCIP analogue of [SemanticdbTextDocumentBuilder].
 *
 * Symbols are emitted using the placeholder scheme [ScipSymbols.PLACEHOLDER_PREFIX]; the
 * `scip-aggregator` rewrites them into final `scip-java maven g a v ...` form once Maven
 * coordinates are resolved.
 *
 * Signature documentation is rendered directly via [FirRenderer] (Kotlin's built-in declaration
 * renderer) and assigned to `SymbolInformation.signature_documentation.text` as raw Kotlin source.
 */
@ExperimentalContracts
class ScipTextDocumentBuilder(
    private val file: KtSourceFile,
    private val lineMap: LineMap,
    private val cache: SymbolsCache,
    private val relativePath: String,
) {
    private val occurrences = mutableListOf<Scip.Occurrence>()
    // Keyed by symbol string so re-encounters of the same definition (multi-round compilation,
    // synthetic accessors) do not produce duplicate entries.
    private val symbols = LinkedHashMap<String, Scip.SymbolInformation>()

    fun build(): Scip.Document =
        Scip
            .Document
            .newBuilder()
            .setRelativePath(relativePath)
            .setLanguage(LANGUAGE_KOTLIN)
            .addAllOccurrences(ScipOccurrences.deduplicate(occurrences))
            .addAllSymbols(symbols.values)
            .build()

    fun buildIndex(): Scip.Index = Scip.Index.newBuilder().addDocuments(build()).build()

    fun emitScipData(
        firBasedSymbol: FirBasedSymbol<*>?,
        symbol: Symbol,
        element: KtSourceElement,
        role: Role,
        context: CheckerContext,
        enclosingSource: KtSourceElement? = null,
    ) {
        if (symbol == Symbol.NONE) return

        emitOccurrence(symbol, element, role, enclosingSource)
        if (role == Role.DEFINITION) {
            emitSymbolInformation(firBasedSymbol, symbol, element, context)
        }
    }

    private fun emitOccurrence(
        symbol: Symbol,
        element: KtSourceElement,
        role: Role,
        enclosingSource: KtSourceElement?,
    ) {
        val builder =
            Scip
                .Occurrence
                .newBuilder()
                .addAllRange(scipRange(element))
                .setSymbol(ScipSymbols.fromSemanticdbSymbol(symbol))
                .setSymbolRoles(scipRole(role))
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
        val scipSymbolStr = ScipSymbols.fromSemanticdbSymbol(symbol)
        val builder =
            Scip
                .SymbolInformation
                .newBuilder()
                .setSymbol(scipSymbolStr)
                .setDisplayName(displayName(firBasedSymbol, element))
                .setKind(scipKind(firBasedSymbol))

        if (symbol.isLocal()) {
            // Locals are convenient to navigate from when the enclosing symbol is known.
            // We don't have direct access to the enclosing FirBasedSymbol here, but the
            // information is non-essential — leaving enclosing_symbol unset is fine.
        }

        val signature = signatureText(firBasedSymbol)
        if (signature.isNotEmpty()) {
            builder.setSignatureDocumentation(
                Scip.Document.newBuilder()
                    .setLanguage(LANGUAGE_KOTLIN)
                    .setRelativePath(relativePath)
                    .setText(signature))
        }

        val kdoc = kdocText(firBasedSymbol)
        if (kdoc.isNotEmpty()) {
            builder.addDocumentation(kdoc)
        }

        val supportsRefRel = supportsReferenceRelationship(firBasedSymbol)
        for (parent in parentOrOverriddenSymbols(firBasedSymbol, context)) {
            val parentSymbolStr = ScipSymbols.fromSemanticdbSymbol(parent)
            if (parentSymbolStr.isEmpty()) continue
            builder.addRelationships(
                Scip.Relationship.newBuilder()
                    .setSymbol(parentSymbolStr)
                    .setIsImplementation(true)
                    .setIsReference(supportsRefRel))
        }

        // Last write wins so newly discovered metadata takes precedence.
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
        // SemanticDB visitor only emits single-line ranges, so the SCIP compact 3-int range
        // form is sufficient here.
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

    /**
     * Returns the kdoc string with all leading and trailing slash/asterisk tokens removed. Naive
     * implementation that can be replaced with a utility method from the compiler in the future,
     * if one exists.
     */
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
        // SCIP `Document.language` value; lowercased to match the SCIP convention used by
        // existing aggregator code.
        const val LANGUAGE_KOTLIN: String = "kotlin"

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

        private fun scipRole(role: Role): Int =
            when (role) {
                Role.DEFINITION -> Scip.SymbolRole.Definition_VALUE
                else -> 0
            }

        private fun scipKind(firBasedSymbol: FirBasedSymbol<*>?): Scip.SymbolInformation.Kind =
            when (firBasedSymbol) {
                null -> Scip.SymbolInformation.Kind.UnspecifiedKind
                is FirRegularClassSymbol ->
                    when (firBasedSymbol.classKind) {
                        org.jetbrains.kotlin.descriptors.ClassKind.INTERFACE ->
                            Scip.SymbolInformation.Kind.Interface
                        org.jetbrains.kotlin.descriptors.ClassKind.ENUM_CLASS ->
                            Scip.SymbolInformation.Kind.Enum
                        org.jetbrains.kotlin.descriptors.ClassKind.ENUM_ENTRY ->
                            Scip.SymbolInformation.Kind.EnumMember
                        org.jetbrains.kotlin.descriptors.ClassKind.OBJECT ->
                            Scip.SymbolInformation.Kind.Object
                        org.jetbrains.kotlin.descriptors.ClassKind.ANNOTATION_CLASS ->
                            Scip.SymbolInformation.Kind.Interface
                        else -> Scip.SymbolInformation.Kind.Class
                    }
                is FirAnonymousObjectSymbol -> Scip.SymbolInformation.Kind.Object
                is FirTypeAliasSymbol -> Scip.SymbolInformation.Kind.TypeAlias
                is FirConstructorSymbol -> Scip.SymbolInformation.Kind.Constructor
                is FirPropertyAccessorSymbol -> Scip.SymbolInformation.Kind.Method
                is FirFunctionSymbol<*> -> Scip.SymbolInformation.Kind.Method
                is FirPropertySymbol -> Scip.SymbolInformation.Kind.Property
                is FirFieldSymbol -> Scip.SymbolInformation.Kind.Field
                is FirEnumEntrySymbol -> Scip.SymbolInformation.Kind.EnumMember
                is FirValueParameterSymbol -> Scip.SymbolInformation.Kind.Parameter
                is FirTypeParameterSymbol -> Scip.SymbolInformation.Kind.TypeParameter
                is FirVariableSymbol<*> -> Scip.SymbolInformation.Kind.Variable
                else -> Scip.SymbolInformation.Kind.UnspecifiedKind
            }

        // Mirrors the renderer used by SemanticdbTextDocumentBuilder for parity. We render the
        // declaration as Kotlin source text — no markdown fence — and put it into
        // SymbolInformation.signature_documentation.text.
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
