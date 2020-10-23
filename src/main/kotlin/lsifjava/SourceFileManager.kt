@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")
package lsifjava

import com.sun.tools.javac.file.JavacFileManager
import com.sun.tools.javac.util.Context
import java.io.IOException
import java.nio.charset.Charset
import java.nio.file.Path
import java.util.regex.Pattern
import java.util.stream.Stream
import javax.tools.FileObject
import javax.tools.JavaFileManager
import javax.tools.JavaFileObject
import javax.tools.StandardLocation


class SourceFileManager internal constructor(private val paths: Set<Path>) : JavacFileManager(Context(), false, Charset.defaultCharset()) {
    @Throws(IOException::class)
    override fun list(
        location: JavaFileManager.Location, packageName: String, kinds: Set<JavaFileObject.Kind>, recurse: Boolean): Iterable<JavaFileObject> {
        return if (location === StandardLocation.SOURCE_PATH) {
            val sourceFileObjectStream = list(packageName)
            Iterable { sourceFileObjectStream.iterator() }
        } else {
            super.list(location, packageName, kinds, recurse)
        }
    }

    private fun list(packageName: String): Stream<JavaFileObject> {
        return paths.stream().map { path: Path? ->
            try {
                return@map SourceFileObject(path!!)
            } catch (e: IOException) {
                return@map null
            }
        }.filter { obj: SourceFileObject? -> packageName(obj!!) == packageName }
         .map { obj: SourceFileObject? -> obj }
    }

    override fun inferBinaryName(location: JavaFileManager.Location, file: JavaFileObject): String {
        return if (location === StandardLocation.SOURCE_PATH) {
            val source = file as SourceFileObject
            val packageName = packageName(source)
            var className = removeExtension(source.path.fileName.toString())
            if (packageName.isNotEmpty()) className = "$packageName.$className"
            className
        } else {
            super.inferBinaryName(location, file)
        }
    }

    private fun removeExtension(fileName: String): String = fileName.lastIndexOf(".").let {
        if(it == -1) fileName else fileName.substring(0, it)
    }

    override fun hasLocation(location: JavaFileManager.Location): Boolean {
        return location === StandardLocation.SOURCE_PATH || super.hasLocation(location)
    }

    @Throws(IOException::class)
    override fun getJavaFileForInput(location: JavaFileManager.Location, className: String, kind: JavaFileObject.Kind): JavaFileObject? {
        // FileStore shadows disk
        if (location === StandardLocation.SOURCE_PATH) {
            if (className == "module-info") return null
            val packageName = mostName(className)
            val simpleClassName = lastName(className)
            val iterator: Iterator<SourceFileObject> = list(packageName).map { obj: JavaFileObject ->
                obj as SourceFileObject
            }.iterator()
            var f = iterator.next()
            while (iterator.hasNext()) {
                if (f.path.fileName.toString() == simpleClassName + kind.extension) {
                    return f
                }
                f = iterator.next()
            }
            // Fall through to disk in case we have .jar or .zip files on the source path
        }
        return super.getJavaFileForInput(location, className, kind)
    }

    @Throws(IOException::class)
    override fun getFileForInput(location: JavaFileManager.Location, packageName: String, relativeName: String): FileObject? {
        return if (location === StandardLocation.SOURCE_PATH) {
            null
        } else super.getFileForInput(location, packageName, relativeName)
    }

    @Throws(IOException::class)
    override fun contains(location: JavaFileManager.Location, file: FileObject): Boolean {
        return if (location === StandardLocation.SOURCE_PATH) {
            val source = file as SourceFileObject
            paths.contains(source.path)
        } else {
            super.contains(location, file)
        }
    }
}

private fun packageName(file: SourceFileObject): String {
    val packagePattern = Pattern.compile("^package +(.*);")
    val startOfClass = Pattern.compile("^[\\w ]*class +\\w+")
    val lines = file.contents.lineSequence().iterator()
    var line = lines.next()
    do {
        if (startOfClass.matcher(line).find()) return ""
        val matchPackage = packagePattern.matcher(line)
        if (matchPackage.matches()) {
            return matchPackage.group(1)
        }
        line = lines.next()
    } while(lines.hasNext())
    // TODO fall back on parsing file
    return ""
}

// TODO this doesn't work for inner classes, eliminate
private fun mostName(name: String): String {
    val lastDot = name.lastIndexOf('.')
    return if (lastDot == -1) "" else name.substring(0, lastDot)
}

// TODO this doesn't work for inner classes, eliminate
private fun lastName(name: String): String {
    val i = name.lastIndexOf('.')
    return if (i == -1) name else name.substring(i + 1)
}
