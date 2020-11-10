@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")
package lsifjava

import com.sun.source.tree.ClassTree
import com.sun.source.tree.MethodTree
import com.sun.source.tree.Tree
import com.sun.source.tree.VariableTree
import com.sun.source.util.DocTrees
import com.sun.source.util.JavacTask
import com.sun.source.util.TreePathScanner
import com.sun.tools.javac.api.JavacTool
import com.sun.tools.javac.tree.JCTree.*
import java.nio.file.Path
import javax.lang.model.element.Element
import javax.tools.JavaFileObject
import javax.tools.StandardLocation

data class ExternalHoverMeta(val doc: String, val tree: Tree)

class ExternalDocs(docPaths: List<Path>) {
    private val fileManager = SourceFileManager(docPaths.toSet())

    fun findDocForElement(containerClass: String, javac: JavacTool, element: Element): ExternalHoverMeta? {
        val context = DocumentIndexer.SimpleContext()
        val file = fileManager.getJavaFileForInput(StandardLocation.SOURCE_PATH, containerClass, JavaFileObject.Kind.SOURCE)
            ?: return null

        val task = javac.getTask(NoopWriter, fileManager, CountingDiagnosticListener.StdoutWriter, listOf(), listOf(), listOf(file), context)
        val compUnit = task.parse().iterator().next()
        task.analyze()

        return DocExtractionVisitor(task, element).scan(compUnit, null)
    }
    
    internal class DocExtractionVisitor(task: JavacTask, private val element: Element): TreePathScanner<ExternalHoverMeta?, Unit?>() {
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