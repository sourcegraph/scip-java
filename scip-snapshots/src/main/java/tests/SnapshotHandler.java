package tests;

import java.nio.file.Path;
import java.util.function.Supplier;

public abstract class SnapshotHandler {
  public void onSnapshotTest(
      SnapshotContext context, Path expectFile, Supplier<String> obtainedOutput) {}

  public void onFinished(SnapshotContext context) {}
}
