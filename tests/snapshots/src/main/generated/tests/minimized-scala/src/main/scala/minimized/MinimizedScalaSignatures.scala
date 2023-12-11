package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

// format: off


case class MinimizedCaseClass(value: String) {
//         ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedCaseClass#
//                            display_name MinimizedCaseClass
//                            documentation ```scala\ncase class MinimizedCaseClass(value: String)\n```
//         __________________ synthetic_definition semanticdb maven . . minimized/MinimizedCaseClass#productElement().
//                            display_name productElement
//                            documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                            relationship is_definition semanticdb maven . . minimized/MinimizedCaseClass#
//                            relationship is_reference is_implementation semanticdb maven . . scala/Product#productElement().
//         __________________ synthetic_definition semanticdb maven . . minimized/MinimizedCaseClass#productElementName().
//                            display_name productElementName
//                            documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                            relationship is_definition semanticdb maven . . minimized/MinimizedCaseClass#
//                            relationship is_reference is_implementation semanticdb maven . . scala/Product#productElementName().
//         __________________ synthetic_definition semanticdb maven . . minimized/MinimizedCaseClass#copy().
//                            display_name copy
//                            documentation ```scala\ndef copy(value: String): MinimizedCaseClass\n```
//                            relationship is_definition semanticdb maven . . minimized/MinimizedCaseClass#
//                           ^ definition semanticdb maven . . minimized/MinimizedCaseClass#`<init>`().
//                             display_name <init>
//                             documentation ```scala\ndef this(value: String)\n```
//                            ^^^^^ definition semanticdb maven . . minimized/MinimizedCaseClass#value.
//                                  display_name value
//                                  documentation ```scala\nval value: String\n```
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass#`<init>`().(value)
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass#copy().(value)
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass.apply().(value)
//                            _____ synthetic_definition semanticdb maven . . minimized/MinimizedCaseClass#copy().(value)
//                                  display_name value
//                                  documentation ```scala\ndefault value: String \n```
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass#`<init>`().(value)
//                                  relationship is_reference is_definition semanticdb maven . . minimized/MinimizedCaseClass#value.
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass.apply().(value)
//                            _____ synthetic_definition semanticdb maven . . minimized/MinimizedCaseClass#`<init>`().(value)
//                                  display_name value
//                                  documentation ```scala\nvalue: String \n```
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass#copy().(value)
//                                  relationship is_reference is_definition semanticdb maven . . minimized/MinimizedCaseClass#value.
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass.apply().(value)
//                            _____ synthetic_definition semanticdb maven . . minimized/MinimizedCaseClass.apply().(value)
//                                  display_name value
//                                  documentation ```scala\nvalue: String \n```
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass#`<init>`().(value)
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass#copy().(value)
//                                  relationship is_reference is_definition semanticdb maven . . minimized/MinimizedCaseClass#value.
//                                   ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  def this() = this(value = "value")
//    ^^^^ definition semanticdb maven . . minimized/MinimizedCaseClass#`<init>`(+1).
//         display_name <init>
//         documentation ```scala\ndef this()\n```
//                 ^ reference semanticdb maven . . minimized/MinimizedCaseClass#`<init>`().
//                  ^^^^^ reference semanticdb maven . . minimized/MinimizedCaseClass#`<init>`().(value)
}
object MinimizedCaseClass {
//     ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedCaseClass.
//                        display_name MinimizedCaseClass
//                        documentation ```scala\nobject MinimizedCaseClass\n```
//                        relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass.apply().
//     __________________ synthetic_definition semanticdb maven . . minimized/MinimizedCaseClass.apply().
//                        display_name apply
//                        documentation ```scala\ndef apply(value: String): MinimizedCaseClass\n```
//                        relationship is_definition semanticdb maven . . minimized/MinimizedCaseClass.
  def main(): Unit = {
//    ^^^^ definition semanticdb maven . . minimized/MinimizedCaseClass.main().
//         display_name main
//         documentation ```scala\ndef main(): Unit\n```
//            ^^^^ reference semanticdb maven . . scala/Unit#
    println(MinimizedCaseClass.apply(value = "value1").copy(value = "value2").value)
//  ^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/MinimizedCaseClass.
//                             ^^^^^ reference semanticdb maven . . minimized/MinimizedCaseClass.apply().
//                                   ^^^^^ reference semanticdb maven . . minimized/MinimizedCaseClass.apply().(value)
//                                                     ^^^^ reference semanticdb maven . . minimized/MinimizedCaseClass#copy().
//                                                          ^^^^^ reference semanticdb maven . . minimized/MinimizedCaseClass#copy().(value)
//                                                                            ^^^^^ reference semanticdb maven . . minimized/MinimizedCaseClass#value.
  }
}

trait MinimizedTrait[T] extends AutoCloseable {
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedTrait#
//                   display_name MinimizedTrait
//                   documentation ```scala\ntrait MinimizedTrait[T]\n```
//                   ^ definition semanticdb maven . . minimized/MinimizedTrait#[T]
//                     display_name T
//                     documentation ```scala\nT\n```
//                              ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/AutoCloseable#
  def add(e: T): T
//    ^^^ definition semanticdb maven . . minimized/MinimizedTrait#add().
//        display_name add
//        documentation ```scala\ndef add(e: T): T\n```
//        ^ definition semanticdb maven . . minimized/MinimizedTrait#add().(e)
//          display_name e
//          documentation ```scala\ne: T \n```
//           ^ reference semanticdb maven . . minimized/MinimizedTrait#[T]
//               ^ reference semanticdb maven . . minimized/MinimizedTrait#[T]
  final def +(e: T): T = add(e)
//          ^ definition semanticdb maven . . minimized/MinimizedTrait#`+`().
//            display_name +
//            documentation ```scala\nfinal def +(e: T): T\n```
//            ^ definition semanticdb maven . . minimized/MinimizedTrait#`+`().(e)
//              display_name e
//              documentation ```scala\ne: T \n```
//               ^ reference semanticdb maven . . minimized/MinimizedTrait#[T]
//                   ^ reference semanticdb maven . . minimized/MinimizedTrait#[T]
//                       ^^^ reference semanticdb maven . . minimized/MinimizedTrait#add().
//                           ^ reference semanticdb maven . . minimized/MinimizedTrait#`+`().(e)
}

class MinimizedScalaSignatures extends AutoCloseable with java.io.Serializable {
//    ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures#
//                             display_name MinimizedScalaSignatures
//                             documentation ```scala\nclass MinimizedScalaSignatures\n```
//                             ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures#`<init>`().
//                               display_name <init>
//                               documentation ```scala\ndef this()\n```
//                                     ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/AutoCloseable#
//                                                   ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
//                                                        ^^^^ reference semanticdb maven . . java/
//                                                             ^^ reference semanticdb maven . . java/io/
//                                                                ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/Serializable#
  def close(): Unit = ()
//    ^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures#close().
//          display_name close
//          documentation ```scala\ndef close(): Unit\n```
//          relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/AutoCloseable#close().
//             ^^^^ reference semanticdb maven . . scala/Unit#
}

object MinimizedScalaSignatures extends MinimizedScalaSignatures with Comparable[Int] {
//     ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.
//                              display_name MinimizedScalaSignatures
//                              documentation ```scala\nobject MinimizedScalaSignatures\n```
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/MinimizedScalaSignatures#
//                                                               ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures#`<init>`().
//                                                                    ^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Comparable#
//                                                                               ^^^ reference semanticdb maven . . scala/Int#
  @inline def annotation(x: Int): Int = x + 1
// ^^^^^^ reference semanticdb maven . . scala/inline#
//        ^ reference semanticdb maven . . scala/inline#`<init>`().
//            ^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.annotation().
//                       display_name annotation
//                       documentation ```scala\n@inline\ndef annotation(x: Int): Int\n```
//                       ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.annotation().(x)
//                         display_name x
//                         documentation ```scala\nx: Int \n```
//                          ^^^ reference semanticdb maven . . scala/Int#
//                                ^^^ reference semanticdb maven . . scala/Int#
//                                      ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.annotation().(x)
//                                        ^ reference semanticdb maven . . scala/Int#`+`(+4).
  @deprecated("2020-07-27") def annotationMessage(x: Int): Int = x + 1
// ^^^^^^^^^^ reference semanticdb maven . . scala/deprecated#
//           ^ reference semanticdb maven . . scala/deprecated#`<init>`().
//                              ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.annotationMessage().
//                                                display_name annotationMessage
//                                                documentation ```scala\n@deprecated\ndef annotationMessage(x: Int): Int\n```
//                                                ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.annotationMessage().(x)
//                                                  display_name x
//                                                  documentation ```scala\nx: Int \n```
//                                                   ^^^ reference semanticdb maven . . scala/Int#
//                                                         ^^^ reference semanticdb maven . . scala/Int#
//                                                               ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.annotationMessage().(x)
//                                                                 ^ reference semanticdb maven . . scala/Int#`+`(+4).
  def compareTo(x: Int): Int = ???
//    ^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.compareTo().
//              display_name compareTo
//              documentation ```scala\ndef compareTo(x: Int): Int\n```
//              relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Comparable#compareTo().
//              ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.compareTo().(x)
//                display_name x
//                documentation ```scala\nx: Int \n```
//                 ^^^ reference semanticdb maven . . scala/Int#
//                       ^^^ reference semanticdb maven . . scala/Int#
//                             ^^^ reference semanticdb maven . . scala/Predef.`???`().
  def identity[T](e: T): T = e
//    ^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.identity().
//             display_name identity
//             documentation ```scala\ndef identity(e: T): T\n```
//             ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.identity().[T]
//               display_name T
//               documentation ```scala\nT\n```
//                ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.identity().(e)
//                  display_name e
//                  documentation ```scala\ne: T \n```
//                   ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.identity().[T]
//                       ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.identity().[T]
//                           ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.identity().(e)
  def tuple(): (Int, String) = null
//    ^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.tuple().
//          display_name tuple
//          documentation ```scala\ndef tuple(): (Int, String)\n```
//              ^^^ reference semanticdb maven . . scala/Int#
//                   ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  def function0(): () => String = null
//    ^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.function0().
//              display_name function0
//              documentation ```scala\ndef function0(): String=> String\n```
//                       ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  def function1(): Int => String = null
//    ^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.function1().
//              display_name function1
//              documentation ```scala\ndef function1(): (Int) => String\n```
//                 ^^^ reference semanticdb maven . . scala/Int#
//                        ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  def function2(): (Int, String) => Unit = null
//    ^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.function2().
//              display_name function2
//              documentation ```scala\ndef function2(): (Int, String) => Unit\n```
//                  ^^^ reference semanticdb maven . . scala/Int#
//                       ^^^^^^ reference semanticdb maven . . scala/Predef.String#
//                                  ^^^^ reference semanticdb maven . . scala/Unit#
  def typeParameter(): Map[Int, String] = null
//    ^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.typeParameter().
//                  display_name typeParameter
//                  documentation ```scala\ndef typeParameter(): Map[Int, String]\n```
//                     ^^^ reference semanticdb maven . . scala/Predef.Map#
//                         ^^^ reference semanticdb maven . . scala/Int#
//                              ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  def termParameter(a: Int, b: String): String = null
//    ^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.termParameter().
//                  display_name termParameter
//                  documentation ```scala\ndef termParameter(a: Int, b: String): String\n```
//                  ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.termParameter().(a)
//                    display_name a
//                    documentation ```scala\na: Int \n```
//                     ^^^ reference semanticdb maven . . scala/Int#
//                          ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.termParameter().(b)
//                            display_name b
//                            documentation ```scala\nb: String \n```
//                             ^^^^^^ reference semanticdb maven . . scala/Predef.String#
//                                      ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  def singletonType(e: String): e.type = e
//    ^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.singletonType().
//                  display_name singletonType
//                  documentation ```scala\ndef singletonType(e: String): e.type\n```
//                  ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.singletonType().(e)
//                    display_name e
//                    documentation ```scala\ne: String \n```
//                     ^^^^^^ reference semanticdb maven . . scala/Predef.String#
//                              ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.singletonType().(e)
//                                       ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.singletonType().(e)
  def thisType(): this.type = this
//    ^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.thisType().
//             display_name thisType
//             documentation ```scala\ndef thisType(): this.type\n```
  def constantInt(): 1 = 1
//    ^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.constantInt().
//                display_name constantInt
//                documentation ```scala\ndef constantInt(): 1\n```
  def constantString(): "string" = "string"
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.constantString().
//                   display_name constantString
//                   documentation ```scala\ndef constantString(): "string"\n```
  def constantBoolean(): true = true
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.constantBoolean().
//                    display_name constantBoolean
//                    documentation ```scala\ndef constantBoolean(): true\n```
  def constantFloat(): 1.2f = 1.2f
//    ^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.constantFloat().
//                  display_name constantFloat
//                  documentation ```scala\ndef constantFloat(): 1.2f\n```
  def constantChar(): 'a' = 'a'
//    ^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.constantChar().
//                 display_name constantChar
//                 documentation ```scala\ndef constantChar(): 'a'\n```
  def structuralType(): { val x: Int; def foo(a: Int): String } = null
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.structuralType().
//                   display_name structuralType
//                   documentation ```scala\ndef structuralType(): { val x: Int; def foo(a: Int): String }\n```
//                            ^ definition local 1
//                              display_name x
//                              documentation ```scala\nval x: Int\n```
//                               ^^^ reference semanticdb maven . . scala/Int#
//                                        ^^^ definition local 2
//                                            display_name foo
//                                            documentation ```scala\ndef foo(a: Int): String\n```
//                                            ^ definition local 3
//                                              display_name a
//                                              documentation ```scala\na: Int \n```
//                                               ^^^ reference semanticdb maven . . scala/Int#
//                                                     ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  def byNameType(a: => Int): Unit = ()
//    ^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.byNameType().
//               display_name byNameType
//               documentation ```scala\ndef byNameType(a: => Int): Unit\n```
//               ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.byNameType().(a)
//                 display_name a
//                 documentation ```scala\na: => Int \n```
//                     ^^^ reference semanticdb maven . . scala/Int#
//                           ^^^^ reference semanticdb maven . . scala/Unit#
  def repeatedType(a: Int*): Unit = ()
//    ^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.repeatedType().
//                 display_name repeatedType
//                 documentation ```scala\ndef repeatedType(a: Int*): Unit\n```
//                 ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.repeatedType().(a)
//                   display_name a
//                   documentation ```scala\na: Int* \n```
//                    ^^^ reference semanticdb maven . . scala/Int#
//                           ^^^^ reference semanticdb maven . . scala/Unit#

  type TypeAlias = Int
//     ^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.TypeAlias#
//               display_name TypeAlias
//               documentation ```scala\ntype TypeAlias >: Int <: Int\n```
//                 ^^^ reference semanticdb maven . . scala/Int#
  type ParameterizedTypeAlias[A] = () => A
//     ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias#
//                            display_name ParameterizedTypeAlias
//                            documentation ```scala\ntype ParameterizedTypeAlias >: A=> A <: A=> A\n```
//                            ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias#[A]
//                              display_name A
//                              documentation ```scala\nA\n```
//                                       ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias#[A]
  type ParameterizedTypeAlias2[A, B] = A => B
//     ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias2#
//                             display_name ParameterizedTypeAlias2
//                             documentation ```scala\ntype ParameterizedTypeAlias2 >: (A) => B <: (A) => B\n```
//                             ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias2#[A]
//                               display_name A
//                               documentation ```scala\nA\n```
//                                ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias2#[B]
//                                  display_name B
//                                  documentation ```scala\nB\n```
//                                     ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias2#[A]
//                                          ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias2#[B]
  type TypeBound
//     ^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.TypeBound#
//               display_name TypeBound
//               documentation ```scala\ntype TypeBound\n```
  type TypeUpperBound <: String
//     ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.TypeUpperBound#
//                    display_name TypeUpperBound
//                    documentation ```scala\ntype TypeUpperBound <: String\n```
//                       ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  type TypeLowerBound >: CharSequence
//     ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.TypeLowerBound#
//                    display_name TypeLowerBound
//                    documentation ```scala\ntype TypeLowerBound >: CharSequence\n```
//                       ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
  type TypeLowerUpperBound >: String <: CharSequence 
//     ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.TypeLowerUpperBound#
//                         display_name TypeLowerUpperBound
//                         documentation ```scala\ntype TypeLowerUpperBound >: String <: CharSequence\n```
//                            ^^^^^^ reference semanticdb maven . . scala/Predef.String#
//                                      ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
}
