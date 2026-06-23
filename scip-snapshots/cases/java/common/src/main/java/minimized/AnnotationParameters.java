package minimized;

@interface Bar {
  double value();
}

@interface BarB {
  boolean value();
}

@interface Nullable {
  String value() default "";
}


@interface BarRef{
  SuppressWarnings value();
}

interface Foo {
  @Bar(-1d)
  double test();

  @Bar(~5)
  @SuppressWarnings(value = "unchecked")
  double test2();

  @BarB(!true)
  double test3();

  @Nullable(("what"))
  Foo test4();

  @Bar((double) -1)
  double testCast();
}

interface TestRef {
  @BarRef(@SuppressWarnings(value = "unchecked"))
  abstract double testCase();
}
