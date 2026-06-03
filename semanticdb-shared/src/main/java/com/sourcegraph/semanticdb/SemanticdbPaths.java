package com.sourcegraph.semanticdb;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.Optional;

/**
 * Shared helpers for the canonical SemanticDB output-path and URI layout.
 *
 * <p>Every SemanticDB producer writes payloads under {@code
 * <targetroot>/META-INF/semanticdb/<relative-source-path>.semanticdb} and labels documents with a
 * unix-style {@code <relative-source-path>} URI. Both {@code semanticdb-javac} and {@code
 * semanticdb-kotlinc} converged on the same layout, so the policy lives here.
 *
 * <p>Plugin-specific behavior for files that are <em>not</em> under the sourceroot (e.g. javac's
 * {@code NoRelativePathMode} fallbacks or kotlinc's "skip with warning") stays in the plugins; this
 * class only covers the in-sourceroot happy path.
 */
public final class SemanticdbPaths {
  /** Subdirectory of the target root that holds the generated {@code .semanticdb} payloads. */
  public static final String SEMANTICDB_ROOT = "META-INF/semanticdb";

  private SemanticdbPaths() {}

  /**
   * Returns the on-disk {@code .semanticdb} payload path for an absolute source file under {@code
   * sourceRoot}, or {@link Optional#empty()} when the source file is not under {@code sourceRoot}.
   */
  public static Optional<Path> semanticdbPath(
      Path targetRoot, Path sourceRoot, Path absoluteSourcePath) {
    if (!absoluteSourcePath.startsWith(sourceRoot)) {
      return Optional.empty();
    }
    Path relative = sourceRoot.relativize(absoluteSourcePath);
    return Optional.of(semanticdbPathForRelativeSource(targetRoot, relative));
  }

  /**
   * Returns the on-disk {@code .semanticdb} payload path for a source file expressed as a path
   * relative to the source root.
   */
  public static Path semanticdbPathForRelativeSource(Path targetRoot, Path relativeSourcePath) {
    String filename = relativeSourcePath.getFileName().toString() + ".semanticdb";
    return targetRoot
        .resolve("META-INF")
        .resolve("semanticdb")
        .resolve(relativeSourcePath)
        .resolveSibling(filename);
  }

  /**
   * Returns the unix-style {@code TextDocument.uri} for the given absolute source file. When the
   * file lives under {@code sourceRoot}, the URI is the source-root-relative path; otherwise it is
   * the file's absolute path. Both cases are joined with {@code '/'} regardless of platform.
   */
  public static String semanticdbUri(Path sourceRoot, Path absoluteSourcePath) {
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
