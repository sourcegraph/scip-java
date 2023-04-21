package minimized

class Issue412 {
  val a: Int = 5
  val b: Long = a

  def a(b: Long): Unit = {
    println(b)
  }
  a(a)

}
