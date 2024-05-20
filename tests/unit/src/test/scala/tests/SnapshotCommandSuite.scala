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
        | /**
        |  * Sample class
        |  */
        |public class Sample {
        |   /**
        |    * Main application entry point
        |    */
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
         | /**
         |  * Sample class
         |  */
         |public class Sample {
         |//           ^^^^^^ definition semanticdb maven . . main/Sample#
         |//                  display_name Sample
         |//                  signature_documentation java public class Sample
         |//                  kind Class
         |//                  documentation  Sample class\n
         |//           ^^^^^^ definition semanticdb maven . . main/Sample#`<init>`().
         |//                  display_name <init>
         |//                  signature_documentation java public Sample()
         |//                  kind Constructor
         |   /**
         |    * Main application entry point
         |    */
         |   public static void main(String[] asdf) {}
         |//                    ^^^^ definition semanticdb maven . . main/Sample#main().
         |//                         display_name main
         |//                         signature_documentation java public static void main(String[] asdf)
         |//                         kind StaticMethod
         |//                         documentation  Main application entry point\n
         |//                         ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
         |//                                  ^^^^ definition local 0
         |//                                       display_name asdf
         |//                                       signature_documentation java String[] asdf
         |//                                       enclosing_symbol semanticdb maven . . main/Sample#main().
         |}
         |""".stripMargin
    )
  }
}
