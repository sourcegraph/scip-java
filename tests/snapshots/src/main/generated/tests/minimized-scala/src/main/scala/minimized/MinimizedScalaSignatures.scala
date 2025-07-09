package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

// format: off


case class MinimizedCaseClass(value: String) {
//         ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedCaseClass#
//                            display_name MinimizedCaseClass
//                            signature_documentation scala case class MinimizedCaseClass(value: String)
//                            kind Class
//         __________________ synthetic_definition semanticdb maven . . minimized/MinimizedCaseClass#productElement().
//                            display_name productElement
//                            signature_documentation scala def productElement(x$1: Int): Any
//                            kind Method
//                            relationship is_definition semanticdb maven . . minimized/MinimizedCaseClass#
//                            relationship is_reference is_implementation semanticdb maven . . scala/Product#productElement().
//         __________________ synthetic_definition semanticdb maven . . minimized/MinimizedCaseClass#productElementName().
//                            display_name productElementName
//                            signature_documentation scala def productElementName(x$1: Int): String
//                            kind Method
//                            relationship is_definition semanticdb maven . . minimized/MinimizedCaseClass#
//                            relationship is_reference is_implementation semanticdb maven . . scala/Product#productElementName().
//         __________________ synthetic_definition semanticdb maven . . minimized/MinimizedCaseClass#copy().
//                            display_name copy
//                            signature_documentation scala def copy(value: String): MinimizedCaseClass
//                            kind Method
//                            relationship is_definition semanticdb maven . . minimized/MinimizedCaseClass#
//                           ^ definition semanticdb maven . . minimized/MinimizedCaseClass#`<init>`().
//                             display_name <init>
//                             signature_documentation scala def this(value: String)
//                             kind Constructor
//                            ^^^^^ definition semanticdb maven . . minimized/MinimizedCaseClass#value.
//                                  display_name value
//                                  signature_documentation scala val value: String
//                                  kind Method
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass#`<init>`().(value)
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass#copy().(value)
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass.apply().(value)
//                            _____ synthetic_definition semanticdb maven . . minimized/MinimizedCaseClass#copy().(value)
//                                  display_name value
//                                  signature_documentation scala default value: String 
//                                  kind Parameter
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass#`<init>`().(value)
//                                  relationship is_reference is_definition semanticdb maven . . minimized/MinimizedCaseClass#value.
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass.apply().(value)
//                            _____ synthetic_definition semanticdb maven . . minimized/MinimizedCaseClass#`<init>`().(value)
//                                  display_name value
//                                  signature_documentation scala value: String 
//                                  kind Parameter
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass#copy().(value)
//                                  relationship is_reference is_definition semanticdb maven . . minimized/MinimizedCaseClass#value.
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass.apply().(value)
//                            _____ synthetic_definition semanticdb maven . . minimized/MinimizedCaseClass.apply().(value)
//                                  display_name value
//                                  signature_documentation scala value: String 
//                                  kind Parameter
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass#`<init>`().(value)
//                                  relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass#copy().(value)
//                                  relationship is_reference is_definition semanticdb maven . . minimized/MinimizedCaseClass#value.
//                                   ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  def this() = this(value = "value")
//    ^^^^ definition semanticdb maven . . minimized/MinimizedCaseClass#`<init>`(+1).
//         display_name <init>
//         signature_documentation scala def this()
//         kind Constructor
//                 ^ reference semanticdb maven . . minimized/MinimizedCaseClass#`<init>`().
//                  ^^^^^ reference semanticdb maven . . minimized/MinimizedCaseClass#`<init>`().(value)
}
object MinimizedCaseClass {
//     ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedCaseClass.
//                        display_name MinimizedCaseClass
//                        signature_documentation scala object MinimizedCaseClass
//                        kind Object
//                        relationship is_reference semanticdb maven . . minimized/MinimizedCaseClass.apply().
//     __________________ synthetic_definition semanticdb maven . . minimized/MinimizedCaseClass.apply().
//                        display_name apply
//                        signature_documentation scala def apply(value: String): MinimizedCaseClass
//                        kind Method
//                        relationship is_definition semanticdb maven . . minimized/MinimizedCaseClass.
  def main(): Unit = {
//    ^^^^ definition semanticdb maven . . minimized/MinimizedCaseClass.main().
//         display_name main
//         signature_documentation scala def main(): Unit
//         kind Method
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
//                   signature_documentation scala trait MinimizedTrait[T]
//                   kind Trait
//                   ^ definition semanticdb maven . . minimized/MinimizedTrait#[T]
//                     display_name T
//                     signature_documentation scala T
//                     kind TypeParameter
//                              ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/AutoCloseable#
  def add(e: T): T
//    ^^^ definition semanticdb maven . . minimized/MinimizedTrait#add().
//        display_name add
//        signature_documentation scala def add(e: T): T
//        kind AbstractMethod
//        ^ definition semanticdb maven . . minimized/MinimizedTrait#add().(e)
//          display_name e
//          signature_documentation scala e: T 
//          kind Parameter
//           ^ reference semanticdb maven . . minimized/MinimizedTrait#[T]
//               ^ reference semanticdb maven . . minimized/MinimizedTrait#[T]
  final def +(e: T): T = add(e)
//          ^ definition semanticdb maven . . minimized/MinimizedTrait#`+`().
//            display_name +
//            signature_documentation scala final def +(e: T): T
//            kind Method
//            ^ definition semanticdb maven . . minimized/MinimizedTrait#`+`().(e)
//              display_name e
//              signature_documentation scala e: T 
//              kind Parameter
//               ^ reference semanticdb maven . . minimized/MinimizedTrait#[T]
//                   ^ reference semanticdb maven . . minimized/MinimizedTrait#[T]
//                       ^^^ reference semanticdb maven . . minimized/MinimizedTrait#add().
//                           ^ reference semanticdb maven . . minimized/MinimizedTrait#`+`().(e)
}

class MinimizedScalaSignatures extends AutoCloseable with java.io.Serializable {
//    ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures#
//                             display_name MinimizedScalaSignatures
//                             signature_documentation scala class MinimizedScalaSignatures
//                             kind Class
//                             ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures#`<init>`().
//                               display_name <init>
//                               signature_documentation scala def this()
//                               kind Constructor
//                                     ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/AutoCloseable#
//                                                   ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
//                                                        ^^^^ reference semanticdb maven . . java/
//                                                             ^^ reference semanticdb maven . . java/io/
//                                                                ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/Serializable#
  def close(): Unit = ()
//    ^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures#close().
//          display_name close
//          signature_documentation scala def close(): Unit
//          kind Method
//          relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/AutoCloseable#close().
//             ^^^^ reference semanticdb maven . . scala/Unit#
}

object MinimizedScalaSignatures extends MinimizedScalaSignatures with Comparable[Int] {
//     ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.
//                              display_name MinimizedScalaSignatures
//                              signature_documentation scala object MinimizedScalaSignatures
//                              kind Object
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/MinimizedScalaSignatures#
//                                                               ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures#`<init>`().
//                                                                    ^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Comparable#
//                                                                               ^^^ reference semanticdb maven . . scala/Int#
  @inline def annotation(x: Int): Int = x + 1
// ^^^^^^ reference semanticdb maven . . scala/inline#
//        ^ reference semanticdb maven . . scala/inline#`<init>`().
//            ^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.annotation().
//                       display_name annotation
//                       signature_documentation scala @inline\ndef annotation(x: Int): Int
//                       kind Method
//                       ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.annotation().(x)
//                         display_name x
//                         signature_documentation scala x: Int 
//                         kind Parameter
//                          ^^^ reference semanticdb maven . . scala/Int#
//                                ^^^ reference semanticdb maven . . scala/Int#
//                                      ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.annotation().(x)
//                                        ^ reference semanticdb maven . . scala/Int#`+`(+4).
  @deprecated("2020-07-27") def annotationMessage(x: Int): Int = x + 1
// ^^^^^^^^^^ reference semanticdb maven . . scala/deprecated#
//           ^ reference semanticdb maven . . scala/deprecated#`<init>`().
//                              ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.annotationMessage().
//                                                display_name annotationMessage
//                                                signature_documentation scala @deprecated\ndef annotationMessage(x: Int): Int
//                                                kind Method
//                                                ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.annotationMessage().(x)
//                                                  display_name x
//                                                  signature_documentation scala x: Int 
//                                                  kind Parameter
//                                                   ^^^ reference semanticdb maven . . scala/Int#
//                                                         ^^^ reference semanticdb maven . . scala/Int#
//                                                               ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.annotationMessage().(x)
//                                                                 ^ reference semanticdb maven . . scala/Int#`+`(+4).
  def compareTo(x: Int): Int = ???
//    ^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.compareTo().
//              display_name compareTo
//              signature_documentation scala def compareTo(x: Int): Int
//              kind Method
//              relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Comparable#compareTo().
//              ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.compareTo().(x)
//                display_name x
//                signature_documentation scala x: Int 
//                kind Parameter
//                 ^^^ reference semanticdb maven . . scala/Int#
//                       ^^^ reference semanticdb maven . . scala/Int#
//                             ^^^ reference semanticdb maven . . scala/Predef.`???`().
  def identity[T](e: T): T = e
//    ^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.identity().
//             display_name identity
//             signature_documentation scala def identity(e: T): T
//             kind Method
//             ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.identity().[T]
//               display_name T
//               signature_documentation scala T
//               kind TypeParameter
//                ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.identity().(e)
//                  display_name e
//                  signature_documentation scala e: T 
//                  kind Parameter
//                   ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.identity().[T]
//                       ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.identity().[T]
//                           ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.identity().(e)
  def tuple(): (Int, String) = null
//    ^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.tuple().
//          display_name tuple
//          signature_documentation scala def tuple(): (Int, String)
//          kind Method
//              ^^^ reference semanticdb maven . . scala/Int#
//                   ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  def function0(): () => String = null
//    ^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.function0().
//              display_name function0
//              signature_documentation scala def function0(): String=> String
//              kind Method
//                       ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  def function1(): Int => String = null
//    ^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.function1().
//              display_name function1
//              signature_documentation scala def function1(): (Int) => String
//              kind Method
//                 ^^^ reference semanticdb maven . . scala/Int#
//                        ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  def function2(): (Int, String) => Unit = null
//    ^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.function2().
//              display_name function2
//              signature_documentation scala def function2(): (Int, String) => Unit
//              kind Method
//                  ^^^ reference semanticdb maven . . scala/Int#
//                       ^^^^^^ reference semanticdb maven . . scala/Predef.String#
//                                  ^^^^ reference semanticdb maven . . scala/Unit#
  def typeParameter(): Map[Int, String] = null
//    ^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.typeParameter().
//                  display_name typeParameter
//                  signature_documentation scala def typeParameter(): Map[Int, String]
//                  kind Method
//                     ^^^ reference semanticdb maven . . scala/Predef.Map#
//                         ^^^ reference semanticdb maven . . scala/Int#
//                              ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  def termParameter(a: Int, b: String): String = null
//    ^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.termParameter().
//                  display_name termParameter
//                  signature_documentation scala def termParameter(a: Int, b: String): String
//                  kind Method
//                  ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.termParameter().(a)
//                    display_name a
//                    signature_documentation scala a: Int 
//                    kind Parameter
//                     ^^^ reference semanticdb maven . . scala/Int#
//                          ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.termParameter().(b)
//                            display_name b
//                            signature_documentation scala b: String 
//                            kind Parameter
//                             ^^^^^^ reference semanticdb maven . . scala/Predef.String#
//                                      ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  def singletonType(e: String): e.type = e
//    ^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.singletonType().
//                  display_name singletonType
//                  signature_documentation scala def singletonType(e: String): e.type
//                  kind Method
//                  ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.singletonType().(e)
//                    display_name e
//                    signature_documentation scala e: String 
//                    kind Parameter
//                     ^^^^^^ reference semanticdb maven . . scala/Predef.String#
//                              ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.singletonType().(e)
//                                       ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.singletonType().(e)
  def thisType(): this.type = this
//    ^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.thisType().
//             display_name thisType
//             signature_documentation scala def thisType(): this.type
//             kind Method
  def constantInt(): 1 = 1
//    ^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.constantInt().
//                display_name constantInt
//                signature_documentation scala def constantInt(): 1
//                kind Method
  def constantString(): "string" = "string"
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.constantString().
//                   display_name constantString
//                   signature_documentation scala def constantString(): "string"
//                   kind Method
  def constantBoolean(): true = true
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.constantBoolean().
//                    display_name constantBoolean
//                    signature_documentation scala def constantBoolean(): true
//                    kind Method
  def constantFloat(): 1.2f = 1.2f
//    ^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.constantFloat().
//                  display_name constantFloat
//                  signature_documentation scala def constantFloat(): 1.2f
//                  kind Method
  def constantChar(): 'a' = 'a'
//    ^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.constantChar().
//                 display_name constantChar
//                 signature_documentation scala def constantChar(): 'a'
//                 kind Method
  def structuralType(): { val x: Int; def foo(a: Int): String } = null
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.structuralType().
//                   display_name structuralType
//                   signature_documentation scala def structuralType(): { val x: Int; def foo(a: Int): String }
//                   kind Method
//                            ^ definition local 1
//                              display_name x
//                              signature_documentation scala val x: Int
//                              kind AbstractMethod
//                               ^^^ reference semanticdb maven . . scala/Int#
//                                        ^^^ definition local 2
//                                            display_name foo
//                                            signature_documentation scala def foo(a: Int): String
//                                            kind AbstractMethod
//                                            ^ definition local 3
//                                              display_name a
//                                              signature_documentation scala a: Int 
//                                              kind Parameter
//                                               ^^^ reference semanticdb maven . . scala/Int#
//                                                     ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  def byNameType(a: => Int): Unit = ()
//    ^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.byNameType().
//               display_name byNameType
//               signature_documentation scala def byNameType(a: => Int): Unit
//               kind Method
//               ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.byNameType().(a)
//                 display_name a
//                 signature_documentation scala a: => Int 
//                 kind Parameter
//                     ^^^ reference semanticdb maven . . scala/Int#
//                           ^^^^ reference semanticdb maven . . scala/Unit#
  def repeatedType(a: Int*): Unit = ()
//    ^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.repeatedType().
//                 display_name repeatedType
//                 signature_documentation scala def repeatedType(a: Int*): Unit
//                 kind Method
//                 ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.repeatedType().(a)
//                   display_name a
//                   signature_documentation scala a: Int* 
//                   kind Parameter
//                    ^^^ reference semanticdb maven . . scala/Int#
//                           ^^^^ reference semanticdb maven . . scala/Unit#

  type TypeAlias = Int
//     ^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.TypeAlias#
//               display_name TypeAlias
//               signature_documentation scala type TypeAlias >: Int <: Int
//               kind Type
//                 ^^^ reference semanticdb maven . . scala/Int#
  type ParameterizedTypeAlias[A] = () => A
//     ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias#
//                            display_name ParameterizedTypeAlias
//                            signature_documentation scala type ParameterizedTypeAlias >: A=> A <: A=> A
//                            kind Type
//                            ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias#[A]
//                              display_name A
//                              signature_documentation scala A
//                              kind TypeParameter
//                                       ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias#[A]
  type ParameterizedTypeAlias2[A, B] = A => B
//     ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias2#
//                             display_name ParameterizedTypeAlias2
//                             signature_documentation scala type ParameterizedTypeAlias2 >: (A) => B <: (A) => B
//                             kind Type
//                             ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias2#[A]
//                               display_name A
//                               signature_documentation scala A
//                               kind TypeParameter
//                                ^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias2#[B]
//                                  display_name B
//                                  signature_documentation scala B
//                                  kind TypeParameter
//                                     ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias2#[A]
//                                          ^ reference semanticdb maven . . minimized/MinimizedScalaSignatures.ParameterizedTypeAlias2#[B]
  type TypeBound
//     ^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.TypeBound#
//               display_name TypeBound
//               signature_documentation scala type TypeBound
//               kind Type
  type TypeUpperBound <: String
//     ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.TypeUpperBound#
//                    display_name TypeUpperBound
//                    signature_documentation scala type TypeUpperBound <: String
//                    kind Type
//                       ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  type TypeLowerBound >: CharSequence
//     ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.TypeLowerBound#
//                    display_name TypeLowerBound
//                    signature_documentation scala type TypeLowerBound >: CharSequence
//                    kind Type
//                       ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
  type TypeLowerUpperBound >: String <: CharSequence
//     ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSignatures.TypeLowerUpperBound#
//                         display_name TypeLowerUpperBound
//                         signature_documentation scala type TypeLowerUpperBound >: String <: CharSequence
//                         kind Type
//                            ^^^^^^ reference semanticdb maven . . scala/Predef.String#
//                                      ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
}
