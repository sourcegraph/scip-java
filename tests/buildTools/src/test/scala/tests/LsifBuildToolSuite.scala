package tests

class LsifBuildToolSuite extends BaseBuildToolSuite {
  checkBuild(
    "basic",
    """|/lsif-java.json
       |{"dependencies": ["junit:junit:4.13.1"]}
       |/foo/Example.java
       |package foo;
       |import org.junit.Assert;
       |public class Example {}
       |/foo/Example2.java
       |package foo;
       |public class Example2 {}
       |""".stripMargin,
    2,
    expectedPackages =
      """|maven:junit:junit:4.13.1
         |maven:org.hamcrest:hamcrest-core:1.3
         |""".stripMargin
  )
}
