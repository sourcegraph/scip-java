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
  
  internal object SQLiteDataTypeProvider : DataTypeProvider() {
//                ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#
//                                       display_name SQLiteDataTypeProvider
//                                       documentation ```kotlin\ninternal final object SQLiteDataTypeProvider : DataTypeProvider\n```
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
//                ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#`<init>`().
//                                       display_name SQLiteDataTypeProvider
//                                       documentation ```kotlin\nprivate constructor(): SQLiteDataTypeProvider\n```
//                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
      override fun integerAutoincType(): String = "INTEGER PRIMARY KEY AUTOINCREMENT"
//                 ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#integerAutoincType().
//                                    display_name integerAutoincType
//                                    documentation ```kotlin\npublic open override fun integerAutoincType(): String\n```
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerAutoincType().
//                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun longAutoincType(): String = "INTEGER PRIMARY KEY AUTOINCREMENT"
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#longAutoincType().
//                                 display_name longAutoincType
//                                 documentation ```kotlin\npublic open override fun longAutoincType(): String\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#longAutoincType().
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun ulongAutoincType(): String = "INTEGER PRIMARY KEY AUTOINCREMENT"
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#ulongAutoincType().
//                                  display_name ulongAutoincType
//                                  documentation ```kotlin\npublic open override fun ulongAutoincType(): String\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongAutoincType().
//                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun floatType(): String = "SINGLE"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#floatType().
//                           display_name floatType
//                           documentation ```kotlin\npublic open override fun floatType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#floatType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun binaryType(): String = "BLOB"
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#binaryType().
//                            display_name binaryType
//                            documentation ```kotlin\npublic open override fun binaryType(): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType().
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun dateTimeType(): String = "TEXT"
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#dateTimeType().
//                              display_name dateTimeType
//                              documentation ```kotlin\npublic open override fun dateTimeType(): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#dateTimeType().
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun timestampWithTimeZoneType(): String = "TEXT"
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#timestampWithTimeZoneType().
//                                           display_name timestampWithTimeZoneType
//                                           documentation ```kotlin\npublic open override fun timestampWithTimeZoneType(): String\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#timestampWithTimeZoneType().
//                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun dateType(): String = "TEXT"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#dateType().
//                          display_name dateType
//                          documentation ```kotlin\npublic open override fun dateType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#dateType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
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
      override fun jsonType(): String = "TEXT"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#jsonType().
//                          display_name jsonType
//                          documentation ```kotlin\npublic open override fun jsonType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#jsonType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
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
  }
  
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
          append("LENGTH(", expr, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().(expr)
      }
  
      override fun <T : String?> substring(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().
//                                         display_name substring
//                                         documentation ```kotlin\npublic open override fun <T : String?> substring(expr: Expression<T>, start: Expression<Int>, length: Expression<Int>, builder: QueryBuilder, prefix: String): Unit\n```
//                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().
          expr: Expression<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          start: Expression<Int>,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(start)
//              display_name start
//              documentation ```kotlin\nstart: Expression<Int>\n```
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          length: Expression<Int>,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(length)
//               display_name length
//               documentation ```kotlin\nlength: Expression<Int>\n```
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          builder: QueryBuilder,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(builder)
//                display_name builder
//                documentation ```kotlin\nbuilder: QueryBuilder\n```
//                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
          prefix: String
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(prefix)
//               display_name prefix
//               documentation ```kotlin\nprefix: String\n```
//                ^^^^^^ reference semanticdb maven . . kotlin/String#
      ): Unit = super.substring(expr, start, length, builder, "substr")
//       ^^^^ reference semanticdb maven . . kotlin/Unit#
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(expr)
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(start)
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(length)
//                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().(builder)
  
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
          if (separator == "") {
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(separator)
              expr.toList().appendTo(this, separator = " || ") { +it }
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(expr)
//                 ^^^^^^ reference semanticdb maven . . kotlin/collections/toList().
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                                             ^^^^^^^ definition semanticdb maven . . (it)
//                                                                     display_name it
//                                                                     documentation ```kotlin\nit: Column<*>\n```
//                                                               ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                                                ^^ reference semanticdb maven . . (it)
          } else {
              expr.toList().appendTo(this, separator = " || '$separator' || ") { +it }
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(expr)
//                 ^^^^^^ reference semanticdb maven . . kotlin/collections/toList().
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().(separator)
//                                                                             ^^^^^^^ definition semanticdb maven . . (it)
//                                                                                     display_name it
//                                                                                     documentation ```kotlin\nit: Column<*>\n```
//                                                                               ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                                                                ^^ reference semanticdb maven . . (it)
          }
      }
  
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
              expr.separator?.let {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().(expr)
//                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getSeparator().
//                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#separator.
//                            ^^^ reference semanticdb maven . . kotlin/let().
//                                ^ definition semanticdb maven . . (it) 2:13
//                                  display_name it
//                                  documentation ```kotlin\nit: Column<*>\n```
                  +", '$it'"
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                      ^^ reference semanticdb maven . . (it)
              }
              if (expr.orderBy.isNotEmpty()) {
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().(expr)
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//                             ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty().
                  expr.orderBy.appendTo(prefix = " ORDER BY ") { (expression, sortOrder) ->
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().(expr)
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                                                               ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                                                       display_name <destruct>
//                                                                                       documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                                                ^^^^^^^^^^ definition local 0
//                                                                           display_name expression
//                                                                           documentation ```kotlin\nlocal val expression: Expression<*>\n```
//                                                                ^^^^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                                ^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                                            ^^^^^^^^^ definition local 1
//                                                                                      display_name sortOrder
//                                                                                      documentation ```kotlin\nlocal val sortOrder: SortOrder\n```
//                                                                            ^^^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
                      currentDialect.dataTypeProvider.precessOrderByClause(this, expression, sortOrder)
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().
//                                                                               ^^^^^^^^^^ reference local 0
//                                                                                           ^^^^^^^^^ reference local 1
                  }
              }
              +")"
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          }
      }
  
      /**
       * Implementation of [FunctionProvider.locate]
       * Note: search is case-sensitive
       * */
      override fun <T : String?> locate(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().
//                                      display_name locate
//                                      documentation ```kotlin\npublic open override fun <T : String?> locate(queryBuilder: QueryBuilder, expr: Expression<T>, substring: String): Unit\n```\n\n----\n\n\n Implementation of [FunctionProvider.locate]\n Note: search is case-sensitive\n
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().
          queryBuilder: QueryBuilder,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
          expr: Expression<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          substring: String
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(substring)
//                  display_name substring
//                  documentation ```kotlin\nsubstring: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
      ) = queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(queryBuilder)
          append("INSTR(", expr, ",\'", substring, "\')")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(expr)
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().(substring)
      }
  
      override fun <T : String?> regexp(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().
//                                      display_name regexp
//                                      documentation ```kotlin\npublic open override fun <T : String?> regexp(expr1: Expression<T>, pattern: Expression<String>, caseSensitive: Boolean, queryBuilder: QueryBuilder): Unit\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().
          expr1: Expression<T>,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(expr1)
//              display_name expr1
//              documentation ```kotlin\nexpr1: Expression<T>\n```
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          pattern: Expression<String>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(pattern)
//                display_name pattern
//                documentation ```kotlin\npattern: Expression<String>\n```
//                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          caseSensitive: Boolean,
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(caseSensitive)
//                      display_name caseSensitive
//                      documentation ```kotlin\ncaseSensitive: Boolean\n```
//                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
      ) {
          @OptIn(InternalApi::class)
          CoreTransactionManager.currentTransaction().throwUnsupportedException("SQLite doesn't provide built in REGEXP expression, use LIKE instead.")
//                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
      }
  
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
          append("STRFTIME('%Y',")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
  
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
          append("STRFTIME('%m',")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
  
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
          append("STRFTIME('%d',")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
  
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
          append("STRFTIME('%H',")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
  
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
          append("STRFTIME('%M',")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
  
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
          append("STRFTIME('%S',")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
  
      private const val UNSUPPORTED_AGGREGATE = "SQLite doesn't provide built-in aggregate function"
//                      ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#UNSUPPORTED_AGGREGATE.
//                                            display_name UNSUPPORTED_AGGREGATE
//                                            documentation ```kotlin\nprivate final const val UNSUPPORTED_AGGREGATE: String\n```
//                      ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#getUNSUPPORTED_AGGREGATE().
//                                            display_name UNSUPPORTED_AGGREGATE
//                                            documentation ```kotlin\nprivate get(): String\n```
  
      override fun <T> stdDevPop(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().
//                               display_name stdDevPop
//                               documentation ```kotlin\npublic open override fun <T> stdDevPop(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().
          expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
      ) {
          @OptIn(InternalApi::class)
          CoreTransactionManager.currentTransaction().throwUnsupportedException("$UNSUPPORTED_AGGREGATE STDDEV_POP")
//                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#UNSUPPORTED_AGGREGATE.
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#getUNSUPPORTED_AGGREGATE().
      }
  
      override fun <T> stdDevSamp(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().
//                                display_name stdDevSamp
//                                documentation ```kotlin\npublic open override fun <T> stdDevSamp(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().
          expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
      ) {
          @OptIn(InternalApi::class)
          CoreTransactionManager.currentTransaction().throwUnsupportedException("$UNSUPPORTED_AGGREGATE STDDEV_SAMP")
//                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#UNSUPPORTED_AGGREGATE.
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#getUNSUPPORTED_AGGREGATE().
      }
  
      override fun <T> varPop(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().
//                            display_name varPop
//                            documentation ```kotlin\npublic open override fun <T> varPop(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().
          expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
      ) {
          @OptIn(InternalApi::class)
          CoreTransactionManager.currentTransaction().throwUnsupportedException("$UNSUPPORTED_AGGREGATE VAR_POP")
//                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#UNSUPPORTED_AGGREGATE.
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#getUNSUPPORTED_AGGREGATE().
      }
  
      override fun <T> varSamp(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().
//                             display_name varSamp
//                             documentation ```kotlin\npublic open override fun <T> varSamp(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().
          expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
      ) {
          @OptIn(InternalApi::class)
          CoreTransactionManager.currentTransaction().throwUnsupportedException("$UNSUPPORTED_AGGREGATE VAR_SAMP")
//                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#UNSUPPORTED_AGGREGATE.
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#getUNSUPPORTED_AGGREGATE().
      }
  
      override fun <T> jsonExtract(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().
//                                 display_name jsonExtract
//                                 documentation ```kotlin\npublic open override fun <T> jsonExtract(expression: Expression<T>, vararg path: String, toScalar: Boolean, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().
          expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          vararg path: String,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(path)
//                    display_name path
//                    documentation ```kotlin\nvararg path: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/Array#
          toScalar: Boolean,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(toScalar)
//                 display_name toScalar
//                 documentation ```kotlin\ntoScalar: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
      ) = queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(queryBuilder)
          append("JSON_EXTRACT(", expression, ", ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(expression)
          path.ifEmpty { arrayOf("") }.appendTo { +"'$$it'" }
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().(path)
//             ^^^^^^^ reference semanticdb maven . . kotlin/collections/ifEmpty().
//                       ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                                              ^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                            display_name it
//                                                            documentation ```kotlin\nit: Column<*>\n```
//                                                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                                     ^^ reference semanticdb maven . . (it)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
  
      override fun jsonExists(
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().
//                            display_name jsonExists
//                            documentation ```kotlin\npublic open override fun jsonExists(expression: Expression<*>, vararg path: String, optional: String?, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().
          expression: Expression<*>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<*>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          vararg path: String,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(path)
//                    display_name path
//                    documentation ```kotlin\nvararg path: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/Array#
          optional: String?,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(optional)
//                 display_name optional
//                 documentation ```kotlin\noptional: String?\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/String#
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
      ) {
          @OptIn(InternalApi::class)
          val transaction = CoreTransactionManager.currentTransaction()
//            ^^^^^^^^^^^ definition local 2
//                        display_name transaction
//                        documentation ```kotlin\n@OptIn(...) local val transaction: Transaction\n```
//                                                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
          if (path.size > 1) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(path)
//                 ^^^^ reference semanticdb maven . . kotlin/Array#getSize().
//                 ^^^^ reference semanticdb maven . . kotlin/Array#size.
//                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
              transaction.throwUnsupportedException("SQLite does not support multiple JSON path arguments")
//            ^^^^^^^^^^^ reference local 2
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          optional?.let {
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().(optional)
//                  ^^^ reference semanticdb maven . . kotlin/let().
//                      ^ definition semanticdb maven . . (it) 2:9
//                        display_name it
//                        documentation ```kotlin\nit: Column<*>\n```
              transaction.throwUnsupportedException("SQLite does not support optional arguments other than a path argument")
//            ^^^^^^^^^^^ reference local 2
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
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
  
      override fun insert(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().
//                        display_name insert
//                        documentation ```kotlin\npublic open override fun insert(ignore: Boolean, table: Table, columns: List<Column<*>>, expr: String, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
          ignore: Boolean,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(ignore)
//               display_name ignore
//               documentation ```kotlin\nignore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
          columns: List<Column<*>>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(columns)
//                display_name columns
//                documentation ```kotlin\ncolumns: List<Column<*>>\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          expr: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          val def = super.insert(false, table, columns, expr, transaction)
//            ^^^ definition local 3
//                display_name def
//                documentation ```kotlin\nlocal val def: String\n```
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(table)
//                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(columns)
//                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(expr)
//                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(transaction)
          return if (ignore) def.replaceFirst("INSERT", "INSERT OR IGNORE") else def
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().(ignore)
//                           ^^^ reference local 3
//                               ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/replaceFirst(+1).
//                                                                               ^^^ reference local 3
      }
  
      override fun replace(
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().
//                         display_name replace
//                         documentation ```kotlin\npublic open override fun replace(table: Table, columns: List<Column<*>>, expression: String, transaction: Transaction, prepared: Boolean): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
          columns: List<Column<*>>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(columns)
//                display_name columns
//                documentation ```kotlin\ncolumns: List<Column<*>>\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          expression: String,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: String\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
          transaction: Transaction,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
          prepared: Boolean
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(prepared)
//                 display_name prepared
//                 documentation ```kotlin\nprepared: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          val insertStatement = super.insert(false, table, columns, expression, transaction)
//            ^^^^^^^^^^^^^^^ definition local 4
//                            display_name insertStatement
//                            documentation ```kotlin\nlocal val insertStatement: String\n```
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(table)
//                                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(columns)
//                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(expression)
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().(transaction)
          return insertStatement.replace("INSERT", "INSERT OR REPLACE")
//               ^^^^^^^^^^^^^^^ reference local 4
//                               ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
      }
  
      override fun upsert(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().
//                        display_name upsert
//                        documentation ```kotlin\npublic open override fun upsert(table: Table, data: List<Pair<Column<*>, Any?>>, expression: String, onUpdate: List<Pair<Column<*>, Any?>>, keyColumns: List<Column<*>>, where: Op<Boolean>?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
          data: List<Pair<Column<*>, Any?>>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(data)
//             display_name data
//             documentation ```kotlin\ndata: List<Pair<Column<*>, Any?>>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          expression: String,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: String\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
          onUpdate: List<Pair<Column<*>, Any?>>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: List<Pair<Column<*>, Any?>>\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          keyColumns: List<Column<*>>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(keyColumns)
//                   display_name keyColumns
//                   documentation ```kotlin\nkeyColumns: List<Column<*>>\n```
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
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
              keyColumns.appendTo(prefix = " (", postfix = ")") { column ->
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(keyColumns)
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                                ^^^^^^ definition semanticdb maven . . (column)
//                                                                       display_name column
//                                                                       documentation ```kotlin\ncolumn: Column<*>\n```
                  append(transaction.identity(column))
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(transaction)
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                            ^^^^^^ reference semanticdb maven . . (column)
              }
          }
  
          +" DO UPDATE SET "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          onUpdate.appendTo { (columnToUpdate, updateExpression) ->
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(onUpdate)
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                               display_name <destruct>
//                                                               documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                             ^^^^^^^^^^^^^^ definition local 5
//                                            display_name columnToUpdate
//                                            documentation ```kotlin\nlocal val columnToUpdate: Column<*>\n```
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                             ^^^^^^^^^^^^^^^^ definition local 6
//                                                              display_name updateExpression
//                                                              documentation ```kotlin\nlocal val updateExpression: Any?\n```
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
              append("${transaction.identity(columnToUpdate)}=")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(transaction)
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                           ^^^^^^^^^^^^^^ reference local 5
              registerArgument(columnToUpdate, updateExpression)
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                             ^^^^^^^^^^^^^^ reference local 5
//                                             ^^^^^^^^^^^^^^^^ reference local 6
          }
  
          where?.let {
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().(where)
//               ^^^ reference semanticdb maven . . kotlin/let().
//                   ^ definition semanticdb maven . . (it) 3:9
//                     display_name it
//                     documentation ```kotlin\nit: Column<*>\n```
              +" WHERE "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              +it
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//             ^^ reference semanticdb maven . . (it)
          }
          toString()
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
      }
  
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
          queryBuilder { +"EXCLUDED.$columnName" }
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insertValue().(queryBuilder)
//                       ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insertValue().(columnName)
      }
  
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
  
      override fun explain(
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().
//                         display_name explain
//                         documentation ```kotlin\npublic open override fun explain(analyze: Boolean, options: String?, internalStatement: String, transaction: Transaction): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
          analyze: Boolean,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(analyze)
//                display_name analyze
//                documentation ```kotlin\nanalyze: Boolean\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          options: String?,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(options)
//                display_name options
//                documentation ```kotlin\noptions: String?\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/String#
          internalStatement: String,
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(internalStatement)
//                          display_name internalStatement
//                          documentation ```kotlin\ninternalStatement: String\n```
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (analyze || options != null) {
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(analyze)
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(options)
              transaction.throwUnsupportedException("SQLite does not support ANALYZE or other options in EXPLAIN queries.")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          val sql = super.explain(false, null, internalStatement, transaction)
//            ^^^ definition local 7
//                display_name sql
//                documentation ```kotlin\nlocal val sql: String\n```
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
//                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(internalStatement)
//                                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().(transaction)
          return sql.replaceFirst("EXPLAIN ", "EXPLAIN QUERY PLAN ")
//               ^^^ reference local 7
//                   ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/replaceFirst(+1).
      }
  
      override fun returning(
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().
//                           display_name returning
//                           documentation ```kotlin\npublic open override fun returning(mainSql: String, returning: List<Expression<*>>, transaction: Transaction): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().
          mainSql: String,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(mainSql)
//                display_name mainSql
//                documentation ```kotlin\nmainSql: String\n```
//                 ^^^^^^ reference semanticdb maven . . kotlin/String#
          returning: List<Expression<*>>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(returning)
//                  display_name returning
//                  documentation ```kotlin\nreturning: List<Expression<*>>\n```
//                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          return with(QueryBuilder(true)) {
//               ^^^^ reference semanticdb maven . . kotlin/with().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
              +"$mainSql RETURNING "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(mainSql)
              returning.appendTo { +it }
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().(returning)
//                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                               ^^^^^^^ definition semanticdb maven . . (it)
//                                       display_name it
//                                       documentation ```kotlin\nit: Column<*>\n```
//                                 ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                  ^^ reference semanticdb maven . . (it)
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
  }
  
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
      override val supportsCreateSequence: Boolean = false
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsCreateSequence().
//                                        display_name supportsCreateSequence
//                                        documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsCreateSequence.
//                                        display_name supportsCreateSequence
//                                        documentation ```kotlin\npublic open override val supportsCreateSequence: Boolean\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      override val supportsMultipleGeneratedKeys: Boolean = false
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsMultipleGeneratedKeys().
//                                               display_name supportsMultipleGeneratedKeys
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsMultipleGeneratedKeys.
//                                               display_name supportsMultipleGeneratedKeys
//                                               documentation ```kotlin\npublic open override val supportsMultipleGeneratedKeys: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      override val supportsCreateSchema: Boolean = false
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsCreateSchema().
//                                      display_name supportsCreateSchema
//                                      documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsCreateSchema.
//                                      display_name supportsCreateSchema
//                                      documentation ```kotlin\npublic open override val supportsCreateSchema: Boolean\n```
//                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      override val supportsWindowFrameGroupsMode: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#getSupportsWindowFrameGroupsMode().
//                                               display_name supportsWindowFrameGroupsMode
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#supportsWindowFrameGroupsMode.
//                                               display_name supportsWindowFrameGroupsMode
//                                               documentation ```kotlin\npublic open override val supportsWindowFrameGroupsMode: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
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
          if (index.indexType != null) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().(index)
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexType().
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexType.
              exposedLogger.warn(
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
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
//                                                                                                               ^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                           display_name it
//                                                                                                                           documentation ```kotlin\nit: Column<*>\n```
//                                                                                                                 ^^ reference semanticdb maven . . (it)
//                                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
              )
              return ""
          }
          val originalCreateIndex = super.createIndex(index.copy(unique = false))
//            ^^^^^^^^^^^^^^^^^^^ definition local 8
//                                display_name originalCreateIndex
//                                documentation ```kotlin\nlocal val originalCreateIndex: String\n```
//                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().
//                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().(index)
//                                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#copy().
          return if (index.unique) {
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().(index)
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
              originalCreateIndex.replace("CREATE INDEX", "CREATE UNIQUE INDEX")
//            ^^^^^^^^^^^^^^^^^^^ reference local 8
//                                ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
          } else {
              originalCreateIndex
//            ^^^^^^^^^^^^^^^^^^^ reference local 8
          }
      }
  
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
          return "DROP INDEX IF EXISTS ${identifierManager.cutIfNecessaryAndQuote(indexName)}"
//                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                                         ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().(indexName)
      }
  
      @OptIn(InternalApi::class)
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
  
      override fun listDatabases(): String = "SELECT name FROM pragma_database_list"
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#listDatabases().
//                               display_name listDatabases
//                               documentation ```kotlin\npublic open override fun listDatabases(): String\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#listDatabases().
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      @OptIn(InternalApi::class)
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
  
      companion object : DialectNameProvider("SQLite")
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#Companion#
//                                                     display_name Companion
//                                                     documentation ```kotlin\npublic final companion object Companion : VendorDialect.DialectNameProvider\n```
//                                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#Companion#`<init>`().
//                                                     display_name Companion
//                                                     documentation ```kotlin\nprivate constructor(): SQLiteDialect.Companion\n```
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
  }
