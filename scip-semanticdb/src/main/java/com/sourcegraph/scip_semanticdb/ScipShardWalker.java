package com.sourcegraph.scip_semanticdb;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/** Recursively collects every {@code *.scip} shard under each requested target root. */
final class ScipShardWalker extends SimpleFileVisitor<Path> {
  private static final PathMatcher SCIP_PATTERN =
      FileSystems.getDefault().getPathMatcher("glob:**.scip");
  private static final PathMatcher JAR_PATTERN =
      FileSystems.getDefault().getPathMatcher("glob:**.jar");

  private final ArrayList<Path> result = new ArrayList<>();
  private final ScipSemanticdbReporter reporter;

  private ScipShardWalker(ScipSemanticdbReporter reporter) {
    this.reporter = reporter;
  }

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
    if (SCIP_PATTERN.matches(file)) result.add(file);
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) {
    reporter.error(exc);
    return FileVisitResult.CONTINUE;
  }

  /**
   * Returns every {@code *.scip} shard under {@code options.targetroots}. A targetroot that happens
   * to be a {@code .jar} is returned as-is so callers can pick out shards stored inside the
   * archive.
   */
  static List<Path> findShards(ScipSemanticdbOptions options) throws IOException {
    ScipShardWalker walker = new ScipShardWalker(options.reporter);
    for (Path root : options.targetroots) {
      if (JAR_PATTERN.matches(root)) {
        walker.result.add(root);
      } else if (Files.isDirectory(root)) {
        Files.walkFileTree(root, walker);
      }
    }
    return walker.result;
  }
}
