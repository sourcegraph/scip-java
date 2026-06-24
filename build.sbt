import _root_.kotlin.Keys._

lazy val V =
  new {
    val protobuf = "4.34.2"
    val scipBindings = "0.8.0"
    val gradle = "8.10"
    val kotlinVersion = "2.2.0"
    val kotest = "4.6.3"
    val kctfork = "0.7.1"
    val clikt = "5.0.3"
    val kotlinxSerialization = "1.9.0"
  }

// sbt-git's bundled JGit can't read linked worktrees; shell out to
// git CLI there. See https://github.com/sbt/sbt-git/issues/264.
if (file(".git").isFile)
  Seq(useReadableConsoleGit)
else
  Nil

inThisBuild(
  List(
    organization := "com.sourcegraph",
    homepage := Some(url("https://github.com/sourcegraph/scip-java")),
    dynverSeparator := "-",
    PB.protocVersion := V.protobuf,
    autoScalaLibrary := false,
    crossPaths := false,
    // Pin bytecode to major 55 so compiler plugins can run on Java 11.
    Compile / javacOptions ++= Seq("--release", "11"),
    incOptions ~= { old =>
      old.withEnabled(false).withApiDebug(true)
    },
    licenses :=
      List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
  )
)

name := "root"
(publish / skip) := true

// Shared module with the SCIP shard utilities (symbol encoder, document
// builder, on-disk writer) consumed by both the Java compiler plugin
// (scip-javac) and the Kotlin compiler plugin (scip-kotlinc).
lazy val scipShared = project
  .in(file("scip-shared"))
  .settings(
    moduleName := "scip-shared",
    libraryDependencies +=
      "org.scip-code" % "scip-java-bindings" % V.scipBindings
  )

lazy val javacPlugin = project
  .in(file("scip-javac"))
  .settings(
    moduleName := "scip-javac",
    // Scoped to compile so doc tasks (which reject -g) are unaffected.
    Compile / compile / javacOptions += "-g",
    // JDK 14+ ServiceLoader-scans the classpath for Plugin providers; our
    // own META-INF/services entry points at ScipPlugin before it's
    // built. Force an empty processor path so javac skips the scan.
    Compile / compile / javacOptions ++= {
      val empty = target.value / "empty-processorpath"
      IO.createDirectory(empty)
      Seq("-processorpath", empty.getAbsolutePath)
    },
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
    (assembly / assemblyShadeRules) :=
      Seq(
        ShadeRule
          .rename(
            // Don't rename ScipPlugin since the fully-qualified name is
            // referenced from META-INF/services/com.sun.source.util.Plugin
            "com.sourcegraph.scip_javac.ScipPlugin" ->
              "com.sourcegraph.scip_javac.ScipPlugin",
            // Don't rename InjectScipOptions because we load it via FQN to
            // process a list of Java compiler options.
            "com.sourcegraph.scip_javac.InjectScipOptions" ->
              "com.sourcegraph.scip_javac.InjectScipOptions",
            "com.google.**" -> "com.sourcegraph.shaded.com.google.@1",
            // Shade everything else in the scip-javac compiler plugin in
            // order to be able to index the plugin code itself. Without this step,
            // we can't add the plugin to the classpath while compiling the source
            // code of the plugin itself because it results in cryptic compile errors.
            "com.sourcegraph.**" -> "com.sourcegraph.shaded.com.sourcegraph.@1",
            "google.**" -> "com.sourcegraph.shaded.google.@1",
            "org.relaxng.**" -> "com.sourcegraph.shaded.relaxng.@1"
          )
          .inAll
      ),
    // JUnit 5 for the colocated in-process javac tests (test scope only, so it
    // stays out of the published scip-javac POM).
    libraryDependencies += "com.github.sbt.junit" % "jupiter-interface" %
      JupiterKeys.jupiterVersion.value % Test,
    Test / fork := true,
    // The tests drive javac in-process via ScipPlugin; on JDK 17+ this requires
    // the JDK-internal javac packages to be opened.
    Test / javaOptions ++= javacModuleOptions.map(_.stripPrefix("-J"))
  )
  .dependsOn(scipShared)

// The scip-kotlinc compiler plugin. Built as a fat-jar that is later
// embedded into the scip-java CLI distribution (see cli's resourceGenerators)
// so the runtime no longer needs to fetch a published scip-kotlinc
// artifact from Maven.
lazy val scipKotlinc = project
  .in(file("scip-kotlinc"))
  .enablePlugins(KotlinPlugin)
  .settings(
    name := "scip-kotlinc",
    moduleName := "scip-kotlinc",
    description := "A kotlinc plugin to emit SCIP information",
    kotlinVersion := V.kotlinVersion,
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
      "org.jetbrains.kotlin" % "kotlin-stdlib" % V.kotlinVersion % Provided,
    // SCIP message classes come from scipShared (which depends on
    // scip-java-bindings); this adds the Kotlin DSL extensions on top.
    libraryDependencies +=
      "org.scip-code" % "scip-kotlin-bindings" % V.scipBindings,
    // kotlin-compiler-embeddable is supplied by kotlinc at runtime
    libraryDependencies += "org.jetbrains.kotlin" %
      "kotlin-compiler-embeddable" % V.kotlinVersion % Provided,
    // ---- sbt-assembly fat-jar ---------------------------------------------
    // Produces a shaded jar for consumers that need a self-contained compiler
    // plugin, such as the CLI resource embedding and minimized fixture build.
    assembly / assemblyShadeRules :=
      Seq(
        // Relocate any IntelliJ classes the same way kotlin-compiler-embeddable
        // does internally. Do NOT rename `com.sourcegraph.**` — the
        // META-INF/services files reference those FQNs.
        ShadeRule
          .rename("com.intellij.**" -> "org.jetbrains.kotlin.com.intellij.@1")
          .inAll
      ),
    // tests
    libraryDependencies ++=
      Seq(
        "org.jetbrains.kotlin" % "kotlin-compiler-embeddable" %
          V.kotlinVersion % Test,
        "org.jetbrains.kotlin" % "kotlin-test" % V.kotlinVersion % Test,
        "org.jetbrains.kotlin" % "kotlin-test-junit5" % V.kotlinVersion % Test,
        "org.jetbrains.kotlin" % "kotlin-reflect" % V.kotlinVersion % Test,
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
  .dependsOn(scipShared)

lazy val gradlePlugin = project
  .in(file("scip-gradle-plugin"))
  .settings(
    name := "scip-gradle",
    publish / skip := true,
    libraryDependencies ++=
      List(
        "dev.gradleplugins" % "gradle-api" % V.gradle % Provided,
        "dev.gradleplugins" % "gradle-test-kit" % V.gradle % Provided
      )
  )

lazy val mavenPlugin = project
  .in(file("scip-maven-plugin"))
  .settings(
    moduleName := "scip-maven-plugin",
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

// Aggregates compiler-plugin shards into the final SCIP index consumed by the CLI.
lazy val scipAggregator = project
  .in(file("scip-aggregator"))
  .settings(
    moduleName := "scip-aggregator",
    libraryDependencies ++=
      Seq(
        "org.scip-code" % "scip-java-bindings" % V.scipBindings,
        // JUnit 5 for the colocated Java unit tests (test scope only, so it is
        // excluded from the published POM and keeps this a Java-only module).
        "com.github.sbt.junit" % "jupiter-interface" %
          JupiterKeys.jupiterVersion.value % Test
      ),
    (Compile / PB.targets) :=
      Seq(PB.gens.java(V.protobuf) -> (Compile / sourceManaged).value)
  )
  .dependsOn(scipShared)

lazy val cli = project
  .in(file("scip-java"))
  .enablePlugins(KotlinPlugin, PackPlugin)
  .settings(
    moduleName := "scip-java",
    kotlinVersion := V.kotlinVersion,
    kotlincJvmTarget := "11",
    (Compile / mainClass) := Some("com.sourcegraph.scip_java.ScipJava"),
    (run / baseDirectory) := (ThisBuild / baseDirectory).value,
    // ScipJava.main can call System.exit, so we always fork the JVM when
    // sbt invokes it directly so it cannot kill the surrounding sbt process.
    Compile / run / fork := true,
    Test / fork := true,
    // Our CI set up is a couple of measly vCPUs so parallelising tests there makes
    // everything worse.
    Test / testForkedParallel := !sys.env.contains("CI"),
    // The SCIP build tool drives javac in-process; on JDK 17+ this requires
    // opening the JDK-internal javac packages.
    Test / javaOptions ++= javacModuleOptions.map(_.stripPrefix("-J")),
    // Pin the JDK version embedded in stdlib SCIP symbols so output is stable.
    Test / javaOptions += "-Dscip.jdk.version=11",
    libraryDependencies ++=
      List(
        "com.github.ajalt.clikt" % "clikt-jvm" % V.clikt,
        "org.jetbrains.kotlinx" % "kotlinx-serialization-json-jvm" %
          V.kotlinxSerialization,
        "org.jetbrains.kotlin" % "kotlin-compiler-embeddable" % V.kotlinVersion,
        "org.jetbrains.kotlin" % "kotlin-scripting-common" % V.kotlinVersion,
        "org.jetbrains.kotlin" % "kotlin-scripting-jvm" % V.kotlinVersion,
        "org.jetbrains.kotlin" % "kotlin-scripting-dependencies" %
          V.kotlinVersion,
        "org.jetbrains.kotlin" % "kotlin-scripting-dependencies-maven" %
          V.kotlinVersion
      ),
    libraryDependencies ++=
      Seq(
        "org.jetbrains.kotlin" % "kotlin-test" % V.kotlinVersion % Test,
        "org.jetbrains.kotlin" % "kotlin-test-junit5" % V.kotlinVersion % Test,
        "com.github.sbt.junit" % "jupiter-interface" %
          JupiterKeys.jupiterVersion.value % Test
      ),
    (Compile / resourceGenerators) +=
      Def
        .task {
          val out = (Compile / resourceManaged).value.toPath
          IO.delete(out.toFile)

          val outs = Seq(
            (javacPlugin / Compile / assembly).value ->
              out.resolve("scip-plugin.jar").toFile,
            (gradlePlugin / Compile / assembly).value ->
              out.resolve("gradle-plugin.jar").toFile,
            (scipKotlinc / Compile / assembly).value ->
              out.resolve("scip-kotlinc.jar").toFile
          )

          IO.copy(
            outs,
            overwrite = true,
            preserveLastModified = false,
            preserveExecutable = true
          )
          val propsFile = out.resolve("scip-java.properties").toFile
          // Build version consumed at runtime by BuildInfo.version (Kotlin).
          IO.write(propsFile, s"version=${version.value}\n")

          propsFile +: outs.map(_._2)
        }
        .taskValue
  )
  .dependsOn(scipAggregator)

// Kotlin snapshot case. The fixture includes Java sources as interop
// consumers, but the case is still keyed by the Kotlin compiler/plugin version
// axis. It writes *.scip shards under target/scip-targetroot/ for the central
// scipSnapshots project to aggregate and compare with goldens.
lazy val scipSnapshotsKotlinCommon = project
  .in(file("scip-snapshots/cases/kotlin/common"))
  .enablePlugins(KotlinPlugin)
  .settings(
    publish / skip := true,
    kotlinVersion := V.kotlinVersion,
    kotlincJvmTarget := "1.8",
    kotlinLib("stdlib"),
    // Force javac to fork. Two reasons:
    //   1. JDK 9+ strongly encapsulates jdk.compiler internals; scip-javac
    //      reflectively touches them and needs --add-exports flags. With a
    //      forked javac we can pass `-J--add-exports=...` (mirrors scip-java).
    //   2. sbt's in-process javac receives `vf://` virtual-file URIs from the
    //      MappedFileConverter, which scip-javac cannot resolve via
    //      java.nio.file.Path.of. Forked javac is invoked with absolute file
    //      paths instead, so the plugin sees real paths.
    // Setting javaHome to Some(<current JVM home>) flips
    // ZincUtil.compilers/JavaTools.directOrFork from direct → fork.
    javaHome := Some(file(System.getProperty("java.home"))),
    Compile / javacOptions ++= javacModuleOptions,
    // Attach the assembled kotlinc fat-jar to the compile classpath.
    // sbt-kotlin-plugin's AnalyzingKotlinCompiler partitions the classpath:
    // any jar containing META-INF/services/org.jetbrains.kotlin.compiler.plugin*
    // entries (which our fat-jar does, for both CommandLineProcessor and
    // CompilerPluginRegistrar) is moved into args.pluginClasspaths and removed
    // from the regular classpath. So no `-Xplugin=<path>` is needed and we
    // don't have to predict the assembled jar's filename. The .value reference
    // also gives us the right task ordering — assembly runs before compile.
    Compile / unmanagedJars +=
      Attributed.blank((scipKotlinc / Compile / assembly).value),
    // Wire the locally-built scip-javac fat jar in place of fetching the
    // published `com.sourcegraph:scip-javac` artifact at compile time.
    Compile / unmanagedJars +=
      Attributed.blank((javacPlugin / Compile / assembly).value),
    Compile / kotlincPluginOptions ++= {
      val srcRoot = (ThisBuild / baseDirectory).value.getAbsolutePath
      val tgtRoot = (target.value / "scip-targetroot").getAbsolutePath
      Seq(
        s"plugin:scip-kotlinc:sourceroot=$srcRoot",
        s"plugin:scip-kotlinc:targetroot=$tgtRoot"
      )
    },
    // The scip javac plugin parses its own argument string, so
    // `-Xplugin:scip -sourceroot:<...> -targetroot:<...>` MUST be passed
    // as a single javac argument (matches the existing Gradle behavior).
    Compile / javacOptions += {
      val srcRoot = (ThisBuild / baseDirectory).value
      val tgtRoot = target.value / "scip-targetroot"
      s"-Xplugin:scip -sourceroot:${srcRoot.getAbsolutePath} " +
        s"-targetroot:${tgtRoot.getAbsolutePath}"
    }
  )

lazy val scipSnapshotsJavaCommon = project
  .in(file("scip-snapshots/cases/java/common"))
  .settings(
    publish / skip := true,
    run / fork := true,
    libraryDependencies += "org.projectlombok" % "lombok" % "1.18.22",
    // Fork javac so it receives real file paths instead of sbt's `vf://` virtual-file URIs
    // (see the comment on `scipSnapshotsKotlinCommon` for the long story).
    javaHome := Some(file(System.getProperty("java.home"))),
    // Keep minimized snapshots stable across JDK 11/17/21.
    Compile / javacOptions ++= Seq("--release", "11"),
    Compile / javacOptions ++= javacModuleOptions,
    javacOptions +=
      List(
        s"-Xplugin:scip",
        s"-text:on",
        s"-verbose",
        s"-sourceroot:${(ThisBuild / baseDirectory).value}",
        s"-targetroot:${(Compile / semanticdbTargetRoot).value}",
        s"-randomtimestamp=${System.nanoTime()}"
      ).mkString(" ")
  )
  .dependsOn(javacPlugin)

def javacModuleOptions = List(
  "-J--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
  "-J--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED",
  "-J--add-exports=jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
  "-J--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
  "-J--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED"
)

lazy val scipSnapshots = project
  .in(file("scip-snapshots"))
  .settings(
    publish / skip := true,
    Test / fork := true,
    // Open the JDK-internal javac packages to the in-process javac the tests
    // drive; on JDK 17+ this is required or the reflective access fails.
    Test / javaOptions ++= javacModuleOptions.map(_.stripPrefix("-J")),
    // Pin the JDK version embedded in stdlib SCIP symbols (e.g. `jdk 11
    // java/lang/String#`) so snapshots are stable across JDK 11/17/21.
    Test / javaOptions += "-Dscip.jdk.version=11",
    libraryDependencies += "com.github.sbt.junit" % "jupiter-interface" %
      JupiterKeys.jupiterVersion.value % Test,
    Compile / mainClass := Some("tests.SaveSnapshots"),
    Compile / run / fork := true,
    Test / javaOptions ++= snapshotPathOptions.value,
    Compile / run / javaOptions ++= snapshotPathOptions.value
  )
  .dependsOn(cli)

// Runtime paths for the snapshot generator, passed as -D system properties.
// Depending on each snapshot case's compile task guarantees fresh targetroots
// whenever `scipSnapshots/test` or `scipSnapshots/run` evaluate javaOptions.
def snapshotPathOptions = Def.task {
  val _java = (scipSnapshotsJavaCommon / Compile / compile).value
  val _kotlin = (scipSnapshotsKotlinCommon / Compile / compile).value
  val snapshotRoot = (ThisBuild / baseDirectory).value / "scip-snapshots"
  Seq(
    s"-Dsnapshot.sourceroot=${(ThisBuild / baseDirectory).value.getAbsolutePath}",
    "-Dsnapshot.cases=java-common,kotlin-common",
    s"-Dsnapshot.case.java-common.expectDir=${(
        snapshotRoot / "expected" / "java" / "common"
      ).getAbsolutePath}",
    s"-Dsnapshot.case.java-common.targetroot=${(
        scipSnapshotsJavaCommon / Compile / semanticdbTargetRoot
      ).value.getAbsolutePath}",
    s"-Dsnapshot.case.kotlin-common.expectDir=${(
        snapshotRoot / "expected" / "kotlin" / "common"
      ).getAbsolutePath}",
    s"-Dsnapshot.case.kotlin-common.targetroot=${((
        scipSnapshotsKotlinCommon / target
      ).value / "scip-targetroot").getAbsolutePath}",
    "-Dsnapshot.case.kotlin-common.aggregateNoEmitInverseRelationships=true"
  )
}
