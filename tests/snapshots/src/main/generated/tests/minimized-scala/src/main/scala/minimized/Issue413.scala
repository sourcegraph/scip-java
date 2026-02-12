  package minimized
//        ^^^^^^^^^ definition semanticdb maven . . minimized/
  
  trait Issue413 {
//      ^^^^^^^^ definition semanticdb maven . . minimized/Issue413#
//               display_name Issue413
//               signature_documentation scala trait Issue413
//               kind Trait
    val b: Int
//      ^ definition semanticdb maven . . minimized/Issue413#b.
//        display_name b
//        signature_documentation scala val b: Int
//        kind AbstractMethod
//        relationship is_reference is_implementation semanticdb maven . . minimized/Issue413Subclass#b.
//         ^^^ reference semanticdb maven . . scala/Int#
    val c: Int
//      ^ definition semanticdb maven . . minimized/Issue413#c.
//        display_name c
//        signature_documentation scala val c: Int
//        kind AbstractMethod
//        relationship is_reference is_implementation semanticdb maven . . minimized/Issue413Subclass#c.
//         ^^^ reference semanticdb maven . . scala/Int#
  }
  object Issue413 {
//       ^^^^^^^^ definition semanticdb maven . . minimized/Issue413.
//                display_name Issue413
//                signature_documentation scala object Issue413
//                kind Object
    def main(): Unit = {
//      ^^^^ definition semanticdb maven . . minimized/Issue413.main().
//           display_name main
//           signature_documentation scala def main(): Unit
//           kind Method
//              ^^^^ reference semanticdb maven . . scala/Unit#
      val a = new Issue413Subclass()
//        ^ definition local 0
//          display_name a
//          signature_documentation scala a: Issue413Subclass 
//          kind Variable
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Issue413Subclass#
//                                ^ reference semanticdb maven . . minimized/Issue413Subclass#`<init>`().
      val b: Issue413 = a
//        ^ definition local 1
//          display_name b
//          signature_documentation scala b: Issue413 
//          kind Variable
//           ^^^^^^^^ reference semanticdb maven . . minimized/Issue413#
//                      ^ reference local 0
      println(a.b + b.b)
//    ^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//            ^ reference local 0
//              ^ reference semanticdb maven . . minimized/Issue413Subclass#b.
//                ^ reference semanticdb maven . . scala/Int#`+`(+4).
//                  ^ reference local 1
//                    ^ reference semanticdb maven . . minimized/Issue413#b.
    }
  }
  
  class Issue413Subclass extends Issue413 {
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Issue413Subclass#
//                       display_name Issue413Subclass
//                       signature_documentation scala class Issue413Subclass
//                       kind Class
//                       ^ definition semanticdb maven . . minimized/Issue413Subclass#`<init>`().
//                         display_name <init>
//                         signature_documentation scala def this()
//                         kind Constructor
//                               ^^^^^^^^ reference semanticdb maven . . minimized/Issue413#
//                                        ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    override val b = 10
//               ^ definition semanticdb maven . . minimized/Issue413Subclass#b.
//                 display_name b
//                 signature_documentation scala val b: Int
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven . . minimized/Issue413#b.
    override val c = 10
//               ^ definition semanticdb maven . . minimized/Issue413Subclass#c.
//                 display_name c
//                 signature_documentation scala val c: Int
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven . . minimized/Issue413#c.
  }
