package com.sourcegraph.io

import java.nio.file.Path
import java.nio.file.Paths

object AbsolutePath {
  def systemWorkingDirectory: Path = Paths.get(".").toAbsolutePath.normalize()
  def of(path: Path): Path = of(path, systemWorkingDirectory)
  def of(path: Path, cwd: Path): Path =
    if (path.isAbsolute)
      path
    else if (cwd.isAbsolute)
      cwd.resolve(path)
    else
      systemWorkingDirectory.resolve(cwd).resolve(path)
}
