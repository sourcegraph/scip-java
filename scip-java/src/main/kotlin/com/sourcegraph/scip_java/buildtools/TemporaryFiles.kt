package com.sourcegraph.scip_java.buildtools

import com.sourcegraph.scip_java.commands.IndexCommand
import java.nio.file.Files
import java.nio.file.Path

object TemporaryFiles {
    fun <T> withDirectory(index: IndexCommand, fn: (Path) -> T): T {
        val explicit = index.temporaryDirectory
        if (explicit != null) {
            return fn(explicit)
        }
        val tmp = Files.createTempDirectory("scip-java")
        try {
            return fn(tmp)
        } finally {
            if (index.cleanup) {
                tmp.toFile().deleteRecursively()
            }
        }
    }
}
