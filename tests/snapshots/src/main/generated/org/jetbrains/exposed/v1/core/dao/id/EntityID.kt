package org.jetbrains.exposed.v1.core.dao.id
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                        ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/

/**
 * Class representing a wrapper for a stored identity value of type [T].
 *
 * The class constructor could be useful, for example, if needing to manually provide an identity value to a column
 * default function or when manually inserting into identity columns using any DSL insert function.
 *
 * @param table The [IdTable] that stores the identity value.
 * @param id The value of type [T] to store.
 * @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTestsData.YTable
 * @sample org.jetbrains.exposed.v1.tests.shared.dml.InsertTests.testInsertWithPredefinedId
 */
open class EntityID<T : Any> protected constructor(val table: IdTable<T>, id: T?) {
//         ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
//                  display_name EntityID
//                  documentation ```kotlin\npublic open class EntityID<T : Any> : Any\n```\n\n----\n\n\n Class representing a wrapper for a stored identity value of type [T].\n\n The class constructor could be useful, for example, if needing to manually provide an identity value to a column\n default function or when manually inserting into identity columns using any DSL insert function.\n\n @param table The [IdTable] that stores the identity value.\n @param id The value of type [T] to store.\n @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTestsData.YTable\n @sample org.jetbrains.exposed.v1.tests.shared.dml.InsertTests.testInsertWithPredefinedId\n
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : Any\n```
//                                     ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`().
//                                                 display_name EntityID
//                                                 documentation ```kotlin\nprotected constructor<T : Any>(table: IdTable<T>, id: T?): EntityID<T>\n```
//                                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`().(table)
//                                                           display_name table
//                                                           documentation ```kotlin\ntable: IdTable<T>\n```
//                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`().(table)
//                                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getTable().
//                                                           display_name table
//                                                           documentation ```kotlin\npublic get(): IdTable<T>\n```
//                                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#table.
//                                                           display_name table
//                                                           documentation ```kotlin\npublic final val table: IdTable<T>\n```
//                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                        ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`().(id)
//                                                                           display_name id
//                                                                           documentation ```kotlin\nid: T?\n```
    constructor(id: T, table: IdTable<T>) : this(table, id)
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                                          display_name EntityID
//                                                          documentation ```kotlin\npublic constructor<T : Any>(id: T, table: IdTable<T>): EntityID<T>\n```
//              ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).(id)
//                 display_name id
//                 documentation ```kotlin\nid: T\n```
//                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).(table)
//                           display_name table
//                           documentation ```kotlin\ntable: IdTable<T>\n```
//                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).(table)
//                                                      ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).(id)

    @Suppress("VariableNaming")
    var _value: Any? = id
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#_value.
//             display_name _value
//             documentation ```kotlin\n@Suppress(...) public final var _value: Any?\n```
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#get_value().
//             display_name _value
//             documentation ```kotlin\npublic get(): Any?\n```
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#set_value().
//             display_name _value
//             documentation ```kotlin\npublic set(value: Any?): Unit\n```
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#set_value().(value)
//             display_name value
//             documentation ```kotlin\nvalue: Any?\n```
//              ^^^^ reference semanticdb maven . . kotlin/Any#
//                     ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`().(id)

    /** The identity value of type [T] wrapped by this [EntityID] instance. */
    val value: T
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
//            display_name value
//            documentation ```kotlin\npublic final val value: T\n```\n\n----\n\n The identity value of type [T] wrapped by this [EntityID] instance.
        get() {
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//          display_name value
//          documentation ```kotlin\npublic get(): T\n```
            if (_value == null) {
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#_value.
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#get_value().
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#set_value().
                invokeOnNoValue()
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#invokeOnNoValue().
                check(_value != null) { "Entity must be inserted" }
//              ^^^^^ reference semanticdb maven . . kotlin/check(+1).
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#_value.
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#get_value().
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#set_value().
            }

            @Suppress("UNCHECKED_CAST")
            return _value!! as T
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#_value.
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#get_value().
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#set_value().
        }

    /** Performs steps when the internal [_value] is accessed without first being initialized. */
    protected open fun invokeOnNoValue() {}
//                     ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#invokeOnNoValue().
//                                     display_name invokeOnNoValue
//                                     documentation ```kotlin\nprotected open fun invokeOnNoValue(): Unit\n```\n\n----\n\n Performs steps when the internal [_value] is accessed without first being initialized.

    override fun toString() = value.toString()
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#toString().
//                        display_name toString
//                        documentation ```kotlin\npublic open override fun toString(): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
//                                  ^^^^^^^^ reference semanticdb maven . . kotlin/Any#toString().

    override fun hashCode() = value.hashCode()
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#hashCode().
//                        display_name hashCode
//                        documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#hashCode().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
//                                  ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().

    override fun equals(other: Any?): Boolean {
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#equals().
//                      display_name equals
//                      documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                      relationship is_reference is_implementation semanticdb maven . . kotlin/Any#equals().
//                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#equals().(other)
//                            display_name other
//                            documentation ```kotlin\nother: Any?\n```
//                             ^^^^ reference semanticdb maven . . kotlin/Any#
//                                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        if (other !is EntityID<*>) return false
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#equals().(other)

        return other._value == _value && other.table == table
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#equals().(other)
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#_value.
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#get_value().
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#set_value().
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#_value.
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#get_value().
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#set_value().
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#equals().(other)
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getTable().
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#table.
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getTable().
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#table.
    }
}
