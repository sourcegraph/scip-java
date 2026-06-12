addSbtPlugin("org.xerial.sbt" % "sbt-pack" % "0.14")
addSbtPlugin("se.marcuslonnberg" % "sbt-docker" % "1.11.0")
addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.11.1")
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.10.0")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.5")
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.14.7")
addSbtPlugin("com.thesamet" % "sbt-protoc" % "1.0.6")
addSbtPlugin("com.lightbend.sbt" % "sbt-java-formatter" % "0.6.1")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.15.0")
addSbtPlugin("org.jetbrains.scala" % "sbt-kotlin-plugin" % "3.1.6")
addSbtPlugin("com.github.sbt.junit" % "sbt-jupiter-interface" % "0.15.1")
// sbt-jdi-tools appears to fix an error related to this message:
// [error] (plugin / Compile / compileIncremental) java.lang.NoClassDefFoundError: com/sun/tools/javac/code/Symbol
addSbtPlugin("org.scala-debugger" % "sbt-jdi-tools" % "1.1.1")

ThisBuild / libraryDependencySchemes ++=
  Seq("org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always)
