  package org.jetbrains.exposed.v1.core.ops
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/
  
  import org.jetbrains.exposed.v1.core.*
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  /**
   * Represents an SQL operator that checks a value, based on the preceding comparison operator,
   * against elements returned by [subSearch].
   */
  abstract class AllAnyFromBaseOp<T, SubSearch>(
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#
//                                display_name AllAnyFromBaseOp
//                                documentation ```kotlin\npublic abstract class AllAnyFromBaseOp<T, SubSearch> : Op<T>\n```\n\n----\n\n\n Represents an SQL operator that checks a value, based on the preceding comparison operator,\n against elements returned by [subSearch].\n
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromExpressionOp#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromSubQueryOp#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromTableOp#
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#`<init>`().
//                                display_name AllAnyFromBaseOp
//                                documentation ```kotlin\npublic constructor<T, SubSearch>(isAny: Boolean, subSearch: SubSearch): AllAnyFromBaseOp<T, SubSearch>\n```\n\n----\n\n Returns `true` if at least 1 comparison must evaluate to `true`, or `false` if all comparisons must be `true`.
//                                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#[T]
//                                  display_name FirTypeParameterSymbol T
//                                  documentation ```kotlin\nT\n```
//                                   ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#[SubSearch]
//                                             display_name FirTypeParameterSymbol SubSearch
//                                             documentation ```kotlin\nSubSearch\n```
      /** Returns `true` if at least 1 comparison must evaluate to `true`, or `false` if all comparisons must be `true`. **/
      val isAny: Boolean,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#`<init>`().(isAny)
//              display_name isAny
//              documentation ```kotlin\nisAny: Boolean\n```\n\n----\n\n Returns `true` if at least 1 comparison must evaluate to `true`, or `false` if all comparisons must be `true`.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#`<init>`().(isAny)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#getIsAny().
//              display_name isAny
//              documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Returns `true` if at least 1 comparison must evaluate to `true`, or `false` if all comparisons must be `true`.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#isAny.
//              display_name isAny
//              documentation ```kotlin\npublic final val isAny: Boolean\n```\n\n----\n\n Returns `true` if at least 1 comparison must evaluate to `true`, or `false` if all comparisons must be `true`.
//               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      /** Returns the source of elements to be compared against. */
      val subSearch: SubSearch
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#`<init>`().(subSearch)
//                  display_name subSearch
//                  documentation ```kotlin\nsubSearch: SubSearch\n```\n\n----\n\n Returns the source of elements to be compared against.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#`<init>`().(subSearch)
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#getSubSearch().
//                  display_name subSearch
//                  documentation ```kotlin\npublic get(): SubSearch\n```\n\n----\n\n Returns the source of elements to be compared against.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#subSearch.
//                  display_name subSearch
//                  documentation ```kotlin\npublic final val subSearch: SubSearch\n```\n\n----\n\n Returns the source of elements to be compared against.
  ) : Op<T>() {
//    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
      override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#toQueryBuilder().(queryBuilder)
          +(if (isAny) "ANY" else "ALL")
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#getIsAny().
//              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#isAny.
          +" ("
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          registerSubSearchArgument(subSearch)
//        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#registerSubSearchArgument().
//                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#getSubSearch().
//                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#subSearch.
          +')'
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus().
      }
  
      /** Processes the [subSearch] value for inclusion in the generated query. */
      abstract fun QueryBuilder.registerSubSearchArgument(subSearch: SubSearch)
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#registerSubSearchArgument().
//                                                        display_name registerSubSearchArgument
//                                                        documentation ```kotlin\npublic abstract fun QueryBuilder.registerSubSearchArgument(subSearch: SubSearch): Unit\n\n```\n\n----\n\n Processes the [subSearch] value for inclusion in the generated query.
//                                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#registerSubSearchArgument().
//                                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromExpressionOp#registerSubSearchArgument().
//                                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromSubQueryOp#registerSubSearchArgument().
//                                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromTableOp#registerSubSearchArgument().
//                                                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#registerSubSearchArgument().(subSearch)
//                                                                  display_name subSearch
//                                                                  documentation ```kotlin\nsubSearch: SubSearch\n```
  }
  
  /**
   * Represents an SQL operator that checks a value, based on the preceding comparison operator,
   * against results returned by a query.
   */
  class AllAnyFromSubQueryOp<T>(
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromSubQueryOp#
//                           display_name AllAnyFromSubQueryOp
//                           documentation ```kotlin\npublic final class AllAnyFromSubQueryOp<T> : AllAnyFromBaseOp<T, AbstractQuery<*>>\n```\n\n----\n\n\n Represents an SQL operator that checks a value, based on the preceding comparison operator,\n against results returned by a query.\n
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromSubQueryOp#`<init>`().
//                           display_name AllAnyFromSubQueryOp
//                           documentation ```kotlin\npublic constructor<T>(isAny: Boolean, subQuery: AbstractQuery<*>): AllAnyFromSubQueryOp<T>\n```
//                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromSubQueryOp#[T]
//                             display_name FirTypeParameterSymbol T
//                             documentation ```kotlin\nT\n```
      isAny: Boolean,
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromSubQueryOp#`<init>`().(isAny)
//          display_name isAny
//          documentation ```kotlin\nisAny: Boolean\n```
//           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      subQuery: AbstractQuery<*>
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromSubQueryOp#`<init>`().(subQuery)
//             display_name subQuery
//             documentation ```kotlin\nsubQuery: AbstractQuery<*>\n```
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
  ) : AllAnyFromBaseOp<T, AbstractQuery<*>>(isAny, subQuery) {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromSubQueryOp#`<init>`().(isAny)
//                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromSubQueryOp#`<init>`().(subQuery)
      override fun QueryBuilder.registerSubSearchArgument(subSearch: AbstractQuery<*>) {
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromSubQueryOp#registerSubSearchArgument().
//                                                        display_name registerSubSearchArgument
//                                                        documentation ```kotlin\npublic open override fun QueryBuilder.registerSubSearchArgument(subSearch: AbstractQuery<*>): Unit\n```
//                                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#registerSubSearchArgument().
//                                                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromSubQueryOp#registerSubSearchArgument().(subSearch)
//                                                                  display_name subSearch
//                                                                  documentation ```kotlin\nsubSearch: AbstractQuery<*>\n```
//                                                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
          subSearch.prepareSQL(this)
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromSubQueryOp#registerSubSearchArgument().(subSearch)
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().
      }
  }
  
  /**
   * Represents an SQL operator that checks a value, based on the preceding comparison operator,
   * against an array of values.
   *
   * **Note** This operation is only supported by PostgreSQL and H2 dialects.
   *
   * **Note** This operation is supported only for 1 dimensional arrays
   */
  class AllAnyFromArrayOp<T : Any>(
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#
//                        display_name AllAnyFromArrayOp
//                        documentation ```kotlin\npublic final class AllAnyFromArrayOp<T : Any> : AllAnyFromBaseOp<T, List<T>>\n```\n\n----\n\n\n Represents an SQL operator that checks a value, based on the preceding comparison operator,\n against an array of values.\n\n **Note** This operation is only supported by PostgreSQL and H2 dialects.\n\n **Note** This operation is supported only for 1 dimensional arrays\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#`<init>`().
//                        display_name AllAnyFromArrayOp
//                        documentation ```kotlin\npublic constructor<T : Any>(isAny: Boolean, array: List<T>, delegateType: ColumnType<T>): AllAnyFromArrayOp<T>\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT : Any\n```
      isAny: Boolean,
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#`<init>`().(isAny)
//          display_name isAny
//          documentation ```kotlin\nisAny: Boolean\n```
//           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      array: List<T>,
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#`<init>`().(array)
//          display_name array
//          documentation ```kotlin\narray: List<T>\n```
//           ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
      private val delegateType: ColumnType<T>
//                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#`<init>`().(delegateType)
//                             display_name delegateType
//                             documentation ```kotlin\ndelegateType: ColumnType<T>\n```
//                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#`<init>`().(delegateType)
//                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#delegateType.
//                             display_name delegateType
//                             documentation ```kotlin\nprivate final val delegateType: ColumnType<T>\n```
//                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#getDelegateType().
//                             display_name delegateType
//                             documentation ```kotlin\nprivate get(): ColumnType<T>\n```
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
  ) : AllAnyFromBaseOp<T, List<T>>(isAny, array) {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#`<init>`().(isAny)
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#`<init>`().(array)
      override fun QueryBuilder.registerSubSearchArgument(subSearch: List<T>) {
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#registerSubSearchArgument().
//                                                        display_name registerSubSearchArgument
//                                                        documentation ```kotlin\npublic open override fun QueryBuilder.registerSubSearchArgument(subSearch: List<T>): Unit\n```
//                                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#registerSubSearchArgument().
//                                                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#registerSubSearchArgument().(subSearch)
//                                                                  display_name subSearch
//                                                                  documentation ```kotlin\nsubSearch: List<T>\n```
//                                                                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          registerArgument(ArrayColumnType<T, List<T>>(delegateType), subSearch)
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
//                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#delegateType.
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#getDelegateType().
//                                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#registerSubSearchArgument().(subSearch)
      }
  }
  
  /**
   * Represents an SQL operator that checks a value, based on the preceding comparison operator,
   * against elements in a single-column table.
   *
   * **Note** This operation is only supported by MySQL, PostgreSQL, and H2 dialects.
   */
  class AllAnyFromTableOp<T>(isAny: Boolean, table: Table) : AllAnyFromBaseOp<T, Table>(isAny, table) {
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromTableOp#
//                        display_name AllAnyFromTableOp
//                        documentation ```kotlin\npublic final class AllAnyFromTableOp<T> : AllAnyFromBaseOp<T, Table>\n```\n\n----\n\n\n Represents an SQL operator that checks a value, based on the preceding comparison operator,\n against elements in a single-column table.\n\n **Note** This operation is only supported by MySQL, PostgreSQL, and H2 dialects.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromTableOp#`<init>`().
//                        display_name AllAnyFromTableOp
//                        documentation ```kotlin\npublic constructor<T>(isAny: Boolean, table: Table): AllAnyFromTableOp<T>\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromTableOp#[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT\n```
//                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromTableOp#`<init>`().(isAny)
//                                 display_name isAny
//                                 documentation ```kotlin\nisAny: Boolean\n```
//                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromTableOp#`<init>`().(table)
//                                                 display_name table
//                                                 documentation ```kotlin\ntable: Table\n```
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#
//                                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromTableOp#`<init>`().(isAny)
//                                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromTableOp#`<init>`().(table)
      override fun QueryBuilder.registerSubSearchArgument(subSearch: Table) {
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromTableOp#registerSubSearchArgument().
//                                                        display_name registerSubSearchArgument
//                                                        documentation ```kotlin\npublic open override fun QueryBuilder.registerSubSearchArgument(subSearch: Table): Unit\n```
//                                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#registerSubSearchArgument().
//                                                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromTableOp#registerSubSearchArgument().(subSearch)
//                                                                  display_name subSearch
//                                                                  documentation ```kotlin\nsubSearch: Table\n```
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
          +"TABLE "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          +subSearch.tableName
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromTableOp#registerSubSearchArgument().(subSearch)
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
      }
  }
  
  /**
   * Represents an SQL operator that checks a value, based on the preceding comparison operator,
   * against a collection of values returned by the provided expression.
   *
   * **Note** This operation is only supported by PostgreSQL and H2 dialects.
   */
  class AllAnyFromExpressionOp<E, T : List<E>?>(
//      ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromExpressionOp#
//                             display_name AllAnyFromExpressionOp
//                             documentation ```kotlin\npublic final class AllAnyFromExpressionOp<E, T : List<E>?> : AllAnyFromBaseOp<E, Expression<T>>\n```\n\n----\n\n\n Represents an SQL operator that checks a value, based on the preceding comparison operator,\n against a collection of values returned by the provided expression.\n\n **Note** This operation is only supported by PostgreSQL and H2 dialects.\n
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#
//      ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromExpressionOp#`<init>`().
//                             display_name AllAnyFromExpressionOp
//                             documentation ```kotlin\npublic constructor<E, T : List<E>?>(isAny: Boolean, expression: Expression<T>): AllAnyFromExpressionOp<E, T>\n```
//                             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromExpressionOp#[E]
//                               display_name FirTypeParameterSymbol E
//                               documentation ```kotlin\nE\n```
//                                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromExpressionOp#[T]
//                                  display_name FirTypeParameterSymbol T
//                                  documentation ```kotlin\nT : List<E>?\n```
      isAny: Boolean,
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromExpressionOp#`<init>`().(isAny)
//          display_name isAny
//          documentation ```kotlin\nisAny: Boolean\n```
//           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      expression: Expression<T>
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromExpressionOp#`<init>`().(expression)
//               display_name expression
//               documentation ```kotlin\nexpression: Expression<T>\n```
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
  ) : AllAnyFromBaseOp<E, Expression<T>>(isAny, expression) {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromExpressionOp#`<init>`().(isAny)
//                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromExpressionOp#`<init>`().(expression)
      override fun QueryBuilder.registerSubSearchArgument(subSearch: Expression<T>) {
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromExpressionOp#registerSubSearchArgument().
//                                                        display_name registerSubSearchArgument
//                                                        documentation ```kotlin\npublic open override fun QueryBuilder.registerSubSearchArgument(subSearch: Expression<T>): Unit\n```
//                                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromBaseOp#registerSubSearchArgument().
//                                                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromExpressionOp#registerSubSearchArgument().(subSearch)
//                                                                  display_name subSearch
//                                                                  documentation ```kotlin\nsubSearch: Expression<T>\n```
//                                                                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          append(subSearch)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromExpressionOp#registerSubSearchArgument().(subSearch)
      }
  }
