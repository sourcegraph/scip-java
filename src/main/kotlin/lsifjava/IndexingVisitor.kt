@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")
package lsifjava

import com.sun.source.tree.*
import com.sun.source.util.JavacTask
import com.sun.source.util.TreePath
import com.sun.source.util.TreePathScanner
import com.sun.source.util.Trees
import com.sun.tools.javac.code.Flags
import com.sun.tools.javac.code.Symbol
import com.sun.tools.javac.code.Type
import com.sun.tools.javac.tree.JCTree
import org.eclipse.lsp4j.Location
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import java.io.IOException
import java.nio.file.Path
import java.nio.file.Paths
import java.util.regex.Pattern
import javax.lang.model.element.Element

class IndexingVisitor(
        task: JavacTask,
        private val compUnit: CompilationUnitTree,
        private val indexer: DocumentIndexer,
        private val indexers: Map<Path, DocumentIndexer>
): TreePathScanner<Unit?, Unit?>() {
    private val trees: Trees = Trees.instance(task)

    override fun visitVariable(node: VariableTree, p: Unit?): Unit? {
        val defRange = findLocation(currentPath, node.name.toString())?.range ?: return super.visitVariable(node, p)
        
        indexer.emitDefinition(defRange, node.toString())
        
        var symbol = when((node as JCTree.JCVariableDecl).type) {
            is Type.ClassType -> node.type.tsym
            is Type.ArrayType -> node.type.tsym
            // incl Type.JCPrimitiveType
            else -> return super.visitVariable(node, p)
        }

        symbol = when(symbol) {
            is Symbol.ClassSymbol -> symbol
            else -> return super.visitVariable(node, p)
        }

        val name = symbol.name.toString()
        val identPath = TreePath(currentPath, node.getType())
        val identElement = trees.getElement(identPath)
        val defContainer = LanguageUtils.getTopLevelClass(identElement) as Symbol.ClassSymbol? ?: return super.visitVariable(node, p)

        var defPath: Path = Paths.get(compUnit.sourceFile.toUri())
        val sourceFilePath = defContainer.sourcefile ?: return super.visitVariable(node, p)
        val refRange = if(sourceFilePath.name != compUnit.sourceFile.name) {
            indexers[Paths.get(sourceFilePath.name)]?.index() ?: return super.visitVariable(node, p)
            val location = findDefinition(defContainer) ?: return super.visitVariable(node, p)
            defPath = Paths.get(location.uri)
            location.range
        } else {
            val location = findDefinition(defContainer) ?: return super.visitVariable(node, p)
            location.range
        }
        
        val useRange = run {
            val location = findLocation(identPath, name) ?: return super.visitVariable(node, p)
            location.range
        }

        indexer.emitUse(useRange, refRange, defPath)
        
        return super.visitVariable(node, p)
    }

    override fun visitClass(node: ClassTree, p: Unit?): Unit? {
        val packagePrefix = compUnit.packageName?.toString()?.plus(".") ?: ""
        
        val classOrEnum = if ((node as JCTree.JCClassDecl).sym.flags() and Flags.ENUM.toLong() != 0L) "enum " else "class "

        val range = findLocation(currentPath, node.simpleName.toString())?.range ?: return super.visitClass(node, p)

        indexer.emitDefinition(
            range, node.modifiers.toString() + classOrEnum + packagePrefix + node.simpleName
        )

        return super.visitClass(node, p)
    }

    override fun visitMethod(node: MethodTree, p: Unit?): Unit? {
        if((node as JCTree.JCMethodDecl).mods.flags and Flags.GENERATEDCONSTR != 0L) return null
        
        val methodName = node.name.toString().let {
            if(it == "<init>") node.sym.owner.name.toString() else it
        }
        
        val returnType = node.returnType?.toString()?.plus(" ") ?: ""
        
        val range = findLocation(currentPath, methodName)?.range ?: return super.visitMethod(node, p)

        indexer.emitDefinition(
            range,
            node.modifiers.toString() +
                returnType +
                methodName + "(" +
                node.parameters.toString() + ")"
        )
        
        return super.visitMethod(node, p)
    }

    override fun visitNewClass(node: NewClassTree, p: Unit?): Unit? {
        if((node as JCTree.JCNewClass).constructor.flags() and Flags.GENERATEDCONSTR != 0L) return null
        
        val ident = when(node.identifier) {
            is JCTree.JCIdent -> node.identifier
            is JCTree.JCTypeApply -> (node.identifier as JCTree.JCTypeApply).clazz
            else  -> {
                println("identifier was neither JCIdent nor JCTypeApply, but ${node.identifier.javaClass}")
                return super.visitNewClass(node, p)
            }
        } as JCTree.JCIdent
        
        val identPath = TreePath(currentPath, node.identifier)
        val identElement = node.constructor
        
        val range = findLocation(identPath, ident.name.toString())?.range ?: return super.visitNewClass(node, p)
        
        val location = findDefinition(identElement) ?: (findDefinition(trees.getElement(identPath)) ?: return super.visitNewClass(node, p))

        indexer.emitUse(
            range, location.range,
            Paths.get(compUnit.sourceFile.toUri())
        )

        return super.visitNewClass(node, p)
    }

    // from https://github.com/georgewfraser/java-language-server/blob/3555762fa35ab99575130911b3c930cc4d2d7b26/src/main/java/org/javacs/FindHelper.java
    private fun findDefinition(element: Element): Location? {
        val path = trees.getPath(element) ?: return null
        var name = element.simpleName
        if (name.contentEquals("<init>")) name = element.enclosingElement.simpleName
        return findLocation(path, name)
    }

    private fun findLocation(path: TreePath, name: CharSequence): Location? {
        val lines = path.compilationUnit.lineMap
        val pos = trees.sourcePositions
        var start = pos.getStartPosition(path.compilationUnit, path.leaf).toInt()
        var end = pos.getEndPosition(path.compilationUnit, path.leaf).toInt()
        if (end == -1) return null
        if (name.isNotEmpty()) {
            start = findNameIn(path.compilationUnit, name, start, end)
            end = start + name.length
        }
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
}