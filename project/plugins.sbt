addSbtPlugin("org.xerial.sbt" % "sbt-pack" % "0.14")
addSbtPlugin("se.marcuslonnberg" % "sbt-docker" % "1.9.0")
addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.5.10")
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.10.0")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.6")
addSbtPlugin("org.scalameta" % "sbt-mdoc" % "2.2.24")
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.10.1")
addSbtPlugin("com.thesamet" % "sbt-protoc" % "1.0.6")
addSbtPlugin("com.sourcegraph" % "sbt-sourcegraph" % "0.4.0")
addSbtPlugin("com.lightbend.sbt" % "sbt-java-formatter" % "0.6.1")
addSbtPlugin("pl.project13.scala" % "sbt-jmh" % "0.4.3")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.15.0")
addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.1")
// sbt-jdi-tools appears to fix an error related to this message:
// [error] (plugin / Compile / compileIncremental) java.lang.NoClassDefFoundError: com/sun/tools/javac/code/Symbol
addSbtPlugin("org.scala-debugger" % "sbt-jdi-tools" % "1.1.1")

libraryDependencies ++=
  List("com.thesamet.scalapb" %% "compilerplugin" % "0.11.11")

ThisBuild / libraryDependencySchemes ++=
  Seq("org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always)
