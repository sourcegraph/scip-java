package minimized
//      ^^^^^^^^^ definition minimized/

case class Issue396(a: Int)
//         ^^^^^^^^ definition minimized/Issue396# case class Issue396(a: Int)
//                  definition minimized/Issue396#`<init>`(). def this(a: Int)
//                  ^ definition minimized/Issue396#a. val a: Int
//                     ^^^ reference scala/Int#
object Issue396App {
//     ^^^^^^^^^^^ definition minimized/Issue396App. object Issue396App
  println(Issue396)
//^^^^^^^ reference scala/Predef.println(+1).
//        ^^^^^^^^ reference minimized/Issue396.
  Issue396.apply(a = 42).copy(a = 41)
//^^^^^^^^ reference minimized/Issue396.
//         ^^^^^ reference minimized/Issue396.apply().
//               ^ reference minimized/Issue396.apply().(a)
//                       ^^^^ reference minimized/Issue396#copy().
//                            ^ reference minimized/Issue396#copy().(a)
  Issue396.apply(a = 42).productElement(0)
//^^^^^^^^ reference minimized/Issue396.
//         ^^^^^ reference minimized/Issue396.apply().
//               ^ reference minimized/Issue396.apply().(a)
//                       ^^^^^^^^^^^^^^ reference minimized/Issue396#productElement().
  Issue396.apply(a = 42).productElementName(0)
//^^^^^^^^ reference minimized/Issue396.
//         ^^^^^ reference minimized/Issue396.apply().
//               ^ reference minimized/Issue396.apply().(a)
//                       ^^^^^^^^^^^^^^^^^^ reference minimized/Issue396#productElementName().
}
