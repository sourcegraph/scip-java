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
import org.jetbrains.exposed.v1.core.vendors.H2Dialect.H2CompatibilityMode
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
//                                                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect/H2CompatibilityMode/
import org.jetbrains.exposed.v1.core.vendors.H2FunctionProvider
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#
import org.jetbrains.exposed.v1.core.vendors.OracleDialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
import org.jetbrains.exposed.v1.core.vendors.PostgreSQLDialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
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
import org.jetbrains.exposed.v1.core.vendors.h2Mode
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
import org.jetbrains.exposed.v1.exceptions.throwUnsupportedException
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().

/**
 * Represents the SQL statement that updates rows of a table.
 *
 * @param targetsSet Column set to update rows from. This may be a [Table] or a [Join] instance.
 * @param limit Maximum number of rows to update.
 * @param where Condition that determines which rows to update.
 */
open class UpdateStatement(val targetsSet: ColumnSet, val limit: Int?, val where: Op<Boolean>? = null) :
//         ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#
//                         display_name UpdateStatement
//                         documentation ```kotlin\npublic open class UpdateStatement : UpdateBuilder<Int>\n```\n\n----\n\n\n Represents the SQL statement that updates rows of a table.\n\n @param targetsSet Column set to update rows from. This may be a [Table] or a [Join] instance.\n @param limit Maximum number of rows to update.\n @param where Condition that determines which rows to update.\n
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#
//         ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#`<init>`().
//                         display_name UpdateStatement
//                         documentation ```kotlin\npublic constructor(targetsSet: ColumnSet, limit: Int?, where: Op<Boolean>? = ...): UpdateStatement\n```
//                             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#`<init>`().(targetsSet)
//                                        display_name targetsSet
//                                        documentation ```kotlin\ntargetsSet: ColumnSet\n```
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#`<init>`().(targetsSet)
//                             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getTargetsSet().
//                                        display_name targetsSet
//                                        documentation ```kotlin\npublic get(): ColumnSet\n```
//                             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#targetsSet.
//                                        display_name targetsSet
//                                        documentation ```kotlin\npublic final val targetsSet: ColumnSet\n```
//                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#`<init>`().(limit)
//                                                              display_name limit
//                                                              documentation ```kotlin\nlimit: Int?\n```
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#`<init>`().(limit)
//                                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getLimit().
//                                                              display_name limit
//                                                              documentation ```kotlin\npublic get(): Int?\n```
//                                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#limit.
//                                                              display_name limit
//                                                              documentation ```kotlin\npublic final val limit: Int?\n```
//                                                               ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#`<init>`().(where)
//                                                                               display_name where
//                                                                               documentation ```kotlin\nwhere: Op<Boolean>? = ...\n```
//                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#`<init>`().(where)
//                                                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getWhere().
//                                                                               display_name where
//                                                                               documentation ```kotlin\npublic get(): Op<Boolean>?\n```
//                                                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#where.
//                                                                               display_name where
//                                                                               documentation ```kotlin\npublic final val where: Op<Boolean>?\n```
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
    UpdateBuilder<Int>(StatementType.UPDATE, targetsSet.targetTables()) {
//  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#UPDATE.
//                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#`<init>`().(targetsSet)
//                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/targetTables().

    /** The initial list of columns to update with their updated values. */
    open val firstDataSet: List<Pair<Column<*>, Any?>>
//           ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#firstDataSet.
//                        display_name firstDataSet
//                        documentation ```kotlin\npublic open val firstDataSet: List<Pair<Column<*>, Any?>>\n```\n\n----\n\n The initial list of columns to update with their updated values.
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        get() {
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getFirstDataSet().
//          display_name firstDataSet
//          documentation ```kotlin\npublic get(): List<Pair<Column<*>, Any?>>\n```
            @OptIn(InternalApi::class)
            return values.toList()
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getValues().
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#values.
//                        ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+11).
        }

    override fun prepareSQL(transaction: Transaction, prepared: Boolean): String {
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#prepareSQL().
//                          display_name prepareSQL
//                          documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#prepareSQL().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#prepareSQL().
//                          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#prepareSQL().(transaction)
//                                      display_name transaction
//                                      documentation ```kotlin\ntransaction: Transaction\n```
//                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#prepareSQL().(prepared)
//                                                             display_name prepared
//                                                             documentation ```kotlin\nprepared: Boolean\n```
//                                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
        require(firstDataSet.isNotEmpty()) { "Can't prepare UPDATE statement without fields to update" }
//      ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#firstDataSet.
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getFirstDataSet().
//                           ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).

        val dialect = transaction.db.dialect
//          ^^^^^^^ definition local 0
//                  display_name dialect
//                  documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#prepareSQL().(transaction)
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
        return when (targetsSet) {
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getTargetsSet().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#targetsSet.
            is Table -> dialect.functionProvider.update(targetsSet, firstDataSet, limit, where, transaction)
//                      ^^^^^^^ reference local 0
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().
//                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getTargetsSet().
//                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#targetsSet.
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#firstDataSet.
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getFirstDataSet().
//                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getLimit().
//                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#limit.
//                                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getWhere().
//                                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#where.
//                                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#prepareSQL().(transaction)
            is Join -> {
                val functionProvider = when (dialect.h2Mode) {
//                  ^^^^^^^^^^^^^^^^ definition local 1
//                                   display_name functionProvider
//                                   documentation ```kotlin\nlocal val functionProvider: FunctionProvider\n```
//                                           ^^^^^^^ reference local 0
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
                    H2CompatibilityMode.PostgreSQL, H2CompatibilityMode.Oracle, H2CompatibilityMode.SQLServer -> H2FunctionProvider
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#PostgreSQL.
//                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
//                                                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#SQLServer.
                    else -> dialect.functionProvider
//                          ^^^^^^^ reference local 0
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
                }
                functionProvider.update(targetsSet, firstDataSet, limit, where, transaction)
//              ^^^^^^^^^^^^^^^^ reference local 1
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getTargetsSet().
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#targetsSet.
//                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#firstDataSet.
//                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getFirstDataSet().
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getLimit().
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#limit.
//                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getWhere().
//                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#where.
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#prepareSQL().(transaction)
            }
            else -> transaction.throwUnsupportedException("UPDATE with ${targetsSet::class.simpleName} unsupported")
//                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#prepareSQL().(transaction)
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getTargetsSet().
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#targetsSet.
//                                                                                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getSimpleName().
//                                                                                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#simpleName.
        }
    }

    override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>> = QueryBuilder(true).run {
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#arguments().
//                         display_name arguments
//                         documentation ```kotlin\npublic open override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>>\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#arguments().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#arguments().
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                                                                                                ^^^ reference semanticdb maven . . kotlin/run(+1).
        val dialect = currentDialect
//          ^^^^^^^ definition local 2
//                  display_name dialect
//                  documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
        when {
            targetsSet is Join && dialect is OracleDialect -> {
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getTargetsSet().
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#targetsSet.
//                                ^^^^^^^ reference local 2
                registerAdditionalArgs(targetsSet)
//              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerAdditionalArgs().
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getTargetsSet().
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#targetsSet.
                registerWhereArg()
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerWhereArg().
                registerUpdateArgs()
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerUpdateArgs().
            }
            targetsSet is Join && (dialect is SQLServerDialect || dialect is PostgreSQLDialect) -> {
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getTargetsSet().
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#targetsSet.
//                                 ^^^^^^^ reference local 2
//                                                                ^^^^^^^ reference local 2
                registerUpdateArgs()
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerUpdateArgs().
                registerAdditionalArgs(targetsSet)
//              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerAdditionalArgs().
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getTargetsSet().
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#targetsSet.
                registerWhereArg()
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerWhereArg().
            }
            targetsSet is Join -> {
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getTargetsSet().
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#targetsSet.
                registerAdditionalArgs(targetsSet)
//              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerAdditionalArgs().
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getTargetsSet().
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#targetsSet.
                registerUpdateArgs()
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerUpdateArgs().
                registerWhereArg()
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerWhereArg().
            }
            else -> {
                registerUpdateArgs()
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerUpdateArgs().
                registerWhereArg()
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerWhereArg().
            }
        }
        if (args.isNotEmpty()) listOf(args) else emptyList()
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#args.
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getArgs().
//               ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                             ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#args.
//                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getArgs().
//                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
    }

    private fun QueryBuilder.registerWhereArg() {
//                           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerWhereArg().
//                                            display_name registerWhereArg
//                                            documentation ```kotlin\nprivate final fun QueryBuilder.registerWhereArg(): Unit\n```
        where?.toQueryBuilder(this)
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getWhere().
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#where.
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
    }

    private fun QueryBuilder.registerUpdateArgs() {
//                           ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerUpdateArgs().
//                                              display_name registerUpdateArgs
//                                              documentation ```kotlin\nprivate final fun QueryBuilder.registerUpdateArgs(): Unit\n```
        @OptIn(InternalApi::class)
        values.forEach { registerArgument(it.key, it.value) }
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getValues().
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#values.
//             ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                            display_name it
//                                                            documentation ```kotlin\nit: Join.JoinPart\n```
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                                        ^^ reference semanticdb maven . . (it)
//                                           ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getKey().
//                                           ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#key.
//                                                ^^ reference semanticdb maven . . (it)
//                                                   ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getValue().
//                                                   ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#value.
    }

    private fun QueryBuilder.registerAdditionalArgs(join: Join) {
//                           ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerAdditionalArgs().
//                                                  display_name registerAdditionalArgs
//                                                  documentation ```kotlin\nprivate final fun QueryBuilder.registerAdditionalArgs(join: Join): Unit\n```
//                                                  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerAdditionalArgs().(join)
//                                                       display_name join
//                                                       documentation ```kotlin\njoin: Join\n```
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
        join.joinParts.forEach {
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#registerAdditionalArgs().(join)
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                     ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                             ^ definition semanticdb maven . . (it) 3:9
//                               display_name it
//                               documentation ```kotlin\nit: Join.JoinPart\n```
            (it.joinPart as? QueryAlias)?.query?.prepareSQL(this)
//           ^^ reference semanticdb maven . . (it)
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getQuery().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#query.
//                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().
            it.additionalConstraint?.invoke(SqlExpressionBuilder)?.toQueryBuilder(this)
//          ^^ reference semanticdb maven . . (it)
//             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#additionalConstraint.
//             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getAdditionalConstraint().
//                                   ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
        }
    }
}
