package minimized
//      ^^^^^^^^^ definition minimized/

trait Issue413 {
//    ^^^^^^^^ definition minimized/Issue413# trait Issue413
  val b: Int
//    ^ definition minimized/Issue413#b. val b: Int
//       ^^^ reference scala/Int#
}

class Issue413Subclass extends Issue413 {
//    ^^^^^^^^^^^^^^^^ definition minimized/Issue413Subclass# class Issue413Subclass
//                      definition minimized/Issue413Subclass#`<init>`(). def this()
//                             ^^^^^^^^ reference minimized/Issue413#
//                                       reference java/lang/Object#`<init>`().
  override val b = 10
//             ^ definition minimized/Issue413Subclass#b. val b: Int
}
