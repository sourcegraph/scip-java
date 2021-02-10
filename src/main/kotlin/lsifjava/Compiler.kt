package lsifjava

import com.sun.source.tree.CompilationUnitTree
import com.sun.source.util.JavacTask
import com.sun.tools.javac.api.JavacTool
import com.sun.tools.javac.main.JavaCompiler
import com.sun.tools.javac.util.Context

fun generateParseTree(
    systemProvider: JavacTool,
    fileManager: SourceFileManager,
    diagnosticListener: CountingDiagnosticListener,
    javaSourceVersion: String,
    classpath: Classpath,
    filepath: CanonicalPath
): Pair<JavacTask, CompilationUnitTree> {
    val task = systemProvider.getTask(
        NoopWriter, fileManager, diagnosticListener,
        listOf("-proc:none", "-nowarn", "-source", javaSourceVersion, "-classpath", classpath.toString() /*, "--enable-preview" */),
        listOf(), listOf(SourceFileObject(filepath.path)), SimpleContext()
    )
    val compUnit = task.parse().iterator().next()
    task.analyze()

    return Pair(task, compUnit)
}

/**
 * Context lets us configure some aspects of the parsing process. SimpleContext
 * incorporates a SimpleCompiler that configures the parser to generate end positions,
 * preserve javadoc and keep line debug info (not sure if we use that currently/ever).
 */
class SimpleContext: Context() {
    init {
        put(SimpleCompiler.contextKey, SimpleCompiler.factory)
    }
}

private class SimpleCompiler(context: Context?): JavaCompiler(context) {
    companion object {
        val factory = Context.Factory<JavaCompiler> { context: Context? -> SimpleCompiler(context) }

        val contextKey: Context.Key<JavaCompiler> by lazy {
            // compilerKey is not public in Java 8, so we have to kinda: https://media.discordapp.net/attachments/287739410286379019/806651592216281108/unknown.png
            if(javaVersion == 8) run {
                val field = SimpleCompiler::class.java.superclass.getDeclaredField("compilerKey")
                field.isAccessible = true
                val key: Context.Key<JavaCompiler> = Context.Key() // dummy value to be overwritten
                return@lazy field.get(key) as Context.Key<JavaCompiler>
            }
            compilerKey
        }
    }

    init {
        genEndPos = true
        lineDebugInfo = true
        keepComments = true
    }
}