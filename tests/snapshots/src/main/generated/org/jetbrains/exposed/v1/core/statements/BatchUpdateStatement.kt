  package org.jetbrains.exposed.v1.core.statements
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
  
  import org.jetbrains.exposed.v1.core.Column
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
  import org.jetbrains.exposed.v1.core.Expression
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
  import org.jetbrains.exposed.v1.core.IColumnType
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
  import org.jetbrains.exposed.v1.core.InternalApi
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/InternalApi#
  import org.jetbrains.exposed.v1.core.Transaction
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
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
  import org.jetbrains.exposed.v1.core.dao.id.IdTable
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
//                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
  
  /**
   * Represents the SQL statement that batch updates rows of a table.
   *
   * @param table Identity table to update values from.
   */
  open class BatchUpdateStatement(val table: IdTable<*>) : UpdateStatement(table, null) {
//           ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#
//                                display_name BatchUpdateStatement
//                                documentation ```kotlin\npublic open class BatchUpdateStatement : UpdateStatement\n```\n\n----\n\n\n Represents the SQL statement that batch updates rows of a table.\n\n @param table Identity table to update values from.\n
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#
//           ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#`<init>`().
//                                display_name BatchUpdateStatement
//                                documentation ```kotlin\npublic constructor(table: IdTable<*>): BatchUpdateStatement\n```
//                                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#`<init>`().(table)
//                                          display_name table
//                                          documentation ```kotlin\ntable: IdTable<*>\n```
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#`<init>`().(table)
//                                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getTable().
//                                          display_name table
//                                          documentation ```kotlin\npublic get(): IdTable<*>\n```
//                                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#table.
//                                          display_name table
//                                          documentation ```kotlin\npublic final val table: IdTable<*>\n```
//                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#
//                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#`<init>`().(table)
      /** The mappings of columns to update with their updated values for each entity in the batch. */
      val data = ArrayList<Pair<EntityID<*>, Map<Column<*>, Any?>>>()
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#data.
//             display_name data
//             documentation ```kotlin\npublic final val data: {kotlin/collections/ArrayList<kotlin/Pair<org/jetbrains/exposed/v1/core/dao/id/EntityID<*>, kotlin/collections/Map<org/jetbrains/exposed/v1/core/Column<*>, kotlin/Any?>>>=} ArrayList<Pair<EntityID<*>, Map<Column<*>, Any?>>>\n```\n\n----\n\n The mappings of columns to update with their updated values for each entity in the batch.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getData().
//             display_name data
//             documentation ```kotlin\npublic get(): {kotlin/collections/ArrayList<kotlin/Pair<org/jetbrains/exposed/v1/core/dao/id/EntityID<*>, kotlin/collections/Map<org/jetbrains/exposed/v1/core/Column<*>, kotlin/Any?>>>=} ArrayList<Pair<EntityID<*>, Map<Column<*>, Any?>>>\n```\n\n----\n\n The mappings of columns to update with their updated values for each entity in the batch.
//               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`().
      override val firstDataSet: List<Pair<Column<*>, Any?>> get() = data.first().second.toList()
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#firstDataSet.
//                              display_name firstDataSet
//                              documentation ```kotlin\npublic open override val firstDataSet: List<Pair<Column<*>, Any?>>\n```
//                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                           ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getFirstDataSet().
//                                                               display_name firstDataSet
//                                                               documentation ```kotlin\npublic get(): List<Pair<Column<*>, Any?>>\n```
//                                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#data.
//                                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getData().
//                                                                        ^^^^^ reference semanticdb maven . . kotlin/collections/first(+19).
//                                                                                ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                                                                ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                                                                       ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+11).
  
      /**
       * Adds the specified entity [id] to the current list of update statements, using the mapping of columns to update
       * provided for this `BatchUpdateStatement`.
       */
      fun addBatch(id: EntityID<*>) {
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#addBatch().
//                 display_name addBatch
//                 documentation ```kotlin\npublic final fun addBatch(id: EntityID<*>): Unit\n```\n\n----\n\n\n Adds the specified entity [id] to the current list of update statements, using the mapping of columns to update\n provided for this `BatchUpdateStatement`.\n
//                 ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#addBatch().(id)
//                    display_name id
//                    documentation ```kotlin\nid: EntityID<*>\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
          val lastBatch = data.lastOrNull()
//            ^^^^^^^^^ definition local 0
//                      display_name lastBatch
//                      documentation ```kotlin\nlocal val lastBatch: Pair<EntityID<*>, Map<Column<*>, Any?>>?\n```
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#data.
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getData().
//                             ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/lastOrNull(+19).
          val different by lazy {
//            ^^^^^^^^^ definition local 1
//                      display_name different
//                      documentation ```kotlin\nlocal val different: Set<Column<*>>\n```
//            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getDifferent().
//                      display_name different
//                      documentation ```kotlin\nlocal get(): Set<Column<*>>\n```
//                         ^^^^ reference semanticdb maven . . kotlin/lazy().
//                         ^^^^^^ reference local 1 4:9
//                         ^^^^^^ reference local 4 4:9
//                         ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 4:9
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getDifferent(). 4:9
              val set1 = firstDataSet.map { it.first }.toSet()
//                ^^^^ definition local 2
//                     display_name set1
//                     documentation ```kotlin\nlocal val set1: Set<Column<*>>\n```
//                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#firstDataSet.
//                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getFirstDataSet().
//                                    ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                        ^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                     display_name it
//                                                     documentation ```kotlin\nit: Map.Entry<Column<*>, Any?>\n```
//                                          ^^ reference semanticdb maven . . (it)
//                                             ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                             ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                     ^^^^^ reference semanticdb maven . . kotlin/collections/toSet(+9).
              val set2 = lastBatch!!.second.keys
//                ^^^^ definition local 3
//                     display_name set2
//                     documentation ```kotlin\nlocal val set2: Set<Column<*>>\n```
//                       ^^^^^^^^^ reference local 0
//                                   ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                   ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                          ^^^^ reference semanticdb maven . . kotlin/collections/Map#getKeys().
//                                          ^^^^ reference semanticdb maven . . kotlin/collections/Map#keys.
              (set1 - set2) + (set2 - set1)
//             ^^^^ reference local 2
//                  ^ reference semanticdb maven . . kotlin/collections/minus(+10).
//                    ^^^^ reference local 3
//                          ^ reference semanticdb maven . . kotlin/collections/plus(+42).
//                             ^^^^ reference local 3
//                                  ^ reference semanticdb maven . . kotlin/collections/minus(+10).
//                                    ^^^^ reference local 2
          }
  
          if (data.size > 1 && different.isNotEmpty()) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#data.
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getData().
//                 ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#getSize().
//                 ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size.
//                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                             ^^^^^^^^^ reference local 1
//                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getDifferent().
//                                       ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
              throw BatchDataInconsistentException("Some values missing for batch update. Different columns: $different")
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchDataInconsistentException#`<init>`().
//                                                                                                            ^^^^^^^^^ reference local 1
//                                                                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getDifferent().
          }
  
          @OptIn(InternalApi::class)
          if (data.isNotEmpty()) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#data.
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getData().
//                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
              data[data.size - 1] = lastBatch!!.copy(second = values.toMap())
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#data.
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getData().
//            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#set().
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#data.
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getData().
//                      ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#getSize().
//                      ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size.
//                           ^ reference semanticdb maven . . kotlin/Int#minus(+2).
//                                  ^^^^^^^^^ reference local 0
//                                              ^^^^ reference semanticdb maven . . kotlin/Pair#copy().
//                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getValues().
//                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#values.
//                                                                   ^^^^^ reference semanticdb maven . . kotlin/collections/toMap(+6).
              values.clear()
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getValues().
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#values.
//                   ^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#clear().
              hasBatchedValues = true
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getHasBatchedValues().
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#hasBatchedValues.
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#setHasBatchedValues().
          }
          @OptIn(InternalApi::class)
          data.add(id to values)
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#data.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getData().
//             ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add().
//                 ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#addBatch().(id)
//                    ^^ reference semanticdb maven . . kotlin/to().
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getValues().
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#values.
      }
  
      override fun <T, S : T?> update(column: Column<T>, value: Expression<S>) = error("Expressions unsupported in batch update")
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#update().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#update().[S]
//                       display_name FirTypeParameterSymbol S
//                       documentation ```kotlin\nS : T?\n```
//                             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#update().
//                                    display_name update
//                                    documentation ```kotlin\npublic open override fun <T, S : T?> update(column: Column<T>, value: Expression<S>): Nothing\n```
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().
//                                    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#update().(column)
//                                           display_name column
//                                           documentation ```kotlin\ncolumn: Column<T>\n```
//                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#update().(value)
//                                                             display_name value
//                                                             documentation ```kotlin\nvalue: Expression<S>\n```
//                                                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                               ^^^^^ reference semanticdb maven . . kotlin/error().
  
      override fun prepareSQL(transaction: Transaction, prepared: Boolean): String {
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#prepareSQL().
//                            display_name prepareSQL
//                            documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#prepareSQL().
//                            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#prepareSQL().(transaction)
//                                        display_name transaction
//                                        documentation ```kotlin\ntransaction: Transaction\n```
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#prepareSQL().(prepared)
//                                                               display_name prepared
//                                                               documentation ```kotlin\nprepared: Boolean\n```
//                                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
          val updateSql = super.prepareSQL(transaction, prepared)
//            ^^^^^^^^^ definition local 5
//                      display_name updateSql
//                      documentation ```kotlin\nlocal val updateSql: String\n```
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#prepareSQL().
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#prepareSQL().(transaction)
//                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#prepareSQL().(prepared)
          val idEqCondition = if (table is CompositeIdTable) {
//            ^^^^^^^^^^^^^ definition local 6
//                          display_name idEqCondition
//                          documentation ```kotlin\nlocal val idEqCondition: String\n```
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getTable().
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#table.
              table.idColumns.joinToString(separator = " AND ") { "${transaction.identity(it)} = ?" }
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getTable().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#table.
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#getIdColumns().
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#idColumns.
//                            ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                    display_name it
//                                                                                                    documentation ```kotlin\nit: Map.Entry<Column<*>, Any?>\n```
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#prepareSQL().(transaction)
//                                                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                                                        ^^ reference semanticdb maven . . (it)
          } else {
              "${transaction.identity(table.id)} = ?"
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#prepareSQL().(transaction)
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getTable().
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#table.
//                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#getId().
//                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#id.
          }
          return "$updateSql WHERE $idEqCondition"
//                 ^^^^^^^^^ reference local 5
//                                  ^^^^^^^^^^^^^ reference local 6
      }
  
      override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>> = data.map { (id, row) ->
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#arguments().
//                           display_name arguments
//                           documentation ```kotlin\npublic open override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>>\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#arguments().
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#data.
//                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getData().
//                                                                                    ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                                                          ^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                                                                    display_name <destruct>
//                                                                                                    documentation ```kotlin\n<destruct>: Pair<EntityID<*>, Map<Column<*>, Any?>>\n```
//                                                                                           ^^ definition local 7
//                                                                                              display_name id
//                                                                                              documentation ```kotlin\nlocal val id: EntityID<*>\n```
//                                                                                           ^^ reference semanticdb maven . . (`<destruct>`)
//                                                                                           ^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                                                               ^^^ definition local 8
//                                                                                                   display_name row
//                                                                                                   documentation ```kotlin\nlocal val row: Map<Column<*>, Any?>\n```
//                                                                                               ^^^ reference semanticdb maven . . (`<destruct>`)
//                                                                                               ^^^ reference semanticdb maven . . kotlin/Pair#component2().
          val idArgs = (id.value as? CompositeID)?.values?.map {
//            ^^^^^^ definition local 9
//                   display_name idArgs
//                   documentation ```kotlin\nlocal val idArgs: List<Pair<IColumnType<out Any>, Any?>>\n```
//                      ^^ reference local 7
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
//                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                                         ^^^ reference semanticdb maven . . kotlin/collections/map(+10).
//                                                             ^ definition semanticdb maven . . (it) 2:9
//                                                               display_name it
//                                                               documentation ```kotlin\nit: Map.Entry<Column<*>, Any?>\n```
              it.key.columnType to it.value
//            ^^ reference semanticdb maven . . (it)
//               ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getKey().
//               ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#key.
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                              ^^ reference semanticdb maven . . kotlin/to().
//                                 ^^ reference semanticdb maven . . (it)
//                                    ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getValue().
//                                    ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#value.
          } ?: listOf(table.id.columnType to id)
//             ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getTable().
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#table.
//                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#getId().
//                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#id.
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                        ^^ reference semanticdb maven . . kotlin/to().
//                                           ^^ reference local 7
          firstDataSet.map { it.first.columnType to row[it.first] } + idArgs
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#firstDataSet.
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#getFirstDataSet().
//                     ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                  display_name it
//                                                                  documentation ```kotlin\nit: Map.Entry<Column<*>, Any?>\n```
//                           ^^ reference semanticdb maven . . (it)
//                              ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                              ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                               ^^ reference semanticdb maven . . kotlin/to().
//                                                  ^^^ reference local 8
//                                                  ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                      ^^ reference semanticdb maven . . (it)
//                                                         ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                         ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                                  ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                                    ^^^^^^ reference local 9
      }
  }
