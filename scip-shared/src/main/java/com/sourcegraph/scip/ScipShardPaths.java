package com.sourcegraph.scip;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.Optional;

/**
 * Shared helpers for the canonical SCIP shard output-path and relative-path layout.
 *
 * <p>Every compiler plugin writes one SCIP shard per source file under {@code
 * <targetroot>/META-INF/scip/<relative-source-path>.scip} and labels documents with a unix-style
 * {@code <relative-source-path>}. Both {@code scip-javac} and {@code scip-kotlinc} share this
 * layout.
 *
 * <p>Plugin-specific behavior for files that are <em>not</em> under the sourceroot (e.g. javac's
 * {@code NoRelativePathMode} fallbacks or kotlinc's "skip with warning") stays in the plugins; this
 * class only covers the in-sourceroot happy path.
 */
public final class ScipShardPaths {
  /** Subdirectory of the target root that holds the generated {@code .scip} shards. */
  public static final String SCIP_ROOT = "META-INF/scip";

  private ScipShardPaths() {}

  /**
   * Returns the on-disk {@code .scip} shard path for an absolute source file under {@code
   * sourceRoot}, or {@link Optional#empty()} when the source file is not under {@code sourceRoot}.
   */
  public static Optional<Path> shardPath(
      Path targetRoot, Path sourceRoot, Path absoluteSourcePath) {
    if (!absoluteSourcePath.startsWith(sourceRoot)) {
      return Optional.empty();
    }
    Path relative = sourceRoot.relativize(absoluteSourcePath);
    return Optional.of(shardPathForRelativeSource(targetRoot, relative));
  }

  /**
   * Returns the on-disk {@code .scip} shard path for a source file expressed as a path relative to
   * the source root.
   */
  public static Path shardPathForRelativeSource(Path targetRoot, Path relativeSourcePath) {
    String filename = relativeSourcePath.getFileName().toString() + ".scip";
    return targetRoot
        .resolve("META-INF")
        .resolve("scip")
        .resolve(relativeSourcePath)
        .resolveSibling(filename);
  }

  /**
   * Returns the unix-style {@code Document.relative_path} for the given absolute source file. When
   * the file lives under {@code sourceRoot}, the path is source-root-relative; otherwise it is the
   * file's absolute path. Both cases are joined with {@code '/'} regardless of platform.
   */
  public static String relativePath(Path sourceRoot, Path absoluteSourcePath) {
    Path uriPath =
        absoluteSourcePath.startsWith(sourceRoot)
            ? sourceRoot.relativize(absoluteSourcePath)
            : absoluteSourcePath;
    StringBuilder out = new StringBuilder();
    Iterator<Path> it = uriPath.iterator();
    if (it.hasNext()) out.append(it.next().getFileName().toString());
    while (it.hasNext()) {
      out.append('/').append(it.next().getFileName().toString());
    }
    return out.toString();
  }
}
