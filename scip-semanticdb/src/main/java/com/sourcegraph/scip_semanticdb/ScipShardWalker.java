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

/**
 * A file visitor that recursively collects per-source SCIP shard files ({@code *.scip}) emitted by
 * the compiler plug-ins. Only files under a {@code META-INF/scip/} directory are returned so we
 * don't accidentally re-ingest a previously-written aggregate {@code index.scip} that may live in
 * the same target tree.
 */
public class ScipShardWalker extends SimpleFileVisitor<Path> {
  private final ArrayList<Path> result;
  private final ScipSemanticdbOptions options;
  private final PathMatcher scipPattern =
      FileSystems.getDefault().getPathMatcher("glob:**/META-INF/scip/**.scip");

  public ScipShardWalker(ScipSemanticdbOptions options) {
    this.options = options;
    result = new ArrayList<>();
  }

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    if (scipPattern.matches(file)) {
      result.add(file);
    }
    return super.visitFile(file, attrs);
  }

  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) {
    options.reporter.error(exc);
    return FileVisitResult.CONTINUE;
  }

  /** Returns all {@code *.scip} shard files reachable from {@code options.targetroots}. */
  public static List<Path> findScipShards(ScipSemanticdbOptions options) throws IOException {
    ScipShardWalker walker = new ScipShardWalker(options);
    PathMatcher jarPattern = FileSystems.getDefault().getPathMatcher("glob:**.jar");
    for (Path root : options.targetroots) {
      if (jarPattern.matches(root)) {
        walker.result.add(root);
      } else if (Files.exists(root)) {
        Files.walkFileTree(root, walker);
      }
    }
    return walker.result;
  }
}
