  package snapshots
//        ^^^^^^^^^ reference semanticdb maven . . snapshots/
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/Class#
//            ⌄ enclosing_range_start semanticdb maven . . snapshots/Class#`<init>`().
//                        ⌄ enclosing_range_start semanticdb maven . . snapshots/Class#`<init>`().(banana)
//                        ⌄ enclosing_range_start semanticdb maven . . snapshots/Class#banana.
//                        ⌄ enclosing_range_start semanticdb maven . . snapshots/Class#getBanana().
//                        ⌄ enclosing_range_start semanticdb maven . . snapshots/Class#setBanana().
//                        ⌄ enclosing_range_start semanticdb maven . . snapshots/Class#setBanana().(value)
//                                                 ⌄ enclosing_range_start semanticdb maven . . snapshots/Class#`<init>`().(apple)
  class Class constructor(private var banana: Int, apple: String) :
//      ^^^^^ definition semanticdb maven . . snapshots/Class#
//            display_name Class
//            documentation ```kotlin\npublic final class Class : Throwable\n```
//            relationship is_reference is_implementation semanticdb maven . . kotlin/Throwable#
//            ^^^^^^^^^^^ definition semanticdb maven . . snapshots/Class#`<init>`().
//                        display_name Class
//                        documentation ```kotlin\npublic constructor(banana: Int, apple: String): Class\n```
//                                    ^^^^^^ definition semanticdb maven . . snapshots/Class#`<init>`().(banana)
//                                           display_name banana
//                                           documentation ```kotlin\nbanana: Int\n```
//                                    ^^^^^^ reference semanticdb maven . . snapshots/Class#`<init>`().(banana)
//                                    ^^^^^^ definition semanticdb maven . . snapshots/Class#banana.
//                                           display_name banana
//                                           documentation ```kotlin\nprivate final var banana: Int\n```
//                                    ^^^^^^ definition semanticdb maven . . snapshots/Class#getBanana().
//                                           display_name banana
//                                           documentation ```kotlin\nprivate get(): Int\n```
//                                    ^^^^^^ definition semanticdb maven . . snapshots/Class#setBanana().
//                                           display_name banana
//                                           documentation ```kotlin\nprivate set(value: Int): Unit\n```
//                                    ^^^^^^ definition semanticdb maven . . snapshots/Class#setBanana().(value)
//                                           display_name value
//                                           documentation ```kotlin\nvalue: Int\n```
//                                            ^^^ reference semanticdb maven . . kotlin/Int#
//                                                 ^^^^^ definition semanticdb maven . . snapshots/Class#`<init>`().(apple)
//                                                       display_name apple
//                                                       documentation ```kotlin\napple: String\n```
//                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                              ⌃ enclosing_range_end semanticdb maven . . snapshots/Class#`<init>`().(banana)
//                                              ⌃ enclosing_range_end semanticdb maven . . snapshots/Class#banana.
//                                              ⌃ enclosing_range_end semanticdb maven . . snapshots/Class#getBanana().
//                                              ⌃ enclosing_range_end semanticdb maven . . snapshots/Class#setBanana().
//                                              ⌃ enclosing_range_end semanticdb maven . . snapshots/Class#setBanana().(value)
//                                                             ⌃ enclosing_range_end semanticdb maven . . snapshots/Class#`<init>`().(apple)
//                                                              ⌃ enclosing_range_end semanticdb maven . . snapshots/Class#`<init>`().
      Throwable(banana.toString() + apple) {
//    ^^^^^^^^^ reference semanticdb maven . . kotlin/Throwable#
//              ^^^^^^ reference semanticdb maven . . snapshots/Class#`<init>`().(banana)
//                     ^^^^^^^^ reference semanticdb maven . . kotlin/Int#toString().
//                                ^ reference semanticdb maven . . kotlin/String#plus().
//                                  ^^^^^ reference semanticdb maven . . snapshots/Class#`<init>`().(apple)
    init {
      println("")
//    ^^^^^^^ reference semanticdb maven . . kotlin/io/println().
    }
  
//  ⌄ enclosing_range_start semanticdb maven . . snapshots/Class#asdf.
//  ⌄ enclosing_range_start semanticdb maven . . snapshots/Class#getAsdf().
    val asdf =
//      ^^^^ definition semanticdb maven . . snapshots/Class#asdf.
//           display_name asdf
//           documentation ```kotlin\npublic final val asdf: Any\n```
//      ^^^^ definition semanticdb maven . . snapshots/Class#getAsdf().
//           display_name asdf
//           documentation ```kotlin\npublic get(): Any\n```
//      ⌄ enclosing_range_start semanticdb maven . . snapshots/`<anonymous object at 177>`#
//      ⌄ enclosing_range_start semanticdb maven . . snapshots/`<anonymous object at 177>`#`<init>`().
        object {
//      ^^^^^^ definition semanticdb maven . . snapshots/`<anonymous object at 177>`#
//             display_name <anonymous>
//             documentation ```kotlin\nobject : Any\n```
//      ^^^^^^ definition semanticdb maven . . snapshots/`<anonymous object at 177>`#`<init>`().
//             display_name <anonymous>
//             documentation ```kotlin\nprivate constructor(): <anonymous>\n```
//        ⌄ enclosing_range_start semanticdb maven . . snapshots/`<anonymous object at 177>`#doStuff().
          fun doStuff() = Unit
//            ^^^^^^^ definition semanticdb maven . . snapshots/`<anonymous object at 177>`#doStuff().
//                    display_name doStuff
//                    documentation ```kotlin\npublic final fun doStuff(): Unit\n```
//                           ⌃ enclosing_range_end semanticdb maven . . snapshots/`<anonymous object at 177>`#doStuff().
        }
//      ⌃ enclosing_range_end semanticdb maven . . snapshots/Class#asdf.
//      ⌃ enclosing_range_end semanticdb maven . . snapshots/Class#getAsdf().
//      ⌃ enclosing_range_end semanticdb maven . . snapshots/`<anonymous object at 177>`#
//      ⌃ enclosing_range_end semanticdb maven . . snapshots/`<anonymous object at 177>`#`<init>`().
  
//  ⌄ enclosing_range_start semanticdb maven . . snapshots/Class#`<init>`(+1).
    constructor() : this(1, "")
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/Class#`<init>`(+1).
//                              display_name Class
//                              documentation ```kotlin\npublic constructor(): Class\n```
//                            ⌃ enclosing_range_end semanticdb maven . . snapshots/Class#`<init>`(+1).
  
//  ⌄ enclosing_range_start semanticdb maven . . snapshots/Class#`<init>`(+2).
//              ⌄ enclosing_range_start semanticdb maven . . snapshots/Class#`<init>`(+2).(banana)
    constructor(banana: Int) : this(banana, "")
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/Class#`<init>`(+2).
//                                              display_name Class
//                                              documentation ```kotlin\npublic constructor(banana: Int): Class\n```
//              ^^^^^^ definition semanticdb maven . . snapshots/Class#`<init>`(+2).(banana)
//                     display_name banana
//                     documentation ```kotlin\nbanana: Int\n```
//                      ^^^ reference semanticdb maven . . kotlin/Int#
//                                  ^^^^^^ reference semanticdb maven . . snapshots/Class#`<init>`(+2).(banana)
//                        ⌃ enclosing_range_end semanticdb maven . . snapshots/Class#`<init>`(+2).(banana)
//                                            ⌃ enclosing_range_end semanticdb maven . . snapshots/Class#`<init>`(+2).
  
//  ⌄ enclosing_range_start semanticdb maven . . snapshots/Class#run().
    fun run() {
//      ^^^ definition semanticdb maven . . snapshots/Class#run().
//          display_name run
//          documentation ```kotlin\npublic final fun run(): Unit\n```
      println(Class::class)
//    ^^^^^^^ reference semanticdb maven . . kotlin/io/println().
      println("I eat $banana for lunch")
//    ^^^^^^^ reference semanticdb maven . . kotlin/io/println().
//                    ^^^^^^ reference semanticdb maven . . snapshots/Class#banana.
//                    ^^^^^^ reference semanticdb maven . . snapshots/Class#getBanana().
//                    ^^^^^^ reference semanticdb maven . . snapshots/Class#setBanana().
      banana = 42
//    ^^^^^^ reference semanticdb maven . . snapshots/Class#banana.
//    ^^^^^^ reference semanticdb maven . . snapshots/Class#getBanana().
//    ^^^^^^ reference semanticdb maven . . snapshots/Class#setBanana().
    }
//  ⌃ enclosing_range_end semanticdb maven . . snapshots/Class#run().
  }
//⌃ enclosing_range_end semanticdb maven . . snapshots/Class#
