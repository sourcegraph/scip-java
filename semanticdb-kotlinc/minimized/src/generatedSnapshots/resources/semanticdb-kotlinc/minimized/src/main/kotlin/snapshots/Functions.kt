  package snapshots
//        ^^^^^^^^^ reference semanticdb maven . . snapshots/
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/sampleText().
//               ⌄ enclosing_range_start semanticdb maven . . snapshots/sampleText().(x)
  fun sampleText(x: String = "") {
//    ^^^^^^^^^^ definition semanticdb maven . . snapshots/sampleText().
//               display_name sampleText
//               documentation ```kotlin\npublic final fun sampleText(x: String = ...): Unit\n```
//               ^ definition semanticdb maven . . snapshots/sampleText().(x)
//                 display_name x
//                 documentation ```kotlin\nx: String = ...\n```
//                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                            ⌃ enclosing_range_end semanticdb maven . . snapshots/sampleText().(x)
    println(x)
//  ^^^^^^^ reference semanticdb maven . . kotlin/io/println().
//          ^ reference semanticdb maven . . snapshots/sampleText().(x)
  }
//⌃ enclosing_range_end semanticdb maven . . snapshots/sampleText().
