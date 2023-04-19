package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

class Issue397 {
//    ^^^^^^^^ definition semanticdb maven . . minimized/Issue397#
//             documentation ```scala\nclass Issue397\n```
//             ^ definition semanticdb maven . . minimized/Issue397#`<init>`().
//               documentation ```scala\ndef this()\n```
  var blah = Set("abc")
//    ^^^^ definition semanticdb maven . . minimized/Issue397#blah().
//         documentation ```scala\nvar blah: Set[String]\n```
//    ____ synthetic_definition semanticdb maven . . minimized/Issue397#`blah_=`().
//         documentation ```scala\nvar blah_=(x$1: Set[String]): Unit\n```
//         relationship is_definition semanticdb maven . . minimized/Issue397#blah().
//           ^^^ reference semanticdb maven . . scala/Predef.Set.
//              ^ reference semanticdb maven . . scala/collection/IterableFactory#apply().
  blah = Set.empty[String]
//^^^^ reference semanticdb maven . . minimized/Issue397#`blah_=`().
//       ^^^ reference semanticdb maven . . scala/Predef.Set.
//           ^^^^^ reference semanticdb maven . . scala/collection/immutable/Set.empty().
//                 ^^^^^^ reference semanticdb maven . . scala/Predef.String#
}
