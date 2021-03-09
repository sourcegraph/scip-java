package tests

import java.nio.file.Files

import scala.meta.inputs.Input

import com.sourcegraph.lsif_java.LsifJava
import moped.testkit.FileLayout
import moped.testkit.MopedSuite

class SnapshotCommandSuite extends MopedSuite(LsifJava.app) {
  test("snapshot") {
    FileLayout.fromString(
      """/main/Sample.java
        |package main;
        |
        |public class Sample {
        |   public static void main(String[] asdf) {}
        |}
        |""".stripMargin,
      workingDirectory
    )

    val targetroot = workingDirectory.resolve("target/main")
    val sourcepath = workingDirectory.resolve("main/Sample.java")
    val code = new String(Files.readAllBytes(sourcepath))
    new TestCompiler(targetroot)
      .compileSemanticdb(List(Input.VirtualFile("main/Sample.java", code)))

    val generatedpath = workingDirectory.resolve("generated")
    val exitCode = app().run(
      List("snapshot", "--output", generatedpath.toString, targetroot.toString)
    )
    assertEquals(exitCode, 0, clues(app.capturedOutput))
    assertNoDiff(
      FileLayout.asString(generatedpath),
      """|/main/Sample.java
         |package main;
         |
         |public class Sample {
         |//     ^^^^^^ definition main/Sample#
         |//     ^^^^^^ definition main/Sample#`<init>`().
         |   public static void main(String[] asdf) {}
         |//                    ^^^^ definition main/Sample#main().
         |//                         ^^^^^^ reference java/lang/String#
         |//                                  ^^^^ definition local0
         |}
         |""".stripMargin
    )
  }
}
