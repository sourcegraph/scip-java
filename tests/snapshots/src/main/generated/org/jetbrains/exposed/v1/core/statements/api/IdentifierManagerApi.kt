package org.jetbrains.exposed.v1.core.statements.api
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/

import org.jetbrains.exposed.v1.core.InternalApi
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/InternalApi#
import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#
import org.jetbrains.exposed.v1.core.vendors.ANSI_SQL_2003_KEYWORDS
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ANSI_SQL_2003_KEYWORDS.
import org.jetbrains.exposed.v1.core.vendors.VENDORS_KEYWORDS
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VENDORS_KEYWORDS.
import org.jetbrains.exposed.v1.core.vendors.currentDialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.

/** Base class responsible for the parsing and processing of identifier tokens in SQL command syntax. */
abstract class IdentifierManagerApi {
//             ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#
//                                  display_name IdentifierManagerApi
//                                  documentation ```kotlin\npublic abstract class IdentifierManagerApi : Any\n```\n\n----\n\n Base class responsible for the parsing and processing of identifier tokens in SQL command syntax.
//             ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#`<init>`().
//                                  display_name IdentifierManagerApi
//                                  documentation ```kotlin\npublic constructor(): IdentifierManagerApi\n```\n\n----\n\n Base class responsible for the parsing and processing of identifier tokens in SQL command syntax.
    /** The string used to quote SQL identifiers for the database. */
    abstract val quoteString: String
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getQuoteString().
//                           display_name quoteString
//                           documentation ```kotlin\npublic get(): String\n```\n\n----\n\n The string used to quote SQL identifiers for the database.
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteString.
//                           display_name quoteString
//                           documentation ```kotlin\npublic abstract val quoteString: String\n```\n\n----\n\n The string used to quote SQL identifiers for the database.
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#

    /** Whether the database treats mixed case unquoted identifiers as case-insensitive and stores them in upper case. */
    protected abstract val isUpperCaseIdentifiers: Boolean
//                         ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getIsUpperCaseIdentifiers().
//                                                display_name isUpperCaseIdentifiers
//                                                documentation ```kotlin\nprotected get(): Boolean\n```\n\n----\n\n Whether the database treats mixed case unquoted identifiers as case-insensitive and stores them in upper case.
//                         ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isUpperCaseIdentifiers.
//                                                display_name isUpperCaseIdentifiers
//                                                documentation ```kotlin\nprotected abstract val isUpperCaseIdentifiers: Boolean\n```\n\n----\n\n Whether the database treats mixed case unquoted identifiers as case-insensitive and stores them in upper case.
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    /** Whether the database treats mixed case quoted identifiers as case-insensitive and stores them in upper case. */
    protected abstract val isUpperCaseQuotedIdentifiers: Boolean
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getIsUpperCaseQuotedIdentifiers().
//                                                      display_name isUpperCaseQuotedIdentifiers
//                                                      documentation ```kotlin\nprotected get(): Boolean\n```\n\n----\n\n Whether the database treats mixed case quoted identifiers as case-insensitive and stores them in upper case.
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isUpperCaseQuotedIdentifiers.
//                                                      display_name isUpperCaseQuotedIdentifiers
//                                                      documentation ```kotlin\nprotected abstract val isUpperCaseQuotedIdentifiers: Boolean\n```\n\n----\n\n Whether the database treats mixed case quoted identifiers as case-insensitive and stores them in upper case.
//                                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    /** Whether the database treats mixed case unquoted identifiers as case-insensitive and stores them in lower case. */
    protected abstract val isLowerCaseIdentifiers: Boolean
//                         ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getIsLowerCaseIdentifiers().
//                                                display_name isLowerCaseIdentifiers
//                                                documentation ```kotlin\nprotected get(): Boolean\n```\n\n----\n\n Whether the database treats mixed case unquoted identifiers as case-insensitive and stores them in lower case.
//                         ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isLowerCaseIdentifiers.
//                                                display_name isLowerCaseIdentifiers
//                                                documentation ```kotlin\nprotected abstract val isLowerCaseIdentifiers: Boolean\n```\n\n----\n\n Whether the database treats mixed case unquoted identifiers as case-insensitive and stores them in lower case.
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    /** Whether the database treats mixed case quoted identifiers as case-insensitive and stores them in lower case. */
    protected abstract val isLowerCaseQuotedIdentifiers: Boolean
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getIsLowerCaseQuotedIdentifiers().
//                                                      display_name isLowerCaseQuotedIdentifiers
//                                                      documentation ```kotlin\nprotected get(): Boolean\n```\n\n----\n\n Whether the database treats mixed case quoted identifiers as case-insensitive and stores them in lower case.
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isLowerCaseQuotedIdentifiers.
//                                                      display_name isLowerCaseQuotedIdentifiers
//                                                      documentation ```kotlin\nprotected abstract val isLowerCaseQuotedIdentifiers: Boolean\n```\n\n----\n\n Whether the database treats mixed case quoted identifiers as case-insensitive and stores them in lower case.
//                                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    /** Whether the database treats and stores mixed case unquoted identifiers as case-sensitive. */
    protected abstract val supportsMixedIdentifiers: Boolean
//                         ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getSupportsMixedIdentifiers().
//                                                  display_name supportsMixedIdentifiers
//                                                  documentation ```kotlin\nprotected get(): Boolean\n```\n\n----\n\n Whether the database treats and stores mixed case unquoted identifiers as case-sensitive.
//                         ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#supportsMixedIdentifiers.
//                                                  display_name supportsMixedIdentifiers
//                                                  documentation ```kotlin\nprotected abstract val supportsMixedIdentifiers: Boolean\n```\n\n----\n\n Whether the database treats and stores mixed case unquoted identifiers as case-sensitive.
//                                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    /** Whether the database treats and stores mixed case quoted identifiers as case-sensitive. */
    protected abstract val supportsMixedQuotedIdentifiers: Boolean
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getSupportsMixedQuotedIdentifiers().
//                                                        display_name supportsMixedQuotedIdentifiers
//                                                        documentation ```kotlin\nprotected get(): Boolean\n```\n\n----\n\n Whether the database treats and stores mixed case quoted identifiers as case-sensitive.
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#supportsMixedQuotedIdentifiers.
//                                                        display_name supportsMixedQuotedIdentifiers
//                                                        documentation ```kotlin\nprotected abstract val supportsMixedQuotedIdentifiers: Boolean\n```\n\n----\n\n Whether the database treats and stores mixed case quoted identifiers as case-sensitive.
//                                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    /** Returns all keywords for the database beyond the [ANSI_SQL_2003_KEYWORDS]. */
    protected abstract fun dbKeywords(): List<String>
//                         ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#dbKeywords().
//                                    display_name dbKeywords
//                                    documentation ```kotlin\nprotected abstract fun dbKeywords(): List<String>\n\n```\n\n----\n\n Returns all keywords for the database beyond the [ANSI_SQL_2003_KEYWORDS].
//                                       ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#

    /** All keywords for the database, including [ANSI_SQL_2003_KEYWORDS] and database-specific keywords. */
    val keywords by lazy {
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getKeywords().
//               display_name keywords
//               documentation ```kotlin\npublic get(): Set<String>\n```\n\n----\n\n All keywords for the database, including [ANSI_SQL_2003_KEYWORDS] and database-specific keywords.
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#keywords.
//               display_name keywords
//               documentation ```kotlin\npublic final val keywords: Set<String>\n```\n\n----\n\n All keywords for the database, including [ANSI_SQL_2003_KEYWORDS] and database-specific keywords.
//                  ^^^^ reference semanticdb maven . . kotlin/lazy().
//                  ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 2:5
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getKeywords(). 2:5
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#keywords. 2:5
        ANSI_SQL_2003_KEYWORDS + VENDORS_KEYWORDS[currentDialect.name].orEmpty() + dbKeywords()
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ANSI_SQL_2003_KEYWORDS.
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getANSI_SQL_2003_KEYWORDS().
//                             ^ reference semanticdb maven . . kotlin/collections/plus(+42).
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VENDORS_KEYWORDS.
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getVENDORS_KEYWORDS().
//                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
//                                                                     ^^^^^^^ reference semanticdb maven . . kotlin/collections/orEmpty(+2).
//                                                                               ^ reference semanticdb maven . . kotlin/collections/plus(+42).
//                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#dbKeywords().
    }

    /** The database-specific special characters that can be additionally used in unquoted identifiers. */
    protected abstract val extraNameCharacters: String
//                         ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#extraNameCharacters.
//                                             display_name extraNameCharacters
//                                             documentation ```kotlin\nprotected abstract val extraNameCharacters: String\n```\n\n----\n\n The database-specific special characters that can be additionally used in unquoted identifiers.
//                         ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getExtraNameCharacters().
//                                             display_name extraNameCharacters
//                                             documentation ```kotlin\nprotected get(): String\n```\n\n----\n\n The database-specific special characters that can be additionally used in unquoted identifiers.
//                                              ^^^^^^ reference semanticdb maven . . kotlin/String#

    /** The [OracleVersion] of the database, if Oracle is the underlying DBMS; otherwise, [OracleVersion.NonOracle]. */
    protected abstract val oracleVersion: OracleVersion
//                         ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getOracleVersion().
//                                       display_name oracleVersion
//                                       documentation ```kotlin\nprotected get(): IdentifierManagerApi.OracleVersion\n```\n\n----\n\n The [OracleVersion] of the database, if Oracle is the underlying DBMS; otherwise, [OracleVersion.NonOracle].
//                         ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#oracleVersion.
//                                       display_name oracleVersion
//                                       documentation ```kotlin\nprotected abstract val oracleVersion: IdentifierManagerApi.OracleVersion\n```\n\n----\n\n The [OracleVersion] of the database, if Oracle is the underlying DBMS; otherwise, [OracleVersion.NonOracle].
//                                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#OracleVersion#

    /** The maximum number of characters in a column name allowed by the database. */
    protected abstract val maxColumnNameLength: Int
//                         ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getMaxColumnNameLength().
//                                             display_name maxColumnNameLength
//                                             documentation ```kotlin\nprotected get(): Int\n```\n\n----\n\n The maximum number of characters in a column name allowed by the database.
//                         ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#maxColumnNameLength.
//                                             display_name maxColumnNameLength
//                                             documentation ```kotlin\nprotected abstract val maxColumnNameLength: Int\n```\n\n----\n\n The maximum number of characters in a column name allowed by the database.
//                                              ^^^ reference semanticdb maven . . kotlin/Int#

    /** Oracle version number classifier. */
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Enum# 1:90
    protected enum class OracleVersion { Oracle11g, Oracle12_1g, Oracle12plus, NonOracle }
//                       ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#OracleVersion#
//                                     display_name OracleVersion
//                                     documentation ```kotlin\nprotected final enum class OracleVersion : Enum<IdentifierManagerApi.OracleVersion>\n```\n\n----\n\n Oracle version number classifier.
//                                     relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//                       ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#OracleVersion#`<init>`().
//                                     display_name OracleVersion
//                                     documentation ```kotlin\nprivate constructor(): IdentifierManagerApi.OracleVersion\n```\n\n----\n\n Oracle version number classifier.
//                       ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#OracleVersion#entries.
//                                     display_name entries
//                                     documentation ```kotlin\npublic final static val entries: EnumEntries<IdentifierManagerApi.OracleVersion>\n```\n\n----\n\n Oracle version number classifier.
//                       ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#OracleVersion#valueOf().
//                                     display_name valueOf
//                                     documentation ```kotlin\npublic final static fun valueOf(value: String): IdentifierManagerApi.OracleVersion\n```\n\n----\n\n Oracle version number classifier.
//                       ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#OracleVersion#valueOf().(value)
//                                     display_name value
//                                     documentation ```kotlin\nvalue: String\n```\n\n----\n\n Oracle version number classifier.
//                       ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#OracleVersion#values().
//                                     display_name values
//                                     documentation ```kotlin\npublic final static fun values(): Array<IdentifierManagerApi.OracleVersion>\n```\n\n----\n\n Oracle version number classifier.
//                       ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/getEntries().
//                                     display_name entries
//                                     documentation ```kotlin\npublic get(): EnumEntries<IdentifierManagerApi.OracleVersion>\n```\n\n----\n\n Oracle version number classifier.

    /** The maximum number of characters in an identifier allowed by the database. */
    protected val identifierLengthLimit by lazy {
//                ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getIdentifierLengthLimit().
//                                      display_name identifierLengthLimit
//                                      documentation ```kotlin\nprotected get(): Int\n```\n\n----\n\n The maximum number of characters in an identifier allowed by the database.
//                ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#identifierLengthLimit.
//                                      display_name identifierLengthLimit
//                                      documentation ```kotlin\nprotected final val identifierLengthLimit: Int\n```\n\n----\n\n The maximum number of characters in an identifier allowed by the database.
//                                         ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                         ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 7:5
//                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getIdentifierLengthLimit(). 7:5
//                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#identifierLengthLimit. 7:5
        @Suppress("MagicNumber")
        when (oracleVersion) {
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getOracleVersion().
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#oracleVersion.
            OracleVersion.Oracle11g, OracleVersion.Oracle12_1g -> 30
//                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#OracleVersion#Oracle11g.
//                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#OracleVersion#Oracle12_1g.
            OracleVersion.Oracle12plus -> 128
//                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#OracleVersion#Oracle12plus.
            else -> maxColumnNameLength.takeIf { it > 0 } ?: Int.MAX_VALUE
//                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getMaxColumnNameLength().
//                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#maxColumnNameLength.
//                                      ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                             ^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                        display_name it
//                                                        documentation ```kotlin\nit: String\n```
//                                               ^^ reference semanticdb maven . . (it)
//                                                  ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
        }
    }

    private val checkedIdentitiesCache = IdentifiersCache<Boolean>()
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#checkedIdentitiesCache.
//                                     display_name checkedIdentitiesCache
//                                     documentation ```kotlin\nprivate final val checkedIdentitiesCache: IdentifiersCache<Boolean>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getCheckedIdentitiesCache().
//                                     display_name checkedIdentitiesCache
//                                     documentation ```kotlin\nprivate get(): IdentifiersCache<Boolean>\n```
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#`<init>`().
    private val checkedKeywordsCache = IdentifiersCache<Boolean>()
//              ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#checkedKeywordsCache.
//                                   display_name checkedKeywordsCache
//                                   documentation ```kotlin\nprivate final val checkedKeywordsCache: IdentifiersCache<Boolean>\n```
//              ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getCheckedKeywordsCache().
//                                   display_name checkedKeywordsCache
//                                   documentation ```kotlin\nprivate get(): IdentifiersCache<Boolean>\n```
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#`<init>`().
    private val shouldQuoteIdentifiersCache = IdentifiersCache<Boolean>()
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getShouldQuoteIdentifiersCache().
//                                          display_name shouldQuoteIdentifiersCache
//                                          documentation ```kotlin\nprivate get(): IdentifiersCache<Boolean>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldQuoteIdentifiersCache.
//                                          display_name shouldQuoteIdentifiersCache
//                                          documentation ```kotlin\nprivate final val shouldQuoteIdentifiersCache: IdentifiersCache<Boolean>\n```
//                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#`<init>`().
    private val identifiersInProperCaseCache = IdentifiersCache<String>()
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getIdentifiersInProperCaseCache().
//                                           display_name identifiersInProperCaseCache
//                                           documentation ```kotlin\nprivate get(): IdentifiersCache<String>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#identifiersInProperCaseCache.
//                                           display_name identifiersInProperCaseCache
//                                           documentation ```kotlin\nprivate final val identifiersInProperCaseCache: IdentifiersCache<String>\n```
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#`<init>`().
    private val quotedIdentifiersCache = IdentifiersCache<String>()
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getQuotedIdentifiersCache().
//                                     display_name quotedIdentifiersCache
//                                     documentation ```kotlin\nprivate get(): IdentifiersCache<String>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quotedIdentifiersCache.
//                                     display_name quotedIdentifiersCache
//                                     documentation ```kotlin\nprivate final val quotedIdentifiersCache: IdentifiersCache<String>\n```
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#`<init>`().

    private fun String.isIdentifier() = isNotEmpty() && first().isIdentifierStart() && all { it.isIdentifierStart() || it in '0'..'9' }
//                     ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isIdentifier().
//                                  display_name isIdentifier
//                                  documentation ```kotlin\nprivate final fun String.isIdentifier(): Boolean\n```
//                                      ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/isNotEmpty().
//                                                      ^^^^^ reference semanticdb maven . . kotlin/text/first().
//                                                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isIdentifierStart().
//                                                                                     ^^^ reference semanticdb maven . . kotlin/text/all().
//                                                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                                      display_name it
//                                                                                                                                      documentation ```kotlin\nit: String\n```
//                                                                                           ^^ reference semanticdb maven . . (it)
//                                                                                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isIdentifierStart().
//                                                                                                                     ^^ reference semanticdb maven . . (it)
//                                                                                                                        ^^ reference semanticdb maven . . kotlin/ranges/CharRange#contains().
//                                                                                                                              ^^ reference semanticdb maven . . kotlin/Char#rangeTo().
    private fun Char.isIdentifierStart(): Boolean = this in 'a'..'z' || this in 'A'..'Z' || this == '_' || this in extraNameCharacters
//                   ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isIdentifierStart().
//                                     display_name isIdentifierStart
//                                     documentation ```kotlin\nprivate final fun Char.isIdentifierStart(): Boolean\n```
//                                        ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                       ^^ reference semanticdb maven . . kotlin/ranges/CharRange#contains().
//                                                             ^^ reference semanticdb maven . . kotlin/Char#rangeTo().
//                                                                           ^^ reference semanticdb maven . . kotlin/ranges/CharRange#contains().
//                                                                                 ^^ reference semanticdb maven . . kotlin/Char#rangeTo().
//                                                                                                              ^^ reference semanticdb maven . . kotlin/text/contains(+1).
//                                                                                                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#extraNameCharacters.
//                                                                                                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getExtraNameCharacters().

    private fun String.isAKeyword(): Boolean = checkedKeywordsCache.getOrPut(lowercase()) {
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isAKeyword().
//                                display_name isAKeyword
//                                documentation ```kotlin\nprivate final fun String.isAKeyword(): Boolean\n```
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#checkedKeywordsCache.
//                                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getCheckedKeywordsCache().
//                                                                  ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getOrPut(+1).
//                                                                           ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
        keywords.any { this.equals(it, true) }
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getKeywords().
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#keywords.
//               ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                             display_name it
//                                             documentation ```kotlin\nit: String\n```
//                          ^^^^^^ reference semanticdb maven . . kotlin/text/equals(+1).
//                                 ^^ reference semanticdb maven . . (it)
    }

    @Deprecated(
        message = "This will be removed in future releases when the opt-out flag is removed in DatabaseConfig",
        level = DeprecationLevel.WARNING
//                               ^^^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#WARNING.
    )
    @OptIn(InternalApi::class)
    private val shouldPreserveKeywordCasing by lazy {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getShouldPreserveKeywordCasing().
//                                          display_name shouldPreserveKeywordCasing
//                                          documentation ```kotlin\nprivate get(): Boolean\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldPreserveKeywordCasing.
//                                          display_name shouldPreserveKeywordCasing
//                                          documentation ```kotlin\n@Deprecated(...) @OptIn(...) private final val shouldPreserveKeywordCasing: Boolean\n```
//                                             ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                             ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 2:5
//                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getShouldPreserveKeywordCasing(). 2:5
//                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldPreserveKeywordCasing. 2:5
        CoreTransactionManager.currentTransactionOrNull()?.db?.config?.preserveKeywordCasing == true
//                             ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransactionOrNull().
//                                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#config.
//                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getConfig().
//                                                                     ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#getPreserveKeywordCasing().
//                                                                     ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseConfig#preserveKeywordCasing.
    }

    /** Returns whether an SQL token should be wrapped in quotations and caches the returned value. */
    fun needQuotes(identity: String): Boolean {
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#needQuotes().
//                 display_name needQuotes
//                 documentation ```kotlin\npublic final fun needQuotes(identity: String): Boolean\n```\n\n----\n\n Returns whether an SQL token should be wrapped in quotations and caches the returned value.
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#needQuotes().(identity)
//                          display_name identity
//                          documentation ```kotlin\nidentity: String\n```
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        return checkedIdentitiesCache.getOrPut(identity.lowercase()) {
//             ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#checkedIdentitiesCache.
//             ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getCheckedIdentitiesCache().
//                                    ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getOrPut(+1).
//                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#needQuotes().(identity)
//                                                      ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
            !identity.isAlreadyQuoted() && (identity.isAKeyword() || !identity.isIdentifier())
//          ^ reference semanticdb maven . . kotlin/Boolean#not().
//           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#needQuotes().(identity)
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isAlreadyQuoted().
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#needQuotes().(identity)
//                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isAKeyword().
//                                                                   ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#needQuotes().(identity)
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isIdentifier().
        }
    }

    private fun String.isAlreadyQuoted() = startsWith(quoteString) && endsWith(quoteString)
//                     ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isAlreadyQuoted().
//                                     display_name isAlreadyQuoted
//                                     documentation ```kotlin\nprivate final fun String.isAlreadyQuoted(): Boolean\n```
//                                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getQuoteString().
//                                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteString.
//                                                                    ^^^^^^^^ reference semanticdb maven . . kotlin/text/endsWith().
//                                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getQuoteString().
//                                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteString.

    /** Returns whether an [identity] should be wrapped in quotations and caches the returned value. */
    fun shouldQuoteIdentifier(identity: String): Boolean = shouldQuoteIdentifiersCache.getOrPut(identity) {
//      ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldQuoteIdentifier().
//                            display_name shouldQuoteIdentifier
//                            documentation ```kotlin\npublic final fun shouldQuoteIdentifier(identity: String): Boolean\n```\n\n----\n\n Returns whether an [identity] should be wrapped in quotations and caches the returned value.
//                            ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldQuoteIdentifier().(identity)
//                                     display_name identity
//                                     documentation ```kotlin\nidentity: String\n```
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getShouldQuoteIdentifiersCache().
//                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldQuoteIdentifiersCache.
//                                                                                     ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getOrPut(+1).
//                                                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldQuoteIdentifier().(identity)
        val alreadyQuoted = identity.isAlreadyQuoted()
//          ^^^^^^^^^^^^^ definition local 0
//                        display_name alreadyQuoted
//                        documentation ```kotlin\nlocal val alreadyQuoted: Boolean\n```
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldQuoteIdentifier().(identity)
//                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isAlreadyQuoted().
        val alreadyLower = identity == identity.lowercase()
//          ^^^^^^^^^^^^ definition local 1
//                       display_name alreadyLower
//                       documentation ```kotlin\nlocal val alreadyLower: Boolean\n```
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldQuoteIdentifier().(identity)
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldQuoteIdentifier().(identity)
//                                              ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
        val alreadyUpper = identity == identity.uppercase()
//          ^^^^^^^^^^^^ definition local 2
//                       display_name alreadyUpper
//                       documentation ```kotlin\nlocal val alreadyUpper: Boolean\n```
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldQuoteIdentifier().(identity)
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldQuoteIdentifier().(identity)
//                                              ^^^^^^^^^ reference semanticdb maven . . kotlin/text/uppercase(+2).
        when {
            alreadyQuoted -> false
//          ^^^^^^^^^^^^^ reference local 0
            identity.isAKeyword() && shouldPreserveKeywordCasing -> true
//          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldQuoteIdentifier().(identity)
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isAKeyword().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getShouldPreserveKeywordCasing().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldPreserveKeywordCasing.
            supportsMixedIdentifiers -> false
//          ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getSupportsMixedIdentifiers().
//          ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#supportsMixedIdentifiers.
            alreadyLower && isLowerCaseIdentifiers -> false
//          ^^^^^^^^^^^^ reference local 1
//                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getIsLowerCaseIdentifiers().
//                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isLowerCaseIdentifiers.
            alreadyUpper && isUpperCaseIdentifiers -> false
//          ^^^^^^^^^^^^ reference local 2
//                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getIsUpperCaseIdentifiers().
//                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isUpperCaseIdentifiers.
            oracleVersion != OracleVersion.NonOracle -> false
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getOracleVersion().
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#oracleVersion.
//                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#OracleVersion#NonOracle.
            supportsMixedQuotedIdentifiers && (!alreadyLower && !alreadyUpper) -> true
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getSupportsMixedQuotedIdentifiers().
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#supportsMixedQuotedIdentifiers.
//                                             ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                              ^^^^^^^^^^^^ reference local 1
//                                                              ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                               ^^^^^^^^^^^^ reference local 2
            else -> false
        }
    }

    /**
     * Returns an [identity] in a casing appropriate for its identifier status and the database,
     * then caches the returned value.
     */
    fun inProperCase(identity: String): String = identifiersInProperCaseCache.getOrPut(identity) {
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().
//                   display_name inProperCase
//                   documentation ```kotlin\npublic final fun inProperCase(identity: String): String\n```\n\n----\n\n\n Returns an [identity] in a casing appropriate for its identifier status and the database,\n then caches the returned value.\n
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().(identity)
//                            display_name identity
//                            documentation ```kotlin\nidentity: String\n```
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getIdentifiersInProperCaseCache().
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#identifiersInProperCaseCache.
//                                                                            ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getOrPut(+1).
//                                                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().(identity)
        val alreadyQuoted = identity.isAlreadyQuoted()
//          ^^^^^^^^^^^^^ definition local 3
//                        display_name alreadyQuoted
//                        documentation ```kotlin\nlocal val alreadyQuoted: Boolean\n```
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().(identity)
//                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isAlreadyQuoted().
        when {
            alreadyQuoted && supportsMixedQuotedIdentifiers -> identity
//          ^^^^^^^^^^^^^ reference local 3
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getSupportsMixedQuotedIdentifiers().
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#supportsMixedQuotedIdentifiers.
//                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().(identity)
            alreadyQuoted && isUpperCaseQuotedIdentifiers -> identity.uppercase()
//          ^^^^^^^^^^^^^ reference local 3
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getIsUpperCaseQuotedIdentifiers().
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isUpperCaseQuotedIdentifiers.
//                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().(identity)
//                                                                    ^^^^^^^^^ reference semanticdb maven . . kotlin/text/uppercase(+2).
            alreadyQuoted && isLowerCaseQuotedIdentifiers -> identity.lowercase()
//          ^^^^^^^^^^^^^ reference local 3
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getIsLowerCaseQuotedIdentifiers().
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isLowerCaseQuotedIdentifiers.
//                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().(identity)
//                                                                    ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
            supportsMixedIdentifiers -> identity
//          ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getSupportsMixedIdentifiers().
//          ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#supportsMixedIdentifiers.
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().(identity)
            identity.isAKeyword() && shouldPreserveKeywordCasing -> identity
//          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().(identity)
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isAKeyword().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getShouldPreserveKeywordCasing().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldPreserveKeywordCasing.
//                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().(identity)
            oracleVersion != OracleVersion.NonOracle -> identity.uppercase()
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getOracleVersion().
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#oracleVersion.
//                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#OracleVersion#NonOracle.
//                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().(identity)
//                                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/text/uppercase(+2).
            isUpperCaseIdentifiers -> identity.uppercase()
//          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getIsUpperCaseIdentifiers().
//          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isUpperCaseIdentifiers.
//                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().(identity)
//                                             ^^^^^^^^^ reference semanticdb maven . . kotlin/text/uppercase(+2).
            isLowerCaseIdentifiers -> identity.lowercase()
//          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getIsLowerCaseIdentifiers().
//          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isLowerCaseIdentifiers.
//                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().(identity)
//                                             ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
            else -> identity
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().(identity)
        }
    }

    /** Returns an SQL token wrapped in quotations, if validated as necessary. */
    fun quoteIfNecessary(identity: String): String {
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                       display_name quoteIfNecessary
//                       documentation ```kotlin\npublic final fun quoteIfNecessary(identity: String): String\n```\n\n----\n\n Returns an SQL token wrapped in quotations, if validated as necessary.
//                       ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().(identity)
//                                display_name identity
//                                documentation ```kotlin\nidentity: String\n```
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
        return if (isDotPrefixedAndUnquoted(identity)) {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isDotPrefixedAndUnquoted().
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().(identity)
            identity.split('.').joinToString(".") { quoteTokenIfNecessary(it) }
//          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().(identity)
//                   ^^^^^ reference semanticdb maven . . kotlin/text/split(+2).
//                              ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                              display_name it
//                                                                              documentation ```kotlin\nit: String\n```
//                                                  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteTokenIfNecessary().
//                                                                        ^^ reference semanticdb maven . . (it)
        } else {
            quoteTokenIfNecessary(identity)
//          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteTokenIfNecessary().
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().(identity)
        }
    }

    /** Returns whether an [identity] is both unquoted and contains dot characters. */
    fun isDotPrefixedAndUnquoted(identity: String): Boolean = identity.contains('.') && !identity.isAlreadyQuoted()
//      ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isDotPrefixedAndUnquoted().
//                               display_name isDotPrefixedAndUnquoted
//                               documentation ```kotlin\npublic final fun isDotPrefixedAndUnquoted(identity: String): Boolean\n```\n\n----\n\n Returns whether an [identity] is both unquoted and contains dot characters.
//                               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isDotPrefixedAndUnquoted().(identity)
//                                        display_name identity
//                                        documentation ```kotlin\nidentity: String\n```
//                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isDotPrefixedAndUnquoted().(identity)
//                                                                     ^^^^^^^^ reference semanticdb maven . . kotlin/text/contains(+1).
//                                                                                      ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isDotPrefixedAndUnquoted().(identity)
//                                                                                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#isAlreadyQuoted().

    /** Returns an [identity] wrapped in quotations, if validated as necessary. */
    fun quoteIdentifierWhenWrongCaseOrNecessary(identity: String): String {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIdentifierWhenWrongCaseOrNecessary().
//                                              display_name quoteIdentifierWhenWrongCaseOrNecessary
//                                              documentation ```kotlin\npublic final fun quoteIdentifierWhenWrongCaseOrNecessary(identity: String): String\n```\n\n----\n\n Returns an [identity] wrapped in quotations, if validated as necessary.
//                                              ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIdentifierWhenWrongCaseOrNecessary().(identity)
//                                                       display_name identity
//                                                       documentation ```kotlin\nidentity: String\n```
//                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
        val inProperCase = inProperCase(identity)
//          ^^^^^^^^^^^^ definition local 4
//                       display_name inProperCase
//                       documentation ```kotlin\nlocal val inProperCase: String\n```
//                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIdentifierWhenWrongCaseOrNecessary().(identity)
        return if (shouldQuoteIdentifier(identity) && inProperCase != identity) {
//                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#shouldQuoteIdentifier().
//                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIdentifierWhenWrongCaseOrNecessary().(identity)
//                                                    ^^^^^^^^^^^^ reference local 4
//                                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIdentifierWhenWrongCaseOrNecessary().(identity)
            quote(identity)
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quote().
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIdentifierWhenWrongCaseOrNecessary().(identity)
        } else {
            quoteIfNecessary(inProperCase)
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                           ^^^^^^^^^^^^ reference local 4
        }
    }

    /** Returns an [identity] wrapped in quotations and containing no more than the maximum [identifierLengthLimit]. */
    fun cutIfNecessaryAndQuote(identity: String) = quoteIfNecessary(identity.take(identifierLengthLimit))
//      ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                             display_name cutIfNecessaryAndQuote
//                             documentation ```kotlin\npublic final fun cutIfNecessaryAndQuote(identity: String): String\n```\n\n----\n\n Returns an [identity] wrapped in quotations and containing no more than the maximum [identifierLengthLimit].
//                             ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().(identity)
//                                      display_name identity
//                                      documentation ```kotlin\nidentity: String\n```
//                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().(identity)
//                                                                           ^^^^ reference semanticdb maven . . kotlin/text/take(+1).
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getIdentifierLengthLimit().
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#identifierLengthLimit.

    private fun quoteTokenIfNecessary(token: String): String = if (needQuotes(token)) quote(token) else token
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteTokenIfNecessary().
//                                    display_name quoteTokenIfNecessary
//                                    documentation ```kotlin\nprivate final fun quoteTokenIfNecessary(token: String): String\n```
//                                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteTokenIfNecessary().(token)
//                                          display_name token
//                                          documentation ```kotlin\ntoken: String\n```
//                                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#needQuotes().
//                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteTokenIfNecessary().(token)
//                                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quote().
//                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteTokenIfNecessary().(token)
//                                                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteTokenIfNecessary().(token)

    private fun quote(identity: String) = quotedIdentifiersCache.getOrPut(identity) { "$quoteString$identity$quoteString".trim() }
//              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quote().
//                    display_name quote
//                    documentation ```kotlin\nprivate final fun quote(identity: String): String\n```
//                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quote().(identity)
//                             display_name identity
//                             documentation ```kotlin\nidentity: String\n```
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getQuotedIdentifiersCache().
//                                        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quotedIdentifiersCache.
//                                                               ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getOrPut(+1).
//                                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quote().(identity)
//                                                                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getQuoteString().
//                                                                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteString.
//                                                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quote().(identity)
//                                                                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#getQuoteString().
//                                                                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteString.
//                                                                                                                        ^^^^ reference semanticdb maven . . kotlin/text/trim(+5).
}

private class IdentifiersCache<V : Any>(initialCapacity: Int = 100, private val cacheSize: Int = 1000) :
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#
//                             display_name IdentifiersCache
//                             documentation ```kotlin\nprivate final class IdentifiersCache<V : Any> : LinkedHashMap<String, V>\n```
//                             relationship is_reference is_implementation semanticdb maven jdk 11 java/util/LinkedHashMap#
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#`<init>`().
//                             display_name IdentifiersCache
//                             documentation ```kotlin\npublic constructor<V : Any>(initialCapacity: Int = ..., cacheSize: Int = ...): IdentifiersCache<V>\n```
//                             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#[V]
//                               display_name FirTypeParameterSymbol V
//                               documentation ```kotlin\nV : Any\n```
//                                      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#`<init>`().(initialCapacity)
//                                                      display_name initialCapacity
//                                                      documentation ```kotlin\ninitialCapacity: Int = ...\n```
//                                                       ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#`<init>`().(cacheSize)
//                                                                                        display_name cacheSize
//                                                                                        documentation ```kotlin\ncacheSize: Int = ...\n```
//                                                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#`<init>`().(cacheSize)
//                                                                              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#cacheSize.
//                                                                                        display_name cacheSize
//                                                                                        documentation ```kotlin\nprivate final val cacheSize: Int\n```
//                                                                              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#getCacheSize().
//                                                                                        display_name cacheSize
//                                                                                        documentation ```kotlin\nprivate get(): Int\n```
//                                                                                         ^^^ reference semanticdb maven . . kotlin/Int#
    java.util.LinkedHashMap<String, V>(initialCapacity) {
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashMap#
//                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#`<init>`().(initialCapacity)
    override fun removeEldestEntry(eldest: MutableMap.MutableEntry<String, V>?): Boolean = size >= cacheSize
//               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#removeEldestEntry().
//                                 display_name removeEldestEntry
//                                 documentation ```kotlin\nprotected open override fun removeEldestEntry(eldest: MutableMap.MutableEntry<String, V>?): Boolean\n```
//                                 relationship is_reference is_implementation semanticdb maven jdk 11 java/util/LinkedHashMap#removeEldestEntry().
//                                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#removeEldestEntry().(eldest)
//                                        display_name eldest
//                                        documentation ```kotlin\neldest: MutableMap.MutableEntry<String, V>?\n```
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#MutableEntry#
//                                                                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#size.
//                                                                                              ^^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#cacheSize.
//                                                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifiersCache#getCacheSize().
}
