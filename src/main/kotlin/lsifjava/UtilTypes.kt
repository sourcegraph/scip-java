package lsifjava

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
