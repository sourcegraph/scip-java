  @file:Suppress("PackageDirectoryMismatch", "InvalidPackageDeclaration")
  
  package org.jetbrains.exposed.v1.exceptions
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/
  
  import org.jetbrains.exposed.v1.core.AbstractQuery
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
  import org.jetbrains.exposed.v1.core.QueryBuilder
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
  import org.jetbrains.exposed.v1.core.Transaction
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
  import org.jetbrains.exposed.v1.core.statements.StatementContext
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#
  import org.jetbrains.exposed.v1.core.statements.expandArgs
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/expandArgs().
  import org.jetbrains.exposed.v1.core.vendors.DatabaseDialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
  import java.sql.SQLException
//       ^^^^ reference semanticdb maven . . java/
//            ^^^ reference semanticdb maven . . java/sql/
//                ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/sql/SQLException#
  
  // TODO Discuss keeping this in core (not used here) & package mismatch
  // Consider changing package if moving to jdbc module
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#
  /**
   * An exception that provides information about a database access error,
   * within the [contexts] of the executed statements that caused the exception.
   */
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().
  class ExposedSQLException(
//      ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#
//                          display_name ExposedSQLException
//                          documentation ```kotlin\npublic final class ExposedSQLException : SQLException\n```\n\n----\n\n\n An exception that provides information about a database access error,\n within the [contexts] of the executed statements that caused the exception.\n
//                          relationship is_reference is_implementation semanticdb maven jdk 11 java/sql/SQLException#
//      ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().
//                          display_name ExposedSQLException
//                          documentation ```kotlin\npublic constructor(cause: Throwable?, contexts: List<StatementContext>, transaction: Transaction): ExposedSQLException\n```
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().(cause)
      cause: Throwable?,
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().(cause)
//          display_name cause
//          documentation ```kotlin\ncause: Throwable?\n```
//           ^^^^^^^^^^ reference semanticdb maven . . kotlin/Throwable#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().(cause)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().(contexts)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#contexts.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getContexts().
      val contexts: List<StatementContext>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().(contexts)
//                 display_name contexts
//                 documentation ```kotlin\ncontexts: List<StatementContext>\n```
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().(contexts)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#contexts.
//                 display_name contexts
//                 documentation ```kotlin\npublic final val contexts: List<StatementContext>\n```
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getContexts().
//                 display_name contexts
//                 documentation ```kotlin\npublic get(): List<StatementContext>\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().(contexts)
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#contexts.
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getContexts().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().(transaction)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#transaction.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getTransaction().
      private val transaction: Transaction
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().(transaction)
//                            display_name transaction
//                            documentation ```kotlin\ntransaction: Transaction\n```
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().(transaction)
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getTransaction().
//                            display_name transaction
//                            documentation ```kotlin\nprivate get(): Transaction\n```
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#transaction.
//                            display_name transaction
//                            documentation ```kotlin\nprivate final val transaction: Transaction\n```
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().(transaction)
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#transaction.
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getTransaction().
  ) : SQLException(cause) {
//    ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/sql/SQLException#
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().(cause)
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#causedByQueries().
//                                                       ⌄ enclosing_range_start local 0
      fun causedByQueries(): List<String> = contexts.map {
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#causedByQueries().
//                        display_name causedByQueries
//                        documentation ```kotlin\npublic final fun causedByQueries(): List<String>\n```
//                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#contexts.
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getContexts().
//                                                   ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                       ^ definition local 0 14:5
//                                                         display_name it
//                                                         documentation ```kotlin\nit: StatementContext\n```
          try {
              if (transaction.debug) {
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getTransaction().
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#transaction.
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#debug.
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#getDebug().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#setDebug().
                  it.expandArgs(transaction)
//                ^^ reference local 0
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/expandArgs().
//                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getTransaction().
//                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#transaction.
              } else {
                  it.sql(transaction)
//                ^^ reference local 0
//                   ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#sql().
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getTransaction().
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#transaction.
              }
//                 ⌄ enclosing_range_start local 1
          } catch (_: Throwable) {
//                 ^ definition local 1
//                   display_name <unused var>
//                   documentation ```kotlin\n<unused var>: Throwable\n```
//                    ^^^^^^^^^ reference semanticdb maven . . kotlin/Throwable#
//                            ⌃ enclosing_range_end local 1
              try {
                  (it.statement as? AbstractQuery<*>)?.prepareSQL(QueryBuilder(!transaction.debug))
//                 ^^ reference local 0
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#getStatement().
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#statement.
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().
//                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                                                                             ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getTransaction().
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#transaction.
//                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#debug.
//                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#getDebug().
//                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#setDebug().
//                     ⌄ enclosing_range_start local 2
              } catch (_: Throwable) {
//                     ^ definition local 2
//                       display_name <unused var>
//                       documentation ```kotlin\n<unused var>: Throwable\n```
//                        ^^^^^^^^^ reference semanticdb maven . . kotlin/Throwable#
//                                ⌃ enclosing_range_end local 2
                  null
              } ?: "Failed on expanding args for ${it.statement.type}: ${it.statement}"
//                                                 ^^ reference local 0
//                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#getStatement().
//                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#statement.
//                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#getType().
//                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#type.
//                                                                       ^^ reference local 0
//                                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#getStatement().
//                                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#statement.
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#causedByQueries().
//    ⌃ enclosing_range_end local 0
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#originalSQLException.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getOriginalSQLException().
      private val originalSQLException = cause as? SQLException
//                ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getOriginalSQLException().
//                                     display_name originalSQLException
//                                     documentation ```kotlin\nprivate get(): SQLException?\n```
//                ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#originalSQLException.
//                                     display_name originalSQLException
//                                     documentation ```kotlin\nprivate final val originalSQLException: SQLException?\n```
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#`<init>`().(cause)
//                                                 ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/sql/SQLException#
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#originalSQLException.
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getOriginalSQLException().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getSQLState().
      override fun getSQLState(): String = originalSQLException?.sqlState.orEmpty()
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getSQLState().
//                             display_name getSQLState
//                             documentation ```kotlin\npublic open override fun getSQLState(): String\n```
//                             relationship is_reference is_implementation semanticdb maven jdk 11 java/sql/SQLException#getSQLState().
//                                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getOriginalSQLException().
//                                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#originalSQLException.
//                                                               ^^^^^^^^ reference semanticdb maven jdk 11 java/sql/SQLException#getSqlState().
//                                                               ^^^^^^^^ reference semanticdb maven jdk 11 java/sql/SQLException#sqlState.
//                                                                        ^^^^^^^ reference semanticdb maven . . kotlin/text/orEmpty().
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getSQLState().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getErrorCode().
      override fun getErrorCode(): Int = originalSQLException?.errorCode ?: 0
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getErrorCode().
//                              display_name getErrorCode
//                              documentation ```kotlin\npublic open override fun getErrorCode(): Int\n```
//                              relationship is_reference is_implementation semanticdb maven jdk 11 java/sql/SQLException#getErrorCode().
//                                 ^^^ reference semanticdb maven . . kotlin/Int#
//                                       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getOriginalSQLException().
//                                       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#originalSQLException.
//                                                             ^^^^^^^^^ reference semanticdb maven jdk 11 java/sql/SQLException#errorCode.
//                                                             ^^^^^^^^^ reference semanticdb maven jdk 11 java/sql/SQLException#getErrorCode().
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#getErrorCode().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#toString().
      override fun toString() = "${super.toString()}\nSQL: ${causedByQueries()}"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#toString().
//                          display_name toString
//                          documentation ```kotlin\npublic open override fun toString(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                                       ^^^^^^^^ reference semanticdb maven . . kotlin/Any#toString().
//                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#causedByQueries().
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#toString().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/ExposedSQLException#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#
  /**
   * An exception that provides information about an operation that is not supported by
   * the provided [dialect].
   */
//                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
//                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().(baseMessage)
//                                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().(dialect)
//                                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#dialect.
//                                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#getDialect().
  class UnsupportedByDialectException(baseMessage: String, val dialect: DatabaseDialect) : UnsupportedOperationException(
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#
//                                    display_name UnsupportedByDialectException
//                                    documentation ```kotlin\npublic final class UnsupportedByDialectException : {kotlin/UnsupportedOperationException=} UnsupportedOperationException\n```\n\n----\n\n\n An exception that provides information about an operation that is not supported by\n the provided [dialect].\n
//                                    relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/UnsupportedOperationException#
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
//                                    display_name UnsupportedByDialectException
//                                    documentation ```kotlin\npublic constructor(baseMessage: String, dialect: DatabaseDialect): UnsupportedByDialectException\n```
//                                    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().(baseMessage)
//                                                display_name baseMessage
//                                                documentation ```kotlin\nbaseMessage: String\n```
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().(dialect)
//                                                                     display_name dialect
//                                                                     documentation ```kotlin\ndialect: DatabaseDialect\n```
//                                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().(dialect)
//                                                             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#dialect.
//                                                                     display_name dialect
//                                                                     documentation ```kotlin\npublic final val dialect: DatabaseDialect\n```
//                                                             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#getDialect().
//                                                                     display_name dialect
//                                                                     documentation ```kotlin\npublic get(): DatabaseDialect\n```
//                                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
//                                                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/UnsupportedOperationException#
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().(baseMessage)
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().(dialect)
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#dialect.
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#getDialect().
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
      baseMessage + ", dialect: ${dialect.name}."
//    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().(baseMessage)
//                ^ reference semanticdb maven . . kotlin/String#plus().
//                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().(dialect)
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
  )
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#
  /**
   * DuplicateColumnException is thrown :
   *
   * When you attempt to create a table with multiple columns having the same name.
   * When you replace a column of a table so that you define multiple columns having the same name.
   *
   * @param columnName the duplicated column name
   */
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#`<init>`().
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#`<init>`().(columnName)
//                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#`<init>`().(tableName)
  class DuplicateColumnException(columnName: String, tableName: String) : ExceptionInInitializerError(
//      ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#
//                               display_name DuplicateColumnException
//                               documentation ```kotlin\npublic final class DuplicateColumnException : ExceptionInInitializerError\n```\n\n----\n\n\n DuplicateColumnException is thrown :\n\n When you attempt to create a table with multiple columns having the same name.\n When you replace a column of a table so that you define multiple columns having the same name.\n\n @param columnName the duplicated column name\n
//                               relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/ExceptionInInitializerError#
//      ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#`<init>`().
//                               display_name DuplicateColumnException
//                               documentation ```kotlin\npublic constructor(columnName: String, tableName: String): DuplicateColumnException\n```
//                               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#`<init>`().(columnName)
//                                          display_name columnName
//                                          documentation ```kotlin\ncolumnName: String\n```
//                                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                   ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#`<init>`().(tableName)
//                                                             display_name tableName
//                                                             documentation ```kotlin\ntableName: String\n```
//                                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/ExceptionInInitializerError#
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#`<init>`().(columnName)
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#`<init>`().(tableName)
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#`<init>`().
      "Duplicate column name \"$columnName\" in table \"$tableName\""
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#`<init>`().(columnName)
//                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#`<init>`().(tableName)
  )
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/LongQueryException#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/LongQueryException#`<init>`().
  /**
   * LongQueryException is thrown:
   *
   * When query running time is greater than value defined in DatabaseConfig.warnLongQueriesDuration
   *
   * @see org.jetbrains.exposed.v1.sql.DatabaseConfig.warnLongQueriesDuration
   */
  class LongQueryException : RuntimeException("Long query was executed")
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/LongQueryException#
//                         display_name LongQueryException
//                         documentation ```kotlin\npublic final class LongQueryException : {kotlin/RuntimeException=} RuntimeException\n```\n\n----\n\n\n LongQueryException is thrown:\n\n When query running time is greater than value defined in DatabaseConfig.warnLongQueriesDuration\n\n @see org.jetbrains.exposed.v1.sql.DatabaseConfig.warnLongQueriesDuration\n
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/RuntimeException#
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/LongQueryException#`<init>`().
//                         display_name LongQueryException
//                         documentation ```kotlin\npublic constructor(): LongQueryException\n```\n\n----\n\n\n LongQueryException is thrown:\n\n When query running time is greater than value defined in DatabaseConfig.warnLongQueriesDuration\n\n @see org.jetbrains.exposed.v1.sql.DatabaseConfig.warnLongQueriesDuration\n
//                           ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/LongQueryException#
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/LongQueryException#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().(message)
  internal fun Transaction.throwUnsupportedException(message: String): Nothing = throw UnsupportedByDialectException(
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                   display_name throwUnsupportedException
//                                                   documentation ```kotlin\ninternal final fun Transaction.throwUnsupportedException(message: String): Nothing\n```
//                                                   ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().(message)
//                                                           display_name message
//                                                           documentation ```kotlin\nmessage: String\n```
//                                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                     ^^^^^^^ reference semanticdb maven . . kotlin/Nothing#
//                                                                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().(message)
      message,
//    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().(message)
      db.dialect
//    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
  )
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
