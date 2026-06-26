  package minimized;
  
  import java.util.Collections;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^^^^^^^^ reference scip-java maven jdk 17 java/util/Collections#
  import java.util.List;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^ reference scip-java maven jdk 17 java/util/List#
  
//⌄ enclosing_range_start scip-java maven . . minimized/RawTypes#
  @SuppressWarnings("ALL")
// ^^^^^^^^^^^^^^^^ reference scip-java maven jdk 17 java/lang/SuppressWarnings#
  public class RawTypes {
//             ^^^^^^^^ definition scip-java maven . . minimized/RawTypes#
//                      kind Class
//                      display_name RawTypes
//                      signature_documentation
//                      > @SuppressWarnings("ALL")
//                      > public class RawTypes
//             ^^^^^^^^ definition scip-java maven . . minimized/RawTypes#`<init>`().
//                      kind Constructor
//                      display_name <init>
//                      signature_documentation
//                      > public RawTypes()
//  ⌄ enclosing_range_start scip-java maven . . minimized/RawTypes#x.
    public static final List x = Collections.singletonList(42);
//                      ^^^^ reference scip-java maven jdk 17 java/util/List#
//                           ^ definition scip-java maven . . minimized/RawTypes#x.
//                             kind StaticField
//                             display_name x
//                             signature_documentation
//                             > public static final List x
//                               ^^^^^^^^^^^ reference scip-java maven jdk 17 java/util/Collections#
//                                           ^^^^^^^^^^^^^ reference scip-java maven jdk 17 java/util/Collections#singletonList().
//                                                            ⌃ enclosing_range_end scip-java maven . . minimized/RawTypes#x.
  }
//⌃ enclosing_range_end scip-java maven . . minimized/RawTypes#
  
