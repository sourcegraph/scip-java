  import module java.base;
  
  /// Compact source file with an instance main method.
//⌄ enclosing_range_start scip-java maven . . CompactMain#main().
  void main() {
//     ^^^^ definition scip-java maven . . CompactMain#main().
//          kind Method
//          display_name main
//          signature_documentation
//          > void main()
//          documentation
//          > Compact source file with an instance main method.
    IO.println(message());
//  ^^ reference scip-java maven jdk 25 java/lang/IO#
//     ^^^^^^^ reference scip-java maven jdk 25 java/lang/IO#println().
//             ^^^^^^^ reference scip-java maven . . CompactMain#message().
  }
//⌃ enclosing_range_end scip-java maven . . CompactMain#main().
  
//⌄ enclosing_range_start scip-java maven . . CompactMain#message().
  String message() {
//^^^^^^ reference scip-java maven jdk 25 java/lang/String#
//       ^^^^^^^ definition scip-java maven . . CompactMain#message().
//               kind Method
//               display_name message
//               signature_documentation
//               > String message()
    return List.of("Java", "25").get(1);
//         ^^^^ reference scip-java maven jdk 25 java/util/List#
//              ^^ reference scip-java maven jdk 25 java/util/List#of(+2).
//                               ^^^ reference scip-java maven jdk 25 java/util/List#get().
  }
//⌃ enclosing_range_end scip-java maven . . CompactMain#message().
  
