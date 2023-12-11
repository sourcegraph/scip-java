package minimized;

public class InnerClasses {
//           ^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#
//                        display_name InnerClasses
//                        signature_documentation java public class InnerClasses

  private final int exampleField;
//                  ^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#exampleField.
//                               display_name exampleField
//                               signature_documentation java private final int exampleField

  private static final String STRING = "asdf";
//                     ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                            ^^^^^^ definition semanticdb maven . . minimized/InnerClasses#STRING.
//                                   display_name STRING
//                                   signature_documentation java private static final String STRING

  private static final int top = 5;
//                         ^^^ definition semanticdb maven . . minimized/InnerClasses#top.
//                             display_name top
//                             signature_documentation java private static final int top
  private static final int bottom = 10;
//                         ^^^^^^ definition semanticdb maven . . minimized/InnerClasses#bottom.
//                                display_name bottom
//                                signature_documentation java private static final int bottom

  public InnerClasses(int exampleField) {
//       ^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#`<init>`().
//                    display_name <init>
//                    signature_documentation java public InnerClasses(int exampleField)
//                        ^^^^^^^^^^^^ definition local 0
//                                     display_name exampleField
//                                     signature_documentation java int exampleField
    this.exampleField = exampleField;
//       ^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#exampleField.
//                      ^^^^^^^^^^^^ reference local 0
  }

  public enum InnerEnum {
//            ^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerEnum#
//                      display_name InnerEnum
//                      signature_documentation java public enum InnerEnum
//                      relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//                      relationship is_implementation semanticdb maven jdk 11 java/lang/Comparable#
//                      relationship is_implementation semanticdb maven jdk 11 java/lang/Enum#
//            ^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerEnum#`<init>`().
//                      display_name <init>
//                      signature_documentation java private InnerEnum()
    A,
//  ^ definition semanticdb maven . . minimized/InnerClasses#InnerEnum#A.
//    display_name A
//    signature_documentation java InnerEnum.A /* ordinal 0 */
//  ^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#`<init>`().
    B,
//  ^ definition semanticdb maven . . minimized/InnerClasses#InnerEnum#B.
//    display_name B
//    signature_documentation java InnerEnum.B /* ordinal 1 */
//  ^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#`<init>`().
    C
//  ^ definition semanticdb maven . . minimized/InnerClasses#InnerEnum#C.
//    display_name C
//    signature_documentation java InnerEnum.C /* ordinal 2 */
//  ^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#`<init>`().
  }

  public interface InnerInterface<A, B> {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerInterface#
//                                display_name InnerInterface
//                                signature_documentation java public interface InnerInterface<A, B>
//                                ^ definition semanticdb maven . . minimized/InnerClasses#InnerInterface#[A]
//                                  display_name A
//                                  signature_documentation java A
//                                   ^ definition semanticdb maven . . minimized/InnerClasses#InnerInterface#[B]
//                                     display_name B
//                                     signature_documentation java B
    B apply(A a);
//  ^ reference semanticdb maven . . minimized/InnerClasses#InnerInterface#[B]
//    ^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerInterface#apply().
//          display_name apply
//          signature_documentation java public abstract B apply(A a)
//          relationship is_reference is_implementation semanticdb maven . . minimized/InnerClasses#InnerClass#apply().
//          ^ reference semanticdb maven . . minimized/InnerClasses#InnerInterface#[A]
//            ^ definition local 1
//              display_name a
//              signature_documentation java A a
  }

  public @interface InnerAnnotation {
//                  ^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerAnnotation#
//                                  display_name InnerAnnotation
//                                  signature_documentation java public @interface InnerAnnotation
//                                  relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
    int value();
//      ^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerAnnotation#value().
//            display_name value
//            signature_documentation java public abstract int value()
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
//                                     display_name InnerStaticClass
//                                     signature_documentation java @SuppressWarnings(STRING + " ")\n@InnerAnnotation(top / bottom)\npublic static class InnerStaticClass
//                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerStaticClass#`<init>`().
//                                     display_name <init>
//                                     signature_documentation java public InnerStaticClass()

    public static void innerStaticMethod() {}
//                     ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerStaticClass#innerStaticMethod().
//                                       display_name innerStaticMethod
//                                       signature_documentation java public static void innerStaticMethod()
  }

  public class InnerClass implements InnerInterface<Integer, Integer> {
//             ^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerClass#
//                        display_name InnerClass
//                        signature_documentation java public class InnerClass
//                        relationship is_implementation semanticdb maven . . minimized/InnerClasses#InnerInterface#
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerInterface#
//                                                  ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                                                           ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
    private final int field;
//                    ^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerClass#field.
//                          display_name field
//                          signature_documentation java private final int field

    public InnerClass(int field) {
//         ^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerClass#`<init>`().
//                    display_name <init>
//                    signature_documentation java public InnerClass(int field)
//                        ^^^^^ definition local 2
//                              display_name field
//                              signature_documentation java int field
      this.field = field;
//         ^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerClass#field.
//                 ^^^^^ reference local 2
    }

    public void innerMethod() {
//              ^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#InnerClass#innerMethod().
//                          display_name innerMethod
//                          signature_documentation java public void innerMethod()
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
//                       display_name apply
//                       signature_documentation java @Override\npublic Integer apply(Integer integer)
//                       relationship is_reference is_implementation semanticdb maven . . minimized/InnerClasses#InnerInterface#apply().
//                       ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                               ^^^^^^^ definition local 3
//                                       display_name integer
//                                       signature_documentation java Integer integer
      return field * integer;
//           ^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerClass#field.
//                   ^^^^^^^ reference local 3
    }
  }

  private static <A, B> B runInnerInterface(InnerInterface<A, B> fn, A a) {
//                ^ definition semanticdb maven . . minimized/InnerClasses#runInnerInterface().[A]
//                  display_name A
//                  signature_documentation java A
//                   ^ definition semanticdb maven . . minimized/InnerClasses#runInnerInterface().[B]
//                     display_name B
//                     signature_documentation java B
//                      ^ reference semanticdb maven . . minimized/InnerClasses#runInnerInterface().[B]
//                        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#runInnerInterface().
//                                          display_name runInnerInterface
//                                          signature_documentation java private static <A, B> B runInnerInterface(InnerInterface<A, B> fn, A a)
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerInterface#
//                                                         ^ reference semanticdb maven . . minimized/InnerClasses#runInnerInterface().[A]
//                                                            ^ reference semanticdb maven . . minimized/InnerClasses#runInnerInterface().[B]
//                                                               ^^ definition local 4
//                                                                  display_name fn
//                                                                  signature_documentation java InnerInterface<A, B> fn
//                                                                   ^ reference semanticdb maven . . minimized/InnerClasses#runInnerInterface().[A]
//                                                                     ^ definition local 5
//                                                                       display_name a
//                                                                       signature_documentation java A a
    return fn.apply(a);
//         ^^ reference local 4
//            ^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerInterface#apply().
//                  ^ reference local 5
  }

  public static void testEnum(InnerEnum magicEnum) {
//                   ^^^^^^^^ definition semanticdb maven . . minimized/InnerClasses#testEnum().
//                            display_name testEnum
//                            signature_documentation java public static void testEnum(InnerEnum magicEnum)
//                            ^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#
//                                      ^^^^^^^^^ definition local 6
//                                                display_name magicEnum
//                                                signature_documentation java InnerEnum magicEnum
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
//                            display_name testAnon
//                            signature_documentation java public static void testAnon()
    InnerInterface<String, String> fn =
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerInterface#
//                 ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                         ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                 ^^ definition local 7
//                                    display_name fn
//                                    signature_documentation java InnerInterface<String, String> fn
        new InnerInterface<String, String>() {
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerInterface#
//                         ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                 ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
          @Override
//         ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
          public String apply(String s) {
//               ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                      ^^^^^ definition local 9
//                            display_name apply
//                            signature_documentation java @Override\npublic String apply(String s)
//                            relationship is_reference is_implementation semanticdb maven . . minimized/InnerClasses#InnerInterface#apply().
//                            ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                   ^ definition local 10
//                                     display_name s
//                                     signature_documentation java String s
            return s + "b";
//                 ^ reference local 10
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
//                         display_name app
//                         signature_documentation java public static String app()
    int a = 42;
//      ^ definition local 11
//        display_name a
//        signature_documentation java int a
    InnerStaticClass.innerStaticMethod();
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerStaticClass#
//                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerStaticClass#innerStaticMethod().
    InnerClasses innerClasses = new InnerClasses(a);
//  ^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#
//               ^^^^^^^^^^^^ definition local 12
//                            display_name innerClasses
//                            signature_documentation java InnerClasses innerClasses
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#`<init>`().
//                                               ^ reference local 11
    InnerClass innerClass = innerClasses.new InnerClass(a);
//  ^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerClass#
//             ^^^^^^^^^^ definition local 13
//                        display_name innerClass
//                        signature_documentation java InnerClass innerClass
//                          ^^^^^^^^^^^^ reference local 12
//                                           ^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerClass#`<init>`().
//                                                      ^ reference local 11
    innerClass.innerMethod();
//  ^^^^^^^^^^ reference local 13
//             ^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerClass#innerMethod().
    System.out.println(runInnerInterface(innerClass, a));
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//         ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//             ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+9).
//                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#runInnerInterface().
//                                       ^^^^^^^^^^ reference local 13
//                                                   ^ reference local 11
    testEnum(InnerEnum.A);
//  ^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#testEnum().
//           ^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#
//                     ^ reference semanticdb maven . . minimized/InnerClasses#InnerEnum#A.
    testAnon();
//  ^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#testAnon().
    return "";
  }
}
