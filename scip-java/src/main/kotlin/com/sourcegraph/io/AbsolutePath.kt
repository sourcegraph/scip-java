package com.sourcegraph.io

import java.nio.file.Path
import java.nio.file.Paths

object AbsolutePath {
    @JvmStatic
    fun systemWorkingDirectory(): Path = Paths.get(".").toAbsolutePath().normalize()

    @JvmStatic
    fun of(path: Path): Path = of(path, systemWorkingDirectory())

    @JvmStatic
    fun of(path: Path, cwd: Path): Path =
        when {
            path.isAbsolute -> path
            cwd.isAbsolute -> cwd.resolve(path)
            else -> systemWorkingDirectory().resolve(cwd).resolve(path)
        }
}
