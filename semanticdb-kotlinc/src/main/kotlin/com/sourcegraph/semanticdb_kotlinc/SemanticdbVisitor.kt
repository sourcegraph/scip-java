package com.sourcegraph.semanticdb_kotlinc

import com.sourcegraph.semanticdb_javac.Semanticdb
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence.Role
import java.nio.file.Path
import kotlin.contracts.ExperimentalContracts
import org.jetbrains.kotlin.com.intellij.psi.PsiElement
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.containingClass

@ExperimentalContracts
class SemanticdbVisitor(
    sourceroot: Path,
    private val resolver: DescriptorResolver,
    private val file: KtFile,
    private val lineMap: LineMap,
    globals: GlobalSymbolsCache,
    locals: LocalSymbolsCache = LocalSymbolsCache()
) : KtTreeVisitorVoid() {
    private val cache = SymbolsCache(globals, locals)
    private val documentBuilder = SemanticdbTextDocumentBuilder(sourceroot, file, lineMap, cache)

    private data class SymbolDescriptorPair(
        val symbol: Symbol,
        val descriptor: DeclarationDescriptor
    )

    fun build(): Semanticdb.TextDocument {
        super.visitKtFile(file)
        return documentBuilder.build()
    }

    private fun Sequence<SymbolDescriptorPair>?.emitAll(
        element: PsiElement,
        role: Semanticdb.SymbolOccurrence.Role
    ): List<Symbol>? =
        this?.onEach { (symbol, descriptor) ->
                documentBuilder.emitSemanticdbData(symbol, descriptor, element, role)
            }
            ?.map { it.symbol }
            ?.toList()

    private fun Sequence<Symbol>.with(descriptor: DeclarationDescriptor) =
        this.map { SymbolDescriptorPair(it, descriptor) }

    override fun visitKtElement(element: KtElement) {
        try {
            super.visitKtElement(element)
        } catch (e: VisitorException) {
            throw e
        } catch (e: Exception) {
            throw VisitorException(
                "exception throw when visiting ${element::class} in ${file.virtualFilePath}: (${
                    lineMap.lineNumber(
                        element
                    )
                }, ${lineMap.startCharacter(element)})",
                e)
        }
    }

    override fun visitObjectDeclaration(declaration: KtObjectDeclaration) {
        if (declaration.name != null) {
            val desc = resolver.fromDeclaration(declaration).single()
            cache[desc].with(desc).emitAll(declaration, Semanticdb.SymbolOccurrence.Role.DEFINITION)
        }
        super.visitObjectDeclaration(declaration)
    }

    override fun visitClass(klass: KtClass) {
        val desc = resolver.fromDeclaration(klass).single()
        cache[desc].with(desc).emitAll(klass, Semanticdb.SymbolOccurrence.Role.DEFINITION)
        if (!klass.hasExplicitPrimaryConstructor()) {
            resolver.syntheticConstructor(klass)?.apply {
                cache[this].with(this).emitAll(klass, Semanticdb.SymbolOccurrence.Role.DEFINITION)
            }
        }
        super.visitClass(klass)
    }

    override fun visitPrimaryConstructor(constructor: KtPrimaryConstructor) {
        val desc = resolver.fromDeclaration(constructor).single()
        // if the constructor is not denoted by the 'constructor' keyword, we want to link it to the
        // class ident
        if (!constructor.hasConstructorKeyword()) {
            cache[desc].with(desc).emitAll(constructor.containingClass()!!, Role.DEFINITION)
        } else {
            cache[desc].with(desc).emitAll(constructor.getConstructorKeyword()!!, Role.DEFINITION)
        }
        super.visitPrimaryConstructor(constructor)
    }

    override fun visitSecondaryConstructor(constructor: KtSecondaryConstructor) {
        val desc = resolver.fromDeclaration(constructor).single()
        cache[desc].with(desc).emitAll(constructor.getConstructorKeyword(), Role.DEFINITION)
        super.visitSecondaryConstructor(constructor)
    }

    override fun visitNamedFunction(function: KtNamedFunction) {
        val desc = resolver.fromDeclaration(function).single()
        cache[desc].with(desc).emitAll(function, Role.DEFINITION)
        super.visitNamedFunction(function)
    }

    override fun visitProperty(property: KtProperty) {
        val desc = resolver.fromDeclaration(property).single()
        cache[desc].with(desc).emitAll(property, Role.DEFINITION)
        super.visitProperty(property)
    }

    override fun visitParameter(parameter: KtParameter) {
        resolver
            .fromDeclaration(parameter)
            .flatMap { desc -> cache[desc].with(desc) }
            .emitAll(parameter, Role.DEFINITION)
        super.visitParameter(parameter)
    }

    override fun visitTypeParameter(parameter: KtTypeParameter) {
        val desc = resolver.fromDeclaration(parameter).single()
        cache[desc].with(desc).emitAll(parameter, Role.DEFINITION)
        super.visitTypeParameter(parameter)
    }

    override fun visitTypeAlias(typeAlias: KtTypeAlias) {
        val desc = resolver.fromDeclaration(typeAlias).single()
        cache[desc].with(desc).emitAll(typeAlias, Role.DEFINITION)
        super.visitTypeAlias(typeAlias)
    }

    override fun visitPropertyAccessor(accessor: KtPropertyAccessor) {
        val desc = resolver.fromDeclaration(accessor).single()
        cache[desc].with(desc).emitAll(accessor, Role.DEFINITION)
        super.visitPropertyAccessor(accessor)
    }

    override fun visitSimpleNameExpression(expression: KtSimpleNameExpression) {
        val desc =
            resolver.fromReference(expression)
                ?: run {
                    super.visitSimpleNameExpression(expression)
                    return
                }
        cache[desc].with(desc).emitAll(expression, Role.REFERENCE)
        super.visitSimpleNameExpression(expression)
    }
}

class VisitorException(msg: String, throwable: Throwable) : Exception(msg, throwable)
