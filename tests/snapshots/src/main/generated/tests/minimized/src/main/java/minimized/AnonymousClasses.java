  package minimized;
  
  import java.util.function.Function;
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/util/
//                 ^^^^^^^^ reference semanticdb maven . . java/util/function/
//                          ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
  
  @SuppressWarnings("ALL")
// ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
  public class AnonymousClasses {
//             ^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnonymousClasses#
//                              display_name AnonymousClasses
//                              signature_documentation java @SuppressWarnings("ALL")\npublic class AnonymousClasses
//                              enclosing_range 4 0 17 1
//                              kind Class
//             ^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnonymousClasses#`<init>`().
//                              display_name <init>
//                              signature_documentation java public AnonymousClasses()
//                              kind Constructor
    public static int app(int n) {
//                    ^^^ definition semanticdb maven . . minimized/AnonymousClasses#app().
//                        display_name app
//                        signature_documentation java public static int app(int n)
//                        enclosing_range 6 2 16 3
//                        kind StaticMethod
//                            ^ definition local 0
//                              display_name n
//                              signature_documentation java int n
//                              enclosing_symbol semanticdb maven . . minimized/AnonymousClasses#app().
//                              enclosing_range 6 24 29
      Function<Integer, Integer> fn =
//    ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//             ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                      ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                               ^^ definition local 1
//                                  display_name fn
//                                  signature_documentation java Function<Integer, Integer> fn
//                                  enclosing_symbol semanticdb maven . . minimized/AnonymousClasses#app().
//                                  enclosing_range 7 4 13 10
//                                  kind Variable
          new Function<Integer, Integer>() {
//            ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//                     ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                              ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
            @Override
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
            public Integer apply(Integer integer) {
//                 ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                         ^^^^^ definition local 3
//                               display_name apply
//                               signature_documentation java @Override\npublic Integer apply(Integer integer)
//                               enclosing_symbol local 2
//                               enclosing_range 9 10 12 11
//                               kind Method
//                               relationship is_reference is_implementation semanticdb maven jdk 11 java/util/function/Function#apply().
//                               ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                                       ^^^^^^^ definition local 4
//                                               display_name integer
//                                               signature_documentation java Integer integer
//                                               enclosing_symbol local 3
//                                               enclosing_range 10 31 46
              return integer + n;
//                   ^^^^^^^ reference local 4
//                             ^ reference local 0
            }
          };
  
      return fn.apply(n);
//           ^^ reference local 1
//              ^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#apply().
//                    ^ reference local 0
    }
  }
