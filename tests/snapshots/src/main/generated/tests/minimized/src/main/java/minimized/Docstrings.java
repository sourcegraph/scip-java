package minimized;

/** Example class docstring. */
public class Docstrings {
//           ^^^^^^^^^^ definition semanticdb maven . . minimized/Docstrings#
//                      documentation ```java\npublic class Docstrings\n```
//                      documentation Example class docstring. 
//           ^^^^^^^^^^ definition semanticdb maven . . minimized/Docstrings#`<init>`().
//                      documentation ```java\npublic Docstrings()\n```

  /** Example field docstring. */
  public static int field = 42;
//                  ^^^^^ definition semanticdb maven . . minimized/Docstrings#field.
//                        documentation ```java\npublic static int field\n```
//                        documentation Example field docstring. 

  /**
   * Example method docstring.
   *
   * @return 42.
   */
  public static int method() {
//                  ^^^^^^ definition semanticdb maven . . minimized/Docstrings#method().
//                         documentation ```java\npublic static int method()\n```
//                         documentation  Example method docstring.\n\n @return 42.\n
    return 42;
  }

  /**
   * Example method parameter docstring.
   *
   * @param n The parameter.
   * @return The number + 42.
   */
  public static int methodParameter(int n) {
//                  ^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Docstrings#methodParameter().
//                                  documentation ```java\npublic static int methodParameter(int n)\n```
//                                  documentation  Example method parameter docstring.\n\n @param n The parameter.\n @return The number + 42.\n
//                                      ^ definition local 0
//                                        documentation ```java\nint n\n```
    return n + 42;
//         ^ reference local 0
  }

  public static String app() {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/Docstrings#app().
//                         documentation ```java\npublic static String app()\n```
    return String.format("%s%s%s", field, method(), methodParameter(42));
//         ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#format().
//                                 ^^^^^ reference semanticdb maven . . minimized/Docstrings#field.
//                                        ^^^^^^ reference semanticdb maven . . minimized/Docstrings#method().
//                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Docstrings#methodParameter().
  }
}
