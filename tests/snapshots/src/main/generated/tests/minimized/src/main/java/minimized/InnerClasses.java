package minimized;

public class InnerClasses {
//           ^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#
//                        documentation ```java\npublic class InnerClasses\n```

  private final int exampleField;
//                  ^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#exampleField.
//                               documentation ```java\nprivate final int exampleField\n```

  private static final String STRING = "asdf";
//                     ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                            ^^^^^^ definition semanticdb maven . . minimized/InnerClasses#STRING.
//                                   documentation ```java\nprivate static final String STRING\n```

  private static final int top = 5;
//                         ^^^ definition semanticdb maven . . minimized/InnerClasses#top.
//                             documentation ```java\nprivate static final int top\n```
  private static final int bottom = 10;
//                         ^^^^^^ definition semanticdb maven . . minimized/InnerClasses#bottom.
//                                documentation ```java\nprivate static final int bottom\n```

  public InnerClasses(int exampleField) {
//       ^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#`<init>`().
//                    documentation ```java\npublic InnerClasses(int exampleField)\n```
//                        ^^^^^^^^^^^^ definition local 0
//                                     documentation ```java\nint exampleField\n```
    this.exampleField = exampleField;
//       ^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#exampleField.
//                      ^^^^^^^^^^^^ reference local 0
  }

  public enum InnerEnum {
//            ^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerEnum#
//                      documentation ```java\npublic enum InnerEnum\n```
//                      relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//                      relationship is_implementation semanticdb maven jdk 11 java/lang/Comparable#
//                      relationship is_implementation semanticdb maven jdk 11 java/lang/Enum#
//            ^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerEnum#`<init>`().
//                      documentation ```java\nprivate InnerEnum()\n```
    A,
//  ^ definition semanticdb maven . . minimized/InnerClasses#InnerEnum#A.
//    documentation ```java\nInnerEnum.A /* ordinal 0 */\n```
    B,
//  ^ definition semanticdb maven . . minimized/InnerClasses#InnerEnum#B.
//    documentation ```java\nInnerEnum.B /* ordinal 1 */\n```
    C
//  ^ definition semanticdb maven . . minimized/InnerClasses#InnerEnum#C.
//    documentation ```java\nInnerEnum.C /* ordinal 2 */\n```
  }

  public interface InnerInterface<A, B> {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerInterface#
//                                documentation ```java\npublic interface InnerInterface<A, B>\n```
//                                ^ definition semanticdb maven . . minimized/InnerClasses#InnerInterface#[A]
//                                  documentation ```java\nA\n```
//                                   ^ definition semanticdb maven . . minimized/InnerClasses#InnerInterface#[B]
//                                     documentation ```java\nB\n```
    B apply(A a);
//  ^ reference semanticdb maven . . minimized/InnerClasses#InnerInterface#[B]
//    ^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerInterface#apply().
//          documentation ```java\npublic abstract B apply(A a)\n```
//          relationship is_reference is_implementation semanticdb maven . . minimized/InnerClasses#InnerClass#apply().
//          ^ reference semanticdb maven . . minimized/InnerClasses#InnerInterface#[A]
//            ^ definition local 1
//              documentation ```java\nA a\n```
  }

  public @interface InnerAnnotation {
//                  ^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerAnnotation#
//                                  documentation ```java\npublic @interface InnerAnnotation\n```
//                                  relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
    int value();
//      ^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerAnnotation#value().
//            documentation ```java\npublic abstract int value()\n```
  }

  @SuppressWarnings(STRING + " ")
// ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
//                  ^^^^^^ reference semanticdb maven . . minimized/InnerClasses#STRING.
  @InnerAnnotation(top / bottom)
// ^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerAnnotation#
//                 ^^^ reference semanticdb maven . . minimized/InnerClasses#top.
//                       ^^^^^^ reference semanticdb maven . . minimized/InnerClasses#bottom.
  public static class InnerStaticClass {
//                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerStaticClass#
//                                     documentation ```java\n@SuppressWarnings(STRING + " ")\n@InnerAnnotation(top / bottom)\npublic static class InnerStaticClass\n```
//                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerStaticClass#`<init>`().
//                                     documentation ```java\npublic InnerStaticClass()\n```

    public static void innerStaticMethod() {}
//                     ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerStaticClass#innerStaticMethod().
//                                       documentation ```java\npublic static void innerStaticMethod()\n```
  }

  public class InnerClass implements InnerInterface<Integer, Integer> {
//             ^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerClass#
//                        documentation ```java\npublic class InnerClass\n```
//                        relationship is_implementation semanticdb maven . . minimized/InnerClasses#InnerInterface#
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerInterface#
//                                                  ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                                                           ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
    private final int field;
//                    ^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerClass#field.
//                          documentation ```java\nprivate final int field\n```

    public InnerClass(int field) {
//         ^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerClass#`<init>`().
//                    documentation ```java\npublic InnerClass(int field)\n```
//                        ^^^^^ definition local 2
//                              documentation ```java\nint field\n```
      this.field = field;
//         ^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerClass#field.
//                 ^^^^^ reference local 2
    }

    public void innerMethod() {
//              ^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerClass#innerMethod().
//                          documentation ```java\npublic void innerMethod()\n```
      System.out.println(field + exampleField);
//    ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//           ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//               ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+3).
//                       ^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerClass#field.
//                               ^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#exampleField.
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public Integer apply(Integer integer) {
//         ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                 ^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerClass#apply().
//                       documentation ```java\n@Override\npublic Integer apply(Integer integer)\n```
//                       relationship is_reference is_implementation semanticdb maven . . minimized/InnerClasses#InnerInterface#apply().
//                       ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                               ^^^^^^^ definition local 3
//                                       documentation ```java\nInteger integer\n```
      return field * integer;
//           ^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerClass#field.
//                   ^^^^^^^ reference local 3
    }
  }

  private static <A, B> B runInnerInterface(InnerInterface<A, B> fn, A a) {
//                ^ definition semanticdb maven . . minimized/InnerClasses#runInnerInterface().[A]
//                  documentation ```java\nA\n```
//                   ^ definition semanticdb maven . . minimized/InnerClasses#runInnerInterface().[B]
//                     documentation ```java\nB\n```
//                      ^ reference semanticdb maven . . minimized/InnerClasses#runInnerInterface().[B]
//                        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#runInnerInterface().
//                                          documentation ```java\nprivate static <A, B> B runInnerInterface(InnerInterface<A, B> fn, A a)\n```
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerInterface#
//                                                         ^ reference semanticdb maven . . minimized/InnerClasses#runInnerInterface().[A]
//                                                            ^ reference semanticdb maven . . minimized/InnerClasses#runInnerInterface().[B]
//                                                               ^^ definition local 4
//                                                                  documentation ```java\nInnerInterface<A, B> fn\n```
//                                                                   ^ reference semanticdb maven . . minimized/InnerClasses#runInnerInterface().[A]
//                                                                     ^ definition local 5
//                                                                       documentation ```java\nA a\n```
    return fn.apply(a);
//         ^^ reference local 4
//            ^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerInterface#apply().
//                  ^ reference local 5
  }

  public static void testEnum(InnerEnum magicEnum) {
//                   ^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#testEnum().
//                            documentation ```java\npublic static void testEnum(InnerEnum magicEnum)\n```
//                            ^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#
//                            ^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#`<init>`().
//                            ^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#`<init>`().
//                            ^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#`<init>`().
//                                      ^^^^^^^^^ definition local 6
//                                                documentation ```java\nInnerEnum magicEnum\n```
    if (System.nanoTime() > System.currentTimeMillis()) {
//      ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//             ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/System#nanoTime().
//                          ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//                                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/System#currentTimeMillis().
      magicEnum = InnerEnum.B;
//    ^^^^^^^^^ reference local 6
//                ^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#
//                          ^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#B.
    }
    switch (magicEnum) {
//          ^^^^^^^^^ reference local 6
      case B:
//         ^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#B.
        System.out.println("b");
//      ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//             ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//                 ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+8).
        break;
      case A:
//         ^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#A.
        System.out.println("a");
//      ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//             ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//                 ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+8).
        break;
      default:
        break;
    }
    if (magicEnum == InnerEnum.A) System.out.println("a");
//      ^^^^^^^^^ reference local 6
//                   ^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#
//                             ^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#A.
//                                ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//                                       ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//                                           ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+8).
    else if (magicEnum == InnerEnum.C) System.out.println("b");
//           ^^^^^^^^^ reference local 6
//                        ^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#
//                                  ^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#C.
//                                     ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//                                            ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//                                                ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+8).
    else System.out.println("c");
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//              ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//                  ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+8).
  }

  public static void testAnon() {
//                   ^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#testAnon().
//                            documentation ```java\npublic static void testAnon()\n```
    InnerInterface<String, String> fn =
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerInterface#
//                 ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                         ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                 ^^ definition local 7
//                                    documentation ```java\nInnerInterface<String, String> fn\n```
        new InnerInterface<String, String>() {
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerInterface#
//                         ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                 ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
          @Override
//         ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
          public String apply(String s) {
//               ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                      ^^^^^ definition local 10
//                            documentation ```java\n@Override\npublic String apply(String s)\n```
//                            relationship is_reference is_implementation semanticdb maven . . minimized/InnerClasses#InnerInterface#apply().
//                            ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                   ^ definition local 11
//                                     documentation ```java\nString s\n```
            return s + "b";
//                 ^ reference local 11
          }
        };
    System.out.println(fn.apply("a"));
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//         ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//             ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+8).
//                     ^^ reference local 7
//                        ^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerInterface#apply().
  }

  public static String app() {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/InnerClasses#app().
//                         documentation ```java\npublic static String app()\n```
    int a = 42;
//      ^ definition local 12
//        documentation ```java\nint a\n```
    InnerStaticClass.innerStaticMethod();
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerStaticClass#
//                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerStaticClass#innerStaticMethod().
    InnerClasses innerClasses = new InnerClasses(a);
//  ^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#
//               ^^^^^^^^^^^^ definition local 13
//                            documentation ```java\nInnerClasses innerClasses\n```
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#`<init>`().
//                                               ^ reference local 12
    InnerClass innerClass = innerClasses.new InnerClass(a);
//  ^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerClass#
//             ^^^^^^^^^^ definition local 14
//                        documentation ```java\nInnerClass innerClass\n```
//                                           ^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerClass#`<init>`().
//                                                      ^ reference local 12
    innerClass.innerMethod();
//  ^^^^^^^^^^ reference local 14
//             ^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerClass#innerMethod().
    System.out.println(runInnerInterface(innerClass, a));
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//         ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//             ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+9).
//                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#runInnerInterface().
//                                       ^^^^^^^^^^ reference local 14
//                                                   ^ reference local 12
    testEnum(InnerEnum.A);
//  ^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#testEnum().
//           ^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#
//                     ^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#A.
    testAnon();
//  ^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#testAnon().
    return "";
  }
}
