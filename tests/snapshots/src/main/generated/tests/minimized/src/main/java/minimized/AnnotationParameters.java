package minimized;

interface Foo {
//        ^^^ definition semanticdb maven . . minimized/Foo#
//            display_name Foo
//            signature_documentation java interface Foo
//            kind Interface
   @Bar(-1d)
   double test();

   @Bar(~5)
   double test2();

   @BarB(!true)
   double test3();
}

@interface Bar {
//         ^^^ definition semanticdb maven . . minimized/Bar#
//             display_name Bar
//             signature_documentation java @interface Bar
//             kind Interface
//             relationship is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
   double value();
}

@interface BarB {
//         ^^^^ definition semanticdb maven . . minimized/BarB#
//              display_name BarB
//              signature_documentation java @interface BarB
//              kind Interface
//              relationship is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
   boolean value();
//         ^^^^^ definition semanticdb maven . . minimized/BarB#value().
//               display_name value
//               signature_documentation java public abstract boolean value()
//               kind AbstractMethod
}
