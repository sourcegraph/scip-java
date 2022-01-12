package tests

import java.io.File
import java.nio.file.Files
import java.nio.file.Path

import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.lsif_java.LsifJava
import com.sourcegraph.lsif_java.commands.SnapshotLsifCommand
import com.sourcegraph.lsif_java.commands.SnapshotLsifCommand.IndexedLsif
import moped.reporters.ConsoleReporter
import moped.testkit.FileLayout

class LsifGraphSnapshotGenerator extends SnapshotGenerator {

  override def run(context: SnapshotContext, handler: SnapshotHandler): Unit = {
    val gen = new Gen(context, handler)
    gen.indexSemanticdb(
      "reference",
      "example/Example#",
      """/example/Example.java
        |package example;
        | /** Docstring for Example */
        |public class Example {
        |  Example next;
        |}
        |""".stripMargin
    )

    gen.indexSemanticdb(
      "multifile",
      "example/Example1#",
      """|/example/Example1.java
         |package example;
         |
         | /** Example1 docstring */
         |public class Example1 {}
         |/example/Example2.java
         |package example;
         |
         |public class Example2 {
         |  public Example1 example;
         |}
         |""".stripMargin
    )

    gen.indexSemanticdb(
      "locals",
      "local0",
      """|/example/Example.java
         |package example;
         |
         |public class Example {
         |  public static int increment(int n) { return n + 1; }
         |}
         |""".stripMargin
    )

    gen.indexSemanticdb(
      "packages",
      "org/hamcrest/MatcherAssert#",
      """|/example/Example.java
         |package example;
         |import org.hamcrest.MatcherAssert;
         |public class Example {
         |  public static void run() { MatcherAssert.assertThat("", true); }
         |}
         |""".stripMargin
    )

    gen.indexSemanticdb(
      "packages-jvm",
      "java/lang/String#",
      """|/example/Example.java
         |package example;
         |public class Example {
         |  public static String run() { return "hello"; }
         |}
         |""".stripMargin
    )

    handler.onFinished(context)

  }

  class Gen(context: SnapshotContext, handler: SnapshotHandler) {
    def runSuccessfully(args: List[String], sourceroot: Path): Unit = {
      val exit = LsifJava
        .app
        .withEnv(LsifJava.app.env.withWorkingDirectory(sourceroot))
        .run(args)
      require(exit == 0)
    }
    def indexSemanticdb(
        name: String,
        symbol: String,
        original: String
    ): Unit = {
      val expectFile = context
        .expectDirectory
        .resolve("index-semanticdb")
        .resolve(name)
      handler.onSnapshotTest(
        context,
        expectFile,
        () => {
          val tmp = Files.createTempDirectory("lsif-java")
          val targetroot = tmp.resolve("targetroot")
          val outputLsif = tmp.resolve("dump.lsif")
          val outputSnapshot = tmp.resolve("snapshot")
          val sourceroot = tmp.resolve("workingDirectory")
          FileLayout.fromString(original, sourceroot)
          val compiler =
            new TestCompiler(
              TestCompiler.PROCESSOR_PATH,
              javacOptions = Nil,
              scalacOptions = Nil,
              targetroot,
              sourceroot
            )
          val Seq(hamcrestJar) =
            TestCompiler
              .PROCESSOR_PATH
              .split(File.pathSeparator)
              .filter(_.contains("hamcrest"))
              .toSeq
          FileLayout.fromString(
            s"/dependencies.txt\norg.hamcrest\thamcrest-core\t1.3\t$hamcrestJar\n",
            targetroot
          )
          val result = compiler.compileSemanticdbDirectory(sourceroot)
          require(result.isSuccess, result.stdout)
          runSuccessfully(
            List(
              "index-semanticdb",
              "--no-parallel",
              "--output",
              outputLsif.toString,
              targetroot.toString
            ),
            sourceroot
          )
          val objects = SnapshotLsifCommand.parseInput(outputLsif)
          val reporter = ConsoleReporter(System.out)
          val lsif = new IndexedLsif(outputLsif, objects, sourceroot, reporter)
          runSuccessfully(
            List(
              "snapshot-lsif",
              "--input",
              outputLsif.toString(),
              "--output",
              outputSnapshot.toString()
            ),
            sourceroot
          )
          assert(
            Files.isDirectory(outputSnapshot),
            s"snapshot-lsif command did not create directory $outputSnapshot"
          )
          val snapshotLsif = FileLayout.asString(outputSnapshot)
          val obtained = new StringBuilder()
            .header("Source code")
            .append(snapshotLsif)
            .append("\n")
            .header(s"LSIF Graph for symbol '$symbol'")
            .append(lsif.asciiGraph(symbol))
            .append("\n")
            .toString()
          Files.walkFileTree(tmp, new DeleteVisitor())
          obtained
        }
      )
    }
  }

  implicit class XtensionStringBuilder(s: StringBuilder) {
    def header(msg: String): StringBuilder = {
      val len = msg.length() + 4
      val banner = "─" * len
      s.append(banner)
        .append("\n")
        .append("│ ")
        .append(msg)
        .append(" │")
        .append("\n")
        .append(banner)
        .append("\n")
    }
  }

}
