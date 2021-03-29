package minimized;

public abstract class AbstractClasses {
//                    ^^^^^^^^^^^^^^^ definition minimized/AbstractClasses# public abstract class AbstractClasses
//                    ^^^^^^^^^^^^^^^ definition minimized/AbstractClasses#`<init>`(). public <init>()
  public String defaultImplementation() {
//       ^^^^^^ reference java/lang/String#
//              ^^^^^^^^^^^^^^^^^^^^^ definition minimized/AbstractClasses#defaultImplementation(). public String defaultImplementation()
    return "";
  }

  public abstract String abstractImplementation();
//                ^^^^^^ reference java/lang/String#
//                       ^^^^^^^^^^^^^^^^^^^^^^ definition minimized/AbstractClasses#abstractImplementation(). public abstract String abstractImplementation()
}
