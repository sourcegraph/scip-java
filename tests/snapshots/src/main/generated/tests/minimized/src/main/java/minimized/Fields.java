package minimized;

public class Fields {
//           ^^^^^^ definition semanticdb maven . . minimized/Fields#
//                  display_name Fields
//                  documentation ```java\npublic class Fields\n```
//           ^^^^^^ definition semanticdb maven . . minimized/Fields#`<init>`().
//                  display_name <init>
//                  documentation ```java\npublic Fields()\n```
  private final int privateField = 0;
//                  ^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#privateField.
//                               display_name privateField
//                               documentation ```java\nprivate final int privateField\n```
  protected int protectedField = 0;
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#protectedField.
//                             display_name protectedField
//                             documentation ```java\nprotected int protectedField\n```
  public int publicField = 0;
//           ^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#publicField.
//                       display_name publicField
//                       documentation ```java\npublic int publicField\n```
  private static final int staticPrivateField = 0;
//                         ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#staticPrivateField.
//                                            display_name staticPrivateField
//                                            documentation ```java\nprivate static final int staticPrivateField\n```
  protected static int staticProtectedFields = 0;
//                     ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#staticProtectedFields.
//                                           display_name staticProtectedFields
//                                           documentation ```java\nprotected static int staticProtectedFields\n```
  public static int staticPublicField = 0;
//                  ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#staticPublicField.
//                                    display_name staticPublicField
//                                    documentation ```java\npublic static int staticPublicField\n```

  public class InnerFields {
//             ^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#InnerFields#
//                         display_name InnerFields
//                         documentation ```java\npublic class InnerFields\n```
//             ^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#InnerFields#`<init>`().
//                         display_name <init>
//                         documentation ```java\npublic InnerFields()\n```
    public int publicInnerField = publicField;
//             ^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#InnerFields#publicInnerField.
//                              display_name publicInnerField
//                              documentation ```java\npublic int publicInnerField\n```
//                                ^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#publicField.
  }

  public static class InnerStaticFields {
//                    ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#InnerStaticFields#
//                                      display_name InnerStaticFields
//                                      documentation ```java\npublic static class InnerStaticFields\n```
//                    ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#InnerStaticFields#`<init>`().
//                                      display_name <init>
//                                      documentation ```java\npublic InnerStaticFields()\n```
    public int publicNonStaticInnerField = 0;
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#InnerStaticFields#publicNonStaticInnerField.
//                                       display_name publicNonStaticInnerField
//                                       documentation ```java\npublic int publicNonStaticInnerField\n```
    public static int publicStaticInnerField = 0;
//                    ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Fields#InnerStaticFields#publicStaticInnerField.
//                                           display_name publicStaticInnerField
//                                           documentation ```java\npublic static int publicStaticInnerField\n```
  }

  public static String app() {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/Fields#app().
//                         display_name app
//                         documentation ```java\npublic static String app()\n```
    Fields fields = new Fields();
//  ^^^^^^ reference semanticdb maven . . minimized/Fields#
//         ^^^^^^ definition local 0
//                display_name fields
//                documentation ```java\nFields fields\n```
//                      ^^^^^^ reference semanticdb maven . . minimized/Fields#`<init>`().
    InnerFields innerFields = fields.new InnerFields();
//  ^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerFields#
//              ^^^^^^^^^^^ definition local 1
//                          display_name innerFields
//                          documentation ```java\nInnerFields innerFields\n```
//                            ^^^^^^ reference local 0
//                                       ^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerFields#`<init>`().
    InnerStaticFields innerStaticFields = new InnerStaticFields();
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerStaticFields#
//                    ^^^^^^^^^^^^^^^^^ definition local 2
//                                      display_name innerStaticFields
//                                      documentation ```java\nInnerStaticFields innerStaticFields\n```
//                                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerStaticFields#`<init>`().
    return String.valueOf(fields.privateField)
//         ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                ^^^^^^^ reference semanticdb maven jdk 11 java/lang/String#valueOf(+5).
//                        ^^^^^^ reference local 0
//                               ^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#privateField.
        + fields.protectedField
//        ^^^^^^ reference local 0
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#protectedField.
        + fields.publicField
//        ^^^^^^ reference local 0
//               ^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#publicField.
        + staticPrivateField
//        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#staticPrivateField.
        + staticProtectedFields
//        ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#staticProtectedFields.
        + staticPublicField
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#staticPublicField.
        + innerFields.publicInnerField
//        ^^^^^^^^^^^ reference local 1
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerFields#publicInnerField.
        + InnerStaticFields.publicStaticInnerField
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerStaticFields#
//                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerStaticFields#publicStaticInnerField.
        + innerStaticFields.publicNonStaticInnerField;
//        ^^^^^^^^^^^^^^^^^ reference local 2
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Fields#InnerStaticFields#publicNonStaticInnerField.
  }
}
