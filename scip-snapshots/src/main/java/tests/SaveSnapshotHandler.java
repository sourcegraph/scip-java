package tests;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Supplier;
import java.util.stream.Stream;

/** Writes regenerated goldens and prunes any stale snapshot files no longer produced. */
public class SaveSnapshotHandler extends SnapshotHandler {
  private final ConcurrentLinkedDeque<Path> writtenTests = new ConcurrentLinkedDeque<>();

  @Override
  public void onSnapshotTest(
      SnapshotContext context, Path expectFile, Supplier<String> obtainedOutput) {
    try {
      Files.createDirectories(expectFile.getParent());
      Files.write(expectFile, obtainedOutput.get().getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
    writtenTests.add(expectFile);
  }

  @Override
  public void onFinished(SnapshotContext context) {
    if (!Files.exists(context.expectDirectory)) {
      return;
    }
    Set<Path> isWritten = new HashSet<>(writtenTests);
    try {
      Files.walkFileTree(
          context.expectDirectory,
          new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                throws IOException {
              if (!isWritten.contains(file)) {
                Files.deleteIfExists(file);
              }
              return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                throws IOException {
              boolean isEmpty;
              try (Stream<Path> entries = Files.list(dir)) {
                isEmpty = !entries.iterator().hasNext();
              }
              if (isEmpty) {
                Files.deleteIfExists(dir);
              }
              return FileVisitResult.CONTINUE;
            }
          });
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }
}
