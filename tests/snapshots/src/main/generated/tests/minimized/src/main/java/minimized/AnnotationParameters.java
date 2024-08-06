package minimized;

@interface Bar {
//         ^^^ definition semanticdb maven . . minimized/Bar#
//             display_name Bar
//             signature_documentation java @interface Bar
//             kind Interface
//             relationship is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
→double value();
}

@interface BarB {
//         ^^^^ definition semanticdb maven . . minimized/BarB#
//              display_name BarB
//              signature_documentation java @interface BarB
//              kind Interface
//              relationship is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
→boolean value();
}

@interface Nullable {
//         ^^^^^^^^ definition semanticdb maven . . minimized/Nullable#
//                  display_name Nullable
//                  signature_documentation java @interface Nullable
//                  kind Interface
//                  relationship is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
→String value() default "";
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
}
