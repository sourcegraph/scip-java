package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

// format: off
object MinimizedScalaMain {
//     ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaMain.
//                        documentation ```scala\nobject MinimizedScalaMain\n```
  def main(args: Array[String]): Unit = {
//    ^^^^ definition semanticdb maven . . minimized/MinimizedScalaMain.main().
//         documentation ```scala\ndef main(args: Array[String]): Unit\n```
//         ^^^^ definition semanticdb maven . . minimized/MinimizedScalaMain.main().(args)
//              documentation ```scala\nargs: Array[String] \n```
//               ^^^^^ reference semanticdb maven . . scala/Array#
//                     ^^^^^^ reference semanticdb maven . . scala/Predef.String#
//                               ^^^^ reference semanticdb maven . . scala/Unit#
    TypeVariables.app(new TypeVariables.CT());
//  ^^^^^^^^^^^^^ reference semanticdb maven . . minimized/TypeVariables#
//                ^^^ reference semanticdb maven . . minimized/TypeVariables#app().
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . minimized/TypeVariables#
//                                      ^^ reference semanticdb maven . . minimized/TypeVariables#CT#
//                                        ^ reference semanticdb maven . . minimized/TypeVariables#CT#`<init>`().
    System.out.println(
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//         ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//             ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+8).
        Methods.app(42, "42") + 
//      ^^^^^^^ reference semanticdb maven . . minimized/Methods#
//              ^^^ reference semanticdb maven . . minimized/Methods#app().
//                            ^ reference semanticdb maven jdk 11 java/lang/String#`+`().
          Enums.app() + 
//        ^^^^^ reference semanticdb maven . . minimized/Enums#
//              ^^^ reference semanticdb maven . . minimized/Enums#app().
//                    ^ reference semanticdb maven jdk 11 java/lang/String#`+`().
          Docstrings.app() +
//        ^^^^^^^^^^ reference semanticdb maven . . minimized/Docstrings#
//                   ^^^ reference semanticdb maven . . minimized/Docstrings#app().
//                         ^ reference semanticdb maven jdk 11 java/lang/String#`+`().
          InnerClasses.app() + 
//        ^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#
//                     ^^^ reference semanticdb maven . . minimized/InnerClasses#app().
//                           ^ reference semanticdb maven jdk 11 java/lang/String#`+`().
          ForComprehensions.app(42) +
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/ForComprehensions#
//                          ^^^ reference semanticdb maven . . minimized/ForComprehensions#app().
//                                  ^ reference semanticdb maven jdk 11 java/lang/String#`+`().
          AnonymousClasses.app(42) + 
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AnonymousClasses#
//                         ^^^ reference semanticdb maven . . minimized/AnonymousClasses#app().
//                                 ^ reference semanticdb maven jdk 11 java/lang/String#`+`().
          Primitives.app() +
//        ^^^^^^^^^^ reference semanticdb maven . . minimized/Primitives#
//                   ^^^ reference semanticdb maven . . minimized/Primitives#app().
//                         ^ reference semanticdb maven jdk 11 java/lang/String#`+`().
          new ParameterizedTypes[Integer, String]()
//            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/ParameterizedTypes#
//                               ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                                        ^^^^^^ reference semanticdb maven . . scala/Predef.String#
//                                               ^ reference semanticdb maven . . minimized/ParameterizedTypes#`<init>`().
            .app(42, "42") +
//           ^^^ reference semanticdb maven . . minimized/ParameterizedTypes#app().
//                 ^ reference semanticdb maven . . scala/Predef.int2Integer().
//                         ^ reference semanticdb maven jdk 11 java/lang/String#`+`().
          RawTypes.x.toString + 
//        ^^^^^^^^ reference semanticdb maven . . minimized/RawTypes#
//                 ^ reference semanticdb maven . . minimized/RawTypes#x.
//                   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#toString().
//                            ^ reference semanticdb maven jdk 11 java/lang/String#`+`().
          ClassOf.app() + 
//        ^^^^^^^ reference semanticdb maven . . minimized/ClassOf#
//                ^^^ reference semanticdb maven . . minimized/ClassOf#app().
//                      ^ reference semanticdb maven jdk 11 java/lang/String#`+`().
          SubClasses.app() + 
//        ^^^^^^^^^^ reference semanticdb maven . . minimized/SubClasses#
//                   ^^^ reference semanticdb maven . . minimized/SubClasses#app().
//                         ^ reference semanticdb maven jdk 11 java/lang/String#`+`().
          Fields.app()
//        ^^^^^^ reference semanticdb maven . . minimized/Fields#
//               ^^^ reference semanticdb maven . . minimized/Fields#app().
      )
  }
}
