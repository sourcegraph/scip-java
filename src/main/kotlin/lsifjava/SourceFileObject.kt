package lsifjava

import com.google.common.io.Files
import org.apache.commons.io.IOUtils
import org.apache.commons.io.input.CharSequenceReader
import java.io.InputStream
import java.io.OutputStream
import java.io.Reader
import java.io.Writer
import java.net.URI
import java.nio.charset.StandardCharsets
import java.nio.file.Path
import java.time.Instant
import javax.lang.model.element.Modifier
import javax.lang.model.element.NestingKind
import javax.tools.JavaFileObject


class SourceFileObject @JvmOverloads constructor(
    /** path is the absolute path to this file on disk  */
    val path: Path,
    /** contents is the text in this file, or null if we should use the text in FileStore  */
    val contents: String = Files.asCharSource(path.toFile(), StandardCharsets.UTF_8).read()) : JavaFileObject {
    override fun equals(other: Any?): Boolean {
        if (other!!.javaClass != SourceFileObject::class.java) return false
        val that = other as SourceFileObject?
        return path == that!!.path
    }

    override fun hashCode(): Int {
        return path.hashCode()
    }

    override fun getKind(): JavaFileObject.Kind {
        return JavaFileObject.Kind.SOURCE
    }

    override fun isNameCompatible(simpleName: String, kind: JavaFileObject.Kind): Boolean {
        return path.fileName.toString() == simpleName + kind.extension
    }

    override fun getNestingKind(): NestingKind? {
        return null
    }

    override fun getAccessLevel(): Modifier? {
        return null
    }

    override fun toUri(): URI {
        return path.toUri()
    }

    override fun getName(): String {
        return path.toString()
    }

    override fun openInputStream(): InputStream {
        return IOUtils.toInputStream(contents, StandardCharsets.UTF_8)
    }

    override fun openOutputStream(): OutputStream {
        throw UnsupportedOperationException()
    }

    override fun openReader(ignoreEncodingErrors: Boolean): Reader {
        return CharSequenceReader(contents)
    }

    override fun getCharContent(ignoreEncodingErrors: Boolean): CharSequence {
        return contents
    }

    override fun openWriter(): Writer {
        throw UnsupportedOperationException()
    }

    override fun getLastModified(): Long {
        return Instant.EPOCH.toEpochMilli()
    }

    override fun delete(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun toString(): String {
        return path.toString()
    }
}
