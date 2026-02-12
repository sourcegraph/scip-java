  package minimized;
  
//⌄ enclosing_range_start semanticdb maven . . minimized/Fields#
  public class Fields {
//             ^^^^^^ definition semanticdb maven . . minimized/Fields#
//                    display_name Fields
//                    signature_documentation java public class Fields
//                    kind Class
//             ^^^^^^ definition semanticdb maven . . minimized/Fields#`<init>`().
//                    display_name <init>
//                    signature_documentation java public Fields()
//                    kind Constructor
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Fields#privateField.
    private final int privateField = 0;
//                    ^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#privateField.
//                                 display_name privateField
//                                 signature_documentation java private final int privateField
//                                 kind Field
//                                    ⌃ enclosing_range_end semanticdb maven . . minimized/Fields#privateField.
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Fields#protectedField.
    protected int protectedField = 0;
//                ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#protectedField.
//                               display_name protectedField
//                               signature_documentation java protected int protectedField
//                               kind Field
//                                  ⌃ enclosing_range_end semanticdb maven . . minimized/Fields#protectedField.
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Fields#publicField.
    public int publicField = 0;
//             ^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#publicField.
//                         display_name publicField
//                         signature_documentation java public int publicField
//                         kind Field
//                            ⌃ enclosing_range_end semanticdb maven . . minimized/Fields#publicField.
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Fields#staticPrivateField.
    private static final int staticPrivateField = 0;
//                           ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#staticPrivateField.
//                                              display_name staticPrivateField
//                                              signature_documentation java private static final int staticPrivateField
//                                              kind StaticField
//                                                 ⌃ enclosing_range_end semanticdb maven . . minimized/Fields#staticPrivateField.
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Fields#staticProtectedFields.
    protected static int staticProtectedFields = 0;
//                       ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#staticProtectedFields.
//                                             display_name staticProtectedFields
//                                             signature_documentation java protected static int staticProtectedFields
//                                             kind StaticField
//                                                ⌃ enclosing_range_end semanticdb maven . . minimized/Fields#staticProtectedFields.
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Fields#staticPublicField.
    public static int staticPublicField = 0;
//                    ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#staticPublicField.
//                                      display_name staticPublicField
//                                      signature_documentation java public static int staticPublicField
//                                      kind StaticField
//                                         ⌃ enclosing_range_end semanticdb maven . . minimized/Fields#staticPublicField.
  
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Fields#InnerFields#
    public class InnerFields {
//               ^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#InnerFields#
//                           display_name InnerFields
//                           signature_documentation java public class InnerFields
//                           kind Class
//               ^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#InnerFields#`<init>`().
//                           display_name <init>
//                           signature_documentation java public InnerFields()
//                           kind Constructor
//    ⌄ enclosing_range_start semanticdb maven . . minimized/Fields#InnerFields#publicInnerField.
      public int publicInnerField = publicField;
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#InnerFields#publicInnerField.
//                                display_name publicInnerField
//                                signature_documentation java public int publicInnerField
//                                kind Field
//                                  ^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#publicField.
//                                             ⌃ enclosing_range_end semanticdb maven . . minimized/Fields#InnerFields#publicInnerField.
    }
//  ⌃ enclosing_range_end semanticdb maven . . minimized/Fields#InnerFields#
  
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Fields#InnerStaticFields#
    public static class InnerStaticFields {
//                      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#InnerStaticFields#
//                                        display_name InnerStaticFields
//                                        signature_documentation java public static class InnerStaticFields
//                                        kind Class
//                      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#InnerStaticFields#`<init>`().
//                                        display_name <init>
//                                        signature_documentation java public InnerStaticFields()
//                                        kind Constructor
//    ⌄ enclosing_range_start semanticdb maven . . minimized/Fields#InnerStaticFields#publicNonStaticInnerField.
      public int publicNonStaticInnerField = 0;
//               ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#InnerStaticFields#publicNonStaticInnerField.
//                                         display_name publicNonStaticInnerField
//                                         signature_documentation java public int publicNonStaticInnerField
//                                         kind Field
//                                            ⌃ enclosing_range_end semanticdb maven . . minimized/Fields#InnerStaticFields#publicNonStaticInnerField.
//    ⌄ enclosing_range_start semanticdb maven . . minimized/Fields#InnerStaticFields#publicStaticInnerField.
      public static int publicStaticInnerField = 0;
//                      ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#InnerStaticFields#publicStaticInnerField.
//                                             display_name publicStaticInnerField
//                                             signature_documentation java public static int publicStaticInnerField
//                                             kind StaticField
//                                                ⌃ enclosing_range_end semanticdb maven . . minimized/Fields#InnerStaticFields#publicStaticInnerField.
    }
//  ⌃ enclosing_range_end semanticdb maven . . minimized/Fields#InnerStaticFields#
  
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Fields#app().
    public static String app() {
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                       ^^^ definition semanticdb maven . . minimized/Fields#app().
//                           display_name app
//                           signature_documentation java public static String app()
//                           kind StaticMethod
//    ⌄ enclosing_range_start local 0
      Fields fields = new Fields();
//    ^^^^^^ reference semanticdb maven . . minimized/Fields#
//           ^^^^^^ definition local 0
//                  display_name fields
//                  signature_documentation java Fields fields
//                  enclosing_symbol semanticdb maven . . minimized/Fields#app().
//                  kind Variable
//                        ^^^^^^ reference semanticdb maven . . minimized/Fields#`<init>`().
//                                ⌃ enclosing_range_end local 0
//    ⌄ enclosing_range_start local 1
      InnerFields innerFields = fields.new InnerFields();
//    ^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerFields#
//                ^^^^^^^^^^^ definition local 1
//                            display_name innerFields
//                            signature_documentation java InnerFields innerFields
//                            enclosing_symbol semanticdb maven . . minimized/Fields#app().
//                            kind Variable
//                              ^^^^^^ reference local 0
//                                         ^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerFields#`<init>`().
//                                                      ⌃ enclosing_range_end local 1
//    ⌄ enclosing_range_start local 2
      InnerStaticFields innerStaticFields = new InnerStaticFields();
//    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerStaticFields#
//                      ^^^^^^^^^^^^^^^^^ definition local 2
//                                        display_name innerStaticFields
//                                        signature_documentation java InnerStaticFields innerStaticFields
//                                        enclosing_symbol semanticdb maven . . minimized/Fields#app().
//                                        kind Variable
//                                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerStaticFields#`<init>`().
//                                                                 ⌃ enclosing_range_end local 2
      return String.valueOf(fields.privateField)
//           ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                  ^^^^^^^ reference semanticdb maven jdk 11 java/lang/String#valueOf(+5).
//                          ^^^^^^ reference local 0
//                                 ^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#privateField.
          + fields.protectedField
//          ^^^^^^ reference local 0
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#protectedField.
          + fields.publicField
//          ^^^^^^ reference local 0
//                 ^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#publicField.
          + staticPrivateField
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#staticPrivateField.
          + staticProtectedFields
//          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#staticProtectedFields.
          + staticPublicField
//          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#staticPublicField.
          + innerFields.publicInnerField
//          ^^^^^^^^^^^ reference local 1
//                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerFields#publicInnerField.
          + InnerStaticFields.publicStaticInnerField
//          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerStaticFields#
//                            ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerStaticFields#publicStaticInnerField.
          + innerStaticFields.publicNonStaticInnerField;
//          ^^^^^^^^^^^^^^^^^ reference local 2
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerStaticFields#publicNonStaticInnerField.
    }
//  ⌃ enclosing_range_end semanticdb maven . . minimized/Fields#app().
  }
//⌃ enclosing_range_end semanticdb maven . . minimized/Fields#
