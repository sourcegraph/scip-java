package org.jetbrains.exposed.v1.core.dao.id
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                        ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/

import org.jetbrains.exposed.v1.core.Column
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#

/** Class representing a mapping of each composite primary key column to its stored identity value. */
class CompositeID private constructor() {
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
//                display_name CompositeID
//                documentation ```kotlin\npublic final class CompositeID : Any\n```\n\n----\n\n Class representing a mapping of each composite primary key column to its stored identity value.
//                        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#`<init>`().
//                                    display_name CompositeID
//                                    documentation ```kotlin\nprivate constructor(): CompositeID\n```
    internal val values: MutableMap<Column<*>, Any?> = HashMap()
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                      display_name values
//                      documentation ```kotlin\ninternal get(): MutableMap<Column<*>, Any?>\n```
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                      display_name values
//                      documentation ```kotlin\ninternal final val values: MutableMap<Column<*>, Any?>\n```
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#
//                                                     ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashMap#`<init>`().

    @Suppress("UNCHECKED_CAST")
    @JvmName("setWithEntityIdValue")
    operator fun <T : Any, ID : EntityID<T>> set(column: Column<ID>, value: T) {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : Any\n```
//                         ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().[ID]
//                            display_name FirTypeParameterSymbol ID
//                            documentation ```kotlin\nID : EntityID<T>\n```
//                                           ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().
//                                               display_name set
//                                               documentation ```kotlin\n@Suppress(...) @JvmName(...) public final operator fun <T : Any, ID : EntityID<T>> set(column: Column<ID>, value: T): Unit\n```
//                                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(column)
//                                                      display_name column
//                                                      documentation ```kotlin\ncolumn: Column<ID>\n```
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                   ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(value)
//                                                                         display_name value
//                                                                         documentation ```kotlin\nvalue: T\n```
        require(values.isEmpty() || values.keys.first().table == column.table) {
//      ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                     ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#isEmpty().
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                         ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getKeys().
//                                         ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#keys.
//                                              ^^^^^ reference semanticdb maven . . kotlin/collections/first(+18).
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(column)
//                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
            "CompositeID key columns must all come from the same IdTable ${values.keys.first().table.tableName}"
//                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                                                                ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getKeys().
//                                                                                ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#keys.
//                                                                                     ^^^^^ reference semanticdb maven . . kotlin/collections/first(+18).
//                                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
        }
        values[column] = EntityID(value, column.table as IdTable<T>)
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(column)
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(value)
//                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set().(column)
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
    }

    @Suppress("UNCHECKED_CAST")
    @JvmName("setWithNullableEntityIdValue")
    operator fun <T : Any, ID : EntityID<T>> set(column: Column<ID?>, value: T?) {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : Any\n```
//                         ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).[ID]
//                            display_name FirTypeParameterSymbol ID
//                            documentation ```kotlin\nID : EntityID<T>\n```
//                                           ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).
//                                               display_name set
//                                               documentation ```kotlin\n@Suppress(...) @JvmName(...) public final operator fun <T : Any, ID : EntityID<T>> set(column: Column<ID?>, value: T?): Unit\n```
//                                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(column)
//                                                      display_name column
//                                                      documentation ```kotlin\ncolumn: Column<ID?>\n```
//                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(value)
//                                                                          display_name value
//                                                                          documentation ```kotlin\nvalue: T?\n```
        require(column.columnType.nullable || value != null) {
//      ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(column)
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(value)
            "Trying to set null to not nullable column $column"
//                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(column)
        }
        values[column] = value?.let { EntityID(value, column.table as IdTable<T>) }
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(column)
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(value)
//                              ^^^ reference semanticdb maven . . kotlin/let().
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                  display_name it
//                                                                                  documentation ```kotlin\nit: CompositeID\n```
//                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(value)
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+1).(column)
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
    }

    @JvmName("setWithEntityID")
    operator fun <T : Any, ID : EntityID<T>> set(column: Column<ID>, value: ID) {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : Any\n```
//                         ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).[ID]
//                            display_name FirTypeParameterSymbol ID
//                            documentation ```kotlin\nID : EntityID<T>\n```
//                                           ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).
//                                               display_name set
//                                               documentation ```kotlin\n@JvmName(...) public final operator fun <T : Any, ID : EntityID<T>> set(column: Column<ID>, value: ID): Unit\n```
//                                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).(column)
//                                                      display_name column
//                                                      documentation ```kotlin\ncolumn: Column<ID>\n```
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                   ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).(value)
//                                                                         display_name value
//                                                                         documentation ```kotlin\nvalue: ID\n```
        require(values.isEmpty() || values.keys.first().table == column.table) {
//      ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                     ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#isEmpty().
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                         ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getKeys().
//                                         ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#keys.
//                                              ^^^^^ reference semanticdb maven . . kotlin/collections/first(+18).
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).(column)
//                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
            "CompositeID key columns must all come from the same IdTable ${values.keys.first().table.tableName}"
//                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                                                                ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getKeys().
//                                                                                ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#keys.
//                                                                                     ^^^^^ reference semanticdb maven . . kotlin/collections/first(+18).
//                                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
        }
        values[column] = value
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).(column)
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#set(+2).(value)
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <T : Any> get(column: Column<T>): T = values[column] as T
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : Any\n```
//                         ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().
//                             display_name get
//                             documentation ```kotlin\n@Suppress(...) public final operator fun <T : Any> get(column: Column<T>): T\n```
//                             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().(column)
//                                    display_name column
//                                    documentation ```kotlin\ncolumn: Column<T>\n```
//                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#get().
//                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().(column)

    operator fun contains(column: Column<*>): Boolean = values.contains(column)
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#contains().
//                        display_name contains
//                        documentation ```kotlin\npublic final operator fun contains(column: Column<*>): Boolean\n```
//                        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#contains().(column)
//                               display_name column
//                               documentation ```kotlin\ncolumn: Column<*>\n```
//                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                                             ^^^^^^^^ reference semanticdb maven . . kotlin/collections/contains(+10).
//                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#contains().(column)

    override fun toString(): String = "CompositeID(${values.entries.joinToString { "${it.key.name}=${it.value}" }})"
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#toString().
//                        display_name toString
//                        documentation ```kotlin\npublic open override fun toString(): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                                          ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#entries.
//                                                          ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getEntries().
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                display_name it
//                                                                                                                documentation ```kotlin\nit: CompositeID\n```
//                                                                                    ^^ reference semanticdb maven . . (it)
//                                                                                       ^^^ reference semanticdb maven . . kotlin/collections/MutableMap#MutableEntry#getKey().
//                                                                                       ^^^ reference semanticdb maven . . kotlin/collections/MutableMap#MutableEntry#key.
//                                                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                                                   ^^ reference semanticdb maven . . (it)
//                                                                                                      ^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#MutableEntry#getValue().
//                                                                                                      ^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#MutableEntry#value.

    override fun hashCode(): Int = values.entries.fold(0) { acc, entry ->
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#hashCode().
//                        display_name hashCode
//                        documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#hashCode().
//                           ^^^ reference semanticdb maven . . kotlin/Int#
//                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                        ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#entries.
//                                        ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getEntries().
//                                                ^^^^ reference semanticdb maven . . kotlin/collections/fold(+9).
//                                                          ^^^ definition semanticdb maven . . (acc)
//                                                              display_name acc
//                                                              documentation ```kotlin\nacc: Int\n```
//                                                               ^^^^^ definition semanticdb maven . . (entry)
//                                                                     display_name entry
//                                                                     documentation ```kotlin\nentry: MutableMap.MutableEntry<Column<*>, Any?>\n```
        (acc * 31) + entry.hashCode()
//       ^^^ reference semanticdb maven . . (acc)
//           ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                 ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                   ^^^^^ reference semanticdb maven . . (entry)
//                         ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().
    }

    override fun equals(other: Any?): Boolean {
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().
//                      display_name equals
//                      documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                      relationship is_reference is_implementation semanticdb maven . . kotlin/Any#equals().
//                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().(other)
//                            display_name other
//                            documentation ```kotlin\nother: Any?\n```
//                             ^^^^ reference semanticdb maven . . kotlin/Any#
//                                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        if (other is EntityID<*>) return this == other._value
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().(other)
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().(other)
//                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#_value.
//                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#get_value().
//                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#set_value().
        if (other !is CompositeID) return false
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().(other)

        return values == other.values
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#equals().(other)
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
    }

    companion object {
//  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion# 8:5
//                     display_name Companion
//                     documentation ```kotlin\npublic final companion object Companion : Any\n```
//  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#`<init>`(). 8:5
//                     display_name Companion
//                     documentation ```kotlin\nprivate constructor(): CompositeID.Companion\n```
        operator fun invoke(body: (CompositeID) -> Unit): CompositeID {
//                   ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#invoke().
//                          display_name invoke
//                          documentation ```kotlin\npublic final operator fun invoke(body: (CompositeID) -> Unit): CompositeID\n```
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#invoke().(body)
//                               display_name body
//                               documentation ```kotlin\nbody: (CompositeID) -> Unit\n```
//                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
            return CompositeID().apply(body).also {
//                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#`<init>`().
//                               ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#Companion#invoke().(body)
//                                           ^^^^ reference semanticdb maven . . kotlin/also().
//                                                ^ definition semanticdb maven . . (it) 4:13
//                                                  display_name it
//                                                  documentation ```kotlin\nit: CompositeID\n```
                require(it.values.isNotEmpty()) {
//              ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                      ^^ reference semanticdb maven . . (it)
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+10).
                    "CompositeID must be initialized with at least one key column mapping"
                }
            }
        }
    }
}
