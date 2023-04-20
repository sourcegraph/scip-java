package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

trait Issue413 {
//    ^^^^^^^^ definition semanticdb maven . . minimized/Issue413#
//             documentation ```scala\ntrait Issue413\n```
  val b: Int
//    ^ definition semanticdb maven . . minimized/Issue413#b.
//      documentation ```scala\nval b: Int\n```
//       ^^^ reference semanticdb maven . . scala/Int#
}

class Issue413Subclass extends Issue413 {
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Issue413Subclass#
//                     documentation ```scala\nclass Issue413Subclass\n```
//                     ^ definition semanticdb maven . . minimized/Issue413Subclass#`<init>`().
//                       documentation ```scala\ndef this()\n```
//                             ^^^^^^^^ reference semanticdb maven . . minimized/Issue413#
//                                      ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  override val b = 10
//             ^ definition semanticdb maven . . minimized/Issue413Subclass#b.
//               documentation ```scala\nval b: Int\n```
//               relationship is_reference is_implementation semanticdb maven . . minimized/Issue413#b.
}
