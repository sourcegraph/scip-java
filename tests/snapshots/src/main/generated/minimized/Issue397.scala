package minimized
//      ^^^^^^^^^ definition minimized/

class Issue397 {
//    ^^^^^^^^ definition minimized/Issue397# class Issue397
//              definition minimized/Issue397#`<init>`(). def this()
  var blah = Set("abc")
//    ^^^^ definition minimized/Issue397#blah(). var blah: Set[String]
//    ^^^^ definition minimized/Issue397#`blah_=`(). var blah_=(x$1: Set[String]): Unit
//           ^^^ reference scala/Predef.Set.
//               reference scala/collection/IterableFactory#apply().
  blah = Set.empty[String]
//^^^^ reference minimized/Issue397#`blah_=`().
//       ^^^ reference scala/Predef.Set.
//           ^^^^^ reference scala/collection/immutable/Set.empty().
//                 ^^^^^^ reference scala/Predef.String#
}
