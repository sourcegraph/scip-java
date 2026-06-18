package tests

import java.nio.file.Files

import scala.meta.inputs.Input

import com.sourcegraph.scip_java.ScipJava

class SnapshotCommandSuite extends ScipJavaSuite(ScipJava.app) {
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
    new TestCompiler(targetroot).compileScip(
      List(Input.VirtualFile("main/Sample.java", code))
    )

    val generatedpath = workingDirectory.resolve("generated")

    val indexExit = app.run(
      List(
        "aggregate",
        "--output",
        targetroot.resolve("index.scip").toString,
        targetroot.toString
      )
    )

    assertEquals(indexExit, 0, clues(app.capturedOutput))

    val snapshotExit = app.run(
      List("snapshot", "--output", generatedpath.toString, targetroot.toString)
    )
    assertEquals(snapshotExit, 0, clues(app.capturedOutput))
    assertNoDiff(
      FileLayout.asString(generatedpath),
      """|/main/Sample.java
         |  package main;
         |   /**
         |    * Sample class
         |    */
         |//⌄ enclosing_range_start scip-java maven . . main/Sample#
         |  public class Sample {
         |//             ^^^^^^ definition scip-java maven . . main/Sample#
         |//                    kind Class
         |//                    display_name Sample
         |//                    signature_documentation
         |//                    > public class Sample
         |//                    documentation
         |//                    > Sample class
         |//             ^^^^^^ definition scip-java maven . . main/Sample#`<init>`().
         |//                    kind Constructor
         |//                    display_name <init>
         |//                    signature_documentation
         |//                    > public Sample()
         |     /**
         |      * Main application entry point
         |      */
         |//   ⌄ enclosing_range_start scip-java maven . . main/Sample#main().
         |//                           ⌄ enclosing_range_start local 0
         |     public static void main(String[] asdf) {}
         |//                      ^^^^ definition scip-java maven . . main/Sample#main().
         |//                           kind StaticMethod
         |//                           display_name main
         |//                           signature_documentation
         |//                           > public static void main(String[] asdf)
         |//                           documentation
         |//                           > Main application entry point
         |//                           ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
         |//                                    ^^^^ definition local 0
         |//                                         display_name asdf
         |//                                         signature_documentation
         |//                                         > String[] asdf
         |//                                       ⌃ enclosing_range_end local 0
         |//                                           ⌃ enclosing_range_end scip-java maven . . main/Sample#main().
         |  }
         |//⌃ enclosing_range_end scip-java maven . . main/Sample#
         |""".stripMargin
    )
  }
}
