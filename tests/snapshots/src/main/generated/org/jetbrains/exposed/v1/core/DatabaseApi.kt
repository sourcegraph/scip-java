package org.jetbrains.exposed.v1.core
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/

import org.jetbrains.exposed.v1.core.statements.api.IdentifierManagerApi
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                              ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/
//                                                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#
import org.jetbrains.exposed.v1.core.vendors.DatabaseDialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
import java.util.concurrent.ConcurrentHashMap
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven . . java/util/concurrent/
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#

/**
 * Base class representing the underlying database to which connections are made
 * and on which transaction tasks are performed.
 *
 * @param config Configuration holding all parameters that apply to a transaction using this database instance.
 */
abstract class DatabaseApi protected constructor(
//             ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#
//                         display_name DatabaseApi
//                         documentation ```kotlin\npublic abstract class DatabaseApi : Any\n```\n\n----\n\n\n Base class representing the underlying database to which connections are made\n and on which transaction tasks are performed.\n\n @param config Configuration holding all parameters that apply to a transaction using this database instance.\n
//                                   ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#`<init>`().
//                                               display_name DatabaseApi
//                                               documentation ```kotlin\nprotected constructor(resolvedVendor: String? = ..., config: DatabaseConfig): DatabaseApi\n```
    protected val resolvedVendor: String? = null,
//                ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#`<init>`().(resolvedVendor)
//                               display_name resolvedVendor
//                               documentation ```kotlin\nresolvedVendor: String? = ...\n```
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#`<init>`().(resolvedVendor)
//                ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getResolvedVendor().
//                               display_name resolvedVendor
//                               documentation ```kotlin\nprotected get(): String?\n```
//                ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#resolvedVendor.
//                               display_name resolvedVendor
//                               documentation ```kotlin\nprotected final val resolvedVendor: String?\n```
//                                ^^^^^^^ reference semanticdb maven . . kotlin/String#
    val config: DatabaseConfig
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#`<init>`().(config)
//             display_name config
//             documentation ```kotlin\nconfig: DatabaseConfig\n```
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#`<init>`().(config)
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#config.
//             display_name config
//             documentation ```kotlin\npublic final val config: DatabaseConfig\n```
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getConfig().
//             display_name config
//             documentation ```kotlin\npublic get(): DatabaseConfig\n```
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#
) {
    /** Whether nested transaction blocks are configured to act like top-level transactions. */
    val useNestedTransactions: Boolean = config.useNestedTransactions
//      ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getUseNestedTransactions().
//                            display_name useNestedTransactions
//                            documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether nested transaction blocks are configured to act like top-level transactions.
//      ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#useNestedTransactions.
//                            display_name useNestedTransactions
//                            documentation ```kotlin\npublic final val useNestedTransactions: Boolean\n```\n\n----\n\n Whether nested transaction blocks are configured to act like top-level transactions.
//                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#config.
//                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getConfig().
//                                              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getUseNestedTransactions().
//                                              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#useNestedTransactions.

    override fun toString(): String =
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#toString().
//                        display_name toString
//                        documentation ```kotlin\npublic open override fun toString(): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
        "ExposedDatabase[${hashCode()}]($resolvedVendor${config.explicitDialect?.let { ", dialect=$it" } ?: ""})"
//                         ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().
//                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getResolvedVendor().
//                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#resolvedVendor.
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#config.
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getConfig().
//                                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#explicitDialect.
//                                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getExplicitDialect().
//                                                                               ^^^ reference semanticdb maven . . kotlin/let().
//                                                                                   ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                       display_name it
//                                                                                                       documentation ```kotlin\nit: DatabaseDialect\n```
//                                                                                                 ^^ reference semanticdb maven . . (it)

    /** The connection URL for the database. */
    abstract val url: String
//               ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getUrl().
//                   display_name url
//                   documentation ```kotlin\npublic get(): String\n```\n\n----\n\n The connection URL for the database.
//               ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#url.
//                   display_name url
//                   documentation ```kotlin\npublic abstract val url: String\n```\n\n----\n\n The connection URL for the database.
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#

    /** The name of the database based on the name of the underlying driver implementation. */
    abstract val vendor: String
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getVendor().
//                      display_name vendor
//                      documentation ```kotlin\npublic get(): String\n```\n\n----\n\n The name of the database based on the name of the underlying driver implementation.
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#vendor.
//                      display_name vendor
//                      documentation ```kotlin\npublic abstract val vendor: String\n```\n\n----\n\n The name of the database based on the name of the underlying driver implementation.
//                       ^^^^^^ reference semanticdb maven . . kotlin/String#

    /** The name of the database as a [DatabaseDialect]. */
    abstract val dialect: DatabaseDialect
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                       display_name dialect
//                       documentation ```kotlin\npublic abstract val dialect: DatabaseDialect\n```\n\n----\n\n The name of the database as a [DatabaseDialect].
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
//                       display_name dialect
//                       documentation ```kotlin\npublic get(): DatabaseDialect\n```\n\n----\n\n The name of the database as a [DatabaseDialect].
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#

    /** The mode of the database. This currently only applies to H2 databases. */
    abstract val dialectMode: String?
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialectMode.
//                           display_name dialectMode
//                           documentation ```kotlin\npublic abstract val dialectMode: String?\n```\n\n----\n\n The mode of the database. This currently only applies to H2 databases.
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialectMode().
//                           display_name dialectMode
//                           documentation ```kotlin\npublic get(): String?\n```\n\n----\n\n The mode of the database. This currently only applies to H2 databases.
//                            ^^^^^^^ reference semanticdb maven . . kotlin/String#

    /** The version number of the database as a [Version]. */
    abstract val version: Version
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getVersion().
//                       display_name version
//                       documentation ```kotlin\npublic get(): Version\n```\n\n----\n\n The version number of the database as a [Version].
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#version.
//                       display_name version
//                       documentation ```kotlin\npublic abstract val version: Version\n```\n\n----\n\n The version number of the database as a [Version].
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#

    /** The full version number of the database as a String. */
    abstract val fullVersion: String
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#fullVersion.
//                           display_name fullVersion
//                           documentation ```kotlin\npublic abstract val fullVersion: String\n```\n\n----\n\n The full version number of the database as a String.
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getFullVersion().
//                           display_name fullVersion
//                           documentation ```kotlin\npublic get(): String\n```\n\n----\n\n The full version number of the database as a String.
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#

    /** Whether the database supports ALTER TABLE with an add column clause. */
    abstract val supportsAlterTableWithAddColumn: Boolean
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getSupportsAlterTableWithAddColumn().
//                                               display_name supportsAlterTableWithAddColumn
//                                               documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether the database supports ALTER TABLE with an add column clause.
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#supportsAlterTableWithAddColumn.
//                                               display_name supportsAlterTableWithAddColumn
//                                               documentation ```kotlin\npublic abstract val supportsAlterTableWithAddColumn: Boolean\n```\n\n----\n\n Whether the database supports ALTER TABLE with an add column clause.
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    /** Whether the database supports ALTER TABLE with a drop column clause. */
    abstract val supportsAlterTableWithDropColumn: Boolean
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getSupportsAlterTableWithDropColumn().
//                                                display_name supportsAlterTableWithDropColumn
//                                                documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether the database supports ALTER TABLE with a drop column clause.
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#supportsAlterTableWithDropColumn.
//                                                display_name supportsAlterTableWithDropColumn
//                                                documentation ```kotlin\npublic abstract val supportsAlterTableWithDropColumn: Boolean\n```\n\n----\n\n Whether the database supports ALTER TABLE with a drop column clause.
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    /** Whether the database supports getting multiple result sets from a single execute. */
    abstract val supportsMultipleResultSets: Boolean
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getSupportsMultipleResultSets().
//                                          display_name supportsMultipleResultSets
//                                          documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether the database supports getting multiple result sets from a single execute.
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#supportsMultipleResultSets.
//                                          display_name supportsMultipleResultSets
//                                          documentation ```kotlin\npublic abstract val supportsMultipleResultSets: Boolean\n```\n\n----\n\n Whether the database supports getting multiple result sets from a single execute.
//                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    /** The database-specific class responsible for parsing and processing identifier tokens in SQL syntax. */
    abstract val identifierManager: IdentifierManagerApi
//               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                                 display_name identifierManager
//                                 documentation ```kotlin\npublic get(): IdentifierManagerApi\n```\n\n----\n\n The database-specific class responsible for parsing and processing identifier tokens in SQL syntax.
//               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
//                                 display_name identifierManager
//                                 documentation ```kotlin\npublic abstract val identifierManager: IdentifierManagerApi\n```\n\n----\n\n The database-specific class responsible for parsing and processing identifier tokens in SQL syntax.
//                                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#

    /** The default number of results that should be fetched when queries are executed. */
    var defaultFetchSize: Int? = config.defaultFetchSize
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#defaultFetchSize.
//                       display_name defaultFetchSize
//                       documentation ```kotlin\npublic final var defaultFetchSize: Int?\n```\n\n----\n\n The default number of results that should be fetched when queries are executed.
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDefaultFetchSize().
//                       display_name defaultFetchSize
//                       documentation ```kotlin\npublic get(): Int?\n```\n\n----\n\n The default number of results that should be fetched when queries are executed.
//                        ^^^^ reference semanticdb maven . . kotlin/Int#
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#config.
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getConfig().
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#defaultFetchSize.
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getDefaultFetchSize().
        private set
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#setDefaultFetchSize().(value)
//                  display_name value
//                  documentation ```kotlin\nvalue: Int?\n```
//              ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#setDefaultFetchSize().
//                  display_name defaultFetchSize
//                  documentation ```kotlin\nprivate set(value: Int?): Unit\n```

    companion object {
//  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#Companion# 10:5
//                     display_name Companion
//                     documentation ```kotlin\npublic final companion object Companion : Any\n```\n\n----\n\n Registers a new [DatabaseDialect] with the identifier [prefix].
//  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#Companion#`<init>`(). 10:5
//                     display_name Companion
//                     documentation ```kotlin\nprivate constructor(): DatabaseApi.Companion\n```\n\n----\n\n Registers a new [DatabaseDialect] with the identifier [prefix].
        // TODO Assess whether concurrent hash map is actually needed
        @InternalApi // how to avoid this
        val dialects = ConcurrentHashMap<String, () -> DatabaseDialect>()
//          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#Companion#dialects.
//                   display_name dialects
//                   documentation ```kotlin\n@InternalApi() public final val dialects: ConcurrentHashMap<String, Function0<DatabaseDialect>>\n```
//          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#Companion#getDialects().
//                   display_name dialects
//                   documentation ```kotlin\npublic get(): ConcurrentHashMap<String, Function0<DatabaseDialect>>\n```
//                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#`<init>`().

        /** Registers a new [DatabaseDialect] with the identifier [prefix]. */
        fun registerDialect(prefix: String, dialect: () -> DatabaseDialect) {
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#Companion#registerDialect().
//                          display_name registerDialect
//                          documentation ```kotlin\npublic final fun registerDialect(prefix: String, dialect: () -> DatabaseDialect): Unit\n```\n\n----\n\n Registers a new [DatabaseDialect] with the identifier [prefix].
//                          ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#Companion#registerDialect().(prefix)
//                                 display_name prefix
//                                 documentation ```kotlin\nprefix: String\n```
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#Companion#registerDialect().(dialect)
//                                                  display_name dialect
//                                                  documentation ```kotlin\ndialect: () -> DatabaseDialect\n```
//                                                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function0#
            @OptIn(InternalApi::class)
            dialects[prefix.lowercase()] = dialect
//          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#Companion#dialects.
//          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#Companion#getDialects().
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#Companion#registerDialect().(prefix)
//                          ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
//                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#Companion#registerDialect().(dialect)
        }
    }
}
