package minimized
//      ^^^^^^^^^ definition minimized/

import scala.language.reflectiveCalls
//     ^^^^^ reference scala/
//           ^^^^^^^^ reference scala/language.
//                    ^^^^^^^^^^^^^^^ reference scala/language.reflectiveCalls.

class ReflectiveCall {
//    ^^^^^^^^^^^^^^ definition minimized/ReflectiveCall# class ReflectiveCall
//                    definition minimized/ReflectiveCall#`<init>`(). def this()
  // Reproduction for https://github.com/scalameta/scalameta/issues/2788
  val a =
//    ^ definition minimized/ReflectiveCall#a. val a: { val b: Int }
    new {
//       definition local0 final class $anon
      val b = 1
//        ^ definition local1 val b: Int
    }
  println(a.b)
//^^^^^^^ reference scala/Predef.println(+1).
//        ^ reference minimized/ReflectiveCall#a.
//          ^ reference local1
}
