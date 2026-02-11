package minimized;

public abstract class AbstractClasses {
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AbstractClasses#
//                                    display_name AbstractClasses
//                                    signature_documentation java public abstract class AbstractClasses
//                                    enclosing_range 2 0 8 1
//                                    kind Class
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AbstractClasses#`<init>`().
//                                    display_name <init>
//                                    signature_documentation java public AbstractClasses()
//                                    kind Constructor
  public String defaultImplementation() {
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AbstractClasses#defaultImplementation().
//                                    display_name defaultImplementation
//                                    signature_documentation java public String defaultImplementation()
//                                    enclosing_range 3 2 5 3
//                                    kind Method
    return "";
  }

  public abstract String abstractImplementation();
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                       ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AbstractClasses#abstractImplementation().
//                                              display_name abstractImplementation
//                                              signature_documentation java public abstract String abstractImplementation()
//                                              enclosing_range 7 2 50
//                                              kind AbstractMethod
//                                              relationship is_reference is_implementation semanticdb maven . . minimized/SubClasses#abstractImplementation().
}
