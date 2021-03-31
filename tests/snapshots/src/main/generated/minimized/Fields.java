package minimized;

public class Fields {
//           ^^^^^^ definition minimized/Fields# public class Fields
//           ^^^^^^ definition minimized/Fields#`<init>`(). public void <init>()
  private final int privateField = 0;
//                  ^^^^^^^^^^^^ definition minimized/Fields#privateField. private final int privateField
  protected int protectedField = 0;
//              ^^^^^^^^^^^^^^ definition minimized/Fields#protectedField. protected int protectedField
  public int publicField = 0;
//           ^^^^^^^^^^^ definition minimized/Fields#publicField. public int publicField
  private static final int staticPrivateField = 0;
//                         ^^^^^^^^^^^^^^^^^^ definition minimized/Fields#staticPrivateField. private static final int staticPrivateField
  protected static int staticProtectedFields = 0;
//                     ^^^^^^^^^^^^^^^^^^^^^ definition minimized/Fields#staticProtectedFields. protected static int staticProtectedFields
  public static int staticPublicField = 0;
//                  ^^^^^^^^^^^^^^^^^ definition minimized/Fields#staticPublicField. public static int staticPublicField

  public class InnerFields {
//             ^^^^^^^^^^^ definition minimized/Fields#InnerFields# public class InnerFields
//             ^^^^^^^^^^^ definition minimized/Fields#InnerFields#`<init>`(). public void <init>()
    public int publicInnerField = publicField;
//             ^^^^^^^^^^^^^^^^ definition minimized/Fields#InnerFields#publicInnerField. public int publicInnerField
//                                ^^^^^^^^^^^ reference minimized/Fields#publicField.
  }

  public static class InnerStaticFields {
//                    ^^^^^^^^^^^^^^^^^ definition minimized/Fields#InnerStaticFields# public static class InnerStaticFields
//                    ^^^^^^^^^^^^^^^^^ definition minimized/Fields#InnerStaticFields#`<init>`(). public void <init>()
    public int publicNonStaticInnerField = 0;
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ definition minimized/Fields#InnerStaticFields#publicNonStaticInnerField. public int publicNonStaticInnerField
    public static int publicStaticInnerField = 0;
//                    ^^^^^^^^^^^^^^^^^^^^^^ definition minimized/Fields#InnerStaticFields#publicStaticInnerField. public static int publicStaticInnerField
  }

  public static String app() {
//              ^^^^^^ reference java/lang/String#
//                     ^^^ definition minimized/Fields#app(). public static String app()
    Fields fields = new Fields();
//  ^^^^^^ reference minimized/Fields#
//         ^^^^^^ definition local0 Fields fields
//                  ^^^^^^^^^^^^ reference minimized/Fields#`<init>`().
//                      ^^^^^^ reference minimized/Fields#
    InnerFields innerFields = fields.new InnerFields();
//  ^^^^^^^^^^^ reference minimized/Fields#InnerFields#
//              ^^^^^^^^^^^ definition local1 InnerFields innerFields
//                            ^^^^^^ reference local0
//                            ^^^^^^^^^^^^^^^^^^^^^^^^ reference minimized/Fields#InnerFields#`<init>`().
//                                       ^^^^^^^^^^^ reference minimized/Fields#InnerFields#
    InnerStaticFields innerStaticFields = new InnerStaticFields();
//  ^^^^^^^^^^^^^^^^^ reference minimized/Fields#InnerStaticFields#
//                    ^^^^^^^^^^^^^^^^^ definition local2 InnerStaticFields innerStaticFields
//                                        ^^^^^^^^^^^^^^^^^^^^^^^ reference minimized/Fields#InnerStaticFields#`<init>`().
//                                            ^^^^^^^^^^^^^^^^^ reference minimized/Fields#InnerStaticFields#
    return String.valueOf(fields.privateField)
//         ^^^^^^ reference java/lang/String#
//                ^^^^^^^ reference java/lang/String#valueOf(+5).
//                        ^^^^^^ reference local0
//                               ^^^^^^^^^^^^ reference minimized/Fields#privateField.
        + fields.protectedField
//        ^^^^^^ reference local0
//               ^^^^^^^^^^^^^^ reference minimized/Fields#protectedField.
        + fields.publicField
//        ^^^^^^ reference local0
//               ^^^^^^^^^^^ reference minimized/Fields#publicField.
        + staticPrivateField
//        ^^^^^^^^^^^^^^^^^^ reference minimized/Fields#staticPrivateField.
        + staticProtectedFields
//        ^^^^^^^^^^^^^^^^^^^^^ reference minimized/Fields#staticProtectedFields.
        + staticPublicField
//        ^^^^^^^^^^^^^^^^^ reference minimized/Fields#staticPublicField.
        + innerFields.publicInnerField
//        ^^^^^^^^^^^ reference local1
//                    ^^^^^^^^^^^^^^^^ reference minimized/Fields#InnerFields#publicInnerField.
        + InnerStaticFields.publicStaticInnerField
//        ^^^^^^^^^^^^^^^^^ reference minimized/Fields#InnerStaticFields#
//                          ^^^^^^^^^^^^^^^^^^^^^^ reference minimized/Fields#InnerStaticFields#publicStaticInnerField.
        + innerStaticFields.publicNonStaticInnerField;
//        ^^^^^^^^^^^^^^^^^ reference local2
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference minimized/Fields#InnerStaticFields#publicNonStaticInnerField.
  }
}
