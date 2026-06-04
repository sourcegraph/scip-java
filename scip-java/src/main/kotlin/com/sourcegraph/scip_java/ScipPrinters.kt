package com.sourcegraph.scip_java

import kotlin.math.max
import org.scip_code.scip.Document
import org.scip_code.scip.Occurrence
import org.scip_code.scip.SymbolInformation
import org.scip_code.scip.SymbolRole

/**
 * Renders a SCIP `Document` (parsed from an `index.scip` file) into the
 * human-readable golden-snapshot format used by the test suite.
 *
 * The output is annotated source code: every source line is followed by
 * comment lines that point at the SCIP occurrences/symbols defined on
 * that line.
 */
object ScipPrinters {

    /**
     * Indent prefix prepended to each source line so that caret-based
     * indicators in snapshot comments can point at arbitrary columns.
     */
    const val sourceIndent: String = "  "

    // scip-java only indexes Java and Kotlin sources, both of which use `//`.
    private const val commentSyntax: String = "//"

    @JvmStatic
    fun printTextDocument(doc: Document, text: String): String {
        val out = StringBuilder()
        val occurrencesByLine: Map<Int, List<Occurrence>> =
            doc.occurrencesList.groupBy { it.getRange(0) }
        val symtab: Map<String, SymbolInformation> =
            doc.symbolsList.associateBy { it.symbol }
        val input = SourceInput(text)

        val syntheticDefinitions: Map<String, List<SymbolInformation>> =
            doc.symbolsList
                .flatMap { info ->
                    info.relationshipsList
                        .filter { it.isDefinition }
                        .map { it.symbol to info }
                }
                .groupBy({ it.first }, { it.second })

        val allEnclosingRanges: List<EnclosingRange> =
            doc.occurrencesList.mapNotNull { occ ->
                val r = occ.enclosingRangeList.map { it.toInt() }
                when (r.size) {
                    3 -> EnclosingRange(r[0], r[1], r[0], r[2], occ.symbol)
                    4 -> EnclosingRange(r[0], r[1], r[2], r[3], occ.symbol)
                    else -> null
                }
            }
        val enclosingByStartLine =
            allEnclosingRanges.groupBy { it.startLine }.mapValues { it.value.sortedBy { r -> r.startChar } }
        val enclosingByEndLine =
            allEnclosingRanges.groupBy { it.endLine }.mapValues { it.value.sortedBy { r -> r.endChar } }

        linesWithSeparators(text).forEachIndexed { i, line ->
            enclosingByStartLine[i]?.forEach { er ->
                out.append(commentSyntax)
                    .append(" ".repeat(er.startChar))
                    .append("⌄ enclosing_range_start ")
                    .append(er.symbol)
                    .append("\n")
            }
            out.append(sourceIndent).append(line.replace("\t", "  "))
            val occurrences =
                (occurrencesByLine[i] ?: emptyList()).sortedWith(occurrenceOrdering)
            for (occ in occurrences) {
                formatOccurrence(input, out, occ, line, symtab, null)
                if ((occ.symbolRoles and SymbolRole.Definition_VALUE) > 0) {
                    syntheticDefinitions[occ.symbol]?.forEach { syntheticDefinition ->
                        formatOccurrence(input, out, occ, line, symtab, syntheticDefinition)
                    }
                }
            }
            enclosingByEndLine[i]?.forEach { er ->
                val indent = max(0, er.endChar - 1)
                out.append(commentSyntax)
                    .append(" ".repeat(indent))
                    .append("⌃ enclosing_range_end ")
                    .append(er.symbol)
                    .append("\n")
            }
        }
        return out.toString()
    }

    private data class EnclosingRange(
        val startLine: Int,
        val startChar: Int,
        val endLine: Int,
        val endChar: Int,
        val symbol: String,
    )

    /**
     * Element-wise integer-list comparator for `Occurrence.rangeList`,
     * matching Scala's `seqOrdering` semantics. Falls back to `symbol`
     * for a tie-breaker.
     */
    private val occurrenceOrdering: Comparator<Occurrence> =
        Comparator { a, b ->
            val ra = a.rangeList
            val rb = b.rangeList
            val n = minOf(ra.size, rb.size)
            for (i in 0 until n) {
                val cmp = ra[i].toInt().compareTo(rb[i].toInt())
                if (cmp != 0) return@Comparator cmp
            }
            val sizeCmp = ra.size.compareTo(rb.size)
            if (sizeCmp != 0) sizeCmp else a.symbol.compareTo(b.symbol)
        }

    private data class OccurrencePos(
        val startLine: Int,
        val startColumn: Int,
        val endLine: Int,
        val endColumn: Int,
    )

    /**
     * Faithful port of `moped.reporters.Position.range` + `RangePosition`:
     * the SCIP `(line, column)` pair is converted to a flat character offset
     * and back. The round-trip matters for occurrences whose end column
     * overflows its start line (e.g. Kotlin `companion object` definitions),
     * where the overflow "carries" the end onto a later line, turning a raw
     * single-line range into a rendered multi-line range.
     */
    private fun positionOf(input: SourceInput, occ: Occurrence): OccurrencePos {
        val rawStartLine: Int
        val rawStartColumn: Int
        val rawEndLine: Int
        val rawEndColumn: Int
        when (occ.rangeCount) {
            3 -> {
                rawStartLine = occ.getRange(0)
                rawStartColumn = occ.getRange(1)
                rawEndLine = occ.getRange(0)
                rawEndColumn = occ.getRange(2)
            }
            4 -> {
                rawStartLine = occ.getRange(0)
                rawStartColumn = occ.getRange(1)
                rawEndLine = occ.getRange(2)
                rawEndColumn = occ.getRange(3)
            }
            else -> throw IllegalArgumentException("Invalid range: $occ")
        }
        // moped's Position.range returns NoPosition (all -1) for empty input.
        if (input.isEmpty) return OccurrencePos(-1, -1, -1, -1)
        val start = input.lineToOffset(rawStartLine) + rawStartColumn
        val end = input.lineToOffset(rawEndLine) + rawEndColumn
        val startLine = input.offsetToLine(start)
        val endLine = input.offsetToLine(end)
        return OccurrencePos(
            startLine = startLine,
            startColumn = start - input.lineToOffset(startLine),
            endLine = endLine,
            endColumn = end - input.lineToOffset(endLine),
        )
    }

    private fun formatOccurrence(
        input: SourceInput,
        out: StringBuilder,
        occ: Occurrence,
        line: String,
        symtab: Map<String, SymbolInformation>,
        syntheticDefinition: SymbolInformation?,
    ) {
        val pos = positionOf(input, occ)
        val isMultiline = pos.startLine != pos.endLine
        val width =
            if (isMultiline) line.length - pos.startColumn - 1
            else max(1, pos.endColumn - pos.startColumn)

        val isDefinition = (occ.symbolRoles and SymbolRole.Definition_VALUE) > 0
        val role =
            when {
                syntheticDefinition != null -> "synthetic_definition"
                isDefinition -> "definition"
                else -> "reference"
            }
        val indent =
            if (pos.startColumn + sourceIndent.length > commentSyntax.length)
                " ".repeat(pos.startColumn + sourceIndent.length - commentSyntax.length)
            else ""
        val caretCharacter = if (syntheticDefinition != null) "_" else "^"
        // Scala's `"x" * n` returns "" for n <= 0; Kotlin's `String.repeat`
        // throws on a negative argument. Clamp to 0 to preserve behaviour.
        val carets =
            if (pos.startColumn == 1) caretCharacter.repeat(max(0, width - 1))
            else caretCharacter.repeat(max(0, width))

        val symbol = syntheticDefinition?.symbol ?: occ.symbol

        // Fail the tests if the index contains symbols that don't parse as valid SCIP symbols.
        ScipSymbol.parseOrThrowExceptionIfInvalid(symbol)

        out.append(commentSyntax)
            .append(indent)
            .append(carets)
            .append(' ')
            .append(role)
            .append(' ')
            .append(symbol)
        if (isMultiline) {
            out.append(" ${pos.endLine - pos.startLine}:${pos.endColumn}")
        }
        out.append('\n')

        val info = syntheticDefinition ?: symtab[occ.symbol]
        if (info != null && isDefinition) {
            val prefix = commentSyntax + " ".repeat(indent.length) + " ".repeat(carets.length) + " "
            if (info.displayName.isNotEmpty()) {
                out.append(prefix).append("display_name ").append(info.displayName).append('\n')
            }
            if (info.hasSignatureDocumentation()) {
                out.append(prefix)
                    .append("signature_documentation ")
                    .append(info.signatureDocumentation.language)
                    .append(' ')
                    .append(
                        info.signatureDocumentation.text
                            .replace("\n", "\\n")
                            .replace("\t", "\\t")
                    )
                    .append('\n')
            }
            if (info.enclosingSymbol.isNotEmpty()) {
                out.append(prefix).append("enclosing_symbol ").append(info.enclosingSymbol).append('\n')
            }
            if (info.kind != SymbolInformation.Kind.UnspecifiedKind) {
                out.append(prefix).append("kind ").append(info.kind).append('\n')
            }
            for (n in 0 until info.documentationCount) {
                val documentation = info.getDocumentation(n)
                out.append(prefix)
                    .append("documentation ")
                    .append(documentation.replace("\n", "\\n").replace("\t", "\\t"))
                    .append('\n')
            }
            info.relationshipsList
                .sortedBy { it.symbol }
                .forEach { relationship ->
                    out.append(prefix).append("relationship")
                    if (relationship.isReference) out.append(" is_reference")
                    if (relationship.isDefinition) out.append(" is_definition")
                    if (relationship.isImplementation) out.append(" is_implementation")
                    if (relationship.isTypeDefinition) out.append(" is_type_definition")
                    out.append(' ').append(relationship.symbol).append('\n')
                }
        }
    }

    /**
     * Mirrors Scala's `linesWithSeparators`: each yielded element keeps its
     * trailing line separator (if any) so that `\r\n`/`\n` line endings round-
     * trip exactly when reassembled.
     */
    private fun linesWithSeparators(text: String): List<String> {
        val result = mutableListOf<String>()
        var start = 0
        var i = 0
        while (i < text.length) {
            val c = text[i]
            if (c == '\n') {
                result += text.substring(start, i + 1)
                start = i + 1
            }
            i++
        }
        if (start < text.length) result += text.substring(start)
        return result
    }

    /**
     * Port of `moped.reporters.Input`'s offset/line bookkeeping. Only the
     * pieces needed by [positionOf] are reproduced ([lineToOffset],
     * [offsetToLine], [isEmpty]).
     */
    private class SourceInput(text: String) {
        private val chars: CharArray = text.toCharArray()

        val isEmpty: Boolean = text.isEmpty()

        // Offset of the first character of each line; a trailing sentinel
        // (== chars.size) is appended when the text does not end in '\n'.
        private val lineIndices: IntArray = run {
            val buf = ArrayList<Int>()
            buf.add(0)
            var i = 0
            while (i < chars.size) {
                if (chars[i] == '\n') buf.add(i + 1)
                i++
            }
            if (buf[buf.size - 1] != chars.size) buf.add(chars.size)
            buf.toIntArray()
        }

        fun lineToOffset(line: Int): Int {
            require(line in 0..(lineIndices.size - 1)) {
                "$line is not a valid line number, allowed [0..${lineIndices.size - 1}]"
            }
            return lineIndices[line]
        }

        fun offsetToLine(offset: Int): Int {
            require(offset in 0..chars.size) {
                "$offset is not a valid offset, allowed [0..${chars.size}]"
            }
            // File ending in '\n': an offset at EOF is last_line+1:0.
            if (offset == chars.size && chars.isNotEmpty() && chars[offset - 1] == '\n') {
                return lineIndices.size - 1
            }
            var lo = 0
            var hi = lineIndices.size - 1
            while (hi - lo > 1) {
                val mid = (hi + lo) / 2
                when {
                    offset < lineIndices[mid] -> hi = mid
                    lineIndices[mid] == offset -> return mid
                    else -> lo = mid
                }
            }
            return lo
        }
    }
}
