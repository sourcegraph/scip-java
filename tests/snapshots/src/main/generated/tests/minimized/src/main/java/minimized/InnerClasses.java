  package minimized;
  
//⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#
  public class InnerClasses {
//             ^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#
//                          display_name InnerClasses
//                          signature_documentation java public class InnerClasses
//                          kind Class
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#exampleField.
    private final int exampleField;
//                    ^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#exampleField.
//                                 display_name exampleField
//                                 signature_documentation java private final int exampleField
//                                 kind Field
//                                ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#exampleField.
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#STRING.
    private static final String STRING = "asdf";
//                       ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                              ^^^^^^ definition scip-java maven . . minimized/InnerClasses#STRING.
//                                     display_name STRING
//                                     signature_documentation java private static final String STRING
//                                     kind StaticField
//                                             ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#STRING.
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#top.
    private static final int top = 5;
//                           ^^^ definition scip-java maven . . minimized/InnerClasses#top.
//                               display_name top
//                               signature_documentation java private static final int top
//                               kind StaticField
//                                  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#top.
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#bottom.
    private static final int bottom = 10;
//                           ^^^^^^ definition scip-java maven . . minimized/InnerClasses#bottom.
//                                  display_name bottom
//                                  signature_documentation java private static final int bottom
//                                  kind StaticField
//                                      ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#bottom.
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#`<init>`().
//                      ⌄ enclosing_range_start local 0
    public InnerClasses(int exampleField) {
//         ^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#`<init>`().
//                      display_name <init>
//                      signature_documentation java public InnerClasses(int exampleField)
//                      kind Constructor
//                          ^^^^^^^^^^^^ definition local 0
//                                       display_name exampleField
//                                       signature_documentation java int exampleField
//                                       enclosing_symbol scip-java maven . . minimized/InnerClasses#`<init>`().
//                                     ⌃ enclosing_range_end local 0
      this.exampleField = exampleField;
//         ^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#exampleField.
//                        ^^^^^^^^^^^^ reference local 0
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#`<init>`().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerEnum#
    public enum InnerEnum {
//              ^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerEnum#
//                        display_name InnerEnum
//                        signature_documentation java public enum InnerEnum
//                        kind Enum
//                        relationship is_implementation scip-java maven jdk 11 java/io/Serializable#
//                        relationship is_implementation scip-java maven jdk 11 java/lang/Comparable#
//                        relationship is_implementation scip-java maven jdk 11 java/lang/Enum#
//              ^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerEnum#`<init>`().
//                        display_name <init>
//                        signature_documentation java private InnerEnum()
//                        kind Constructor
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerEnum#A.
      A,
//    ^ definition scip-java maven . . minimized/InnerClasses#InnerEnum#A.
//      display_name A
//      signature_documentation java InnerEnum.A /* ordinal 0 */
//    ^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#`<init>`().
//    ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerEnum#A.
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerEnum#B.
      B,
//    ^ definition scip-java maven . . minimized/InnerClasses#InnerEnum#B.
//      display_name B
//      signature_documentation java InnerEnum.B /* ordinal 1 */
//    ^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#`<init>`().
//    ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerEnum#B.
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerEnum#C.
      C
//    ^ definition scip-java maven . . minimized/InnerClasses#InnerEnum#C.
//      display_name C
//      signature_documentation java InnerEnum.C /* ordinal 2 */
//    ^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#`<init>`().
//    ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerEnum#C.
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerEnum#
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerInterface#
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerInterface#[A]
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerInterface#[B]
    public interface InnerInterface<A, B> {
//                   ^^^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerInterface#
//                                  display_name InnerInterface
//                                  signature_documentation java public interface InnerInterface<A, B>
//                                  kind Interface
//                                  ^ definition scip-java maven . . minimized/InnerClasses#InnerInterface#[A]
//                                    display_name A
//                                    signature_documentation java A
//                                    kind TypeParameter
//                                     ^ definition scip-java maven . . minimized/InnerClasses#InnerInterface#[B]
//                                       display_name B
//                                       signature_documentation java B
//                                       kind TypeParameter
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerInterface#apply().
//            ⌄ enclosing_range_start local 1
      B apply(A a);
//    ^ reference scip-java maven . . minimized/InnerClasses#InnerInterface#[B]
//      ^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerInterface#apply().
//            display_name apply
//            signature_documentation java public abstract B apply(A a)
//            kind AbstractMethod
//            relationship is_reference is_implementation scip-java maven . . minimized/InnerClasses#InnerClass#apply().
//            ^ reference scip-java maven . . minimized/InnerClasses#InnerInterface#[A]
//              ^ definition local 1
//                display_name a
//                signature_documentation java A a
//                enclosing_symbol scip-java maven . . minimized/InnerClasses#InnerInterface#apply().
//              ⌃ enclosing_range_end local 1
//                ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerInterface#apply().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerInterface#
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerInterface#[A]
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerInterface#[B]
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerAnnotation#
    public @interface InnerAnnotation {
//                    ^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerAnnotation#
//                                    display_name InnerAnnotation
//                                    signature_documentation java public @interface InnerAnnotation
//                                    kind Interface
//                                    relationship is_implementation scip-java maven jdk 11 java/lang/annotation/Annotation#
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerAnnotation#value().
      int value();
//        ^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerAnnotation#value().
//              display_name value
//              signature_documentation java public abstract int value()
//              kind AbstractMethod
//               ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerAnnotation#value().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerAnnotation#
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerStaticClass#
    @SuppressWarnings(STRING + " ")
//   ^^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/SuppressWarnings#
//                    ^^^^^^ reference scip-java maven . . minimized/InnerClasses#STRING.
    @InnerAnnotation(top / bottom)
//   ^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerAnnotation#
//                   ^^^ reference scip-java maven . . minimized/InnerClasses#top.
//                         ^^^^^^ reference scip-java maven . . minimized/InnerClasses#bottom.
    public static class InnerStaticClass {
//                      ^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerStaticClass#
//                                       display_name InnerStaticClass
//                                       signature_documentation java @SuppressWarnings(STRING + " ")\n@InnerAnnotation(top / bottom)\npublic static class InnerStaticClass
//                                       kind Class
//                      ^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerStaticClass#`<init>`().
//                                       display_name <init>
//                                       signature_documentation java public InnerStaticClass()
//                                       kind Constructor
  
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerStaticClass#innerStaticMethod().
      public static void innerStaticMethod() {}
//                       ^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerStaticClass#innerStaticMethod().
//                                         display_name innerStaticMethod
//                                         signature_documentation java public static void innerStaticMethod()
//                                         kind StaticMethod
//                                            ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerStaticClass#innerStaticMethod().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerStaticClass#
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerClass#
    public class InnerClass implements InnerInterface<Integer, Integer> {
//               ^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerClass#
//                          display_name InnerClass
//                          signature_documentation java public class InnerClass implements InnerInterface<Integer, Integer>
//                          kind Class
//                          relationship is_implementation scip-java maven . . minimized/InnerClasses#InnerInterface#
//                                     ^^^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerInterface#
//                                                    ^^^^^^^ reference scip-java maven jdk 11 java/lang/Integer#
//                                                             ^^^^^^^ reference scip-java maven jdk 11 java/lang/Integer#
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerClass#field.
      private final int field;
//                      ^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerClass#field.
//                            display_name field
//                            signature_documentation java private final int field
//                            kind Field
//                           ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerClass#field.
  
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerClass#`<init>`().
//                      ⌄ enclosing_range_start local 2
      public InnerClass(int field) {
//           ^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerClass#`<init>`().
//                      display_name <init>
//                      signature_documentation java public InnerClass(int field)
//                      kind Constructor
//                          ^^^^^ definition local 2
//                                display_name field
//                                signature_documentation java int field
//                                enclosing_symbol scip-java maven . . minimized/InnerClasses#InnerClass#`<init>`().
//                              ⌃ enclosing_range_end local 2
        this.field = field;
//           ^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerClass#field.
//                   ^^^^^ reference local 2
      }
//    ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerClass#`<init>`().
  
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerClass#innerMethod().
      public void innerMethod() {
//                ^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerClass#innerMethod().
//                            display_name innerMethod
//                            signature_documentation java public void innerMethod()
//                            kind Method
        System.out.println(field + exampleField);
//      ^^^^^^ reference scip-java maven jdk 11 java/lang/System#
//             ^^^ reference scip-java maven jdk 11 java/lang/System#out.
//                 ^^^^^^^ reference scip-java maven jdk 11 java/io/PrintStream#println(+3).
//                         ^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerClass#field.
//                                 ^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#exampleField.
      }
//    ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerClass#innerMethod().
  
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerClass#apply().
      @Override
//     ^^^^^^^^ reference scip-java maven jdk 11 java/lang/Override#
//                         ⌄ enclosing_range_start local 3
      public Integer apply(Integer integer) {
//           ^^^^^^^ reference scip-java maven jdk 11 java/lang/Integer#
//                   ^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerClass#apply().
//                         display_name apply
//                         signature_documentation java @Override\npublic Integer apply(Integer integer)
//                         kind Method
//                         relationship is_reference is_implementation scip-java maven . . minimized/InnerClasses#InnerInterface#apply().
//                         ^^^^^^^ reference scip-java maven jdk 11 java/lang/Integer#
//                                 ^^^^^^^ definition local 3
//                                         display_name integer
//                                         signature_documentation java Integer integer
//                                         enclosing_symbol scip-java maven . . minimized/InnerClasses#InnerClass#apply().
//                                       ⌃ enclosing_range_end local 3
        return field * integer;
//             ^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerClass#field.
//                     ^^^^^^^ reference local 3
      }
//    ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerClass#apply().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerClass#
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#runInnerInterface().[A]
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#runInnerInterface().[B]
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#runInnerInterface().
//                                            ⌄ enclosing_range_start local 4
//                                                                     ⌄ enclosing_range_start local 5
    private static <A, B> B runInnerInterface(InnerInterface<A, B> fn, A a) {
//                  ^ definition scip-java maven . . minimized/InnerClasses#runInnerInterface().[A]
//                    display_name A
//                    signature_documentation java A
//                    kind TypeParameter
//                     ^ definition scip-java maven . . minimized/InnerClasses#runInnerInterface().[B]
//                       display_name B
//                       signature_documentation java B
//                       kind TypeParameter
//                        ^ reference scip-java maven . . minimized/InnerClasses#runInnerInterface().[B]
//                          ^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#runInnerInterface().
//                                            display_name runInnerInterface
//                                            signature_documentation java private static <A, B> B runInnerInterface(InnerInterface<A, B> fn, A a)
//                                            kind StaticMethod
//                                            ^^^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerInterface#
//                                                           ^ reference scip-java maven . . minimized/InnerClasses#runInnerInterface().[A]
//                                                              ^ reference scip-java maven . . minimized/InnerClasses#runInnerInterface().[B]
//                                                                 ^^ definition local 4
//                                                                    display_name fn
//                                                                    signature_documentation java InnerInterface<A, B> fn
//                                                                    enclosing_symbol scip-java maven . . minimized/InnerClasses#runInnerInterface().
//                                                                     ^ reference scip-java maven . . minimized/InnerClasses#runInnerInterface().[A]
//                                                                       ^ definition local 5
//                                                                         display_name a
//                                                                         signature_documentation java A a
//                                                                         enclosing_symbol scip-java maven . . minimized/InnerClasses#runInnerInterface().
//                                                                  ⌃ enclosing_range_end local 4
//                                                                       ⌃ enclosing_range_end local 5
      return fn.apply(a);
//           ^^ reference local 4
//              ^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerInterface#apply().
//                    ^ reference local 5
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#runInnerInterface().[A]
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#runInnerInterface().[B]
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#runInnerInterface().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#testEnum().
//                              ⌄ enclosing_range_start local 6
    public static void testEnum(InnerEnum magicEnum) {
//                     ^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#testEnum().
//                              display_name testEnum
//                              signature_documentation java public static void testEnum(InnerEnum magicEnum)
//                              kind StaticMethod
//                              ^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#
//                                        ^^^^^^^^^ definition local 6
//                                                  display_name magicEnum
//                                                  signature_documentation java InnerEnum magicEnum
//                                                  enclosing_symbol scip-java maven . . minimized/InnerClasses#testEnum().
//                                                ⌃ enclosing_range_end local 6
      if (System.nanoTime() > System.currentTimeMillis()) {
//        ^^^^^^ reference scip-java maven jdk 11 java/lang/System#
//               ^^^^^^^^ reference scip-java maven jdk 11 java/lang/System#nanoTime().
//                            ^^^^^^ reference scip-java maven jdk 11 java/lang/System#
//                                   ^^^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/System#currentTimeMillis().
        magicEnum = InnerEnum.B;
//      ^^^^^^^^^ reference local 6
//                  ^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#
//                            ^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#B.
      }
      switch (magicEnum) {
//            ^^^^^^^^^ reference local 6
        case B:
//           ^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#B.
          System.out.println("b");
//        ^^^^^^ reference scip-java maven jdk 11 java/lang/System#
//               ^^^ reference scip-java maven jdk 11 java/lang/System#out.
//                   ^^^^^^^ reference scip-java maven jdk 11 java/io/PrintStream#println(+8).
          break;
        case A:
//           ^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#A.
          System.out.println("a");
//        ^^^^^^ reference scip-java maven jdk 11 java/lang/System#
//               ^^^ reference scip-java maven jdk 11 java/lang/System#out.
//                   ^^^^^^^ reference scip-java maven jdk 11 java/io/PrintStream#println(+8).
          break;
        default:
          break;
      }
      if (magicEnum == InnerEnum.A) System.out.println("a");
//        ^^^^^^^^^ reference local 6
//                     ^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#
//                               ^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#A.
//                                  ^^^^^^ reference scip-java maven jdk 11 java/lang/System#
//                                         ^^^ reference scip-java maven jdk 11 java/lang/System#out.
//                                             ^^^^^^^ reference scip-java maven jdk 11 java/io/PrintStream#println(+8).
      else if (magicEnum == InnerEnum.C) System.out.println("b");
//             ^^^^^^^^^ reference local 6
//                          ^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#
//                                    ^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#C.
//                                       ^^^^^^ reference scip-java maven jdk 11 java/lang/System#
//                                              ^^^ reference scip-java maven jdk 11 java/lang/System#out.
//                                                  ^^^^^^^ reference scip-java maven jdk 11 java/io/PrintStream#println(+8).
      else System.out.println("c");
//         ^^^^^^ reference scip-java maven jdk 11 java/lang/System#
//                ^^^ reference scip-java maven jdk 11 java/lang/System#out.
//                    ^^^^^^^ reference scip-java maven jdk 11 java/io/PrintStream#println(+8).
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#testEnum().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#testAnon().
    public static void testAnon() {
//                     ^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#testAnon().
//                              display_name testAnon
//                              signature_documentation java public static void testAnon()
//                              kind StaticMethod
//    ⌄ enclosing_range_start local 7
      InnerInterface<String, String> fn =
//    ^^^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerInterface#
//                   ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                           ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                                   ^^ definition local 7
//                                      display_name fn
//                                      signature_documentation java InnerInterface<String, String> fn
//                                      enclosing_symbol scip-java maven . . minimized/InnerClasses#testAnon().
//                                      kind Variable
          new InnerInterface<String, String>() {
//            ^^^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerInterface#
//                           ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                                   ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//          ⌄ enclosing_range_start local 9
            @Override
//           ^^^^^^^^ reference scip-java maven jdk 11 java/lang/Override#
//                              ⌄ enclosing_range_start local 10
            public String apply(String s) {
//                 ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                        ^^^^^ definition local 9
//                              display_name apply
//                              signature_documentation java @Override\npublic String apply(String s)
//                              enclosing_symbol local 8
//                              kind Method
//                              relationship is_reference is_implementation scip-java maven . . minimized/InnerClasses#InnerInterface#apply().
//                              ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                                     ^ definition local 10
//                                       display_name s
//                                       signature_documentation java String s
//                                       enclosing_symbol local 9
//                                     ⌃ enclosing_range_end local 10
              return s + "b";
//                   ^ reference local 10
            }
//          ⌃ enclosing_range_end local 9
          };
//         ⌃ enclosing_range_end local 7
      System.out.println(fn.apply("a"));
//    ^^^^^^ reference scip-java maven jdk 11 java/lang/System#
//           ^^^ reference scip-java maven jdk 11 java/lang/System#out.
//               ^^^^^^^ reference scip-java maven jdk 11 java/io/PrintStream#println(+8).
//                       ^^ reference local 7
//                          ^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerInterface#apply().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#testAnon().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#app().
    public static String app() {
//                ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                       ^^^ definition scip-java maven . . minimized/InnerClasses#app().
//                           display_name app
//                           signature_documentation java public static String app()
//                           kind StaticMethod
//    ⌄ enclosing_range_start local 11
      int a = 42;
//        ^ definition local 11
//          display_name a
//          signature_documentation java int a
//          enclosing_symbol scip-java maven . . minimized/InnerClasses#app().
//          kind Variable
//              ⌃ enclosing_range_end local 11
      InnerStaticClass.innerStaticMethod();
//    ^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerStaticClass#
//                     ^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerStaticClass#innerStaticMethod().
//    ⌄ enclosing_range_start local 12
      InnerClasses innerClasses = new InnerClasses(a);
//    ^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#
//                 ^^^^^^^^^^^^ definition local 12
//                              display_name innerClasses
//                              signature_documentation java InnerClasses innerClasses
//                              enclosing_symbol scip-java maven . . minimized/InnerClasses#app().
//                              kind Variable
//                                    ^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#`<init>`().
//                                                 ^ reference local 11
//                                                   ⌃ enclosing_range_end local 12
//    ⌄ enclosing_range_start local 13
      InnerClass innerClass = innerClasses.new InnerClass(a);
//    ^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerClass#
//               ^^^^^^^^^^ definition local 13
//                          display_name innerClass
//                          signature_documentation java InnerClass innerClass
//                          enclosing_symbol scip-java maven . . minimized/InnerClasses#app().
//                          kind Variable
//                            ^^^^^^^^^^^^ reference local 12
//                                             ^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerClass#`<init>`().
//                                                        ^ reference local 11
//                                                          ⌃ enclosing_range_end local 13
      innerClass.innerMethod();
//    ^^^^^^^^^^ reference local 13
//               ^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerClass#innerMethod().
      System.out.println(runInnerInterface(innerClass, a));
//    ^^^^^^ reference scip-java maven jdk 11 java/lang/System#
//           ^^^ reference scip-java maven jdk 11 java/lang/System#out.
//               ^^^^^^^ reference scip-java maven jdk 11 java/io/PrintStream#println(+9).
//                       ^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#runInnerInterface().
//                                         ^^^^^^^^^^ reference local 13
//                                                     ^ reference local 11
      testEnum(InnerEnum.A);
//    ^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#testEnum().
//             ^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#
//                       ^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#A.
      testAnon();
//    ^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#testAnon().
      return "";
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#app().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#
