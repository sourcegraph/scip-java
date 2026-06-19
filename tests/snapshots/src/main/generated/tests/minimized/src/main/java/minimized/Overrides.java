  package minimized;
  
  /**
   * Override relationships migrated from the former OverridesSuite unit test: same-file overrides and
   * transitive ("multiple") overrides that record more than one `implementation` relationship on a
   * single symbol.
   */
//⌄ enclosing_range_start scip-java maven . . minimized/Overrides#
  public class Overrides {
//             ^^^^^^^^^ definition scip-java maven . . minimized/Overrides#
//                       kind Class
//                       display_name Overrides
//                       signature_documentation
//                       > public class Overrides
//                       documentation
//                       > Override relationships migrated from the former OverridesSuite unit test:
//                       >  same-file overrides and transitive ("multiple") overrides that record more
//                       >  than one `implementation` relationship on a single symbol.
//             ^^^^^^^^^ definition scip-java maven . . minimized/Overrides#`<init>`().
//                       kind Constructor
//                       display_name <init>
//                       signature_documentation
//                       > public Overrides()
//  ⌄ enclosing_range_start scip-java maven . . minimized/Overrides#stuff().
    public void stuff() {}
//              ^^^^^ definition scip-java maven . . minimized/Overrides#stuff().
//                    kind Method
//                    display_name stuff
//                    signature_documentation
//                    > public void stuff()
//                    relationship scip-java maven . . minimized/Overrides#Child#stuff(). implementation reference
//                       ⌃ enclosing_range_end scip-java maven . . minimized/Overrides#stuff().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Overrides#toString().
    @Override
//   ^^^^^^^^ reference scip-java maven jdk 11 java/lang/Override#
    public String toString() {
//         ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                ^^^^^^^^ definition scip-java maven . . minimized/Overrides#toString().
//                         kind Method
//                         display_name toString
//                         signature_documentation
//                         > @Override
//                         > public String toString()
//                         relationship scip-java maven . . minimized/Overrides#Child#toString(). implementation reference
//                         relationship scip-java maven jdk 11 java/lang/Object#toString(). implementation reference
      return "";
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Overrides#toString().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Overrides#Child#
    public class Child extends Overrides {
//               ^^^^^ definition scip-java maven . . minimized/Overrides#Child#
//                     kind Class
//                     display_name Child
//                     signature_documentation
//                     > public class Child extends Overrides
//                     relationship scip-java maven . . minimized/Overrides# implementation
//               ^^^^^ definition scip-java maven . . minimized/Overrides#Child#`<init>`().
//                     kind Constructor
//                     display_name <init>
//                     signature_documentation
//                     > public Child()
//                             ^^^^^^^^^ reference scip-java maven . . minimized/Overrides#
      // Same-file override of a concrete superclass method.
//    ⌄ enclosing_range_start scip-java maven . . minimized/Overrides#Child#stuff().
      @Override
//     ^^^^^^^^ reference scip-java maven jdk 11 java/lang/Override#
      public void stuff() {}
//                ^^^^^ definition scip-java maven . . minimized/Overrides#Child#stuff().
//                      kind Method
//                      display_name stuff
//                      signature_documentation
//                      > @Override
//                      > public void stuff()
//                      relationship scip-java maven . . minimized/Overrides#stuff(). implementation reference
//                         ⌃ enclosing_range_end scip-java maven . . minimized/Overrides#Child#stuff().
  
      // Transitive override: overrides Overrides#toString, which itself overrides
      // java/lang/Object#toString, so this symbol has multiple `implementation`
      // relationships.
//    ⌄ enclosing_range_start scip-java maven . . minimized/Overrides#Child#toString().
      @Override
//     ^^^^^^^^ reference scip-java maven jdk 11 java/lang/Override#
      public String toString() {
//           ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                  ^^^^^^^^ definition scip-java maven . . minimized/Overrides#Child#toString().
//                           kind Method
//                           display_name toString
//                           signature_documentation
//                           > @Override
//                           > public String toString()
//                           relationship scip-java maven . . minimized/Overrides#toString(). implementation reference
//                           relationship scip-java maven jdk 11 java/lang/Object#toString(). implementation reference
        return "";
      }
//    ⌃ enclosing_range_end scip-java maven . . minimized/Overrides#Child#toString().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Overrides#Child#
  }
//⌃ enclosing_range_end scip-java maven . . minimized/Overrides#
  
