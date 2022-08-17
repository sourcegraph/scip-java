import scala.xml.{Node => XmlNode, NodeSeq => XmlNodeSeq, _}
import scala.xml.transform.{RewriteRule, RuleTransformer}
import java.io.File
import java.nio.file.Files
import java.util.Properties
import scala.collection.mutable.ListBuffer
import scala.util.control.NoStackTrace

lazy val V =
  new {
    val protobuf = "3.21.4"
    val coursier = "2.0.8"
    val bsp = "2.0.0-M13"
    val moped = "0.1.11"
    def scala213 = "2.13.6"
    def scala212 = "2.12.14"
    def scala211 = "2.11.12"
    def scala3 = "3.0.1"
    def metals = "0.10.6-M1"
    def scalameta = "4.5.11"
    def semanticdbKotlinc = "0.2.0"
    def testcontainers = "0.39.3"
    def requests = "0.6.5"
    def minimalMillVersion = "0.10.0"
    def millScipVersion = "0.2.2"
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
    homepage := Some(url("https://github.com/sourcegraph/scip-java")),
    dynverSeparator := "-",
    PB.protocVersion := V.protobuf,
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
(publish / skip) := true

commands +=
  Command.command("fixAll") { s =>
    "scalafixAll" :: "scalafmtAll" :: "scalafmtSbt" :: "javafmtAll" :: s
  }

commands +=
  Command.command("checkAll") { s =>
    "javafmtCheckAll" :: "scalafmtCheckAll" :: "scalafmtSbtCheck" ::
      "scalafixAll --check" :: "publishLocal" :: "docs/docusaurusCreateSite" ::
      s
  }

lazy val semanticdb = project
  .in(file("semanticdb-java"))
  .settings(
    moduleName := "semanticdb-java",
    javaOnlySettings,
    (Compile / PB.targets) :=
      Seq(PB.gens.java(V.protobuf) -> (Compile / sourceManaged).value)
  )

lazy val agent = project
  .in(file("semanticdb-agent"))
  .settings(
    fatjarPackageSettings,
    javaOnlySettings,
    moduleName := "semanticdb-agent",
    libraryDependencies ++=
      List(
        "net.bytebuddy" % "byte-buddy" % "1.11.9",
        "net.bytebuddy" % "byte-buddy-agent" % "1.11.21"
      ),
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
    fatjarPackageSettings,
    javaOnlySettings,
    moduleName := "semanticdb-javac",
    javaToolchainVersion := "8",
    javacOptions += "-g",
    (assembly / assemblyShadeRules) :=
      Seq(
        ShadeRule
          .rename(
            "com.google.**" -> "com.sourcegraph.shaded.com.google.@1",
            "google.**" -> "com.sourcegraph.shaded.google.@1",
            "org.relaxng.**" -> "com.sourcegraph.shaded.relaxng.@1"
          )
          .inAll
      )
  )
  .dependsOn(semanticdb)

lazy val scip = project
  .in(file("scip-semanticdb"))
  .settings(
    moduleName := "scip-semanticdb",
    javaToolchainVersion := "8",
    javaOnlySettings,
    libraryDependencies +=
      "com.google.protobuf" % "protobuf-java-util" % V.protobuf,
    (Compile / PB.targets) :=
      Seq(PB.gens.java(V.protobuf) -> (Compile / sourceManaged).value),
    Compile / PB.protocOptions := Seq("--experimental_allow_proto3_optional")
  )
  .dependsOn(semanticdb)

lazy val cli = project
  .in(file("scip-java"))
  .settings(
    moduleName := "scip-java",
    (Compile / mainClass) := Some("com.sourcegraph.scip_java.ScipJava"),
    (run / baseDirectory) := (ThisBuild / baseDirectory).value,
    buildInfoKeys :=
      Seq[BuildInfoKey](
        version,
        sbtVersion,
        scalaVersion,
        "javacModuleOptions" -> javacModuleOptions,
        "semanticdbScalacVersions" ->
          com
            .sourcegraph
            .sbtsourcegraph
            .Versions
            .cachedSemanticdbVersionsByScalaVersion,
        "sbtSourcegraphVersion" ->
          com.sourcegraph.sbtsourcegraph.BuildInfo.version,
        "semanticdbVersion" -> V.scalameta,
        "semanticdbKotlincVersion" -> V.semanticdbKotlinc,
        "mtagsVersion" -> V.metals,
        "scala211" -> V.scala211,
        "scala212" -> V.scala212,
        "scala213" -> V.scala213,
        "scala3" -> V.scala3,
        "bspVersion" -> V.bsp,
        "minimalMillVersion" -> V.minimalMillVersion,
        "millScipVersion" -> V.millScipVersion
      ),
    buildInfoPackage := "com.sourcegraph.scip_java",
    libraryDependencies ++=
      List(
        "io.get-coursier" %% "coursier" % V.coursier,
        "org.scalameta" % "mtags-interfaces" % V.metals,
        "org.scala-lang.modules" %% "scala-xml" % "1.3.0",
        "com.lihaoyi" %% "requests" % V.requests,
        "org.scalameta" %% "moped" % V.moped,
        "org.scalameta" %% "ascii-graphs" % "0.1.2",
        "org.jetbrains.kotlin" % "kotlin-compiler-embeddable" % "1.5.21"
      ),
    (Compile / resourceGenerators) +=
      Def
        .task[Seq[File]] {
          val outs = ListBuffer.empty[(File, File)]
          val out = (Compile / resourceManaged).value.toPath
          IO.delete(out.toFile)
          def addJar(jar: File, filename: String): Unit = {
            outs += jar -> out.resolve(filename).toFile
          }

          addJar(
            (plugin / Compile / Keys.`package`).value,
            "semanticdb-plugin.jar"
          )
          addJar(
            (agent / Compile / Keys.`package`).value,
            "semanticdb-agent.jar"
          )

          IO.copy(outs)
          val props = new Properties()
          val propsFile = out.resolve("scip-java.properties").toFile
          val copiedJars = outs.collect { case (_, out) =>
            out
          }
          val names = copiedJars.map(_.getName).mkString(";")
          props.put("jarNames", names)
          IO.write(props, "scip-java", propsFile)

          propsFile :: copiedJars.toList
        }
        .taskValue,
    docker / imageNames :=
      List(
        ImageName("sourcegraph/scip-java:latest"),
        ImageName(s"sourcegraph/scip-java:${version.value}")
      ),
    docker / dockerfile := {
      val binaryDistribution = pack.value
      val script = (ThisBuild / baseDirectory).value / "bin" /
        "scip-java-docker-script.sh"
      new Dockerfile {
        from("gradle:7.2.0-jdk8")

        // Setup system dependencies.
        run("apt-get", "update")
        run("apt-get", "install", "--yes", "maven", "jq")

        // Install Coursier.
        run(
          "curl",
          "-fLo",
          "/usr/local/bin/coursier",
          "https://git.io/coursier-cli"
        )
        run("chmod", "+x", "/usr/local/bin/coursier")

        // Pre-download Java 8, 11 and 17.
        run("coursier", "java-home", "--jvm", "8")
        run("coursier", "java-home", "--jvm", "11")
        run("coursier", "java-home", "--jvm", "17")

        // Install `scip-java` binary.
        add(script, "/usr/local/bin/scip-java")
        add(binaryDistribution, "/app/scip-java")
      }
    }
  )
  .enablePlugins(PackPlugin, DockerPlugin, BuildInfoPlugin)
  .dependsOn(scip)

def commitAll(): Unit = {
  import scala.sys.process._
  "git add .".!!
  "git commit --allow-empty -m WIP".!!

}
commands +=
  Command.command("commitall") { s =>
    commitAll()
    s
  }

commands +=
  Command.command("nativeImageProfiled") { s =>
    val targetroot =
      file("tests/minimized/.j11/target/scala-2.13/meta").absolutePath
    val output = Files.createTempFile("scip-java", "index.scip")
    "minimized/compile" ::
      s"""nativeImageRunAgent " index-semanticdb --output=$output $targetroot"""" ::
      "nativeImage" :: s
  }

def minimizedSourceDirectory =
  file("tests/minimized/src/main/java").getAbsoluteFile

lazy val minimizedSettings = List[Def.Setting[_]](
  autoScalaLibrary := false,
  (publish / skip) := true,
  (run / fork) := true,
  (Compile / unmanagedSourceDirectories) += minimizedSourceDirectory,
  libraryDependencies ++= List("org.projectlombok" % "lombok" % "1.18.22"),
  (Compile / javacOptions) ++=
    List[String](
      s"-Arandomtimestamp=${System.nanoTime()}",
      List(
        s"-Xplugin:semanticdb",
        s"-build-tool:sbt",
        s"-text:on",
        s"-verbose",
        s"-sourceroot:${(ThisBuild / baseDirectory).value}",
        s"-targetroot:${(Compile / semanticdbTargetRoot).value}"
      ).mkString(" ")
    )
)

lazy val minimized = project
  .in(file("tests/minimized/.j11"))
  .settings(minimizedSettings)
  .dependsOn(agent, plugin)
  .disablePlugins(JavaFormatterPlugin)

lazy val minimized8 = project
  .in(file("tests/minimized/.j8"))
  .settings(minimizedSettings, javaToolchainVersion := "8")
  .dependsOn(agent, plugin)
  .disablePlugins(JavaFormatterPlugin)

def javacModuleOptions =
  List(
    "-J--add-exports",
    "-Jjdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
    "-J--add-exports",
    "-Jjdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED",
    "-J--add-exports",
    "-Jjdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
    "-J--add-exports",
    "-Jjdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
    "-J--add-exports",
    "-Jjdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED"
  )

lazy val minimized17 = project
  .in(file("tests/minimized/.j17"))
  .settings(
    minimizedSettings,
    javaToolchainVersion := "17",
    javacOptions ++= javacModuleOptions
  )
  .dependsOn(agent, plugin)
  .disablePlugins(JavaFormatterPlugin)

lazy val minimizedScala = project
  .in(file("tests/minimized-scala"))
  .settings(
    (publish / skip) := true,
    semanticdbOptions ++=
      List("-P:semanticdb:text:on", "-P:semanticdb:synthetics:on")
  )
  .dependsOn(minimized)

lazy val unit = project
  .in(file("tests/unit"))
  .settings(
    testSettings,
    //javaOptions ++= Seq(   "-Xdebug",   "-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"),
    buildInfoKeys :=
      Seq[BuildInfoKey](
        version,
        scalaVersion,
        "temporaryDirectory" -> target.value / "tmpdir",
        "sourceroot" -> (ThisBuild / baseDirectory).value,
        "minimizedJavaSourceDirectory" -> minimizedSourceDirectory,
        "minimizedJavaTargetroot" ->
          (minimized / Compile / semanticdbTargetRoot).value,
        "minimizedScalaSourceDirectory" ->
          (minimizedScala / Compile / sourceDirectory).value / "scala",
        "minimizedScalaTargetroot" ->
          (minimizedScala / Compile / semanticdbTargetRoot).value
      ),
    buildInfoPackage := "tests"
  )
  .dependsOn(plugin, cli)
  .enablePlugins(BuildInfoPlugin)

lazy val buildTools = project
  .in(file("tests/buildTools"))
  .settings(
    testSettings,
    (Test / javaOptions) ++=
      List(
        s"-javaagent:${(agent / Compile / Keys.`package`).value}",
        s"-Dsemanticdb.pluginpath=${(plugin / Compile / Keys.`package`).value}",
        s"-Dsemanticdb.sourceroot=${(ThisBuild / baseDirectory).value}",
        s"-Dsemanticdb.targetroot=${(agent / Compile / target).value / "semanticdb-targetroot"}"
      )
  )
  .dependsOn(agent, unit)

lazy val snapshots = project
  .in(file("tests/snapshots"))
  .settings(
    testSettings,
    buildInfoKeys :=
      Seq[BuildInfoKey](
        "snapshotDirectory" -> (Compile / sourceDirectory).value / "generated"
      ),
    buildInfoPackage := "tests.snapshots"
  )
  .dependsOn(minimizedScala, unit)
  .enablePlugins(BuildInfoPlugin)

lazy val bench = project
  .in(file("tests/benchmarks"))
  .settings(
    moduleName := "scip-java-bench",
    (run / fork) := true,
    (publish / skip) := true
  )
  .dependsOn(unit)
  .enablePlugins(JmhPlugin)

lazy val docs = project
  .in(file("scip-java-docs"))
  .settings(
    moduleName := "scip-java-docs",
    mdocOut :=
      (ThisBuild / baseDirectory).value / "website" / "target" / "docs",
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

lazy val javaOnlySettings = List[Def.Setting[_]](
  autoScalaLibrary := false,
  incOptions ~= { old =>
    old.withEnabled(false)
  },
  crossPaths := false
)

lazy val testSettings = List(
  (publish / skip) := true,
  autoScalaLibrary := true,
  testFrameworks := List(TestFrameworks.MUnit),
  testOptions ++= List(Tests.Argument(TestFrameworks.MUnit, "-b")),
  libraryDependencies ++=
    List(
      "org.scalameta" %% "munit" % "0.7.29",
      "org.scalameta" %% "mtags" % V.metals cross CrossVersion.full,
      "com.dimafeng" %% "testcontainers-scala-munit" % V.testcontainers,
      "com.dimafeng" %% "testcontainers-scala-postgresql" % V.testcontainers,
      "org.scalameta" %% "moped-testkit" % V.moped,
      "org.scalameta" %% "scalameta" % V.scalameta,
      "io.get-coursier" %% "coursier" % V.coursier,
      "com.lihaoyi" %% "pprint" % "0.6.6"
    )
)

lazy val fatjarPackageSettings = List[Def.Setting[_]](
  (assembly / assemblyMergeStrategy) := {
    case PathList("javax", _ @_*) =>
      MergeStrategy.discard
    case PathList("com", "sun", _ @_*) =>
      MergeStrategy.discard
    case PathList("sun", _ @_*) =>
      MergeStrategy.discard
    case PathList("META-INF", "versions", "9", "module-info.class") =>
      MergeStrategy.discard
    case x =>
      val oldStrategy = (assembly / assemblyMergeStrategy).value
      oldStrategy(x)
  },
  (Compile / Keys.`package`) := {
    val slimJar = (Compile / Keys.`package`).value
    val fatJar = crossTarget.value / (assembly / assemblyJarName).value
    val _ = assembly.value
    IO.copyFile(fatJar, slimJar, CopyOptions().withOverwrite(true))
    slimJar
  },
  (Compile / packageBin / packagedArtifact) := {
    val (art, slimJar) = (Compile / packageBin / packagedArtifact).value
    val fatJar =
      new File(crossTarget.value + "/" + (assembly / assemblyJarName).value)
    val _ = assembly.value
    IO.copy(List(fatJar -> slimJar), CopyOptions().withOverwrite(true))
    (art, slimJar)
  },
  pomPostProcess := { node =>
    new RuleTransformer(
      new RewriteRule {
        private def isAbsorbedDependency(node: XmlNode): Boolean = {
          node.label == "dependency" &&
          node.child.exists(child => child.label == "artifactId")
        }
        override def transform(node: XmlNode): XmlNodeSeq =
          node match {
            case e: Elem if isAbsorbedDependency(node) =>
              Comment(
                "the dependency that was here has been absorbed via sbt-assembly"
              )
            case _ =>
              node
          }
      }
    ).transform(node).head
  }
)
