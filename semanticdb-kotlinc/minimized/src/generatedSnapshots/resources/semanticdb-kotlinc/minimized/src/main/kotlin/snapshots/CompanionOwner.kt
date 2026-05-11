  package snapshots
//        ^^^^^^^^^ reference semanticdb maven . . snapshots/
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/CompanionOwner#
//⌄ enclosing_range_start semanticdb maven . . snapshots/CompanionOwner#`<init>`().
  class CompanionOwner {
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/CompanionOwner#
//                     display_name CompanionOwner
//                     documentation ```kotlin\npublic final class CompanionOwner : Any\n```
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/CompanionOwner#`<init>`().
//                     display_name CompanionOwner
//                     documentation ```kotlin\npublic constructor(): CompanionOwner\n```
//  ⌄ enclosing_range_start semanticdb maven . . snapshots/CompanionOwner#Companion#
//  ⌄ enclosing_range_start semanticdb maven . . snapshots/CompanionOwner#Companion#`<init>`().
    companion object {
//  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/CompanionOwner#Companion# 2:3
//                     display_name Companion
//                     documentation ```kotlin\npublic final companion object Companion : Any\n```
//  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/CompanionOwner#Companion#`<init>`(). 2:3
//                     display_name Companion
//                     documentation ```kotlin\nprivate constructor(): CompanionOwner.Companion\n```
//    ⌄ enclosing_range_start semanticdb maven . . snapshots/CompanionOwner#Companion#create().
      fun create(): CompanionOwner = CompanionOwner()
//        ^^^^^^ definition semanticdb maven . . snapshots/CompanionOwner#Companion#create().
//               display_name create
//               documentation ```kotlin\npublic final fun create(): CompanionOwner\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . snapshots/CompanionOwner#
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . snapshots/CompanionOwner#`<init>`().
//                                                  ⌃ enclosing_range_end semanticdb maven . . snapshots/CompanionOwner#Companion#create().
    }
//  ⌃ enclosing_range_end semanticdb maven . . snapshots/CompanionOwner#Companion#
//  ⌃ enclosing_range_end semanticdb maven . . snapshots/CompanionOwner#Companion#`<init>`().
//  ⌄ enclosing_range_start semanticdb maven . . snapshots/CompanionOwner#create().
    fun create(): Int = CompanionOwner.create().hashCode()
//      ^^^^^^ definition semanticdb maven . . snapshots/CompanionOwner#create().
//             display_name create
//             documentation ```kotlin\npublic final fun create(): Int\n```
//                ^^^ reference semanticdb maven . . kotlin/Int#
//                                     ^^^^^^ reference semanticdb maven . . snapshots/CompanionOwner#Companion#create().
//                                              ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().
//                                                       ⌃ enclosing_range_end semanticdb maven . . snapshots/CompanionOwner#create().
  }
//⌃ enclosing_range_end semanticdb maven . . snapshots/CompanionOwner#
//⌃ enclosing_range_end semanticdb maven . . snapshots/CompanionOwner#`<init>`().
