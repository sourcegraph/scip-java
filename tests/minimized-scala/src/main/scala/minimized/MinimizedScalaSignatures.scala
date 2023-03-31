package minimized

// format: off


case class MinimizedCaseClass(value: String) {
  def this() = this(value = "value")
}
object MinimizedCaseClass {
  def main(): Unit = {
    println(MinimizedCaseClass.apply(value = "value1").copy(value = "value2").value)
  }
}

trait MinimizedTrait[T] extends AutoCloseable {
  def add(e: T): T
  final def +(e: T): T = add(e)
}

class MinimizedScalaSignatures extends AutoCloseable with java.io.Serializable {
  def close(): Unit = ()
}

object MinimizedScalaSignatures extends MinimizedScalaSignatures with Comparable[Int] {
  @inline def annotation(x: Int): Int = x + 1
  @deprecated("2020-07-27") def annotationMessage(x: Int): Int = x + 1
  def compareTo(x: Int): Int = ???
  def identity[T](e: T): T = e
  def tuple(): (Int, String) = null
  def function0(): () => String = null
  def function1(): Int => String = null
  def function2(): (Int, String) => Unit = null
  def typeParameter(): Map[Int, String] = null
  def termParameter(a: Int, b: String): String = null
  def singletonType(e: String): e.type = e
  def thisType(): this.type = this
  def constantInt(): 1 = 1
  def constantString(): "string" = "string"
  def constantBoolean(): true = true
  def constantFloat(): 1.2f = 1.2f
  def constantChar(): 'a' = 'a'
  def structuralType(): { val x: Int; def foo(a: Int): String } = null
  def byNameType(a: => Int): Unit = ()
  def repeatedType(a: Int*): Unit = ()

  type TypeAlias = Int
  type ParameterizedTypeAlias[A] = () => A
  type ParameterizedTypeAlias2[A, B] = A => B
  type TypeBound
  type TypeUpperBound <: String
  type TypeLowerBound >: CharSequence
  type TypeLowerUpperBound >: String <: CharSequence 
}
