addSbtPlugin("org.xerial.sbt" % "sbt-pack" % "0.14")
addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.11.1")
addSbtPlugin("com.thesamet" % "sbt-protoc" % "1.0.6")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.15.0")
addSbtPlugin("org.jetbrains.scala" % "sbt-kotlin-plugin" % "3.1.6")
addSbtPlugin("com.github.sbt.junit" % "sbt-jupiter-interface" % "0.15.1")

ThisBuild / libraryDependencySchemes ++=
  Seq("org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always)
