package minimized;

public class SubClasses extends AbstractClasses implements Interfaces {

  @Override
  public String abstractImplementation() {
    return "abstract";
  }

  @Override
  public String abstractInterfaceMethod() {
    return "abstractInterface";
  }

  public static String app() {
    SubClasses s = new SubClasses();
    return s.abstractImplementation()
        + s.defaultImplementation()
        + s.abstractInterfaceMethod()
        + s.defaultInterfaceMethod();
  }
}
