package minimized

import scala.language.reflectiveCalls

class ReflectiveCall {
  // Reproduction for https://github.com/scalameta/scalameta/issues/2788
  val a =
    new {
      val b = 1
    }
  println(a.b)
}
