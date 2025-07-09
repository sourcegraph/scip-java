package org.jetbrains.exposed.v1.core.statements
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/

import org.jetbrains.exposed.v1.core.*
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
import kotlin.properties.Delegates
//     ^^^^^^ reference semanticdb maven . . kotlin/
//            ^^^^^^^^^^ reference semanticdb maven . . kotlin/properties/
//                       ^^^^^^^^^ reference semanticdb maven . . kotlin/properties/Delegates#

/**
 * Represents the SQL statement that inserts a new row into a table.
 *
 * @param table Table to insert the new row into.
 * @param isIgnore Whether to ignore errors or not.
 * **Note** [isIgnore] is not supported by all vendors. Please check the documentation.
 */
@Suppress("ForbiddenComment", "AnnotationSpacing")
open class InsertStatement<Key : Any>(
//         ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#
//                         display_name InsertStatement
//                         documentation ```kotlin\n@Suppress(...) public open class InsertStatement<Key : Any> : UpdateBuilder<Int>\n```\n\n----\n\n\n Represents the SQL statement that inserts a new row into a table.\n\n @param table Table to insert the new row into.\n @param isIgnore Whether to ignore errors or not.\n **Note** [isIgnore] is not supported by all vendors. Please check the documentation.\n
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#
//         ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().
//                         display_name InsertStatement
//                         documentation ```kotlin\npublic constructor<Key : Any>(table: Table, isIgnore: Boolean = ...): InsertStatement<Key>\n```
//                         ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#[Key]
//                             display_name FirTypeParameterSymbol Key
//                             documentation ```kotlin\nKey : Any\n```
    val table: Table,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().(table)
//            display_name table
//            documentation ```kotlin\ntable: Table\n```
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().(table)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getTable().
//            display_name table
//            documentation ```kotlin\npublic get(): Table\n```
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#table.
//            display_name table
//            documentation ```kotlin\npublic final val table: Table\n```
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
    val isIgnore: Boolean = false
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().(isIgnore)
//               display_name isIgnore
//               documentation ```kotlin\nisIgnore: Boolean = ...\n```
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().(isIgnore)
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getIsIgnore().
//               display_name isIgnore
//               documentation ```kotlin\npublic get(): Boolean\n```
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isIgnore.
//               display_name isIgnore
//               documentation ```kotlin\npublic final val isIgnore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
) : UpdateBuilder<Int>(StatementType.INSERT, listOf(table)) {
//  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#INSERT.
//                                           ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().(table)

    /**
     * The number of rows affected by the insert operation.
     *
     * When returned by a `BatchInsertStatement` or `BatchUpsertStatement`, the returned value is calculated using the
     * sum of the individual values generated by each statement.
     *
     * **Note**: Some vendors support returning the affected-row value of 2 if an existing row is updated by an upsert
     * operation; please check the documentation.
     */
    var insertedCount: Int by Delegates.notNull()
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getInsertedCount().
//                    display_name insertedCount
//                    documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n\n The number of rows affected by the insert operation.\n\n When returned by a `BatchInsertStatement` or `BatchUpsertStatement`, the returned value is calculated using the\n sum of the individual values generated by each statement.\n\n **Note**: Some vendors support returning the affected-row value of 2 if an existing row is updated by an upsert\n operation; please check the documentation.\n
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#insertedCount.
//                    display_name insertedCount
//                    documentation ```kotlin\npublic final var insertedCount: Int\n```\n\n----\n\n\n The number of rows affected by the insert operation.\n\n When returned by a `BatchInsertStatement` or `BatchUpsertStatement`, the returned value is calculated using the\n sum of the individual values generated by each statement.\n\n **Note**: Some vendors support returning the affected-row value of 2 if an existing row is updated by an upsert\n operation; please check the documentation.\n
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setInsertedCount().
//                    display_name insertedCount
//                    documentation ```kotlin\npublic set(<set-?>: Int): Unit\n```\n\n----\n\n\n The number of rows affected by the insert operation.\n\n When returned by a `BatchInsertStatement` or `BatchUpsertStatement`, the returned value is calculated using the\n sum of the individual values generated by each statement.\n\n **Note**: Some vendors support returning the affected-row value of 2 if an existing row is updated by an upsert\n operation; please check the documentation.\n
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setInsertedCount().(insertedCount)
//                    display_name insertedCount
//                    documentation ```kotlin\n<set-?>: Int\n```\n\n----\n\n\n The number of rows affected by the insert operation.\n\n When returned by a `BatchInsertStatement` or `BatchUpsertStatement`, the returned value is calculated using the\n sum of the individual values generated by each statement.\n\n **Note**: Some vendors support returning the affected-row value of 2 if an existing row is updated by an upsert\n operation; please check the documentation.\n
//                     ^^^ reference semanticdb maven . . kotlin/Int#
//                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/properties/ReadWriteProperty#getValue().
//                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/properties/ReadWriteProperty#setValue().
//                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getInsertedCount().
//                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#insertedCount.
//                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setInsertedCount().
//                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setInsertedCount().(insertedCount)
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/properties/Delegates#notNull().

    /** The [ResultRow]s generated by processing the database result set retrieved after executing the statement. */
    var resultedValues: List<ResultRow>? = null
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getResultedValues().
//                     display_name resultedValues
//                     documentation ```kotlin\npublic get(): List<ResultRow>?\n```\n\n----\n\n The [ResultRow]s generated by processing the database result set retrieved after executing the statement.
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#resultedValues.
//                     display_name resultedValues
//                     documentation ```kotlin\npublic final var resultedValues: List<ResultRow>?\n```\n\n----\n\n The [ResultRow]s generated by processing the database result set retrieved after executing the statement.
//                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        @InternalApi
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setResultedValues().(value) 1:11
//                   display_name value
//                   documentation ```kotlin\nvalue: List<ResultRow>?\n```
        set
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setResultedValues().
//          display_name resultedValues
//          documentation ```kotlin\n@InternalApi() public set(value: List<ResultRow>?): Unit\n```

    infix operator fun <T> get(column: Column<T>): T {
//                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get().[T]
//                        display_name FirTypeParameterSymbol T
//                        documentation ```kotlin\nT\n```
//                         ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get().
//                             display_name get
//                             documentation ```kotlin\npublic final operator infix fun <T> get(column: Column<T>): T\n```
//                             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get().(column)
//                                    display_name column
//                                    documentation ```kotlin\ncolumn: Column<T>\n```
//                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
        val row = resultedValues?.firstOrNull() ?: error("No key generated")
//          ^^^ definition local 0
//              display_name row
//              documentation ```kotlin\nlocal val row: ResultRow\n```
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getResultedValues().
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#resultedValues.
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setResultedValues().
//                                ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+19).
//                                                 ^^^^^ reference semanticdb maven . . kotlin/error().
        return row[column]
//             ^^^ reference local 0
//             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get().(column)
    }

    infix operator fun <T> get(column: CompositeColumn<T>): T {
//                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get(+1).[T]
//                        display_name FirTypeParameterSymbol T
//                        documentation ```kotlin\nT\n```
//                         ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get(+1).
//                             display_name get
//                             documentation ```kotlin\npublic final operator infix fun <T> get(column: CompositeColumn<T>): T\n```
//                             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get(+1).(column)
//                                    display_name column
//                                    documentation ```kotlin\ncolumn: CompositeColumn<T>\n```
//                                     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#
        val row = resultedValues?.firstOrNull() ?: error("No key generated")
//          ^^^ definition local 1
//              display_name row
//              documentation ```kotlin\nlocal val row: ResultRow\n```
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getResultedValues().
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#resultedValues.
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setResultedValues().
//                                ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+19).
//                                                 ^^^^^ reference semanticdb maven . . kotlin/error().
        return row[column]
//             ^^^ reference local 1
//             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get(+1).(column)
    }

    /**
     * Returns the value of a given [column] from the first stored [ResultRow], or `null` if either no results were
     * retrieved from the database or if the column cannot be found in the row.
     */
    fun <T> getOrNull(column: Column<T>): T? = resultedValues?.firstOrNull()?.getOrNull(column)
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getOrNull().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT\n```
//          ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getOrNull().
//                    display_name getOrNull
//                    documentation ```kotlin\npublic final fun <T> getOrNull(column: Column<T>): T?\n```\n\n----\n\n\n Returns the value of a given [column] from the first stored [ResultRow], or `null` if either no results were\n retrieved from the database or if the column cannot be found in the row.\n
//                    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getOrNull().(column)
//                           display_name column
//                           documentation ```kotlin\ncolumn: Column<T>\n```
//                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getResultedValues().
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#resultedValues.
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setResultedValues().
//                                                             ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+19).
//                                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getOrNull().
//                                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getOrNull().(column)
    // TODO: log issue about unifying process result method for jdbc and r2dbc

    @OptIn(InternalApi::class)
    @Suppress("NestedBlockDepth")
    @Deprecated(
        "This function is used in derived classes to build a list of arguments. " +
            "It's recommended to avoid including all default and nullable values in insert statements, " +
            "as these values can often be generated automatically by the database. " +
            "There are no usages of that function inside Exposed. Saved as deprecated for back compatability",
        level = DeprecationLevel.WARNING
//                               ^^^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#WARNING.
    )
    protected open fun valuesAndDefaults(values: Map<Column<*>, Any?> = this.values): Map<Column<*>, Any?> {
//                     ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndDefaults().
//                                       display_name valuesAndDefaults
//                                       documentation ```kotlin\n@OptIn(...) @Suppress(...) @Deprecated(...) protected open fun valuesAndDefaults(values: Map<Column<*>, Any?> = ...): Map<Column<*>, Any?>\n```
//                                       ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndDefaults().(values)
//                                              display_name values
//                                              documentation ```kotlin\nvalues: Map<Column<*>, Any?> = ...\n```
//                                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getValues().
//                                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#values.
//                                                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
        val result = values.toMutableMap()
//          ^^^^^^ definition local 2
//                 display_name result
//                 documentation ```kotlin\nlocal val result: MutableMap<Column<*>, Any?>\n```
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndDefaults().(values)
//                          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/toMutableMap().
        targets.forEach { table ->
//      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getTargets().
//      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#targets.
//              ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                        ^^^^^ definition semanticdb maven . . (table)
//                              display_name table
//                              documentation ```kotlin\ntable: Table\n```
            table.columns.forEach { column ->
//          ^^^^^ reference semanticdb maven . . (table)
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                        ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                  ^^^^^^ definition semanticdb maven . . (column)
//                                         display_name column
//                                         documentation ```kotlin\ncolumn: Column<*>\n```
                if ((column.dbDefaultValue != null || column.defaultValueFun != null) && column !in values.keys) {
//                   ^^^^^^ reference semanticdb maven . . (column)
//                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                    ^^^^^^ reference semanticdb maven . . (column)
//                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                                                       ^^^^^^ reference semanticdb maven . . (column)
//                                                                                              ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                                              ^^^ reference semanticdb maven . . kotlin/collections/Set#contains().
//                                                                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndDefaults().(values)
//                                                                                                         ^^^^ reference semanticdb maven . . kotlin/collections/Map#getKeys().
//                                                                                                         ^^^^ reference semanticdb maven . . kotlin/collections/Map#keys.
                    val value = when {
//                      ^^^^^ definition local 3
//                            display_name value
//                            documentation ```kotlin\nlocal val value: Any?\n```
                        column.defaultValueFun != null -> column.defaultValueFun!!()
//                      ^^^^^^ reference semanticdb maven . . (column)
//                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                        ^^^^^^ reference semanticdb maven . . (column)
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function0#invoke().
//                                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
                        else -> DefaultValueMarker
                    }
                    result[column] = value
//                  ^^^^^^ reference local 2
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//                         ^^^^^^ reference semanticdb maven . . (column)
//                                   ^^^^^ reference local 3
                }
            }
        }
        return result
//             ^^^^^^ reference local 2
    }

    @Deprecated(
        "This function has been obsolete since version 0.57.0, " +
            "following the removal of default values from insert statements. " +
            "It's safe to remove any overrides of this function from your code.",
        level = DeprecationLevel.WARNING
//                               ^^^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#WARNING.
    )
    protected open fun isColumnValuePreferredFromResultSet(column: Column<*>, value: Any?): Boolean {
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().
//                                                         display_name isColumnValuePreferredFromResultSet
//                                                         documentation ```kotlin\n@Deprecated(...) protected open fun isColumnValuePreferredFromResultSet(column: Column<*>, value: Any?): Boolean\n```
//                                                         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().(column)
//                                                                display_name column
//                                                                documentation ```kotlin\ncolumn: Column<*>\n```
//                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().(value)
//                                                                                  display_name value
//                                                                                  documentation ```kotlin\nvalue: Any?\n```
//                                                                                   ^^^^ reference semanticdb maven . . kotlin/Any#
//                                                                                          ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        return column.columnType.isAutoInc || value is NextVal<*>
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().(column)
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().(value)
    }

    protected fun clientDefaultColumns() = targets
//                ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#clientDefaultColumns().
//                                     display_name clientDefaultColumns
//                                     documentation ```kotlin\nprotected final fun clientDefaultColumns(): List<Column<*>>\n```
//                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getTargets().
//                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#targets.
        // The current check for existing client side without db side default value
        .flatMap { it.columns.filter { column -> column.dbDefaultValue == null && column.defaultValueFun != null } }
//       ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap(+10).
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                   display_name it
//                                                                                                                   documentation ```kotlin\nit: Column<*>\n```
//                 ^^ reference semanticdb maven . . (it)
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                            ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                     ^^^^^^ definition semanticdb maven . . (column)
//                                            display_name column
//                                            documentation ```kotlin\ncolumn: Column<*>\n```
//                                               ^^^^^^ reference semanticdb maven . . (column)
//                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                                                ^^^^^^ reference semanticdb maven . . (column)
//                                                                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                                                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                                                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().

    @OptIn(InternalApi::class)
    protected fun valuesAndClientDefaults(values: Map<Column<*>, Any?> = this.values): Map<Column<*>, Any?> {
//                ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndClientDefaults().
//                                        display_name valuesAndClientDefaults
//                                        documentation ```kotlin\n@OptIn(...) protected final fun valuesAndClientDefaults(values: Map<Column<*>, Any?> = ...): Map<Column<*>, Any?>\n```
//                                        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndClientDefaults().(values)
//                                               display_name values
//                                               documentation ```kotlin\nvalues: Map<Column<*>, Any?> = ...\n```
//                                                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getValues().
//                                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#values.
//                                                                                     ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
        val clientDefaultValues = clientDefaultColumns()
//          ^^^^^^^^^^^^^^^^^^^ definition local 4
//                              display_name clientDefaultValues
//                              documentation ```kotlin\nlocal val clientDefaultValues: List<Pair<Column<*>, Any?>>\n```
//                                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#clientDefaultColumns().
            .filter { column -> column !in values.keys }
//           ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                    ^^^^^^ definition semanticdb maven . . (column)
//                           display_name column
//                           documentation ```kotlin\ncolumn: Column<*>\n```
//                              ^^^^^^ reference semanticdb maven . . (column)
//                                     ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                                     ^^^ reference semanticdb maven . . kotlin/collections/Set#contains().
//                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndClientDefaults().(values)
//                                                ^^^^ reference semanticdb maven . . kotlin/collections/Map#getKeys().
//                                                ^^^^ reference semanticdb maven . . kotlin/collections/Map#keys.
            .map { column -> column to column.defaultValueFun!!() }
//           ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                 ^^^^^^ definition semanticdb maven . . (column)
//                        display_name column
//                        documentation ```kotlin\ncolumn: Column<*>\n```
//                           ^^^^^^ reference semanticdb maven . . (column)
//                                  ^^ reference semanticdb maven . . kotlin/to().
//                                     ^^^^^^ reference semanticdb maven . . (column)
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function0#invoke().
//                                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().

        return clientDefaultValues.toMap() + values
//             ^^^^^^^^^^^^^^^^^^^ reference local 4
//                                 ^^^^^ reference semanticdb maven . . kotlin/collections/toMap().
//                                         ^ reference semanticdb maven . . kotlin/collections/plus(+39).
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndClientDefaults().(values)
    }

    override fun prepareSQL(transaction: Transaction, prepared: Boolean): String {
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().
//                          display_name prepareSQL
//                          documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#prepareSQL().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#prepareSQL().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#prepareSQL().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#prepareSQL().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#prepareSQL().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#prepareSQL().
//                          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().(transaction)
//                                      display_name transaction
//                                      documentation ```kotlin\ntransaction: Transaction\n```
//                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().(prepared)
//                                                             display_name prepared
//                                                             documentation ```kotlin\nprepared: Boolean\n```
//                                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
        val values = arguments!!.first()
//          ^^^^^^ definition local 5
//                 display_name values
//                 documentation ```kotlin\nlocal val values: List<Pair<Column<*>, Any?>>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments.
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getArguments().
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setArguments().
//                               ^^^^^ reference semanticdb maven . . kotlin/collections/first(+19).
        val sql = values.toSqlString(prepared)
//          ^^^ definition local 6
//              display_name sql
//              documentation ```kotlin\nlocal val sql: String\n```
//                ^^^^^^ reference local 5
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#toSqlString().
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().(prepared)
        return transaction.db.dialect.functionProvider
//             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().(transaction)
//                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
            .insert(isIgnore, table, values.map { it.first }, sql, transaction)
//           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getIsIgnore().
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isIgnore.
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getTable().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#table.
//                                   ^^^^^^ reference local 5
//                                          ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                              ^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                           display_name it
//                                                           documentation ```kotlin\nit: Column<*>\n```
//                                                ^^ reference semanticdb maven . . (it)
//                                                   ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                   ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                            ^^^ reference local 6
//                                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().(transaction)
    }

    protected fun List<Pair<Column<*>, Any?>>.toSqlString(prepared: Boolean): String {
//                                            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#toSqlString().
//                                                        display_name toSqlString
//                                                        documentation ```kotlin\nprotected final fun List<Pair<Column<*>, Any?>>.toSqlString(prepared: Boolean): String\n```
//                                                        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#toSqlString().(prepared)
//                                                                 display_name prepared
//                                                                 documentation ```kotlin\nprepared: Boolean\n```
//                                                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
        val builder = QueryBuilder(prepared)
//          ^^^^^^^ definition local 7
//                  display_name builder
//                  documentation ```kotlin\nlocal val builder: QueryBuilder\n```
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#toSqlString().(prepared)
        return if (isEmpty()) {
//                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#isEmpty().
            ""
        } else {
            with(builder) {
//          ^^^^ reference semanticdb maven . . kotlin/with().
//               ^^^^^^^ reference local 7
                this@toSqlString.appendTo(prefix = "VALUES (", postfix = ")") { (column, value) ->
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                                              ^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                                                              display_name <destruct>
//                                                                                              documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                                                               ^^^^^^ definition local 8
//                                                                                      display_name column
//                                                                                      documentation ```kotlin\nlocal val column: Column<*>\n```
//                                                                               ^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                                               ^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                                                       ^^^^^ definition local 9
//                                                                                             display_name value
//                                                                                             documentation ```kotlin\nlocal val value: Any?\n```
//                                                                                       ^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                                                       ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
                    registerArgument(column, value)
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                                   ^^^^^^ reference local 8
//                                           ^^^^^ reference local 9
                }
                toString()
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
            }
        }
    }

    open var arguments: List<List<Pair<Column<*>, Any?>>>? = null
//           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments.
//                     display_name arguments
//                     documentation ```kotlin\npublic open var arguments: List<List<Pair<Column<*>, Any?>>>?\n```
//           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setArguments().
//                     display_name arguments
//                     documentation ```kotlin\npublic set(value: List<List<Pair<Column<*>, Any?>>>?): Unit\n```
//           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setArguments().(value)
//                     display_name value
//                     documentation ```kotlin\nvalue: List<List<Pair<Column<*>, Any?>>>?\n```
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        get() = field ?: run {
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getArguments().
//          display_name arguments
//          documentation ```kotlin\npublic get(): List<List<Pair<Column<*>, Any?>>>?\n```
//              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/field.
//                       ^^^ reference semanticdb maven . . kotlin/run(+1).
            listOf(valuesAndClientDefaults().toList())
//          ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                 ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndClientDefaults().
//                                           ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+11).
                .apply { field = this }
//               ^^^^^ reference semanticdb maven . . kotlin/apply().
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/field.
        }

    override fun arguments(): List<Iterable<Pair<IColumnType<*>, Any?>>> {
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments(+1).
//                         display_name arguments
//                         documentation ```kotlin\npublic open override fun arguments(): List<Iterable<Pair<IColumnType<*>, Any?>>>\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#arguments().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#arguments().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#arguments().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#arguments().
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        return arguments?.map { args ->
//             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments.
//             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getArguments().
//             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setArguments().
//                        ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                              ^^^^ definition semanticdb maven . . (args)
//                                   display_name args
//                                   documentation ```kotlin\nargs: List<Pair<Column<*>, Any?>>\n```
            val builder = QueryBuilder(true)
//              ^^^^^^^ definition local 10
//                      display_name builder
//                      documentation ```kotlin\nlocal val builder: QueryBuilder\n```
//                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
            args.filter { (_, value) ->
//          ^^^^ reference semanticdb maven . . (args)
//               ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                        ^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                   display_name <destruct>
//                                   documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                         ^ definition local 11
//                           display_name <unused var>
//                           documentation ```kotlin\nlocal val <unused var>: Column<*>\n```
//                         ^ reference semanticdb maven . . (`<destruct>`)
//                         ^ reference semanticdb maven . . kotlin/Pair#component1().
//                            ^^^^^ definition local 12
//                                  display_name value
//                                  documentation ```kotlin\nlocal val value: Any?\n```
//                            ^^^^^ reference semanticdb maven . . (`<destruct>`)
//                            ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
                value != DefaultValueMarker
//              ^^^^^ reference local 12
            }.forEach { (column, value) ->
//            ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                      ^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                      display_name <destruct>
//                                      documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                       ^^^^^^ definition local 13
//                              display_name column
//                              documentation ```kotlin\nlocal val column: Column<*>\n```
//                       ^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                       ^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                               ^^^^^ definition local 14
//                                     display_name value
//                                     documentation ```kotlin\nlocal val value: Any?\n```
//                               ^^^^^ reference semanticdb maven . . (`<destruct>`)
//                               ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
                builder.registerArgument(column, value)
//              ^^^^^^^ reference local 10
//                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                                       ^^^^^^ reference local 13
//                                               ^^^^^ reference local 14
            }
            builder.args
//          ^^^^^^^ reference local 10
//                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#args.
//                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getArgs().
        } ?: emptyList()
//           ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
    }

    /**
     * Returns the list of columns with default values that can not be taken locally.
     * It is the columns defined with `defaultExpression()`, `databaseGenerated()`
     */
    @InternalApi
    fun columnsWithDatabaseDefaults() = targets
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#columnsWithDatabaseDefaults().
//                                  display_name columnsWithDatabaseDefaults
//                                  documentation ```kotlin\n@InternalApi() public final fun columnsWithDatabaseDefaults(): List<Column<*>>\n```\n\n----\n\n\n Returns the list of columns with default values that can not be taken locally.\n It is the columns defined with `defaultExpression()`, `databaseGenerated()`\n
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getTargets().
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#targets.
        .flatMap { it.columns }
//       ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap(+10).
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                              display_name it
//                              documentation ```kotlin\nit: Column<*>\n```
//                 ^^ reference semanticdb maven . . (it)
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
        .filter { it.defaultValueFun == null && it.dbDefaultValue != null }
//       ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                          display_name it
//                                                                          documentation ```kotlin\nit: Column<*>\n```
//                ^^ reference semanticdb maven . . (it)
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                              ^^ reference semanticdb maven . . (it)
//                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
}
