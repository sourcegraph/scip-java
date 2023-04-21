package minimized

trait Issue413 {
  val b: Int
  val c: Int
}
object Issue413 {
  def main(): Unit = {
    val a = new Issue413Subclass()
    val b: Issue413 = a
    println(a.b + b.b)
  }
}

class Issue413Subclass extends Issue413 {
  override val b = 10
  override val c = 10
}
