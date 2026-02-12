  package minimized;
  
  import java.util.Collections;
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/util/
//                 ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
  import java.util.List;
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/util/
//                 ^^^^ reference semanticdb maven jdk 11 java/util/List#
  
  @SuppressWarnings("ALL")
// ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
  public class RawTypes {
//             ^^^^^^^^ definition semanticdb maven . . minimized/RawTypes#
//                      display_name RawTypes
//                      signature_documentation java @SuppressWarnings("ALL")\npublic class RawTypes
//                      enclosing_range 5 0 8 1
//                      kind Class
//             ^^^^^^^^ definition semanticdb maven . . minimized/RawTypes#`<init>`().
//                      display_name <init>
//                      signature_documentation java public RawTypes()
//                      kind Constructor
    public static final List x = Collections.singletonList(42);
//                      ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                           ^ definition semanticdb maven . . minimized/RawTypes#x.
//                             display_name x
//                             signature_documentation java public static final List x
//                             enclosing_range 7 2 61
//                             kind StaticField
//                               ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                           ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#singletonList().
  }
