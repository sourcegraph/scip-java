package minimized;

@interface Bar {
//         ^^^ definition semanticdb maven . . minimized/Bar#
//             display_name Bar
//             signature_documentation java @interface Bar
//             kind Interface
//             relationship is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
→double value();
//      ^^^^^ definition semanticdb maven . . minimized/Bar#value().
//            display_name value
//            signature_documentation java public abstract double value()
//            kind AbstractMethod
}

@interface BarB {
//         ^^^^ definition semanticdb maven . . minimized/BarB#
//              display_name BarB
//              signature_documentation java @interface BarB
//              kind Interface
//              relationship is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
→boolean value();
//       ^^^^^ definition semanticdb maven . . minimized/BarB#value().
//             display_name value
//             signature_documentation java public abstract boolean value()
//             kind AbstractMethod
}

@interface Nullable {
//         ^^^^^^^^ definition semanticdb maven . . minimized/Nullable#
//                  display_name Nullable
//                  signature_documentation java @interface Nullable
//                  kind Interface
//                  relationship is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
→String value() default "";
//^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//      ^^^^^ definition semanticdb maven . . minimized/Nullable#value().
//            display_name value
//            signature_documentation java public abstract String value()
//            kind AbstractMethod
}


@interface BarRef{
//         ^^^^^^ definition semanticdb maven . . minimized/BarRef#
//                display_name BarRef
//                signature_documentation java @interface BarRef
//                kind Interface
//                relationship is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
→SuppressWarnings value();
//^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
//                ^^^^^ definition semanticdb maven . . minimized/BarRef#value().
//                      display_name value
//                      signature_documentation java public abstract SuppressWarnings value()
//                      kind AbstractMethod
}

interface Foo {
//        ^^^ definition semanticdb maven . . minimized/Foo#
//            display_name Foo
//            signature_documentation java interface Foo
//            kind Interface
→@Bar(-1d)
//^^^ reference semanticdb maven . . minimized/Bar#
→double test();
//      ^^^^ definition semanticdb maven . . minimized/Foo#test().
//           display_name test
//           signature_documentation java @Bar(-1.0)\npublic abstract double test()
//           kind AbstractMethod

→@Bar(~5)
//^^^ reference semanticdb maven . . minimized/Bar#
→@SuppressWarnings(value = "unchecked")
//^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
//                 ^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#value().
→double test2();
//      ^^^^^ definition semanticdb maven . . minimized/Foo#test2().
//            display_name test2
//            signature_documentation java @Bar(~5)\n@SuppressWarnings("unchecked")\npublic abstract double test2()
//            kind AbstractMethod

→@BarB(!true)
//^^^^ reference semanticdb maven . . minimized/BarB#
→double test3();
//      ^^^^^ definition semanticdb maven . . minimized/Foo#test3().
//            display_name test3
//            signature_documentation java @BarB(!true)\npublic abstract double test3()
//            kind AbstractMethod

→@Nullable(("what"))
//^^^^^^^^ reference semanticdb maven . . minimized/Nullable#
→Foo test4();
//^^ reference semanticdb maven . . minimized/Foo#
//   ^^^^^ definition semanticdb maven . . minimized/Foo#test4().
//         display_name test4
//         signature_documentation java @Nullable("what")\npublic abstract Foo test4()
//         kind AbstractMethod

→@Bar((double) -1)
//^^^ reference semanticdb maven . . minimized/Bar#
→double testCast();
//      ^^^^^^^^ definition semanticdb maven . . minimized/Foo#testCast().
//               display_name testCast
//               signature_documentation java @Bar((double) -1)\npublic abstract double testCast()
//               kind AbstractMethod
}

interface TestRef {
//        ^^^^^^^ definition semanticdb maven . . minimized/TestRef#
//                display_name TestRef
//                signature_documentation java interface TestRef
//                kind Interface
→@BarRef(@SuppressWarnings(value = "unchecked"))
//^^^^^^ reference semanticdb maven . . minimized/BarRef#
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
//                         ^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#value().
→abstract double testCase();
//               ^^^^^^^^ definition semanticdb maven . . minimized/TestRef#testCase().
//                        display_name testCase
//                        signature_documentation java @BarRef(@SuppressWarnings("unchecked"))\npublic abstract double testCase()
//                        kind AbstractMethod
}
