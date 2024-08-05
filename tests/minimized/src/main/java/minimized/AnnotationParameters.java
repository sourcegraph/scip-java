package minimized;

interface Foo {
   @Bar(-1d)
   double test();

   @Bar(~5)
   double test2();

   @BarB(!true)
   double test3();
}

@interface Bar {
   double value();
}

@interface BarB {
   boolean value();
}
