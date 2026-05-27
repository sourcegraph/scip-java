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
// ^^^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/Documented#
  @Retention(RetentionPolicy.RUNTIME)
// ^^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/Retention#
//           ^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/RetentionPolicy#
//                           ^^^^^^^ reference scip-java maven jdk 11 java/lang/annotation/RetentionPolicy#RUNTIME.
  @Target(value = {CONSTRUCTOR,
// ^^^^^ reference scip-java maven jdk 11 java/lang/annotation/Target#
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
//                              display_name Annotations
//                              signature_documentation java @Documented\n@Retention\n@Target\npublic abstract @interface Annotations implements Annotation
//                              kind Interface
//                              relationship is_implementation scip-java maven jdk 11 java/lang/annotation/Annotation#
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Annotations#value().
    String value() default "";
//  ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//         ^^^^^ definition scip-java maven . . minimized/Annotations#value().
//               display_name value
//               signature_documentation java public abstract String value()
//               kind AbstractMethod
//                           ⌃ enclosing_range_end scip-java maven . . minimized/Annotations#value().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Annotations#format().
    String format() default "";
//  ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//         ^^^^^^ definition scip-java maven . . minimized/Annotations#format().
//                display_name format
//                signature_documentation java public abstract String format()
//                kind AbstractMethod
//                            ⌃ enclosing_range_end scip-java maven . . minimized/Annotations#format().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/Annotations#
