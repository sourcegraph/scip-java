package tests;

import java.nio.file.Path;

public final class SnapshotContext {
  public final Path expectDirectory;

  public SnapshotContext(Path expectDirectory) {
    this.expectDirectory = expectDirectory;
  }
}
