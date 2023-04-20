import sbt.{Compile, Def, File, _}
import sbt.Keys._
import sbt.plugins.JvmPlugin

import java.nio.file.Paths
import java.util
import java.util.Collections
import scala.util.Properties
import scala.sys.process.Process

/**
 * An sbt plugin that automatically adds the Java compiler to the boot classpath
 * when necessary.
 */
object JavaToolchainPlugin extends AutoPlugin {
  override def trigger = allRequirements
  override def requires = JvmPlugin

  object autoImport {
    lazy val javaToolchainVersion = settingKey[String](
      "The version of the Java"
    )
    lazy val javaToolchainJvmIndex = settingKey[Option[String]](
      "The JVM index to use"
    )
  }
  import autoImport._

  override lazy val projectSettings: Seq[Def.Setting[_]] = List(
    javacOptions ++=
      List(
        "-target",
        "1.8",
        "-source",
        "1.8",
        "-bootclasspath",
        java8Bootclasspath()
      ),
    (doc / javacOptions) --= List("-target", "1.8"),
    (doc / javacOptions) --= bootclasspathSettings(javaToolchainVersion.value),
    (doc / javacOptions) --= List("-g"),
    javacOptions ++= bootclasspathSettings(javaToolchainVersion.value),
    javaOptions ++= bootclasspathSettings(javaToolchainVersion.value),
    fork := true,
    javaToolchainVersion := "11",
    javaToolchainJvmIndex := None,
    javaHome :=
      Some(getJavaHome(javaToolchainVersion.value, javaToolchainJvmIndex.value))
  )

  /**
   * For Java 8, we need to manually add the Java compiler to the boot
   * classpath.
   *
   * Newer Java versions include the compiler by default.
   */
  private def bootclasspathSettings(version: String): List[String] = {
    val home = getJavaHome(version)
    val toolsJar: File = home / "lib" / "tools.jar"
    // The tools.jar file includes the bytecode for the Java compiler in the com.sun.source package.
    // The Java compiler is available by default in Java 9+, so we only need to add tools.jar to the
    // bootclasspath for Java 8.
    if (version == "8" && toolsJar.isFile) {
      List(s"-Xbootclasspath/p:$toolsJar")
    } else {
      List()
    }
  }

  private def java8Bootclasspath(): String = {
    (getJavaHome("8") / "jre" / "lib" / "rt.jar").toString
  }

  private val javaHomeCache: util.Map[String, File] = Collections
    .synchronizedMap(new util.HashMap[String, File]())
  private def getJavaHome(
      version: String,
      jvmIndex: Option[String] = None
  ): File = {
    javaHomeCache.computeIfAbsent(
      version,
      (v: String) => {
        val coursier = Paths.get("bin", "coursier")
        val index = jvmIndex
          .toList
          .flatMap(index => "--jvm-index" :: index :: Nil)
        val arguments =
          List(
            "java",
            "-jar",
            coursier.toString,
            "java-home",
            "--jvm",
            jvmName(v),
            "--architecture",
            jvmArchitecture
          ) ++ index

        new File(Process(arguments).!!.trim)
      }
    )
  }

  private def jvmName(version: String) =
    version match {
      case "8" if isAppleM1 =>
        "zulu:8" // the only Java 8 distribution available for Apple M1 is Zulu
      case _ =>
        version
    }

  private def isAppleM1 =
    scala.util.Properties.isMac && sys.props("os.arch") == "aarch64"

  private def jvmArchitecture: String =
    sys.props("os.arch") match {
      case "x86_64" =>
        "amd64"
      case _ if isAppleM1 =>
        "arm64"
      case other =>
        other
    }

}
