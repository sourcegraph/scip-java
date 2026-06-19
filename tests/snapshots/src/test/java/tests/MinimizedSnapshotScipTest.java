package tests;

import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class MinimizedSnapshotScipTest {

  @TestFactory
  List<DynamicTest> minimizedSnapshots() {
    Path expectDir = MinimizedSnapshotScipGenerator.requiredPathProperty("snapshot.expectDir");
    SnapshotContext context = new SnapshotContext(expectDir);
    AssertSnapshotHandler handler = new AssertSnapshotHandler();
    new MinimizedSnapshotScipGenerator().run(context, handler);
    return handler.tests();
  }
}
