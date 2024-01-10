package minimized;

public abstract class AbstractClasses {
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AbstractClasses#
//                                    display_name AbstractClasses
//                                    signature_documentation java public abstract class AbstractClasses
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
//                                    kind Method
    return "";
  }

  public abstract String abstractImplementation();
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                       ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AbstractClasses#abstractImplementation().
//                                              display_name abstractImplementation
//                                              signature_documentation java public abstract String abstractImplementation()
//                                              kind AbstractMethod
//                                              relationship is_reference is_implementation semanticdb maven . . minimized/SubClasses#abstractImplementation().
}
