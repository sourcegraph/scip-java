  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  import org.jetbrains.exposed.v1.core.statements.StatementContext
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#
  import org.jetbrains.exposed.v1.core.statements.StatementInterceptor
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#
  import org.jetbrains.exposed.v1.core.statements.api.PreparedStatementApi
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/
//                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
  import org.jetbrains.exposed.v1.core.statements.expandArgs
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/expandArgs().
  import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#
  import org.slf4j.LoggerFactory
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^ reference semanticdb maven . . org/slf4j/
//                 ^^^^^^^^^^^^^ reference semanticdb maven . . org/slf4j/LoggerFactory#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#
  /** Base class representing a provider of log messages. */
  interface SqlLogger {
//          ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#
//                    display_name SqlLogger
//                    documentation ```kotlin\npublic abstract interface SqlLogger : Any\n```\n\n----\n\n Base class representing a provider of log messages.
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#log().
      /** Determines how a log message is routed. */
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#log().(context)
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#log().(transaction)
      fun log(context: StatementContext, transaction: Transaction)
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#log().
//            display_name log
//            documentation ```kotlin\npublic abstract fun log(context: StatementContext, transaction: Transaction): Unit\n\n```\n\n----\n\n Determines how a log message is routed.
//            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#log().
//            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#log().
//            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#log().
//            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#log().(context)
//                    display_name context
//                    documentation ```kotlin\ncontext: StatementContext\n```
//                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#
//                                       ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#log().(transaction)
//                                                   display_name transaction
//                                                   documentation ```kotlin\ntransaction: Transaction\n```
//                                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#log().(context)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#log().(transaction)
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#log().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
  /** Returns a [org.slf4j.Logger] named specifically for Exposed log messages.  */
  val exposedLogger = LoggerFactory.getLogger("Exposed")!!
//    ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                  display_name exposedLogger
//                  documentation ```kotlin\npublic final val exposedLogger: Logger\n```\n\n----\n\n Returns a [org.slf4j.Logger] named specifically for Exposed log messages.
//    ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                  display_name exposedLogger
//                  documentation ```kotlin\npublic get(): Logger\n```\n\n----\n\n Returns a [org.slf4j.Logger] named specifically for Exposed log messages.
//                                  ^^^^^^^^^ reference semanticdb maven . . org/slf4j/LoggerFactory#getLogger().
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#`<init>`().
  /** Class representing a provider of log messages sent to standard output stream. */
  object StdOutSqlLogger : SqlLogger {
//       ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#
//                       display_name StdOutSqlLogger
//                       documentation ```kotlin\npublic final object StdOutSqlLogger : SqlLogger\n```\n\n----\n\n Class representing a provider of log messages sent to standard output stream.
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#
//       ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#`<init>`().
//                       display_name StdOutSqlLogger
//                       documentation ```kotlin\nprivate constructor(): StdOutSqlLogger\n```\n\n----\n\n Class representing a provider of log messages sent to standard output stream.
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#log().
      /** Prints a log message containing the string representation of a complete SQL statement. */
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#log().(context)
//                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#log().(transaction)
      override fun log(context: StatementContext, transaction: Transaction) {
//                 ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#log().
//                     display_name log
//                     documentation ```kotlin\npublic open override fun log(context: StatementContext, transaction: Transaction): Unit\n```\n\n----\n\n Prints a log message containing the string representation of a complete SQL statement.
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#log().
//                     ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#log().(context)
//                             display_name context
//                             documentation ```kotlin\ncontext: StatementContext\n```
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#
//                                                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#log().(transaction)
//                                                            display_name transaction
//                                                            documentation ```kotlin\ntransaction: Transaction\n```
//                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#log().(context)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#log().(transaction)
          println("SQL: ${context.expandArgs(transaction)}")
//        ^^^^^^^ reference semanticdb maven . . kotlin/io/println().
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#log().(context)
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/expandArgs().
//                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#log().(transaction)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#log().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdOutSqlLogger#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#`<init>`().
  /** Class representing a provider of log messages at DEBUG level. */
  object Slf4jSqlDebugLogger : SqlLogger {
//       ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#
//                           display_name Slf4jSqlDebugLogger
//                           documentation ```kotlin\npublic final object Slf4jSqlDebugLogger : SqlLogger\n```\n\n----\n\n Class representing a provider of log messages at DEBUG level.
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#
//       ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#`<init>`().
//                           display_name Slf4jSqlDebugLogger
//                           documentation ```kotlin\nprivate constructor(): Slf4jSqlDebugLogger\n```\n\n----\n\n Class representing a provider of log messages at DEBUG level.
//                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#log().
      /**
       * Logs a message containing the string representation of a complete SQL statement.
       *
       * **Note:** This is only logged if DEBUG level is currently enabled.
       */
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#log().(context)
//                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#log().(transaction)
      override fun log(context: StatementContext, transaction: Transaction) {
//                 ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#log().
//                     display_name log
//                     documentation ```kotlin\npublic open override fun log(context: StatementContext, transaction: Transaction): Unit\n```\n\n----\n\n\n Logs a message containing the string representation of a complete SQL statement.\n\n **Note:** This is only logged if DEBUG level is currently enabled.\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#log().
//                     ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#log().(context)
//                             display_name context
//                             documentation ```kotlin\ncontext: StatementContext\n```
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#
//                                                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#log().(transaction)
//                                                            display_name transaction
//                                                            documentation ```kotlin\ntransaction: Transaction\n```
//                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#log().(context)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#log().(transaction)
          @OptIn(InternalApi::class)
          if (exposedLogger.isDebugEnabled) {
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/slf4j/Logger#getIsDebugEnabled().
//                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/slf4j/Logger#isDebugEnabled.
              exposedLogger.debug(context.expandArgs(CoreTransactionManager.currentTransaction()))
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^^ reference semanticdb maven . . org/slf4j/Logger#debug().
//                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#log().(context)
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/expandArgs().
//                                                                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#log().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Slf4jSqlDebugLogger#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#`<init>`().
  /** Class representing one or more [SqlLogger]s. */
  class CompositeSqlLogger : SqlLogger, StatementInterceptor {
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#
//                         display_name CompositeSqlLogger
//                         documentation ```kotlin\npublic final class CompositeSqlLogger : SqlLogger, StatementInterceptor\n```\n\n----\n\n Class representing one or more [SqlLogger]s.
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#`<init>`().
//                         display_name CompositeSqlLogger
//                         documentation ```kotlin\npublic constructor(): CompositeSqlLogger\n```\n\n----\n\n Class representing one or more [SqlLogger]s.
//                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#
//                                      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#loggers.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#getLoggers().
      private val loggers: ArrayList<SqlLogger> = ArrayList(2)
//                ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#getLoggers().
//                        display_name loggers
//                        documentation ```kotlin\nprivate get(): {kotlin/collections/ArrayList<org/jetbrains/exposed/v1/core/SqlLogger>=} ArrayList<SqlLogger>\n```
//                ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#loggers.
//                        display_name loggers
//                        documentation ```kotlin\nprivate final val loggers: {kotlin/collections/ArrayList<org/jetbrains/exposed/v1/core/SqlLogger>=} ArrayList<SqlLogger>\n```
//                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
//                                                ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`().
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#loggers.
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#getLoggers().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#addLogger().
      /** Adds an [SqlLogger] instance. */
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#addLogger().(logger)
      fun addLogger(logger: SqlLogger) {
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#addLogger().
//                  display_name addLogger
//                  documentation ```kotlin\npublic final fun addLogger(logger: SqlLogger): Unit\n```\n\n----\n\n Adds an [SqlLogger] instance.
//                  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#addLogger().(logger)
//                         display_name logger
//                         documentation ```kotlin\nlogger: SqlLogger\n```
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#addLogger().(logger)
          loggers.add(logger)
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#getLoggers().
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#loggers.
//                ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add().
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#addLogger().(logger)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#addLogger().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#removeLogger().
      /** Removes an [SqlLogger] instance. */
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#removeLogger().(logger)
      fun removeLogger(logger: SqlLogger) {
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#removeLogger().
//                     display_name removeLogger
//                     documentation ```kotlin\npublic final fun removeLogger(logger: SqlLogger): Unit\n```\n\n----\n\n Removes an [SqlLogger] instance.
//                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#removeLogger().(logger)
//                            display_name logger
//                            documentation ```kotlin\nlogger: SqlLogger\n```
//                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#removeLogger().(logger)
          loggers.remove(logger)
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#getLoggers().
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#loggers.
//                ^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#remove().
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#removeLogger().(logger)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#removeLogger().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#log().
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#log().(context)
//                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#log().(transaction)
      override fun log(context: StatementContext, transaction: Transaction) {
//                 ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#log().
//                     display_name log
//                     documentation ```kotlin\npublic open override fun log(context: StatementContext, transaction: Transaction): Unit\n```
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#log().
//                     ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#log().(context)
//                             display_name context
//                             documentation ```kotlin\ncontext: StatementContext\n```
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#
//                                                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#log().(transaction)
//                                                            display_name transaction
//                                                            documentation ```kotlin\ntransaction: Transaction\n```
//                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#log().(context)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#log().(transaction)
//             ⌄ enclosing_range_start local 1
//                       ⌄ enclosing_range_start local 0
          for (logger in loggers) {
//             ^^^^^^ definition local 1
//                    display_name logger
//                    documentation ```kotlin\nlocal val logger: SqlLogger\n```
//                       ^^^^^^^ definition local 0
//                               display_name <iterator>
//                               documentation ```kotlin\nlocal val <iterator>: MutableIterator<@EnhancedNullability SqlLogger>\n```
//                       ^^^^^^^ reference local 0
//                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableIterator#hasNext().
//                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableIterator#next().
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#getLoggers().
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#loggers.
//                       ^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#iterator().
//                  ⌃ enclosing_range_end local 1
//                             ⌃ enclosing_range_end local 0
              logger.log(context, transaction)
//            ^^^^^^ reference local 1
//                   ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#log().
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#log().(context)
//                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#log().(transaction)
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#log().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#afterExecution().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#afterExecution().(transaction)
//                                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#afterExecution().(contexts)
//                                                                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#afterExecution().(executedStatement)
      override fun afterExecution(transaction: Transaction, contexts: List<StatementContext>, executedStatement: PreparedStatementApi) {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#afterExecution().
//                                display_name afterExecution
//                                documentation ```kotlin\npublic open override fun afterExecution(transaction: Transaction, contexts: List<StatementContext>, executedStatement: PreparedStatementApi): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementInterceptor#afterExecution().
//                                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#afterExecution().(transaction)
//                                            display_name transaction
//                                            documentation ```kotlin\ntransaction: Transaction\n```
//                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#afterExecution().(contexts)
//                                                                   display_name contexts
//                                                                   documentation ```kotlin\ncontexts: List<StatementContext>\n```
//                                                                    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                                            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#afterExecution().(executedStatement)
//                                                                                                              display_name executedStatement
//                                                                                                              documentation ```kotlin\nexecutedStatement: PreparedStatementApi\n```
//                                                                                                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#afterExecution().(transaction)
//                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#afterExecution().(contexts)
//                                                                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#afterExecution().(executedStatement)
//                         ⌄ enclosing_range_start local 2
          contexts.forEach {
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#afterExecution().(contexts)
//                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                         ^ definition local 2 2:9
//                           display_name it
//                           documentation ```kotlin\nit: StatementContext\n```
              log(it, transaction)
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#log().
//                ^^ reference local 2
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#afterExecution().(transaction)
          }
//        ⌃ enclosing_range_end local 2
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#afterExecution().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeSqlLogger#`<init>`().
