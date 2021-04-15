package benchmarks

import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.TimeUnit

import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.lsif_java.Dependencies
import com.sourcegraph.lsif_java.LsifJava
import org.openjdk.jmh.annotations._
import tests.TestCompiler

@State(Scope.Benchmark)
class LsifSemanticdbBench {

  var targetroot: Path = _
  var deps: Dependencies = _

  @Setup
  def setup(): Unit = {
    targetroot = Files.createTempDirectory("lsif-java")
    deps = Dependencies
      .resolveDependencies(List("com.google.guava:guava:30.1-jre"))
    val compiler =
      new TestCompiler(deps.classpathSyntax, List.empty[String], targetroot)
    CompileBench.foreachSource(deps) { inputs =>
      compiler.compileSemanticdb(inputs).byteCode.length
    }
  }

  @TearDown
  def teardown(): Unit = {
    Files.walkFileTree(targetroot, new DeleteVisitor())
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.SingleShotTime))
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  def jsonParallel(): Unit = run("dump.lsif", parallel = true)

  @Benchmark
  @BenchmarkMode(Array(Mode.SingleShotTime))
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  def json(): Unit = run("dump.lsif", parallel = false)

  @Benchmark
  @BenchmarkMode(Array(Mode.SingleShotTime))
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  def protobufParallel(): Unit = run("dump.lsif-protobuf", parallel = true)

  @Benchmark
  @BenchmarkMode(Array(Mode.SingleShotTime))
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  def protobuf(): Unit = run("dump.lsif-protobuf", parallel = false)

  private def run(filename: String, parallel: Boolean): Unit = {
    val output = Files.createTempFile("lsif-java", filename)
    val parallelFlag =
      if (parallel)
        "--parallel"
      else
        "--no-parallel"
    val exit = LsifJava
      .app
      .run(
        List(
          "index-semanticdb",
          s"--output=$output",
          parallelFlag,
          targetroot.toString
        )
      )

    require(exit == 0, exit)
  }

}
