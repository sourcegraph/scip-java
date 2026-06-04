  package snapshots
//        ^^^^^^^^^ reference semanticdb maven . . snapshots/
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/x.
//⌄ enclosing_range_start semanticdb maven . . snapshots/getX().
//                                               ⌄ enclosing_range_start local 0
//                                                  ⌄ enclosing_range_start local 1
  val x = arrayListOf<String>().forEachIndexed { i, s -> println("$i $s") }
//    ^ definition semanticdb maven . . snapshots/getX().
//      display_name x
//      signature_documentation kotlin public get(): Unit
//    ^ definition semanticdb maven . . snapshots/x.
//      display_name x
//      signature_documentation kotlin public final val x: Unit
//        ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/arrayListOf().
//                              ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/forEachIndexed(+9).
//                                               ^ definition local 0
//                                                 display_name i
//                                                 signature_documentation kotlin i: Int
//                                                  ^ definition local 1
//                                                    display_name s
//                                                    signature_documentation kotlin s: String
//                                                       ^^^^^^^ reference semanticdb maven . . kotlin/io/println().
//                                                                 ^ reference local 0
//                                                                    ^ reference local 1
//                                               ⌃ enclosing_range_end local 0
//                                                  ⌃ enclosing_range_end local 1
//                                                                        ⌃ enclosing_range_end semanticdb maven . . snapshots/x.
//                                                                        ⌃ enclosing_range_end semanticdb maven . . snapshots/getX().
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/y.
//⌄ enclosing_range_start semanticdb maven . . snapshots/getY().
  val y = "fdsa".run { this.toByteArray() }
//    ^ definition semanticdb maven . . snapshots/getY().
//      display_name y
//      signature_documentation kotlin public get(): ByteArray
//    ^ definition semanticdb maven . . snapshots/y.
//      display_name y
//      signature_documentation kotlin public final val y: ByteArray
//               ^^^ reference semanticdb maven . . kotlin/run(+1).
//                          ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/toByteArray().
//                                        ⌃ enclosing_range_end semanticdb maven . . snapshots/y.
//                                        ⌃ enclosing_range_end semanticdb maven . . snapshots/getY().
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/z.
//⌄ enclosing_range_start semanticdb maven . . snapshots/getZ().
//              ⌄ enclosing_range_start local 2
  val z = y.let { it.size }
//    ^ definition semanticdb maven . . snapshots/getZ().
//      display_name z
//      signature_documentation kotlin public get(): Int
//    ^ definition semanticdb maven . . snapshots/z.
//      display_name z
//      signature_documentation kotlin public final val z: Int
//        ^ reference semanticdb maven . . snapshots/getY().
//        ^ reference semanticdb maven . . snapshots/y.
//          ^^^ reference semanticdb maven . . kotlin/let().
//              ^^^^^^^^^^^ definition local 2
//                          display_name it
//                          signature_documentation kotlin it: ByteArray
//                ^^ reference local 2
//                   ^^^^ reference semanticdb maven . . kotlin/ByteArray#getSize().
//                   ^^^^ reference semanticdb maven . . kotlin/ByteArray#size.
//                        ⌃ enclosing_range_end semanticdb maven . . snapshots/z.
//                        ⌃ enclosing_range_end semanticdb maven . . snapshots/getZ().
//                        ⌃ enclosing_range_end local 2
