  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  /**
   * Represents differences between a column definition and database metadata for the existing column.
   */
  data class ColumnDiff(
//           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#
//                      display_name ColumnDiff
//                      documentation ```kotlin\npublic final data class ColumnDiff : Any\n```\n\n----\n\n\n Represents differences between a column definition and database metadata for the existing column.\n
//           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().
//                      display_name ColumnDiff
//                      documentation ```kotlin\npublic constructor(nullability: Boolean, type: Boolean, autoInc: Boolean, defaults: Boolean, caseSensitiveName: Boolean, sizeAndScale: Boolean): ColumnDiff\n```\n\n----\n\n Whether there is a mismatch between nullability of the existing column and the defined column.
//           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#copy().
//                      display_name copy
//                      documentation ```kotlin\npublic final fun copy(nullability: Boolean = ..., type: Boolean = ..., autoInc: Boolean = ..., defaults: Boolean = ..., caseSensitiveName: Boolean = ..., sizeAndScale: Boolean = ...): ColumnDiff\n\n```\n\n----\n\n\n Represents differences between a column definition and database metadata for the existing column.\n
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
  ) {
      /** Returns `true` if there is a difference between the column definition and the existing column in the database. */
      fun hasDifferences() = this != NoneChanged
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#hasDifferences().
//                       display_name hasDifferences
//                       documentation ```kotlin\npublic final fun hasDifferences(): Boolean\n```\n\n----\n\n Returns `true` if there is a difference between the column definition and the existing column in the database.
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#NoneChanged.
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#getNoneChanged().
  
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion# 20:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```\n\n----\n\n A [ColumnDiff] with no differences.
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#`<init>`(). 20:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): ColumnDiff.Companion\n```\n\n----\n\n A [ColumnDiff] with no differences.
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
      }
  }
