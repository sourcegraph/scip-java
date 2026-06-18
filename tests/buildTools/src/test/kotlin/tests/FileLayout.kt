package tests

import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

/** Converts a text "file layout" description into real files on disk. */
object FileLayout {

    fun mapFromString(layout: String): Map<String, String> {
        if (layout.trim().isEmpty()) return emptyMap()
        val normalized = layout.replace("\r\n", "\n")
        return splitBeforeEntries(normalized).associate { row ->
            val parts = row.removePrefix("\n").split("\n", limit = 2)
            require(parts.size == 2) {
                "Unable to split argument into path/contents!\n$row"
            }
            val (path, contents) = parts
            val withEndOfFileLine =
                if (contents.endsWith("\n")) contents else contents + "\n"
            path.removePrefix("/") to withEndOfFileLine
        }
    }

    /**
     * Splits before every `\n/` boundary, matching the Scala harness'
     * `split("(?=\n/)")`. A boundary at index 0 is kept in the first row (it is
     * stripped later by `removePrefix("\n")`) rather than producing an empty
     * leading row, which is where Kotlin's `Regex.split` would differ.
     */
    private fun splitBeforeEntries(s: String): List<String> {
        val rows = mutableListOf<String>()
        var start = 0
        var i = 1
        while (i < s.length) {
            if (s[i] == '\n' && i + 1 < s.length && s[i + 1] == '/') {
                rows.add(s.substring(start, i))
                start = i
            }
            i++
        }
        rows.add(s.substring(start))
        return rows
    }

    fun fromString(
        layout: String,
        root: Path,
        charset: Charset = StandardCharsets.UTF_8,
    ): Path {
        if (layout.trim().isEmpty()) return root
        for ((path, contents) in mapFromString(layout)) {
            val file = path.split("/").fold(root) { acc, part -> acc.resolve(part) }
            val parent = file.parent
            if (!Files.exists(parent)) Files.createDirectories(parent)
            Files.deleteIfExists(file)
            Files.write(
                file,
                contents.toByteArray(charset),
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE,
            )
        }
        return root
    }
}
