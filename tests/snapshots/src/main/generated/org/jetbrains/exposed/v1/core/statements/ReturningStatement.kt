package org.jetbrains.exposed.v1.core.statements
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/

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
import org.jetbrains.exposed.v1.core.statements.api.ResultApi
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                              ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/
//                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ResultApi#

/**
 * Represents the underlying SQL [mainStatement] that returns a result with data from any modified rows.
 *
 * @param table Table to perform the main statement on and return results from.
 * @param returningExpressions Columns or expressions to include in the returned result.
 * @param mainStatement The statement to append the RETURNING clause to. This may be an insert, update, or delete statement.
 */
open class ReturningStatement(
//         ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#
//                            display_name ReturningStatement
//                            documentation ```kotlin\npublic open class ReturningStatement : Statement<ResultApi>\n```\n\n----\n\n\n Represents the underlying SQL [mainStatement] that returns a result with data from any modified rows.\n\n @param table Table to perform the main statement on and return results from.\n @param returningExpressions Columns or expressions to include in the returned result.\n @param mainStatement The statement to append the RETURNING clause to. This may be an insert, update, or delete statement.\n
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
//         ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#`<init>`().
//                            display_name ReturningStatement
//                            documentation ```kotlin\npublic constructor(table: Table, returningExpressions: List<Expression<*>>, mainStatement: Statement<*>): ReturningStatement\n```
    val table: Table,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#`<init>`().(table)
//            display_name table
//            documentation ```kotlin\ntable: Table\n```
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#`<init>`().(table)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#getTable().
//            display_name table
//            documentation ```kotlin\npublic get(): Table\n```
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#table.
//            display_name table
//            documentation ```kotlin\npublic final val table: Table\n```
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
    val returningExpressions: List<Expression<*>>,
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#`<init>`().(returningExpressions)
//                           display_name returningExpressions
//                           documentation ```kotlin\nreturningExpressions: List<Expression<*>>\n```
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#`<init>`().(returningExpressions)
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#getReturningExpressions().
//                           display_name returningExpressions
//                           documentation ```kotlin\npublic get(): List<Expression<*>>\n```
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#returningExpressions.
//                           display_name returningExpressions
//                           documentation ```kotlin\npublic final val returningExpressions: List<Expression<*>>\n```
//                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
    val mainStatement: Statement<*>
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#`<init>`().(mainStatement)
//                    display_name mainStatement
//                    documentation ```kotlin\nmainStatement: Statement<*>\n```
//      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#`<init>`().(mainStatement)
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#getMainStatement().
//                    display_name mainStatement
//                    documentation ```kotlin\npublic get(): Statement<*>\n```
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#mainStatement.
//                    display_name mainStatement
//                    documentation ```kotlin\npublic final val mainStatement: Statement<*>\n```
//                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
) : Statement<ResultApi>(mainStatement.type, listOf(table)) {
//  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
//                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#`<init>`().(mainStatement)
//                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#getType().
//                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#type.
//                                           ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#`<init>`().(table)
    override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>> = mainStatement.arguments()
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#arguments().
//                         display_name arguments
//                         documentation ```kotlin\npublic open override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>>\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#arguments().
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#getMainStatement().
//                                                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#mainStatement.
//                                                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#arguments().

    override fun prepareSQL(transaction: Transaction, prepared: Boolean): String {
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#prepareSQL().
//                          display_name prepareSQL
//                          documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#prepareSQL().
//                          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#prepareSQL().(transaction)
//                                      display_name transaction
//                                      documentation ```kotlin\ntransaction: Transaction\n```
//                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#prepareSQL().(prepared)
//                                                             display_name prepared
//                                                             documentation ```kotlin\nprepared: Boolean\n```
//                                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
        val mainSql = mainStatement.prepareSQL(transaction, prepared)
//          ^^^^^^^ definition local 0
//                  display_name mainSql
//                  documentation ```kotlin\nlocal val mainSql: String\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#getMainStatement().
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#mainStatement.
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#prepareSQL().
//                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#prepareSQL().(transaction)
//                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#prepareSQL().(prepared)
        return transaction.db.dialect.functionProvider.returning(mainSql, returningExpressions, transaction)
//             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#prepareSQL().(transaction)
//                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().
//                                                               ^^^^^^^ reference local 0
//                                                                        ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#getReturningExpressions().
//                                                                        ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#returningExpressions.
//                                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#prepareSQL().(transaction)
    }
}
