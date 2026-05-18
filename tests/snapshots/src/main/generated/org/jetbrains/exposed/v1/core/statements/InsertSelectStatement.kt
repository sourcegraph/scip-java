  package org.jetbrains.exposed.v1.core.statements
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
  
  import org.jetbrains.exposed.v1.core.AbstractQuery
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
  import org.jetbrains.exposed.v1.core.Column
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
  import org.jetbrains.exposed.v1.core.IColumnType
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
  import org.jetbrains.exposed.v1.core.Transaction
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#
  /**
   * Represents the SQL statement that uses data retrieved from a [selectQuery] to insert new rows into a table.
   *
   * @param columns Columns to insert the values into.
   * @param selectQuery Source SELECT query that provides the values to insert.
   * @param isIgnore Whether to ignore errors or not.
   * **Note** [isIgnore] is not supported by all vendors. Please check the documentation.
   */
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().
  open class InsertSelectStatement(
//           ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#
//                                 display_name InsertSelectStatement
//                                 documentation ```kotlin\npublic open class InsertSelectStatement : Statement<Int>\n```\n\n----\n\n\n Represents the SQL statement that uses data retrieved from a [selectQuery] to insert new rows into a table.\n\n @param columns Columns to insert the values into.\n @param selectQuery Source SELECT query that provides the values to insert.\n @param isIgnore Whether to ignore errors or not.\n **Note** [isIgnore] is not supported by all vendors. Please check the documentation.\n
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
//           ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().
//                                 display_name InsertSelectStatement
//                                 documentation ```kotlin\npublic constructor(columns: List<Column<*>>, selectQuery: AbstractQuery<*>, isIgnore: Boolean = ...): InsertSelectStatement\n```
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().(columns)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#columns.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getColumns().
      val columns: List<Column<*>>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().(columns)
//                display_name columns
//                documentation ```kotlin\ncolumns: List<Column<*>>\n```
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().(columns)
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#columns.
//                display_name columns
//                documentation ```kotlin\npublic final val columns: List<Column<*>>\n```
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getColumns().
//                display_name columns
//                documentation ```kotlin\npublic get(): List<Column<*>>\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().(columns)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#columns.
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getColumns().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().(selectQuery)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#selectQuery.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getSelectQuery().
      val selectQuery: AbstractQuery<*>,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().(selectQuery)
//                    display_name selectQuery
//                    documentation ```kotlin\nselectQuery: AbstractQuery<*>\n```
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().(selectQuery)
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getSelectQuery().
//                    display_name selectQuery
//                    documentation ```kotlin\npublic get(): AbstractQuery<*>\n```
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#selectQuery.
//                    display_name selectQuery
//                    documentation ```kotlin\npublic final val selectQuery: AbstractQuery<*>\n```
//                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().(selectQuery)
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#selectQuery.
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getSelectQuery().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().(isIgnore)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#isIgnore.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getIsIgnore().
      val isIgnore: Boolean = false
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().(isIgnore)
//                 display_name isIgnore
//                 documentation ```kotlin\nisIgnore: Boolean = ...\n```
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().(isIgnore)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getIsIgnore().
//                 display_name isIgnore
//                 documentation ```kotlin\npublic get(): Boolean\n```
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#isIgnore.
//                 display_name isIgnore
//                 documentation ```kotlin\npublic final val isIgnore: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().(isIgnore)
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#isIgnore.
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getIsIgnore().
  ) : Statement<Int>(StatementType.INSERT, listOf(columns.first().table)) {
//    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
//                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#INSERT.
//                                         ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().(columns)
//                                                        ^^^^^ reference semanticdb maven . . kotlin/collections/first(+19).
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().
  
      init {
          if (columns.isEmpty()) error("Can't insert without provided columns")
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#columns.
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getColumns().
//                    ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#isEmpty().
//                               ^^^^^ reference semanticdb maven . . kotlin/error().
//        ⌄ enclosing_range_start local 0
//                                        ⌄ enclosing_range_start local 1
          val tables = columns.distinctBy { it.table }
//            ^^^^^^ definition local 0
//                   display_name tables
//                   documentation ```kotlin\nlocal val tables: List<Column<*>>\n```
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#columns.
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getColumns().
//                             ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/distinctBy(+9).
//                                        ^^^^^^^^^^^^ definition local 1
//                                                     display_name it
//                                                     documentation ```kotlin\nit: Column<*>\n```
//                                          ^^ reference local 1
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                   ⌃ enclosing_range_end local 0
//                                                   ⌃ enclosing_range_end local 1
//                                                                                              ⌄ enclosing_range_start local 2
          if (tables.count() > 1) error("Can't insert to different tables ${tables.joinToString { it.name }} from single select")
//            ^^^^^^ reference local 0
//                   ^^^^^ reference semanticdb maven . . kotlin/collections/count(+19).
//                           ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                                          ^^^^^^ reference local 0
//                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                              ^^^^^^^^^^^ definition local 2
//                                                                                                          display_name it
//                                                                                                          documentation ```kotlin\nit: Column<*>\n```
//                                                                                                ^^ reference local 2
//                                                                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                                                        ⌃ enclosing_range_end local 2
          if (columns.size != selectQuery.set.fields.size) error("Columns count doesn't equal to query columns count")
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#columns.
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getColumns().
//                    ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                    ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getSelectQuery().
//                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#selectQuery.
//                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getSet().
//                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#set.
//                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#fields.
//                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getFields().
//                                                   ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                                   ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                                         ^^^^^ reference semanticdb maven . . kotlin/error().
      }
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#arguments().
      override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>> = selectQuery.arguments()
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#arguments().
//                           display_name arguments
//                           documentation ```kotlin\npublic open override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>>\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#arguments().
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getSelectQuery().
//                                                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#selectQuery.
//                                                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#arguments().
//                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#arguments().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#prepareSQL().
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#prepareSQL().(transaction)
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#prepareSQL().(prepared)
      override fun prepareSQL(transaction: Transaction, prepared: Boolean): String =
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#prepareSQL().
//                            display_name prepareSQL
//                            documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#prepareSQL().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#prepareSQL().
//                            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#prepareSQL().(transaction)
//                                        display_name transaction
//                                        documentation ```kotlin\ntransaction: Transaction\n```
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#prepareSQL().(prepared)
//                                                               display_name prepared
//                                                               documentation ```kotlin\nprepared: Boolean\n```
//                                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#prepareSQL().(transaction)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#prepareSQL().(prepared)
          transaction.db.dialect.functionProvider.insert(isIgnore, targets.single(), columns, selectQuery.prepareSQL(transaction, prepared), transaction)
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#prepareSQL().(transaction)
//                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getIsIgnore().
//                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#isIgnore.
//                                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getTargets().
//                                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#targets.
//                                                                         ^^^^^^ reference semanticdb maven . . kotlin/collections/single(+19).
//                                                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#columns.
//                                                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getColumns().
//                                                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getSelectQuery().
//                                                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#selectQuery.
//                                                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().
//                                                                                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#prepareSQL().(transaction)
//                                                                                                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#prepareSQL().(prepared)
//                                                                                                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#prepareSQL().(transaction)
//                                                                                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#prepareSQL().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#
