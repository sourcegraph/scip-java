  package org.jetbrains.exposed.v1.core.vendors
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
  
  import org.jetbrains.exposed.v1.core.*
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#
  import org.jetbrains.exposed.v1.exceptions.throwUnsupportedException
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#`<init>`().
  internal object SQLiteDataTypeProvider : DataTypeProvider() {
//                ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#
//                                       display_name SQLiteDataTypeProvider
//                                       documentation ```kotlin\ninternal final object SQLiteDataTypeProvider : DataTypeProvider\n```
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
//                ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#`<init>`().
//                                       display_name SQLiteDataTypeProvider
//                                       documentation ```kotlin\nprivate constructor(): SQLiteDataTypeProvider\n```
//                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#integerAutoincType().
      override fun integerAutoincType(): String = "INTEGER PRIMARY KEY AUTOINCREMENT"
//                 ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#integerAutoincType().
//                                    display_name integerAutoincType
//                                    documentation ```kotlin\npublic open override fun integerAutoincType(): String\n```
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerAutoincType().
//                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#integerAutoincType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#longAutoincType().
      override fun longAutoincType(): String = "INTEGER PRIMARY KEY AUTOINCREMENT"
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#longAutoincType().
//                                 display_name longAutoincType
//                                 documentation ```kotlin\npublic open override fun longAutoincType(): String\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#longAutoincType().
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#longAutoincType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#ulongAutoincType().
      override fun ulongAutoincType(): String = "INTEGER PRIMARY KEY AUTOINCREMENT"
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#ulongAutoincType().
//                                  display_name ulongAutoincType
//                                  documentation ```kotlin\npublic open override fun ulongAutoincType(): String\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongAutoincType().
//                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#ulongAutoincType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#floatType().
      override fun floatType(): String = "SINGLE"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#floatType().
//                           display_name floatType
//                           documentation ```kotlin\npublic open override fun floatType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#floatType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#floatType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#binaryType().
      override fun binaryType(): String = "BLOB"
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#binaryType().
//                            display_name binaryType
//                            documentation ```kotlin\npublic open override fun binaryType(): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType().
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#binaryType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#dateTimeType().
      override fun dateTimeType(): String = "TEXT"
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#dateTimeType().
//                              display_name dateTimeType
//                              documentation ```kotlin\npublic open override fun dateTimeType(): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#dateTimeType().
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#dateTimeType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#timestampWithTimeZoneType().
      override fun timestampWithTimeZoneType(): String = "TEXT"
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#timestampWithTimeZoneType().
//                                           display_name timestampWithTimeZoneType
//                                           documentation ```kotlin\npublic open override fun timestampWithTimeZoneType(): String\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#timestampWithTimeZoneType().
//                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#timestampWithTimeZoneType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#dateType().
      override fun dateType(): String = "TEXT"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#dateType().
//                          display_name dateType
//                          documentation ```kotlin\npublic open override fun dateType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#dateType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#dateType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#booleanToStatementString().
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#booleanToStatementString().(bool)
      override fun booleanToStatementString(bool: Boolean) = if (bool) "1" else "0"
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#booleanToStatementString().
//                                          display_name booleanToStatementString
//                                          documentation ```kotlin\npublic open override fun booleanToStatementString(bool: Boolean): String\n```
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanToStatementString().
//                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#booleanToStatementString().(bool)
//                                               display_name bool
//                                               documentation ```kotlin\nbool: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#booleanToStatementString().(bool)
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#booleanToStatementString().(bool)
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#booleanToStatementString().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#jsonType().
      override fun jsonType(): String = "TEXT"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#jsonType().
//                          display_name jsonType
//                          documentation ```kotlin\npublic open override fun jsonType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#jsonType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#jsonType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#hexToDb().
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#hexToDb().(hexString)
      override fun hexToDb(hexString: String): String = "X'$hexString'"
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#hexToDb().
//                         display_name hexToDb
//                         documentation ```kotlin\npublic open override fun hexToDb(hexString: String): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#hexToDb().
//                         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#hexToDb().(hexString)
//                                   display_name hexString
//                                   documentation ```kotlin\nhexString: String\n```
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#hexToDb().(hexString)
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#hexToDb().(hexString)
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#hexToDb().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#`<init>`().
  @Suppress("TooManyFunctions")
  internal object SQLiteFunctionProvider : FunctionProvider() {
//                ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#
//                                       display_name SQLiteFunctionProvider
//                                       documentation ```kotlin\n@Suppress(...) internal final object SQLiteFunctionProvider : FunctionProvider\n```\n\n----\n\n\n Implementation of [FunctionProvider.locate]\n Note: search is case-sensitive\n
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
//                ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#`<init>`().
//                                       display_name SQLiteFunctionProvider
//                                       documentation ```kotlin\nprivate constructor(): SQLiteFunctionProvider\n```\n\n----\n\n\n Implementation of [FunctionProvider.locate]\n Note: search is case-sensitive\n
//                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().[T]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().(expr)
//                                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().(queryBuilder)
      override fun <T : String?> charLength(expr: Expression<T>, queryBuilder: QueryBuilder) = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().
//                                          display_name charLength
//                                          documentation ```kotlin\npublic open override fun <T : String?> charLength(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().
//                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().(expr)
//                                               display_name expr
//                                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().(queryBuilder)
//                                                                            display_name queryBuilder
//                                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().(queryBuilder)
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().[T]
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().(expr)
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().(queryBuilder)
          append("LENGTH(", expr, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().(expr)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().[T]
      override fun <T : String?> substring(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().
//                                         display_name substring
//                                         documentation ```kotlin\npublic open override fun <T : String?> substring(expr: Expression<T>, start: Expression<Int>, length: Expression<Int>, builder: QueryBuilder, prefix: String): Unit\n```
//                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(expr)
          expr: Expression<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(expr)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(start)
          start: Expression<Int>,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(start)
//              display_name start
//              documentation ```kotlin\nstart: Expression<Int>\n```
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(start)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(length)
          length: Expression<Int>,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(length)
//               display_name length
//               documentation ```kotlin\nlength: Expression<Int>\n```
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(length)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(builder)
          builder: QueryBuilder,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(builder)
//                display_name builder
//                documentation ```kotlin\nbuilder: QueryBuilder\n```
//                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(builder)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(prefix)
          prefix: String
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(prefix)
//               display_name prefix
//               documentation ```kotlin\nprefix: String\n```
//                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(prefix)
      ): Unit = super.substring(expr, start, length, builder, "substr")
//       ^^^^ reference semanticdb maven . . kotlin/Unit#
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(expr)
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(start)
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(length)
//                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(builder)
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(separator)
//                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(queryBuilder)
//                                                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(expr)
      override fun concat(separator: String, queryBuilder: QueryBuilder, vararg expr: Expression<*>) = queryBuilder {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().
//                        display_name concat
//                        documentation ```kotlin\npublic open override fun concat(separator: String, queryBuilder: QueryBuilder, vararg expr: Expression<*>): Unit\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().
//                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(separator)
//                                  display_name separator
//                                  documentation ```kotlin\nseparator: String\n```
//                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                           ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(queryBuilder)
//                                                        display_name queryBuilder
//                                                        documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(expr)
//                                                                                   display_name expr
//                                                                                   documentation ```kotlin\nvararg expr: Expression<*>\n```
//                                                                                    ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(queryBuilder)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(separator)
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(queryBuilder)
//                                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(expr)
          if (separator == "") {
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(separator)
//                                                             ⌄ enclosing_range_start local 0
              expr.toList().appendTo(this, separator = " || ") { +it }
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(expr)
//                 ^^^^^^ reference semanticdb maven . . kotlin/collections/toList().
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                                             ^^^^^^^ definition local 0
//                                                                     display_name it
//                                                                     documentation ```kotlin\nit: Expression<*>\n```
//                                                               ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                                                ^^ reference local 0
//                                                                   ⌃ enclosing_range_end local 0
          } else {
//                                                                             ⌄ enclosing_range_start local 1
              expr.toList().appendTo(this, separator = " || '$separator' || ") { +it }
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(expr)
//                 ^^^^^^ reference semanticdb maven . . kotlin/collections/toList().
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(separator)
//                                                                             ^^^^^^^ definition local 1
//                                                                                     display_name it
//                                                                                     documentation ```kotlin\nit: Expression<*>\n```
//                                                                               ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                                                                ^^ reference local 1
//                                                                                   ⌃ enclosing_range_end local 1
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().[T]
//                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().(expr)
//                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().(queryBuilder)
      override fun <T : String?> groupConcat(expr: GroupConcat<T>, queryBuilder: QueryBuilder) {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().
//                                           display_name groupConcat
//                                           documentation ```kotlin\npublic open override fun <T : String?> groupConcat(expr: GroupConcat<T>, queryBuilder: QueryBuilder): Unit\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().
//                                           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().(expr)
//                                                display_name expr
//                                                documentation ```kotlin\nexpr: GroupConcat<T>\n```
//                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#
//                                                                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().(queryBuilder)
//                                                                              display_name queryBuilder
//                                                                              documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().[T]
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().(expr)
//                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().(queryBuilder)
          @OptIn(InternalApi::class)
          if (expr.distinct) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().(expr)
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#distinct.
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getDistinct().
              CoreTransactionManager.currentTransaction().throwUnsupportedException("SQLite doesn't support DISTINCT in GROUP_CONCAT function")
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().(queryBuilder)
              +"GROUP_CONCAT("
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              +expr.expr
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().(expr)
//                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#expr.
//                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getExpr().
//                                ⌄ enclosing_range_start local 2
              expr.separator?.let {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().(expr)
//                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getSeparator().
//                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#separator.
//                            ^^^ reference semanticdb maven . . kotlin/let().
//                                ^ definition local 2 2:13
//                                  display_name it
//                                  documentation ```kotlin\nit: String\n```
                  +", '$it'"
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                      ^^ reference local 2
              }
//            ⌃ enclosing_range_end local 2
              if (expr.orderBy.isNotEmpty()) {
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().(expr)
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//                             ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty().
//                                                               ⌄ enclosing_range_start local 3
//                                                                ⌄ enclosing_range_start local 4
//                                                                            ⌄ enclosing_range_start local 5
                  expr.orderBy.appendTo(prefix = " ORDER BY ") { (expression, sortOrder) ->
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().(expr)
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                                                               ^^^^^^^^^^^^^^^^^^^^^^^ definition local 3
//                                                                                       display_name <destruct>
//                                                                                       documentation ```kotlin\n<destruct>: CapturedType(out Pair<Expression<*>, SortOrder>)\n```
//                                                                ^^^^^^^^^^ reference local 3
//                                                                ^^^^^^^^^^ definition local 4
//                                                                           display_name expression
//                                                                           documentation ```kotlin\nlocal val expression: Expression<*>\n```
//                                                                ^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                                            ^^^^^^^^^ reference local 3
//                                                                            ^^^^^^^^^ definition local 5
//                                                                                      display_name sortOrder
//                                                                                      documentation ```kotlin\nlocal val sortOrder: SortOrder\n```
//                                                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                                         ⌃ enclosing_range_end local 4
//                                                                                    ⌃ enclosing_range_end local 5
//                                                                                     ⌃ enclosing_range_end local 3
                      currentDialect.dataTypeProvider.precessOrderByClause(this, expression, sortOrder)
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().
//                                                                               ^^^^^^^^^^ reference local 4
//                                                                                           ^^^^^^^^^ reference local 5
                  }
              }
              +")"
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().
      /**
       * Implementation of [FunctionProvider.locate]
       * Note: search is case-sensitive
       * */
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().[T]
      override fun <T : String?> locate(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().
//                                      display_name locate
//                                      documentation ```kotlin\npublic open override fun <T : String?> locate(queryBuilder: QueryBuilder, expr: Expression<T>, substring: String): Unit\n```\n\n----\n\n\n Implementation of [FunctionProvider.locate]\n Note: search is case-sensitive\n
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(queryBuilder)
          queryBuilder: QueryBuilder,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(queryBuilder)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(expr)
          expr: Expression<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(expr)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(substring)
          substring: String
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(substring)
//                  display_name substring
//                  documentation ```kotlin\nsubstring: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(substring)
      ) = queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(queryBuilder)
          append("INSTR(", expr, ",\'", substring, "\')")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(expr)
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(substring)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().[T]
      override fun <T : String?> regexp(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().
//                                      display_name regexp
//                                      documentation ```kotlin\npublic open override fun <T : String?> regexp(expr1: Expression<T>, pattern: Expression<String>, caseSensitive: Boolean, queryBuilder: QueryBuilder): Unit\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(expr1)
          expr1: Expression<T>,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(expr1)
//              display_name expr1
//              documentation ```kotlin\nexpr1: Expression<T>\n```
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(expr1)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(pattern)
          pattern: Expression<String>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(pattern)
//                display_name pattern
//                documentation ```kotlin\npattern: Expression<String>\n```
//                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(pattern)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(caseSensitive)
          caseSensitive: Boolean,
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(caseSensitive)
//                      display_name caseSensitive
//                      documentation ```kotlin\ncaseSensitive: Boolean\n```
//                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(caseSensitive)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(queryBuilder)
      ) {
          @OptIn(InternalApi::class)
          CoreTransactionManager.currentTransaction().throwUnsupportedException("SQLite doesn't provide built in REGEXP expression, use LIKE instead.")
//                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(expr)
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(queryBuilder)
      override fun <T> time(expr: Expression<T>, queryBuilder: QueryBuilder) = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().
//                          display_name time
//                          documentation ```kotlin\npublic open override fun <T> time(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().[T]
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(expr)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(queryBuilder)
          append(
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
              "SUBSTR(", expr, ", INSTR(", expr, ", ' ') + 1,\n",
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(expr)
//                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(expr)
              "CASE\n",
              "    WHEN INSTR(", expr, ", 'Z') > 0 THEN\n",
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(expr)
              "        INSTR(", expr, ", 'Z') - 1\n",
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(expr)
              "    WHEN INSTR(", expr, ", '+') > 0 THEN\n",
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(expr)
              "        INSTR(", expr, ", '+') - 1\n",
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(expr)
              "    WHEN INSTR(", expr, ", '-') > 0 THEN\n",
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(expr)
              "        INSTR(", expr, ", '-') - 1\n",
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(expr)
              "    ELSE\n",
              "        LENGTH(", expr, ")\n",
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(expr)
              "END- INSTR(", expr, ", ' '))"
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().(expr)
          )
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().(expr)
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().(queryBuilder)
      override fun <T> year(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().
//                          display_name year
//                          documentation ```kotlin\npublic open override fun <T> year(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                            ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().[T]
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().(expr)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().(queryBuilder)
          append("STRFTIME('%Y',")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().(expr)
//                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().(queryBuilder)
      override fun <T> month(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().
//                           display_name month
//                           documentation ```kotlin\npublic open override fun <T> month(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().
//                           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().(expr)
//                                display_name expr
//                                documentation ```kotlin\nexpr: Expression<T>\n```
//                                 ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().(queryBuilder)
//                                                             display_name queryBuilder
//                                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().[T]
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().(expr)
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().(queryBuilder)
          append("STRFTIME('%m',")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().[T]
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().(expr)
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().(queryBuilder)
      override fun <T> day(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().
//                         display_name day
//                         documentation ```kotlin\npublic open override fun <T> day(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().
//                         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().(expr)
//                              display_name expr
//                              documentation ```kotlin\nexpr: Expression<T>\n```
//                               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().(queryBuilder)
//                                                           display_name queryBuilder
//                                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().[T]
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().(expr)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().(queryBuilder)
          append("STRFTIME('%d',")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().(expr)
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().(queryBuilder)
      override fun <T> hour(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().
//                          display_name hour
//                          documentation ```kotlin\npublic open override fun <T> hour(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                            ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().[T]
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().(expr)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().(queryBuilder)
          append("STRFTIME('%H',")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().(expr)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().(queryBuilder)
      override fun <T> minute(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().
//                            display_name minute
//                            documentation ```kotlin\npublic open override fun <T> minute(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().
//                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().(expr)
//                                 display_name expr
//                                 documentation ```kotlin\nexpr: Expression<T>\n```
//                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().(queryBuilder)
//                                                              display_name queryBuilder
//                                                              documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                              ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().[T]
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().(expr)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().(queryBuilder)
          append("STRFTIME('%M',")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().(expr)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().(queryBuilder)
      override fun <T> second(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().
//                            display_name second
//                            documentation ```kotlin\npublic open override fun <T> second(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().
//                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().(expr)
//                                 display_name expr
//                                 documentation ```kotlin\nexpr: Expression<T>\n```
//                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().(queryBuilder)
//                                                              display_name queryBuilder
//                                                              documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                              ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().[T]
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().(expr)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().(queryBuilder)
          append("STRFTIME('%S',")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#UNSUPPORTED_AGGREGATE.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#getUNSUPPORTED_AGGREGATE().
      private const val UNSUPPORTED_AGGREGATE = "SQLite doesn't provide built-in aggregate function"
//                      ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#UNSUPPORTED_AGGREGATE.
//                                            display_name UNSUPPORTED_AGGREGATE
//                                            documentation ```kotlin\nprivate final const val UNSUPPORTED_AGGREGATE: String\n```
//                      ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#getUNSUPPORTED_AGGREGATE().
//                                            display_name UNSUPPORTED_AGGREGATE
//                                            documentation ```kotlin\nprivate get(): String\n```
//                                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#UNSUPPORTED_AGGREGATE.
//                                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#getUNSUPPORTED_AGGREGATE().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().[T]
      override fun <T> stdDevPop(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().
//                               display_name stdDevPop
//                               documentation ```kotlin\npublic open override fun <T> stdDevPop(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().(expression)
          expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().(queryBuilder)
      ) {
          @OptIn(InternalApi::class)
          CoreTransactionManager.currentTransaction().throwUnsupportedException("$UNSUPPORTED_AGGREGATE STDDEV_POP")
//                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#UNSUPPORTED_AGGREGATE.
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#getUNSUPPORTED_AGGREGATE().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().[T]
      override fun <T> stdDevSamp(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().
//                                display_name stdDevSamp
//                                documentation ```kotlin\npublic open override fun <T> stdDevSamp(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().(expression)
          expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().(queryBuilder)
      ) {
          @OptIn(InternalApi::class)
          CoreTransactionManager.currentTransaction().throwUnsupportedException("$UNSUPPORTED_AGGREGATE STDDEV_SAMP")
//                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#UNSUPPORTED_AGGREGATE.
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#getUNSUPPORTED_AGGREGATE().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().[T]
      override fun <T> varPop(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().
//                            display_name varPop
//                            documentation ```kotlin\npublic open override fun <T> varPop(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().(expression)
          expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().(queryBuilder)
      ) {
          @OptIn(InternalApi::class)
          CoreTransactionManager.currentTransaction().throwUnsupportedException("$UNSUPPORTED_AGGREGATE VAR_POP")
//                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#UNSUPPORTED_AGGREGATE.
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#getUNSUPPORTED_AGGREGATE().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().[T]
      override fun <T> varSamp(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().
//                             display_name varSamp
//                             documentation ```kotlin\npublic open override fun <T> varSamp(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().(expression)
          expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().(queryBuilder)
      ) {
          @OptIn(InternalApi::class)
          CoreTransactionManager.currentTransaction().throwUnsupportedException("$UNSUPPORTED_AGGREGATE VAR_SAMP")
//                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#UNSUPPORTED_AGGREGATE.
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#getUNSUPPORTED_AGGREGATE().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().[T]
      override fun <T> jsonExtract(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().
//                                 display_name jsonExtract
//                                 documentation ```kotlin\npublic open override fun <T> jsonExtract(expression: Expression<T>, vararg path: String, toScalar: Boolean, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(expression)
          expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(path)
          vararg path: String,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(path)
//                    display_name path
//                    documentation ```kotlin\nvararg path: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/Array#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(path)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(toScalar)
          toScalar: Boolean,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(toScalar)
//                 display_name toScalar
//                 documentation ```kotlin\ntoScalar: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(toScalar)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(jsonType)
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(jsonType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(queryBuilder)
      ) = queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(queryBuilder)
          append("JSON_EXTRACT(", expression, ", ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(expression)
//                                              ⌄ enclosing_range_start local 6
          path.ifEmpty { arrayOf("") }.appendTo { +"'$$it'" }
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(path)
//             ^^^^^^^ reference semanticdb maven . . kotlin/collections/ifEmpty().
//                       ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                                              ^^^^^^^^^^^^^ definition local 6
//                                                            display_name it
//                                                            documentation ```kotlin\nit: CapturedType(out String)\n```
//                                                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                                     ^^ reference local 6
//                                                          ⌃ enclosing_range_end local 6
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().
      override fun jsonExists(
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().
//                            display_name jsonExists
//                            documentation ```kotlin\npublic open override fun jsonExists(expression: Expression<*>, vararg path: String, optional: String?, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(expression)
          expression: Expression<*>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<*>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(path)
          vararg path: String,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(path)
//                    display_name path
//                    documentation ```kotlin\nvararg path: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/Array#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(path)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(optional)
          optional: String?,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(optional)
//                 display_name optional
//                 documentation ```kotlin\noptional: String?\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(optional)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(jsonType)
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(jsonType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(queryBuilder)
      ) {
//        ⌄ enclosing_range_start local 7
          @OptIn(InternalApi::class)
          val transaction = CoreTransactionManager.currentTransaction()
//            ^^^^^^^^^^^ definition local 7
//                        display_name transaction
//                        documentation ```kotlin\n@OptIn(...) local val transaction: Transaction\n```
//                                                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                                    ⌃ enclosing_range_end local 7
          if (path.size > 1) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(path)
//                 ^^^^ reference semanticdb maven . . kotlin/Array#getSize().
//                 ^^^^ reference semanticdb maven . . kotlin/Array#size.
//                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
              transaction.throwUnsupportedException("SQLite does not support multiple JSON path arguments")
//            ^^^^^^^^^^^ reference local 7
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
//                      ⌄ enclosing_range_start local 8
          optional?.let {
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(optional)
//                  ^^^ reference semanticdb maven . . kotlin/let().
//                      ^ definition local 8 2:9
//                        display_name it
//                        documentation ```kotlin\nit: String\n```
              transaction.throwUnsupportedException("SQLite does not support optional arguments other than a path argument")
//            ^^^^^^^^^^^ reference local 7
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
//        ⌃ enclosing_range_end local 8
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(queryBuilder)
              append("JSON_TYPE(", expression, ", ")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(expression)
              append("'$", path.firstOrNull() ?: "", "'")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(path)
//                              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull().
              append(") IS NOT NULL")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().
      override fun insert(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().
//                        display_name insert
//                        documentation ```kotlin\npublic open override fun insert(ignore: Boolean, table: Table, columns: List<Column<*>>, expr: String, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(ignore)
          ignore: Boolean,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(ignore)
//               display_name ignore
//               documentation ```kotlin\nignore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(ignore)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(table)
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(table)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(columns)
          columns: List<Column<*>>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(columns)
//                display_name columns
//                documentation ```kotlin\ncolumns: List<Column<*>>\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(columns)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(expr)
          expr: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(expr)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
//        ⌄ enclosing_range_start local 9
          val def = super.insert(false, table, columns, expr, transaction)
//            ^^^ definition local 9
//                display_name def
//                documentation ```kotlin\nlocal val def: String\n```
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(table)
//                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(columns)
//                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(expr)
//                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(transaction)
//                                                                       ⌃ enclosing_range_end local 9
          return if (ignore) def.replaceFirst("INSERT", "INSERT OR IGNORE") else def
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(ignore)
//                           ^^^ reference local 9
//                               ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/replaceFirst(+1).
//                                                                               ^^^ reference local 9
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().
      override fun replace(
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().
//                         display_name replace
//                         documentation ```kotlin\npublic open override fun replace(table: Table, columns: List<Column<*>>, expression: String, transaction: Transaction, prepared: Boolean): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(table)
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(table)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(columns)
          columns: List<Column<*>>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(columns)
//                display_name columns
//                documentation ```kotlin\ncolumns: List<Column<*>>\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(columns)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(expression)
          expression: String,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: String\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(transaction)
          transaction: Transaction,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(transaction)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(prepared)
          prepared: Boolean
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(prepared)
//                 display_name prepared
//                 documentation ```kotlin\nprepared: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(prepared)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
//        ⌄ enclosing_range_start local 10
          val insertStatement = super.insert(false, table, columns, expression, transaction)
//            ^^^^^^^^^^^^^^^ definition local 10
//                            display_name insertStatement
//                            documentation ```kotlin\nlocal val insertStatement: String\n```
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(table)
//                                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(columns)
//                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(expression)
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(transaction)
//                                                                                         ⌃ enclosing_range_end local 10
          return insertStatement.replace("INSERT", "INSERT OR REPLACE")
//               ^^^^^^^^^^^^^^^ reference local 10
//                               ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().
      override fun upsert(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().
//                        display_name upsert
//                        documentation ```kotlin\npublic open override fun upsert(table: Table, data: List<Pair<Column<*>, Any?>>, expression: String, onUpdate: List<Pair<Column<*>, Any?>>, keyColumns: List<Column<*>>, where: Op<Boolean>?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(table)
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(table)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(data)
          data: List<Pair<Column<*>, Any?>>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(data)
//             display_name data
//             documentation ```kotlin\ndata: List<Pair<Column<*>, Any?>>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(data)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(expression)
          expression: String,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: String\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(onUpdate)
          onUpdate: List<Pair<Column<*>, Any?>>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: List<Pair<Column<*>, Any?>>\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(onUpdate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(keyColumns)
          keyColumns: List<Column<*>>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(keyColumns)
//                   display_name keyColumns
//                   documentation ```kotlin\nkeyColumns: List<Column<*>>\n```
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(keyColumns)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(where)
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(transaction)
      ): String = with(QueryBuilder(true)) {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                ^^^^ reference semanticdb maven . . kotlin/with().
//                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
          +insert(false, table, data.unzip().first, expression, transaction)
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(table)
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(data)
//                                   ^^^^^ reference semanticdb maven . . kotlin/collections/unzip(+1).
//                                           ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                           ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(expression)
//                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(transaction)
  
          +" ON CONFLICT"
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          if (keyColumns.isNotEmpty()) {
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(keyColumns)
//                       ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                                                ⌄ enclosing_range_start local 11
              keyColumns.appendTo(prefix = " (", postfix = ")") { column ->
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(keyColumns)
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                                ^^^^^^ definition local 11
//                                                                       display_name column
//                                                                       documentation ```kotlin\ncolumn: Column<*>\n```
//                                                                     ⌃ enclosing_range_end local 11
                  append(transaction.identity(column))
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(transaction)
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                            ^^^^^^ reference local 11
              }
          }
  
          +" DO UPDATE SET "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                            ⌄ enclosing_range_start local 12
//                             ⌄ enclosing_range_start local 13
//                                             ⌄ enclosing_range_start local 14
          onUpdate.appendTo { (columnToUpdate, updateExpression) ->
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(onUpdate)
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 12
//                                                               display_name <destruct>
//                                                               documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                             ^^^^^^^^^^^^^^ reference local 12
//                             ^^^^^^^^^^^^^^ definition local 13
//                                            display_name columnToUpdate
//                                            documentation ```kotlin\nlocal val columnToUpdate: Column<*>\n```
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                             ^^^^^^^^^^^^^^^^ reference local 12
//                                             ^^^^^^^^^^^^^^^^ definition local 14
//                                                              display_name updateExpression
//                                                              documentation ```kotlin\nlocal val updateExpression: Any?\n```
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                          ⌃ enclosing_range_end local 13
//                                                            ⌃ enclosing_range_end local 14
//                                                             ⌃ enclosing_range_end local 12
              append("${transaction.identity(columnToUpdate)}=")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(transaction)
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                           ^^^^^^^^^^^^^^ reference local 13
              registerArgument(columnToUpdate, updateExpression)
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                             ^^^^^^^^^^^^^^ reference local 13
//                                             ^^^^^^^^^^^^^^^^ reference local 14
          }
  
//                   ⌄ enclosing_range_start local 15
          where?.let {
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(where)
//               ^^^ reference semanticdb maven . . kotlin/let().
//                   ^ definition local 15 3:9
//                     display_name it
//                     documentation ```kotlin\nit: Op<Boolean>\n```
              +" WHERE "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              +it
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//             ^^ reference local 15
          }
//        ⌃ enclosing_range_end local 15
          toString()
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insertValue().
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insertValue().(columnName)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insertValue().(queryBuilder)
      override fun insertValue(columnName: String, queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insertValue().
//                             display_name insertValue
//                             documentation ```kotlin\npublic open override fun insertValue(columnName: String, queryBuilder: QueryBuilder): Unit\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insertValue().
//                             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insertValue().(columnName)
//                                        display_name columnName
//                                        documentation ```kotlin\ncolumnName: String\n```
//                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insertValue().(queryBuilder)
//                                                              display_name queryBuilder
//                                                              documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insertValue().(columnName)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insertValue().(queryBuilder)
          queryBuilder { +"EXCLUDED.$columnName" }
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insertValue().(queryBuilder)
//                       ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insertValue().(columnName)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insertValue().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().(size)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().(offset)
//                                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().(alreadyOrdered)
      override fun queryLimitAndOffset(size: Int?, offset: Long, alreadyOrdered: Boolean): String {
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().
//                                     display_name queryLimitAndOffset
//                                     documentation ```kotlin\npublic open override fun queryLimitAndOffset(size: Int?, offset: Long, alreadyOrdered: Boolean): String\n```
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().
//                                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().(size)
//                                          display_name size
//                                          documentation ```kotlin\nsize: Int?\n```
//                                           ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().(offset)
//                                                        display_name offset
//                                                        documentation ```kotlin\noffset: Long\n```
//                                                         ^^^^ reference semanticdb maven . . kotlin/Long#
//                                                               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().(alreadyOrdered)
//                                                                              display_name alreadyOrdered
//                                                                              documentation ```kotlin\nalreadyOrdered: Boolean\n```
//                                                                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().(size)
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().(offset)
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().(alreadyOrdered)
          @OptIn(InternalApi::class)
          if (size == null && offset > 0) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().(size)
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().(offset)
//                                   ^ reference semanticdb maven . . kotlin/Long#compareTo(+2).
              CoreTransactionManager.currentTransaction().throwUnsupportedException("SQLite doesn't support OFFSET clause without LIMIT")
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          return super.queryLimitAndOffset(size, offset, alreadyOrdered)
//                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().
//                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().(size)
//                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().(offset)
//                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().(alreadyOrdered)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().
      override fun explain(
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().
//                         display_name explain
//                         documentation ```kotlin\npublic open override fun explain(analyze: Boolean, options: String?, internalStatement: String, transaction: Transaction): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(analyze)
          analyze: Boolean,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(analyze)
//                display_name analyze
//                documentation ```kotlin\nanalyze: Boolean\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(analyze)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(options)
          options: String?,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(options)
//                display_name options
//                documentation ```kotlin\noptions: String?\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(options)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(internalStatement)
          internalStatement: String,
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(internalStatement)
//                          display_name internalStatement
//                          documentation ```kotlin\ninternalStatement: String\n```
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(internalStatement)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (analyze || options != null) {
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(analyze)
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(options)
              transaction.throwUnsupportedException("SQLite does not support ANALYZE or other options in EXPLAIN queries.")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
//        ⌄ enclosing_range_start local 16
          val sql = super.explain(false, null, internalStatement, transaction)
//            ^^^ definition local 16
//                display_name sql
//                documentation ```kotlin\nlocal val sql: String\n```
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
//                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(internalStatement)
//                                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(transaction)
//                                                                           ⌃ enclosing_range_end local 16
          return sql.replaceFirst("EXPLAIN ", "EXPLAIN QUERY PLAN ")
//               ^^^ reference local 16
//                   ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/replaceFirst(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().
      override fun returning(
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().
//                           display_name returning
//                           documentation ```kotlin\npublic open override fun returning(mainSql: String, returning: List<Expression<*>>, transaction: Transaction): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(mainSql)
          mainSql: String,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(mainSql)
//                display_name mainSql
//                documentation ```kotlin\nmainSql: String\n```
//                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(mainSql)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(returning)
          returning: List<Expression<*>>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(returning)
//                  display_name returning
//                  documentation ```kotlin\nreturning: List<Expression<*>>\n```
//                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(returning)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          return with(QueryBuilder(true)) {
//               ^^^^ reference semanticdb maven . . kotlin/with().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
              +"$mainSql RETURNING "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(mainSql)
//                               ⌄ enclosing_range_start local 17
              returning.appendTo { +it }
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(returning)
//                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                               ^^^^^^^ definition local 17
//                                       display_name it
//                                       documentation ```kotlin\nit: Expression<*>\n```
//                                 ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                  ^^ reference local 17
//                                     ⌃ enclosing_range_end local 17
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#`<init>`().
  /**
   * SQLite dialect implementation.
   */
  open class SQLiteDialect : VendorDialect(dialectName, SQLiteDataTypeProvider, SQLiteFunctionProvider) {
//           ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#
//                         display_name SQLiteDialect
//                         documentation ```kotlin\npublic open class SQLiteDialect : VendorDialect\n```\n\n----\n\n\n SQLite dialect implementation.\n
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
//           ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#`<init>`().
//                         display_name SQLiteDialect
//                         documentation ```kotlin\npublic constructor(): SQLiteDialect\n```\n\n----\n\n\n SQLite dialect implementation.\n
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsCreateSequence.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsCreateSequence().
      override val supportsCreateSequence: Boolean = false
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsCreateSequence().
//                                        display_name supportsCreateSequence
//                                        documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsCreateSequence.
//                                        display_name supportsCreateSequence
//                                        documentation ```kotlin\npublic open override val supportsCreateSequence: Boolean\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsCreateSequence.
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsCreateSequence().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsMultipleGeneratedKeys.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsMultipleGeneratedKeys().
      override val supportsMultipleGeneratedKeys: Boolean = false
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsMultipleGeneratedKeys().
//                                               display_name supportsMultipleGeneratedKeys
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsMultipleGeneratedKeys.
//                                               display_name supportsMultipleGeneratedKeys
//                                               documentation ```kotlin\npublic open override val supportsMultipleGeneratedKeys: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsMultipleGeneratedKeys.
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsMultipleGeneratedKeys().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsCreateSchema.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsCreateSchema().
      override val supportsCreateSchema: Boolean = false
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsCreateSchema().
//                                      display_name supportsCreateSchema
//                                      documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsCreateSchema.
//                                      display_name supportsCreateSchema
//                                      documentation ```kotlin\npublic open override val supportsCreateSchema: Boolean\n```
//                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsCreateSchema.
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsCreateSchema().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsWindowFrameGroupsMode.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsWindowFrameGroupsMode().
      override val supportsWindowFrameGroupsMode: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsWindowFrameGroupsMode().
//                                               display_name supportsWindowFrameGroupsMode
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsWindowFrameGroupsMode.
//                                               display_name supportsWindowFrameGroupsMode
//                                               documentation ```kotlin\npublic open override val supportsWindowFrameGroupsMode: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsWindowFrameGroupsMode.
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsWindowFrameGroupsMode().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#isAllowedAsColumnDefault().
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#isAllowedAsColumnDefault().(e)
      override fun isAllowedAsColumnDefault(e: Expression<*>): Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#isAllowedAsColumnDefault().
//                                          display_name isAllowedAsColumnDefault
//                                          documentation ```kotlin\npublic open override fun isAllowedAsColumnDefault(e: Expression<*>): Boolean\n```
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#isAllowedAsColumnDefault().
//                                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#isAllowedAsColumnDefault().(e)
//                                            display_name e
//                                            documentation ```kotlin\ne: Expression<*>\n```
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#isAllowedAsColumnDefault().(e)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#isAllowedAsColumnDefault().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().(index)
      override fun createIndex(index: Index): String {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().
//                             display_name createIndex
//                             documentation ```kotlin\npublic open override fun createIndex(index: Index): String\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().(index)
//                                   display_name index
//                                   documentation ```kotlin\nindex: Index\n```
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#
//                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().(index)
          if (index.indexType != null) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().(index)
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexType().
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexType.
              exposedLogger.warn(
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                                                                                               ⌄ enclosing_range_start local 18
                  "Index of type ${index.indexType} on ${index.table.tableName} for ${index.columns.joinToString { it.name }} can't be created in SQLite"
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().(index)
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexType().
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexType.
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().(index)
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().(index)
//                                                                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                                                                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                                               ^^^^^^^^^^^ definition local 18
//                                                                                                                           display_name it
//                                                                                                                           documentation ```kotlin\nit: Column<*>\n```
//                                                                                                                 ^^ reference local 18
//                                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                                                                         ⌃ enclosing_range_end local 18
              )
              return ""
          }
//        ⌄ enclosing_range_start local 19
          val originalCreateIndex = super.createIndex(index.copy(unique = false))
//            ^^^^^^^^^^^^^^^^^^^ definition local 19
//                                display_name originalCreateIndex
//                                documentation ```kotlin\nlocal val originalCreateIndex: String\n```
//                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().
//                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().(index)
//                                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#copy().
//                                                                              ⌃ enclosing_range_end local 19
          return if (index.unique) {
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().(index)
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
              originalCreateIndex.replace("CREATE INDEX", "CREATE UNIQUE INDEX")
//            ^^^^^^^^^^^^^^^^^^^ reference local 19
//                                ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
          } else {
              originalCreateIndex
//            ^^^^^^^^^^^^^^^^^^^ reference local 19
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().(tableName)
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().(indexName)
//                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().(isUnique)
//                                                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().(isPartialOrFunctional)
      override fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String {
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().
//                           display_name dropIndex
//                           documentation ```kotlin\npublic open override fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().
//                           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().(tableName)
//                                     display_name tableName
//                                     documentation ```kotlin\ntableName: String\n```
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().(indexName)
//                                                        display_name indexName
//                                                        documentation ```kotlin\nindexName: String\n```
//                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().(isUnique)
//                                                                          display_name isUnique
//                                                                          documentation ```kotlin\nisUnique: Boolean\n```
//                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                    ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().(isPartialOrFunctional)
//                                                                                                          display_name isPartialOrFunctional
//                                                                                                          documentation ```kotlin\nisPartialOrFunctional: Boolean\n```
//                                                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().(tableName)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().(indexName)
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().(isUnique)
//                                                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().(isPartialOrFunctional)
          return "DROP INDEX IF EXISTS ${identifierManager.cutIfNecessaryAndQuote(indexName)}"
//                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                                         ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().(indexName)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createDatabase().
      @OptIn(InternalApi::class)
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createDatabase().(name)
      override fun createDatabase(name: String) = "ATTACH DATABASE '${name.lowercase()}.db' AS ${name.inProperCase()}"
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createDatabase().
//                                display_name createDatabase
//                                documentation ```kotlin\n@OptIn(...) public open override fun createDatabase(name: String): String\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createDatabase().
//                                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createDatabase().(name)
//                                     display_name name
//                                     documentation ```kotlin\nname: String\n```
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createDatabase().(name)
//                                                                         ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
//                                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createDatabase().(name)
//                                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createDatabase().(name)
//                                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createDatabase().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#listDatabases().
      override fun listDatabases(): String = "SELECT name FROM pragma_database_list"
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#listDatabases().
//                               display_name listDatabases
//                               documentation ```kotlin\npublic open override fun listDatabases(): String\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#listDatabases().
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#listDatabases().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropDatabase().
      @OptIn(InternalApi::class)
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropDatabase().(name)
      override fun dropDatabase(name: String) = "DETACH DATABASE ${name.inProperCase()}"
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropDatabase().
//                              display_name dropDatabase
//                              documentation ```kotlin\n@OptIn(...) public open override fun dropDatabase(name: String): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropDatabase().
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropDatabase().(name)
//                                   display_name name
//                                   documentation ```kotlin\nname: String\n```
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropDatabase().(name)
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropDatabase().(name)
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropDatabase().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#Companion#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#Companion#`<init>`().
      companion object : DialectNameProvider("SQLite")
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#Companion#
//                                                     display_name Companion
//                                                     documentation ```kotlin\npublic final companion object Companion : VendorDialect.DialectNameProvider\n```
//                                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#Companion#`<init>`().
//                                                     display_name Companion
//                                                     documentation ```kotlin\nprivate constructor(): SQLiteDialect.Companion\n```
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#Companion#
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#Companion#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#`<init>`().
