package tests

import java.nio.charset.StandardCharsets
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.atomic.AtomicInteger

import scala.meta.inputs.Input
import scala.meta.internal.io.FileIO
import scala.meta.io.AbsolutePath

import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.lsif_java.Dependencies
import com.sourcegraph.lsif_java.SemanticdbPrinters

class LibrarySnapshotGenerator extends SnapshotGenerator {
  val javaPattern = FileSystems.getDefault.getPathMatcher("glob:**.java")
  private case class IndexMetrics(occurrenceCount: Int, linesOfCode: Int)

  override def run(context: SnapshotContext, handler: SnapshotHandler): Unit = {
    val gen = new Gen(context, handler)
    gen.checkLibrary(
      "com.airbnb.android:epoxy:4.3.1",
      isIncluded = jar => jar.contains("epoxy")
    )
  }
  private class Gen(context: SnapshotContext, handler: SnapshotHandler) {
    def checkLibrary(
        name: String,
        provided: List[String] = Nil,
        isIncluded: String => Boolean = _ => true
    ): Unit = {
      println(s"indexing library '$name'")
      val deps = Dependencies.resolveDependencies(name :: provided.toList)
      val options = List("-Xlint:none")
      val counter = new AtomicInteger()
      val targetroot = Files.createTempDirectory("semanticdb-javac")

      val compiler = new TestCompiler(deps.classpathSyntax, options, targetroot)
      val timer = new Timer()
      val toIndex = deps.sources.filter(p => isIncluded(p.getFileName.toString))
      toIndex.foreach { source =>
        val metrics = compileSourcesJar(source, compiler)
        val i = counter.incrementAndGet()
        val message =
          f"$i%3s/${toIndex.size} jars; $timer%6s; " +
            f"${metrics.occurrenceCount}%,.0f occurrences; " +
            f"${metrics.linesOfCode}%,.0f loc; " + f"${source.getFileName}"
        println(message)
      }
      Files.walkFileTree(targetroot, new DeleteVisitor())
    }

    private def compileSourcesJar(
        source: Path,
        compiler: TestCompiler
    ): IndexMetrics = {
      var occurrenceCount, linesOfCode = 0
      FileIO
        .withJarFileSystem(AbsolutePath(source), create = false, close = true) {
          root =>
            val inputs =
              FileIO
                .listAllFilesRecursively(root)
                .iterator
                .filter(file => javaPattern.matches(file.toNIO))
                .map { file =>
                  val relpath = file.toRelative(root).toString()
                  val text = FileIO.slurp(file, StandardCharsets.UTF_8)
                  linesOfCode += text.linesIterator.size
                  Input.VirtualFile(relpath, text)
                }
                .toArray

            val result = compiler.compileSemanticdb(inputs)
            result
              .textDocuments
              .getDocumentsList
              .forEach { textDocument =>
                occurrenceCount += textDocument.getOccurrencesCount
                val print = SemanticdbPrinters.printTextDocument(textDocument)
                val out = context.expectDirectory.resolve(textDocument.getUri)
                handler.onSnapshotTest(context, out, () => print)
              }
        }
      IndexMetrics(occurrenceCount, linesOfCode)
    }
  }
}
