package minimized
//      ^^^^^^^^^ definition minimized/

// format: off
object MinimizedScalaMain {
//     ^^^^^^^^^^^^^^^^^^ definition minimized/MinimizedScalaMain. public final MinimizedScalaMain extends AnyRef
  def main(args: Array[String]): Unit = {
//    ^^^^ definition minimized/MinimizedScalaMain.main(). public void main(Array<String> args)
//         ^^^^ definition minimized/MinimizedScalaMain.main().(args) Array<String> args
//               ^^^^^ reference scala/Array#
//                     ^^^^^^ reference scala/Predef.String#
//                               ^^^^ reference scala/Unit#
    TypeVariables.app(new TypeVariables.CT());
//  ^^^^^^^^^^^^^ reference minimized/TypeVariables#
//                ^^^ reference minimized/TypeVariables#app().
//                        ^^^^^^^^^^^^^ reference minimized/TypeVariables#
//                                      ^^ reference minimized/TypeVariables#CT#
//                                         reference minimized/TypeVariables#CT#`<init>`().
    System.out.println(
//  ^^^^^^ reference java/lang/System#
//         ^^^ reference java/lang/System#out.
//             ^^^^^^^ reference java/io/PrintStream#println(+8).
        Methods.app(42, "42") + 
//      ^^^^^^^ reference minimized/Methods#
//              ^^^ reference minimized/Methods#app().
//                            ^ reference java/lang/String#`+`().
          Enums.app() + 
//        ^^^^^ reference minimized/Enums#
//              ^^^ reference minimized/Enums#app().
//                    ^ reference java/lang/String#`+`().
          Docstrings.app() +
//        ^^^^^^^^^^ reference minimized/Docstrings#
//                   ^^^ reference minimized/Docstrings#app().
//                         ^ reference java/lang/String#`+`().
          InnerClasses.app() + 
//        ^^^^^^^^^^^^ reference minimized/InnerClasses#
//                     ^^^ reference minimized/InnerClasses#app().
//                           ^ reference java/lang/String#`+`().
          ForComprehensions.app(42) +
//        ^^^^^^^^^^^^^^^^^ reference minimized/ForComprehensions#
//                          ^^^ reference minimized/ForComprehensions#app().
//                                  ^ reference java/lang/String#`+`().
          AnonymousClasses.app(42) + 
//        ^^^^^^^^^^^^^^^^ reference minimized/AnonymousClasses#
//                         ^^^ reference minimized/AnonymousClasses#app().
//                                 ^ reference java/lang/String#`+`().
          Primitives.app() +
//        ^^^^^^^^^^ reference minimized/Primitives#
//                   ^^^ reference minimized/Primitives#app().
//                         ^ reference java/lang/String#`+`().
          new ParameterizedTypes[Integer, String]()
//            ^^^^^^^^^^^^^^^^^^ reference minimized/ParameterizedTypes#
//                               ^^^^^^^ reference java/lang/Integer#
//                                        ^^^^^^ reference scala/Predef.String#
//                                                reference minimized/ParameterizedTypes#`<init>`().
            .app(42, "42") +
//           ^^^ reference minimized/ParameterizedTypes#app().
//                         ^ reference java/lang/String#`+`().
          RawTypes.x.toString + 
//        ^^^^^^^^ reference minimized/RawTypes#
//                 ^ reference minimized/RawTypes#x.
//                   ^^^^^^^^ reference java/lang/Object#toString().
//                            ^ reference java/lang/String#`+`().
          ClassOf.app() + 
//        ^^^^^^^ reference minimized/ClassOf#
//                ^^^ reference minimized/ClassOf#app().
//                      ^ reference java/lang/String#`+`().
          SubClasses.app() + 
//        ^^^^^^^^^^ reference minimized/SubClasses#
//                   ^^^ reference minimized/SubClasses#app().
//                         ^ reference java/lang/String#`+`().
          Fields.app()
//        ^^^^^^ reference minimized/Fields#
//               ^^^ reference minimized/Fields#app().
      )
  }
}
