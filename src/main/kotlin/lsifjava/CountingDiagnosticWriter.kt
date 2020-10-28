package lsifjava

import java.io.File
import java.io.PrintStream
import java.io.Writer
import javax.tools.Diagnostic
import javax.tools.DiagnosticListener

fun createJavacDiagnosticListener(javacOutDest: String): CountingDiagnosticListener {
    return when(javacOutDest) {
        "stdout" -> CountingDiagnosticListener.StdoutWriter
        "stderr" -> CountingDiagnosticListener.StderrWriter
        "none" -> CountingDiagnosticListener.NullWriter
        else -> CountingDiagnosticListener.FileWriter(javacOutDest)
    }
}

sealed class CountingDiagnosticListener(private val out: Writer): DiagnosticListener<Any>, AutoCloseable {
    var count = 0

    override fun report(diagnostic: Diagnostic<out Any>?) {
        count++
        out.write(diagnostic.toString())
        out.flush()
    }

    override fun close() = out.close()

    class FileWriter(path: String): CountingDiagnosticListener(PrintStream(File(path)).writer())
    
    object StdoutWriter: CountingDiagnosticListener(System.out.writer()) {
        override fun close() = Unit
    }

    object StderrWriter: CountingDiagnosticListener(System.err.writer()) {
        override fun close() = Unit
    }

    object NullWriter: CountingDiagnosticListener(NoopWriter)
}

// OutputStreamWriter.nullWriter() CANT USE IN JAVA 8 :(
object NoopWriter: Writer() {
    override fun close() = Unit
    override fun flush() = Unit
    override fun write(p0: CharArray, p1: Int, p2: Int) = Unit
}
