package minimized
//      ^^^^^^^^^ definition minimized/

case class Issue396(a: Int)
//         ^^^^^^^^ definition minimized/Issue396# case class Issue396(a: Int)
//         ^^^^^^^^ definition minimized/Issue396#copy(). def copy(a: Int): Issue396
//         ^^^^^^^^ definition minimized/Issue396#productElement(). def productElement(x$1: Int): Any
//         ^^^^^^^^ definition minimized/Issue396. object Issue396
//         ^^^^^^^^ definition minimized/Issue396.apply(). def apply(a: Int): Issue396
//         ^^^^^^^^ definition minimized/Issue396#productElementName(). def productElementName(x$1: Int): String
//                  definition minimized/Issue396#`<init>`(). def this(a: Int)
//                  ^ definition minimized/Issue396#a. val a: Int
//                     ^^^ reference scala/Int#
object Issue396App {
//     ^^^^^^^^^^^ definition minimized/Issue396App. object Issue396App
  println(Issue396)
//^^^^^^^ reference scala/Predef.println(+1).
//        ^^^^^^^^ reference minimized/Issue396.
  Issue396.apply(42).copy(a = 41)
//^^^^^^^^ reference minimized/Issue396.
//         ^^^^^ reference minimized/Issue396.apply().
//                   ^^^^ reference minimized/Issue396#copy().
//                        ^ reference minimized/Issue396#copy().(a)
  Issue396.apply(42).productElement(0)
//^^^^^^^^ reference minimized/Issue396.
//         ^^^^^ reference minimized/Issue396.apply().
//                   ^^^^^^^^^^^^^^ reference minimized/Issue396#productElement().
  Issue396.apply(42).productElementName(0)
//^^^^^^^^ reference minimized/Issue396.
//         ^^^^^ reference minimized/Issue396.apply().
//                   ^^^^^^^^^^^^^^^^^^ reference minimized/Issue396#productElementName().
}
