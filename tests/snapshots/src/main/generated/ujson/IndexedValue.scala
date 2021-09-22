package ujson
//      ^^^^^ definition ujson/

import upickle.core.Util.reject
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                  ^^^^ reference upickle/core/Util.
//                       ^^^^^^ reference upickle/core/Util.reject().
import scala.collection.mutable
//     ^^^^^ reference scala/
//           ^^^^^^^^^^ reference scala/collection/
//                      ^^^^^^^ reference scala/collection/mutable/
import upickle.core.{Visitor, ObjVisitor, ArrVisitor, Abort, AbortException}
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                   ^^^^^^^ reference upickle/core/Visitor.
//                   ^^^^^^^ reference upickle/core/Visitor#
//                            ^^^^^^^^^^ reference upickle/core/ObjVisitor#
//                                        ^^^^^^^^^^ reference upickle/core/ArrVisitor#
//                                                    ^^^^^ reference upickle/core/Abort.
//                                                    ^^^^^ reference upickle/core/Abort#
//                                                           ^^^^^^^^^^^^^^ reference upickle/core/AbortException.
//                                                           ^^^^^^^^^^^^^^ reference upickle/core/AbortException#

/**
  * A version of [[ujson.Value]] that keeps the index positions of the various AST
  * nodes it is constructing. Usually not necessary, but sometimes useful if you
  * want to work with an AST but still provide source-index error positions if
  * something goes wrong
  */
sealed trait IndexedValue {
//           ^^^^^^^^^^^^ definition ujson/IndexedValue#
  def index: Int
//    ^^^^^ definition ujson/IndexedValue#index().
//           ^^^ reference scala/Int#
}

object IndexedValue extends Transformer[IndexedValue]{
//     ^^^^^^^^^^^^ definition ujson/IndexedValue.
//                          ^^^^^^^^^^^ reference ujson/Transformer#
//                                      ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                                    reference java/lang/Object#`<init>`().
  
  case class Str(index: Int, value0: java.lang.CharSequence) extends IndexedValue
//           ^^^ definition ujson/IndexedValue.Str#
//               definition ujson/IndexedValue.Str#`<init>`().
//               ^^^^^ definition ujson/IndexedValue.Str#index.
//                      ^^^ reference scala/Int#
//                           ^^^^^^ definition ujson/IndexedValue.Str#value0.
//                                   ^^^^ reference java/
//                                        ^^^^ reference java/lang/
//                                             ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                                                   ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                                                                reference java/lang/Object#`<init>`().
  case class Obj(index: Int, value0: (java.lang.CharSequence, IndexedValue)*) extends IndexedValue
//           ^^^ definition ujson/IndexedValue.Obj#
//               definition ujson/IndexedValue.Obj#`<init>`().
//               ^^^^^ definition ujson/IndexedValue.Obj#index.
//                      ^^^ reference scala/Int#
//                           ^^^^^^ definition ujson/IndexedValue.Obj#value0.
//                                    ^^^^ reference java/
//                                         ^^^^ reference java/lang/
//                                              ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                                            ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                                                                    ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                                                                                 reference java/lang/Object#`<init>`().
  case class Arr(index: Int, value: IndexedValue*) extends IndexedValue
//           ^^^ definition ujson/IndexedValue.Arr#
//               definition ujson/IndexedValue.Arr#`<init>`().
//               ^^^^^ definition ujson/IndexedValue.Arr#index.
//                      ^^^ reference scala/Int#
//                           ^^^^^ definition ujson/IndexedValue.Arr#value.
//                                  ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                                         ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                                                      reference java/lang/Object#`<init>`().
  case class Num(index: Int, s: CharSequence, decIndex: Int, expIndex: Int) extends IndexedValue
//           ^^^ definition ujson/IndexedValue.Num#
//               definition ujson/IndexedValue.Num#`<init>`().
//               ^^^^^ definition ujson/IndexedValue.Num#index.
//                      ^^^ reference scala/Int#
//                           ^ definition ujson/IndexedValue.Num#s.
//                              ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                            ^^^^^^^^ definition ujson/IndexedValue.Num#decIndex.
//                                                      ^^^ reference scala/Int#
//                                                           ^^^^^^^^ definition ujson/IndexedValue.Num#expIndex.
//                                                                     ^^^ reference scala/Int#
//                                                                                  ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                                                                               reference java/lang/Object#`<init>`().
  case class NumRaw(index: Int, d: Double) extends IndexedValue
//           ^^^^^^ definition ujson/IndexedValue.NumRaw#
//                  definition ujson/IndexedValue.NumRaw#`<init>`().
//                  ^^^^^ definition ujson/IndexedValue.NumRaw#index.
//                         ^^^ reference scala/Int#
//                              ^ definition ujson/IndexedValue.NumRaw#d.
//                                 ^^^^^^ reference scala/Double#
//                                                 ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                                              reference java/lang/Object#`<init>`().
  case class False(index: Int) extends IndexedValue{
//           ^^^^^ definition ujson/IndexedValue.False#
//                 definition ujson/IndexedValue.False#`<init>`().
//                 ^^^^^ definition ujson/IndexedValue.False#index.
//                        ^^^ reference scala/Int#
//                                     ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                                  reference java/lang/Object#`<init>`().
    def value = false
//      ^^^^^ definition ujson/IndexedValue.False#value().
  }
  case class True(index: Int) extends IndexedValue{
//           ^^^^ definition ujson/IndexedValue.True#
//                definition ujson/IndexedValue.True#`<init>`().
//                ^^^^^ definition ujson/IndexedValue.True#index.
//                       ^^^ reference scala/Int#
//                                    ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                                 reference java/lang/Object#`<init>`().
    def value = true
//      ^^^^^ definition ujson/IndexedValue.True#value().
  }
  case class Null(index: Int) extends IndexedValue{
//           ^^^^ definition ujson/IndexedValue.Null#
//                definition ujson/IndexedValue.Null#`<init>`().
//                ^^^^^ definition ujson/IndexedValue.Null#index.
//                       ^^^ reference scala/Int#
//                                    ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                                 reference java/lang/Object#`<init>`().
    def value = null
//      ^^^^^ definition ujson/IndexedValue.Null#value().
  }

  def transform[T](j: IndexedValue, f: Visitor[_, T]): T = try{
//    ^^^^^^^^^ definition ujson/IndexedValue.transform().
//              ^ definition ujson/IndexedValue.transform().[T]
//                 ^ definition ujson/IndexedValue.transform().(j)
//                    ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                  ^ definition ujson/IndexedValue.transform().(f)
//                                     ^^^^^^^ reference upickle/core/Visitor#
//                                                ^ reference ujson/IndexedValue.transform().[T]
//                                                     ^ reference ujson/IndexedValue.transform().[T]
    j match{
//  ^ reference ujson/IndexedValue.transform().(j)
      case IndexedValue.Null(i) => f.visitNull(i)
//         ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                      ^^^^ reference ujson/IndexedValue.Null.
//                           ^ definition local0
//                                 ^ reference ujson/IndexedValue.transform().(f)
//                                   ^^^^^^^^^ reference upickle/core/Visitor#visitNull().
//                                             ^ reference local0
      case IndexedValue.True(i) => f.visitTrue(i)
//         ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                      ^^^^ reference ujson/IndexedValue.True.
//                           ^ definition local1
//                                 ^ reference ujson/IndexedValue.transform().(f)
//                                   ^^^^^^^^^ reference upickle/core/Visitor#visitTrue().
//                                             ^ reference local1
      case IndexedValue.False(i) => f.visitFalse(i)
//         ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                      ^^^^^ reference ujson/IndexedValue.False.
//                            ^ definition local2
//                                  ^ reference ujson/IndexedValue.transform().(f)
//                                    ^^^^^^^^^^ reference upickle/core/Visitor#visitFalse().
//                                               ^ reference local2
      case IndexedValue.Str(i, s) => f.visitString(s, i)
//         ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                      ^^^ reference ujson/IndexedValue.Str.
//                          ^ definition local3
//                             ^ definition local4
//                                   ^ reference ujson/IndexedValue.transform().(f)
//                                     ^^^^^^^^^^^ reference upickle/core/Visitor#visitString().
//                                                 ^ reference local4
//                                                    ^ reference local3
      case IndexedValue.Num(i, s, d, e) => f.visitFloat64StringParts(s, d, e, i)
//         ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                      ^^^ reference ujson/IndexedValue.Num.
//                          ^ definition local5
//                             ^ definition local6
//                                ^ definition local7
//                                   ^ definition local8
//                                         ^ reference ujson/IndexedValue.transform().(f)
//                                           ^^^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/Visitor#visitFloat64StringParts().
//                                                                   ^ reference local6
//                                                                      ^ reference local7
//                                                                         ^ reference local8
//                                                                            ^ reference local5
      case IndexedValue.NumRaw(i, d) => f.visitFloat64(d, i)
//         ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                      ^^^^^^ reference ujson/IndexedValue.NumRaw.
//                             ^ definition local9
//                                ^ definition local10
//                                      ^ reference ujson/IndexedValue.transform().(f)
//                                        ^^^^^^^^^^^^ reference upickle/core/Visitor#visitFloat64().
//                                                     ^ reference local10
//                                                        ^ reference local9
      case IndexedValue.Arr(i, items @_*) =>
//         ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                      ^^^ reference ujson/IndexedValue.Arr.
//                          ^ definition local11
//                             ^^^^^ definition local12
        val ctx = f.visitArray(-1, -1).narrow
//          ^^^ definition local13
//                ^ reference ujson/IndexedValue.transform().(f)
//                  ^^^^^^^^^^ reference upickle/core/Visitor#visitArray().
//                                     ^^^^^^ reference upickle/core/ArrVisitor#narrow().
        for(item <- items) try ctx.visitValue(transform(item, ctx.subVisitor), item.index) catch reject(item.index)
//          ^^^^ definition local14
//                  ^^^^^ reference local12
//                             ^^^ reference local13
//                                 ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
//                                            ^^^^^^^^^ reference ujson/IndexedValue.transform().
//                                                      ^^^^ reference local14
//                                                            ^^^ reference local13
//                                                                ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                                                                             ^^^^ reference local14
//                                                                                  ^^^^^ reference ujson/IndexedValue#index().
//                                                                                               ^^^^^^ reference upickle/core/Util.reject().
//                                                                                                      ^^^^ reference local14
//                                                                                                           ^^^^^ reference ujson/IndexedValue#index().
//                                                                                                                  reference scala/collection/IterableOnceOps#foreach().
//                                                                                                                  reference local14
//                                                                                                                  reference scala/Function1#apply().
        ctx.visitEnd(i)
//      ^^^ reference local13
//          ^^^^^^^^ reference upickle/core/ObjArrVisitor#visitEnd().
//                   ^ reference local11
      case IndexedValue.Obj(i, items @_*) =>
//         ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                      ^^^ reference ujson/IndexedValue.Obj.
//                          ^ definition local16
//                             ^^^^^ definition local17
        val ctx = f.visitObject(-1, -1).narrow
//          ^^^ definition local18
//                ^ reference ujson/IndexedValue.transform().(f)
//                  ^^^^^^^^^^^ reference upickle/core/Visitor#visitObject().
//                                      ^^^^^^ reference upickle/core/ObjVisitor#narrow().
        for((k, item) <- items) {
//           ^ definition local21
//              ^^^^ definition local22
//                       ^^^^^ reference scala/collection/IterableOps#withFilter().
          val keyVisitor = try ctx.visitKey(i) catch reject(i)
//            ^^^^^^^^^^ definition local23
//                             ^^^ reference local18
//                                 ^^^^^^^^ reference upickle/core/ObjVisitor#visitKey().
//                                          ^ reference local16
//                                                   ^^^^^^ reference upickle/core/Util.reject().
//                                                          ^ reference local16
//                                                             reference scala/Function1#apply().

          ctx.visitKeyValue(keyVisitor.visitString(k, i))
//        ^^^ reference local18
//            ^^^^^^^^^^^^^ reference upickle/core/ObjVisitor#visitKeyValue().
//                          ^^^^^^^^^^ reference local23
//                                     ^^^^^^^^^^^ reference upickle/core/Visitor#visitString().
//                                                 ^ reference local21
//                                                    ^ reference local16
          try ctx.visitValue(transform(item, ctx.subVisitor), item.index) catch reject(item.index)
//            ^^^ reference local18
//                ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
//                           ^^^^^^^^^ reference ujson/IndexedValue.transform().
//                                     ^^^^ reference local22
//                                           ^^^ reference local18
//                                               ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                                                            ^^^^ reference local22
//                                                                 ^^^^^ reference ujson/IndexedValue#index().
//                                                                              ^^^^^^ reference upickle/core/Util.reject().
//                                                                                     ^^^^ reference local22
//                                                                                          ^^^^^ reference ujson/IndexedValue#index().
//                                                                                                 reference scala/Function1#apply().
        }
//        reference scala/collection/IterableOps#withFilter().
//        reference local19
//        reference scala/collection/WithFilter#foreach().
//        reference local20
        ctx.visitEnd(i)
//      ^^^ reference local18
//          ^^^^^^^^ reference upickle/core/ObjArrVisitor#visitEnd().
//                   ^ reference local16
    }
  } catch reject(j.index)
//        ^^^^^^ reference upickle/core/Util.reject().
//               ^ reference ujson/IndexedValue.transform().(j)
//                 ^^^^^ reference ujson/IndexedValue#index().
//                        reference scala/Function1#apply().


  object Builder extends JsVisitor[IndexedValue, IndexedValue]{
//       ^^^^^^^ definition ujson/IndexedValue.Builder.
//                       ^^^^^^^^^ reference ujson/JsVisitor#
//                                 ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                               ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                                             reference java/lang/Object#`<init>`().
    def visitArray(length: Int, i: Int) = new ArrVisitor[IndexedValue, IndexedValue.Arr] {
//      ^^^^^^^^^^ definition ujson/IndexedValue.Builder.visitArray().
//                 ^^^^^^ definition ujson/IndexedValue.Builder.visitArray().(length)
//                         ^^^ reference scala/Int#
//                              ^ definition ujson/IndexedValue.Builder.visitArray().(i)
//                                 ^^^ reference scala/Int#
//                                            ^^^^^^^^^^ reference upickle/core/ArrVisitor#
//                                                       ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                                                     ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                                                                                  ^^^ reference ujson/IndexedValue.Arr#
//                                                                                        reference java/lang/Object#`<init>`().
      val out = mutable.Buffer.empty[IndexedValue]
//        ^^^ definition local25
//              ^^^^^^^ reference scala/collection/mutable/
//                      ^^^^^^ reference scala/collection/mutable/Buffer.
//                             ^^^^^ reference scala/collection/SeqFactory.Delegate#empty().
//                                   ^^^^^^^^^^^^ reference ujson/IndexedValue#
      def subVisitor = Builder
//        ^^^^^^^^^^ definition local26
//                     ^^^^^^^ reference ujson/IndexedValue.Builder.
      def visitValue(v: IndexedValue, index: Int): Unit = {
//        ^^^^^^^^^^ definition local27
//                   ^ definition local28
//                      ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                    ^^^^^ definition local29
//                                           ^^^ reference scala/Int#
//                                                 ^^^^ reference scala/Unit#
        out.append(v)
//      ^^^ reference local25
//          ^^^^^^ reference scala/collection/mutable/Buffer#append().
//                 ^ reference local28
      }
      def visitEnd(index: Int): IndexedValue.Arr = IndexedValue.Arr(i, out.toSeq:_*)
//        ^^^^^^^^ definition local30
//                 ^^^^^ definition local31
//                        ^^^ reference scala/Int#
//                              ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                                           ^^^ reference ujson/IndexedValue.Arr#
//                                                 ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                                                              ^^^ reference ujson/IndexedValue.Arr.
//                                                                  reference ujson/IndexedValue.Arr.apply().
//                                                                  ^ reference ujson/IndexedValue.Builder.visitArray().(i)
//                                                                     ^^^ reference local25
//                                                                         ^^^^^ reference scala/collection/IterableOnceOps#toSeq().
    }

    def visitObject(length: Int, i: Int) = new ObjVisitor[IndexedValue, IndexedValue.Obj] {
//      ^^^^^^^^^^^ definition ujson/IndexedValue.Builder.visitObject().
//                  ^^^^^^ definition ujson/IndexedValue.Builder.visitObject().(length)
//                          ^^^ reference scala/Int#
//                               ^ definition ujson/IndexedValue.Builder.visitObject().(i)
//                                  ^^^ reference scala/Int#
//                                             ^^^^^^^^^^ reference upickle/core/ObjVisitor#
//                                                        ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                                                      ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                                                                                   ^^^ reference ujson/IndexedValue.Obj#
//                                                                                         reference java/lang/Object#`<init>`().
      val out = mutable.Buffer.empty[(String, IndexedValue)]
//        ^^^ definition local32
//              ^^^^^^^ reference scala/collection/mutable/
//                      ^^^^^^ reference scala/collection/mutable/Buffer.
//                             ^^^^^ reference scala/collection/SeqFactory.Delegate#empty().
//                                    ^^^^^^ reference scala/Predef.String#
//                                            ^^^^^^^^^^^^ reference ujson/IndexedValue#
      var currentKey: String = _
//        ^^^^^^^^^^ definition local33
//                    ^^^^^^ reference scala/Predef.String#
      def subVisitor = Builder
//        ^^^^^^^^^^ definition local34
//                     ^^^^^^^ reference ujson/IndexedValue.Builder.
      def visitKey(index: Int) = IndexedValue.Builder
//        ^^^^^^^^ definition local35
//                 ^^^^^ definition local36
//                        ^^^ reference scala/Int#
//                               ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                                            ^^^^^^^ reference ujson/IndexedValue.Builder.
      def visitKeyValue(s: Any): Unit = currentKey = s.asInstanceOf[IndexedValue.Str].value0.toString
//        ^^^^^^^^^^^^^ definition local37
//                      ^ definition local38
//                         ^^^ reference scala/Any#
//                               ^^^^ reference scala/Unit#
//                                      ^^^^^^^^^^ reference local39
//                                                   ^ reference local38
//                                                     ^^^^^^^^^^^^ reference scala/Any#asInstanceOf().
//                                                                  ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                                                                               ^^^ reference ujson/IndexedValue.Str#
//                                                                                    ^^^^^^ reference ujson/IndexedValue.Str#value0.
//                                                                                           ^^^^^^^^ reference java/lang/Object#toString().
      def visitValue(v: IndexedValue, index: Int): Unit = {
//        ^^^^^^^^^^ definition local40
//                   ^ definition local41
//                      ^^^^^^^^^^^^ reference ujson/IndexedValue#
//                                    ^^^^^ definition local42
//                                           ^^^ reference scala/Int#
//                                                 ^^^^ reference scala/Unit#
        out.append((currentKey, v))
//      ^^^ reference local32
//          ^^^^^^ reference scala/collection/mutable/Buffer#append().
//                  ^^^^^^^^^^ reference local33
//                              ^ reference local41
      }
      def visitEnd(index: Int): IndexedValue.Obj = IndexedValue.Obj(i, out.toSeq:_*)
//        ^^^^^^^^ definition local43
//                 ^^^^^ definition local44
//                        ^^^ reference scala/Int#
//                              ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                                           ^^^ reference ujson/IndexedValue.Obj#
//                                                 ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                                                              ^^^ reference ujson/IndexedValue.Obj.
//                                                                  reference ujson/IndexedValue.Obj.apply().
//                                                                  ^ reference ujson/IndexedValue.Builder.visitObject().(i)
//                                                                     ^^^ reference local32
//                                                                         ^^^^^ reference scala/collection/IterableOnceOps#toSeq().
    }

    def visitNull(i: Int) = IndexedValue.Null(i)
//      ^^^^^^^^^ definition ujson/IndexedValue.Builder.visitNull().
//                ^ definition ujson/IndexedValue.Builder.visitNull().(i)
//                   ^^^ reference scala/Int#
//                          ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                                       ^^^^ reference ujson/IndexedValue.Null.
//                                            reference ujson/IndexedValue.Null.apply().
//                                            ^ reference ujson/IndexedValue.Builder.visitNull().(i)

    def visitFalse(i: Int) = IndexedValue.False(i)
//      ^^^^^^^^^^ definition ujson/IndexedValue.Builder.visitFalse().
//                 ^ definition ujson/IndexedValue.Builder.visitFalse().(i)
//                    ^^^ reference scala/Int#
//                           ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                                        ^^^^^ reference ujson/IndexedValue.False.
//                                              reference ujson/IndexedValue.False.apply().
//                                              ^ reference ujson/IndexedValue.Builder.visitFalse().(i)

    def visitTrue(i: Int) = IndexedValue.True(i)
//      ^^^^^^^^^ definition ujson/IndexedValue.Builder.visitTrue().
//                ^ definition ujson/IndexedValue.Builder.visitTrue().(i)
//                   ^^^ reference scala/Int#
//                          ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                                       ^^^^ reference ujson/IndexedValue.True.
//                                            reference ujson/IndexedValue.True.apply().
//                                            ^ reference ujson/IndexedValue.Builder.visitTrue().(i)

    def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, i: Int) = IndexedValue.Num(i, s, decIndex, expIndex)
//      ^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/IndexedValue.Builder.visitFloat64StringParts().
//                              ^ definition ujson/IndexedValue.Builder.visitFloat64StringParts().(s)
//                                 ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                               ^^^^^^^^ definition ujson/IndexedValue.Builder.visitFloat64StringParts().(decIndex)
//                                                         ^^^ reference scala/Int#
//                                                              ^^^^^^^^ definition ujson/IndexedValue.Builder.visitFloat64StringParts().(expIndex)
//                                                                        ^^^ reference scala/Int#
//                                                                             ^ definition ujson/IndexedValue.Builder.visitFloat64StringParts().(i)
//                                                                                ^^^ reference scala/Int#
//                                                                                       ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                                                                                                    ^^^ reference ujson/IndexedValue.Num.
//                                                                                                        reference ujson/IndexedValue.Num.apply().
//                                                                                                        ^ reference ujson/IndexedValue.Builder.visitFloat64StringParts().(i)
//                                                                                                           ^ reference ujson/IndexedValue.Builder.visitFloat64StringParts().(s)
//                                                                                                              ^^^^^^^^ reference ujson/IndexedValue.Builder.visitFloat64StringParts().(decIndex)
//                                                                                                                        ^^^^^^^^ reference ujson/IndexedValue.Builder.visitFloat64StringParts().(expIndex)
    override def visitFloat64(d: Double, i: Int) = IndexedValue.NumRaw(i, d)
//               ^^^^^^^^^^^^ definition ujson/IndexedValue.Builder.visitFloat64().
//                            ^ definition ujson/IndexedValue.Builder.visitFloat64().(d)
//                               ^^^^^^ reference scala/Double#
//                                       ^ definition ujson/IndexedValue.Builder.visitFloat64().(i)
//                                          ^^^ reference scala/Int#
//                                                 ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                                                              ^^^^^^ reference ujson/IndexedValue.NumRaw.
//                                                                     reference ujson/IndexedValue.NumRaw.apply().
//                                                                     ^ reference ujson/IndexedValue.Builder.visitFloat64().(i)
//                                                                        ^ reference ujson/IndexedValue.Builder.visitFloat64().(d)

    def visitString(s: CharSequence, i: Int) = IndexedValue.Str(i, s)
//      ^^^^^^^^^^^ definition ujson/IndexedValue.Builder.visitString().
//                  ^ definition ujson/IndexedValue.Builder.visitString().(s)
//                     ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                   ^ definition ujson/IndexedValue.Builder.visitString().(i)
//                                      ^^^ reference scala/Int#
//                                             ^^^^^^^^^^^^ reference ujson/IndexedValue.
//                                                          ^^^ reference ujson/IndexedValue.Str.
//                                                              reference ujson/IndexedValue.Str.apply().
//                                                              ^ reference ujson/IndexedValue.Builder.visitString().(i)
//                                                                 ^ reference ujson/IndexedValue.Builder.visitString().(s)
  }
}
