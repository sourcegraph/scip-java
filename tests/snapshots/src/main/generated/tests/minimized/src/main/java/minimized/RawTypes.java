  package minimized;
  
  import java.util.Collections;
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/util/
//                 ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
  import java.util.List;
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/util/
//                 ^^^^ reference semanticdb maven jdk 11 java/util/List#
  
//⌄ enclosing_range_start semanticdb maven . . minimized/RawTypes#
  @SuppressWarnings("ALL")
// ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
  public class RawTypes {
//             ^^^^^^^^ definition semanticdb maven . . minimized/RawTypes#
//                      display_name RawTypes
//                      signature_documentation java @SuppressWarnings("ALL")\npublic class RawTypes
//                      kind Class
//             ^^^^^^^^ definition semanticdb maven . . minimized/RawTypes#`<init>`().
//                      display_name <init>
//                      signature_documentation java public RawTypes()
//                      kind Constructor
//  ⌄ enclosing_range_start semanticdb maven . . minimized/RawTypes#x.
    public static final List x = Collections.singletonList(42);
//                      ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                           ^ definition semanticdb maven . . minimized/RawTypes#x.
//                             display_name x
//                             signature_documentation java public static final List x
//                             kind StaticField
//                               ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                           ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#singletonList().
//                                                            ⌃ enclosing_range_end semanticdb maven . . minimized/RawTypes#x.
  }
//⌃ enclosing_range_end semanticdb maven . . minimized/RawTypes#
