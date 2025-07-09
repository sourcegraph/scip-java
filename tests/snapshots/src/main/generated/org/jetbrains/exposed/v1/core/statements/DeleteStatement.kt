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
 * Represents the SQL statement that deletes one or more rows of a table.
 *
 * @param targetsSet Column set to delete rows from. This may be a [Table] or a [Join] instance.
 * @param where Condition that determines which rows to delete.
 * @param isIgnore Whether to ignore errors or not.
 * **Note** [isIgnore] is not supported by all vendors. Please check the documentation.
 * @param limit Maximum number of rows to delete.
 * @param targetTables List of specific tables from [targetsSet] to delete rows from.
 */
@Suppress("ForbiddenComment", "AnnotationSpacing")
open class DeleteStatement(
//         ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#
//                         display_name DeleteStatement
//                         documentation ```kotlin\n@Suppress(...) public open class DeleteStatement : Statement<Int>\n```\n\n----\n\n\n Represents the SQL statement that deletes one or more rows of a table.\n\n @param targetsSet Column set to delete rows from. This may be a [Table] or a [Join] instance.\n @param where Condition that determines which rows to delete.\n @param isIgnore Whether to ignore errors or not.\n **Note** [isIgnore] is not supported by all vendors. Please check the documentation.\n @param limit Maximum number of rows to delete.\n @param targetTables List of specific tables from [targetsSet] to delete rows from.\n
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
//         ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().
//                         display_name DeleteStatement
//                         documentation ```kotlin\npublic constructor(targetsSet: ColumnSet, where: Op<Boolean>? = ..., isIgnore: Boolean = ..., limit: Int? = ..., targetTables: List<Table> = ...): DeleteStatement\n```
    val targetsSet: ColumnSet,
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().(targetsSet)
//                 display_name targetsSet
//                 documentation ```kotlin\ntargetsSet: ColumnSet\n```
//      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().(targetsSet)
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getTargetsSet().
//                 display_name targetsSet
//                 documentation ```kotlin\npublic get(): ColumnSet\n```
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#targetsSet.
//                 display_name targetsSet
//                 documentation ```kotlin\npublic final val targetsSet: ColumnSet\n```
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
    val where: Op<Boolean>? = null,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().(where)
//            display_name where
//            documentation ```kotlin\nwhere: Op<Boolean>? = ...\n```
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().(where)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getWhere().
//            display_name where
//            documentation ```kotlin\npublic get(): Op<Boolean>?\n```
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#where.
//            display_name where
//            documentation ```kotlin\npublic final val where: Op<Boolean>?\n```
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
    val isIgnore: Boolean = false,
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().(isIgnore)
//               display_name isIgnore
//               documentation ```kotlin\nisIgnore: Boolean = ...\n```
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().(isIgnore)
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getIsIgnore().
//               display_name isIgnore
//               documentation ```kotlin\npublic get(): Boolean\n```
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#isIgnore.
//               display_name isIgnore
//               documentation ```kotlin\npublic final val isIgnore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    val limit: Int? = null,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().(limit)
//            display_name limit
//            documentation ```kotlin\nlimit: Int? = ...\n```
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().(limit)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getLimit().
//            display_name limit
//            documentation ```kotlin\npublic get(): Int?\n```
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#limit.
//            display_name limit
//            documentation ```kotlin\npublic final val limit: Int?\n```
//             ^^^^ reference semanticdb maven . . kotlin/Int#
    val targetTables: List<Table> = emptyList(),
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().(targetTables)
//                   display_name targetTables
//                   documentation ```kotlin\ntargetTables: List<Table> = ...\n```
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().(targetTables)
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getTargetTables().
//                   display_name targetTables
//                   documentation ```kotlin\npublic get(): List<Table>\n```
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#targetTables.
//                   display_name targetTables
//                   documentation ```kotlin\npublic final val targetTables: List<Table>\n```
//                    ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                  ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
) : Statement<Int>(StatementType.DELETE, targetsSet.targetTables()) {
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#DELETE.
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`().(targetsSet)
//                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/targetTables().
    @Deprecated(
//  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`(+1). 12:56
//               display_name DeleteStatement
//               documentation ```kotlin\n@Deprecated(...) @Suppress(...) public constructor(table: Table, where: Op<Boolean>?, isIgnore: Boolean, limit: Int?, offset: Long?): DeleteStatement\n```
        "This constructor will be removed in future releases.",
        ReplaceWith("DeleteStatement(targetsSet = table, where, isIgnore, limit, emptyList())"),
//      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/ReplaceWith#`<init>`().
        DeprecationLevel.ERROR
//                       ^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#ERROR.
    )
    @Suppress("UnusedPrivateProperty")
    constructor(
        table: Table,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`(+1).(table)
//            display_name table
//            documentation ```kotlin\ntable: Table\n```
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
        where: Op<Boolean>?,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`(+1).(where)
//            display_name where
//            documentation ```kotlin\nwhere: Op<Boolean>?\n```
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
        isIgnore: Boolean,
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`(+1).(isIgnore)
//               display_name isIgnore
//               documentation ```kotlin\nisIgnore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        limit: Int?,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`(+1).(limit)
//            display_name limit
//            documentation ```kotlin\nlimit: Int?\n```
//             ^^^^ reference semanticdb maven . . kotlin/Int#
        offset: Long?
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`(+1).(offset)
//             display_name offset
//             documentation ```kotlin\noffset: Long?\n```
//              ^^^^^ reference semanticdb maven . . kotlin/Long#
    ) : this(table, where, isIgnore, limit, emptyList())
//           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`(+1).(table)
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`(+1).(where)
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`(+1).(isIgnore)
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#`<init>`(+1).(limit)
//                                          ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().

    @Deprecated(
        "This property will be removed in future releases and replaced with a property that stores a `ColumnSet`," +
            "which may be a `Table` or a `Join`. To access the table(s) to which the columns belong, use `ColumnSet.targetTables()`",
        ReplaceWith("targetsSet"),
//      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/ReplaceWith#`<init>`().
        DeprecationLevel.ERROR
//                       ^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#ERROR.
    )
    val table: Table = targets.first()
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getTable().
//            display_name table
//            documentation ```kotlin\npublic get(): Table\n```
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#table.
//            display_name table
//            documentation ```kotlin\n@Deprecated(...) public final val table: Table\n```
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getTargets().
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#targets.
//                             ^^^^^ reference semanticdb maven . . kotlin/collections/first(+19).

    @Deprecated(
        "This property is not being used and will be removed in future releases. Please leave a comment on " +
            "[YouTrack](https://youtrack.jetbrains.com/issue/EXPOSED-550/DeleteStatement-holds-unused-offset-property) " +
            "with a use-case if your database supports the OFFSET clause in a DELETE statement.",
        level = DeprecationLevel.ERROR
//                               ^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#ERROR.
    )
    val offset: Long? = null
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getOffset().
//             display_name offset
//             documentation ```kotlin\npublic get(): Long?\n```
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#offset.
//             display_name offset
//             documentation ```kotlin\n@Deprecated(...) public final val offset: Long?\n```
//              ^^^^^ reference semanticdb maven . . kotlin/Long#

    override fun prepareSQL(transaction: Transaction, prepared: Boolean): String {
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#prepareSQL().
//                          display_name prepareSQL
//                          documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#prepareSQL().
//                          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#prepareSQL().(transaction)
//                                      display_name transaction
//                                      documentation ```kotlin\ntransaction: Transaction\n```
//                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#prepareSQL().(prepared)
//                                                             display_name prepared
//                                                             documentation ```kotlin\nprepared: Boolean\n```
//                                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
        val dialect = transaction.db.dialect
//          ^^^^^^^ definition local 0
//                  display_name dialect
//                  documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#prepareSQL().(transaction)
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
        return when (targetsSet) {
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getTargetsSet().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#targetsSet.
            is Table -> dialect.functionProvider.delete(
//                      ^^^^^^^ reference local 0
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().
                isIgnore, targetsSet, where?.let { QueryBuilder(prepared).append(it).toString() }, limit, transaction
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getIsIgnore().
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#isIgnore.
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getTargetsSet().
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#targetsSet.
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getWhere().
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#where.
//                                           ^^^ reference semanticdb maven . . kotlin/let().
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                display_name it
//                                                                                                documentation ```kotlin\nit: Join.JoinPart\n```
//                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#prepareSQL().(prepared)
//                                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                                                                               ^^ reference semanticdb maven . . (it)
//                                                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
//                                                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getLimit().
//                                                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#limit.
//                                                                                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#prepareSQL().(transaction)
            )
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
                functionProvider.delete(isIgnore, targetsSet, targetTables, where, limit, transaction)
//              ^^^^^^^^^^^^^^^^ reference local 1
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getIsIgnore().
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#isIgnore.
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getTargetsSet().
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#targetsSet.
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getTargetTables().
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#targetTables.
//                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getWhere().
//                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#where.
//                                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getLimit().
//                                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#limit.
//                                                                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#prepareSQL().(transaction)
            }
            else -> transaction.throwUnsupportedException("DELETE with ${targetsSet::class.simpleName} is unsupported")
//                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#prepareSQL().(transaction)
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getTargetsSet().
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#targetsSet.
//                                                                                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getSimpleName().
//                                                                                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#simpleName.
        }
    }

    override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>> = QueryBuilder(true).run {
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#arguments().
//                         display_name arguments
//                         documentation ```kotlin\npublic open override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>>\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#arguments().
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                                                                                                ^^^ reference semanticdb maven . . kotlin/run(+1).
        if (targetsSet is Join) {
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getTargetsSet().
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#targetsSet.
            targetsSet.joinParts.forEach {
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getTargetsSet().
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#targetsSet.
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                               ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                       ^ definition semanticdb maven . . (it) 3:13
//                                         display_name it
//                                         documentation ```kotlin\nit: Join.JoinPart\n```
                (it.joinPart as? QueryAlias)?.query?.prepareSQL(this)
//               ^^ reference semanticdb maven . . (it)
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getQuery().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#query.
//                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().
                it.additionalConstraint?.invoke(SqlExpressionBuilder)?.toQueryBuilder(this)
//              ^^ reference semanticdb maven . . (it)
//                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#additionalConstraint.
//                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getAdditionalConstraint().
//                                       ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
            }
        }
        where?.toQueryBuilder(this)
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#getWhere().
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#where.
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
        listOf(args)
//      ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#args.
//             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getArgs().
    }

    companion object {
//  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#Companion# 34:5
//                     display_name Companion
//                     documentation ```kotlin\npublic final companion object Companion : Any\n```
//  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#Companion#`<init>`(). 34:5
//                     display_name Companion
//                     documentation ```kotlin\nprivate constructor(): DeleteStatement.Companion\n```
        @Suppress("FunctionOnlyReturningConstant", "UnusedParameter")
        @Deprecated(
            message = """
                Statement execution has been removed from exposed-core.
                Replace directly with a table extension function:
                    `table.deleteWhere(limit) { op }` OR `table.deleteIgnoreWhere(limit) { op }`

                Or pass the expected statement to an instance of Executable:
                For JDBC:
                `DeleteBlockingExecutable(buildStatement { table.deleteWhere(limit, { op }) }).execute(transaction) ?: 0`

                FOR R2DBC:
                `DeleteSuspendExecutable(buildStatement { table.deleteWhere(limit, { op }) }).execute(transaction) ?: 0`
            """,
            level = DeprecationLevel.ERROR
//                                   ^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#ERROR.
        )
        fun where(transaction: Transaction, table: Table, op: Op<Boolean>, isIgnore: Boolean = false, limit: Int? = null): Int = 0
//          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#Companion#where().
//                display_name where
//                documentation ```kotlin\n@Suppress(...) @Deprecated(...) public final fun where(transaction: Transaction, table: Table, op: Op<Boolean>, isIgnore: Boolean = ..., limit: Int? = ...): Int\n```
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#Companion#where().(transaction)
//                            display_name transaction
//                            documentation ```kotlin\ntransaction: Transaction\n```
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#Companion#where().(table)
//                                                display_name table
//                                                documentation ```kotlin\ntable: Table\n```
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                        ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#Companion#where().(op)
//                                                           display_name op
//                                                           documentation ```kotlin\nop: Op<Boolean>\n```
//                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                                         ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#Companion#where().(isIgnore)
//                                                                                  display_name isIgnore
//                                                                                  documentation ```kotlin\nisIgnore: Boolean = ...\n```
//                                                                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#Companion#where().(limit)
//                                                                                                          display_name limit
//                                                                                                          documentation ```kotlin\nlimit: Int? = ...\n```
//                                                                                                           ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                                                         ^^^ reference semanticdb maven . . kotlin/Int#

        @Suppress("FunctionOnlyReturningConstant", "UnusedParameter")
        @Deprecated(
            message = """
                Statement execution has been removed from exposed-core.
                Replace directly with a table extension function or pass the expected statement to an instance of Executable:

                For JDBC:
                `DeleteBlockingExecutable(buildStatement { table.deleteAll() }).execute(transaction) ?: 0`

                FOR R2DBC:
                `DeleteSuspendExecutable(buildStatement { table.deleteAll() }).execute(transaction) ?: 0`
            """,
            level = DeprecationLevel.ERROR
//                                   ^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#ERROR.
        )
        fun all(transaction: Transaction, table: Table): Int = 0
//          ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#Companion#all().
//              display_name all
//              documentation ```kotlin\n@Suppress(...) @Deprecated(...) public final fun all(transaction: Transaction, table: Table): Int\n```
//              ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#Companion#all().(transaction)
//                          display_name transaction
//                          documentation ```kotlin\ntransaction: Transaction\n```
//                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#Companion#all().(table)
//                                              display_name table
//                                              documentation ```kotlin\ntable: Table\n```
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                       ^^^ reference semanticdb maven . . kotlin/Int#
    }
}
