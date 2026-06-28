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
 * are supplied as {@code -Dsnapshot.*} system properties by the Gradle build.
 */
public class MinimizedSnapshotScipGenerator {
  private static final List<SnapshotCaseSpec> SNAPSHOT_CASES =
      Arrays.asList(
          new SnapshotCaseSpec(
              "java-common",
              "scip-snapshots/expected/java/common",
              "snapshot.case.java-common.targetroot",
              false,
              "17"),
          new SnapshotCaseSpec(
              "java-25",
              "scip-snapshots/expected/java-25",
              "snapshot.case.java-25.targetroot",
              false,
              "25",
              25),
          new SnapshotCaseSpec(
              "kotlin-common",
              "scip-snapshots/expected/kotlin/common",
              "snapshot.case.kotlin-common.targetroot",
              true,
              "17"));

  public static final class SnapshotCase {
    public final String id;
    public final Path expectDirectory;
    public final Path targetroot;
    public final boolean aggregateNoEmitInverseRelationships;
    public final String jdkVersion;

    private SnapshotCase(
        String id,
        Path expectDirectory,
        Path targetroot,
        boolean aggregateNoEmitInverseRelationships,
        String jdkVersion) {
      this.id = id;
      this.expectDirectory = expectDirectory;
      this.targetroot = targetroot;
      this.aggregateNoEmitInverseRelationships = aggregateNoEmitInverseRelationships;
      this.jdkVersion = jdkVersion;
    }

    public SnapshotContext context() {
      return new SnapshotContext(id, expectDirectory);
    }
  }

  private static final class SnapshotCaseSpec {
    private final String id;
    private final String expectDirectory;
    private final String targetrootProperty;
    private final boolean aggregateNoEmitInverseRelationships;
    private final String jdkVersion;
    private final int minimumJavaFeature;

    private SnapshotCaseSpec(
        String id,
        String expectDirectory,
        String targetrootProperty,
        boolean aggregateNoEmitInverseRelationships,
        String jdkVersion) {
      this(
          id,
          expectDirectory,
          targetrootProperty,
          aggregateNoEmitInverseRelationships,
          jdkVersion,
          0);
    }

    private SnapshotCaseSpec(
        String id,
        String expectDirectory,
        String targetrootProperty,
        boolean aggregateNoEmitInverseRelationships,
        String jdkVersion,
        int minimumJavaFeature) {
      this.id = id;
      this.expectDirectory = expectDirectory;
      this.targetrootProperty = targetrootProperty;
      this.aggregateNoEmitInverseRelationships = aggregateNoEmitInverseRelationships;
      this.jdkVersion = jdkVersion;
      this.minimumJavaFeature = minimumJavaFeature;
    }

    private boolean isEnabled() {
      return Runtime.version().feature() >= minimumJavaFeature;
    }

    private SnapshotCase toSnapshotCase(Path sourceroot) {
      return new SnapshotCase(
          id,
          sourceroot.resolve(expectDirectory),
          requiredPathProperty(targetrootProperty),
          aggregateNoEmitInverseRelationships,
          jdkVersion);
    }
  }

  public void run(List<String> args) {
    int exit = ScipJava.app.run(args);
    if (exit != 0) {
      throw new IllegalStateException("scip-java exited with code " + exit + " for args " + args);
    }
  }

  public void run(SnapshotCase snapshotCase, SnapshotHandler handler) {
    String previousJdkVersion = System.getProperty("scip.jdk.version");
    System.setProperty("scip.jdk.version", snapshotCase.jdkVersion);
    try {
      onTargetroot(
          snapshotCase.context(),
          handler,
          snapshotCase.targetroot,
          snapshotCase.aggregateNoEmitInverseRelationships);
    } finally {
      if (previousJdkVersion == null) {
        System.clearProperty("scip.jdk.version");
      } else {
        System.setProperty("scip.jdk.version", previousJdkVersion);
      }
    }
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

  /**
   * The snapshot corpora and their indexing options. This is fixed test metadata, so it lives here
   * rather than in the build script; the Gradle build only supplies each case's compiled
   * target-root (as {@code -Dsnapshot.case.<id>.targetroot}) and the source root, which are
   * build-time paths.
   */
  public static List<SnapshotCase> snapshotCases() {
    Path sourceroot = requiredPathProperty("snapshot.sourceroot");
    return SNAPSHOT_CASES.stream()
        .filter(SnapshotCaseSpec::isEnabled)
        .map(snapshotCase -> snapshotCase.toSnapshotCase(sourceroot))
        .collect(Collectors.toList());
  }

  public static Path requiredPathProperty(String name) {
    return Paths.get(requiredProperty(name));
  }

  private static String requiredProperty(String name) {
    String value = System.getProperty(name);
    if (value == null || value.trim().isEmpty()) {
      throw new IllegalStateException(
          "Missing -D"
              + name
              + ". Run via gradle :scip-snapshots:test or :scip-snapshots:saveSnapshots.");
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
