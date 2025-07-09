package org.jetbrains.exposed.v1.core.vendors
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/

import org.jetbrains.exposed.v1.core.*
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
import org.jetbrains.exposed.v1.core.Function
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#
import org.jetbrains.exposed.v1.exceptions.UnsupportedByDialectException
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#

internal object MariaDBDataTypeProvider : MysqlDataTypeProvider() {
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#
//                                      display_name MariaDBDataTypeProvider
//                                      documentation ```kotlin\ninternal final object MariaDBDataTypeProvider : MysqlDataTypeProvider\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#`<init>`().
//                                      display_name MariaDBDataTypeProvider
//                                      documentation ```kotlin\nprivate constructor(): MariaDBDataTypeProvider\n```
//                                        ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#
    override fun timestampType(): String = if ((currentDialect as? MariaDBDialect)?.isFractionDateTimeSupported() == true) "TIMESTAMP(6)" else "TIMESTAMP"
//               ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#timestampType().
//                             display_name timestampType
//                             documentation ```kotlin\npublic open override fun timestampType(): String\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#timestampType().
//                                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#isFractionDateTimeSupported().

    override fun timestampWithTimeZoneType(): String {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#timestampWithTimeZoneType().
//                                         display_name timestampWithTimeZoneType
//                                         documentation ```kotlin\npublic open override fun timestampWithTimeZoneType(): String\n```
//                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#timestampWithTimeZoneType().
//                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
        throw UnsupportedByDialectException("This vendor does not support timestamp with time zone data type", currentDialect)
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
//                                                                                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
    }

    override fun processForDefaultValue(e: Expression<*>): String = when {
//               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#processForDefaultValue().
//                                      display_name processForDefaultValue
//                                      documentation ```kotlin\npublic open override fun processForDefaultValue(e: Expression<*>): String\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().
//                                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#processForDefaultValue().(e)
//                                        display_name e
//                                        documentation ```kotlin\ne: Expression<*>\n```
//                                         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
        e is LiteralOp<*> -> (e.columnType as IColumnType<Any?>).valueAsDefaultString(e.value)
//      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#processForDefaultValue().(e)
//                            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#processForDefaultValue().(e)
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueAsDefaultString().
//                                                                                    ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#processForDefaultValue().(e)
//                                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getValue().
//                                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#value.
        e is Function<*> || currentDialect is MariaDBDialect -> "$e"
//      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#processForDefaultValue().(e)
//                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#processForDefaultValue().(e)
        else -> "($e)"
//                 ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#processForDefaultValue().(e)
    }
}

internal object MariaDBFunctionProvider : MysqlFunctionProvider() {
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#
//                                      display_name MariaDBFunctionProvider
//                                      documentation ```kotlin\ninternal final object MariaDBFunctionProvider : MysqlFunctionProvider\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#`<init>`().
//                                      display_name MariaDBFunctionProvider
//                                      documentation ```kotlin\nprivate constructor(): MariaDBFunctionProvider\n```
//                                        ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#
    override fun nextVal(seq: Sequence, builder: QueryBuilder) = builder {
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#nextVal().
//                       display_name nextVal
//                       documentation ```kotlin\npublic open override fun nextVal(seq: Sequence, builder: QueryBuilder): Unit\n```
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().
//                       ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#nextVal().(seq)
//                           display_name seq
//                           documentation ```kotlin\nseq: Sequence\n```
//                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
//                                      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#nextVal().(builder)
//                                              display_name builder
//                                              documentation ```kotlin\nbuilder: QueryBuilder\n```
//                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#nextVal().(builder)
        append("NEXTVAL(", seq.identifier, ")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                         ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#nextVal().(seq)
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getIdentifier().
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#identifier.
    }

    override fun <T : String?> regexp(
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#regexp().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : String?\n```
//                             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#regexp().
//                                    display_name regexp
//                                    documentation ```kotlin\npublic open override fun <T : String?> regexp(expr1: Expression<T>, pattern: Expression<String>, caseSensitive: Boolean, queryBuilder: QueryBuilder): Unit\n```
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().
        expr1: Expression<T>,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#regexp().(expr1)
//            display_name expr1
//            documentation ```kotlin\nexpr1: Expression<T>\n```
//             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
        pattern: Expression<String>,
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#regexp().(pattern)
//              display_name pattern
//              documentation ```kotlin\npattern: Expression<String>\n```
//               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
        caseSensitive: Boolean,
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#regexp().(caseSensitive)
//                    display_name caseSensitive
//                    documentation ```kotlin\ncaseSensitive: Boolean\n```
//                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        queryBuilder: QueryBuilder
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#regexp().(queryBuilder)
//                   display_name queryBuilder
//                   documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
    ): Unit = queryBuilder {
//     ^^^^ reference semanticdb maven . . kotlin/Unit#
//            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#regexp().(queryBuilder)
        append(expr1, " REGEXP ", pattern)
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#regexp().(expr1)
//                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#regexp().(pattern)
    }

    override fun <T : String?> locate(
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#locate().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : String?\n```
//                             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#locate().
//                                    display_name locate
//                                    documentation ```kotlin\npublic open override fun <T : String?> locate(queryBuilder: QueryBuilder, expr: Expression<T>, substring: String): Unit\n```
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().
        queryBuilder: QueryBuilder,
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#locate().(queryBuilder)
//                   display_name queryBuilder
//                   documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
        expr: Expression<T>,
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#locate().(expr)
//           display_name expr
//           documentation ```kotlin\nexpr: Expression<T>\n```
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
        substring: String
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#locate().(substring)
//                display_name substring
//                documentation ```kotlin\nsubstring: String\n```
//                 ^^^^^^ reference semanticdb maven . . kotlin/String#
    ) = queryBuilder {
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#locate().(queryBuilder)
        append("LOCATE(\'", substring, "\',", expr, ")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#locate().(substring)
//                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#locate().(expr)
    }

    override fun update(
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#update().
//                      display_name update
//                      documentation ```kotlin\npublic open override fun update(targets: Join, columnsAndValues: List<Pair<Column<*>, Any?>>, limit: Int?, where: Op<Boolean>?, transaction: Transaction): String\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().
        targets: Join,
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#update().(targets)
//              display_name targets
//              documentation ```kotlin\ntargets: Join\n```
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
        columnsAndValues: List<Pair<Column<*>, Any?>>,
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#update().(columnsAndValues)
//                       display_name columnsAndValues
//                       documentation ```kotlin\ncolumnsAndValues: List<Pair<Column<*>, Any?>>\n```
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        limit: Int?,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#update().(limit)
//            display_name limit
//            documentation ```kotlin\nlimit: Int?\n```
//             ^^^^ reference semanticdb maven . . kotlin/Int#
        where: Op<Boolean>?,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#update().(where)
//            display_name where
//            documentation ```kotlin\nwhere: Op<Boolean>?\n```
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
        transaction: Transaction
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#update().(transaction)
//                  display_name transaction
//                  documentation ```kotlin\ntransaction: Transaction\n```
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
    ): String {
//     ^^^^^^ reference semanticdb maven . . kotlin/String#
        val sql = super.update(targets, columnsAndValues, null, where, transaction)
//          ^^^ definition local 0
//              display_name sql
//              documentation ```kotlin\nlocal val sql: String\n```
//                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().
//                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#update().(targets)
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#update().(columnsAndValues)
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#update().(where)
//                                                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#update().(transaction)
        return if (limit != null) "$sql LIMIT $limit" else sql
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#update().(limit)
//                                  ^^^ reference local 0
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#update().(limit)
//                                                         ^^^ reference local 0
    }

    override fun explain(
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#explain().
//                       display_name explain
//                       documentation ```kotlin\npublic open override fun explain(analyze: Boolean, options: String?, internalStatement: String, transaction: Transaction): String\n```
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
        analyze: Boolean,
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#explain().(analyze)
//              display_name analyze
//              documentation ```kotlin\nanalyze: Boolean\n```
//               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        options: String?,
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#explain().(options)
//              display_name options
//              documentation ```kotlin\noptions: String?\n```
//               ^^^^^^^ reference semanticdb maven . . kotlin/String#
        internalStatement: String,
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#explain().(internalStatement)
//                        display_name internalStatement
//                        documentation ```kotlin\ninternalStatement: String\n```
//                         ^^^^^^ reference semanticdb maven . . kotlin/String#
        transaction: Transaction
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#explain().(transaction)
//                  display_name transaction
//                  documentation ```kotlin\ntransaction: Transaction\n```
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
    ): String {
//     ^^^^^^ reference semanticdb maven . . kotlin/String#
        val sql = super.explain(analyze, options, internalStatement, transaction)
//          ^^^ definition local 1
//              display_name sql
//              documentation ```kotlin\nlocal val sql: String\n```
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#explain().(analyze)
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#explain().(options)
//                                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#explain().(internalStatement)
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#explain().(transaction)
        return if (analyze) {
//                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#explain().(analyze)
            sql.substringAfter("EXPLAIN ")
//          ^^^ reference local 1
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringAfter(+1).
        } else {
            sql
//          ^^^ reference local 1
        }
    }

    override fun returning(
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#returning().
//                         display_name returning
//                         documentation ```kotlin\npublic open override fun returning(mainSql: String, returning: List<Expression<*>>, transaction: Transaction): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().
        mainSql: String,
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#returning().(mainSql)
//              display_name mainSql
//              documentation ```kotlin\nmainSql: String\n```
//               ^^^^^^ reference semanticdb maven . . kotlin/String#
        returning: List<Expression<*>>,
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#returning().(returning)
//                display_name returning
//                documentation ```kotlin\nreturning: List<Expression<*>>\n```
//                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        transaction: Transaction
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#returning().(transaction)
//                  display_name transaction
//                  documentation ```kotlin\ntransaction: Transaction\n```
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
    ): String {
//     ^^^^^^ reference semanticdb maven . . kotlin/String#
        return with(QueryBuilder(true)) {
//             ^^^^ reference semanticdb maven . . kotlin/with().
//                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
            +"$mainSql RETURNING "
//          ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#returning().(mainSql)
            returning.appendTo { +it }
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#returning().(returning)
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                             ^^^^^^^ definition semanticdb maven . . (it)
//                                     display_name it
//                                     documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                               ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                ^^ reference semanticdb maven . . (it)
            toString()
//          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
        }
    }

    override fun isUpsertAliasSupported(dialect: DatabaseDialect): Boolean = false
//               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#isUpsertAliasSupported().
//                                      display_name isUpsertAliasSupported
//                                      documentation ```kotlin\npublic open override fun isUpsertAliasSupported(dialect: DatabaseDialect): Boolean\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#isUpsertAliasSupported().
//                                      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#isUpsertAliasSupported().(dialect)
//                                              display_name dialect
//                                              documentation ```kotlin\ndialect: DatabaseDialect\n```
//                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
//                                                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
}

/**
 * MariaDB dialect implementation.
 */
open class MariaDBDialect : MysqlDialect() {
//         ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#
//                        display_name MariaDBDialect
//                        documentation ```kotlin\npublic open class MariaDBDialect : MysqlDialect\n```\n\n----\n\n\n MariaDB dialect implementation.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//         ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#`<init>`().
//                        display_name MariaDBDialect
//                        documentation ```kotlin\npublic constructor(): MariaDBDialect\n```\n\n----\n\n\n MariaDB dialect implementation.\n
//                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
    override val name: String = dialectName
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#getName().
//                    display_name name
//                    documentation ```kotlin\npublic get(): String\n```
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#name.
//                    display_name name
//                    documentation ```kotlin\npublic open override val name: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
    override val dataTypeProvider: DataTypeProvider = MariaDBDataTypeProvider
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#dataTypeProvider.
//                                display_name dataTypeProvider
//                                documentation ```kotlin\npublic open override val dataTypeProvider: DataTypeProvider\n```
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#getDataTypeProvider().
//                                display_name dataTypeProvider
//                                documentation ```kotlin\npublic get(): DataTypeProvider\n```
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
    override val functionProvider: FunctionProvider = MariaDBFunctionProvider
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#functionProvider.
//                                display_name functionProvider
//                                documentation ```kotlin\npublic open override val functionProvider: FunctionProvider\n```
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#getFunctionProvider().
//                                display_name functionProvider
//                                documentation ```kotlin\npublic get(): FunctionProvider\n```
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
    override val supportsOnlyIdentifiersInGeneratedKeys: Boolean = true
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#getSupportsOnlyIdentifiersInGeneratedKeys().
//                                                      display_name supportsOnlyIdentifiersInGeneratedKeys
//                                                      documentation ```kotlin\npublic get(): Boolean\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#supportsOnlyIdentifiersInGeneratedKeys.
//                                                      display_name supportsOnlyIdentifiersInGeneratedKeys
//                                                      documentation ```kotlin\npublic open override val supportsOnlyIdentifiersInGeneratedKeys: Boolean\n```
//                                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    override val supportsSetDefaultReferenceOption: Boolean = false
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#getSupportsSetDefaultReferenceOption().
//                                                 display_name supportsSetDefaultReferenceOption
//                                                 documentation ```kotlin\npublic get(): Boolean\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#supportsSetDefaultReferenceOption.
//                                                 display_name supportsSetDefaultReferenceOption
//                                                 documentation ```kotlin\npublic open override val supportsSetDefaultReferenceOption: Boolean\n```
//                                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    override val supportsCreateSequence: Boolean by lazy {
//               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#getSupportsCreateSequence().
//                                      display_name supportsCreateSequence
//                                      documentation ```kotlin\npublic get(): Boolean\n```
//               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#supportsCreateSequence.
//                                      display_name supportsCreateSequence
//                                      documentation ```kotlin\npublic open override val supportsCreateSequence: Boolean\n```
//                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                  ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                  ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 3:5
//                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#getSupportsCreateSequence(). 3:5
//                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#supportsCreateSequence. 3:5
        @OptIn(InternalApi::class)
        CoreTransactionManager.currentTransaction().db.version.covers(SEQUENCE_MIN_MAJOR_VERSION, SEQUENCE_MIN_MINOR_VERSION)
//                             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                  ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                  ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getVersion().
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#version.
//                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+3).
//                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#Companion#SEQUENCE_MIN_MAJOR_VERSION.
//                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#Companion#getSEQUENCE_MIN_MAJOR_VERSION().
//                                                                                                ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#Companion#SEQUENCE_MIN_MINOR_VERSION.
//                                                                                                ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#Companion#getSEQUENCE_MIN_MINOR_VERSION().
    }

    // actually MariaDb supports it but jdbc driver prepares statement without RETURNING clause
    override val supportsSequenceAsGeneratedKeys: Boolean = false
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#getSupportsSequenceAsGeneratedKeys().
//                                               display_name supportsSequenceAsGeneratedKeys
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#supportsSequenceAsGeneratedKeys.
//                                               display_name supportsSequenceAsGeneratedKeys
//                                               documentation ```kotlin\npublic open override val supportsSequenceAsGeneratedKeys: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    @Suppress("MagicNumber")
    override val sequenceMaxValue: Long by lazy {
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#getSequenceMaxValue().
//                                display_name sequenceMaxValue
//                                documentation ```kotlin\npublic get(): Long\n```
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#sequenceMaxValue.
//                                display_name sequenceMaxValue
//                                documentation ```kotlin\n@Suppress(...) public open override val sequenceMaxValue: Long\n```
//                                 ^^^^ reference semanticdb maven . . kotlin/Long#
//                                         ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                         ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 7:5
//                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#getSequenceMaxValue(). 7:5
//                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#sequenceMaxValue. 7:5
        @OptIn(InternalApi::class)
        if (CoreTransactionManager.currentTransaction().db.version.covers(11, 5)) {
//                                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                      ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                      ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getVersion().
//                                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#version.
//                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+3).
            super.sequenceMaxValue
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSequenceMaxValue().
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#sequenceMaxValue.
        } else {
            Long.MAX_VALUE - 1
//               ^^^^^^^^^ reference semanticdb maven . . kotlin/Long#Companion#MAX_VALUE.
//               ^^^^^^^^^ reference semanticdb maven . . kotlin/Long#Companion#getMAX_VALUE().
//                         ^ reference semanticdb maven . . kotlin/Long#minus(+2).
        }
    }

    /** Returns `true` if the MariaDB database version is greater than or equal to 5.3. */
    @Suppress("MagicNumber")
    override fun isFractionDateTimeSupported(): Boolean {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#isFractionDateTimeSupported().
//                                           display_name isFractionDateTimeSupported
//                                           documentation ```kotlin\n@Suppress(...) public open override fun isFractionDateTimeSupported(): Boolean\n```\n\n----\n\n Returns `true` if the MariaDB database version is greater than or equal to 5.3.
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isFractionDateTimeSupported().
//                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        @OptIn(InternalApi::class)
        return CoreTransactionManager.currentTransaction().db.version.covers(5, 3)
//                                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getVersion().
//                                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#version.
//                                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+3).
    }

    override fun isTimeZoneOffsetSupported(): Boolean = false
//               ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#isTimeZoneOffsetSupported().
//                                         display_name isTimeZoneOffsetSupported
//                                         documentation ```kotlin\npublic open override fun isTimeZoneOffsetSupported(): Boolean\n```
//                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isTimeZoneOffsetSupported().
//                                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    override fun isAllowedAsColumnDefault(e: Expression<*>): Boolean {
//               ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#isAllowedAsColumnDefault().
//                                        display_name isAllowedAsColumnDefault
//                                        documentation ```kotlin\npublic open override fun isAllowedAsColumnDefault(e: Expression<*>): Boolean\n```
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isAllowedAsColumnDefault().
//                                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#isAllowedAsColumnDefault().(e)
//                                          display_name e
//                                          documentation ```kotlin\ne: Expression<*>\n```
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        if (e is LiteralOp<*>) return true
//          ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#isAllowedAsColumnDefault().(e)
        if (fullVersion >= "10.2.1") {
//          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#fullVersion.
//          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getFullVersion().
//                      ^^ reference semanticdb maven . . kotlin/String#compareTo().
            return true
        }

        // This check is quite optimistic, it will not allow to create a varchar columns with "CURRENT_DATE" default value for example
        // Comparing to the previous variant with white list of functions the new variant does not reject valid values,
        // it could be checked on the test UpsertTests::testUpsertWithColumnExpressions()
        return e.toString().trim() !in notAcceptableDefaults
//             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#isAllowedAsColumnDefault().(e)
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toString().
//                          ^^^^ reference semanticdb maven . . kotlin/text/trim(+5).
//                                 ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                                 ^^^ reference semanticdb maven . . kotlin/collections/MutableList#contains().
//                                     ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getNotAcceptableDefaults().
//                                     ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#notAcceptableDefaults.
    }

    override fun createIndex(index: Index): String {
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#createIndex().
//                           display_name createIndex
//                           documentation ```kotlin\npublic open override fun createIndex(index: Index): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createIndex().
//                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#createIndex().(index)
//                                 display_name index
//                                 documentation ```kotlin\nindex: Index\n```
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#
//                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
        if (index.functions != null) {
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#createIndex().(index)
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
            exposedLogger.warn(
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                        ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
                "Functional index on ${index.table.tableName} using ${index.functions.joinToString { it.toString() }} can't be created in MariaDB"
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#createIndex().(index)
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#createIndex().(index)
//                                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//                                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                                 ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                   display_name it
//                                                                                                                   documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                                                                   ^^ reference semanticdb maven . . (it)
//                                                                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toString().
            )
            return ""
        }
        return super.createIndex(index)
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createIndex().
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#createIndex().(index)
    }

    companion object : DialectNameProvider("MariaDB") {
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#Companion# 3:5
//                                                      display_name Companion
//                                                      documentation ```kotlin\npublic final companion object Companion : VendorDialect.DialectNameProvider\n```
//                                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#Companion#`<init>`(). 3:5
//                                                      display_name Companion
//                                                      documentation ```kotlin\nprivate constructor(): MariaDBDialect.Companion\n```
//                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
        private const val SEQUENCE_MIN_MAJOR_VERSION = 10
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#Companion#SEQUENCE_MIN_MAJOR_VERSION.
//                                                   display_name SEQUENCE_MIN_MAJOR_VERSION
//                                                   documentation ```kotlin\nprivate final const val SEQUENCE_MIN_MAJOR_VERSION: Int\n```
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#Companion#getSEQUENCE_MIN_MAJOR_VERSION().
//                                                   display_name SEQUENCE_MIN_MAJOR_VERSION
//                                                   documentation ```kotlin\nprivate get(): Int\n```
        private const val SEQUENCE_MIN_MINOR_VERSION = 3
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#Companion#SEQUENCE_MIN_MINOR_VERSION.
//                                                   display_name SEQUENCE_MIN_MINOR_VERSION
//                                                   documentation ```kotlin\nprivate final const val SEQUENCE_MIN_MINOR_VERSION: Int\n```
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#Companion#getSEQUENCE_MIN_MINOR_VERSION().
//                                                   display_name SEQUENCE_MIN_MINOR_VERSION
//                                                   documentation ```kotlin\nprivate get(): Int\n```
    }
}
