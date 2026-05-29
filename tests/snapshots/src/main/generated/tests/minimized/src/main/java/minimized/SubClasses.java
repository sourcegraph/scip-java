  package minimized;
  
//⌄ enclosing_range_start scip-java maven . . minimized/SubClasses#
  public class SubClasses extends AbstractClasses implements Interfaces {
//             ^^^^^^^^^^ definition scip-java maven . . minimized/SubClasses#
//                        display_name SubClasses
//                        signature_documentation java public class SubClasses extends AbstractClasses implements Interfaces
//                        kind Class
//                        relationship is_implementation scip-java maven . . minimized/AbstractClasses#
//                        relationship is_implementation scip-java maven . . minimized/Interfaces#
//             ^^^^^^^^^^ definition scip-java maven . . minimized/SubClasses#`<init>`().
//                        display_name <init>
//                        signature_documentation java public SubClasses()
//                        kind Constructor
//                                ^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/AbstractClasses#
//                                                           ^^^^^^^^^^ reference scip-java maven . . minimized/Interfaces#
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/SubClasses#abstractImplementation().
    @Override
//   ^^^^^^^^ reference scip-java maven jdk 11 java/lang/Override#
    public String abstractImplementation() {
//         ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                ^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/SubClasses#abstractImplementation().
//                                       display_name abstractImplementation
//                                       signature_documentation java @Override\npublic String abstractImplementation()
//                                       kind Method
//                                       relationship is_reference is_implementation scip-java maven . . minimized/AbstractClasses#abstractImplementation().
      return "abstract";
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/SubClasses#abstractImplementation().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/SubClasses#abstractInterfaceMethod().
    @Override
//   ^^^^^^^^ reference scip-java maven jdk 11 java/lang/Override#
    public String abstractInterfaceMethod() {
//         ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                ^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/SubClasses#abstractInterfaceMethod().
//                                        display_name abstractInterfaceMethod
//                                        signature_documentation java @Override\npublic String abstractInterfaceMethod()
//                                        kind Method
//                                        relationship is_reference is_implementation scip-java maven . . minimized/Interfaces#abstractInterfaceMethod().
      return "abstractInterface";
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/SubClasses#abstractInterfaceMethod().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/SubClasses#app().
    public static String app() {
//                ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                       ^^^ definition scip-java maven . . minimized/SubClasses#app().
//                           display_name app
//                           signature_documentation java public static String app()
//                           kind StaticMethod
//    ⌄ enclosing_range_start local 0
      SubClasses s = new SubClasses();
//    ^^^^^^^^^^ reference scip-java maven . . minimized/SubClasses#
//               ^ definition local 0
//                 display_name s
//                 signature_documentation java SubClasses s
//                 enclosing_symbol scip-java maven . . minimized/SubClasses#app().
//                 kind Variable
//                       ^^^^^^^^^^ reference scip-java maven . . minimized/SubClasses#`<init>`().
//                                   ⌃ enclosing_range_end local 0
      return s.abstractImplementation()
//           ^ reference local 0
//             ^^^^^^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/SubClasses#abstractImplementation().
          + s.defaultImplementation()
//          ^ reference local 0
//            ^^^^^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/AbstractClasses#defaultImplementation().
          + s.abstractInterfaceMethod()
//          ^ reference local 0
//            ^^^^^^^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/SubClasses#abstractInterfaceMethod().
          + s.defaultInterfaceMethod();
//          ^ reference local 0
//            ^^^^^^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/Interfaces#defaultInterfaceMethod().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/SubClasses#app().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/SubClasses#
