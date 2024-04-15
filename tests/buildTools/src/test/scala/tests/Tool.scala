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

  def minimalSupportedJdk(tools: Seq[Tool]): Int =
    tools.map(_.support.minJava).minOption.getOrElse(8)

  def maximumSupportedJdk(tools: Seq[Tool]): Option[Int] =
    tools.flatMap(_.support.maxJava).minOption
  
  // See https://docs.gradle.org/current/userguide/compatibility.html
  sealed abstract class Gradle(version: String, support: JVMSupport)
      extends Tool("gradle", version, support)
  case object Gradle8 extends Gradle("8.7", atMostJava(21))
  case object Gradle7 extends Gradle("7.6.1", atMostJava(17))
  case object Gradle6 extends Gradle("6.7", atMostJava(11))
  case object Gradle5 extends Gradle("5.6.4", atMostJava(11))
  case object Gradle3 extends Gradle("3.3", atMostJava(8))
  case object Gradle2 extends Gradle("2.2.1", atMostJava(8))

  sealed abstract class SBT(version: String, support: JVMSupport)
      extends Tool("sbt", version, support)
  // See https://docs.scala-lang.org/overviews/jdk-compatibility/overview.html#build-tool-compatibility-table
  case object SBT15 extends SBT("1.5.2", atMostJava(17))
  case object SBT19 extends SBT("1.9.9", noRestrictions)

  sealed abstract class Scala(version: String, support: JVMSupport)
      extends Tool("scala", version, support)
  // See https://docs.scala-lang.org/overviews/jdk-compatibility/overview.html
  case object Scala213 extends Scala("2.13.13", noRestrictions)
  case object Scala212 extends Scala("2.12.19", noRestrictions)
  case object Scala2_12_12 extends Scala("2.12.12", atMostJava(11))
  case object Scala2_13_8 extends Scala("2.13.8", atMostJava(17))
  case object Scala211 extends Scala("2.11.9", atMostJava(11))
  case object Scala3 extends Scala("3.3.3", noRestrictions)

}
