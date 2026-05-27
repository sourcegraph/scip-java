  package minimized;
  
  import java.util.Collections;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^^^^^^^^ reference scip-java maven jdk 11 java/util/Collections#
  import java.util.List;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^ reference scip-java maven jdk 11 java/util/List#
  
//⌄ enclosing_range_start scip-java maven . . minimized/RawTypes#
  @SuppressWarnings("ALL")
// ^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/SuppressWarnings#
  public class RawTypes {
//             ^^^^^^^^ definition scip-java maven . . minimized/RawTypes#
//                      display_name RawTypes
//                      signature_documentation java @SuppressWarnings\npublic class RawTypes
//                      kind Class
//             ^^^^^^^^ definition scip-java maven . . minimized/RawTypes#`<init>`().
//                      display_name <init>
//                      signature_documentation java public RawTypes()
//                      kind Constructor
//  ⌄ enclosing_range_start scip-java maven . . minimized/RawTypes#x.
    public static final List x = Collections.singletonList(42);
//                      ^^^^ reference scip-java maven jdk 11 java/util/List#
//                           ^ definition scip-java maven . . minimized/RawTypes#x.
//                             display_name x
//                             signature_documentation java public static final List x
//                             kind StaticField
//                               ^^^^^^^^^^^ reference scip-java maven jdk 11 java/util/Collections#
//                                           ^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/util/Collections#singletonList().
//                                                            ⌃ enclosing_range_end scip-java maven . . minimized/RawTypes#x.
  }
//⌃ enclosing_range_end scip-java maven . . minimized/RawTypes#
