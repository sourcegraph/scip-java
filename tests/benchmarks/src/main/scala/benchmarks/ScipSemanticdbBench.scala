package benchmarks

import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.TimeUnit

import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.scip_java.Dependencies
import com.sourcegraph.scip_java.ScipJava
import org.openjdk.jmh.annotations._
import tests.TestCompiler

@State(Scope.Benchmark)
class ScipSemanticdbBench {

  var targetroot: Path = _
  var deps: Dependencies = _

  @Setup
  def setup(): Unit = {
    targetroot = Files.createTempDirectory("scip-java")
    deps = Dependencies
      .resolveDependencies(List("com.google.guava:guava:30.1-jre"))
    val compiler =
      new TestCompiler(
        deps.classpathSyntax,
        javacOptions = Nil,
        scalacOptions = Nil,
        targetroot
      )
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
  def jsonParallel(): Unit = run("index.scip", parallel = true)

  @Benchmark
  @BenchmarkMode(Array(Mode.SingleShotTime))
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  def json(): Unit = run("index.scip", parallel = false)

  @Benchmark
  @BenchmarkMode(Array(Mode.SingleShotTime))
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  def protobufParallel(): Unit = run("index.scip-protobuf", parallel = true)

  @Benchmark
  @BenchmarkMode(Array(Mode.SingleShotTime))
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  def protobuf(): Unit = run("index.scip-protobuf", parallel = false)

  private def run(filename: String, parallel: Boolean): Unit = {
    val output = Files.createTempFile("scip-java", filename)
    val parallelFlag =
      if (parallel)
        "--parallel"
      else
        "--no-parallel"
    val exit = ScipJava
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
