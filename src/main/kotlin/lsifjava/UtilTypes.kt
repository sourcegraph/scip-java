package lsifjava

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.ByteArrayOutputStream
import java.io.Writer
import java.nio.file.Path

inline class CanonicalPath(val path: Path) {
    override fun toString(): String = path.toFile().canonicalPath
}

// OutputStreamWriter.nullWriter() CANT USE IN JAVA 8 :(
object NoopWriter: Writer() {
    override fun close() = Unit
    override fun flush() = Unit
    override fun write(p0: CharArray, p1: Int, p2: Int) = Unit
}

inline class Classpath(private val classpaths: Set<String>) {
    operator fun plus(other: Set<String>) = Classpath(classpaths.union(other))

    operator fun plus(other: Classpath) = Classpath(classpaths.union(other.classpaths))
    
    fun size() = classpaths.size
    
    override fun toString() = classpaths.joinToString(":")
}

fun List<Classpath>.merge() = when(this.isEmpty()) {
    false -> this.reduce { acc, classpath -> acc + classpath }
    else -> {
        println("no classpaths were inferred, symbol resolution for external dependencies may fail.")
        Classpath(setOf())
    }
}

fun execAndReadStdoutAndStderr(shellCommand: String, directory: Path): Pair<String, String> {
    val process = Runtime.getRuntime().exec(shellCommand, null, directory.toFile())
    val output = ByteArrayOutputStream().writer()
    val errors = ByteArrayOutputStream().writer()

    runBlocking(Dispatchers.IO) {
        launch {
            process.inputStream.bufferedReader().use { it.copyTo(output) }
        }

        launch {
            process.errorStream.bufferedReader().use { it.copyTo(errors) }
        }
    }

    return Pair(output.toString(), errors.toString())
}