  package org.jetbrains.exposed.v1.core.vendors
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
  
  /**
   * Represents metadata information about a specific column.
   */
  data class ColumnMetadata(
//           ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#
//                          display_name ColumnMetadata
//                          documentation ```kotlin\npublic final data class ColumnMetadata : Any\n```\n\n----\n\n\n Represents metadata information about a specific column.\n
//           ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().
//                          display_name ColumnMetadata
//                          documentation ```kotlin\npublic constructor(name: String, jdbcType: Int, sqlType: String, nullable: Boolean, size: Int?, scale: Int?, autoIncrement: Boolean, defaultDbValue: String?): ColumnMetadata\n```\n\n----\n\n Name of the column.
//           ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#copy().
//                          display_name copy
//                          documentation ```kotlin\npublic final fun copy(name: String = ..., jdbcType: Int = ..., sqlType: String = ..., nullable: Boolean = ..., size: Int? = ..., scale: Int? = ..., autoIncrement: Boolean = ..., defaultDbValue: String? = ...): ColumnMetadata\n\n```\n\n----\n\n\n Represents metadata information about a specific column.\n
      /** Name of the column. */
      val name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```\n\n----\n\n Name of the column.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(name)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#component1().
//             display_name component1
//             documentation ```kotlin\npublic final operator fun component1(): String\n\n```\n\n----\n\n Name of the column.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#copy().(name)
//             display_name name
//             documentation ```kotlin\nname: String = ...\n```\n\n----\n\n Name of the column.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getName().
//             display_name name
//             documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Name of the column.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getName().
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#name.
//             display_name name
//             documentation ```kotlin\npublic final val name: String\n```\n\n----\n\n Name of the column.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#name.
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
      /**
       * JDBC type of the column.
       *
       * @see java.sql.Types
       */
      val jdbcType: Int,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(jdbcType)
//                 display_name jdbcType
//                 documentation ```kotlin\njdbcType: Int\n```\n\n----\n\n\n JDBC type of the column.\n\n @see java.sql.Types\n
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(jdbcType)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#component2().
//                 display_name component2
//                 documentation ```kotlin\npublic final operator fun component2(): Int\n\n```\n\n----\n\n\n JDBC type of the column.\n\n @see java.sql.Types\n
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#copy().(jdbcType)
//                 display_name jdbcType
//                 documentation ```kotlin\njdbcType: Int = ...\n```\n\n----\n\n\n JDBC type of the column.\n\n @see java.sql.Types\n
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getJdbcType().
//                 display_name jdbcType
//                 documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n\n JDBC type of the column.\n\n @see java.sql.Types\n
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getJdbcType().
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#jdbcType.
//                 display_name jdbcType
//                 documentation ```kotlin\npublic final val jdbcType: Int\n```\n\n----\n\n\n JDBC type of the column.\n\n @see java.sql.Types\n
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#jdbcType.
//                  ^^^ reference semanticdb maven . . kotlin/Int#
      /** SQL type of the column. */
      val sqlType: String,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(sqlType)
//                display_name sqlType
//                documentation ```kotlin\nsqlType: String\n```\n\n----\n\n SQL type of the column.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(sqlType)
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#component3().
//                display_name component3
//                documentation ```kotlin\npublic final operator fun component3(): String\n\n```\n\n----\n\n SQL type of the column.
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#copy().(sqlType)
//                display_name sqlType
//                documentation ```kotlin\nsqlType: String = ...\n```\n\n----\n\n SQL type of the column.
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getSqlType().
//                display_name sqlType
//                documentation ```kotlin\npublic get(): String\n```\n\n----\n\n SQL type of the column.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getSqlType().
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#sqlType.
//                display_name sqlType
//                documentation ```kotlin\npublic final val sqlType: String\n```\n\n----\n\n SQL type of the column.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#sqlType.
//                 ^^^^^^ reference semanticdb maven . . kotlin/String#
      /** Whether the column is nullable or not. */
      val nullable: Boolean,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(nullable)
//                 display_name nullable
//                 documentation ```kotlin\nnullable: Boolean\n```\n\n----\n\n Whether the column is nullable or not.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(nullable)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#component4().
//                 display_name component4
//                 documentation ```kotlin\npublic final operator fun component4(): Boolean\n\n```\n\n----\n\n Whether the column is nullable or not.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#copy().(nullable)
//                 display_name nullable
//                 documentation ```kotlin\nnullable: Boolean = ...\n```\n\n----\n\n Whether the column is nullable or not.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getNullable().
//                 display_name nullable
//                 documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether the column is nullable or not.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getNullable().
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#nullable.
//                 display_name nullable
//                 documentation ```kotlin\npublic final val nullable: Boolean\n```\n\n----\n\n Whether the column is nullable or not.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#nullable.
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      /** Optional size of the column. */
      val size: Int?,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(size)
//             display_name size
//             documentation ```kotlin\nsize: Int?\n```\n\n----\n\n Optional size of the column.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(size)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#component5().
//             display_name component5
//             documentation ```kotlin\npublic final operator fun component5(): Int?\n\n```\n\n----\n\n Optional size of the column.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#copy().(size)
//             display_name size
//             documentation ```kotlin\nsize: Int? = ...\n```\n\n----\n\n Optional size of the column.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getSize().
//             display_name size
//             documentation ```kotlin\npublic get(): Int?\n```\n\n----\n\n Optional size of the column.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getSize().
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#size.
//             display_name size
//             documentation ```kotlin\npublic final val size: Int?\n```\n\n----\n\n Optional size of the column.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#size.
//              ^^^^ reference semanticdb maven . . kotlin/Int#
      /** Optional amount of fractional digits allowed in the column. */
      val scale: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(scale)
//              display_name scale
//              documentation ```kotlin\nscale: Int?\n```\n\n----\n\n Optional amount of fractional digits allowed in the column.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(scale)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#component6().
//              display_name component6
//              documentation ```kotlin\npublic final operator fun component6(): Int?\n\n```\n\n----\n\n Optional amount of fractional digits allowed in the column.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#copy().(scale)
//              display_name scale
//              documentation ```kotlin\nscale: Int? = ...\n```\n\n----\n\n Optional amount of fractional digits allowed in the column.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getScale().
//              display_name scale
//              documentation ```kotlin\npublic get(): Int?\n```\n\n----\n\n Optional amount of fractional digits allowed in the column.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getScale().
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#scale.
//              display_name scale
//              documentation ```kotlin\npublic final val scale: Int?\n```\n\n----\n\n Optional amount of fractional digits allowed in the column.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#scale.
//               ^^^^ reference semanticdb maven . . kotlin/Int#
      /** Whether the column is auto-incremented. */
      val autoIncrement: Boolean,
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(autoIncrement)
//                      display_name autoIncrement
//                      documentation ```kotlin\nautoIncrement: Boolean\n```\n\n----\n\n Whether the column is auto-incremented.
//        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(autoIncrement)
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#autoIncrement.
//                      display_name autoIncrement
//                      documentation ```kotlin\npublic final val autoIncrement: Boolean\n```\n\n----\n\n Whether the column is auto-incremented.
//        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#autoIncrement.
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#component7().
//                      display_name component7
//                      documentation ```kotlin\npublic final operator fun component7(): Boolean\n\n```\n\n----\n\n Whether the column is auto-incremented.
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#copy().(autoIncrement)
//                      display_name autoIncrement
//                      documentation ```kotlin\nautoIncrement: Boolean = ...\n```\n\n----\n\n Whether the column is auto-incremented.
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getAutoIncrement().
//                      display_name autoIncrement
//                      documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether the column is auto-incremented.
//        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getAutoIncrement().
//                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      /** Default value of the column. */
      val defaultDbValue: String?,
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(defaultDbValue)
//                       display_name defaultDbValue
//                       documentation ```kotlin\ndefaultDbValue: String?\n```\n\n----\n\n Default value of the column.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().(defaultDbValue)
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#component8().
//                       display_name component8
//                       documentation ```kotlin\npublic final operator fun component8(): String?\n\n```\n\n----\n\n Default value of the column.
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#copy().(defaultDbValue)
//                       display_name defaultDbValue
//                       documentation ```kotlin\ndefaultDbValue: String? = ...\n```\n\n----\n\n Default value of the column.
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#defaultDbValue.
//                       display_name defaultDbValue
//                       documentation ```kotlin\npublic final val defaultDbValue: String?\n```\n\n----\n\n Default value of the column.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#defaultDbValue.
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getDefaultDbValue().
//                       display_name defaultDbValue
//                       documentation ```kotlin\npublic get(): String?\n```\n\n----\n\n Default value of the column.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getDefaultDbValue().
//                        ^^^^^^^ reference semanticdb maven . . kotlin/String#
  )
