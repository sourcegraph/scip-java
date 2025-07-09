package org.jetbrains.exposed.v1.core
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/

import org.jetbrains.exposed.v1.core.SqlExpressionBuilder.wrap
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlExpressionBuilder#
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlExpressionBuilder/wrap/
import org.jetbrains.exposed.v1.core.dao.id.CompositeID
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                       ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
//                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
import org.jetbrains.exposed.v1.core.dao.id.EntityID
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                       ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
import org.jetbrains.exposed.v1.core.statements.api.ExposedBlob
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                              ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/
//                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#
import org.jetbrains.exposed.v1.core.vendors.*
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
import java.math.BigDecimal
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/math/
//               ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#

/**
 * Represents an SQL operator.
 */
@Suppress("UnnecessaryAbstractClass")
abstract class Op<T> : Expression<T>() {
//             ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                display_name Op
//                documentation ```kotlin\n@Suppress(...) public abstract class Op<T> : Expression<T>\n```\n\n----\n\n\n Represents an SQL operator.\n
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Between#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Exists#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NotExists#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NotOp#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#FALSE#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#NULL#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#TRUE#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#
//             ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#`<init>`().
//                display_name Op
//                documentation ```kotlin\npublic constructor<T>(): Op<T>\n```\n\n----\n\n\n Represents an SQL operator.\n
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    companion object {
//  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion# 5:5
//                     display_name Companion
//                     documentation ```kotlin\npublic final companion object Companion : Any\n```\n\n----\n\n Builds a new operator using provided [op].
//  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion#`<init>`(). 5:5
//                     display_name Companion
//                     documentation ```kotlin\nprivate constructor(): Op.Companion\n```\n\n----\n\n Builds a new operator using provided [op].
        /** Builds a new operator using provided [op]. */
        inline fun <T> build(op: SqlExpressionBuilder.() -> Op<T>): Op<T> = SqlExpressionBuilder.op()
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion#build().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion#build().
//                           display_name build
//                           documentation ```kotlin\npublic final inline fun <T> build(op: SqlExpressionBuilder.() -> Op<T>): Op<T>\n```\n\n----\n\n Builds a new operator using provided [op].
//                           ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion#build().(op)
//                              display_name op
//                              documentation ```kotlin\nop: SqlExpressionBuilder.() -> Op<T>\n```
//                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                                                               ^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                                               ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion#build().(op)

        fun <T> nullOp(): Op<T> = NULL as Op<T>
//           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion#nullOp().[T]
//             display_name FirTypeParameterSymbol T
//             documentation ```kotlin\nT\n```
//              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion#nullOp().
//                     display_name nullOp
//                     documentation ```kotlin\npublic final fun <T> nullOp(): Op<T>\n```
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
    }

    internal interface OpBoolean
//                     ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//                               display_name OpBoolean
//                               documentation ```kotlin\ninternal abstract interface OpBoolean : Any\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Between#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Exists#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NotExists#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NotOp#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#FALSE#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#TRUE#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#

    /**
     * Boolean operator that always evaluates to the SQL value `TRUE`.
     *
     * **Note** Some databases, like SQL Server and Oracle, do not support conditions like `WHERE 1` or `WHERE TRUE`.
     * When using these databases, this operator will instead produce the condition `1 = 1`.
     */
    object TRUE : Op<Boolean>(), OpBoolean {
//         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#TRUE#
//              display_name TRUE
//              documentation ```kotlin\npublic final object TRUE : Op<Boolean>, Op.OpBoolean\n```\n\n----\n\n\n Boolean operator that always evaluates to the SQL value `TRUE`.\n\n **Note** Some databases, like SQL Server and Oracle, do not support conditions like `WHERE 1` or `WHERE TRUE`.\n When using these databases, this operator will instead produce the condition `1 = 1`.\n
//              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#TRUE#`<init>`().
//              display_name TRUE
//              documentation ```kotlin\nprivate constructor(): Op.TRUE\n```\n\n----\n\n\n Boolean operator that always evaluates to the SQL value `TRUE`.\n\n **Note** Some databases, like SQL Server and Oracle, do not support conditions like `WHERE 1` or `WHERE TRUE`.\n When using these databases, this operator will instead produce the condition `1 = 1`.\n
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
        override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//                   ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#TRUE#toQueryBuilder().
//                                  display_name toQueryBuilder
//                                  documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                                  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#TRUE#toQueryBuilder().(queryBuilder)
//                                               display_name queryBuilder
//                                               documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                               ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#TRUE#toQueryBuilder().(queryBuilder)
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
            when {
                currentDialect is SQLServerDialect || currentDialect is OracleDialect || currentDialect.h2Mode == H2Dialect.H2CompatibilityMode.Oracle ->
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                                                                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
                    build { booleanLiteral(true) eq booleanLiteral(true) }.toQueryBuilder(this)
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion#build().
//                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/booleanLiteral().
//                                               ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).
//                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/booleanLiteral().
//                                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().

                else -> append(currentDialect.dataTypeProvider.booleanToStatementString(true))
//                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                             ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanToStatementString().
            }
        }
    }

    /**
     * Boolean operator that always evaluates to the SQL value `FALSE`.
     *
     * **Note** Some databases, like SQL Server and Oracle, do not support conditions like `WHERE 0` or `WHERE FALSE`.
     * When using these databases, this operator will instead produce the condition `1 = 0`.
     */
    object FALSE : Op<Boolean>(), OpBoolean {
//         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#FALSE#
//               display_name FALSE
//               documentation ```kotlin\npublic final object FALSE : Op<Boolean>, Op.OpBoolean\n```\n\n----\n\n\n Boolean operator that always evaluates to the SQL value `FALSE`.\n\n **Note** Some databases, like SQL Server and Oracle, do not support conditions like `WHERE 0` or `WHERE FALSE`.\n When using these databases, this operator will instead produce the condition `1 = 0`.\n
//               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#FALSE#`<init>`().
//               display_name FALSE
//               documentation ```kotlin\nprivate constructor(): Op.FALSE\n```\n\n----\n\n\n Boolean operator that always evaluates to the SQL value `FALSE`.\n\n **Note** Some databases, like SQL Server and Oracle, do not support conditions like `WHERE 0` or `WHERE FALSE`.\n When using these databases, this operator will instead produce the condition `1 = 0`.\n
//                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
        override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//                   ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#FALSE#toQueryBuilder().
//                                  display_name toQueryBuilder
//                                  documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                                  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#FALSE#toQueryBuilder().(queryBuilder)
//                                               display_name queryBuilder
//                                               documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                               ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#FALSE#toQueryBuilder().(queryBuilder)
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
            when {
                currentDialect is SQLServerDialect || currentDialect is OracleDialect || currentDialect.h2Mode == H2Dialect.H2CompatibilityMode.Oracle ->
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                                                                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
                    build { booleanLiteral(true) eq booleanLiteral(false) }.toQueryBuilder(this)
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion#build().
//                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/booleanLiteral().
//                                               ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).
//                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/booleanLiteral().
//                                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
                else -> append(currentDialect.dataTypeProvider.booleanToStatementString(false))
//                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                             ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanToStatementString().
            }
        }
    }

    internal object NULL : Op<Any>() {
//                  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#NULL#
//                       display_name NULL
//                       documentation ```kotlin\ninternal final object NULL : Op<Any>\n```
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#NULL#`<init>`().
//                       display_name NULL
//                       documentation ```kotlin\nprivate constructor(): Op.NULL\n```
//                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
        override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//                   ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#NULL#toQueryBuilder().
//                                  display_name toQueryBuilder
//                                  documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                                  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Op#NULL#toQueryBuilder().(queryBuilder)
//                                               display_name queryBuilder
//                                               documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                               ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#NULL#toQueryBuilder().(queryBuilder)
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
            append("NULL")
//          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
        }
    }
}

// Logical Operators

/**
 * Represents a logical operator that inverts the specified boolean [expr].
 */
class NotOp<T>(
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotOp#
//          display_name NotOp
//          documentation ```kotlin\npublic final class NotOp<T> : Op<Boolean>, Op.OpBoolean\n```\n\n----\n\n\n Represents a logical operator that inverts the specified boolean [expr].\n
//          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotOp#`<init>`().
//          display_name NotOp
//          documentation ```kotlin\npublic constructor<T>(expr: Expression<T>): NotOp<T>\n```\n\n----\n\n Returns the expression being inverted.
//          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotOp#[T]
//            display_name FirTypeParameterSymbol T
//            documentation ```kotlin\nT\n```
    /** Returns the expression being inverted. */
    val expr: Expression<T>
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotOp#`<init>`().(expr)
//           display_name expr
//           documentation ```kotlin\nexpr: Expression<T>\n```\n\n----\n\n Returns the expression being inverted.
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotOp#`<init>`().(expr)
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotOp#expr.
//           display_name expr
//           documentation ```kotlin\npublic final val expr: Expression<T>\n```\n\n----\n\n Returns the expression being inverted.
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotOp#getExpr().
//           display_name expr
//           documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n Returns the expression being inverted.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
) : Op<Boolean>(), Op.OpBoolean {
//  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder { append("NOT (", expr, ")") }
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotOp#toQueryBuilder().(queryBuilder)
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotOp#expr.
//                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotOp#getExpr().
}

/**
 * Marker interface which indicates that expression should be wrapped with braces when used in compound operators
 */
interface ComplexExpression
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                          display_name ComplexExpression
//                          documentation ```kotlin\npublic abstract interface ComplexExpression : Any\n```\n\n----\n\n\n Marker interface which indicates that expression should be wrapped with braces when used in compound operators\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Between#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#

/**
 * Represent a logical operator that performs an operation between all the specified [expressions].
 * This is the base class for the `and` and `or` operators:
 *
 * @see AndOp
 * @see OrOp
 */
sealed class CompoundBooleanOp(
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#
//                             display_name CompoundBooleanOp
//                             documentation ```kotlin\npublic sealed class CompoundBooleanOp : Op<Boolean>, ComplexExpression, Op.OpBoolean\n```\n\n----\n\n\n Represent a logical operator that performs an operation between all the specified [expressions].\n This is the base class for the `and` and `or` operators:\n\n @see AndOp\n @see OrOp\n
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/AndOp#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/OrOp#
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#`<init>`().
//                             display_name CompoundBooleanOp
//                             documentation ```kotlin\nprotected constructor(operator: String, expressions: List<Expression<Boolean>>): CompoundBooleanOp\n```
    private val operator: String,
//              ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#`<init>`().(operator)
//                       display_name operator
//                       documentation ```kotlin\noperator: String\n```
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#`<init>`().(operator)
//              ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#getOperator().
//                       display_name operator
//                       documentation ```kotlin\nprivate get(): String\n```
//              ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#operator.
//                       display_name operator
//                       documentation ```kotlin\nprivate final val operator: String\n```
//                        ^^^^^^ reference semanticdb maven . . kotlin/String#
    internal val expressions: List<Expression<Boolean>>
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#`<init>`().(expressions)
//                           display_name expressions
//                           documentation ```kotlin\nexpressions: List<Expression<Boolean>>\n```
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#`<init>`().(expressions)
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#expressions.
//                           display_name expressions
//                           documentation ```kotlin\ninternal final val expressions: List<Expression<Boolean>>\n```
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#getExpressions().
//                           display_name expressions
//                           documentation ```kotlin\ninternal get(): List<Expression<Boolean>>\n```
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
) : Op<Boolean>(), ComplexExpression, Op.OpBoolean {
//  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#toQueryBuilder().(queryBuilder)
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
        expressions.appendTo(this, separator = operator) { appendExpression(it) }
//      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#expressions.
//      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#getExpressions().
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#getOperator().
//                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#operator.
//                                                       ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                display_name it
//                                                                                documentation ```kotlin\nit: CompositeID\n```
//                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendExpression().
//                                                                          ^^ reference semanticdb maven . . (it)
    }
}

/**
 * Represents a logical operator that performs an `and` operation between all the specified [expressions].
 */
class AndOp(expressions: List<Expression<Boolean>>) : CompoundBooleanOp(" AND ", expressions)
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndOp#
//          display_name AndOp
//          documentation ```kotlin\npublic final class AndOp : CompoundBooleanOp\n```\n\n----\n\n\n Represents a logical operator that performs an `and` operation between all the specified [expressions].\n
//          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndOp#`<init>`().
//          display_name AndOp
//          documentation ```kotlin\npublic constructor(expressions: List<Expression<Boolean>>): AndOp\n```
//          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndOp#`<init>`().(expressions)
//                      display_name expressions
//                      documentation ```kotlin\nexpressions: List<Expression<Boolean>>\n```
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#
//                                                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndOp#`<init>`().(expressions)

/**
 * Represents a logical operator that performs an `or` operation between all the specified [expressions].
 */
class OrOp(expressions: List<Expression<Boolean>>) : CompoundBooleanOp(" OR ", expressions)
//    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrOp#
//         display_name OrOp
//         documentation ```kotlin\npublic final class OrOp : CompoundBooleanOp\n```\n\n----\n\n\n Represents a logical operator that performs an `or` operation between all the specified [expressions].\n
//         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#
//    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrOp#`<init>`().
//         display_name OrOp
//         documentation ```kotlin\npublic constructor(expressions: List<Expression<Boolean>>): OrOp\n```
//         ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrOp#`<init>`().(expressions)
//                     display_name expressions
//                     documentation ```kotlin\nexpressions: List<Expression<Boolean>>\n```
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#
//                                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrOp#`<init>`().(expressions)

/** Returns the inverse of this boolean expression. */
fun not(op: Expression<Boolean>): Op<Boolean> = NotOp(op)
//  ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/not().
//      display_name not
//      documentation ```kotlin\npublic final fun not(op: Expression<Boolean>): Op<Boolean>\n```\n\n----\n\n Returns the inverse of this boolean expression.
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/not().(op)
//         display_name op
//         documentation ```kotlin\nop: Expression<Boolean>\n```
//          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotOp#`<init>`().
//                                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/not().(op)

/** Returns the result of performing a logical `and` operation between this expression and the [op]. */
infix fun Expression<Boolean>.and(op: Expression<Boolean>): Op<Boolean> = when {
//                            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/and().
//                                display_name and
//                                documentation ```kotlin\npublic final infix fun Expression<Boolean>.and(op: Expression<Boolean>): Op<Boolean>\n```\n\n----\n\n Returns the result of performing a logical `and` operation between this expression and the [op].
//                                ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/and().(op)
//                                   display_name op
//                                   documentation ```kotlin\nop: Expression<Boolean>\n```
//                                    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
    this is AndOp && op is AndOp -> AndOp(expressions + op.expressions)
//                   ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/and().(op)
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndOp#`<init>`().
//                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#expressions.
//                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#getExpressions().
//                                                    ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                      ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/and().(op)
//                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#expressions.
//                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#getExpressions().
    this is AndOp -> AndOp(expressions + op)
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndOp#`<init>`().
//                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#expressions.
//                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#getExpressions().
//                                     ^ reference semanticdb maven . . kotlin/collections/plus(+28).
//                                       ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/and().(op)
    op is AndOp -> AndOp(
//  ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/and().(op)
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndOp#`<init>`().
        ArrayList<Expression<Boolean>>(op.expressions.size + 1).also {
//      ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`().
//                                     ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/and().(op)
//                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#expressions.
//                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#getExpressions().
//                                                    ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                                    ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                                         ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                                                              ^^^^ reference semanticdb maven . . kotlin/also().
//                                                                   ^ definition semanticdb maven . . (it) 3:9
//                                                                     display_name it
//                                                                     documentation ```kotlin\nit: CompositeID\n```
            it.add(this)
//          ^^ reference semanticdb maven . . (it)
//             ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add().
            it.addAll(op.expressions)
//          ^^ reference semanticdb maven . . (it)
//             ^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#addAll().
//                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/and().(op)
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#expressions.
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#getExpressions().
        }
    )
    else -> AndOp(listOf(this, op))
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndOp#`<init>`().
//                ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf(+1).
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/and().(op)
}

/** Returns the result of performing a logical `or` operation between this expression and the [op]. */
infix fun Expression<Boolean>.or(op: Expression<Boolean>): Op<Boolean> = when {
//                            ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/or().
//                               display_name or
//                               documentation ```kotlin\npublic final infix fun Expression<Boolean>.or(op: Expression<Boolean>): Op<Boolean>\n```\n\n----\n\n Returns the result of performing a logical `or` operation between this expression and the [op].
//                               ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/or().(op)
//                                  display_name op
//                                  documentation ```kotlin\nop: Expression<Boolean>\n```
//                                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
    this is OrOp && op is OrOp -> OrOp(expressions + op.expressions)
//                  ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/or().(op)
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrOp#`<init>`().
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#expressions.
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#getExpressions().
//                                                 ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                   ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/or().(op)
//                                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#expressions.
//                                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#getExpressions().
    this is OrOp -> OrOp(expressions + op)
//                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrOp#`<init>`().
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#expressions.
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#getExpressions().
//                                   ^ reference semanticdb maven . . kotlin/collections/plus(+28).
//                                     ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/or().(op)
    op is OrOp -> OrOp(
//  ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/or().(op)
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrOp#`<init>`().
        ArrayList<Expression<Boolean>>(op.expressions.size + 1).also {
//      ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`().
//                                     ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/or().(op)
//                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#expressions.
//                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#getExpressions().
//                                                    ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                                    ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                                         ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                                                              ^^^^ reference semanticdb maven . . kotlin/also().
//                                                                   ^ definition semanticdb maven . . (it) 3:9
//                                                                     display_name it
//                                                                     documentation ```kotlin\nit: CompositeID\n```
            it.add(this)
//          ^^ reference semanticdb maven . . (it)
//             ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add().
            it.addAll(op.expressions)
//          ^^ reference semanticdb maven . . (it)
//             ^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#addAll().
//                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/or().(op)
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#expressions.
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompoundBooleanOp#getExpressions().
        }
    )
    else -> OrOp(listOf(this, op))
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrOp#`<init>`().
//               ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf(+1).
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/or().(op)
}

/**
 * Returns the result of performing a logical `and` operation between this expression and the [op] **if** [op] is not null.
 * Otherwise, this expression will be returned.
 */
infix fun Op<Boolean>.andIfNotNull(op: Expression<Boolean>?): Op<Boolean> =
//                    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/andIfNotNull().
//                                 display_name andIfNotNull
//                                 documentation ```kotlin\npublic final infix fun Op<Boolean>.andIfNotNull(op: Expression<Boolean>?): Op<Boolean>\n```\n\n----\n\n\n Returns the result of performing a logical `and` operation between this expression and the [op] **if** [op] is not null.\n Otherwise, this expression will be returned.\n
//                                 ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/andIfNotNull().(op)
//                                    display_name op
//                                    documentation ```kotlin\nop: Expression<Boolean>?\n```
//                                     ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
    op?.let { this and it } ?: this
//  ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/andIfNotNull().(op)
//      ^^^ reference semanticdb maven . . kotlin/let().
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                          display_name it
//                          documentation ```kotlin\nit: CompositeID\n```
//                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/and().
//                     ^^ reference semanticdb maven . . (it)

/**
 * Returns the result of performing a logical `or` operation between this expression and the [op] **if** [op] is not null.
 * Otherwise, this expression will be returned.
 */
infix fun Op<Boolean>.orIfNotNull(op: Expression<Boolean>?): Op<Boolean> =
//                    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/orIfNotNull().
//                                display_name orIfNotNull
//                                documentation ```kotlin\npublic final infix fun Op<Boolean>.orIfNotNull(op: Expression<Boolean>?): Op<Boolean>\n```\n\n----\n\n\n Returns the result of performing a logical `or` operation between this expression and the [op] **if** [op] is not null.\n Otherwise, this expression will be returned.\n
//                                ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/orIfNotNull().(op)
//                                   display_name op
//                                   documentation ```kotlin\nop: Expression<Boolean>?\n```
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
    op?.let { this or it } ?: this
//  ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/orIfNotNull().(op)
//      ^^^ reference semanticdb maven . . kotlin/let().
//          ^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                         display_name it
//                         documentation ```kotlin\nit: CompositeID\n```
//                 ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/or().
//                    ^^ reference semanticdb maven . . (it)

/** Reduces this list to a single expression by performing an `and` operation between all the expressions in the list. */
fun List<Op<Boolean>>.compoundAnd(): Op<Boolean> = reduce(Op<Boolean>::and)
//                    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/compoundAnd().
//                                display_name compoundAnd
//                                documentation ```kotlin\npublic final fun List<Op<Boolean>>.compoundAnd(): Op<Boolean>\n```\n\n----\n\n Reduces this list to a single expression by performing an `and` operation between all the expressions in the list.
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/collections/reduce(+9).
//                                                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/and().

/** Reduces this list to a single expression by performing an `or` operation between all the expressions in the list. */
fun List<Op<Boolean>>.compoundOr(): Op<Boolean> = reduce(Op<Boolean>::or)
//                    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/compoundOr().
//                               display_name compoundOr
//                               documentation ```kotlin\npublic final fun List<Op<Boolean>>.compoundOr(): Op<Boolean>\n```\n\n----\n\n Reduces this list to a single expression by performing an `or` operation between all the expressions in the list.
//                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                ^^^^^^ reference semanticdb maven . . kotlin/collections/reduce(+9).
//                                                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/or().

/** Returns the result of performing a logical `and` operation between this expression and the [op]. */
inline fun Expression<Boolean>.and(op: SqlExpressionBuilder.() -> Op<Boolean>): Op<Boolean> = and(Op.build(op))
//                             ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/and(+1).
//                                 display_name and
//                                 documentation ```kotlin\npublic final inline fun Expression<Boolean>.and(op: SqlExpressionBuilder.() -> Op<Boolean>): Op<Boolean>\n```\n\n----\n\n Returns the result of performing a logical `and` operation between this expression and the [op].
//                                 ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/and(+1).(op)
//                                    display_name op
//                                    documentation ```kotlin\nop: SqlExpressionBuilder.() -> Op<Boolean>\n```
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                                                            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/and().
//                                                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion#build().
//                                                                                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/and(+1).(op)

/**  Returns the result of performing a logical `or` operation between this expression and the [op].*/
inline fun Expression<Boolean>.or(op: SqlExpressionBuilder.() -> Op<Boolean>): Op<Boolean> = or(Op.build(op))
//                             ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/or(+1).
//                                display_name or
//                                documentation ```kotlin\npublic final inline fun Expression<Boolean>.or(op: SqlExpressionBuilder.() -> Op<Boolean>): Op<Boolean>\n```\n\n----\n\n  Returns the result of performing a logical `or` operation between this expression and the [op].
//                                ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/or(+1).(op)
//                                   display_name op
//                                   documentation ```kotlin\nop: SqlExpressionBuilder.() -> Op<Boolean>\n```
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                                                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/or().
//                                                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion#build().
//                                                                                                       ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/or(+1).(op)

/** Returns the result of performing a logical `and` operation between this expression and the negate [op]. */
inline fun Expression<Boolean>.andNot(op: SqlExpressionBuilder.() -> Op<Boolean>): Op<Boolean> = and(not(Op.build(op)))
//                             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/andNot().
//                                    display_name andNot
//                                    documentation ```kotlin\npublic final inline fun Expression<Boolean>.andNot(op: SqlExpressionBuilder.() -> Op<Boolean>): Op<Boolean>\n```\n\n----\n\n Returns the result of performing a logical `and` operation between this expression and the negate [op].
//                                    ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/andNot().(op)
//                                       display_name op
//                                       documentation ```kotlin\nop: SqlExpressionBuilder.() -> Op<Boolean>\n```
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                                                               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/and().
//                                                                                                   ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/not().
//                                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion#build().
//                                                                                                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/andNot().(op)

/** Returns the result of performing a logical `or` operation between this expression and the negate [op]. */
inline fun Expression<Boolean>.orNot(op: SqlExpressionBuilder.() -> Op<Boolean>): Op<Boolean> = or(not(Op.build(op)))
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/orNot().
//                                   display_name orNot
//                                   documentation ```kotlin\npublic final inline fun Expression<Boolean>.orNot(op: SqlExpressionBuilder.() -> Op<Boolean>): Op<Boolean>\n```\n\n----\n\n Returns the result of performing a logical `or` operation between this expression and the negate [op].
//                                   ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/orNot().(op)
//                                      display_name op
//                                      documentation ```kotlin\nop: SqlExpressionBuilder.() -> Op<Boolean>\n```
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                                                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/or().
//                                                                                                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/not().
//                                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion#build().
//                                                                                                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/orNot().(op)

/**
 * Returns the result of performing a logical `and` operation between this expression and the [op] **if** [op] is not null.
 * Otherwise, this expression will be returned.
 */
inline fun Op<Boolean>.andIfNotNull(op: SqlExpressionBuilder.() -> Op<Boolean>?): Op<Boolean> = andIfNotNull(SqlExpressionBuilder.op())
//                     ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/andIfNotNull(+1).
//                                  display_name andIfNotNull
//                                  documentation ```kotlin\npublic final inline fun Op<Boolean>.andIfNotNull(op: SqlExpressionBuilder.() -> Op<Boolean>?): Op<Boolean>\n```\n\n----\n\n\n Returns the result of performing a logical `and` operation between this expression and the [op] **if** [op] is not null.\n Otherwise, this expression will be returned.\n
//                                  ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/andIfNotNull(+1).(op)
//                                     display_name op
//                                     documentation ```kotlin\nop: SqlExpressionBuilder.() -> Op<Boolean>?\n```
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/andIfNotNull().
//                                                                                                                                ^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                                                                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/andIfNotNull(+1).(op)

/**
 * Returns the result of performing a logical `or` operation between this expression and the [op] **if** [op] is not null.
 * Otherwise, this expression will be returned.
 */
inline fun Op<Boolean>.orIfNotNull(op: SqlExpressionBuilder.() -> Op<Boolean>?): Op<Boolean> = orIfNotNull(SqlExpressionBuilder.op())
//                     ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/orIfNotNull(+1).
//                                 display_name orIfNotNull
//                                 documentation ```kotlin\npublic final inline fun Op<Boolean>.orIfNotNull(op: SqlExpressionBuilder.() -> Op<Boolean>?): Op<Boolean>\n```\n\n----\n\n\n Returns the result of performing a logical `or` operation between this expression and the [op] **if** [op] is not null.\n Otherwise, this expression will be returned.\n
//                                 ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/orIfNotNull(+1).(op)
//                                    display_name op
//                                    documentation ```kotlin\nop: SqlExpressionBuilder.() -> Op<Boolean>?\n```
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/orIfNotNull().
//                                                                                                                              ^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                                                                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/orIfNotNull(+1).(op)

// Comparison Operators

/**
 * Represents a comparison between [expr1] and [expr2] using the given SQL [opSign].
 */
abstract class ComparisonOp(
//             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//                          display_name ComparisonOp
//                          documentation ```kotlin\npublic abstract class ComparisonOp : Op<Boolean>, ComplexExpression, Op.OpBoolean\n```\n\n----\n\n\n Represents a comparison between [expr1] and [expr2] using the given SQL [opSign].\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NeqOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#`<init>`().
//                          display_name ComparisonOp
//                          documentation ```kotlin\npublic constructor(expr1: Expression<*>, expr2: Expression<*>, opSign: String): ComparisonOp\n```\n\n----\n\n Returns the left-hand side operand.
    /** Returns the left-hand side operand. */
    val expr1: Expression<*>,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#`<init>`().(expr1)
//            display_name expr1
//            documentation ```kotlin\nexpr1: Expression<*>\n```\n\n----\n\n Returns the left-hand side operand.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#`<init>`().(expr1)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#expr1.
//            display_name expr1
//            documentation ```kotlin\npublic final val expr1: Expression<*>\n```\n\n----\n\n Returns the left-hand side operand.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#getExpr1().
//            display_name expr1
//            documentation ```kotlin\npublic get(): Expression<*>\n```\n\n----\n\n Returns the left-hand side operand.
//             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** Returns the right-hand side operand. */
    val expr2: Expression<*>,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#`<init>`().(expr2)
//            display_name expr2
//            documentation ```kotlin\nexpr2: Expression<*>\n```\n\n----\n\n Returns the right-hand side operand.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#`<init>`().(expr2)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#expr2.
//            display_name expr2
//            documentation ```kotlin\npublic final val expr2: Expression<*>\n```\n\n----\n\n Returns the right-hand side operand.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#getExpr2().
//            display_name expr2
//            documentation ```kotlin\npublic get(): Expression<*>\n```\n\n----\n\n Returns the right-hand side operand.
//             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** Returns the symbol of the comparison operation. */
    val opSign: String
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#`<init>`().(opSign)
//             display_name opSign
//             documentation ```kotlin\nopSign: String\n```\n\n----\n\n Returns the symbol of the comparison operation.
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#`<init>`().(opSign)
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#getOpSign().
//             display_name opSign
//             documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Returns the symbol of the comparison operation.
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#opSign.
//             display_name opSign
//             documentation ```kotlin\npublic final val opSign: String\n```\n\n----\n\n Returns the symbol of the comparison operation.
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
) : Op<Boolean>(), ComplexExpression, Op.OpBoolean {
//  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#toQueryBuilder().
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#toQueryBuilder().(queryBuilder)
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
        appendComparison(expr1, expr2, opSign)
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendComparison().
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#expr1.
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#getExpr1().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#expr2.
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#getExpr2().
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#getOpSign().
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#opSign.
    }
}

/**
 * Represents an SQL operator that checks if [expr1] is equals to [expr2].
 */
class EqOp(expr1: Expression<*>, expr2: Expression<*>) : ComparisonOp(expr1, expr2, "=")
//    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#
//         display_name EqOp
//         documentation ```kotlin\npublic final class EqOp : ComparisonOp\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr1] is equals to [expr2].\n
//         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#`<init>`().
//         display_name EqOp
//         documentation ```kotlin\npublic constructor(expr1: Expression<*>, expr2: Expression<*>): EqOp\n```
//         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#`<init>`().(expr1)
//               display_name expr1
//               documentation ```kotlin\nexpr1: Expression<*>\n```
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#`<init>`().(expr2)
//                                     display_name expr2
//                                     documentation ```kotlin\nexpr2: Expression<*>\n```
//                                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#`<init>`().(expr1)
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#`<init>`().(expr2)

/**
 * Represents an SQL operator that checks if [expr1] is not equals to [expr2].
 */
class NeqOp(expr1: Expression<*>, expr2: Expression<*>) : ComparisonOp(expr1, expr2, "<>")
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NeqOp#
//          display_name NeqOp
//          documentation ```kotlin\npublic final class NeqOp : ComparisonOp\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr1] is not equals to [expr2].\n
//          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NeqOp#`<init>`().
//          display_name NeqOp
//          documentation ```kotlin\npublic constructor(expr1: Expression<*>, expr2: Expression<*>): NeqOp\n```
//          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NeqOp#`<init>`().(expr1)
//                display_name expr1
//                documentation ```kotlin\nexpr1: Expression<*>\n```
//                 ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NeqOp#`<init>`().(expr2)
//                                      display_name expr2
//                                      documentation ```kotlin\nexpr2: Expression<*>\n```
//                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NeqOp#`<init>`().(expr1)
//                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NeqOp#`<init>`().(expr2)

/**
 * Represents an SQL operator that checks if [expr1] is less than [expr2].
 */
class LessOp(expr1: Expression<*>, expr2: Expression<*>) : ComparisonOp(expr1, expr2, "<")
//    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#
//           display_name LessOp
//           documentation ```kotlin\npublic final class LessOp : ComparisonOp\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr1] is less than [expr2].\n
//           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#`<init>`().
//           display_name LessOp
//           documentation ```kotlin\npublic constructor(expr1: Expression<*>, expr2: Expression<*>): LessOp\n```
//           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#`<init>`().(expr1)
//                 display_name expr1
//                 documentation ```kotlin\nexpr1: Expression<*>\n```
//                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#`<init>`().(expr2)
//                                       display_name expr2
//                                       documentation ```kotlin\nexpr2: Expression<*>\n```
//                                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#`<init>`().(expr1)
//                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#`<init>`().(expr2)

/**
 * Represents an SQL operator that checks if [expr1] is less than or equal to [expr2].
 */
class LessEqOp(expr1: Expression<*>, expr2: Expression<*>) : ComparisonOp(expr1, expr2, "<=")
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#
//             display_name LessEqOp
//             documentation ```kotlin\npublic final class LessEqOp : ComparisonOp\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr1] is less than or equal to [expr2].\n
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#`<init>`().
//             display_name LessEqOp
//             documentation ```kotlin\npublic constructor(expr1: Expression<*>, expr2: Expression<*>): LessEqOp\n```
//             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#`<init>`().(expr1)
//                   display_name expr1
//                   documentation ```kotlin\nexpr1: Expression<*>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                   ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#`<init>`().(expr2)
//                                         display_name expr2
//                                         documentation ```kotlin\nexpr2: Expression<*>\n```
//                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#`<init>`().(expr1)
//                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#`<init>`().(expr2)

/**
 * Represents an SQL operator that checks if [expr1] is greater than [expr2].
 */
class GreaterOp(expr1: Expression<*>, expr2: Expression<*>) : ComparisonOp(expr1, expr2, ">")
//    ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#
//              display_name GreaterOp
//              documentation ```kotlin\npublic final class GreaterOp : ComparisonOp\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr1] is greater than [expr2].\n
//              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//    ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#`<init>`().
//              display_name GreaterOp
//              documentation ```kotlin\npublic constructor(expr1: Expression<*>, expr2: Expression<*>): GreaterOp\n```
//              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#`<init>`().(expr1)
//                    display_name expr1
//                    documentation ```kotlin\nexpr1: Expression<*>\n```
//                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#`<init>`().(expr2)
//                                          display_name expr2
//                                          documentation ```kotlin\nexpr2: Expression<*>\n```
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#`<init>`().(expr1)
//                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#`<init>`().(expr2)

/**
 * Represents an SQL operator that checks if [expr1] is greater than or equal to [expr2].
 */
class GreaterEqOp(expr1: Expression<*>, expr2: Expression<*>) : ComparisonOp(expr1, expr2, ">=")
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#
//                display_name GreaterEqOp
//                documentation ```kotlin\npublic final class GreaterEqOp : ComparisonOp\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr1] is greater than or equal to [expr2].\n
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#`<init>`().
//                display_name GreaterEqOp
//                documentation ```kotlin\npublic constructor(expr1: Expression<*>, expr2: Expression<*>): GreaterEqOp\n```
//                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#`<init>`().(expr1)
//                      display_name expr1
//                      documentation ```kotlin\nexpr1: Expression<*>\n```
//                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#`<init>`().(expr2)
//                                            display_name expr2
//                                            documentation ```kotlin\nexpr2: Expression<*>\n```
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#`<init>`().(expr1)
//                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#`<init>`().(expr2)

/**
 * Represents an SQL operator that checks if the specified [expr] is between the values [from] and [to].
 */
class Between(
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Between#
//            display_name Between
//            documentation ```kotlin\npublic final class Between : Op<Boolean>, ComplexExpression, Op.OpBoolean\n```\n\n----\n\n\n Represents an SQL operator that checks if the specified [expr] is between the values [from] and [to].\n
//            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Between#`<init>`().
//            display_name Between
//            documentation ```kotlin\npublic constructor(expr: Expression<*>, from: Expression<*>, to: Expression<*>): Between\n```\n\n----\n\n The expression being checked.
    /** The expression being checked. */
    val expr: Expression<*>,
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Between#`<init>`().(expr)
//           display_name expr
//           documentation ```kotlin\nexpr: Expression<*>\n```\n\n----\n\n The expression being checked.
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Between#`<init>`().(expr)
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Between#expr.
//           display_name expr
//           documentation ```kotlin\npublic final val expr: Expression<*>\n```\n\n----\n\n The expression being checked.
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Between#getExpr().
//           display_name expr
//           documentation ```kotlin\npublic get(): Expression<*>\n```\n\n----\n\n The expression being checked.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** Returns the lower limit of the range to check against. */
    val from: Expression<*>,
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Between#`<init>`().(from)
//           display_name from
//           documentation ```kotlin\nfrom: Expression<*>\n```\n\n----\n\n Returns the lower limit of the range to check against.
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Between#`<init>`().(from)
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Between#from.
//           display_name from
//           documentation ```kotlin\npublic final val from: Expression<*>\n```\n\n----\n\n Returns the lower limit of the range to check against.
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Between#getFrom().
//           display_name from
//           documentation ```kotlin\npublic get(): Expression<*>\n```\n\n----\n\n Returns the lower limit of the range to check against.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** Returns the upper limit of the range to check against. */
    val to: Expression<*>
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Between#`<init>`().(to)
//         display_name to
//         documentation ```kotlin\nto: Expression<*>\n```\n\n----\n\n Returns the upper limit of the range to check against.
//      ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Between#`<init>`().(to)
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Between#getTo().
//         display_name to
//         documentation ```kotlin\npublic get(): Expression<*>\n```\n\n----\n\n Returns the upper limit of the range to check against.
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Between#to.
//         display_name to
//         documentation ```kotlin\npublic final val to: Expression<*>\n```\n\n----\n\n Returns the upper limit of the range to check against.
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
) : Op<Boolean>(), ComplexExpression, Op.OpBoolean {
//  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder { append(expr, " BETWEEN ", from, " AND ", to) }
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Between#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Between#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Between#toQueryBuilder().(queryBuilder)
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Between#expr.
//                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Between#getExpr().
//                                                                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Between#from.
//                                                                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Between#getFrom().
//                                                                                                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Between#getTo().
//                                                                                                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Between#to.
}

/**
 * Represents an SQL operator that checks if the specified [expr] is null.
 */
class IsNullOp(
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#
//             display_name IsNullOp
//             documentation ```kotlin\npublic final class IsNullOp : Op<Boolean>, ComplexExpression, Op.OpBoolean\n```\n\n----\n\n\n Represents an SQL operator that checks if the specified [expr] is null.\n
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#`<init>`().
//             display_name IsNullOp
//             documentation ```kotlin\npublic constructor(expr: Expression<*>): IsNullOp\n```\n\n----\n\n The expression being checked.
    /** The expression being checked. */
    val expr: Expression<*>
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#`<init>`().(expr)
//           display_name expr
//           documentation ```kotlin\nexpr: Expression<*>\n```\n\n----\n\n The expression being checked.
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#`<init>`().(expr)
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#expr.
//           display_name expr
//           documentation ```kotlin\npublic final val expr: Expression<*>\n```\n\n----\n\n The expression being checked.
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#getExpr().
//           display_name expr
//           documentation ```kotlin\npublic get(): Expression<*>\n```\n\n----\n\n The expression being checked.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
) : Op<Boolean>(), ComplexExpression, Op.OpBoolean {
//  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder { append(expr, " IS NULL") }
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#toQueryBuilder().(queryBuilder)
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#expr.
//                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#getExpr().
}

/**
 * Represents an SQL operator that checks if the specified [expr] is not null.
 */
class IsNotNullOp(
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#
//                display_name IsNotNullOp
//                documentation ```kotlin\npublic final class IsNotNullOp : Op<Boolean>, ComplexExpression, Op.OpBoolean\n```\n\n----\n\n\n Represents an SQL operator that checks if the specified [expr] is not null.\n
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#`<init>`().
//                display_name IsNotNullOp
//                documentation ```kotlin\npublic constructor(expr: Expression<*>): IsNotNullOp\n```\n\n----\n\n The expression being checked.
    /** The expression being checked. */
    val expr: Expression<*>
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#`<init>`().(expr)
//           display_name expr
//           documentation ```kotlin\nexpr: Expression<*>\n```\n\n----\n\n The expression being checked.
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#`<init>`().(expr)
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#expr.
//           display_name expr
//           documentation ```kotlin\npublic final val expr: Expression<*>\n```\n\n----\n\n The expression being checked.
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#getExpr().
//           display_name expr
//           documentation ```kotlin\npublic get(): Expression<*>\n```\n\n----\n\n The expression being checked.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
) : Op<Boolean>(), ComplexExpression, Op.OpBoolean {
//  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder { append(expr, " IS NOT NULL") }
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#toQueryBuilder().(queryBuilder)
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#expr.
//                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#getExpr().
}

/**
 * Represents an SQL operator that checks if [expression1] is equal to [expression2], with `null` treated as a comparable value.
 * This comparison never returns null.
 */
class IsNotDistinctFromOp(
//    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#
//                        display_name IsNotDistinctFromOp
//                        documentation ```kotlin\npublic final class IsNotDistinctFromOp : Op<Boolean>, ComplexExpression, Op.OpBoolean\n```\n\n----\n\n\n Represents an SQL operator that checks if [expression1] is equal to [expression2], with `null` treated as a comparable value.\n This comparison never returns null.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#`<init>`().
//                        display_name IsNotDistinctFromOp
//                        documentation ```kotlin\npublic constructor(expression1: Expression<*>, expression2: Expression<*>): IsNotDistinctFromOp\n```
    val expression1: Expression<*>,
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#`<init>`().(expression1)
//                  display_name expression1
//                  documentation ```kotlin\nexpression1: Expression<*>\n```
//      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#`<init>`().(expression1)
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#expression1.
//                  display_name expression1
//                  documentation ```kotlin\npublic final val expression1: Expression<*>\n```
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#getExpression1().
//                  display_name expression1
//                  documentation ```kotlin\npublic get(): Expression<*>\n```
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    val expression2: Expression<*>
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#`<init>`().(expression2)
//                  display_name expression2
//                  documentation ```kotlin\nexpression2: Expression<*>\n```
//      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#`<init>`().(expression2)
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#expression2.
//                  display_name expression2
//                  documentation ```kotlin\npublic final val expression2: Expression<*>\n```
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#getExpression2().
//                  display_name expression2
//                  documentation ```kotlin\npublic get(): Expression<*>\n```
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
) : Op<Boolean>(), ComplexExpression, Op.OpBoolean {
//  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
    override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#toQueryBuilder().(queryBuilder)
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
        when (currentDialectIfAvailable) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
            is MariaDBDialect, is MysqlDialect -> appendComparison(expression1, expression2, "<=>")
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendComparison().
//                                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#expression1.
//                                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#getExpression1().
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#expression2.
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#getExpression2().
            is OracleDialect -> append("DECODE(", expression1, ", ", expression2, ", 1, 0) = 1")
//                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#expression1.
//                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#getExpression1().
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#expression2.
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#getExpression2().
            is SQLiteDialect -> appendComparison(expression1, expression2, "IS")
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendComparison().
//                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#expression1.
//                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#getExpression1().
//                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#expression2.
//                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#getExpression2().
            else -> appendComparison(expression1, expression2, "IS NOT DISTINCT FROM")
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendComparison().
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#expression1.
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#getExpression1().
//                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#expression2.
//                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#getExpression2().
        }
    }
}

/**
 * Represents an SQL operator that checks if [expression1] is not equal to [expression2], with `null` treated as a comparable value.
 * This comparison never returns null.
 */
class IsDistinctFromOp(
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#
//                     display_name IsDistinctFromOp
//                     documentation ```kotlin\npublic final class IsDistinctFromOp : Op<Boolean>, ComplexExpression, Op.OpBoolean\n```\n\n----\n\n\n Represents an SQL operator that checks if [expression1] is not equal to [expression2], with `null` treated as a comparable value.\n This comparison never returns null.\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#`<init>`().
//                     display_name IsDistinctFromOp
//                     documentation ```kotlin\npublic constructor(expression1: Expression<*>, expression2: Expression<*>): IsDistinctFromOp\n```
    val expression1: Expression<*>,
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#`<init>`().(expression1)
//                  display_name expression1
//                  documentation ```kotlin\nexpression1: Expression<*>\n```
//      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#`<init>`().(expression1)
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#expression1.
//                  display_name expression1
//                  documentation ```kotlin\npublic final val expression1: Expression<*>\n```
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#getExpression1().
//                  display_name expression1
//                  documentation ```kotlin\npublic get(): Expression<*>\n```
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    val expression2: Expression<*>
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#`<init>`().(expression2)
//                  display_name expression2
//                  documentation ```kotlin\nexpression2: Expression<*>\n```
//      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#`<init>`().(expression2)
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#expression2.
//                  display_name expression2
//                  documentation ```kotlin\npublic final val expression2: Expression<*>\n```
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#getExpression2().
//                  display_name expression2
//                  documentation ```kotlin\npublic get(): Expression<*>\n```
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
) : Op<Boolean>(), ComplexExpression, Op.OpBoolean {
//  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
    override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#toQueryBuilder().(queryBuilder)
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
        when (currentDialectIfAvailable) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
            is MariaDBDialect, is MysqlDialect -> {
                +"NOT("
//              ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                appendComparison(expression1, expression2, "<=>")
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendComparison().
//                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#expression1.
//                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#getExpression1().
//                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#expression2.
//                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#getExpression2().
                +")"
//              ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
            }
            is OracleDialect -> append("DECODE(", expression1, ", ", expression2, ", 1, 0) = 0")
//                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#expression1.
//                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#getExpression1().
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#expression2.
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#getExpression2().
            is SQLiteDialect -> appendComparison(expression1, expression2, "IS NOT")
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendComparison().
//                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#expression1.
//                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#getExpression1().
//                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#expression2.
//                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#getExpression2().
            else -> appendComparison(expression1, expression2, "IS DISTINCT FROM")
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendComparison().
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#expression1.
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#getExpression1().
//                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#expression2.
//                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#getExpression2().
        }
    }
}

// Mathematical Operators

/**
 * Represents an SQL operator that adds [expr2] to [expr1].
 */
class PlusOp<T, S : T>(
//    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/PlusOp#
//           display_name PlusOp
//           documentation ```kotlin\npublic final class PlusOp<T, S : T> : CustomOperator<T>\n```\n\n----\n\n\n Represents an SQL operator that adds [expr2] to [expr1].\n
//           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#
//    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/PlusOp#`<init>`().
//           display_name PlusOp
//           documentation ```kotlin\npublic constructor<T, S : T>(expr1: Expression<T>, expr2: Expression<S>, columnType: IColumnType<T & Any>): PlusOp<T, S>\n```\n\n----\n\n The left-hand side operand.
//           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/PlusOp#[T]
//             display_name FirTypeParameterSymbol T
//             documentation ```kotlin\nT\n```
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/PlusOp#[S]
//                display_name FirTypeParameterSymbol S
//                documentation ```kotlin\nS : T\n```
    /** The left-hand side operand. */
    expr1: Expression<T>,
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/PlusOp#`<init>`().(expr1)
//        display_name expr1
//        documentation ```kotlin\nexpr1: Expression<T>\n```\n\n----\n\n The left-hand side operand.
//         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The right-hand side operand. */
    expr2: Expression<S>,
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/PlusOp#`<init>`().(expr2)
//        display_name expr2
//        documentation ```kotlin\nexpr2: Expression<S>\n```\n\n----\n\n The right-hand side operand.
//         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The column type of this expression. */
    columnType: IColumnType<T & Any>
//  ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/PlusOp#`<init>`().(columnType)
//             display_name columnType
//             documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```\n\n----\n\n The column type of this expression.
//              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
) : CustomOperator<T>("+", columnType, expr1, expr2)
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#
//                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/PlusOp#`<init>`().(columnType)
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/PlusOp#`<init>`().(expr1)
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/PlusOp#`<init>`().(expr2)

/**
 * Represents an SQL operator that subtracts [expr2] from [expr1].
 */
class MinusOp<T, S : T>(
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/MinusOp#
//            display_name MinusOp
//            documentation ```kotlin\npublic final class MinusOp<T, S : T> : CustomOperator<T>\n```\n\n----\n\n\n Represents an SQL operator that subtracts [expr2] from [expr1].\n
//            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/MinusOp#`<init>`().
//            display_name MinusOp
//            documentation ```kotlin\npublic constructor<T, S : T>(expr1: Expression<T>, expr2: Expression<S>, columnType: IColumnType<T & Any>): MinusOp<T, S>\n```\n\n----\n\n The left-hand side operand.
//            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/MinusOp#[T]
//              display_name FirTypeParameterSymbol T
//              documentation ```kotlin\nT\n```
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/MinusOp#[S]
//                 display_name FirTypeParameterSymbol S
//                 documentation ```kotlin\nS : T\n```
    /** The left-hand side operand. */
    expr1: Expression<T>,
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/MinusOp#`<init>`().(expr1)
//        display_name expr1
//        documentation ```kotlin\nexpr1: Expression<T>\n```\n\n----\n\n The left-hand side operand.
//         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The right-hand side operand. */
    expr2: Expression<S>,
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/MinusOp#`<init>`().(expr2)
//        display_name expr2
//        documentation ```kotlin\nexpr2: Expression<S>\n```\n\n----\n\n The right-hand side operand.
//         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The column type of this expression. */
    columnType: IColumnType<T & Any>
//  ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/MinusOp#`<init>`().(columnType)
//             display_name columnType
//             documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```\n\n----\n\n The column type of this expression.
//              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
) : CustomOperator<T>("-", columnType, expr1, expr2)
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#
//                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/MinusOp#`<init>`().(columnType)
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/MinusOp#`<init>`().(expr1)
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/MinusOp#`<init>`().(expr2)

/**
 * Represents an SQL operator that multiplies [expr1] by [expr2].
 */
class TimesOp<T, S : T>(
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TimesOp#
//            display_name TimesOp
//            documentation ```kotlin\npublic final class TimesOp<T, S : T> : CustomOperator<T>\n```\n\n----\n\n\n Represents an SQL operator that multiplies [expr1] by [expr2].\n
//            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TimesOp#`<init>`().
//            display_name TimesOp
//            documentation ```kotlin\npublic constructor<T, S : T>(expr1: Expression<T>, expr2: Expression<S>, columnType: IColumnType<T & Any>): TimesOp<T, S>\n```\n\n----\n\n The left-hand side operand.
//            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TimesOp#[T]
//              display_name FirTypeParameterSymbol T
//              documentation ```kotlin\nT\n```
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TimesOp#[S]
//                 display_name FirTypeParameterSymbol S
//                 documentation ```kotlin\nS : T\n```
    /** The left-hand side operand. */
    expr1: Expression<T>,
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TimesOp#`<init>`().(expr1)
//        display_name expr1
//        documentation ```kotlin\nexpr1: Expression<T>\n```\n\n----\n\n The left-hand side operand.
//         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The right-hand side operand. */
    expr2: Expression<S>,
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TimesOp#`<init>`().(expr2)
//        display_name expr2
//        documentation ```kotlin\nexpr2: Expression<S>\n```\n\n----\n\n The right-hand side operand.
//         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The column type of this expression. */
    columnType: IColumnType<T & Any>
//  ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TimesOp#`<init>`().(columnType)
//             display_name columnType
//             documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```\n\n----\n\n The column type of this expression.
//              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
) : CustomOperator<T>("*", columnType, expr1, expr2)
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#
//                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TimesOp#`<init>`().(columnType)
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TimesOp#`<init>`().(expr1)
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TimesOp#`<init>`().(expr2)

/**
 * Represents an SQL operator that divides [expr1] by [expr2].
 */
class DivideOp<T, S : T>(
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#
//             display_name DivideOp
//             documentation ```kotlin\npublic final class DivideOp<T, S : T> : CustomOperator<T>\n```\n\n----\n\n\n Represents an SQL operator that divides [expr1] by [expr2].\n
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#`<init>`().
//             display_name DivideOp
//             documentation ```kotlin\npublic constructor<T, S : T>(dividend: Expression<T>, divisor: Expression<S>, columnType: IColumnType<T & Any>): DivideOp<T, S>\n```\n\n----\n\n The left-hand side operand.
//             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#[T]
//               display_name FirTypeParameterSymbol T
//               documentation ```kotlin\nT\n```
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#[S]
//                  display_name FirTypeParameterSymbol S
//                  documentation ```kotlin\nS : T\n```
    /** The left-hand side operand. */
    private val dividend: Expression<T>,
//              ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#`<init>`().(dividend)
//                       display_name dividend
//                       documentation ```kotlin\ndividend: Expression<T>\n```\n\n----\n\n The left-hand side operand.
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#`<init>`().(dividend)
//              ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#dividend.
//                       display_name dividend
//                       documentation ```kotlin\nprivate final val dividend: Expression<T>\n```\n\n----\n\n The left-hand side operand.
//              ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#getDividend().
//                       display_name dividend
//                       documentation ```kotlin\nprivate get(): Expression<T>\n```\n\n----\n\n The left-hand side operand.
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The right-hand side operand. */
    private val divisor: Expression<S>,
//              ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#`<init>`().(divisor)
//                      display_name divisor
//                      documentation ```kotlin\ndivisor: Expression<S>\n```\n\n----\n\n The right-hand side operand.
//              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#`<init>`().(divisor)
//              ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#divisor.
//                      display_name divisor
//                      documentation ```kotlin\nprivate final val divisor: Expression<S>\n```\n\n----\n\n The right-hand side operand.
//              ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#getDivisor().
//                      display_name divisor
//                      documentation ```kotlin\nprivate get(): Expression<S>\n```\n\n----\n\n The right-hand side operand.
//                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The column type of this expression. */
    columnType: IColumnType<T & Any>
//  ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#`<init>`().(columnType)
//             display_name columnType
//             documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```\n\n----\n\n The column type of this expression.
//              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
) : CustomOperator<T>("/", columnType, dividend, divisor) {
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#
//                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#`<init>`().(columnType)
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#`<init>`().(dividend)
//                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#`<init>`().(divisor)
    companion object {
//  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#Companion# 11:5
//                     display_name Companion
//                     documentation ```kotlin\npublic final companion object Companion : Any\n```
//  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#Companion#`<init>`(). 11:5
//                     display_name Companion
//                     documentation ```kotlin\nprivate constructor(): DivideOp.Companion\n```
        fun <T : BigDecimal?, S : T> DivideOp<T, S>.withScale(scale: Int): DivideOp<T, S> {
//           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#Companion#withScale().[T]
//             display_name FirTypeParameterSymbol T
//             documentation ```kotlin\nT : BigDecimal?\n```
//                            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#Companion#withScale().[S]
//                              display_name FirTypeParameterSymbol S
//                              documentation ```kotlin\nS : T\n```
//                                                  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#Companion#withScale().
//                                                            display_name withScale
//                                                            documentation ```kotlin\npublic final fun <T : BigDecimal?, S : T> DivideOp<T, S>.withScale(scale: Int): DivideOp<T, S>\n```
//                                                            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#Companion#withScale().(scale)
//                                                                  display_name scale
//                                                                  documentation ```kotlin\nscale: Int\n```
//                                                                   ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#
            val precision = (columnType as DecimalColumnType).precision + scale
//              ^^^^^^^^^ definition local 0
//                        display_name precision
//                        documentation ```kotlin\nlocal val precision: Int\n```
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#columnType.
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#getColumnType().
//                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getPrecision().
//                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#precision.
//                                                                      ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#Companion#withScale().(scale)
            val decimalColumnType = DecimalColumnType(precision, scale)
//              ^^^^^^^^^^^^^^^^^ definition local 1
//                                display_name decimalColumnType
//                                documentation ```kotlin\nlocal val decimalColumnType: DecimalColumnType\n```
//                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                                                    ^^^^^^^^^ reference local 0
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#Companion#withScale().(scale)

            val newExpression = (dividend as? LiteralOp<BigDecimal>)?.value?.takeIf { it.scale() == 0 }?.let {
//              ^^^^^^^^^^^^^ definition local 2
//                            display_name newExpression
//                            documentation ```kotlin\nlocal val newExpression: Expression<out BigDecimal?>\n```
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#dividend.
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#getDividend().
//                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getValue().
//                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#value.
//                                                                           ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                                                                  ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                      display_name it
//                                                                                                      documentation ```kotlin\nit: CompositeID\n```
//                                                                                    ^^ reference semanticdb maven . . (it)
//                                                                                       ^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#scale().
//                                                                                                       ^^^ reference semanticdb maven . . kotlin/let().
//                                                                                                           ^ definition semanticdb maven . . (it) 2:13
//                                                                                                             display_name it
//                                                                                                             documentation ```kotlin\nit: CompositeID\n```
                decimalLiteral(it.setScale(1)) // it is needed to treat dividend as decimal instead of integer in SQL
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/decimalLiteral().
//                             ^^ reference semanticdb maven . . (it)
//                                ^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#setScale().
            } ?: dividend
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#dividend.
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#getDividend().

            return DivideOp(newExpression as Expression<T>, divisor, decimalColumnType as IColumnType<T & Any>)
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#`<init>`().
//                          ^^^^^^^^^^^^^ reference local 2
//                                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#divisor.
//                                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#getDivisor().
//                                                                   ^^^^^^^^^^^^^^^^^ reference local 1
        }
    }
}

/**
 * Represents an SQL operator that calculates the remainder of dividing [expr1] by [expr2].
 */
class ModOp<T : Number?, S : Number?, R : Number?>(
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#
//          display_name ModOp
//          documentation ```kotlin\npublic final class ModOp<T : Number?, S : Number?, R : Number?> : ExpressionWithColumnType<R>\n```\n\n----\n\n\n Represents an SQL operator that calculates the remainder of dividing [expr1] by [expr2].\n
//          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#`<init>`().
//          display_name ModOp
//          documentation ```kotlin\npublic constructor<T : Number?, S : Number?, R : Number?>(expr1: Expression<T>, expr2: Expression<S>, columnType: IColumnType<R & Any>): ModOp<T, S, R>\n```\n\n----\n\n Returns the left-hand side operand.
//          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#[T]
//            display_name FirTypeParameterSymbol T
//            documentation ```kotlin\nT : Number?\n```
//                       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#[S]
//                         display_name FirTypeParameterSymbol S
//                         documentation ```kotlin\nS : Number?\n```
//                                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#[R]
//                                      display_name FirTypeParameterSymbol R
//                                      documentation ```kotlin\nR : Number?\n```
    /** Returns the left-hand side operand. */
    val expr1: Expression<T>,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#`<init>`().(expr1)
//            display_name expr1
//            documentation ```kotlin\nexpr1: Expression<T>\n```\n\n----\n\n Returns the left-hand side operand.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#`<init>`().(expr1)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#expr1.
//            display_name expr1
//            documentation ```kotlin\npublic final val expr1: Expression<T>\n```\n\n----\n\n Returns the left-hand side operand.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#getExpr1().
//            display_name expr1
//            documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n Returns the left-hand side operand.
//             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** Returns the right-hand side operand. */
    val expr2: Expression<S>,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#`<init>`().(expr2)
//            display_name expr2
//            documentation ```kotlin\nexpr2: Expression<S>\n```\n\n----\n\n Returns the right-hand side operand.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#`<init>`().(expr2)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#expr2.
//            display_name expr2
//            documentation ```kotlin\npublic final val expr2: Expression<S>\n```\n\n----\n\n Returns the right-hand side operand.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#getExpr2().
//            display_name expr2
//            documentation ```kotlin\npublic get(): Expression<S>\n```\n\n----\n\n Returns the right-hand side operand.
//             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    override val columnType: IColumnType<R & Any>
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#`<init>`().(columnType)
//                          display_name columnType
//                          documentation ```kotlin\ncolumnType: IColumnType<R & Any>\n```
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#`<init>`().(columnType)
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#columnType.
//                          display_name columnType
//                          documentation ```kotlin\npublic open override val columnType: IColumnType<R & Any>\n```
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#getColumnType().
//                          display_name columnType
//                          documentation ```kotlin\npublic get(): IColumnType<R & Any>\n```
//                           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
) : ExpressionWithColumnType<R>() {
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#

    override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
        queryBuilder {
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#toQueryBuilder().(queryBuilder)
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
            when (currentDialectIfAvailable) {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
                is OracleDialect -> append("MOD(", expr1, ", ", expr2, ")")
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#expr1.
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#getExpr1().
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#expr2.
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#getExpr2().
                else -> append('(', expr1, " % ", expr2, ')')
//                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#expr1.
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#getExpr1().
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#expr2.
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#getExpr2().
            }
        }
    }

    companion object {
//  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion# 29:5
//                     display_name Companion
//                     documentation ```kotlin\npublic final companion object Companion : Any\n```
//  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#`<init>`(). 29:5
//                     display_name Companion
//                     documentation ```kotlin\nprivate constructor(): ModOp.Companion\n```
        @Suppress("UNCHECKED_CAST")
        private fun <T : Number?, K : EntityID<T>?> originalColumn(expr1: ExpressionWithColumnType<K>): Column<T> {
//                   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#originalColumn().[T]
//                     display_name FirTypeParameterSymbol T
//                     documentation ```kotlin\nT : Number?\n```
//                                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#originalColumn().[K]
//                                  display_name FirTypeParameterSymbol K
//                                  documentation ```kotlin\nK : EntityID<T>?\n```
//                                                  ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#originalColumn().
//                                                                 display_name originalColumn
//                                                                 documentation ```kotlin\n@Suppress(...) private final fun <T : Number?, K : EntityID<T>?> originalColumn(expr1: ExpressionWithColumnType<K>): Column<T>\n```
//                                                                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#originalColumn().(expr1)
//                                                                       display_name expr1
//                                                                       documentation ```kotlin\nexpr1: ExpressionWithColumnType<K>\n```
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
            return (expr1.columnType as EntityIDColumnType<*>).idColumn as Column<T>
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#originalColumn().(expr1)
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
        }

        internal operator fun <T, S : Number, K : EntityID<T>?> invoke(
//                             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke().[T]
//                               display_name FirTypeParameterSymbol T
//                               documentation ```kotlin\nT : Number, Comparable<T>\n```
//                                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke().[S]
//                                  display_name FirTypeParameterSymbol S
//                                  documentation ```kotlin\nS : Number\n```
//                                            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke().[K]
//                                              display_name FirTypeParameterSymbol K
//                                              documentation ```kotlin\nK : EntityID<T>?\n```
//                                                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke().
//                                                                     display_name invoke
//                                                                     documentation ```kotlin\ninternal final operator fun <T : Number, Comparable<T>, S : Number, K : EntityID<T>?> invoke(expr1: ExpressionWithColumnType<K>, expr2: Expression<S>): ExpressionWithColumnType<T>\n```
            expr1: ExpressionWithColumnType<K>,
//          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke().(expr1)
//                display_name expr1
//                documentation ```kotlin\nexpr1: ExpressionWithColumnType<K>\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
            expr2: Expression<S>
//          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke().(expr2)
//                display_name expr2
//                documentation ```kotlin\nexpr2: Expression<S>\n```
//                 ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
        ): ExpressionWithColumnType<T> where T : Number, T : Comparable<T> {
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
            val column = originalColumn(expr1)
//              ^^^^^^ definition local 3
//                     display_name column
//                     documentation ```kotlin\nlocal val column: Column<T>\n```
//                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#originalColumn().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke().(expr1)
            return ModOp(column, expr2, column.columnType)
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#`<init>`().
//                       ^^^^^^ reference local 3
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke().(expr2)
//                                      ^^^^^^ reference local 3
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
        }

        internal operator fun <T, S : Number, K : EntityID<T>?> invoke(
//                             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+1).[T]
//                               display_name FirTypeParameterSymbol T
//                               documentation ```kotlin\nT : Number, Comparable<T>\n```
//                                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+1).[S]
//                                  display_name FirTypeParameterSymbol S
//                                  documentation ```kotlin\nS : Number\n```
//                                            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+1).[K]
//                                              display_name FirTypeParameterSymbol K
//                                              documentation ```kotlin\nK : EntityID<T>?\n```
//                                                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+1).
//                                                                     display_name invoke
//                                                                     documentation ```kotlin\ninternal final operator fun <T : Number, Comparable<T>, S : Number, K : EntityID<T>?> invoke(expr1: Expression<S>, expr2: ExpressionWithColumnType<K>): ExpressionWithColumnType<T>\n```
            expr1: Expression<S>,
//          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+1).(expr1)
//                display_name expr1
//                documentation ```kotlin\nexpr1: Expression<S>\n```
//                 ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
            expr2: ExpressionWithColumnType<K>
//          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+1).(expr2)
//                display_name expr2
//                documentation ```kotlin\nexpr2: ExpressionWithColumnType<K>\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
        ): ExpressionWithColumnType<T> where T : Number, T : Comparable<T> {
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
            val column = originalColumn(expr2)
//              ^^^^^^ definition local 4
//                     display_name column
//                     documentation ```kotlin\nlocal val column: Column<T>\n```
//                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#originalColumn().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+1).(expr2)
            return ModOp(expr1, column, column.columnType)
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#`<init>`().
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+1).(expr1)
//                              ^^^^^^ reference local 4
//                                      ^^^^^^ reference local 4
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
        }

        internal operator fun <T, S : Number, K : EntityID<T>?> invoke(
//                             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+2).[T]
//                               display_name FirTypeParameterSymbol T
//                               documentation ```kotlin\nT : Number, Comparable<T>\n```
//                                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+2).[S]
//                                  display_name FirTypeParameterSymbol S
//                                  documentation ```kotlin\nS : Number\n```
//                                            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+2).[K]
//                                              display_name FirTypeParameterSymbol K
//                                              documentation ```kotlin\nK : EntityID<T>?\n```
//                                                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+2).
//                                                                     display_name invoke
//                                                                     documentation ```kotlin\ninternal final operator fun <T : Number, Comparable<T>, S : Number, K : EntityID<T>?> invoke(expr1: ExpressionWithColumnType<K>, expr2: S): ExpressionWithColumnType<T>\n```
            expr1: ExpressionWithColumnType<K>,
//          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+2).(expr1)
//                display_name expr1
//                documentation ```kotlin\nexpr1: ExpressionWithColumnType<K>\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
            expr2: S
//          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+2).(expr2)
//                display_name expr2
//                documentation ```kotlin\nexpr2: S\n```
        ): ExpressionWithColumnType<T> where T : Number, T : Comparable<T> {
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
            val column = originalColumn(expr1)
//              ^^^^^^ definition local 5
//                     display_name column
//                     documentation ```kotlin\nlocal val column: Column<T>\n```
//                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#originalColumn().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+2).(expr1)
            return ModOp(column, column.wrap(expr2), column.columnType)
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#`<init>`().
//                       ^^^^^^ reference local 5
//                               ^^^^^^ reference local 5
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+2).(expr2)
//                                                   ^^^^^^ reference local 5
//                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
        }
    }
}

// https://github.com/h2database/h2database/issues/3253
private fun <T> ExpressionWithColumnType<T>.castToExpressionTypeForH2BitWiseIps(e: Expression<out T>, queryBuilder: QueryBuilder) {
//           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().[T]
//             display_name FirTypeParameterSymbol T
//             documentation ```kotlin\nT\n```
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().
//                                                                              display_name castToExpressionTypeForH2BitWiseIps
//                                                                              documentation ```kotlin\nprivate final fun <T> ExpressionWithColumnType<T>.castToExpressionTypeForH2BitWiseIps(e: Expression<out T>, queryBuilder: QueryBuilder): Unit\n```
//                                                                              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().(e)
//                                                                                display_name e
//                                                                                documentation ```kotlin\ne: Expression<out T>\n```
//                                                                                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                                    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().(queryBuilder)
//                                                                                                                 display_name queryBuilder
//                                                                                                                 documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
    when {
        currentDialect.h2Mode == H2Dialect.H2CompatibilityMode.Oracle -> H2FunctionProvider.cast(e, ByteColumnType(), queryBuilder)
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
//                                                                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().
//                                                                                               ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().(e)
//                                                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#`<init>`().
//                                                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().(queryBuilder)
        e is Column<*> || e is LiteralOp<*> -> queryBuilder.append(e)
//      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().(e)
//                        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().(e)
//                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().(queryBuilder)
//                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                                                                 ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().(e)
        else -> currentDialect.functionProvider.cast(e, columnType, queryBuilder)
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().
//                                                   ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().(e)
//                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().(queryBuilder)
    }
}

/**
 * Represents an SQL operator that performs a bitwise `and` on [expr1] and [expr2].
 */
class AndBitOp<T, S : T>(
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#
//             display_name AndBitOp
//             documentation ```kotlin\npublic final class AndBitOp<T, S : T> : ExpressionWithColumnType<T>\n```\n\n----\n\n\n Represents an SQL operator that performs a bitwise `and` on [expr1] and [expr2].\n
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#`<init>`().
//             display_name AndBitOp
//             documentation ```kotlin\npublic constructor<T, S : T>(expr1: Expression<T>, expr2: Expression<S>, columnType: IColumnType<T & Any>): AndBitOp<T, S>\n```\n\n----\n\n The left-hand side operand.
//             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#[T]
//               display_name FirTypeParameterSymbol T
//               documentation ```kotlin\nT\n```
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#[S]
//                  display_name FirTypeParameterSymbol S
//                  documentation ```kotlin\nS : T\n```
    /** The left-hand side operand. */
    val expr1: Expression<T>,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#`<init>`().(expr1)
//            display_name expr1
//            documentation ```kotlin\nexpr1: Expression<T>\n```\n\n----\n\n The left-hand side operand.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#`<init>`().(expr1)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#expr1.
//            display_name expr1
//            documentation ```kotlin\npublic final val expr1: Expression<T>\n```\n\n----\n\n The left-hand side operand.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#getExpr1().
//            display_name expr1
//            documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n The left-hand side operand.
//             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The right-hand side operand. */
    val expr2: Expression<S>,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#`<init>`().(expr2)
//            display_name expr2
//            documentation ```kotlin\nexpr2: Expression<S>\n```\n\n----\n\n The right-hand side operand.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#`<init>`().(expr2)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#expr2.
//            display_name expr2
//            documentation ```kotlin\npublic final val expr2: Expression<S>\n```\n\n----\n\n The right-hand side operand.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#getExpr2().
//            display_name expr2
//            documentation ```kotlin\npublic get(): Expression<S>\n```\n\n----\n\n The right-hand side operand.
//             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The column type of this expression. */
    override val columnType: IColumnType<T & Any>
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#`<init>`().(columnType)
//                          display_name columnType
//                          documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```\n\n----\n\n The column type of this expression.
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#`<init>`().(columnType)
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#columnType.
//                          display_name columnType
//                          documentation ```kotlin\npublic open override val columnType: IColumnType<T & Any>\n```\n\n----\n\n The column type of this expression.
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#getColumnType().
//                          display_name columnType
//                          documentation ```kotlin\npublic get(): IColumnType<T & Any>\n```\n\n----\n\n The column type of this expression.
//                           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
) : ExpressionWithColumnType<T>() {
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#toQueryBuilder().(queryBuilder)
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
        when (val dialect = currentDialectIfAvailable) {
//                ^^^^^^^ definition local 6
//                        display_name dialect
//                        documentation ```kotlin\nlocal val dialect: DatabaseDialect?\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
            is OracleDialect -> append("BITAND(", expr1, ", ", expr2, ")")
//                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#expr1.
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#getExpr1().
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#expr2.
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#getExpr2().
            is H2Dialect -> {
                when (dialect.isSecondVersion) {
//                    ^^^^^^^ reference local 6
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getIsSecondVersion().
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#isSecondVersion.
                    false -> append("BITAND(", expr1, ", ", expr2, ")")
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#expr1.
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#getExpr1().
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#expr2.
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#getExpr2().
                    true -> {
                        +"BITAND("
//                      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                        castToExpressionTypeForH2BitWiseIps(expr1, this)
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#expr1.
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#getExpr1().
                        +", "
//                      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                        castToExpressionTypeForH2BitWiseIps(expr2, this)
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#expr2.
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#getExpr2().
                        +")"
//                      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                    }
                }
            }
            else -> append('(', expr1, " & ", expr2, ')')
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#expr1.
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#getExpr1().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#expr2.
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#getExpr2().
        }
    }
}

/**
 * Represents an SQL operator that performs a bitwise `or` on [expr1] and [expr2].
 */
class OrBitOp<T, S : T>(
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#
//            display_name OrBitOp
//            documentation ```kotlin\npublic final class OrBitOp<T, S : T> : ExpressionWithColumnType<T>\n```\n\n----\n\n\n Represents an SQL operator that performs a bitwise `or` on [expr1] and [expr2].\n
//            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#`<init>`().
//            display_name OrBitOp
//            documentation ```kotlin\npublic constructor<T, S : T>(expr1: Expression<T>, expr2: Expression<S>, columnType: IColumnType<T & Any>): OrBitOp<T, S>\n```\n\n----\n\n The left-hand side operand.
//            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#[T]
//              display_name FirTypeParameterSymbol T
//              documentation ```kotlin\nT\n```
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#[S]
//                 display_name FirTypeParameterSymbol S
//                 documentation ```kotlin\nS : T\n```
    /** The left-hand side operand. */
    val expr1: Expression<T>,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#`<init>`().(expr1)
//            display_name expr1
//            documentation ```kotlin\nexpr1: Expression<T>\n```\n\n----\n\n The left-hand side operand.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#`<init>`().(expr1)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#expr1.
//            display_name expr1
//            documentation ```kotlin\npublic final val expr1: Expression<T>\n```\n\n----\n\n The left-hand side operand.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#getExpr1().
//            display_name expr1
//            documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n The left-hand side operand.
//             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The right-hand side operand. */
    val expr2: Expression<S>,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#`<init>`().(expr2)
//            display_name expr2
//            documentation ```kotlin\nexpr2: Expression<S>\n```\n\n----\n\n The right-hand side operand.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#`<init>`().(expr2)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#expr2.
//            display_name expr2
//            documentation ```kotlin\npublic final val expr2: Expression<S>\n```\n\n----\n\n The right-hand side operand.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#getExpr2().
//            display_name expr2
//            documentation ```kotlin\npublic get(): Expression<S>\n```\n\n----\n\n The right-hand side operand.
//             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The column type of this expression. */
    override val columnType: IColumnType<T & Any>
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#`<init>`().(columnType)
//                          display_name columnType
//                          documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```\n\n----\n\n The column type of this expression.
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#`<init>`().(columnType)
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#columnType.
//                          display_name columnType
//                          documentation ```kotlin\npublic open override val columnType: IColumnType<T & Any>\n```\n\n----\n\n The column type of this expression.
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#getColumnType().
//                          display_name columnType
//                          documentation ```kotlin\npublic get(): IColumnType<T & Any>\n```\n\n----\n\n The column type of this expression.
//                           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
) : ExpressionWithColumnType<T>() {
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#toQueryBuilder().(queryBuilder)
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
        when (val dialect = currentDialectIfAvailable) {
//                ^^^^^^^ definition local 7
//                        display_name dialect
//                        documentation ```kotlin\nlocal val dialect: DatabaseDialect?\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
            // Oracle doesn't natively support bitwise OR, thus emulate it with 'and'
            is OracleDialect -> append("(", expr1, "+", expr2, "-", AndBitOp(expr1, expr2, columnType), ")")
//                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#expr1.
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#getExpr1().
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#expr2.
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#getExpr2().
//                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#`<init>`().
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#expr1.
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#getExpr1().
//                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#expr2.
//                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#getExpr2().
//                                                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#columnType.
//                                                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#getColumnType().
            is H2Dialect -> {
                when (dialect.isSecondVersion) {
//                    ^^^^^^^ reference local 7
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getIsSecondVersion().
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#isSecondVersion.
                    false -> append("BITOR(", expr1, ", ", expr2, ")")
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#expr1.
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#getExpr1().
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#expr2.
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#getExpr2().
                    true -> {
                        +"BITOR("
//                      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                        castToExpressionTypeForH2BitWiseIps(expr1, this)
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#expr1.
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#getExpr1().
                        +", "
//                      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                        castToExpressionTypeForH2BitWiseIps(expr2, this)
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#expr2.
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#getExpr2().
                        +")"
//                      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                    }
                }
            }
            else -> append('(', expr1, " | ", expr2, ')')
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#expr1.
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#getExpr1().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#expr2.
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#getExpr2().
        }
    }
}

/**
 * Represents an SQL operator that performs a bitwise `or` on [expr1] and [expr2].
 */
class XorBitOp<T, S : T>(
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#
//             display_name XorBitOp
//             documentation ```kotlin\npublic final class XorBitOp<T, S : T> : ExpressionWithColumnType<T>\n```\n\n----\n\n\n Represents an SQL operator that performs a bitwise `or` on [expr1] and [expr2].\n
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#`<init>`().
//             display_name XorBitOp
//             documentation ```kotlin\npublic constructor<T, S : T>(expr1: Expression<T>, expr2: Expression<S>, columnType: IColumnType<T & Any>): XorBitOp<T, S>\n```\n\n----\n\n The left-hand side operand.
//             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#[T]
//               display_name FirTypeParameterSymbol T
//               documentation ```kotlin\nT\n```
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#[S]
//                  display_name FirTypeParameterSymbol S
//                  documentation ```kotlin\nS : T\n```
    /** The left-hand side operand. */
    val expr1: Expression<T>,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#`<init>`().(expr1)
//            display_name expr1
//            documentation ```kotlin\nexpr1: Expression<T>\n```\n\n----\n\n The left-hand side operand.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#`<init>`().(expr1)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#expr1.
//            display_name expr1
//            documentation ```kotlin\npublic final val expr1: Expression<T>\n```\n\n----\n\n The left-hand side operand.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getExpr1().
//            display_name expr1
//            documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n The left-hand side operand.
//             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The right-hand side operand. */
    val expr2: Expression<S>,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#`<init>`().(expr2)
//            display_name expr2
//            documentation ```kotlin\nexpr2: Expression<S>\n```\n\n----\n\n The right-hand side operand.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#`<init>`().(expr2)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#expr2.
//            display_name expr2
//            documentation ```kotlin\npublic final val expr2: Expression<S>\n```\n\n----\n\n The right-hand side operand.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getExpr2().
//            display_name expr2
//            documentation ```kotlin\npublic get(): Expression<S>\n```\n\n----\n\n The right-hand side operand.
//             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The column type of this expression. */
    override val columnType: IColumnType<T & Any>
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#`<init>`().(columnType)
//                          display_name columnType
//                          documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```\n\n----\n\n The column type of this expression.
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#`<init>`().(columnType)
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#columnType.
//                          display_name columnType
//                          documentation ```kotlin\npublic open override val columnType: IColumnType<T & Any>\n```\n\n----\n\n The column type of this expression.
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getColumnType().
//                          display_name columnType
//                          documentation ```kotlin\npublic get(): IColumnType<T & Any>\n```\n\n----\n\n The column type of this expression.
//                           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
) : ExpressionWithColumnType<T>() {
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#toQueryBuilder().(queryBuilder)
        when (val dialect = currentDialectIfAvailable) {
//                ^^^^^^^ definition local 8
//                        display_name dialect
//                        documentation ```kotlin\nlocal val dialect: DatabaseDialect?\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
            // Oracle and SQLite don't natively support bitwise XOR, thus emulate it with 'or' and 'and'
            is OracleDialect, is SQLiteDialect -> append(
//                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
                "(", OrBitOp(expr1, expr2, columnType), "-", AndBitOp(expr1, expr2, columnType), ")"
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#`<init>`().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#expr1.
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getExpr1().
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#expr2.
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getExpr2().
//                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#columnType.
//                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getColumnType().
//                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#`<init>`().
//                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#expr1.
//                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getExpr1().
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#expr2.
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getExpr2().
//                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#columnType.
//                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getColumnType().
            )
            is PostgreSQLDialect -> append('(', expr1, " # ", expr2, ')')
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#expr1.
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getExpr1().
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#expr2.
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getExpr2().
            is H2Dialect -> {
                when (dialect.isSecondVersion) {
//                    ^^^^^^^ reference local 8
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getIsSecondVersion().
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#isSecondVersion.
                    false -> append("BITXOR(", expr1, ", ", expr2, ")")
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#expr1.
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getExpr1().
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#expr2.
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getExpr2().
                    true -> {
                        +"BITXOR("
//                      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                        castToExpressionTypeForH2BitWiseIps(expr1, this)
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#expr1.
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getExpr1().
                        +", "
//                      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                        castToExpressionTypeForH2BitWiseIps(expr2, this)
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/castToExpressionTypeForH2BitWiseIps().
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#expr2.
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getExpr2().
                        +")"
//                      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                    }
                }
            }
            else -> append('(', expr1, " ^ ", expr2, ')')
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#expr1.
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getExpr1().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#expr2.
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#getExpr2().
        }
    }
}

// Pattern Matching

/**
 * Represents an SQL operator that checks if [expr1] matches [expr2].
 */
class LikeEscapeOp(expr1: Expression<*>, expr2: Expression<*>, like: Boolean, val escapeChar: Char?) :
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#
//                 display_name LikeEscapeOp
//                 documentation ```kotlin\npublic final class LikeEscapeOp : ComparisonOp\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr1] matches [expr2].\n
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().
//                 display_name LikeEscapeOp
//                 documentation ```kotlin\npublic constructor(expr1: Expression<*>, expr2: Expression<*>, like: Boolean, escapeChar: Char?): LikeEscapeOp\n```
//                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().(expr1)
//                       display_name expr1
//                       documentation ```kotlin\nexpr1: Expression<*>\n```
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().(expr2)
//                                             display_name expr2
//                                             documentation ```kotlin\nexpr2: Expression<*>\n```
//                                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().(like)
//                                                                  display_name like
//                                                                  documentation ```kotlin\nlike: Boolean\n```
//                                                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().(escapeChar)
//                                                                                           display_name escapeChar
//                                                                                           documentation ```kotlin\nescapeChar: Char?\n```
//                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().(escapeChar)
//                                                                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#escapeChar.
//                                                                                           display_name escapeChar
//                                                                                           documentation ```kotlin\npublic final val escapeChar: Char?\n```
//                                                                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#getEscapeChar().
//                                                                                           display_name escapeChar
//                                                                                           documentation ```kotlin\npublic get(): Char?\n```
//                                                                                            ^^^^^ reference semanticdb maven . . kotlin/Char#
    ComparisonOp(expr1, expr2, if (like) "LIKE" else "NOT LIKE") {
//  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().(expr1)
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().(expr2)
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().(like)
    override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
        super.toQueryBuilder(queryBuilder)
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#toQueryBuilder().
//                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#toQueryBuilder().(queryBuilder)
        if (escapeChar != null) {
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#escapeChar.
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#getEscapeChar().
            with(queryBuilder) {
//          ^^^^ reference semanticdb maven . . kotlin/with().
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#toQueryBuilder().(queryBuilder)
                +" ESCAPE "
//              ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                +stringParam(escapeChar.toString())
//              ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/stringParam().
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#escapeChar.
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#getEscapeChar().
//                                      ^^^^^^^^ reference semanticdb maven . . kotlin/Char#toString().
            }
        }
    }
}

/**
 * Represents an SQL operator that checks if [expr1] matches the regular expression [expr2].
 */
class RegexpOp<T : String?>(
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#
//             display_name RegexpOp
//             documentation ```kotlin\npublic final class RegexpOp<T : String?> : Op<Boolean>, ComplexExpression, Op.OpBoolean\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr1] matches the regular expression [expr2].\n
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#`<init>`().
//             display_name RegexpOp
//             documentation ```kotlin\npublic constructor<T : String?>(expr1: Expression<T>, expr2: Expression<String>, caseSensitive: Boolean): RegexpOp<T>\n```\n\n----\n\n Returns the expression being checked.
//             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#[T]
//               display_name FirTypeParameterSymbol T
//               documentation ```kotlin\nT : String?\n```
    /** Returns the expression being checked. */
    val expr1: Expression<T>,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#`<init>`().(expr1)
//            display_name expr1
//            documentation ```kotlin\nexpr1: Expression<T>\n```\n\n----\n\n Returns the expression being checked.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#`<init>`().(expr1)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#expr1.
//            display_name expr1
//            documentation ```kotlin\npublic final val expr1: Expression<T>\n```\n\n----\n\n Returns the expression being checked.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#getExpr1().
//            display_name expr1
//            documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n Returns the expression being checked.
//             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** Returns the regular expression [expr1] is checked against. */
    val expr2: Expression<String>,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#`<init>`().(expr2)
//            display_name expr2
//            documentation ```kotlin\nexpr2: Expression<String>\n```\n\n----\n\n Returns the regular expression [expr1] is checked against.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#`<init>`().(expr2)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#expr2.
//            display_name expr2
//            documentation ```kotlin\npublic final val expr2: Expression<String>\n```\n\n----\n\n Returns the regular expression [expr1] is checked against.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#getExpr2().
//            display_name expr2
//            documentation ```kotlin\npublic get(): Expression<String>\n```\n\n----\n\n Returns the regular expression [expr1] is checked against.
//             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** Returns `true` if the regular expression is case sensitive, `false` otherwise. */
    val caseSensitive: Boolean
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#`<init>`().(caseSensitive)
//                    display_name caseSensitive
//                    documentation ```kotlin\ncaseSensitive: Boolean\n```\n\n----\n\n Returns `true` if the regular expression is case sensitive, `false` otherwise.
//      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#`<init>`().(caseSensitive)
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#caseSensitive.
//                    display_name caseSensitive
//                    documentation ```kotlin\npublic final val caseSensitive: Boolean\n```\n\n----\n\n Returns `true` if the regular expression is case sensitive, `false` otherwise.
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#getCaseSensitive().
//                    display_name caseSensitive
//                    documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Returns `true` if the regular expression is case sensitive, `false` otherwise.
//                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
) : Op<Boolean>(), ComplexExpression, Op.OpBoolean {
//  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
    override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
        currentDialect.functionProvider.regexp(expr1, expr2, caseSensitive, queryBuilder)
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#expr1.
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#getExpr1().
//                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#expr2.
//                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#getExpr2().
//                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#caseSensitive.
//                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#getCaseSensitive().
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#toQueryBuilder().(queryBuilder)
    }
}

// Subquery Expressions

/**
 * Represents an SQL operator that checks if [query] returns at least one row.
 */
class Exists(
//    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Exists#
//           display_name Exists
//           documentation ```kotlin\npublic final class Exists : Op<Boolean>, Op.OpBoolean\n```\n\n----\n\n\n Represents an SQL operator that checks if [query] returns at least one row.\n
//           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Exists#`<init>`().
//           display_name Exists
//           documentation ```kotlin\npublic constructor(query: AbstractQuery<*>): Exists\n```\n\n----\n\n Returns the query being checked.
    /** Returns the query being checked. */
    val query: AbstractQuery<*>
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Exists#`<init>`().(query)
//            display_name query
//            documentation ```kotlin\nquery: AbstractQuery<*>\n```\n\n----\n\n Returns the query being checked.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Exists#`<init>`().(query)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Exists#getQuery().
//            display_name query
//            documentation ```kotlin\npublic get(): AbstractQuery<*>\n```\n\n----\n\n Returns the query being checked.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Exists#query.
//            display_name query
//            documentation ```kotlin\npublic final val query: AbstractQuery<*>\n```\n\n----\n\n Returns the query being checked.
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
) : Op<Boolean>(), Op.OpBoolean {
//  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Exists#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Exists#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Exists#toQueryBuilder().(queryBuilder)
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
        append("EXISTS (")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
        query.prepareSQL(this)
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Exists#getQuery().
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Exists#query.
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().
        append(")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
    }
}

/** Returns an SQL operator that checks if [query] returns at least one row. */
fun exists(query: AbstractQuery<*>) = Exists(query)
//  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/exists().
//         display_name exists
//         documentation ```kotlin\npublic final fun exists(query: AbstractQuery<*>): Exists\n```\n\n----\n\n Returns an SQL operator that checks if [query] returns at least one row.
//         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/exists().(query)
//               display_name query
//               documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Exists#`<init>`().
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exists().(query)

/**
 * Represents an SQL operator that checks if [query] doesn't returns any row.
 */
class NotExists(
//    ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotExists#
//              display_name NotExists
//              documentation ```kotlin\npublic final class NotExists : Op<Boolean>, Op.OpBoolean\n```\n\n----\n\n\n Represents an SQL operator that checks if [query] doesn't returns any row.\n
//              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//    ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotExists#`<init>`().
//              display_name NotExists
//              documentation ```kotlin\npublic constructor(query: AbstractQuery<*>): NotExists\n```\n\n----\n\n Returns the query being checked.
    /** Returns the query being checked. */
    val query: AbstractQuery<*>
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotExists#`<init>`().(query)
//            display_name query
//            documentation ```kotlin\nquery: AbstractQuery<*>\n```\n\n----\n\n Returns the query being checked.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotExists#`<init>`().(query)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotExists#getQuery().
//            display_name query
//            documentation ```kotlin\npublic get(): AbstractQuery<*>\n```\n\n----\n\n Returns the query being checked.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotExists#query.
//            display_name query
//            documentation ```kotlin\npublic final val query: AbstractQuery<*>\n```\n\n----\n\n Returns the query being checked.
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
) : Op<Boolean>(), Op.OpBoolean {
//  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotExists#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotExists#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotExists#toQueryBuilder().(queryBuilder)
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
        append("NOT EXISTS (")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
        query.prepareSQL(this)
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotExists#getQuery().
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotExists#query.
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().
        append(")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
    }
}

/** Returns an SQL operator that checks if [query] doesn't returns any row. */
fun notExists(query: AbstractQuery<*>) = NotExists(query)
//  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/notExists().
//            display_name notExists
//            documentation ```kotlin\npublic final fun notExists(query: AbstractQuery<*>): NotExists\n```\n\n----\n\n Returns an SQL operator that checks if [query] doesn't returns any row.
//            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/notExists().(query)
//                  display_name query
//                  documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotExists#`<init>`().
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/notExists().(query)

/** Represents an SQL operator that compares [expr] to any row returned from [query]. */
sealed class SubQueryOp<T>(
//           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//                      display_name SubQueryOp
//                      documentation ```kotlin\npublic sealed class SubQueryOp<T> : Op<Boolean>, ComplexExpression, Op.OpBoolean\n```\n\n----\n\n Represents an SQL operator that compares [expr] to any row returned from [query].
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/EqSubQueryOp#
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqSubQueryOp#
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterSubQueryOp#
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/InSubQueryOp#
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqSubQueryOp#
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/LessSubQueryOp#
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NotEqSubQueryOp#
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NotInSubQueryOp#
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#`<init>`().
//                      display_name SubQueryOp
//                      documentation ```kotlin\nprotected constructor<T>(operator: String, expr: Expression<T>, query: AbstractQuery<*>): SubQueryOp<T>\n```\n\n----\n\n Returns the string representation of the operator to use in the comparison.
//                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#[T]
//                        display_name FirTypeParameterSymbol T
//                        documentation ```kotlin\nT\n```
    /** Returns the string representation of the operator to use in the comparison. */
    val operator: String,
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#`<init>`().(operator)
//               display_name operator
//               documentation ```kotlin\noperator: String\n```\n\n----\n\n Returns the string representation of the operator to use in the comparison.
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#`<init>`().(operator)
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#getOperator().
//               display_name operator
//               documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Returns the string representation of the operator to use in the comparison.
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#operator.
//               display_name operator
//               documentation ```kotlin\npublic final val operator: String\n```\n\n----\n\n Returns the string representation of the operator to use in the comparison.
//                ^^^^^^ reference semanticdb maven . . kotlin/String#
    /** Returns the expression compared to each row of the query result. */
    val expr: Expression<T>,
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#`<init>`().(expr)
//           display_name expr
//           documentation ```kotlin\nexpr: Expression<T>\n```\n\n----\n\n Returns the expression compared to each row of the query result.
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#`<init>`().(expr)
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#expr.
//           display_name expr
//           documentation ```kotlin\npublic final val expr: Expression<T>\n```\n\n----\n\n Returns the expression compared to each row of the query result.
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#getExpr().
//           display_name expr
//           documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n Returns the expression compared to each row of the query result.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** Returns the query to check against. */
    val query: AbstractQuery<*>
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#`<init>`().(query)
//            display_name query
//            documentation ```kotlin\nquery: AbstractQuery<*>\n```\n\n----\n\n Returns the query to check against.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#`<init>`().(query)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#getQuery().
//            display_name query
//            documentation ```kotlin\npublic get(): AbstractQuery<*>\n```\n\n----\n\n Returns the query to check against.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#query.
//            display_name query
//            documentation ```kotlin\npublic final val query: AbstractQuery<*>\n```\n\n----\n\n Returns the query to check against.
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
) : Op<Boolean>(), ComplexExpression, Op.OpBoolean {
//  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#toQueryBuilder().(queryBuilder)
        append(expr, " $operator (")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#expr.
//             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#getExpr().
//                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#getOperator().
//                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#operator.
        query.prepareSQL(this)
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#getQuery().
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#query.
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().
        +")"
//      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
    }
}

/**
 * Represents an SQL operator that checks if [expr] is equals to any row returned from [query].
 */
class InSubQueryOp<T>(expr: Expression<T>, query: AbstractQuery<*>) : SubQueryOp<T>("IN", expr, query)
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/InSubQueryOp#
//                 display_name InSubQueryOp
//                 documentation ```kotlin\npublic final class InSubQueryOp<T> : SubQueryOp<T>\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr] is equals to any row returned from [query].\n
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/InSubQueryOp#`<init>`().
//                 display_name InSubQueryOp
//                 documentation ```kotlin\npublic constructor<T>(expr: Expression<T>, query: AbstractQuery<*>): InSubQueryOp<T>\n```
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/InSubQueryOp#[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/InSubQueryOp#`<init>`().(expr)
//                         display_name expr
//                         documentation ```kotlin\nexpr: Expression<T>\n```
//                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/InSubQueryOp#`<init>`().(query)
//                                               display_name query
//                                               documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/InSubQueryOp#`<init>`().(expr)
//                                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/InSubQueryOp#`<init>`().(query)

/**
 * Represents an SQL operator that checks if [expr] is not equals to any row returned from [query].
 */
class NotInSubQueryOp<T>(expr: Expression<T>, query: AbstractQuery<*>) : SubQueryOp<T>("NOT IN", expr, query)
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotInSubQueryOp#
//                    display_name NotInSubQueryOp
//                    documentation ```kotlin\npublic final class NotInSubQueryOp<T> : SubQueryOp<T>\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr] is not equals to any row returned from [query].\n
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotInSubQueryOp#`<init>`().
//                    display_name NotInSubQueryOp
//                    documentation ```kotlin\npublic constructor<T>(expr: Expression<T>, query: AbstractQuery<*>): NotInSubQueryOp<T>\n```
//                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotInSubQueryOp#[T]
//                      display_name FirTypeParameterSymbol T
//                      documentation ```kotlin\nT\n```
//                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotInSubQueryOp#`<init>`().(expr)
//                            display_name expr
//                            documentation ```kotlin\nexpr: Expression<T>\n```
//                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotInSubQueryOp#`<init>`().(query)
//                                                  display_name query
//                                                  documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//                                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotInSubQueryOp#`<init>`().(expr)
//                                                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotInSubQueryOp#`<init>`().(query)

/**
 * Represents an SQL operator that checks if [expr] is equals to single value returned from [query].
 */
class EqSubQueryOp<T>(expr: Expression<T>, query: AbstractQuery<*>) : SubQueryOp<T>("=", expr, query)
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EqSubQueryOp#
//                 display_name EqSubQueryOp
//                 documentation ```kotlin\npublic final class EqSubQueryOp<T> : SubQueryOp<T>\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr] is equals to single value returned from [query].\n
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EqSubQueryOp#`<init>`().
//                 display_name EqSubQueryOp
//                 documentation ```kotlin\npublic constructor<T>(expr: Expression<T>, query: AbstractQuery<*>): EqSubQueryOp<T>\n```
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EqSubQueryOp#[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EqSubQueryOp#`<init>`().(expr)
//                         display_name expr
//                         documentation ```kotlin\nexpr: Expression<T>\n```
//                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EqSubQueryOp#`<init>`().(query)
//                                               display_name query
//                                               documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqSubQueryOp#`<init>`().(expr)
//                                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqSubQueryOp#`<init>`().(query)

/**
 * Represents an SQL operator that checks if [expr] is not equals to single value returned from [query].
 */
class NotEqSubQueryOp<T>(expr: Expression<T>, query: AbstractQuery<*>) : SubQueryOp<T>("!=", expr, query)
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotEqSubQueryOp#
//                    display_name NotEqSubQueryOp
//                    documentation ```kotlin\npublic final class NotEqSubQueryOp<T> : SubQueryOp<T>\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr] is not equals to single value returned from [query].\n
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotEqSubQueryOp#`<init>`().
//                    display_name NotEqSubQueryOp
//                    documentation ```kotlin\npublic constructor<T>(expr: Expression<T>, query: AbstractQuery<*>): NotEqSubQueryOp<T>\n```
//                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotEqSubQueryOp#[T]
//                      display_name FirTypeParameterSymbol T
//                      documentation ```kotlin\nT\n```
//                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotEqSubQueryOp#`<init>`().(expr)
//                            display_name expr
//                            documentation ```kotlin\nexpr: Expression<T>\n```
//                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NotEqSubQueryOp#`<init>`().(query)
//                                                  display_name query
//                                                  documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//                                                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotEqSubQueryOp#`<init>`().(expr)
//                                                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotEqSubQueryOp#`<init>`().(query)

/**
 * Represents an SQL operator that checks if [expr] is less than the single value returned from [query].
 */
class LessSubQueryOp<T>(expr: Expression<T>, query: AbstractQuery<*>) : SubQueryOp<T>("<", expr, query)
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessSubQueryOp#
//                   display_name LessSubQueryOp
//                   documentation ```kotlin\npublic final class LessSubQueryOp<T> : SubQueryOp<T>\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr] is less than the single value returned from [query].\n
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessSubQueryOp#`<init>`().
//                   display_name LessSubQueryOp
//                   documentation ```kotlin\npublic constructor<T>(expr: Expression<T>, query: AbstractQuery<*>): LessSubQueryOp<T>\n```
//                   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessSubQueryOp#[T]
//                     display_name FirTypeParameterSymbol T
//                     documentation ```kotlin\nT\n```
//                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessSubQueryOp#`<init>`().(expr)
//                           display_name expr
//                           documentation ```kotlin\nexpr: Expression<T>\n```
//                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessSubQueryOp#`<init>`().(query)
//                                                 display_name query
//                                                 documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//                                                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessSubQueryOp#`<init>`().(expr)
//                                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessSubQueryOp#`<init>`().(query)

/**
 * Represents an SQL operator that checks if [expr] is less than or equal to the single value returned from [query].
 */
class LessEqSubQueryOp<T>(expr: Expression<T>, query: AbstractQuery<*>) : SubQueryOp<T>("<=", expr, query)
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqSubQueryOp#
//                     display_name LessEqSubQueryOp
//                     documentation ```kotlin\npublic final class LessEqSubQueryOp<T> : SubQueryOp<T>\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr] is less than or equal to the single value returned from [query].\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqSubQueryOp#`<init>`().
//                     display_name LessEqSubQueryOp
//                     documentation ```kotlin\npublic constructor<T>(expr: Expression<T>, query: AbstractQuery<*>): LessEqSubQueryOp<T>\n```
//                     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqSubQueryOp#[T]
//                       display_name FirTypeParameterSymbol T
//                       documentation ```kotlin\nT\n```
//                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqSubQueryOp#`<init>`().(expr)
//                             display_name expr
//                             documentation ```kotlin\nexpr: Expression<T>\n```
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqSubQueryOp#`<init>`().(query)
//                                                   display_name query
//                                                   documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//                                                                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqSubQueryOp#`<init>`().(expr)
//                                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqSubQueryOp#`<init>`().(query)

/**
 * Represents an SQL operator that checks if [expr] is greater than the single value returned from [query].
 */
class GreaterSubQueryOp<T>(expr: Expression<T>, query: AbstractQuery<*>) : SubQueryOp<T>(">", expr, query)
//    ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterSubQueryOp#
//                      display_name GreaterSubQueryOp
//                      documentation ```kotlin\npublic final class GreaterSubQueryOp<T> : SubQueryOp<T>\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr] is greater than the single value returned from [query].\n
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//    ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterSubQueryOp#`<init>`().
//                      display_name GreaterSubQueryOp
//                      documentation ```kotlin\npublic constructor<T>(expr: Expression<T>, query: AbstractQuery<*>): GreaterSubQueryOp<T>\n```
//                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterSubQueryOp#[T]
//                        display_name FirTypeParameterSymbol T
//                        documentation ```kotlin\nT\n```
//                         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterSubQueryOp#`<init>`().(expr)
//                              display_name expr
//                              documentation ```kotlin\nexpr: Expression<T>\n```
//                               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterSubQueryOp#`<init>`().(query)
//                                                    display_name query
//                                                    documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//                                                                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterSubQueryOp#`<init>`().(expr)
//                                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterSubQueryOp#`<init>`().(query)

/**
 * Represents an SQL operator that checks if [expr] is greater than or equal to the single value returned from [query].
 */
class GreaterEqSubQueryOp<T>(expr: Expression<T>, query: AbstractQuery<*>) : SubQueryOp<T>(">=", expr, query)
//    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqSubQueryOp#
//                        display_name GreaterEqSubQueryOp
//                        documentation ```kotlin\npublic final class GreaterEqSubQueryOp<T> : SubQueryOp<T>\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr] is greater than or equal to the single value returned from [query].\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqSubQueryOp#`<init>`().
//                        display_name GreaterEqSubQueryOp
//                        documentation ```kotlin\npublic constructor<T>(expr: Expression<T>, query: AbstractQuery<*>): GreaterEqSubQueryOp<T>\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqSubQueryOp#[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT\n```
//                           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqSubQueryOp#`<init>`().(expr)
//                                display_name expr
//                                documentation ```kotlin\nexpr: Expression<T>\n```
//                                 ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqSubQueryOp#`<init>`().(query)
//                                                      display_name query
//                                                      documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SubQueryOp#
//                                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqSubQueryOp#`<init>`().(expr)
//                                                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqSubQueryOp#`<init>`().(query)

// Literals

/**
 * Represents the specified [value] as an SQL literal, using the specified [columnType] to convert the value.
 */
class LiteralOp<T>(
//    ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//              display_name LiteralOp
//              documentation ```kotlin\npublic final class LiteralOp<T> : ExpressionWithColumnType<T>\n```\n\n----\n\n\n Represents the specified [value] as an SQL literal, using the specified [columnType] to convert the value.\n
//              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//    ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//              display_name LiteralOp
//              documentation ```kotlin\npublic constructor<T>(columnType: IColumnType<T & Any>, value: T): LiteralOp<T>\n```\n\n----\n\n Returns the value being used as a literal.
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
    override val columnType: IColumnType<T & Any>,
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().(columnType)
//                          display_name columnType
//                          documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().(columnType)
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                          display_name columnType
//                          documentation ```kotlin\npublic open override val columnType: IColumnType<T & Any>\n```
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                          display_name columnType
//                          documentation ```kotlin\npublic get(): IColumnType<T & Any>\n```
//                           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
    /** Returns the value being used as a literal. */
    val value: T
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().(value)
//            display_name value
//            documentation ```kotlin\nvalue: T\n```\n\n----\n\n Returns the value being used as a literal.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().(value)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getValue().
//            display_name value
//            documentation ```kotlin\npublic get(): T\n```\n\n----\n\n Returns the value being used as a literal.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#value.
//            display_name value
//            documentation ```kotlin\npublic final val value: T\n```\n\n----\n\n Returns the value being used as a literal.
) : ExpressionWithColumnType<T>() {
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder { +columnType.valueToString(value) }
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#toQueryBuilder().(queryBuilder)
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                 ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                                                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueToString().
//                                                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getValue().
//                                                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#value.
}

/** Returns the specified [value] as a boolean literal. */
fun booleanLiteral(value: Boolean): LiteralOp<Boolean> = LiteralOp(BooleanColumnType.INSTANCE, value)
//  ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/booleanLiteral().
//                 display_name booleanLiteral
//                 documentation ```kotlin\npublic final fun booleanLiteral(value: Boolean): LiteralOp<Boolean>\n```\n\n----\n\n Returns the specified [value] as a boolean literal.
//                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/booleanLiteral().(value)
//                       display_name value
//                       documentation ```kotlin\nvalue: Boolean\n```
//                        ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                                                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#Companion#INSTANCE.
//                                                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#Companion#getINSTANCE().
//                                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/booleanLiteral().(value)

/** Returns the specified [value] as a byte literal. */
fun byteLiteral(value: Byte): LiteralOp<Byte> = LiteralOp(ByteColumnType(), value)
//  ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/byteLiteral().
//              display_name byteLiteral
//              documentation ```kotlin\npublic final fun byteLiteral(value: Byte): LiteralOp<Byte>\n```\n\n----\n\n Returns the specified [value] as a byte literal.
//              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/byteLiteral().(value)
//                    display_name value
//                    documentation ```kotlin\nvalue: Byte\n```
//                     ^^^^ reference semanticdb maven . . kotlin/Byte#
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#`<init>`().
//                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/byteLiteral().(value)

/** Returns the specified [value] as a unsigned byte literal. */
fun ubyteLiteral(value: UByte): LiteralOp<UByte> = LiteralOp(UByteColumnType(), value)
//  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ubyteLiteral().
//               display_name ubyteLiteral
//               documentation ```kotlin\npublic final fun ubyteLiteral(value: UByte): LiteralOp<UByte>\n```\n\n----\n\n Returns the specified [value] as a unsigned byte literal.
//               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ubyteLiteral().(value)
//                     display_name value
//                     documentation ```kotlin\nvalue: UByte\n```
//                      ^^^^^ reference semanticdb maven . . kotlin/UByte#
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#`<init>`().
//                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ubyteLiteral().(value)

/** Returns the specified [value] as a short literal. */
fun shortLiteral(value: Short): LiteralOp<Short> = LiteralOp(ShortColumnType(), value)
//  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/shortLiteral().
//               display_name shortLiteral
//               documentation ```kotlin\npublic final fun shortLiteral(value: Short): LiteralOp<Short>\n```\n\n----\n\n Returns the specified [value] as a short literal.
//               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/shortLiteral().(value)
//                     display_name value
//                     documentation ```kotlin\nvalue: Short\n```
//                      ^^^^^ reference semanticdb maven . . kotlin/Short#
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#`<init>`().
//                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/shortLiteral().(value)

/** Returns the specified [value] as a unsigned short literal. */
fun ushortLiteral(value: UShort): LiteralOp<UShort> = LiteralOp(UShortColumnType(), value)
//  ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ushortLiteral().
//                display_name ushortLiteral
//                documentation ```kotlin\npublic final fun ushortLiteral(value: UShort): LiteralOp<UShort>\n```\n\n----\n\n Returns the specified [value] as a unsigned short literal.
//                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ushortLiteral().(value)
//                      display_name value
//                      documentation ```kotlin\nvalue: UShort\n```
//                       ^^^^^^ reference semanticdb maven . . kotlin/UShort#
//                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                                                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#`<init>`().
//                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ushortLiteral().(value)

/** Returns the specified [value] as an int literal. */
fun intLiteral(value: Int): LiteralOp<Int> = LiteralOp(IntegerColumnType(), value)
//  ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().
//             display_name intLiteral
//             documentation ```kotlin\npublic final fun intLiteral(value: Int): LiteralOp<Int>\n```\n\n----\n\n Returns the specified [value] as an int literal.
//             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().(value)
//                   display_name value
//                   documentation ```kotlin\nvalue: Int\n```
//                    ^^^ reference semanticdb maven . . kotlin/Int#
//                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                                                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#`<init>`().
//                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().(value)

/** Returns the specified [value] as a unsigned int literal. */
fun uintLiteral(value: UInt): LiteralOp<UInt> = LiteralOp(UIntegerColumnType(), value)
//  ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/uintLiteral().
//              display_name uintLiteral
//              documentation ```kotlin\npublic final fun uintLiteral(value: UInt): LiteralOp<UInt>\n```\n\n----\n\n Returns the specified [value] as a unsigned int literal.
//              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/uintLiteral().(value)
//                    display_name value
//                    documentation ```kotlin\nvalue: UInt\n```
//                     ^^^^ reference semanticdb maven . . kotlin/UInt#
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                                                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#`<init>`().
//                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/uintLiteral().(value)

/** Returns the specified [value] as a long literal. */
fun longLiteral(value: Long): LiteralOp<Long> = LiteralOp(LongColumnType(), value)
//  ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/longLiteral().
//              display_name longLiteral
//              documentation ```kotlin\npublic final fun longLiteral(value: Long): LiteralOp<Long>\n```\n\n----\n\n Returns the specified [value] as a long literal.
//              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/longLiteral().(value)
//                    display_name value
//                    documentation ```kotlin\nvalue: Long\n```
//                     ^^^^ reference semanticdb maven . . kotlin/Long#
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#`<init>`().
//                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/longLiteral().(value)

/** Returns the specified [value] as a unsigned long literal. */
fun ulongLiteral(value: ULong): LiteralOp<ULong> = LiteralOp(ULongColumnType(), value)
//  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ulongLiteral().
//               display_name ulongLiteral
//               documentation ```kotlin\npublic final fun ulongLiteral(value: ULong): LiteralOp<ULong>\n```\n\n----\n\n Returns the specified [value] as a unsigned long literal.
//               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ulongLiteral().(value)
//                     display_name value
//                     documentation ```kotlin\nvalue: ULong\n```
//                      ^^^^^ reference semanticdb maven . . kotlin/ULong#
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#`<init>`().
//                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ulongLiteral().(value)

/** Returns the specified [value] as a float literal. */
fun floatLiteral(value: Float): LiteralOp<Float> = LiteralOp(FloatColumnType(), value)
//  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/floatLiteral().
//               display_name floatLiteral
//               documentation ```kotlin\npublic final fun floatLiteral(value: Float): LiteralOp<Float>\n```\n\n----\n\n Returns the specified [value] as a float literal.
//               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/floatLiteral().(value)
//                     display_name value
//                     documentation ```kotlin\nvalue: Float\n```
//                      ^^^^^ reference semanticdb maven . . kotlin/Float#
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#`<init>`().
//                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/floatLiteral().(value)

/** Returns the specified [value] as a double literal. */
fun doubleLiteral(value: Double): LiteralOp<Double> = LiteralOp(DoubleColumnType(), value)
//  ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/doubleLiteral().
//                display_name doubleLiteral
//                documentation ```kotlin\npublic final fun doubleLiteral(value: Double): LiteralOp<Double>\n```\n\n----\n\n Returns the specified [value] as a double literal.
//                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/doubleLiteral().(value)
//                      display_name value
//                      documentation ```kotlin\nvalue: Double\n```
//                       ^^^^^^ reference semanticdb maven . . kotlin/Double#
//                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                                                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#`<init>`().
//                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/doubleLiteral().(value)

/** Returns the specified [value] as a string literal. */
fun stringLiteral(value: String): LiteralOp<String> = LiteralOp(TextColumnType(), value)
//  ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/stringLiteral().
//                display_name stringLiteral
//                documentation ```kotlin\npublic final fun stringLiteral(value: String): LiteralOp<String>\n```\n\n----\n\n Returns the specified [value] as a string literal.
//                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/stringLiteral().(value)
//                      display_name value
//                      documentation ```kotlin\nvalue: String\n```
//                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
//                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/stringLiteral().(value)

/** Returns the specified [value] as a decimal literal. */
fun decimalLiteral(value: BigDecimal): LiteralOp<BigDecimal> = LiteralOp(DecimalColumnType(value.precision(), value.scale()), value)
//  ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/decimalLiteral().
//                 display_name decimalLiteral
//                 documentation ```kotlin\npublic final fun decimalLiteral(value: BigDecimal): LiteralOp<BigDecimal>\n```\n\n----\n\n Returns the specified [value] as a decimal literal.
//                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/decimalLiteral().(value)
//                       display_name value
//                       documentation ```kotlin\nvalue: BigDecimal\n```
//                        ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
//                                     ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                                                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/decimalLiteral().(value)
//                                                                                               ^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#precision().
//                                                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/decimalLiteral().(value)
//                                                                                                                  ^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#scale().
//                                                                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/decimalLiteral().(value)

/**
 * Returns the specified [value] as an array literal, with elements parsed by the [delegateType] if provided.
 *
 * **Note** If [delegateType] is left `null`, the associated column type will be resolved according to the
 * internal mapping of the element's type in [resolveColumnType].
 *
 * @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.
 */
inline fun <reified T : Any> arrayLiteral(value: List<T>, delegateType: ColumnType<T>? = null): LiteralOp<List<T>> =
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nreified T : Any\n```
//                           ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral().
//                                        display_name arrayLiteral
//                                        documentation ```kotlin\npublic final inline fun <reified T : Any> arrayLiteral(value: List<T>, delegateType: ColumnType<T>? = ...): LiteralOp<List<T>>\n```\n\n----\n\n\n Returns the specified [value] as an array literal, with elements parsed by the [delegateType] if provided.\n\n **Note** If [delegateType] is left `null`, the associated column type will be resolved according to the\n internal mapping of the element's type in [resolveColumnType].\n\n @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.\n
//                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral().(value)
//                                              display_name value
//                                              documentation ```kotlin\nvalue: List<T>\n```
//                                               ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral().(delegateType)
//                                                                     display_name delegateType
//                                                                     documentation ```kotlin\ndelegateType: ColumnType<T>? = ...\n```
//                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                                                                                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
    arrayLiteral(value, 1, delegateType)
//  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral(+1).
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral().(value)
//                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral().(delegateType)

/**
 * Returns the specified [value] as an array literal, with elements parsed by the [delegateType] if provided.
 *
 * **Note** If [delegateType] is left `null`, the associated column type will be resolved according to the
 * internal mapping of the element's type in [resolveColumnType].
 *
 * **Note:** Because arrays can have varying dimensions, you must specify the type of elements
 * and the number of dimensions when using array literals.
 * For example, use `arrayLiteral<Int, List<List<Int>>>(list, dimensions = 2)`.
 *
 * @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.
 */
inline fun <reified T : Any, R : List<Any>> arrayLiteral(value: R, dimensions: Int, delegateType: ColumnType<T>? = null): LiteralOp<R> {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral(+1).[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nreified T : Any\n```
//                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral(+1).[R]
//                             display_name FirTypeParameterSymbol R
//                             documentation ```kotlin\nR : List<Any>\n```
//                                          ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral(+1).
//                                                       display_name arrayLiteral
//                                                       documentation ```kotlin\npublic final inline fun <reified T : Any, R : List<Any>> arrayLiteral(value: R, dimensions: Int, delegateType: ColumnType<T>? = ...): LiteralOp<R>\n```\n\n----\n\n\n Returns the specified [value] as an array literal, with elements parsed by the [delegateType] if provided.\n\n **Note** If [delegateType] is left `null`, the associated column type will be resolved according to the\n internal mapping of the element's type in [resolveColumnType].\n\n **Note:** Because arrays can have varying dimensions, you must specify the type of elements\n and the number of dimensions when using array literals.\n For example, use `arrayLiteral<Int, List<List<Int>>>(list, dimensions = 2)`.\n\n @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.\n
//                                                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral(+1).(value)
//                                                             display_name value
//                                                             documentation ```kotlin\nvalue: R\n```
//                                                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral(+1).(dimensions)
//                                                                            display_name dimensions
//                                                                            documentation ```kotlin\ndimensions: Int\n```
//                                                                             ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral(+1).(delegateType)
//                                                                                               display_name delegateType
//                                                                                               documentation ```kotlin\ndelegateType: ColumnType<T>? = ...\n```
//                                                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                                                                                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
    @OptIn(InternalApi::class)
    return LiteralOp(ArrayColumnType(delegateType ?: resolveColumnType(T::class), dimensions = dimensions), value)
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`().
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral(+1).(delegateType)
//                                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/resolveColumnType().
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral(+1).(dimensions)
//                                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/arrayLiteral(+1).(value)
}

// Query Parameters

/**
 * Represents the specified [value] as a query parameter, using the specified [sqlType] to convert the value.
 */
class QueryParameter<T>(
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#
//                   display_name QueryParameter
//                   documentation ```kotlin\npublic final class QueryParameter<T> : Expression<T>\n```\n\n----\n\n\n Represents the specified [value] as a query parameter, using the specified [sqlType] to convert the value.\n
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                   display_name QueryParameter
//                   documentation ```kotlin\npublic constructor<T>(value: T, sqlType: IColumnType<T & Any>): QueryParameter<T>\n```\n\n----\n\n Returns the value being used as a query parameter.
//                   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#[T]
//                     display_name FirTypeParameterSymbol T
//                     documentation ```kotlin\nT\n```
    /** Returns the value being used as a query parameter. */
    val value: T,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().(value)
//            display_name value
//            documentation ```kotlin\nvalue: T\n```\n\n----\n\n Returns the value being used as a query parameter.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().(value)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#getValue().
//            display_name value
//            documentation ```kotlin\npublic get(): T\n```\n\n----\n\n Returns the value being used as a query parameter.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#value.
//            display_name value
//            documentation ```kotlin\npublic final val value: T\n```\n\n----\n\n Returns the value being used as a query parameter.
    /** Returns the column type of this expression. */
    val sqlType: IColumnType<T & Any>
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().(sqlType)
//              display_name sqlType
//              documentation ```kotlin\nsqlType: IColumnType<T & Any>\n```\n\n----\n\n Returns the column type of this expression.
//      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().(sqlType)
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#getSqlType().
//              display_name sqlType
//              documentation ```kotlin\npublic get(): IColumnType<T & Any>\n```\n\n----\n\n Returns the column type of this expression.
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#sqlType.
//              display_name sqlType
//              documentation ```kotlin\npublic final val sqlType: IColumnType<T & Any>\n```\n\n----\n\n Returns the column type of this expression.
//               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
) : Expression<T>() {
//  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    internal val compositeValue: CompositeID? = (value as? EntityID<*>)?.value as? CompositeID
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#compositeValue.
//                              display_name compositeValue
//                              documentation ```kotlin\ninternal final val compositeValue: CompositeID?\n```
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#getCompositeValue().
//                              display_name compositeValue
//                              documentation ```kotlin\ninternal get(): CompositeID?\n```
//                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#getValue().
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#value.
//                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.

    override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
        queryBuilder {
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#toQueryBuilder().(queryBuilder)
            compositeValue?.let {
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#compositeValue.
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#getCompositeValue().
//                          ^^^ reference semanticdb maven . . kotlin/let().
//                              ^ definition semanticdb maven . . (it) 4:13
//                                display_name it
//                                documentation ```kotlin\nit: CompositeID\n```
                it.values.entries.appendTo { (column, value) ->
//              ^^ reference semanticdb maven . . (it)
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                        ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#entries.
//                        ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getEntries().
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                           ^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                           display_name <destruct>
//                                                           documentation ```kotlin\n<destruct>: MutableMap.MutableEntry<Column<*>, Any?>\n```
//                                            ^^^^^^ definition local 9
//                                                   display_name column
//                                                   documentation ```kotlin\nlocal val column: Column<*>\n```
//                                            ^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                            ^^^^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                                    ^^^^^ definition local 10
//                                                          display_name value
//                                                          documentation ```kotlin\nlocal val value: Any?\n```
//                                                    ^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                    ^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
                    registerArgument(column.columnType, value)
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
//                                   ^^^^^^ reference local 9
//                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                      ^^^^^ reference local 10
                }
            } ?: registerArgument(sqlType, value)
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
//                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#getSqlType().
//                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#sqlType.
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#getValue().
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#value.
        }
    }
}

/** Returns the specified [value] as a query parameter with the same type as [column]. */
fun <T : Any> idParam(value: EntityID<T>, column: Column<EntityID<T>>): Expression<EntityID<T>> =
//   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/idParam().[T]
//     display_name FirTypeParameterSymbol T
//     documentation ```kotlin\nT : Any\n```
//            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/idParam().
//                    display_name idParam
//                    documentation ```kotlin\npublic final fun <T : Any> idParam(value: EntityID<T>, column: Column<EntityID<T>>): Expression<EntityID<T>>\n```\n\n----\n\n Returns the specified [value] as a query parameter with the same type as [column].
//                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/idParam().(value)
//                          display_name value
//                          documentation ```kotlin\nvalue: EntityID<T>\n```
//                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
//                                        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/idParam().(column)
//                                               display_name column
//                                               documentation ```kotlin\ncolumn: Column<EntityID<T>>\n```
//                                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                      ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    QueryParameter(value, column.columnType)
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/idParam().(value)
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/idParam().(column)
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().

/** Returns the specified [value] as a boolean query parameter. */
fun booleanParam(value: Boolean): Expression<Boolean> = QueryParameter(value, BooleanColumnType.INSTANCE)
//  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/booleanParam().
//               display_name booleanParam
//               documentation ```kotlin\npublic final fun booleanParam(value: Boolean): Expression<Boolean>\n```\n\n----\n\n Returns the specified [value] as a boolean query parameter.
//               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/booleanParam().(value)
//                     display_name value
//                     documentation ```kotlin\nvalue: Boolean\n```
//                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/booleanParam().(value)
//                                                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#Companion#INSTANCE.
//                                                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#Companion#getINSTANCE().

/** Returns the specified [value] as a byte query parameter. */
fun byteParam(value: Byte): Expression<Byte> = QueryParameter(value, ByteColumnType())
//  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/byteParam().
//            display_name byteParam
//            documentation ```kotlin\npublic final fun byteParam(value: Byte): Expression<Byte>\n```\n\n----\n\n Returns the specified [value] as a byte query parameter.
//            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/byteParam().(value)
//                  display_name value
//                  documentation ```kotlin\nvalue: Byte\n```
//                   ^^^^ reference semanticdb maven . . kotlin/Byte#
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/byteParam().(value)
//                                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#`<init>`().

/** Returns the specified [value] as a unsigned byte query parameter. */
fun ubyteParam(value: UByte): Expression<UByte> = QueryParameter(value, UByteColumnType())
//  ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ubyteParam().
//             display_name ubyteParam
//             documentation ```kotlin\npublic final fun ubyteParam(value: UByte): Expression<UByte>\n```\n\n----\n\n Returns the specified [value] as a unsigned byte query parameter.
//             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ubyteParam().(value)
//                   display_name value
//                   documentation ```kotlin\nvalue: UByte\n```
//                    ^^^^^ reference semanticdb maven . . kotlin/UByte#
//                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ubyteParam().(value)
//                                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#`<init>`().

/** Returns the specified [value] as a short query parameter. */
fun shortParam(value: Short): Expression<Short> = QueryParameter(value, ShortColumnType())
//  ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/shortParam().
//             display_name shortParam
//             documentation ```kotlin\npublic final fun shortParam(value: Short): Expression<Short>\n```\n\n----\n\n Returns the specified [value] as a short query parameter.
//             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/shortParam().(value)
//                   display_name value
//                   documentation ```kotlin\nvalue: Short\n```
//                    ^^^^^ reference semanticdb maven . . kotlin/Short#
//                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/shortParam().(value)
//                                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#`<init>`().

/** Returns the specified [value] as a unsigned short query parameter. */
fun ushortParam(value: UShort): Expression<UShort> = QueryParameter(value, UShortColumnType())
//  ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ushortParam().
//              display_name ushortParam
//              documentation ```kotlin\npublic final fun ushortParam(value: UShort): Expression<UShort>\n```\n\n----\n\n Returns the specified [value] as a unsigned short query parameter.
//              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ushortParam().(value)
//                    display_name value
//                    documentation ```kotlin\nvalue: UShort\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/UShort#
//                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ushortParam().(value)
//                                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#`<init>`().

/** Returns the specified [value] as an int query parameter. */
fun intParam(value: Int): Expression<Int> = QueryParameter(value, IntegerColumnType())
//  ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/intParam().
//           display_name intParam
//           documentation ```kotlin\npublic final fun intParam(value: Int): Expression<Int>\n```\n\n----\n\n Returns the specified [value] as an int query parameter.
//           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/intParam().(value)
//                 display_name value
//                 documentation ```kotlin\nvalue: Int\n```
//                  ^^^ reference semanticdb maven . . kotlin/Int#
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/intParam().(value)
//                                                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#`<init>`().

/** Returns the specified [value] as a unsigned int query parameter. */
fun uintParam(value: UInt): Expression<UInt> = QueryParameter(value, UIntegerColumnType())
//  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/uintParam().
//            display_name uintParam
//            documentation ```kotlin\npublic final fun uintParam(value: UInt): Expression<UInt>\n```\n\n----\n\n Returns the specified [value] as a unsigned int query parameter.
//            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/uintParam().(value)
//                  display_name value
//                  documentation ```kotlin\nvalue: UInt\n```
//                   ^^^^ reference semanticdb maven . . kotlin/UInt#
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/uintParam().(value)
//                                                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#`<init>`().

/** Returns the specified [value] as a long query parameter. */
fun longParam(value: Long): Expression<Long> = QueryParameter(value, LongColumnType())
//  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/longParam().
//            display_name longParam
//            documentation ```kotlin\npublic final fun longParam(value: Long): Expression<Long>\n```\n\n----\n\n Returns the specified [value] as a long query parameter.
//            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/longParam().(value)
//                  display_name value
//                  documentation ```kotlin\nvalue: Long\n```
//                   ^^^^ reference semanticdb maven . . kotlin/Long#
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/longParam().(value)
//                                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#`<init>`().

/** Returns the specified [value] as a unsigned long query parameter. */
fun ulongParam(value: ULong): Expression<ULong> = QueryParameter(value, ULongColumnType())
//  ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ulongParam().
//             display_name ulongParam
//             documentation ```kotlin\npublic final fun ulongParam(value: ULong): Expression<ULong>\n```\n\n----\n\n Returns the specified [value] as a unsigned long query parameter.
//             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ulongParam().(value)
//                   display_name value
//                   documentation ```kotlin\nvalue: ULong\n```
//                    ^^^^^ reference semanticdb maven . . kotlin/ULong#
//                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ulongParam().(value)
//                                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#`<init>`().

/** Returns the specified [value] as a float query parameter. */
fun floatParam(value: Float): Expression<Float> = QueryParameter(value, FloatColumnType())
//  ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/floatParam().
//             display_name floatParam
//             documentation ```kotlin\npublic final fun floatParam(value: Float): Expression<Float>\n```\n\n----\n\n Returns the specified [value] as a float query parameter.
//             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/floatParam().(value)
//                   display_name value
//                   documentation ```kotlin\nvalue: Float\n```
//                    ^^^^^ reference semanticdb maven . . kotlin/Float#
//                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/floatParam().(value)
//                                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#`<init>`().

/** Returns the specified [value] as a double query parameter. */
fun doubleParam(value: Double): Expression<Double> = QueryParameter(value, DoubleColumnType())
//  ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/doubleParam().
//              display_name doubleParam
//              documentation ```kotlin\npublic final fun doubleParam(value: Double): Expression<Double>\n```\n\n----\n\n Returns the specified [value] as a double query parameter.
//              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/doubleParam().(value)
//                    display_name value
//                    documentation ```kotlin\nvalue: Double\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/Double#
//                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/doubleParam().(value)
//                                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#`<init>`().

/** Returns the specified [value] as a string query parameter. */
fun stringParam(value: String): Expression<String> = QueryParameter(value, TextColumnType())
//  ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/stringParam().
//              display_name stringParam
//              documentation ```kotlin\npublic final fun stringParam(value: String): Expression<String>\n```\n\n----\n\n Returns the specified [value] as a string query parameter.
//              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/stringParam().(value)
//                    display_name value
//                    documentation ```kotlin\nvalue: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/stringParam().(value)
//                                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().

/** Returns the specified [value] as a decimal query parameter. */
fun decimalParam(value: BigDecimal): Expression<BigDecimal> = QueryParameter(value, DecimalColumnType(value.precision(), value.scale()))
//  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/decimalParam().
//               display_name decimalParam
//               documentation ```kotlin\npublic final fun decimalParam(value: BigDecimal): Expression<BigDecimal>\n```\n\n----\n\n Returns the specified [value] as a decimal query parameter.
//               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/decimalParam().(value)
//                     display_name value
//                     documentation ```kotlin\nvalue: BigDecimal\n```
//                      ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
//                                   ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/decimalParam().(value)
//                                                                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                                                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/decimalParam().(value)
//                                                                                                          ^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#precision().
//                                                                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/decimalParam().(value)
//                                                                                                                             ^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#scale().

/**
 * Returns the specified [value] as a blob query parameter.
 *
 * Set [useObjectIdentifier] to `true` if the parameter should be processed using an OID column instead of a
 * BYTEA column. This is only supported by PostgreSQL databases.
 */
fun blobParam(value: ExposedBlob, useObjectIdentifier: Boolean = false): Expression<ExposedBlob> =
//  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/blobParam().
//            display_name blobParam
//            documentation ```kotlin\npublic final fun blobParam(value: ExposedBlob, useObjectIdentifier: Boolean = ...): Expression<ExposedBlob>\n```\n\n----\n\n\n Returns the specified [value] as a blob query parameter.\n\n Set [useObjectIdentifier] to `true` if the parameter should be processed using an OID column instead of a\n BYTEA column. This is only supported by PostgreSQL databases.\n
//            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/blobParam().(value)
//                  display_name value
//                  documentation ```kotlin\nvalue: ExposedBlob\n```
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#
//                                ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/blobParam().(useObjectIdentifier)
//                                                    display_name useObjectIdentifier
//                                                    documentation ```kotlin\nuseObjectIdentifier: Boolean = ...\n```
//                                                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                       ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    QueryParameter(value, BlobColumnType(useObjectIdentifier))
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/blobParam().(value)
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#`<init>`().
//                                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/blobParam().(useObjectIdentifier)

/**
 * Returns the specified [value] as an array query parameter, with elements parsed by the [delegateType] if provided.
 *
 * **Note** If [delegateType] is left `null`, the associated column type will be resolved according to the
 * internal mapping of the element's type in [resolveColumnType].
 *
 * @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.
 */
inline fun <reified T : Any> arrayParam(value: List<T>, delegateType: ColumnType<T>? = null): Expression<List<T>> =
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nreified T : Any\n```
//                           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam().
//                                      display_name arrayParam
//                                      documentation ```kotlin\npublic final inline fun <reified T : Any> arrayParam(value: List<T>, delegateType: ColumnType<T>? = ...): Expression<List<T>>\n```\n\n----\n\n\n Returns the specified [value] as an array query parameter, with elements parsed by the [delegateType] if provided.\n\n **Note** If [delegateType] is left `null`, the associated column type will be resolved according to the\n internal mapping of the element's type in [resolveColumnType].\n\n @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.\n
//                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam().(value)
//                                            display_name value
//                                            documentation ```kotlin\nvalue: List<T>\n```
//                                             ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam().(delegateType)
//                                                                   display_name delegateType
//                                                                   documentation ```kotlin\ndelegateType: ColumnType<T>? = ...\n```
//                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                                                                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    arrayParam(value, 1, delegateType)
//  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam(+1).
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam().(value)
//                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam().(delegateType)

/**
 * Returns the specified [value] as an array query parameter, with elements parsed by the [delegateType] if provided.
 *
 * **Note** If [delegateType] is left `null`, the associated column type will be resolved according to the
 * internal mapping of the element's type in [resolveColumnType].
 *
 * **Note:** Because arrays can have varying dimensions, you must specify the type of elements
 * and the number of dimensions when using array literals.
 * For example, use `arrayParam<Int, List<List<Int>>>(list, dimensions = 2)`.
 *
 * @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.
 */
inline fun <reified T : Any, R : List<Any>> arrayParam(value: R, dimensions: Int, delegateType: ColumnType<T>? = null): Expression<R> {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam(+1).[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nreified T : Any\n```
//                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam(+1).[R]
//                             display_name FirTypeParameterSymbol R
//                             documentation ```kotlin\nR : List<Any>\n```
//                                          ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam(+1).
//                                                     display_name arrayParam
//                                                     documentation ```kotlin\npublic final inline fun <reified T : Any, R : List<Any>> arrayParam(value: R, dimensions: Int, delegateType: ColumnType<T>? = ...): Expression<R>\n```\n\n----\n\n\n Returns the specified [value] as an array query parameter, with elements parsed by the [delegateType] if provided.\n\n **Note** If [delegateType] is left `null`, the associated column type will be resolved according to the\n internal mapping of the element's type in [resolveColumnType].\n\n **Note:** Because arrays can have varying dimensions, you must specify the type of elements\n and the number of dimensions when using array literals.\n For example, use `arrayParam<Int, List<List<Int>>>(list, dimensions = 2)`.\n\n @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.\n
//                                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam(+1).(value)
//                                                           display_name value
//                                                           documentation ```kotlin\nvalue: R\n```
//                                                               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam(+1).(dimensions)
//                                                                          display_name dimensions
//                                                                          documentation ```kotlin\ndimensions: Int\n```
//                                                                           ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam(+1).(delegateType)
//                                                                                             display_name delegateType
//                                                                                             documentation ```kotlin\ndelegateType: ColumnType<T>? = ...\n```
//                                                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                                                                                                                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    @OptIn(InternalApi::class)
    return QueryParameter(value, ArrayColumnType(delegateType ?: resolveColumnType(T::class), dimensions = dimensions))
//         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam(+1).(value)
//                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`().
//                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam(+1).(delegateType)
//                                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/resolveColumnType().
//                                                                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/arrayParam(+1).(dimensions)
}

// Misc.

/**
 * Represents an SQL operator that doesn't perform any operation.
 * This is mainly used to change between column types.
 */
class NoOpConversion<T, S>(
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#
//                   display_name NoOpConversion
//                   documentation ```kotlin\npublic final class NoOpConversion<T, S> : ExpressionWithColumnType<S>\n```\n\n----\n\n\n Represents an SQL operator that doesn't perform any operation.\n This is mainly used to change between column types.\n
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#`<init>`().
//                   display_name NoOpConversion
//                   documentation ```kotlin\npublic constructor<T, S>(expr: Expression<T>, columnType: IColumnType<S & Any>): NoOpConversion<T, S>\n```\n\n----\n\n Returns the expression whose type is being changed.
//                   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#[T]
//                     display_name FirTypeParameterSymbol T
//                     documentation ```kotlin\nT\n```
//                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#[S]
//                        display_name FirTypeParameterSymbol S
//                        documentation ```kotlin\nS\n```
    /** Returns the expression whose type is being changed. */
    val expr: Expression<T>,
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#`<init>`().(expr)
//           display_name expr
//           documentation ```kotlin\nexpr: Expression<T>\n```\n\n----\n\n Returns the expression whose type is being changed.
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#`<init>`().(expr)
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#expr.
//           display_name expr
//           documentation ```kotlin\npublic final val expr: Expression<T>\n```\n\n----\n\n Returns the expression whose type is being changed.
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#getExpr().
//           display_name expr
//           documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n Returns the expression whose type is being changed.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    override val columnType: IColumnType<S & Any>
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#`<init>`().(columnType)
//                          display_name columnType
//                          documentation ```kotlin\ncolumnType: IColumnType<S & Any>\n```
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#`<init>`().(columnType)
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#columnType.
//                          display_name columnType
//                          documentation ```kotlin\npublic open override val columnType: IColumnType<S & Any>\n```
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#getColumnType().
//                          display_name columnType
//                          documentation ```kotlin\npublic get(): IColumnType<S & Any>\n```
//                           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
) : ExpressionWithColumnType<S>() {
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder { +expr }
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#toQueryBuilder().(queryBuilder)
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                 ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#expr.
//                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#getExpr().
}

/** Appends an expression that is wrapped in parentheses (if necessary by [ComplexExpression]). */
private fun QueryBuilder.appendExpression(expr: Expression<*>) {
//                       ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendExpression().
//                                        display_name appendExpression
//                                        documentation ```kotlin\nprivate final fun QueryBuilder.appendExpression(expr: Expression<*>): Unit\n```\n\n----\n\n Appends an expression that is wrapped in parentheses (if necessary by [ComplexExpression]).
//                                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendExpression().(expr)
//                                             display_name expr
//                                             documentation ```kotlin\nexpr: Expression<*>\n```
//                                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    if (expr is ComplexExpression) {
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendExpression().(expr)
        append("(", expr, ")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendExpression().(expr)
    } else {
        append(expr)
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendExpression().(expr)
    }
}

/**
 * Appends a comparison string between [expr1] and [expr2] using the given SQL [op], for when an operator class
 * cannot directly extend the [ComparisonOp] class.
 */
private fun QueryBuilder.appendComparison(expr1: Expression<*>, expr2: Expression<*>, op: String) {
//                       ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendComparison().
//                                        display_name appendComparison
//                                        documentation ```kotlin\nprivate final fun QueryBuilder.appendComparison(expr1: Expression<*>, expr2: Expression<*>, op: String): Unit\n```\n\n----\n\n\n Appends a comparison string between [expr1] and [expr2] using the given SQL [op], for when an operator class\n cannot directly extend the [ComparisonOp] class.\n
//                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendComparison().(expr1)
//                                              display_name expr1
//                                              documentation ```kotlin\nexpr1: Expression<*>\n```
//                                               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendComparison().(expr2)
//                                                                    display_name expr2
//                                                                    documentation ```kotlin\nexpr2: Expression<*>\n```
//                                                                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                    ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendComparison().(op)
//                                                                                       display_name op
//                                                                                       documentation ```kotlin\nop: String\n```
//                                                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
    appendExpression(expr1)
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendExpression().
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendComparison().(expr1)
    +" $op "
//  ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//      ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendComparison().(op)
    appendExpression(expr2)
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendExpression().
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendComparison().(expr2)
}
