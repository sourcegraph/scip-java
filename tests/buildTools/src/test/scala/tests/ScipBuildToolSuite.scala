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
    expectedScipFiles = 2
  )

  checkBuild(
    "compiles-with-classpath",
    """|/lsif-java.json
       |{"classpath": ["lib-classes"]}
       |/foo/Example.java
       |package foo;
       |import bar.Greeter;
       |public class Example {
       |  public String hello() { return new Greeter().greet(); }
       |}
       |""".stripMargin,
    expectedScipFiles = 1,
    prepare =
      () => {
        val libSrcDir = os.temp.dir(prefix = "scip-classpath-lib")
        val libSrc = libSrcDir / "bar" / "Greeter.java"
        os.write(
          libSrc,
          """|package bar;
             |public class Greeter {
             |  public String greet() { return "hi"; }
             |}
             |""".stripMargin,
          createFolders = true
        )
        val libClasses = os.Path(workingDirectory) / "lib-classes"
        os.makeDir.all(libClasses)
        os.proc("javac", "-d", libClasses.toString, libSrc.toString).call()
      }
  )
}
