package com.sourcegraph.semanticdb_kotlinc

import com.sourcegraph.semanticdb_javac.Semanticdb
import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocument
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence.Role
import java.lang.IllegalArgumentException
import java.lang.StringBuilder
import java.nio.file.Path
import java.nio.file.Paths
import java.security.MessageDigest
import kotlin.contracts.ExperimentalContracts
import kotlin.text.Charsets.UTF_8
import org.jetbrains.kotlin.asJava.namedUnwrappedElement
import org.jetbrains.kotlin.backend.common.serialization.metadata.findKDocString
import org.jetbrains.kotlin.com.intellij.lang.java.JavaLanguage
import org.jetbrains.kotlin.com.intellij.navigation.NavigationItem
import org.jetbrains.kotlin.com.intellij.psi.PsiElement
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.idea.KotlinLanguage
import org.jetbrains.kotlin.psi.KtConstructor
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtPropertyAccessor
import org.jetbrains.kotlin.renderer.DescriptorRenderer
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.jetbrains.kotlin.resolve.descriptorUtil.getAllSuperClassifiers

@ExperimentalContracts
class SemanticdbTextDocumentBuilder(
    private val sourceroot: Path,
    private val file: KtFile,
    private val lineMap: LineMap,
    private val cache: SymbolsCache
) {
    private val occurrences = mutableListOf<Semanticdb.SymbolOccurrence>()
    private val symbols = mutableListOf<Semanticdb.SymbolInformation>()

    fun build() = {
        TextDocument.newBuilder().setText(file.text).setUri(semanticdbURI()).setMd5(semanticdbMD5())
            .setSchema(Semanticdb.Schema.SEMANTICDB4).setLanguage(Semanticdb.Language.KOTLIN)
            .addAllOccurrences(occurrences).addAllSymbols(symbols)
    }

    fun emitSemanticdbData(
        symbol: Symbol,
        descriptor: DeclarationDescriptor,
        element: PsiElement,
        role: Role
    ) {
        symbolOccurrence(symbol, element, role)?.let(occurrences::add)
        if (role == Role.DEFINITION) symbols.add(symbolInformation(symbol, descriptor, element))
    }

    private val isIgnoredSuperClass = setOf("kotlin.Any", "java.lang.Object", "java.io.Serializable")

    private fun functionDescriptorOverrides(descriptor: FunctionDescriptor): Iterable<String> {
        val result = mutableListOf<String>()
        val isVisited = mutableSetOf<FunctionDescriptor>()
        val queue = ArrayDeque<FunctionDescriptor>()
        queue.add(descriptor)
        while (!queue.isEmpty()) {
            val current = queue.removeFirst()
            if (current in isVisited) {
                continue
            }

            isVisited.add(current)
            val directOverrides = current.overriddenDescriptors.flatMap { cache[it] }.map { it.toString() }
            result.addAll(directOverrides)
            queue.addAll(current.overriddenDescriptors)
        }
        return result
    }

    private fun symbolInformation(
        symbol: Symbol,
        descriptor: DeclarationDescriptor,
        element: PsiElement
    ): Semanticdb.SymbolInformation {
        val supers =
            when (descriptor) {
                is ClassDescriptor ->
                    descriptor
                        .getAllSuperClassifiers()
                        // first is the class itself
                        .drop(1)
                        .filter {
                            it.fqNameSafe.toString() !in isIgnoredSuperClass
                        }
                        .flatMap { cache[it] }
                        .map { it.toString() }
                        .asIterable()

                is SimpleFunctionDescriptor ->
                    functionDescriptorOverrides(descriptor)

                else -> emptyList<String>().asIterable()
            }
        return SymbolInformation {
            this.symbol = symbol.toString()
            this.displayName = displayName(element)
            this.documentation = semanticdbDocumentation(descriptor)
            this.addAllOverriddenSymbols(supers)
            this.language =
                when (element.language) {
                    is KotlinLanguage -> Semanticdb.Language.KOTLIN
                    is JavaLanguage -> Semanticdb.Language.JAVA
                    else ->
                        throw IllegalArgumentException("unexpected language ${element.language}")
                }
        }
    }

    private fun symbolOccurrence(
        symbol: Symbol,
        element: PsiElement,
        role: Role
    ): Semanticdb.SymbolOccurrence? {
        /*val symbol = when(val s = globals[descriptor, locals]) {
            Symbol.NONE -> return null
            else -> s
        }.symbol*/

        return SymbolOccurrence {
            this.symbol = symbol.toString()
            this.role = role
            this.range = semanticdbRange(element)
        }
    }

    private fun semanticdbRange(element: PsiElement): Semanticdb.Range {
        return Range {
            startCharacter = lineMap.startCharacter(element) - 1
            startLine = lineMap.lineNumber(element) - 1
            endCharacter = lineMap.endCharacter(element) - 1
            endLine = lineMap.lineNumber(element) - 1
        }
    }

    private fun semanticdbURI(): String {
        // TODO: unix-style only
        val relative = sourceroot.relativize(Paths.get(file.virtualFilePath))
        return relative.toString()
    }

    private fun semanticdbMD5(): String =
        MessageDigest.getInstance("MD5").digest(file.text.toByteArray(UTF_8)).joinToString("") {
            "%02X".format(it)
        }

    private fun semanticdbDocumentation(
        descriptor: DeclarationDescriptor
    ): Semanticdb.Documentation = Documentation {
        format = Semanticdb.Documentation.Format.MARKDOWN
        val signature =
            DescriptorRenderer.COMPACT_WITH_MODIFIERS
                .withOptions {
                    withSourceFileForTopLevel = true
                    unitReturnType = false
                }
                .render(descriptor)
        val kdoc =
            when (descriptor) {
                is DeclarationDescriptorWithSource -> descriptor.findKDocString() ?: ""
                else -> ""
            }
        message = "```kotlin\n$signature\n```${stripKDocAsterisks(kdoc)}"
    }

    // Returns the kdoc string with all leading and trailing "/*" tokens removed. Naive
    // implementation that can
    // be replaced with a utility method from the compiler in the future, if one exists.
    private fun stripKDocAsterisks(kdoc: String): String {
        if (kdoc.isEmpty()) return kdoc
        val out = StringBuilder().append("\n\n").append("----").append("\n")
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
            out.append("\n").append(line, start, end)
        }
        return out.toString()
    }

    companion object {
        private fun displayName(element: PsiElement): String =
            when (element) {
                is KtPropertyAccessor -> element.namePlaceholder.text
                is NavigationItem ->
                    when (element.namedUnwrappedElement) {
                        is KtConstructor<*> ->
                            (element.namedUnwrappedElement as KtConstructor<*>).name!!

                        else -> element.name ?: element.text
                    }

                else -> element.text
            }
    }
}
