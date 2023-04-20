package tests

import java.nio.file.Files

import scala.meta.inputs.Input

import com.sourcegraph.scip_java.ScipJava
import moped.testkit.FileLayout
import moped.testkit.MopedSuite

class SnapshotCommandSuite extends MopedSuite(ScipJava.app) {
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

    val indexExit = app().run(
      List(
        "index-semanticdb",
        "--output",
        targetroot.resolve("index.scip").toString,
        targetroot.toString
      )
    )
    assertEquals(indexExit, 0, clues(app.capturedOutput))

    val snapshotExit = app().run(
      List("snapshot", "--output", generatedpath.toString, targetroot.toString)
    )
    assertEquals(snapshotExit, 0, clues(app.capturedOutput))
    assertNoDiff(
      FileLayout.asString(generatedpath),
      """|/main/Sample.java
         |package main;
         |
         |public class Sample {
         |//           ^^^^^^ definition semanticdb maven . . main/Sample#
         |//                  documentation ```java\npublic class Sample\n```
         |//           ^^^^^^ definition semanticdb maven . . main/Sample#`<init>`().
         |//                  documentation ```java\npublic Sample()\n```
         |   public static void main(String[] asdf) {}
         |//                    ^^^^ definition semanticdb maven . . main/Sample#main().
         |//                         documentation ```java\npublic static void main(String[] asdf)\n```
         |//                         ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
         |//                                  ^^^^ definition local 0
         |//                                       documentation ```java\nString[] asdf\n```
         |}
         |""".stripMargin
    )
  }
}
