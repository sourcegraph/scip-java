package minimized;

import java.lang.annotation.Documented;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^^ reference java/lang/annotation/Documented#
import java.lang.annotation.Retention;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^ reference java/lang/annotation/Retention#
import java.lang.annotation.RetentionPolicy;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
import java.lang.annotation.Target;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^ reference java/lang/annotation/Target#

import static java.lang.annotation.ElementType.*;
//            ^^^^ reference java/
//                 ^^^^ reference java/lang/
//                      ^^^^^^^^^^ reference java/lang/annotation/
//                                 ^^^^^^^^^^^ reference java/lang/annotation/ElementType#

@Documented
//^^^^^^^^^ reference java/lang/annotation/Documented#
@Retention(RetentionPolicy.RUNTIME)
//^^^^^^^^ reference java/lang/annotation/Retention#
//         ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
//                         ^^^^^^^ reference java/lang/annotation/RetentionPolicy#RUNTIME.
@Target(value = {CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
//^^^^^ reference java/lang/annotation/Target#
//      ^^^^^ reference java/lang/annotation/Target#value().
//               ^^^^^^^^^^^ reference java/lang/annotation/ElementType#CONSTRUCTOR.
//                            ^^^^^ reference java/lang/annotation/ElementType#FIELD.
//                                   ^^^^^^^^^^^^^^ reference java/lang/annotation/ElementType#LOCAL_VARIABLE.
//                                                   ^^^^^^ reference java/lang/annotation/ElementType#METHOD.
//                                                           ^^^^^^^ reference java/lang/annotation/ElementType#PACKAGE.
//                                                                    ^^^^^^^^^ reference java/lang/annotation/ElementType#PARAMETER.
//                                                                               ^^^^ reference java/lang/annotation/ElementType#TYPE.
public @interface Annotations {
//                ^^^^^^^^^^^ definition minimized/Annotations# public abstract Annotations extends Annotation

  String value() default "";
//^^^^^^ reference java/lang/String#
//       ^^^^^ definition minimized/Annotations#value(). public abstract String value()

  String format() default "";
//^^^^^^ reference java/lang/String#
//       ^^^^^^ definition minimized/Annotations#format(). public abstract String format()
}
