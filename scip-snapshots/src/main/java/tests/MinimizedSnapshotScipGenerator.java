package tests;

import com.sourcegraph.scip_java.ScipJava;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.scip_code.scip.Document;
import org.scip_code.scip.Index;

/**
 * Indexes the {@code scip-snapshots/cases} corpora and renders golden SCIP snapshots. Runtime paths
 * are supplied as {@code -Dsnapshot.*} system properties by the sbt build (see build.sbt),
 * replacing the former sbt-buildinfo generated values.
 */
public class MinimizedSnapshotScipGenerator {
  public static final class SnapshotCase {
    public final String id;
    public final Path expectDirectory;
    public final Path targetroot;
    public final boolean aggregateNoEmitInverseRelationships;

    private SnapshotCase(
        String id,
        Path expectDirectory,
        Path targetroot,
        boolean aggregateNoEmitInverseRelationships) {
      this.id = id;
      this.expectDirectory = expectDirectory;
      this.targetroot = targetroot;
      this.aggregateNoEmitInverseRelationships = aggregateNoEmitInverseRelationships;
    }

    public SnapshotContext context() {
      return new SnapshotContext(id, expectDirectory);
    }
  }

  public void run(List<String> args) {
    int exit = ScipJava.app.run(args);
    if (exit != 0) {
      throw new IllegalStateException("scip-java exited with code " + exit + " for args " + args);
    }
  }

  public void run(SnapshotCase snapshotCase, SnapshotHandler handler) {
    onTargetroot(
        snapshotCase.context(),
        handler,
        snapshotCase.targetroot,
        snapshotCase.aggregateNoEmitInverseRelationships);
  }

  public void onTargetroot(
      SnapshotContext context,
      SnapshotHandler handler,
      Path targetroot,
      boolean aggregateNoEmitInverseRelationships) {
    Path sourceroot = requiredPathProperty("snapshot.sourceroot");
    Path scipTempDir = createTempDirectory();
    Path snapshotOutput = createTempDirectory();
    try {
      Path scipOutput = scipTempDir.resolve("index.scip");
      List<String> aggregateArgs =
          new ArrayList<>(
              Arrays.asList(
                  "aggregate", "--cwd", sourceroot.toString(), "--output", scipOutput.toString()));
      if (aggregateNoEmitInverseRelationships) {
        aggregateArgs.add("--no-emit-inverse-relationships");
      }
      aggregateArgs.add("--targetroot");
      aggregateArgs.add(targetroot.toString());
      run(aggregateArgs);
      Index index;
      try {
        index = Index.parseFrom(Files.readAllBytes(scipOutput));
      } catch (IOException e) {
        throw new UncheckedIOException(e);
      }
      // Render the index into golden snapshots with the `scip` CLI (provided on PATH by the nix
      // devShell). scip reads each document's source from disk via the project root recorded in the
      // index metadata and writes one annotated snapshot file per document under `snapshotOutput`.
      runScipSnapshot(scipOutput, snapshotOutput);
      for (Document document : index.getDocumentsList()) {
        Path expectOutput = context.expectDirectory.resolve(Paths.get(document.getRelativePath()));
        // Read the rendered snapshot eagerly: handlers may defer evaluation (the assertion suite
        // defers it to JUnit), and by then the `finally` block below has deleted the temp dir.
        String obtained;
        try {
          obtained =
              new String(
                  Files.readAllBytes(snapshotOutput.resolve(document.getRelativePath())),
                  StandardCharsets.UTF_8);
        } catch (IOException e) {
          throw new UncheckedIOException(e);
        }
        handler.onSnapshotTest(context, expectOutput, () -> obtained);
      }
    } finally {
      deleteRecursively(scipTempDir);
      deleteRecursively(snapshotOutput);
    }
  }

  public static List<SnapshotCase> snapshotCases() {
    List<SnapshotCase> cases =
        Arrays.stream(requiredProperty("snapshot.cases").split(","))
            .map(String::trim)
            .filter(id -> !id.isEmpty())
            .map(MinimizedSnapshotScipGenerator::snapshotCase)
            .collect(Collectors.toList());
    if (cases.isEmpty()) {
      throw new IllegalStateException("Missing snapshot cases in -Dsnapshot.cases");
    }
    return cases;
  }

  private static SnapshotCase snapshotCase(String id) {
    String prefix = "snapshot.case." + id + ".";
    return new SnapshotCase(
        id,
        requiredPathProperty(prefix + "expectDir"),
        requiredPathProperty(prefix + "targetroot"),
        Boolean.parseBoolean(System.getProperty(prefix + "aggregateNoEmitInverseRelationships")));
  }

  public static Path requiredPathProperty(String name) {
    return Paths.get(requiredProperty(name));
  }

  private static String requiredProperty(String name) {
    String value = System.getProperty(name);
    if (value == null || value.trim().isEmpty()) {
      throw new IllegalStateException(
          "Missing -D" + name + ". Run via sbt scipSnapshots/test or scipSnapshots/run.");
    }
    return value;
  }

  private static void runScipSnapshot(Path from, Path to) {
    List<String> command =
        Arrays.asList(
            "scip", "snapshot", "--from", from.toString(), "--to", to.toString(), "--strict=false");
    try {
      Process process = new ProcessBuilder(command).inheritIO().start();
      int exit = process.waitFor();
      if (exit != 0) {
        throw new IllegalStateException("`scip snapshot` exited with code " + exit);
      }
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException("interrupted while running `scip snapshot`", e);
    }
  }

  private static Path createTempDirectory() {
    try {
      return Files.createTempDirectory("scip-java");
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  private static void deleteRecursively(Path dir) {
    if (dir == null || !Files.exists(dir)) {
      return;
    }
    try (Stream<Path> walk = Files.walk(dir)) {
      walk.sorted(Comparator.reverseOrder())
          .forEach(
              p -> {
                try {
                  Files.deleteIfExists(p);
                } catch (IOException e) {
                  throw new UncheckedIOException(e);
                }
              });
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }
}
