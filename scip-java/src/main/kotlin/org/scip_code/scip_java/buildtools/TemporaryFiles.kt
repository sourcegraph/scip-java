package org.scip_code.scip_java.buildtools

import java.nio.file.Files
import java.nio.file.Path
import org.scip_code.scip_java.commands.IndexCommand

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
