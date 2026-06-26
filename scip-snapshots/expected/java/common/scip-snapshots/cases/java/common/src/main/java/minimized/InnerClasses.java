  package minimized;
  
//⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#
  public class InnerClasses {
//             ^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#
//                          kind Class
//                          display_name InnerClasses
//                          signature_documentation
//                          > public class InnerClasses
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#exampleField.
    private final int exampleField;
//                    ^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#exampleField.
//                                 kind Field
//                                 display_name exampleField
//                                 signature_documentation
//                                 > private final int exampleField
//                                ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#exampleField.
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#STRING.
    private static final String STRING = "asdf";
//                       ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                              ^^^^^^ definition scip-java maven . . minimized/InnerClasses#STRING.
//                                     kind StaticField
//                                     display_name STRING
//                                     signature_documentation
//                                     > private static final String STRING
//                                             ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#STRING.
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#top.
    private static final int top = 5;
//                           ^^^ definition scip-java maven . . minimized/InnerClasses#top.
//                               kind StaticField
//                               display_name top
//                               signature_documentation
//                               > private static final int top
//                                  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#top.
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#bottom.
    private static final int bottom = 10;
//                           ^^^^^^ definition scip-java maven . . minimized/InnerClasses#bottom.
//                                  kind StaticField
//                                  display_name bottom
//                                  signature_documentation
//                                  > private static final int bottom
//                                      ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#bottom.
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#`<init>`().
//                      ⌄ enclosing_range_start local 0
    public InnerClasses(int exampleField) {
//         ^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#`<init>`().
//                      kind Constructor
//                      display_name <init>
//                      signature_documentation
//                      > public InnerClasses(int exampleField)
//                          ^^^^^^^^^^^^ definition local 0
//                                       display_name exampleField
//                                       signature_documentation
//                                       > int exampleField
//                                     ⌃ enclosing_range_end local 0
      this.exampleField = exampleField;
//         ^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#exampleField.
//                        ^^^^^^^^^^^^ reference local 0
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#`<init>`().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerEnum#
    public enum InnerEnum {
//              ^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerEnum#
//                        kind Enum
//                        display_name InnerEnum
//                        signature_documentation
//                        > public enum InnerEnum
//                        relationship scip-java maven jdk 11 java/io/Serializable# implementation
//                        relationship scip-java maven jdk 11 java/lang/Comparable# implementation
//                        relationship scip-java maven jdk 11 java/lang/Enum# implementation
//                        relationship scip-java maven jdk 11 java/lang/constant/Constable# implementation
//              ^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerEnum#`<init>`().
//                        kind Constructor
//                        display_name <init>
//                        signature_documentation
//                        > private InnerEnum()
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerEnum#A.
      A,
//    ^ definition scip-java maven . . minimized/InnerClasses#InnerEnum#A.
//      display_name A
//      signature_documentation
//      > InnerEnum.A /* ordinal 0 */
//    ^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#`<init>`().
//    ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerEnum#A.
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerEnum#B.
      B,
//    ^ definition scip-java maven . . minimized/InnerClasses#InnerEnum#B.
//      display_name B
//      signature_documentation
//      > InnerEnum.B /* ordinal 1 */
//    ^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#`<init>`().
//    ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerEnum#B.
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerEnum#C.
      C
//    ^ definition scip-java maven . . minimized/InnerClasses#InnerEnum#C.
//      display_name C
//      signature_documentation
//      > InnerEnum.C /* ordinal 2 */
//    ^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#`<init>`().
//    ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerEnum#C.
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerEnum#
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerInterface#
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerInterface#[A]
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerInterface#[B]
    public interface InnerInterface<A, B> {
//                   ^^^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerInterface#
//                                  kind Interface
//                                  display_name InnerInterface
//                                  signature_documentation
//                                  > public interface InnerInterface<A, B>
//                                  ^ definition scip-java maven . . minimized/InnerClasses#InnerInterface#[A]
//                                    kind TypeParameter
//                                    display_name A
//                                    signature_documentation
//                                    > A
//                                     ^ definition scip-java maven . . minimized/InnerClasses#InnerInterface#[B]
//                                       kind TypeParameter
//                                       display_name B
//                                       signature_documentation
//                                       > B
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerInterface#apply().
//            ⌄ enclosing_range_start local 1
      B apply(A a);
//    ^ reference scip-java maven . . minimized/InnerClasses#InnerInterface#[B]
//      ^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerInterface#apply().
//            kind AbstractMethod
//            display_name apply
//            signature_documentation
//            > public abstract B apply(A a)
//            relationship scip-java maven . . minimized/InnerClasses#InnerClass#apply(). implementation reference
//            ^ reference scip-java maven . . minimized/InnerClasses#InnerInterface#[A]
//              ^ definition local 1
//                display_name a
//                signature_documentation
//                > A a
//              ⌃ enclosing_range_end local 1
//                ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerInterface#apply().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerInterface#
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerInterface#[A]
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerInterface#[B]
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerAnnotation#
    public @interface InnerAnnotation {
//                    ^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerAnnotation#
//                                    kind Interface
//                                    display_name InnerAnnotation
//                                    signature_documentation
//                                    > public @interface InnerAnnotation
//                                    relationship scip-java maven jdk 11 java/lang/annotation/Annotation# implementation
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerAnnotation#value().
      int value();
//        ^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerAnnotation#value().
//              kind AbstractMethod
//              display_name value
//              signature_documentation
//              > public abstract int value()
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
//                                       kind Class
//                                       display_name InnerStaticClass
//                                       signature_documentation
//                                       > @SuppressWarnings(STRING + " ")
//                                       > @InnerAnnotation(top / bottom)
//                                       > public static class InnerStaticClass
//                      ^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerStaticClass#`<init>`().
//                                       kind Constructor
//                                       display_name <init>
//                                       signature_documentation
//                                       > public InnerStaticClass()
  
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerStaticClass#innerStaticMethod().
      public static void innerStaticMethod() {}
//                       ^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerStaticClass#innerStaticMethod().
//                                         kind StaticMethod
//                                         display_name innerStaticMethod
//                                         signature_documentation
//                                         > public static void innerStaticMethod()
//                                            ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerStaticClass#innerStaticMethod().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerStaticClass#
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerClass#
    public class InnerClass implements InnerInterface<Integer, Integer> {
//               ^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerClass#
//                          kind Class
//                          display_name InnerClass
//                          signature_documentation
//                          > public class InnerClass implements InnerInterface<Integer, Integer>
//                          relationship scip-java maven . . minimized/InnerClasses#InnerInterface# implementation
//                                     ^^^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerInterface#
//                                                    ^^^^^^^ reference scip-java maven jdk 11 java/lang/Integer#
//                                                             ^^^^^^^ reference scip-java maven jdk 11 java/lang/Integer#
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerClass#field.
      private final int field;
//                      ^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerClass#field.
//                            kind Field
//                            display_name field
//                            signature_documentation
//                            > private final int field
//                           ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerClass#field.
  
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerClass#`<init>`().
//                      ⌄ enclosing_range_start local 2
      public InnerClass(int field) {
//           ^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerClass#`<init>`().
//                      kind Constructor
//                      display_name <init>
//                      signature_documentation
//                      > public InnerClass(int field)
//                          ^^^^^ definition local 2
//                                display_name field
//                                signature_documentation
//                                > int field
//                              ⌃ enclosing_range_end local 2
        this.field = field;
//           ^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerClass#field.
//                   ^^^^^ reference local 2
      }
//    ⌃ enclosing_range_end scip-java maven . . minimized/InnerClasses#InnerClass#`<init>`().
  
//    ⌄ enclosing_range_start scip-java maven . . minimized/InnerClasses#InnerClass#innerMethod().
      public void innerMethod() {
//                ^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#InnerClass#innerMethod().
//                            kind Method
//                            display_name innerMethod
//                            signature_documentation
//                            > public void innerMethod()
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
//                         kind Method
//                         display_name apply
//                         signature_documentation
//                         > @Override
//                         > public Integer apply(Integer integer)
//                         relationship scip-java maven . . minimized/InnerClasses#InnerInterface#apply(). implementation reference
//                         ^^^^^^^ reference scip-java maven jdk 11 java/lang/Integer#
//                                 ^^^^^^^ definition local 3
//                                         display_name integer
//                                         signature_documentation
//                                         > Integer integer
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
//                    kind TypeParameter
//                    display_name A
//                    signature_documentation
//                    > A
//                     ^ definition scip-java maven . . minimized/InnerClasses#runInnerInterface().[B]
//                       kind TypeParameter
//                       display_name B
//                       signature_documentation
//                       > B
//                        ^ reference scip-java maven . . minimized/InnerClasses#runInnerInterface().[B]
//                          ^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/InnerClasses#runInnerInterface().
//                                            kind StaticMethod
//                                            display_name runInnerInterface
//                                            signature_documentation
//                                            > private static <A, B> B runInnerInterface(InnerInterface<A, B> fn, A a)
//                                            ^^^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerInterface#
//                                                           ^ reference scip-java maven . . minimized/InnerClasses#runInnerInterface().[A]
//                                                              ^ reference scip-java maven . . minimized/InnerClasses#runInnerInterface().[B]
//                                                                 ^^ definition local 4
//                                                                    display_name fn
//                                                                    signature_documentation
//                                                                    > InnerInterface<A, B> fn
//                                                                     ^ reference scip-java maven . . minimized/InnerClasses#runInnerInterface().[A]
//                                                                       ^ definition local 5
//                                                                         display_name a
//                                                                         signature_documentation
//                                                                         > A a
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
//                              kind StaticMethod
//                              display_name testEnum
//                              signature_documentation
//                              > public static void testEnum(InnerEnum magicEnum)
//                              ^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerEnum#
//                                        ^^^^^^^^^ definition local 6
//                                                  display_name magicEnum
//                                                  signature_documentation
//                                                  > InnerEnum magicEnum
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
//                              kind StaticMethod
//                              display_name testAnon
//                              signature_documentation
//                              > public static void testAnon()
//    ⌄ enclosing_range_start local 7
      InnerInterface<String, String> fn =
//    ^^^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerInterface#
//                   ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                           ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                                   ^^ definition local 7
//                                      kind Variable
//                                      display_name fn
//                                      signature_documentation
//                                      > InnerInterface<String, String> fn
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
//                              kind Method
//                              display_name apply
//                              signature_documentation
//                              > @Override
//                              > public String apply(String s)
//                              relationship scip-java maven . . minimized/InnerClasses#InnerInterface#apply(). implementation reference
//                              ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                                     ^ definition local 10
//                                       display_name s
//                                       signature_documentation
//                                       > String s
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
//                           kind StaticMethod
//                           display_name app
//                           signature_documentation
//                           > public static String app()
//    ⌄ enclosing_range_start local 11
      int a = 42;
//        ^ definition local 11
//          kind Variable
//          display_name a
//          signature_documentation
//          > int a
//              ⌃ enclosing_range_end local 11
      InnerStaticClass.innerStaticMethod();
//    ^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerStaticClass#
//                     ^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerStaticClass#innerStaticMethod().
//    ⌄ enclosing_range_start local 12
      InnerClasses innerClasses = new InnerClasses(a);
//    ^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#
//                 ^^^^^^^^^^^^ definition local 12
//                              kind Variable
//                              display_name innerClasses
//                              signature_documentation
//                              > InnerClasses innerClasses
//                                    ^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#`<init>`().
//                                                 ^ reference local 11
//                                                   ⌃ enclosing_range_end local 12
//    ⌄ enclosing_range_start local 13
      InnerClass innerClass = innerClasses.new InnerClass(a);
//    ^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#InnerClass#
//               ^^^^^^^^^^ definition local 13
//                          kind Variable
//                          display_name innerClass
//                          signature_documentation
//                          > InnerClass innerClass
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
  
