package minimized;

import java.lang.annotation.ElementType;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^^^^ reference semanticdb maven . . java/lang/annotation/
//                          ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/ElementType#
import java.lang.annotation.Target;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^^^^ reference semanticdb maven . . java/lang/annotation/
//                          ^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/Target#

@Target({ ElementType.TYPE_USE })
//^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/Target#
//        ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/ElementType#
//                    ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/ElementType#TYPE_USE.
@interface TypeAnnotation {
//         ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/TypeAnnotation#
//                        display_name TypeAnnotation
//                        signature_documentation java @Target({ElementType.TYPE_USE})\n@interface TypeAnnotation
//                        kind Interface
//                        relationship is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
    int integer() default 1;
//      ^^^^^^^ definition semanticdb maven . . minimized/TypeAnnotation#integer().
//              display_name integer
//              signature_documentation java public abstract int integer()
//              kind AbstractMethod
}

// FIXME(issue: GRAPH-1122): Definition range for T below is incorrect
class ClassProcessed<@TypeAnnotation T extends Number> {
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/ClassProcessed#
//                   display_name ClassProcessed
//                   signature_documentation java class ClassProcessed<T extends Number>
//                   kind Class
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/ClassProcessed#[T]
//                                                    display_name T
//                                                    signature_documentation java T extends Number
//                                                    kind TypeParameter
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/TypeAnnotation#
//                                             ^^^^^^ reference semanticdb maven jdk 11 java/lang/Number#

    public ClassProcessed() {
//         ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/ClassProcessed#`<init>`().
//                        display_name <init>
//                        signature_documentation java public ClassProcessed()
//                        kind Constructor
        String s = new @TypeAnnotation String();
//      ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//             ^ definition local 0
//               display_name s
//               signature_documentation java String s
//               enclosing_symbol semanticdb maven . . minimized/ClassProcessed#`<init>`().
//               kind Variable
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/TypeAnnotation#
//                                     ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                     ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#`<init>`().
    }
}
