package minimized;

public class SubClasses extends AbstractClasses implements Interfaces {
//     ^^^^^^ definition minimized/SubClasses#`<init>`().
//     ^^^^^^^^^^ definition minimized/SubClasses#
//                              ^^^^^^^^^^^^^^^ reference minimized/AbstractClasses#
//                                                         ^^^^^^^^^^ reference minimized/Interfaces#

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public String abstractImplementation() {
//       ^^^^^^ reference java/lang/String#
//              ^^^^^^^^^^^^^^^^^^^^^^ definition minimized/SubClasses#abstractImplementation().
    return "abstract";
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public String abstractInterfaceMethod() {
//       ^^^^^^ reference java/lang/String#
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition minimized/SubClasses#abstractInterfaceMethod().
    return "abstractInterface";
  }

  public static String app() {
//              ^^^^^^ reference java/lang/String#
//                     ^^^ definition minimized/SubClasses#app().
    SubClasses s = new SubClasses();
//  ^^^^^^^^^^ reference minimized/SubClasses#
//             ^ definition local0
//                 ^^^^^^^^^^^^^^^^ reference minimized/SubClasses#`<init>`().
//                     ^^^^^^^^^^ reference minimized/SubClasses#
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
