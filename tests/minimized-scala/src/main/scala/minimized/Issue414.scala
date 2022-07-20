package minimized

object Issue414 {
  trait A {
    def b(): Unit
  }
  val a: A =
    new A {
      override def b(): Unit = {
        print("Hello")
      }
    }
  println(a.b())
}
