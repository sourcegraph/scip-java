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

    override fun hashCode() = path.hashCode()

    override fun getKind() = JavaFileObject.Kind.SOURCE

    override fun isNameCompatible(simpleName: String, kind: JavaFileObject.Kind) =
        path.fileName.toString() == simpleName + kind.extension

    override fun getNestingKind(): NestingKind? = null

    override fun getAccessLevel(): Modifier? = null

    override fun toUri(): URI = path.toUri()

    override fun getName() = path.toString()

    override fun openInputStream(): InputStream = IOUtils.toInputStream(contents, StandardCharsets.UTF_8)

    override fun openOutputStream(): OutputStream = throw UnsupportedOperationException()

    override fun openReader(ignoreEncodingErrors: Boolean) = CharSequenceReader(contents)

    override fun getCharContent(ignoreEncodingErrors: Boolean): CharSequence = contents

    override fun openWriter(): Writer = throw UnsupportedOperationException()

    override fun getLastModified() = Instant.EPOCH.toEpochMilli()

    override fun delete(): Boolean = throw UnsupportedOperationException()

    override fun toString() = path.toString()
}
