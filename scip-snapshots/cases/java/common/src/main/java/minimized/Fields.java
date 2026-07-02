package minimized;

public class Fields {
  private final int privateField = 0;
  protected int protectedField = 0;
  public int publicField = 0;
  private static final int staticPrivateField = 0;
  protected static int staticProtectedFields = 0;
  public static int staticPublicField = 0;

  public class InnerFields {
    public int publicInnerField = publicField;
  }

  public static class InnerStaticFields {
    public int publicNonStaticInnerField = 0;
    public static int publicStaticInnerField = 0;
  }

  public static String app() {
    Fields fields = new Fields();
    InnerFields innerFields = fields.new InnerFields();
    InnerStaticFields innerStaticFields = new InnerStaticFields();
    return String.valueOf(fields.privateField)
        + fields.protectedField
        + fields.publicField
        + staticPrivateField
        + staticProtectedFields
        + staticPublicField
        + innerFields.publicInnerField
        + InnerStaticFields.publicStaticInnerField
        + innerStaticFields.publicNonStaticInnerField;
  }
}
