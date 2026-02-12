  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  import org.jetbrains.exposed.v1.core.vendors.DatabaseDialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
  
  // TODO instead of magic number? put back into DatabaseConfig?
  internal const val DEFAULT_MAX_ATTEMPTS = 3
//                   ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DEFAULT_MAX_ATTEMPTS.
//                                        display_name DEFAULT_MAX_ATTEMPTS
//                                        documentation ```kotlin\ninternal final const val DEFAULT_MAX_ATTEMPTS: Int\n```
//                   ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/getDEFAULT_MAX_ATTEMPTS().
//                                        display_name DEFAULT_MAX_ATTEMPTS
//                                        documentation ```kotlin\ninternal get(): Int\n```
  
  /**
   * Base configuration for a [DatabaseApi] instance.
   *
   * Parameters set in this class apply to all transactions that use the [DatabaseApi] instance,
   * unless an applicable override is specified in an individual transaction block.
   */
  interface DatabaseConfig {
//          ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#
//                         display_name DatabaseConfig
//                         documentation ```kotlin\npublic abstract interface DatabaseConfig : Any\n```\n\n----\n\n\n Base configuration for a [DatabaseApi] instance.\n\n Parameters set in this class apply to all transactions that use the [DatabaseApi] instance,\n unless an applicable override is specified in an individual transaction block.\n
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#
      val sqlLogger: SqlLogger
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getSqlLogger().
//                  display_name sqlLogger
//                  documentation ```kotlin\npublic get(): SqlLogger\n```
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#sqlLogger.
//                  display_name sqlLogger
//                  documentation ```kotlin\npublic abstract val sqlLogger: SqlLogger\n```
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#
      val useNestedTransactions: Boolean
//        ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getUseNestedTransactions().
//                              display_name useNestedTransactions
//                              documentation ```kotlin\npublic get(): Boolean\n```
//        ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#useNestedTransactions.
//                              display_name useNestedTransactions
//                              documentation ```kotlin\npublic abstract val useNestedTransactions: Boolean\n```
//                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      val defaultFetchSize: Int?
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#defaultFetchSize.
//                         display_name defaultFetchSize
//                         documentation ```kotlin\npublic abstract val defaultFetchSize: Int?\n```
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getDefaultFetchSize().
//                         display_name defaultFetchSize
//                         documentation ```kotlin\npublic get(): Int?\n```
//                          ^^^^ reference semanticdb maven . . kotlin/Int#
      val defaultIsolationLevel: Int
//        ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#defaultIsolationLevel.
//                              display_name defaultIsolationLevel
//                              documentation ```kotlin\npublic abstract val defaultIsolationLevel: Int\n```
//        ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getDefaultIsolationLevel().
//                              display_name defaultIsolationLevel
//                              documentation ```kotlin\npublic get(): Int\n```
//                               ^^^ reference semanticdb maven . . kotlin/Int#
      val defaultMaxAttempts: Int
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#defaultMaxAttempts.
//                           display_name defaultMaxAttempts
//                           documentation ```kotlin\npublic abstract val defaultMaxAttempts: Int\n```
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getDefaultMaxAttempts().
//                           display_name defaultMaxAttempts
//                           documentation ```kotlin\npublic get(): Int\n```
//                            ^^^ reference semanticdb maven . . kotlin/Int#
      val defaultMinRetryDelay: Long
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#defaultMinRetryDelay.
//                             display_name defaultMinRetryDelay
//                             documentation ```kotlin\npublic abstract val defaultMinRetryDelay: Long\n```
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getDefaultMinRetryDelay().
//                             display_name defaultMinRetryDelay
//                             documentation ```kotlin\npublic get(): Long\n```
//                              ^^^^ reference semanticdb maven . . kotlin/Long#
      val defaultMaxRetryDelay: Long
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#defaultMaxRetryDelay.
//                             display_name defaultMaxRetryDelay
//                             documentation ```kotlin\npublic abstract val defaultMaxRetryDelay: Long\n```
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getDefaultMaxRetryDelay().
//                             display_name defaultMaxRetryDelay
//                             documentation ```kotlin\npublic get(): Long\n```
//                              ^^^^ reference semanticdb maven . . kotlin/Long#
      val defaultReadOnly: Boolean
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#defaultReadOnly.
//                        display_name defaultReadOnly
//                        documentation ```kotlin\npublic abstract val defaultReadOnly: Boolean\n```
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getDefaultReadOnly().
//                        display_name defaultReadOnly
//                        documentation ```kotlin\npublic get(): Boolean\n```
//                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      val warnLongQueriesDuration: Long?
//        ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getWarnLongQueriesDuration().
//                                display_name warnLongQueriesDuration
//                                documentation ```kotlin\npublic get(): Long?\n```
//        ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#warnLongQueriesDuration.
//                                display_name warnLongQueriesDuration
//                                documentation ```kotlin\npublic abstract val warnLongQueriesDuration: Long?\n```
//                                 ^^^^^ reference semanticdb maven . . kotlin/Long#
      val maxEntitiesToStoreInCachePerEntity: Int
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getMaxEntitiesToStoreInCachePerEntity().
//                                           display_name maxEntitiesToStoreInCachePerEntity
//                                           documentation ```kotlin\npublic get(): Int\n```
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#maxEntitiesToStoreInCachePerEntity.
//                                           display_name maxEntitiesToStoreInCachePerEntity
//                                           documentation ```kotlin\npublic abstract val maxEntitiesToStoreInCachePerEntity: Int\n```
//                                            ^^^ reference semanticdb maven . . kotlin/Int#
      val keepLoadedReferencesOutOfTransaction: Boolean
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getKeepLoadedReferencesOutOfTransaction().
//                                             display_name keepLoadedReferencesOutOfTransaction
//                                             documentation ```kotlin\npublic get(): Boolean\n```
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#keepLoadedReferencesOutOfTransaction.
//                                             display_name keepLoadedReferencesOutOfTransaction
//                                             documentation ```kotlin\npublic abstract val keepLoadedReferencesOutOfTransaction: Boolean\n```
//                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      val explicitDialect: DatabaseDialect?
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#explicitDialect.
//                        display_name explicitDialect
//                        documentation ```kotlin\npublic abstract val explicitDialect: DatabaseDialect?\n```
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getExplicitDialect().
//                        display_name explicitDialect
//                        documentation ```kotlin\npublic get(): DatabaseDialect?\n```
//                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
      val defaultSchema: Schema?
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#defaultSchema.
//                      display_name defaultSchema
//                      documentation ```kotlin\npublic abstract val defaultSchema: Schema?\n```
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getDefaultSchema().
//                      display_name defaultSchema
//                      documentation ```kotlin\npublic get(): Schema?\n```
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
      val logTooMuchResultSetsThreshold: Int
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getLogTooMuchResultSetsThreshold().
//                                      display_name logTooMuchResultSetsThreshold
//                                      documentation ```kotlin\npublic get(): Int\n```
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#logTooMuchResultSetsThreshold.
//                                      display_name logTooMuchResultSetsThreshold
//                                      documentation ```kotlin\npublic abstract val logTooMuchResultSetsThreshold: Int\n```
//                                       ^^^ reference semanticdb maven . . kotlin/Int#
      val preserveKeywordCasing: Boolean
//        ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getPreserveKeywordCasing().
//                              display_name preserveKeywordCasing
//                              documentation ```kotlin\npublic get(): Boolean\n```
//        ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#preserveKeywordCasing.
//                              display_name preserveKeywordCasing
//                              documentation ```kotlin\npublic abstract val preserveKeywordCasing: Boolean\n```
//                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      /**
       * Builder API responsible for constructing a custom [DatabaseApi] configuration parameter state.
       */
      open class Builder {
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#
//                       display_name Builder
//                       documentation ```kotlin\npublic open class Builder : Any\n```\n\n----\n\n\n Builder API responsible for constructing a custom [DatabaseApi] configuration parameter state.\n
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#`<init>`().
//                       display_name Builder
//                       documentation ```kotlin\npublic constructor(): DatabaseConfig.Builder\n```\n\n----\n\n\n Builder API responsible for constructing a custom [DatabaseApi] configuration parameter state.\n
          /**
           * SQLLogger to be used to log all SQL statements. [Slf4jSqlDebugLogger] by default.
           */
          var sqlLogger: SqlLogger? = null
//            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getSqlLogger().
//                      display_name sqlLogger
//                      documentation ```kotlin\npublic get(): SqlLogger?\n```\n\n----\n\n\n SQLLogger to be used to log all SQL statements. [Slf4jSqlDebugLogger] by default.\n
//            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setSqlLogger().
//                      display_name sqlLogger
//                      documentation ```kotlin\npublic set(value: SqlLogger?): Unit\n```\n\n----\n\n\n SQLLogger to be used to log all SQL statements. [Slf4jSqlDebugLogger] by default.\n
//            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setSqlLogger().(value)
//                      display_name value
//                      documentation ```kotlin\nvalue: SqlLogger?\n```\n\n----\n\n\n SQLLogger to be used to log all SQL statements. [Slf4jSqlDebugLogger] by default.\n
//            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#sqlLogger.
//                      display_name sqlLogger
//                      documentation ```kotlin\npublic final var sqlLogger: SqlLogger?\n```\n\n----\n\n\n SQLLogger to be used to log all SQL statements. [Slf4jSqlDebugLogger] by default.\n
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#
  
          /**
           * Turn on/off nested transactions support. Is disabled by default
           */
          var useNestedTransactions: Boolean = false
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getUseNestedTransactions().
//                                  display_name useNestedTransactions
//                                  documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n\n Turn on/off nested transactions support. Is disabled by default\n
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setUseNestedTransactions().
//                                  display_name useNestedTransactions
//                                  documentation ```kotlin\npublic set(value: Boolean): Unit\n```\n\n----\n\n\n Turn on/off nested transactions support. Is disabled by default\n
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setUseNestedTransactions().(value)
//                                  display_name value
//                                  documentation ```kotlin\nvalue: Boolean\n```\n\n----\n\n\n Turn on/off nested transactions support. Is disabled by default\n
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#useNestedTransactions.
//                                  display_name useNestedTransactions
//                                  documentation ```kotlin\npublic final var useNestedTransactions: Boolean\n```\n\n----\n\n\n Turn on/off nested transactions support. Is disabled by default\n
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
          /**
           * How many records will be fetched at once by select queries
           */
          var defaultFetchSize: Int? = null
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#defaultFetchSize.
//                             display_name defaultFetchSize
//                             documentation ```kotlin\npublic final var defaultFetchSize: Int?\n```\n\n----\n\n\n How many records will be fetched at once by select queries\n
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getDefaultFetchSize().
//                             display_name defaultFetchSize
//                             documentation ```kotlin\npublic get(): Int?\n```\n\n----\n\n\n How many records will be fetched at once by select queries\n
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultFetchSize().
//                             display_name defaultFetchSize
//                             documentation ```kotlin\npublic set(value: Int?): Unit\n```\n\n----\n\n\n How many records will be fetched at once by select queries\n
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultFetchSize().(value)
//                             display_name value
//                             documentation ```kotlin\nvalue: Int?\n```\n\n----\n\n\n How many records will be fetched at once by select queries\n
//                              ^^^^ reference semanticdb maven . . kotlin/Int#
  
          /**
           * Default transaction isolation level. If not specified, the database-specific level will be used.
           * This can be overridden on a per-transaction level by specifying the `transactionIsolation` parameter of
           * the `transaction` function.
           *
           * Check `Database.getDefaultIsolationLevel()` for the database defaults.
           *
           * If using Exposed with an R2DBC driver, `defaultR2dbcIsolationLevel` should be used directly instead.
           */
          open var defaultIsolationLevel: Int = -1
//                 ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#defaultIsolationLevel.
//                                       display_name defaultIsolationLevel
//                                       documentation ```kotlin\npublic open var defaultIsolationLevel: Int\n```\n\n----\n\n\n Default transaction isolation level. If not specified, the database-specific level will be used.\n This can be overridden on a per-transaction level by specifying the `transactionIsolation` parameter of\n the `transaction` function.\n\n Check `Database.getDefaultIsolationLevel()` for the database defaults.\n\n If using Exposed with an R2DBC driver, `defaultR2dbcIsolationLevel` should be used directly instead.\n
//                 ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getDefaultIsolationLevel().
//                                       display_name defaultIsolationLevel
//                                       documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n\n Default transaction isolation level. If not specified, the database-specific level will be used.\n This can be overridden on a per-transaction level by specifying the `transactionIsolation` parameter of\n the `transaction` function.\n\n Check `Database.getDefaultIsolationLevel()` for the database defaults.\n\n If using Exposed with an R2DBC driver, `defaultR2dbcIsolationLevel` should be used directly instead.\n
//                 ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultIsolationLevel().
//                                       display_name defaultIsolationLevel
//                                       documentation ```kotlin\npublic set(value: Int): Unit\n```\n\n----\n\n\n Default transaction isolation level. If not specified, the database-specific level will be used.\n This can be overridden on a per-transaction level by specifying the `transactionIsolation` parameter of\n the `transaction` function.\n\n Check `Database.getDefaultIsolationLevel()` for the database defaults.\n\n If using Exposed with an R2DBC driver, `defaultR2dbcIsolationLevel` should be used directly instead.\n
//                 ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultIsolationLevel().(value)
//                                       display_name value
//                                       documentation ```kotlin\nvalue: Int\n```\n\n----\n\n\n Default transaction isolation level. If not specified, the database-specific level will be used.\n This can be overridden on a per-transaction level by specifying the `transactionIsolation` parameter of\n the `transaction` function.\n\n Check `Database.getDefaultIsolationLevel()` for the database defaults.\n\n If using Exposed with an R2DBC driver, `defaultR2dbcIsolationLevel` should be used directly instead.\n
//                                        ^^^ reference semanticdb maven . . kotlin/Int#
  
          /**
           * The maximum amount of attempts that will be made to perform any transaction block.
           * If this value is set to 1 and an SQLException happens, the exception will be thrown without performing a retry.
           * This can be overridden on a per-transaction level by specifying the `maxAttempts` property in a
           * `transaction` block.
           * Default amount of attempts is 3.
           *
           * @throws IllegalArgumentException If the amount of attempts is set to a value less than 1.
           */
          var defaultMaxAttempts: Int = DEFAULT_MAX_ATTEMPTS
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#defaultMaxAttempts.
//                               display_name defaultMaxAttempts
//                               documentation ```kotlin\npublic final var defaultMaxAttempts: Int\n```\n\n----\n\n\n The maximum amount of attempts that will be made to perform any transaction block.\n If this value is set to 1 and an SQLException happens, the exception will be thrown without performing a retry.\n This can be overridden on a per-transaction level by specifying the `maxAttempts` property in a\n `transaction` block.\n Default amount of attempts is 3.\n\n @throws IllegalArgumentException If the amount of attempts is set to a value less than 1.\n
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getDefaultMaxAttempts().
//                               display_name defaultMaxAttempts
//                               documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n\n The maximum amount of attempts that will be made to perform any transaction block.\n If this value is set to 1 and an SQLException happens, the exception will be thrown without performing a retry.\n This can be overridden on a per-transaction level by specifying the `maxAttempts` property in a\n `transaction` block.\n Default amount of attempts is 3.\n\n @throws IllegalArgumentException If the amount of attempts is set to a value less than 1.\n
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultMaxAttempts().
//                               display_name defaultMaxAttempts
//                               documentation ```kotlin\npublic set(value: Int): Unit\n```\n\n----\n\n\n The maximum amount of attempts that will be made to perform any transaction block.\n If this value is set to 1 and an SQLException happens, the exception will be thrown without performing a retry.\n This can be overridden on a per-transaction level by specifying the `maxAttempts` property in a\n `transaction` block.\n Default amount of attempts is 3.\n\n @throws IllegalArgumentException If the amount of attempts is set to a value less than 1.\n
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultMaxAttempts().(value)
//                               display_name value
//                               documentation ```kotlin\nvalue: Int\n```\n\n----\n\n\n The maximum amount of attempts that will be made to perform any transaction block.\n If this value is set to 1 and an SQLException happens, the exception will be thrown without performing a retry.\n This can be overridden on a per-transaction level by specifying the `maxAttempts` property in a\n `transaction` block.\n Default amount of attempts is 3.\n\n @throws IllegalArgumentException If the amount of attempts is set to a value less than 1.\n
//                                ^^^ reference semanticdb maven . . kotlin/Int#
//                                      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DEFAULT_MAX_ATTEMPTS.
//                                      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getDEFAULT_MAX_ATTEMPTS().
  
          /**
           * The minimum number of milliseconds to wait before retrying a transaction if an SQLException happens.
           * This can be overridden on a per-transaction level by specifying the `minRetryDelay` property in a
           * `transaction` block.
           * Default minimum delay is 0.
           */
          var defaultMinRetryDelay: Long = 0
//            ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#defaultMinRetryDelay.
//                                 display_name defaultMinRetryDelay
//                                 documentation ```kotlin\npublic final var defaultMinRetryDelay: Long\n```\n\n----\n\n\n The minimum number of milliseconds to wait before retrying a transaction if an SQLException happens.\n This can be overridden on a per-transaction level by specifying the `minRetryDelay` property in a\n `transaction` block.\n Default minimum delay is 0.\n
//            ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getDefaultMinRetryDelay().
//                                 display_name defaultMinRetryDelay
//                                 documentation ```kotlin\npublic get(): Long\n```\n\n----\n\n\n The minimum number of milliseconds to wait before retrying a transaction if an SQLException happens.\n This can be overridden on a per-transaction level by specifying the `minRetryDelay` property in a\n `transaction` block.\n Default minimum delay is 0.\n
//            ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultMinRetryDelay().
//                                 display_name defaultMinRetryDelay
//                                 documentation ```kotlin\npublic set(value: Long): Unit\n```\n\n----\n\n\n The minimum number of milliseconds to wait before retrying a transaction if an SQLException happens.\n This can be overridden on a per-transaction level by specifying the `minRetryDelay` property in a\n `transaction` block.\n Default minimum delay is 0.\n
//            ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultMinRetryDelay().(value)
//                                 display_name value
//                                 documentation ```kotlin\nvalue: Long\n```\n\n----\n\n\n The minimum number of milliseconds to wait before retrying a transaction if an SQLException happens.\n This can be overridden on a per-transaction level by specifying the `minRetryDelay` property in a\n `transaction` block.\n Default minimum delay is 0.\n
//                                  ^^^^ reference semanticdb maven . . kotlin/Long#
  
          /**
           * The maximum number of milliseconds to wait before retrying a transaction if an SQLException happens.
           * This can be overridden on a per-transaction level by specifying the `maxRetryDelay` property in a
           * `transaction` block.
           * Default maximum delay is 0.
           */
          var defaultMaxRetryDelay: Long = 0
//            ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#defaultMaxRetryDelay.
//                                 display_name defaultMaxRetryDelay
//                                 documentation ```kotlin\npublic final var defaultMaxRetryDelay: Long\n```\n\n----\n\n\n The maximum number of milliseconds to wait before retrying a transaction if an SQLException happens.\n This can be overridden on a per-transaction level by specifying the `maxRetryDelay` property in a\n `transaction` block.\n Default maximum delay is 0.\n
//            ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getDefaultMaxRetryDelay().
//                                 display_name defaultMaxRetryDelay
//                                 documentation ```kotlin\npublic get(): Long\n```\n\n----\n\n\n The maximum number of milliseconds to wait before retrying a transaction if an SQLException happens.\n This can be overridden on a per-transaction level by specifying the `maxRetryDelay` property in a\n `transaction` block.\n Default maximum delay is 0.\n
//            ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultMaxRetryDelay().
//                                 display_name defaultMaxRetryDelay
//                                 documentation ```kotlin\npublic set(value: Long): Unit\n```\n\n----\n\n\n The maximum number of milliseconds to wait before retrying a transaction if an SQLException happens.\n This can be overridden on a per-transaction level by specifying the `maxRetryDelay` property in a\n `transaction` block.\n Default maximum delay is 0.\n
//            ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultMaxRetryDelay().(value)
//                                 display_name value
//                                 documentation ```kotlin\nvalue: Long\n```\n\n----\n\n\n The maximum number of milliseconds to wait before retrying a transaction if an SQLException happens.\n This can be overridden on a per-transaction level by specifying the `maxRetryDelay` property in a\n `transaction` block.\n Default maximum delay is 0.\n
//                                  ^^^^ reference semanticdb maven . . kotlin/Long#
  
          /**
           * Should all connections/transactions be executed in read-only mode by default or not.
           * Default state is false.
           */
          var defaultReadOnly: Boolean = false
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#defaultReadOnly.
//                            display_name defaultReadOnly
//                            documentation ```kotlin\npublic final var defaultReadOnly: Boolean\n```\n\n----\n\n\n Should all connections/transactions be executed in read-only mode by default or not.\n Default state is false.\n
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getDefaultReadOnly().
//                            display_name defaultReadOnly
//                            documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n\n Should all connections/transactions be executed in read-only mode by default or not.\n Default state is false.\n
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultReadOnly().
//                            display_name defaultReadOnly
//                            documentation ```kotlin\npublic set(value: Boolean): Unit\n```\n\n----\n\n\n Should all connections/transactions be executed in read-only mode by default or not.\n Default state is false.\n
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultReadOnly().(value)
//                            display_name value
//                            documentation ```kotlin\nvalue: Boolean\n```\n\n----\n\n\n Should all connections/transactions be executed in read-only mode by default or not.\n Default state is false.\n
//                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
          /**
           * Threshold in milliseconds to log queries which exceed the threshold with WARN level.
           * No tracing enabled by default.
           * This can be set on a per-transaction level by setting [Transaction.warnLongQueriesDuration] field.
           */
          var warnLongQueriesDuration: Long? = null
//            ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getWarnLongQueriesDuration().
//                                    display_name warnLongQueriesDuration
//                                    documentation ```kotlin\npublic get(): Long?\n```\n\n----\n\n\n Threshold in milliseconds to log queries which exceed the threshold with WARN level.\n No tracing enabled by default.\n This can be set on a per-transaction level by setting [Transaction.warnLongQueriesDuration] field.\n
//            ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setWarnLongQueriesDuration().
//                                    display_name warnLongQueriesDuration
//                                    documentation ```kotlin\npublic set(value: Long?): Unit\n```\n\n----\n\n\n Threshold in milliseconds to log queries which exceed the threshold with WARN level.\n No tracing enabled by default.\n This can be set on a per-transaction level by setting [Transaction.warnLongQueriesDuration] field.\n
//            ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setWarnLongQueriesDuration().(value)
//                                    display_name value
//                                    documentation ```kotlin\nvalue: Long?\n```\n\n----\n\n\n Threshold in milliseconds to log queries which exceed the threshold with WARN level.\n No tracing enabled by default.\n This can be set on a per-transaction level by setting [Transaction.warnLongQueriesDuration] field.\n
//            ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#warnLongQueriesDuration.
//                                    display_name warnLongQueriesDuration
//                                    documentation ```kotlin\npublic final var warnLongQueriesDuration: Long?\n```\n\n----\n\n\n Threshold in milliseconds to log queries which exceed the threshold with WARN level.\n No tracing enabled by default.\n This can be set on a per-transaction level by setting [Transaction.warnLongQueriesDuration] field.\n
//                                     ^^^^^ reference semanticdb maven . . kotlin/Long#
  
          /**
           * Amount of entities to keep in an EntityCache per an Entity class.
           * Applicable only when `exposed-dao` module is used.
           * This can be overridden on a per-transaction basis via `EntityCache.maxEntitiesToStore`.
           * All entities will be kept by default.
           */
          var maxEntitiesToStoreInCachePerEntity: Int = Int.MAX_VALUE
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getMaxEntitiesToStoreInCachePerEntity().
//                                               display_name maxEntitiesToStoreInCachePerEntity
//                                               documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n\n Amount of entities to keep in an EntityCache per an Entity class.\n Applicable only when `exposed-dao` module is used.\n This can be overridden on a per-transaction basis via `EntityCache.maxEntitiesToStore`.\n All entities will be kept by default.\n
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#maxEntitiesToStoreInCachePerEntity.
//                                               display_name maxEntitiesToStoreInCachePerEntity
//                                               documentation ```kotlin\npublic final var maxEntitiesToStoreInCachePerEntity: Int\n```\n\n----\n\n\n Amount of entities to keep in an EntityCache per an Entity class.\n Applicable only when `exposed-dao` module is used.\n This can be overridden on a per-transaction basis via `EntityCache.maxEntitiesToStore`.\n All entities will be kept by default.\n
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setMaxEntitiesToStoreInCachePerEntity().
//                                               display_name maxEntitiesToStoreInCachePerEntity
//                                               documentation ```kotlin\npublic set(value: Int): Unit\n```\n\n----\n\n\n Amount of entities to keep in an EntityCache per an Entity class.\n Applicable only when `exposed-dao` module is used.\n This can be overridden on a per-transaction basis via `EntityCache.maxEntitiesToStore`.\n All entities will be kept by default.\n
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setMaxEntitiesToStoreInCachePerEntity().(value)
//                                               display_name value
//                                               documentation ```kotlin\nvalue: Int\n```\n\n----\n\n\n Amount of entities to keep in an EntityCache per an Entity class.\n Applicable only when `exposed-dao` module is used.\n This can be overridden on a per-transaction basis via `EntityCache.maxEntitiesToStore`.\n All entities will be kept by default.\n
//                                                ^^^ reference semanticdb maven . . kotlin/Int#
//                                                          ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                          ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
  
          /**
           * Turns on "mode" for Exposed DAO to store relations (after they were loaded) within the entity that will
           * allow access to them outside the transaction.
           * Useful when [eager loading](https://github.com/JetBrains/Exposed/wiki/DAO#eager-loading) is used.
           */
          var keepLoadedReferencesOutOfTransaction: Boolean = false
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getKeepLoadedReferencesOutOfTransaction().
//                                                 display_name keepLoadedReferencesOutOfTransaction
//                                                 documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n\n Turns on "mode" for Exposed DAO to store relations (after they were loaded) within the entity that will\n allow access to them outside the transaction.\n Useful when [eager loading](https://github.com/JetBrains/Exposed/wiki/DAO#eager-loading) is used.\n
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#keepLoadedReferencesOutOfTransaction.
//                                                 display_name keepLoadedReferencesOutOfTransaction
//                                                 documentation ```kotlin\npublic final var keepLoadedReferencesOutOfTransaction: Boolean\n```\n\n----\n\n\n Turns on "mode" for Exposed DAO to store relations (after they were loaded) within the entity that will\n allow access to them outside the transaction.\n Useful when [eager loading](https://github.com/JetBrains/Exposed/wiki/DAO#eager-loading) is used.\n
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setKeepLoadedReferencesOutOfTransaction().
//                                                 display_name keepLoadedReferencesOutOfTransaction
//                                                 documentation ```kotlin\npublic set(value: Boolean): Unit\n```\n\n----\n\n\n Turns on "mode" for Exposed DAO to store relations (after they were loaded) within the entity that will\n allow access to them outside the transaction.\n Useful when [eager loading](https://github.com/JetBrains/Exposed/wiki/DAO#eager-loading) is used.\n
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setKeepLoadedReferencesOutOfTransaction().(value)
//                                                 display_name value
//                                                 documentation ```kotlin\nvalue: Boolean\n```\n\n----\n\n\n Turns on "mode" for Exposed DAO to store relations (after they were loaded) within the entity that will\n allow access to them outside the transaction.\n Useful when [eager loading](https://github.com/JetBrains/Exposed/wiki/DAO#eager-loading) is used.\n
//                                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
          /**
           * Set the explicit dialect for a database.
           * This can be useful when working with unsupported dialects which have the same behavior as the one that
           * Exposed supports.
           */
          var explicitDialect: DatabaseDialect? = null
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#explicitDialect.
//                            display_name explicitDialect
//                            documentation ```kotlin\npublic final var explicitDialect: DatabaseDialect?\n```\n\n----\n\n\n Set the explicit dialect for a database.\n This can be useful when working with unsupported dialects which have the same behavior as the one that\n Exposed supports.\n
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getExplicitDialect().
//                            display_name explicitDialect
//                            documentation ```kotlin\npublic get(): DatabaseDialect?\n```\n\n----\n\n\n Set the explicit dialect for a database.\n This can be useful when working with unsupported dialects which have the same behavior as the one that\n Exposed supports.\n
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setExplicitDialect().
//                            display_name explicitDialect
//                            documentation ```kotlin\npublic set(value: DatabaseDialect?): Unit\n```\n\n----\n\n\n Set the explicit dialect for a database.\n This can be useful when working with unsupported dialects which have the same behavior as the one that\n Exposed supports.\n
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setExplicitDialect().(value)
//                            display_name value
//                            documentation ```kotlin\nvalue: DatabaseDialect?\n```\n\n----\n\n\n Set the explicit dialect for a database.\n This can be useful when working with unsupported dialects which have the same behavior as the one that\n Exposed supports.\n
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
  
          /**
           * Set the default schema for a database.
           */
          var defaultSchema: Schema? = null
//            ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#defaultSchema.
//                          display_name defaultSchema
//                          documentation ```kotlin\npublic final var defaultSchema: Schema?\n```\n\n----\n\n\n Set the default schema for a database.\n
//            ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getDefaultSchema().
//                          display_name defaultSchema
//                          documentation ```kotlin\npublic get(): Schema?\n```\n\n----\n\n\n Set the default schema for a database.\n
//            ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultSchema().
//                          display_name defaultSchema
//                          documentation ```kotlin\npublic set(value: Schema?): Unit\n```\n\n----\n\n\n Set the default schema for a database.\n
//            ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultSchema().(value)
//                          display_name value
//                          documentation ```kotlin\nvalue: Schema?\n```\n\n----\n\n\n Set the default schema for a database.\n
//                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
  
          /**
           * Log too much result sets opened in parallel.
           * The error log will contain the stacktrace of the place in the code where a new result set occurs, and it
           * exceeds the threshold.
           * 0 value means no log needed.
           */
          var logTooMuchResultSetsThreshold: Int = 0
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getLogTooMuchResultSetsThreshold().
//                                          display_name logTooMuchResultSetsThreshold
//                                          documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n\n Log too much result sets opened in parallel.\n The error log will contain the stacktrace of the place in the code where a new result set occurs, and it\n exceeds the threshold.\n 0 value means no log needed.\n
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#logTooMuchResultSetsThreshold.
//                                          display_name logTooMuchResultSetsThreshold
//                                          documentation ```kotlin\npublic final var logTooMuchResultSetsThreshold: Int\n```\n\n----\n\n\n Log too much result sets opened in parallel.\n The error log will contain the stacktrace of the place in the code where a new result set occurs, and it\n exceeds the threshold.\n 0 value means no log needed.\n
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setLogTooMuchResultSetsThreshold().
//                                          display_name logTooMuchResultSetsThreshold
//                                          documentation ```kotlin\npublic set(value: Int): Unit\n```\n\n----\n\n\n Log too much result sets opened in parallel.\n The error log will contain the stacktrace of the place in the code where a new result set occurs, and it\n exceeds the threshold.\n 0 value means no log needed.\n
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setLogTooMuchResultSetsThreshold().(value)
//                                          display_name value
//                                          documentation ```kotlin\nvalue: Int\n```\n\n----\n\n\n Log too much result sets opened in parallel.\n The error log will contain the stacktrace of the place in the code where a new result set occurs, and it\n exceeds the threshold.\n 0 value means no log needed.\n
//                                           ^^^ reference semanticdb maven . . kotlin/Int#
  
          /**
           * Toggle whether table and column identifiers that are also keywords should retain their case sensitivity.
           * Keeping user-defined case sensitivity (value set to `true`) is the default setting.
           */
          @ExperimentalKeywordApi
          var preserveKeywordCasing: Boolean = true
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getPreserveKeywordCasing().
//                                  display_name preserveKeywordCasing
//                                  documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n\n Toggle whether table and column identifiers that are also keywords should retain their case sensitivity.\n Keeping user-defined case sensitivity (value set to `true`) is the default setting.\n
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#preserveKeywordCasing.
//                                  display_name preserveKeywordCasing
//                                  documentation ```kotlin\n@ExperimentalKeywordApi() public final var preserveKeywordCasing: Boolean\n```\n\n----\n\n\n Toggle whether table and column identifiers that are also keywords should retain their case sensitivity.\n Keeping user-defined case sensitivity (value set to `true`) is the default setting.\n
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setPreserveKeywordCasing().
//                                  display_name preserveKeywordCasing
//                                  documentation ```kotlin\npublic set(value: Boolean): Unit\n```\n\n----\n\n\n Toggle whether table and column identifiers that are also keywords should retain their case sensitivity.\n Keeping user-defined case sensitivity (value set to `true`) is the default setting.\n
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setPreserveKeywordCasing().(value)
//                                  display_name value
//                                  documentation ```kotlin\nvalue: Boolean\n```\n\n----\n\n\n Toggle whether table and column identifiers that are also keywords should retain their case sensitivity.\n Keeping user-defined case sensitivity (value set to `true`) is the default setting.\n
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      }
  
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Companion# 42:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Companion#`<init>`(). 42:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): DatabaseConfig.Companion\n```
          // TODO make sure R2dbcDatabaseConfig has constructor function so that it is compatible with JDBC
          operator fun invoke(body: Builder.() -> Unit = {}): DatabaseConfig {
//                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Companion#invoke().
//                            display_name invoke
//                            documentation ```kotlin\npublic final operator fun invoke(body: DatabaseConfig.Builder.() -> Unit = ...): DatabaseConfig\n```
//                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Companion#invoke().(body)
//                                 display_name body
//                                 documentation ```kotlin\nbody: DatabaseConfig.Builder.() -> Unit = ...\n```
//                                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#
              val builder = Builder().apply(body)
//                ^^^^^^^ definition local 0
//                        display_name builder
//                        documentation ```kotlin\nlocal val builder: DatabaseConfig.Builder\n```
//                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#`<init>`().
//                                    ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Companion#invoke().(body)
              require(builder.defaultMaxAttempts > 0) { "defaultMaxAttempts must be set to perform at least 1 attempt." }
//            ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                    ^^^^^^^ reference local 0
//                            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#defaultMaxAttempts.
//                            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getDefaultMaxAttempts().
//                            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultMaxAttempts().
//                                               ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
  
              // TODO make default implementation to simplify & call constructor func instead
              return object : DatabaseConfig {
//                   ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#
//                          display_name <anonymous>
//                          documentation ```kotlin\nobject : DatabaseConfig\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#
//                   ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#`<init>`().
//                          display_name <anonymous>
//                          documentation ```kotlin\nprivate constructor(): <anonymous>\n```
//                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#
                  override val sqlLogger: SqlLogger
//                             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#sqlLogger.
//                                       display_name sqlLogger
//                                       documentation ```kotlin\npublic open override val sqlLogger: SqlLogger\n```
//                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlLogger#
                      get() = builder.sqlLogger ?: Slf4jSqlDebugLogger
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#getSqlLogger().
//                        display_name sqlLogger
//                        documentation ```kotlin\npublic get(): SqlLogger\n```
//                            ^^^^^^^ reference local 0
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getSqlLogger().
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setSqlLogger().
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#sqlLogger.
                  override val useNestedTransactions: Boolean
//                             ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#useNestedTransactions.
//                                                   display_name useNestedTransactions
//                                                   documentation ```kotlin\npublic open override val useNestedTransactions: Boolean\n```
//                                                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
                      get() = builder.useNestedTransactions
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#getUseNestedTransactions().
//                        display_name useNestedTransactions
//                        documentation ```kotlin\npublic get(): Boolean\n```
//                            ^^^^^^^ reference local 0
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getUseNestedTransactions().
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setUseNestedTransactions().
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#useNestedTransactions.
                  override val defaultFetchSize: Int?
//                             ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#defaultFetchSize.
//                                              display_name defaultFetchSize
//                                              documentation ```kotlin\npublic open override val defaultFetchSize: Int?\n```
//                                               ^^^^ reference semanticdb maven . . kotlin/Int#
                      get() = builder.defaultFetchSize
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#getDefaultFetchSize().
//                        display_name defaultFetchSize
//                        documentation ```kotlin\npublic get(): Int?\n```
//                            ^^^^^^^ reference local 0
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#defaultFetchSize.
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getDefaultFetchSize().
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultFetchSize().
                  override val defaultIsolationLevel: Int
//                             ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#defaultIsolationLevel.
//                                                   display_name defaultIsolationLevel
//                                                   documentation ```kotlin\npublic open override val defaultIsolationLevel: Int\n```
//                                                    ^^^ reference semanticdb maven . . kotlin/Int#
                      get() = builder.defaultIsolationLevel
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#getDefaultIsolationLevel().
//                        display_name defaultIsolationLevel
//                        documentation ```kotlin\npublic get(): Int\n```
//                            ^^^^^^^ reference local 0
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#defaultIsolationLevel.
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getDefaultIsolationLevel().
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultIsolationLevel().
                  override val defaultMaxAttempts: Int
//                             ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#defaultMaxAttempts.
//                                                display_name defaultMaxAttempts
//                                                documentation ```kotlin\npublic open override val defaultMaxAttempts: Int\n```
//                                                 ^^^ reference semanticdb maven . . kotlin/Int#
                      get() = builder.defaultMaxAttempts
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#getDefaultMaxAttempts().
//                        display_name defaultMaxAttempts
//                        documentation ```kotlin\npublic get(): Int\n```
//                            ^^^^^^^ reference local 0
//                                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#defaultMaxAttempts.
//                                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getDefaultMaxAttempts().
//                                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultMaxAttempts().
                  override val defaultMinRetryDelay: Long
//                             ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#defaultMinRetryDelay.
//                                                  display_name defaultMinRetryDelay
//                                                  documentation ```kotlin\npublic open override val defaultMinRetryDelay: Long\n```
//                                                   ^^^^ reference semanticdb maven . . kotlin/Long#
                      get() = builder.defaultMinRetryDelay
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#getDefaultMinRetryDelay().
//                        display_name defaultMinRetryDelay
//                        documentation ```kotlin\npublic get(): Long\n```
//                            ^^^^^^^ reference local 0
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#defaultMinRetryDelay.
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getDefaultMinRetryDelay().
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultMinRetryDelay().
                  override val defaultMaxRetryDelay: Long
//                             ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#defaultMaxRetryDelay.
//                                                  display_name defaultMaxRetryDelay
//                                                  documentation ```kotlin\npublic open override val defaultMaxRetryDelay: Long\n```
//                                                   ^^^^ reference semanticdb maven . . kotlin/Long#
                      get() = builder.defaultMaxRetryDelay
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#getDefaultMaxRetryDelay().
//                        display_name defaultMaxRetryDelay
//                        documentation ```kotlin\npublic get(): Long\n```
//                            ^^^^^^^ reference local 0
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#defaultMaxRetryDelay.
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getDefaultMaxRetryDelay().
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultMaxRetryDelay().
                  override val defaultReadOnly: Boolean
//                             ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#defaultReadOnly.
//                                             display_name defaultReadOnly
//                                             documentation ```kotlin\npublic open override val defaultReadOnly: Boolean\n```
//                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
                      get() = builder.defaultReadOnly
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#getDefaultReadOnly().
//                        display_name defaultReadOnly
//                        documentation ```kotlin\npublic get(): Boolean\n```
//                            ^^^^^^^ reference local 0
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#defaultReadOnly.
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getDefaultReadOnly().
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultReadOnly().
                  override val warnLongQueriesDuration: Long?
//                             ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#warnLongQueriesDuration.
//                                                     display_name warnLongQueriesDuration
//                                                     documentation ```kotlin\npublic open override val warnLongQueriesDuration: Long?\n```
//                                                      ^^^^^ reference semanticdb maven . . kotlin/Long#
                      get() = builder.warnLongQueriesDuration
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#getWarnLongQueriesDuration().
//                        display_name warnLongQueriesDuration
//                        documentation ```kotlin\npublic get(): Long?\n```
//                            ^^^^^^^ reference local 0
//                                    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getWarnLongQueriesDuration().
//                                    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setWarnLongQueriesDuration().
//                                    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#warnLongQueriesDuration.
                  override val maxEntitiesToStoreInCachePerEntity: Int
//                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#maxEntitiesToStoreInCachePerEntity.
//                                                                display_name maxEntitiesToStoreInCachePerEntity
//                                                                documentation ```kotlin\npublic open override val maxEntitiesToStoreInCachePerEntity: Int\n```
//                                                                 ^^^ reference semanticdb maven . . kotlin/Int#
                      get() = builder.maxEntitiesToStoreInCachePerEntity
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#getMaxEntitiesToStoreInCachePerEntity().
//                        display_name maxEntitiesToStoreInCachePerEntity
//                        documentation ```kotlin\npublic get(): Int\n```
//                            ^^^^^^^ reference local 0
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getMaxEntitiesToStoreInCachePerEntity().
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#maxEntitiesToStoreInCachePerEntity.
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setMaxEntitiesToStoreInCachePerEntity().
                  override val keepLoadedReferencesOutOfTransaction: Boolean
//                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#keepLoadedReferencesOutOfTransaction.
//                                                                  display_name keepLoadedReferencesOutOfTransaction
//                                                                  documentation ```kotlin\npublic open override val keepLoadedReferencesOutOfTransaction: Boolean\n```
//                                                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
                      get() = builder.keepLoadedReferencesOutOfTransaction
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#getKeepLoadedReferencesOutOfTransaction().
//                        display_name keepLoadedReferencesOutOfTransaction
//                        documentation ```kotlin\npublic get(): Boolean\n```
//                            ^^^^^^^ reference local 0
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getKeepLoadedReferencesOutOfTransaction().
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#keepLoadedReferencesOutOfTransaction.
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setKeepLoadedReferencesOutOfTransaction().
                  override val explicitDialect: DatabaseDialect?
//                             ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#explicitDialect.
//                                             display_name explicitDialect
//                                             documentation ```kotlin\npublic open override val explicitDialect: DatabaseDialect?\n```
//                                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
                      get() = builder.explicitDialect
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#getExplicitDialect().
//                        display_name explicitDialect
//                        documentation ```kotlin\npublic get(): DatabaseDialect?\n```
//                            ^^^^^^^ reference local 0
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#explicitDialect.
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getExplicitDialect().
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setExplicitDialect().
                  override val defaultSchema: Schema?
//                             ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#defaultSchema.
//                                           display_name defaultSchema
//                                           documentation ```kotlin\npublic open override val defaultSchema: Schema?\n```
//                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
                      get() = builder.defaultSchema
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#getDefaultSchema().
//                        display_name defaultSchema
//                        documentation ```kotlin\npublic get(): Schema?\n```
//                            ^^^^^^^ reference local 0
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#defaultSchema.
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getDefaultSchema().
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setDefaultSchema().
                  override val logTooMuchResultSetsThreshold: Int
//                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#logTooMuchResultSetsThreshold.
//                                                           display_name logTooMuchResultSetsThreshold
//                                                           documentation ```kotlin\npublic open override val logTooMuchResultSetsThreshold: Int\n```
//                                                            ^^^ reference semanticdb maven . . kotlin/Int#
                      get() = builder.logTooMuchResultSetsThreshold
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#getLogTooMuchResultSetsThreshold().
//                        display_name logTooMuchResultSetsThreshold
//                        documentation ```kotlin\npublic get(): Int\n```
//                            ^^^^^^^ reference local 0
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getLogTooMuchResultSetsThreshold().
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#logTooMuchResultSetsThreshold.
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setLogTooMuchResultSetsThreshold().
  
                  @OptIn(ExperimentalKeywordApi::class)
                  override val preserveKeywordCasing: Boolean
//                             ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#preserveKeywordCasing.
//                                                   display_name preserveKeywordCasing
//                                                   documentation ```kotlin\n@OptIn(...) public open override val preserveKeywordCasing: Boolean\n```
//                                                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
                      get() = builder.preserveKeywordCasing
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 6298>`#getPreserveKeywordCasing().
//                        display_name preserveKeywordCasing
//                        documentation ```kotlin\npublic get(): Boolean\n```
//                            ^^^^^^^ reference local 0
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#getPreserveKeywordCasing().
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#preserveKeywordCasing.
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#Builder#setPreserveKeywordCasing().
              }
          }
      }
  }
