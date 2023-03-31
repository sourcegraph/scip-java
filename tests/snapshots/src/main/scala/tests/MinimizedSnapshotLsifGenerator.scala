package tests

import java.nio.charset.StandardCharsets
import java.nio.file.Files

import scala.collection.mutable.ListBuffer

import scala.meta.internal.io.FileIO
import scala.meta.io.AbsolutePath

import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.scip_java.ScipJava
import munit.internal.console.AnsiColors
import munit.internal.difflib.Diffs

class MinimizedSnapshotLsifGenerator extends SnapshotGenerator {
  def run(args: List[String]): Unit = {
    val exit = ScipJava.app.run(args)
    require(exit == 0)
  }
  def onFinished(context: SnapshotContext): Unit = ()
  override def run(context: SnapshotContext, handler: SnapshotHandler): Unit = {
    onTargetroot(
      context,
      handler,
      AbsolutePath(BuildInfo.minimizedJavaTargetroot),
      AbsolutePath(BuildInfo.minimizedJavaSourceDirectory)
    )
    onTargetroot(
      context,
      handler,
      AbsolutePath(BuildInfo.minimizedScalaTargetroot),
      AbsolutePath(BuildInfo.minimizedScalaSourceDirectory)
    )
  }
  def onTargetroot(
      context: SnapshotContext,
      handler: SnapshotHandler,
      targetroot: AbsolutePath,
      sourceDirectory: AbsolutePath
  ): Unit = {
    val sourceroot = AbsolutePath(BuildInfo.sourceroot)
    val scipOutput = Files.createTempDirectory("scip-java").resolve("dump.lsif")
    val snapshotOutput = AbsolutePath(Files.createTempDirectory("scip-java"))
    try {
      run(
        List(
          "index-semanticdb",
          "--cwd",
          sourceroot.toString(),
          "--output",
          scipOutput.toString,
          "--targetroot",
          targetroot.toString()
        )
      )
      run(
        List(
          "snapshot-lsif",
          "--cwd",
          sourceroot.toString(),
          "--input",
          scipOutput.toString,
          "--output",
          snapshotOutput.toString
        )
      )
      val diffs = ListBuffer.empty[String]
      FileIO
        .listAllFilesRecursively(snapshotOutput)
        .foreach { file =>
          val relativeToSourceroot = file.toRelative(snapshotOutput)
          val absoluteSource = sourceroot.resolve(relativeToSourceroot)
          val relativeToSourceDirectory = absoluteSource
            .toRelative(sourceDirectory)
          val expectOutput = AbsolutePath(
            context.expectDirectory.resolve(relativeToSourceDirectory.toNIO)
          )
          val obtainedOutput = FileIO.slurp(file, StandardCharsets.UTF_8)
          val expectedOutput = FileIO
            .slurp(expectOutput, StandardCharsets.UTF_8)
          val diff = Diffs.create(obtainedOutput, expectedOutput).unifiedDiff
          if (diff.nonEmpty) {
            val filename = relativeToSourceDirectory.toURI(false).toString
            val header = "=" * (filename.length + 2)
            diffs += header
            diffs += s"= $filename"
            diffs += header
            diffs += "++ expected"
            diffs += "-- obtained"
            diffs += AnsiColors.filterAnsi(diff)
          }
        }
      val expectFile = context.expectDirectory.resolve("snapshot-lsif.diff")
      handler.onSnapshotTest(context, expectFile, () => diffs.mkString("\n"))
    } finally {
      Files.walkFileTree(scipOutput, new DeleteVisitor())
      Files.walkFileTree(snapshotOutput.toNIO, new DeleteVisitor())
    }
  }
}
