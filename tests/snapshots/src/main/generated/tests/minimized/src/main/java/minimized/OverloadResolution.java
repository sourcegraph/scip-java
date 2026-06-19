  package minimized;
  
  /**
   * Reference-side overload disambiguation migrated from the former TargetedSuite "issue-24" test:
   * references to the four String#lastIndexOf overloads must resolve to distinct disambiguated
   * symbols (lastIndexOf(), (+1), (+2), (+3)).
   */
//⌄ enclosing_range_start scip-java maven . . minimized/OverloadResolution#
  public class OverloadResolution {
//             ^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/OverloadResolution#
//                                kind Class
//                                display_name OverloadResolution
//                                signature_documentation
//                                > public class OverloadResolution
//                                documentation
//                                > Reference-side overload disambiguation migrated from the former TargetedSuite "issue-24" test:
//                                >  references to the four String#lastIndexOf overloads must resolve to distinct disambiguated
//                                >  symbols (lastIndexOf(), (+1), (+2), (+3)).
//             ^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/OverloadResolution#`<init>`().
//                                kind Constructor
//                                display_name <init>
//                                signature_documentation
//                                > public OverloadResolution()
//  ⌄ enclosing_range_start scip-java maven . . minimized/OverloadResolution#app().
    public static void app() {
//                     ^^^ definition scip-java maven . . minimized/OverloadResolution#app().
//                         kind StaticMethod
//                         display_name app
//                         signature_documentation
//                         > public static void app()
      "".lastIndexOf('a');
//       ^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/String#lastIndexOf().
      "".lastIndexOf('b', 0);
//       ^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/String#lastIndexOf(+1).
      "".lastIndexOf("c");
//       ^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/String#lastIndexOf(+2).
      "".lastIndexOf("d", 0);
//       ^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/String#lastIndexOf(+3).
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/OverloadResolution#app().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/OverloadResolution#
  
