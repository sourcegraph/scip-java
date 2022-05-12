package benchmarks

import java.nio.charset.StandardCharsets
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.TimeUnit

import scala.meta.inputs.Input
import scala.meta.internal.io.FileIO
import scala.meta.io.AbsolutePath

import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.scip_java.Dependencies
import org.openjdk.jmh.annotations._
import tests.TestCompiler

@State(Scope.Benchmark)
class CompileBench {

  var deps: Dependencies = _
  var tmp: Path = _
  var compiler: TestCompiler = _

  @Param(Array("bytebuddy", "guava"))
  var lib: String = _

  val libs = Map(
    "bytebuddy" -> "net.bytebuddy:byte-buddy:1.10.20",
    "guava" -> "com.google.guava:guava:30.1-jre"
  )

  @Setup()
  def setup(): Unit = {
    tmp = Files.createTempDirectory("benchmarks")
    deps = Dependencies.resolveDependencies(List(libs(lib)))
    compiler =
      new TestCompiler(
        deps.classpathSyntax,
        javacOptions = Nil,
        scalacOptions = Nil,
        targetroot = tmp
      )
  }

  @TearDown()
  def teardown(): Unit = {
    Files.walkFileTree(tmp, new DeleteVisitor)
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.SingleShotTime))
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  def compile(): Long = {
    CompileBench.foreachSource(deps) { inputs =>
      compiler.compile(inputs).byteCode.length
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.SingleShotTime))
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  def compileSemanticdb(): Long = {
    CompileBench.foreachSource(deps) { inputs =>
      compiler.compileSemanticdb(inputs).textDocument.getOccurrencesCount
    }
  }

}
object CompileBench {
  private val javaPattern = FileSystems
    .getDefault
    .getPathMatcher("glob:**.java")
  def foreachSource(
      deps: Dependencies
  )(fn: Seq[Input.VirtualFile] => Int): Long = {
    var sum = 0L
    deps
      .sources
      .foreach { source =>
        val path = AbsolutePath(source)
        FileIO.withJarFileSystem(path, create = false, close = true) { root =>
          val files =
            FileIO
              .listAllFilesRecursively(root)
              .iterator
              .filter(p => javaPattern.matches(p.toNIO))
              .toArray
          val inputs = files.map { source =>
            val text = FileIO.slurp(source, StandardCharsets.UTF_8)
            val relativePath = source.toString().stripPrefix("/")
            Input.VirtualFile(relativePath, text)
          }
          sum += fn(inputs)
        }
      }
    sum
  }
}
