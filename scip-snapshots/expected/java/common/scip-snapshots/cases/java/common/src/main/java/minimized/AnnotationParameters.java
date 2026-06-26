  package minimized;
  
//⌄ enclosing_range_start scip-java maven . . minimized/Bar#
  @interface Bar {
//           ^^^ definition scip-java maven . . minimized/Bar#
//               kind Interface
//               display_name Bar
//               signature_documentation
//               > @interface Bar
//               relationship scip-java maven jdk 17 java/lang/annotation/Annotation# implementation
//  ⌄ enclosing_range_start scip-java maven . . minimized/Bar#value().
    double value();
//         ^^^^^ definition scip-java maven . . minimized/Bar#value().
//               kind AbstractMethod
//               display_name value
//               signature_documentation
//               > public abstract double value()
//                ⌃ enclosing_range_end scip-java maven . . minimized/Bar#value().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/Bar#
  
//⌄ enclosing_range_start scip-java maven . . minimized/BarB#
  @interface BarB {
//           ^^^^ definition scip-java maven . . minimized/BarB#
//                kind Interface
//                display_name BarB
//                signature_documentation
//                > @interface BarB
//                relationship scip-java maven jdk 17 java/lang/annotation/Annotation# implementation
//  ⌄ enclosing_range_start scip-java maven . . minimized/BarB#value().
    boolean value();
//          ^^^^^ definition scip-java maven . . minimized/BarB#value().
//                kind AbstractMethod
//                display_name value
//                signature_documentation
//                > public abstract boolean value()
//                 ⌃ enclosing_range_end scip-java maven . . minimized/BarB#value().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/BarB#
  
//⌄ enclosing_range_start scip-java maven . . minimized/Nullable#
  @interface Nullable {
//           ^^^^^^^^ definition scip-java maven . . minimized/Nullable#
//                    kind Interface
//                    display_name Nullable
//                    signature_documentation
//                    > @interface Nullable
//                    relationship scip-java maven jdk 17 java/lang/annotation/Annotation# implementation
//  ⌄ enclosing_range_start scip-java maven . . minimized/Nullable#value().
    String value() default "";
//  ^^^^^^ reference scip-java maven jdk 17 java/lang/String#
//         ^^^^^ definition scip-java maven . . minimized/Nullable#value().
//               kind AbstractMethod
//               display_name value
//               signature_documentation
//               > public abstract String value()
//                           ⌃ enclosing_range_end scip-java maven . . minimized/Nullable#value().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/Nullable#
  
  
//⌄ enclosing_range_start scip-java maven . . minimized/BarRef#
  @interface BarRef{
//           ^^^^^^ definition scip-java maven . . minimized/BarRef#
//                  kind Interface
//                  display_name BarRef
//                  signature_documentation
//                  > @interface BarRef
//                  relationship scip-java maven jdk 17 java/lang/annotation/Annotation# implementation
//  ⌄ enclosing_range_start scip-java maven . . minimized/BarRef#value().
    SuppressWarnings value();
//  ^^^^^^^^^^^^^^^^ reference scip-java maven jdk 17 java/lang/SuppressWarnings#
//                   ^^^^^ definition scip-java maven . . minimized/BarRef#value().
//                         kind AbstractMethod
//                         display_name value
//                         signature_documentation
//                         > public abstract SuppressWarnings value()
//                          ⌃ enclosing_range_end scip-java maven . . minimized/BarRef#value().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/BarRef#
  
//⌄ enclosing_range_start scip-java maven . . minimized/Foo#
  interface Foo {
//          ^^^ definition scip-java maven . . minimized/Foo#
//              kind Interface
//              display_name Foo
//              signature_documentation
//              > interface Foo
//  ⌄ enclosing_range_start scip-java maven . . minimized/Foo#test().
    @Bar(-1d)
//   ^^^ reference scip-java maven . . minimized/Bar#
    double test();
//         ^^^^ definition scip-java maven . . minimized/Foo#test().
//              kind AbstractMethod
//              display_name test
//              signature_documentation
//              > @Bar(-1.0)
//              > public abstract double test()
//               ⌃ enclosing_range_end scip-java maven . . minimized/Foo#test().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Foo#test2().
    @Bar(~5)
//   ^^^ reference scip-java maven . . minimized/Bar#
    @SuppressWarnings(value = "unchecked")
//   ^^^^^^^^^^^^^^^^ reference scip-java maven jdk 17 java/lang/SuppressWarnings#
//                    ^^^^^ reference scip-java maven jdk 17 java/lang/SuppressWarnings#value().
    double test2();
//         ^^^^^ definition scip-java maven . . minimized/Foo#test2().
//               kind AbstractMethod
//               display_name test2
//               signature_documentation
//               > @Bar(~5)
//               > @SuppressWarnings("unchecked")
//               > public abstract double test2()
//                ⌃ enclosing_range_end scip-java maven . . minimized/Foo#test2().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Foo#test3().
    @BarB(!true)
//   ^^^^ reference scip-java maven . . minimized/BarB#
    double test3();
//         ^^^^^ definition scip-java maven . . minimized/Foo#test3().
//               kind AbstractMethod
//               display_name test3
//               signature_documentation
//               > @BarB(!true)
//               > public abstract double test3()
//                ⌃ enclosing_range_end scip-java maven . . minimized/Foo#test3().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Foo#test4().
    @Nullable(("what"))
//   ^^^^^^^^ reference scip-java maven . . minimized/Nullable#
    Foo test4();
//  ^^^ reference scip-java maven . . minimized/Foo#
//      ^^^^^ definition scip-java maven . . minimized/Foo#test4().
//            kind AbstractMethod
//            display_name test4
//            signature_documentation
//            > @Nullable("what")
//            > public abstract Foo test4()
//             ⌃ enclosing_range_end scip-java maven . . minimized/Foo#test4().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Foo#testCast().
    @Bar((double) -1)
//   ^^^ reference scip-java maven . . minimized/Bar#
    double testCast();
//         ^^^^^^^^ definition scip-java maven . . minimized/Foo#testCast().
//                  kind AbstractMethod
//                  display_name testCast
//                  signature_documentation
//                  > @Bar((double) -1)
//                  > public abstract double testCast()
//                   ⌃ enclosing_range_end scip-java maven . . minimized/Foo#testCast().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/Foo#
  
//⌄ enclosing_range_start scip-java maven . . minimized/TestRef#
  interface TestRef {
//          ^^^^^^^ definition scip-java maven . . minimized/TestRef#
//                  kind Interface
//                  display_name TestRef
//                  signature_documentation
//                  > interface TestRef
//  ⌄ enclosing_range_start scip-java maven . . minimized/TestRef#testCase().
    @BarRef(@SuppressWarnings(value = "unchecked"))
//   ^^^^^^ reference scip-java maven . . minimized/BarRef#
//           ^^^^^^^^^^^^^^^^ reference scip-java maven jdk 17 java/lang/SuppressWarnings#
//                            ^^^^^ reference scip-java maven jdk 17 java/lang/SuppressWarnings#value().
    abstract double testCase();
//                  ^^^^^^^^ definition scip-java maven . . minimized/TestRef#testCase().
//                           kind AbstractMethod
//                           display_name testCase
//                           signature_documentation
//                           > @BarRef(@SuppressWarnings("unchecked"))
//                           > public abstract double testCase()
//                            ⌃ enclosing_range_end scip-java maven . . minimized/TestRef#testCase().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/TestRef#
  
