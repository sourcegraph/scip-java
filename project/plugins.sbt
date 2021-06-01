addSbtPlugin("org.scalameta" % "sbt-native-image" % "0.3.0")
addSbtPlugin("com.geirsson" % "sbt-ci-release" % "1.5.7")
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.10.0")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.3.4")
addSbtPlugin("org.scalameta" % "sbt-mdoc" % "2.2.21")
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.9.27")
addSbtPlugin("com.thesamet" % "sbt-protoc" % "1.0.0")
addSbtPlugin("ch.epfl.scala" % "sbt-bloop" % "1.4.8-17-3eab1f80")
addSbtPlugin("com.sourcegraph" % "sbt-sourcegraph" % "0.2.0")
addSbtPlugin("com.lightbend.sbt" % "sbt-java-formatter" % "0.6.0")
addSbtPlugin("pl.project13.scala" % "sbt-jmh" % "0.4.0")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.15.0")
addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.1")

// sbt-jdi-tools appears to fix an error related to this message:
// [error] (plugin / Compile / compileIncremental) java.lang.NoClassDefFoundError: com/sun/tools/javac/code/Symbol
addSbtPlugin("org.scala-debugger" % "sbt-jdi-tools" % "1.1.1")

libraryDependencies ++=
  List("com.thesamet.scalapb" %% "compilerplugin" % "0.10.10")
