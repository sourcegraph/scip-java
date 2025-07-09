package org.jetbrains.exposed.v1.core.ops
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/

import org.jetbrains.exposed.v1.core.*
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
import org.jetbrains.exposed.v1.core.vendors.OracleDialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
import org.jetbrains.exposed.v1.core.vendors.SQLServerDialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#
import org.jetbrains.exposed.v1.core.vendors.currentDialectIfAvailable
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.

/**
 * Represents an SQL operator that checks if [expr] is equals to any element from [list].
 */
abstract class InListOrNotInListBaseOp<V>(
//             ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                                     display_name InListOrNotInListBaseOp
//                                     documentation ```kotlin\npublic abstract class InListOrNotInListBaseOp<V> : Op<Boolean>, ComplexExpression\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr] is equals to any element from [list].\n
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#
//             ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#`<init>`().
//                                     display_name InListOrNotInListBaseOp
//                                     documentation ```kotlin\npublic constructor<V>(expr: Any, list: Iterable<V>, isInList: Boolean = ...): InListOrNotInListBaseOp<V>\n```\n\n----\n\n Returns the expression compared to each element of the list.
//                                     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#[V]
//                                       display_name FirTypeParameterSymbol V
//                                       documentation ```kotlin\nV\n```
    /** Returns the expression compared to each element of the list. */
    open val expr: Any,
//           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#`<init>`().(expr)
//                display_name expr
//                documentation ```kotlin\nexpr: Any\n```\n\n----\n\n Returns the expression compared to each element of the list.
//           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#`<init>`().(expr)
//           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#expr.
//                display_name expr
//                documentation ```kotlin\npublic open val expr: Any\n```\n\n----\n\n Returns the expression compared to each element of the list.
//           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#getExpr().
//                display_name expr
//                documentation ```kotlin\npublic get(): Any\n```\n\n----\n\n Returns the expression compared to each element of the list.
//                 ^^^ reference semanticdb maven . . kotlin/Any#
    /** Returns the query to check against. */
    val list: Iterable<V>,
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#`<init>`().(list)
//           display_name list
//           documentation ```kotlin\nlist: Iterable<V>\n```\n\n----\n\n Returns the query to check against.
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#`<init>`().(list)
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#getList().
//           display_name list
//           documentation ```kotlin\npublic get(): Iterable<V>\n```\n\n----\n\n Returns the query to check against.
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#list.
//           display_name list
//           documentation ```kotlin\npublic final val list: Iterable<V>\n```\n\n----\n\n Returns the query to check against.
//            ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
    /** Returns `false` if the check is inverted, `true` otherwise. */
    val isInList: Boolean = true
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#`<init>`().(isInList)
//               display_name isInList
//               documentation ```kotlin\nisInList: Boolean = ...\n```\n\n----\n\n Returns `false` if the check is inverted, `true` otherwise.
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#`<init>`().(isInList)
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#getIsInList().
//               display_name isInList
//               documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Returns `false` if the check is inverted, `true` otherwise.
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#isInList.
//               display_name isInList
//               documentation ```kotlin\npublic final val isInList: Boolean\n```\n\n----\n\n Returns `false` if the check is inverted, `true` otherwise.
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
) : Op<Boolean>(), ComplexExpression {
//  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#

    protected abstract val columnTypes: List<ExpressionWithColumnType<*>>
//                         ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#columnTypes.
//                                     display_name columnTypes
//                                     documentation ```kotlin\nprotected abstract val columnTypes: List<ExpressionWithColumnType<*>>\n```
//                         ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#getColumnTypes().
//                                     display_name columnTypes
//                                     documentation ```kotlin\nprotected get(): List<ExpressionWithColumnType<*>>\n```
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#

    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#toQueryBuilder().(queryBuilder)
        val iterator = list.iterator()
//          ^^^^^^^^ definition local 0
//                   display_name iterator
//                   documentation ```kotlin\nlocal val iterator: Iterator<V>\n```
//                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#getList().
//                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#list.
//                          ^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#iterator().
        if (!iterator.hasNext()) {
//          ^ reference semanticdb maven . . kotlin/Boolean#not().
//           ^^^^^^^^ reference local 0
//                    ^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#hasNext().
            if (isInList) {
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#getIsInList().
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#isInList.
                +FALSE
//              ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
            } else {
                +TRUE
//              ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
            }
        } else {
            val singleColumn = columnTypes.singleOrNull()
//              ^^^^^^^^^^^^ definition local 1
//                           display_name singleColumn
//                           documentation ```kotlin\nlocal val singleColumn: ExpressionWithColumnType<*>?\n```
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#columnTypes.
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#getColumnTypes().
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull(+19).
            if (singleColumn != null) {
//              ^^^^^^^^^^^^ reference local 1
                append(singleColumn)
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                     ^^^^^^^^^^^^ reference local 1
            } else {
                columnTypes.appendTo(prefix = "(", postfix = ")") { +it }
//              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#columnTypes.
//              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#getColumnTypes().
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                                ^^^^^^^ definition semanticdb maven . . (it)
//                                                                        display_name it
//                                                                        documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                                  ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                                                   ^^ reference semanticdb maven . . (it)
            }

            val firstValue = iterator.next()
//              ^^^^^^^^^^ definition local 2
//                         display_name firstValue
//                         documentation ```kotlin\nlocal val firstValue: V\n```
//                           ^^^^^^^^ reference local 0
//                                    ^^^^ reference semanticdb maven . . kotlin/collections/Iterator#next().

            if (!iterator.hasNext() && currentDialectIfAvailable !is OracleDialect) {
//              ^ reference semanticdb maven . . kotlin/Boolean#not().
//               ^^^^^^^^ reference local 0
//                        ^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#hasNext().
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
                when {
                    isInList -> append(" = ")
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#getIsInList().
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#isInList.
//                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                    else -> append(" != ")
//                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                }
                registerValues(firstValue)
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#registerValues().
//                             ^^^^^^^^^^ reference local 2
            } else {
                when {
                    isInList -> append(" IN (")
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#getIsInList().
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#isInList.
//                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                    else -> append(" NOT IN (")
//                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                }
                registerValues(firstValue)
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#registerValues().
//                             ^^^^^^^^^^ reference local 2
                iterator.forEach { value ->
//              ^^^^^^^^ reference local 0
//                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+9).
//                                 ^^^^^ definition semanticdb maven . . (value)
//                                       display_name value
//                                       documentation ```kotlin\nvalue: List<*>\n```
                    append(", ")
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                    registerValues(value)
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#registerValues().
//                                 ^^^^^ reference semanticdb maven . . (value)
                }
                append(')')
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append().
            }
        }
    }

    protected abstract fun QueryBuilder.registerValues(values: V)
//                                      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#registerValues().
//                                                     display_name registerValues
//                                                     documentation ```kotlin\nprotected abstract fun QueryBuilder.registerValues(values: V): Unit\n\n```
//                                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#registerValues().
//                                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#registerValues().
//                                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#registerValues().
//                                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#registerValues().
//                                                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#registerValues().(values)
//                                                            display_name values
//                                                            documentation ```kotlin\nvalues: V\n```
}

/**
 * Represents an SQL operator that checks if a single-value [expr] is equal to any element from [list].
 *
 * To inverse the operator and check if [expr] is **not** in [list], set [isInList] to `false`.
 */
class SingleValueInListOp<T>(
//    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#
//                        display_name SingleValueInListOp
//                        documentation ```kotlin\npublic final class SingleValueInListOp<T> : InListOrNotInListBaseOp<T>\n```\n\n----\n\n\n Represents an SQL operator that checks if a single-value [expr] is equal to any element from [list].\n\n To inverse the operator and check if [expr] is **not** in [list], set [isInList] to `false`.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#`<init>`().
//                        display_name SingleValueInListOp
//                        documentation ```kotlin\npublic constructor<T>(expr: ExpressionWithColumnType<out T>, list: Iterable<T>, isInList: Boolean = ...): SingleValueInListOp<T>\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT\n```
    override val expr: ExpressionWithColumnType<out T>,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#`<init>`().(expr)
//                    display_name expr
//                    documentation ```kotlin\nexpr: ExpressionWithColumnType<out T>\n```
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#`<init>`().(expr)
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#expr.
//                    display_name expr
//                    documentation ```kotlin\npublic open override val expr: ExpressionWithColumnType<out T>\n```
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#getExpr().
//                    display_name expr
//                    documentation ```kotlin\npublic get(): ExpressionWithColumnType<out T>\n```
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
    list: Iterable<T>,
//  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#`<init>`().(list)
//       display_name list
//       documentation ```kotlin\nlist: Iterable<T>\n```
//        ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
    isInList: Boolean = true
//  ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#`<init>`().(isInList)
//           display_name isInList
//           documentation ```kotlin\nisInList: Boolean = ...\n```
//            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
) : InListOrNotInListBaseOp<T>(expr, list, isInList) {
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#`<init>`().(expr)
//                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#`<init>`().(list)
//                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#`<init>`().(isInList)
    override val columnTypes: List<ExpressionWithColumnType<*>> = listOf(expr)
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#columnTypes.
//                           display_name columnTypes
//                           documentation ```kotlin\nprotected open override val columnTypes: List<ExpressionWithColumnType<*>>\n```
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#getColumnTypes().
//                           display_name columnTypes
//                           documentation ```kotlin\nprotected get(): List<ExpressionWithColumnType<*>>\n```
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#expr.
//                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#getExpr().

    override fun QueryBuilder.registerValues(values: T) {
//                            ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#registerValues().
//                                           display_name registerValues
//                                           documentation ```kotlin\nprotected open override fun QueryBuilder.registerValues(values: T): Unit\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#registerValues().
//                                           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#registerValues().(values)
//                                                  display_name values
//                                                  documentation ```kotlin\nvalues: T\n```
        registerArgument(expr.columnType, values)
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#expr.
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#getExpr().
//                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#registerValues().(values)
    }
}

/**
 * Represents an SQL operator that checks if both values of a `Pair` [expr] match any element from [list].
 *
 * To inverse the operator and check if the `Pair` is **not** in [list], set [isInList] to `false`.
 */
class PairInListOp<T1, T2>(
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#
//                 display_name PairInListOp
//                 documentation ```kotlin\npublic final class PairInListOp<T1, T2> : InListOrNotInListBaseOp<Pair<T1, T2>>\n```\n\n----\n\n\n Represents an SQL operator that checks if both values of a `Pair` [expr] match any element from [list].\n\n To inverse the operator and check if the `Pair` is **not** in [list], set [isInList] to `false`.\n
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#`<init>`().
//                 display_name PairInListOp
//                 documentation ```kotlin\npublic constructor<T1, T2>(expr: Pair<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>>, list: Iterable<Pair<T1, T2>>, isInList: Boolean = ...): PairInListOp<T1, T2>\n```
//                 ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#[T1]
//                    display_name FirTypeParameterSymbol T1
//                    documentation ```kotlin\nT1\n```
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#[T2]
//                        display_name FirTypeParameterSymbol T2
//                        documentation ```kotlin\nT2\n```
    override val expr: Pair<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>>,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#`<init>`().(expr)
//                    display_name expr
//                    documentation ```kotlin\nexpr: Pair<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>>\n```
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#`<init>`().(expr)
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#expr.
//                    display_name expr
//                    documentation ```kotlin\npublic open override val expr: Pair<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>>\n```
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#getExpr().
//                    display_name expr
//                    documentation ```kotlin\npublic get(): Pair<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>>\n```
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#
    list: Iterable<Pair<T1, T2>>,
//  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#`<init>`().(list)
//       display_name list
//       documentation ```kotlin\nlist: Iterable<Pair<T1, T2>>\n```
//        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
    isInList: Boolean = true
//  ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#`<init>`().(isInList)
//           display_name isInList
//           documentation ```kotlin\nisInList: Boolean = ...\n```
//            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
) : InListOrNotInListBaseOp<Pair<T1, T2>>(expr, list, isInList) {
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#`<init>`().(expr)
//                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#`<init>`().(list)
//                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#`<init>`().(isInList)
    override val columnTypes: List<ExpressionWithColumnType<*>> = listOf(expr.first, expr.second)
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#columnTypes.
//                           display_name columnTypes
//                           documentation ```kotlin\nprotected open override val columnTypes: List<ExpressionWithColumnType<*>>\n```
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#getColumnTypes().
//                           display_name columnTypes
//                           documentation ```kotlin\nprotected get(): List<ExpressionWithColumnType<*>>\n```
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf(+1).
//                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#expr.
//                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#getExpr().
//                                                                            ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                                            ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#expr.
//                                                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#getExpr().
//                                                                                        ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                                                                        ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.

    override fun QueryBuilder.registerValues(values: Pair<T1, T2>) {
//                            ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#registerValues().
//                                           display_name registerValues
//                                           documentation ```kotlin\nprotected open override fun QueryBuilder.registerValues(values: Pair<T1, T2>): Unit\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#registerValues().
//                                           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#registerValues().(values)
//                                                  display_name values
//                                                  documentation ```kotlin\nvalues: Pair<T1, T2>\n```
//                                                   ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#
        append("(")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
        registerArgument(expr.first.columnType, values.first)
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#expr.
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#getExpr().
//                            ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                            ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#registerValues().(values)
//                                                     ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                     ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
        append(", ")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
        registerArgument(expr.second.columnType, values.second)
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#expr.
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#getExpr().
//                            ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                            ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#registerValues().(values)
//                                                      ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                                      ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
        append(")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
    }
}

/**
 * Represents an SQL operator that checks if all values of a `Triple` [expr] match any element from [list].
 *
 * To inverse the operator and check if the `Triple` is **not** in [list], set [isInList] to `false`.
 */
class TripleInListOp<T1, T2, T3>(
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#
//                   display_name TripleInListOp
//                   documentation ```kotlin\npublic final class TripleInListOp<T1, T2, T3> : InListOrNotInListBaseOp<Triple<T1, T2, T3>>\n```\n\n----\n\n\n Represents an SQL operator that checks if all values of a `Triple` [expr] match any element from [list].\n\n To inverse the operator and check if the `Triple` is **not** in [list], set [isInList] to `false`.\n
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#`<init>`().
//                   display_name TripleInListOp
//                   documentation ```kotlin\npublic constructor<T1, T2, T3>(expr: Triple<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>, ExpressionWithColumnType<T3>>, list: Iterable<Triple<T1, T2, T3>>, isInList: Boolean = ...): TripleInListOp<T1, T2, T3>\n```
//                   ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#[T1]
//                      display_name FirTypeParameterSymbol T1
//                      documentation ```kotlin\nT1\n```
//                       ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#[T2]
//                          display_name FirTypeParameterSymbol T2
//                          documentation ```kotlin\nT2\n```
//                           ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#[T3]
//                              display_name FirTypeParameterSymbol T3
//                              documentation ```kotlin\nT3\n```
    override val expr: Triple<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>, ExpressionWithColumnType<T3>>,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#`<init>`().(expr)
//                    display_name expr
//                    documentation ```kotlin\nexpr: Triple<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>, ExpressionWithColumnType<T3>>\n```
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#`<init>`().(expr)
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#expr.
//                    display_name expr
//                    documentation ```kotlin\npublic open override val expr: Triple<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>, ExpressionWithColumnType<T3>>\n```
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#getExpr().
//                    display_name expr
//                    documentation ```kotlin\npublic get(): Triple<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>, ExpressionWithColumnType<T3>>\n```
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Triple#
    list: Iterable<Triple<T1, T2, T3>>,
//  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#`<init>`().(list)
//       display_name list
//       documentation ```kotlin\nlist: Iterable<Triple<T1, T2, T3>>\n```
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
    isInList: Boolean = true
//  ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#`<init>`().(isInList)
//           display_name isInList
//           documentation ```kotlin\nisInList: Boolean = ...\n```
//            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
) : InListOrNotInListBaseOp<Triple<T1, T2, T3>>(expr, list, isInList) {
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#`<init>`().(expr)
//                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#`<init>`().(list)
//                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#`<init>`().(isInList)
    override val columnTypes: List<ExpressionWithColumnType<*>> = listOf(expr.first, expr.second, expr.third)
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#columnTypes.
//                           display_name columnTypes
//                           documentation ```kotlin\nprotected open override val columnTypes: List<ExpressionWithColumnType<*>>\n```
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#getColumnTypes().
//                           display_name columnTypes
//                           documentation ```kotlin\nprotected get(): List<ExpressionWithColumnType<*>>\n```
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf(+1).
//                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#expr.
//                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#getExpr().
//                                                                            ^^^^^ reference semanticdb maven . . kotlin/Triple#first.
//                                                                            ^^^^^ reference semanticdb maven . . kotlin/Triple#getFirst().
//                                                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#expr.
//                                                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#getExpr().
//                                                                                        ^^^^^^ reference semanticdb maven . . kotlin/Triple#getSecond().
//                                                                                        ^^^^^^ reference semanticdb maven . . kotlin/Triple#second.
//                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#expr.
//                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#getExpr().
//                                                                                                     ^^^^^ reference semanticdb maven . . kotlin/Triple#getThird().
//                                                                                                     ^^^^^ reference semanticdb maven . . kotlin/Triple#third.

    override fun QueryBuilder.registerValues(values: Triple<T1, T2, T3>) {
//                            ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#registerValues().
//                                           display_name registerValues
//                                           documentation ```kotlin\nprotected open override fun QueryBuilder.registerValues(values: Triple<T1, T2, T3>): Unit\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#registerValues().
//                                           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#registerValues().(values)
//                                                  display_name values
//                                                  documentation ```kotlin\nvalues: Triple<T1, T2, T3>\n```
//                                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Triple#
        append("(")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
        registerArgument(expr.first.columnType, values.first)
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#expr.
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#getExpr().
//                            ^^^^^ reference semanticdb maven . . kotlin/Triple#first.
//                            ^^^^^ reference semanticdb maven . . kotlin/Triple#getFirst().
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#registerValues().(values)
//                                                     ^^^^^ reference semanticdb maven . . kotlin/Triple#first.
//                                                     ^^^^^ reference semanticdb maven . . kotlin/Triple#getFirst().
        append(", ")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
        registerArgument(expr.second.columnType, values.second)
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#expr.
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#getExpr().
//                            ^^^^^^ reference semanticdb maven . . kotlin/Triple#getSecond().
//                            ^^^^^^ reference semanticdb maven . . kotlin/Triple#second.
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#registerValues().(values)
//                                                      ^^^^^^ reference semanticdb maven . . kotlin/Triple#getSecond().
//                                                      ^^^^^^ reference semanticdb maven . . kotlin/Triple#second.
        append(", ")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
        registerArgument(expr.third.columnType, values.third)
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#expr.
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#getExpr().
//                            ^^^^^ reference semanticdb maven . . kotlin/Triple#getThird().
//                            ^^^^^ reference semanticdb maven . . kotlin/Triple#third.
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#registerValues().(values)
//                                                     ^^^^^ reference semanticdb maven . . kotlin/Triple#getThird().
//                                                     ^^^^^ reference semanticdb maven . . kotlin/Triple#third.
        append(")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
    }
}

/**
 * Represents an SQL operator that checks if all columns of a `List` [expr] match any of the lists of
 * values from [list].
 *
 * To inverse the operator and check if the `List` of columns is **not** in [list], set [isInList] to `false`.
 */
class MultipleInListOp(
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#
//                     display_name MultipleInListOp
//                     documentation ```kotlin\npublic final class MultipleInListOp : InListOrNotInListBaseOp<List<*>>\n```\n\n----\n\n\n Represents an SQL operator that checks if all columns of a `List` [expr] match any of the lists of\n values from [list].\n\n To inverse the operator and check if the `List` of columns is **not** in [list], set [isInList] to `false`.\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#`<init>`().
//                     display_name MultipleInListOp
//                     documentation ```kotlin\npublic constructor(expr: List<Column<*>>, list: Iterable<List<*>>, isInList: Boolean = ...): MultipleInListOp\n```
    override val expr: List<Column<*>>,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#`<init>`().(expr)
//                    display_name expr
//                    documentation ```kotlin\nexpr: List<Column<*>>\n```
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#`<init>`().(expr)
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#expr.
//                    display_name expr
//                    documentation ```kotlin\npublic open override val expr: List<Column<*>>\n```
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#getExpr().
//                    display_name expr
//                    documentation ```kotlin\npublic get(): List<Column<*>>\n```
//                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
    list: Iterable<List<*>>,
//  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#`<init>`().(list)
//       display_name list
//       documentation ```kotlin\nlist: Iterable<List<*>>\n```
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
    isInList: Boolean = true
//  ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#`<init>`().(isInList)
//           display_name isInList
//           documentation ```kotlin\nisInList: Boolean = ...\n```
//            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
) : InListOrNotInListBaseOp<List<*>>(expr, list, isInList) {
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#`<init>`().(expr)
//                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#`<init>`().(list)
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#`<init>`().(isInList)
    override val columnTypes: List<Column<*>> = expr
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#columnTypes.
//                           display_name columnTypes
//                           documentation ```kotlin\nprotected open override val columnTypes: List<Column<*>>\n```
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#getColumnTypes().
//                           display_name columnTypes
//                           documentation ```kotlin\nprotected get(): List<Column<*>>\n```
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#expr.
//                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#getExpr().

    override fun QueryBuilder.registerValues(values: List<*>) {
//                            ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#registerValues().
//                                           display_name registerValues
//                                           documentation ```kotlin\nprotected open override fun QueryBuilder.registerValues(values: List<*>): Unit\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#registerValues().
//                                           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#registerValues().(values)
//                                                  display_name values
//                                                  documentation ```kotlin\nvalues: List<*>\n```
//                                                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        append("(")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
        expr.forEachIndexed { i, expression ->
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#expr.
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#getExpr().
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/forEachIndexed(+9).
//                            ^ definition semanticdb maven . . (i)
//                              display_name i
//                              documentation ```kotlin\ni: Int\n```
//                               ^^^^^^^^^^ definition semanticdb maven . . (expression)
//                                          display_name expression
//                                          documentation ```kotlin\nexpression: Column<*>\n```
            registerArgument(expression.columnType, values[i])
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
//                           ^^^^^^^^^^ reference semanticdb maven . . (expression)
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#registerValues().(values)
//                                                  ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#get().
//                                                         ^ reference semanticdb maven . . (i)
            if (i != values.lastIndex) append(", ")
//              ^ reference semanticdb maven . . (i)
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#registerValues().(values)
//                          ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/getLastIndex().
//                          ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/lastIndex.
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
        }
        append(")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
    }

    override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
        // SQL Server does not support IN operator with tuples (or any more than 1 expression on the left-hand side)
        if (currentDialectIfAvailable !is SQLServerDialect) return super.toQueryBuilder(queryBuilder)
//          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
//                                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#toQueryBuilder().
//                                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#toQueryBuilder().(queryBuilder)

        queryBuilder {
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#toQueryBuilder().(queryBuilder)
            val iterator = list.iterator()
//              ^^^^^^^^ definition local 3
//                       display_name iterator
//                       documentation ```kotlin\nlocal val iterator: Iterator<List<*>>\n```
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#getList().
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#list.
//                              ^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#iterator().
            if (!iterator.hasNext()) {
//              ^ reference semanticdb maven . . kotlin/Boolean#not().
//               ^^^^^^^^ reference local 3
//                        ^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#hasNext().
                if (isInList) {
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#getIsInList().
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#isInList.
                    +FALSE
//                  ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
                } else {
                    +TRUE
//                  ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
                }
            } else {
                // Generates compound AND & OR operators for each values list:
                // WHERE
                //     ((tester.num_1 = 0) AND (tester.num_2 = 0.0) AND (tester.num_3 = '0') AND (tester.num_4 = 0)) OR
                //     ((tester.num_1 = 1) AND (tester.num_2 = 1.0) AND (tester.num_3 = '1') AND (tester.num_4 = 1)) OR
                //     ((tester.num_1 = 2) AND (tester.num_2 = 2.0) AND (tester.num_3 = '2') AND (tester.num_4 = 2))

                // Alternative: EXISTS (SELECT * FROM (VALUES (...), (...), ...) v(...) WHERE v.?=? AND ...)
                // Built-in exists(AbstractQuery) cannot be used because above row value constructors are not supported

                val valueEqualityOps = mutableListOf<Op<Boolean>>()
//                  ^^^^^^^^^^^^^^^^ definition local 4
//                                   display_name valueEqualityOps
//                                   documentation ```kotlin\nlocal val valueEqualityOps: MutableList<Op<Boolean>>\n```
//                                     ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().

                iterator.forEach { value ->
//              ^^^^^^^^ reference local 3
//                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+9).
//                                 ^^^^^ definition semanticdb maven . . (value)
//                                       display_name value
//                                       documentation ```kotlin\nvalue: List<*>\n```
                    val valueEqualityOp = build {
//                      ^^^^^^^^^^^^^^^ definition local 5
//                                      display_name valueEqualityOp
//                                      documentation ```kotlin\nlocal val valueEqualityOp: Op<Boolean>\n```
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion#build().
                        expr.zip(value).map { (column, value) ->
//                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#expr.
//                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#getExpr().
//                           ^^^ reference semanticdb maven . . kotlin/collections/zip(+54).
//                               ^^^^^ reference semanticdb maven . . (value)
//                                      ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                            ^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                            display_name <destruct>
//                                                            documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                             ^^^^^^ definition local 6
//                                                    display_name column
//                                                    documentation ```kotlin\nlocal val column: Column<*>\n```
//                                             ^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                             ^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                     ^^^^^ definition local 7
//                                                           display_name value
//                                                           documentation ```kotlin\nlocal val value: Any?\n```
//                                                     ^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                     ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
                            build { EqOp(column, column.wrap(value)) }
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#Companion#build().
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#`<init>`().
//                                       ^^^^^^ reference local 6
//                                               ^^^^^^ reference local 6
//                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                           ^^^^^ reference local 7
                        }.compoundAnd()
//                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/compoundAnd().
                    }
                    valueEqualityOps.add(if (isInList) valueEqualityOp else not(valueEqualityOp))
//                  ^^^^^^^^^^^^^^^^ reference local 4
//                                   ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#getIsInList().
//                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#isInList.
//                                                     ^^^^^^^^^^^^^^^ reference local 5
//                                                                          ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/not().
//                                                                              ^^^^^^^^^^^^^^^ reference local 5
                }

                if (isInList) {
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#getIsInList().
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#isInList.
                    +valueEqualityOps.compoundOr()
//                  ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                   ^^^^^^^^^^^^^^^^ reference local 4
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/compoundOr().
                } else {
                    +valueEqualityOps.compoundAnd()
//                  ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                   ^^^^^^^^^^^^^^^^ reference local 4
//                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/compoundAnd().
                }
            }
        }
    }
}
