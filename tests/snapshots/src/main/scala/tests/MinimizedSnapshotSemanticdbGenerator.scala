package tests

import scala.meta.io.AbsolutePath

import com.sourcegraph.scip_java.SemanticdbPrinters
import com.sourcegraph.scip_semanticdb.ScipTextDocument

class MinimizedSnapshotSemanticdbGenerator extends SnapshotGenerator {
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
      val doc = ScipTextDocument
        .manifestOccurrencesForSyntheticSymbols(file.textDocument)
      handler.onSnapshotTest(
        context,
        expectOutput,
        () => SemanticdbPrinters.printTextDocument(doc)
      )
    }
  }
}
