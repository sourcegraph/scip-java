  package snapshots
//        ^^^^^^^^^ reference scip-java maven . . snapshots/
  
//⌄ enclosing_range_start scip-java maven . . snapshots/Class#
//            ⌄ enclosing_range_start scip-java maven . . snapshots/Class#`<init>`().
//                        ⌄ enclosing_range_start scip-java maven . . snapshots/Class#`<init>`().(banana)
//                        ⌄ enclosing_range_start scip-java maven . . snapshots/Class#banana.
//                        ⌄ enclosing_range_start scip-java maven . . snapshots/Class#getBanana().
//                        ⌄ enclosing_range_start scip-java maven . . snapshots/Class#setBanana().
//                        ⌄ enclosing_range_start scip-java maven . . snapshots/Class#setBanana().(value)
//                                                 ⌄ enclosing_range_start scip-java maven . . snapshots/Class#`<init>`().(apple)
  class Class constructor(private var banana: Int, apple: String) :
//      ^^^^^ definition scip-java maven . . snapshots/Class#
//            display_name Class
//            signature_documentation kotlin public final class Class : Throwable
//            kind Class
//            relationship is_implementation scip-java maven . . kotlin/Throwable#
//            ^^^^^^^^^^^ definition scip-java maven . . snapshots/Class#`<init>`().
//                        display_name Class
//                        signature_documentation kotlin public constructor(banana: Int, apple: String): Class
//                        kind Constructor
//                                    ^^^^^^ definition scip-java maven . . snapshots/Class#`<init>`().(banana)
//                                           display_name banana
//                                           signature_documentation kotlin banana: Int
//                                           kind Parameter
//                                    ^^^^^^ reference scip-java maven . . snapshots/Class#`<init>`().(banana)
//                                    ^^^^^^ definition scip-java maven . . snapshots/Class#banana.
//                                           display_name banana
//                                           signature_documentation kotlin private final var banana: Int
//                                           kind Property
//                                    ^^^^^^ definition scip-java maven . . snapshots/Class#getBanana().
//                                           display_name banana
//                                           signature_documentation kotlin private get(): Int
//                                           kind Method
//                                    ^^^^^^ definition scip-java maven . . snapshots/Class#setBanana().
//                                           display_name banana
//                                           signature_documentation kotlin private set(value: Int): Unit
//                                           kind Method
//                                    ^^^^^^ definition scip-java maven . . snapshots/Class#setBanana().(value)
//                                           display_name value
//                                           signature_documentation kotlin value: Int
//                                           kind Parameter
//                                            ^^^ reference scip-java maven . . kotlin/Int#
//                                                 ^^^^^ definition scip-java maven . . snapshots/Class#`<init>`().(apple)
//                                                       display_name apple
//                                                       signature_documentation kotlin apple: String
//                                                       kind Parameter
//                                                        ^^^^^^ reference scip-java maven . . kotlin/String#
//                                              ⌃ enclosing_range_end scip-java maven . . snapshots/Class#`<init>`().(banana)
//                                              ⌃ enclosing_range_end scip-java maven . . snapshots/Class#banana.
//                                              ⌃ enclosing_range_end scip-java maven . . snapshots/Class#getBanana().
//                                              ⌃ enclosing_range_end scip-java maven . . snapshots/Class#setBanana().
//                                              ⌃ enclosing_range_end scip-java maven . . snapshots/Class#setBanana().(value)
//                                                             ⌃ enclosing_range_end scip-java maven . . snapshots/Class#`<init>`().(apple)
//                                                              ⌃ enclosing_range_end scip-java maven . . snapshots/Class#`<init>`().
      Throwable(banana.toString() + apple) {
//    ^^^^^^^^^ reference scip-java maven . . kotlin/Throwable#
//              ^^^^^^ reference scip-java maven . . snapshots/Class#`<init>`().(banana)
//                     ^^^^^^^^ reference scip-java maven . . kotlin/Int#toString().
//                                ^ reference scip-java maven . . kotlin/String#plus().
//                                  ^^^^^ reference scip-java maven . . snapshots/Class#`<init>`().(apple)
    init {
      println("")
//    ^^^^^^^ reference scip-java maven . . kotlin/io/println().
    }
  
//  ⌄ enclosing_range_start scip-java maven . . snapshots/Class#asdf.
//  ⌄ enclosing_range_start scip-java maven . . snapshots/Class#getAsdf().
    val asdf =
//      ^^^^ definition scip-java maven . . snapshots/Class#asdf.
//           display_name asdf
//           signature_documentation kotlin public final val asdf: Any
//           kind Property
//      ^^^^ definition scip-java maven . . snapshots/Class#getAsdf().
//           display_name asdf
//           signature_documentation kotlin public get(): Any
//           kind Method
//      ⌄ enclosing_range_start scip-java maven . . snapshots/`<anonymous object at 177>`#
//      ⌄ enclosing_range_start scip-java maven . . snapshots/`<anonymous object at 177>`#`<init>`().
        object {
//      ^^^^^^ definition scip-java maven . . snapshots/`<anonymous object at 177>`#
//             display_name <anonymous>
//             signature_documentation kotlin object : Any
//             kind Object
//      ^^^^^^ definition scip-java maven . . snapshots/`<anonymous object at 177>`#`<init>`().
//             display_name <anonymous>
//             signature_documentation kotlin private constructor(): <anonymous>
//             kind Constructor
//        ⌄ enclosing_range_start scip-java maven . . snapshots/`<anonymous object at 177>`#doStuff().
          fun doStuff() = Unit
//            ^^^^^^^ definition scip-java maven . . snapshots/`<anonymous object at 177>`#doStuff().
//                    display_name doStuff
//                    signature_documentation kotlin public final fun doStuff(): Unit
//                    kind Method
//                           ⌃ enclosing_range_end scip-java maven . . snapshots/`<anonymous object at 177>`#doStuff().
        }
//      ⌃ enclosing_range_end scip-java maven . . snapshots/Class#asdf.
//      ⌃ enclosing_range_end scip-java maven . . snapshots/`<anonymous object at 177>`#
//      ⌃ enclosing_range_end scip-java maven . . snapshots/`<anonymous object at 177>`#`<init>`().
//      ⌃ enclosing_range_end scip-java maven . . snapshots/Class#getAsdf().
  
//  ⌄ enclosing_range_start scip-java maven . . snapshots/Class#`<init>`(+1).
    constructor() : this(1, "")
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . snapshots/Class#`<init>`(+1).
//                              display_name Class
//                              signature_documentation kotlin public constructor(): Class
//                              kind Constructor
//                            ⌃ enclosing_range_end scip-java maven . . snapshots/Class#`<init>`(+1).
  
//  ⌄ enclosing_range_start scip-java maven . . snapshots/Class#`<init>`(+2).
//              ⌄ enclosing_range_start scip-java maven . . snapshots/Class#`<init>`(+2).(banana)
    constructor(banana: Int) : this(banana, "")
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . snapshots/Class#`<init>`(+2).
//                                              display_name Class
//                                              signature_documentation kotlin public constructor(banana: Int): Class
//                                              kind Constructor
//              ^^^^^^ definition scip-java maven . . snapshots/Class#`<init>`(+2).(banana)
//                     display_name banana
//                     signature_documentation kotlin banana: Int
//                     kind Parameter
//                      ^^^ reference scip-java maven . . kotlin/Int#
//                                  ^^^^^^ reference scip-java maven . . snapshots/Class#`<init>`(+2).(banana)
//                        ⌃ enclosing_range_end scip-java maven . . snapshots/Class#`<init>`(+2).(banana)
//                                            ⌃ enclosing_range_end scip-java maven . . snapshots/Class#`<init>`(+2).
  
//  ⌄ enclosing_range_start scip-java maven . . snapshots/Class#run().
    fun run() {
//      ^^^ definition scip-java maven . . snapshots/Class#run().
//          display_name run
//          signature_documentation kotlin public final fun run(): Unit
//          kind Method
      println(Class::class)
//    ^^^^^^^ reference scip-java maven . . kotlin/io/println().
      println("I eat $banana for lunch")
//    ^^^^^^^ reference scip-java maven . . kotlin/io/println().
//                    ^^^^^^ reference scip-java maven . . snapshots/Class#banana.
//                    ^^^^^^ reference scip-java maven . . snapshots/Class#getBanana().
//                    ^^^^^^ reference scip-java maven . . snapshots/Class#setBanana().
      banana = 42
//    ^^^^^^ reference scip-java maven . . snapshots/Class#banana.
//    ^^^^^^ reference scip-java maven . . snapshots/Class#getBanana().
//    ^^^^^^ reference scip-java maven . . snapshots/Class#setBanana().
    }
//  ⌃ enclosing_range_end scip-java maven . . snapshots/Class#run().
  }
//⌃ enclosing_range_end scip-java maven . . snapshots/Class#
