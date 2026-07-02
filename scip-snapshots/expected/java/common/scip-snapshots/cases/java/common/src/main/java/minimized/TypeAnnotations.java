  package minimized;
  
  import java.lang.annotation.ElementType;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/lang/
//                 ^^^^^^^^^^ reference scip-java maven . . java/lang/annotation/
//                            ^^^^^^^^^^^ reference scip-java maven jdk 17 java/lang/annotation/ElementType#
  import java.lang.annotation.Target;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/lang/
//                 ^^^^^^^^^^ reference scip-java maven . . java/lang/annotation/
//                            ^^^^^^ reference scip-java maven jdk 17 java/lang/annotation/Target#
  
//⌄ enclosing_range_start scip-java maven . . minimized/TypeAnnotation#
  @Target({ ElementType.TYPE_USE })
// ^^^^^^ reference scip-java maven jdk 17 java/lang/annotation/Target#
//          ^^^^^^^^^^^ reference scip-java maven jdk 17 java/lang/annotation/ElementType#
//                      ^^^^^^^^ reference scip-java maven jdk 17 java/lang/annotation/ElementType#TYPE_USE.
  @interface TypeAnnotation {
//           ^^^^^^^^^^^^^^ definition scip-java maven . . minimized/TypeAnnotation#
//                          kind Interface
//                          display_name TypeAnnotation
//                          signature_documentation
//                          > @Target({ElementType.TYPE_USE})
//                          > @interface TypeAnnotation
//                          relationship scip-java maven jdk 17 java/lang/annotation/Annotation# implementation
//    ⌄ enclosing_range_start scip-java maven . . minimized/TypeAnnotation#integer().
      int integer() default 1;
//        ^^^^^^^ definition scip-java maven . . minimized/TypeAnnotation#integer().
//                kind AbstractMethod
//                display_name integer
//                signature_documentation
//                > public abstract int integer()
//                           ⌃ enclosing_range_end scip-java maven . . minimized/TypeAnnotation#integer().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/TypeAnnotation#
  
  // FIXME(issue: GRAPH-1122): Definition range for T below is incorrect
//⌄ enclosing_range_start scip-java maven . . minimized/ClassProcessed#
//⌄ enclosing_range_start scip-java maven . . minimized/ClassProcessed#[T]
  class ClassProcessed<@TypeAnnotation T extends Number> {
//      ^^^^^^^^^^^^^^ definition scip-java maven . . minimized/ClassProcessed#
//                     kind Class
//                     display_name ClassProcessed
//                     signature_documentation
//                     > class ClassProcessed<T extends Number>
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/ClassProcessed#[T]
//                                                      kind TypeParameter
//                                                      display_name T
//                                                      signature_documentation
//                                                      > T extends Number
//                      ^^^^^^^^^^^^^^ reference scip-java maven . . minimized/TypeAnnotation#
//                                               ^^^^^^ reference scip-java maven jdk 17 java/lang/Number#
  
//    ⌄ enclosing_range_start scip-java maven . . minimized/ClassProcessed#`<init>`().
      public ClassProcessed() {
//           ^^^^^^^^^^^^^^ definition scip-java maven . . minimized/ClassProcessed#`<init>`().
//                          kind Constructor
//                          display_name <init>
//                          signature_documentation
//                          > public ClassProcessed()
//        ⌄ enclosing_range_start local 0
          String s = new @TypeAnnotation String();
//        ^^^^^^ reference scip-java maven jdk 17 java/lang/String#
//               ^ definition local 0
//                 kind Variable
//                 display_name s
//                 signature_documentation
//                 > String s
//                        ^^^^^^^^^^^^^^ reference scip-java maven . . minimized/TypeAnnotation#
//                                       ^^^^^^ reference scip-java maven jdk 17 java/lang/String#`<init>`().
//                                       ^^^^^^ reference scip-java maven jdk 17 java/lang/String#
//                                               ⌃ enclosing_range_end local 0
      }
//    ⌃ enclosing_range_end scip-java maven . . minimized/ClassProcessed#`<init>`().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/ClassProcessed#
//⌃ enclosing_range_end scip-java maven . . minimized/ClassProcessed#[T]
  
