import java.io.File
import java.util.Properties
import scala.collection.mutable.ListBuffer

lazy val V =
  new {
    val coursier = "2.0.8"
    val bloop = "1.4.7"
    val bsp = "2.0.0-M13"
    val moped = "0.1.9"
    def scala213 = "2.13.4"
    def scala212 = "2.12.12"
    def scalameta = "4.4.8"
  }

inThisBuild(
  List(
    scalaVersion := V.scala213,
    crossScalaVersions := List(V.scala213),
    scalafixDependencies +=
      "com.github.liancheng" %% "organize-imports" % "0.5.0",
    scalafixCaching := true,
    scalacOptions ++= List("-Wunused:imports"),
    semanticdbEnabled := true,
    semanticdbVersion := V.scalameta,
    organization := "com.sourcegraph",
    homepage := Some(url("https://github.com/sourcegraph/lsif-java")),
    dynverSeparator := "-",
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
      "javafmtCheckAll" :: "publishLocal" :: "docs/docusaurusCreateSite" :: s
  }

lazy val agent = project
  .in(file("semanticdb-agent"))
  .settings(
    fatjarPackageSettings,
    autoScalaLibrary := false,
    moduleName := "semanticdb-agent",
    libraryDependencies ++=
      List(
        "org.javassist" % "javassist" % "3.27.0-GA",
        "net.bytebuddy" % "byte-buddy" % "1.10.20",
        "net.bytebuddy" % "byte-buddy-agent" % "1.10.20"
      ),
    incOptions ~= { old =>
      old.withEnabled(false)
    },
    crossPaths := false,
    Compile / packageBin / packageOptions +=
      Package.ManifestAttributes(
        "Agent-Class" -> "com.sourcegraph.semanticdb_javac.SemanticdbAgent",
        "Can-Redefine-Classes" -> "true",
        "Can-Retransform-Classes" -> "true",
        "Premain-Class" -> "com.sourcegraph.semanticdb_javac.SemanticdbAgent"
      )
  )

lazy val plugin = project
  .in(file("semanticdb-javac"))
  .settings(
    moduleName := "semanticdb-javac",
    javaToolchainVersion := "1.8",
    autoScalaLibrary := false,
    incOptions ~= { old =>
      old.withEnabled(false)
    },
    fatjarPackageSettings,
    crossPaths := false,
    PB.targets.in(Compile) :=
      Seq(PB.gens.java -> (Compile / sourceManaged).value)
  )

lazy val cli = project
  .in(file("cli"))
  .settings(
    moduleName := "lsif-java",
    mainClass.in(Compile) := Some("com.sourcegraph.lsif_java.LsifJava"),
    buildInfoKeys :=
      Seq[BuildInfoKey](
        version,
        scalaVersion,
        "bloopVersion" -> V.bloop,
        "bspVersion" -> V.bsp
      ),
    buildInfoPackage := "com.sourcegraph.lsif_java",
    libraryDependencies ++= List("org.scalameta" %% "moped" % V.moped),
    resourceGenerators.in(Compile) +=
      Def
        .task[Seq[File]] {
          val outs = ListBuffer.empty[(File, File)]
          val out = resourceManaged.in(Compile).value.toPath
          IO.delete(out.toFile)
          def addJar(jar: File, filename: String): Unit = {
            outs += jar -> out.resolve(filename).toFile
          }

          addJar(
            Keys.`package`.in(plugin, Compile).value,
            "semanticdb-plugin.jar"
          )
          addJar(
            Keys.`package`.in(agent, Compile).value,
            "semanticdb-agent.jar"
          )

          IO.copy(outs)
          val props = new Properties()
          val propsFile = out.resolve("lsif-java.properties").toFile
          val copiedJars = outs.collect { case (_, out) =>
            out
          }
          val names = copiedJars.map(_.getName).mkString(";")
          props.put("jarNames", names)
          IO.write(props, "lsif-java", propsFile)

          propsFile :: copiedJars.toList
        }
        .taskValue,
    nativeImageOptions ++= List("-H:IncludeResources=^semanticdb-.*jar$"),
    nativeImageOutput := target.in(NativeImage).value / "lsif-java"
  )
  .enablePlugins(NativeImagePlugin, BuildInfoPlugin)

def minimizedSourceDirectory =
  file("tests/minimized/src/main/java").getAbsoluteFile
lazy val minimizedSettings = List[Def.Setting[_]](
  autoScalaLibrary := false,
  skip.in(publish) := true,
  fork.in(run) := true,
  unmanagedSourceDirectories.in(Compile) += minimizedSourceDirectory,
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

lazy val minimized = project
  .in(file("tests/minimized/.j11"))
  .settings(minimizedSettings)
  .dependsOn(agent, plugin)

lazy val minimized8 = project
  .in(file("tests/minimized/.j8"))
  .settings(minimizedSettings, javaToolchainVersion := "8")
  .dependsOn(agent, plugin)

lazy val minimized15 = project
  .in(file("tests/minimized/.j15"))
  .settings(minimizedSettings, javaToolchainVersion := "15")
  .dependsOn(agent, plugin)

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
        "temporaryDirectory" -> target.value / "tmpdir",
        "sourceroot" -> baseDirectory.in(ThisBuild).value,
        "minimizedJavaSourceDirectory" -> minimizedSourceDirectory,
        "minimizedJavaTargetroot" ->
          semanticdbTargetRoot.in(minimized, Compile).value,
        "minimizedScalaSourceDirectory" ->
          sourceDirectory.in(minimizedScala, Compile).value / "scala",
        "minimizedScalaTargetroot" ->
          semanticdbTargetRoot.in(minimizedScala, Compile).value
      ),
    buildInfoPackage := "tests"
  )
  .dependsOn(plugin, cli)
  .enablePlugins(BuildInfoPlugin)

lazy val buildTools = project
  .in(file("tests/buildTools"))
  .settings(
    testSettings,
    javaOptions.in(Test) ++=
      List(
        s"-javaagent:${Keys.`package`.in(agent, Compile).value}",
        s"-Dsemanticdb.pluginpath=${Keys.`package`.in(plugin, Compile).value}",
        s"-Dsemanticdb.sourceroot=${baseDirectory.in(ThisBuild).value}",
        s"-Dsemanticdb.targetroot=${target.in(agent, Compile).value / "semanticdb-targetroot"}"
      )
  )
  .dependsOn(agent, unit)

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

lazy val testSettings = List(
  skip.in(publish) := true,
  autoScalaLibrary := true,
  testFrameworks := List(new TestFramework("munit.Framework")),
  libraryDependencies ++=
    List(
      "org.scalameta" %% "munit" % "0.7.10",
      "org.scalameta" %% "moped-testkit" % V.moped,
      "org.scalameta" %% "scalameta" % V.scalameta,
      "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.0",
      "io.get-coursier" %% "coursier" % V.coursier,
      "com.lihaoyi" %% "pprint" % "0.6.1"
    )
)

lazy val fatjarPackageSettings = List[Def.Setting[_]](
  assemblyMergeStrategy in assembly := {
    case PathList("javax", _ @_*) =>
      MergeStrategy.discard
    case PathList("com", "sun", _ @_*) =>
      MergeStrategy.discard
    case PathList("sun", _ @_*) =>
      MergeStrategy.discard
    case PathList("META-INF", "versions", "9", "module-info.class") =>
      MergeStrategy.first
    case x =>
      val oldStrategy = (assemblyMergeStrategy in assembly).value
      oldStrategy(x)
  },
  Keys.`package`.in(Compile) := {
    val slimJar = Keys.`package`.in(Compile).value
    val fatJar = crossTarget.value / assemblyJarName.in(assembly).value
    val _ = assembly.value
    IO.copyFile(fatJar, slimJar, CopyOptions().withOverwrite(true))
    slimJar
  }
)

lazy val docs = project
  .in(file("lsif-java-docs"))
  .settings(
    mdocOut :=
      baseDirectory.in(ThisBuild).value / "website" / "target" / "docs",
    fork := false,
    mdocVariables :=
      Map[String, String](
        "VERSION" -> version.value,
        "SCALA_VERSION" -> scalaVersion.value,
        "STABLE_VERSION" -> version.value.replaceFirst("\\-.*", "")
      )
  )
  .dependsOn(unit)
  .enablePlugins(DocusaurusPlugin)
