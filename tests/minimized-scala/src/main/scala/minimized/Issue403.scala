package minimized

case class Issue403(value: String)

object Issue403App {
  def instantiations(): Unit = {
    println(Issue403("a").value)
    println(Issue403.apply("a").value)
    println(new Issue403("a").value)

    Issue403("a") match {
      case Issue403(value) =>
        println(value)
    }
  }
}
