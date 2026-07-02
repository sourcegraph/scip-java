  package minimized;
  
  import java.io.Serializable;
//       ^^^^ reference scip-java maven . . java/
//            ^^ reference scip-java maven . . java/io/
//               ^^^^^^^^^^^^ reference scip-java maven jdk 17 java/io/Serializable#
  
//⌄ enclosing_range_start scip-java maven . . minimized/EnumImplementsInterface#
  enum EnumImplementsInterface implements Serializable {
//     ^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/EnumImplementsInterface#
//                             kind Enum
//                             display_name EnumImplementsInterface
//                             signature_documentation
//                             > enum EnumImplementsInterface implements Serializable
//                             relationship scip-java maven jdk 17 java/io/Serializable# implementation
//                             relationship scip-java maven jdk 17 java/lang/Comparable# implementation
//                             relationship scip-java maven jdk 17 java/lang/Enum# implementation
//                             relationship scip-java maven jdk 17 java/lang/constant/Constable# implementation
//     ^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/EnumImplementsInterface#`<init>`().
//                             kind Constructor
//                             display_name <init>
//                             signature_documentation
//                             > private EnumImplementsInterface()
//                                        ^^^^^^^^^^^^ reference scip-java maven jdk 17 java/io/Serializable#
//  ⌄ enclosing_range_start scip-java maven . . minimized/EnumImplementsInterface#A.
    A,
//  ^ definition scip-java maven . . minimized/EnumImplementsInterface#A.
//    display_name A
//    signature_documentation
//    > EnumImplementsInterface.A /* ordinal 0 */
//  ^ reference scip-java maven . . minimized/EnumImplementsInterface#`<init>`().
//  ⌃ enclosing_range_end scip-java maven . . minimized/EnumImplementsInterface#A.
//  ⌄ enclosing_range_start scip-java maven . . minimized/EnumImplementsInterface#B.
    B
//  ^ definition scip-java maven . . minimized/EnumImplementsInterface#B.
//    display_name B
//    signature_documentation
//    > EnumImplementsInterface.B /* ordinal 1 */
//  ^ reference scip-java maven . . minimized/EnumImplementsInterface#`<init>`().
//  ⌃ enclosing_range_end scip-java maven . . minimized/EnumImplementsInterface#B.
  }
//⌃ enclosing_range_end scip-java maven . . minimized/EnumImplementsInterface#
  
