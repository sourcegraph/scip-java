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
    javacOptions ++= List("--release", "11"),
    (doc / javacOptions) --= List("--release", "11"),
    (doc / javacOptions) --= List("-g"),
    fork := true,
    javaToolchainVersion := "11",
    javaToolchainJvmIndex := None,
    javaHome :=
      Some(getJavaHome(javaToolchainVersion.value, javaToolchainJvmIndex.value))
  )

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
          List("java", "-jar", coursier.toString, "java-home", "--jvm", v) ++
            index

        new File(Process(arguments).!!.trim)
      }
    )
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
