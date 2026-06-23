package tests;

import java.util.List;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class MinimizedSnapshotScipTest {

  @TestFactory
  List<DynamicTest> minimizedSnapshots() {
    AssertSnapshotHandler handler = new AssertSnapshotHandler();
    MinimizedSnapshotScipGenerator generator = new MinimizedSnapshotScipGenerator();
    for (MinimizedSnapshotScipGenerator.SnapshotCase snapshotCase :
        MinimizedSnapshotScipGenerator.snapshotCases()) {
      generator.onTargetroot(
          snapshotCase.context(),
          handler,
          snapshotCase.targetroot,
          snapshotCase.aggregateNoEmitInverseRelationships);
    }
    return handler.tests();
  }
}
