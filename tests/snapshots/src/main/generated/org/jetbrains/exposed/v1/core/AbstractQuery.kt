  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  import org.jetbrains.exposed.v1.core.statements.Statement
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
  import org.jetbrains.exposed.v1.core.statements.StatementType
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
  import org.jetbrains.exposed.v1.core.statements.api.ResultApi
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/
//                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ResultApi#
  import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#
  import org.jetbrains.exposed.v1.core.vendors.ForUpdateOption
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
  import org.jetbrains.exposed.v1.core.vendors.currentDialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
  
  @Suppress("ForbiddenComment")
  // TODO: check if Statement<T> is limited to ResultApi & if we can introduce typed exec()s to avoid casting ResultApi
  // TODO: consider naming this as QueryState (or something related to state of the query) and check that it has only single responsibility
  /** Base class representing an SQL query that returns a database result when executed. */
  abstract class AbstractQuery<T : AbstractQuery<T>>(
//               ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                             display_name AbstractQuery
//                             documentation ```kotlin\n@Suppress(...) public abstract class AbstractQuery<T : AbstractQuery<T>> : Statement<ResultApi>\n```\n\n----\n\n Base class representing an SQL query that returns a database result when executed.
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
//               ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#`<init>`().
//                             display_name AbstractQuery
//                             documentation ```kotlin\npublic constructor<T : AbstractQuery<T>>(targets: List<Table>): AbstractQuery<T>\n```
//                             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#[T]
//                               display_name FirTypeParameterSymbol T
//                               documentation ```kotlin\nT : AbstractQuery<T>\n```
      targets: List<Table>
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#`<init>`().(targets)
//            display_name targets
//            documentation ```kotlin\ntargets: List<Table>\n```
//             ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
  ) : Statement<ResultApi>(StatementType.SELECT, targets) {
//    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
//                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#SELECT.
//                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#`<init>`().(targets)
      /** The stored list of columns and their [SortOrder] for an `ORDER BY` clause in this query. */
      var orderByExpressions: List<Pair<Expression<*>, SortOrder>> = mutableListOf()
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getOrderByExpressions().
//                           display_name orderByExpressions
//                           documentation ```kotlin\npublic get(): List<Pair<Expression<*>, SortOrder>>\n```\n\n----\n\n The stored list of columns and their [SortOrder] for an `ORDER BY` clause in this query.
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#orderByExpressions.
//                           display_name orderByExpressions
//                           documentation ```kotlin\npublic final var orderByExpressions: List<Pair<Expression<*>, SortOrder>>\n```\n\n----\n\n The stored list of columns and their [SortOrder] for an `ORDER BY` clause in this query.
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                   ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
          private set
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setOrderByExpressions().(value)
//                    display_name value
//                    documentation ```kotlin\nvalue: List<Pair<Expression<*>, SortOrder>>\n```
//                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setOrderByExpressions().
//                    display_name orderByExpressions
//                    documentation ```kotlin\nprivate set(value: List<Pair<Expression<*>, SortOrder>>): Unit\n```
  
      /** The stored value for a `LIMIT` clause in this query. */
      var limit: Int? = null
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getLimit().
//              display_name limit
//              documentation ```kotlin\npublic get(): Int?\n```\n\n----\n\n The stored value for a `LIMIT` clause in this query.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#limit.
//              display_name limit
//              documentation ```kotlin\npublic final var limit: Int?\n```\n\n----\n\n The stored value for a `LIMIT` clause in this query.
//               ^^^^ reference semanticdb maven . . kotlin/Int#
          protected set
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setLimit().(value)
//                      display_name value
//                      documentation ```kotlin\nvalue: Int?\n```
//                  ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setLimit().
//                      display_name limit
//                      documentation ```kotlin\nprotected set(value: Int?): Unit\n```
  
      /** The stored value for an `OFFSET` clause in this query. */
      var offset: Long = 0
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getOffset().
//               display_name offset
//               documentation ```kotlin\npublic get(): Long\n```\n\n----\n\n The stored value for an `OFFSET` clause in this query.
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#offset.
//               display_name offset
//               documentation ```kotlin\npublic final var offset: Long\n```\n\n----\n\n The stored value for an `OFFSET` clause in this query.
//                ^^^^ reference semanticdb maven . . kotlin/Long#
          protected set
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setOffset().(value)
//                      display_name value
//                      documentation ```kotlin\nvalue: Long\n```
//                  ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setOffset().
//                      display_name offset
//                      documentation ```kotlin\nprotected set(value: Long): Unit\n```
  
      /** The number of results that should be fetched when this query is executed. */
      var fetchSize: Int? = null
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#fetchSize.
//                  display_name fetchSize
//                  documentation ```kotlin\npublic final var fetchSize: Int?\n```\n\n----\n\n The number of results that should be fetched when this query is executed.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getFetchSize().
//                  display_name fetchSize
//                  documentation ```kotlin\npublic get(): Int?\n```\n\n----\n\n The number of results that should be fetched when this query is executed.
//                   ^^^^ reference semanticdb maven . . kotlin/Int#
          private set
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setFetchSize().(value)
//                    display_name value
//                    documentation ```kotlin\nvalue: Int?\n```
//                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setFetchSize().
//                    display_name fetchSize
//                    documentation ```kotlin\nprivate set(value: Int?): Unit\n```
  
      /** The set of columns on which a query should be executed, contained by a [ColumnSet]. */
      abstract val set: FieldSet
//                 ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getSet().
//                     display_name set
//                     documentation ```kotlin\npublic get(): FieldSet\n```\n\n----\n\n The set of columns on which a query should be executed, contained by a [ColumnSet].
//                 ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#set.
//                     display_name set
//                     documentation ```kotlin\npublic abstract val set: FieldSet\n```\n\n----\n\n The set of columns on which a query should be executed, contained by a [ColumnSet].
//                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#
  
      /** Whether only distinct results should be retrieved by this `SELECT` query. */
      var distinct: Boolean = false
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#distinct.
//                 display_name distinct
//                 documentation ```kotlin\npublic final var distinct: Boolean\n```\n\n----\n\n Whether only distinct results should be retrieved by this `SELECT` query.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getDistinct().
//                 display_name distinct
//                 documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether only distinct results should be retrieved by this `SELECT` query.
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          protected set
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setDistinct().(value)
//                      display_name value
//                      documentation ```kotlin\nvalue: Boolean\n```
//                  ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setDistinct().
//                      display_name distinct
//                      documentation ```kotlin\nprotected set(value: Boolean): Unit\n```
  
      /**
       * List of columns on which the query should be distinct.
       *
       * This parameter specifies columns for the `DISTINCT ON` clause, which allows selecting distinct rows based on
       * the specified columns and is supported by some SQL dialects (e.g., PostgreSQL, H2).
       */
      var distinctOn: List<Column<*>>? = null
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#distinctOn.
//                   display_name distinctOn
//                   documentation ```kotlin\npublic final var distinctOn: List<Column<*>>?\n```\n\n----\n\n\n List of columns on which the query should be distinct.\n\n This parameter specifies columns for the `DISTINCT ON` clause, which allows selecting distinct rows based on\n the specified columns and is supported by some SQL dialects (e.g., PostgreSQL, H2).\n
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getDistinctOn().
//                   display_name distinctOn
//                   documentation ```kotlin\npublic get(): List<Column<*>>?\n```\n\n----\n\n\n List of columns on which the query should be distinct.\n\n This parameter specifies columns for the `DISTINCT ON` clause, which allows selecting distinct rows based on\n the specified columns and is supported by some SQL dialects (e.g., PostgreSQL, H2).\n
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          protected set
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setDistinctOn().(value)
//                      display_name value
//                      documentation ```kotlin\nvalue: List<Column<*>>?\n```
//                  ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setDistinctOn().
//                      display_name distinctOn
//                      documentation ```kotlin\nprotected set(value: List<Column<*>>?): Unit\n```
  
      /** The stored list of columns for a `GROUP BY` clause in this `SELECT` query. */
      var groupedByColumns: List<Expression<*>> = mutableListOf()
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getGroupedByColumns().
//                         display_name groupedByColumns
//                         documentation ```kotlin\npublic get(): List<Expression<*>>\n```\n\n----\n\n The stored list of columns for a `GROUP BY` clause in this `SELECT` query.
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#groupedByColumns.
//                         display_name groupedByColumns
//                         documentation ```kotlin\npublic final var groupedByColumns: List<Expression<*>>\n```\n\n----\n\n The stored list of columns for a `GROUP BY` clause in this `SELECT` query.
//                          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
          private set
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setGroupedByColumns().(value)
//                    display_name value
//                    documentation ```kotlin\nvalue: List<Expression<*>>\n```
//                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setGroupedByColumns().
//                    display_name groupedByColumns
//                    documentation ```kotlin\nprivate set(value: List<Expression<*>>): Unit\n```
  
      /** The stored condition for a `HAVING` clause in this `SELECT` query. */
      var having: Op<Boolean>? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getHaving().
//               display_name having
//               documentation ```kotlin\npublic get(): Op<Boolean>?\n```\n\n----\n\n The stored condition for a `HAVING` clause in this `SELECT` query.
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#having.
//               display_name having
//               documentation ```kotlin\npublic final var having: Op<Boolean>?\n```\n\n----\n\n The stored condition for a `HAVING` clause in this `SELECT` query.
//                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          private set
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setHaving().(value)
//                    display_name value
//                    documentation ```kotlin\nvalue: Op<Boolean>?\n```
//                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setHaving().
//                    display_name having
//                    documentation ```kotlin\nprivate set(value: Op<Boolean>?): Unit\n```
  
      protected var forUpdate: ForUpdateOption? = null
//                  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#forUpdate.
//                            display_name forUpdate
//                            documentation ```kotlin\nprotected final var forUpdate: ForUpdateOption?\n```
//                  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getForUpdate().
//                            display_name forUpdate
//                            documentation ```kotlin\nprotected get(): ForUpdateOption?\n```
//                  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setForUpdate().
//                            display_name forUpdate
//                            documentation ```kotlin\nprotected set(value: ForUpdateOption?): Unit\n```
//                  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setForUpdate().(value)
//                            display_name value
//                            documentation ```kotlin\nvalue: ForUpdateOption?\n```
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
  
      /** The stored comments and their [CommentPosition]s in this `SELECT` query. */
      var comments: Map<CommentPosition, String> = mutableMapOf()
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comments.
//                 display_name comments
//                 documentation ```kotlin\npublic final var comments: Map<AbstractQuery.CommentPosition, String>\n```\n\n----\n\n The stored comments and their [CommentPosition]s in this `SELECT` query.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getComments().
//                 display_name comments
//                 documentation ```kotlin\npublic get(): Map<AbstractQuery.CommentPosition, String>\n```\n\n----\n\n The stored comments and their [CommentPosition]s in this `SELECT` query.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                 ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableMapOf().
          private set
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setComments().(value)
//                    display_name value
//                    documentation ```kotlin\nvalue: Map<AbstractQuery.CommentPosition, String>\n```
//                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setComments().
//                    display_name comments
//                    documentation ```kotlin\nprivate set(value: Map<AbstractQuery.CommentPosition, String>): Unit\n```
  
      /**
       * Copies all stored properties of this `SELECT` query into the properties of [other].
       *
       * Override this function to additionally copy any properties that are not part of the primary constructor.
       */
      open fun copyTo(other: T) {
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#copyTo().
//                    display_name copyTo
//                    documentation ```kotlin\npublic open fun copyTo(other: T): Unit\n```\n\n----\n\n\n Copies all stored properties of this `SELECT` query into the properties of [other].\n\n Override this function to additionally copy any properties that are not part of the primary constructor.\n
//                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#copyTo().(other)
//                          display_name other
//                          documentation ```kotlin\nother: T\n```
          other.orderByExpressions = orderByExpressions.toMutableList()
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#copyTo().(other)
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getOrderByExpressions().
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#orderByExpressions.
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setOrderByExpressions().
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getOrderByExpressions().
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#orderByExpressions.
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setOrderByExpressions().
//                                                      ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/toMutableList(+10).
          other.limit = limit
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#copyTo().(other)
//              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getLimit().
//              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#limit.
//              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setLimit().
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getLimit().
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#limit.
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setLimit().
          other.offset = offset
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#copyTo().(other)
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getOffset().
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#offset.
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setOffset().
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getOffset().
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#offset.
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setOffset().
          other.fetchSize = fetchSize
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#copyTo().(other)
//              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#fetchSize.
//              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getFetchSize().
//              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setFetchSize().
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#fetchSize.
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getFetchSize().
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setFetchSize().
          other.distinct = distinct
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#copyTo().(other)
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#distinct.
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getDistinct().
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setDistinct().
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#distinct.
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getDistinct().
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setDistinct().
          other.distinctOn = distinctOn
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#copyTo().(other)
//              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#distinctOn.
//              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getDistinctOn().
//              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setDistinctOn().
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#distinctOn.
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getDistinctOn().
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setDistinctOn().
          other.groupedByColumns = groupedByColumns.toMutableList()
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#copyTo().(other)
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getGroupedByColumns().
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#groupedByColumns.
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setGroupedByColumns().
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getGroupedByColumns().
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#groupedByColumns.
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setGroupedByColumns().
//                                                  ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/toMutableList(+10).
          other.having = having
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#copyTo().(other)
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getHaving().
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#having.
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setHaving().
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getHaving().
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#having.
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setHaving().
          other.forUpdate = forUpdate
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#copyTo().(other)
//              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#forUpdate.
//              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getForUpdate().
//              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setForUpdate().
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#forUpdate.
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getForUpdate().
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setForUpdate().
          other.comments = comments.toMutableMap()
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#copyTo().(other)
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comments.
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getComments().
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setComments().
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comments.
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getComments().
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setComments().
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/toMutableMap().
      }
  
      override fun arguments() = QueryBuilder(true).let {
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#arguments().
//                           display_name arguments
//                           documentation ```kotlin\npublic open override fun arguments(): List<List<Pair<IColumnType<*>, Any?>>>\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#arguments().
//                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                                                  ^^^ reference semanticdb maven . . kotlin/let().
//                                                      ^ definition semanticdb maven . . (it) 3:5
//                                                        display_name it
//                                                        documentation ```kotlin\nit: Op<Boolean>\n```
          prepareSQL(it)
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL(+1).
//                   ^^ reference semanticdb maven . . (it)
          if (it.args.isNotEmpty()) listOf(it.args) else emptyList()
//            ^^ reference semanticdb maven . . (it)
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#args.
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getArgs().
//                    ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                  ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                         ^^ reference semanticdb maven . . (it)
//                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#args.
//                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getArgs().
//                                                       ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
      }
  
      /** Modifies this query to retrieve only distinct results if [value] is set to `true`. */
      open fun withDistinct(value: Boolean = true): T = apply {
//             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#withDistinct().
//                          display_name withDistinct
//                          documentation ```kotlin\npublic open fun withDistinct(value: Boolean = ...): T\n```\n\n----\n\n Modifies this query to retrieve only distinct results if [value] is set to `true`.
//                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#withDistinct().(value)
//                                display_name value
//                                documentation ```kotlin\nvalue: Boolean = ...\n```
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                      ^^^^^ reference semanticdb maven . . kotlin/apply().
          if (value) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#withDistinct().(value)
              require(distinctOn == null) { "DISTINCT cannot be used with the DISTINCT ON modifier. Only one of them should be applied." }
//            ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#distinctOn.
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getDistinctOn().
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setDistinctOn().
          }
          distinct = value
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#distinct.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getDistinct().
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setDistinct().
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#withDistinct().(value)
      } as T
  
      /** Modifies the number of results that should be fetched when this query is executed. */
      fun fetchSize(n: Int): T = apply {
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#fetchSize(+1).
//                  display_name fetchSize
//                  documentation ```kotlin\npublic final fun fetchSize(n: Int): T\n```\n\n----\n\n Modifies the number of results that should be fetched when this query is executed.
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#fetchSize(+1).(n)
//                    display_name n
//                    documentation ```kotlin\nn: Int\n```
//                     ^^^ reference semanticdb maven . . kotlin/Int#
//                               ^^^^^ reference semanticdb maven . . kotlin/apply().
          fetchSize = n
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#fetchSize.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getFetchSize().
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setFetchSize().
//                    ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#fetchSize(+1).(n)
      } as T
  
      /** The stored condition for a `WHERE` clause in this `SELECT` query. */
      var where: Op<Boolean>? = null
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getWhere().
//              display_name where
//              documentation ```kotlin\npublic get(): Op<Boolean>?\n```\n\n----\n\n The stored condition for a `WHERE` clause in this `SELECT` query.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#where.
//              display_name where
//              documentation ```kotlin\npublic final var where: Op<Boolean>?\n```\n\n----\n\n The stored condition for a `WHERE` clause in this `SELECT` query.
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          protected set
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setWhere().(value)
//                      display_name value
//                      documentation ```kotlin\nvalue: Op<Boolean>?\n```
//                  ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setWhere().
//                      display_name where
//                      documentation ```kotlin\nprotected set(value: Op<Boolean>?): Unit\n```
  
      /**
       * Specifies that the `SELECT` query should retrieve distinct results based on the given list of columns.
       *
       * This method can be used to set a `DISTINCT ON` clause for the query, which is supported by some SQL dialects
       * (e.g., PostgreSQL, H2). The resulting query will retrieve rows that are distinct based on the specified columns.
       *
       * @param columns The columns to apply the `DISTINCT ON` clause.
       * @return The current `Query` instance with the `DISTINCT ON` clause applied.
       */
      fun withDistinctOn(vararg columns: Column<*>): T = apply {
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#withDistinctOn().
//                       display_name withDistinctOn
//                       documentation ```kotlin\npublic final fun withDistinctOn(vararg columns: Column<*>): T\n```\n\n----\n\n\n Specifies that the `SELECT` query should retrieve distinct results based on the given list of columns.\n\n This method can be used to set a `DISTINCT ON` clause for the query, which is supported by some SQL dialects\n (e.g., PostgreSQL, H2). The resulting query will retrieve rows that are distinct based on the specified columns.\n\n @param columns The columns to apply the `DISTINCT ON` clause.\n @return The current `Query` instance with the `DISTINCT ON` clause applied.\n
//                              ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#withDistinctOn().(columns)
//                                      display_name columns
//                                      documentation ```kotlin\nvararg columns: Column<*>\n```
//                                       ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                       ^^^^^ reference semanticdb maven . . kotlin/apply().
          if (columns.isEmpty()) return@apply
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#withDistinctOn().(columns)
//                    ^^^^^^^ reference semanticdb maven . . kotlin/collections/isEmpty().
  
          require(!distinct) { "DISTINCT ON cannot be used with the DISTINCT modifier. Only one of them should be applied." }
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^ reference semanticdb maven . . kotlin/Boolean#not().
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#distinct.
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getDistinct().
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setDistinct().
          distinctOn = (distinctOn ?: emptyList()) + columns
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#distinctOn.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getDistinctOn().
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setDistinctOn().
//                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#distinctOn.
//                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getDistinctOn().
//                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setDistinctOn().
//                                    ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
//                                                 ^ reference semanticdb maven . . kotlin/collections/plus(+30).
//                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#withDistinctOn().(columns)
      } as T
  
      protected var count: Boolean = false
//                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#count.
//                        display_name count
//                        documentation ```kotlin\nprotected final var count: Boolean\n```
//                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getCount().
//                        display_name count
//                        documentation ```kotlin\nprotected get(): Boolean\n```
//                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setCount().
//                        display_name count
//                        documentation ```kotlin\nprotected set(value: Boolean): Unit\n```
//                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setCount().(value)
//                        display_name value
//                        documentation ```kotlin\nvalue: Boolean\n```
//                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      /**
       * Changes the [having] field of this query.
       *
       * @param body Builder for the new `HAVING` condition, with the previous value used as the receiver.
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.AdjustQueryTests.testAdjustQueryHaving
       */
      fun adjustHaving(body: Op<Boolean>?.() -> Op<Boolean>): T = apply { having = having.body() } as T
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#adjustHaving().
//                     display_name adjustHaving
//                     documentation ```kotlin\npublic final fun adjustHaving(body: Op<Boolean>?.() -> Op<Boolean>): T\n```\n\n----\n\n\n Changes the [having] field of this query.\n\n @param body Builder for the new `HAVING` condition, with the previous value used as the receiver.\n @sample org.jetbrains.exposed.v1.tests.shared.dml.AdjustQueryTests.testAdjustQueryHaving\n
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#adjustHaving().(body)
//                          display_name body
//                          documentation ```kotlin\nbody: Op<Boolean>?.() -> Op<Boolean>\n```
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getHaving().
//                                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#having.
//                                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setHaving().
//                                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getHaving().
//                                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#having.
//                                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setHaving().
//                                                                                        ^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#adjustHaving().(body)
  
      /**
       * Changes the [content] of the [comments] field at the specified [position] in this query.
       *
       * @param position The [CommentPosition] in the query that should be assigned a new value.
       * @param content The content of the comment that should be set. If left `null`, any comment at the specified
       * [position] will be removed.
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testSelectWithComment
       */
      fun adjustComments(position: CommentPosition, content: String? = null): T = apply {
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#adjustComments().
//                       display_name adjustComments
//                       documentation ```kotlin\npublic final fun adjustComments(position: AbstractQuery.CommentPosition, content: String? = ...): T\n```\n\n----\n\n\n Changes the [content] of the [comments] field at the specified [position] in this query.\n\n @param position The [CommentPosition] in the query that should be assigned a new value.\n @param content The content of the comment that should be set. If left `null`, any comment at the specified\n [position] will be removed.\n @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testSelectWithComment\n
//                       ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#adjustComments().(position)
//                                display_name position
//                                documentation ```kotlin\nposition: AbstractQuery.CommentPosition\n```
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#CommentPosition#
//                                                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#adjustComments().(content)
//                                                          display_name content
//                                                          documentation ```kotlin\ncontent: String? = ...\n```
//                                                           ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                ^^^^^ reference semanticdb maven . . kotlin/apply().
          content?.let {
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#adjustComments().(content)
//                 ^^^ reference semanticdb maven . . kotlin/let().
//                     ^ definition semanticdb maven . . (it) 2:9
//                       display_name it
//                       documentation ```kotlin\nit: Op<Boolean>\n```
              (comments as MutableMap)[position] = content
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comments.
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getComments().
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setComments().
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#adjustComments().(position)
//                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#adjustComments().(content)
          } ?: run {
//             ^^^ reference semanticdb maven . . kotlin/run(+1).
              (comments as MutableMap).remove(position)
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comments.
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getComments().
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setComments().
//                                     ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#remove().
//                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#adjustComments().(position)
          }
      } as T
  
      /** Whether this `SELECT` query already has a stored value option for performing locking reads. */
      fun hasCustomForUpdateState() = forUpdate != null
//        ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#hasCustomForUpdateState().
//                                display_name hasCustomForUpdateState
//                                documentation ```kotlin\npublic final fun hasCustomForUpdateState(): Boolean\n```\n\n----\n\n Whether this `SELECT` query already has a stored value option for performing locking reads.
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#forUpdate.
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getForUpdate().
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setForUpdate().
  
      /**
       * Whether this `SELECT` query will perform a locking read.
       *
       * **Note:** `SELECT FOR UPDATE` is not supported by all vendors. Please check the documentation.
       */
      fun isForUpdate(): Boolean = (
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#isForUpdate().
//                    display_name isForUpdate
//                    documentation ```kotlin\npublic final fun isForUpdate(): Boolean\n```\n\n----\n\n\n Whether this `SELECT` query will perform a locking read.\n\n **Note:** `SELECT FOR UPDATE` is not supported by all vendors. Please check the documentation.\n
//                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          @OptIn(InternalApi::class)
          forUpdate?.let { it != ForUpdateOption.NoForUpdateOption }
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#forUpdate.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getForUpdate().
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setForUpdate().
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                   display_name it
//                                                                   documentation ```kotlin\nit: Op<Boolean>\n```
//                         ^^ reference semanticdb maven . . (it)
              ?: false
          )
  
      /**
       * Appends a `GROUP BY` clause with the specified [columns] to this `SELECT` query.
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.GroupByTests.testGroupBy02
       */
      fun groupBy(vararg columns: Expression<*>): T {
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#groupBy().
//                display_name groupBy
//                documentation ```kotlin\npublic final fun groupBy(vararg columns: Expression<*>): T\n```\n\n----\n\n\n Appends a `GROUP BY` clause with the specified [columns] to this `SELECT` query.\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.GroupByTests.testGroupBy02\n
//                       ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#groupBy().(columns)
//                               display_name columns
//                               documentation ```kotlin\nvararg columns: Expression<*>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
          for (column in columns) {
//             ^^^^^^ definition local 1
//                    display_name column
//                    documentation ```kotlin\nlocal val column: Expression<*>\n```
//                       ^^^^^^^ definition local 0
//                               display_name <iterator>
//                               documentation ```kotlin\nlocal val <iterator>: Iterator<Expression<*>>\n```
//                       ^^^^^^^ reference local 0
//                       ^^^^^^^ reference semanticdb maven . . kotlin/Array#iterator().
//                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#hasNext().
//                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#next().
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#groupBy().(columns)
              (groupedByColumns as MutableList).add(column)
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getGroupedByColumns().
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#groupedByColumns.
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setGroupedByColumns().
//                                              ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                                                  ^^^^^^ reference local 1
          }
          return this as T
      }
  
      /**
       * Appends a `HAVING` clause with the specified [op] condition to this `SELECT` query.
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.GroupByTests.testGroupBy02
       */
      fun having(op: SqlExpressionBuilder.() -> Op<Boolean>): T {
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#having(+1).
//               display_name having
//               documentation ```kotlin\npublic final fun having(op: SqlExpressionBuilder.() -> Op<Boolean>): T\n```\n\n----\n\n\n Appends a `HAVING` clause with the specified [op] condition to this `SELECT` query.\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.GroupByTests.testGroupBy02\n
//               ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#having(+1).(op)
//                  display_name op
//                  documentation ```kotlin\nop: SqlExpressionBuilder.() -> Op<Boolean>\n```
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
          val oop = SqlExpressionBuilder.op()
//            ^^^ definition local 2
//                display_name oop
//                documentation ```kotlin\nlocal val oop: Op<Boolean>\n```
//                                       ^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                       ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#having(+1).(op)
          if (having != null) {
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getHaving().
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#having.
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setHaving().
              error("HAVING clause is specified twice. Old value = '$having', new value = '$oop'")
//            ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getHaving().
//                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#having.
//                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setHaving().
//                                                                                          ^^^ reference local 2
          }
          having = oop
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getHaving().
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#having.
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setHaving().
//                 ^^^ reference local 2
          return this as T
      }
  
      /**
       * Appends an SQL comment, with [content] wrapped by `/* */`, at the specified [CommentPosition] in this `SELECT` query.
       *
       * Adding some comments may be useful for tracking, embedding metadata, or for special instructions, like using
       * `/*FORCE_MASTER*/` for some cloud databases to force the statement to run in the master database
       * or using optimizer hints.
       *
       * @throws IllegalStateException If a comment has already been appended at the specified [position]. An existing
       * comment can be removed or altered by [adjustComments].
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testSelectWithComment
       */
      fun comment(content: String, position: CommentPosition = CommentPosition.FRONT): T {
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comment().
//                display_name comment
//                documentation ```kotlin\npublic final fun comment(content: String, position: AbstractQuery.CommentPosition = ...): T\n```\n\n----\n\n\n Appends an SQL comment, with [content] wrapped by `/* */`, at the specified [CommentPosition] in this `SELECT` query.\n\n Adding some comments may be useful for tracking, embedding metadata, or for special instructions, like using\n `/*FORCE_MASTER*/` for some cloud databases to force the statement to run in the master database\n or using optimizer hints.\n\n @throws IllegalStateException If a comment has already been appended at the specified [position]. An existing\n comment can be removed or altered by [adjustComments].\n @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testSelectWithComment\n
//                ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comment().(content)
//                        display_name content
//                        documentation ```kotlin\ncontent: String\n```
//                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comment().(position)
//                                          display_name position
//                                          documentation ```kotlin\nposition: AbstractQuery.CommentPosition = ...\n```
//                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#CommentPosition#
//                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#CommentPosition#FRONT.
          comments[position]?.let {
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comments.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getComments().
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setComments().
//        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comment().(position)
//                            ^^^ reference semanticdb maven . . kotlin/let().
//                                ^ definition semanticdb maven . . (it) 2:9
//                                  display_name it
//                                  documentation ```kotlin\nit: Op<Boolean>\n```
              error("Comment at $position position is specified twice. Old value = '$it', new value = '$content'")
//            ^^^^^ reference semanticdb maven . . kotlin/error().
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comment().(position)
//                                                                                   ^^ reference semanticdb maven . . (it)
//                                                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comment().(content)
          }
          (comments as MutableMap)[position] = content
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comments.
//         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getComments().
//         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setComments().
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comment().(position)
//                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comment().(content)
          return this as T
      }
  
      override fun prepareSQL(transaction: Transaction, prepared: Boolean) = prepareSQL(QueryBuilder(prepared))
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().
//                            display_name prepareSQL
//                            documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#prepareSQL().
//                            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().(transaction)
//                                        display_name transaction
//                                        documentation ```kotlin\ntransaction: Transaction\n```
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().(prepared)
//                                                               display_name prepared
//                                                               documentation ```kotlin\nprepared: Boolean\n```
//                                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL(+1).
//                                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                                                                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().(prepared)
  
      /** Returns the string representation of an SQL query, generated by appending SQL expressions to a [QueryBuilder]. **/
      open fun prepareSQL(builder: QueryBuilder): String {
//             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL(+1).
//                        display_name prepareSQL
//                        documentation ```kotlin\npublic open fun prepareSQL(builder: QueryBuilder): String\n```\n\n----\n\n Returns the string representation of an SQL query, generated by appending SQL expressions to a [QueryBuilder].
//                        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL(+1).(builder)
//                                display_name builder
//                                documentation ```kotlin\nbuilder: QueryBuilder\n```
//                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                ^^^^^^ reference semanticdb maven . . kotlin/String#
          require(set.fields.isNotEmpty()) { "Can't prepare SELECT statement without columns or expressions to retrieve" }
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getSet().
//                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#set.
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#fields.
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getFields().
//                           ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
  
          builder {
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL(+1).(builder)
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
              comments[CommentPosition.FRONT]?.let { comment ->
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comments.
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getComments().
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setComments().
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#CommentPosition#FRONT.
//                                             ^^^ reference semanticdb maven . . kotlin/let().
//                                                   ^^^^^^^ definition semanticdb maven . . (comment)
//                                                           display_name comment
//                                                           documentation ```kotlin\ncomment: String\n```
                  append("/*$comment*/ ")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                           ^^^^^^^ reference semanticdb maven . . (comment)
              }
  
              append("SELECT ")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
  
              comments[CommentPosition.AFTER_SELECT]?.let { comment ->
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comments.
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getComments().
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setComments().
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#CommentPosition#AFTER_SELECT.
//                                                    ^^^ reference semanticdb maven . . kotlin/let().
//                                                          ^^^^^^^ definition semanticdb maven . . (comment)
//                                                                  display_name comment
//                                                                  documentation ```kotlin\ncomment: String\n```
                  append("/*$comment*/ ")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                           ^^^^^^^ reference semanticdb maven . . (comment)
              }
  
              if (count) {
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#count.
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getCount().
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setCount().
                  append("COUNT(*)")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
              } else {
                  if (distinct) {
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#distinct.
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getDistinct().
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setDistinct().
                      append("DISTINCT ")
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                  }
                  distinctOn
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#distinctOn.
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getDistinctOn().
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setDistinctOn().
                      ?.takeIf { it.isNotEmpty() }
//                      ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                             ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                 display_name it
//                                                 documentation ```kotlin\nit: Op<Boolean>\n```
//                               ^^ reference semanticdb maven . . (it)
//                                  ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
                      ?.let { columns ->
//                      ^^^ reference semanticdb maven . . kotlin/let().
//                            ^^^^^^^ definition semanticdb maven . . (columns)
//                                    display_name columns
//                                    documentation ```kotlin\ncolumns: List<Column<*>>\n```
                          columns.appendTo(prefix = "DISTINCT ON (", postfix = ") ") { append(it) }
//                        ^^^^^^^ reference semanticdb maven . . (columns)
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                                                   ^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                  display_name it
//                                                                                                  documentation ```kotlin\nit: Op<Boolean>\n```
//                                                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                                                                                            ^^ reference semanticdb maven . . (it)
                      }
                  set.realFields.appendTo { +it }
//                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getSet().
//                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#set.
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getRealFields().
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#realFields.
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                        ^^^^^^^ definition semanticdb maven . . (it)
//                                                display_name it
//                                                documentation ```kotlin\nit: Op<Boolean>\n```
//                                          ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                           ^^ reference semanticdb maven . . (it)
              }
              @OptIn(InternalApi::class)
              if (set.source != Table.Dual || currentDialect.supportsDualTableConcept) {
//                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getSet().
//                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#set.
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getSource().
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#source.
//                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsDualTableConcept().
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsDualTableConcept.
                  append(" FROM ")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                  set.source.describe(CoreTransactionManager.currentTransaction(), this)
//                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getSet().
//                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#set.
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getSource().
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#source.
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().
//                                                           ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
              }
  
              where?.let {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getWhere().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setWhere().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#where.
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^ definition semanticdb maven . . (it) 3:13
//                         display_name it
//                         documentation ```kotlin\nit: Op<Boolean>\n```
                  append(" WHERE ")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                  +it
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                 ^^ reference semanticdb maven . . (it)
              }
  
              if (!count) {
//                ^ reference semanticdb maven . . kotlin/Boolean#not().
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#count.
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getCount().
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setCount().
                  if (groupedByColumns.isNotEmpty()) {
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getGroupedByColumns().
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#groupedByColumns.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setGroupedByColumns().
//                                     ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
                      append(" GROUP BY ")
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                      groupedByColumns.appendTo {
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getGroupedByColumns().
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#groupedByColumns.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setGroupedByColumns().
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                              ^ definition semanticdb maven . . (it) 2:21
//                                                display_name it
//                                                documentation ```kotlin\nit: Op<Boolean>\n```
                          +((it as? IExpressionAlias<*>)?.aliasOnlyExpression() ?: it)
//                        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                           ^^ reference semanticdb maven . . (it)
//                                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#aliasOnlyExpression().
//                                                                                 ^^ reference semanticdb maven . . (it)
                      }
                  }
  
                  having?.let {
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getHaving().
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#having.
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setHaving().
//                        ^^^ reference semanticdb maven . . kotlin/let().
//                            ^ definition semanticdb maven . . (it) 3:17
//                              display_name it
//                              documentation ```kotlin\nit: Op<Boolean>\n```
                      append(" HAVING ")
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                      append(it)
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                           ^^ reference semanticdb maven . . (it)
                  }
  
                  if (orderByExpressions.isNotEmpty()) {
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getOrderByExpressions().
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#orderByExpressions.
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setOrderByExpressions().
//                                       ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
                      append(" ORDER BY ")
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                      orderByExpressions.appendTo { (expression, sortOrder) ->
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getOrderByExpressions().
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#orderByExpressions.
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setOrderByExpressions().
//                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                                          display_name <destruct>
//                                                                          documentation ```kotlin\n<destruct>: Pair<Expression<*>, SortOrder>\n```
//                                                   ^^^^^^^^^^ definition local 3
//                                                              display_name expression
//                                                              documentation ```kotlin\nlocal val expression: Expression<*>\n```
//                                                   ^^^^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                   ^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                               ^^^^^^^^^ definition local 4
//                                                                         display_name sortOrder
//                                                                         documentation ```kotlin\nlocal val sortOrder: SortOrder\n```
//                                                               ^^^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
                          currentDialect.dataTypeProvider.precessOrderByClause(this, expression, sortOrder)
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                        ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().
//                                                                                   ^^^^^^^^^^ reference local 3
//                                                                                               ^^^^^^^^^ reference local 4
                      }
                  }
  
                  if (limit != null || offset > 0) {
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getLimit().
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#limit.
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setLimit().
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getOffset().
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#offset.
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setOffset().
//                                            ^ reference semanticdb maven . . kotlin/Long#compareTo(+2).
                      append(" ")
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                      append(currentDialect.functionProvider.queryLimitAndOffset(limit, offset, orderByExpressions.isNotEmpty()))
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                                           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().
//                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getLimit().
//                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#limit.
//                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setLimit().
//                                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getOffset().
//                                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#offset.
//                                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setOffset().
//                                                                                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getOrderByExpressions().
//                                                                                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#orderByExpressions.
//                                                                                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setOrderByExpressions().
//                                                                                                                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
                  }
              }
  
              if (isForUpdate()) {
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#isForUpdate().
                  forUpdate?.apply {
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#forUpdate.
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getForUpdate().
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setForUpdate().
//                           ^^^^^ reference semanticdb maven . . kotlin/apply().
                      append(" $querySuffix")
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#getQuerySuffix().
//                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#querySuffix.
                  }
              }
  
              comments[CommentPosition.BACK]?.let { comment ->
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#comments.
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getComments().
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#setComments().
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#CommentPosition#BACK.
//                                            ^^^ reference semanticdb maven . . kotlin/let().
//                                                  ^^^^^^^ definition semanticdb maven . . (comment)
//                                                          display_name comment
//                                                          documentation ```kotlin\ncomment: String\n```
                  append(" /*$comment*/")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                            ^^^^^^^ reference semanticdb maven . . (comment)
              }
          }
          return builder.toString()
//               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL(+1).(builder)
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
      }
  
      /** Represents the position at which an SQL comment will be added in a `SELECT` query. */
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Enum# 10:5
      enum class CommentPosition {
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#CommentPosition#
//                               display_name CommentPosition
//                               documentation ```kotlin\npublic final enum class CommentPosition : Enum<AbstractQuery.CommentPosition>\n```\n\n----\n\n Represents the position at which an SQL comment will be added in a `SELECT` query.
//                               relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#CommentPosition#`<init>`().
//                               display_name CommentPosition
//                               documentation ```kotlin\nprivate constructor(): AbstractQuery.CommentPosition\n```\n\n----\n\n Represents the position at which an SQL comment will be added in a `SELECT` query.
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#CommentPosition#entries.
//                               display_name entries
//                               documentation ```kotlin\npublic final static val entries: EnumEntries<AbstractQuery.CommentPosition>\n```\n\n----\n\n Represents the position at which an SQL comment will be added in a `SELECT` query.
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#CommentPosition#valueOf().
//                               display_name valueOf
//                               documentation ```kotlin\npublic final static fun valueOf(value: String): AbstractQuery.CommentPosition\n```\n\n----\n\n Represents the position at which an SQL comment will be added in a `SELECT` query.
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#CommentPosition#valueOf().(value)
//                               display_name value
//                               documentation ```kotlin\nvalue: String\n```\n\n----\n\n Represents the position at which an SQL comment will be added in a `SELECT` query.
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#CommentPosition#values().
//                               display_name values
//                               documentation ```kotlin\npublic final static fun values(): Array<AbstractQuery.CommentPosition>\n```\n\n----\n\n Represents the position at which an SQL comment will be added in a `SELECT` query.
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/getEntries().
//                               display_name entries
//                               documentation ```kotlin\npublic get(): EnumEntries<AbstractQuery.CommentPosition>\n```\n\n----\n\n Represents the position at which an SQL comment will be added in a `SELECT` query.
          /** The start of the query, before the keyword `SELECT`. */
          FRONT,
  
          /** Immediately following the keyword `SELECT`. */
          AFTER_SELECT,
  
          /** The end of the query, after all clauses. */
          BACK
      }
  }
