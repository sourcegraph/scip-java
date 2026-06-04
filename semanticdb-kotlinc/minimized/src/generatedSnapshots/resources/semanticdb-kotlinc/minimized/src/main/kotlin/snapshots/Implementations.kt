  package snapshots
//        ^^^^^^^^^ reference semanticdb maven . . snapshots/
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/Overrides#
//⌄ enclosing_range_start semanticdb maven . . snapshots/Overrides#`<init>`().
  class Overrides : AutoCloseable {
//      ^^^^^^^^^ definition semanticdb maven . . snapshots/Overrides#
//                display_name Overrides
//                signature_documentation kotlin public final class Overrides : {kotlin/AutoCloseable=} AutoCloseable
//                relationship is_implementation semanticdb maven jdk 11 java/lang/AutoCloseable#
//      ^^^^^^^^^ definition semanticdb maven . . snapshots/Overrides#`<init>`().
//                display_name Overrides
//                signature_documentation kotlin public constructor(): Overrides
//                  ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/AutoCloseable#
//    ⌄ enclosing_range_start semanticdb maven . . snapshots/Overrides#close().
      override fun close() {
//                 ^^^^^ definition semanticdb maven . . snapshots/Overrides#close().
//                       display_name close
//                       signature_documentation kotlin public open override fun close(): Unit
//                       relationship is_implementation semanticdb maven jdk 11 java/lang/AutoCloseable#close().
          TODO("Not yet implemented")
//        ^^^^ reference semanticdb maven . . kotlin/TODO(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . snapshots/Overrides#close().
  }
//⌃ enclosing_range_end semanticdb maven . . snapshots/Overrides#
//⌃ enclosing_range_end semanticdb maven . . snapshots/Overrides#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/Animal#
  interface Animal {
//          ^^^^^^ definition semanticdb maven . . snapshots/Animal#
//                 display_name Animal
//                 signature_documentation kotlin public abstract interface Animal : Any
//    ⌄ enclosing_range_start semanticdb maven . . snapshots/Animal#favoriteNumber.
//    ⌄ enclosing_range_start semanticdb maven . . snapshots/Animal#getFavoriteNumber().
      val favoriteNumber: Int
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/Animal#favoriteNumber.
//                       display_name favoriteNumber
//                       signature_documentation kotlin public abstract val favoriteNumber: Int
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/Animal#getFavoriteNumber().
//                       display_name favoriteNumber
//                       signature_documentation kotlin public get(): Int
//                        ^^^ reference semanticdb maven . . kotlin/Int#
//                          ⌃ enclosing_range_end semanticdb maven . . snapshots/Animal#favoriteNumber.
//                          ⌃ enclosing_range_end semanticdb maven . . snapshots/Animal#getFavoriteNumber().
//    ⌄ enclosing_range_start semanticdb maven . . snapshots/Animal#sound().
      fun sound(): String
//        ^^^^^ definition semanticdb maven . . snapshots/Animal#sound().
//              display_name sound
//              signature_documentation kotlin public abstract fun sound(): String\n
//                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                      ⌃ enclosing_range_end semanticdb maven . . snapshots/Animal#sound().
  }
//⌃ enclosing_range_end semanticdb maven . . snapshots/Animal#
//⌄ enclosing_range_start semanticdb maven . . snapshots/Bird#
//⌄ enclosing_range_start semanticdb maven . . snapshots/Bird#`<init>`().
  open class Bird : Animal {
//           ^^^^ definition semanticdb maven . . snapshots/Bird#
//                display_name Bird
//                signature_documentation kotlin public open class Bird : Animal
//                relationship is_implementation semanticdb maven . . snapshots/Animal#
//           ^^^^ definition semanticdb maven . . snapshots/Bird#`<init>`().
//                display_name Bird
//                signature_documentation kotlin public constructor(): Bird
//                  ^^^^^^ reference semanticdb maven . . snapshots/Animal#
//    ⌄ enclosing_range_start semanticdb maven . . snapshots/Bird#favoriteNumber.
      override val favoriteNumber: Int
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/Bird#favoriteNumber.
//                                display_name favoriteNumber
//                                signature_documentation kotlin public open override val favoriteNumber: Int
//                                 ^^^ reference semanticdb maven . . kotlin/Int#
//        ⌄ enclosing_range_start semanticdb maven . . snapshots/Bird#getFavoriteNumber().
          get() = 42
//        ^^^ definition semanticdb maven . . snapshots/Bird#getFavoriteNumber().
//            display_name favoriteNumber
//            signature_documentation kotlin public get(): Int
//                 ⌃ enclosing_range_end semanticdb maven . . snapshots/Bird#favoriteNumber.
//                 ⌃ enclosing_range_end semanticdb maven . . snapshots/Bird#getFavoriteNumber().
  
//    ⌄ enclosing_range_start semanticdb maven . . snapshots/Bird#sound().
      override fun sound(): String {
//                 ^^^^^ definition semanticdb maven . . snapshots/Bird#sound().
//                       display_name sound
//                       signature_documentation kotlin public open override fun sound(): String
//                       relationship is_implementation semanticdb maven . . snapshots/Animal#sound().
//                          ^^^^^^ reference semanticdb maven . . kotlin/String#
          return "tweet"
      }
//    ⌃ enclosing_range_end semanticdb maven . . snapshots/Bird#sound().
  }
//⌃ enclosing_range_end semanticdb maven . . snapshots/Bird#
//⌃ enclosing_range_end semanticdb maven . . snapshots/Bird#`<init>`().
//⌄ enclosing_range_start semanticdb maven . . snapshots/Seagull#
//⌄ enclosing_range_start semanticdb maven . . snapshots/Seagull#`<init>`().
  class Seagull : Bird() {
//      ^^^^^^^ definition semanticdb maven . . snapshots/Seagull#
//              display_name Seagull
//              signature_documentation kotlin public final class Seagull : Bird
//              relationship is_implementation semanticdb maven . . snapshots/Bird#
//      ^^^^^^^ definition semanticdb maven . . snapshots/Seagull#`<init>`().
//              display_name Seagull
//              signature_documentation kotlin public constructor(): Seagull
//                ^^^^ reference semanticdb maven . . snapshots/Bird#
//    ⌄ enclosing_range_start semanticdb maven . . snapshots/Seagull#favoriteNumber.
      override val favoriteNumber: Int
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/Seagull#favoriteNumber.
//                                display_name favoriteNumber
//                                signature_documentation kotlin public open override val favoriteNumber: Int
//                                 ^^^ reference semanticdb maven . . kotlin/Int#
//        ⌄ enclosing_range_start semanticdb maven . . snapshots/Seagull#getFavoriteNumber().
          get() = 1337
//        ^^^ definition semanticdb maven . . snapshots/Seagull#getFavoriteNumber().
//            display_name favoriteNumber
//            signature_documentation kotlin public get(): Int
//                   ⌃ enclosing_range_end semanticdb maven . . snapshots/Seagull#favoriteNumber.
//                   ⌃ enclosing_range_end semanticdb maven . . snapshots/Seagull#getFavoriteNumber().
//    ⌄ enclosing_range_start semanticdb maven . . snapshots/Seagull#sound().
      override fun sound(): String {
//                 ^^^^^ definition semanticdb maven . . snapshots/Seagull#sound().
//                       display_name sound
//                       signature_documentation kotlin public open override fun sound(): String
//                       relationship is_implementation semanticdb maven . . snapshots/Bird#sound().
//                          ^^^^^^ reference semanticdb maven . . kotlin/String#
          return "squawk"
      }
//    ⌃ enclosing_range_end semanticdb maven . . snapshots/Seagull#sound().
  }
//⌃ enclosing_range_end semanticdb maven . . snapshots/Seagull#
//⌃ enclosing_range_end semanticdb maven . . snapshots/Seagull#`<init>`().
