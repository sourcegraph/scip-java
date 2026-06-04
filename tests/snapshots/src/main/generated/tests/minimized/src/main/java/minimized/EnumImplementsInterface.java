  package minimized;
  
  import java.io.Serializable;
//       ^^^^ reference semanticdb maven . . java/
//            ^^ reference semanticdb maven . . java/io/
//               ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/Serializable#
  
//⌄ enclosing_range_start semanticdb maven . . minimized/EnumImplementsInterface#
  enum EnumImplementsInterface implements Serializable {
//     ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/EnumImplementsInterface#
//                             display_name EnumImplementsInterface
//                             signature_documentation java enum EnumImplementsInterface implements Serializable
//                             kind Enum
//                             relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//                             relationship is_implementation semanticdb maven jdk 11 java/lang/Comparable#
//                             relationship is_implementation semanticdb maven jdk 11 java/lang/Enum#
//     ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/EnumImplementsInterface#`<init>`().
//                             display_name <init>
//                             signature_documentation java private EnumImplementsInterface()
//                             kind Constructor
//                                        ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/Serializable#
//  ⌄ enclosing_range_start semanticdb maven . . minimized/EnumImplementsInterface#A.
    A,
//  ^ definition semanticdb maven . . minimized/EnumImplementsInterface#A.
//    display_name A
//    signature_documentation java EnumImplementsInterface.A /* ordinal 0 */
//  ^ reference semanticdb maven . . minimized/EnumImplementsInterface#`<init>`().
//  ⌃ enclosing_range_end semanticdb maven . . minimized/EnumImplementsInterface#A.
//  ⌄ enclosing_range_start semanticdb maven . . minimized/EnumImplementsInterface#B.
    B
//  ^ definition semanticdb maven . . minimized/EnumImplementsInterface#B.
//    display_name B
//    signature_documentation java EnumImplementsInterface.B /* ordinal 1 */
//  ^ reference semanticdb maven . . minimized/EnumImplementsInterface#`<init>`().
//  ⌃ enclosing_range_end semanticdb maven . . minimized/EnumImplementsInterface#B.
  }
//⌃ enclosing_range_end semanticdb maven . . minimized/EnumImplementsInterface#
