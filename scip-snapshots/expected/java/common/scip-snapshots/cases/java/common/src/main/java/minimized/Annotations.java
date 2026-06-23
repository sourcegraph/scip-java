  package minimized;
  
  import java.lang.annotation.Documented;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/lang/
//                 ^^^^^^^^^^ reference scip-java maven . . java/lang/annotation/
//                            ^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/Documented#
  import java.lang.annotation.Retention;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/lang/
//                 ^^^^^^^^^^ reference scip-java maven . . java/lang/annotation/
//                            ^^^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/Retention#
  import java.lang.annotation.RetentionPolicy;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/lang/
//                 ^^^^^^^^^^ reference scip-java maven . . java/lang/annotation/
//                            ^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/RetentionPolicy#
  import java.lang.annotation.Target;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/lang/
//                 ^^^^^^^^^^ reference scip-java maven . . java/lang/annotation/
//                            ^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/Target#
  
  import static java.lang.annotation.ElementType.*;
//              ^^^^ reference scip-java maven . . java/
//                   ^^^^ reference scip-java maven . . java/lang/
//                        ^^^^^^^^^^ reference scip-java maven . . java/lang/annotation/
//                                   ^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/ElementType#
  
//⌄ enclosing_range_start scip-java maven . . minimized/Annotations#
  @Documented
// ^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/Documented#
  @Retention(RetentionPolicy.RUNTIME)
// ^^^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/Retention#
//           ^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/RetentionPolicy#
//                           ^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/RetentionPolicy#RUNTIME.
  @Target(value = {CONSTRUCTOR,
// ^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/Target#
//        ^^^^^ reference scip-java maven jdk 11 java/lang/annotation/Target#value().
//                 ^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/ElementType#CONSTRUCTOR.
          FIELD,
//        ^^^^^ reference scip-java maven jdk 11 java/lang/annotation/ElementType#FIELD.
          LOCAL_VARIABLE,
//        ^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/ElementType#LOCAL_VARIABLE.
          METHOD,
//        ^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/ElementType#METHOD.
          PACKAGE,
//        ^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/ElementType#PACKAGE.
          PARAMETER,
//        ^^^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/ElementType#PARAMETER.
          TYPE}
//        ^^^^ reference scip-java maven jdk 11 java/lang/annotation/ElementType#TYPE.
  )
  public @interface Annotations {
//                  ^^^^^^^^^^^ definition scip-java maven . . minimized/Annotations#
//                              kind Interface
//                              display_name Annotations
//                              signature_documentation
//                              > @Documented
//                              > @Retention(RetentionPolicy.RUNTIME)
//                              > @Target({CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
//                              > public @interface Annotations
//                              relationship scip-java maven jdk 11 java/lang/annotation/Annotation# implementation
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Annotations#value().
    String value() default "";
//  ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//         ^^^^^ definition scip-java maven . . minimized/Annotations#value().
//               kind AbstractMethod
//               display_name value
//               signature_documentation
//               > public abstract String value()
//                           ⌃ enclosing_range_end scip-java maven . . minimized/Annotations#value().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Annotations#format().
    String format() default "";
//  ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//         ^^^^^^ definition scip-java maven . . minimized/Annotations#format().
//                kind AbstractMethod
//                display_name format
//                signature_documentation
//                > public abstract String format()
//                            ⌃ enclosing_range_end scip-java maven . . minimized/Annotations#format().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/Annotations#
  
