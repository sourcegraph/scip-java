package minimized;

import java.lang.annotation.Documented;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^^^^ reference semanticdb maven . . java/lang/annotation/
//                          ^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/Documented#
import java.lang.annotation.Retention;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^^^^ reference semanticdb maven . . java/lang/annotation/
//                          ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/Retention#
import java.lang.annotation.RetentionPolicy;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^^^^ reference semanticdb maven . . java/lang/annotation/
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/RetentionPolicy#
import java.lang.annotation.Target;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^^^^ reference semanticdb maven . . java/lang/annotation/
//                          ^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/Target#

import static java.lang.annotation.ElementType.*;
//            ^^^^ reference semanticdb maven . . java/
//                 ^^^^ reference semanticdb maven . . java/lang/
//                      ^^^^^^^^^^ reference semanticdb maven . . java/lang/annotation/
//                                 ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/ElementType#

@Documented
//^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/Documented#
@Retention(RetentionPolicy.RUNTIME)
//^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/Retention#
//         ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/RetentionPolicy#
//                         ^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/RetentionPolicy#RUNTIME.
@Target(value = {CONSTRUCTOR,
//^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/Target#
//      ^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/Target#value().
//               ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/ElementType#CONSTRUCTOR.
        FIELD,
//      ^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/ElementType#FIELD.
        LOCAL_VARIABLE,
//      ^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/ElementType#LOCAL_VARIABLE.
        METHOD,
//      ^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/ElementType#METHOD.
        PACKAGE,
//      ^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/ElementType#PACKAGE.
        PARAMETER,
//      ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/ElementType#PARAMETER.
        TYPE}
//      ^^^^ reference semanticdb maven jdk 11 java/lang/annotation/ElementType#TYPE.
)
public @interface Annotations {
//                ^^^^^^^^^^^ definition semanticdb maven . . minimized/Annotations#
//                            documentation ```java\n@Documented\n@Retention(RetentionPolicy.RUNTIME)\n@Target({CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})\npublic @interface Annotations\n```
//                            relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#

  String value() default "";
//^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//       ^^^^^ definition semanticdb maven . . minimized/Annotations#value().
//             documentation ```java\npublic abstract String value()\n```

  String format() default "";
//^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//       ^^^^^^ definition semanticdb maven . . minimized/Annotations#format().
//              documentation ```java\npublic abstract String format()\n```
}
