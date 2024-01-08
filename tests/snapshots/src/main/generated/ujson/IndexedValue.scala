package ujson
//      ^^^^^ definition semanticdb maven . . ujson/

import upickle.core.Util.reject
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                  ^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Util.
//                       ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Util.reject().
import scala.collection.mutable
//     ^^^^^ reference semanticdb maven . . scala/
//           ^^^^^^^^^^ reference semanticdb maven . . scala/collection/
//                      ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
import upickle.core.{Visitor, ObjVisitor, ArrVisitor, Abort, AbortException}
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                   ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                   ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor.
//                            ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#
//                                        ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ArrVisitor#
//                                                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Abort#
//                                                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Abort.
//                                                           ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/AbortException#
//                                                           ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/AbortException.

/**
  * A version of [[ujson.Value]] that keeps the index positions of the various AST
  * nodes it is constructing. Usually not necessary, but sometimes useful if you
  * want to work with an AST but still provide source-index error positions if
  * something goes wrong
  */
sealed trait IndexedValue {
//           ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                        display_name IndexedValue
//                        signature_documentation scala sealed trait IndexedValue
//                        kind Trait
  def index: Int
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//          display_name index
//          signature_documentation scala def index: Int
//          kind AbstractMethod
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#index.
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#index.
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#index.
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#index.
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#index.
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#index.
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#index.
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#index.
//           ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
}

object IndexedValue extends Transformer[IndexedValue]{
//     ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                  display_name IndexedValue
//                  signature_documentation scala object IndexedValue
//                  kind Object
//                          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#
//                                      ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                   ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  
  case class Str(index: Int, value0: java.lang.CharSequence) extends IndexedValue
//           ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#
//               display_name Str
//               signature_documentation scala case class Str(index: Int, value0: CharSequence) extends IndexedValue
//               kind Class
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().
//               display_name copy
//               signature_documentation scala def copy(index: Int, value0: CharSequence): Str
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().
//               display_name apply
//               signature_documentation scala def apply(index: Int, value0: CharSequence): Str
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function2#apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.
//               display_name Str
//               signature_documentation scala object Str
//               kind Object
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#productElement().
//               display_name productElement
//               signature_documentation scala def productElement(x$1: Int): Any
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#productElementName().
//               display_name productElementName
//               signature_documentation scala def productElementName(x$1: Int): String
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().
//                display_name <init>
//                signature_documentation scala def this(index: Int, value0: CharSequence)
//                kind Constructor
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#index.
//                     display_name index
//                     signature_documentation scala val index: Int
//                     kind Method
//                     relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(index)
//                     display_name index
//                     signature_documentation scala default index: Int 
//                     kind Parameter
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#index.
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().(index)
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#index.
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().(index)
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#index.
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                           ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#value0.
//                                  display_name value0
//                                  signature_documentation scala val value0: CharSequence
//                                  kind Method
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().(value0)
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(value0)
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().(value0)
//                           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().(value0)
//                                  display_name value0
//                                  signature_documentation scala value0: CharSequence 
//                                  kind Parameter
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(value0)
//                                  relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#value0.
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().(value0)
//                           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().(value0)
//                                  display_name value0
//                                  signature_documentation scala value0: CharSequence 
//                                  kind Parameter
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().(value0)
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(value0)
//                                  relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#value0.
//                           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(value0)
//                                  display_name value0
//                                  signature_documentation scala default value0: CharSequence 
//                                  kind Parameter
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().(value0)
//                                  relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#value0.
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().(value0)
//                                   ^^^^ reference semanticdb maven . . java/
//                                        ^^^^ reference semanticdb maven . . java/lang/
//                                             ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                                                   ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                                               ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  case class Obj(index: Int, value0: (java.lang.CharSequence, IndexedValue)*) extends IndexedValue
//           ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#
//               display_name Obj
//               signature_documentation scala case class Obj(index: Int, value0: (CharSequence, IndexedValue)*) extends IndexedValue
//               kind Class
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().
//               display_name apply
//               signature_documentation scala def apply(index: Int, value0: (CharSequence, IndexedValue)*): Obj
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function2#apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#productElement().
//               display_name productElement
//               signature_documentation scala def productElement(x$1: Int): Any
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.
//               display_name Obj
//               signature_documentation scala object Obj
//               kind Object
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#productElementName().
//               display_name productElementName
//               signature_documentation scala def productElementName(x$1: Int): String
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#`<init>`().
//                display_name <init>
//                signature_documentation scala def this(index: Int, value0: (CharSequence, IndexedValue)*)
//                kind Constructor
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#index.
//                     display_name index
//                     signature_documentation scala val index: Int
//                     kind Method
//                     relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#`<init>`().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#`<init>`().(index)
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#index.
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().(index)
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#`<init>`().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#index.
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                           ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#value0.
//                                  display_name value0
//                                  signature_documentation scala val value0: (CharSequence, IndexedValue)*
//                                  kind Method
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#`<init>`().(value0)
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().(value0)
//                           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().(value0)
//                                  display_name value0
//                                  signature_documentation scala value0: (CharSequence, IndexedValue)* 
//                                  kind Parameter
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#`<init>`().(value0)
//                                  relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#value0.
//                           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#`<init>`().(value0)
//                                  display_name value0
//                                  signature_documentation scala value0: (CharSequence, IndexedValue)* 
//                                  kind Parameter
//                                  relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#value0.
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().(value0)
//                                    ^^^^ reference semanticdb maven . . java/
//                                         ^^^^ reference semanticdb maven . . java/lang/
//                                              ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                                            ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                                                                ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  case class Arr(index: Int, value: IndexedValue*) extends IndexedValue
//           ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#
//               display_name Arr
//               signature_documentation scala case class Arr(index: Int, value: IndexedValue*) extends IndexedValue
//               kind Class
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#productElementName().
//               display_name productElementName
//               signature_documentation scala def productElementName(x$1: Int): String
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#productElement().
//               display_name productElement
//               signature_documentation scala def productElement(x$1: Int): Any
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.
//               display_name Arr
//               signature_documentation scala object Arr
//               kind Object
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().
//               display_name apply
//               signature_documentation scala def apply(index: Int, value: IndexedValue*): Arr
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function2#apply().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#`<init>`().
//                display_name <init>
//                signature_documentation scala def this(index: Int, value: IndexedValue*)
//                kind Constructor
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#index.
//                     display_name index
//                     signature_documentation scala val index: Int
//                     kind Method
//                     relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#`<init>`().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().(index)
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#`<init>`().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#index.
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#`<init>`().(index)
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#index.
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().(index)
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                           ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#value.
//                                 display_name value
//                                 signature_documentation scala val value: IndexedValue*
//                                 kind Method
//                                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#`<init>`().(value)
//                                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().(value)
//                           _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#`<init>`().(value)
//                                 display_name value
//                                 signature_documentation scala value: IndexedValue* 
//                                 kind Parameter
//                                 relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#value.
//                                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().(value)
//                           _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().(value)
//                                 display_name value
//                                 signature_documentation scala value: IndexedValue* 
//                                 kind Parameter
//                                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#`<init>`().(value)
//                                 relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#value.
//                                  ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                                     ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  case class Num(index: Int, s: CharSequence, decIndex: Int, expIndex: Int) extends IndexedValue
//           ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#
//               display_name Num
//               signature_documentation scala case class Num(index: Int, s: CharSequence, decIndex: Int, expIndex: Int) extends IndexedValue
//               kind Class
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.
//               display_name Num
//               signature_documentation scala object Num
//               kind Object
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().
//               display_name copy
//               signature_documentation scala def copy(index: Int, s: CharSequence, decIndex: Int, expIndex: Int): Num
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#productElement().
//               display_name productElement
//               signature_documentation scala def productElement(x$1: Int): Any
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#productElementName().
//               display_name productElementName
//               signature_documentation scala def productElementName(x$1: Int): String
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().
//               display_name apply
//               signature_documentation scala def apply(index: Int, s: CharSequence, decIndex: Int, expIndex: Int): Num
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function4#apply().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().
//                display_name <init>
//                signature_documentation scala def this(index: Int, s: CharSequence, decIndex: Int, expIndex: Int)
//                kind Constructor
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#index.
//                     display_name index
//                     signature_documentation scala val index: Int
//                     kind Method
//                     relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(index)
//                     display_name index
//                     signature_documentation scala default index: Int 
//                     kind Parameter
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#index.
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(index)
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#index.
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(index)
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#index.
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#s.
//                             display_name s
//                             signature_documentation scala val s: CharSequence
//                             kind Method
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(s)
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(s)
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(s)
//                           _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(s)
//                             display_name s
//                             signature_documentation scala s: CharSequence 
//                             kind Parameter
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(s)
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(s)
//                             relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#s.
//                           _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(s)
//                             display_name s
//                             signature_documentation scala s: CharSequence 
//                             kind Parameter
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(s)
//                             relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#s.
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(s)
//                           _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(s)
//                             display_name s
//                             signature_documentation scala default s: CharSequence 
//                             kind Parameter
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(s)
//                             relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#s.
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(s)
//                              ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                            ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#decIndex.
//                                                     display_name decIndex
//                                                     signature_documentation scala val decIndex: Int
//                                                     kind Method
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(decIndex)
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(decIndex)
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(decIndex)
//                                            ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(decIndex)
//                                                     display_name decIndex
//                                                     signature_documentation scala default decIndex: Int 
//                                                     kind Parameter
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(decIndex)
//                                                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#decIndex.
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(decIndex)
//                                            ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(decIndex)
//                                                     display_name decIndex
//                                                     signature_documentation scala decIndex: Int 
//                                                     kind Parameter
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(decIndex)
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(decIndex)
//                                                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#decIndex.
//                                            ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(decIndex)
//                                                     display_name decIndex
//                                                     signature_documentation scala decIndex: Int 
//                                                     kind Parameter
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(decIndex)
//                                                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#decIndex.
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(decIndex)
//                                                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                           ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#expIndex.
//                                                                    display_name expIndex
//                                                                    signature_documentation scala val expIndex: Int
//                                                                    kind Method
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(expIndex)
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(expIndex)
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(expIndex)
//                                                           ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(expIndex)
//                                                                    display_name expIndex
//                                                                    signature_documentation scala expIndex: Int 
//                                                                    kind Parameter
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(expIndex)
//                                                                    relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#expIndex.
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(expIndex)
//                                                           ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(expIndex)
//                                                                    display_name expIndex
//                                                                    signature_documentation scala expIndex: Int 
//                                                                    kind Parameter
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(expIndex)
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(expIndex)
//                                                                    relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#expIndex.
//                                                           ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(expIndex)
//                                                                    display_name expIndex
//                                                                    signature_documentation scala default expIndex: Int 
//                                                                    kind Parameter
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(expIndex)
//                                                                    relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#expIndex.
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(expIndex)
//                                                                     ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                                  ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                                                              ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  case class NumRaw(index: Int, d: Double) extends IndexedValue
//           ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#
//                  display_name NumRaw
//                  signature_documentation scala case class NumRaw(index: Int, d: Double) extends IndexedValue
//                  kind Class
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().
//           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().
//                  display_name copy
//                  signature_documentation scala def copy(index: Int, d: Double): NumRaw
//                  kind Method
//                  relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().
//           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.
//                  display_name NumRaw
//                  signature_documentation scala object NumRaw
//                  kind Object
//                  relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().
//           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#productElement().
//                  display_name productElement
//                  signature_documentation scala def productElement(x$1: Int): Any
//                  kind Method
//                  relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().
//                  relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().
//                  display_name apply
//                  signature_documentation scala def apply(index: Int, d: Double): NumRaw
//                  kind Method
//                  relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#
//                  relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function2#apply().
//           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#productElementName().
//                  display_name productElementName
//                  signature_documentation scala def productElementName(x$1: Int): String
//                  kind Method
//                  relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().
//                  relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().
//                   display_name <init>
//                   signature_documentation scala def this(index: Int, d: Double)
//                   kind Constructor
//                  ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#index.
//                        display_name index
//                        signature_documentation scala val index: Int
//                        kind Method
//                        relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(index)
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(index)
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(index)
//                  _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(index)
//                        display_name index
//                        signature_documentation scala index: Int 
//                        kind Parameter
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(index)
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(index)
//                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#index.
//                  _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(index)
//                        display_name index
//                        signature_documentation scala index: Int 
//                        kind Parameter
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(index)
//                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#index.
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(index)
//                  _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(index)
//                        display_name index
//                        signature_documentation scala default index: Int 
//                        kind Parameter
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(index)
//                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#index.
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(index)
//                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#d.
//                                display_name d
//                                signature_documentation scala val d: Double
//                                kind Method
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(d)
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(d)
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(d)
//                              _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(d)
//                                display_name d
//                                signature_documentation scala default d: Double 
//                                kind Parameter
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(d)
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#d.
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(d)
//                              _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(d)
//                                display_name d
//                                signature_documentation scala d: Double 
//                                kind Parameter
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(d)
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(d)
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#d.
//                              _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(d)
//                                display_name d
//                                signature_documentation scala d: Double 
//                                kind Parameter
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(d)
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#d.
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(d)
//                                 ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#
//                                                 ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                             ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  case class False(index: Int) extends IndexedValue{
//           ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#
//                 display_name False
//                 signature_documentation scala case class False(index: Int) extends IndexedValue
//                 kind Class
//                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.
//                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().
//           _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.
//                 display_name False
//                 signature_documentation scala object False
//                 kind Object
//                 relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#
//                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().
//           _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#productElementName().
//                 display_name productElementName
//                 signature_documentation scala def productElementName(x$1: Int): String
//                 kind Method
//                 relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#
//                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().
//                 relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//           _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().
//                 display_name apply
//                 signature_documentation scala def apply(index: Int): False
//                 kind Method
//                 relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#
//                 relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function1#apply().
//           _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#productElement().
//                 display_name productElement
//                 signature_documentation scala def productElement(x$1: Int): Any
//                 kind Method
//                 relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#
//                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().
//                 relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#copy().
//                 display_name copy
//                 signature_documentation scala def copy(index: Int): False
//                 kind Method
//                 relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#
//                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#`<init>`().
//                  display_name <init>
//                  signature_documentation scala def this(index: Int)
//                  kind Constructor
//                 ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#index.
//                       display_name index
//                       signature_documentation scala val index: Int
//                       kind Method
//                       relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#`<init>`().(index)
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#copy().(index)
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().(index)
//                 _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().(index)
//                       display_name index
//                       signature_documentation scala index: Int 
//                       kind Parameter
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#`<init>`().(index)
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#copy().(index)
//                       relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#index.
//                 _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#copy().(index)
//                       display_name index
//                       signature_documentation scala default index: Int 
//                       kind Parameter
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#`<init>`().(index)
//                       relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#index.
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().(index)
//                 _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#`<init>`().(index)
//                       display_name index
//                       signature_documentation scala index: Int 
//                       kind Parameter
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#copy().(index)
//                       relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#index.
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().(index)
//                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                     ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                 ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    def value = false
//      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#value().
//            display_name value
//            signature_documentation scala def value: Boolean
//            kind Method
  }
  case class True(index: Int) extends IndexedValue{
//           ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#
//                display_name True
//                signature_documentation scala case class True(index: Int) extends IndexedValue
//                kind Class
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#productElement().
//                display_name productElement
//                signature_documentation scala def productElement(x$1: Int): Any
//                kind Method
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().
//                relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.
//                display_name True
//                signature_documentation scala object True
//                kind Object
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#copy().
//                display_name copy
//                signature_documentation scala def copy(index: Int): True
//                kind Method
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().
//                display_name apply
//                signature_documentation scala def apply(index: Int): True
//                kind Method
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#
//                relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function1#apply().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#productElementName().
//                display_name productElementName
//                signature_documentation scala def productElementName(x$1: Int): String
//                kind Method
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().
//                relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#`<init>`().
//                 display_name <init>
//                 signature_documentation scala def this(index: Int)
//                 kind Constructor
//                ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#index.
//                      display_name index
//                      signature_documentation scala val index: Int
//                      kind Method
//                      relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#`<init>`().(index)
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#copy().(index)
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().(index)
//                _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().(index)
//                      display_name index
//                      signature_documentation scala index: Int 
//                      kind Parameter
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#`<init>`().(index)
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#copy().(index)
//                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#index.
//                _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#`<init>`().(index)
//                      display_name index
//                      signature_documentation scala index: Int 
//                      kind Parameter
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#copy().(index)
//                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#index.
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().(index)
//                _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#copy().(index)
//                      display_name index
//                      signature_documentation scala default index: Int 
//                      kind Parameter
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#`<init>`().(index)
//                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#index.
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().(index)
//                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    def value = true
//      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#value().
//            display_name value
//            signature_documentation scala def value: Boolean
//            kind Method
  }
  case class Null(index: Int) extends IndexedValue{
//           ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#
//                display_name Null
//                signature_documentation scala case class Null(index: Int) extends IndexedValue
//                kind Class
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#copy().
//                display_name copy
//                signature_documentation scala def copy(index: Int): Null
//                kind Method
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#productElement().
//                display_name productElement
//                signature_documentation scala def productElement(x$1: Int): Any
//                kind Method
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().
//                relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#productElementName().
//                display_name productElementName
//                signature_documentation scala def productElementName(x$1: Int): String
//                kind Method
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().
//                relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().
//                display_name apply
//                signature_documentation scala def apply(index: Int): Null
//                kind Method
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#
//                relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function1#apply().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.
//                display_name Null
//                signature_documentation scala object Null
//                kind Object
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#`<init>`().
//                 display_name <init>
//                 signature_documentation scala def this(index: Int)
//                 kind Constructor
//                ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#index.
//                      display_name index
//                      signature_documentation scala val index: Int
//                      kind Method
//                      relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#`<init>`().(index)
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#copy().(index)
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().(index)
//                _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#`<init>`().(index)
//                      display_name index
//                      signature_documentation scala index: Int 
//                      kind Parameter
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#copy().(index)
//                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#index.
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().(index)
//                _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().(index)
//                      display_name index
//                      signature_documentation scala index: Int 
//                      kind Parameter
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#`<init>`().(index)
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#copy().(index)
//                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#index.
//                _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#copy().(index)
//                      display_name index
//                      signature_documentation scala default index: Int 
//                      kind Parameter
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#`<init>`().(index)
//                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#index.
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().(index)
//                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    def value = null
//      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#value().
//            display_name value
//            signature_documentation scala def value: Null
//            kind Method
  }

  def transform[T](j: IndexedValue, f: Visitor[_, T]): T = try{
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().
//              display_name transform
//              signature_documentation scala def transform(j: IndexedValue, f: Visitor[local16, T[): T
//              kind Method
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().[T]
//                display_name T
//                signature_documentation scala T
//                kind TypeParameter
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(j)
//                   display_name j
//                   signature_documentation scala j: IndexedValue 
//                   kind Parameter
//                    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                  ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                                    display_name f
//                                    signature_documentation scala f: Visitor[local16, T[ 
//                                    kind Parameter
//                                     ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().[T]
//                                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().[T]
    j match{
//  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(j)
      case IndexedValue.Null(i) => f.visitNull(i)
//         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                      ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.
//                           ^ definition local 17
//                             display_name i
//                             signature_documentation scala i: Int 
//                             kind Variable
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                                   ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitNull().
//                                             ^ reference local 17
      case IndexedValue.True(i) => f.visitTrue(i)
//         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                      ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.
//                           ^ definition local 18
//                             display_name i
//                             signature_documentation scala i: Int 
//                             kind Variable
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                                   ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitTrue().
//                                             ^ reference local 18
      case IndexedValue.False(i) => f.visitFalse(i)
//         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                      ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.
//                            ^ definition local 19
//                              display_name i
//                              signature_documentation scala i: Int 
//                              kind Variable
//                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                                    ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFalse().
//                                               ^ reference local 19
      case IndexedValue.Str(i, s) => f.visitString(s, i)
//         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                      ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.
//                          ^ definition local 20
//                            display_name i
//                            signature_documentation scala i: Int 
//                            kind Variable
//                             ^ definition local 21
//                               display_name s
//                               signature_documentation scala s: CharSequence 
//                               kind Variable
//                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                                     ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                                                 ^ reference local 21
//                                                    ^ reference local 20
      case IndexedValue.Num(i, s, d, e) => f.visitFloat64StringParts(s, d, e, i)
//         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                      ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.
//                          ^ definition local 22
//                            display_name i
//                            signature_documentation scala i: Int 
//                            kind Variable
//                             ^ definition local 23
//                               display_name s
//                               signature_documentation scala s: CharSequence 
//                               kind Variable
//                                ^ definition local 24
//                                  display_name d
//                                  signature_documentation scala d: Int 
//                                  kind Variable
//                                   ^ definition local 25
//                                     display_name e
//                                     signature_documentation scala e: Int 
//                                     kind Variable
//                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                                           ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64StringParts().
//                                                                   ^ reference local 23
//                                                                      ^ reference local 24
//                                                                         ^ reference local 25
//                                                                            ^ reference local 22
      case IndexedValue.NumRaw(i, d) => f.visitFloat64(d, i)
//         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                      ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.
//                             ^ definition local 26
//                               display_name i
//                               signature_documentation scala i: Int 
//                               kind Variable
//                                ^ definition local 27
//                                  display_name d
//                                  signature_documentation scala d: Double 
//                                  kind Variable
//                                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                                        ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64().
//                                                     ^ reference local 27
//                                                        ^ reference local 26
      case IndexedValue.Arr(i, items @_*) =>
//         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                      ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.
//                          ^ definition local 28
//                            display_name i
//                            signature_documentation scala i: Int 
//                            kind Variable
//                             ^^^^^ definition local 29
//                                   display_name items
//                                   signature_documentation scala items: Seq[IndexedValue] 
//                                   kind Variable
        val ctx = f.visitArray(-1, -1).narrow
//          ^^^ definition local 30
//              display_name ctx
//              signature_documentation scala ctx: ArrVisitor[Any, T] 
//              kind Variable
//                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                  ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitArray().
//                                     ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ArrVisitor#narrow().
        for(item <- items) try ctx.visitValue(transform(item, ctx.subVisitor), item.index) catch reject(item.index)
//          ^^^^ definition local 31
//               display_name item
//               signature_documentation scala item: IndexedValue 
//               kind Parameter
//                  ^^^^^ reference local 29
//                             ^^^ reference local 30
//                                 ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                                            ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().
//                                                      ^^^^ reference local 31
//                                                            ^^^ reference local 30
//                                                                ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                                                                             ^^^^ reference local 31
//                                                                                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                                                                                               ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Util.reject().
//                                                                                                      ^^^^ reference local 31
//                                                                                                           ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
        ctx.visitEnd(i)
//      ^^^ reference local 30
//          ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//                   ^ reference local 28
      case IndexedValue.Obj(i, items @_*) =>
//         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                      ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.
//                          ^ definition local 34
//                            display_name i
//                            signature_documentation scala i: Int 
//                            kind Variable
//                             ^^^^^ definition local 35
//                                   display_name items
//                                   signature_documentation scala items: Seq[(CharSequence, IndexedValue)] 
//                                   kind Variable
        val ctx = f.visitObject(-1, -1).narrow
//          ^^^ definition local 36
//              display_name ctx
//              signature_documentation scala ctx: ObjVisitor[Any, T] 
//              kind Variable
//                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitObject().
//                                      ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#narrow().
        for((k, item) <- items) {
//           ^ definition local 37
//             display_name k
//             signature_documentation scala k: CharSequence 
//             kind Variable
//              ^^^^ definition local 38
//                   display_name item
//                   signature_documentation scala item: IndexedValue 
//                   kind Variable
//                       ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOps#withFilter().
          val keyVisitor = try ctx.visitKey(i) catch reject(i)
//            ^^^^^^^^^^ definition local 40
//                       display_name keyVisitor
//                       signature_documentation scala keyVisitor: Visitor[local41, Any[ 
//                       kind Variable
//                             ^^^ reference local 36
//                                 ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKey().
//                                          ^ reference local 34
//                                                   ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Util.reject().
//                                                          ^ reference local 34

          ctx.visitKeyValue(keyVisitor.visitString(k, i))
//        ^^^ reference local 36
//            ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKeyValue().
//                          ^^^^^^^^^^ reference local 40
//                                     ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                                                 ^ reference local 37
//                                                    ^ reference local 34
          try ctx.visitValue(transform(item, ctx.subVisitor), item.index) catch reject(item.index)
//            ^^^ reference local 36
//                ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                           ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().
//                                     ^^^^ reference local 38
//                                           ^^^ reference local 36
//                                               ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                                                            ^^^^ reference local 38
//                                                                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                                                                              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Util.reject().
//                                                                                     ^^^^ reference local 38
//                                                                                          ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
        }
        ctx.visitEnd(i)
//      ^^^ reference local 36
//          ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//                   ^ reference local 34
    }
  } catch reject(j.index)
//        ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Util.reject().
//               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(j)
//                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().


  object Builder extends JsVisitor[IndexedValue, IndexedValue]{
//       ^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.
//               display_name Builder
//               signature_documentation scala object Builder
//               kind Object
//                       ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#
//                                 ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                               ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                            ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    def visitArray(length: Int, i: Int) = new ArrVisitor[IndexedValue, IndexedValue.Arr] {
//      ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitArray().
//                 display_name visitArray
//                 signature_documentation scala def visitArray(length: Int, i: Int): { def subVisitor: Builder }
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitArray().
//                 ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitArray().(length)
//                        display_name length
//                        signature_documentation scala length: Int 
//                        kind Parameter
//                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitArray().(i)
//                                display_name i
//                                signature_documentation scala i: Int 
//                                kind Parameter
//                                 ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                            ^ definition local 49
//                                              display_name $anon
//                                              signature_documentation scala final class $anon
//                                              kind Class
//                                            ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ArrVisitor#
//                                                       ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                                     ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                                                                  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#
//                                                                                       ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
      val out = mutable.Buffer.empty[IndexedValue]
//        ^^^ definition local 50
//            display_name out
//            signature_documentation scala private val out: Buffer[IndexedValue]
//            kind Method
//              ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
//                      ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/Buffer.
//                             ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/SeqFactory.Delegate#empty().
//                                   ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
      def subVisitor = Builder
//        ^^^^^^^^^^ definition local 48
//                   display_name subVisitor
//                   signature_documentation scala def subVisitor: Builder
//                   kind Method
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                     ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.
      def visitValue(v: IndexedValue, index: Int): Unit = {
//        ^^^^^^^^^^ definition local 51
//                   display_name visitValue
//                   signature_documentation scala def visitValue(v: IndexedValue, index: Int): Unit
//                   kind Method
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                   ^ definition local 53
//                     display_name v
//                     signature_documentation scala v: IndexedValue 
//                     kind Parameter
//                      ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                    ^^^^^ definition local 54
//                                          display_name index
//                                          signature_documentation scala index: Int 
//                                          kind Parameter
//                                           ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                 ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
        out.append(v)
//      ^^^ reference local 50
//          ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/Buffer#append().
//                 ^ reference local 53
      }
      def visitEnd(index: Int): IndexedValue.Arr = IndexedValue.Arr(i, out.toSeq:_*)
//        ^^^^^^^^ definition local 52
//                 display_name visitEnd
//                 signature_documentation scala def visitEnd(index: Int): Arr
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//                 ^^^^^ definition local 55
//                       display_name index
//                       signature_documentation scala index: Int 
//                       kind Parameter
//                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                           ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#
//                                                 ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                                              ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.
//                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitArray().(i)
//                                                                     ^^^ reference local 50
//                                                                         ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOnceOps#toSeq().
    }

    def visitObject(length: Int, i: Int) = new ObjVisitor[IndexedValue, IndexedValue.Obj] {
//      ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitObject().
//                  display_name visitObject
//                  signature_documentation scala def visitObject(length: Int, i: Int): { def subVisitor: Builder; def visitKey(index: Int): Builder }
//                  kind Method
//                  relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitObject().
//                  ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitObject().(length)
//                         display_name length
//                         signature_documentation scala length: Int 
//                         kind Parameter
//                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitObject().(i)
//                                 display_name i
//                                 signature_documentation scala i: Int 
//                                 kind Parameter
//                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                             ^ definition local 59
//                                               display_name $anon
//                                               signature_documentation scala final class $anon
//                                               kind Class
//                                             ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#
//                                                        ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                                                                   ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#
//                                                                                        ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
      val out = mutable.Buffer.empty[(String, IndexedValue)]
//        ^^^ definition local 60
//            display_name out
//            signature_documentation scala private val out: Buffer[(String, IndexedValue)]
//            kind Method
//              ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
//                      ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/Buffer.
//                             ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/SeqFactory.Delegate#empty().
//                                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                            ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
      var currentKey: String = _
//        ^^^^^^^^^^ definition local 61
//                   display_name currentKey
//                   signature_documentation scala private var currentKey: String
//                   kind Method
//                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
      def subVisitor = Builder
//        ^^^^^^^^^^ definition local 56
//                   display_name subVisitor
//                   signature_documentation scala def subVisitor: Builder
//                   kind Method
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                     ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.
      def visitKey(index: Int) = IndexedValue.Builder
//        ^^^^^^^^ definition local 57
//                 display_name visitKey
//                 signature_documentation scala def visitKey(index: Int): Builder
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKey().
//                 ^^^^^ definition local 58
//                       display_name index
//                       signature_documentation scala index: Int 
//                       kind Parameter
//                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                               ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                            ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.
      def visitKeyValue(s: Any): Unit = currentKey = s.asInstanceOf[IndexedValue.Str].value0.toString
//        ^^^^^^^^^^^^^ definition local 63
//                      display_name visitKeyValue
//                      signature_documentation scala def visitKeyValue(s: Any): Unit
//                      kind Method
//                      relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKeyValue().
//                      ^ definition local 67
//                        display_name s
//                        signature_documentation scala s: Any 
//                        kind Parameter
//                         ^^^ reference semanticdb maven . . scala/Any#
//                               ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
//                                      ^^^^^^^^^^ reference local 62
//                                                   ^ reference local 67
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . scala/Any#asInstanceOf().
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                                                               ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#
//                                                                                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#value0.
//                                                                                           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#toString().
      def visitValue(v: IndexedValue, index: Int): Unit = {
//        ^^^^^^^^^^ definition local 64
//                   display_name visitValue
//                   signature_documentation scala def visitValue(v: IndexedValue, index: Int): Unit
//                   kind Method
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                   ^ definition local 68
//                     display_name v
//                     signature_documentation scala v: IndexedValue 
//                     kind Parameter
//                      ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                    ^^^^^ definition local 69
//                                          display_name index
//                                          signature_documentation scala index: Int 
//                                          kind Parameter
//                                           ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                 ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
        out.append((currentKey, v))
//      ^^^ reference local 60
//          ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/Buffer#append().
//                  ^^^^^^^^^^ reference local 61
//                              ^ reference local 68
      }
      def visitEnd(index: Int): IndexedValue.Obj = IndexedValue.Obj(i, out.toSeq:_*)
//        ^^^^^^^^ definition local 65
//                 display_name visitEnd
//                 signature_documentation scala def visitEnd(index: Int): Obj
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//                 ^^^^^ definition local 70
//                       display_name index
//                       signature_documentation scala index: Int 
//                       kind Parameter
//                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                           ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#
//                                                 ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                                              ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.
//                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitObject().(i)
//                                                                     ^^^ reference local 60
//                                                                         ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOnceOps#toSeq().
    }

    def visitNull(i: Int) = IndexedValue.Null(i)
//      ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitNull().
//                display_name visitNull
//                signature_documentation scala def visitNull(i: Int): Null
//                kind Method
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitNull().
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitNull().(i)
//                  display_name i
//                  signature_documentation scala i: Int 
//                  kind Parameter
//                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                          ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                       ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.
//                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitNull().(i)

    def visitFalse(i: Int) = IndexedValue.False(i)
//      ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFalse().
//                 display_name visitFalse
//                 signature_documentation scala def visitFalse(i: Int): False
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFalse().
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFalse().(i)
//                   display_name i
//                   signature_documentation scala i: Int 
//                   kind Parameter
//                    ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                           ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                        ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.
//                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFalse().(i)

    def visitTrue(i: Int) = IndexedValue.True(i)
//      ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitTrue().
//                display_name visitTrue
//                signature_documentation scala def visitTrue(i: Int): True
//                kind Method
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitTrue().
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitTrue().(i)
//                  display_name i
//                  signature_documentation scala i: Int 
//                  kind Parameter
//                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                          ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                       ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.
//                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitTrue().(i)

    def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, i: Int) = IndexedValue.Num(i, s, decIndex, expIndex)
//      ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().
//                              display_name visitFloat64StringParts
//                              signature_documentation scala def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, i: Int): Num
//                              kind Method
//                              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64StringParts().
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(s)
//                                display_name s
//                                signature_documentation scala s: CharSequence 
//                                kind Parameter
//                                 ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                               ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(decIndex)
//                                                        display_name decIndex
//                                                        signature_documentation scala decIndex: Int 
//                                                        kind Parameter
//                                                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                              ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(expIndex)
//                                                                       display_name expIndex
//                                                                       signature_documentation scala expIndex: Int 
//                                                                       kind Parameter
//                                                                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(i)
//                                                                               display_name i
//                                                                               signature_documentation scala i: Int 
//                                                                               kind Parameter
//                                                                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                                       ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                                                                                    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.
//                                                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(i)
//                                                                                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(s)
//                                                                                                              ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(decIndex)
//                                                                                                                        ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(expIndex)
    override def visitFloat64(d: Double, i: Int) = IndexedValue.NumRaw(i, d)
//               ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64().
//                            display_name visitFloat64
//                            signature_documentation scala def visitFloat64(d: Double, i: Int): NumRaw
//                            kind Method
//                            relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                            relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64().
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64().(d)
//                              display_name d
//                              signature_documentation scala d: Double 
//                              kind Parameter
//                               ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#
//                                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64().(i)
//                                         display_name i
//                                         signature_documentation scala i: Int 
//                                         kind Parameter
//                                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                 ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                                              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.
//                                                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64().(i)
//                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64().(d)

    def visitString(s: CharSequence, i: Int) = IndexedValue.Str(i, s)
//      ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitString().
//                  display_name visitString
//                  signature_documentation scala def visitString(s: CharSequence, i: Int): Str
//                  kind Method
//                  relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                  ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitString().(s)
//                    display_name s
//                    signature_documentation scala s: CharSequence 
//                    kind Parameter
//                     ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitString().(i)
//                                     display_name i
//                                     signature_documentation scala i: Int 
//                                     kind Parameter
//                                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                             ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                                          ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.
//                                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitString().(i)
//                                                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitString().(s)
  }
}
