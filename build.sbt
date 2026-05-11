import _root_.kotlin.Keys._
import sbtdocker.DockerfileBase
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
    val coursier = "2.1.9"
    val scalaXml = "2.1.0"
    val moped = "0.2.0"
    val gradle = "7.0"
    val scala213 = "2.13.13"
    val scala3 = "3.3.3"
    val metals = "1.2.2"
    val scalameta = "4.9.3"
    val semanticdbKotlin = "0.5.0"
    val requests = "0.8.0"
    val minimalMillVersion = "0.10.0"
    val millScipVersion = "0.3.6"
    val kotlinVersion = "2.1.20"
    // Versions used by the merged-in scip-kotlin compiler plugin.
    val kotlinPlugin = "2.2.0"
    val kotest = "4.6.3"
    val kctfork = "0.7.1"
    val kotlincProtobuf = "3.17.3"
  }

inThisBuild(
  List(
    scalaVersion := V.scala213,
    crossScalaVersions := List(V.scala213),
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
          "jupblb",
          "Michal Kielbowicz",
          "michal.kielbowicz@sourcegraph.com",
          url("https://github.com/jupblb")
        ),
        Developer(
          "chrapkowski-sg",
          "Adam Chrapkowski",
          "adam.chrapkowski@sourcegraph.com",
          url("https://github.com/chrapkowski-sg")
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
        "net.bytebuddy" % "byte-buddy-agent" % "1.15.7"
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
        "org.jetbrains.kotlin" % "kotlin-gradle-plugin" % V.kotlinVersion %
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
        "semanticdbKotlincVersion" -> V.semanticdbKotlin,
        "mtagsVersion" -> V.metals,
        "scala213" -> V.scala213,
        "scala3" -> V.scala3,
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
            // Don't rename SemanticdbPlugin since the fully-qualified name is
            // referenced from META-INF/services/com.sun.source.util.Plugin
            "com.sourcegraph.semanticdb_javac.SemanticdbPlugin" ->
              "com.sourcegraph.semanticdb_javac.SemanticdbPlugin",
            // Don't rename PrintJavaVersion because we load it via FQN to
            // detect the Java of a JVM installation.
            "com.sourcegraph.semanticdb_javac.PrintJavaVersion" ->
              "com.sourcegraph.semanticdb_javac.PrintJavaVersion",
            // Don't rename InjectSemanticdbOptions because we load it via FQN to
            // process a list of Java compiler options.
            "com.sourcegraph.semanticdb_javac.InjectSemanticdbOptions" ->
              "com.sourcegraph.semanticdb_javac.InjectSemanticdbOptions",
            "com.google.**" -> "com.sourcegraph.shaded.com.google.@1",
            // Shade everything else in the semanticdb-javac compiler plugin in
            // order to be able to index the plugin code itself. Without this step,
            // we can't add the plugin to the classpath while compiling the source
            // code of the plugin itself because it results in cryptic compile errors.
            "com.sourcegraph.**" -> "com.sourcegraph.shaded.com.sourcegraph.@1",
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
    publishMavenStyle := true,
    moduleName := "scip-semanticdb",
    javaToolchainVersion := "8",
    javaOnlySettings,
    (Compile / PB.targets) :=
      Seq(PB.gens.java(V.protobuf) -> (Compile / sourceManaged).value),
    Compile / PB.protocOptions := Seq("--experimental_allow_proto3_optional")
  )
  .dependsOn(semanticdb, scipProto)

lazy val mavenPlugin = project
  .in(file("maven-plugin"))
  .settings(
    moduleName := "maven-plugin",
    javaToolchainVersion := "8",
    javaOnlySettings,
    libraryDependencies ++=
      Seq(
        "org.apache.maven" % "maven-plugin-api" % "3.6.3",
        "org.apache.maven.plugin-tools" % "maven-plugin-annotations" % "3.6.4" %
          Provided,
        "org.apache.maven" % "maven-project" % "2.2.1"
      ),
    Compile / resourceGenerators +=
      Def.task {
        val dir = (Compile / managedResourceDirectories).value.head /
          "META-INF" / "maven"
        IO.createDirectory(dir)
        val file = dir / "plugin.xml"
        val template = IO.read(
          (Compile / resourceDirectory).value / "META-INF" / "maven" /
            "plugin.template.xml"
        )

        IO.write(file, template.replace("@VERSION@", version.value))

        Seq(file)
      }
  )

// The Kotlin compiler plugin that emits SemanticDB. Merged in from the
// previously separate scip-kotlin repository.
//
// NOTE: `test / aggregate := false` keeps `sbt test` (run across the JDK 8/
// 11/17/21 matrix in CI) from invoking `kotlinc/test` — kotlinc 2.2.0
// requires JDK 11+ to run, so the kotlinc tests live in a dedicated CI job
// (.github/workflows/ci.yml :: kotlin) instead.
lazy val kotlinc = project
  .in(file("semanticdb-kotlinc"))
  .enablePlugins(KotlinPlugin)
  .settings(
    name := "semanticdb-kotlinc",
    moduleName := "semanticdb-kotlinc",
    description := "A kotlinc plugin to emit SemanticDB information",
    crossPaths := false,
    autoScalaLibrary := false,
    test / aggregate := false,
    compile / aggregate := false,
    kotlinVersion := V.kotlinPlugin,
    kotlincJvmTarget := "1.8",
    kotlincOptions ++= Seq("-Xinline-classes", "-Xcontext-parameters"),

    // sbt-kotlin-plugin defaults to adding `kotlin-scripting-compiler-embeddable`
    // (and its transitive kotlin-stdlib) as a regular dependency. Mark them
    // Provided — kotlinc supplies them at runtime, and we don't want them
    // bundled into the fat-jar.
    kotlinRuntimeProvided := true,

    // kotlin-stdlib is supplied by kotlinc at runtime — keep on compile
    // classpath via Provided so the assembled fat-jar does not bundle it.
    libraryDependencies +=
      "org.jetbrains.kotlin" % "kotlin-stdlib" % V.kotlinPlugin % Provided,

    // protobuf java codegen — proto file lives at src/main/proto/...
    Compile / PB.protoSources :=
      Seq((Compile / sourceDirectory).value / "proto"),
    Compile / PB.targets :=
      Seq(PB.gens.java(V.kotlincProtobuf) -> (Compile / sourceManaged).value),
    libraryDependencies +=
      "com.google.protobuf" % "protobuf-java" % V.kotlincProtobuf,

    // kotlin-compiler-embeddable is supplied by kotlinc at runtime
    libraryDependencies +=
      "org.jetbrains.kotlin" % "kotlin-compiler-embeddable" %
        V.kotlinPlugin % Provided,

    // ---- sbt-assembly fat-jar ---------------------------------------------
    // Mirrors scip-java's `fatjarPackageSettings`. Produces a shaded jar that
    // replaces the slim `packageBin` so `publishLocal` ships the shaded
    // artifact (the same artifact Gradle's shadowJar produced previously).
    assembly / assemblyShadeRules :=
      Seq(
        // Relocate any IntelliJ classes the same way kotlin-compiler-embeddable
        // does internally. Do NOT rename `com.sourcegraph.**` — the
        // META-INF/services files reference those FQNs.
        ShadeRule
          .rename("com.intellij.**" -> "org.jetbrains.kotlin.com.intellij.@1")
          .inAll
      ),
    Compile / packageBin := assembly.value,
    // Strip every <dependency> from the POM — the fat-jar absorbs the
    // protobuf runtime, and the kotlin-* deps are Provided by kotlinc.
    pomPostProcess := { node =>
      new RuleTransformer(new RewriteRule {
        override def transform(n: XmlNode): XmlNodeSeq =
          if (n.label == "dependency")
            XmlNodeSeq.Empty
          else
            n
      }).transform(node).head
    },

    // tests
    libraryDependencies ++=
      Seq(
        "org.jetbrains.kotlin" % "kotlin-compiler-embeddable" %
          V.kotlinPlugin % Test,
        "org.jetbrains.kotlin" % "kotlin-test" % V.kotlinPlugin % Test,
        "org.jetbrains.kotlin" % "kotlin-test-junit5" % V.kotlinPlugin % Test,
        "org.jetbrains.kotlin" % "kotlin-reflect" % V.kotlinPlugin % Test,
        "io.kotest" % "kotest-assertions-core-jvm" % V.kotest % Test,
        "dev.zacsweers.kctfork" % "core" % V.kctfork % Test,
        "com.github.sbt.junit" % "jupiter-interface" %
          JupiterKeys.jupiterVersion.value % Test
      ),
    Test / fork := true,
    Test / javaOptions += "-Xmx2g",

    // sbt-kotlin-plugin 3.1.6 inspects every jar on the kotlinc classpath and
    // moves any jar containing META-INF/services/org.jetbrains.kotlin.compiler.plugin.*
    // entries into the compiler-plugin classpath, removing it from the regular
    // classpath. kctfork ships such service files for its own internal use as a
    // KAPT/registrar shim, which makes its public API (com.tschuchort.compiletesting.*)
    // invisible to our test sources. Workaround: pre-extract kctfork to a
    // directory and add that directory to the test classpath — sbt-kotlin-plugin
    // only inspects .jar files, so directories pass through unmodified.
    Test / unmanagedJars += {
      val report = update.value
      val files = report.allFiles
      val jar = files
        .find(_.getName == s"core-${V.kctfork}.jar")
        .getOrElse(
          sys.error(s"kctfork core-${V.kctfork}.jar not found in update report")
        )
      val dir = target.value / s"kctfork-${V.kctfork}-extracted"
      val marker = dir / ".extracted"
      if (!marker.exists()) {
        IO.delete(dir)
        IO.unzip(jar, dir)
        IO.touch(marker)
      }
      Attributed.blank(dir)
    }
  )

// `kotlincMinimized` is the SemanticDB/SCIP snapshot fixture project for the
// merged-in kotlinc plugin (named differently from the existing `minimized`
// project to avoid collision). It compiles a small set of Kotlin and Java
// fixtures with the assembled `kotlinc` plugin attached, producing
// *.semanticdb files which the `kotlincSnapshots` task converts to SCIP and
// renders as the human-readable golden snapshots checked into
// semanticdb-kotlinc/minimized/src/generatedSnapshots/resources/.
lazy val kotlincMinimized = project
  .in(file("semanticdb-kotlinc/minimized"))
  .enablePlugins(KotlinPlugin)
  .settings(
    publish / skip := true,
    crossPaths := false,
    autoScalaLibrary := false,
    // kotlincMinimized's compile invokes kotlinc 2.2.0 which requires JDK 11+,
    // so keep it out of the aggregated `sbt test` (which runs on the JDK 8/11/
    // 17/21 matrix in CI). The dedicated `kotlin` CI job below targets it
    // explicitly via `sbt kotlincMinimized/kotlincSnapshots`.
    test / aggregate := false,
    compile / aggregate := false,
    kotlinVersion := V.kotlinPlugin,
    kotlincJvmTarget := "1.8",
    kotlinLib("stdlib"),

    // Force javac to fork. Two reasons:
    //   1. JDK 9+ strongly encapsulates jdk.compiler internals; semanticdb-javac
    //      reflectively touches them and needs --add-exports flags. With a
    //      forked javac we can pass `-J--add-exports=...` (mirrors scip-java).
    //   2. sbt's in-process javac receives `vf://` virtual-file URIs from the
    //      MappedFileConverter, which semanticdb-javac cannot resolve via
    //      java.nio.file.Path.of. Forked javac is invoked with absolute file
    //      paths instead, so the plugin sees real paths.
    // Setting javaHome to Some(<current JVM home>) flips
    // ZincUtil.compilers/JavaTools.directOrFork from direct → fork.
    javaHome := Some(file(System.getProperty("java.home"))),
    Compile / javacOptions ++=
      Seq(
        "-J--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
        "-J--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED",
        "-J--add-exports=jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
        "-J--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
        "-J--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED"
      ),

    // Attach the assembled kotlinc fat-jar to the compile classpath.
    // sbt-kotlin-plugin's AnalyzingKotlinCompiler partitions the classpath:
    // any jar containing META-INF/services/org.jetbrains.kotlin.compiler.plugin*
    // entries (which our fat-jar does, for both CommandLineProcessor and
    // CompilerPluginRegistrar) is moved into args.pluginClasspaths and removed
    // from the regular classpath. So no `-Xplugin=<path>` is needed and we
    // don't have to predict the assembled jar's filename. The .value reference
    // also gives us the right task ordering — assembly runs before compile.
    Compile / unmanagedJars +=
      Attributed.blank((kotlinc / Compile / packageBin).value),
    // Attach the locally-built semanticdb-javac fat-jar so that `-Xplugin:semanticdb`
    // (set in javacOptions below) loads our plugin via its META-INF/services/
    // com.sun.source.util.Plugin entry. Using the local jar instead of the
    // published `com.sourcegraph:semanticdb-javac:<old>` artifact keeps this
    // module compatible with whichever JDK scip-java itself is built against.
    //
    // NOTE: must use `Keys.\`package\`` (which `fatjarPackageSettings`
    // overrides to return `assembly.value`), not `packageBin` — the latter
    // produces the slim, unshaded jar that is missing the bundled protobuf
    // runtime classes referenced by SemanticdbVisitor at runtime.
    Compile / unmanagedJars +=
      Attributed.blank((javacPlugin / Compile / Keys.`package`).value),
    Compile / kotlincPluginOptions ++= {
      val srcRoot = (ThisBuild / baseDirectory).value.getAbsolutePath
      val tgtRoot = (target.value / "semanticdb-targetroot").getAbsolutePath
      Seq(
        s"plugin:semanticdb-kotlinc:sourceroot=$srcRoot",
        s"plugin:semanticdb-kotlinc:targetroot=$tgtRoot"
      )
    },

    // The semanticdb javac plugin parses its own argument string, so
    // `-Xplugin:semanticdb -sourceroot:<...> -targetroot:<...>` MUST be passed
    // as a single javac argument (matches the existing Gradle behavior).
    Compile / javacOptions += {
      val srcRoot = (ThisBuild / baseDirectory).value
      val tgtRoot = target.value / "semanticdb-targetroot"
      s"-Xplugin:semanticdb -sourceroot:${srcRoot.getAbsolutePath} " +
        s"-targetroot:${tgtRoot.getAbsolutePath}"
    },

    // ----- snapshots regeneration task -----
    // Invokes `com.sourcegraph.scip_java.ScipJava.main` twice in the cli JVM
    // (forked — ScipJava.main calls System.exit on failure). First pass
    // converts the *.semanticdb files under target/semanticdb-targetroot/
    // into an index.scip; second pass renders that index as the human-readable
    // golden snapshots.
    kotlincSnapshots := Def.taskDyn {
      val srcRoot = (ThisBuild / baseDirectory).value.getAbsolutePath
      val tgtRoot = (target.value / "semanticdb-targetroot").getAbsolutePath
      val snapDir =
        (baseDirectory.value / "src" / "generatedSnapshots" / "resources")
          .getAbsolutePath
      val scipOut = s"$tgtRoot/index.scip"
      val mainCls = "com.sourcegraph.scip_java.ScipJava"
      Def.sequential(
        Compile / compile,
        (cli / Compile / runMain).toTask(
          s" $mainCls index-semanticdb --no-emit-inverse-relationships --cwd $srcRoot --output $scipOut $tgtRoot"
        ),
        (cli / Compile / runMain).toTask(
          s" $mainCls snapshot --cwd $srcRoot --output $snapDir $tgtRoot"
        )
      )
    }.value
  )
  // The Java fixture files under semanticdb-kotlinc/minimized/src/main/java/
  // are intentionally hand-formatted (4-space indent, etc.) — disable
  // sbt-java-formatter so it doesn't rewrite them and break the golden
  // SCIP snapshots.
  .disablePlugins(JavaFormatterPlugin)

// Regenerates the golden SemanticDB/SCIP snapshots checked into
// semanticdb-kotlinc/minimized/src/generatedSnapshots/resources/. Defined at
// the top level so it is in scope for the `kotlincMinimized` project above.
lazy val kotlincSnapshots = taskKey[Unit](
  "Run the SCIP snapshot generator over the kotlinc minimized project"
)

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
        "semanticdbKotlincVersion" -> V.semanticdbKotlin,
        "mtagsVersion" -> V.metals,
        "scala213" -> V.scala213,
        "scala3" -> V.scala3,
        "minimalMillVersion" -> V.minimalMillVersion,
        "millScipVersion" -> V.millScipVersion
      ),
    buildInfoPackage := "com.sourcegraph.scip_java",
    libraryDependencies ++=
      List(
        "io.get-coursier" %% "coursier" % V.coursier,
        "io.get-coursier" %% "coursier-jvm" % V.coursier,
        "org.scalameta" % "mtags-interfaces" % V.metals,
        "org.scala-lang.modules" %% "scala-xml" % V.scalaXml,
        "com.lihaoyi" %% "requests" % V.requests,
        "org.scalameta" %% "moped" % V.moped,
        "org.scalameta" %% "ascii-graphs" % "0.1.2",
        "org.jetbrains.kotlin" % "kotlin-compiler-embeddable" % V.kotlinVersion,
        "org.jetbrains.kotlin" % "kotlin-scripting-common" % V.kotlinVersion,
        "org.jetbrains.kotlin" % "kotlin-scripting-jvm" % V.kotlinVersion,
        "org.jetbrains.kotlin" % "kotlin-scripting-dependencies" %
          V.kotlinVersion,
        "org.jetbrains.kotlin" % "kotlin-scripting-dependencies-maven" %
          V.kotlinVersion
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

          IO.copy(
            outs,
            overwrite = true,
            preserveLastModified = false,
            preserveExecutable = true
          )
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
    docker / dockerfile :=
      NativeDockerfile((ThisBuild / baseDirectory).value / "Dockerfile")
  )
  .enablePlugins(PackPlugin, DockerPlugin, BuildInfoPlugin)
  .dependsOn(scip)

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
  javacOptions +=
    List(
      s"-Xplugin:semanticdb",
      s"-build-tool:sbt",
      s"-text:on",
      s"-verbose",
      s"-sourceroot:${(ThisBuild / baseDirectory).value}",
      s"-targetroot:${(Compile / semanticdbTargetRoot).value}",
      s"-randomtimestamp=${System.nanoTime()}"
    ).mkString(" ")
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

def javacModuleOptions = List(
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

lazy val minimized21 = project
  .in(file("tests/minimized/.j21"))
  .settings(
    javaOnlySettings,
    minimizedSettings,
    javaToolchainVersion := "21",
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
    // javaOptions ++= Seq(   "-Xdebug",   "-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"),
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
        s"-Dsemanticdb.pluginpath=${(javacPlugin / Compile / Keys.`package`)
            .value}",
        s"-Dsemanticdb.sourceroot=${(ThisBuild / baseDirectory).value}",
        s"-Dsemanticdb.targetroot=${(agent / Compile / target).value /
            "semanticdb-targetroot"}"
      ),
    Test / envVars ++=
      Map(
        "SCIP_JAVA_CLI" -> ((cli / pack).value / "bin" / "scip-java").toString
      ),
    Test / fork := true,
    // Our CI set up is a couple of measly vCPUs so parallelising tests there makes
    // everything worse
    Test / testForkedParallel := !sys.env.contains("CI")
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
  javafmtOnCompile := false,
  autoScalaLibrary := false,
  incOptions ~= { old =>
    old.withEnabled(false).withApiDebug(true)
  },
  crossPaths := false
)

val testSettings = List(
  (publish / skip) := true,
  autoScalaLibrary := true,
  testFrameworks := List(TestFrameworks.MUnit),
  testOptions ++= {
    if (!(Test / testForkedParallel).value)
      List(Tests.Argument(TestFrameworks.MUnit, "-b"))
    else
      Nil
  },
  libraryDependencies ++=
    List(
      "org.scalameta" %% "munit" % "0.7.29",
      "org.scalameta" %% "mtags" % V.metals cross CrossVersion.full,
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
    assembly.value
  },
  (Compile / packageBin / packagedArtifact) := {
    val (artifact, _) = (Compile / packageBin / packagedArtifact).value
    (artifact, assembly.value)
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

lazy val build = taskKey[Unit](
  "Build `scip-java` CLI and place it in the out/bin/scip-java. "
)

build := {
  val source = (cli / pack).value
  val destination = (ThisBuild / baseDirectory).value / "out"
  IO.copyDirectory(source, destination)
}
