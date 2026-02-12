  package org.jetbrains.exposed.v1.core.transactions
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
  
  import org.jetbrains.exposed.v1.core.DatabaseApi
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#
  import org.jetbrains.exposed.v1.core.Transaction
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
  
  /** Base representation for a unit block of work that is performed on a database. */
  interface TransactionInterface {
//          ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#
//                               display_name TransactionInterface
//                               documentation ```kotlin\npublic abstract interface TransactionInterface : Any\n```\n\n----\n\n Base representation for a unit block of work that is performed on a database.
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
      /** The database on which the transaction tasks are performed. */
      val db: DatabaseApi
//        ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//           display_name db
//           documentation ```kotlin\npublic abstract val db: DatabaseApi\n```\n\n----\n\n The database on which the transaction tasks are performed.
//        ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//           display_name db
//           documentation ```kotlin\npublic get(): DatabaseApi\n```\n\n----\n\n The database on which the transaction tasks are performed.
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#
  
      /** Whether the transaction is in read-only mode. */
      val readOnly: Boolean
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getReadOnly().
//                 display_name readOnly
//                 documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether the transaction is in read-only mode.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#readOnly.
//                 display_name readOnly
//                 documentation ```kotlin\npublic abstract val readOnly: Boolean\n```\n\n----\n\n Whether the transaction is in read-only mode.
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      /** The parent transaction of a nested transaction; otherwise, `null` if the transaction is a top-level instance. */
      val outerTransaction: Transaction?
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getOuterTransaction().
//                         display_name outerTransaction
//                         documentation ```kotlin\npublic get(): Transaction?\n```\n\n----\n\n The parent transaction of a nested transaction; otherwise, `null` if the transaction is a top-level instance.
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#outerTransaction.
//                         display_name outerTransaction
//                         documentation ```kotlin\npublic abstract val outerTransaction: Transaction?\n```\n\n----\n\n The parent transaction of a nested transaction; otherwise, `null` if the transaction is a top-level instance.
//                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
  }
