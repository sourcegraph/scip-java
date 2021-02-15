package benchmarks

import java.nio.charset.StandardCharsets
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.PathMatcher
import java.util.concurrent.TimeUnit

import scala.meta.inputs.Input
import scala.meta.internal.io.FileIO

import org.openjdk.jmh.annotations._
import tests.DeleteVisitor
import tests.Dependencies
import tests.TestCompiler

@State(Scope.Benchmark)
class CompileBench {

  var deps: Dependencies = _
  var tmp: Path = _
  var compiler: TestCompiler = _
  var javaPattern: PathMatcher = _
  @Param(Array("bytebuddy", "guava"))
  var lib: String = _

  val libs = Map(
    "bytebuddy" -> "net.bytebuddy:byte-buddy:1.10.20",
    "guava" -> "com.google.guava:guava:30.1-jre"
  )

  @Setup()
  def setup(): Unit = {
    javaPattern = FileSystems.getDefault.getPathMatcher("glob:**.java")
    tmp = Files.createTempDirectory("benchmarks")
    deps = Dependencies.resolveDependencies(List(libs(lib)), Nil)
    compiler = new TestCompiler(deps.classpathSyntax, List.empty[String], tmp)
  }

  @TearDown()
  def teardown(): Unit = {
    Files.walkFileTree(tmp, new DeleteVisitor)
  }

  def foreachSource(fn: Seq[Input.VirtualFile] => Int): Long = {
    var sum = 0L
    deps
      .sources
      .foreach { source =>
        FileIO.withJarFileSystem(source, create = false, close = true) { root =>
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

  @Benchmark
  @BenchmarkMode(Array(Mode.SingleShotTime))
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  def compile(): Long = {
    foreachSource { inputs =>
      compiler.compile(inputs).byteCode.length
    }
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.SingleShotTime))
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  def compileSemanticdb(): Long = {
    foreachSource { inputs =>
      compiler.compileSemanticdb(inputs).textDocument.getOccurrencesCount
    }
  }

}
