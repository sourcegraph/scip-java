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
//                        documentation ```scala\nsealed trait IndexedValue\n```
  def index: Int
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//          documentation ```scala\ndef index: Int\n```
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
//                  documentation ```scala\nobject IndexedValue\n```
//                          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#
//                                      ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                   ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  
  case class Str(index: Int, value0: java.lang.CharSequence) extends IndexedValue
//           ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#
//               documentation ```scala\ncase class Str(index: Int, value0: CharSequence) extends IndexedValue\n```
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().
//               documentation ```scala\ndef copy(index: Int, value0: CharSequence): Str\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().
//               documentation ```scala\ndef apply(index: Int, value0: CharSequence): Str\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function2#apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.
//               documentation ```scala\nobject Str\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#productElement().
//               documentation ```scala\ndef productElement(x$1: Int): Any\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#productElementName().
//               documentation ```scala\ndef productElementName(x$1: Int): String\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().
//                documentation ```scala\ndef this(index: Int, value0: CharSequence)\n```
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#index.
//                     documentation ```scala\nval index: Int\n```
//                     relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(index)
//                     documentation ```scala\ndefault index: Int \n```
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#index.
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().(index)
//                     documentation ```scala\nindex: Int \n```
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#index.
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().(index)
//                     documentation ```scala\nindex: Int \n```
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#index.
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                           ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#value0.
//                                  documentation ```scala\nval value0: CharSequence\n```
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().(value0)
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(value0)
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().(value0)
//                           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().(value0)
//                                  documentation ```scala\nvalue0: CharSequence \n```
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(value0)
//                                  relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#value0.
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().(value0)
//                           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.apply().(value0)
//                                  documentation ```scala\nvalue0: CharSequence \n```
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#`<init>`().(value0)
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(value0)
//                                  relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#value0.
//                           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str#copy().(value0)
//                                  documentation ```scala\ndefault value0: CharSequence \n```
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
//               documentation ```scala\ncase class Obj(index: Int, value0: (CharSequence, IndexedValue)*) extends IndexedValue\n```
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().
//               documentation ```scala\ndef apply(index: Int, value0: (CharSequence, IndexedValue)*): Obj\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function2#apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#productElement().
//               documentation ```scala\ndef productElement(x$1: Int): Any\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.
//               documentation ```scala\nobject Obj\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#productElementName().
//               documentation ```scala\ndef productElementName(x$1: Int): String\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#`<init>`().
//                documentation ```scala\ndef this(index: Int, value0: (CharSequence, IndexedValue)*)\n```
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#index.
//                     documentation ```scala\nval index: Int\n```
//                     relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#`<init>`().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#`<init>`().(index)
//                     documentation ```scala\nindex: Int \n```
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#index.
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().(index)
//                     documentation ```scala\nindex: Int \n```
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#`<init>`().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#index.
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                           ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#value0.
//                                  documentation ```scala\nval value0: (CharSequence, IndexedValue)*\n```
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#`<init>`().(value0)
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().(value0)
//                           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj.apply().(value0)
//                                  documentation ```scala\nvalue0: (CharSequence, IndexedValue)* \n```
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#`<init>`().(value0)
//                                  relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#value0.
//                           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#`<init>`().(value0)
//                                  documentation ```scala\nvalue0: (CharSequence, IndexedValue)* \n```
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
//               documentation ```scala\ncase class Arr(index: Int, value: IndexedValue*) extends IndexedValue\n```
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#productElementName().
//               documentation ```scala\ndef productElementName(x$1: Int): String\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#productElement().
//               documentation ```scala\ndef productElement(x$1: Int): Any\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.
//               documentation ```scala\nobject Arr\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().
//               documentation ```scala\ndef apply(index: Int, value: IndexedValue*): Arr\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function2#apply().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#`<init>`().
//                documentation ```scala\ndef this(index: Int, value: IndexedValue*)\n```
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#index.
//                     documentation ```scala\nval index: Int\n```
//                     relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#`<init>`().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().(index)
//                     documentation ```scala\nindex: Int \n```
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#`<init>`().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#index.
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#`<init>`().(index)
//                     documentation ```scala\nindex: Int \n```
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#index.
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().(index)
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                           ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#value.
//                                 documentation ```scala\nval value: IndexedValue*\n```
//                                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#`<init>`().(value)
//                                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().(value)
//                           _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#`<init>`().(value)
//                                 documentation ```scala\nvalue: IndexedValue* \n```
//                                 relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#value.
//                                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().(value)
//                           _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.apply().(value)
//                                 documentation ```scala\nvalue: IndexedValue* \n```
//                                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#`<init>`().(value)
//                                 relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#value.
//                                  ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                                     ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  case class Num(index: Int, s: CharSequence, decIndex: Int, expIndex: Int) extends IndexedValue
//           ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#
//               documentation ```scala\ncase class Num(index: Int, s: CharSequence, decIndex: Int, expIndex: Int) extends IndexedValue\n```
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.
//               documentation ```scala\nobject Num\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().
//               documentation ```scala\ndef copy(index: Int, s: CharSequence, decIndex: Int, expIndex: Int): Num\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#productElement().
//               documentation ```scala\ndef productElement(x$1: Int): Any\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#productElementName().
//               documentation ```scala\ndef productElementName(x$1: Int): String\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#
//               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//           ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().
//               documentation ```scala\ndef apply(index: Int, s: CharSequence, decIndex: Int, expIndex: Int): Num\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function4#apply().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().
//                documentation ```scala\ndef this(index: Int, s: CharSequence, decIndex: Int, expIndex: Int)\n```
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#index.
//                     documentation ```scala\nval index: Int\n```
//                     relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(index)
//                     documentation ```scala\ndefault index: Int \n```
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#index.
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(index)
//                     documentation ```scala\nindex: Int \n```
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#index.
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(index)
//               _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(index)
//                     documentation ```scala\nindex: Int \n```
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(index)
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(index)
//                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#index.
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#s.
//                             documentation ```scala\nval s: CharSequence\n```
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(s)
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(s)
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(s)
//                           _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(s)
//                             documentation ```scala\ns: CharSequence \n```
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(s)
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(s)
//                             relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#s.
//                           _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(s)
//                             documentation ```scala\ns: CharSequence \n```
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(s)
//                             relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#s.
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(s)
//                           _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(s)
//                             documentation ```scala\ndefault s: CharSequence \n```
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(s)
//                             relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#s.
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(s)
//                              ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                            ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#decIndex.
//                                                     documentation ```scala\nval decIndex: Int\n```
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(decIndex)
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(decIndex)
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(decIndex)
//                                            ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(decIndex)
//                                                     documentation ```scala\ndefault decIndex: Int \n```
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(decIndex)
//                                                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#decIndex.
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(decIndex)
//                                            ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(decIndex)
//                                                     documentation ```scala\ndecIndex: Int \n```
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(decIndex)
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(decIndex)
//                                                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#decIndex.
//                                            ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(decIndex)
//                                                     documentation ```scala\ndecIndex: Int \n```
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(decIndex)
//                                                     relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#decIndex.
//                                                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(decIndex)
//                                                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                           ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#expIndex.
//                                                                    documentation ```scala\nval expIndex: Int\n```
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(expIndex)
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(expIndex)
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(expIndex)
//                                                           ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(expIndex)
//                                                                    documentation ```scala\nexpIndex: Int \n```
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(expIndex)
//                                                                    relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#expIndex.
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(expIndex)
//                                                           ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(expIndex)
//                                                                    documentation ```scala\nexpIndex: Int \n```
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(expIndex)
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(expIndex)
//                                                                    relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#expIndex.
//                                                           ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#copy().(expIndex)
//                                                                    documentation ```scala\ndefault expIndex: Int \n```
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#`<init>`().(expIndex)
//                                                                    relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num#expIndex.
//                                                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.apply().(expIndex)
//                                                                     ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                                  ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                                                              ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  case class NumRaw(index: Int, d: Double) extends IndexedValue
//           ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#
//                  documentation ```scala\ncase class NumRaw(index: Int, d: Double) extends IndexedValue\n```
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().
//           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().
//                  documentation ```scala\ndef copy(index: Int, d: Double): NumRaw\n```
//                  relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().
//           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.
//                  documentation ```scala\nobject NumRaw\n```
//                  relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().
//           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#productElement().
//                  documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                  relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().
//                  relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().
//                  documentation ```scala\ndef apply(index: Int, d: Double): NumRaw\n```
//                  relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#
//                  relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function2#apply().
//           ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#productElementName().
//                  documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                  relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().
//                  relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().
//                   documentation ```scala\ndef this(index: Int, d: Double)\n```
//                  ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#index.
//                        documentation ```scala\nval index: Int\n```
//                        relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(index)
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(index)
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(index)
//                  _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(index)
//                        documentation ```scala\nindex: Int \n```
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(index)
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(index)
//                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#index.
//                  _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(index)
//                        documentation ```scala\nindex: Int \n```
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(index)
//                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#index.
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(index)
//                  _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(index)
//                        documentation ```scala\ndefault index: Int \n```
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(index)
//                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#index.
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(index)
//                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#d.
//                                documentation ```scala\nval d: Double\n```
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(d)
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(d)
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(d)
//                              _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(d)
//                                documentation ```scala\ndefault d: Double \n```
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(d)
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#d.
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(d)
//                              _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(d)
//                                documentation ```scala\nd: Double \n```
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(d)
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(d)
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#d.
//                              _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#`<init>`().(d)
//                                documentation ```scala\nd: Double \n```
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#copy().(d)
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw#d.
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.apply().(d)
//                                 ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#
//                                                 ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                             ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  case class False(index: Int) extends IndexedValue{
//           ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#
//                 documentation ```scala\ncase class False(index: Int) extends IndexedValue\n```
//                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.
//                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().
//           _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.
//                 documentation ```scala\nobject False\n```
//                 relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#
//                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().
//           _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#productElementName().
//                 documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                 relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#
//                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().
//                 relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//           _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().
//                 documentation ```scala\ndef apply(index: Int): False\n```
//                 relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#
//                 relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function1#apply().
//           _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#productElement().
//                 documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                 relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#
//                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().
//                 relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#copy().
//                 documentation ```scala\ndef copy(index: Int): False\n```
//                 relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#
//                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#`<init>`().
//                  documentation ```scala\ndef this(index: Int)\n```
//                 ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#index.
//                       documentation ```scala\nval index: Int\n```
//                       relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#`<init>`().(index)
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#copy().(index)
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().(index)
//                 _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().(index)
//                       documentation ```scala\nindex: Int \n```
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#`<init>`().(index)
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#copy().(index)
//                       relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#index.
//                 _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#copy().(index)
//                       documentation ```scala\ndefault index: Int \n```
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#`<init>`().(index)
//                       relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#index.
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().(index)
//                 _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#`<init>`().(index)
//                       documentation ```scala\nindex: Int \n```
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#copy().(index)
//                       relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#index.
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.apply().(index)
//                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                     ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                 ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    def value = false
//      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False#value().
//            documentation ```scala\ndef value: Boolean\n```
  }
  case class True(index: Int) extends IndexedValue{
//           ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#
//                documentation ```scala\ncase class True(index: Int) extends IndexedValue\n```
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#productElement().
//                documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().
//                relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.
//                documentation ```scala\nobject True\n```
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#copy().
//                documentation ```scala\ndef copy(index: Int): True\n```
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().
//                documentation ```scala\ndef apply(index: Int): True\n```
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#
//                relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function1#apply().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#productElementName().
//                documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().
//                relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#`<init>`().
//                 documentation ```scala\ndef this(index: Int)\n```
//                ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#index.
//                      documentation ```scala\nval index: Int\n```
//                      relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#`<init>`().(index)
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#copy().(index)
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().(index)
//                _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().(index)
//                      documentation ```scala\nindex: Int \n```
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#`<init>`().(index)
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#copy().(index)
//                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#index.
//                _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#`<init>`().(index)
//                      documentation ```scala\nindex: Int \n```
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#copy().(index)
//                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#index.
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().(index)
//                _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#copy().(index)
//                      documentation ```scala\ndefault index: Int \n```
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#`<init>`().(index)
//                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#index.
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.apply().(index)
//                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    def value = true
//      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True#value().
//            documentation ```scala\ndef value: Boolean\n```
  }
  case class Null(index: Int) extends IndexedValue{
//           ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#
//                documentation ```scala\ncase class Null(index: Int) extends IndexedValue\n```
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#copy().
//                documentation ```scala\ndef copy(index: Int): Null\n```
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#productElement().
//                documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().
//                relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#productElementName().
//                documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().
//                relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().
//                documentation ```scala\ndef apply(index: Int): Null\n```
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#
//                relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function1#apply().
//           ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.
//                documentation ```scala\nobject Null\n```
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#
//                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#`<init>`().
//                 documentation ```scala\ndef this(index: Int)\n```
//                ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#index.
//                      documentation ```scala\nval index: Int\n```
//                      relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#index().
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#`<init>`().(index)
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#copy().(index)
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().(index)
//                _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#`<init>`().(index)
//                      documentation ```scala\nindex: Int \n```
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#copy().(index)
//                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#index.
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().(index)
//                _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().(index)
//                      documentation ```scala\nindex: Int \n```
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#`<init>`().(index)
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#copy().(index)
//                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#index.
//                _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#copy().(index)
//                      documentation ```scala\ndefault index: Int \n```
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#`<init>`().(index)
//                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#index.
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.apply().(index)
//                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    def value = null
//      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null#value().
//            documentation ```scala\ndef value: Null\n```
  }

  def transform[T](j: IndexedValue, f: Visitor[_, T]): T = try{
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().
//              documentation ```scala\ndef transform(j: IndexedValue, f: Visitor[local16, T[): T\n```
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().[T]
//                documentation ```scala\nT\n```
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(j)
//                   documentation ```scala\nj: IndexedValue \n```
//                    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                  ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                                    documentation ```scala\nf: Visitor[local16, T[ \n```
//                                     ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().[T]
//                                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().[T]
    j match{
//  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(j)
      case IndexedValue.Null(i) => f.visitNull(i)
//         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                      ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.
//                           ^ definition local 17
//                             documentation ```scala\ni: Int \n```
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                                   ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitNull().
//                                             ^ reference local 17
      case IndexedValue.True(i) => f.visitTrue(i)
//         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                      ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.
//                           ^ definition local 18
//                             documentation ```scala\ni: Int \n```
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                                   ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitTrue().
//                                             ^ reference local 18
      case IndexedValue.False(i) => f.visitFalse(i)
//         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                      ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.
//                            ^ definition local 19
//                              documentation ```scala\ni: Int \n```
//                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                                    ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFalse().
//                                               ^ reference local 19
      case IndexedValue.Str(i, s) => f.visitString(s, i)
//         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                      ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.
//                          ^ definition local 20
//                            documentation ```scala\ni: Int \n```
//                             ^ definition local 21
//                               documentation ```scala\ns: CharSequence \n```
//                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                                     ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                                                 ^ reference local 21
//                                                    ^ reference local 20
      case IndexedValue.Num(i, s, d, e) => f.visitFloat64StringParts(s, d, e, i)
//         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                      ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.
//                          ^ definition local 22
//                            documentation ```scala\ni: Int \n```
//                             ^ definition local 23
//                               documentation ```scala\ns: CharSequence \n```
//                                ^ definition local 24
//                                  documentation ```scala\nd: Int \n```
//                                   ^ definition local 25
//                                     documentation ```scala\ne: Int \n```
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
//                               documentation ```scala\ni: Int \n```
//                                ^ definition local 27
//                                  documentation ```scala\nd: Double \n```
//                                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                                        ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64().
//                                                     ^ reference local 27
//                                                        ^ reference local 26
      case IndexedValue.Arr(i, items @_*) =>
//         ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                      ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr.
//                          ^ definition local 28
//                            documentation ```scala\ni: Int \n```
//                             ^^^^^ definition local 29
//                                   documentation ```scala\nitems: Seq[IndexedValue] \n```
        val ctx = f.visitArray(-1, -1).narrow
//          ^^^ definition local 30
//              documentation ```scala\nctx: ArrVisitor[Any, T] \n```
//                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                  ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitArray().
//                                     ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ArrVisitor#narrow().
        for(item <- items) try ctx.visitValue(transform(item, ctx.subVisitor), item.index) catch reject(item.index)
//          ^^^^ definition local 31
//               documentation ```scala\nitem: IndexedValue \n```
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
//                            documentation ```scala\ni: Int \n```
//                             ^^^^^ definition local 35
//                                   documentation ```scala\nitems: Seq[(CharSequence, IndexedValue)] \n```
        val ctx = f.visitObject(-1, -1).narrow
//          ^^^ definition local 36
//              documentation ```scala\nctx: ObjVisitor[Any, T] \n```
//                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().(f)
//                  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitObject().
//                                      ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#narrow().
        for((k, item) <- items) {
//           ^ definition local 37
//             documentation ```scala\nk: CharSequence \n```
//              ^^^^ definition local 38
//                   documentation ```scala\nitem: IndexedValue \n```
//                       ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOps#withFilter().
          val keyVisitor = try ctx.visitKey(i) catch reject(i)
//            ^^^^^^^^^^ definition local 40
//                       documentation ```scala\nkeyVisitor: Visitor[local41, Any[ \n```
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
//               documentation ```scala\nobject Builder\n```
//                       ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#
//                                 ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                               ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                            ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    def visitArray(length: Int, i: Int) = new ArrVisitor[IndexedValue, IndexedValue.Arr] {
//      ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitArray().
//                 documentation ```scala\ndef visitArray(length: Int, i: Int): { def subVisitor: Builder }\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitArray().
//                 ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitArray().(length)
//                        documentation ```scala\nlength: Int \n```
//                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitArray().(i)
//                                documentation ```scala\ni: Int \n```
//                                 ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                            ^ definition local 49
//                                              documentation ```scala\nfinal class $anon\n```
//                                            ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ArrVisitor#
//                                                       ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                                     ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                                                                  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Arr#
//                                                                                       ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
      val out = mutable.Buffer.empty[IndexedValue]
//        ^^^ definition local 50
//            documentation ```scala\nprivate val out: Buffer[IndexedValue]\n```
//              ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
//                      ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/Buffer.
//                             ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/SeqFactory.Delegate#empty().
//                                   ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
      def subVisitor = Builder
//        ^^^^^^^^^^ definition local 48
//                   documentation ```scala\ndef subVisitor: Builder\n```
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                     ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.
      def visitValue(v: IndexedValue, index: Int): Unit = {
//        ^^^^^^^^^^ definition local 51
//                   documentation ```scala\ndef visitValue(v: IndexedValue, index: Int): Unit\n```
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                   ^ definition local 53
//                     documentation ```scala\nv: IndexedValue \n```
//                      ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                    ^^^^^ definition local 54
//                                          documentation ```scala\nindex: Int \n```
//                                           ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                 ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
        out.append(v)
//      ^^^ reference local 50
//          ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/Buffer#append().
//                 ^ reference local 53
      }
      def visitEnd(index: Int): IndexedValue.Arr = IndexedValue.Arr(i, out.toSeq:_*)
//        ^^^^^^^^ definition local 52
//                 documentation ```scala\ndef visitEnd(index: Int): Arr\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//                 ^^^^^ definition local 55
//                       documentation ```scala\nindex: Int \n```
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
//                  documentation ```scala\ndef visitObject(length: Int, i: Int): { def subVisitor: Builder; def visitKey(index: Int): Builder }\n```
//                  relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitObject().
//                  ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitObject().(length)
//                         documentation ```scala\nlength: Int \n```
//                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitObject().(i)
//                                 documentation ```scala\ni: Int \n```
//                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                             ^ definition local 59
//                                               documentation ```scala\nfinal class $anon\n```
//                                             ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#
//                                                        ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                                                                   ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Obj#
//                                                                                        ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
      val out = mutable.Buffer.empty[(String, IndexedValue)]
//        ^^^ definition local 60
//            documentation ```scala\nprivate val out: Buffer[(String, IndexedValue)]\n```
//              ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
//                      ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/Buffer.
//                             ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/SeqFactory.Delegate#empty().
//                                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                            ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
      var currentKey: String = _
//        ^^^^^^^^^^ definition local 61
//                   documentation ```scala\nprivate var currentKey: String\n```
//                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
      def subVisitor = Builder
//        ^^^^^^^^^^ definition local 56
//                   documentation ```scala\ndef subVisitor: Builder\n```
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                     ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.
      def visitKey(index: Int) = IndexedValue.Builder
//        ^^^^^^^^ definition local 57
//                 documentation ```scala\ndef visitKey(index: Int): Builder\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKey().
//                 ^^^^^ definition local 58
//                       documentation ```scala\nindex: Int \n```
//                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                               ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                            ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.
      def visitKeyValue(s: Any): Unit = currentKey = s.asInstanceOf[IndexedValue.Str].value0.toString
//        ^^^^^^^^^^^^^ definition local 63
//                      documentation ```scala\ndef visitKeyValue(s: Any): Unit\n```
//                      relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKeyValue().
//                      ^ definition local 67
//                        documentation ```scala\ns: Any \n```
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
//                   documentation ```scala\ndef visitValue(v: IndexedValue, index: Int): Unit\n```
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                   ^ definition local 68
//                     documentation ```scala\nv: IndexedValue \n```
//                      ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue#
//                                    ^^^^^ definition local 69
//                                          documentation ```scala\nindex: Int \n```
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
//                 documentation ```scala\ndef visitEnd(index: Int): Obj\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//                 ^^^^^ definition local 70
//                       documentation ```scala\nindex: Int \n```
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
//                documentation ```scala\ndef visitNull(i: Int): Null\n```
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitNull().
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitNull().(i)
//                  documentation ```scala\ni: Int \n```
//                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                          ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                       ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Null.
//                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitNull().(i)

    def visitFalse(i: Int) = IndexedValue.False(i)
//      ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFalse().
//                 documentation ```scala\ndef visitFalse(i: Int): False\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFalse().
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFalse().(i)
//                   documentation ```scala\ni: Int \n```
//                    ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                           ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                        ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.False.
//                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFalse().(i)

    def visitTrue(i: Int) = IndexedValue.True(i)
//      ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitTrue().
//                documentation ```scala\ndef visitTrue(i: Int): True\n```
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitTrue().
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitTrue().(i)
//                  documentation ```scala\ni: Int \n```
//                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                          ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                       ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.True.
//                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitTrue().(i)

    def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, i: Int) = IndexedValue.Num(i, s, decIndex, expIndex)
//      ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().
//                              documentation ```scala\ndef visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, i: Int): Num\n```
//                              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64StringParts().
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(s)
//                                documentation ```scala\ns: CharSequence \n```
//                                 ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                               ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(decIndex)
//                                                        documentation ```scala\ndecIndex: Int \n```
//                                                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                              ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(expIndex)
//                                                                       documentation ```scala\nexpIndex: Int \n```
//                                                                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(i)
//                                                                               documentation ```scala\ni: Int \n```
//                                                                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                                       ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                                                                                    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Num.
//                                                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(i)
//                                                                                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(s)
//                                                                                                              ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(decIndex)
//                                                                                                                        ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64StringParts().(expIndex)
    override def visitFloat64(d: Double, i: Int) = IndexedValue.NumRaw(i, d)
//               ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64().
//                            documentation ```scala\ndef visitFloat64(d: Double, i: Int): NumRaw\n```
//                            relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                            relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64().
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64().(d)
//                              documentation ```scala\nd: Double \n```
//                               ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#
//                                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64().(i)
//                                         documentation ```scala\ni: Int \n```
//                                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                 ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                                              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.NumRaw.
//                                                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64().(i)
//                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64().(d)

    def visitString(s: CharSequence, i: Int) = IndexedValue.Str(i, s)
//      ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitString().
//                  documentation ```scala\ndef visitString(s: CharSequence, i: Int): Str\n```
//                  relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                  ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitString().(s)
//                    documentation ```scala\ns: CharSequence \n```
//                     ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitString().(i)
//                                     documentation ```scala\ni: Int \n```
//                                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                             ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.
//                                                          ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Str.
//                                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitString().(i)
//                                                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitString().(s)
  }
}
