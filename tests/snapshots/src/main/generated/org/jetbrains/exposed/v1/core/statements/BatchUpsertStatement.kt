package org.jetbrains.exposed.v1.core.statements
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/

import org.jetbrains.exposed.v1.core.Column
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
import org.jetbrains.exposed.v1.core.Expression
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
import org.jetbrains.exposed.v1.core.IColumnType
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
import org.jetbrains.exposed.v1.core.Op
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
import org.jetbrains.exposed.v1.core.Table
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
import org.jetbrains.exposed.v1.core.Transaction
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
import org.jetbrains.exposed.v1.core.vendors.MysqlFunctionProvider
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#
import org.jetbrains.exposed.v1.core.vendors.OracleDialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#

/**
 * Represents the SQL statement that either batch inserts new rows into a table, or updates the existing rows if insertions violate unique constraints.
 *
 * @param table Table to either insert values into or update values from.
 * @param keys (optional) Columns to include in the condition that determines a unique constraint match. If no columns are provided,
 * primary keys will be used. If the table does not have any primary keys, the first unique index will be attempted.
 * @param onUpdateExclude List of specific columns to exclude from updating.
 * If left null, all columns will be updated with the values provided for the insert.
 * @param where Condition that determines which rows to update, if a unique violation is found. This clause may not be supported by all vendors.
 * @param shouldReturnGeneratedValues Specifies whether newly generated values (for example, auto-incremented IDs) should be returned.
 * See [Batch Insert](https://github.com/JetBrains/Exposed/wiki/DSL#batch-insert) for more details.
 */
open class BatchUpsertStatement(
//         ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#
//                              display_name BatchUpsertStatement
//                              documentation ```kotlin\npublic open class BatchUpsertStatement : BatchInsertStatement, UpsertBuilder\n```\n\n----\n\n\n Represents the SQL statement that either batch inserts new rows into a table, or updates the existing rows if insertions violate unique constraints.\n\n @param table Table to either insert values into or update values from.\n @param keys (optional) Columns to include in the condition that determines a unique constraint match. If no columns are provided,\n primary keys will be used. If the table does not have any primary keys, the first unique index will be attempted.\n @param onUpdateExclude List of specific columns to exclude from updating.\n If left null, all columns will be updated with the values provided for the insert.\n @param where Condition that determines which rows to update, if a unique violation is found. This clause may not be supported by all vendors.\n @param shouldReturnGeneratedValues Specifies whether newly generated values (for example, auto-incremented IDs) should be returned.\n See [Batch Insert](https://github.com/JetBrains/Exposed/wiki/DSL#batch-insert) for more details.\n
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#
//         ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`().
//                              display_name BatchUpsertStatement
//                              documentation ```kotlin\npublic constructor(table: Table, vararg keys: Column<*>, onUpdateExclude: List<Column<*>>?, where: Op<Boolean>?, shouldReturnGeneratedValues: Boolean = ...): BatchUpsertStatement\n```
    table: Table,
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`().(table)
//        display_name table
//        documentation ```kotlin\ntable: Table\n```
//         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
    vararg val keys: Column<*>,
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`().(keys)
//                  display_name keys
//                  documentation ```kotlin\nvararg keys: Column<*>\n```
//             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`().(keys)
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#getKeys().
//                  display_name keys
//                  documentation ```kotlin\npublic get(): Array<out Column<*>>\n```
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#keys.
//                  display_name keys
//                  documentation ```kotlin\npublic final val keys: Array<out Column<*>>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
    val onUpdateExclude: List<Column<*>>?,
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`().(onUpdateExclude)
//                      display_name onUpdateExclude
//                      documentation ```kotlin\nonUpdateExclude: List<Column<*>>?\n```
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`().(onUpdateExclude)
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#getOnUpdateExclude().
//                      display_name onUpdateExclude
//                      documentation ```kotlin\npublic get(): List<Column<*>>?\n```
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#onUpdateExclude.
//                      display_name onUpdateExclude
//                      documentation ```kotlin\npublic final val onUpdateExclude: List<Column<*>>?\n```
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
    val where: Op<Boolean>?,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`().(where)
//            display_name where
//            documentation ```kotlin\nwhere: Op<Boolean>?\n```
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`().(where)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#getWhere().
//            display_name where
//            documentation ```kotlin\npublic get(): Op<Boolean>?\n```
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#where.
//            display_name where
//            documentation ```kotlin\npublic final val where: Op<Boolean>?\n```
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
    shouldReturnGeneratedValues: Boolean = true
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`().(shouldReturnGeneratedValues)
//                              display_name shouldReturnGeneratedValues
//                              documentation ```kotlin\nshouldReturnGeneratedValues: Boolean = ...\n```
//                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
) : BatchInsertStatement(table, ignore = false, shouldReturnGeneratedValues), UpsertBuilder {
//  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`().(table)
//                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`().(shouldReturnGeneratedValues)
//                                                                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#
    @Deprecated(
//  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`(+1). 15:5
//               display_name BatchUpsertStatement
//               documentation ```kotlin\n@Deprecated(...) public constructor(table: Table, vararg keys: Column<*>, onUpdate: List<Pair<Column<*>, Expression<*>>>?, onUpdateExclude: List<Column<*>>?, where: Op<Boolean>?, shouldReturnGeneratedValues: Boolean): BatchUpsertStatement\n```
        "This constructor with `onUpdate` that takes a List may be removed in future releases.",
        level = DeprecationLevel.ERROR
//                               ^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#ERROR.
    )
    constructor(
        table: Table,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`(+1).(table)
//            display_name table
//            documentation ```kotlin\ntable: Table\n```
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
        vararg keys: Column<*>,
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`(+1).(keys)
//                  display_name keys
//                  documentation ```kotlin\nvararg keys: Column<*>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
        onUpdate: List<Pair<Column<*>, Expression<*>>>?,
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`(+1).(onUpdate)
//               display_name onUpdate
//               documentation ```kotlin\nonUpdate: List<Pair<Column<*>, Expression<*>>>?\n```
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        onUpdateExclude: List<Column<*>>?,
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`(+1).(onUpdateExclude)
//                      display_name onUpdateExclude
//                      documentation ```kotlin\nonUpdateExclude: List<Column<*>>?\n```
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        where: Op<Boolean>?,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`(+1).(where)
//            display_name where
//            documentation ```kotlin\nwhere: Op<Boolean>?\n```
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
        shouldReturnGeneratedValues: Boolean
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`(+1).(shouldReturnGeneratedValues)
//                                  display_name shouldReturnGeneratedValues
//                                  documentation ```kotlin\nshouldReturnGeneratedValues: Boolean\n```
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    ) : this(table, keys = keys, onUpdateExclude, where, shouldReturnGeneratedValues) {
//           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`(+1).(table)
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`(+1).(keys)
//                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`(+1).(onUpdateExclude)
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`(+1).(where)
//                                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`(+1).(shouldReturnGeneratedValues)
        onUpdate?.let {
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`(+1).(onUpdate)
//                ^^^ reference semanticdb maven . . kotlin/let().
//                    ^ definition semanticdb maven . . (it) 2:9
//                      display_name it
//                      documentation ```kotlin\nit: Iterable<Pair<IColumnType<*>, Any?>>\n```
            updateValues.putAll(it)
//          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#getUpdateValues().
//          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#updateValues.
//                       ^^^^^^ reference semanticdb maven . . kotlin/collections/putAll(+1).
//                              ^^ reference semanticdb maven . . (it)
        }
    }

    @Deprecated("This property will be removed in future releases.", level = DeprecationLevel.ERROR)
//                                                                                            ^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#ERROR.
    var onUpdate: List<Pair<Column<*>, Expression<*>>>? = null
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#getOnUpdate().
//               display_name onUpdate
//               documentation ```kotlin\npublic get(): List<Pair<Column<*>, Expression<*>>>?\n```
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#onUpdate.
//               display_name onUpdate
//               documentation ```kotlin\n@Deprecated(...) public final var onUpdate: List<Pair<Column<*>, Expression<*>>>?\n```
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        private set
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#setOnUpdate().(value)
//                  display_name value
//                  documentation ```kotlin\nvalue: List<Pair<Column<*>, Expression<*>>>?\n```
//              ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#setOnUpdate().
//                  display_name onUpdate
//                  documentation ```kotlin\nprivate set(value: List<Pair<Column<*>, Expression<*>>>?): Unit\n```

    internal val updateValues: MutableMap<Column<*>, Any?> = LinkedHashMap()
//               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#getUpdateValues().
//                            display_name updateValues
//                            documentation ```kotlin\ninternal get(): MutableMap<Column<*>, Any?>\n```
//               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#updateValues.
//                            display_name updateValues
//                            documentation ```kotlin\ninternal final val updateValues: MutableMap<Column<*>, Any?>\n```
//                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#
//                                                           ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashMap#`<init>`().

    override fun prepareSQL(transaction: Transaction, prepared: Boolean): String {
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#prepareSQL().
//                          display_name prepareSQL
//                          documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().
//                          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#prepareSQL().(transaction)
//                                      display_name transaction
//                                      documentation ```kotlin\ntransaction: Transaction\n```
//                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#prepareSQL().(prepared)
//                                                             display_name prepared
//                                                             documentation ```kotlin\nprepared: Boolean\n```
//                                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
        val dialect = transaction.db.dialect
//          ^^^^^^^ definition local 0
//                  display_name dialect
//                  documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#prepareSQL().(transaction)
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
        val functionProvider = UpsertBuilder.getFunctionProvider(dialect)
//          ^^^^^^^^^^^^^^^^ definition local 1
//                           display_name functionProvider
//                           documentation ```kotlin\nlocal val functionProvider: FunctionProvider\n```
//                                           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#Companion#getFunctionProvider().
//                                                               ^^^^^^^ reference local 0
        val keyColumns = if (functionProvider is MysqlFunctionProvider) keys.toList() else getKeyColumns(keys = keys)
//          ^^^^^^^^^^ definition local 2
//                     display_name keyColumns
//                     documentation ```kotlin\nlocal val keyColumns: List<Column<*>>\n```
//                           ^^^^^^^^^^^^^^^^ reference local 1
//                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#getKeys().
//                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#keys.
//                                                                           ^^^^^^ reference semanticdb maven . . kotlin/collections/toList().
//                                                                                         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getKeyColumns().
//                                                                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#getKeys().
//                                                                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#keys.
        val insertValues = arguments!!.first()
//          ^^^^^^^^^^^^ definition local 3
//                       display_name insertValues
//                       documentation ```kotlin\nlocal val insertValues: List<Pair<Column<*>, Any?>>\n```
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#arguments.
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getArguments().
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#setArguments().
//                                     ^^^^^ reference semanticdb maven . . kotlin/collections/first(+19).
        val insertValuesSql = insertValues.toSqlString(prepared)
//          ^^^^^^^^^^^^^^^ definition local 4
//                          display_name insertValuesSql
//                          documentation ```kotlin\nlocal val insertValuesSql: String\n```
//                            ^^^^^^^^^^^^ reference local 3
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#toSqlString().
//                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#prepareSQL().(prepared)
        val updateExcludeColumns = (onUpdateExclude ?: emptyList()) + if (dialect is OracleDialect) keyColumns else emptyList()
//          ^^^^^^^^^^^^^^^^^^^^ definition local 5
//                               display_name updateExcludeColumns
//                               documentation ```kotlin\nlocal val updateExcludeColumns: List<Column<*>>\n```
//                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#getOnUpdateExclude().
//                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#onUpdateExclude.
//                                                     ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
//                                                                  ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                                        ^^^^^^^ reference local 0
//                                                                                                  ^^^^^^^^^^ reference local 2
//                                                                                                                  ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
        val updateExpressions = updateValues.takeIf { it.isNotEmpty() }?.toList()
//          ^^^^^^^^^^^^^^^^^ definition local 6
//                            display_name updateExpressions
//                            documentation ```kotlin\nlocal val updateExpressions: List<Pair<Column<*>, Any?>>\n```
//                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#getUpdateValues().
//                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#updateValues.
//                                           ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                                  ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                      display_name it
//                                                                      documentation ```kotlin\nit: Iterable<Pair<IColumnType<*>, Any?>>\n```
//                                                    ^^ reference semanticdb maven . . (it)
//                                                       ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+10).
//                                                                       ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+11).
            ?: getUpdateExpressions(insertValues.unzip().first, updateExcludeColumns, keyColumns)
//             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getUpdateExpressions().
//                                  ^^^^^^^^^^^^ reference local 3
//                                               ^^^^^ reference semanticdb maven . . kotlin/collections/unzip(+1).
//                                                       ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                       ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                              ^^^^^^^^^^^^^^^^^^^^ reference local 5
//                                                                                    ^^^^^^^^^^ reference local 2
        return functionProvider.upsert(table, insertValues, insertValuesSql, updateExpressions, keyColumns, where, transaction)
//             ^^^^^^^^^^^^^^^^ reference local 1
//                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getTable().
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#table.
//                                            ^^^^^^^^^^^^ reference local 3
//                                                          ^^^^^^^^^^^^^^^ reference local 4
//                                                                           ^^^^^^^^^^^^^^^^^ reference local 6
//                                                                                              ^^^^^^^^^^ reference local 2
//                                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#getWhere().
//                                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#where.
//                                                                                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#prepareSQL().(transaction)
    }

    override fun arguments(): List<Iterable<Pair<IColumnType<*>, Any?>>> {
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#arguments().
//                         display_name arguments
//                         documentation ```kotlin\npublic open override fun arguments(): List<Iterable<Pair<IColumnType<*>, Any?>>>\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments(+1).
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        val additionalArgs = getAdditionalArgs(updateValues, where)
//          ^^^^^^^^^^^^^^ definition local 7
//                         display_name additionalArgs
//                         documentation ```kotlin\nlocal val additionalArgs: List<Pair<IColumnType<*>, Any?>>\n```
//                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getAdditionalArgs().
//                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#getUpdateValues().
//                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#updateValues.
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#getWhere().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#where.
        return super.arguments().map {
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#arguments().
//                               ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                   ^ definition semanticdb maven . . (it) 2:9
//                                     display_name it
//                                     documentation ```kotlin\nit: Iterable<Pair<IColumnType<*>, Any?>>\n```
            it + additionalArgs
//          ^^ reference semanticdb maven . . (it)
//             ^ reference semanticdb maven . . kotlin/collections/plus(+31).
//               ^^^^^^^^^^^^^^ reference local 7
        }
    }
}
