package minimized;

/**
 * Override relationships migrated from the former OverridesSuite unit test: same-file overrides and
 * transitive ("multiple") overrides that record more than one `implementation` relationship on a
 * single symbol.
 */
public class Overrides {
  public void stuff() {}

  @Override
  public String toString() {
    return "";
  }

  public class Child extends Overrides {
    // Same-file override of a concrete superclass method.
    @Override
    public void stuff() {}

    // Transitive override: overrides Overrides#toString, which itself overrides
    // java/lang/Object#toString, so this symbol has multiple `implementation`
    // relationships.
    @Override
    public String toString() {
      return "";
    }
  }
}
