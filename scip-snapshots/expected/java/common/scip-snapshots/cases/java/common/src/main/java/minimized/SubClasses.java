  package minimized;
  
//⌄ enclosing_range_start scip-java maven . . minimized/SubClasses#
  public class SubClasses extends AbstractClasses implements Interfaces {
//             ^^^^^^^^^^ definition scip-java maven . . minimized/SubClasses#
//                        kind Class
//                        display_name SubClasses
//                        signature_documentation
//                        > public class SubClasses extends AbstractClasses implements Interfaces
//                        relationship scip-java maven . . minimized/AbstractClasses# implementation
//                        relationship scip-java maven . . minimized/Interfaces# implementation
//             ^^^^^^^^^^ definition scip-java maven . . minimized/SubClasses#`<init>`().
//                        kind Constructor
//                        display_name <init>
//                        signature_documentation
//                        > public SubClasses()
//                                ^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/AbstractClasses#
//                                                           ^^^^^^^^^^ reference scip-java maven . . minimized/Interfaces#
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/SubClasses#abstractImplementation().
    @Override
//   ^^^^^^^^ reference scip-java maven jdk 17 java/lang/Override#
    public String abstractImplementation() {
//         ^^^^^^ reference scip-java maven jdk 17 java/lang/String#
//                ^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/SubClasses#abstractImplementation().
//                                       kind Method
//                                       display_name abstractImplementation
//                                       signature_documentation
//                                       > @Override
//                                       > public String abstractImplementation()
//                                       relationship scip-java maven . . minimized/AbstractClasses#abstractImplementation(). implementation reference
      return "abstract";
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/SubClasses#abstractImplementation().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/SubClasses#abstractInterfaceMethod().
    @Override
//   ^^^^^^^^ reference scip-java maven jdk 17 java/lang/Override#
    public String abstractInterfaceMethod() {
//         ^^^^^^ reference scip-java maven jdk 17 java/lang/String#
//                ^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/SubClasses#abstractInterfaceMethod().
//                                        kind Method
//                                        display_name abstractInterfaceMethod
//                                        signature_documentation
//                                        > @Override
//                                        > public String abstractInterfaceMethod()
//                                        relationship scip-java maven . . minimized/Interfaces#abstractInterfaceMethod(). implementation reference
      return "abstractInterface";
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/SubClasses#abstractInterfaceMethod().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/SubClasses#app().
    public static String app() {
//                ^^^^^^ reference scip-java maven jdk 17 java/lang/String#
//                       ^^^ definition scip-java maven . . minimized/SubClasses#app().
//                           kind StaticMethod
//                           display_name app
//                           signature_documentation
//                           > public static String app()
//    ⌄ enclosing_range_start local 0
      SubClasses s = new SubClasses();
//    ^^^^^^^^^^ reference scip-java maven . . minimized/SubClasses#
//               ^ definition local 0
//                 kind Variable
//                 display_name s
//                 signature_documentation
//                 > SubClasses s
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
  
