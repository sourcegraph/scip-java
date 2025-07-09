package org.jetbrains.exposed.v1.core.statements
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/

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
 * Represents the SQL statement that either batch inserts new rows into a table, or, if insertions violate unique constraints,
 * first deletes the existing rows before inserting new rows.
 *
 * @param table Table to either insert values into or delete values from then insert into.
 * @param shouldReturnGeneratedValues Specifies whether newly generated values (for example, auto-incremented IDs) should be returned.
 * See [Batch Insert](https://github.com/JetBrains/Exposed/wiki/DSL#batch-insert) for more details.
 */
open class BatchReplaceStatement(
//         ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#
//                               display_name BatchReplaceStatement
//                               documentation ```kotlin\npublic open class BatchReplaceStatement : BatchInsertStatement\n```\n\n----\n\n\n Represents the SQL statement that either batch inserts new rows into a table, or, if insertions violate unique constraints,\n first deletes the existing rows before inserting new rows.\n\n @param table Table to either insert values into or delete values from then insert into.\n @param shouldReturnGeneratedValues Specifies whether newly generated values (for example, auto-incremented IDs) should be returned.\n See [Batch Insert](https://github.com/JetBrains/Exposed/wiki/DSL#batch-insert) for more details.\n
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#
//         ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#`<init>`().
//                               display_name BatchReplaceStatement
//                               documentation ```kotlin\npublic constructor(table: Table, shouldReturnGeneratedValues: Boolean = ...): BatchReplaceStatement\n```
    table: Table,
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#`<init>`().(table)
//        display_name table
//        documentation ```kotlin\ntable: Table\n```
//         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
    shouldReturnGeneratedValues: Boolean = true
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#`<init>`().(shouldReturnGeneratedValues)
//                              display_name shouldReturnGeneratedValues
//                              documentation ```kotlin\nshouldReturnGeneratedValues: Boolean = ...\n```
//                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
) : BatchInsertStatement(table, ignore = false, shouldReturnGeneratedValues) {
//  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#`<init>`().(table)
//                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#`<init>`().(shouldReturnGeneratedValues)
    override fun prepareSQL(transaction: Transaction, prepared: Boolean): String {
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#prepareSQL().
//                          display_name prepareSQL
//                          documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().
//                          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#prepareSQL().(transaction)
//                                      display_name transaction
//                                      documentation ```kotlin\ntransaction: Transaction\n```
//                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#prepareSQL().(prepared)
//                                                             display_name prepared
//                                                             documentation ```kotlin\nprepared: Boolean\n```
//                                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
        val values = arguments!!.first()
//          ^^^^^^ definition local 0
//                 display_name values
//                 documentation ```kotlin\nlocal val values: List<Pair<Column<*>, Any?>>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#arguments.
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getArguments().
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#setArguments().
//                               ^^^^^ reference semanticdb maven . . kotlin/collections/first(+19).
        val valuesSql = values.toSqlString(prepared)
//          ^^^^^^^^^ definition local 1
//                    display_name valuesSql
//                    documentation ```kotlin\nlocal val valuesSql: String\n```
//                      ^^^^^^ reference local 0
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#toSqlString().
//                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#prepareSQL().(prepared)
        val dialect = transaction.db.dialect
//          ^^^^^^^ definition local 2
//                  display_name dialect
//                  documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#prepareSQL().(transaction)
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
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#getTable().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#table.
//                                             ^^^^^^ reference local 0
//                                                    ^^^^^ reference semanticdb maven . . kotlin/collections/unzip(+1).
//                                                            ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                            ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                                   ^^^^^^^^^ reference local 1
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#prepareSQL().(transaction)
//                                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#prepareSQL().(prepared)
    }
}
