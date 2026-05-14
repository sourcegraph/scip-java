  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#
  /**
   * Represents differences between a column definition and database metadata for the existing column.
   */
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().
  data class ColumnDiff(
//           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#
//                      display_name ColumnDiff
//                      documentation ```kotlin\npublic final data class ColumnDiff : Any\n```\n\n----\n\n\n Represents differences between a column definition and database metadata for the existing column.\n
//           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().
//                      display_name ColumnDiff
//                      documentation ```kotlin\npublic constructor(nullability: Boolean, type: Boolean, autoInc: Boolean, defaults: Boolean, caseSensitiveName: Boolean, sizeAndScale: Boolean): ColumnDiff\n```\n\n----\n\n Whether there is a mismatch between nullability of the existing column and the defined column.
//                     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy(). 13:1
//                       display_name copy
//                       documentation ```kotlin\npublic final fun copy(nullability: Boolean = ..., type: Boolean = ..., autoInc: Boolean = ..., defaults: Boolean = ..., caseSensitiveName: Boolean = ..., sizeAndScale: Boolean = ...): ColumnDiff\n\n```\n\n----\n\n Whether there is a mismatch between nullability of the existing column and the defined column.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(nullability)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#nullability.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getNullability().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component1().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(nullability)
      /** Whether there is a mismatch between nullability of the existing column and the defined column. */
      val nullability: Boolean,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(nullability)
//                    display_name nullability
//                    documentation ```kotlin\nnullability: Boolean\n```\n\n----\n\n Whether there is a mismatch between nullability of the existing column and the defined column.
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(nullability)
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component1().
//                    display_name component1
//                    documentation ```kotlin\npublic final operator fun component1(): Boolean\n\n```\n\n----\n\n Whether there is a mismatch between nullability of the existing column and the defined column.
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(nullability)
//                    display_name nullability
//                    documentation ```kotlin\nnullability: Boolean = ...\n```\n\n----\n\n Whether there is a mismatch between nullability of the existing column and the defined column.
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getNullability().
//                    display_name nullability
//                    documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether there is a mismatch between nullability of the existing column and the defined column.
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getNullability().
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#nullability.
//                    display_name nullability
//                    documentation ```kotlin\npublic final val nullability: Boolean\n```\n\n----\n\n Whether there is a mismatch between nullability of the existing column and the defined column.
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#nullability.
//                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(nullability)
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#nullability.
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getNullability().
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component1().
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(nullability)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(type)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#type.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component2().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(type)
      /** Whether there is a mismatch between type of the existing column and the defined column. */
      val type: Boolean,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(type)
//             display_name type
//             documentation ```kotlin\ntype: Boolean\n```\n\n----\n\n Whether there is a mismatch between type of the existing column and the defined column.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(type)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component2().
//             display_name component2
//             documentation ```kotlin\npublic final operator fun component2(): Boolean\n\n```\n\n----\n\n Whether there is a mismatch between type of the existing column and the defined column.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(type)
//             display_name type
//             documentation ```kotlin\ntype: Boolean = ...\n```\n\n----\n\n Whether there is a mismatch between type of the existing column and the defined column.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getType().
//             display_name type
//             documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether there is a mismatch between type of the existing column and the defined column.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getType().
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#type.
//             display_name type
//             documentation ```kotlin\npublic final val type: Boolean\n```\n\n----\n\n Whether there is a mismatch between type of the existing column and the defined column.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#type.
//              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(type)
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#type.
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getType().
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component2().
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(type)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(autoInc)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#autoInc.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getAutoInc().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component3().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(autoInc)
      /** Whether there is a mismatch between auto-increment status of the existing column and the defined column. */
      val autoInc: Boolean,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(autoInc)
//                display_name autoInc
//                documentation ```kotlin\nautoInc: Boolean\n```\n\n----\n\n Whether there is a mismatch between auto-increment status of the existing column and the defined column.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(autoInc)
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#autoInc.
//                display_name autoInc
//                documentation ```kotlin\npublic final val autoInc: Boolean\n```\n\n----\n\n Whether there is a mismatch between auto-increment status of the existing column and the defined column.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#autoInc.
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component3().
//                display_name component3
//                documentation ```kotlin\npublic final operator fun component3(): Boolean\n\n```\n\n----\n\n Whether there is a mismatch between auto-increment status of the existing column and the defined column.
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(autoInc)
//                display_name autoInc
//                documentation ```kotlin\nautoInc: Boolean = ...\n```\n\n----\n\n Whether there is a mismatch between auto-increment status of the existing column and the defined column.
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getAutoInc().
//                display_name autoInc
//                documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether there is a mismatch between auto-increment status of the existing column and the defined column.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getAutoInc().
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(autoInc)
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#autoInc.
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getAutoInc().
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component3().
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(autoInc)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(defaults)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#defaults.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getDefaults().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component4().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(defaults)
      /** Whether the default value of the existing column matches that of the defined column. */
      val defaults: Boolean,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(defaults)
//                 display_name defaults
//                 documentation ```kotlin\ndefaults: Boolean\n```\n\n----\n\n Whether the default value of the existing column matches that of the defined column.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(defaults)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component4().
//                 display_name component4
//                 documentation ```kotlin\npublic final operator fun component4(): Boolean\n\n```\n\n----\n\n Whether the default value of the existing column matches that of the defined column.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(defaults)
//                 display_name defaults
//                 documentation ```kotlin\ndefaults: Boolean = ...\n```\n\n----\n\n Whether the default value of the existing column matches that of the defined column.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#defaults.
//                 display_name defaults
//                 documentation ```kotlin\npublic final val defaults: Boolean\n```\n\n----\n\n Whether the default value of the existing column matches that of the defined column.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#defaults.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getDefaults().
//                 display_name defaults
//                 documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether the default value of the existing column matches that of the defined column.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getDefaults().
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(defaults)
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#defaults.
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getDefaults().
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component4().
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(defaults)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(caseSensitiveName)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#caseSensitiveName.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getCaseSensitiveName().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component5().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(caseSensitiveName)
      /** Whether the existing column identifier matches that of the defined column and has the correct casing. */
      val caseSensitiveName: Boolean,
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(caseSensitiveName)
//                          display_name caseSensitiveName
//                          documentation ```kotlin\ncaseSensitiveName: Boolean\n```\n\n----\n\n Whether the existing column identifier matches that of the defined column and has the correct casing.
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(caseSensitiveName)
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#caseSensitiveName.
//                          display_name caseSensitiveName
//                          documentation ```kotlin\npublic final val caseSensitiveName: Boolean\n```\n\n----\n\n Whether the existing column identifier matches that of the defined column and has the correct casing.
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#caseSensitiveName.
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component5().
//                          display_name component5
//                          documentation ```kotlin\npublic final operator fun component5(): Boolean\n\n```\n\n----\n\n Whether the existing column identifier matches that of the defined column and has the correct casing.
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(caseSensitiveName)
//                          display_name caseSensitiveName
//                          documentation ```kotlin\ncaseSensitiveName: Boolean = ...\n```\n\n----\n\n Whether the existing column identifier matches that of the defined column and has the correct casing.
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getCaseSensitiveName().
//                          display_name caseSensitiveName
//                          documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether the existing column identifier matches that of the defined column and has the correct casing.
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getCaseSensitiveName().
//                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(caseSensitiveName)
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#caseSensitiveName.
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getCaseSensitiveName().
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component5().
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(caseSensitiveName)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(sizeAndScale)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#sizeAndScale.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getSizeAndScale().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component6().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(sizeAndScale)
      /** Whether the size and scale of the existing column, if applicable, match those of the defined column. */
      val sizeAndScale: Boolean,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(sizeAndScale)
//                     display_name sizeAndScale
//                     documentation ```kotlin\nsizeAndScale: Boolean\n```\n\n----\n\n Whether the size and scale of the existing column, if applicable, match those of the defined column.
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(sizeAndScale)
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component6().
//                     display_name component6
//                     documentation ```kotlin\npublic final operator fun component6(): Boolean\n\n```\n\n----\n\n Whether the size and scale of the existing column, if applicable, match those of the defined column.
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(sizeAndScale)
//                     display_name sizeAndScale
//                     documentation ```kotlin\nsizeAndScale: Boolean = ...\n```\n\n----\n\n Whether the size and scale of the existing column, if applicable, match those of the defined column.
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getSizeAndScale().
//                     display_name sizeAndScale
//                     documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether the size and scale of the existing column, if applicable, match those of the defined column.
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getSizeAndScale().
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#sizeAndScale.
//                     display_name sizeAndScale
//                     documentation ```kotlin\npublic final val sizeAndScale: Boolean\n```\n\n----\n\n Whether the size and scale of the existing column, if applicable, match those of the defined column.
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#sizeAndScale.
//                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().(sizeAndScale)
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#sizeAndScale.
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getSizeAndScale().
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#component6().
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().(sizeAndScale)
  ) {
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#hasDifferences().
      /** Returns `true` if there is a difference between the column definition and the existing column in the database. */
      fun hasDifferences() = this != NoneChanged
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#hasDifferences().
//                       display_name hasDifferences
//                       documentation ```kotlin\npublic final fun hasDifferences(): Boolean\n```\n\n----\n\n Returns `true` if there is a difference between the column definition and the existing column in the database.
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#NoneChanged.
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#getNoneChanged().
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#hasDifferences().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#`<init>`().
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion# 20:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```\n\n----\n\n A [ColumnDiff] with no differences.
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#`<init>`(). 20:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): ColumnDiff.Companion\n```\n\n----\n\n A [ColumnDiff] with no differences.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#NoneChanged.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#getNoneChanged().
          /** A [ColumnDiff] with no differences. */
          val NoneChanged = ColumnDiff(
//            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#NoneChanged.
//                        display_name NoneChanged
//                        documentation ```kotlin\npublic final val NoneChanged: ColumnDiff\n```\n\n----\n\n A [ColumnDiff] with no differences.
//            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#getNoneChanged().
//                        display_name NoneChanged
//                        documentation ```kotlin\npublic get(): ColumnDiff\n```\n\n----\n\n A [ColumnDiff] with no differences.
//                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().
              nullability = false,
              type = false,
              autoInc = false,
              defaults = false,
              caseSensitiveName = false,
              sizeAndScale = false,
          )
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#NoneChanged.
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#getNoneChanged().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#AllChanged.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#getAllChanged().
          /** A [ColumnDiff] with differences for every matched property. */
          val AllChanged = ColumnDiff(
//            ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#AllChanged.
//                       display_name AllChanged
//                       documentation ```kotlin\npublic final val AllChanged: ColumnDiff\n```\n\n----\n\n A [ColumnDiff] with differences for every matched property.
//            ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#getAllChanged().
//                       display_name AllChanged
//                       documentation ```kotlin\npublic get(): ColumnDiff\n```\n\n----\n\n A [ColumnDiff] with differences for every matched property.
//                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().
              nullability = true,
              type = true,
              autoInc = true,
              defaults = true,
              caseSensitiveName = true,
              sizeAndScale = true,
          )
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#AllChanged.
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#getAllChanged().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#
