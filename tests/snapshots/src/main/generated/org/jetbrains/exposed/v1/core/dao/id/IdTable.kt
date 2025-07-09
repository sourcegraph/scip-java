package org.jetbrains.exposed.v1.core.dao.id
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                        ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/

import org.jetbrains.exposed.v1.core.*
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
import org.jetbrains.exposed.v1.core.SqlExpressionBuilder.wrap
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlExpressionBuilder#
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlExpressionBuilder/wrap/
import java.util.*
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/

/** Base class representing a producer of [EntityID] instances.  */
interface EntityIDFactory {
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFactory#
//                        display_name EntityIDFactory
//                        documentation ```kotlin\npublic abstract interface EntityIDFactory : Any\n```\n\n----\n\n Base class representing a producer of [EntityID] instances.
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 772>`#
    /** Returns a new [EntityID] that holds a [value] of type [T], for the specified [table]. */
    fun <T : Any> createEntityID(value: T, table: IdTable<T>): EntityID<T>
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFactory#createEntityID().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Any\n```
//                ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFactory#createEntityID().
//                               display_name createEntityID
//                               documentation ```kotlin\npublic abstract fun <T : Any> createEntityID(value: T, table: IdTable<T>): EntityID<T>\n\n```\n\n----\n\n Returns a new [EntityID] that holds a [value] of type [T], for the specified [table].
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 772>`#createEntityID().
//                               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFactory#createEntityID().(value)
//                                     display_name value
//                                     documentation ```kotlin\nvalue: T\n```
//                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFactory#createEntityID().(table)
//                                               display_name table
//                                               documentation ```kotlin\ntable: IdTable<T>\n```
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
}

/** Class responsible for locating and providing the appropriate functions to produce [EntityID] instances. */
object EntityIDFunctionProvider {
//     ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#
//                              display_name EntityIDFunctionProvider
//                              documentation ```kotlin\npublic final object EntityIDFunctionProvider : Any\n```\n\n----\n\n Class responsible for locating and providing the appropriate functions to produce [EntityID] instances.
//     ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#`<init>`().
//                              display_name EntityIDFunctionProvider
//                              documentation ```kotlin\nprivate constructor(): EntityIDFunctionProvider\n```\n\n----\n\n Class responsible for locating and providing the appropriate functions to produce [EntityID] instances.
    private val factory: EntityIDFactory
//              ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#factory.
//                      display_name factory
//                      documentation ```kotlin\nprivate final val factory: EntityIDFactory\n```
//              ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#getFactory().
//                      display_name factory
//                      documentation ```kotlin\nprivate get(): EntityIDFactory\n```
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFactory#
    init {
        factory = ServiceLoader.load(EntityIDFactory::class.java, EntityIDFactory::class.java.classLoader).firstOrNull()
//      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#factory.
//      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#getFactory().
//                              ^^^^ reference semanticdb maven jdk 11 java/util/ServiceLoader#load().
//                                                          ^^^^ reference semanticdb maven . . kotlin/jvm/getJava().
//                                                          ^^^^ reference semanticdb maven . . kotlin/jvm/java.
//                                                                                       ^^^^ reference semanticdb maven . . kotlin/jvm/getJava().
//                                                                                       ^^^^ reference semanticdb maven . . kotlin/jvm/java.
//                                                                                            ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#classLoader.
//                                                                                            ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#getClassLoader().
//                                                                                                         ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+18).
            ?: object : EntityIDFactory {
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 772>`#
//                    display_name <anonymous>
//                    documentation ```kotlin\nobject : EntityIDFactory\n```
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFactory#
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 772>`#`<init>`().
//                    display_name <anonymous>
//                    documentation ```kotlin\nprivate constructor(): <anonymous>\n```
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFactory#
                override fun <T : Any> createEntityID(value: T, table: IdTable<T>): EntityID<T> {
//                            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 772>`#createEntityID().[T]
//                              display_name FirTypeParameterSymbol T
//                              documentation ```kotlin\nT : Any\n```
//                                     ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 772>`#createEntityID().
//                                                    display_name createEntityID
//                                                    documentation ```kotlin\npublic open override fun <T : Any> createEntityID(value: T, table: IdTable<T>): EntityID<T>\n```
//                                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFactory#createEntityID().
//                                                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 772>`#createEntityID().(value)
//                                                          display_name value
//                                                          documentation ```kotlin\nvalue: T\n```
//                                                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 772>`#createEntityID().(table)
//                                                                    display_name table
//                                                                    documentation ```kotlin\ntable: IdTable<T>\n```
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
                    return EntityID(value, table)
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 772>`#createEntityID().(value)
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 772>`#createEntityID().(table)
                }
            }
    }

    /** Returns a new [EntityID] that holds a [value] of type [T], for the specified [table]. */
    fun <T : Any> createEntityID(value: T, table: IdTable<T>) = factory.createEntityID(value, table)
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#createEntityID().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Any\n```
//                ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#createEntityID().
//                               display_name createEntityID
//                               documentation ```kotlin\npublic final fun <T : Any> createEntityID(value: T, table: IdTable<T>): EntityID<T>\n```\n\n----\n\n Returns a new [EntityID] that holds a [value] of type [T], for the specified [table].
//                               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#createEntityID().(value)
//                                     display_name value
//                                     documentation ```kotlin\nvalue: T\n```
//                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#createEntityID().(table)
//                                               display_name table
//                                               documentation ```kotlin\ntable: IdTable<T>\n```
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#factory.
//                                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#getFactory().
//                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFactory#createEntityID().
//                                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#createEntityID().(value)
//                                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#createEntityID().(table)
}

/**
 * Base class for an identity table, which could be referenced from other tables.
 *
 * @param name Table name. By default, this will be resolved from any class name with a "Table" suffix removed (if present).
 */
abstract class IdTable<T : Any>(name: String = "") : Table(name) {
//             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                     display_name IdTable
//                     documentation ```kotlin\npublic abstract class IdTable<T : Any> : Table\n```\n\n----\n\n\n Base class for an identity table, which could be referenced from other tables.\n\n @param name Table name. By default, this will be resolved from any class name with a "Table" suffix removed (if present).\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IntIdTable#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/LongIdTable#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UIntIdTable#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/ULongIdTable#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UUIDTable#
//             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#`<init>`().
//                     display_name IdTable
//                     documentation ```kotlin\npublic constructor<T : Any>(name: String = ...): IdTable<T>\n```
//                     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#[T]
//                       display_name FirTypeParameterSymbol T
//                       documentation ```kotlin\nT : Any\n```
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#`<init>`().(name)
//                                   display_name name
//                                   documentation ```kotlin\nname: String = ...\n```
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#`<init>`().(name)
    /** The identity column of this [IdTable], for storing values of type [T] wrapped as [EntityID] instances. */
    abstract val id: Column<EntityID<T>>
//               ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#getId().
//                  display_name id
//                  documentation ```kotlin\npublic get(): Column<EntityID<T>>\n```\n\n----\n\n The identity column of this [IdTable], for storing values of type [T] wrapped as [EntityID] instances.
//               ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#id.
//                  display_name id
//                  documentation ```kotlin\npublic abstract val id: Column<EntityID<T>>\n```\n\n----\n\n The identity column of this [IdTable], for storing values of type [T] wrapped as [EntityID] instances.
//                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#

    private val _idColumns = HashSet<Column<out Any>>()
//              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#_idColumns.
//                         display_name _idColumns
//                         documentation ```kotlin\nprivate final val _idColumns: HashSet<Column<out Any>>\n```
//              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#get_idColumns().
//                         display_name _idColumns
//                         documentation ```kotlin\nprivate get(): HashSet<Column<out Any>>\n```
//                           ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#`<init>`().

    /** All base columns that make up this [IdTable]'s identifier column. */
    val idColumns: Set<Column<out Any>>
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#idColumns.
//                display_name idColumns
//                documentation ```kotlin\npublic final val idColumns: Set<Column<out Any>>\n```\n\n----\n\n All base columns that make up this [IdTable]'s identifier column.
//                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Set#
        get() = _idColumns.ifEmpty {
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#getIdColumns().
//          display_name idColumns
//          documentation ```kotlin\npublic get(): Set<Column<out Any>>\n```
//              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#_idColumns.
//              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#get_idColumns().
//                         ^^^^^^^ reference semanticdb maven . . kotlin/collections/ifEmpty(+1).
            val message = "Table definition must include id columns. Please use Column.entityId() or IdTable.addIdColumn()."
//              ^^^^^^^ definition local 0
//                      display_name message
//                      documentation ```kotlin\nlocal val message: String\n```
            exposedLogger.error(message)
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                        ^^^^^ reference semanticdb maven . . org/slf4j/Logger#error().
//                              ^^^^^^^ reference local 0
            error(message)
//          ^^^^^ reference semanticdb maven . . kotlin/error().
//                ^^^^^^^ reference local 0
        }

    /** Adds a column to [idColumns] so that it can be used as a component of the [id] property. */
    protected fun <S : Any> addIdColumn(newColumn: Column<EntityID<S>>) {
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#addIdColumn().[S]
//                   display_name FirTypeParameterSymbol S
//                   documentation ```kotlin\nS : Any\n```
//                          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#addIdColumn().
//                                      display_name addIdColumn
//                                      documentation ```kotlin\nprotected final fun <S : Any> addIdColumn(newColumn: Column<EntityID<S>>): Unit\n```\n\n----\n\n Adds a column to [idColumns] so that it can be used as a component of the [id] property.
//                                      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#addIdColumn().(newColumn)
//                                                display_name newColumn
//                                                documentation ```kotlin\nnewColumn: Column<EntityID<S>>\n```
//                                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
        if (_idColumns.isNotEmpty() && this !is CompositeIdTable) {
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#_idColumns.
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#get_idColumns().
//                     ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
            val message = "CompositeIdTable should be used if multiple EntityID key columns are required"
//              ^^^^^^^ definition local 1
//                      display_name message
//                      documentation ```kotlin\nlocal val message: String\n```
            exposedLogger.error(message)
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                        ^^^^^ reference semanticdb maven . . org/slf4j/Logger#error().
//                              ^^^^^^^ reference local 1
            error(message)
//          ^^^^^ reference semanticdb maven . . kotlin/error().
//                ^^^^^^^ reference local 1
        }
        _idColumns.add(newColumn)
//      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#_idColumns.
//      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#get_idColumns().
//                 ^^^ reference semanticdb maven jdk 11 java/util/HashSet#add().
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#addIdColumn().(newColumn)
    }

    internal fun <S : Any> addIdColumnInternal(newColumn: Column<EntityID<S>>) { addIdColumn(newColumn) }
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#addIdColumnInternal().[S]
//                  display_name FirTypeParameterSymbol S
//                  documentation ```kotlin\nS : Any\n```
//                         ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#addIdColumnInternal().
//                                             display_name addIdColumnInternal
//                                             documentation ```kotlin\ninternal final fun <S : Any> addIdColumnInternal(newColumn: Column<EntityID<S>>): Unit\n```
//                                             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#addIdColumnInternal().(newColumn)
//                                                       display_name newColumn
//                                                       documentation ```kotlin\nnewColumn: Column<EntityID<S>>\n```
//                                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#addIdColumn().
//                                                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#addIdColumnInternal().(newColumn)
}

/**
 * Identity table with a primary key consisting of an auto-incrementing `Int` value.
 *
 * @param name Table name. By default, this will be resolved from any class name with a "Table" suffix removed (if present).
 * @param columnName Name for the primary key column. By default, "id" is used.
 */
open class IntIdTable(name: String = "", columnName: String = "id") : IdTable<Int>(name) {
//         ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IntIdTable#
//                    display_name IntIdTable
//                    documentation ```kotlin\npublic open class IntIdTable : IdTable<Int>\n```\n\n----\n\n\n Identity table with a primary key consisting of an auto-incrementing `Int` value.\n\n @param name Table name. By default, this will be resolved from any class name with a "Table" suffix removed (if present).\n @param columnName Name for the primary key column. By default, "id" is used.\n
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//         ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IntIdTable#`<init>`().
//                    display_name IntIdTable
//                    documentation ```kotlin\npublic constructor(name: String = ..., columnName: String = ...): IntIdTable\n```
//                    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IntIdTable#`<init>`().(name)
//                         display_name name
//                         documentation ```kotlin\nname: String = ...\n```
//                          ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                       ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IntIdTable#`<init>`().(columnName)
//                                                  display_name columnName
//                                                  documentation ```kotlin\ncolumnName: String = ...\n```
//                                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IntIdTable#`<init>`().(name)
    /** The identity column of this [IntIdTable], for storing 4-byte integers wrapped as [EntityID] instances. */
    final override val id: Column<EntityID<Int>> = integer(columnName).autoIncrement().entityId()
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IntIdTable#getId().
//                        display_name id
//                        documentation ```kotlin\npublic get(): Column<EntityID<Int>>\n```\n\n----\n\n The identity column of this [IntIdTable], for storing 4-byte integers wrapped as [EntityID] instances.
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IntIdTable#id.
//                        display_name id
//                        documentation ```kotlin\npublic final override val id: Column<EntityID<Int>>\n```\n\n----\n\n The identity column of this [IntIdTable], for storing 4-byte integers wrapped as [EntityID] instances.
//                         ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#integer().
//                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IntIdTable#`<init>`().(columnName)
//                                                                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IntIdTable#autoIncrement().
//                                                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IntIdTable#entityId().
    final override val primaryKey = PrimaryKey(id)
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IntIdTable#getPrimaryKey().
//                                display_name primaryKey
//                                documentation ```kotlin\npublic get(): Table.PrimaryKey\n```
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IntIdTable#primaryKey.
//                                display_name primaryKey
//                                documentation ```kotlin\npublic final override val primaryKey: Table.PrimaryKey\n```
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).
//                                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IntIdTable#getId().
//                                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IntIdTable#id.
}

/**
 * Identity table with a primary key consisting of an auto-incrementing `UInt` value.
 *
 * @param name Table name. By default, this will be resolved from any class name with a "Table" suffix removed (if present).
 * @param columnName Name for the primary key column. By default, "id" is used.
 */
open class UIntIdTable(name: String = "", columnName: String = "id") : IdTable<UInt>(name) {
//         ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UIntIdTable#
//                     display_name UIntIdTable
//                     documentation ```kotlin\npublic open class UIntIdTable : IdTable<UInt>\n```\n\n----\n\n\n Identity table with a primary key consisting of an auto-incrementing `UInt` value.\n\n @param name Table name. By default, this will be resolved from any class name with a "Table" suffix removed (if present).\n @param columnName Name for the primary key column. By default, "id" is used.\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//         ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UIntIdTable#`<init>`().
//                     display_name UIntIdTable
//                     documentation ```kotlin\npublic constructor(name: String = ..., columnName: String = ...): UIntIdTable\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UIntIdTable#`<init>`().(name)
//                          display_name name
//                          documentation ```kotlin\nname: String = ...\n```
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UIntIdTable#`<init>`().(columnName)
//                                                   display_name columnName
//                                                   documentation ```kotlin\ncolumnName: String = ...\n```
//                                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UIntIdTable#`<init>`().(name)
    /** The identity column of this [IntIdTable], for storing 4-byte unsigned integers wrapped as [EntityID] instances. */
    final override val id: Column<EntityID<UInt>> = uinteger(columnName).autoIncrement().entityId()
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UIntIdTable#getId().
//                        display_name id
//                        documentation ```kotlin\npublic get(): Column<EntityID<UInt>>\n```\n\n----\n\n The identity column of this [IntIdTable], for storing 4-byte unsigned integers wrapped as [EntityID] instances.
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UIntIdTable#id.
//                        display_name id
//                        documentation ```kotlin\npublic final override val id: Column<EntityID<UInt>>\n```\n\n----\n\n The identity column of this [IntIdTable], for storing 4-byte unsigned integers wrapped as [EntityID] instances.
//                         ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uinteger().
//                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UIntIdTable#`<init>`().(columnName)
//                                                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UIntIdTable#autoIncrement().
//                                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UIntIdTable#entityId().
    final override val primaryKey = PrimaryKey(id)
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UIntIdTable#getPrimaryKey().
//                                display_name primaryKey
//                                documentation ```kotlin\npublic get(): Table.PrimaryKey\n```
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UIntIdTable#primaryKey.
//                                display_name primaryKey
//                                documentation ```kotlin\npublic final override val primaryKey: Table.PrimaryKey\n```
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).
//                                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UIntIdTable#getId().
//                                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UIntIdTable#id.
}

/**
 * Identity table with a primary key consisting of an auto-incrementing `Long` value.
 *
 * @param name Table name. By default, this will be resolved from any class name with a "Table" suffix removed (if present).
 * @param columnName Name for the primary key column. By default, "id" is used.
 */
open class LongIdTable(name: String = "", columnName: String = "id") : IdTable<Long>(name) {
//         ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/LongIdTable#
//                     display_name LongIdTable
//                     documentation ```kotlin\npublic open class LongIdTable : IdTable<Long>\n```\n\n----\n\n\n Identity table with a primary key consisting of an auto-incrementing `Long` value.\n\n @param name Table name. By default, this will be resolved from any class name with a "Table" suffix removed (if present).\n @param columnName Name for the primary key column. By default, "id" is used.\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//         ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/LongIdTable#`<init>`().
//                     display_name LongIdTable
//                     documentation ```kotlin\npublic constructor(name: String = ..., columnName: String = ...): LongIdTable\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/LongIdTable#`<init>`().(name)
//                          display_name name
//                          documentation ```kotlin\nname: String = ...\n```
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/LongIdTable#`<init>`().(columnName)
//                                                   display_name columnName
//                                                   documentation ```kotlin\ncolumnName: String = ...\n```
//                                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/LongIdTable#`<init>`().(name)
    /** The identity column of this [LongIdTable], for storing 8-byte integers wrapped as [EntityID] instances. */
    final override val id: Column<EntityID<Long>> = long(columnName).autoIncrement().entityId()
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/LongIdTable#getId().
//                        display_name id
//                        documentation ```kotlin\npublic get(): Column<EntityID<Long>>\n```\n\n----\n\n The identity column of this [LongIdTable], for storing 8-byte integers wrapped as [EntityID] instances.
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/LongIdTable#id.
//                        display_name id
//                        documentation ```kotlin\npublic final override val id: Column<EntityID<Long>>\n```\n\n----\n\n The identity column of this [LongIdTable], for storing 8-byte integers wrapped as [EntityID] instances.
//                         ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#long().
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/LongIdTable#`<init>`().(columnName)
//                                                                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/LongIdTable#autoIncrement().
//                                                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/LongIdTable#entityId().
    final override val primaryKey = PrimaryKey(id)
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/LongIdTable#getPrimaryKey().
//                                display_name primaryKey
//                                documentation ```kotlin\npublic get(): Table.PrimaryKey\n```
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/LongIdTable#primaryKey.
//                                display_name primaryKey
//                                documentation ```kotlin\npublic final override val primaryKey: Table.PrimaryKey\n```
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).
//                                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/LongIdTable#getId().
//                                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/LongIdTable#id.
}

/**
 * Identity table with a primary key consisting of an auto-incrementing `ULong` value.
 *
 * @param name Table name. By default, this will be resolved from any class name with a "Table" suffix removed (if present).
 * @param columnName Name for the primary key column. By default, "id" is used.
 */
open class ULongIdTable(name: String = "", columnName: String = "id") : IdTable<ULong>(name) {
//         ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/ULongIdTable#
//                      display_name ULongIdTable
//                      documentation ```kotlin\npublic open class ULongIdTable : IdTable<ULong>\n```\n\n----\n\n\n Identity table with a primary key consisting of an auto-incrementing `ULong` value.\n\n @param name Table name. By default, this will be resolved from any class name with a "Table" suffix removed (if present).\n @param columnName Name for the primary key column. By default, "id" is used.\n
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//         ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/ULongIdTable#`<init>`().
//                      display_name ULongIdTable
//                      documentation ```kotlin\npublic constructor(name: String = ..., columnName: String = ...): ULongIdTable\n```
//                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/ULongIdTable#`<init>`().(name)
//                           display_name name
//                           documentation ```kotlin\nname: String = ...\n```
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                         ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/ULongIdTable#`<init>`().(columnName)
//                                                    display_name columnName
//                                                    documentation ```kotlin\ncolumnName: String = ...\n```
//                                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/ULongIdTable#`<init>`().(name)
    /** The identity column of this [ULongIdTable], for storing 8-byte unsigned integers wrapped as [EntityID] instances. */
    final override val id: Column<EntityID<ULong>> = ulong(columnName).autoIncrement().entityId()
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/ULongIdTable#getId().
//                        display_name id
//                        documentation ```kotlin\npublic get(): Column<EntityID<ULong>>\n```\n\n----\n\n The identity column of this [ULongIdTable], for storing 8-byte unsigned integers wrapped as [EntityID] instances.
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/ULongIdTable#id.
//                        display_name id
//                        documentation ```kotlin\npublic final override val id: Column<EntityID<ULong>>\n```\n\n----\n\n The identity column of this [ULongIdTable], for storing 8-byte unsigned integers wrapped as [EntityID] instances.
//                         ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ulong().
//                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/ULongIdTable#`<init>`().(columnName)
//                                                                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/ULongIdTable#autoIncrement().
//                                                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/ULongIdTable#entityId().
    final override val primaryKey = PrimaryKey(id)
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/ULongIdTable#getPrimaryKey().
//                                display_name primaryKey
//                                documentation ```kotlin\npublic get(): Table.PrimaryKey\n```
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/ULongIdTable#primaryKey.
//                                display_name primaryKey
//                                documentation ```kotlin\npublic final override val primaryKey: Table.PrimaryKey\n```
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).
//                                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/ULongIdTable#getId().
//                                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/ULongIdTable#id.
}

/**
 * Identity table with a primary key consisting of an auto-generating [UUID] value.
 *
 * **Note** The specific UUID column type used depends on the database.
 * The stored identity value will be auto-generated on the client side just before insertion of a new row.
 *
 * @param name Table name. By default, this will be resolved from any class name with a "Table" suffix removed (if present).
 * @param columnName Name for the primary key column. By default, "id" is used.
 */
open class UUIDTable(name: String = "", columnName: String = "id") : IdTable<UUID>(name) {
//         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UUIDTable#
//                   display_name UUIDTable
//                   documentation ```kotlin\npublic open class UUIDTable : IdTable<UUID>\n```\n\n----\n\n\n Identity table with a primary key consisting of an auto-generating [UUID] value.\n\n **Note** The specific UUID column type used depends on the database.\n The stored identity value will be auto-generated on the client side just before insertion of a new row.\n\n @param name Table name. By default, this will be resolved from any class name with a "Table" suffix removed (if present).\n @param columnName Name for the primary key column. By default, "id" is used.\n
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UUIDTable#`<init>`().
//                   display_name UUIDTable
//                   documentation ```kotlin\npublic constructor(name: String = ..., columnName: String = ...): UUIDTable\n```
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UUIDTable#`<init>`().(name)
//                        display_name name
//                        documentation ```kotlin\nname: String = ...\n```
//                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UUIDTable#`<init>`().(columnName)
//                                                 display_name columnName
//                                                 documentation ```kotlin\ncolumnName: String = ...\n```
//                                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UUIDTable#`<init>`().(name)
    /** The identity column of this [UUIDTable], for storing UUIDs wrapped as [EntityID] instances. */
    final override val id: Column<EntityID<UUID>> = uuid(columnName).autoGenerate().entityId()
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UUIDTable#getId().
//                        display_name id
//                        documentation ```kotlin\npublic get(): Column<EntityID<UUID>>\n```\n\n----\n\n The identity column of this [UUIDTable], for storing UUIDs wrapped as [EntityID] instances.
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UUIDTable#id.
//                        display_name id
//                        documentation ```kotlin\npublic final override val id: Column<EntityID<UUID>>\n```\n\n----\n\n The identity column of this [UUIDTable], for storing UUIDs wrapped as [EntityID] instances.
//                         ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uuid().
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UUIDTable#`<init>`().(columnName)
//                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoGenerate().
//                                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UUIDTable#entityId().
    final override val primaryKey = PrimaryKey(id)
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UUIDTable#getPrimaryKey().
//                                display_name primaryKey
//                                documentation ```kotlin\npublic get(): Table.PrimaryKey\n```
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UUIDTable#primaryKey.
//                                display_name primaryKey
//                                documentation ```kotlin\npublic final override val primaryKey: Table.PrimaryKey\n```
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).
//                                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UUIDTable#getId().
//                                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/UUIDTable#id.
}

/**
 * Identity table with a primary key consisting of a combination of columns.
 *
 * @param name Table name. By default, this will be resolved from any class name with a "Table" suffix removed (if present).
 */
open class CompositeIdTable(name: String = "") : IdTable<CompositeID>(name) {
//         ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#
//                          display_name CompositeIdTable
//                          documentation ```kotlin\npublic open class CompositeIdTable : IdTable<CompositeID>\n```\n\n----\n\n\n Identity table with a primary key consisting of a combination of columns.\n\n @param name Table name. By default, this will be resolved from any class name with a "Table" suffix removed (if present).\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//         ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#`<init>`().
//                          display_name CompositeIdTable
//                          documentation ```kotlin\npublic constructor(name: String = ...): CompositeIdTable\n```
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#`<init>`().(name)
//                               display_name name
//                               documentation ```kotlin\nname: String = ...\n```
//                                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#`<init>`().(name)
    /** The identity column of this [CompositeIdTable], for storing references to all key columns wrapped as [EntityID] instances. */
    final override val id: Column<EntityID<CompositeID>> = compositeIdColumn()
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#getId().
//                        display_name id
//                        documentation ```kotlin\npublic get(): Column<EntityID<CompositeID>>\n```\n\n----\n\n The identity column of this [CompositeIdTable], for storing references to all key columns wrapped as [EntityID] instances.
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#id.
//                        display_name id
//                        documentation ```kotlin\npublic final override val id: Column<EntityID<CompositeID>>\n```\n\n----\n\n The identity column of this [CompositeIdTable], for storing references to all key columns wrapped as [EntityID] instances.
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#compositeIdColumn().

    private fun compositeIdColumn(): Column<EntityID<CompositeID>> {
//              ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#compositeIdColumn().
//                                display_name compositeIdColumn
//                                documentation ```kotlin\nprivate final fun compositeIdColumn(): Column<EntityID<CompositeID>>\n```
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
        val placeholder = Column(
//          ^^^^^^^^^^^ definition local 2
//                      display_name placeholder
//                      documentation ```kotlin\nlocal val placeholder: Column<CompositeID>\n```
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
            this,
            "composite_id",
            object : ColumnType<CompositeID>() {
//          ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 6775>`#
//                 display_name <anonymous>
//                 documentation ```kotlin\nobject : ColumnType<CompositeID>\n```
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//          ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 6775>`#`<init>`().
//                 display_name <anonymous>
//                 documentation ```kotlin\nprivate constructor(): <anonymous>\n```
//                   ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
                override fun sqlType(): String = ""
//                           ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 6775>`#sqlType().
//                                   display_name sqlType
//                                   documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
                override fun valueFromDB(value: Any): CompositeID? = null
//                           ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 6775>`#valueFromDB().
//                                       display_name valueFromDB
//                                       documentation ```kotlin\npublic open override fun valueFromDB(value: Any): CompositeID?\n```
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 6775>`#valueFromDB().(value)
//                                             display_name value
//                                             documentation ```kotlin\nvalue: Any\n```
//                                              ^^^ reference semanticdb maven . . kotlin/Any#
//                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
            }
        )
        return Column(this, "composite_id", EntityIDColumnType(placeholder)).apply {
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
//                                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#`<init>`().
//                                                             ^^^^^^^^^^^ reference local 2
//                                                                           ^^^^^ reference semanticdb maven . . kotlin/apply().
            defaultValueFun = null
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun mapIdComparison(
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#mapIdComparison().
//                               display_name mapIdComparison
//                               documentation ```kotlin\n@Suppress(...) internal open override fun mapIdComparison(toCompare: Any?, booleanOperator: (Column<*>, Expression<*>) -> Op<Boolean>): Op<Boolean>\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().
        toCompare: Any?,
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#mapIdComparison().(toCompare)
//                display_name toCompare
//                documentation ```kotlin\ntoCompare: Any?\n```
//                 ^^^^ reference semanticdb maven . . kotlin/Any#
        booleanOperator: (Column<*>, Expression<*>) -> Op<Boolean>
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#mapIdComparison().(booleanOperator)
//                      display_name booleanOperator
//                      documentation ```kotlin\nbooleanOperator: (Column<*>, Expression<*>) -> Op<Boolean>\n```
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
    ): Op<Boolean> {
//     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
        (toCompare as? EntityID<CompositeID>) ?: error("toCompare must be an EntityID<CompositeID> value")
//       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#mapIdComparison().(toCompare)
//                                               ^^^^^ reference semanticdb maven . . kotlin/error().
        return idColumns.map { column ->
//             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#getIdColumns().
//             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#idColumns.
//                       ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                             ^^^^^^ definition semanticdb maven . . (column)
//                                    display_name column
//                                    documentation ```kotlin\ncolumn: Column<out Any>\n```
            val otherValue = if (column in toCompare.value.values) {
//              ^^^^^^^^^^ definition local 3
//                         display_name otherValue
//                         documentation ```kotlin\nlocal val otherValue: EntityID<Any>\n```
//                               ^^^^^^ reference semanticdb maven . . (column)
//                                      ^^ reference semanticdb maven . . kotlin/collections/contains(+10).
//                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#mapIdComparison().(toCompare)
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
//                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
                toCompare.value[column as Column<EntityID<Any>>]
//              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#mapIdComparison().(toCompare)
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
//                              ^^^^^^ reference semanticdb maven . . (column)
            } else {
                error("Comparison CompositeID is missing a key mapping for ${column.name}")
//              ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                                           ^^^^^^ reference semanticdb maven . . (column)
//                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
            }
            booleanOperator(column, column.wrap(otherValue.value as? EntityID<*> ?: otherValue))
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#mapIdComparison().(booleanOperator)
//                          ^^^^^^ reference semanticdb maven . . (column)
//                                  ^^^^^^ reference semanticdb maven . . (column)
//                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                              ^^^^^^^^^^ reference local 3
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
//                                                                                  ^^^^^^^^^^ reference local 3
        }.compoundAnd()
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/compoundAnd().
    }

    override fun mapIdOperator(
//               ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#mapIdOperator().
//                             display_name mapIdOperator
//                             documentation ```kotlin\ninternal open override fun mapIdOperator(booleanOperator: (Column<*>) -> Op<Boolean>): Op<Boolean>\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().
        booleanOperator: (Column<*>) -> Op<Boolean>
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#mapIdOperator().(booleanOperator)
//                      display_name booleanOperator
//                      documentation ```kotlin\nbooleanOperator: (Column<*>) -> Op<Boolean>\n```
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
    ): Op<Boolean> = idColumns.map { booleanOperator(it) }.compoundAnd()
//     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#getIdColumns().
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#idColumns.
//                             ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                 ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                         display_name it
//                                                         documentation ```kotlin\nit: Column<out Any>\n```
//                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#mapIdOperator().(booleanOperator)
//                                                   ^^ reference semanticdb maven . . (it)
//                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/compoundAnd().
}
