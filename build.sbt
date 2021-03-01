def scala213 = "2.13.4"
def scalametaVersion = "4.4.8"

inThisBuild(
  List(
    scalaVersion := scala213,
    crossScalaVersions := List(scala213),
    scalafixDependencies +=
      "com.github.liancheng" %% "organize-imports" % "0.5.0",
    scalafixCaching := true,
    scalacOptions ++= List("-Wunused:imports"),
    semanticdbEnabled := true,
    semanticdbVersion := scalametaVersion,
    organization := "com.sourcegraph",
    homepage := Some(url("https://github.com/sourcegraph/lsif-java")),
    licenses :=
      List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    developers :=
      List(
        Developer(
          "olafurpg",
          "Ólafur Páll Geirsson",
          "olafurpg@sourcegraph.com",
          url("https://github.com/olafurpg")
        ),
        Developer(
          "Strum355",
          "Noah Santschi-Cooney",
          "noah@sourcegraph.com",
          url("https://github.com/Strum355")
        )
      )
  )
)

name := "root"
bloopGenerate.in(Compile) := None
bloopGenerate.in(Test) := None
skip.in(publish) := true

commands +=
  Command.command("fixAll") { s =>
    "scalafixAll" :: "scalafmtAll" :: "scalafmtSbt" :: "javafmtAll" :: s
  }

commands +=
  Command.command("checkAll") { s =>
    "scalafmtCheckAll" :: "scalafmtSbtCheck" :: "scalafixAll --check" ::
      "javafmtCheckAll" :: "publishLocal" :: s
  }

lazy val testSettings = List(
  skip.in(publish) := true,
  autoScalaLibrary := true,
  testFrameworks := List(new TestFramework("munit.Framework")),
  libraryDependencies ++=
    List(
      "org.scalameta" %% "munit" % "0.7.22",
      "org.scalameta" %% "scalameta" % scalametaVersion,
      "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.0",
      "io.get-coursier" %% "coursier" % "2.0.8",
      "com.lihaoyi" %% "pprint" % "0.6.1"
    )
)

lazy val plugin = project
  .in(file("semanticdb-javac"))
  .settings(
    moduleName := "semanticdb-javac",
    autoScalaLibrary := false,
    incOptions ~= { old =>
      old.withEnabled(false)
    },
    crossPaths := false,
    PB.targets.in(Compile) :=
      Seq(PB.gens.java -> (Compile / sourceManaged).value)
  )

lazy val minimized = project
  .in(file("tests/minimized"))
  .settings(
    autoScalaLibrary := false,
    skip.in(publish) := true,
    javacOptions.in(Compile) ++=
      List[String](
        s"-Arandomtimestamp=${System.nanoTime()}",
        List(
          s"-Xplugin:semanticdb",
          s"-text:on",
          s"-verbose",
          s"-sourceroot:${baseDirectory.in(ThisBuild).value}",
          s"-targetroot:${semanticdbTargetRoot.in(Compile).value}"
        ).mkString(" ")
      )
  )
  .dependsOn(plugin)

lazy val minimizedScala = project
  .in(file("tests/minimized-scala"))
  .settings(
    skip.in(publish) := true,
    semanticdbOptions ++= List("-P:semanticdb:text:on")
  )
  .dependsOn(minimized)

lazy val unit = project
  .in(file("tests/unit"))
  .settings(
    testSettings,
    buildInfoKeys :=
      Seq[BuildInfoKey](
        version,
        scalaVersion,
        "sourceroot" -> baseDirectory.in(ThisBuild).value,
        "minimizedJavaSourceDirectory" ->
          sourceDirectory.in(minimized, Compile).value / "java",
        "minimizedJavaTargetroot" ->
          semanticdbTargetRoot.in(minimized, Compile).value,
        "minimizedScalaSourceDirectory" ->
          sourceDirectory.in(minimizedScala, Compile).value / "scala",
        "minimizedScalaTargetroot" ->
          semanticdbTargetRoot.in(minimizedScala, Compile).value
      ),
    buildInfoPackage := "tests"
  )
  .dependsOn(plugin)
  .enablePlugins(BuildInfoPlugin)

lazy val snapshots = project
  .in(file("tests/snapshots"))
  .settings(
    testSettings,
    buildInfoKeys :=
      Seq[BuildInfoKey](
        "snapshotDirectory" -> sourceDirectory.in(Compile).value / "generated"
      ),
    buildInfoPackage := "tests.snapshots"
  )
  .dependsOn(minimizedScala, unit)
  .enablePlugins(BuildInfoPlugin)

lazy val bench = project
  .in(file("tests/benchmarks"))
  .settings(
    moduleName := "lsif-java-bench",
    fork.in(run) := true,
    skip.in(publish) := true
  )
  .dependsOn(unit)
  .enablePlugins(JmhPlugin)
