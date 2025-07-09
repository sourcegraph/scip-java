package org.jetbrains.exposed.v1.core
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/

import org.jetbrains.exposed.v1.core.transactions.TransactionInterface
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#
import org.jetbrains.exposed.v1.core.vendors.inProperCase
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
import java.util.*
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
import java.util.concurrent.ConcurrentHashMap
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven . . java/util/concurrent/
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#

/** Represents a key for a value of type [T]. */
class Key<T>
//    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Key#
//        display_name Key
//        documentation ```kotlin\npublic final class Key<T> : Any\n```\n\n----\n\n Represents a key for a value of type [T].
//    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Key#`<init>`().
//        display_name Key
//        documentation ```kotlin\npublic constructor<T>(): Key<T>\n```\n\n----\n\n Represents a key for a value of type [T].
//        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Key#[T]
//          display_name FirTypeParameterSymbol T
//          documentation ```kotlin\nT\n```

/**
 * Class for storing transaction data that should remain available to the transaction scope even
 * after the transaction is committed.
 */
@Suppress("UNCHECKED_CAST")
open class UserDataHolder {
//         ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#
//                        display_name UserDataHolder
//                        documentation ```kotlin\n@Suppress(...) public open class UserDataHolder : Any\n```\n\n----\n\n\n Class for storing transaction data that should remain available to the transaction scope even\n after the transaction is committed.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//         ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#`<init>`().
//                        display_name UserDataHolder
//                        documentation ```kotlin\npublic constructor(): UserDataHolder\n```\n\n----\n\n\n Class for storing transaction data that should remain available to the transaction scope even\n after the transaction is committed.\n
    /** A mapping of a [Key] to any data value. */
    protected val userdata = ConcurrentHashMap<Key<*>, Any?>()
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getUserdata().
//                         display_name userdata
//                         documentation ```kotlin\nprotected get(): ConcurrentHashMap<Key<*>, Any?>\n```\n\n----\n\n A mapping of a [Key] to any data value.
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#userdata.
//                         display_name userdata
//                         documentation ```kotlin\nprotected final val userdata: ConcurrentHashMap<Key<*>, Any?>\n```\n\n----\n\n A mapping of a [Key] to any data value.
//                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#`<init>`().

    /** Maps the specified [key] to the specified [value]. */
    fun <T : Any> putUserData(key: Key<T>, value: T) {
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#putUserData().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Any\n```
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#putUserData().
//                            display_name putUserData
//                            documentation ```kotlin\npublic final fun <T : Any> putUserData(key: Key<T>, value: T): Unit\n```\n\n----\n\n Maps the specified [key] to the specified [value].
//                            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#putUserData().(key)
//                                display_name key
//                                documentation ```kotlin\nkey: Key<T>\n```
//                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Key#
//                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#putUserData().(value)
//                                               display_name value
//                                               documentation ```kotlin\nvalue: T\n```
        userdata[key] = value
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getUserdata().
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#userdata.
//      ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#putUserData().(key)
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#putUserData().(value)
    }

    /** Removes the specified [key] and its corresponding value. */
    fun <T : Any> removeUserData(key: Key<T>) = userdata.remove(key)
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#removeUserData().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Any\n```
//                ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#removeUserData().
//                               display_name removeUserData
//                               documentation ```kotlin\npublic final fun <T : Any> removeUserData(key: Key<T>): Any?\n```\n\n----\n\n Removes the specified [key] and its corresponding value.
//                               ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#removeUserData().(key)
//                                   display_name key
//                                   documentation ```kotlin\nkey: Key<T>\n```
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Key#
//                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getUserdata().
//                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#userdata.
//                                                       ^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#remove().
//                                                              ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#removeUserData().(key)

    /** Returns the value to which the specified [key] is mapped, as a value of type [T]. */
    fun <T : Any> getUserData(key: Key<T>): T? = userdata[key] as T?
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getUserData().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Any\n```
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getUserData().
//                            display_name getUserData
//                            documentation ```kotlin\npublic final fun <T : Any> getUserData(key: Key<T>): T?\n```\n\n----\n\n Returns the value to which the specified [key] is mapped, as a value of type [T].
//                            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getUserData().(key)
//                                display_name key
//                                documentation ```kotlin\nkey: Key<T>\n```
//                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Key#
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getUserdata().
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#userdata.
//                                               ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#get().
//                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getUserData().(key)

    /**
     * Returns the value for the specified [key]. If the [key] is not found, the [init] function is called,
     * then its result is mapped to the [key] and returned.
     */
    fun <T : Any> getOrCreate(key: Key<T>, init: () -> T): T = userdata.getOrPut(key, init) as T
//       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getOrCreate().[T]
//         display_name FirTypeParameterSymbol T
//         documentation ```kotlin\nT : Any\n```
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getOrCreate().
//                            display_name getOrCreate
//                            documentation ```kotlin\npublic final fun <T : Any> getOrCreate(key: Key<T>, init: () -> T): T\n```\n\n----\n\n\n Returns the value for the specified [key]. If the [key] is not found, the [init] function is called,\n then its result is mapped to the [key] and returned.\n
//                            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getOrCreate().(key)
//                                display_name key
//                                documentation ```kotlin\nkey: Key<T>\n```
//                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Key#
//                                         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getOrCreate().(init)
//                                              display_name init
//                                              documentation ```kotlin\ninit: () -> T\n```
//                                               ^^^^^^^ reference semanticdb maven . . kotlin/Function0#
//                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getUserdata().
//                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#userdata.
//                                                                      ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getOrPut().
//                                                                               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getOrCreate().(key)
//                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getOrCreate().(init)
}

/** Base class representing a unit block of work that is performed on a database. */
abstract class Transaction : UserDataHolder(), TransactionInterface {
//             ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                         display_name Transaction
//                         documentation ```kotlin\npublic abstract class Transaction : UserDataHolder, TransactionInterface\n```\n\n----\n\n Base class representing a unit block of work that is performed on a database.
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#
//             ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#`<init>`().
//                         display_name Transaction
//                         documentation ```kotlin\npublic constructor(): Transaction\n```\n\n----\n\n Base class representing a unit block of work that is performed on a database.
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#
//                                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#
    /** The current number of statements executed in this transaction. */
    var statementCount: Int = 0
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#getStatementCount().
//                     display_name statementCount
//                     documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n The current number of statements executed in this transaction.
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#setStatementCount().
//                     display_name statementCount
//                     documentation ```kotlin\npublic set(value: Int): Unit\n```\n\n----\n\n The current number of statements executed in this transaction.
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#setStatementCount().(value)
//                     display_name value
//                     documentation ```kotlin\nvalue: Int\n```\n\n----\n\n The current number of statements executed in this transaction.
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#statementCount.
//                     display_name statementCount
//                     documentation ```kotlin\npublic final var statementCount: Int\n```\n\n----\n\n The current number of statements executed in this transaction.
//                      ^^^ reference semanticdb maven . . kotlin/Int#

    /** The current total amount of time, in milliseconds, spent executing statements in this transaction. */
    var duration: Long = 0
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#duration.
//               display_name duration
//               documentation ```kotlin\npublic final var duration: Long\n```\n\n----\n\n The current total amount of time, in milliseconds, spent executing statements in this transaction.
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#getDuration().
//               display_name duration
//               documentation ```kotlin\npublic get(): Long\n```\n\n----\n\n The current total amount of time, in milliseconds, spent executing statements in this transaction.
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#setDuration().
//               display_name duration
//               documentation ```kotlin\npublic set(value: Long): Unit\n```\n\n----\n\n The current total amount of time, in milliseconds, spent executing statements in this transaction.
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#setDuration().(value)
//               display_name value
//               documentation ```kotlin\nvalue: Long\n```\n\n----\n\n The current total amount of time, in milliseconds, spent executing statements in this transaction.
//                ^^^^ reference semanticdb maven . . kotlin/Long#

    /** The threshold in milliseconds for query execution to exceed before logging a warning. */
    // TODO fix unused assignment (getter needs to check field if mutable)
    // TODO add unit tests
    var warnLongQueriesDuration: Long? = null
//      ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#setWarnLongQueriesDuration().
//                              display_name warnLongQueriesDuration
//                              documentation ```kotlin\npublic set(value: Long?): Unit\n```\n\n----\n\n The threshold in milliseconds for query execution to exceed before logging a warning.
//      ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#setWarnLongQueriesDuration().(value)
//                              display_name value
//                              documentation ```kotlin\nvalue: Long?\n```\n\n----\n\n The threshold in milliseconds for query execution to exceed before logging a warning.
//      ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#warnLongQueriesDuration.
//                              display_name warnLongQueriesDuration
//                              documentation ```kotlin\npublic final var warnLongQueriesDuration: Long?\n```\n\n----\n\n The threshold in milliseconds for query execution to exceed before logging a warning.
//                               ^^^^^ reference semanticdb maven . . kotlin/Long#
        get() = db.config.warnLongQueriesDuration
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#getWarnLongQueriesDuration().
//          display_name warnLongQueriesDuration
//          documentation ```kotlin\npublic get(): Long?\n```
//              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#config.
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getConfig().
//                        ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getWarnLongQueriesDuration().
//                        ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#warnLongQueriesDuration.

    /** Whether tracked values like [statementCount] and [duration] should be stored in [statementStats] for debugging. */
    var debug = false
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#debug.
//            display_name debug
//            documentation ```kotlin\npublic final var debug: Boolean\n```\n\n----\n\n Whether tracked values like [statementCount] and [duration] should be stored in [statementStats] for debugging.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#getDebug().
//            display_name debug
//            documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether tracked values like [statementCount] and [duration] should be stored in [statementStats] for debugging.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#setDebug().
//            display_name debug
//            documentation ```kotlin\npublic set(value: Boolean): Unit\n```\n\n----\n\n Whether tracked values like [statementCount] and [duration] should be stored in [statementStats] for debugging.
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#setDebug().(value)
//            display_name value
//            documentation ```kotlin\nvalue: Boolean\n```\n\n----\n\n Whether tracked values like [statementCount] and [duration] should be stored in [statementStats] for debugging.

    /**
     * The number of seconds the driver should wait for a statement to execute in a transaction before timing out.
     * Note that not all drivers implement this limit. For more information, refer to the relevant driver documentation.
     */
    var queryTimeout: Int? = null
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#getQueryTimeout().
//                   display_name queryTimeout
//                   documentation ```kotlin\npublic get(): Int?\n```\n\n----\n\n\n The number of seconds the driver should wait for a statement to execute in a transaction before timing out.\n Note that not all drivers implement this limit. For more information, refer to the relevant driver documentation.\n
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#queryTimeout.
//                   display_name queryTimeout
//                   documentation ```kotlin\npublic final var queryTimeout: Int?\n```\n\n----\n\n\n The number of seconds the driver should wait for a statement to execute in a transaction before timing out.\n Note that not all drivers implement this limit. For more information, refer to the relevant driver documentation.\n
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#setQueryTimeout().
//                   display_name queryTimeout
//                   documentation ```kotlin\npublic set(value: Int?): Unit\n```\n\n----\n\n\n The number of seconds the driver should wait for a statement to execute in a transaction before timing out.\n Note that not all drivers implement this limit. For more information, refer to the relevant driver documentation.\n
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#setQueryTimeout().(value)
//                   display_name value
//                   documentation ```kotlin\nvalue: Int?\n```\n\n----\n\n\n The number of seconds the driver should wait for a statement to execute in a transaction before timing out.\n Note that not all drivers implement this limit. For more information, refer to the relevant driver documentation.\n
//                    ^^^^ reference semanticdb maven . . kotlin/Int#

    /** The unique ID for this transaction. */
    val id by lazy { UUID.randomUUID().toString() }
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#getId().
//         display_name id
//         documentation ```kotlin\npublic get(): @EnhancedNullability String\n```\n\n----\n\n The unique ID for this transaction.
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#id.
//         display_name id
//         documentation ```kotlin\npublic final val id: String\n```\n\n----\n\n The unique ID for this transaction.
//            ^^^^ reference semanticdb maven . . kotlin/lazy().
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#getId().
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#id.
//                        ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/UUID#randomUUID().
//                                     ^^^^^^^^ reference semanticdb maven jdk 11 java/util/UUID#toString().

    /**
     * A [StringBuilder] containing string representations of previously executed statements
     * prefixed by their execution time in milliseconds.
     *
     * **Note:** [Transaction.debug] must be set to `true` for execution strings to be appended.
     */
    val statements = StringBuilder()
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#getStatements().
//                 display_name statements
//                 documentation ```kotlin\npublic get(): {kotlin/text/StringBuilder=} StringBuilder\n```\n\n----\n\n\n A [StringBuilder] containing string representations of previously executed statements\n prefixed by their execution time in milliseconds.\n\n **Note:** [Transaction.debug] must be set to `true` for execution strings to be appended.\n
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#statements.
//                 display_name statements
//                 documentation ```kotlin\npublic final val statements: {kotlin/text/StringBuilder=} StringBuilder\n```\n\n----\n\n\n A [StringBuilder] containing string representations of previously executed statements\n prefixed by their execution time in milliseconds.\n\n **Note:** [Transaction.debug] must be set to `true` for execution strings to be appended.\n
//                   ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#`<init>`().

    /**
     * A mapping of previously executed statements in this transaction, with a string representation of
     * the prepared statement as the key and the statement count to execution time as the value.
     *
     * **Note:** [Transaction.debug] must be set to `true` for this mapping to be populated.
     */
    val statementStats by lazy { hashMapOf<String, Pair<Int, Long>>() }
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#getStatementStats().
//                     display_name statementStats
//                     documentation ```kotlin\npublic get(): {kotlin/collections/HashMap<kotlin/String, kotlin/Pair<kotlin/Int, kotlin/Long>>=} HashMap<String, Pair<Int, Long>>\n```\n\n----\n\n\n A mapping of previously executed statements in this transaction, with a string representation of\n the prepared statement as the key and the statement count to execution time as the value.\n\n **Note:** [Transaction.debug] must be set to `true` for this mapping to be populated.\n
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#statementStats.
//                     display_name statementStats
//                     documentation ```kotlin\npublic final val statementStats: {kotlin/collections/HashMap<kotlin/String, kotlin/Pair<kotlin/Int, kotlin/Long>>=} HashMap<String, Pair<Int, Long>>\n```\n\n----\n\n\n A mapping of previously executed statements in this transaction, with a string representation of\n the prepared statement as the key and the statement count to execution time as the value.\n\n **Note:** [Transaction.debug] must be set to `true` for this mapping to be populated.\n
//                        ^^^^ reference semanticdb maven . . kotlin/lazy().
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#getStatementStats().
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#statementStats.
//                               ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/hashMapOf().

    /** Returns the string identifier of a [table], based on its [Table.tableName] and [Table.alias], if applicable. */
    @OptIn(InternalApi::class)
    fun identity(table: Table): String =
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//               display_name identity
//               documentation ```kotlin\n@OptIn(...) public final fun identity(table: Table): String\n```\n\n----\n\n Returns the string identifier of a [table], based on its [Table.tableName] and [Table.alias], if applicable.
//               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().(table)
//                     display_name table
//                     documentation ```kotlin\ntable: Table\n```
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
        (table as? Alias<*>)?.let { "${identity(it.delegate)} ${db.identifierManager.quoteIfNecessary(it.alias)}" }
//       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().(table)
//                            ^^^ reference semanticdb maven . . kotlin/let().
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                  display_name it
//                                                                                                                  documentation ```kotlin\nit: SqlLogger\n```
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                              ^^ reference semanticdb maven . . (it)
//                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                                                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                                                                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
//                                                                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                                                                                                    ^^ reference semanticdb maven . . (it)
//                                                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#alias.
//                                                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getAlias().
            ?: db.identifierManager.quoteIfNecessary(table.tableName.inProperCase())
//             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().(table)
//                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().

    /** Returns the complete string identifier of a [column], based on its [Table.tableName] and [Column.name]. */
    fun fullIdentity(column: Column<*>): String = QueryBuilder(false).also {
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity().
//                   display_name fullIdentity
//                   documentation ```kotlin\npublic final fun fullIdentity(column: Column<*>): String\n```\n\n----\n\n Returns the complete string identifier of a [column], based on its [Table.tableName] and [Column.name].
//                   ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity().(column)
//                          display_name column
//                          documentation ```kotlin\ncolumn: Column<*>\n```
//                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                                                                    ^^^^ reference semanticdb maven . . kotlin/also().
//                                                                         ^ definition semanticdb maven . . (it) 2:5
//                                                                           display_name it
//                                                                           documentation ```kotlin\nit: SqlLogger\n```
        fullIdentity(column, it)
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity(+1).
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity().(column)
//                           ^^ reference semanticdb maven . . (it)
    }.toString()
//    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().

    @OptIn(InternalApi::class)
    internal fun fullIdentity(column: Column<*>, queryBuilder: QueryBuilder) = queryBuilder {
//               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity(+1).
//                            display_name fullIdentity
//                            documentation ```kotlin\n@OptIn(...) internal final fun fullIdentity(column: Column<*>, queryBuilder: QueryBuilder): Unit\n```
//                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity(+1).(column)
//                                   display_name column
//                                   documentation ```kotlin\ncolumn: Column<*>\n```
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity(+1).(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity(+1).(queryBuilder)
        if (column.table is Alias<*>) {
//          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity(+1).(column)
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
            append(db.identifierManager.quoteIfNecessary(column.table.alias))
//          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                 ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                 ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity(+1).(column)
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#alias.
//                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getAlias().
        } else {
            append(db.identifierManager.quoteIfNecessary(column.table.tableName.inProperCase()))
//          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                 ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                 ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity(+1).(column)
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
        }
        append('.')
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append().
        append(identity(column))
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity(+1).(column)
    }

    /** Returns the string identifier of a [column], based on its [Column.name]. */
    fun identity(column: Column<*>): String = db.identifierManager.quoteIdentifierWhenWrongCaseOrNecessary(column.name)
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//               display_name identity
//               documentation ```kotlin\npublic final fun identity(column: Column<*>): String\n```\n\n----\n\n Returns the string identifier of a [column], based on its [Column.name].
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).(column)
//                      display_name column
//                      documentation ```kotlin\ncolumn: Column<*>\n```
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
//                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIdentifierWhenWrongCaseOrNecessary().
//                                                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).(column)
//                                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.

    /** Adds one or more [SqlLogger]s to this [Transaction]. */
    open fun addLogger(vararg logger: SqlLogger): CompositeSqlLogger {
//           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#addLogger().
//                     display_name addLogger
//                     documentation ```kotlin\npublic open fun addLogger(vararg logger: SqlLogger): CompositeSqlLogger\n```\n\n----\n\n Adds one or more [SqlLogger]s to this [Transaction].
//                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#addLogger().(logger)
//                                   display_name logger
//                                   documentation ```kotlin\nvararg logger: SqlLogger\n```
//                                    ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#
        return CompositeSqlLogger().apply {
//             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#`<init>`().
//                                  ^^^^^ reference semanticdb maven . . kotlin/apply().
            logger.forEach { this.addLogger(it) }
//          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#addLogger().(logger)
//                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach().
//                         ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                display_name it
//                                                documentation ```kotlin\nit: SqlLogger\n```
//                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#addLogger().
//                                          ^^ reference semanticdb maven . . (it)
        }
    }
}
