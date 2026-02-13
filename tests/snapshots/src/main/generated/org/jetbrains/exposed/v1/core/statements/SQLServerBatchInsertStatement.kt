  package org.jetbrains.exposed.v1.core.statements
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
  
  import org.jetbrains.exposed.v1.core.InternalApi
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/InternalApi#
  import org.jetbrains.exposed.v1.core.QueryBuilder
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
  import org.jetbrains.exposed.v1.core.Table
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
  import org.jetbrains.exposed.v1.core.Transaction
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
  import org.jetbrains.exposed.v1.core.autoIncColumnType
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
  
  private const val OUTPUT_ROW_LIMIT = 1000
//                  ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/OUTPUT_ROW_LIMIT.
//                                   display_name OUTPUT_ROW_LIMIT
//                                   documentation ```kotlin\nprivate final const val OUTPUT_ROW_LIMIT: Int\n```
//                  ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getOUTPUT_ROW_LIMIT().
//                                   display_name OUTPUT_ROW_LIMIT
//                                   documentation ```kotlin\nprivate get(): Int\n```
  
  /**
   * Represents the SQL statement that batch inserts new rows into a table, specifically for the SQL Server database.
   *
   * Before adding each new batch, the class validates that the database's maximum number of inserted rows (1000)
   * is not being exceeded.
   */
  open class SQLServerBatchInsertStatement(
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#
//                                         display_name SQLServerBatchInsertStatement
//                                         documentation ```kotlin\npublic open class SQLServerBatchInsertStatement : BatchInsertStatement\n```\n\n----\n\n\n Represents the SQL statement that batch inserts new rows into a table, specifically for the SQL Server database.\n\n Before adding each new batch, the class validates that the database's maximum number of inserted rows (1000)\n is not being exceeded.\n
//                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#`<init>`().
//                                         display_name SQLServerBatchInsertStatement
//                                         documentation ```kotlin\npublic constructor(table: Table, ignore: Boolean = ..., shouldReturnGeneratedValues: Boolean = ...): SQLServerBatchInsertStatement\n```
      table: Table,
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#`<init>`().(table)
//          display_name table
//          documentation ```kotlin\ntable: Table\n```
//           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
      ignore: Boolean = false,
//    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#`<init>`().(ignore)
//           display_name ignore
//           documentation ```kotlin\nignore: Boolean = ...\n```
//            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      shouldReturnGeneratedValues: Boolean = true
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#`<init>`().(shouldReturnGeneratedValues)
//                                display_name shouldReturnGeneratedValues
//                                documentation ```kotlin\nshouldReturnGeneratedValues: Boolean = ...\n```
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  ) : BatchInsertStatement(table, ignore, shouldReturnGeneratedValues) {
//    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#`<init>`().(table)
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#`<init>`().(ignore)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#`<init>`().(shouldReturnGeneratedValues)
      @OptIn(InternalApi::class)
      override fun validateLastBatch() {
//                 ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#validateLastBatch().
//                                   display_name validateLastBatch
//                                   documentation ```kotlin\n@OptIn(...) public open override fun validateLastBatch(): Unit\n```
//                                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#validateLastBatch().
          super.validateLastBatch()
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#validateLastBatch().
          if (data.size > OUTPUT_ROW_LIMIT) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//                 ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#getSize().
//                 ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size.
//                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/OUTPUT_ROW_LIMIT.
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getOUTPUT_ROW_LIMIT().
              throw BatchDataInconsistentException("Too much rows in one batch. Exceed $OUTPUT_ROW_LIMIT limit")
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchDataInconsistentException#`<init>`().
//                                                                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/OUTPUT_ROW_LIMIT.
//                                                                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getOUTPUT_ROW_LIMIT().
          }
      }
  
      @InternalApi
      val columnToReturnValue = table.autoIncColumn?.takeIf {
//        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#columnToReturnValue.
//                            display_name columnToReturnValue
//                            documentation ```kotlin\n@InternalApi() public final val columnToReturnValue: Column<*>?\n```
//        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#getColumnToReturnValue().
//                            display_name columnToReturnValue
//                            documentation ```kotlin\npublic get(): Column<*>?\n```
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#`<init>`().(table)
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncColumn.
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getAutoIncColumn().
//                                                   ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                                          ^ definition semanticdb maven . . (it) 2:5
//                                                            display_name it
//                                                            documentation ```kotlin\nit: List<Pair<IColumnType<*>, Any?>>\n```
          shouldReturnGeneratedValues && it.autoIncColumnType?.nextValExpression == null
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#`<init>`().(shouldReturnGeneratedValues)
//                                       ^^ reference semanticdb maven . . (it)
//                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getNextValExpression().
//                                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#nextValExpression.
      }
  
      override fun prepareSQL(transaction: Transaction, prepared: Boolean): String {
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#prepareSQL().
//                            display_name prepareSQL
//                            documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().
//                            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#prepareSQL().(transaction)
//                                        display_name transaction
//                                        documentation ```kotlin\ntransaction: Transaction\n```
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#prepareSQL().(prepared)
//                                                               display_name prepared
//                                                               documentation ```kotlin\nprepared: Boolean\n```
//                                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
          val values = arguments!!
//            ^^^^^^ definition local 0
//                   display_name values
//                   documentation ```kotlin\nlocal val values: List<List<Pair<Column<*>, Any?>>>\n```
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#arguments.
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getArguments().
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#setArguments().
          val sql = if (values.isEmpty()) {
//            ^^^ definition local 1
//                display_name sql
//                documentation ```kotlin\nlocal val sql: String\n```
//                      ^^^^^^ reference local 0
//                             ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#isEmpty().
              ""
          } else {
              @OptIn(InternalApi::class)
              val output = columnToReturnValue?.let {
//                ^^^^^^ definition local 2
//                       display_name output
//                       documentation ```kotlin\n@OptIn(...) local val output: String\n```
//                         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#columnToReturnValue.
//                         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#getColumnToReturnValue().
//                                              ^^^ reference semanticdb maven . . kotlin/let().
//                                                  ^ definition semanticdb maven . . (it) 2:13
//                                                    display_name it
//                                                    documentation ```kotlin\nit: List<Pair<IColumnType<*>, Any?>>\n```
                  " OUTPUT inserted.${transaction.identity(it)} AS GENERATED_KEYS"
//                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#prepareSQL().(transaction)
//                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                         ^^ reference semanticdb maven . . (it)
              }.orEmpty()
//              ^^^^^^^ reference semanticdb maven . . kotlin/text/orEmpty().
  
              QueryBuilder(prepared).apply {
//            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#prepareSQL().(prepared)
//                                   ^^^^^ reference semanticdb maven . . kotlin/apply().
                  values.appendTo(prefix = "$output VALUES") {
//                ^^^^^^ reference local 0
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                           ^^^^^^ reference local 2
//                                                           ^ definition semanticdb maven . . (it) 4:17
//                                                             display_name it
//                                                             documentation ```kotlin\nit: List<Pair<IColumnType<*>, Any?>>\n```
                      it.appendTo(prefix = "(", postfix = ")") { (col, value) ->
//                    ^^ reference semanticdb maven . . (it)
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                               ^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                                            display_name <destruct>
//                                                                            documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                                                ^^^ definition local 3
//                                                                    display_name col
//                                                                    documentation ```kotlin\nlocal val col: Column<*>\n```
//                                                                ^^^ reference semanticdb maven . . (`<destruct>`)
//                                                                ^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                                     ^^^^^ definition local 4
//                                                                           display_name value
//                                                                           documentation ```kotlin\nlocal val value: Any?\n```
//                                                                     ^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                                     ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
                          registerArgument(col, value)
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                                         ^^^ reference local 3
//                                              ^^^^^ reference local 4
                      }
                  }
              }.toString()
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
          return transaction.db.dialect.functionProvider.insert(isIgnore, table, values.firstOrNull()?.map { it.first }.orEmpty(), sql, transaction)
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#prepareSQL().(transaction)
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getIsIgnore().
//                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#isIgnore.
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getTable().
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#table.
//                                                                               ^^^^^^ reference local 0
//                                                                                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+19).
//                                                                                                     ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                                                                         ^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                      display_name it
//                                                                                                                      documentation ```kotlin\nit: List<Pair<IColumnType<*>, Any?>>\n```
//                                                                                                           ^^ reference semanticdb maven . . (it)
//                                                                                                              ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                                                                              ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                                                                                      ^^^^^^^ reference semanticdb maven . . kotlin/collections/orEmpty(+2).
//                                                                                                                                 ^^^ reference local 1
//                                                                                                                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#prepareSQL().(transaction)
      }
  
      override fun arguments() = listOfNotNull(
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#arguments().
//                           display_name arguments
//                           documentation ```kotlin\npublic open override fun arguments(): List<List<Pair<IColumnType<*>, Any?>>>\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments(+1).
//                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/listOfNotNull().
          @OptIn(InternalApi::class)
          super.arguments().flatten().takeIf { data.isNotEmpty() }
//              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#arguments().
//                          ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatten(+1).
//                                    ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                           ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                 display_name it
//                                                                 documentation ```kotlin\nit: List<Pair<IColumnType<*>, Any?>>\n```
//                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//                                                  ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
      )
  }
