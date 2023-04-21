package minimized

object Issue414 {
  trait A {
    def b(): Unit
  }
  val a1 =
    new A {
      override def b(): Unit = {
        print("Hello")
      }
    }
  val a2: A = a1
  println(a1.b())
  println(a2.b())
}
