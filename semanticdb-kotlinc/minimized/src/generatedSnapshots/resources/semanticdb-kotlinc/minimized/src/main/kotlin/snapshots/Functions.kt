  package snapshots
//        ^^^^^^^^^ reference semanticdb maven . . snapshots/
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/sampleText().
//               ⌄ enclosing_range_start semanticdb maven . . snapshots/sampleText().(x)
  fun sampleText(x: String = "") {
//    ^^^^^^^^^^ definition semanticdb maven . . snapshots/sampleText().
//               display_name sampleText
//               signature_documentation kotlin public final fun sampleText(x: String = ...): Unit
//               ^ definition semanticdb maven . . snapshots/sampleText().(x)
//                 display_name x
//                 signature_documentation kotlin x: String = ...
//                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                            ⌃ enclosing_range_end semanticdb maven . . snapshots/sampleText().(x)
    println(x)
//  ^^^^^^^ reference semanticdb maven . . kotlin/io/println().
//          ^ reference semanticdb maven . . snapshots/sampleText().(x)
  }
//⌃ enclosing_range_end semanticdb maven . . snapshots/sampleText().
