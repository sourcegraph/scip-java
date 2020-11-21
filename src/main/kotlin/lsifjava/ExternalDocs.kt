@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")
package lsifjava

import com.sun.tools.javac.code.*
import com.sun.source.tree.*
import com.sun.source.util.DocTrees
import com.sun.source.util.JavacTask
import com.sun.source.util.TreePathScanner
import com.sun.tools.javac.api.JavacTool
import com.sun.tools.javac.tree.JCTree.*
import com.sun.tools.javac.util.Context
import java.nio.charset.Charset
import java.nio.file.*
import javax.lang.model.element.Element
import javax.tools.JavaFileObject
import com.sun.tools.javac.file.JavacFileManager
import javax.tools.StandardLocation

data class ExternalHoverMeta(val doc: String, val tree: Tree)

private val emptyFileManager = SourceFileManager(emptySet())

class ExternalDocs(private val docPaths: List<Path>) {
    private val fileCache = HashMap<String, Pair<JavacTask, CompilationUnitTree>?>()

    private val fileManager = let {
        val manager = JavacFileManager(Context(), false, Charset.defaultCharset())
        manager.setLocation(StandardLocation.SOURCE_PATH, docPaths.map { it.toFile() })
        manager
    }

    private val jdkFileManager = JDK8CompatFileManager(fileManager)

    fun findDocForElement(containerClass: String, javac: JavacTool, element: Element): ExternalHoverMeta? {
        val context = DocumentIndexer.SimpleContext()

        val (task, compUnit) = fileCache.getOrPut(containerClass) { analyzeFileFromJar(containerClass, context, javac) }
            ?: return null

        return DocExtractionVisitor(task, element).scan(compUnit, null)
    }

    private fun findFileFromJars(containerClass: String): JavaFileObject? =
        fileManager.getJavaFileForInput(StandardLocation.SOURCE_PATH, containerClass, JavaFileObject.Kind.SOURCE)
            ?: jdkFileManager.getJavaFileForInput(containerClass)

    private fun analyzeFileFromJar(containerClass: String, context: Context, javac: JavacTool): Pair<JavacTask, CompilationUnitTree>? {
        val file = findFileFromJars(containerClass) ?: return null

        val task = javac.getTask(NoopWriter, emptyFileManager, CountingDiagnosticListener.NullWriter, listOf(), listOf(), listOf(file), context)
        val compUnit = task.parse().iterator().apply {
            if(!hasNext()) return null
        }.next()
        return Pair(task, compUnit)
    }

    private class DocExtractionVisitor(val task: JavacTask, private val element: Element, private val docs: DocTrees = DocTrees.instance(task)): TreePathScanner<ExternalHoverMeta?, Unit?>() {
        private var new: Boolean = true
        private lateinit var classDecl: ClassTree

        override fun visitMethod(node: MethodTree, p: Unit?): ExternalHoverMeta? {
            (node as JCMethodDecl).sym ?: return null

            if(node.sym.toString() == element.toString()) {
                val doc = docs.getDocComment(currentPath) ?: return null
                return ExternalHoverMeta(doc, node)
            }

            return null
        }

        override fun visitVariable(node: VariableTree, p: Unit?): ExternalHoverMeta? {
            (node as JCVariableDecl).sym ?: return null

            if(node.sym.toString() == element.toString()) {

            }
            // filter to instance variables
            return null
        }

        override fun visitClass(node: ClassTree, p: Unit?): ExternalHoverMeta? {
            // we need this logic here to stop calling scan on the same ClassTree infinitely, but we also
            // want to start a new visitor for each nested class decl
            if(!new) {
                return DocExtractionVisitor(task, element, docs).scan(node, null)
            }
            new = false
            classDecl = node
            
            (node as JCClassDecl).sym ?: return super.visitClass(node, p)
            
            if(node.sym.toString() == element.toString()) {
                val doc = docs.getDocComment(currentPath) ?: return super.visitClass(node, p)
                return ExternalHoverMeta(doc, node)
            }

            return super.visitClass(node, p)
        }

        override fun reduce(r1: ExternalHoverMeta?, r2: ExternalHoverMeta?) = r1 ?: r2
    }
}