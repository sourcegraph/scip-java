  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  import org.jetbrains.exposed.v1.core.vendors.currentDialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
  import java.math.BigDecimal
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/math/
//                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
  /** Interface for functions that can be used as window functions. */
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#[T]
  interface WindowFunction<T> {
//          ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//                         display_name WindowFunction
//                         documentation ```kotlin\npublic abstract interface WindowFunction<T> : Any\n```\n\n----\n\n Interface for functions that can be used as window functions.
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Count#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Max#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Min#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#
//                         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#[T]
//                           display_name FirTypeParameterSymbol T
//                           documentation ```kotlin\nT\n```
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
      /** Returns window function definition. */
      fun over(): WindowFunctionDefinition<T>
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//             display_name over
//             documentation ```kotlin\npublic abstract fun over(): WindowFunctionDefinition<T>\n\n```\n\n----\n\n Returns window function definition.
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Count#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Max#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Min#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#over().
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#over().
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
      /** Appends the SQL representation of this function to the specified [queryBuilder]. */
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().(queryBuilder)
      fun toQueryBuilder(queryBuilder: QueryBuilder)
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                       display_name toQueryBuilder
//                       documentation ```kotlin\npublic abstract fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n\n```\n\n----\n\n Appends the SQL representation of this function to the specified [queryBuilder].
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Count#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Max#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Min#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#toQueryBuilder().
//                       ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().(queryBuilder)
//                                    display_name queryBuilder
//                                    documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().(queryBuilder)
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
  /** Represents an SQL window function with window definition. */
  @Suppress("TooManyFunctions")
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#[T]
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
  class WindowFunctionDefinition<T>(
//      ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
//                               display_name WindowFunctionDefinition
//                               documentation ```kotlin\n@Suppress(...) public final class WindowFunctionDefinition<T> : ExpressionWithColumnType<T>\n```\n\n----\n\n Represents an SQL window function with window definition.
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//      ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                               display_name WindowFunctionDefinition
//                               documentation ```kotlin\npublic constructor<T>(columnType: IColumnType<T & Any>, function: WindowFunction<T>): WindowFunctionDefinition<T>\n```\n\n----\n\n Returns the function that definition is used for.
//                               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#[T]
//                                 display_name FirTypeParameterSymbol T
//                                 documentation ```kotlin\nT\n```
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().(columnType)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#columnType.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getColumnType().
      override val columnType: IColumnType<T & Any>,
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().(columnType)
//                            display_name columnType
//                            documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().(columnType)
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#columnType.
//                            display_name columnType
//                            documentation ```kotlin\npublic open override val columnType: IColumnType<T & Any>\n```
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getColumnType().
//                            display_name columnType
//                            documentation ```kotlin\npublic get(): IColumnType<T & Any>\n```
//                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().(columnType)
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#columnType.
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getColumnType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().(function)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#function.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getFunction().
      /** Returns the function that definition is used for. */
      private val function: WindowFunction<T>
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().(function)
//                         display_name function
//                         documentation ```kotlin\nfunction: WindowFunction<T>\n```\n\n----\n\n Returns the function that definition is used for.
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().(function)
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#function.
//                         display_name function
//                         documentation ```kotlin\nprivate final val function: WindowFunction<T>\n```\n\n----\n\n Returns the function that definition is used for.
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getFunction().
//                         display_name function
//                         documentation ```kotlin\nprivate get(): WindowFunction<T>\n```\n\n----\n\n Returns the function that definition is used for.
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().(function)
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#function.
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getFunction().
  ) : ExpressionWithColumnType<T>() {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#partitionExpressions.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getPartitionExpressions().
      /** Returns expressions in PARTITION BY clause. */
      private val partitionExpressions: List<Expression<*>> = mutableListOf()
//                ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getPartitionExpressions().
//                                     display_name partitionExpressions
//                                     documentation ```kotlin\nprivate get(): List<Expression<*>>\n```\n\n----\n\n Returns expressions in PARTITION BY clause.
//                ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#partitionExpressions.
//                                     display_name partitionExpressions
//                                     documentation ```kotlin\nprivate final val partitionExpressions: List<Expression<*>>\n```\n\n----\n\n Returns expressions in PARTITION BY clause.
//                                      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                            ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#partitionExpressions.
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getPartitionExpressions().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderByExpressions.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getOrderByExpressions().
      /** Returns expressions in ORDER BY clause. */
      private val orderByExpressions: List<Pair<Expression<*>, SortOrder>> = mutableListOf()
//                ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getOrderByExpressions().
//                                   display_name orderByExpressions
//                                   documentation ```kotlin\nprivate get(): List<Pair<Expression<*>, SortOrder>>\n```\n\n----\n\n Returns expressions in ORDER BY clause.
//                ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderByExpressions.
//                                   display_name orderByExpressions
//                                   documentation ```kotlin\nprivate final val orderByExpressions: List<Pair<Expression<*>, SortOrder>>\n```\n\n----\n\n Returns expressions in ORDER BY clause.
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
//                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderByExpressions.
//                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getOrderByExpressions().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#frameClause.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getFrameClause().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#setFrameClause().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#setFrameClause().(value)
      /** Returns window frame clause. */
      private var frameClause: WindowFrameClause? = null
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#frameClause.
//                            display_name frameClause
//                            documentation ```kotlin\nprivate final var frameClause: WindowFrameClause?\n```\n\n----\n\n Returns window frame clause.
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getFrameClause().
//                            display_name frameClause
//                            documentation ```kotlin\nprivate get(): WindowFrameClause?\n```\n\n----\n\n Returns window frame clause.
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#setFrameClause().
//                            display_name frameClause
//                            documentation ```kotlin\nprivate set(value: WindowFrameClause?): Unit\n```\n\n----\n\n Returns window frame clause.
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#setFrameClause().(value)
//                            display_name value
//                            documentation ```kotlin\nvalue: WindowFrameClause?\n```\n\n----\n\n Returns window frame clause.
//                             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#frameClause.
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getFrameClause().
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#setFrameClause().
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#setFrameClause().(value)
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#partitionBy().
      /**
       * Groups the rows of the query by specified [expressions] into partitions,
       * which are processed separately by the window function.
       */
//                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#partitionBy().(expressions)
      fun partitionBy(vararg expressions: Expression<*>): WindowFunctionDefinition<T> = apply {
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#partitionBy().
//                    display_name partitionBy
//                    documentation ```kotlin\npublic final fun partitionBy(vararg expressions: Expression<*>): WindowFunctionDefinition<T>\n```\n\n----\n\n\n Groups the rows of the query by specified [expressions] into partitions,\n which are processed separately by the window function.\n
//                           ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#partitionBy().(expressions)
//                                       display_name expressions
//                                       documentation ```kotlin\nvararg expressions: Expression<*>\n```
//                                        ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
//                                                                                      ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#partitionBy().(expressions)
          (partitionExpressions as MutableList).addAll(expressions)
//         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getPartitionExpressions().
//         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#partitionExpressions.
//                                 ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#
//                                              ^^^^^^ reference semanticdb maven . . kotlin/collections/addAll(+2).
//                                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#partitionBy().(expressions)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#partitionBy().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy().
      /**
       * Defines sorting order by [column] and [order] in which the rows of a partition
       * are processed by the window function.
       */
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy().(column)
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy().(order)
      fun orderBy(column: Expression<*>, order: SortOrder = SortOrder.ASC): WindowFunctionDefinition<T> =
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy().
//                display_name orderBy
//                documentation ```kotlin\npublic final fun orderBy(column: Expression<*>, order: SortOrder = ...): WindowFunctionDefinition<T>\n```\n\n----\n\n\n Defines sorting order by [column] and [order] in which the rows of a partition\n are processed by the window function.\n
//                ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy().(column)
//                       display_name column
//                       documentation ```kotlin\ncolumn: Expression<*>\n```
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy().(order)
//                                             display_name order
//                                             documentation ```kotlin\norder: SortOrder = ...\n```
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#
//                                                                    ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#ASC.
//                                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy().(column)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy().(order)
          orderBy(column to order)
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy(+1).
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy().(column)
//                       ^^ reference semanticdb maven . . kotlin/to().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy().(order)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy(+1).
      /**
       * Defines sorting order by column and order pairs [order] in which the rows of a partition
       * are processed by the window function.
       */
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy(+1).(order)
      fun orderBy(vararg order: Pair<Expression<*>, SortOrder>): WindowFunctionDefinition<T> = apply {
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy(+1).
//                display_name orderBy
//                documentation ```kotlin\npublic final fun orderBy(vararg order: Pair<Expression<*>, SortOrder>): WindowFunctionDefinition<T>\n```\n\n----\n\n\n Defines sorting order by column and order pairs [order] in which the rows of a partition\n are processed by the window function.\n
//                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy(+1).(order)
//                             display_name order
//                             documentation ```kotlin\nvararg order: Pair<Expression<*>, SortOrder>\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
//                                                                                             ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy(+1).(order)
          (orderByExpressions as MutableList).addAll(order)
//         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getOrderByExpressions().
//         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderByExpressions.
//                               ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#
//                                            ^^^^^^ reference semanticdb maven . . kotlin/collections/addAll(+2).
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy(+1).(order)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderBy(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows().
      /**
       * Defines the set of rows constituting the window frame, which is a subset of the current partition.
       * Window frame uses [WindowFrameUnit.ROWS] mode and specified [start] and [end] bounds.
       */
      fun rows(
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows().
//             display_name rows
//             documentation ```kotlin\npublic final fun rows(start: WindowFrameBound, end: WindowFrameBound): WindowFunctionDefinition<T>\n```\n\n----\n\n\n Defines the set of rows constituting the window frame, which is a subset of the current partition.\n Window frame uses [WindowFrameUnit.ROWS] mode and specified [start] and [end] bounds.\n
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows().(start)
          start: WindowFrameBound,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows().(start)
//              display_name start
//              documentation ```kotlin\nstart: WindowFrameBound\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows().(start)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows().(end)
          end: WindowFrameBound
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows().(end)
//            display_name end
//            documentation ```kotlin\nend: WindowFrameBound\n```
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows().(end)
      ): WindowFunctionDefinition<T> = apply {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
//                                     ^^^^^ reference semanticdb maven . . kotlin/apply().
          frameClause = WindowFrameClause(WindowFrameUnit.ROWS, start, end)
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#frameClause.
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getFrameClause().
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#setFrameClause().
//                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#ROWS.
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows().(start)
//                                                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows().(end)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows(+1).
      /**
       * Defines the set of rows constituting the window frame, which is a subset of the current partition.
       * Window frame uses [WindowFrameUnit.ROWS] mode and specified [start] bound.
       */
      fun rows(
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows(+1).
//             display_name rows
//             documentation ```kotlin\npublic final fun rows(start: CurrentOrPreceding): WindowFunctionDefinition<T>\n```\n\n----\n\n\n Defines the set of rows constituting the window frame, which is a subset of the current partition.\n Window frame uses [WindowFrameUnit.ROWS] mode and specified [start] bound.\n
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows(+1).(start)
          start: CurrentOrPreceding
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows(+1).(start)
//              display_name start
//              documentation ```kotlin\nstart: CurrentOrPreceding\n```
//               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrPreceding#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows(+1).(start)
      ): WindowFunctionDefinition<T> = apply {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
//                                     ^^^^^ reference semanticdb maven . . kotlin/apply().
          frameClause = WindowFrameClause(WindowFrameUnit.ROWS, start, null)
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#frameClause.
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getFrameClause().
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#setFrameClause().
//                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#ROWS.
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows(+1).(start)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#rows(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range().
      /**
       * Defines the set of rows constituting the window frame, which is a subset of the current partition.
       * Window frame uses [WindowFrameUnit.RANGE] mode and specified [start] and [end] bounds.
       */
      fun range(
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range().
//              display_name range
//              documentation ```kotlin\npublic final fun range(start: WindowFrameBound, end: WindowFrameBound): WindowFunctionDefinition<T>\n```\n\n----\n\n\n Defines the set of rows constituting the window frame, which is a subset of the current partition.\n Window frame uses [WindowFrameUnit.RANGE] mode and specified [start] and [end] bounds.\n
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range().(start)
          start: WindowFrameBound,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range().(start)
//              display_name start
//              documentation ```kotlin\nstart: WindowFrameBound\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range().(start)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range().(end)
          end: WindowFrameBound
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range().(end)
//            display_name end
//            documentation ```kotlin\nend: WindowFrameBound\n```
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range().(end)
      ): WindowFunctionDefinition<T> = apply {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
//                                     ^^^^^ reference semanticdb maven . . kotlin/apply().
          frameClause = WindowFrameClause(WindowFrameUnit.RANGE, start, end)
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#frameClause.
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getFrameClause().
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#setFrameClause().
//                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#RANGE.
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range().(start)
//                                                                      ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range().(end)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range(+1).
      /**
       * Defines the set of rows constituting the window frame, which is a subset of the current partition.
       * Window frame uses [WindowFrameUnit.RANGE] mode and specified [start] bound.
       */
      fun range(
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range(+1).
//              display_name range
//              documentation ```kotlin\npublic final fun range(start: CurrentOrPreceding): WindowFunctionDefinition<T>\n```\n\n----\n\n\n Defines the set of rows constituting the window frame, which is a subset of the current partition.\n Window frame uses [WindowFrameUnit.RANGE] mode and specified [start] bound.\n
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range(+1).(start)
          start: CurrentOrPreceding
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range(+1).(start)
//              display_name start
//              documentation ```kotlin\nstart: CurrentOrPreceding\n```
//               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrPreceding#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range(+1).(start)
      ): WindowFunctionDefinition<T> = apply {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
//                                     ^^^^^ reference semanticdb maven . . kotlin/apply().
          frameClause = WindowFrameClause(WindowFrameUnit.RANGE, start, null)
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#frameClause.
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getFrameClause().
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#setFrameClause().
//                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#RANGE.
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range(+1).(start)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#range(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups().
      /**
       * Defines the set of rows constituting the window frame, which is a subset of the current partition.
       * Window frame uses [WindowFrameUnit.GROUPS] mode and specified [start] and [end] bounds.
       */
      fun groups(
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups().
//               display_name groups
//               documentation ```kotlin\npublic final fun groups(start: WindowFrameBound, end: WindowFrameBound): WindowFunctionDefinition<T>\n```\n\n----\n\n\n Defines the set of rows constituting the window frame, which is a subset of the current partition.\n Window frame uses [WindowFrameUnit.GROUPS] mode and specified [start] and [end] bounds.\n
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups().(start)
          start: WindowFrameBound,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups().(start)
//              display_name start
//              documentation ```kotlin\nstart: WindowFrameBound\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups().(start)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups().(end)
          end: WindowFrameBound
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups().(end)
//            display_name end
//            documentation ```kotlin\nend: WindowFrameBound\n```
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups().(end)
      ): WindowFunctionDefinition<T> = apply {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
//                                     ^^^^^ reference semanticdb maven . . kotlin/apply().
          frameClause = WindowFrameClause(WindowFrameUnit.GROUPS, start, end)
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#frameClause.
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getFrameClause().
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#setFrameClause().
//                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#GROUPS.
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups().(start)
//                                                                       ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups().(end)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups(+1).
      /**
       * Defines the set of rows constituting the window frame, which is a subset of the current partition.
       * Window frame uses [WindowFrameUnit.GROUPS] mode and specified [start] bound.
       */
      fun groups(
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups(+1).
//               display_name groups
//               documentation ```kotlin\npublic final fun groups(start: CurrentOrPreceding): WindowFunctionDefinition<T>\n```\n\n----\n\n\n Defines the set of rows constituting the window frame, which is a subset of the current partition.\n Window frame uses [WindowFrameUnit.GROUPS] mode and specified [start] bound.\n
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups(+1).(start)
          start: CurrentOrPreceding,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups(+1).(start)
//              display_name start
//              documentation ```kotlin\nstart: CurrentOrPreceding\n```
//               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrPreceding#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups(+1).(start)
      ): WindowFunctionDefinition<T> = apply {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
//                                     ^^^^^ reference semanticdb maven . . kotlin/apply().
          frameClause = WindowFrameClause(WindowFrameUnit.GROUPS, start, null)
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#frameClause.
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getFrameClause().
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#setFrameClause().
//                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#GROUPS.
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups(+1).(start)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#groups(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#toQueryBuilder().(queryBuilder)
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#toQueryBuilder().(queryBuilder)
          function.toQueryBuilder(this)
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#function.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getFunction().
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
          +" OVER("
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          appendPartitionByClause()
//        ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#appendPartitionByClause().
          appendOrderByClause()
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#appendOrderByClause().
//                         ⌄ enclosing_range_start local 0
          frameClause?.let {
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#frameClause.
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getFrameClause().
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#setFrameClause().
//                     ^^^ reference semanticdb maven . . kotlin/let().
//                         ^ definition local 0 3:9
//                           display_name it
//                           documentation ```kotlin\nit: WindowFrameClause\n```
              +" "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              it.toQueryBuilder(this)
//            ^^ reference local 0
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#toQueryBuilder().
          }
//        ⌃ enclosing_range_end local 0
          +")"
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#appendPartitionByClause().
      private fun QueryBuilder.appendPartitionByClause() {
//                             ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#appendPartitionByClause().
//                                                     display_name appendPartitionByClause
//                                                     documentation ```kotlin\nprivate final fun QueryBuilder.appendPartitionByClause(): Unit\n```
          if (partitionExpressions.isNotEmpty()) {
//            ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getPartitionExpressions().
//            ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#partitionExpressions.
//                                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
              +"PARTITION BY "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                          ⌄ enclosing_range_start local 1
              partitionExpressions.appendTo {
//            ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getPartitionExpressions().
//            ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#partitionExpressions.
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                          ^ definition local 1 2:13
//                                            display_name it
//                                            documentation ```kotlin\nit: Expression<*>\n```
                  +((it as? IExpressionAlias<*>)?.aliasOnlyExpression() ?: it)
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                   ^^ reference local 1
//                          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#
//                                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#aliasOnlyExpression().
//                                                                         ^^ reference local 1
              }
//            ⌃ enclosing_range_end local 1
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#appendPartitionByClause().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#appendOrderByClause().
      private fun QueryBuilder.appendOrderByClause() {
//                             ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#appendOrderByClause().
//                                                 display_name appendOrderByClause
//                                                 documentation ```kotlin\nprivate final fun QueryBuilder.appendOrderByClause(): Unit\n```
          if (orderByExpressions.isNotEmpty()) {
//            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getOrderByExpressions().
//            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderByExpressions.
//                               ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
              +" ORDER BY "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                          ⌄ enclosing_range_start local 2
//                                           ⌄ enclosing_range_start local 3
//                                                       ⌄ enclosing_range_start local 4
              orderByExpressions.appendTo { (expression, sortOrder) ->
//            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#getOrderByExpressions().
//            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#orderByExpressions.
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                          ^^^^^^^^^^^^^^^^^^^^^^^ definition local 2
//                                                                  display_name <destruct>
//                                                                  documentation ```kotlin\n<destruct>: Pair<Expression<*>, SortOrder>\n```
//                                           ^^^^^^^^^^ reference local 2
//                                           ^^^^^^^^^^ definition local 3
//                                                      display_name expression
//                                                      documentation ```kotlin\nlocal val expression: Expression<*>\n```
//                                           ^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                       ^^^^^^^^^ reference local 2
//                                                       ^^^^^^^^^ definition local 4
//                                                                 display_name sortOrder
//                                                                 documentation ```kotlin\nlocal val sortOrder: SortOrder\n```
//                                                       ^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                    ⌃ enclosing_range_end local 3
//                                                               ⌃ enclosing_range_end local 4
//                                                                ⌃ enclosing_range_end local 2
                  currentDialect.dataTypeProvider.precessOrderByClause(this, expression, sortOrder)
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().
//                                                                           ^^^^^^^^^^ reference local 3
//                                                                                       ^^^^^^^^^ reference local 4
              }
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#appendOrderByClause().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#
  /** Represents an SQL window function frame clause */
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().
  class WindowFrameClause(
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#
//                        display_name WindowFrameClause
//                        documentation ```kotlin\npublic final class WindowFrameClause : Any\n```\n\n----\n\n Represents an SQL window function frame clause
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().
//                        display_name WindowFrameClause
//                        documentation ```kotlin\npublic constructor(unit: WindowFrameUnit, start: WindowFrameBound, end: WindowFrameBound? = ...): WindowFrameClause\n```\n\n----\n\n Returns frame unit (also called mode).
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().(unit)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#unit.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#getUnit().
      /** Returns frame unit (also called mode). */
      private val unit: WindowFrameUnit,
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().(unit)
//                     display_name unit
//                     documentation ```kotlin\nunit: WindowFrameUnit\n```\n\n----\n\n Returns frame unit (also called mode).
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().(unit)
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#getUnit().
//                     display_name unit
//                     documentation ```kotlin\nprivate get(): WindowFrameUnit\n```\n\n----\n\n Returns frame unit (also called mode).
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#unit.
//                     display_name unit
//                     documentation ```kotlin\nprivate final val unit: WindowFrameUnit\n```\n\n----\n\n Returns frame unit (also called mode).
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().(unit)
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#unit.
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#getUnit().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().(start)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#start.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#getStart().
      /** Returns frame start bound. */
      private val start: WindowFrameBound,
//                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().(start)
//                      display_name start
//                      documentation ```kotlin\nstart: WindowFrameBound\n```\n\n----\n\n Returns frame start bound.
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().(start)
//                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#getStart().
//                      display_name start
//                      documentation ```kotlin\nprivate get(): WindowFrameBound\n```\n\n----\n\n Returns frame start bound.
//                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#start.
//                      display_name start
//                      documentation ```kotlin\nprivate final val start: WindowFrameBound\n```\n\n----\n\n Returns frame start bound.
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().(start)
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#start.
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#getStart().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().(end)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#end.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#getEnd().
      /** Returns frame end bound. */
      private val end: WindowFrameBound? = null
//                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().(end)
//                    display_name end
//                    documentation ```kotlin\nend: WindowFrameBound? = ...\n```\n\n----\n\n Returns frame end bound.
//                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().(end)
//                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#end.
//                    display_name end
//                    documentation ```kotlin\nprivate final val end: WindowFrameBound?\n```\n\n----\n\n Returns frame end bound.
//                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#getEnd().
//                    display_name end
//                    documentation ```kotlin\nprivate get(): WindowFrameBound?\n```\n\n----\n\n Returns frame end bound.
//                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().(end)
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#end.
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#getEnd().
  ) {
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#toQueryBuilder().
      /** Appends the SQL representation of this window function clause to the specified [queryBuilder]. */
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#toQueryBuilder().(queryBuilder)
      fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#toQueryBuilder().
//                       display_name toQueryBuilder
//                       documentation ```kotlin\npublic final fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n Appends the SQL representation of this window function clause to the specified [queryBuilder].
//                       ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#toQueryBuilder().(queryBuilder)
//                                    display_name queryBuilder
//                                    documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#toQueryBuilder().(queryBuilder)
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#toQueryBuilder().(queryBuilder)
          append(unit.name, " ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#getUnit().
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#unit.
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#getName().
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#name.
  
          if (end != null) {
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#end.
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#getEnd().
              +"BETWEEN "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              start.toQueryBuilder(this)
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#getStart().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#start.
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#toQueryBuilder().
              +" AND "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              end.toQueryBuilder(this)
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#end.
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#getEnd().
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#toQueryBuilder().
          } else {
              start.toQueryBuilder(this)
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#getStart().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#start.
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#toQueryBuilder().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameClause#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#`<init>`().
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#values().
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#valueOf().
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#valueOf().(value)
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#entries.
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/getEntries().
  /** Represents an SQL window function frame unit (also called mode). */
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Enum# 10:1
  enum class WindowFrameUnit {
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#
//                           display_name WindowFrameUnit
//                           documentation ```kotlin\npublic final enum class WindowFrameUnit : Enum<WindowFrameUnit>\n```\n\n----\n\n Represents an SQL window function frame unit (also called mode).
//                           relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#`<init>`().
//                           display_name WindowFrameUnit
//                           documentation ```kotlin\nprivate constructor(): WindowFrameUnit\n```\n\n----\n\n Represents an SQL window function frame unit (also called mode).
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#entries.
//                           display_name entries
//                           documentation ```kotlin\npublic final static val entries: EnumEntries<WindowFrameUnit>\n```\n\n----\n\n Represents an SQL window function frame unit (also called mode).
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#valueOf().
//                           display_name valueOf
//                           documentation ```kotlin\npublic final static fun valueOf(value: String): WindowFrameUnit\n```\n\n----\n\n Represents an SQL window function frame unit (also called mode).
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#valueOf().(value)
//                           display_name value
//                           documentation ```kotlin\nvalue: String\n```\n\n----\n\n Represents an SQL window function frame unit (also called mode).
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#values().
//                           display_name values
//                           documentation ```kotlin\npublic final static fun values(): Array<WindowFrameUnit>\n```\n\n----\n\n Represents an SQL window function frame unit (also called mode).
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/getEntries().
//                           display_name entries
//                           documentation ```kotlin\npublic get(): EnumEntries<WindowFrameBoundDirection>\n```\n\n----\n\n Represents window function frame bound direction.
      /** A frame unit based on a fixed amount of rows before and/or after the current row. */
      ROWS,
  
      /** A frame unit consisting of a logical range of rows, based on their value compared to the current row value. */
      RANGE,
  
      /** A frame unit based on a logical range of rows around the current row, but with a distinct value count. */
      GROUPS
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#`<init>`().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#values().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#valueOf().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#valueOf().(value)
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameUnit#entries.
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/getEntries().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
  /** Represents an SQL window function frame start and end bound. */
  sealed interface WindowFrameBound {
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//                                  display_name WindowFrameBound
//                                  documentation ```kotlin\npublic sealed interface WindowFrameBound : Any\n```\n\n----\n\n Represents an SQL window function frame start and end bound.
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrFollowing#
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrPreceding#
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#`<init>`().
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion# 35:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```\n\n----\n\n Returns UNBOUNDED PRECEDING window function frame bound
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#`<init>`(). 35:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): WindowFrameBound.Companion\n```\n\n----\n\n Returns UNBOUNDED PRECEDING window function frame bound
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#unboundedPreceding().
          /** Returns UNBOUNDED PRECEDING window function frame bound */
          fun unboundedPreceding(): UnboundedPrecedingWindowFrameBound {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#unboundedPreceding().
//                               display_name unboundedPreceding
//                               documentation ```kotlin\npublic final fun unboundedPreceding(): UnboundedPrecedingWindowFrameBound\n```\n\n----\n\n Returns UNBOUNDED PRECEDING window function frame bound
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedPrecedingWindowFrameBound#
              return UnboundedPrecedingWindowFrameBound()
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedPrecedingWindowFrameBound#`<init>`().
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#unboundedPreceding().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#unboundedFollowing().
          /** Returns UNBOUNDED FOLLOWING window function frame bound */
          fun unboundedFollowing(): UnboundedFollowingWindowFrameBound {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#unboundedFollowing().
//                               display_name unboundedFollowing
//                               documentation ```kotlin\npublic final fun unboundedFollowing(): UnboundedFollowingWindowFrameBound\n```\n\n----\n\n Returns UNBOUNDED FOLLOWING window function frame bound
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedFollowingWindowFrameBound#
              return UnboundedFollowingWindowFrameBound()
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedFollowingWindowFrameBound#`<init>`().
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#unboundedFollowing().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetPreceding().
          /** Returns [offset] PRECEDING window function frame bound */
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetPreceding().(offset)
          fun offsetPreceding(offset: Expression<Int>): OffsetPrecedingWindowFrameBound {
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetPreceding().
//                            display_name offsetPreceding
//                            documentation ```kotlin\npublic final fun offsetPreceding(offset: Expression<Int>): OffsetPrecedingWindowFrameBound\n```\n\n----\n\n Returns [offset] PRECEDING window function frame bound
//                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetPreceding().(offset)
//                                   display_name offset
//                                   documentation ```kotlin\noffset: Expression<Int>\n```
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetPreceding().(offset)
              return OffsetPrecedingWindowFrameBound(offset)
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#`<init>`().
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetPreceding().(offset)
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetPreceding().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetPreceding(+1).
          /** Returns [offset] PRECEDING window function frame bound */
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetPreceding(+1).(offset)
          fun offsetPreceding(offset: Int): OffsetPrecedingWindowFrameBound {
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetPreceding(+1).
//                            display_name offsetPreceding
//                            documentation ```kotlin\npublic final fun offsetPreceding(offset: Int): OffsetPrecedingWindowFrameBound\n```\n\n----\n\n Returns [offset] PRECEDING window function frame bound
//                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetPreceding(+1).(offset)
//                                   display_name offset
//                                   documentation ```kotlin\noffset: Int\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Int#
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetPreceding(+1).(offset)
              return OffsetPrecedingWindowFrameBound(intLiteral(offset))
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#`<init>`().
//                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().
//                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetPreceding(+1).(offset)
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetPreceding(+1).
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetFollowing().
          /** Returns [offset] FOLLOWING window function frame bound */
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetFollowing().(offset)
          fun offsetFollowing(offset: Expression<Int>): OffsetFollowingWindowFrameBound {
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetFollowing().
//                            display_name offsetFollowing
//                            documentation ```kotlin\npublic final fun offsetFollowing(offset: Expression<Int>): OffsetFollowingWindowFrameBound\n```\n\n----\n\n Returns [offset] FOLLOWING window function frame bound
//                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetFollowing().(offset)
//                                   display_name offset
//                                   documentation ```kotlin\noffset: Expression<Int>\n```
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetFollowing().(offset)
              return OffsetFollowingWindowFrameBound(offset)
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#`<init>`().
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetFollowing().(offset)
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetFollowing().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetFollowing(+1).
          /** Returns [offset] FOLLOWING window function frame bound */
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetFollowing(+1).(offset)
          fun offsetFollowing(offset: Int): OffsetFollowingWindowFrameBound {
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetFollowing(+1).
//                            display_name offsetFollowing
//                            documentation ```kotlin\npublic final fun offsetFollowing(offset: Int): OffsetFollowingWindowFrameBound\n```\n\n----\n\n Returns [offset] FOLLOWING window function frame bound
//                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetFollowing(+1).(offset)
//                                   display_name offset
//                                   documentation ```kotlin\noffset: Int\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Int#
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetFollowing(+1).(offset)
              return OffsetFollowingWindowFrameBound(intLiteral(offset))
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#`<init>`().
//                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().
//                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetFollowing(+1).(offset)
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#offsetFollowing(+1).
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#currentRow().
          /** Returns CURRENT ROW window function frame bound */
          fun currentRow(): CurrentRowWindowFrameBound {
//            ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#currentRow().
//                       display_name currentRow
//                       documentation ```kotlin\npublic final fun currentRow(): CurrentRowWindowFrameBound\n```\n\n----\n\n Returns CURRENT ROW window function frame bound
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#
              return CurrentRowWindowFrameBound
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#currentRow().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#Companion#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#toQueryBuilder().
      /** Appends the SQL representation of this window function clause to the specified [queryBuilder]. */
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#toQueryBuilder().(queryBuilder)
      fun toQueryBuilder(queryBuilder: QueryBuilder)
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#toQueryBuilder().
//                       display_name toQueryBuilder
//                       documentation ```kotlin\npublic abstract fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n\n```\n\n----\n\n Appends the SQL representation of this window function clause to the specified [queryBuilder].
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#toQueryBuilder().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#toQueryBuilder().
//                       ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#toQueryBuilder().(queryBuilder)
//                                    display_name queryBuilder
//                                    documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#toQueryBuilder().(queryBuilder)
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrPreceding#
  /** Represents an SQL window function frame bound that is CURRENT ROW or one of PRECEDING forms. */
  interface CurrentOrPreceding : WindowFrameBound
//          ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrPreceding#
//                             display_name CurrentOrPreceding
//                             documentation ```kotlin\npublic abstract interface CurrentOrPreceding : WindowFrameBound\n```\n\n----\n\n Represents an SQL window function frame bound that is CURRENT ROW or one of PRECEDING forms.
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedPrecedingWindowFrameBound#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrPreceding#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrFollowing#
  /** Represents an SQL window function frame bound that is CURRENT ROW or one of FOLLOWING forms. */
  interface CurrentOrFollowing : WindowFrameBound
//          ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrFollowing#
//                             display_name CurrentOrFollowing
//                             documentation ```kotlin\npublic abstract interface CurrentOrFollowing : WindowFrameBound\n```\n\n----\n\n Represents an SQL window function frame bound that is CURRENT ROW or one of FOLLOWING forms.
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedFollowingWindowFrameBound#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrFollowing#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#
  /**
   * Represents UNBOUNDED PRECEDING or FOLLOWING window function frame bound.
   * [direction] specifies whether first or last partition row will be used.
   */
//                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#`<init>`().
  open class UnboundedWindowFrameBound(
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#
//                                     display_name UnboundedWindowFrameBound
//                                     documentation ```kotlin\npublic open class UnboundedWindowFrameBound : WindowFrameBound\n```\n\n----\n\n\n Represents UNBOUNDED PRECEDING or FOLLOWING window function frame bound.\n [direction] specifies whether first or last partition row will be used.\n
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedFollowingWindowFrameBound#
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedPrecedingWindowFrameBound#
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#`<init>`().
//                                     display_name UnboundedWindowFrameBound
//                                     documentation ```kotlin\npublic constructor(direction: WindowFrameBoundDirection): UnboundedWindowFrameBound\n```
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#`<init>`().(direction)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#direction.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#getDirection().
      private val direction: WindowFrameBoundDirection
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#`<init>`().(direction)
//                          display_name direction
//                          documentation ```kotlin\ndirection: WindowFrameBoundDirection\n```
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#`<init>`().(direction)
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#direction.
//                          display_name direction
//                          documentation ```kotlin\nprivate final val direction: WindowFrameBoundDirection\n```
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#getDirection().
//                          display_name direction
//                          documentation ```kotlin\nprivate get(): WindowFrameBoundDirection\n```
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#`<init>`().(direction)
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#direction.
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#getDirection().
  ) : WindowFrameBound {
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#toQueryBuilder().(queryBuilder)
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#toQueryBuilder().(queryBuilder)
          append("UNBOUNDED ", direction.name)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#direction.
//                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#getDirection().
//                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#getName().
//                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#name.
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedPrecedingWindowFrameBound#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedPrecedingWindowFrameBound#`<init>`().
  /** Represents UNBOUNDED PRECEDING window function frame bound. */
  class UnboundedPrecedingWindowFrameBound :
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedPrecedingWindowFrameBound#
//                                         display_name UnboundedPrecedingWindowFrameBound
//                                         documentation ```kotlin\npublic final class UnboundedPrecedingWindowFrameBound : UnboundedWindowFrameBound, CurrentOrPreceding\n```\n\n----\n\n Represents UNBOUNDED PRECEDING window function frame bound.
//                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrPreceding#
//                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedPrecedingWindowFrameBound#`<init>`().
//                                         display_name UnboundedPrecedingWindowFrameBound
//                                         documentation ```kotlin\npublic constructor(): UnboundedPrecedingWindowFrameBound\n```\n\n----\n\n Represents UNBOUNDED PRECEDING window function frame bound.
      UnboundedWindowFrameBound(WindowFrameBoundDirection.PRECEDING),
//    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#
//                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#PRECEDING.
      CurrentOrPreceding
//    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrPreceding#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedPrecedingWindowFrameBound#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedPrecedingWindowFrameBound#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedFollowingWindowFrameBound#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedFollowingWindowFrameBound#`<init>`().
  /** Represents UNBOUNDED FOLLOWING window function frame bound. */
  class UnboundedFollowingWindowFrameBound :
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedFollowingWindowFrameBound#
//                                         display_name UnboundedFollowingWindowFrameBound
//                                         documentation ```kotlin\npublic final class UnboundedFollowingWindowFrameBound : UnboundedWindowFrameBound, CurrentOrFollowing\n```\n\n----\n\n Represents UNBOUNDED FOLLOWING window function frame bound.
//                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrFollowing#
//                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedFollowingWindowFrameBound#`<init>`().
//                                         display_name UnboundedFollowingWindowFrameBound
//                                         documentation ```kotlin\npublic constructor(): UnboundedFollowingWindowFrameBound\n```\n\n----\n\n Represents UNBOUNDED FOLLOWING window function frame bound.
      UnboundedWindowFrameBound(WindowFrameBoundDirection.FOLLOWING),
//    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedWindowFrameBound#
//                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#FOLLOWING.
      CurrentOrFollowing
//    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrFollowing#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedFollowingWindowFrameBound#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UnboundedFollowingWindowFrameBound#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#
  /**
   * Represents an [offset] PRECEDING or FOLLOWING window function frame bound.
   * [direction] specifies whether previous or next partition rows will be used.
   */
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#`<init>`().
  open class OffsetWindowFrameBound(
//           ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#
//                                  display_name OffsetWindowFrameBound
//                                  documentation ```kotlin\npublic open class OffsetWindowFrameBound : WindowFrameBound\n```\n\n----\n\n\n Represents an [offset] PRECEDING or FOLLOWING window function frame bound.\n [direction] specifies whether previous or next partition rows will be used.\n
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//           ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#`<init>`().
//                                  display_name OffsetWindowFrameBound
//                                  documentation ```kotlin\npublic constructor(offset: Expression<Int>, direction: WindowFrameBoundDirection): OffsetWindowFrameBound\n```
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#`<init>`().(offset)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#offset.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#getOffset().
      private val offset: Expression<Int>,
//                ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#`<init>`().(offset)
//                       display_name offset
//                       documentation ```kotlin\noffset: Expression<Int>\n```
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#`<init>`().(offset)
//                ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#getOffset().
//                       display_name offset
//                       documentation ```kotlin\nprivate get(): Expression<Int>\n```
//                ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#offset.
//                       display_name offset
//                       documentation ```kotlin\nprivate final val offset: Expression<Int>\n```
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#`<init>`().(offset)
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#offset.
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#getOffset().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#`<init>`().(direction)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#direction.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#getDirection().
      private val direction: WindowFrameBoundDirection
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#`<init>`().(direction)
//                          display_name direction
//                          documentation ```kotlin\ndirection: WindowFrameBoundDirection\n```
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#`<init>`().(direction)
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#direction.
//                          display_name direction
//                          documentation ```kotlin\nprivate final val direction: WindowFrameBoundDirection\n```
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#getDirection().
//                          display_name direction
//                          documentation ```kotlin\nprivate get(): WindowFrameBoundDirection\n```
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#`<init>`().(direction)
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#direction.
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#getDirection().
  ) : WindowFrameBound {
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#toQueryBuilder().(queryBuilder)
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#toQueryBuilder().(queryBuilder)
          append(offset, " ", direction.name)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#getOffset().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#offset.
//                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#direction.
//                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#getDirection().
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#getName().
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#name.
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#
  /** Represents [offset] PRECEDING window function frame bound. */
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#`<init>`().
  class OffsetPrecedingWindowFrameBound(
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#
//                                      display_name OffsetPrecedingWindowFrameBound
//                                      documentation ```kotlin\npublic final class OffsetPrecedingWindowFrameBound : OffsetWindowFrameBound, CurrentOrPreceding\n```\n\n----\n\n Represents [offset] PRECEDING window function frame bound.
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrPreceding#
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#`<init>`().
//                                      display_name OffsetPrecedingWindowFrameBound
//                                      documentation ```kotlin\npublic constructor(offset: Expression<Int>): OffsetPrecedingWindowFrameBound\n```
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#`<init>`().(offset)
      offset: Expression<Int>
//    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#`<init>`().(offset)
//           display_name offset
//           documentation ```kotlin\noffset: Expression<Int>\n```
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#`<init>`().(offset)
  ) : OffsetWindowFrameBound(offset, WindowFrameBoundDirection.PRECEDING), CurrentOrPreceding
//    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#`<init>`().(offset)
//                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#PRECEDING.
//                                                                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrPreceding#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#`<init>`().
//                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetPrecedingWindowFrameBound#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#
  /** Represents [offset] FOLLOWING window function frame bound. */
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#`<init>`().
  class OffsetFollowingWindowFrameBound(
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#
//                                      display_name OffsetFollowingWindowFrameBound
//                                      documentation ```kotlin\npublic final class OffsetFollowingWindowFrameBound : OffsetWindowFrameBound, CurrentOrFollowing\n```\n\n----\n\n Represents [offset] FOLLOWING window function frame bound.
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrFollowing#
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#`<init>`().
//                                      display_name OffsetFollowingWindowFrameBound
//                                      documentation ```kotlin\npublic constructor(offset: Expression<Int>): OffsetFollowingWindowFrameBound\n```
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#`<init>`().(offset)
      offset: Expression<Int>
//    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#`<init>`().(offset)
//           display_name offset
//           documentation ```kotlin\noffset: Expression<Int>\n```
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#`<init>`().(offset)
  ) : OffsetWindowFrameBound(offset, WindowFrameBoundDirection.FOLLOWING), CurrentOrFollowing
//    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetWindowFrameBound#
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#`<init>`().(offset)
//                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#FOLLOWING.
//                                                                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrFollowing#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#`<init>`().
//                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/OffsetFollowingWindowFrameBound#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#`<init>`().
  /** Represents an CURRENT ROW window function frame bound. */
  object CurrentRowWindowFrameBound : WindowFrameBound, CurrentOrPreceding, CurrentOrFollowing {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#
//                                  display_name CurrentRowWindowFrameBound
//                                  documentation ```kotlin\npublic final object CurrentRowWindowFrameBound : WindowFrameBound, CurrentOrPreceding, CurrentOrFollowing\n```\n\n----\n\n Represents an CURRENT ROW window function frame bound.
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrFollowing#
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrPreceding#
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#`<init>`().
//                                  display_name CurrentRowWindowFrameBound
//                                  documentation ```kotlin\nprivate constructor(): CurrentRowWindowFrameBound\n```\n\n----\n\n Represents an CURRENT ROW window function frame bound.
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#
//                                                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrPreceding#
//                                                                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentOrFollowing#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBound#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#toQueryBuilder().(queryBuilder)
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#toQueryBuilder().(queryBuilder)
          +"CURRENT ROW"
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CurrentRowWindowFrameBound#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#`<init>`().
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#values().
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#valueOf().
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#valueOf().(value)
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#entries.
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/getEntries().
  /** Represents window function frame bound direction. */
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Enum# 7:1
  enum class WindowFrameBoundDirection {
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#
//                                     display_name WindowFrameBoundDirection
//                                     documentation ```kotlin\npublic final enum class WindowFrameBoundDirection : Enum<WindowFrameBoundDirection>\n```\n\n----\n\n Represents window function frame bound direction.
//                                     relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#`<init>`().
//                                     display_name WindowFrameBoundDirection
//                                     documentation ```kotlin\nprivate constructor(): WindowFrameBoundDirection\n```\n\n----\n\n Represents window function frame bound direction.
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#entries.
//                                     display_name entries
//                                     documentation ```kotlin\npublic final static val entries: EnumEntries<WindowFrameBoundDirection>\n```\n\n----\n\n Represents window function frame bound direction.
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#valueOf().
//                                     display_name valueOf
//                                     documentation ```kotlin\npublic final static fun valueOf(value: String): WindowFrameBoundDirection\n```\n\n----\n\n Represents window function frame bound direction.
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#valueOf().(value)
//                                     display_name value
//                                     documentation ```kotlin\nvalue: String\n```\n\n----\n\n Represents window function frame bound direction.
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#values().
//                                     display_name values
//                                     documentation ```kotlin\npublic final static fun values(): Array<WindowFrameBoundDirection>\n```\n\n----\n\n Represents window function frame bound direction.
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/getEntries().
//                                     display_name entries
//                                     documentation ```kotlin\npublic get(): EnumEntries<WindowFrameBoundDirection>\n```\n\n----\n\n Represents window function frame bound direction.
      /** Gets rows before the current row. */
      PRECEDING,
  
      /** Gets rows after the current row. */
      FOLLOWING
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#`<init>`().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#values().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#valueOf().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#valueOf().(value)
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFrameBoundDirection#entries.
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/getEntries().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#`<init>`().
  /** Represents an SQL function that returns the number of the current row within its partition, counting from 1. */
  class RowNumber : WindowFunction<Long> {
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#
//                display_name RowNumber
//                documentation ```kotlin\npublic final class RowNumber : WindowFunction<Long>\n```\n\n----\n\n Represents an SQL function that returns the number of the current row within its partition, counting from 1.
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#`<init>`().
//                display_name RowNumber
//                documentation ```kotlin\npublic constructor(): RowNumber\n```\n\n----\n\n Represents an SQL function that returns the number of the current row within its partition, counting from 1.
//                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#toQueryBuilder().(queryBuilder)
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#toQueryBuilder().(queryBuilder)
          +"ROW_NUMBER()"
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#over().
      override fun over(): WindowFunctionDefinition<Long> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<Long>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(LongColumnType(), this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#`<init>`().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#`<init>`().
  /**
   * Represents an SQL function that returns the rank of the current row, with gaps; that is, the row_number
   * of the first row in its peer group.
   */
  class Rank : WindowFunction<Long> {
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#
//           display_name Rank
//           documentation ```kotlin\npublic final class Rank : WindowFunction<Long>\n```\n\n----\n\n\n Represents an SQL function that returns the rank of the current row, with gaps; that is, the row_number\n of the first row in its peer group.\n
//           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#`<init>`().
//           display_name Rank
//           documentation ```kotlin\npublic constructor(): Rank\n```\n\n----\n\n\n Represents an SQL function that returns the rank of the current row, with gaps; that is, the row_number\n of the first row in its peer group.\n
//             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#toQueryBuilder().(queryBuilder)
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#toQueryBuilder().(queryBuilder)
          +"RANK()"
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#over().
      override fun over(): WindowFunctionDefinition<Long> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<Long>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(LongColumnType(), this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#`<init>`().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#`<init>`().
  /**
   * Represents an SQL function that returns the rank of the current row, without gaps; this function effectively
   * counts peer groups.
   */
  class DenseRank : WindowFunction<Long> {
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#
//                display_name DenseRank
//                documentation ```kotlin\npublic final class DenseRank : WindowFunction<Long>\n```\n\n----\n\n\n Represents an SQL function that returns the rank of the current row, without gaps; this function effectively\n counts peer groups.\n
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#`<init>`().
//                display_name DenseRank
//                documentation ```kotlin\npublic constructor(): DenseRank\n```\n\n----\n\n\n Represents an SQL function that returns the rank of the current row, without gaps; this function effectively\n counts peer groups.\n
//                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#toQueryBuilder().(queryBuilder)
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#toQueryBuilder().(queryBuilder)
          +"DENSE_RANK()"
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#over().
      override fun over(): WindowFunctionDefinition<Long> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<Long>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(LongColumnType(), this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#`<init>`().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#
  /**
   * Represents an SQL function that returns the relative rank of the current row, that is (rank - 1) /
   * (total partition rows - 1). The value thus ranges from 0 to 1 inclusive.
   * [scale] represents decimal digits count in the fractional part of result.
   */
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#`<init>`().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#`<init>`().(scale)
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#scale.
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#getScale().
  class PercentRank(private val scale: Int = 2) : WindowFunction<BigDecimal> {
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#
//                  display_name PercentRank
//                  documentation ```kotlin\npublic final class PercentRank : WindowFunction<BigDecimal>\n```\n\n----\n\n\n Represents an SQL function that returns the relative rank of the current row, that is (rank - 1)\n (total partition rows - 1). The value thus ranges from 0 to 1 inclusive.\n [scale] represents decimal digits count in the fractional part of result.\n
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#`<init>`().
//                  display_name PercentRank
//                  documentation ```kotlin\npublic constructor(scale: Int = ...): PercentRank\n```
//                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#`<init>`().(scale)
//                                    display_name scale
//                                    documentation ```kotlin\nscale: Int = ...\n```
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#`<init>`().(scale)
//                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#getScale().
//                                    display_name scale
//                                    documentation ```kotlin\nprivate get(): Int\n```
//                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#scale.
//                                    display_name scale
//                                    documentation ```kotlin\nprivate final val scale: Int\n```
//                                     ^^^ reference semanticdb maven . . kotlin/Int#
//                                                ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#`<init>`().(scale)
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#scale.
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#getScale().
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#toQueryBuilder().(queryBuilder)
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#toQueryBuilder().(queryBuilder)
          +"PERCENT_RANK()"
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#over().
      override fun over(): WindowFunctionDefinition<BigDecimal> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<BigDecimal>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(DecimalColumnType(Int.MAX_VALUE, scale), this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                                                              ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                              ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#getScale().
//                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#scale.
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#
  /**
   * Represents an SQL function that Returns the cumulative distribution, that is (number of partition rows preceding
   * or peers with current row) / (total partition rows). The value thus ranges from 1/N to 1.
   * [scale] represents decimal digits count in the fractional part of result.
   */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#`<init>`().
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#`<init>`().(scale)
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#scale.
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#getScale().
  class CumeDist(private val scale: Int = 2) : WindowFunction<BigDecimal> {
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#
//               display_name CumeDist
//               documentation ```kotlin\npublic final class CumeDist : WindowFunction<BigDecimal>\n```\n\n----\n\n\n Represents an SQL function that Returns the cumulative distribution, that is (number of partition rows preceding\n or peers with current row) / (total partition rows). The value thus ranges from 1/N to 1.\n [scale] represents decimal digits count in the fractional part of result.\n
//               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#`<init>`().
//               display_name CumeDist
//               documentation ```kotlin\npublic constructor(scale: Int = ...): CumeDist\n```
//                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#`<init>`().(scale)
//                                 display_name scale
//                                 documentation ```kotlin\nscale: Int = ...\n```
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#`<init>`().(scale)
//                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#getScale().
//                                 display_name scale
//                                 documentation ```kotlin\nprivate get(): Int\n```
//                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#scale.
//                                 display_name scale
//                                 documentation ```kotlin\nprivate final val scale: Int\n```
//                                  ^^^ reference semanticdb maven . . kotlin/Int#
//                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#`<init>`().(scale)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#scale.
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#getScale().
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#toQueryBuilder().(queryBuilder)
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#toQueryBuilder().(queryBuilder)
          +"CUME_DIST()"
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#over().
      override fun over(): WindowFunctionDefinition<BigDecimal> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<BigDecimal>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(DecimalColumnType(Int.MAX_VALUE, scale), this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                                                              ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                              ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#getScale().
//                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#scale.
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#
  /** Returns an integer ranging from 1 to the argument value, dividing the partition as equally as possible. */
//           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#`<init>`().
  class Ntile(
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#
//            display_name Ntile
//            documentation ```kotlin\npublic final class Ntile : WindowFunction<Int>\n```\n\n----\n\n Returns an integer ranging from 1 to the argument value, dividing the partition as equally as possible.
//            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#`<init>`().
//            display_name Ntile
//            documentation ```kotlin\npublic constructor(numBuckets: ExpressionWithColumnType<Int>): Ntile\n```\n\n----\n\n Returns number of buckets.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#`<init>`().(numBuckets)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#numBuckets.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#getNumBuckets().
      /** Returns number of buckets. */
      val numBuckets: ExpressionWithColumnType<Int>
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#`<init>`().(numBuckets)
//                   display_name numBuckets
//                   documentation ```kotlin\nnumBuckets: ExpressionWithColumnType<Int>\n```\n\n----\n\n Returns number of buckets.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#`<init>`().(numBuckets)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#getNumBuckets().
//                   display_name numBuckets
//                   documentation ```kotlin\npublic get(): ExpressionWithColumnType<Int>\n```\n\n----\n\n Returns number of buckets.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#numBuckets.
//                   display_name numBuckets
//                   documentation ```kotlin\npublic final val numBuckets: ExpressionWithColumnType<Int>\n```\n\n----\n\n Returns number of buckets.
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#`<init>`().(numBuckets)
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#numBuckets.
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#getNumBuckets().
  ) : WindowFunction<Int> {
//    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#toQueryBuilder().(queryBuilder)
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#toQueryBuilder().(queryBuilder)
          append("NTILE(", numBuckets, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#getNumBuckets().
//                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#numBuckets.
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#over().
      override fun over(): WindowFunctionDefinition<Int> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<Int>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(IntegerColumnType(), this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#`<init>`().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#
  /**
   * Represents an SQL function that returns value evaluated at the row that is [offset] rows before the current row
   * within the partition; if there is no such row, instead returns [defaultValue].
   */
//          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#[T]
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().
  class Lag<T>(
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#
//          display_name Lag
//          documentation ```kotlin\npublic final class Lag<T> : WindowFunction<T?>\n```\n\n----\n\n\n Represents an SQL function that returns value evaluated at the row that is [offset] rows before the current row\n within the partition; if there is no such row, instead returns [defaultValue].\n
//          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().
//          display_name Lag
//          documentation ```kotlin\npublic constructor<T>(expr: ExpressionWithColumnType<T>, offset: ExpressionWithColumnType<Int> = ..., defaultValue: ExpressionWithColumnType<T>? = ...): Lag<T>\n```\n\n----\n\n Returns the expression from which the rows are counted.
//          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#[T]
//            display_name FirTypeParameterSymbol T
//            documentation ```kotlin\nT\n```
//          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#getExpr().
      /** Returns the expression from which the rows are counted. */
      val expr: ExpressionWithColumnType<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: ExpressionWithColumnType<T>\n```\n\n----\n\n Returns the expression from which the rows are counted.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: ExpressionWithColumnType<T>\n```\n\n----\n\n Returns the expression from which the rows are counted.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): ExpressionWithColumnType<T>\n```\n\n----\n\n Returns the expression from which the rows are counted.
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().(expr)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#expr.
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#getExpr().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().(offset)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#offset.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#getOffset().
      /** Returns number of rows before the current row. */
      val offset: ExpressionWithColumnType<Int> = intLiteral(1),
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().(offset)
//               display_name offset
//               documentation ```kotlin\noffset: ExpressionWithColumnType<Int> = ...\n```\n\n----\n\n Returns number of rows before the current row.
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().(offset)
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#getOffset().
//               display_name offset
//               documentation ```kotlin\npublic get(): ExpressionWithColumnType<Int>\n```\n\n----\n\n Returns number of rows before the current row.
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#offset.
//               display_name offset
//               documentation ```kotlin\npublic final val offset: ExpressionWithColumnType<Int>\n```\n\n----\n\n Returns number of rows before the current row.
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().(offset)
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#offset.
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#getOffset().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().(defaultValue)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#defaultValue.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#getDefaultValue().
      /** Returns value that is used if no row found at such offset. */
      val defaultValue: ExpressionWithColumnType<T>? = null
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().(defaultValue)
//                     display_name defaultValue
//                     documentation ```kotlin\ndefaultValue: ExpressionWithColumnType<T>? = ...\n```\n\n----\n\n Returns value that is used if no row found at such offset.
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().(defaultValue)
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#defaultValue.
//                     display_name defaultValue
//                     documentation ```kotlin\npublic final val defaultValue: ExpressionWithColumnType<T>?\n```\n\n----\n\n Returns value that is used if no row found at such offset.
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#getDefaultValue().
//                     display_name defaultValue
//                     documentation ```kotlin\npublic get(): ExpressionWithColumnType<T>?\n```\n\n----\n\n Returns value that is used if no row found at such offset.
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().(defaultValue)
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#defaultValue.
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#getDefaultValue().
  ) : WindowFunction<T?> {
//    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#toQueryBuilder().(queryBuilder)
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#toQueryBuilder().(queryBuilder)
          append("LAG(", expr, ", ", offset)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#expr.
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#getExpr().
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#getOffset().
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#offset.
          if (defaultValue != null) append(", ", defaultValue)
//            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#defaultValue.
//            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#getDefaultValue().
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#defaultValue.
//                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#getDefaultValue().
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#over().
      override fun over(): WindowFunctionDefinition<T?> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<T?>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(expr.columnType, this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#expr.
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#getExpr().
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#
  /**
   * Represents an SQL function that returns value evaluated at the row that is [offset] rows after the current row
   * within the partition; if there is no such row, instead returns [defaultValue].
   */
//           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#[T]
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().
  class Lead<T>(
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#
//           display_name Lead
//           documentation ```kotlin\npublic final class Lead<T> : WindowFunction<T?>\n```\n\n----\n\n\n Represents an SQL function that returns value evaluated at the row that is [offset] rows after the current row\n within the partition; if there is no such row, instead returns [defaultValue].\n
//           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().
//           display_name Lead
//           documentation ```kotlin\npublic constructor<T>(expr: ExpressionWithColumnType<T>, offset: ExpressionWithColumnType<Int> = ..., defaultValue: ExpressionWithColumnType<T>? = ...): Lead<T>\n```\n\n----\n\n Returns the expression from which the rows are counted.
//           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#[T]
//             display_name FirTypeParameterSymbol T
//             documentation ```kotlin\nT\n```
//           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#getExpr().
      /** Returns the expression from which the rows are counted. */
      val expr: ExpressionWithColumnType<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: ExpressionWithColumnType<T>\n```\n\n----\n\n Returns the expression from which the rows are counted.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: ExpressionWithColumnType<T>\n```\n\n----\n\n Returns the expression from which the rows are counted.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): ExpressionWithColumnType<T>\n```\n\n----\n\n Returns the expression from which the rows are counted.
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().(expr)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#expr.
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#getExpr().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().(offset)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#offset.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#getOffset().
      /** Returns number of rows before the current row. */
      val offset: ExpressionWithColumnType<Int> = intLiteral(1),
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().(offset)
//               display_name offset
//               documentation ```kotlin\noffset: ExpressionWithColumnType<Int> = ...\n```\n\n----\n\n Returns number of rows before the current row.
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().(offset)
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#getOffset().
//               display_name offset
//               documentation ```kotlin\npublic get(): ExpressionWithColumnType<Int>\n```\n\n----\n\n Returns number of rows before the current row.
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#offset.
//               display_name offset
//               documentation ```kotlin\npublic final val offset: ExpressionWithColumnType<Int>\n```\n\n----\n\n Returns number of rows before the current row.
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().(offset)
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#offset.
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#getOffset().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().(defaultValue)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#defaultValue.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#getDefaultValue().
      /** Returns value that is used if no row found at such offset. */
      val defaultValue: ExpressionWithColumnType<T>? = null
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().(defaultValue)
//                     display_name defaultValue
//                     documentation ```kotlin\ndefaultValue: ExpressionWithColumnType<T>? = ...\n```\n\n----\n\n Returns value that is used if no row found at such offset.
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().(defaultValue)
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#defaultValue.
//                     display_name defaultValue
//                     documentation ```kotlin\npublic final val defaultValue: ExpressionWithColumnType<T>?\n```\n\n----\n\n Returns value that is used if no row found at such offset.
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#getDefaultValue().
//                     display_name defaultValue
//                     documentation ```kotlin\npublic get(): ExpressionWithColumnType<T>?\n```\n\n----\n\n Returns value that is used if no row found at such offset.
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().(defaultValue)
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#defaultValue.
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#getDefaultValue().
  ) : WindowFunction<T?> {
//    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#toQueryBuilder().(queryBuilder)
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#toQueryBuilder().(queryBuilder)
          append("LEAD(", expr, ", ", offset)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#expr.
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#getExpr().
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#getOffset().
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#offset.
          if (defaultValue != null) append(", ", defaultValue)
//            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#defaultValue.
//            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#getDefaultValue().
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#defaultValue.
//                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#getDefaultValue().
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#over().
      override fun over(): WindowFunctionDefinition<T?> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<T?>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(expr.columnType, this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#expr.
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#getExpr().
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#
  /** Represents an SQL function that returns [expr] evaluated at the row that is the first row of the window frame. */
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#[T]
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#`<init>`().
  class FirstValue<T>(
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#
//                 display_name FirstValue
//                 documentation ```kotlin\npublic final class FirstValue<T> : WindowFunction<T>\n```\n\n----\n\n Represents an SQL function that returns [expr] evaluated at the row that is the first row of the window frame.
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#`<init>`().
//                 display_name FirstValue
//                 documentation ```kotlin\npublic constructor<T>(expr: ExpressionWithColumnType<T>): FirstValue<T>\n```\n\n----\n\n Returns the expression to evaluate.
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#getExpr().
      /** Returns the expression to evaluate. */
      val expr: ExpressionWithColumnType<T>
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: ExpressionWithColumnType<T>\n```\n\n----\n\n Returns the expression to evaluate.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: ExpressionWithColumnType<T>\n```\n\n----\n\n Returns the expression to evaluate.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): ExpressionWithColumnType<T>\n```\n\n----\n\n Returns the expression to evaluate.
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#`<init>`().(expr)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#expr.
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#getExpr().
  ) : WindowFunction<T> {
//    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#toQueryBuilder().(queryBuilder)
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#toQueryBuilder().(queryBuilder)
          append("FIRST_VALUE(", expr, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#expr.
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#getExpr().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#over().
      override fun over(): WindowFunctionDefinition<T> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<T>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(expr.columnType, this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#expr.
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#getExpr().
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#
  /** Represents an SQL function that returns [expr] evaluated at the row that is the last row of the window frame. */
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#[T]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#`<init>`().
  class LastValue<T>(
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#
//                display_name LastValue
//                documentation ```kotlin\npublic final class LastValue<T> : WindowFunction<T>\n```\n\n----\n\n Represents an SQL function that returns [expr] evaluated at the row that is the last row of the window frame.
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#`<init>`().
//                display_name LastValue
//                documentation ```kotlin\npublic constructor<T>(expr: ExpressionWithColumnType<T>): LastValue<T>\n```\n\n----\n\n Returns the expression to evaluate.
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#getExpr().
      /** Returns the expression to evaluate. */
      val expr: ExpressionWithColumnType<T>
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: ExpressionWithColumnType<T>\n```\n\n----\n\n Returns the expression to evaluate.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: ExpressionWithColumnType<T>\n```\n\n----\n\n Returns the expression to evaluate.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): ExpressionWithColumnType<T>\n```\n\n----\n\n Returns the expression to evaluate.
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#`<init>`().(expr)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#expr.
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#getExpr().
  ) : WindowFunction<T> {
//    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#toQueryBuilder().(queryBuilder)
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#toQueryBuilder().(queryBuilder)
          append("LAST_VALUE(", expr, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#expr.
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#getExpr().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#over().
      override fun over(): WindowFunctionDefinition<T> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<T>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(expr.columnType, this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#expr.
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#getExpr().
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#
  /**
   * Represents an SQL function that returns [expr] evaluated at the row that is the [n]'th row of the window frame
   * (counting from 1); null if no such row
   */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#[T]
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#`<init>`().
  class NthValue<T>(
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#
//               display_name NthValue
//               documentation ```kotlin\npublic final class NthValue<T> : WindowFunction<T?>\n```\n\n----\n\n\n Represents an SQL function that returns [expr] evaluated at the row that is the [n]'th row of the window frame\n (counting from 1); null if no such row\n
//               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#`<init>`().
//               display_name NthValue
//               documentation ```kotlin\npublic constructor<T>(expr: ExpressionWithColumnType<T>, n: ExpressionWithColumnType<Int>): NthValue<T>\n```\n\n----\n\n Returns the expression to evaluate.
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#getExpr().
      /** Returns the expression to evaluate. */
      val expr: ExpressionWithColumnType<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: ExpressionWithColumnType<T>\n```\n\n----\n\n Returns the expression to evaluate.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: ExpressionWithColumnType<T>\n```\n\n----\n\n Returns the expression to evaluate.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): ExpressionWithColumnType<T>\n```\n\n----\n\n Returns the expression to evaluate.
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#`<init>`().(expr)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#expr.
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#getExpr().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#`<init>`().(n)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#n.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#getN().
      /** Returns the row n to find. */
      val n: ExpressionWithColumnType<Int>
//        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#`<init>`().(n)
//          display_name n
//          documentation ```kotlin\nn: ExpressionWithColumnType<Int>\n```\n\n----\n\n Returns the row n to find.
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#`<init>`().(n)
//        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#getN().
//          display_name n
//          documentation ```kotlin\npublic get(): ExpressionWithColumnType<Int>\n```\n\n----\n\n Returns the row n to find.
//        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#n.
//          display_name n
//          documentation ```kotlin\npublic final val n: ExpressionWithColumnType<Int>\n```\n\n----\n\n Returns the row n to find.
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#`<init>`().(n)
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#n.
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#getN().
  ) : WindowFunction<T?> {
//    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#toQueryBuilder().(queryBuilder)
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#toQueryBuilder().(queryBuilder)
          append("NTH_VALUE(", expr, ", ", n, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#expr.
//                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#getExpr().
//                                         ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#getN().
//                                         ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#n.
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#over().
      override fun over(): WindowFunctionDefinition<T?> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<T?>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(expr.columnType, this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#expr.
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#getExpr().
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#
