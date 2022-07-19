package minimized
//      ^^^^^^^^^ definition minimized/

object Issue414 {
//     ^^^^^^^^ definition minimized/Issue414. object Issue414
  trait A {
//      ^ definition minimized/Issue414.A# trait A
    def b(): Unit
//      ^ definition minimized/Issue414.A#b(). def b(): Unit
//           ^^^^ reference scala/Unit#
  }
  val a: A =
//    ^ definition minimized/Issue414.a. val a: A
//       ^ reference minimized/Issue414.A#
    new A {
//       definition local0 final class $anon
//      ^ reference minimized/Issue414.A#
//         reference java/lang/Object#`<init>`().
      override def b(): Unit = {
//                 ^ definition local1 def b(): Unit
//                      ^^^^ reference scala/Unit#
        print("Hello")
//      ^^^^^ reference scala/Predef.print().
      }
    }
  println(a.b())
//^^^^^^^ reference scala/Predef.println(+1).
//        ^ reference minimized/Issue414.a.
//          ^ reference minimized/Issue414.A#b().
}
