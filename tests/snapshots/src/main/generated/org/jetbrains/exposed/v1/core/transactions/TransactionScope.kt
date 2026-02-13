  package org.jetbrains.exposed.v1.core.transactions
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
  
  import org.jetbrains.exposed.v1.core.InternalApi
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/InternalApi#
  import org.jetbrains.exposed.v1.core.Key
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Key#
  import org.jetbrains.exposed.v1.core.Transaction
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
  import kotlin.properties.ReadWriteProperty
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^^^^^^^ reference semanticdb maven . . kotlin/properties/
//                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/properties/ReadWriteProperty#
  import kotlin.reflect.KProperty
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^^^^ reference semanticdb maven . . kotlin/reflect/
//                      ^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KProperty#
  
  /**
   * Returns the result of reading/writing transaction data stored within the scope of the current transaction.
   *
   * If no data is found, the specified [init] block is called with the current transaction as its receiver and
   * the result is returned.
   */
  @Suppress("UNCHECKED_CAST")
  fun <T : Any> transactionScope(init: Transaction.() -> T) = TransactionStore(init) as ReadWriteProperty<Any?, T>
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/transactionScope().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : Any\n```
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/transactionScope().
//                               display_name transactionScope
//                               documentation ```kotlin\n@Suppress(...) public final fun <T : Any> transactionScope(init: Transaction.() -> T): ReadWriteProperty<Any?, T>\n```\n\n----\n\n\n Returns the result of reading/writing transaction data stored within the scope of the current transaction.\n\n If no data is found, the specified [init] block is called with the current transaction as its receiver and\n the result is returned.\n
//                               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/transactionScope().(init)
//                                    display_name init
//                                    documentation ```kotlin\ninit: Transaction.() -> T\n```
//                                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#`<init>`().
//                                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/transactionScope().(init)
  
  /**
   * Returns the result of reading/writing transaction data stored within the scope of the current transaction,
   * or `null` if no data is found.
   */
  fun <T : Any> nullableTransactionScope() = TransactionStore<T>()
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/nullableTransactionScope().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : Any\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/nullableTransactionScope().
//                                       display_name nullableTransactionScope
//                                       documentation ```kotlin\npublic final fun <T : Any> nullableTransactionScope(): TransactionStore<T>\n```\n\n----\n\n\n Returns the result of reading/writing transaction data stored within the scope of the current transaction,\n or `null` if no data is found.\n
//                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#`<init>`().
  
  /**
   * Class responsible for implementing property delegates of read-write properties in
   * the current transaction's `UserDataHolder`.
   */
  class TransactionStore<T : Any>(val init: (Transaction.() -> T)? = null) : ReadWriteProperty<Any?, T?> {
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#
//                       display_name TransactionStore
//                       documentation ```kotlin\npublic final class TransactionStore<T : Any> : ReadWriteProperty<Any?, T?>\n```\n\n----\n\n\n Class responsible for implementing property delegates of read-write properties in\n the current transaction's `UserDataHolder`.\n
//                       relationship is_reference is_implementation semanticdb maven . . kotlin/properties/ReadWriteProperty#
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#`<init>`().
//                       display_name TransactionStore
//                       documentation ```kotlin\npublic constructor<T : Any>(init: (Transaction.() -> T)? = ...): TransactionStore<T>\n```
//                       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#[T]
//                         display_name FirTypeParameterSymbol T
//                         documentation ```kotlin\nT : Any\n```
//                                    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#`<init>`().(init)
//                                         display_name init
//                                         documentation ```kotlin\ninit: (Transaction.() -> T)? = ...\n```
//                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#`<init>`().(init)
//                                    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#getInit().
//                                         display_name init
//                                         documentation ```kotlin\npublic get(): (Transaction.() -> T)?\n```
//                                    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#init.
//                                         display_name init
//                                         documentation ```kotlin\npublic final val init: (Transaction.() -> T)?\n```
//                                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/properties/ReadWriteProperty#
  
      private val key = Key<T>()
//                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#getKey().
//                    display_name key
//                    documentation ```kotlin\nprivate get(): Key<T>\n```
//                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#key.
//                    display_name key
//                    documentation ```kotlin\nprivate final val key: Key<T>\n```
//                      ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Key#`<init>`().
  
      override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#getValue().
//                          display_name getValue
//                          documentation ```kotlin\npublic open override operator fun getValue(thisRef: Any?, property: KProperty<*>): T?\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/properties/ReadWriteProperty#getValue().
//                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#getValue().(thisRef)
//                                  display_name thisRef
//                                  documentation ```kotlin\nthisRef: Any?\n```
//                                   ^^^^ reference semanticdb maven . . kotlin/Any#
//                                         ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#getValue().(property)
//                                                  display_name property
//                                                  documentation ```kotlin\nproperty: KProperty<*>\n```
//                                                   ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KProperty#
          @OptIn(InternalApi::class)
          val currentOrNullTransaction = CoreTransactionManager.currentTransactionOrNull()
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 0
//                                     display_name currentOrNullTransaction
//                                     documentation ```kotlin\n@OptIn(...) local val currentOrNullTransaction: Transaction?\n```
//                                                              ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransactionOrNull().
          return currentOrNullTransaction?.getUserData(key)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference local 0
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#getUserData().
//                                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#getKey().
//                                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#key.
              ?: init?.let {
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#getInit().
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#init.
//                     ^^^ reference semanticdb maven . . kotlin/let().
//                         ^ definition semanticdb maven . . (it) 4:13
//                           display_name it
//                           documentation ```kotlin\nit: Transaction\n```
                  val value = currentOrNullTransaction?.it() ?: error("Can't init value outside the transaction")
//                    ^^^^^ definition local 1
//                          display_name value
//                          documentation ```kotlin\nlocal val value: T\n```
//                            ^^^^^^^^^^^^^^^^^^^^^^^^ reference local 0
//                                                      ^^ reference semanticdb maven . . (it)
//                                                      ^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                              ^^^^^ reference semanticdb maven . . kotlin/error().
                  currentOrNullTransaction.putUserData(key, value)
//                ^^^^^^^^^^^^^^^^^^^^^^^^ reference local 0
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#putUserData().
//                                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#getKey().
//                                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#key.
//                                                          ^^^^^ reference local 1
                  value
//                ^^^^^ reference local 1
              }
      }
  
      override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#setValue().
//                          display_name setValue
//                          documentation ```kotlin\npublic open override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T?): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/properties/ReadWriteProperty#setValue().
//                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#setValue().(thisRef)
//                                  display_name thisRef
//                                  documentation ```kotlin\nthisRef: Any?\n```
//                                   ^^^^ reference semanticdb maven . . kotlin/Any#
//                                         ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#setValue().(property)
//                                                  display_name property
//                                                  documentation ```kotlin\nproperty: KProperty<*>\n```
//                                                   ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KProperty#
//                                                                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#setValue().(value)
//                                                                       display_name value
//                                                                       documentation ```kotlin\nvalue: T?\n```
          @OptIn(InternalApi::class)
          CoreTransactionManager.currentTransactionOrNull()?.let {
//                               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransactionOrNull().
//                                                           ^^^ reference semanticdb maven . . kotlin/let().
//                                                               ^ definition semanticdb maven . . (it) 6:9
//                                                                 display_name it
//                                                                 documentation ```kotlin\nit: Transaction\n```
              if (value == null) {
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#setValue().(value)
                  it.removeUserData(key)
//                ^^ reference semanticdb maven . . (it)
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#removeUserData().
//                                  ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#getKey().
//                                  ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#key.
              } else {
                  it.putUserData(key, value)
//                ^^ reference semanticdb maven . . (it)
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UserDataHolder#putUserData().
//                               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#getKey().
//                               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#key.
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionStore#setValue().(value)
              }
          }
      }
  }
