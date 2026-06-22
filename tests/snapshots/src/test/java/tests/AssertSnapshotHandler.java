package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.junit.jupiter.api.DynamicTest;

/**
 * Collects one {@link DynamicTest} per generated document, asserting the rendered snapshot matches
 * the committed golden. The obtained output is captured eagerly because the generator deletes its
 * temp directories as soon as {@code run()} returns, before the dynamic tests execute.
 */
final class AssertSnapshotHandler extends SnapshotHandler {
  private final List<DynamicTest> tests = new ArrayList<>();

  List<DynamicTest> tests() {
    return tests;
  }

  @Override
  public void onSnapshotTest(
      SnapshotContext context, Path expectFile, Supplier<String> obtainedOutput) {
    String relativePath = context.expectDirectory.relativize(expectFile).toString();
    String obtained = obtainedOutput.get();
    tests.add(
        dynamicTest(
            relativePath,
            () -> {
              if (!Files.isRegularFile(expectFile)) {
                fail(
                    "no snapshot file for "
                        + relativePath
                        + ". To fix this problem, execute the command 'sbt snapshots/run'");
              }
              String expected;
              try {
                expected = new String(Files.readAllBytes(expectFile), StandardCharsets.UTF_8);
              } catch (IOException e) {
                throw new UncheckedIOException(e);
              }
              assertEquals(expected, obtained, relativePath);
            }));
  }
}
