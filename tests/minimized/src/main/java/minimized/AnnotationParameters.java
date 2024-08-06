package minimized;


@interface Bar {
   double value();
}

@interface BarB {
   boolean value();
}

interface Foo {
   @Bar(-1d)
   double test();

   @Bar(~5)
   @SuppressWarnings(value = "unchecked")
   double test2();

   @BarB(!true)
   double test3();
}

