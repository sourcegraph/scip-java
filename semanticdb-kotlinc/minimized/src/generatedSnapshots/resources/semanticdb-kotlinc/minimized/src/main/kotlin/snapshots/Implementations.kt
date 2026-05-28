  package snapshots
//        ^^^^^^^^^ reference scip-java maven . . snapshots/
  
//⌄ enclosing_range_start scip-java maven . . snapshots/Overrides#
//⌄ enclosing_range_start scip-java maven . . snapshots/Overrides#`<init>`().
  class Overrides : AutoCloseable {
//      ^^^^^^^^^ definition scip-java maven . . snapshots/Overrides#
//                display_name Overrides
//                signature_documentation kotlin public final class Overrides : {kotlin/AutoCloseable=} AutoCloseable
//                kind Class
//                relationship is_implementation scip-java maven jdk 11 java/lang/AutoCloseable#
//      ^^^^^^^^^ definition scip-java maven . . snapshots/Overrides#`<init>`().
//                display_name Overrides
//                signature_documentation kotlin public constructor(): Overrides
//                kind Constructor
//                  ^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/AutoCloseable#
//    ⌄ enclosing_range_start scip-java maven . . snapshots/Overrides#close().
      override fun close() {
//                 ^^^^^ definition scip-java maven . . snapshots/Overrides#close().
//                       display_name close
//                       signature_documentation kotlin public open override fun close(): Unit
//                       kind Method
//                       relationship is_reference is_implementation scip-java maven jdk 11 java/lang/AutoCloseable#close().
          TODO("Not yet implemented")
//        ^^^^ reference scip-java maven . . kotlin/TODO(+1).
      }
//    ⌃ enclosing_range_end scip-java maven . . snapshots/Overrides#close().
  }
//⌃ enclosing_range_end scip-java maven . . snapshots/Overrides#
//⌃ enclosing_range_end scip-java maven . . snapshots/Overrides#`<init>`().
  
//⌄ enclosing_range_start scip-java maven . . snapshots/Animal#
  interface Animal {
//          ^^^^^^ definition scip-java maven . . snapshots/Animal#
//                 display_name Animal
//                 signature_documentation kotlin public abstract interface Animal : Any
//                 kind Interface
//    ⌄ enclosing_range_start scip-java maven . . snapshots/Animal#favoriteNumber.
//    ⌄ enclosing_range_start scip-java maven . . snapshots/Animal#getFavoriteNumber().
      val favoriteNumber: Int
//        ^^^^^^^^^^^^^^ definition scip-java maven . . snapshots/Animal#favoriteNumber.
//                       display_name favoriteNumber
//                       signature_documentation kotlin public abstract val favoriteNumber: Int
//                       kind Property
//        ^^^^^^^^^^^^^^ definition scip-java maven . . snapshots/Animal#getFavoriteNumber().
//                       display_name favoriteNumber
//                       signature_documentation kotlin public get(): Int
//                       kind Method
//                        ^^^ reference scip-java maven . . kotlin/Int#
//                          ⌃ enclosing_range_end scip-java maven . . snapshots/Animal#favoriteNumber.
//                          ⌃ enclosing_range_end scip-java maven . . snapshots/Animal#getFavoriteNumber().
//    ⌄ enclosing_range_start scip-java maven . . snapshots/Animal#sound().
      fun sound(): String
//        ^^^^^ definition scip-java maven . . snapshots/Animal#sound().
//              display_name sound
//              signature_documentation kotlin public abstract fun sound(): String
//              kind Method
//                 ^^^^^^ reference scip-java maven . . kotlin/String#
//                      ⌃ enclosing_range_end scip-java maven . . snapshots/Animal#sound().
  }
//⌃ enclosing_range_end scip-java maven . . snapshots/Animal#
//⌄ enclosing_range_start scip-java maven . . snapshots/Bird#
//⌄ enclosing_range_start scip-java maven . . snapshots/Bird#`<init>`().
  open class Bird : Animal {
//           ^^^^ definition scip-java maven . . snapshots/Bird#
//                display_name Bird
//                signature_documentation kotlin public open class Bird : Animal
//                kind Class
//                relationship is_implementation scip-java maven . . snapshots/Animal#
//           ^^^^ definition scip-java maven . . snapshots/Bird#`<init>`().
//                display_name Bird
//                signature_documentation kotlin public constructor(): Bird
//                kind Constructor
//                  ^^^^^^ reference scip-java maven . . snapshots/Animal#
//    ⌄ enclosing_range_start scip-java maven . . snapshots/Bird#favoriteNumber.
      override val favoriteNumber: Int
//                 ^^^^^^^^^^^^^^ definition scip-java maven . . snapshots/Bird#favoriteNumber.
//                                display_name favoriteNumber
//                                signature_documentation kotlin public open override val favoriteNumber: Int
//                                kind Property
//                                 ^^^ reference scip-java maven . . kotlin/Int#
//        ⌄ enclosing_range_start scip-java maven . . snapshots/Bird#getFavoriteNumber().
          get() = 42
//        ^^^ definition scip-java maven . . snapshots/Bird#getFavoriteNumber().
//            display_name favoriteNumber
//            signature_documentation kotlin public get(): Int
//            kind Method
//                 ⌃ enclosing_range_end scip-java maven . . snapshots/Bird#favoriteNumber.
//                 ⌃ enclosing_range_end scip-java maven . . snapshots/Bird#getFavoriteNumber().
  
//    ⌄ enclosing_range_start scip-java maven . . snapshots/Bird#sound().
      override fun sound(): String {
//                 ^^^^^ definition scip-java maven . . snapshots/Bird#sound().
//                       display_name sound
//                       signature_documentation kotlin public open override fun sound(): String
//                       kind Method
//                       relationship is_reference is_implementation scip-java maven . . snapshots/Animal#sound().
//                          ^^^^^^ reference scip-java maven . . kotlin/String#
          return "tweet"
      }
//    ⌃ enclosing_range_end scip-java maven . . snapshots/Bird#sound().
  }
//⌃ enclosing_range_end scip-java maven . . snapshots/Bird#
//⌃ enclosing_range_end scip-java maven . . snapshots/Bird#`<init>`().
//⌄ enclosing_range_start scip-java maven . . snapshots/Seagull#
//⌄ enclosing_range_start scip-java maven . . snapshots/Seagull#`<init>`().
  class Seagull : Bird() {
//      ^^^^^^^ definition scip-java maven . . snapshots/Seagull#
//              display_name Seagull
//              signature_documentation kotlin public final class Seagull : Bird
//              kind Class
//              relationship is_implementation scip-java maven . . snapshots/Bird#
//      ^^^^^^^ definition scip-java maven . . snapshots/Seagull#`<init>`().
//              display_name Seagull
//              signature_documentation kotlin public constructor(): Seagull
//              kind Constructor
//                ^^^^ reference scip-java maven . . snapshots/Bird#
//    ⌄ enclosing_range_start scip-java maven . . snapshots/Seagull#favoriteNumber.
      override val favoriteNumber: Int
//                 ^^^^^^^^^^^^^^ definition scip-java maven . . snapshots/Seagull#favoriteNumber.
//                                display_name favoriteNumber
//                                signature_documentation kotlin public open override val favoriteNumber: Int
//                                kind Property
//                                 ^^^ reference scip-java maven . . kotlin/Int#
//        ⌄ enclosing_range_start scip-java maven . . snapshots/Seagull#getFavoriteNumber().
          get() = 1337
//        ^^^ definition scip-java maven . . snapshots/Seagull#getFavoriteNumber().
//            display_name favoriteNumber
//            signature_documentation kotlin public get(): Int
//            kind Method
//                   ⌃ enclosing_range_end scip-java maven . . snapshots/Seagull#favoriteNumber.
//                   ⌃ enclosing_range_end scip-java maven . . snapshots/Seagull#getFavoriteNumber().
//    ⌄ enclosing_range_start scip-java maven . . snapshots/Seagull#sound().
      override fun sound(): String {
//                 ^^^^^ definition scip-java maven . . snapshots/Seagull#sound().
//                       display_name sound
//                       signature_documentation kotlin public open override fun sound(): String
//                       kind Method
//                       relationship is_reference is_implementation scip-java maven . . snapshots/Bird#sound().
//                          ^^^^^^ reference scip-java maven . . kotlin/String#
          return "squawk"
      }
//    ⌃ enclosing_range_end scip-java maven . . snapshots/Seagull#sound().
  }
//⌃ enclosing_range_end scip-java maven . . snapshots/Seagull#
//⌃ enclosing_range_end scip-java maven . . snapshots/Seagull#`<init>`().
