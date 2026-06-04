package tests

case class JVMSupport(minJava: Int, maxJava: Option[Int] = None) {
  def supports(javaVersion: Int) =
    javaVersion >= minJava &&
      (maxJava.isEmpty || maxJava.exists(javaVersion <= _))
}
object JVMSupport {
  val noRestrictions = JVMSupport(11, None)
  def atMostJava(j: Int) = JVMSupport(11, Some(j))
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
    .getOrElse(11)

  def maximumSupportedJdk(tools: Seq[Tool]): Option[Int] =
    tools.flatMap(_.support.maxJava).minOption

  // See https://docs.gradle.org/current/userguide/compatibility.html
  sealed abstract class Gradle(version: String, support: JVMSupport)
      extends Tool("gradle", version, support)
  case object Gradle8 extends Gradle("8.10", atMostJava(21))

}
