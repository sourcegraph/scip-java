  package snapshots
//        ^^^^^^^^^ reference semanticdb maven . . snapshots/
  
  import java.lang.RuntimeException
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/lang/
//                 ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/ObjectKt#
//⌄ enclosing_range_start semanticdb maven . . snapshots/ObjectKt#`<init>`().
  object ObjectKt {
//       ^^^^^^^^ definition semanticdb maven . . snapshots/ObjectKt#
//                display_name ObjectKt
//                signature_documentation kotlin public final object ObjectKt : Any
//       ^^^^^^^^ definition semanticdb maven . . snapshots/ObjectKt#`<init>`().
//                display_name ObjectKt
//                signature_documentation kotlin private constructor(): ObjectKt
//  ⌄ enclosing_range_start semanticdb maven . . snapshots/ObjectKt#fail().
//           ⌄ enclosing_range_start semanticdb maven . . snapshots/ObjectKt#fail().(message)
    fun fail(message: String?): Nothing {
//      ^^^^ definition semanticdb maven . . snapshots/ObjectKt#fail().
//           display_name fail
//           signature_documentation kotlin public final fun fail(message: String?): Nothing
//           ^^^^^^^ definition semanticdb maven . . snapshots/ObjectKt#fail().(message)
//                   display_name message
//                   signature_documentation kotlin message: String?
//                    ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                              ^^^^^^^ reference semanticdb maven . . kotlin/Nothing#
//                          ⌃ enclosing_range_end semanticdb maven . . snapshots/ObjectKt#fail().(message)
      throw RuntimeException(message)
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#`<init>`().
//                           ^^^^^^^ reference semanticdb maven . . snapshots/ObjectKt#fail().(message)
    }
//  ⌃ enclosing_range_end semanticdb maven . . snapshots/ObjectKt#fail().
  }
//⌃ enclosing_range_end semanticdb maven . . snapshots/ObjectKt#
//⌃ enclosing_range_end semanticdb maven . . snapshots/ObjectKt#`<init>`().
