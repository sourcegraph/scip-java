  package org.jetbrains.exposed.v1.core.statements
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
  
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
  import org.jetbrains.exposed.v1.core.vendors.*
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
  
  /**
   * Represents the SQL statement that either inserts a new row into a table, or updates the existing row if insertion would violate a unique constraint.
   *
   * @param table Table to either insert values into or update values from.
   * @param keys (optional) Columns to include in the condition that determines a unique constraint match. If no columns are provided,
   * primary keys will be used. If the table does not have any primary keys, the first unique index will be attempted.
   * @param onUpdateExclude List of specific columns to exclude from updating.
   * If left null, all columns will be updated with the values provided for the insert.
   * @param where Condition that determines which rows to update, if a unique violation is found. This clause may not be supported by all vendors.
   */
  open class UpsertStatement<Key : Any>(
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#
//                           display_name UpsertStatement
//                           documentation ```kotlin\npublic open class UpsertStatement<Key : Any> : InsertStatement<Key>, UpsertBuilder\n```\n\n----\n\n\n Represents the SQL statement that either inserts a new row into a table, or updates the existing row if insertion would violate a unique constraint.\n\n @param table Table to either insert values into or update values from.\n @param keys (optional) Columns to include in the condition that determines a unique constraint match. If no columns are provided,\n primary keys will be used. If the table does not have any primary keys, the first unique index will be attempted.\n @param onUpdateExclude List of specific columns to exclude from updating.\n If left null, all columns will be updated with the values provided for the insert.\n @param where Condition that determines which rows to update, if a unique violation is found. This clause may not be supported by all vendors.\n
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`().
//                           display_name UpsertStatement
//                           documentation ```kotlin\npublic constructor<Key : Any>(table: Table, vararg keys: Column<*>, onUpdateExclude: List<Column<*>>?, where: Op<Boolean>?): UpsertStatement<Key>\n```
//                           ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#[Key]
//                               display_name FirTypeParameterSymbol Key
//                               documentation ```kotlin\nKey : Any\n```
      table: Table,
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`().(table)
//          display_name table
//          documentation ```kotlin\ntable: Table\n```
//           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
      vararg val keys: Column<*>,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`().(keys)
//                    display_name keys
//                    documentation ```kotlin\nvararg keys: Column<*>\n```
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`().(keys)
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getKeys().
//                    display_name keys
//                    documentation ```kotlin\npublic get(): Array<out Column<*>>\n```
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#keys.
//                    display_name keys
//                    documentation ```kotlin\npublic final val keys: Array<out Column<*>>\n```
//                     ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
      val onUpdateExclude: List<Column<*>>?,
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`().(onUpdateExclude)
//                        display_name onUpdateExclude
//                        documentation ```kotlin\nonUpdateExclude: List<Column<*>>?\n```
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`().(onUpdateExclude)
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getOnUpdateExclude().
//                        display_name onUpdateExclude
//                        documentation ```kotlin\npublic get(): List<Column<*>>?\n```
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#onUpdateExclude.
//                        display_name onUpdateExclude
//                        documentation ```kotlin\npublic final val onUpdateExclude: List<Column<*>>?\n```
//                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
      val where: Op<Boolean>?
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`().(where)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getWhere().
//              display_name where
//              documentation ```kotlin\npublic get(): Op<Boolean>?\n```
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#where.
//              display_name where
//              documentation ```kotlin\npublic final val where: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
  ) : InsertStatement<Key>(table), UpsertBuilder {
//    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`().(table)
//                                 ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#
      @Deprecated(
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`(+1). 14:5
//                 display_name UpsertStatement
//                 documentation ```kotlin\n@Deprecated(...) public constructor<Key : Any>(table: Table, vararg keys: Column<*>, onUpdate: List<Pair<Column<*>, Expression<*>>>?, onUpdateExclude: List<Column<*>>?, where: Op<Boolean>?): UpsertStatement<Key>\n```
          "This constructor with `onUpdate` that takes a List may be removed in future releases.",
          level = DeprecationLevel.ERROR
//                                 ^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#ERROR.
      )
      constructor(
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`(+1).(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
          vararg keys: Column<*>,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`(+1).(keys)
//                    display_name keys
//                    documentation ```kotlin\nvararg keys: Column<*>\n```
//                     ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
          onUpdate: List<Pair<Column<*>, Expression<*>>>?,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`(+1).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: List<Pair<Column<*>, Expression<*>>>?\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          onUpdateExclude: List<Column<*>>?,
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`(+1).(onUpdateExclude)
//                        display_name onUpdateExclude
//                        documentation ```kotlin\nonUpdateExclude: List<Column<*>>?\n```
//                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          where: Op<Boolean>?
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`(+1).(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
      ) : this(table, keys = keys, onUpdateExclude, where) {
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`(+1).(table)
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`(+1).(keys)
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`(+1).(onUpdateExclude)
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`(+1).(where)
          onUpdate?.let {
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`(+1).(onUpdate)
//                  ^^^ reference semanticdb maven . . kotlin/let().
//                      ^ definition semanticdb maven . . (it) 2:9
//                        display_name it
//                        documentation ```kotlin\nit: Column<*>\n```
              updateValues.putAll(it)
//            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getUpdateValues().
//            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#updateValues.
//                         ^^^^^^ reference semanticdb maven . . kotlin/collections/putAll(+1).
//                                ^^ reference semanticdb maven . . (it)
          }
      }
  
      @Deprecated("This property will be removed in future releases.", level = DeprecationLevel.ERROR)
//                                                                                              ^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#ERROR.
      var onUpdate: List<Pair<Column<*>, Expression<*>>>? = null
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getOnUpdate().
//                 display_name onUpdate
//                 documentation ```kotlin\npublic get(): List<Pair<Column<*>, Expression<*>>>?\n```
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#onUpdate.
//                 display_name onUpdate
//                 documentation ```kotlin\n@Deprecated(...) public final var onUpdate: List<Pair<Column<*>, Expression<*>>>?\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          private set
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#setOnUpdate().(value)
//                    display_name value
//                    documentation ```kotlin\nvalue: List<Pair<Column<*>, Expression<*>>>?\n```
//                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#setOnUpdate().
//                    display_name onUpdate
//                    documentation ```kotlin\nprivate set(value: List<Pair<Column<*>, Expression<*>>>?): Unit\n```
  
      internal val updateValues: MutableMap<Column<*>, Any?> = LinkedHashMap()
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getUpdateValues().
//                              display_name updateValues
//                              documentation ```kotlin\ninternal get(): MutableMap<Column<*>, Any?>\n```
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#updateValues.
//                              display_name updateValues
//                              documentation ```kotlin\ninternal final val updateValues: MutableMap<Column<*>, Any?>\n```
//                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#
//                                                             ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashMap#`<init>`().
  
      override fun prepareSQL(transaction: Transaction, prepared: Boolean): String {
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#prepareSQL().
//                            display_name prepareSQL
//                            documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().
//                            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#prepareSQL().(transaction)
//                                        display_name transaction
//                                        documentation ```kotlin\ntransaction: Transaction\n```
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#prepareSQL().(prepared)
//                                                               display_name prepared
//                                                               documentation ```kotlin\nprepared: Boolean\n```
//                                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
          val dialect = transaction.db.dialect
//            ^^^^^^^ definition local 0
//                    display_name dialect
//                    documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#prepareSQL().(transaction)
//                                  ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                  ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
          val functionProvider = UpsertBuilder.getFunctionProvider(dialect)
//            ^^^^^^^^^^^^^^^^ definition local 1
//                             display_name functionProvider
//                             documentation ```kotlin\nlocal val functionProvider: FunctionProvider\n```
//                                             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#Companion#getFunctionProvider().
//                                                                 ^^^^^^^ reference local 0
          val keyColumns = if (functionProvider is MysqlFunctionProvider) keys.toList() else getKeyColumns(keys = keys)
//            ^^^^^^^^^^ definition local 2
//                       display_name keyColumns
//                       documentation ```kotlin\nlocal val keyColumns: List<Column<*>>\n```
//                             ^^^^^^^^^^^^^^^^ reference local 1
//                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getKeys().
//                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#keys.
//                                                                             ^^^^^^ reference semanticdb maven . . kotlin/collections/toList().
//                                                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getKeyColumns().
//                                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getKeys().
//                                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#keys.
          val insertValues = arguments!!.first()
//            ^^^^^^^^^^^^ definition local 3
//                         display_name insertValues
//                         documentation ```kotlin\nlocal val insertValues: List<Pair<Column<*>, Any?>>\n```
//                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#arguments.
//                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getArguments().
//                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#setArguments().
//                                       ^^^^^ reference semanticdb maven . . kotlin/collections/first(+19).
          val insertValuesSql = insertValues.toSqlString(prepared)
//            ^^^^^^^^^^^^^^^ definition local 4
//                            display_name insertValuesSql
//                            documentation ```kotlin\nlocal val insertValuesSql: String\n```
//                              ^^^^^^^^^^^^ reference local 3
//                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#toSqlString().
//                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#prepareSQL().(prepared)
          val updateExcludeColumns = (onUpdateExclude ?: emptyList()) + if (dialect is OracleDialect) keyColumns else emptyList()
//            ^^^^^^^^^^^^^^^^^^^^ definition local 5
//                                 display_name updateExcludeColumns
//                                 documentation ```kotlin\nlocal val updateExcludeColumns: List<Column<*>>\n```
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getOnUpdateExclude().
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#onUpdateExclude.
//                                                       ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
//                                                                    ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                                          ^^^^^^^ reference local 0
//                                                                                                    ^^^^^^^^^^ reference local 2
//                                                                                                                    ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
          val updateExpressions = updateValues.takeIf { it.isNotEmpty() }?.toList()
//            ^^^^^^^^^^^^^^^^^ definition local 6
//                              display_name updateExpressions
//                              documentation ```kotlin\nlocal val updateExpressions: List<Pair<Column<*>, Any?>>\n```
//                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getUpdateValues().
//                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#updateValues.
//                                             ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                                    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                        display_name it
//                                                                        documentation ```kotlin\nit: Column<*>\n```
//                                                      ^^ reference semanticdb maven . . (it)
//                                                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+10).
//                                                                         ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+11).
              ?: getUpdateExpressions(insertValues.unzip().first, updateExcludeColumns, keyColumns)
//               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getUpdateExpressions().
//                                    ^^^^^^^^^^^^ reference local 3
//                                                 ^^^^^ reference semanticdb maven . . kotlin/collections/unzip(+1).
//                                                         ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                         ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                                ^^^^^^^^^^^^^^^^^^^^ reference local 5
//                                                                                      ^^^^^^^^^^ reference local 2
          return functionProvider.upsert(table, insertValues, insertValuesSql, updateExpressions, keyColumns, where, transaction)
//               ^^^^^^^^^^^^^^^^ reference local 1
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getTable().
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#table.
//                                              ^^^^^^^^^^^^ reference local 3
//                                                            ^^^^^^^^^^^^^^^ reference local 4
//                                                                             ^^^^^^^^^^^^^^^^^ reference local 6
//                                                                                                ^^^^^^^^^^ reference local 2
//                                                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getWhere().
//                                                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#where.
//                                                                                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#prepareSQL().(transaction)
      }
  
      override fun arguments(): List<Iterable<Pair<IColumnType<*>, Any?>>> {
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#arguments().
//                           display_name arguments
//                           documentation ```kotlin\npublic open override fun arguments(): List<Iterable<Pair<IColumnType<*>, Any?>>>\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments(+1).
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          val additionalArgs = getAdditionalArgs(updateValues, where)
//            ^^^^^^^^^^^^^^ definition local 7
//                           display_name additionalArgs
//                           documentation ```kotlin\nlocal val additionalArgs: List<Pair<IColumnType<*>, Any?>>\n```
//                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getAdditionalArgs().
//                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getUpdateValues().
//                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#updateValues.
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getWhere().
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#where.
          return super.arguments().map {
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments().
//                                 ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                     ^ definition semanticdb maven . . (it) 2:9
//                                       display_name it
//                                       documentation ```kotlin\nit: Column<*>\n```
              it + additionalArgs
//            ^^ reference semanticdb maven . . (it)
//               ^ reference semanticdb maven . . kotlin/collections/plus(+31).
//                 ^^^^^^^^^^^^^^ reference local 7
          }
      }
  }
  
  /**
   * Common interface for building SQL statements that either insert a new row into a table,
   * or update the existing row if insertion would violate a unique constraint.
   */
  sealed interface UpsertBuilder {
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#
//                               display_name UpsertBuilder
//                               documentation ```kotlin\npublic sealed interface UpsertBuilder : Any\n```\n\n----\n\n\n Common interface for building SQL statements that either insert a new row into a table,\n or update the existing row if insertion would violate a unique constraint.\n
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#
      /**
       * Calls the specified function [onUpdate] with an [UpdateStatement] as its argument,
       * allowing values to be stored as part of the UPDATE clause of the upsert statement associated with this builder.
       */
      fun storeUpdateValues(onUpdate: UpsertBuilder.(UpdateStatement) -> Unit) {
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#storeUpdateValues().
//                          display_name storeUpdateValues
//                          documentation ```kotlin\npublic open fun storeUpdateValues(onUpdate: UpsertBuilder.(UpdateStatement) -> Unit): Unit\n```\n\n----\n\n\n Calls the specified function [onUpdate] with an [UpdateStatement] as its argument,\n allowing values to be stored as part of the UPDATE clause of the upsert statement associated with this builder.\n
//                          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#storeUpdateValues().(onUpdate)
//                                   display_name onUpdate
//                                   documentation ```kotlin\nonUpdate: UpsertBuilder.(UpdateStatement) -> Unit\n```
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
          val arguments = UpdateStatement((this as InsertStatement<*>).table, null).apply {
//            ^^^^^^^^^ definition local 8
//                      display_name arguments
//                      documentation ```kotlin\nlocal val arguments: List<Pair<Column<*>, Any?>>\n```
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#`<init>`().
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getTable().
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#table.
//                                                                                  ^^^^^ reference semanticdb maven . . kotlin/apply().
              onUpdate.invoke(this@UpsertBuilder, this)
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#storeUpdateValues().(onUpdate)
//                     ^^^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
          }.firstDataSet
//          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#firstDataSet.
//          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getFirstDataSet().
          when (this) {
              is UpsertStatement<*> -> updateValues.putAll(arguments)
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#getUpdateValues().
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#updateValues.
//                                                  ^^^^^^ reference semanticdb maven . . kotlin/collections/putAll(+1).
//                                                         ^^^^^^^^^ reference local 8
              is BatchUpsertStatement -> updateValues.putAll(arguments)
//                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#getUpdateValues().
//                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#updateValues.
//                                                    ^^^^^^ reference semanticdb maven . . kotlin/collections/putAll(+1).
//                                                           ^^^^^^^^^ reference local 8
          }
      }
  
      /**
       * Specifies that this column should be updated using the same values that would be inserted if there was
       * no violation of a unique constraint in an upsert statement.
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.UpsertTests.testUpsertWithManualUpdateUsingInsertValues
       */
      fun <T> insertValue(column: Column<T>): ExpressionWithColumnType<T> = InsertValue(column, column.columnType)
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#insertValue().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#insertValue().
//                        display_name insertValue
//                        documentation ```kotlin\npublic open fun <T> insertValue(column: Column<T>): ExpressionWithColumnType<T>\n```\n\n----\n\n\n Specifies that this column should be updated using the same values that would be inserted if there was\n no violation of a unique constraint in an upsert statement.\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.UpsertTests.testUpsertWithManualUpdateUsingInsertValues\n
//                        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#insertValue().(column)
//                               display_name column
//                               documentation ```kotlin\ncolumn: Column<T>\n```
//                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#`<init>`().
//                                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#insertValue().(column)
//                                                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#insertValue().(column)
//                                                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
  
      @OptIn(InternalApi::class)
      private class InsertValue<T>(
//                  ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#
//                              display_name InsertValue
//                              documentation ```kotlin\n@OptIn(...) private final class InsertValue<T> : ExpressionWithColumnType<T>\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                  ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#`<init>`().
//                              display_name InsertValue
//                              documentation ```kotlin\npublic constructor<T>(column: Column<T>, columnType: IColumnType<T & Any>): UpsertBuilder.InsertValue<T>\n```
//                              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#[T]
//                                display_name FirTypeParameterSymbol T
//                                documentation ```kotlin\nT\n```
          val column: Column<T>,
//            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#`<init>`().(column)
//                   display_name column
//                   documentation ```kotlin\ncolumn: Column<T>\n```
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#`<init>`().(column)
//            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#column.
//                   display_name column
//                   documentation ```kotlin\npublic final val column: Column<T>\n```
//            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#getColumn().
//                   display_name column
//                   documentation ```kotlin\npublic get(): Column<T>\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          override val columnType: IColumnType<T & Any>
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#`<init>`().(columnType)
//                                display_name columnType
//                                documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#`<init>`().(columnType)
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#columnType.
//                                display_name columnType
//                                documentation ```kotlin\npublic open override val columnType: IColumnType<T & Any>\n```
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#getColumnType().
//                                display_name columnType
//                                documentation ```kotlin\npublic get(): IColumnType<T & Any>\n```
//                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
      ) : ExpressionWithColumnType<T>() {
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
          override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//                     ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#toQueryBuilder().
//                                    display_name toQueryBuilder
//                                    documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toQueryBuilder().
//                                    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#toQueryBuilder().(queryBuilder)
//                                                 display_name queryBuilder
//                                                 documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
              val transaction = CoreTransactionManager.currentTransaction()
//                ^^^^^^^^^^^ definition local 9
//                            display_name transaction
//                            documentation ```kotlin\nlocal val transaction: Transaction\n```
//                                                     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
              val functionProvider = getFunctionProvider(transaction.db.dialect)
//                ^^^^^^^^^^^^^^^^ definition local 10
//                                 display_name functionProvider
//                                 documentation ```kotlin\nlocal val functionProvider: FunctionProvider\n```
//                                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#Companion#getFunctionProvider().
//                                                       ^^^^^^^^^^^ reference local 9
//                                                                   ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                                   ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
              functionProvider.insertValue(transaction.identity(column), queryBuilder)
//            ^^^^^^^^^^^^^^^^ reference local 10
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insertValue().
//                                         ^^^^^^^^^^^ reference local 9
//                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#column.
//                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#getColumn().
//                                                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#toQueryBuilder().(queryBuilder)
          }
      }
  
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#Companion# 9:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```\n\n----\n\n Returns the [FunctionProvider] for valid upsert statement syntax.
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#Companion#`<init>`(). 9:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): UpsertBuilder.Companion\n```\n\n----\n\n Returns the [FunctionProvider] for valid upsert statement syntax.
          /** Returns the [FunctionProvider] for valid upsert statement syntax. */
          fun getFunctionProvider(dialect: DatabaseDialect): FunctionProvider = when (dialect) {
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#Companion#getFunctionProvider().
//                                display_name getFunctionProvider
//                                documentation ```kotlin\npublic final fun getFunctionProvider(dialect: DatabaseDialect): FunctionProvider\n```\n\n----\n\n Returns the [FunctionProvider] for valid upsert statement syntax.
//                                ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#Companion#getFunctionProvider().(dialect)
//                                        display_name dialect
//                                        documentation ```kotlin\ndialect: DatabaseDialect\n```
//                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
//                                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
//                                                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#Companion#getFunctionProvider().(dialect)
              is H2Dialect -> when (dialect.h2Mode) {
//                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#Companion#getFunctionProvider().(dialect)
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode().
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode.
                  H2Dialect.H2CompatibilityMode.MariaDB, H2Dialect.H2CompatibilityMode.MySQL -> MysqlFunctionProvider.INSTANCE
//                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MariaDB.
//                                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MySQL.
//                                                                                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#INSTANCE.
//                                                                                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#getINSTANCE().
                  else -> H2FunctionProvider
              }
              else -> dialect.functionProvider
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#Companion#getFunctionProvider().(dialect)
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
          }
      }
  }
  
  /** Returns the columns to be used in the conflict condition of an upsert statement. */
  internal fun UpsertBuilder.getKeyColumns(vararg keys: Column<*>): List<Column<*>> {
//                           ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getKeyColumns().
//                                         display_name getKeyColumns
//                                         documentation ```kotlin\ninternal final fun UpsertBuilder.getKeyColumns(vararg keys: Column<*>): List<Column<*>>\n```\n\n----\n\n Returns the columns to be used in the conflict condition of an upsert statement.
//                                                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getKeyColumns().(keys)
//                                                     display_name keys
//                                                     documentation ```kotlin\nvararg keys: Column<*>\n```
//                                                      ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
      this as InsertStatement<*>
      return keys.toList().ifEmpty {
//           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getKeyColumns().(keys)
//                ^^^^^^ reference semanticdb maven . . kotlin/collections/toList().
//                         ^^^^^^^ reference semanticdb maven . . kotlin/collections/ifEmpty(+1).
          table.primaryKey?.columns?.toList() ?: table.indices.firstOrNull { it.unique }?.columns
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getTable().
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#table.
//              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                                   ^^^^^^ reference semanticdb maven . . kotlin/collections/toList().
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getTable().
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#table.
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getIndices().
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#indices.
//                                                             ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+20).
//                                                                         ^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                       display_name it
//                                                                                       documentation ```kotlin\nit: Column<*>\n```
//                                                                           ^^ reference semanticdb maven . . (it)
//                                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
//                                                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                                                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
      } ?: emptyList()
//         ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
  }
  
  /** Returns the expressions to be used in the update clause of an upsert statement, along with their insert column reference. */
  internal fun UpsertBuilder.getUpdateExpressions(
//                           ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getUpdateExpressions().
//                                                display_name getUpdateExpressions
//                                                documentation ```kotlin\ninternal final fun UpsertBuilder.getUpdateExpressions(dataColumns: List<Column<*>>, toExclude: List<Column<*>>?, keyColumns: List<Column<*>>?): List<Pair<Column<*>, Any?>>\n```\n\n----\n\n Returns the expressions to be used in the update clause of an upsert statement, along with their insert column reference.
      dataColumns: List<Column<*>>,
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getUpdateExpressions().(dataColumns)
//                display_name dataColumns
//                documentation ```kotlin\ndataColumns: List<Column<*>>\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
      toExclude: List<Column<*>>?,
//    ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getUpdateExpressions().(toExclude)
//              display_name toExclude
//              documentation ```kotlin\ntoExclude: List<Column<*>>?\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
      keyColumns: List<Column<*>>?
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getUpdateExpressions().(keyColumns)
//               display_name keyColumns
//               documentation ```kotlin\nkeyColumns: List<Column<*>>?\n```
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
  ): List<Pair<Column<*>, Any?>> {
//   ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
      val updateColumns = toExclude?.let { dataColumns - it } ?: dataColumns
//        ^^^^^^^^^^^^^ definition local 11
//                      display_name updateColumns
//                      documentation ```kotlin\nlocal val updateColumns: List<Column<*>>\n```
//                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getUpdateExpressions().(toExclude)
//                                   ^^^ reference semanticdb maven . . kotlin/let().
//                                       ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                            display_name it
//                                                            documentation ```kotlin\nit: Column<*>\n```
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getUpdateExpressions().(dataColumns)
//                                                     ^ reference semanticdb maven . . kotlin/collections/minus(+2).
//                                                       ^^ reference semanticdb maven . . (it)
//                                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getUpdateExpressions().(dataColumns)
      val updateColumnsWithoutKeys = keyColumns?.let { keys ->
//        ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 12
//                                 display_name updateColumnsWithoutKeys
//                                 documentation ```kotlin\nlocal val updateColumnsWithoutKeys: List<Column<*>>\n```
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getUpdateExpressions().(keyColumns)
//                                               ^^^ reference semanticdb maven . . kotlin/let().
//                                                     ^^^^ definition semanticdb maven . . (keys)
//                                                          display_name keys
//                                                          documentation ```kotlin\nkeys: List<Column<*>>\n```
          updateColumns.filter { it !in keys }.ifEmpty { updateColumns }
//        ^^^^^^^^^^^^^ reference local 11
//                      ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                             ^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                             display_name it
//                                             documentation ```kotlin\nit: Column<*>\n```
//                               ^^ reference semanticdb maven . . (it)
//                                  ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                                  ^^^ reference semanticdb maven . . kotlin/collections/List#contains().
//                                      ^^^^ reference semanticdb maven . . (keys)
//                                             ^^^^^^^ reference semanticdb maven . . kotlin/collections/ifEmpty(+1).
//                                                       ^^^^^^^^^^^^^ reference local 11
      } ?: updateColumns
//         ^^^^^^^^^^^^^ reference local 11
      return updateColumnsWithoutKeys.zip(updateColumnsWithoutKeys.map { insertValue(it) })
//           ^^^^^^^^^^^^^^^^^^^^^^^^ reference local 12
//                                    ^^^ reference semanticdb maven . . kotlin/collections/zip(+54).
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^ reference local 12
//                                                                 ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                                     ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                         display_name it
//                                                                                         documentation ```kotlin\nit: Column<*>\n```
//                                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#insertValue().
//                                                                                   ^^ reference semanticdb maven . . (it)
  }
  
  /** Returns the arguments used in the UPDATE and WHERE clauses for this UPSERT statement. */
  internal fun UpsertBuilder.getAdditionalArgs(
//                           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getAdditionalArgs().
//                                             display_name getAdditionalArgs
//                                             documentation ```kotlin\ninternal final fun UpsertBuilder.getAdditionalArgs(updateValues: Map<Column<*>, Any?>, where: Op<Boolean>?): List<Pair<IColumnType<*>, Any?>>\n```\n\n----\n\n Returns the arguments used in the UPDATE and WHERE clauses for this UPSERT statement.
      updateValues: Map<Column<*>, Any?>,
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getAdditionalArgs().(updateValues)
//                 display_name updateValues
//                 documentation ```kotlin\nupdateValues: Map<Column<*>, Any?>\n```
//                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
      where: Op<Boolean>?
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getAdditionalArgs().(where)
//          display_name where
//          documentation ```kotlin\nwhere: Op<Boolean>?\n```
//           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
  ): List<Pair<IColumnType<*>, Any?>> {
//   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
      val noAliasExpressionRequired = when (val dialect = currentDialect) {
//        ^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 13
//                                  display_name noAliasExpressionRequired
//                                  documentation ```kotlin\nlocal val noAliasExpressionRequired: Boolean\n```
//                                              ^^^^^^^ definition local 14
//                                                      display_name dialect
//                                                      documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
          is SQLServerDialect, is OracleDialect -> false
          is H2Dialect -> dialect.h2Mode in listOf(H2Dialect.H2CompatibilityMode.MySQL, H2Dialect.H2CompatibilityMode.MariaDB)
//                        ^^^^^^^ reference local 14
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode().
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode.
//                                       ^^ reference semanticdb maven . . kotlin/collections/contains(+9).
//                                          ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf(+1).
//                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MySQL.
//                                                                                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MariaDB.
          else -> true
      }
      return QueryBuilder(true).apply {
//           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                              ^^^^^ reference semanticdb maven . . kotlin/apply().
          updateValues.forEach { (column, value) ->
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getAdditionalArgs().(updateValues)
//                     ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                               ^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                               display_name <destruct>
//                                               documentation ```kotlin\n<destruct>: Map.Entry<Column<*>, Any?>\n```
//                                ^^^^^^ definition local 15
//                                       display_name column
//                                       documentation ```kotlin\nlocal val column: Column<*>\n```
//                                ^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                ^^^^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                        ^^^^^ definition local 16
//                                              display_name value
//                                              documentation ```kotlin\nlocal val value: Any?\n```
//                                        ^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                        ^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
              if (noAliasExpressionRequired || value is QueryParameter<*> || value !is Expression<*>) {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 13
//                                             ^^^^^ reference local 16
//                                                                           ^^^^^ reference local 16
                  registerArgument(column, value)
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                                 ^^^^^^ reference local 15
//                                         ^^^^^ reference local 16
              }
          }
          where?.toQueryBuilder(this)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getAdditionalArgs().(where)
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
      }.args
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#args.
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getArgs().
  }
