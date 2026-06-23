package tests;

import java.nio.file.Path;

public final class SnapshotContext {
  public final String caseId;
  public final Path expectDirectory;

  public SnapshotContext(String caseId, Path expectDirectory) {
    this.caseId = caseId;
    this.expectDirectory = expectDirectory;
  }
}
