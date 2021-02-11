import sbt.{Compile, Def, File, _}
import sbt.Keys._
import sbt.plugins.JvmPlugin

import scala.util.Properties

/**
 * An sbt plugin that automatically adds the Java compiler to the boot classpath
 * when necessary.
 */
object JavacBootClasspathPlugin extends AutoPlugin {
  override def trigger = allRequirements
  override def requires = JvmPlugin

  lazy val configSettings = List(
    javacOptions ++= List("-target", "1.8", "-source", "1.8"),
    javacOptions.in(doc) --= List("-target", "1.8"),
    javaHome := Some(javaHomeDirectory),
    javacOptions ++= bootclasspathSettings,
    javaOptions ++= bootclasspathSettings
  )

  override lazy val projectSettings: Seq[Def.Setting[_]] =
    List(Compile, Test).flatMap(c => inConfig(c)(configSettings)) ++
      List(fork := true)

  /**
   * Returns the local path to tools.jar, which contains the Java compiler
   * implementation.
   */
  private def toolsJar: File = javaHomeDirectory / "lib" / "tools.jar"
  private def javaHomeDirectory: File = {
    val home = file(System.getProperty("java.home"))
    if (Properties.isJavaAtLeast("8"))
      home.getParentFile
    else
      home
  }

  private def bootclasspathSettings: List[String] = {
    // The tools.jar file includes the bytecode for the Java compiler in the com.sun.source package.
    // The Java compiler is available by default in Java 9+, so we only need to add tools.jar to the
    // bootclasspath for Java 8.
    if (
      !Properties.isJavaAtLeast("9") && Properties.isJavaAtLeast("8") &&
      toolsJar.isFile
    ) {
      List(s"-Xbootclasspath/p:$toolsJar")
    } else {
      List()
    }

  }
}
