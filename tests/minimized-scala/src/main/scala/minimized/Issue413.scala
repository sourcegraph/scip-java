package minimized

trait Issue413 {
  val b: Int
}

class Issue413Subclass extends Issue413 {
  override val b = 10
}
