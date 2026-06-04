  package snapshots
//        ^^^^^^^^^ reference scip-java maven . . snapshots/
  
//⌄ enclosing_range_start scip-java maven . . snapshots/CompanionOwner#
//⌄ enclosing_range_start scip-java maven . . snapshots/CompanionOwner#`<init>`().
  class CompanionOwner {
//      ^^^^^^^^^^^^^^ definition scip-java maven . . snapshots/CompanionOwner#
//                     display_name CompanionOwner
//                     signature_documentation kotlin public final class CompanionOwner : Any
//      ^^^^^^^^^^^^^^ definition scip-java maven . . snapshots/CompanionOwner#`<init>`().
//                     display_name CompanionOwner
//                     signature_documentation kotlin public constructor(): CompanionOwner
//  ⌄ enclosing_range_start scip-java maven . . snapshots/CompanionOwner#Companion#
//  ⌄ enclosing_range_start scip-java maven . . snapshots/CompanionOwner#Companion#`<init>`().
    companion object {
//  ^^^^^^^^^^^^^^^^^^ definition scip-java maven . . snapshots/CompanionOwner#Companion# 2:3
//                     display_name Companion
//                     signature_documentation kotlin public final companion object Companion : Any
//  ^^^^^^^^^^^^^^^^^^ definition scip-java maven . . snapshots/CompanionOwner#Companion#`<init>`(). 2:3
//                     display_name Companion
//                     signature_documentation kotlin private constructor(): CompanionOwner.Companion
//    ⌄ enclosing_range_start scip-java maven . . snapshots/CompanionOwner#Companion#create().
      fun create(): CompanionOwner = CompanionOwner()
//        ^^^^^^ definition scip-java maven . . snapshots/CompanionOwner#Companion#create().
//               display_name create
//               signature_documentation kotlin public final fun create(): CompanionOwner
//                  ^^^^^^^^^^^^^^ reference scip-java maven . . snapshots/CompanionOwner#
//                                   ^^^^^^^^^^^^^^ reference scip-java maven . . snapshots/CompanionOwner#`<init>`().
//                                                  ⌃ enclosing_range_end scip-java maven . . snapshots/CompanionOwner#Companion#create().
    }
//  ⌃ enclosing_range_end scip-java maven . . snapshots/CompanionOwner#Companion#
//  ⌃ enclosing_range_end scip-java maven . . snapshots/CompanionOwner#Companion#`<init>`().
//  ⌄ enclosing_range_start scip-java maven . . snapshots/CompanionOwner#create().
    fun create(): Int = CompanionOwner.create().hashCode()
//      ^^^^^^ definition scip-java maven . . snapshots/CompanionOwner#create().
//             display_name create
//             signature_documentation kotlin public final fun create(): Int
//                ^^^ reference scip-java maven . . kotlin/Int#
//                                     ^^^^^^ reference scip-java maven . . snapshots/CompanionOwner#Companion#create().
//                                              ^^^^^^^^ reference scip-java maven . . kotlin/Any#hashCode().
//                                                       ⌃ enclosing_range_end scip-java maven . . snapshots/CompanionOwner#create().
  }
//⌃ enclosing_range_end scip-java maven . . snapshots/CompanionOwner#
//⌃ enclosing_range_end scip-java maven . . snapshots/CompanionOwner#`<init>`().
