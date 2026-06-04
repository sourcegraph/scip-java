package com.sourcegraph.io

import java.io.IOException
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes
import java.util.function.Predicate

/**
 * File visitor that recursively deletes a directory tree.
 *
 * Optionally accepts a predicate that decides whether a given file or
 * directory should be deleted. Empty directories are deleted on the
 * post-visit pass.
 */
class DeleteVisitor
@JvmOverloads
constructor(
    private val deleteFile: Predicate<Path> = Predicate { true }
) : SimpleFileVisitor<Path>() {

    override fun preVisitDirectory(dir: Path, attrs: BasicFileAttributes): FileVisitResult =
        if (!deleteFile.test(dir)) FileVisitResult.SKIP_SUBTREE
        else super.preVisitDirectory(dir, attrs)

    override fun visitFile(file: Path, attrs: BasicFileAttributes): FileVisitResult {
        if (deleteFile.test(file)) {
            Files.deleteIfExists(file)
        }
        return super.visitFile(file, attrs)
    }

    override fun postVisitDirectory(dir: Path, exc: IOException?): FileVisitResult {
        Files.list(dir).use { stream ->
            if (!stream.iterator().hasNext()) {
                Files.deleteIfExists(dir)
            }
        }
        return super.postVisitDirectory(dir, exc)
    }

    override fun visitFileFailed(file: Path, exc: IOException): FileVisitResult =
        FileVisitResult.CONTINUE

    companion object {
        @JvmStatic
        fun deleteRecursively(path: Path): Int {
            return try {
                Files.walkFileTree(path, DeleteVisitor())
                0
            } catch (_: NoSuchFileException) {
                0
            } catch (e: IOException) {
                e.printStackTrace()
                1
            }
        }
    }
}
