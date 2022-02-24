package minimized

case class Issue396(a: Int)
object Issue396App {
  println(Issue396)
  Issue396.apply(a = 42).copy(a = 41)
  Issue396.apply(a = 42).productElement(0)
  Issue396.apply(a = 42).productElementName(0)
}
