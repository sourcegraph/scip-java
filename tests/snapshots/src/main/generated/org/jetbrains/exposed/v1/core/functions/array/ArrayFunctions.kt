package org.jetbrains.exposed.v1.core.functions.array
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/

import org.jetbrains.exposed.v1.core.Expression
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
import org.jetbrains.exposed.v1.core.Function
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
import org.jetbrains.exposed.v1.core.IColumnType
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
import org.jetbrains.exposed.v1.core.QueryBuilder
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
import org.jetbrains.exposed.v1.core.append
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
import org.jetbrains.exposed.v1.core.vendors.H2Dialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
import org.jetbrains.exposed.v1.core.vendors.H2FunctionProvider
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#
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

/**
 * Represents an SQL function that returns the array element stored at the one-based [index] position,
 * or `null` if the stored array itself is null.
 */
class ArrayGet<E, T : List<E>?>(
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#
//             display_name ArrayGet
//             documentation ```kotlin\npublic final class ArrayGet<E, T : List<E>?> : Function<E?>\n```\n\n----\n\n\n Represents an SQL function that returns the array element stored at the one-based [index] position,\n or `null` if the stored array itself is null.\n
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().
//             display_name ArrayGet
//             documentation ```kotlin\npublic constructor<E, T : List<E>?>(expression: Expression<T>, index: Int, columnType: IColumnType<E & Any>): ArrayGet<E, T>\n```\n\n----\n\n The array expression that is accessed.
//             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#[E]
//               display_name FirTypeParameterSymbol E
//               documentation ```kotlin\nE\n```
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : List<E>?\n```
    /** The array expression that is accessed. */
    val expression: Expression<T>,
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(expression)
//                 display_name expression
//                 documentation ```kotlin\nexpression: Expression<T>\n```\n\n----\n\n The array expression that is accessed.
//      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(expression)
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#expression.
//                 display_name expression
//                 documentation ```kotlin\npublic final val expression: Expression<T>\n```\n\n----\n\n The array expression that is accessed.
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#getExpression().
//                 display_name expression
//                 documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n The array expression that is accessed.
//                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The one-based index position at which the stored array is accessed. */
    val index: Int,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(index)
//            display_name index
//            documentation ```kotlin\nindex: Int\n```\n\n----\n\n The one-based index position at which the stored array is accessed.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(index)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#getIndex().
//            display_name index
//            documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n The one-based index position at which the stored array is accessed.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#index.
//            display_name index
//            documentation ```kotlin\npublic final val index: Int\n```\n\n----\n\n The one-based index position at which the stored array is accessed.
//             ^^^ reference semanticdb maven . . kotlin/Int#
    columnType: IColumnType<E & Any>
//  ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(columnType)
//             display_name columnType
//             documentation ```kotlin\ncolumnType: IColumnType<E & Any>\n```
//              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
) : Function<E?>(columnType) {
//  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(columnType)
    override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
        queryBuilder {
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#toQueryBuilder().(queryBuilder)
            append(expression, "[", index.toString(), "]")
//          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#expression.
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#getExpression().
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#getIndex().
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#index.
//                                        ^^^^^^^^ reference semanticdb maven . . kotlin/Int#toString().
        }
    }
}

/**
 * Represents an SQL function that returns a subarray of elements stored from between [lower] and [upper] bounds (inclusive),
 * or `null` if the stored array itself is null.
 */
class ArraySlice<E, T : List<E>?>(
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#
//               display_name ArraySlice
//               documentation ```kotlin\npublic final class ArraySlice<E, T : List<E>?> : Function<T>\n```\n\n----\n\n\n Represents an SQL function that returns a subarray of elements stored from between [lower] and [upper] bounds (inclusive),\n or `null` if the stored array itself is null.\n
//               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().
//               display_name ArraySlice
//               documentation ```kotlin\npublic constructor<E, T : List<E>?>(expression: Expression<T>, lower: Int?, upper: Int?, columnType: IColumnType<T & Any>): ArraySlice<E, T>\n```\n\n----\n\n The array expression from which the subarray is returned.
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#[E]
//                 display_name FirTypeParameterSymbol E
//                 documentation ```kotlin\nE\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : List<E>?\n```
    /** The array expression from which the subarray is returned. */
    val expression: Expression<T>,
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(expression)
//                 display_name expression
//                 documentation ```kotlin\nexpression: Expression<T>\n```\n\n----\n\n The array expression from which the subarray is returned.
//      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(expression)
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#expression.
//                 display_name expression
//                 documentation ```kotlin\npublic final val expression: Expression<T>\n```\n\n----\n\n The array expression from which the subarray is returned.
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getExpression().
//                 display_name expression
//                 documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n The array expression from which the subarray is returned.
//                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    /** The lower bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's lower limit. */
    val lower: Int?,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(lower)
//            display_name lower
//            documentation ```kotlin\nlower: Int?\n```\n\n----\n\n The lower bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's lower limit.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(lower)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getLower().
//            display_name lower
//            documentation ```kotlin\npublic get(): Int?\n```\n\n----\n\n The lower bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's lower limit.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#lower.
//            display_name lower
//            documentation ```kotlin\npublic final val lower: Int?\n```\n\n----\n\n The lower bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's lower limit.
//             ^^^^ reference semanticdb maven . . kotlin/Int#
    /** The upper bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's upper limit. */
    val upper: Int?,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(upper)
//            display_name upper
//            documentation ```kotlin\nupper: Int?\n```\n\n----\n\n The upper bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's upper limit.
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(upper)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getUpper().
//            display_name upper
//            documentation ```kotlin\npublic get(): Int?\n```\n\n----\n\n The upper bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's upper limit.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#upper.
//            display_name upper
//            documentation ```kotlin\npublic final val upper: Int?\n```\n\n----\n\n The upper bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's upper limit.
//             ^^^^ reference semanticdb maven . . kotlin/Int#
    columnType: IColumnType<T & Any>
//  ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(columnType)
//             display_name columnType
//             documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```
//              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
) : Function<T>(columnType) {
//  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(columnType)
    override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#toQueryBuilder().
//                              display_name toQueryBuilder
//                              documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#toQueryBuilder().(queryBuilder)
//                                           display_name queryBuilder
//                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
        val functionProvider = when (currentDialect.h2Mode) {
//          ^^^^^^^^^^^^^^^^ definition local 0
//                           display_name functionProvider
//                           documentation ```kotlin\nlocal val functionProvider: FunctionProvider\n```
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
            H2Dialect.H2CompatibilityMode.PostgreSQL -> H2FunctionProvider
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#PostgreSQL.
            else -> currentDialect.functionProvider
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
        }
        functionProvider.arraySlice(expression, lower, upper, queryBuilder)
//      ^^^^^^^^^^^^^^^^ reference local 0
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#expression.
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getExpression().
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getLower().
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#lower.
//                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getUpper().
//                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#upper.
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#toQueryBuilder().(queryBuilder)
    }
}
