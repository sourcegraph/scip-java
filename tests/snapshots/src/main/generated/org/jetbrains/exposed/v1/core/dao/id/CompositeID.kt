  package org.jetbrains.exposed.v1.core.dao.id
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
  
  import org.jetbrains.exposed.v1.core.Column
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
  /** Class representing a mapping of each composite primary key column to its stored identity value. */
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#`<init>`().
  class CompositeID private constructor() {
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
//                  display_name CompositeID
//                  documentation ```kotlin\npublic final class CompositeID : Any\n```\n\n----\n\n Class representing a mapping of each composite primary key column to its stored identity value.
//                          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#`<init>`().
//                                      display_name CompositeID
//                                      documentation ```kotlin\nprivate constructor(): CompositeID\n```
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
      internal val values: MutableMap<Column<*>, Any?> = HashMap()
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                        display_name values
//                        documentation ```kotlin\ninternal get(): MutableMap<Column<*>, Any?>\n```
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                        display_name values
//                        documentation ```kotlin\ninternal final val values: MutableMap<Column<*>, Any?>\n```
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#
//                                                       ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashMap#`<init>`().
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().
      @Suppress("UNCHECKED_CAST")
      @JvmName("setWithEntityIdValue")
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().[ID]
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(column)
//                                                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(value)
      operator fun <T : Any, ID : EntityID<T>> set(column: Column<ID>, value: T) {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : Any\n```
//                           ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().[ID]
//                              display_name FirTypeParameterSymbol ID
//                              documentation ```kotlin\nID : EntityID<T>\n```
//                                             ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().
//                                                 display_name set
//                                                 documentation ```kotlin\n@Suppress(...) @JvmName(...) public final operator fun <T : Any, ID : EntityID<T>> set(column: Column<ID>, value: T): Unit\n```
//                                                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(column)
//                                                        display_name column
//                                                        documentation ```kotlin\ncolumn: Column<ID>\n```
//                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(value)
//                                                                           display_name value
//                                                                           documentation ```kotlin\nvalue: T\n```
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().[T]
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().[ID]
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(column)
//                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(value)
          require(values.isEmpty() || values.keys.first().table == column.table) {
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#isEmpty().
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                           ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getKeys().
//                                           ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#keys.
//                                                ^^^^^ reference semanticdb maven . . kotlin/collections/first(+18).
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(column)
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
              "CompositeID key columns must all come from the same IdTable ${values.keys.first().table.tableName}"
//                                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                                                                  ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getKeys().
//                                                                                  ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#keys.
//                                                                                       ^^^^^ reference semanticdb maven . . kotlin/collections/first(+18).
//                                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
          }
          values[column] = EntityID(value, column.table as IdTable<T>)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(column)
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(value)
//                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(column)
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).
      @Suppress("UNCHECKED_CAST")
      @JvmName("setWithNullableEntityIdValue")
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).[ID]
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(column)
//                                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(value)
      operator fun <T : Any, ID : EntityID<T>> set(column: Column<ID?>, value: T?) {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : Any\n```
//                           ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).[ID]
//                              display_name FirTypeParameterSymbol ID
//                              documentation ```kotlin\nID : EntityID<T>\n```
//                                             ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).
//                                                 display_name set
//                                                 documentation ```kotlin\n@Suppress(...) @JvmName(...) public final operator fun <T : Any, ID : EntityID<T>> set(column: Column<ID?>, value: T?): Unit\n```
//                                                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(column)
//                                                        display_name column
//                                                        documentation ```kotlin\ncolumn: Column<ID?>\n```
//                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(value)
//                                                                            display_name value
//                                                                            documentation ```kotlin\nvalue: T?\n```
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).[T]
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).[ID]
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(column)
//                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(value)
          require(column.columnType.nullable || value != null) {
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(column)
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(value)
              "Trying to set null to not nullable column $column"
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(column)
          }
//                                    ⌄ enclosing_range_start local 0
          values[column] = value?.let { EntityID(value, column.table as IdTable<T>) }
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(column)
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(value)
//                                ^^^ reference semanticdb maven . . kotlin/let().
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 0
//                                                                                    display_name it
//                                                                                    documentation ```kotlin\nit: T\n```
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(value)
//                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(column)
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                                  ⌃ enclosing_range_end local 0
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).
      @JvmName("setWithEntityID")
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).[ID]
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).(column)
//                                                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).(value)
      operator fun <T : Any, ID : EntityID<T>> set(column: Column<ID>, value: ID) {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : Any\n```
//                           ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).[ID]
//                              display_name FirTypeParameterSymbol ID
//                              documentation ```kotlin\nID : EntityID<T>\n```
//                                             ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).
//                                                 display_name set
//                                                 documentation ```kotlin\n@JvmName(...) public final operator fun <T : Any, ID : EntityID<T>> set(column: Column<ID>, value: ID): Unit\n```
//                                                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).(column)
//                                                        display_name column
//                                                        documentation ```kotlin\ncolumn: Column<ID>\n```
//                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).(value)
//                                                                           display_name value
//                                                                           documentation ```kotlin\nvalue: ID\n```
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).[T]
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).[ID]
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).(column)
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).(value)
          require(values.isEmpty() || values.keys.first().table == column.table) {
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#isEmpty().
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                           ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getKeys().
//                                           ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#keys.
//                                                ^^^^^ reference semanticdb maven . . kotlin/collections/first(+18).
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).(column)
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
              "CompositeID key columns must all come from the same IdTable ${values.keys.first().table.tableName}"
//                                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                                                                  ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getKeys().
//                                                                                  ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#keys.
//                                                                                       ^^^^^ reference semanticdb maven . . kotlin/collections/first(+18).
//                                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
          }
          values[column] = value
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).(column)
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).(value)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().
      @Suppress("UNCHECKED_CAST")
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().[T]
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().(column)
      operator fun <T : Any> get(column: Column<T>): T = values[column] as T
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : Any\n```
//                           ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().
//                               display_name get
//                               documentation ```kotlin\n@Suppress(...) public final operator fun <T : Any> get(column: Column<T>): T\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().(column)
//                                      display_name column
//                                      documentation ```kotlin\ncolumn: Column<T>\n```
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#get().
//                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().(column)
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().[T]
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().(column)
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#contains().
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#contains().(column)
      operator fun contains(column: Column<*>): Boolean = values.contains(column)
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#contains().
//                          display_name contains
//                          documentation ```kotlin\npublic final operator fun contains(column: Column<*>): Boolean\n```
//                          ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#contains().(column)
//                                 display_name column
//                                 documentation ```kotlin\ncolumn: Column<*>\n```
//                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                                               ^^^^^^^^ reference semanticdb maven . . kotlin/collections/contains(+10).
//                                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#contains().(column)
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#contains().(column)
//                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#contains().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#toString().
//                                                                                 ⌄ enclosing_range_start local 1
      override fun toString(): String = "CompositeID(${values.entries.joinToString { "${it.key.name}=${it.value}" }})"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#toString().
//                          display_name toString
//                          documentation ```kotlin\npublic open override fun toString(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                                            ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#entries.
//                                                            ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getEntries().
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 1
//                                                                                                                  display_name it
//                                                                                                                  documentation ```kotlin\nit: MutableMap.MutableEntry<Column<*>, Any?>\n```
//                                                                                      ^^ reference local 1
//                                                                                         ^^^ reference semanticdb maven . . kotlin/collections/MutableMap#MutableEntry#getKey().
//                                                                                         ^^^ reference semanticdb maven . . kotlin/collections/MutableMap#MutableEntry#key.
//                                                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                                                     ^^ reference local 1
//                                                                                                        ^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#MutableEntry#getValue().
//                                                                                                        ^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#MutableEntry#value.
//                                                                                                                ⌃ enclosing_range_end local 1
//                                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#toString().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#hashCode().
//                                                            ⌄ enclosing_range_start local 2
//                                                                 ⌄ enclosing_range_start local 3
      override fun hashCode(): Int = values.entries.fold(0) { acc, entry ->
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                          ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#entries.
//                                          ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getEntries().
//                                                  ^^^^ reference semanticdb maven . . kotlin/collections/fold(+9).
//                                                            ^^^ definition local 2
//                                                                display_name acc
//                                                                documentation ```kotlin\nacc: Int\n```
//                                                                 ^^^^^ definition local 3
//                                                                       display_name entry
//                                                                       documentation ```kotlin\nentry: MutableMap.MutableEntry<Column<*>, Any?>\n```
//                                                              ⌃ enclosing_range_end local 2
//                                                                     ⌃ enclosing_range_end local 3
          (acc * 31) + entry.hashCode()
//         ^^^ reference local 2
//             ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                   ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                     ^^^^^ reference local 3
//                           ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#hashCode().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().(other)
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().(other)
          if (other is EntityID<*>) return this == other._value
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().(other)
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().(other)
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#_value.
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#get_value().
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#set_value().
          if (other !is CompositeID) return false
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().(other)
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
  
          return values == other.values
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().(other)
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#`<init>`().
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion# 8:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#`<init>`(). 8:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): CompositeID.Companion\n```
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#invoke().
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#invoke().(body)
          operator fun invoke(body: (CompositeID) -> Unit): CompositeID {
//                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#invoke().
//                            display_name invoke
//                            documentation ```kotlin\npublic final operator fun invoke(body: (CompositeID) -> Unit): CompositeID\n```
//                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#invoke().(body)
//                                 display_name body
//                                 documentation ```kotlin\nbody: (CompositeID) -> Unit\n```
//                                  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#invoke().(body)
//                                                  ⌄ enclosing_range_start local 4
              return CompositeID().apply(body).also {
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#`<init>`().
//                                 ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#invoke().(body)
//                                             ^^^^ reference semanticdb maven . . kotlin/also().
//                                                  ^ definition local 4 4:13
//                                                    display_name it
//                                                    documentation ```kotlin\nit: CompositeID\n```
                  require(it.values.isNotEmpty()) {
//                ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                        ^^ reference local 4
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                  ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+10).
                      "CompositeID must be initialized with at least one key column mapping"
                  }
              }
//            ⌃ enclosing_range_end local 4
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#invoke().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
