@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")
package lsifjava

import com.sun.source.tree.*
import com.sun.source.util.DocTrees
import com.sun.source.util.JavacTask
import com.sun.source.util.TreePathScanner
import com.sun.tools.javac.util.Context
import com.sun.tools.javac.api.JavacTool
import com.sun.tools.javac.tree.JCTree.*
import java.nio.charset.Charset
import java.nio.file.Path
import javax.lang.model.element.Element
import javax.tools.*

data class ExternalHoverMeta(val doc: String, val tree: Tree)

class ExternalDocs(docPaths: List<Path>) {
    private val fileManager = SourceFileManager(docPaths.toSet())

    private val fileCache = HashMap<String, Pair<JavacTask, CompilationUnitTree>?>()
    fun findDocForElement(containerClass: String, javac: JavacTool, element: Element): ExternalHoverMeta? {
        val context = DocumentIndexer.SimpleContext()

        val (task, compUnit) = fileCache.getOrElse(containerClass) { analyzeFileFromJar(containerClass, context, javac) }
            ?: return null

        return DocExtractionVisitor(task, element).scan(compUnit, null)
    }

    private fun analyzeFileFromJar(containerClass: String, context: Context, javac: JavacTool): Pair<JavacTask, CompilationUnitTree>? {
        val file = fileManager.getJavaFileForInput(StandardLocation.SOURCE_PATH, containerClass, JavaFileObject.Kind.SOURCE)
            ?: return null
        val task = javac.getTask(NoopWriter, fileManager, CountingDiagnosticListener.NullWriter, listOf(), listOf(), listOf(file), context)
        val compUnit = task.parse().iterator().next()
        val analyzeResult = runCatching { task.analyze() }
        analyzeResult.getOrNull() ?: run {
            //println("${file.name} threw exception")
            return null
        }
        return Pair(task, compUnit)
    }
    
    private class DocExtractionVisitor(task: JavacTask, private val element: Element): TreePathScanner<ExternalHoverMeta?, Unit?>() {
        private val docs: DocTrees = DocTrees.instance(task)

        override fun visitMethod(node: MethodTree?, p: Unit?): ExternalHoverMeta? {
            (node as JCMethodDecl).sym ?: return null

            if(node.sym.toString() == element.toString()) {
                return ExternalHoverMeta(docs.getDocComment(currentPath), node)
            }

            return null
        }

        override fun visitVariable(node: VariableTree?, p: Unit?): ExternalHoverMeta? {
            (node as JCVariableDecl).sym ?: return null

            if(node.sym.toString() == element.toString()) {

            }
            // filter to instance variables
            return super.visitVariable(node, p)
        }

        override fun visitClass(node: ClassTree?, p: Unit?): ExternalHoverMeta? {
            (node as JCClassDecl).sym ?: return null
            
            if(node.sym.toString() == element.toString()) {
                return ExternalHoverMeta(docs.getDocComment(currentPath), node)
            }

            return super.visitClass(node, p)
        }

        override fun reduce(r1: ExternalHoverMeta?, r2: ExternalHoverMeta?) = r1 ?: r2
    }
}