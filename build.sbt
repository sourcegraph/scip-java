import scala.xml.{Node => XmlNode, NodeSeq => XmlNodeSeq, _}
import scala.xml.transform.{RewriteRule, RuleTransformer}
import java.io.File
import java.nio.file.Files
import java.util.Properties
import scala.collection.mutable.ListBuffer
import scala.util.control.NoStackTrace

lazy val V =
  new {
    val protobuf = "3.15.6"
    val protoc =
      "3.17.3" // the oldest protoc version with Apple M1 support, see https://github.com/scalapb/ScalaPB/issues/1024#issuecomment-860126568
    val coursier = "2.0.8"
    val bsp = "2.0.0-M13"
    val moped = "0.1.11"
    val gradle = "7.0"
    val scala213 = "2.13.10"
    val scala212 = "2.12.17"
    val scala211 = "2.11.12"
    val scala3 = "3.2.2"
    val metals = "0.11.11"
    val scalameta = "4.8.1"
    val semanticdbKotlinc = "0.3.0"
    val testcontainers = "0.39.3"
    val requests = "0.6.5"
    val minimalMillVersion = "0.10.0"
    val millScipVersion = "0.3.5"
    val kotlinGradlePlugin = "1.5.31"
  }

inThisBuild(
  List(
    scalaVersion := V.scala213,
    crossScalaVersions := List(V.scala213),
    scalafixDependencies +=
      "com.github.liancheng" %% "organize-imports" % "0.6.0",
    scalafixCaching := true,
    scalacOptions ++= List("-Wunused:imports"),
    semanticdbEnabled := true,
    semanticdbVersion := V.scalameta,
    organization := "com.sourcegraph",
    homepage := Some(url("https://github.com/sourcegraph/scip-java")),
    dynverSeparator := "-",
    PB.protocVersion := V.protoc,
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
    javaToolchainVersion := "8",
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
lazy val gradlePlugin = project
  .in(file("semanticdb-gradle-plugin"))
  .settings(
    name := "semanticdb-gradle",
    scalaVersion := V.scala213,
    buildInfoPackage := "com.sourcegraph.scip_java",
    publish / skip := true,
    javaToolchainVersion := "8",
    scalacOptions ++= Seq("-target:8", "-release", "8"),
    libraryDependencies ++=
      List(
        "dev.gradleplugins" % "gradle-api" % V.gradle % Provided,
        "dev.gradleplugins" % "gradle-test-kit" % V.gradle % Provided,
        "org.jetbrains.kotlin" % "kotlin-gradle-plugin" % V.kotlinGradlePlugin %
          Provided
      ),
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
      )
  )
  .enablePlugins(BuildInfoPlugin)

lazy val javacPlugin = project
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

lazy val scipProto = project
  .in(file("scip-java-proto"))
  .settings(
    moduleName := "scip-java-proto",
    javaToolchainVersion := "8",
    javaOnlySettings,
    libraryDependencies +=
      "com.google.protobuf" % "protobuf-java-util" % V.protobuf,
    (Compile / PB.targets) :=
      Seq(PB.gens.java(V.protobuf) -> (Compile / sourceManaged).value),
    Compile / PB.protocOptions := Seq("--experimental_allow_proto3_optional")
  )

lazy val scip = project
  .in(file("scip-semanticdb"))
  .settings(
    moduleName := "scip-semanticdb",
    javaToolchainVersion := "8",
    javaOnlySettings,
    (Compile / PB.targets) :=
      Seq(PB.gens.java(V.protobuf) -> (Compile / sourceManaged).value),
    Compile / PB.protocOptions := Seq("--experimental_allow_proto3_optional")
  )
  .dependsOn(semanticdb, scipProto)

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
            (javacPlugin / Compile / Keys.`package`).value,
            "semanticdb-plugin.jar"
          )
          addJar(
            (agent / Compile / Keys.`package`).value,
            "semanticdb-agent.jar"
          )
          addJar((gradlePlugin / Compile / assembly).value, "gradle-plugin.jar")

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
    docker / imageNames := {
      val latest = {
        val label =
          if (isSnapshot.value)
            "latest-snapshot"
          else
            "latest"

        List(ImageName(s"sourcegraph/scip-java:$label"))
      }

      // Don't publish a separately tagged image for snapshots -
      // only latest-snapshot
      val versioned =
        if (isSnapshot.value)
          Nil
        else
          List(ImageName(s"sourcegraph/scip-java:${version.value}"))

      latest ++ versioned

    },
    docker / dockerfile := {
      val binaryDistribution = pack.value
      val scipJavaWrapper = (ThisBuild / baseDirectory).value / "bin" /
        "scip-java-docker-script.sh"
      val dockerSetup = (ThisBuild / baseDirectory).value / "bin" /
        "docker-setup.sh"
      new Dockerfile {
        from("eclipse-temurin:17")

        // Setup system dependencies.
        run("apt-get", "update")
        run(
          "apt-get",
          "install",
          "--yes",
          "jq",
          "wget",
          "curl",
          "zip",
          "unzip",
          "git",
          // C++ and Python dependencies that may be needed by some random JVM
          // builds.
          "python3",
          "python3-pip",
          "autoconf",
          "automake",
          "libtool",
          "build-essential",
          "libtool",
          "make",
          "g++"
        )

        // Install SDKMAN
        add(dockerSetup, "/docker-setup.sh")
        run("bash", "/docker-setup.sh")

        env("PATH", "/opt/maven/bin:${PATH}")
        env("PATH", "/opt/gradle/bin:${PATH}")
        env("PATH", "/root/.local/share/coursier/bin:${PATH}")
        env(
          "JAVA_TOOL_OPTIONS",
          "-XX:MaxRAMPercentage=80.0 -XX:+UseContainerSupport"
        )

        // Mark all directories as safe for Git, so that it doesn't
        // trigger this check and error:
        // `detected dubious ownership in repository at <folder>`
        run("git", "config", "--global", "--add", "safe.directory", "*")

        // Install `scip-java` binary.
        add(scipJavaWrapper, "/usr/local/bin/scip-java")
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
  (publishLocal / skip) := true,
  (run / fork) := true,
  (Compile / unmanagedSourceDirectories) += minimizedSourceDirectory,
  libraryDependencies ++= List("org.projectlombok" % "lombok" % "1.18.22"),
  javacOptions ++=
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
  .settings(minimizedSettings, javaOnlySettings)
  .dependsOn(agent, javacPlugin)
  .disablePlugins(JavaFormatterPlugin)

lazy val minimized8 = project
  .in(file("tests/minimized/.j8"))
  .settings(minimizedSettings, javaToolchainVersion := "8", javaOnlySettings)
  .dependsOn(agent, javacPlugin)
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
    javaOnlySettings,
    minimizedSettings,
    javaToolchainVersion := "17",
    javacOptions ++= javacModuleOptions
  )
  .dependsOn(agent, javacPlugin)
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
  .dependsOn(javacPlugin, cli)
  .enablePlugins(BuildInfoPlugin)

lazy val buildTools = project
  .in(file("tests/buildTools"))
  .settings(
    testSettings,
    (Test / javaOptions) ++=
      List(
        s"-javaagent:${(agent / Compile / Keys.`package`).value}",
        s"-Dsemanticdb.pluginpath=${(javacPlugin / Compile / Keys.`package`).value}",
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
    Jmh / bspEnabled := false,
    (run / fork) := true,
    (publish / skip) := true
  )
  .dependsOn(unit)
  .enablePlugins(JmhPlugin)

lazy val docs = project
  .in(file("scip-java-docs"))
  .settings(
    publishLocal / skip := true,
    publish / skip := true,
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
    old.withEnabled(false).withApiDebug(true)
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

lazy val dumpScipJavaVersion = taskKey[Unit](
  "Dump the version of scip-java tool to a VERSION file"
)
dumpScipJavaVersion := {
  val versionValue = (cli / version).value

  IO.write((ThisBuild / baseDirectory).value / "VERSION", versionValue)
}
