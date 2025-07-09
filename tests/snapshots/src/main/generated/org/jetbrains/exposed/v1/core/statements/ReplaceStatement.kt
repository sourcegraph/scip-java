package org.jetbrains.exposed.v1.core.statements
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/

import org.jetbrains.exposed.v1.core.AbstractQuery
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
import org.jetbrains.exposed.v1.core.Column
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
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
import org.jetbrains.exposed.v1.core.vendors.H2Dialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
import org.jetbrains.exposed.v1.core.vendors.MysqlFunctionProvider
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#
import org.jetbrains.exposed.v1.core.vendors.h2Mode
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.

/**
 * Represents the SQL statement that either inserts a new row into a table, or, if insertion would violate a unique constraint,
 * first deletes the existing row before inserting a new row.
 *
 * @param table Table to either insert values into or delete values from then insert into.
 */
open class ReplaceStatement<Key : Any>(table: Table) : InsertStatement<Key>(table) {
//         ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#
//                          display_name ReplaceStatement
//                          documentation ```kotlin\npublic open class ReplaceStatement<Key : Any> : InsertStatement<Key>\n```\n\n----\n\n\n Represents the SQL statement that either inserts a new row into a table, or, if insertion would violate a unique constraint,\n first deletes the existing row before inserting a new row.\n\n @param table Table to either insert values into or delete values from then insert into.\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#
//         ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#`<init>`().
//                          display_name ReplaceStatement
//                          documentation ```kotlin\npublic constructor<Key : Any>(table: Table): ReplaceStatement<Key>\n```
//                          ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#[Key]
//                              display_name FirTypeParameterSymbol Key
//                              documentation ```kotlin\nKey : Any\n```
//                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#`<init>`().(table)
//                                           display_name table
//                                           documentation ```kotlin\ntable: Table\n```
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                     ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#
//                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#`<init>`().(table)
    override fun prepareSQL(transaction: Transaction, prepared: Boolean): String {
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#prepareSQL().
//                          display_name prepareSQL
//                          documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().
//                          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#prepareSQL().(transaction)
//                                      display_name transaction
//                                      documentation ```kotlin\ntransaction: Transaction\n```
//                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#prepareSQL().(prepared)
//                                                             display_name prepared
//                                                             documentation ```kotlin\nprepared: Boolean\n```
//                                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
        val values = arguments!!.first()
//          ^^^^^^ definition local 0
//                 display_name values
//                 documentation ```kotlin\nlocal val values: List<Pair<Column<*>, Any?>>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#arguments.
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#getArguments().
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#setArguments().
//                               ^^^^^ reference semanticdb maven . . kotlin/collections/first(+19).
        val valuesSql = values.toSqlString(prepared)
//          ^^^^^^^^^ definition local 1
//                    display_name valuesSql
//                    documentation ```kotlin\nlocal val valuesSql: String\n```
//                      ^^^^^^ reference local 0
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#toSqlString().
//                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#prepareSQL().(prepared)
        val dialect = transaction.db.dialect
//          ^^^^^^^ definition local 2
//                  display_name dialect
//                  documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#prepareSQL().(transaction)
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
        val functionProvider = when (dialect.h2Mode) {
//          ^^^^^^^^^^^^^^^^ definition local 3
//                           display_name functionProvider
//                           documentation ```kotlin\nlocal val functionProvider: FunctionProvider\n```
//                                   ^^^^^^^ reference local 2
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
            H2Dialect.H2CompatibilityMode.MySQL, H2Dialect.H2CompatibilityMode.MariaDB -> MysqlFunctionProvider.INSTANCE
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MySQL.
//                                                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MariaDB.
//                                                                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#INSTANCE.
//                                                                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#getINSTANCE().
            else -> dialect.functionProvider
//                  ^^^^^^^ reference local 2
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
        }
        return functionProvider.replace(table, values.unzip().first, valuesSql, transaction, prepared)
//             ^^^^^^^^^^^^^^^^ reference local 3
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#getTable().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#table.
//                                             ^^^^^^ reference local 0
//                                                    ^^^^^ reference semanticdb maven . . kotlin/collections/unzip(+1).
//                                                            ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                            ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                                   ^^^^^^^^^ reference local 1
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#prepareSQL().(transaction)
//                                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#prepareSQL().(prepared)
    }
}

/**
 * Represents the SQL statement that uses data retrieved from a [selectQuery] to either insert a new row into a table,
 * or, if insertion would violate a unique constraint, first delete the existing row before inserting a new row.
 *
 * @param columns Columns to either insert values into or delete values from then insert into.
 * @param selectQuery Source SELECT query that provides the values to insert.
 */
open class ReplaceSelectStatement(
//         ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#
//                                display_name ReplaceSelectStatement
//                                documentation ```kotlin\npublic open class ReplaceSelectStatement : InsertSelectStatement\n```\n\n----\n\n\n Represents the SQL statement that uses data retrieved from a [selectQuery] to either insert a new row into a table,\n or, if insertion would violate a unique constraint, first delete the existing row before inserting a new row.\n\n @param columns Columns to either insert values into or delete values from then insert into.\n @param selectQuery Source SELECT query that provides the values to insert.\n
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#
//         ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#`<init>`().
//                                display_name ReplaceSelectStatement
//                                documentation ```kotlin\npublic constructor(columns: List<Column<*>>, selectQuery: AbstractQuery<*>): ReplaceSelectStatement\n```
    columns: List<Column<*>>,
//  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#`<init>`().(columns)
//          display_name columns
//          documentation ```kotlin\ncolumns: List<Column<*>>\n```
//           ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
    selectQuery: AbstractQuery<*>
//  ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#`<init>`().(selectQuery)
//              display_name selectQuery
//              documentation ```kotlin\nselectQuery: AbstractQuery<*>\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
) : InsertSelectStatement(columns, selectQuery) {
//  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#`<init>`().(columns)
//                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#`<init>`().(selectQuery)
    override fun prepareSQL(transaction: Transaction, prepared: Boolean): String {
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#prepareSQL().
//                          display_name prepareSQL
//                          documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#prepareSQL().
//                          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#prepareSQL().(transaction)
//                                      display_name transaction
//                                      documentation ```kotlin\ntransaction: Transaction\n```
//                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#prepareSQL().(prepared)
//                                                             display_name prepared
//                                                             documentation ```kotlin\nprepared: Boolean\n```
//                                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
        val querySql = selectQuery.prepareSQL(transaction, prepared)
//          ^^^^^^^^ definition local 4
//                   display_name querySql
//                   documentation ```kotlin\nlocal val querySql: String\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getSelectQuery().
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#selectQuery.
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().
//                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#prepareSQL().(transaction)
//                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#prepareSQL().(prepared)
        val dialect = transaction.db.dialect
//          ^^^^^^^ definition local 5
//                  display_name dialect
//                  documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#prepareSQL().(transaction)
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
        val functionProvider = when (dialect.h2Mode) {
//          ^^^^^^^^^^^^^^^^ definition local 6
//                           display_name functionProvider
//                           documentation ```kotlin\nlocal val functionProvider: FunctionProvider\n```
//                                   ^^^^^^^ reference local 5
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
            H2Dialect.H2CompatibilityMode.MySQL, H2Dialect.H2CompatibilityMode.MariaDB -> MysqlFunctionProvider.INSTANCE
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MySQL.
//                                                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MariaDB.
//                                                                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#INSTANCE.
//                                                                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#getINSTANCE().
            else -> dialect.functionProvider
//                  ^^^^^^^ reference local 5
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
        }
        return functionProvider.replace(targets.single(), columns, querySql, transaction, prepared)
//             ^^^^^^^^^^^^^^^^ reference local 6
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getTargets().
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#targets.
//                                              ^^^^^^ reference semanticdb maven . . kotlin/collections/single(+19).
//                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#columns.
//                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#getColumns().
//                                                                 ^^^^^^^^ reference local 4
//                                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#prepareSQL().(transaction)
//                                                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceSelectStatement#prepareSQL().(prepared)
    }
}
