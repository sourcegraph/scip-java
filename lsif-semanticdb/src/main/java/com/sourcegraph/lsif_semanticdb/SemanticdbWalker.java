package com.sourcegraph.lsif_semanticdb;

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

/** A file visitor that recursively collects all SemanticDB files in a given directory. */
public class SemanticdbWalker extends SimpleFileVisitor<Path> {
  private final ArrayList<Path> result;
  private final LsifSemanticdbOptions options;
  private final PathMatcher semanticdbPattern;

  public SemanticdbWalker(LsifSemanticdbOptions options) {
    this.options = options;
    result = new ArrayList<>();
    semanticdbPattern = FileSystems.getDefault().getPathMatcher("glob:**.semanticdb");
  }

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    if (semanticdbPattern.matches(file)) {
      result.add(file);
    }
    return super.visitFile(file, attrs);
  }

  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) {
    options.reporter.error(exc);
    return FileVisitResult.CONTINUE;
  }

  public static List<Path> findSemanticdbFiles(LsifSemanticdbOptions options) throws IOException {
    SemanticdbWalker walker = new SemanticdbWalker(options);
    for (Path root : options.targetroots) {
      Files.walkFileTree(root, walker);
    }
    return walker.result;
  }
}
