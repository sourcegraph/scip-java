package org.jetbrains.exposed.v1.core.transactions
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/

import org.jetbrains.exposed.v1.core.DatabaseApi
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#
import org.jetbrains.exposed.v1.core.InternalApi
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/InternalApi#
import org.jetbrains.exposed.v1.core.Transaction
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
import java.util.concurrent.ConcurrentHashMap
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven . . java/util/concurrent/
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#
import java.util.concurrent.ConcurrentLinkedDeque
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven . . java/util/concurrent/
//                          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentLinkedDeque#
import java.util.concurrent.atomic.AtomicReference
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven . . java/util/concurrent/
//                          ^^^^^^ reference semanticdb maven . . java/util/concurrent/atomic/
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/atomic/AtomicReference#

@Suppress("ForbiddenComment")
// TODO: break down this to a separate files

private object NotInitializedTransactionManager : TransactionManagerApi {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#
//                                              display_name NotInitializedTransactionManager
//                                              documentation ```kotlin\n@Suppress(...) private final object NotInitializedTransactionManager : TransactionManagerApi\n```
//                                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#`<init>`().
//                                              display_name NotInitializedTransactionManager
//                                              documentation ```kotlin\nprivate constructor(): NotInitializedTransactionManager\n```
//                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#
    override var defaultReadOnly: Boolean = false
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#defaultReadOnly.
//                               display_name defaultReadOnly
//                               documentation ```kotlin\npublic open override var defaultReadOnly: Boolean\n```
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#getDefaultReadOnly().
//                               display_name defaultReadOnly
//                               documentation ```kotlin\npublic get(): Boolean\n```
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#setDefaultReadOnly().
//                               display_name defaultReadOnly
//                               documentation ```kotlin\npublic set(value: Boolean): Unit\n```
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#setDefaultReadOnly().(value)
//                               display_name value
//                               documentation ```kotlin\nvalue: Boolean\n```
//                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    override var defaultMaxAttempts: Int = -1
//               ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#defaultMaxAttempts.
//                                  display_name defaultMaxAttempts
//                                  documentation ```kotlin\npublic open override var defaultMaxAttempts: Int\n```
//               ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#getDefaultMaxAttempts().
//                                  display_name defaultMaxAttempts
//                                  documentation ```kotlin\npublic get(): Int\n```
//               ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#setDefaultMaxAttempts().
//                                  display_name defaultMaxAttempts
//                                  documentation ```kotlin\npublic set(value: Int): Unit\n```
//               ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#setDefaultMaxAttempts().(value)
//                                  display_name value
//                                  documentation ```kotlin\nvalue: Int\n```
//                                   ^^^ reference semanticdb maven . . kotlin/Int#

    override var defaultMinRetryDelay: Long = 0
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#defaultMinRetryDelay.
//                                    display_name defaultMinRetryDelay
//                                    documentation ```kotlin\npublic open override var defaultMinRetryDelay: Long\n```
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#getDefaultMinRetryDelay().
//                                    display_name defaultMinRetryDelay
//                                    documentation ```kotlin\npublic get(): Long\n```
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#setDefaultMinRetryDelay().
//                                    display_name defaultMinRetryDelay
//                                    documentation ```kotlin\npublic set(value: Long): Unit\n```
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#setDefaultMinRetryDelay().(value)
//                                    display_name value
//                                    documentation ```kotlin\nvalue: Long\n```
//                                     ^^^^ reference semanticdb maven . . kotlin/Long#

    override var defaultMaxRetryDelay: Long = 0
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#defaultMaxRetryDelay.
//                                    display_name defaultMaxRetryDelay
//                                    documentation ```kotlin\npublic open override var defaultMaxRetryDelay: Long\n```
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#getDefaultMaxRetryDelay().
//                                    display_name defaultMaxRetryDelay
//                                    documentation ```kotlin\npublic get(): Long\n```
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#setDefaultMaxRetryDelay().
//                                    display_name defaultMaxRetryDelay
//                                    documentation ```kotlin\npublic set(value: Long): Unit\n```
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#setDefaultMaxRetryDelay().(value)
//                                    display_name value
//                                    documentation ```kotlin\nvalue: Long\n```
//                                     ^^^^ reference semanticdb maven . . kotlin/Long#

    override fun currentOrNull(): Transaction = error(
//               ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#currentOrNull().
//                             display_name currentOrNull
//                             documentation ```kotlin\npublic open override fun currentOrNull(): Transaction\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#currentOrNull().
//                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                              ^^^^^ reference semanticdb maven . . kotlin/error().
        "Please call Database.connect() or R2dbcDatabase.connect() before using this code"
    )

    override fun bindTransactionToThread(transaction: Transaction?) {
//               ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#bindTransactionToThread().
//                                       display_name bindTransactionToThread
//                                       documentation ```kotlin\npublic open override fun bindTransactionToThread(transaction: Transaction?): Unit\n```
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#bindTransactionToThread().
//                                       ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#bindTransactionToThread().(transaction)
//                                                   display_name transaction
//                                                   documentation ```kotlin\ntransaction: Transaction?\n```
//                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
        error("Please call Database.connect() or R2dbcDatabase.connect() before using this code")
//      ^^^^^ reference semanticdb maven . . kotlin/error().
    }
}

/**
 * Represents the manager registered to a database, which is responsible for creating new transactions
 * and storing data related to the database and its transactions.
 */
interface TransactionManagerApi {
//        ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#
//                              display_name TransactionManagerApi
//                              documentation ```kotlin\npublic abstract interface TransactionManagerApi : Any\n```\n\n----\n\n\n Represents the manager registered to a database, which is responsible for creating new transactions\n and storing data related to the database and its transactions.\n
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#
    /** Whether transactions should be performed in read-only mode. Unless specified, the database default will be used. */
    var defaultReadOnly: Boolean
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#defaultReadOnly.
//                      display_name defaultReadOnly
//                      documentation ```kotlin\npublic abstract var defaultReadOnly: Boolean\n```\n\n----\n\n Whether transactions should be performed in read-only mode. Unless specified, the database default will be used.
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#getDefaultReadOnly().
//                      display_name defaultReadOnly
//                      documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether transactions should be performed in read-only mode. Unless specified, the database default will be used.
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#setDefaultReadOnly().
//                      display_name defaultReadOnly
//                      documentation ```kotlin\npublic set(value: Boolean): Unit\n```\n\n----\n\n Whether transactions should be performed in read-only mode. Unless specified, the database default will be used.
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#setDefaultReadOnly().(value)
//                      display_name value
//                      documentation ```kotlin\nvalue: Boolean\n```\n\n----\n\n Whether transactions should be performed in read-only mode. Unless specified, the database default will be used.
//                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    /** The default maximum amount of attempts that will be made to perform a transaction. */
    var defaultMaxAttempts: Int
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#defaultMaxAttempts.
//                         display_name defaultMaxAttempts
//                         documentation ```kotlin\npublic abstract var defaultMaxAttempts: Int\n```\n\n----\n\n The default maximum amount of attempts that will be made to perform a transaction.
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#getDefaultMaxAttempts().
//                         display_name defaultMaxAttempts
//                         documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n The default maximum amount of attempts that will be made to perform a transaction.
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#setDefaultMaxAttempts().
//                         display_name defaultMaxAttempts
//                         documentation ```kotlin\npublic set(value: Int): Unit\n```\n\n----\n\n The default maximum amount of attempts that will be made to perform a transaction.
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#setDefaultMaxAttempts().(value)
//                         display_name value
//                         documentation ```kotlin\nvalue: Int\n```\n\n----\n\n The default maximum amount of attempts that will be made to perform a transaction.
//                          ^^^ reference semanticdb maven . . kotlin/Int#

    /** The default minimum number of milliseconds to wait before retrying a transaction if an exception is thrown. */
    var defaultMinRetryDelay: Long
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#defaultMinRetryDelay.
//                           display_name defaultMinRetryDelay
//                           documentation ```kotlin\npublic abstract var defaultMinRetryDelay: Long\n```\n\n----\n\n The default minimum number of milliseconds to wait before retrying a transaction if an exception is thrown.
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#getDefaultMinRetryDelay().
//                           display_name defaultMinRetryDelay
//                           documentation ```kotlin\npublic get(): Long\n```\n\n----\n\n The default minimum number of milliseconds to wait before retrying a transaction if an exception is thrown.
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#setDefaultMinRetryDelay().
//                           display_name defaultMinRetryDelay
//                           documentation ```kotlin\npublic set(value: Long): Unit\n```\n\n----\n\n The default minimum number of milliseconds to wait before retrying a transaction if an exception is thrown.
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#setDefaultMinRetryDelay().(value)
//                           display_name value
//                           documentation ```kotlin\nvalue: Long\n```\n\n----\n\n The default minimum number of milliseconds to wait before retrying a transaction if an exception is thrown.
//                            ^^^^ reference semanticdb maven . . kotlin/Long#

    /** The default maximum number of milliseconds to wait before retrying a transaction if an exception is thrown. */
    var defaultMaxRetryDelay: Long
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#defaultMaxRetryDelay.
//                           display_name defaultMaxRetryDelay
//                           documentation ```kotlin\npublic abstract var defaultMaxRetryDelay: Long\n```\n\n----\n\n The default maximum number of milliseconds to wait before retrying a transaction if an exception is thrown.
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#getDefaultMaxRetryDelay().
//                           display_name defaultMaxRetryDelay
//                           documentation ```kotlin\npublic get(): Long\n```\n\n----\n\n The default maximum number of milliseconds to wait before retrying a transaction if an exception is thrown.
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#setDefaultMaxRetryDelay().
//                           display_name defaultMaxRetryDelay
//                           documentation ```kotlin\npublic set(value: Long): Unit\n```\n\n----\n\n The default maximum number of milliseconds to wait before retrying a transaction if an exception is thrown.
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#setDefaultMaxRetryDelay().(value)
//                           display_name value
//                           documentation ```kotlin\nvalue: Long\n```\n\n----\n\n The default maximum number of milliseconds to wait before retrying a transaction if an exception is thrown.
//                            ^^^^ reference semanticdb maven . . kotlin/Long#

    /** Returns the current [Transaction], or `null` if none exists. */
    fun currentOrNull(): Transaction?
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#currentOrNull().
//                    display_name currentOrNull
//                    documentation ```kotlin\npublic abstract fun currentOrNull(): Transaction?\n\n```\n\n----\n\n Returns the current [Transaction], or `null` if none exists.
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#currentOrNull().
//                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#

    /** Sets the current thread's copy of the manager's thread-local variable to the specified [transaction]. */
    fun bindTransactionToThread(transaction: Transaction?)
//      ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#bindTransactionToThread().
//                              display_name bindTransactionToThread
//                              documentation ```kotlin\npublic abstract fun bindTransactionToThread(transaction: Transaction?): Unit\n\n```\n\n----\n\n Sets the current thread's copy of the manager's thread-local variable to the specified [transaction].
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/NotInitializedTransactionManager#bindTransactionToThread().
//                              ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#bindTransactionToThread().(transaction)
//                                          display_name transaction
//                                          documentation ```kotlin\ntransaction: Transaction?\n```
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
}

/**
 * Represents the object responsible for storing internal data related to each registered database
 * and its transaction manager.
 */
@Suppress("ForbiddenComment")
@InternalApi
object CoreTransactionManager {
//     ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#
//                            display_name CoreTransactionManager
//                            documentation ```kotlin\n@Suppress(...) @InternalApi() public final object CoreTransactionManager : Any\n```\n\n----\n\n\n Represents the object responsible for storing internal data related to each registered database\n and its transaction manager.\n
//     ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#`<init>`().
//                            display_name CoreTransactionManager
//                            documentation ```kotlin\nprivate constructor(): CoreTransactionManager\n```\n\n----\n\n\n Represents the object responsible for storing internal data related to each registered database\n and its transaction manager.\n
    private val databases = ConcurrentLinkedDeque<DatabaseApi>()
//              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#databases.
//                        display_name databases
//                        documentation ```kotlin\nprivate final val databases: ConcurrentLinkedDeque<DatabaseApi>\n```
//              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getDatabases().
//                        display_name databases
//                        documentation ```kotlin\nprivate get(): ConcurrentLinkedDeque<DatabaseApi>\n```
//                          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentLinkedDeque#`<init>`().

    private val currentDefaultDatabase = AtomicReference<DatabaseApi>()
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentDefaultDatabase.
//                                     display_name currentDefaultDatabase
//                                     documentation ```kotlin\nprivate final val currentDefaultDatabase: AtomicReference<DatabaseApi>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getCurrentDefaultDatabase().
//                                     display_name currentDefaultDatabase
//                                     documentation ```kotlin\nprivate get(): AtomicReference<DatabaseApi>\n```
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/atomic/AtomicReference#`<init>`().

    /** Returns the database that has been set as the default for all transactions. */
    fun getDefaultDatabase(): DatabaseApi? = currentDefaultDatabase.get()
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getDefaultDatabase().
//                         display_name getDefaultDatabase
//                         documentation ```kotlin\npublic final fun getDefaultDatabase(): DatabaseApi?\n```\n\n----\n\n Returns the database that has been set as the default for all transactions.
//                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#
//                                           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentDefaultDatabase.
//                                           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getCurrentDefaultDatabase().
//                                                                  ^^^ reference semanticdb maven jdk 11 java/util/concurrent/atomic/AtomicReference#get().

    /**
     * Returns the database that has been set as the default for all transactions, or, if none was set,
     * the last instance created.
     */
    fun getDefaultDatabaseOrFirst(): DatabaseApi? = getDefaultDatabase() ?: databases.firstOrNull()
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getDefaultDatabaseOrFirst().
//                                display_name getDefaultDatabaseOrFirst
//                                documentation ```kotlin\npublic final fun getDefaultDatabaseOrFirst(): DatabaseApi?\n```\n\n----\n\n\n Returns the database that has been set as the default for all transactions, or, if none was set,\n the last instance created.\n
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#
//                                                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getDefaultDatabase().
//                                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#databases.
//                                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getDatabases().
//                                                                                    ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+18).

    /** Sets the specified database instance as the default for all transactions. */
    fun setDefaultDatabase(db: DatabaseApi?) {
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#setDefaultDatabase().
//                         display_name setDefaultDatabase
//                         documentation ```kotlin\npublic final fun setDefaultDatabase(db: DatabaseApi?): Unit\n```\n\n----\n\n Sets the specified database instance as the default for all transactions.
//                         ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#setDefaultDatabase().(db)
//                            display_name db
//                            documentation ```kotlin\ndb: DatabaseApi?\n```
//                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#
        currentDefaultDatabase.set(db)
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentDefaultDatabase.
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getCurrentDefaultDatabase().
//                             ^^^ reference semanticdb maven jdk 11 java/util/concurrent/atomic/AtomicReference#set().
//                                 ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#setDefaultDatabase().(db)
    }

    private val registeredDatabases = ConcurrentHashMap<DatabaseApi, TransactionManagerApi>()
//              ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getRegisteredDatabases().
//                                  display_name registeredDatabases
//                                  documentation ```kotlin\nprivate get(): ConcurrentHashMap<DatabaseApi, TransactionManagerApi>\n```
//              ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#registeredDatabases.
//                                  display_name registeredDatabases
//                                  documentation ```kotlin\nprivate final val registeredDatabases: ConcurrentHashMap<DatabaseApi, TransactionManagerApi>\n```
//                                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#`<init>`().

    /**
     * Returns the transaction manager instance that is associated with the provided database key,
     * or `null` if  a manager has not been registered for the database.
     */
    fun getDatabaseManager(db: DatabaseApi): TransactionManagerApi? = registeredDatabases[db]
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getDatabaseManager().
//                         display_name getDatabaseManager
//                         documentation ```kotlin\npublic final fun getDatabaseManager(db: DatabaseApi): TransactionManagerApi?\n```\n\n----\n\n\n Returns the transaction manager instance that is associated with the provided database key,\n or `null` if  a manager has not been registered for the database.\n
//                         ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getDatabaseManager().(db)
//                            display_name db
//                            documentation ```kotlin\ndb: DatabaseApi\n```
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#
//                                           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#
//                                                                    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getRegisteredDatabases().
//                                                                    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#registeredDatabases.
//                                                                    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#get().
//                                                                                        ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getDatabaseManager().(db)

    private val currentThreadManager = TransactionManagerThreadLocal()
//              ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentThreadManager.
//                                   display_name currentThreadManager
//                                   documentation ```kotlin\nprivate final val currentThreadManager: CoreTransactionManager.TransactionManagerThreadLocal\n```
//              ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getCurrentThreadManager().
//                                   display_name getCurrentThreadManager
//                                   documentation ```kotlin\npublic final fun getCurrentThreadManager(): TransactionManagerApi\n```\n\n----\n\n Returns the transaction manager instance stored in the current thread's copy of its thread-local variable.
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#`<init>`().

    /** Stores the specified database instance as a key for the provided transaction manager value. */
    fun registerDatabaseManager(db: DatabaseApi, manager: TransactionManagerApi) {
//      ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#registerDatabaseManager().
//                              display_name registerDatabaseManager
//                              documentation ```kotlin\npublic final fun registerDatabaseManager(db: DatabaseApi, manager: TransactionManagerApi): Unit\n```\n\n----\n\n Stores the specified database instance as a key for the provided transaction manager value.
//                              ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#registerDatabaseManager().(db)
//                                 display_name db
//                                 documentation ```kotlin\ndb: DatabaseApi\n```
//                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#
//                                               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#registerDatabaseManager().(manager)
//                                                       display_name manager
//                                                       documentation ```kotlin\nmanager: TransactionManagerApi\n```
//                                                        ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#
        if (getDefaultDatabaseOrFirst() == null) {
//          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getDefaultDatabaseOrFirst().
            currentThreadManager.remove()
//          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentThreadManager.
//          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getCurrentThreadManager().
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#remove().
        }
        if (!registeredDatabases.containsKey(db)) {
//          ^ reference semanticdb maven . . kotlin/Boolean#not().
//           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getRegisteredDatabases().
//           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#registeredDatabases.
//                               ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#containsKey().
//                                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#registerDatabaseManager().(db)
            databases.push(db)
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#databases.
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getDatabases().
//                    ^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentLinkedDeque#push().
//                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#registerDatabaseManager().(db)
        }

        registeredDatabases[db] = manager
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getRegisteredDatabases().
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#registeredDatabases.
//      ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#registerDatabaseManager().(db)
//                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#registerDatabaseManager().(manager)
    }

    /**
     * Clears any association between the provided database instance and its transaction manager,
     * and completely removes the database instance from the internal storage.
     */
    fun closeAndUnregisterDatabase(db: DatabaseApi) {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#closeAndUnregisterDatabase().
//                                 display_name closeAndUnregisterDatabase
//                                 documentation ```kotlin\npublic final fun closeAndUnregisterDatabase(db: DatabaseApi): Unit\n```\n\n----\n\n\n Clears any association between the provided database instance and its transaction manager,\n and completely removes the database instance from the internal storage.\n
//                                 ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#closeAndUnregisterDatabase().(db)
//                                    display_name db
//                                    documentation ```kotlin\ndb: DatabaseApi\n```
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#
        val manager = getDatabaseManager(db)
//          ^^^^^^^ definition local 0
//                  display_name manager
//                  documentation ```kotlin\nlocal val manager: TransactionManagerApi?\n```
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getDatabaseManager().
//                                       ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#closeAndUnregisterDatabase().(db)
        manager?.let {
//      ^^^^^^^ reference local 0
//               ^^^ reference semanticdb maven . . kotlin/let().
//                   ^ definition semanticdb maven . . (it) 7:9
//                     display_name it
//                     documentation ```kotlin\nit: DatabaseApi\n```
            registeredDatabases.remove(db)
//          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getRegisteredDatabases().
//          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#registeredDatabases.
//                              ^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#remove().
//                                     ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#closeAndUnregisterDatabase().(db)
            databases.remove(db)
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#databases.
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getDatabases().
//                    ^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentLinkedDeque#remove().
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#closeAndUnregisterDatabase().(db)
            currentDefaultDatabase.compareAndSet(db, null)
//          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentDefaultDatabase.
//          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getCurrentDefaultDatabase().
//                                 ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/atomic/AtomicReference#compareAndSet().
//                                               ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#closeAndUnregisterDatabase().(db)
            if (currentThreadManager.isInitialized && getCurrentThreadManager() == it) {
//              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentThreadManager.
//              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getCurrentThreadManager().
//                                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#getIsInitialized().
//                                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#isInitialized.
//                                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#setIsInitialized().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getCurrentThreadManager().
//                                                                                 ^^ reference semanticdb maven . . (it)
                currentThreadManager.remove()
//              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentThreadManager.
//              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getCurrentThreadManager().
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#remove().
            }
        }
    }

    /** Returns the transaction manager instance stored in the current thread's copy of its thread-local variable. */
    fun getCurrentThreadManager(): TransactionManagerApi = currentThreadManager.get()
//      ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getCurrentThreadManager().
//                              display_name getCurrentThreadManager
//                              documentation ```kotlin\npublic final fun getCurrentThreadManager(): TransactionManagerApi\n```\n\n----\n\n Returns the transaction manager instance stored in the current thread's copy of its thread-local variable.
//                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#
//                                                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentThreadManager.
//                                                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getCurrentThreadManager().
//                                                                              ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#get().

    /**
     * Sets the current thread's copy of its thread-local variable to the specified [manager] instance,
     * or removes the value entirely if a `null` instance is provided.
     */
    fun resetCurrentThreadManager(manager: TransactionManagerApi?) {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#resetCurrentThreadManager().
//                                display_name resetCurrentThreadManager
//                                documentation ```kotlin\npublic final fun resetCurrentThreadManager(manager: TransactionManagerApi?): Unit\n```\n\n----\n\n\n Sets the current thread's copy of its thread-local variable to the specified [manager] instance,\n or removes the value entirely if a `null` instance is provided.\n
//                                ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#resetCurrentThreadManager().(manager)
//                                        display_name manager
//                                        documentation ```kotlin\nmanager: TransactionManagerApi?\n```
//                                         ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#
        manager?.let { currentThreadManager.set(it) } ?: currentThreadManager.remove()
//      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#resetCurrentThreadManager().(manager)
//               ^^^ reference semanticdb maven . . kotlin/let().
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                    display_name it
//                                                    documentation ```kotlin\nit: DatabaseApi\n```
//                     ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentThreadManager.
//                     ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getCurrentThreadManager().
//                                          ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#set().
//                                              ^^ reference semanticdb maven . . (it)
//                                                       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentThreadManager.
//                                                       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getCurrentThreadManager().
//                                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#remove().
    }

    /**
     * Returns the current [Transaction] from the current transaction manager instance,
     * or `null` if none exists.
     */
    fun currentTransactionOrNull(): Transaction? = getCurrentThreadManager().currentOrNull()
//      ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransactionOrNull().
//                               display_name currentTransactionOrNull
//                               documentation ```kotlin\npublic final fun currentTransactionOrNull(): Transaction?\n```\n\n----\n\n\n Returns the current [Transaction] from the current transaction manager instance,\n or `null` if none exists.\n
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getCurrentThreadManager().
//                                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#currentOrNull().

    /**
     * Returns the current [Transaction] from the current transaction manager instance.
     *
     * @throws IllegalStateException If a transaction is not currently open.
     */
    fun currentTransaction(): Transaction = currentTransactionOrNull() ?: error("No transaction in context.")
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                         display_name currentTransaction
//                         documentation ```kotlin\npublic final fun currentTransaction(): Transaction\n```\n\n----\n\n\n Returns the current [Transaction] from the current transaction manager instance.\n\n @throws IllegalStateException If a transaction is not currently open.\n
//                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransactionOrNull().
//                                                                        ^^^^^ reference semanticdb maven . . kotlin/error().

    private class TransactionManagerThreadLocal : ThreadLocal<TransactionManagerApi>() {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#
//                                              display_name TransactionManagerThreadLocal
//                                              documentation ```kotlin\nprivate final class TransactionManagerThreadLocal : ThreadLocal<TransactionManagerApi>\n```
//                                              relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/ThreadLocal#
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#`<init>`().
//                                              display_name TransactionManagerThreadLocal
//                                              documentation ```kotlin\npublic constructor(): CoreTransactionManager.TransactionManagerThreadLocal\n```
//                                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/ThreadLocal#
        var isInitialized = false
//          ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#getIsInitialized().
//                        display_name isInitialized
//                        documentation ```kotlin\npublic get(): Boolean\n```
//          ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#isInitialized.
//                        display_name isInitialized
//                        documentation ```kotlin\npublic final var isInitialized: Boolean\n```
//          ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#setIsInitialized().
//                        display_name isInitialized
//                        documentation ```kotlin\npublic set(value: Boolean): Unit\n```
//          ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#setIsInitialized().(value)
//                        display_name value
//                        documentation ```kotlin\nvalue: Boolean\n```

        override fun get(): TransactionManagerApi {
//                   ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#get().
//                       display_name get
//                       documentation ```kotlin\npublic open override fun get(): TransactionManagerApi\n```
//                       relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/ThreadLocal#get().
//                          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#
            return super.get()
//                       ^^^ reference semanticdb maven jdk 11 java/lang/ThreadLocal#get().
        }

        override fun initialValue(): TransactionManagerApi {
//                   ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#initialValue().
//                                display_name initialValue
//                                documentation ```kotlin\nprotected open override fun initialValue(): TransactionManagerApi\n```
//                                relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/ThreadLocal#initialValue().
//                                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#
            isInitialized = true
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#getIsInitialized().
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#isInitialized.
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#setIsInitialized().
            return getDefaultDatabaseOrFirst()?.let { registeredDatabases.getValue(it) } ?: NotInitializedTransactionManager
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getDefaultDatabaseOrFirst().
//                                              ^^^ reference semanticdb maven . . kotlin/let().
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                       display_name it
//                                                                                       documentation ```kotlin\nit: DatabaseApi\n```
//                                                    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getRegisteredDatabases().
//                                                    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#registeredDatabases.
//                                                                        ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getValue().
//                                                                                 ^^ reference semanticdb maven . . (it)
        }

        override fun set(value: TransactionManagerApi?) {
//                   ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#set().
//                       display_name set
//                       documentation ```kotlin\npublic open override fun set(value: TransactionManagerApi?): Unit\n```
//                       relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/ThreadLocal#set().
//                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#set().(value)
//                             display_name value
//                             documentation ```kotlin\nvalue: TransactionManagerApi?\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionManagerApi#
            isInitialized = true
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#getIsInitialized().
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#isInitialized.
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#setIsInitialized().
            super.set(value)
//                ^^^ reference semanticdb maven jdk 11 java/lang/ThreadLocal#set().
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#set().(value)
        }

        override fun remove() {
//                   ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#remove().
//                          display_name remove
//                          documentation ```kotlin\npublic open override fun remove(): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/ThreadLocal#remove().
            isInitialized = false
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#getIsInitialized().
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#isInitialized.
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#TransactionManagerThreadLocal#setIsInitialized().
            super.remove()
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/ThreadLocal#remove().
        }
    }
}
