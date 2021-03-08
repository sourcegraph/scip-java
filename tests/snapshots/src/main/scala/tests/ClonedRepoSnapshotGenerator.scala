package tests

import scala.meta.io.AbsolutePath

class ClonedRepoSnapshotGenerator extends SnapshotGenerator {
  override def run(context: SnapshotContext, handler: SnapshotHandler): Unit = {
    val files = SemanticdbFile.fromDirectory(
      AbsolutePath("/home/noah/Java/ReFund-Backend/src/main/java"),
      AbsolutePath("/home/noah/Java/ReFund-Backend/"),
      AbsolutePath("/home/noah/Java/ReFund-Backend/build/semanticdb-targetroot"),
    )

    println(files.size)

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
        () => {
          //println(file.textDocument)
          SemanticdbPrinters.printTextDocument(file.textDocument)
        }
      )
    }
  }
}
