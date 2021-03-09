package tests

import scala.meta.io.AbsolutePath

import com.sourcegraph.lsif_java.SemanticdbPrinters

class MinimizedSnapshotGenerator extends SnapshotGenerator {
  override def run(context: SnapshotContext, handler: SnapshotHandler): Unit = {
    val sourceroot = AbsolutePath(BuildInfo.sourceroot)
    val fromJavac = SemanticdbFile.fromDirectory(
      AbsolutePath(BuildInfo.minimizedJavaSourceDirectory),
      sourceroot,
      AbsolutePath(BuildInfo.minimizedJavaTargetroot)
    )
    val fromScalac = SemanticdbFile.fromDirectory(
      AbsolutePath(BuildInfo.minimizedScalaSourceDirectory),
      sourceroot,
      AbsolutePath(BuildInfo.minimizedScalaTargetroot)
    )
    val files = fromJavac ++ fromScalac
    files.foreach { file =>
      val relativeToSourceDirectory = file
        .javaPath
        .toRelative(file.sourceDirectory)
      val expectOutput = context
        .expectDirectory
        .resolve(relativeToSourceDirectory.toNIO)
      handler.onSnapshotTest(
        context,
        expectOutput,
        () => SemanticdbPrinters.printTextDocument(file.textDocument)
      )
    }
  }
}
