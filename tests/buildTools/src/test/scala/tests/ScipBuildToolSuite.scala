package tests

class ScipBuildToolSuite extends BaseBuildToolSuite {
  override def tags = List(SkipWindows)

  checkBuild(
    "rejects-dependencies-field",
    """|/lsif-java.json
       |{"dependencies": ["junit:junit:4.13.1"]}
       |/foo/Example.java
       |package foo;
       |public class Example {}
       |""".stripMargin,
    expectedError = Some { output =>
      assert(
        output.contains(
          "scip-java no longer resolves Maven coordinates from the 'dependencies' field"
        ),
        clue = output
      )
    }
  )

  checkBuild(
    "compiles-with-empty-classpath",
    """|/lsif-java.json
       |{}
       |/foo/Example.java
       |package foo;
       |public class Example {}
       |/foo/Example2.java
       |package foo;
       |public class Example2 {}
       |""".stripMargin,
    expectedSemanticdbFiles = 2
  )
}
