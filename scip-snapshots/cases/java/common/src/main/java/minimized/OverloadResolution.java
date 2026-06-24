package minimized;

/**
 * Reference-side overload disambiguation migrated from the former TargetedSuite "issue-24" test:
 * references to the four String#lastIndexOf overloads must resolve to distinct disambiguated
 * symbols (lastIndexOf(), (+1), (+2), (+3)).
 */
public class OverloadResolution {
  public static int app() {
    return "".lastIndexOf('a')
        + "".lastIndexOf('b', 0)
        + "".lastIndexOf("c")
        + "".lastIndexOf("d", 0);
  }
}
