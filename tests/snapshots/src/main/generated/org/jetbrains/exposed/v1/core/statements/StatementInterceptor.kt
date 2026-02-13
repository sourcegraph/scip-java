  package org.jetbrains.exposed.v1.core.statements
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
  
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
  import org.jetbrains.exposed.v1.core.statements.api.PreparedStatementApi
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/
//                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
  
  /**
   * Represents the processes that should be performed during a statement's lifecycle events in a transaction.
   *
   * In general, statement execution flow works in the following way:
   * 1) [beforeExecution] of the statement
   * 2) Creation of the prepared statement
   * 3) [afterStatementPrepared] using the prepared statement from step 2
   * 4) Execution of the SQL query
   * 5) [afterExecution]
   */
  interface StatementInterceptor {
//          ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#
//                               display_name StatementInterceptor
//                               documentation ```kotlin\npublic abstract interface StatementInterceptor : Any\n```\n\n----\n\n\n Represents the processes that should be performed during a statement's lifecycle events in a transaction.\n\n In general, statement execution flow works in the following way:\n 1) [beforeExecution] of the statement\n 2) Creation of the prepared statement\n 3) [afterStatementPrepared] using the prepared statement from step 2\n 4) Execution of the SQL query\n 5) [afterExecution]\n
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/GlobalStatementInterceptor#
      /** Performs steps before a statement, from the provided [context], is executed in a [transaction]. */
      fun beforeExecution(transaction: Transaction, context: StatementContext) {}
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#beforeExecution().
//                        display_name beforeExecution
//                        documentation ```kotlin\npublic open fun beforeExecution(transaction: Transaction, context: StatementContext): Unit\n```\n\n----\n\n Performs steps before a statement, from the provided [context], is executed in a [transaction].
//                        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#beforeExecution().(transaction)
//                                    display_name transaction
//                                    documentation ```kotlin\ntransaction: Transaction\n```
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#beforeExecution().(context)
//                                                          display_name context
//                                                          documentation ```kotlin\ncontext: StatementContext\n```
//                                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#
  
      /**
       * Performs steps after [preparedStatement] has been created in a [transaction], but before the statement
       * has been executed.
       **/
      fun afterStatementPrepared(transaction: Transaction, preparedStatement: PreparedStatementApi) {}
//        ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#afterStatementPrepared().
//                               display_name afterStatementPrepared
//                               documentation ```kotlin\npublic open fun afterStatementPrepared(transaction: Transaction, preparedStatement: PreparedStatementApi): Unit\n```\n\n----\n\n\n Performs steps after [preparedStatement] has been created in a [transaction], but before the statement\n has been executed.\n
//                               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#afterStatementPrepared().(transaction)
//                                           display_name transaction
//                                           documentation ```kotlin\ntransaction: Transaction\n```
//                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                         ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#afterStatementPrepared().(preparedStatement)
//                                                                           display_name preparedStatement
//                                                                           documentation ```kotlin\npreparedStatement: PreparedStatementApi\n```
//                                                                            ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
  
      /** Performs steps after an [executedStatement], from the provided [contexts], is complete in [transaction]. */
      fun afterExecution(transaction: Transaction, contexts: List<StatementContext>, executedStatement: PreparedStatementApi) {}
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#afterExecution().
//                       display_name afterExecution
//                       documentation ```kotlin\npublic open fun afterExecution(transaction: Transaction, contexts: List<StatementContext>, executedStatement: PreparedStatementApi): Unit\n```\n\n----\n\n Performs steps after an [executedStatement], from the provided [contexts], is complete in [transaction].
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#afterExecution().
//                       ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#afterExecution().(transaction)
//                                   display_name transaction
//                                   documentation ```kotlin\ntransaction: Transaction\n```
//                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#afterExecution().(contexts)
//                                                          display_name contexts
//                                                          documentation ```kotlin\ncontexts: List<StatementContext>\n```
//                                                           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                                   ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#afterExecution().(executedStatement)
//                                                                                                     display_name executedStatement
//                                                                                                     documentation ```kotlin\nexecutedStatement: PreparedStatementApi\n```
//                                                                                                      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
  
      /** Performs steps before a [transaction] is committed. */
      fun beforeCommit(transaction: Transaction) {}
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#beforeCommit().
//                     display_name beforeCommit
//                     documentation ```kotlin\npublic open fun beforeCommit(transaction: Transaction): Unit\n```\n\n----\n\n Performs steps before a [transaction] is committed.
//                     ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#beforeCommit().(transaction)
//                                 display_name transaction
//                                 documentation ```kotlin\ntransaction: Transaction\n```
//                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
  
      /** Performs steps after a [transaction] is committed. */
      fun afterCommit(transaction: Transaction) {}
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#afterCommit().
//                    display_name afterCommit
//                    documentation ```kotlin\npublic open fun afterCommit(transaction: Transaction): Unit\n```\n\n----\n\n Performs steps after a [transaction] is committed.
//                    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#afterCommit().(transaction)
//                                display_name transaction
//                                documentation ```kotlin\ntransaction: Transaction\n```
//                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
  
      /** Performs steps before a rollback operation is issued on a [transaction]. */
      fun beforeRollback(transaction: Transaction) {}
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#beforeRollback().
//                       display_name beforeRollback
//                       documentation ```kotlin\npublic open fun beforeRollback(transaction: Transaction): Unit\n```\n\n----\n\n Performs steps before a rollback operation is issued on a [transaction].
//                       ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#beforeRollback().(transaction)
//                                   display_name transaction
//                                   documentation ```kotlin\ntransaction: Transaction\n```
//                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
  
      /** Performs steps after a rollback operation is issued on a [transaction]. */
      fun afterRollback(transaction: Transaction) {}
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#afterRollback().
//                      display_name afterRollback
//                      documentation ```kotlin\npublic open fun afterRollback(transaction: Transaction): Unit\n```\n\n----\n\n Performs steps after a rollback operation is issued on a [transaction].
//                      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#afterRollback().(transaction)
//                                  display_name transaction
//                                  documentation ```kotlin\ntransaction: Transaction\n```
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
  
      /**
       * Returns a mapping of [userData] that ensures required information is not lost from the transaction scope
       * once the transaction is committed.
       */
      fun keepUserDataInTransactionStoreOnCommit(userData: Map<Key<*>, Any?>): Map<Key<*>, Any?> = emptyMap()
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#keepUserDataInTransactionStoreOnCommit().
//                                               display_name keepUserDataInTransactionStoreOnCommit
//                                               documentation ```kotlin\npublic open fun keepUserDataInTransactionStoreOnCommit(userData: Map<Key<*>, Any?>): Map<Key<*>, Any?>\n```\n\n----\n\n\n Returns a mapping of [userData] that ensures required information is not lost from the transaction scope\n once the transaction is committed.\n
//                                               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#keepUserDataInTransactionStoreOnCommit().(userData)
//                                                        display_name userData
//                                                        documentation ```kotlin\nuserData: Map<Key<*>, Any?>\n```
//                                                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                                                                 ^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyMap().
  }
  
  /** Represents a [StatementInterceptor] that is loaded whenever a [Transaction] instance is initialized. */
  interface GlobalStatementInterceptor : StatementInterceptor
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/GlobalStatementInterceptor#
//                                     display_name GlobalStatementInterceptor
//                                     documentation ```kotlin\npublic abstract interface GlobalStatementInterceptor : StatementInterceptor\n```\n\n----\n\n Represents a [StatementInterceptor] that is loaded whenever a [Transaction] instance is initialized.
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#
//                                       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#
