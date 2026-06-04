package com.sourcegraph.semanticdb_kotlinc.test

import org.scip_code.scip.Occurrence
import org.scip_code.scip.SymbolInformation
import org.scip_code.scip.SymbolRole
import org.scip_code.scip.occurrence
import org.scip_code.scip.relationship
import org.scip_code.scip.signature
import org.scip_code.scip.symbolInformation

/**
 * Tiny DSL for building SCIP [Occurrence] / [SymbolInformation] test fixtures with the same shape
 * as the original SemanticDB-based one used by the Kotlin tests.
 *
 * <p>Example:
 * ```
 * scipOccurrence {
 *     role = DEFINITION
 *     symbol = "sample/Banana#"
 *     range { startLine = 1; startCharacter = 6; endLine = 1; endCharacter = 12 }
 *     enclosingRange { startLine = 1; endLine = 3; endCharacter = 1 }
 * }
 * ```
 */

internal val REFERENCE: Int = SymbolRole.UnspecifiedSymbolRole.number
internal val DEFINITION: Int = SymbolRole.Definition.number

@DslMarker annotation class ScipBuilderDsl

@ScipBuilderDsl
class ScipRangeBuilder {
    var startLine: Int = 0
    var startCharacter: Int = 0
    /**
     * Default sentinel: when [endLine] is left untouched, the produced range is
     * single-line at [startLine].
     */
    var endLine: Int = -1
    var endCharacter: Int = 0

    internal fun toIntList(): List<Int> {
        val line = if (endLine < 0) startLine else endLine
        return if (line == startLine) listOf(startLine, startCharacter, endCharacter)
        else listOf(startLine, startCharacter, line, endCharacter)
    }
}

@ScipBuilderDsl
class ScipOccurrenceBuilder {
    var role: Int = REFERENCE
    var symbol: String = ""
    private var range: List<Int>? = null
    private var enclosingRange: List<Int>? = null

    fun range(block: ScipRangeBuilder.() -> Unit) {
        range = ScipRangeBuilder().apply(block).toIntList()
    }

    fun enclosingRange(block: ScipRangeBuilder.() -> Unit) {
        enclosingRange = ScipRangeBuilder().apply(block).toIntList()
    }

    internal fun build(): Occurrence = occurrence {
        symbol = this@ScipOccurrenceBuilder.symbol
        symbolRoles = role
        this@ScipOccurrenceBuilder.range?.let { range += it }
        this@ScipOccurrenceBuilder.enclosingRange?.let { enclosingRange += it }
    }
}

@ScipBuilderDsl
class ScipSymbolInformationBuilder {
    var symbol: String = ""
    var displayName: String = ""
    var signatureText: String? = null
    private val docs = mutableListOf<String>()
    private val overrides = mutableListOf<String>()

    fun documentation(text: String) {
        docs += text
    }

    /**
     * Appends an `is_implementation` [Relationship]. Mirrors the old SemanticDB-flavored
     * `addOverriddenSymbols` so existing test fixtures port over with minimal diff.
     */
    fun addOverriddenSymbols(vararg symbols: String) {
        overrides.addAll(symbols)
    }

    internal fun build(): SymbolInformation = symbolInformation {
        symbol = this@ScipSymbolInformationBuilder.symbol
        if (this@ScipSymbolInformationBuilder.displayName.isNotEmpty()) {
            displayName = this@ScipSymbolInformationBuilder.displayName
        }
        signatureText?.let { sigText ->
            signatureDocumentation = signature {
                language = "kotlin"
                text = sigText
            }
        }
        for (d in docs) documentation += d
        for (s in overrides) {
            relationships += relationship {
                symbol = s
                isImplementation = true
            }
        }
    }
}

internal fun scipOccurrence(block: ScipOccurrenceBuilder.() -> Unit): Occurrence =
    ScipOccurrenceBuilder().apply(block).build()

internal fun scipSymbol(block: ScipSymbolInformationBuilder.() -> Unit): SymbolInformation =
    ScipSymbolInformationBuilder().apply(block).build()
