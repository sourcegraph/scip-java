package com.sourcegraph.io

import java.nio.file.Path
import java.nio.file.Paths

object AbsolutePath {
    fun systemWorkingDirectory(): Path = Paths.get(".").toAbsolutePath().normalize()

    fun of(path: Path): Path = of(path, systemWorkingDirectory())

    fun of(path: Path, cwd: Path): Path =
        when {
            path.isAbsolute -> path
            cwd.isAbsolute -> cwd.resolve(path)
            else -> systemWorkingDirectory().resolve(cwd).resolve(path)
        }
}
