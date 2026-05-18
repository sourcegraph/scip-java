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
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#
  /** A row of data representing a single record retrieved from a database result set. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().
  class ResultRow(
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#
//                display_name ResultRow
//                documentation ```kotlin\npublic final class ResultRow : Any\n```\n\n----\n\n A row of data representing a single record retrieved from a database result set.
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().
//                display_name ResultRow
//                documentation ```kotlin\npublic constructor(fieldIndex: Map<Expression<*>, Int>, data: Array<Any?> = ...): ResultRow\n```\n\n----\n\n Mapping of the expressions stored on this row to their index positions.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().(fieldIndex)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#fieldIndex.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getFieldIndex().
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
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().(fieldIndex)
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#fieldIndex.
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getFieldIndex().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().(data)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#data.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getData().
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
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().(data)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#data.
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getData().
  ) {
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#database.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getDatabase().
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
//                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#database.
//                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getDatabase().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#lookUpCache.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getLookUpCache().
      private val lookUpCache = ResultRowCache()
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getLookUpCache().
//                            display_name lookUpCache
//                            documentation ```kotlin\nprivate get(): ResultRow.ResultRowCache\n```
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#lookUpCache.
//                            display_name lookUpCache
//                            documentation ```kotlin\nprivate final val lookUpCache: ResultRow.ResultRowCache\n```
//                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#`<init>`().
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#lookUpCache.
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getLookUpCache().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().
      /**
       * Retrieves the value of a given expression on this row.
       *
       * @param expression expression to evaluate
       * @throws IllegalStateException if expression is not in record set or if result value is uninitialized
       *
       * @see [getOrNull] to get null in the cases an exception would be thrown
       */
      @Suppress("UNCHECKED_CAST")
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().[T]
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().(expression)
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().[T]
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().(expression)
//        ⌄ enclosing_range_start local 0
          val column = expression as? Column<*>
//            ^^^^^^ definition local 0
//                   display_name column
//                   documentation ```kotlin\nlocal val column: Column<*>?\n```
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().(expression)
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                            ⌃ enclosing_range_end local 0
          return when {
              column?.isEntityIdentifier() == true && column.table is CompositeIdTable -> {
//            ^^^^^^ reference local 0
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isEntityIdentifier().
//                                                    ^^^^^^ reference local 0
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#
//                ⌄ enclosing_range_start local 1
//                                           ⌄ enclosing_range_start local 2
                  val resultID = CompositeID {
//                    ^^^^^^^^ definition local 1
//                             display_name resultID
//                             documentation ```kotlin\nlocal val resultID: CompositeID\n```
//                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#invoke().
//                                           ^ definition local 2 4:17
//                                             display_name it
//                                             documentation ```kotlin\nit: CompositeID\n```
//                                                     ⌄ enclosing_range_start local 3
                      column.table.idColumns.forEach { column ->
//                    ^^^^^^ reference local 0
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#getIdColumns().
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#idColumns.
//                                           ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                                     ^^^^^^ definition local 3
//                                                            display_name column
//                                                            documentation ```kotlin\ncolumn: Column<out Any>\n```
//                                                          ⌃ enclosing_range_end local 3
                          it[column as Column<EntityID<Any>>] = getInternal(column, checkNullability = true).value
//                        ^^ reference local 2
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().
//                           ^^^^^^ reference local 3
//                                     ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().
//                                                                          ^^^^^^ reference local 3
//                                                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                                                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
                      }
                  }
//                ⌃ enclosing_range_end local 1
//                ⌃ enclosing_range_end local 2
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#set().
      /**
       * Sets the value of a given expression on this row.
       *
       * @param expression expression for which to set the value
       * @param value value to be set for the given expression
       */
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#set().[T]
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#set().(expression)
//                                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#set().(value)
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#set().[T]
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#set().(expression)
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#set().(value)
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#set().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().[T]
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().(expression)
//                                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().(value)
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
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().[T]
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().(expression)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().(value)
//        ⌄ enclosing_range_start local 4
          val index = getExpressionIndex(expression)
//            ^^^^^ definition local 4
//                  display_name index
//                  documentation ```kotlin\nlocal val index: Int\n```
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().(expression)
//                                                 ⌃ enclosing_range_end local 4
          data[index] = value
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#data.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getData().
//        ^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#set().
//             ^^^^^ reference local 4
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().(value)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#hasValue().
      /** Whether the given [expression] has been initialized with a value on this row. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#hasValue().[T]
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#hasValue().(expression)
//                                                                                       ⌄ enclosing_range_start local 5
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
//                                                                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 5
//                                                                                                                           display_name it
//                                                                                                                           documentation ```kotlin\nit: Int\n```
//                                                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#data.
//                                                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getData().
//                                                                                         ^^^^^^^^ reference semanticdb maven . . kotlin/Array#get().
//                                                                                              ^^ reference local 5
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#hasValue().[T]
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#hasValue().(expression)
//                                                                                                                         ⌃ enclosing_range_end local 5
//                                                                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#hasValue().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getOrNull().
      /**
       * Retrieves the value of a given expression on this row.
       * Returns null in the cases an exception would be thrown in [get].
       *
       * @param expression expression to evaluate
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getOrNull().[T]
//                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getOrNull().(expression)
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
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getOrNull().[T]
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getOrNull().(expression)
//                                                                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getOrNull().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().
      @OptIn(InternalApi::class)
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().[T]
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(expression)
//                                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(checkNullability)
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
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().[T]
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(expression)
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(checkNullability)
//        ⌄ enclosing_range_start local 6
          val rawValue = getRaw(expression)
//            ^^^^^^^^ definition local 6
//                     display_name rawValue
//                     documentation ```kotlin\nlocal val rawValue: T?\n```
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(expression)
//                                        ⌃ enclosing_range_end local 6
  
          if (checkNullability) {
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(checkNullability)
              if (rawValue == null && expression is Column<*> && expression.dbDefaultValue != null && !expression.columnType.nullable) {
//                ^^^^^^^^ reference local 6
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(expression)
//                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
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
  
//                               ⌄ enclosing_range_start local 7
          database?.dialect?.let {
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#database.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getDatabase().
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
//                           ^^^ reference semanticdb maven . . kotlin/let().
//                               ^ definition local 7 4:9
//                                 display_name it
//                                 documentation ```kotlin\nit: DatabaseDialect\n```
              withDialect(it) {
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/withDialect().
//                        ^^ reference local 7
                  rawToColumnValue(rawValue, expression)
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().
//                                 ^^^^^^^^ reference local 6
//                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(expression)
              }
          } ?: rawToColumnValue(rawValue, expression)
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().
//                              ^^^^^^^^ reference local 6
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().(expression)
//        ⌃ enclosing_range_end local 7
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getInternal().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().
      @Suppress("UNCHECKED_CAST")
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().[T]
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
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
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().[T]
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
          return when {
              raw == null -> null
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
              raw == NotInitializedValue -> error("$expression is not initialized yet")
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
//                                          ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
              expression is ExpressionWithColumnTypeAlias<T> -> rawToColumnValue(raw, expression.delegate)
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#
//                                                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().
//                                                                               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
//                                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
//                                                                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#delegate.
//                                                                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#getDelegate().
              expression is ExpressionAlias<T> -> rawToColumnValue(raw, expression.delegate)
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
//                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().
//                                                                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
//                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
//                                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#delegate.
//                                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#getDelegate().
              expression is ExpressionWithColumnType<T> -> expression.columnType.valueFromDB(raw)
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
//                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueFromDB().
//                                                                                           ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
              expression is Op.OpBoolean -> BooleanColumnType.INSTANCE.valueFromDB(raw)
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(expression)
//                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#OpBoolean#
//                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#Companion#INSTANCE.
//                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#Companion#getINSTANCE().
//                                                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#valueFromDB().
//                                                                                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
              else -> raw
//                    ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().(raw)
          } as T
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#rawToColumnValue().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().
      @Suppress("UNCHECKED_CAST")
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().(expression)
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
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().[T]
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().(expression)
          if (expression is CompositeColumn<T>) {
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().(expression)
//                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#
//            ⌄ enclosing_range_start local 8
//                                                                     ⌄ enclosing_range_start local 9
              val rawParts = expression.getRealColumns().associateWith { getRaw(it) }
//                ^^^^^^^^ definition local 8
//                         display_name rawParts
//                         documentation ```kotlin\nlocal val rawParts: Map<Column<*>, Any?>\n```
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().(expression)
//                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumns().
//                                                       ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/associateWith(+9).
//                                                                     ^^^^^^^^^^^^^^ definition local 9
//                                                                                    display_name it
//                                                                                    documentation ```kotlin\nit: Column<*>\n```
//                                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().
//                                                                              ^^ reference local 9
//                                                                                  ⌃ enclosing_range_end local 8
//                                                                                  ⌃ enclosing_range_end local 9
              return expression.restoreValueFromParts(rawParts)
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().(expression)
//                              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#restoreValueFromParts().
//                                                    ^^^^^^^^ reference local 8
          }
  
//        ⌄ enclosing_range_start local 10
          val index = getExpressionIndex(expression)
//            ^^^^^ definition local 10
//                  display_name index
//                  documentation ```kotlin\nlocal val index: Int\n```
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().(expression)
//                                                 ⌃ enclosing_range_end local 10
          return data[index] as T?
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#data.
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getData().
//               ^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#get().
//                    ^^^^^ reference local 10
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getRaw().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().
      /**
       * Retrieves the index of a given expression in the [fieldIndex] map.
       *
       * @param expression expression for which to get the index
       * @throws IllegalStateException if expression is not in record set
       */
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().[T]
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().(expression)
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
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().[T]
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().(expression)
          return fieldIndex[expression]
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#fieldIndex.
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getFieldIndex().
//               ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().(expression)
//                                             ⌄ enclosing_range_start local 11
              ?: fieldIndex.keys.firstOrNull { exp ->
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#fieldIndex.
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getFieldIndex().
//                          ^^^^ reference semanticdb maven . . kotlin/collections/Map#getKeys().
//                          ^^^^ reference semanticdb maven . . kotlin/collections/Map#keys.
//                               ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+20).
//                                             ^^^ definition local 11
//                                                 display_name exp
//                                                 documentation ```kotlin\nexp: Expression<*>\n```
//                                               ⌃ enclosing_range_end local 11
//                      ⌄ enclosing_range_start local 12
                  when (exp) {
//                      ^^^ reference local 11
//                      ^^^ definition local 12
//                          display_name <when-subject>
//                          documentation ```kotlin\nlocal val <when-subject>: Expression<*>\n```
//                        ⌃ enclosing_range_end local 12
                      is Column<*> -> (exp.columnType as? EntityIDColumnType<*>)?.idColumn == expression
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                     ^^^ reference local 11
//                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                        ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#
//                                                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().(expression)
                      is IExpressionAlias<*> -> exp.delegate == expression
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#
//                                              ^^^ reference local 11
//                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#delegate.
//                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getDelegate().
//                                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().(expression)
                      else -> false
                  }
//                     ⌄ enclosing_range_start local 13
              }?.let { exp -> fieldIndex[exp] }
//               ^^^ reference semanticdb maven . . kotlin/let().
//                     ^^^ definition local 13
//                         display_name exp
//                         documentation ```kotlin\nexp: Expression<*>\n```
//                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#fieldIndex.
//                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getFieldIndex().
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                       ^^^ reference local 13
//                       ⌃ enclosing_range_end local 13
              ?: error("$expression is not in record set")
//               ^^^^^ reference semanticdb maven . . kotlin/error().
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().(expression)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getExpressionIndex().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#toString().
      override fun toString(): String =
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#toString().
//                          display_name toString
//                          documentation ```kotlin\npublic open override fun toString(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                        ⌄ enclosing_range_start local 14
          fieldIndex.entries.joinToString { "${it.key}=${data[it.value]}" }
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#fieldIndex.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getFieldIndex().
//                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#entries.
//                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#getEntries().
//                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 14
//                                                                          display_name it
//                                                                          documentation ```kotlin\nit: Map.Entry<Expression<*>, Int>\n```
//                                             ^^ reference local 14
//                                                ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getKey().
//                                                ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#key.
//                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#data.
//                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getData().
//                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#get().
//                                                            ^^ reference local 14
//                                                               ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getValue().
//                                                               ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#value.
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#toString().
//                                                                        ⌃ enclosing_range_end local 14
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#NotInitializedValue#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#NotInitializedValue#`<init>`().
      internal object NotInitializedValue
//                    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#NotInitializedValue#
//                                        display_name NotInitializedValue
//                                        documentation ```kotlin\ninternal final object NotInitializedValue : Any\n```
//                    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#NotInitializedValue#`<init>`().
//                                        display_name NotInitializedValue
//                                        documentation ```kotlin\nprivate constructor(): ResultRow.NotInitializedValue\n```
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#NotInitializedValue#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#NotInitializedValue#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#`<init>`().
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion# 35:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```\n\n----\n\n Creates a [ResultRow] storing all expressions in [fieldsIndex] with their values retrieved from a [RowApi].
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#`<init>`(). 35:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): ResultRow.Companion\n```\n\n----\n\n Creates a [ResultRow] storing all expressions in [fieldsIndex] with their values retrieved from a [RowApi].
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().
          /** Creates a [ResultRow] storing all expressions in [fieldsIndex] with their values retrieved from a [RowApi]. */
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().(rs)
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().(fieldsIndex)
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
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().(rs)
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().(fieldsIndex)
              return ResultRow(fieldsIndex).apply {
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().(fieldsIndex)
//                                          ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                      ⌄ enclosing_range_start local 15
//                                       ⌄ enclosing_range_start local 16
//                                              ⌄ enclosing_range_start local 17
                  fieldsIndex.forEach { (field, index) ->
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().(fieldsIndex)
//                            ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                                      ^^^^^^^^^^^^^^ definition local 15
//                                                     display_name <destruct>
//                                                     documentation ```kotlin\n<destruct>: Map.Entry<Expression<*>, Int>\n```
//                                       ^^^^^ reference local 15
//                                       ^^^^^ definition local 16
//                                             display_name field
//                                             documentation ```kotlin\nlocal val field: Expression<*>\n```
//                                       ^^^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                              ^^^^^ reference local 15
//                                              ^^^^^ definition local 17
//                                                    display_name index
//                                                    documentation ```kotlin\nlocal val index: Int\n```
//                                              ^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
//                                           ⌃ enclosing_range_end local 16
//                                                  ⌃ enclosing_range_end local 17
//                                                   ⌃ enclosing_range_end local 15
//                    ⌄ enclosing_range_start local 18
                      val columnType: IColumnType<out Any>? = (field as? ExpressionWithColumnType)?.columnType
//                        ^^^^^^^^^^ definition local 18
//                                   display_name columnType
//                                   documentation ```kotlin\nlocal val columnType: IColumnType<out Any>?\n```
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                             ^^^^^ reference local 16
//                                                                       ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                                                                                           ⌃ enclosing_range_end local 18
//                    ⌄ enclosing_range_start local 19
                      val value = if (columnType != null) {
//                        ^^^^^ definition local 19
//                              display_name value
//                              documentation ```kotlin\nlocal val value: Any?\n```
//                                    ^^^^^^^^^^ reference local 18
                          columnType.readObject(rs, index + 1)
//                        ^^^^^^^^^^ reference local 18
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#readObject().
//                                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().(rs)
//                                                  ^^^^^ reference local 17
//                                                        ^ reference semanticdb maven . . kotlin/Int#plus(+2).
                      } else {
                          rs.getObject(index + 1)
//                        ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().(rs)
//                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject().
//                                     ^^^^^ reference local 17
//                                           ^ reference semanticdb maven . . kotlin/Int#plus(+2).
                      }
//                    ⌃ enclosing_range_end local 19
                      data[index] = value
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#data.
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getData().
//                    ^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#set().
//                         ^^^^^ reference local 17
//                                  ^^^^^ reference local 19
                  }
              }
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#create().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillValues().
          /** Creates a [ResultRow] using the expressions and values provided by [data]. */
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillValues().(data)
          fun createAndFillValues(data: Map<Expression<*>, Any?>): ResultRow {
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillValues().
//                                display_name createAndFillValues
//                                documentation ```kotlin\npublic final fun createAndFillValues(data: Map<Expression<*>, Any?>): ResultRow\n```\n\n----\n\n Creates a [ResultRow] using the expressions and values provided by [data].
//                                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillValues().(data)
//                                     display_name data
//                                     documentation ```kotlin\ndata: Map<Expression<*>, Any?>\n```
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillValues().(data)
//            ⌄ enclosing_range_start local 20
              val fieldIndex = HashMap<Expression<*>, Int>(data.size)
//                ^^^^^^^^^^ definition local 20
//                           display_name fieldIndex
//                           documentation ```kotlin\nlocal val fieldIndex: {kotlin/collections/HashMap<org/jetbrains/exposed/v1/core/Expression<*>, kotlin/Int>=} HashMap<Expression<*>, Int>\n```
//                             ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashMap#`<init>`().
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillValues().(data)
//                                                              ^^^^ reference semanticdb maven . . kotlin/collections/Map#getSize().
//                                                              ^^^^ reference semanticdb maven . . kotlin/collections/Map#size.
//                                                                  ⌃ enclosing_range_end local 20
//            ⌄ enclosing_range_start local 21
              val values = arrayOfNulls<Any?>(data.size)
//                ^^^^^^ definition local 21
//                       display_name values
//                       documentation ```kotlin\nlocal val values: Array<Any?>\n```
//                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/arrayOfNulls().
//                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillValues().(data)
//                                                 ^^^^ reference semanticdb maven . . kotlin/collections/Map#getSize().
//                                                 ^^^^ reference semanticdb maven . . kotlin/collections/Map#size.
//                                                     ⌃ enclosing_range_end local 21
//                                          ⌄ enclosing_range_start local 22
//                                             ⌄ enclosing_range_start local 23
              data.entries.forEachIndexed { i, columnAndValue ->
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillValues().(data)
//                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#entries.
//                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#getEntries().
//                         ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/forEachIndexed(+9).
//                                          ^ definition local 22
//                                            display_name i
//                                            documentation ```kotlin\ni: Int\n```
//                                             ^^^^^^^^^^^^^^ definition local 23
//                                                            display_name columnAndValue
//                                                            documentation ```kotlin\ncolumnAndValue: Map.Entry<Expression<*>, Any?>\n```
//                                          ⌃ enclosing_range_end local 22
//                                                          ⌃ enclosing_range_end local 23
//                ⌄ enclosing_range_start local 24
//                     ⌄ enclosing_range_start local 25
//                             ⌄ enclosing_range_start local 26
                  val (column, value) = columnAndValue
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 24
//                                                     display_name <destruct>
//                                                     documentation ```kotlin\nlocal val <destruct>: Map.Entry<Expression<*>, Any?>\n```
//                     ^^^^^^ reference local 24
//                     ^^^^^^ definition local 25
//                            display_name column
//                            documentation ```kotlin\nlocal val column: Expression<*>\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                             ^^^^^ reference local 24
//                             ^^^^^ definition local 26
//                                   display_name value
//                                   documentation ```kotlin\nlocal val value: Any?\n```
//                             ^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
//                                      ^^^^^^^^^^^^^^ reference local 23
//                          ⌃ enclosing_range_end local 25
//                                 ⌃ enclosing_range_end local 26
//                                                   ⌃ enclosing_range_end local 24
                  fieldIndex[column] = i
//                ^^^^^^^^^^ reference local 20
//                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//                           ^^^^^^ reference local 25
//                                     ^ reference local 22
                  values[i] = value
//                ^^^^^^ reference local 21
//                ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#set().
//                       ^ reference local 22
//                            ^^^^^ reference local 26
              }
              return ResultRow(fieldIndex, values)
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().
//                             ^^^^^^^^^^ reference local 20
//                                         ^^^^^^ reference local 21
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillValues().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillDefaults().
          /** Creates a [ResultRow] storing [columns] with their default or nullable values. */
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillDefaults().(columns)
          fun createAndFillDefaults(columns: List<Column<*>>): ResultRow =
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillDefaults().
//                                  display_name createAndFillDefaults
//                                  documentation ```kotlin\npublic final fun createAndFillDefaults(columns: List<Column<*>>): ResultRow\n```\n\n----\n\n Creates a [ResultRow] storing [columns] with their default or nullable values.
//                                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillDefaults().(columns)
//                                          display_name columns
//                                          documentation ```kotlin\ncolumns: List<Column<*>>\n```
//                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillDefaults().(columns)
//                                                    ⌄ enclosing_range_start local 27
              ResultRow(columns.withIndex().associate { it.value to it.index }).apply {
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#`<init>`().
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillDefaults().(columns)
//                              ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/withIndex(+10).
//                                          ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/associate(+9).
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 27
//                                                                             display_name it
//                                                                             documentation ```kotlin\nit: IndexedValue<Column<*>>\n```
//                                                      ^^ reference local 27
//                                                         ^^^^^ reference semanticdb maven . . kotlin/collections/IndexedValue#getValue().
//                                                         ^^^^^ reference semanticdb maven . . kotlin/collections/IndexedValue#value.
//                                                               ^^ reference semanticdb maven . . kotlin/to().
//                                                                  ^^ reference local 27
//                                                                     ^^^^^ reference semanticdb maven . . kotlin/collections/IndexedValue#getIndex().
//                                                                     ^^^^^ reference semanticdb maven . . kotlin/collections/IndexedValue#index.
//                                                                              ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                                           ⌃ enclosing_range_end local 27
//                                ⌄ enclosing_range_start local 28
                  columns.forEach {
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillDefaults().(columns)
//                        ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                ^ definition local 28 2:17
//                                  display_name it
//                                  documentation ```kotlin\nit: Column<*>\n```
                      setInternal(it, it.defaultValueOrNotInitialized())
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#setInternal().
//                                ^^ reference local 28
//                                    ^^ reference local 28
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#defaultValueOrNotInitialized().
                  }
//                ⌃ enclosing_range_end local 28
              }
//            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#createAndFillDefaults().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#Companion#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#defaultValueOrNotInitialized().
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#defaultValueOrNotInitialized().[T]
      private fun <T> Column<T>.defaultValueOrNotInitialized(): Any? {
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#defaultValueOrNotInitialized().[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#defaultValueOrNotInitialized().
//                                                           display_name defaultValueOrNotInitialized
//                                                           documentation ```kotlin\nprivate final fun <T> Column<T>.defaultValueOrNotInitialized(): Any?\n```
//                                                              ^^^^ reference semanticdb maven . . kotlin/Any#
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#defaultValueOrNotInitialized().[T]
          return when {
              defaultValueFun != null -> when {
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
                  columnType is ColumnWithTransform<*, *> -> {
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#
                      (columnType as ColumnWithTransform<Any, Any>).unwrapRecursive(defaultValueFun!!())
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#defaultValueOrNotInitialized().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#`<init>`().
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
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#values.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#getValues().
          private val values: MutableMap<Pair<Expression<*>, IColumnType<*>?>, Any?> = mutableMapOf()
//                    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#getValues().
//                           display_name values
//                           documentation ```kotlin\nprivate get(): MutableMap<Pair<Expression<*>, IColumnType<*>?>, Any?>\n```
//                    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#values.
//                           display_name values
//                           documentation ```kotlin\nprivate final val values: MutableMap<Pair<Expression<*>, IColumnType<*>?>, Any?>\n```
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableMapOf().
//                                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#values.
//                                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#getValues().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#cached().
          /**
           * Wrapping function that accept the expression and target function.
           * The function would be called if the value not found in the cache.
           *
           * @param expression is the key of caching
           * @param initializer function that returns the new value if the cache missed
           */
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#cached().[T]
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#cached().(expression)
//                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#cached().(initializer)
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
//             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#cached().[T]
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#cached().(expression)
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#cached().(initializer)
//                                                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#cached().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#remove().
          /**
           * Remove the value by expression
           *
           * @param expression is the key of caching
           */
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#remove().(expression)
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
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#remove().(expression)
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#remove().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#key().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#key().(expression)
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
//                                                                                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#key().(expression)
//                                                                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#key().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#ResultRowCache#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#
