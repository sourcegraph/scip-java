@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")
package lsifjava

import com.sun.source.tree.*
import com.sun.source.util.*
import com.sun.tools.javac.code.Flags
import com.sun.tools.javac.code.Symbol
import com.sun.tools.javac.tree.JCTree.*
import org.eclipse.lsp4j.Location
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import java.io.IOException
import java.nio.file.Path
import java.nio.file.Paths
import java.util.regex.Pattern
import javax.lang.model.element.Element

data class ReferenceData(val useRange: Range, val refRange: Range, val defPath: Path)

class IndexingVisitor(
        task: JavacTask,
        private val compUnit: CompilationUnitTree,
        private val indexer: DocumentIndexer,
        private val indexers: Map<Path, DocumentIndexer>
): TreePathScanner<Unit?, Unit?>() {
    private val trees: Trees = Trees.instance(task)
    private val docs: DocTrees = DocTrees.instance(task)

    // TODO(nsc) handle 'var'
    override fun visitVariable(node: VariableTree, p: Unit?): Unit? {
        // emit var definition
        val defRange = findLocation(currentPath, node.name.toString())?.range ?: return super.visitVariable(node, p)

        indexer.emitDefinition(defRange, node.toString(), docs.getDocComment(currentPath))
        
        return super.visitVariable(node, p)
    }

    override fun visitClass(node: ClassTree, p: Unit?): Unit? {
        val packagePrefix = compUnit.packageName?.toString()?.plus(".") ?: ""

        // TODO(nsc): records
        val classOrEnum = if ((node as JCClassDecl).sym.flags() and Flags.ENUM.toLong() != 0L) "enum " else "class "

        val range = findLocation(currentPath, node.simpleName.toString())?.range ?: return super.visitClass(node, p)

        indexer.emitDefinition(
            range,
            node.modifiers.toString() + classOrEnum + packagePrefix + node.simpleName,
            docs.getDocComment(currentPath)
        )

        return super.visitClass(node, p)
    }

    override fun visitMethod(node: MethodTree, p: Unit?): Unit? {
        if((node as JCMethodDecl).mods.flags and Flags.GENERATEDCONSTR != 0L) return null
        
        val methodName = node.name.toString().let {
            if(it == "<init>") node.sym.owner.name.toString() else it
        }
        
        val returnType = node.returnType?.toString()?.plus(" ") ?: ""
        
        val range = findLocation(currentPath, methodName, node.pos)?.range ?: return super.visitMethod(node, p)

        indexer.emitDefinition(
            range,
            node.modifiers.toString() +
                returnType +
                methodName + "(" +
                node.parameters.toString(", ") + ")",
            docs.getDocComment(currentPath)
        )
        
        return super.visitMethod(node, p)
    }

    override fun visitNewClass(node: NewClassTree, p: Unit?): Unit? {
        (node as JCNewClass).constructor ?: return super.visitNewClass(node, p)
        // ignore auto-genned constructors (for now)
        if(node.constructor.flags() and Flags.GENERATEDCONSTR != 0L) return null

        // refactor to extension methods?
        val identifier = node.identifier
        val identName = when(identifier) {
            is JCIdent -> identifier.name
            is JCFieldAccess -> identifier.name
            is JCTypeApply -> when(identifier.clazz) {
                is JCIdent -> (identifier.clazz as JCIdent).name
                is JCFieldAccess -> (identifier.clazz as JCFieldAccess).name
                else -> {
                    println("clazz was not JCIdent|JCFieldAccess|JCTypeApply, but ${identifier.clazz.javaClass}:\n${identifier.clazz}")
                    return super.visitNewClass(node, p)
                }
            }
            else -> {
                println("identifier was not JCIdent|JCTypeApply|JCFieldAccess, but ${identifier.javaClass}:\n${identifier}")
                return super.visitNewClass(node, p)
            }
        }.toString()
        
        val identPath = TreePath(currentPath, node.identifier)
        val identElement = node.constructor
        
        val defContainer = getTopLevelClass(identElement) as Symbol.ClassSymbol? ?: return super.visitNewClass(node, p)
        val (useRange, refRange, defPath) = findReference(identElement, identName, defContainer, path = identPath) ?: return super.visitNewClass(node, p)

        indexer.emitUse(useRange, refRange, defPath)

        return super.visitNewClass(node, p)
    }

    override fun visitMethodInvocation(node: MethodInvocationTree?, p: Unit?): Unit? {
        val symbol = when((node as JCMethodInvocation).meth) {
            is JCFieldAccess -> (node.meth as JCFieldAccess).sym
            is JCIdent -> (node.meth as JCIdent).sym
            else -> {
                println("method receiver tree was neither JCFieldAccess nor JCIdent but ${node.meth.javaClass}")
                return super.visitMethodInvocation(node, p)
            }
        }
        
        //val isStatic = symbol.flags_field and Flags.STATIC.toLong() > 0L

        val name = symbol?.name?.toString()?.let {
            if(it == "<init>") "this" else it
        } ?: return super.visitMethodInvocation(node, p)
        val methodPath = TreePath(currentPath, node.meth)
        val defContainer = getTopLevelClass(symbol) as Symbol.ClassSymbol? ?: return super.visitMethodInvocation(node, p)

        // this gives us the start pos of the name of the method, so override defStartPos
        val overrideStartOffset = (trees.getPath(symbol)?.leaf as JCMethodDecl?)?.pos ?: return super.visitMethodInvocation(node, p)
        val (useRange, refRange, defPath) = findReference(symbol, name, defContainer, path = methodPath, defStartPos = overrideStartOffset) ?: return super.visitMethodInvocation(node, p)

        indexer.emitUse(useRange, refRange, defPath)

        return super.visitMethodInvocation(node, p)
    }

    // does not match `var` or constructor calls
    override fun visitIdentifier(node: IdentifierTree?, p: Unit?): Unit? {
        val symbol = (node as JCIdent).sym ?: return super.visitIdentifier(node, p)
        
        if(symbol is Symbol.PackageSymbol) return super.visitIdentifier(node, p)

        val name = symbol.name.toString()
        if(name == "<init>") return super.visitIdentifier(node, p) // handled by visitMethodInvocation
        val defContainer = getTopLevelClass(symbol) as Symbol.ClassSymbol? ?: return super.visitIdentifier(node, p)

        val (useRange, refRange, defPath) = findReference(symbol, name, defContainer) ?: return super.visitIdentifier(node, p)
        
        indexer.emitUse(useRange, refRange, defPath)

        return super.visitIdentifier(node, p)
    }

    override fun visitTypeParameter(node: TypeParameterTree?, p: Unit?): Unit? {
        val range = findLocation(currentPath, node!!.name.toString(), (node as JCTypeParameter).pos)?.range ?: return super.visitTypeParameter(node, p)

        indexer.emitDefinition(range, "type-parameter $node")

        return super.visitTypeParameter(node, p)
    }
    
    // function references eg test::myfunc or banana::new
    override fun visitMemberReference(node: MemberReferenceTree?, p: Unit?): Unit? {
        val symbol = (node as JCMemberReference).sym ?: return super.visitMemberReference(node, p)
        
        val name = symbol.name.toString()
        
        val defContainer = getTopLevelClass(symbol) as Symbol.ClassSymbol? ?: return super.visitMemberReference(node, p)
        
        val (useRange, refRange, defPath) = findReference(symbol, name, defContainer) ?: return super.visitMemberReference(node, p)

        indexer.emitUse(useRange, refRange, defPath)
        
        return super.visitMemberReference(node, p)
    }

    override fun visitMemberSelect(node: MemberSelectTree?, p: Unit?): Unit? {
        if((node as JCFieldAccess).sym == null) return super.visitMemberSelect(node, p)

        val symbol = when(node.sym) {
            is Symbol.ClassSymbol -> node.sym
            is Symbol.VarSymbol -> node.sym
            else -> return super.visitMemberSelect(node, p)
        }

        val name = symbol.name.toString()
        
        val defContainer = getTopLevelClass(symbol) as Symbol.ClassSymbol? ?: return super.visitMemberSelect(node, p)

        // need to narrow down start pos of the field access here, so override refStartPos
        val (useRange, refRange, defPath) = findReference(symbol, name, defContainer, refStartPos = node.pos) ?: return super.visitMemberSelect(node, p)

        indexer.emitUse(useRange, refRange, defPath)
        
        return super.visitMemberSelect(node, p)
    }

    /**
     * @param element the definition element
     * @param symbolName string non fully qualified name of the symbol
     * @param container the containing class Symbol of `element`
     * @param path the TreePath to the reference element (not definition)
     * @param refStartPos document offset to be provided if a node supplies a more accurate start position for a reference/use search
     * @param defStartPos document offset to be provided if a node supplies a more accurate start position for a definition search
     */
    private fun findReference(element: Element, symbolName: String, container: Symbol.ClassSymbol, path: TreePath = currentPath, refStartPos: Int? = null, defStartPos: Int? = null): ReferenceData? {
        val sourceFilePath = container.sourcefile ?: return null
        val defPath = Paths.get(sourceFilePath.name)
        if(sourceFilePath.name != compUnit.sourceFile.name)
            indexers[defPath]?.index() ?: return null
        val refRange = findDefinition(element, defStartPos)?.range ?: return null

        var name = symbolName
        if (name.contentEquals("<init>")) name = element.enclosingElement.simpleName.toString()
        val useRange = findLocation(path, name, refStartPos)?.range ?: return null
        return ReferenceData(useRange, refRange, defPath)
    }

    // from https://github.com/georgewfraser/java-language-server/blob/3555762fa35ab99575130911b3c930cc4d2d7b26/src/main/java/org/javacs/FindHelper.java
    private fun findDefinition(element: Element, startPos: Int? = null): Location? {
        val path = trees.getPath(element) ?: return null
        var name = element.simpleName
        if (name.contentEquals("<init>")) name = element.enclosingElement.simpleName
        return findLocation(path, name, startPos)
    }

    private fun findLocation(path: TreePath, name: CharSequence, startPos: Int? = null): Location? {
        val lines = path.compilationUnit.lineMap
        val pos = trees.sourcePositions
        // we seem to be able to get a more exact position of eg func name from the original node,
        // so use that instead if given
        var start = startPos ?: pos.getStartPosition(path.compilationUnit, path.leaf).toInt()
        var end = pos.getEndPosition(path.compilationUnit, path.leaf).toInt()
        if (end == -1) return null
        if (name.isNotEmpty()) {
            start = findNameIn(path.compilationUnit, name, start, end)
            end = start + name.length
        }
        if (start == -1) return null
        val startLine = lines.getLineNumber(start.toLong()).toInt()
        val startColumn = lines.getColumnNumber(start.toLong()).toInt()
        val endLine = lines.getLineNumber(end.toLong()).toInt()
        val endColumn = lines.getColumnNumber(end.toLong()).toInt()
        val range = Range(
            Position(startLine - 1, startColumn - 1),
            Position(endLine - 1, endColumn - 1)
        )
        val uri = path.compilationUnit.sourceFile.toUri()
        return Location(uri.path, range)
    }

    // this may fail to find the correct position if start is too far behind the actual start position
    // that we want and another matching but incorrect symbol matches the regex
    private fun findNameIn(root: CompilationUnitTree, name: CharSequence, start: Int, end: Int): Int {
        val contents: CharSequence
        contents = try {
            root.sourceFile.getCharContent(true)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
        val matcher = Pattern.compile("\\b$name\\b").matcher(contents)
        matcher.region(start, end)
        return if (matcher.find()) {
            matcher.start()
        } else -1
    }

    private fun getTopLevelClass(element: Element?): Element? {
        var element = element
        var highestClass: Element? = null
        while (element != null) {
            val kind = element.kind
            if (isTopLevel(kind)) {
                highestClass = element
            }
            element = element.enclosingElement
        }
        return highestClass
    }

    private fun isTopLevel(kind: ElementKind) = kind.isClass || kind.isInterface
}