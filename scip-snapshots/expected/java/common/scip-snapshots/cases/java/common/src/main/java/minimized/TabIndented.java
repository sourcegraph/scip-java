  package minimized;
  
//⌄ enclosing_range_start scip-java maven . . minimized/TabIndented#
  public class TabIndented {
//             ^^^^^^^^^^^ definition scip-java maven . . minimized/TabIndented#
//                         kind Class
//                         display_name TabIndented
//                         signature_documentation
//                         > public class TabIndented
//             ^^^^^^^^^^^ definition scip-java maven . . minimized/TabIndented#`<init>`().
//                         kind Constructor
//                         display_name <init>
//                         signature_documentation
//                         > public TabIndented()
//  ⌄ enclosing_range_start scip-java maven . . minimized/TabIndented#app().
    public void app() {
//              ^^^ definition scip-java maven . . minimized/TabIndented#app().
//                  kind Method
//                  display_name app
//                  signature_documentation
//                  > public void app()
//    ⌄ enclosing_range_start local 0
      Object o = new Object() {
//    ^^^^^^ reference scip-java maven jdk 17 java/lang/Object#
//           ^ definition local 0
//             kind Variable
//             display_name o
//             signature_documentation
//             > Object o
//                   ^^^^^^ reference scip-java maven jdk 17 java/lang/Object#
//      ⌄ enclosing_range_start local 2
        @Override
//       ^^^^^^^^ reference scip-java maven jdk 17 java/lang/Override#
//                            ⌄ enclosing_range_start local 3
        public boolean equals(Object other) {
//                     ^^^^^^ definition local 2
//                            kind Method
//                            display_name equals
//                            signature_documentation
//                            > @Override
//                            > public boolean equals(Object other)
//                            relationship scip-java maven jdk 17 java/lang/Object#equals(). implementation reference
//                            ^^^^^^ reference scip-java maven jdk 17 java/lang/Object#
//                                   ^^^^^ definition local 3
//                                         display_name other
//                                         signature_documentation
//                                         > Object other
//                                       ⌃ enclosing_range_end local 3
          return false;
        }
//      ⌃ enclosing_range_end local 2
  
//      ⌄ enclosing_range_start local 4
        @Override
//       ^^^^^^^^ reference scip-java maven jdk 17 java/lang/Override#
        public int hashCode() {
//                 ^^^^^^^^ definition local 4
//                          kind Method
//                          display_name hashCode
//                          signature_documentation
//                          > @Override
//                          > public int hashCode()
//                          relationship scip-java maven jdk 17 java/lang/Object#hashCode(). implementation reference
          return System.identityHashCode(this);
//               ^^^^^^ reference scip-java maven jdk 17 java/lang/System#
//                      ^^^^^^^^^^^^^^^^ reference scip-java maven jdk 17 java/lang/System#identityHashCode().
        }
//      ⌃ enclosing_range_end local 4
  
//      ⌄ enclosing_range_start local 5
        @Override
//       ^^^^^^^^ reference scip-java maven jdk 17 java/lang/Override#
        public String toString() {
//             ^^^^^^ reference scip-java maven jdk 17 java/lang/String#
//                    ^^^^^^^^ definition local 5
//                             kind Method
//                             display_name toString
//                             signature_documentation
//                             > @Override
//                             > public String toString()
//                             relationship scip-java maven jdk 17 java/lang/Object#toString(). implementation reference
          return "";
        }
//      ⌃ enclosing_range_end local 5
      };
//     ⌃ enclosing_range_end local 0
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/TabIndented#app().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/TabIndented#
  
