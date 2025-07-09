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
import org.jetbrains.exposed.v1.core.vendors.SQLServerDialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#
import org.jetbrains.exposed.v1.core.vendors.currentDialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.

/** Represents all the DSL methods available when building SQL statements. */
@Suppress("TooManyFunctions")
interface IStatementBuilder {
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#
//                          display_name IStatementBuilder
//                          documentation ```kotlin\n@Suppress(...) public abstract interface IStatementBuilder : Any\n```\n\n----\n\n Represents all the DSL methods available when building SQL statements.
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementBuilder#
    /**
     * Represents the SQL statement that deletes only rows in a table that match the provided [op].
     *
     * @param limit Maximum number of rows to delete.
     * @param op Condition that determines which rows to delete.
     * @return A [DeleteStatement] that can be executed.
     */
    fun <T : Table> T.deleteWhere(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteWhere().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteWhere().
//                                display_name deleteWhere
//                                documentation ```kotlin\npublic open fun <T : Table> T.deleteWhere(limit: Int? = ..., op: T.(ISqlExpressionBuilder) -> Op<Boolean>): DeleteStatement\n```\n\n----\n\n\n Represents the SQL statement that deletes only rows in a table that match the provided [op].\n\n @param limit Maximum number of rows to delete.\n @param op Condition that determines which rows to delete.\n @return A [DeleteStatement] that can be executed.\n
        limit: Int? = null,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteWhere().(limit)
//            display_name limit
//            documentation ```kotlin\nlimit: Int? = ...\n```
//             ^^^^ reference semanticdb maven . . kotlin/Int#
        op: T.(ISqlExpressionBuilder) -> Op<Boolean>
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteWhere().(op)
//         display_name op
//         documentation ```kotlin\nop: T.(ISqlExpressionBuilder) -> Op<Boolean>\n```
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
    ): DeleteStatement {
//     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#
        return DeleteStatement(this, op(SqlExpressionBuilder), false, limit, emptyList())
//             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().
//                                   ^^ reference semanticdb maven . . kotlin/Function2#invoke().
//                                   ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteWhere().(op)
//                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteWhere().(limit)
//                                                                           ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
    }

    /**
     * Represents the SQL statement that deletes only rows in a table that match the provided [op], while ignoring any
     * possible errors that occur during the process.
     *
     * **Note:** `DELETE IGNORE` is not supported by all vendors. Please check the documentation.
     *
     * @param limit Maximum number of rows to delete.
     * @param op Condition that determines which rows to delete.
     * @return A [DeleteStatement] that can be executed.
     */
    fun <T : Table> T.deleteIgnoreWhere(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteIgnoreWhere().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteIgnoreWhere().
//                                      display_name deleteIgnoreWhere
//                                      documentation ```kotlin\npublic open fun <T : Table> T.deleteIgnoreWhere(limit: Int? = ..., op: T.(ISqlExpressionBuilder) -> Op<Boolean>): DeleteStatement\n```\n\n----\n\n\n Represents the SQL statement that deletes only rows in a table that match the provided [op], while ignoring any\n possible errors that occur during the process.\n\n **Note:** `DELETE IGNORE` is not supported by all vendors. Please check the documentation.\n\n @param limit Maximum number of rows to delete.\n @param op Condition that determines which rows to delete.\n @return A [DeleteStatement] that can be executed.\n
        limit: Int? = null,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteIgnoreWhere().(limit)
//            display_name limit
//            documentation ```kotlin\nlimit: Int? = ...\n```
//             ^^^^ reference semanticdb maven . . kotlin/Int#
        op: T.(ISqlExpressionBuilder) -> Op<Boolean>
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteIgnoreWhere().(op)
//         display_name op
//         documentation ```kotlin\nop: T.(ISqlExpressionBuilder) -> Op<Boolean>\n```
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
    ): DeleteStatement {
//     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#
        return DeleteStatement(this, op(SqlExpressionBuilder), true, limit, emptyList())
//             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().
//                                   ^^ reference semanticdb maven . . kotlin/Function2#invoke().
//                                   ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteIgnoreWhere().(op)
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteIgnoreWhere().(limit)
//                                                                          ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
    }

    /**
     * Represents the SQL statement that deletes all rows in a table.
     *
     * @return A [DeleteStatement] that can be executed.
     */
    fun <T : Table> T.deleteAll(): DeleteStatement = DeleteStatement(this)
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteAll().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteAll().
//                              display_name deleteAll
//                              documentation ```kotlin\npublic open fun <T : Table> T.deleteAll(): DeleteStatement\n```\n\n----\n\n\n Represents the SQL statement that deletes all rows in a table.\n\n @return A [DeleteStatement] that can be executed.\n
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#
//                                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().

    /**
     * Represents the SQL statement that deletes rows in a table and returns specified data from the deleted rows.
     *
     * @param returning Columns and expressions to include in the returned data. This defaults to all columns in the table.
     * @param where Condition that determines which rows to delete. If left as `null`, all rows in the table will be deleted.
     * @return A [ReturningStatement] that can be executed once iterated over.
     */
    fun <T : Table> T.deleteReturning(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteReturning().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteReturning().
//                                    display_name deleteReturning
//                                    documentation ```kotlin\npublic open fun <T : Table> T.deleteReturning(returning: List<Expression<*>> = ..., where: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...): ReturningStatement\n```\n\n----\n\n\n Represents the SQL statement that deletes rows in a table and returns specified data from the deleted rows.\n\n @param returning Columns and expressions to include in the returned data. This defaults to all columns in the table.\n @param where Condition that determines which rows to delete. If left as `null`, all rows in the table will be deleted.\n @return A [ReturningStatement] that can be executed once iterated over.\n
        returning: List<Expression<*>> = columns,
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteReturning().(returning)
//                display_name returning
//                documentation ```kotlin\nreturning: List<Expression<*>> = ...\n```
//                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
        where: (SqlExpressionBuilder.() -> Op<Boolean>)? = null
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteReturning().(where)
//            display_name where
//            documentation ```kotlin\nwhere: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
    ): ReturningStatement {
//     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#
        val delete = DeleteStatement(this, where?.let { SqlExpressionBuilder.it() }, false, null)
//          ^^^^^^ definition local 0
//                 display_name delete
//                 documentation ```kotlin\nlocal val delete: DeleteStatement\n```
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteReturning().(where)
//                                                ^^^ reference semanticdb maven . . kotlin/let().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                  display_name it
//                                                                                  documentation ```kotlin\nit: List<Pair<Column<*>, Any?>>\n```
//                                                                           ^^ reference semanticdb maven . . (it)
//                                                                           ^^ reference semanticdb maven . . kotlin/Function1#invoke().
        return ReturningStatement(this, returning, delete)
//             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#`<init>`().
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#deleteReturning().(returning)
//                                                 ^^^^^^ reference local 0
    }

    /**
     * Represents the SQL statement that deletes rows from a table in a join relation.
     *
     * @param targetTable The specific table from this join relation to delete rows from.
     * @param targetTables (Optional) Other tables from this join relation to delete rows from.
     * **Note** Targeting multiple tables for deletion is not supported by all vendors. Please check the documentation.
     * @param ignore Whether to ignore any possible errors that occur when deleting rows.
     * **Note** [ignore] is not supported by all vendors. Please check the documentation.
     * @param limit Maximum number of rows to delete.
     * **Note** [limit] is not supported by all vendors. Please check the documentation.
     * @param where Condition that determines which rows to delete. If left as `null`, all rows will be deleted.
     * @return A [DeleteStatement] that can be executed.
     */
    fun Join.delete(
//           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#delete().
//                  display_name delete
//                  documentation ```kotlin\npublic open fun Join.delete(targetTable: Table, vararg targetTables: Table, ignore: Boolean = ..., limit: Int? = ..., where: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...): DeleteStatement\n```\n\n----\n\n\n Represents the SQL statement that deletes rows from a table in a join relation.\n\n @param targetTable The specific table from this join relation to delete rows from.\n @param targetTables (Optional) Other tables from this join relation to delete rows from.\n **Note** Targeting multiple tables for deletion is not supported by all vendors. Please check the documentation.\n @param ignore Whether to ignore any possible errors that occur when deleting rows.\n **Note** [ignore] is not supported by all vendors. Please check the documentation.\n @param limit Maximum number of rows to delete.\n **Note** [limit] is not supported by all vendors. Please check the documentation.\n @param where Condition that determines which rows to delete. If left as `null`, all rows will be deleted.\n @return A [DeleteStatement] that can be executed.\n
        targetTable: Table,
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#delete().(targetTable)
//                  display_name targetTable
//                  documentation ```kotlin\ntargetTable: Table\n```
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
        vararg targetTables: Table,
//             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#delete().(targetTables)
//                          display_name targetTables
//                          documentation ```kotlin\nvararg targetTables: Table\n```
//                           ^^^^^ reference semanticdb maven . . kotlin/Array#
        ignore: Boolean = false,
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#delete().(ignore)
//             display_name ignore
//             documentation ```kotlin\nignore: Boolean = ...\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        limit: Int? = null,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#delete().(limit)
//            display_name limit
//            documentation ```kotlin\nlimit: Int? = ...\n```
//             ^^^^ reference semanticdb maven . . kotlin/Int#
        where: (SqlExpressionBuilder.() -> Op<Boolean>)? = null
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#delete().(where)
//            display_name where
//            documentation ```kotlin\nwhere: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
    ): DeleteStatement {
//     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#
        val targets = listOf(targetTable) + targetTables
//          ^^^^^^^ definition local 1
//                  display_name targets
//                  documentation ```kotlin\nlocal val targets: List<Table>\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#delete().(targetTable)
//                                        ^ reference semanticdb maven . . kotlin/collections/plus(+30).
//                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#delete().(targetTables)
        return DeleteStatement(this, where?.let { SqlExpressionBuilder.it() }, ignore, limit, targets)
//             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#delete().(where)
//                                          ^^^ reference semanticdb maven . . kotlin/let().
//                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                            display_name it
//                                                                            documentation ```kotlin\nit: List<Pair<Column<*>, Any?>>\n```
//                                                                     ^^ reference semanticdb maven . . (it)
//                                                                     ^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#delete().(ignore)
//                                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#delete().(limit)
//                                                                                            ^^^^^^^ reference local 1
    }

    /**
     * Represents the SQL statement that inserts a new row into a table.
     *
     * @return Am [InsertStatement] that can be executed.
     */
    fun <T : Table> T.insert(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insert().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insert().
//                           display_name insert
//                           documentation ```kotlin\npublic open fun <T : Table> T.insert(body: T.(InsertStatement<Number>) -> Unit): InsertStatement<Number>\n```\n\n----\n\n\n Represents the SQL statement that inserts a new row into a table.\n\n @return Am [InsertStatement] that can be executed.\n
        body: T.(InsertStatement<Number>) -> Unit
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insert().(body)
//           display_name body
//           documentation ```kotlin\nbody: T.(InsertStatement<Number>) -> Unit\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
    ): InsertStatement<Number> {
//     ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#
        return InsertStatement<Number>(this).apply { body(this) }
//             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().
//                                           ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                   ^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insert().(body)
    }

    /**
     * Represents the SQL statement that inserts a new row into a table, while ignoring any possible errors that occur
     * during the process.
     *
     * For example, if the new row would violate a unique constraint, its insertion would be ignored.
     * **Note:** `INSERT IGNORE` is not supported by all vendors. Please check the documentation.
     *
     * @return An [InsertStatement] that can be executed.
     */
    fun <T : Table> T.insertIgnore(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertIgnore().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertIgnore().
//                                 display_name insertIgnore
//                                 documentation ```kotlin\npublic open fun <T : Table> T.insertIgnore(body: T.(UpdateBuilder<*>) -> Unit): InsertStatement<Long>\n```\n\n----\n\n\n Represents the SQL statement that inserts a new row into a table, while ignoring any possible errors that occur\n during the process.\n\n For example, if the new row would violate a unique constraint, its insertion would be ignored.\n **Note:** `INSERT IGNORE` is not supported by all vendors. Please check the documentation.\n\n @return An [InsertStatement] that can be executed.\n
        body: T.(UpdateBuilder<*>) -> Unit
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertIgnore().(body)
//           display_name body
//           documentation ```kotlin\nbody: T.(UpdateBuilder<*>) -> Unit\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
    ): InsertStatement<Long> {
//     ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#
        return InsertStatement<Long>(this, true).apply { body(this) }
//             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().
//                                               ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                       ^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertIgnore().(body)
    }

    /**
     * Represents the SQL statement that uses data retrieved from a [selectQuery] to insert new rows into a table.
     *
     * @param selectQuery Source `SELECT` query that provides the values to insert.
     * @param columns Columns to insert the values into. This defaults to all columns in the table that are not
     * auto-increment columns without a valid sequence to generate new values.
     * @return An [InsertSelectStatement] that can be executed.
     */
    fun <T : Table> T.insert(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insert(+1).[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insert(+1).
//                           display_name insert
//                           documentation ```kotlin\npublic open fun <T : Table> T.insert(selectQuery: AbstractQuery<*>, columns: List<Column<*>>? = ...): InsertSelectStatement\n```\n\n----\n\n\n Represents the SQL statement that uses data retrieved from a [selectQuery] to insert new rows into a table.\n\n @param selectQuery Source `SELECT` query that provides the values to insert.\n @param columns Columns to insert the values into. This defaults to all columns in the table that are not\n auto-increment columns without a valid sequence to generate new values.\n @return An [InsertSelectStatement] that can be executed.\n
        selectQuery: AbstractQuery<*>,
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insert(+1).(selectQuery)
//                  display_name selectQuery
//                  documentation ```kotlin\nselectQuery: AbstractQuery<*>\n```
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
        columns: List<Column<*>>? = null
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insert(+1).(columns)
//              display_name columns
//              documentation ```kotlin\ncolumns: List<Column<*>>? = ...\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
    ): org.jetbrains.exposed.v1.core.statements.InsertSelectStatement {
//     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#
        val columnsToReplace = columns ?: this.columns.filter { it.isValidIfAutoIncrement() }
//          ^^^^^^^^^^^^^^^^ definition local 2
//                           display_name columnsToReplace
//                           documentation ```kotlin\nlocal val columnsToReplace: List<Column<*>>\n```
//                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insert(+1).(columns)
//                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                                                     ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                            display_name it
//                                                                                            documentation ```kotlin\nit: List<Pair<Column<*>, Any?>>\n```
//                                                              ^^ reference semanticdb maven . . (it)
//                                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#isValidIfAutoIncrement().
        return org.jetbrains.exposed.v1.core.statements.InsertSelectStatement(columnsToReplace, selectQuery, false)
//                                                      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().
//                                                                            ^^^^^^^^^^^^^^^^ reference local 2
//                                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insert(+1).(selectQuery)
    }

    /**
     * Represents the SQL statement that uses data retrieved from a [selectQuery] to insert new rows into a table,
     * while ignoring any possible errors that occur during the process.
     *
     * **Note:** `INSERT IGNORE` is not supported by all vendors. Please check the documentation.
     *
     * @param selectQuery Source `SELECT` query that provides the values to insert.
     * @param columns Columns to insert the values into. This defaults to all columns in the table that are not
     * auto-increment columns without a valid sequence to generate new values.
     * @return An [InsertSelectStatement] that can be executed.
     */
    fun <T : Table> T.insertIgnore(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertIgnore(+1).[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertIgnore(+1).
//                                 display_name insertIgnore
//                                 documentation ```kotlin\npublic open fun <T : Table> T.insertIgnore(selectQuery: AbstractQuery<*>, columns: List<Column<*>>? = ...): InsertSelectStatement\n```\n\n----\n\n\n Represents the SQL statement that uses data retrieved from a [selectQuery] to insert new rows into a table,\n while ignoring any possible errors that occur during the process.\n\n **Note:** `INSERT IGNORE` is not supported by all vendors. Please check the documentation.\n\n @param selectQuery Source `SELECT` query that provides the values to insert.\n @param columns Columns to insert the values into. This defaults to all columns in the table that are not\n auto-increment columns without a valid sequence to generate new values.\n @return An [InsertSelectStatement] that can be executed.\n
        selectQuery: AbstractQuery<*>,
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertIgnore(+1).(selectQuery)
//                  display_name selectQuery
//                  documentation ```kotlin\nselectQuery: AbstractQuery<*>\n```
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
        columns: List<Column<*>>? = null
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertIgnore(+1).(columns)
//              display_name columns
//              documentation ```kotlin\ncolumns: List<Column<*>>? = ...\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
    ): org.jetbrains.exposed.v1.core.statements.InsertSelectStatement {
//     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#
        val columnsToReplace = columns ?: this.columns.filter { it.isValidIfAutoIncrement() }
//          ^^^^^^^^^^^^^^^^ definition local 3
//                           display_name columnsToReplace
//                           documentation ```kotlin\nlocal val columnsToReplace: List<Column<*>>\n```
//                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertIgnore(+1).(columns)
//                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                                                     ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                            display_name it
//                                                                                            documentation ```kotlin\nit: List<Pair<Column<*>, Any?>>\n```
//                                                              ^^ reference semanticdb maven . . (it)
//                                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#isValidIfAutoIncrement().
        return org.jetbrains.exposed.v1.core.statements.InsertSelectStatement(columnsToReplace, selectQuery, true)
//                                                      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#`<init>`().
//                                                                            ^^^^^^^^^^^^^^^^ reference local 3
//                                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertIgnore(+1).(selectQuery)
    }

    /**
     * Represents the SQL statement that inserts new rows into a table and returns specified data from the inserted rows.
     *
     * @param returning Columns and expressions to include in the returned data. This defaults to all columns in the table.
     * @param ignoreErrors Whether to ignore any possible errors that occur during the process.
     * Note `INSERT IGNORE` is not supported by all vendors. Please check the documentation.
     * @return A [ReturningStatement] that can be executed once iterated over.
     */
    fun <T : Table> T.insertReturning(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertReturning().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertReturning().
//                                    display_name insertReturning
//                                    documentation ```kotlin\npublic open fun <T : Table> T.insertReturning(returning: List<Expression<*>> = ..., ignoreErrors: Boolean = ..., body: T.(InsertStatement<Number>) -> Unit): ReturningStatement\n```\n\n----\n\n\n Represents the SQL statement that inserts new rows into a table and returns specified data from the inserted rows.\n\n @param returning Columns and expressions to include in the returned data. This defaults to all columns in the table.\n @param ignoreErrors Whether to ignore any possible errors that occur during the process.\n Note `INSERT IGNORE` is not supported by all vendors. Please check the documentation.\n @return A [ReturningStatement] that can be executed once iterated over.\n
        returning: List<Expression<*>> = columns,
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertReturning().(returning)
//                display_name returning
//                documentation ```kotlin\nreturning: List<Expression<*>> = ...\n```
//                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
        ignoreErrors: Boolean = false,
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertReturning().(ignoreErrors)
//                   display_name ignoreErrors
//                   documentation ```kotlin\nignoreErrors: Boolean = ...\n```
//                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        body: T.(InsertStatement<Number>) -> Unit
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertReturning().(body)
//           display_name body
//           documentation ```kotlin\nbody: T.(InsertStatement<Number>) -> Unit\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
    ): ReturningStatement {
//     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#
        val insert = InsertStatement<Number>(this, ignoreErrors)
//          ^^^^^^ definition local 4
//                 display_name insert
//                 documentation ```kotlin\nlocal val insert: InsertStatement<Number>\n```
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().
//                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertReturning().(ignoreErrors)
        body(insert)
//      ^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertReturning().(body)
//           ^^^^^^ reference local 4
        return ReturningStatement(this, returning, insert)
//             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#`<init>`().
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#insertReturning().(returning)
//                                                 ^^^^^^ reference local 4
    }

    /**
     * Represents the SQL statement that batch inserts new rows into a table.
     *
     * @param ignoreErrors Whether to ignore errors or not.
     * **Note** [ignoreErrors] is not supported by all vendors. Please check the documentation.
     * @param shouldReturnGeneratedValues Specifies whether newly generated values (for example, auto-incremented IDs)
     * should be returned.
     * @return A [BatchInsertStatement] that can be executed.
     */
    fun <T : Table, E> T.batchInsert(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchInsert().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchInsert().[E]
//                    display_name FirTypeParameterSymbol E
//                    documentation ```kotlin\nE\n```
//                       ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchInsert().
//                                   display_name batchInsert
//                                   documentation ```kotlin\npublic open fun <T : Table, E> T.batchInsert(ignoreErrors: Boolean = ..., shouldReturnGeneratedValues: Boolean = ..., body: BatchInsertStatement.(E) -> Unit): BatchInsertStatement\n```\n\n----\n\n\n Represents the SQL statement that batch inserts new rows into a table.\n\n @param ignoreErrors Whether to ignore errors or not.\n **Note** [ignoreErrors] is not supported by all vendors. Please check the documentation.\n @param shouldReturnGeneratedValues Specifies whether newly generated values (for example, auto-incremented IDs)\n should be returned.\n @return A [BatchInsertStatement] that can be executed.\n
        ignoreErrors: Boolean = false,
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchInsert().(ignoreErrors)
//                   display_name ignoreErrors
//                   documentation ```kotlin\nignoreErrors: Boolean = ...\n```
//                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        shouldReturnGeneratedValues: Boolean = true,
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchInsert().(shouldReturnGeneratedValues)
//                                  display_name shouldReturnGeneratedValues
//                                  documentation ```kotlin\nshouldReturnGeneratedValues: Boolean = ...\n```
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        body: BatchInsertStatement.(E) -> Unit
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchInsert().(body)
//           display_name body
//           documentation ```kotlin\nbody: BatchInsertStatement.(E) -> Unit\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
    ): BatchInsertStatement {
//     ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#
        return if (currentDialect is SQLServerDialect && autoIncColumn != null) {
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncColumn.
//                                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getAutoIncColumn().
            SQLServerBatchInsertStatement(this, ignoreErrors, shouldReturnGeneratedValues)
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#`<init>`().
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchInsert().(ignoreErrors)
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchInsert().(shouldReturnGeneratedValues)
        } else {
            BatchInsertStatement(this, ignoreErrors, shouldReturnGeneratedValues)
//          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#`<init>`().
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchInsert().(ignoreErrors)
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchInsert().(shouldReturnGeneratedValues)
        }
    }

    /**
     * Represents the SQL statement that either inserts a new row into a table, or, if insertion would violate a unique constraint,
     * first deletes the existing row before inserting a new row.
     *
     * **Note:** This operation is not supported by all vendors, please check the documentation.
     *
     * @return A [ReplaceStatement] that can be executed.
     */
    fun <T : Table> T.replace(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#replace().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#replace().
//                            display_name replace
//                            documentation ```kotlin\npublic open fun <T : Table> T.replace(body: T.(UpdateBuilder<*>) -> Unit): ReplaceStatement<Long>\n```\n\n----\n\n\n Represents the SQL statement that either inserts a new row into a table, or, if insertion would violate a unique constraint,\n first deletes the existing row before inserting a new row.\n\n **Note:** This operation is not supported by all vendors, please check the documentation.\n\n @return A [ReplaceStatement] that can be executed.\n
        body: T.(UpdateBuilder<*>) -> Unit
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#replace().(body)
//           display_name body
//           documentation ```kotlin\nbody: T.(UpdateBuilder<*>) -> Unit\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
    ): ReplaceStatement<Long> {
//     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#
        return ReplaceStatement<Long>(this).apply { body(this) }
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#`<init>`().
//                                          ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                  ^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#replace().(body)
    }

    /**
     * Represents the SQL statement that uses data retrieved from a [selectQuery] to either insert a new row into a table,
     * or, if insertion would violate a unique constraint, first delete the existing row before inserting a new row.
     *
     * **Note:** This operation is not supported by all vendors, please check the documentation.
     *
     * @param selectQuery Source `SELECT` query that provides the values to insert.
     * @param columns Columns to either insert values into or delete values from then insert into. This defaults to all
     * columns in the table that are not auto-increment columns without a valid sequence to generate new values.
     * @return A [ReplaceSelectStatement] that can be executed.
     */
    fun <T : Table> T.replace(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#replace(+1).[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#replace(+1).
//                            display_name replace
//                            documentation ```kotlin\npublic open fun <T : Table> T.replace(selectQuery: AbstractQuery<*>, columns: List<Column<*>>? = ...): ReplaceSelectStatement\n```\n\n----\n\n\n Represents the SQL statement that uses data retrieved from a [selectQuery] to either insert a new row into a table,\n or, if insertion would violate a unique constraint, first delete the existing row before inserting a new row.\n\n **Note:** This operation is not supported by all vendors, please check the documentation.\n\n @param selectQuery Source `SELECT` query that provides the values to insert.\n @param columns Columns to either insert values into or delete values from then insert into. This defaults to all\n columns in the table that are not auto-increment columns without a valid sequence to generate new values.\n @return A [ReplaceSelectStatement] that can be executed.\n
        selectQuery: AbstractQuery<*>,
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#replace(+1).(selectQuery)
//                  display_name selectQuery
//                  documentation ```kotlin\nselectQuery: AbstractQuery<*>\n```
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
        columns: List<Column<*>>? = null
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#replace(+1).(columns)
//              display_name columns
//              documentation ```kotlin\ncolumns: List<Column<*>>? = ...\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
    ): ReplaceSelectStatement {
//     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#
        val columnsToReplace = columns ?: this.columns.filter { it.isValidIfAutoIncrement() }
//          ^^^^^^^^^^^^^^^^ definition local 5
//                           display_name columnsToReplace
//                           documentation ```kotlin\nlocal val columnsToReplace: List<Column<*>>\n```
//                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#replace(+1).(columns)
//                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                                                     ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                            display_name it
//                                                                                            documentation ```kotlin\nit: List<Pair<Column<*>, Any?>>\n```
//                                                              ^^ reference semanticdb maven . . (it)
//                                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#isValidIfAutoIncrement().
        return ReplaceSelectStatement(columnsToReplace, selectQuery)
//             ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#`<init>`().
//                                    ^^^^^^^^^^^^^^^^ reference local 5
//                                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#replace(+1).(selectQuery)
    }

    /**
     * Represents the SQL statement that either batch inserts new rows into a table, or, if insertions violate unique constraints,
     * first deletes the existing rows before inserting new rows.
     *
     * **Note:** This operation is not supported by all vendors, please check the documentation.
     *
     * @param shouldReturnGeneratedValues Specifies whether newly generated values (for example, auto-incremented IDs)
     * should be returned.
     * @return A [BatchReplaceStatement] that can be executed.
     */
    fun <T : Table, E : Any> T.batchReplace(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchReplace().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchReplace().[E]
//                    display_name FirTypeParameterSymbol E
//                    documentation ```kotlin\nE : Any\n```
//                             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchReplace().
//                                          display_name batchReplace
//                                          documentation ```kotlin\npublic open fun <T : Table, E : Any> T.batchReplace(shouldReturnGeneratedValues: Boolean = ..., body: BatchReplaceStatement.(E) -> Unit): BatchReplaceStatement\n```\n\n----\n\n\n Represents the SQL statement that either batch inserts new rows into a table, or, if insertions violate unique constraints,\n first deletes the existing rows before inserting new rows.\n\n **Note:** This operation is not supported by all vendors, please check the documentation.\n\n @param shouldReturnGeneratedValues Specifies whether newly generated values (for example, auto-incremented IDs)\n should be returned.\n @return A [BatchReplaceStatement] that can be executed.\n
        shouldReturnGeneratedValues: Boolean = true,
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchReplace().(shouldReturnGeneratedValues)
//                                  display_name shouldReturnGeneratedValues
//                                  documentation ```kotlin\nshouldReturnGeneratedValues: Boolean = ...\n```
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        body: BatchReplaceStatement.(E) -> Unit
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchReplace().(body)
//           display_name body
//           documentation ```kotlin\nbody: BatchReplaceStatement.(E) -> Unit\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
    ): BatchReplaceStatement {
//     ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#
        return BatchReplaceStatement(this, shouldReturnGeneratedValues)
//             ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#`<init>`().
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchReplace().(shouldReturnGeneratedValues)
    }

    /**
     * Represents the SQL statement that updates rows of a table.
     *
     * @param where Condition that determines which rows to update. If left `null`, all columns will be updated.
     * @param limit Maximum number of rows to update.
     * @return An [UpdateStatement] that can be executed.
     */
    fun <T : Table> T.update(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#update().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#update().
//                           display_name update
//                           documentation ```kotlin\npublic open fun <T : Table> T.update(where: (SqlExpressionBuilder.() -> Op<Boolean>)? = ..., limit: Int? = ..., body: T.(UpdateStatement) -> Unit): UpdateStatement\n```\n\n----\n\n\n Represents the SQL statement that updates rows of a table.\n\n @param where Condition that determines which rows to update. If left `null`, all columns will be updated.\n @param limit Maximum number of rows to update.\n @return An [UpdateStatement] that can be executed.\n
        where: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#update().(where)
//            display_name where
//            documentation ```kotlin\nwhere: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
        limit: Int? = null,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#update().(limit)
//            display_name limit
//            documentation ```kotlin\nlimit: Int? = ...\n```
//             ^^^^ reference semanticdb maven . . kotlin/Int#
        body: T.(UpdateStatement) -> Unit
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#update().(body)
//           display_name body
//           documentation ```kotlin\nbody: T.(UpdateStatement) -> Unit\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
    ): UpdateStatement {
//     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#
        return UpdateStatement(this, limit, where?.let { SqlExpressionBuilder.it() }).apply { body(this) }
//             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#`<init>`().
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#update().(limit)
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#update().(where)
//                                                 ^^^ reference semanticdb maven . . kotlin/let().
//                                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                   display_name it
//                                                                                   documentation ```kotlin\nit: List<Pair<Column<*>, Any?>>\n```
//                                                                            ^^ reference semanticdb maven . . (it)
//                                                                            ^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                                    ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                                                            ^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//                                                                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#update().(body)
    }

    /**
     * Represents the SQL statement that updates rows of a join relation.
     *
     * @param where Condition that determines which rows to update. If left `null`, all columns will be updated.
     * @param limit Maximum number of rows to update.
     * @return An [UpdateStatement] that can be executed.
     */
    fun Join.update(
//           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#update(+1).
//                  display_name update
//                  documentation ```kotlin\npublic open fun Join.update(where: (SqlExpressionBuilder.() -> Op<Boolean>)? = ..., limit: Int? = ..., body: (UpdateStatement) -> Unit): UpdateStatement\n```\n\n----\n\n\n Represents the SQL statement that updates rows of a join relation.\n\n @param where Condition that determines which rows to update. If left `null`, all columns will be updated.\n @param limit Maximum number of rows to update.\n @return An [UpdateStatement] that can be executed.\n
        where: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#update(+1).(where)
//            display_name where
//            documentation ```kotlin\nwhere: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
        limit: Int? = null,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#update(+1).(limit)
//            display_name limit
//            documentation ```kotlin\nlimit: Int? = ...\n```
//             ^^^^ reference semanticdb maven . . kotlin/Int#
        body: (UpdateStatement) -> Unit
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#update(+1).(body)
//           display_name body
//           documentation ```kotlin\nbody: (UpdateStatement) -> Unit\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
    ): UpdateStatement {
//     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#
        return UpdateStatement(this, limit, where?.let { SqlExpressionBuilder.it() }).apply(body)
//             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#`<init>`().
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#update(+1).(limit)
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#update(+1).(where)
//                                                 ^^^ reference semanticdb maven . . kotlin/let().
//                                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                   display_name it
//                                                                                   documentation ```kotlin\nit: List<Pair<Column<*>, Any?>>\n```
//                                                                            ^^ reference semanticdb maven . . (it)
//                                                                            ^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                                    ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#update(+1).(body)
    }

    /**
     * Represents the SQL statement that updates rows of a table and returns specified data from the updated rows.
     *
     * @param returning Columns and expressions to include in the returned data. This defaults to all columns in the table.
     * @param where Condition that determines which rows to update. If left `null`, all columns will be updated.
     * @return A [ReturningStatement] that can be executed once iterated over.
     */
    fun <T : Table> T.updateReturning(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#updateReturning().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#updateReturning().
//                                    display_name updateReturning
//                                    documentation ```kotlin\npublic open fun <T : Table> T.updateReturning(returning: List<Expression<*>> = ..., where: (SqlExpressionBuilder.() -> Op<Boolean>)? = ..., body: T.(UpdateStatement) -> Unit): ReturningStatement\n```\n\n----\n\n\n Represents the SQL statement that updates rows of a table and returns specified data from the updated rows.\n\n @param returning Columns and expressions to include in the returned data. This defaults to all columns in the table.\n @param where Condition that determines which rows to update. If left `null`, all columns will be updated.\n @return A [ReturningStatement] that can be executed once iterated over.\n
        returning: List<Expression<*>> = columns,
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#updateReturning().(returning)
//                display_name returning
//                documentation ```kotlin\nreturning: List<Expression<*>> = ...\n```
//                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
        where: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#updateReturning().(where)
//            display_name where
//            documentation ```kotlin\nwhere: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
        body: T.(UpdateStatement) -> Unit
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#updateReturning().(body)
//           display_name body
//           documentation ```kotlin\nbody: T.(UpdateStatement) -> Unit\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
    ): ReturningStatement {
//     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#
        val update = UpdateStatement(this, null, where?.let { SqlExpressionBuilder.it() })
//          ^^^^^^ definition local 6
//                 display_name update
//                 documentation ```kotlin\nlocal val update: UpdateStatement\n```
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#`<init>`().
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#updateReturning().(where)
//                                                      ^^^ reference semanticdb maven . . kotlin/let().
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                        display_name it
//                                                                                        documentation ```kotlin\nit: List<Pair<Column<*>, Any?>>\n```
//                                                                                 ^^ reference semanticdb maven . . (it)
//                                                                                 ^^ reference semanticdb maven . . kotlin/Function1#invoke().
        body(update)
//      ^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#updateReturning().(body)
//           ^^^^^^ reference local 6
        return ReturningStatement(this, returning, update)
//             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#`<init>`().
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#updateReturning().(returning)
//                                                 ^^^^^^ reference local 6
    }

    /**
     * Represents the SQL statement that either inserts a new row into a table, or updates the existing row if insertion would violate a unique constraint.
     *
     * **Note:** Vendors that do not support this operation directly implement the standard MERGE USING command.
     *
     * @param keys (optional) Columns to include in the condition that determines a unique constraint match.
     * If no columns are provided, primary keys will be used. If the table does not have any primary keys, the first unique index will be attempted.
     * @param onUpdate Lambda block with an [UpdateStatement] as its argument, allowing values to be assigned to the UPDATE clause.
     * To specify manually that the insert value should be used when updating a column, for example within an expression
     * or function, invoke `insertValue()` with the desired column as the function argument.
     * If left `null`, all columns will be updated with the values provided for the insert.
     * @param onUpdateExclude List of specific columns to exclude from updating.
     * If left `null`, all columns will be updated with the values provided for the insert.
     * @param where Condition that determines which rows to update, if a unique violation is found.
     * @return An [UpsertStatement] that can be executed.
     */
    fun <T : Table> T.upsert(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsert().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsert().
//                           display_name upsert
//                           documentation ```kotlin\npublic open fun <T : Table> T.upsert(vararg keys: Column<*>, onUpdate: (UpsertBuilder.(UpdateStatement) -> Unit)? = ..., onUpdateExclude: List<Column<*>>? = ..., where: (SqlExpressionBuilder.() -> Op<Boolean>)? = ..., body: T.(UpsertStatement<Long>) -> Unit): UpsertStatement<Long>\n```\n\n----\n\n\n Represents the SQL statement that either inserts a new row into a table, or updates the existing row if insertion would violate a unique constraint.\n\n **Note:** Vendors that do not support this operation directly implement the standard MERGE USING command.\n\n @param keys (optional) Columns to include in the condition that determines a unique constraint match.\n If no columns are provided, primary keys will be used. If the table does not have any primary keys, the first unique index will be attempted.\n @param onUpdate Lambda block with an [UpdateStatement] as its argument, allowing values to be assigned to the UPDATE clause.\n To specify manually that the insert value should be used when updating a column, for example within an expression\n or function, invoke `insertValue()` with the desired column as the function argument.\n If left `null`, all columns will be updated with the values provided for the insert.\n @param onUpdateExclude List of specific columns to exclude from updating.\n If left `null`, all columns will be updated with the values provided for the insert.\n @param where Condition that determines which rows to update, if a unique violation is found.\n @return An [UpsertStatement] that can be executed.\n
        vararg keys: Column<*>,
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsert().(keys)
//                  display_name keys
//                  documentation ```kotlin\nvararg keys: Column<*>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
        onUpdate: (UpsertBuilder.(UpdateStatement) -> Unit)? = null,
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsert().(onUpdate)
//               display_name onUpdate
//               documentation ```kotlin\nonUpdate: (UpsertBuilder.(UpdateStatement) -> Unit)? = ...\n```
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
        onUpdateExclude: List<Column<*>>? = null,
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsert().(onUpdateExclude)
//                      display_name onUpdateExclude
//                      documentation ```kotlin\nonUpdateExclude: List<Column<*>>? = ...\n```
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        where: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsert().(where)
//            display_name where
//            documentation ```kotlin\nwhere: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
        body: T.(UpsertStatement<Long>) -> Unit
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsert().(body)
//           display_name body
//           documentation ```kotlin\nbody: T.(UpsertStatement<Long>) -> Unit\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
    ): UpsertStatement<Long> {
//     ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#
        return UpsertStatement<Long>(
//             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`().
            table = this,
            keys = keys,
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsert().(keys)
            onUpdateExclude = onUpdateExclude,
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsert().(onUpdateExclude)
            where = where?.let { SqlExpressionBuilder.it() }
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsert().(where)
//                         ^^^ reference semanticdb maven . . kotlin/let().
//                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                           display_name it
//                                                           documentation ```kotlin\nit: List<Pair<Column<*>, Any?>>\n```
//                                                    ^^ reference semanticdb maven . . (it)
//                                                    ^^ reference semanticdb maven . . kotlin/Function1#invoke().
        ).apply {
//        ^^^^^ reference semanticdb maven . . kotlin/apply().
            onUpdate?.let { storeUpdateValues(it) }
//          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsert().(onUpdate)
//                    ^^^ reference semanticdb maven . . kotlin/let().
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                  display_name it
//                                                  documentation ```kotlin\nit: List<Pair<Column<*>, Any?>>\n```
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#storeUpdateValues().
//                                            ^^ reference semanticdb maven . . (it)
            body(this)
//          ^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsert().(body)
        }
    }

    /**
     * Represents the SQL statement that either inserts a new row into a table, or updates the existing row if insertion would
     * violate a unique constraint, and also returns specified data from the modified rows.
     *
     * @param keys (optional) Columns to include in the condition that determines a unique constraint match. If no columns are
     * provided, primary keys will be used. If the table does not have any primary keys, the first unique index will be attempted.
     * @param returning Columns and expressions to include in the returned data. This defaults to all columns in the table.
     * @param onUpdate Lambda block with an [UpdateStatement] as its argument, allowing values to be assigned to the UPDATE clause.
     * To specify manually that the insert value should be used when updating a column, for example within an expression
     * or function, invoke `insertValue()` with the desired column as the function argument.
     * If left null, all columns will be updated with the values provided for the insert.
     * @param onUpdateExclude List of specific columns to exclude from updating.
     * If left null, all columns will be updated with the values provided for the insert.
     * @param where Condition that determines which rows to update, if a unique violation is found.
     * @return A [ReturningStatement] that can be executed once iterated over.
     */
    fun <T : Table> T.upsertReturning(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsertReturning().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsertReturning().
//                                    display_name upsertReturning
//                                    documentation ```kotlin\npublic open fun <T : Table> T.upsertReturning(vararg keys: Column<*>, returning: List<Expression<*>> = ..., onUpdate: (UpsertBuilder.(UpdateStatement) -> Unit)? = ..., onUpdateExclude: List<Column<*>>? = ..., where: (SqlExpressionBuilder.() -> Op<Boolean>)? = ..., body: T.(UpsertStatement<Long>) -> Unit): ReturningStatement\n```\n\n----\n\n\n Represents the SQL statement that either inserts a new row into a table, or updates the existing row if insertion would\n violate a unique constraint, and also returns specified data from the modified rows.\n\n @param keys (optional) Columns to include in the condition that determines a unique constraint match. If no columns are\n provided, primary keys will be used. If the table does not have any primary keys, the first unique index will be attempted.\n @param returning Columns and expressions to include in the returned data. This defaults to all columns in the table.\n @param onUpdate Lambda block with an [UpdateStatement] as its argument, allowing values to be assigned to the UPDATE clause.\n To specify manually that the insert value should be used when updating a column, for example within an expression\n or function, invoke `insertValue()` with the desired column as the function argument.\n If left null, all columns will be updated with the values provided for the insert.\n @param onUpdateExclude List of specific columns to exclude from updating.\n If left null, all columns will be updated with the values provided for the insert.\n @param where Condition that determines which rows to update, if a unique violation is found.\n @return A [ReturningStatement] that can be executed once iterated over.\n
        vararg keys: Column<*>,
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsertReturning().(keys)
//                  display_name keys
//                  documentation ```kotlin\nvararg keys: Column<*>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
        returning: List<Expression<*>> = columns,
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsertReturning().(returning)
//                display_name returning
//                documentation ```kotlin\nreturning: List<Expression<*>> = ...\n```
//                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
        onUpdate: (UpsertBuilder.(UpdateStatement) -> Unit)? = null,
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsertReturning().(onUpdate)
//               display_name onUpdate
//               documentation ```kotlin\nonUpdate: (UpsertBuilder.(UpdateStatement) -> Unit)? = ...\n```
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
        onUpdateExclude: List<Column<*>>? = null,
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsertReturning().(onUpdateExclude)
//                      display_name onUpdateExclude
//                      documentation ```kotlin\nonUpdateExclude: List<Column<*>>? = ...\n```
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        where: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsertReturning().(where)
//            display_name where
//            documentation ```kotlin\nwhere: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
        body: T.(UpsertStatement<Long>) -> Unit
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsertReturning().(body)
//           display_name body
//           documentation ```kotlin\nbody: T.(UpsertStatement<Long>) -> Unit\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
    ): ReturningStatement {
//     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#
        val upsert = UpsertStatement<Long>(
//          ^^^^^^ definition local 7
//                 display_name upsert
//                 documentation ```kotlin\nlocal val upsert: UpsertStatement<Long>\n```
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#`<init>`().
            table = this,
            keys = keys,
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsertReturning().(keys)
            onUpdateExclude = onUpdateExclude,
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsertReturning().(onUpdateExclude)
            where = where?.let { SqlExpressionBuilder.it() }
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsertReturning().(where)
//                         ^^^ reference semanticdb maven . . kotlin/let().
//                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                           display_name it
//                                                           documentation ```kotlin\nit: List<Pair<Column<*>, Any?>>\n```
//                                                    ^^ reference semanticdb maven . . (it)
//                                                    ^^ reference semanticdb maven . . kotlin/Function1#invoke().
        )
        onUpdate?.let { upsert.storeUpdateValues(it) }
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsertReturning().(onUpdate)
//                ^^^ reference semanticdb maven . . kotlin/let().
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                     display_name it
//                                                     documentation ```kotlin\nit: List<Pair<Column<*>, Any?>>\n```
//                      ^^^^^^ reference local 7
//                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#storeUpdateValues().
//                                               ^^ reference semanticdb maven . . (it)
        body(upsert)
//      ^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsertReturning().(body)
//           ^^^^^^ reference local 7
        return ReturningStatement(this, returning, upsert)
//             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#`<init>`().
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#upsertReturning().(returning)
//                                                 ^^^^^^ reference local 7
    }

    /**
     * Represents the SQL statement that either batch inserts new rows into a table, or updates the existing rows if insertions violate unique constraints.
     *
     * @param keys (optional) Columns to include in the condition that determines a unique constraint match. If no columns are provided,
     * primary keys will be used. If the table does not have any primary keys, the first unique index will be attempted.
     * @param onUpdate Lambda block with an [UpdateStatement] as its argument, allowing values to be assigned to the UPDATE clause.
     * To specify manually that the insert value should be used when updating a column, for example within an expression
     * or function, invoke `insertValue()` with the desired column as the function argument.
     * If left null, all columns will be updated with the values provided for the insert.
     * @param onUpdateExclude List of specific columns to exclude from updating.
     * If left null, all columns will be updated with the values provided for the insert.
     * @param where Condition that determines which rows to update, if a unique violation is found.
     * @param shouldReturnGeneratedValues Specifies whether newly generated values (for example, auto-incremented IDs)
     * should be returned.
     * @return A [BatchUpsertStatement] that can be executed.
     */
    @Suppress("LongParameterList")
    fun <T : Table, E> T.batchUpsert(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().[E]
//                    display_name FirTypeParameterSymbol E
//                    documentation ```kotlin\nE\n```
//                       ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().
//                                   display_name batchUpsert
//                                   documentation ```kotlin\n@Suppress(...) public open fun <T : Table, E> T.batchUpsert(onUpdateList: List<Pair<Column<*>, Any?>>? = ..., onUpdate: (UpsertBuilder.(UpdateStatement) -> Unit)? = ..., onUpdateExclude: List<Column<*>>? = ..., where: (SqlExpressionBuilder.() -> Op<Boolean>)? = ..., shouldReturnGeneratedValues: Boolean = ..., vararg keys: Column<*>, body: BatchUpsertStatement.(E) -> Unit): BatchUpsertStatement\n```\n\n----\n\n\n Represents the SQL statement that either batch inserts new rows into a table, or updates the existing rows if insertions violate unique constraints.\n\n @param keys (optional) Columns to include in the condition that determines a unique constraint match. If no columns are provided,\n primary keys will be used. If the table does not have any primary keys, the first unique index will be attempted.\n @param onUpdate Lambda block with an [UpdateStatement] as its argument, allowing values to be assigned to the UPDATE clause.\n To specify manually that the insert value should be used when updating a column, for example within an expression\n or function, invoke `insertValue()` with the desired column as the function argument.\n If left null, all columns will be updated with the values provided for the insert.\n @param onUpdateExclude List of specific columns to exclude from updating.\n If left null, all columns will be updated with the values provided for the insert.\n @param where Condition that determines which rows to update, if a unique violation is found.\n @param shouldReturnGeneratedValues Specifies whether newly generated values (for example, auto-incremented IDs)\n should be returned.\n @return A [BatchUpsertStatement] that can be executed.\n
        onUpdateList: List<Pair<Column<*>, Any?>>? = null,
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().(onUpdateList)
//                   display_name onUpdateList
//                   documentation ```kotlin\nonUpdateList: List<Pair<Column<*>, Any?>>? = ...\n```
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        onUpdate: (UpsertBuilder.(UpdateStatement) -> Unit)? = null,
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().(onUpdate)
//               display_name onUpdate
//               documentation ```kotlin\nonUpdate: (UpsertBuilder.(UpdateStatement) -> Unit)? = ...\n```
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
        onUpdateExclude: List<Column<*>>? = null,
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().(onUpdateExclude)
//                      display_name onUpdateExclude
//                      documentation ```kotlin\nonUpdateExclude: List<Column<*>>? = ...\n```
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        where: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().(where)
//            display_name where
//            documentation ```kotlin\nwhere: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
        shouldReturnGeneratedValues: Boolean = true,
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().(shouldReturnGeneratedValues)
//                                  display_name shouldReturnGeneratedValues
//                                  documentation ```kotlin\nshouldReturnGeneratedValues: Boolean = ...\n```
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        vararg keys: Column<*>,
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().(keys)
//                  display_name keys
//                  documentation ```kotlin\nvararg keys: Column<*>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
        body: BatchUpsertStatement.(E) -> Unit
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().(body)
//           display_name body
//           documentation ```kotlin\nbody: BatchUpsertStatement.(E) -> Unit\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
    ): BatchUpsertStatement {
//     ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#
        return BatchUpsertStatement(
//             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#`<init>`().
            table = this,
            keys = keys,
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().(keys)
            onUpdateExclude = onUpdateExclude,
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().(onUpdateExclude)
            where = where?.let { SqlExpressionBuilder.it() },
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().(where)
//                         ^^^ reference semanticdb maven . . kotlin/let().
//                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                           display_name it
//                                                           documentation ```kotlin\nit: List<Pair<Column<*>, Any?>>\n```
//                                                    ^^ reference semanticdb maven . . (it)
//                                                    ^^ reference semanticdb maven . . kotlin/Function1#invoke().
            shouldReturnGeneratedValues = shouldReturnGeneratedValues
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().(shouldReturnGeneratedValues)
        ).apply {
//        ^^^^^ reference semanticdb maven . . kotlin/apply().
            onUpdate?.let { storeUpdateValues(it) }
//          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().(onUpdate)
//                    ^^^ reference semanticdb maven . . kotlin/let().
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                  display_name it
//                                                  documentation ```kotlin\nit: List<Pair<Column<*>, Any?>>\n```
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#storeUpdateValues().
//                                            ^^ reference semanticdb maven . . (it)
                ?: onUpdateList?.let { updateValues.putAll(it) }
//                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#batchUpsert().(onUpdateList)
//                               ^^^ reference semanticdb maven . . kotlin/let().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                               display_name it
//                                                               documentation ```kotlin\nit: List<Pair<Column<*>, Any?>>\n```
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#getUpdateValues().
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#updateValues.
//                                                  ^^^^^^ reference semanticdb maven . . kotlin/collections/putAll(+1).
//                                                         ^^ reference semanticdb maven . . (it)
        }
    }

    /**
     * Represents the SQL statement that inserts, updates, or deletes records in a target table based on
     * a comparison with a source table.
     *
     * @param source An instance of the source table.
     * @param on A lambda function with [SqlExpressionBuilder] as its receiver that should return an `Op<Boolean>` condition.
     * This condition is used to match records between the source and target tables.
     * @param body A lambda where [MergeTableStatement] can be configured with specific actions to perform
     * when records are matched or not matched.
     * @return A [MergeTableStatement] that can be executed.
     */
    fun <D : Table, S : Table> D.mergeFrom(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom().[D]
//         display_name FirTypeParameterSymbol D
//         documentation ```kotlin\nD : Table\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom().[S]
//                    display_name FirTypeParameterSymbol S
//                    documentation ```kotlin\nS : Table\n```
//                               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom().
//                                         display_name mergeFrom
//                                         documentation ```kotlin\npublic open fun <D : Table, S : Table> D.mergeFrom(source: S, on: (SqlExpressionBuilder.() -> Op<Boolean>)? = ..., body: MergeTableStatement.() -> Unit): MergeTableStatement\n```\n\n----\n\n\n Represents the SQL statement that inserts, updates, or deletes records in a target table based on\n a comparison with a source table.\n\n @param source An instance of the source table.\n @param on A lambda function with [SqlExpressionBuilder] as its receiver that should return an `Op<Boolean>` condition.\n This condition is used to match records between the source and target tables.\n @param body A lambda where [MergeTableStatement] can be configured with specific actions to perform\n when records are matched or not matched.\n @return A [MergeTableStatement] that can be executed.\n
        source: S,
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom().(source)
//             display_name source
//             documentation ```kotlin\nsource: S\n```
        on: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom().(on)
//         display_name on
//         documentation ```kotlin\non: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
        body: MergeTableStatement.() -> Unit
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom().(body)
//           display_name body
//           documentation ```kotlin\nbody: MergeTableStatement.() -> Unit\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
    ): MergeTableStatement {
//     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#
        return MergeTableStatement(this, source, on = on?.invoke(SqlExpressionBuilder)).apply(body)
//             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#`<init>`().
//                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom().(source)
//                                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom().(on)
//                                                        ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                                      ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom().(body)
    }

    /**
     * Represents the SQL statement that inserts, updates, or deletes records in a target table based on
     * a comparison with a select query source.
     *
     * @param selectQuery The aliased query for a complex subquery to be used as the source.
     * @param on A lambda with a receiver of type [SqlExpressionBuilder] that returns an `Op<Boolean>` condition.
     * This condition is used to match records between the source query and the target table.
     * @param body A lambda where [MergeSelectStatement] can be configured with specific actions to perform
     * when records are matched or not matched.
     * @return A [MergeSelectStatement] which represents the MERGE operation with the configured actions.
     */
    fun <T : Table> T.mergeFrom(
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom(+1).[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Table\n```
//                    ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom(+1).
//                              display_name mergeFrom
//                              documentation ```kotlin\npublic open fun <T : Table> T.mergeFrom(selectQuery: QueryAlias, on: SqlExpressionBuilder.() -> Op<Boolean>, body: MergeSelectStatement.() -> Unit): MergeSelectStatement\n```\n\n----\n\n\n Represents the SQL statement that inserts, updates, or deletes records in a target table based on\n a comparison with a select query source.\n\n @param selectQuery The aliased query for a complex subquery to be used as the source.\n @param on A lambda with a receiver of type [SqlExpressionBuilder] that returns an `Op<Boolean>` condition.\n This condition is used to match records between the source query and the target table.\n @param body A lambda where [MergeSelectStatement] can be configured with specific actions to perform\n when records are matched or not matched.\n @return A [MergeSelectStatement] which represents the MERGE operation with the configured actions.\n
        selectQuery: QueryAlias,
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom(+1).(selectQuery)
//                  display_name selectQuery
//                  documentation ```kotlin\nselectQuery: QueryAlias\n```
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#
        on: SqlExpressionBuilder.() -> Op<Boolean>,
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom(+1).(on)
//         display_name on
//         documentation ```kotlin\non: SqlExpressionBuilder.() -> Op<Boolean>\n```
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
        body: MergeSelectStatement.() -> Unit
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom(+1).(body)
//           display_name body
//           documentation ```kotlin\nbody: MergeSelectStatement.() -> Unit\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
    ): MergeSelectStatement {
//     ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#
        return MergeSelectStatement(this, selectQuery, SqlExpressionBuilder.on()).apply(body)
//             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#`<init>`().
//                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom(+1).(selectQuery)
//                                                                          ^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom(+1).(on)
//                                                                                ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#mergeFrom(+1).(body)
    }
    private fun Column<*>.isValidIfAutoIncrement(): Boolean =
//                        ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#isValidIfAutoIncrement().
//                                               display_name isValidIfAutoIncrement
//                                               documentation ```kotlin\nprivate final fun Column<*>.isValidIfAutoIncrement(): Boolean\n```
//                                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        !columnType.isAutoInc || autoIncColumnType?.nextValExpression != null
//      ^ reference semanticdb maven . . kotlin/Boolean#not().
//       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
//                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getNextValExpression().
//                                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#nextValExpression.
}

/** Builder object for creating SQL statements. Made it private to avoid imports clash */
@Suppress("ForbiddenComment")
// TODO: StatementBuilder -> StatementBuilderImpl, and IStatementBuilder -> StatementBuilder
private object StatementBuilder : IStatementBuilder
//             ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementBuilder#
//                              display_name StatementBuilder
//                              documentation ```kotlin\n@Suppress(...) private final object StatementBuilder : IStatementBuilder\n```\n\n----\n\n Builder object for creating SQL statements. Made it private to avoid imports clash
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#
//             ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementBuilder#`<init>`().
//                              display_name StatementBuilder
//                              documentation ```kotlin\nprivate constructor(): StatementBuilder\n```\n\n----\n\n Builder object for creating SQL statements. Made it private to avoid imports clash
//                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/IStatementBuilder#

// TODO: add documentation for building statements without execution, like in the old DSL
@Suppress("ForbiddenComment", "AnnotationSpacing")
fun <S> buildStatement(body: IStatementBuilder.() -> S): S = body(StatementBuilder)
//   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/buildStatement().[S]
//     display_name FirTypeParameterSymbol S
//     documentation ```kotlin\nS\n```
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/buildStatement().
//                     display_name buildStatement
//                     documentation ```kotlin\n@Suppress(...) public final fun <S> buildStatement(body: IStatementBuilder.() -> S): S\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/buildStatement().(body)
//                          display_name body
//                          documentation ```kotlin\nbody: IStatementBuilder.() -> S\n```
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/buildStatement().(body)
