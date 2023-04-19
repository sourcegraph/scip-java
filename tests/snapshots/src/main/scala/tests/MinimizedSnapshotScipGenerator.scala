package tests

import java.net.URI
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

import scala.jdk.CollectionConverters.CollectionHasAsScala

import scala.meta.internal.io.FileIO
import scala.meta.io.AbsolutePath

import com.sourcegraph.Scip.Index
import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.scip_java.ScipJava
import com.sourcegraph.scip_java.ScipPrinters

class MinimizedSnapshotScipGenerator extends SnapshotGenerator {
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
    val scipOutput = Files
      .createTempDirectory("scip-java")
      .resolve("index.scip")
    val snapshotOutput = AbsolutePath(Files.createTempDirectory("scip-java"))
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
    val index = Index.parseFrom(Files.readAllBytes(scipOutput))
    try {
      index
        .getDocumentsList
        .asScala
        .foreach { document =>
          val expectOutput = context
            .expectDirectory
            .resolve(Paths.get(document.getRelativePath))
          handler.onSnapshotTest(
            context,
            expectOutput,
            () => {
              val uri = URI.create(
                List(
                  index.getMetadata.getProjectRoot.stripSuffix("/"),
                  document.getRelativePath
                ).mkString("/")
              )
              val absolutePath = AbsolutePath(Paths.get(uri))
              val text = FileIO.slurp(absolutePath, StandardCharsets.UTF_8)
              ScipPrinters.printTextDocument(document, text)
            }
          )
        }
    } finally {
      Files.walkFileTree(scipOutput, new DeleteVisitor())
      Files.walkFileTree(snapshotOutput.toNIO, new DeleteVisitor())
    }
  }
}
