  package minimized
//        ^^^^^^^^^ definition semanticdb maven . . minimized/
  
  class Issue397 {
//      ^^^^^^^^ definition semanticdb maven . . minimized/Issue397#
//               display_name Issue397
//               signature_documentation scala class Issue397
//               kind Class
//               ^ definition semanticdb maven . . minimized/Issue397#`<init>`().
//                 display_name <init>
//                 signature_documentation scala def this()
//                 kind Constructor
    var blah = Set("abc")
//      ^^^^ definition semanticdb maven . . minimized/Issue397#blah().
//           display_name blah
//           signature_documentation scala var blah: Set[String]
//           kind Method
//      ____ synthetic_definition semanticdb maven . . minimized/Issue397#`blah_=`().
//           display_name blah_=
//           signature_documentation scala var blah_=(x$1: Set[String]): Unit
//           kind Method
//           relationship is_definition semanticdb maven . . minimized/Issue397#blah().
//             ^^^ reference semanticdb maven . . scala/Predef.Set.
//                ^ reference semanticdb maven . . scala/collection/IterableFactory#apply().
    blah = Set.empty[String]
//  ^^^^ reference semanticdb maven . . minimized/Issue397#`blah_=`().
//         ^^^ reference semanticdb maven . . scala/Predef.Set.
//             ^^^^^ reference semanticdb maven . . scala/collection/immutable/Set.empty().
//                   ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  }
