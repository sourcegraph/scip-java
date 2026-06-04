  package minimized;
  
  import java.io.Serializable;
//       ^^^^ reference scip-java maven . . java/
//            ^^ reference scip-java maven . . java/io/
//               ^^^^^^^^^^^^ reference scip-java maven jdk 11 java/io/Serializable#
  
//⌄ enclosing_range_start scip-java maven . . minimized/EnumImplementsInterface#
  enum EnumImplementsInterface implements Serializable {
//     ^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/EnumImplementsInterface#
//                             display_name EnumImplementsInterface
//                             signature_documentation java enum EnumImplementsInterface implements Serializable
//                             kind Enum
//                             relationship is_implementation scip-java maven jdk 11 java/io/Serializable#
//                             relationship is_implementation scip-java maven jdk 11 java/lang/Comparable#
//                             relationship is_implementation scip-java maven jdk 11 java/lang/Enum#
//     ^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/EnumImplementsInterface#`<init>`().
//                             display_name <init>
//                             signature_documentation java private EnumImplementsInterface()
//                             kind Constructor
//                                        ^^^^^^^^^^^^ reference scip-java maven jdk 11 java/io/Serializable#
//  ⌄ enclosing_range_start scip-java maven . . minimized/EnumImplementsInterface#A.
    A,
//  ^ definition scip-java maven . . minimized/EnumImplementsInterface#A.
//    display_name A
//    signature_documentation java EnumImplementsInterface.A /* ordinal 0 */
//  ^ reference scip-java maven . . minimized/EnumImplementsInterface#`<init>`().
//  ⌃ enclosing_range_end scip-java maven . . minimized/EnumImplementsInterface#A.
//  ⌄ enclosing_range_start scip-java maven . . minimized/EnumImplementsInterface#B.
    B
//  ^ definition scip-java maven . . minimized/EnumImplementsInterface#B.
//    display_name B
//    signature_documentation java EnumImplementsInterface.B /* ordinal 1 */
//  ^ reference scip-java maven . . minimized/EnumImplementsInterface#`<init>`().
//  ⌃ enclosing_range_end scip-java maven . . minimized/EnumImplementsInterface#B.
  }
//⌃ enclosing_range_end scip-java maven . . minimized/EnumImplementsInterface#
