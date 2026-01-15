package tests

case class JVMSupport(minJava: Int, maxJava: Option[Int] = None) {
  def supports(javaVersion: Int) =
    javaVersion >= minJava &&
      (maxJava.isEmpty || maxJava.exists(javaVersion <= _))
}
object JVMSupport {
  val noRestrictions = JVMSupport(8, None)
  def atMostJava(j: Int) = JVMSupport(8, Some(j))
  def atLeastJava(j: Int) = JVMSupport(j, None)
  def javaBetween(min: Int, max: Int) = JVMSupport(min, Some(max))

}

sealed abstract class Tool(
    val label: String,
    val version: String,
    val support: JVMSupport
) extends Product
    with Serializable {
  def name = s"$label-$version"
}

object Tool {
  import JVMSupport._

  def minimumSupportedJdk(tools: Seq[Tool]): Int = tools
    .map(_.support.minJava)
    .minOption
    .getOrElse(8)

  def maximumSupportedJdk(tools: Seq[Tool]): Option[Int] =
    tools.flatMap(_.support.maxJava).minOption

  // See https://docs.gradle.org/current/userguide/compatibility.html
  // See https://endoflife.date/gradle for versions with active support
  sealed abstract class Gradle(version: String, support: JVMSupport)
      extends Tool("gradle", version, support)
  case object Gradle9 extends Gradle("9.2.1", javaBetween(17, 25))
  case object Gradle8 extends Gradle("8.14.3", javaBetween(8, 24))

  sealed abstract class SBT(version: String, support: JVMSupport)
      extends Tool("sbt", version, support)
  // See https://docs.scala-lang.org/overviews/jdk-compatibility/overview.html#build-tool-compatibility-table
  case object SBT112 extends SBT("1.11.7", noRestrictions)

  sealed abstract class Scala(version: String, support: JVMSupport)
      extends Tool("scala", version, support)
  // See https://docs.scala-lang.org/overviews/jdk-compatibility/overview.html
  case object Scala_Next extends Scala("3.7.4", noRestrictions)
  case object Scala_LTS extends Scala("3.3.7", noRestrictions)
  case object Scala2_13 extends Scala("2.13.18", noRestrictions)
  case object Scala2_11 extends Scala("2.11.12", noRestrictions)
  case object Scala2_10 extends Scala("2.10.7", noRestrictions)

  sealed abstract class Mill(version: String, support: JVMSupport)
      extends Tool("mill", version, support)
  // See https://docs.scala-lang.org/overviews/jdk-compatibility/overview.html#build-tool-compatibility-table
  case object Mill extends Mill("1.0.6", noRestrictions)

}
