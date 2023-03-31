package minimized
//      ^^^^^^^^^ definition minimized/

// format: off


case class MinimizedCaseClass(value: String) {
//         ^^^^^^^^^^^^^^^^^^ definition minimized/MinimizedCaseClass# case class MinimizedCaseClass(value: String)
//                            definition minimized/MinimizedCaseClass#`<init>`(). def this(value: String)
//                            ^^^^^ definition minimized/MinimizedCaseClass#value. val value: String
//                                   ^^^^^^ reference scala/Predef.String#
  def this() = this(value = "value")
//    ^^^^ definition minimized/MinimizedCaseClass#`<init>`(+1). def this()
//                  reference minimized/MinimizedCaseClass#`<init>`().
//                  ^^^^^ reference minimized/MinimizedCaseClass#`<init>`().(value)
}
object MinimizedCaseClass {
//     ^^^^^^^^^^^^^^^^^^ definition minimized/MinimizedCaseClass. object MinimizedCaseClass
  def main(): Unit = {
//    ^^^^ definition minimized/MinimizedCaseClass.main(). def main(): Unit
//            ^^^^ reference scala/Unit#
    println(MinimizedCaseClass.apply(value = "value1").copy(value = "value2").value)
//  ^^^^^^^ reference scala/Predef.println(+1).
//          ^^^^^^^^^^^^^^^^^^ reference minimized/MinimizedCaseClass.
//                             ^^^^^ reference minimized/MinimizedCaseClass.apply().
//                                   ^^^^^ reference minimized/MinimizedCaseClass.apply().(value)
//                                                     ^^^^ reference minimized/MinimizedCaseClass#copy().
//                                                          ^^^^^ reference minimized/MinimizedCaseClass#copy().(value)
//                                                                            ^^^^^ reference minimized/MinimizedCaseClass#value.
  }
}

trait MinimizedTrait[T] extends AutoCloseable {
//    ^^^^^^^^^^^^^^ definition minimized/MinimizedTrait# trait MinimizedTrait[T]
//                   ^ definition minimized/MinimizedTrait#[T] T
//                              ^^^^^^^^^^^^^ reference java/lang/AutoCloseable#
  def add(e: T): T
//    ^^^ definition minimized/MinimizedTrait#add(). def add(e: T): T
//        ^ definition minimized/MinimizedTrait#add().(e) e: T
//           ^ reference minimized/MinimizedTrait#[T]
//               ^ reference minimized/MinimizedTrait#[T]
  final def +(e: T): T = add(e)
//          ^ definition minimized/MinimizedTrait#`+`(). final def +(e: T): T
//            ^ definition minimized/MinimizedTrait#`+`().(e) e: T
//               ^ reference minimized/MinimizedTrait#[T]
//                   ^ reference minimized/MinimizedTrait#[T]
//                       ^^^ reference minimized/MinimizedTrait#add().
//                           ^ reference minimized/MinimizedTrait#`+`().(e)
}

class MinimizedScalaSignatures extends AutoCloseable with java.io.Serializable {
//    ^^^^^^^^^^^^^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures# class MinimizedScalaSignatures
//                              definition minimized/MinimizedScalaSignatures#`<init>`(). def this()
//                                     ^^^^^^^^^^^^^ reference java/lang/AutoCloseable#
//                                                    reference java/lang/Object#`<init>`().
//                                                        ^^^^ reference java/
//                                                             ^^ reference java/io/
//                                                                ^^^^^^^^^^^^ reference java/io/Serializable#
  def close(): Unit = ()
//    ^^^^^ definition minimized/MinimizedScalaSignatures#close(). def close(): Unit
//             ^^^^ reference scala/Unit#
}

object MinimizedScalaSignatures extends MinimizedScalaSignatures with Comparable[Int] {
//     ^^^^^^^^^^^^^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures. object MinimizedScalaSignatures
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^ reference minimized/MinimizedScalaSignatures#
//                                                                reference minimized/MinimizedScalaSignatures#`<init>`().
//                                                                    ^^^^^^^^^^ reference java/lang/Comparable#
//                                                                               ^^^ reference scala/Int#
  @inline def annotation(x: Int): Int = x + 1
// ^^^^^^ reference scala/inline#
//         reference scala/inline#`<init>`().
//            ^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.annotation(). @inline def annotation(x: Int): Int
//                       ^ definition minimized/MinimizedScalaSignatures.annotation().(x) x: Int
//                          ^^^ reference scala/Int#
//                                ^^^ reference scala/Int#
//                                      ^ reference minimized/MinimizedScalaSignatures.annotation().(x)
//                                        ^ reference scala/Int#`+`(+4).
  @deprecated("2020-07-27") def annotationMessage(x: Int): Int = x + 1
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
//                              ^^^^^^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.annotationMessage(). @deprecated def annotationMessage(x: Int): Int
//                                                ^ definition minimized/MinimizedScalaSignatures.annotationMessage().(x) x: Int
//                                                   ^^^ reference scala/Int#
//                                                         ^^^ reference scala/Int#
//                                                               ^ reference minimized/MinimizedScalaSignatures.annotationMessage().(x)
//                                                                 ^ reference scala/Int#`+`(+4).
  def compareTo(x: Int): Int = ???
//    ^^^^^^^^^ definition minimized/MinimizedScalaSignatures.compareTo(). def compareTo(x: Int): Int
//              ^ definition minimized/MinimizedScalaSignatures.compareTo().(x) x: Int
//                 ^^^ reference scala/Int#
//                       ^^^ reference scala/Int#
//                             ^^^ reference scala/Predef.`???`().
  def identity[T](e: T): T = e
//    ^^^^^^^^ definition minimized/MinimizedScalaSignatures.identity(). def identity(e: T): T
//             ^ definition minimized/MinimizedScalaSignatures.identity().[T] T
//                ^ definition minimized/MinimizedScalaSignatures.identity().(e) e: T
//                   ^ reference minimized/MinimizedScalaSignatures.identity().[T]
//                       ^ reference minimized/MinimizedScalaSignatures.identity().[T]
//                           ^ reference minimized/MinimizedScalaSignatures.identity().(e)
  def tuple(): (Int, String) = null
//    ^^^^^ definition minimized/MinimizedScalaSignatures.tuple(). def tuple(): (Int, String)
//              ^^^ reference scala/Int#
//                   ^^^^^^ reference scala/Predef.String#
  def function0(): () => String = null
//    ^^^^^^^^^ definition minimized/MinimizedScalaSignatures.function0(). def function0(): String=> String
//                       ^^^^^^ reference scala/Predef.String#
  def function1(): Int => String = null
//    ^^^^^^^^^ definition minimized/MinimizedScalaSignatures.function1(). def function1(): (Int) => String
//                 ^^^ reference scala/Int#
//                        ^^^^^^ reference scala/Predef.String#
  def function2(): (Int, String) => Unit = null
//    ^^^^^^^^^ definition minimized/MinimizedScalaSignatures.function2(). def function2(): (Int, String) => Unit
//                  ^^^ reference scala/Int#
//                       ^^^^^^ reference scala/Predef.String#
//                                  ^^^^ reference scala/Unit#
  def typeParameter(): Map[Int, String] = null
//    ^^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.typeParameter(). def typeParameter(): Map[Int, String]
//                     ^^^ reference scala/Predef.Map#
//                         ^^^ reference scala/Int#
//                              ^^^^^^ reference scala/Predef.String#
  def termParameter(a: Int, b: String): String = null
//    ^^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.termParameter(). def termParameter(a: Int, b: String): String
//                  ^ definition minimized/MinimizedScalaSignatures.termParameter().(a) a: Int
//                     ^^^ reference scala/Int#
//                          ^ definition minimized/MinimizedScalaSignatures.termParameter().(b) b: String
//                             ^^^^^^ reference scala/Predef.String#
//                                      ^^^^^^ reference scala/Predef.String#
  def singletonType(e: String): e.type = e
//    ^^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.singletonType(). def singletonType(e: String): e.type
//                  ^ definition minimized/MinimizedScalaSignatures.singletonType().(e) e: String
//                     ^^^^^^ reference scala/Predef.String#
//                              ^ reference minimized/MinimizedScalaSignatures.singletonType().(e)
//                                       ^ reference minimized/MinimizedScalaSignatures.singletonType().(e)
  def thisType(): this.type = this
//    ^^^^^^^^ definition minimized/MinimizedScalaSignatures.thisType(). def thisType(): this.type
  def constantInt(): 1 = 1
//    ^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.constantInt(). def constantInt(): 1
  def constantString(): "string" = "string"
//    ^^^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.constantString(). def constantString(): "string"
  def constantBoolean(): true = true
//    ^^^^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.constantBoolean(). def constantBoolean(): true
  def constantFloat(): 1.2f = 1.2f
//    ^^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.constantFloat(). def constantFloat(): 1.2f
  def constantChar(): 'a' = 'a'
//    ^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.constantChar(). def constantChar(): 'a'
  def structuralType(): { val x: Int; def foo(a: Int): String } = null
//    ^^^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.structuralType(). def structuralType(): { val x: Int; def foo(a: Int): String }
//                            ^ definition local1 val x: Int
//                               ^^^ reference scala/Int#
//                                        ^^^ definition local2 def foo(a: Int): String
//                                            ^ definition local3 a: Int
//                                               ^^^ reference scala/Int#
//                                                     ^^^^^^ reference scala/Predef.String#
  def byNameType(a: => Int): Unit = ()
//    ^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.byNameType(). def byNameType(a: => Int): Unit
//               ^ definition minimized/MinimizedScalaSignatures.byNameType().(a) a: => Int
//                     ^^^ reference scala/Int#
//                           ^^^^ reference scala/Unit#
  def repeatedType(a: Int*): Unit = ()
//    ^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.repeatedType(). def repeatedType(a: Int*): Unit
//                 ^ definition minimized/MinimizedScalaSignatures.repeatedType().(a) a: Int*
//                    ^^^ reference scala/Int#
//                           ^^^^ reference scala/Unit#

  type TypeAlias = Int
//     ^^^^^^^^^ definition minimized/MinimizedScalaSignatures.TypeAlias# type TypeAlias >: Int <: Int
//                 ^^^ reference scala/Int#
  type ParameterizedTypeAlias[A] = () => A
//     ^^^^^^^^^^^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.ParameterizedTypeAlias# type ParameterizedTypeAlias >: A=> A <: A=> A
//                            ^ definition minimized/MinimizedScalaSignatures.ParameterizedTypeAlias#[A] A
//                                       ^ reference minimized/MinimizedScalaSignatures.ParameterizedTypeAlias#[A]
  type ParameterizedTypeAlias2[A, B] = A => B
//     ^^^^^^^^^^^^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.ParameterizedTypeAlias2# type ParameterizedTypeAlias2 >: (A) => B <: (A) => B
//                             ^ definition minimized/MinimizedScalaSignatures.ParameterizedTypeAlias2#[A] A
//                                ^ definition minimized/MinimizedScalaSignatures.ParameterizedTypeAlias2#[B] B
//                                     ^ reference minimized/MinimizedScalaSignatures.ParameterizedTypeAlias2#[A]
//                                          ^ reference minimized/MinimizedScalaSignatures.ParameterizedTypeAlias2#[B]
  type TypeBound
//     ^^^^^^^^^ definition minimized/MinimizedScalaSignatures.TypeBound# type TypeBound
  type TypeUpperBound <: String
//     ^^^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.TypeUpperBound# type TypeUpperBound <: String
//                       ^^^^^^ reference scala/Predef.String#
  type TypeLowerBound >: CharSequence
//     ^^^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.TypeLowerBound# type TypeLowerBound >: CharSequence
//                       ^^^^^^^^^^^^ reference java/lang/CharSequence#
  type TypeLowerUpperBound >: String <: CharSequence 
//     ^^^^^^^^^^^^^^^^^^^ definition minimized/MinimizedScalaSignatures.TypeLowerUpperBound# type TypeLowerUpperBound >: String <: CharSequence
//                            ^^^^^^ reference scala/Predef.String#
//                                      ^^^^^^^^^^^^ reference java/lang/CharSequence#
}
