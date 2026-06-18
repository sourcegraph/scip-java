package tests

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

import scala.jdk.CollectionConverters.CollectionHasAsScala
import scala.jdk.CollectionConverters.SeqHasAsJava

import scala.meta.io.AbsolutePath

import com.sourcegraph.scip_java.ScipJava
import org.scip_code.scip.Index

class MinimizedSnapshotScipGenerator {
  def run(args: List[String]): Unit = {
    val exit = ScipJava.app.run(args.asJava)
    require(exit == 0)
  }
  def run(context: SnapshotContext, handler: SnapshotHandler): Unit = {
    onTargetroot(
      context,
      handler,
      AbsolutePath(BuildInfo.minimizedJavaTargetroot)
    )
  }
  def onTargetroot(
      context: SnapshotContext,
      handler: SnapshotHandler,
      targetroot: AbsolutePath
  ): Unit = {
    val sourceroot = AbsolutePath(BuildInfo.sourceroot)
    val scipOutput = Files
      .createTempDirectory("scip-java")
      .resolve("index.scip")
    val snapshotOutput = AbsolutePath(Files.createTempDirectory("scip-java"))
    run(
      List(
        "aggregate",
        "--cwd",
        sourceroot.toString(),
        "--output",
        scipOutput.toString,
        "--targetroot",
        targetroot.toString()
      )
    )
    val index = Index.parseFrom(Files.readAllBytes(scipOutput))
    // Render the index into golden snapshots with the `scip` CLI (provided on
    // PATH by the nix devShell). scip reads each document's source from disk
    // via the project root recorded in the index metadata and writes one
    // annotated snapshot file per document under `snapshotOutput`.
    os.proc(
        "scip",
        "snapshot",
        "--from",
        scipOutput.toString,
        "--to",
        snapshotOutput.toString,
        "--strict=false"
      )
      .call(stdout = os.Inherit, stderr = os.Inherit)
    try {
      index
        .getDocumentsList
        .asScala
        .foreach { document =>
          val expectOutput = context
            .expectDirectory
            .resolve(Paths.get(document.getRelativePath))
          // Read the rendered snapshot eagerly: some handlers evaluate
          // `obtainedOutput` lazily (the assertion suite defers it to munit),
          // and by then the `finally` block below has deleted the temp dir.
          val obtained =
            new String(
              Files.readAllBytes(
                snapshotOutput.toNIO.resolve(document.getRelativePath)
              ),
              StandardCharsets.UTF_8
            )
          handler.onSnapshotTest(context, expectOutput, () => obtained)
        }
    } finally {
      os.remove.all(os.Path(scipOutput))
      os.remove.all(os.Path(snapshotOutput.toNIO))
    }
  }
}
