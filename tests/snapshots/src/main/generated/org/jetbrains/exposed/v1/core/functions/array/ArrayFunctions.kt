  package org.jetbrains.exposed.v1.core.functions.array
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/
  
  import org.jetbrains.exposed.v1.core.Expression
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
  import org.jetbrains.exposed.v1.core.Function
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
  import org.jetbrains.exposed.v1.core.IColumnType
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
  import org.jetbrains.exposed.v1.core.QueryBuilder
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
  import org.jetbrains.exposed.v1.core.append
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
  import org.jetbrains.exposed.v1.core.vendors.H2Dialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
  import org.jetbrains.exposed.v1.core.vendors.H2FunctionProvider
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#
  import org.jetbrains.exposed.v1.core.vendors.currentDialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
  import org.jetbrains.exposed.v1.core.vendors.h2Mode
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#
  /**
   * Represents an SQL function that returns the array element stored at the one-based [index] position,
   * or `null` if the stored array itself is null.
   */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#[E]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#[T]
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().
  class ArrayGet<E, T : List<E>?>(
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#
//               display_name ArrayGet
//               documentation ```kotlin\npublic final class ArrayGet<E, T : List<E>?> : Function<E?>\n```\n\n----\n\n\n Represents an SQL function that returns the array element stored at the one-based [index] position,\n or `null` if the stored array itself is null.\n
//               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().
//               display_name ArrayGet
//               documentation ```kotlin\npublic constructor<E, T : List<E>?>(expression: Expression<T>, index: Int, columnType: IColumnType<E & Any>): ArrayGet<E, T>\n```\n\n----\n\n The array expression that is accessed.
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#[E]
//                 display_name FirTypeParameterSymbol E
//                 documentation ```kotlin\nE\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : List<E>?\n```
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#[E]
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(expression)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#expression.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#getExpression().
      /** The array expression that is accessed. */
      val expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```\n\n----\n\n The array expression that is accessed.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(expression)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#expression.
//                   display_name expression
//                   documentation ```kotlin\npublic final val expression: Expression<T>\n```\n\n----\n\n The array expression that is accessed.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#getExpression().
//                   display_name expression
//                   documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n The array expression that is accessed.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(expression)
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#expression.
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#getExpression().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(index)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#index.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#getIndex().
      /** The one-based index position at which the stored array is accessed. */
      val index: Int,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(index)
//              display_name index
//              documentation ```kotlin\nindex: Int\n```\n\n----\n\n The one-based index position at which the stored array is accessed.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(index)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#getIndex().
//              display_name index
//              documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n The one-based index position at which the stored array is accessed.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#index.
//              display_name index
//              documentation ```kotlin\npublic final val index: Int\n```\n\n----\n\n The one-based index position at which the stored array is accessed.
//               ^^^ reference semanticdb maven . . kotlin/Int#
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(index)
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#index.
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#getIndex().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(columnType)
      columnType: IColumnType<E & Any>
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(columnType)
//               display_name columnType
//               documentation ```kotlin\ncolumnType: IColumnType<E & Any>\n```
//                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(columnType)
  ) : Function<E?>(columnType) {
//    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().(columnType)
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#toQueryBuilder().(queryBuilder)
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#toQueryBuilder().(queryBuilder)
              append(expression, "[", index.toString(), "]")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#expression.
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#getExpression().
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#getIndex().
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#index.
//                                          ^^^^^^^^ reference semanticdb maven . . kotlin/Int#toString().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#
  /**
   * Represents an SQL function that returns a subarray of elements stored from between [lower] and [upper] bounds (inclusive),
   * or `null` if the stored array itself is null.
   */
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#[E]
//                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#[T]
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().
  class ArraySlice<E, T : List<E>?>(
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#
//                 display_name ArraySlice
//                 documentation ```kotlin\npublic final class ArraySlice<E, T : List<E>?> : Function<T>\n```\n\n----\n\n\n Represents an SQL function that returns a subarray of elements stored from between [lower] and [upper] bounds (inclusive),\n or `null` if the stored array itself is null.\n
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().
//                 display_name ArraySlice
//                 documentation ```kotlin\npublic constructor<E, T : List<E>?>(expression: Expression<T>, lower: Int?, upper: Int?, columnType: IColumnType<T & Any>): ArraySlice<E, T>\n```\n\n----\n\n The array expression from which the subarray is returned.
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#[E]
//                   display_name FirTypeParameterSymbol E
//                   documentation ```kotlin\nE\n```
//                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#[T]
//                      display_name FirTypeParameterSymbol T
//                      documentation ```kotlin\nT : List<E>?\n```
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#[E]
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(expression)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#expression.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getExpression().
      /** The array expression from which the subarray is returned. */
      val expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```\n\n----\n\n The array expression from which the subarray is returned.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(expression)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#expression.
//                   display_name expression
//                   documentation ```kotlin\npublic final val expression: Expression<T>\n```\n\n----\n\n The array expression from which the subarray is returned.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getExpression().
//                   display_name expression
//                   documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n The array expression from which the subarray is returned.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(expression)
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#expression.
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getExpression().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(lower)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#lower.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getLower().
      /** The lower bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's lower limit. */
      val lower: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(lower)
//              display_name lower
//              documentation ```kotlin\nlower: Int?\n```\n\n----\n\n The lower bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's lower limit.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(lower)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getLower().
//              display_name lower
//              documentation ```kotlin\npublic get(): Int?\n```\n\n----\n\n The lower bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's lower limit.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#lower.
//              display_name lower
//              documentation ```kotlin\npublic final val lower: Int?\n```\n\n----\n\n The lower bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's lower limit.
//               ^^^^ reference semanticdb maven . . kotlin/Int#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(lower)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#lower.
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getLower().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(upper)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#upper.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getUpper().
      /** The upper bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's upper limit. */
      val upper: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(upper)
//              display_name upper
//              documentation ```kotlin\nupper: Int?\n```\n\n----\n\n The upper bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's upper limit.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(upper)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getUpper().
//              display_name upper
//              documentation ```kotlin\npublic get(): Int?\n```\n\n----\n\n The upper bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's upper limit.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#upper.
//              display_name upper
//              documentation ```kotlin\npublic final val upper: Int?\n```\n\n----\n\n The upper bounds (inclusive) of a subarray. If left `null`, the database will use the stored array's upper limit.
//               ^^^^ reference semanticdb maven . . kotlin/Int#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(upper)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#upper.
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getUpper().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(columnType)
      columnType: IColumnType<T & Any>
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(columnType)
//               display_name columnType
//               documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```
//                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(columnType)
  ) : Function<T>(columnType) {
//    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().(columnType)
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#toQueryBuilder().(queryBuilder)
//        ⌄ enclosing_range_start local 0
//                                     ⌄ enclosing_range_start local 1
          val functionProvider = when (currentDialect.h2Mode) {
//            ^^^^^^^^^^^^^^^^ definition local 0
//                             display_name functionProvider
//                             documentation ```kotlin\nlocal val functionProvider: FunctionProvider\n```
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                     ^^^^^^^^^^^^^^^^^^^^^ definition local 1
//                                                           display_name <when-subject>
//                                                           documentation ```kotlin\nlocal val <when-subject>: H2Dialect.H2CompatibilityMode?\n```
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                         ⌃ enclosing_range_end local 1
              H2Dialect.H2CompatibilityMode.PostgreSQL -> H2FunctionProvider
//                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#PostgreSQL.
              else -> currentDialect.functionProvider
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
          }
//        ⌃ enclosing_range_end local 0
          functionProvider.arraySlice(expression, lower, upper, queryBuilder)
//        ^^^^^^^^^^^^^^^^ reference local 0
//                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#expression.
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getExpression().
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getLower().
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#lower.
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#getUpper().
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#upper.
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#toQueryBuilder().(queryBuilder)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#
