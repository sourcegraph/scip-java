  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  import org.jetbrains.exposed.v1.core.dao.id.CompositeID
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
//                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
  import org.jetbrains.exposed.v1.core.dao.id.CompositeIdTable
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
//                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#
  import org.jetbrains.exposed.v1.core.dao.id.EntityID
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
//                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
  import org.jetbrains.exposed.v1.core.statements.api.RowApi
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#
  import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#
  import org.jetbrains.exposed.v1.core.vendors.withDialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/withDialect().
  
  /** A row of data representing a single record retrieved from a database result set. */
  class ResultRow(
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#
//                display_name ResultRow
//                documentation ```kotlin\npublic final class ResultRow : Any\n```\n\n----\n\n A row of data representing a single record retrieved from a database result set.
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().
//                display_name ResultRow
//                documentation ```kotlin\npublic constructor(fieldIndex: Map<Expression<*>, Int>, data: Array<Any?> = ...): ResultRow\n```\n\n----\n\n Mapping of the expressions stored on this row to their index positions.
      /** Mapping of the expressions stored on this row to their index positions. */
      val fieldIndex: Map<Expression<*>, Int>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().(fieldIndex)
//                   display_name fieldIndex
//                   documentation ```kotlin\nfieldIndex: Map<Expression<*>, Int>\n```\n\n----\n\n Mapping of the expressions stored on this row to their index positions.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().(fieldIndex)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#fieldIndex.
//                   display_name fieldIndex
//                   documentation ```kotlin\npublic final val fieldIndex: Map<Expression<*>, Int>\n```\n\n----\n\n Mapping of the expressions stored on this row to their index positions.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getFieldIndex().
//                   display_name fieldIndex
//                   documentation ```kotlin\npublic get(): Map<Expression<*>, Int>\n```\n\n----\n\n Mapping of the expressions stored on this row to their index positions.
//                    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
      private val data: Array<Any?> = arrayOfNulls<Any?>(fieldIndex.size)
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().(data)
//                     display_name data
//                     documentation ```kotlin\ndata: Array<Any?> = ...\n```
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().(data)
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#data.
//                     display_name data
//                     documentation ```kotlin\nprivate final val data: Array<Any?>\n```
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getData().
//                     display_name data
//                     documentation ```kotlin\nprivate get(): Array<Any?>\n```
//                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/arrayOfNulls().
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().(fieldIndex)
//                                                                  ^^^^ reference semanticdb maven . . kotlin/collections/Map#getSize().
//                                                                  ^^^^ reference semanticdb maven . . kotlin/collections/Map#size.
  ) {
      @OptIn(InternalApi::class)
      private val database: DatabaseApi? = CoreTransactionManager.currentTransactionOrNull()?.db
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#database.
//                         display_name database
//                         documentation ```kotlin\n@OptIn(...) private final val database: DatabaseApi?\n```
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getDatabase().
//                         display_name database
//                         documentation ```kotlin\nprivate get(): DatabaseApi?\n```
//                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#
//                                                                ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransactionOrNull().
//                                                                                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                                                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
  
      private val lookUpCache = ResultRowCache()
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getLookUpCache().
//                            display_name lookUpCache
//                            documentation ```kotlin\nprivate get(): ResultRow.ResultRowCache\n```
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#lookUpCache.
//                            display_name lookUpCache
//                            documentation ```kotlin\nprivate final val lookUpCache: ResultRow.ResultRowCache\n```
//                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#`<init>`().
  
      /**
       * Retrieves the value of a given expression on this row.
       *
       * @param expression expression to evaluate
       * @throws IllegalStateException if expression is not in record set or if result value is uninitialized
       *
       * @see [getOrNull] to get null in the cases an exception would be thrown
       */
      @Suppress("UNCHECKED_CAST")
      operator fun <T> get(expression: Expression<T>): T {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().
//                         display_name get
//                         documentation ```kotlin\n@Suppress(...) public final operator fun <T> get(expression: Expression<T>): T\n```\n\n----\n\n\n Retrieves the value of a given expression on this row.\n\n @param expression expression to evaluate\n @throws IllegalStateException if expression is not in record set or if result value is uninitialized\n\n @see [getOrNull] to get null in the cases an exception would be thrown\n
//                         ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().(expression)
//                                    display_name expression
//                                    documentation ```kotlin\nexpression: Expression<T>\n```
//                                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          val column = expression as? Column<*>
//            ^^^^^^ definition local 0
//                   display_name column
//                   documentation ```kotlin\nlocal val column: Column<*>?\n```
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().(expression)
          return when {
              column?.isEntityIdentifier() == true && column.table is CompositeIdTable -> {
//            ^^^^^^ reference local 0
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isEntityIdentifier().
//                                                    ^^^^^^ reference local 0
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
                  val resultID = CompositeID {
//                    ^^^^^^^^ definition local 1
//                             display_name resultID
//                             documentation ```kotlin\nlocal val resultID: CompositeID\n```
//                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#invoke().
//                                           ^ definition semanticdb maven . . (it) 4:17
//                                             display_name it
//                                             documentation ```kotlin\nit: IndexedValue<Column<*>>\n```
                      column.table.idColumns.forEach { column ->
//                    ^^^^^^ reference local 0
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#getIdColumns().
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#idColumns.
//                                           ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                                     ^^^^^^ definition semanticdb maven . . (column)
//                                                            display_name column
//                                                            documentation ```kotlin\ncolumn: Column<out Any>\n```
                          it[column as Column<EntityID<Any>>] = getInternal(column, checkNullability = true).value
//                        ^^ reference semanticdb maven . . (it)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().
//                           ^^^^^^ reference semanticdb maven . . (column)
//                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().
//                                                                          ^^^^^^ reference semanticdb maven . . (column)
//                                                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                                                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
                      }
                  }
                  EntityID(resultID, column.table) as T
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                         ^^^^^^^^ reference local 1
//                                   ^^^^^^ reference local 0
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
              }
              else -> getInternal(expression, checkNullability = true)
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().(expression)
          }
      }
  
      /**
       * Sets the value of a given expression on this row.
       *
       * @param expression expression for which to set the value
       * @param value value to be set for the given expression
       */
      operator fun <T> set(expression: Expression<out T>, value: T) {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#set().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#set().
//                         display_name set
//                         documentation ```kotlin\npublic final operator fun <T> set(expression: Expression<out T>, value: T): Unit\n```\n\n----\n\n\n Sets the value of a given expression on this row.\n\n @param expression expression for which to set the value\n @param value value to be set for the given expression\n
//                         ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#set().(expression)
//                                    display_name expression
//                                    documentation ```kotlin\nexpression: Expression<out T>\n```
//                                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#set().(value)
//                                                              display_name value
//                                                              documentation ```kotlin\nvalue: T\n```
          setInternal(expression, value)
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#set().(expression)
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#set().(value)
          lookUpCache.remove(expression)
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getLookUpCache().
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#lookUpCache.
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#remove().
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#set().(expression)
      }
  
      private fun <T> setInternal(expression: Expression<out T>, value: T) {
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().
//                                display_name setInternal
//                                documentation ```kotlin\nprivate final fun <T> setInternal(expression: Expression<out T>, value: T): Unit\n```
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().(expression)
//                                           display_name expression
//                                           documentation ```kotlin\nexpression: Expression<out T>\n```
//                                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().(value)
//                                                                     display_name value
//                                                                     documentation ```kotlin\nvalue: T\n```
          val index = getExpressionIndex(expression)
//            ^^^^^ definition local 2
//                  display_name index
//                  documentation ```kotlin\nlocal val index: Int\n```
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().(expression)
          data[index] = value
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#data.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getData().
//        ^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#set().
//             ^^^^^ reference local 2
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().(value)
      }
  
      /** Whether the given [expression] has been initialized with a value on this row. */
      fun <T> hasValue(expression: Expression<T>): Boolean = fieldIndex[expression]?.let { data[it] != NotInitializedValue } ?: false
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#hasValue().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//            ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#hasValue().
//                     display_name hasValue
//                     documentation ```kotlin\npublic final fun <T> hasValue(expression: Expression<T>): Boolean\n```\n\n----\n\n Whether the given [expression] has been initialized with a value on this row.
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#hasValue().(expression)
//                                display_name expression
//                                documentation ```kotlin\nexpression: Expression<T>\n```
//                                 ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#fieldIndex.
//                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getFieldIndex().
//                                                           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#hasValue().(expression)
//                                                                                   ^^^ reference semanticdb maven . . kotlin/let().
//                                                                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                           display_name it
//                                                                                                                           documentation ```kotlin\nit: IndexedValue<Column<*>>\n```
//                                                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#data.
//                                                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getData().
//                                                                                         ^^^^^^^^ reference semanticdb maven . . kotlin/Array#get().
//                                                                                              ^^ reference semanticdb maven . . (it)
  
      /**
       * Retrieves the value of a given expression on this row.
       * Returns null in the cases an exception would be thrown in [get].
       *
       * @param expression expression to evaluate
       */
      fun <T> getOrNull(expression: Expression<T>): T? = if (hasValue(expression)) getInternal(expression, checkNullability = false) else null
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getOrNull().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getOrNull().
//                      display_name getOrNull
//                      documentation ```kotlin\npublic final fun <T> getOrNull(expression: Expression<T>): T?\n```\n\n----\n\n\n Retrieves the value of a given expression on this row.\n Returns null in the cases an exception would be thrown in [get].\n\n @param expression expression to evaluate\n
//                      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getOrNull().(expression)
//                                 display_name expression
//                                 documentation ```kotlin\nexpression: Expression<T>\n```
//                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#hasValue().
//                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getOrNull().(expression)
//                                                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getOrNull().(expression)
  
      @OptIn(InternalApi::class)
      private fun <T> getInternal(expression: Expression<T>, checkNullability: Boolean): T = lookUpCache.cached(expression) {
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().
//                                display_name getInternal
//                                documentation ```kotlin\n@OptIn(...) private final fun <T> getInternal(expression: Expression<T>, checkNullability: Boolean): T\n```
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(expression)
//                                           display_name expression
//                                           documentation ```kotlin\nexpression: Expression<T>\n```
//                                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(checkNullability)
//                                                                            display_name checkNullability
//                                                                            documentation ```kotlin\ncheckNullability: Boolean\n```
//                                                                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getLookUpCache().
//                                                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#lookUpCache.
//                                                                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#cached().
//                                                                                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(expression)
          val rawValue = getRaw(expression)
//            ^^^^^^^^ definition local 3
//                     display_name rawValue
//                     documentation ```kotlin\nlocal val rawValue: T?\n```
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(expression)
  
          if (checkNullability) {
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(checkNullability)
              if (rawValue == null && expression is Column<*> && expression.dbDefaultValue != null && !expression.columnType.nullable) {
//                ^^^^^^^^ reference local 3
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(expression)
//                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(expression)
//                                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                                                                    ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(expression)
//                                                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                                                                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                                                                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
                  exposedLogger.warn(
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                              ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
                      "Column ${CoreTransactionManager.currentTransaction().fullIdentity(expression)} is marked as not null, " +
//                                                     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity().
//                                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(expression)
                          "has default db value, but returns null. Possible have to re-read it from DB."
                  )
              }
          }
  
          database?.dialect?.let {
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#database.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getDatabase().
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
//                           ^^^ reference semanticdb maven . . kotlin/let().
//                               ^ definition semanticdb maven . . (it) 4:9
//                                 display_name it
//                                 documentation ```kotlin\nit: IndexedValue<Column<*>>\n```
              withDialect(it) {
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/withDialect().
//                        ^^ reference semanticdb maven . . (it)
                  rawToColumnValue(rawValue, expression)
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().
//                                 ^^^^^^^^ reference local 3
//                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(expression)
              }
          } ?: rawToColumnValue(rawValue, expression)
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().
//                              ^^^^^^^^ reference local 3
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(expression)
      }
  
      @Suppress("UNCHECKED_CAST")
      private fun <T> rawToColumnValue(raw: T?, expression: Expression<T>): T {
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().
//                                     display_name rawToColumnValue
//                                     documentation ```kotlin\n@Suppress(...) private final fun <T> rawToColumnValue(raw: T?, expression: Expression<T>): T\n```
//                                     ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
//                                         display_name raw
//                                         documentation ```kotlin\nraw: T?\n```
//                                              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
//                                                         display_name expression
//                                                         documentation ```kotlin\nexpression: Expression<T>\n```
//                                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          return when {
              raw == null -> null
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
              raw == NotInitializedValue -> error("$expression is not initialized yet")
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
//                                          ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
              expression is ExpressionWithColumnTypeAlias<T> -> rawToColumnValue(raw, expression.delegate)
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
//                                                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().
//                                                                               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
//                                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
//                                                                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#delegate.
//                                                                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#getDelegate().
              expression is ExpressionAlias<T> -> rawToColumnValue(raw, expression.delegate)
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().
//                                                                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
//                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
//                                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#delegate.
//                                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#getDelegate().
              expression is ExpressionWithColumnType<T> -> expression.columnType.valueFromDB(raw)
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
//                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
//                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueFromDB().
//                                                                                           ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
              expression is Op.OpBoolean -> BooleanColumnType.INSTANCE.valueFromDB(raw)
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
//                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#Companion#INSTANCE.
//                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#Companion#getINSTANCE().
//                                                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#valueFromDB().
//                                                                                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
              else -> raw
//                    ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
          } as T
      }
  
      @Suppress("UNCHECKED_CAST")
      private fun <T> getRaw(expression: Expression<T>): T? {
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().
//                           display_name getRaw
//                           documentation ```kotlin\n@Suppress(...) private final fun <T> getRaw(expression: Expression<T>): T?\n```
//                           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().(expression)
//                                      display_name expression
//                                      documentation ```kotlin\nexpression: Expression<T>\n```
//                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          if (expression is CompositeColumn<T>) {
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().(expression)
              val rawParts = expression.getRealColumns().associateWith { getRaw(it) }
//                ^^^^^^^^ definition local 4
//                         display_name rawParts
//                         documentation ```kotlin\nlocal val rawParts: Map<Column<*>, Any?>\n```
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().(expression)
//                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumns().
//                                                       ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/associateWith(+9).
//                                                                     ^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                    display_name it
//                                                                                    documentation ```kotlin\nit: IndexedValue<Column<*>>\n```
//                                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().
//                                                                              ^^ reference semanticdb maven . . (it)
              return expression.restoreValueFromParts(rawParts)
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().(expression)
//                              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#restoreValueFromParts().
//                                                    ^^^^^^^^ reference local 4
          }
  
          val index = getExpressionIndex(expression)
//            ^^^^^ definition local 5
//                  display_name index
//                  documentation ```kotlin\nlocal val index: Int\n```
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().(expression)
          return data[index] as T?
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#data.
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getData().
//               ^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#get().
//                    ^^^^^ reference local 5
      }
  
      /**
       * Retrieves the index of a given expression in the [fieldIndex] map.
       *
       * @param expression expression for which to get the index
       * @throws IllegalStateException if expression is not in record set
       */
      private fun <T> getExpressionIndex(expression: Expression<T>): Int {
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().
//                                       display_name getExpressionIndex
//                                       documentation ```kotlin\nprivate final fun <T> getExpressionIndex(expression: Expression<T>): Int\n```\n\n----\n\n\n Retrieves the index of a given expression in the [fieldIndex] map.\n\n @param expression expression for which to get the index\n @throws IllegalStateException if expression is not in record set\n
//                                       ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().(expression)
//                                                  display_name expression
//                                                  documentation ```kotlin\nexpression: Expression<T>\n```
//                                                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                   ^^^ reference semanticdb maven . . kotlin/Int#
          return fieldIndex[expression]
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#fieldIndex.
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getFieldIndex().
//               ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().(expression)
              ?: fieldIndex.keys.firstOrNull { exp ->
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#fieldIndex.
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getFieldIndex().
//                          ^^^^ reference semanticdb maven . . kotlin/collections/Map#getKeys().
//                          ^^^^ reference semanticdb maven . . kotlin/collections/Map#keys.
//                               ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+20).
//                                             ^^^ definition semanticdb maven . . (exp)
//                                                 display_name exp
//                                                 documentation ```kotlin\nexp: Expression<*>\n```
                  when (exp) {
//                      ^^^ reference semanticdb maven . . (exp)
                      is Column<*> -> (exp.columnType as? EntityIDColumnType<*>)?.idColumn == expression
//                                     ^^^ reference semanticdb maven . . (exp)
//                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().(expression)
                      is IExpressionAlias<*> -> exp.delegate == expression
//                                              ^^^ reference semanticdb maven . . (exp)
//                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#delegate.
//                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getDelegate().
//                                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().(expression)
                      else -> false
                  }
              }?.let { exp -> fieldIndex[exp] }
//               ^^^ reference semanticdb maven . . kotlin/let().
//                     ^^^ definition semanticdb maven . . (exp)
//                         display_name exp
//                         documentation ```kotlin\nexp: Expression<*>\n```
//                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#fieldIndex.
//                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getFieldIndex().
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                       ^^^ reference semanticdb maven . . (exp)
              ?: error("$expression is not in record set")
//               ^^^^^ reference semanticdb maven . . kotlin/error().
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().(expression)
      }
  
      override fun toString(): String =
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#toString().
//                          display_name toString
//                          documentation ```kotlin\npublic open override fun toString(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
          fieldIndex.entries.joinToString { "${it.key}=${data[it.value]}" }
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#fieldIndex.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getFieldIndex().
//                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#entries.
//                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#getEntries().
//                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                          display_name it
//                                                                          documentation ```kotlin\nit: IndexedValue<Column<*>>\n```
//                                             ^^ reference semanticdb maven . . (it)
//                                                ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getKey().
//                                                ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#key.
//                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#data.
//                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getData().
//                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#get().
//                                                            ^^ reference semanticdb maven . . (it)
//                                                               ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getValue().
//                                                               ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#value.
  
      internal object NotInitializedValue
//                    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#NotInitializedValue#
//                                        display_name NotInitializedValue
//                                        documentation ```kotlin\ninternal final object NotInitializedValue : Any\n```
//                    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#NotInitializedValue#`<init>`().
//                                        display_name NotInitializedValue
//                                        documentation ```kotlin\nprivate constructor(): ResultRow.NotInitializedValue\n```
  
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion# 35:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```\n\n----\n\n Creates a [ResultRow] storing all expressions in [fieldsIndex] with their values retrieved from a [RowApi].
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#`<init>`(). 35:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): ResultRow.Companion\n```\n\n----\n\n Creates a [ResultRow] storing all expressions in [fieldsIndex] with their values retrieved from a [RowApi].
          /** Creates a [ResultRow] storing all expressions in [fieldsIndex] with their values retrieved from a [RowApi]. */
          fun create(rs: RowApi, fieldsIndex: Map<Expression<*>, Int>): ResultRow {
//            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().
//                   display_name create
//                   documentation ```kotlin\npublic final fun create(rs: RowApi, fieldsIndex: Map<Expression<*>, Int>): ResultRow\n```\n\n----\n\n Creates a [ResultRow] storing all expressions in [fieldsIndex] with their values retrieved from a [RowApi].
//                   ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().(rs)
//                      display_name rs
//                      documentation ```kotlin\nrs: RowApi\n```
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#
//                               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().(fieldsIndex)
//                                           display_name fieldsIndex
//                                           documentation ```kotlin\nfieldsIndex: Map<Expression<*>, Int>\n```
//                                            ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#
              return ResultRow(fieldsIndex).apply {
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().(fieldsIndex)
//                                          ^^^^^ reference semanticdb maven . . kotlin/apply().
                  fieldsIndex.forEach { (field, index) ->
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().(fieldsIndex)
//                            ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                                      ^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                     display_name <destruct>
//                                                     documentation ```kotlin\n<destruct>: Map.Entry<Expression<*>, Int>\n```
//                                       ^^^^^ definition local 6
//                                             display_name field
//                                             documentation ```kotlin\nlocal val field: Expression<*>\n```
//                                       ^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                       ^^^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                              ^^^^^ definition local 7
//                                                    display_name index
//                                                    documentation ```kotlin\nlocal val index: Int\n```
//                                              ^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                              ^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
                      val columnType: IColumnType<out Any>? = (field as? ExpressionWithColumnType)?.columnType
//                        ^^^^^^^^^^ definition local 8
//                                   display_name columnType
//                                   documentation ```kotlin\nlocal val columnType: IColumnType<out Any>?\n```
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                             ^^^^^ reference local 6
//                                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
                      val value = if (columnType != null) {
//                        ^^^^^ definition local 9
//                              display_name value
//                              documentation ```kotlin\nlocal val value: Any?\n```
//                                    ^^^^^^^^^^ reference local 8
                          columnType.readObject(rs, index + 1)
//                        ^^^^^^^^^^ reference local 8
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#readObject().
//                                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().(rs)
//                                                  ^^^^^ reference local 7
//                                                        ^ reference semanticdb maven . . kotlin/Int#plus(+2).
                      } else {
                          rs.getObject(index + 1)
//                        ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().(rs)
//                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject().
//                                     ^^^^^ reference local 7
//                                           ^ reference semanticdb maven . . kotlin/Int#plus(+2).
                      }
                      data[index] = value
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#data.
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getData().
//                    ^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#set().
//                         ^^^^^ reference local 7
//                                  ^^^^^ reference local 9
                  }
              }
          }
  
          /** Creates a [ResultRow] using the expressions and values provided by [data]. */
          fun createAndFillValues(data: Map<Expression<*>, Any?>): ResultRow {
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillValues().
//                                display_name createAndFillValues
//                                documentation ```kotlin\npublic final fun createAndFillValues(data: Map<Expression<*>, Any?>): ResultRow\n```\n\n----\n\n Creates a [ResultRow] using the expressions and values provided by [data].
//                                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillValues().(data)
//                                     display_name data
//                                     documentation ```kotlin\ndata: Map<Expression<*>, Any?>\n```
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#
              val fieldIndex = HashMap<Expression<*>, Int>(data.size)
//                ^^^^^^^^^^ definition local 10
//                           display_name fieldIndex
//                           documentation ```kotlin\nlocal val fieldIndex: {kotlin/collections/HashMap<org/jetbrains/exposed/v1/core/Expression<*>, kotlin/Int>=} HashMap<Expression<*>, Int>\n```
//                             ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashMap#`<init>`().
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillValues().(data)
//                                                              ^^^^ reference semanticdb maven . . kotlin/collections/Map#getSize().
//                                                              ^^^^ reference semanticdb maven . . kotlin/collections/Map#size.
              val values = arrayOfNulls<Any?>(data.size)
//                ^^^^^^ definition local 11
//                       display_name values
//                       documentation ```kotlin\nlocal val values: Array<Any?>\n```
//                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/arrayOfNulls().
//                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillValues().(data)
//                                                 ^^^^ reference semanticdb maven . . kotlin/collections/Map#getSize().
//                                                 ^^^^ reference semanticdb maven . . kotlin/collections/Map#size.
              data.entries.forEachIndexed { i, columnAndValue ->
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillValues().(data)
//                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#entries.
//                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#getEntries().
//                         ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/forEachIndexed(+9).
//                                          ^ definition semanticdb maven . . (i)
//                                            display_name i
//                                            documentation ```kotlin\ni: Int\n```
//                                             ^^^^^^^^^^^^^^ definition semanticdb maven . . (columnAndValue)
//                                                            display_name columnAndValue
//                                                            documentation ```kotlin\ncolumnAndValue: Map.Entry<Expression<*>, Any?>\n```
                  val (column, value) = columnAndValue
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 12
//                                                     display_name <destruct>
//                                                     documentation ```kotlin\nlocal val <destruct>: Map.Entry<Expression<*>, Any?>\n```
//                     ^^^^^^ reference local 12
//                     ^^^^^^ definition local 13
//                            display_name column
//                            documentation ```kotlin\nlocal val column: Expression<*>\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                             ^^^^^ reference local 12
//                             ^^^^^ definition local 14
//                                   display_name value
//                                   documentation ```kotlin\nlocal val value: Any?\n```
//                             ^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
//                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . (columnAndValue)
                  fieldIndex[column] = i
//                ^^^^^^^^^^ reference local 10
//                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//                           ^^^^^^ reference local 13
//                                     ^ reference semanticdb maven . . (i)
                  values[i] = value
//                ^^^^^^ reference local 11
//                ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#set().
//                       ^ reference semanticdb maven . . (i)
//                            ^^^^^ reference local 14
              }
              return ResultRow(fieldIndex, values)
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().
//                             ^^^^^^^^^^ reference local 10
//                                         ^^^^^^ reference local 11
          }
  
          /** Creates a [ResultRow] storing [columns] with their default or nullable values. */
          fun createAndFillDefaults(columns: List<Column<*>>): ResultRow =
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillDefaults().
//                                  display_name createAndFillDefaults
//                                  documentation ```kotlin\npublic final fun createAndFillDefaults(columns: List<Column<*>>): ResultRow\n```\n\n----\n\n Creates a [ResultRow] storing [columns] with their default or nullable values.
//                                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillDefaults().(columns)
//                                          display_name columns
//                                          documentation ```kotlin\ncolumns: List<Column<*>>\n```
//                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#
              ResultRow(columns.withIndex().associate { it.value to it.index }).apply {
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillDefaults().(columns)
//                              ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/withIndex(+10).
//                                          ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/associate(+9).
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                             display_name it
//                                                                             documentation ```kotlin\nit: IndexedValue<Column<*>>\n```
//                                                      ^^ reference semanticdb maven . . (it)
//                                                         ^^^^^ reference semanticdb maven . . kotlin/collections/IndexedValue#getValue().
//                                                         ^^^^^ reference semanticdb maven . . kotlin/collections/IndexedValue#value.
//                                                               ^^ reference semanticdb maven . . kotlin/to().
//                                                                  ^^ reference semanticdb maven . . (it)
//                                                                     ^^^^^ reference semanticdb maven . . kotlin/collections/IndexedValue#getIndex().
//                                                                     ^^^^^ reference semanticdb maven . . kotlin/collections/IndexedValue#index.
//                                                                              ^^^^^ reference semanticdb maven . . kotlin/apply().
                  columns.forEach {
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillDefaults().(columns)
//                        ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                ^ definition semanticdb maven . . (it) 2:17
//                                  display_name it
//                                  documentation ```kotlin\nit: IndexedValue<Column<*>>\n```
                      setInternal(it, it.defaultValueOrNotInitialized())
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().
//                                ^^ reference semanticdb maven . . (it)
//                                    ^^ reference semanticdb maven . . (it)
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#defaultValueOrNotInitialized().
                  }
              }
      }
  
      private fun <T> Column<T>.defaultValueOrNotInitialized(): Any? {
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#defaultValueOrNotInitialized().[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#defaultValueOrNotInitialized().
//                                                           display_name defaultValueOrNotInitialized
//                                                           documentation ```kotlin\nprivate final fun <T> Column<T>.defaultValueOrNotInitialized(): Any?\n```
//                                                              ^^^^ reference semanticdb maven . . kotlin/Any#
          return when {
              defaultValueFun != null -> when {
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
                  columnType is ColumnWithTransform<*, *> -> {
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
                      (columnType as ColumnWithTransform<Any, Any>).unwrapRecursive(defaultValueFun!!())
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#unwrapRecursive().
//                                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                                                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function0#invoke().
                  }
                  else -> defaultValueFun!!()
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function0#invoke().
              }
              columnType.nullable -> null
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
              else -> NotInitializedValue
          }
      }
  
      /**
       * [ResultRowCache] caches the values on reads by `expression`. The value cached by pair of `expression` itself and `columnType` of that expression.
       * It solves the problem of "equal" expression with different column type (like the same column with original type and [EntityIDColumnType])
       */
      private class ResultRowCache {
//                  ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#
//                                 display_name ResultRowCache
//                                 documentation ```kotlin\nprivate final class ResultRowCache : Any\n```\n\n----\n\n\n [ResultRowCache] caches the values on reads by `expression`. The value cached by pair of `expression` itself and `columnType` of that expression.\n It solves the problem of "equal" expression with different column type (like the same column with original type and [EntityIDColumnType])\n
//                  ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#`<init>`().
//                                 display_name ResultRowCache
//                                 documentation ```kotlin\npublic constructor(): ResultRow.ResultRowCache\n```\n\n----\n\n\n [ResultRowCache] caches the values on reads by `expression`. The value cached by pair of `expression` itself and `columnType` of that expression.\n It solves the problem of "equal" expression with different column type (like the same column with original type and [EntityIDColumnType])\n
          private val values: MutableMap<Pair<Expression<*>, IColumnType<*>?>, Any?> = mutableMapOf()
//                    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#getValues().
//                           display_name values
//                           documentation ```kotlin\nprivate get(): MutableMap<Pair<Expression<*>, IColumnType<*>?>, Any?>\n```
//                    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#values.
//                           display_name values
//                           documentation ```kotlin\nprivate final val values: MutableMap<Pair<Expression<*>, IColumnType<*>?>, Any?>\n```
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableMapOf().
  
          /**
           * Wrapping function that accept the expression and target function.
           * The function would be called if the value not found in the cache.
           *
           * @param expression is the key of caching
           * @param initializer function that returns the new value if the cache missed
           */
          fun <T> cached(expression: Expression<*>, initializer: () -> T): T = values.getOrPut(key(expression), initializer) as T
//             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#cached().[T]
//               display_name FirTypeParameterSymbol T
//               documentation ```kotlin\nT\n```
//                ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#cached().
//                       display_name cached
//                       documentation ```kotlin\npublic final fun <T> cached(expression: Expression<*>, initializer: () -> T): T\n```\n\n----\n\n\n Wrapping function that accept the expression and target function.\n The function would be called if the value not found in the cache.\n\n @param expression is the key of caching\n @param initializer function that returns the new value if the cache missed\n
//                       ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#cached().(expression)
//                                  display_name expression
//                                  documentation ```kotlin\nexpression: Expression<*>\n```
//                                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                  ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#cached().(initializer)
//                                                              display_name initializer
//                                                              documentation ```kotlin\ninitializer: () -> T\n```
//                                                               ^^^^^^^ reference semanticdb maven . . kotlin/Function0#
//                                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#getValues().
//                                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#values.
//                                                                                    ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getOrPut(+1).
//                                                                                             ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#key().
//                                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#cached().(expression)
//                                                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#cached().(initializer)
  
          /**
           * Remove the value by expression
           *
           * @param expression is the key of caching
           */
          fun remove(expression: Expression<*>) = values.remove(key(expression))
//            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#remove().
//                   display_name remove
//                   documentation ```kotlin\npublic final fun remove(expression: Expression<*>): Any?\n```\n\n----\n\n\n Remove the value by expression\n\n @param expression is the key of caching\n
//                   ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#remove().(expression)
//                              display_name expression
//                              documentation ```kotlin\nexpression: Expression<*>\n```
//                               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#getValues().
//                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#values.
//                                                       ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#remove().
//                                                              ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#key().
//                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#remove().(expression)
  
          private fun key(expression: Expression<*>): Pair<Expression<*>, IColumnType<*>?> = expression to (expression as? Column<*>)?.columnType
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#key().
//                        display_name key
//                        documentation ```kotlin\nprivate final fun key(expression: Expression<*>): Pair<Expression<*>, IColumnType<*>?>\n```
//                        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#key().(expression)
//                                   display_name expression
//                                   documentation ```kotlin\nexpression: Expression<*>\n```
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#
//                                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#key().(expression)
//                                                                                                      ^^ reference semanticdb maven . . kotlin/to().
//                                                                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#key().(expression)
//                                                                                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
      }
  }
