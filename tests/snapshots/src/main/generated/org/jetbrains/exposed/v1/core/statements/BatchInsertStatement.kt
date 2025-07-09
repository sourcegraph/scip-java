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
import org.jetbrains.exposed.v1.core.EntityIDColumnType
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#
import org.jetbrains.exposed.v1.core.InternalApi
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/InternalApi#
import org.jetbrains.exposed.v1.core.ResultRow
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#
import org.jetbrains.exposed.v1.core.Table
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
import org.jetbrains.exposed.v1.core.isAutoInc
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#

/** An exception thrown when the provided data cannot be validated or processed to prepare a batch statement. */
class BatchDataInconsistentException(message: String) : Exception(message)
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchDataInconsistentException#
//                                   display_name BatchDataInconsistentException
//                                   documentation ```kotlin\npublic final class BatchDataInconsistentException : {kotlin/Exception=} Exception\n```\n\n----\n\n An exception thrown when the provided data cannot be validated or processed to prepare a batch statement.
//                                   relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Exception#
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchDataInconsistentException#`<init>`().
//                                   display_name BatchDataInconsistentException
//                                   documentation ```kotlin\npublic constructor(message: String): BatchDataInconsistentException\n```
//                                   ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchDataInconsistentException#`<init>`().(message)
//                                           display_name message
//                                           documentation ```kotlin\nmessage: String\n```
//                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                      ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Exception#
//                                                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchDataInconsistentException#`<init>`().(message)

/**
 * Represents the SQL statement that batch inserts new rows into a table.
 *
 * @param shouldReturnGeneratedValues Specifies whether newly generated values (for example, auto-incremented IDs)
 * should be returned. See [Batch Insert](https://github.com/JetBrains/Exposed/wiki/DSL#batch-insert) for more details.
 */
@Suppress("ForbiddenComment")
open class BatchInsertStatement(
//         ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#
//                              display_name BatchInsertStatement
//                              documentation ```kotlin\n@Suppress(...) public open class BatchInsertStatement : InsertStatement<List<ResultRow>>\n```\n\n----\n\n\n Represents the SQL statement that batch inserts new rows into a table.\n\n @param shouldReturnGeneratedValues Specifies whether newly generated values (for example, auto-incremented IDs)\n should be returned. See [Batch Insert](https://github.com/JetBrains/Exposed/wiki/DSL#batch-insert) for more details.\n
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#
//         ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#`<init>`().
//                              display_name BatchInsertStatement
//                              documentation ```kotlin\npublic constructor(table: Table, ignore: Boolean = ..., shouldReturnGeneratedValues: Boolean = ...): BatchInsertStatement\n```
    table: Table,
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#`<init>`().(table)
//        display_name table
//        documentation ```kotlin\ntable: Table\n```
//         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
    ignore: Boolean = false,
//  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#`<init>`().(ignore)
//         display_name ignore
//         documentation ```kotlin\nignore: Boolean = ...\n```
//          ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    val shouldReturnGeneratedValues: Boolean = true
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#`<init>`().(shouldReturnGeneratedValues)
//                                  display_name shouldReturnGeneratedValues
//                                  documentation ```kotlin\nshouldReturnGeneratedValues: Boolean = ...\n```
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#`<init>`().(shouldReturnGeneratedValues)
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getShouldReturnGeneratedValues().
//                                  display_name shouldReturnGeneratedValues
//                                  documentation ```kotlin\npublic get(): Boolean\n```
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#shouldReturnGeneratedValues.
//                                  display_name shouldReturnGeneratedValues
//                                  documentation ```kotlin\npublic final val shouldReturnGeneratedValues: Boolean\n```
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
) : InsertStatement<List<ResultRow>>(table, ignore) {
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#`<init>`().(table)
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#`<init>`().(ignore)
    @InternalApi
    val data = ArrayList<MutableMap<Column<*>, Any?>>()
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//           display_name data
//           documentation ```kotlin\n@InternalApi() public final val data: {kotlin/collections/ArrayList<kotlin/collections/MutableMap<org/jetbrains/exposed/v1/core/Column<*>, kotlin/Any?>>=} ArrayList<MutableMap<Column<*>, Any?>>\n```
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//           display_name data
//           documentation ```kotlin\npublic get(): {kotlin/collections/ArrayList<kotlin/collections/MutableMap<org/jetbrains/exposed/v1/core/Column<*>, kotlin/Any?>>=} ArrayList<MutableMap<Column<*>, Any?>>\n```
//             ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`().

    private fun Column<*>.isDefaultable() = columnType.nullable || defaultValueFun != null || isDatabaseGenerated
//                        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#isDefaultable().
//                                      display_name isDefaultable
//                                      documentation ```kotlin\nprivate final fun Column<*>.isDefaultable(): Boolean\n```
//                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
//                                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//                                                                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//                                                                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().

    override operator fun <S> set(column: Column<S>, value: S) {
//                         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#set().[S]
//                           display_name FirTypeParameterSymbol S
//                           documentation ```kotlin\nS\n```
//                            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#set().
//                                display_name set
//                                documentation ```kotlin\npublic open override operator fun <S> set(column: Column<S>, value: S): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#set().
//                                ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#set().(column)
//                                       display_name column
//                                       documentation ```kotlin\ncolumn: Column<S>\n```
//                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                   ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#set().(value)
//                                                         display_name value
//                                                         documentation ```kotlin\nvalue: S\n```
        @OptIn(InternalApi::class)
        if (data.size > 1 && column !in data[data.size - 2] && !column.isDefaultable()) {
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//               ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#getSize().
//               ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size.
//                    ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#set().(column)
//                                  ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                                  ^^^ reference semanticdb maven . . kotlin/collections/contains(+10).
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//                                      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#get().
//                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//                                                ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#getSize().
//                                                ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size.
//                                                     ^ reference semanticdb maven . . kotlin/Int#minus(+2).
//                                                             ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#set().(column)
//                                                                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#isDefaultable().
            val fullIdentity = CoreTransactionManager.currentTransaction().fullIdentity(column)
//              ^^^^^^^^^^^^ definition local 0
//                           display_name fullIdentity
//                           documentation ```kotlin\nlocal val fullIdentity: String\n```
//                                                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity().
//                                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#set().(column)
            throw BatchDataInconsistentException("Can't set $value for $fullIdentity because previous insertion can't be defaulted for that column.")
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchDataInconsistentException#`<init>`().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#set().(value)
//                                                                      ^^^^^^^^^^^^ reference local 0
        }
        super.set(column, value)
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#set().
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#set().(column)
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#set().(value)
    }

    /**
     * Adds the most recent batch to the current list of insert statements.
     *
     * This function uses the mapping of columns scheduled for change with their new values, which is
     * provided by the implementing `BatchInsertStatement` instance.
     */
    fun addBatch() {
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#addBatch().
//               display_name addBatch
//               documentation ```kotlin\npublic final fun addBatch(): Unit\n```\n\n----\n\n\n Adds the most recent batch to the current list of insert statements.\n\n This function uses the mapping of columns scheduled for change with their new values, which is\n provided by the implementing `BatchInsertStatement` instance.\n
        @OptIn(InternalApi::class)
        if (data.isNotEmpty()) {
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//               ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
            validateLastBatch()
//          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#validateLastBatch().
            data[data.size - 1] = LinkedHashMap(values)
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#set().
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//                    ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#getSize().
//                    ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size.
//                         ^ reference semanticdb maven . . kotlin/Int#minus(+2).
//                                ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashMap#`<init>`().
//                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getValues().
//                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#values.
            allColumnsInDataSet.addAll(values.keys)
//          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#allColumnsInDataSet.
//          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getAllColumnsInDataSet().
//                              ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableSet#addAll().
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getValues().
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#values.
//                                            ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getKeys().
//                                            ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#keys.
            values.clear()
//          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getValues().
//          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#values.
//                 ^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#clear().
            hasBatchedValues = true
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getHasBatchedValues().
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#hasBatchedValues.
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#setHasBatchedValues().
        }
        @OptIn(InternalApi::class)
        data.add(values)
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//           ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getValues().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#values.
        arguments = null
//      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#arguments.
//      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getArguments().
//      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#setArguments().
    }

    @OptIn(InternalApi::class)
    fun removeLastBatch() {
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#removeLastBatch().
//                      display_name removeLastBatch
//                      documentation ```kotlin\n@OptIn(...) public final fun removeLastBatch(): Unit\n```
        data.removeAt(data.size - 1)
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#removeAt().
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//                         ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#getSize().
//                         ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size.
//                              ^ reference semanticdb maven . . kotlin/Int#minus(+2).
        allColumnsInDataSet.clear()
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#allColumnsInDataSet.
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getAllColumnsInDataSet().
//                          ^^^^^ reference semanticdb maven . . kotlin/collections/MutableSet#clear().
        data.flatMapTo(allColumnsInDataSet) { it.keys }
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//           ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMapTo(+10).
//                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#allColumnsInDataSet.
//                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getAllColumnsInDataSet().
//                                          ^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                      display_name it
//                                                      documentation ```kotlin\nit: Table\n```
//                                            ^^ reference semanticdb maven . . (it)
//                                               ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getKeys().
//                                               ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#keys.
        values.clear()
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getValues().
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#values.
//             ^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#clear().
        values.putAll(data.last())
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getValues().
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#values.
//             ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#putAll().
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//                         ^^^^ reference semanticdb maven . . kotlin/collections/last(+19).
        arguments = null
//      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#arguments.
//      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getArguments().
//      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#setArguments().
        hasBatchedValues = data.size > 0
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getHasBatchedValues().
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#hasBatchedValues.
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#setHasBatchedValues().
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//                              ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#getSize().
//                              ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size.
//                                   ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
    }

    @InternalApi
    open fun validateLastBatch() {
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#validateLastBatch().
//                             display_name validateLastBatch
//                             documentation ```kotlin\n@InternalApi() public open fun validateLastBatch(): Unit\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#validateLastBatch().
        val tr = CoreTransactionManager.currentTransaction()
//          ^^ definition local 1
//             display_name tr
//             documentation ```kotlin\nlocal val tr: Transaction\n```
//                                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
        val cantBeDefaulted = (allColumnsInDataSet - values.keys).filterNot { it.isDefaultable() }
//          ^^^^^^^^^^^^^^^ definition local 2
//                          display_name cantBeDefaulted
//                          documentation ```kotlin\nlocal val cantBeDefaulted: List<Column<*>>\n```
//                             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#allColumnsInDataSet.
//                             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getAllColumnsInDataSet().
//                                                 ^ reference semanticdb maven . . kotlin/collections/minus(+10).
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getValues().
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#values.
//                                                          ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getKeys().
//                                                          ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#keys.
//                                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterNot(+9).
//                                                                          ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                 display_name it
//                                                                                                 documentation ```kotlin\nit: Table\n```
//                                                                            ^^ reference semanticdb maven . . (it)
//                                                                               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#isDefaultable().
        if (cantBeDefaulted.isNotEmpty()) {
//          ^^^^^^^^^^^^^^^ reference local 2
//                          ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
            val columnList = cantBeDefaulted.joinToString { tr.fullIdentity(it) }
//              ^^^^^^^^^^ definition local 3
//                         display_name columnList
//                         documentation ```kotlin\nlocal val columnList: String\n```
//                           ^^^^^^^^^^^^^^^ reference local 2
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                display_name it
//                                                                                documentation ```kotlin\nit: Table\n```
//                                                          ^^ reference local 1
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity().
//                                                                          ^^ reference semanticdb maven . . (it)
            throw BatchDataInconsistentException(
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchDataInconsistentException#`<init>`().
                "Can't add a new batch because columns: $columnList don't have client default values. DB defaults are not supported in batch inserts"
//                                                       ^^^^^^^^^^ reference local 3
            )
        }
        val requiredInTargets = (targets.flatMap { it.columns } - values.keys).filter {
//          ^^^^^^^^^^^^^^^^^ definition local 4
//                            display_name requiredInTargets
//                            documentation ```kotlin\nlocal val requiredInTargets: List<Column<*>>\n```
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getTargets().
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#targets.
//                                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap(+10).
//                                               ^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                              display_name it
//                                                              documentation ```kotlin\nit: Table\n```
//                                                 ^^ reference semanticdb maven . . (it)
//                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                                                              ^ reference semanticdb maven . . kotlin/collections/minus(+2).
//                                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getValues().
//                                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#values.
//                                                                       ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getKeys().
//                                                                       ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#keys.
//                                                                             ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                                                                    ^ definition semanticdb maven . . (it) 2:9
//                                                                                      display_name it
//                                                                                      documentation ```kotlin\nit: Table\n```
            !it.isDefaultable() && !it.columnType.isAutoInc && it.dbDefaultValue == null && it.columnType !is EntityIDColumnType<*>
//          ^ reference semanticdb maven . . kotlin/Boolean#not().
//           ^^ reference semanticdb maven . . (it)
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#isDefaultable().
//                                 ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                  ^^ reference semanticdb maven . . (it)
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
//                                                             ^^ reference semanticdb maven . . (it)
//                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                                                          ^^ reference semanticdb maven . . (it)
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
        }
        if (requiredInTargets.any()) {
//          ^^^^^^^^^^^^^^^^^ reference local 4
//                            ^^^ reference semanticdb maven . . kotlin/collections/any(+18).
            val columnList = requiredInTargets.joinToString { tr.fullIdentity(it) }
//              ^^^^^^^^^^ definition local 5
//                         display_name columnList
//                         documentation ```kotlin\nlocal val columnList: String\n```
//                           ^^^^^^^^^^^^^^^^^ reference local 4
//                                             ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                  display_name it
//                                                                                  documentation ```kotlin\nit: Table\n```
//                                                            ^^ reference local 1
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity().
//                                                                            ^^ reference semanticdb maven . . (it)
            throw BatchDataInconsistentException(
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchDataInconsistentException#`<init>`().
                "Can't add a new batch because columns: $columnList don't have default values. DB defaults are not supported in batch inserts"
//                                                       ^^^^^^^^^^ reference local 5
            )
        }
    }

    private val allColumnsInDataSet = mutableSetOf<Column<*>>()
//              ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#allColumnsInDataSet.
//                                  display_name allColumnsInDataSet
//                                  documentation ```kotlin\nprivate final val allColumnsInDataSet: MutableSet<Column<*>>\n```
//              ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getAllColumnsInDataSet().
//                                  display_name allColumnsInDataSet
//                                  documentation ```kotlin\nprivate get(): MutableSet<Column<*>>\n```
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableSetOf().

    @OptIn(InternalApi::class)
    private fun allColumnsInDataSet() = allColumnsInDataSet +
//              ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#allColumnsInDataSet(+1).
//                                  display_name allColumnsInDataSet
//                                  documentation ```kotlin\n@OptIn(...) private final fun allColumnsInDataSet(): Set<Column<*>>\n```
//                                      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#allColumnsInDataSet.
//                                      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getAllColumnsInDataSet().
//                                                          ^ reference semanticdb maven . . kotlin/collections/plus(+42).
        (data.lastOrNull()?.keys ?: throw BatchDataInconsistentException("No data provided for inserting into ${table.tableName}"))
//       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
//            ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/lastOrNull(+19).
//                          ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getKeys().
//                          ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#keys.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchDataInconsistentException#`<init>`().
//                                                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getTable().
//                                                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#table.
//                                                                                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.

    override var arguments: List<List<Pair<Column<*>, Any?>>>? = null
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#arguments.
//                         display_name arguments
//                         documentation ```kotlin\npublic open override var arguments: List<List<Pair<Column<*>, Any?>>>?\n```
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#setArguments().
//                         display_name arguments
//                         documentation ```kotlin\npublic set(value: List<List<Pair<Column<*>, Any?>>>?): Unit\n```
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#setArguments().(value)
//                         display_name value
//                         documentation ```kotlin\nvalue: List<List<Pair<Column<*>, Any?>>>?\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        get() = field ?: run {
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getArguments().
//          display_name arguments
//          documentation ```kotlin\npublic get(): List<List<Pair<Column<*>, Any?>>>?\n```
//              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/field.
//                       ^^^ reference semanticdb maven . . kotlin/run(+1).
            val columnsToInsert = (allColumnsInDataSet() + clientDefaultColumns()).toSet()
//              ^^^^^^^^^^^^^^^ definition local 6
//                              display_name columnsToInsert
//                              documentation ```kotlin\nlocal val columnsToInsert: Set<Column<*>>\n```
//                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#allColumnsInDataSet(+1).
//                                                       ^ reference semanticdb maven . . kotlin/collections/plus(+42).
//                                                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#clientDefaultColumns().
//                                                                                 ^^^^^ reference semanticdb maven . . kotlin/collections/toSet(+9).
            @OptIn(InternalApi::class)
            data
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#data.
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getData().
                .map { valuesAndClientDefaults(it) as MutableMap }
//               ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                 display_name it
//                                                                 documentation ```kotlin\nit: Table\n```
//                     ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#valuesAndClientDefaults().
//                                             ^^ reference semanticdb maven . . (it)
                .map { values ->
//               ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                     ^^^^^^ definition semanticdb maven . . (values)
//                            display_name values
//                            documentation ```kotlin\nvalues: MutableMap<Column<*>, Any?>\n```
                    columnsToInsert.map { column ->
//                  ^^^^^^^^^^^^^^^ reference local 6
//                                  ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                        ^^^^^^ definition semanticdb maven . . (column)
//                                               display_name column
//                                               documentation ```kotlin\ncolumn: Column<*>\n```
                        column to when {
//                      ^^^^^^ reference semanticdb maven . . (column)
//                             ^^ reference semanticdb maven . . kotlin/to().
                            values.contains(column) -> values[column]
//                          ^^^^^^ reference semanticdb maven . . (values)
//                                 ^^^^^^^^ reference semanticdb maven . . kotlin/collections/contains(+10).
//                                          ^^^^^^ reference semanticdb maven . . (column)
//                                                     ^^^^^^ reference semanticdb maven . . (values)
//                                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#get().
//                                                            ^^^^^^ reference semanticdb maven . . (column)
                            column.dbDefaultValue != null || column.isDatabaseGenerated -> DefaultValueMarker
//                          ^^^^^^ reference semanticdb maven . . (column)
//                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                           ^^^^^^ reference semanticdb maven . . (column)
//                                                                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//                                                                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//                                                                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
                            else -> {
                                require(column.columnType.nullable) {
//                              ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                                      ^^^^^^ reference semanticdb maven . . (column)
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
                                    "The value for the column ${column.name} was not provided. " +
//                                                              ^^^^^^ reference semanticdb maven . . (column)
//                                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
                                        "The value for non-nullable column without defaults must be specified."
                                }
                                null
                            }
                        }
                    }
                }.apply { field = this }
//                ^^^^^ reference semanticdb maven . . kotlin/apply().
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/field.
        }
}
