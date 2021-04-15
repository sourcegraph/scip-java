package minimized;

public class SubClasses extends AbstractClasses implements Interfaces {
//           ^^^^^^^^^^ definition minimized/SubClasses# public class SubClasses extends AbstractClasses implements Interfaces
//           ^^^^^^^^^^ definition minimized/SubClasses#`<init>`(). public SubClasses()
//                              ^^^^^^^^^^^^^^^ reference minimized/AbstractClasses#
//                                                         ^^^^^^^^^^ reference minimized/Interfaces#

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public String abstractImplementation() {
//       ^^^^^^ reference java/lang/String#
//              ^^^^^^^^^^^^^^^^^^^^^^ definition minimized/SubClasses#abstractImplementation(). @Override public String abstractImplementation()
    return "abstract";
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public String abstractInterfaceMethod() {
//       ^^^^^^ reference java/lang/String#
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition minimized/SubClasses#abstractInterfaceMethod(). @Override public String abstractInterfaceMethod()
    return "abstractInterface";
  }

  public static String app() {
//              ^^^^^^ reference java/lang/String#
//                     ^^^ definition minimized/SubClasses#app(). public static String app()
    SubClasses s = new SubClasses();
//  ^^^^^^^^^^ reference minimized/SubClasses#
//             ^ definition local0 SubClasses s
//                     ^^^^^^^^^^ reference minimized/SubClasses#`<init>`().
    return s.abstractImplementation()
//         ^ reference local0
//           ^^^^^^^^^^^^^^^^^^^^^^ reference minimized/SubClasses#abstractImplementation().
        + s.defaultImplementation()
//        ^ reference local0
//          ^^^^^^^^^^^^^^^^^^^^^ reference minimized/AbstractClasses#defaultImplementation().
        + s.abstractInterfaceMethod()
//        ^ reference local0
//          ^^^^^^^^^^^^^^^^^^^^^^^ reference minimized/SubClasses#abstractInterfaceMethod().
        + s.defaultInterfaceMethod();
//        ^ reference local0
//          ^^^^^^^^^^^^^^^^^^^^^^ reference minimized/Interfaces#defaultInterfaceMethod().
  }
}
