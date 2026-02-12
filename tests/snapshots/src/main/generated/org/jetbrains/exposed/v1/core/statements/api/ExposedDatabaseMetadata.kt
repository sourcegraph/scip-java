  package org.jetbrains.exposed.v1.core.statements.api
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/
  
  import org.jetbrains.exposed.v1.core.InternalApi
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/InternalApi#
  import org.jetbrains.exposed.v1.core.ReferenceOption
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
  import org.jetbrains.exposed.v1.core.vendors.*
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
  import org.jetbrains.exposed.v1.core.vendors.H2Dialect.H2CompatibilityMode
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
//                                                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect/H2CompatibilityMode/
  import java.sql.Types
//       ^^^^ reference semanticdb maven . . java/
//            ^^^ reference semanticdb maven . . java/sql/
//                ^^^^^ reference semanticdb maven jdk 11 java/sql/Types#
  
  /**
   * Base class responsible for shared utility methods needed for retrieving and storing information about
   * the underlying driver and associated [database].
   */
  abstract class ExposedDatabaseMetadata(val database: String) {
//               ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#
//                                       display_name ExposedDatabaseMetadata
//                                       documentation ```kotlin\npublic abstract class ExposedDatabaseMetadata : Any\n```\n\n----\n\n\n Base class responsible for shared utility methods needed for retrieving and storing information about\n the underlying driver and associated [database].\n
//               ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#`<init>`().
//                                       display_name ExposedDatabaseMetadata
//                                       documentation ```kotlin\npublic constructor(database: String): ExposedDatabaseMetadata\n```
//                                           ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#`<init>`().(database)
//                                                    display_name database
//                                                    documentation ```kotlin\ndatabase: String\n```
//                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#`<init>`().(database)
//                                           ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#database.
//                                                    display_name database
//                                                    documentation ```kotlin\npublic final val database: String\n```
//                                           ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getDatabase().
//                                                    display_name database
//                                                    documentation ```kotlin\npublic get(): String\n```
//                                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
      /** Clears and resets any stored information about the database's current schema to default values. */
      abstract fun resetCurrentScheme()
//                 ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#resetCurrentScheme().
//                                    display_name resetCurrentScheme
//                                    documentation ```kotlin\npublic abstract fun resetCurrentScheme(): Unit\n\n```\n\n----\n\n Clears and resets any stored information about the database's current schema to default values.
  
      @Suppress("ForbiddenComment")
      // TODO: THIS should become protected after the usage in DatabaseDialect is fully deprecated
      /**
       * Returns the corresponding [ReferenceOption] for the specified [refOption] result,
       * or `null` if the database result is an invalid string without a corresponding match.
       */
      @InternalApi
      abstract fun resolveReferenceOption(refOption: String): ReferenceOption?
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#resolveReferenceOption().
//                                        display_name resolveReferenceOption
//                                        documentation ```kotlin\n@Suppress(...) @InternalApi() public abstract fun resolveReferenceOption(refOption: String): ReferenceOption?\n\n```\n\n----\n\n\n Returns the corresponding [ReferenceOption] for the specified [refOption] result,\n or `null` if the database result is an invalid string without a corresponding match.\n
//                                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#resolveReferenceOption().(refOption)
//                                                  display_name refOption
//                                                  documentation ```kotlin\nrefOption: String\n```
//                                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
  
      /** Clears any cached values. */
      abstract fun cleanCache()
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#cleanCache().
//                            display_name cleanCache
//                            documentation ```kotlin\npublic abstract fun cleanCache(): Unit\n\n```\n\n----\n\n Clears any cached values.
  
      /** The database-specific and metadata-reliant implementation of [IdentifierManagerApi]. */
      abstract val identifierManager: IdentifierManagerApi
//                 ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getIdentifierManager().
//                                   display_name identifierManager
//                                   documentation ```kotlin\npublic get(): IdentifierManagerApi\n```\n\n----\n\n The database-specific and metadata-reliant implementation of [IdentifierManagerApi].
//                 ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#identifierManager.
//                                   display_name identifierManager
//                                   documentation ```kotlin\npublic abstract val identifierManager: IdentifierManagerApi\n```\n\n----\n\n The database-specific and metadata-reliant implementation of [IdentifierManagerApi].
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#
  
      /**
       * Here is the table of default values which are returned from the column `"COLUMN_DEF"` depending on how it was configured:
       *
       * - Not set: `varchar("any", 128).nullable()`
       * - Set null: `varchar("any", 128).nullable().default(null)`
       * - Set "NULL": `varchar("any", 128).nullable().default("NULL")`
       * ```
       * DB                  Not set    Set null                    Set "NULL"
       * SqlServer           null       "(NULL)"                    "('NULL')"
       * SQLite              null       "NULL"                      "'NULL'"
       * Postgres            null       "NULL::character varying"   "'NULL'::character varying"
       * PostgresNG          null       "NULL::character varying"   "'NULL'::character varying"
       * Oracle              null       "NULL "                     "'NULL' "
       * MySql5              null       null                        "NULL"
       * MySql8              null       null                        "NULL"
       * MariaDB3            "NULL"     "NULL"                      "'NULL'"
       * MariaDB2            "NULL"     "NULL"                      "'NULL'"
       * H2V1                null       "NULL"                      "'NULL'"
       * H2V1 (MySql)        null       "NULL"                      "'NULL'"
       * H2V2                null       "NULL"                      "'NULL'"
       * H2V2 (MySql)        null       "NULL"                      "'NULL'"
       * H2V2 (MariaDB)      null       "NULL"                      "'NULL'"
       * H2V2 (PSQL)         null       "NULL"                      "'NULL'"
       * H2V2 (Oracle)       null       "NULL"                      "'NULL'"
       * H2V2 (SqlServer)    null       "NULL"                      "'NULL'"
       * ```
       * According to this table there is no simple rule of what is the default value. It should be checked
       * for each DB (or groups of DBs) specifically.
       * In the case of MySql and MariaDB it's also not possible to say whether was default value skipped or
       * explicitly set to `null`.
       *
       * @return `null` - if the value was set to `null` or not configured. `defaultValue` in other case.
       */
      @Suppress("ForbiddenComment")
      // TODO: move to the utility class, rename
      @InternalApi
      protected fun sanitizedDefault(defaultValue: String): String? {
//                  ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#sanitizedDefault().
//                                   display_name sanitizedDefault
//                                   documentation ```kotlin\n@Suppress(...) @InternalApi() protected final fun sanitizedDefault(defaultValue: String): String?\n```\n\n----\n\n\n Here is the table of default values which are returned from the column `"COLUMN_DEF"` depending on how it was configured:\n\n - Not set: `varchar("any", 128).nullable()`\n - Set null: `varchar("any", 128).nullable().default(null)`\n - Set "NULL": `varchar("any", 128).nullable().default("NULL")`\n ```\n DB                  Not set    Set null                    Set "NULL"\n SqlServer           null       "(NULL)"                    "('NULL')"\n SQLite              null       "NULL"                      "'NULL'"\n Postgres            null       "NULL::character varying"   "'NULL'::character varying"\n PostgresNG          null       "NULL::character varying"   "'NULL'::character varying"\n Oracle              null       "NULL "                     "'NULL' "\n MySql5              null       null                        "NULL"\n MySql8              null       null                        "NULL"\n MariaDB3            "NULL"     "NULL"                      "'NULL'"\n MariaDB2            "NULL"     "NULL"                      "'NULL'"\n H2V1                null       "NULL"                      "'NULL'"\n H2V1 (MySql)        null       "NULL"                      "'NULL'"\n H2V2                null       "NULL"                      "'NULL'"\n H2V2 (MySql)        null       "NULL"                      "'NULL'"\n H2V2 (MariaDB)      null       "NULL"                      "'NULL'"\n H2V2 (PSQL)         null       "NULL"                      "'NULL'"\n H2V2 (Oracle)       null       "NULL"                      "'NULL'"\n H2V2 (SqlServer)    null       "NULL"                      "'NULL'"\n ```\n According to this table there is no simple rule of what is the default value. It should be checked\n for each DB (or groups of DBs) specifically.\n In the case of MySql and MariaDB it's also not possible to say whether was default value skipped or\n explicitly set to `null`.\n\n @return `null` - if the value was set to `null` or not configured. `defaultValue` in other case.\n
//                                   ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#sanitizedDefault().(defaultValue)
//                                                display_name defaultValue
//                                                documentation ```kotlin\ndefaultValue: String\n```
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                          ^^^^^^^ reference semanticdb maven . . kotlin/String#
          val dialect = currentDialect
//            ^^^^^^^ definition local 0
//                    display_name dialect
//                    documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
          val h2Mode = dialect.h2Mode
//            ^^^^^^ definition local 1
//                   display_name h2Mode
//                   documentation ```kotlin\nlocal val h2Mode: H2Dialect.H2CompatibilityMode?\n```
//                     ^^^^^^^ reference local 0
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
          return when {
              // Check for MariaDB must be before MySql because MariaDBDialect as a class inherits MysqlDialect
              dialect is MariaDBDialect || h2Mode == H2CompatibilityMode.MariaDB -> when {
//            ^^^^^^^ reference local 0
//                                         ^^^^^^ reference local 1
//                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MariaDB.
                  defaultValue.startsWith("b'") -> defaultValue.substringAfter("b'").trim('\'')
//                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#sanitizedDefault().(defaultValue)
//                             ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#sanitizedDefault().(defaultValue)
//                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringAfter(+1).
//                                                                                   ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
                  else -> defaultValue.extractNullAndStringFromDefaultValue()
//                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#sanitizedDefault().(defaultValue)
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#extractNullAndStringFromDefaultValue().
              }
              // A special case, because MySql returns default string "NULL" as string "NULL", but other DBs return it as "'NULL'"
              dialect is MysqlDialect && defaultValue == "NULL" -> defaultValue
//            ^^^^^^^ reference local 0
//                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#sanitizedDefault().(defaultValue)
//                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#sanitizedDefault().(defaultValue)
              dialect is MysqlDialect || h2Mode == H2CompatibilityMode.MySQL -> when {
//            ^^^^^^^ reference local 0
//                                       ^^^^^^ reference local 1
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MySQL.
                  defaultValue.startsWith("b'") -> defaultValue.substringAfter("b'").trim('\'')
//                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#sanitizedDefault().(defaultValue)
//                             ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#sanitizedDefault().(defaultValue)
//                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringAfter(+1).
//                                                                                   ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
                  else -> defaultValue.extractNullAndStringFromDefaultValue()
//                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#sanitizedDefault().(defaultValue)
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#extractNullAndStringFromDefaultValue().
              }
              dialect is SQLServerDialect -> defaultValue.trim('(', ')').extractNullAndStringFromDefaultValue()
//            ^^^^^^^ reference local 0
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#sanitizedDefault().(defaultValue)
//                                                        ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
//                                                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#extractNullAndStringFromDefaultValue().
              dialect is OracleDialect -> defaultValue.trim().extractNullAndStringFromDefaultValue()
//            ^^^^^^^ reference local 0
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#sanitizedDefault().(defaultValue)
//                                                     ^^^^ reference semanticdb maven . . kotlin/text/trim(+5).
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#extractNullAndStringFromDefaultValue().
              else -> defaultValue.extractNullAndStringFromDefaultValue()
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#sanitizedDefault().(defaultValue)
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#extractNullAndStringFromDefaultValue().
          }
      }
  
      private fun String.extractNullAndStringFromDefaultValue() = when {
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#extractNullAndStringFromDefaultValue().
//                                                            display_name extractNullAndStringFromDefaultValue
//                                                            documentation ```kotlin\nprivate final fun String.extractNullAndStringFromDefaultValue(): String?\n```
          this.startsWith("NULL") -> null
//             ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
          this.startsWith('\'') && this.endsWith('\'') -> this.trim('\'')
//             ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith(+2).
//                                      ^^^^^^^^ reference semanticdb maven . . kotlin/text/endsWith(+1).
//                                                             ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
          else -> this
      }
  
      /** Extracts result data about a specific column as [ColumnMetadata]. */
      @InternalApi
      protected fun RowApi.asColumnMetadata(prefetchedColumnTypes: Map<String, String> = emptyMap()): ColumnMetadata {
//                         ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#asColumnMetadata().
//                                          display_name asColumnMetadata
//                                          documentation ```kotlin\n@InternalApi() protected final fun RowApi.asColumnMetadata(prefetchedColumnTypes: Map<String, String> = ...): ColumnMetadata\n```\n\n----\n\n Extracts result data about a specific column as [ColumnMetadata].
//                                          ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#asColumnMetadata().(prefetchedColumnTypes)
//                                                                display_name prefetchedColumnTypes
//                                                                documentation ```kotlin\nprefetchedColumnTypes: Map<String, String> = ...\n```
//                                                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                                                       ^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyMap().
//                                                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#
          val defaultDbValue = getObject("COLUMN_DEF", java.lang.String::class.java)?.toString()?.let {
//            ^^^^^^^^^^^^^^ definition local 2
//                           display_name defaultDbValue
//                           documentation ```kotlin\nlocal val defaultDbValue: String?\n```
//                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject(+3).
//                                                                             ^^^^ reference semanticdb maven . . kotlin/jvm/getJava().
//                                                                             ^^^^ reference semanticdb maven . . kotlin/jvm/java.
//                                                                                    ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/String#toString().
//                                                                                                ^^^ reference semanticdb maven . . kotlin/let().
//                                                                                                    ^ definition semanticdb maven . . (it) 2:9
//                                                                                                      display_name it
//                                                                                                      documentation ```kotlin\nit: Int?\n```
              sanitizedDefault(it)
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#sanitizedDefault().
//                             ^^ reference semanticdb maven . . (it)
          }
          val autoIncrement = getObject("IS_AUTOINCREMENT", java.lang.String::class.java)?.toString() == "YES"
//            ^^^^^^^^^^^^^ definition local 3
//                          display_name autoIncrement
//                          documentation ```kotlin\nlocal val autoIncrement: Boolean\n```
//                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject(+3).
//                                                                                  ^^^^ reference semanticdb maven . . kotlin/jvm/getJava().
//                                                                                  ^^^^ reference semanticdb maven . . kotlin/jvm/java.
//                                                                                         ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/String#toString().
          val type = getObject("DATA_TYPE")?.toString()?.toInt() ?: 0
//            ^^^^ definition local 4
//                 display_name type
//                 documentation ```kotlin\nlocal val type: Int\n```
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject(+1).
//                                           ^^^^^^^^ reference semanticdb maven . . kotlin/Any#toString().
//                                                       ^^^^^ reference semanticdb maven . . kotlin/text/toInt().
          val name = getStringOrThrow("COLUMN_NAME")
//            ^^^^ definition local 5
//                 display_name name
//                 documentation ```kotlin\nlocal val name: String\n```
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getStringOrThrow().
          val nullable = getObject("NULLABLE")?.toString()?.lowercase() in listOf("true", "1")
//            ^^^^^^^^ definition local 6
//                     display_name nullable
//                     documentation ```kotlin\nlocal val nullable: Boolean\n```
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject(+1).
//                                              ^^^^^^^^ reference semanticdb maven . . kotlin/Any#toString().
//                                                          ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
//                                                                      ^^ reference semanticdb maven . . kotlin/collections/contains(+9).
//                                                                         ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf(+1).
          val size = getObject("COLUMN_SIZE")?.toString()?.toInt().takeIf { it != 0 }
//            ^^^^ definition local 7
//                 display_name size
//                 documentation ```kotlin\nlocal val size: Int?\n```
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject(+1).
//                                             ^^^^^^^^ reference semanticdb maven . . kotlin/Any#toString().
//                                                         ^^^^^ reference semanticdb maven . . kotlin/text/toInt().
//                                                                 ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                                                        ^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                    display_name it
//                                                                                    documentation ```kotlin\nit: Int?\n```
//                                                                          ^^ reference semanticdb maven . . (it)
          val scale = getObject("DECIMAL_DIGITS")?.toString()?.toInt().takeIf { it != 0 }
//            ^^^^^ definition local 8
//                  display_name scale
//                  documentation ```kotlin\nlocal val scale: Int?\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject(+1).
//                                                 ^^^^^^^^ reference semanticdb maven . . kotlin/Any#toString().
//                                                             ^^^^^ reference semanticdb maven . . kotlin/text/toInt().
//                                                                     ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                                                            ^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                        display_name it
//                                                                                        documentation ```kotlin\nit: Int?\n```
//                                                                              ^^ reference semanticdb maven . . (it)
          val sqlType = getColumnType(this, prefetchedColumnTypes)
//            ^^^^^^^ definition local 9
//                    display_name sqlType
//                    documentation ```kotlin\nlocal val sqlType: String\n```
//                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getColumnType().
//                                          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#asColumnMetadata().(prefetchedColumnTypes)
  
          return ColumnMetadata(name, type, sqlType, nullable, size, scale, autoIncrement, defaultDbValue?.takeIf { !autoIncrement })
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#`<init>`().
//                              ^^^^ reference local 5
//                                    ^^^^ reference local 4
//                                          ^^^^^^^ reference local 9
//                                                   ^^^^^^^^ reference local 6
//                                                             ^^^^ reference local 7
//                                                                   ^^^^^ reference local 8
//                                                                          ^^^^^^^^^^^^^ reference local 3
//                                                                                         ^^^^^^^^^^^^^^ reference local 2
//                                                                                                         ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                                                                                                ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                                   display_name it
//                                                                                                                                   documentation ```kotlin\nit: Int?\n```
//                                                                                                                  ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                                                                   ^^^^^^^^^^^^^ reference local 3
      }
  
      private fun RowApi.getStringOrThrow(
//                       ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getStringOrThrow().
//                                        display_name getStringOrThrow
//                                        documentation ```kotlin\nprivate final fun RowApi.getStringOrThrow(field: String, transform: String.() -> String = ...): String\n```
          field: String,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getStringOrThrow().(field)
//              display_name field
//              documentation ```kotlin\nfield: String\n```
//               ^^^^^^ reference semanticdb maven . . kotlin/String#
          transform: String.() -> String = { this }
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getStringOrThrow().(transform)
//                  display_name transform
//                  documentation ```kotlin\ntransform: String.() -> String = ...\n```
//                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          return getObject(field, java.lang.String::class.java)
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject(+3).
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getStringOrThrow().(field)
//                                                        ^^^^ reference semanticdb maven . . kotlin/jvm/getJava().
//                                                        ^^^^ reference semanticdb maven . . kotlin/jvm/java.
              ?.toString()
//              ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/String#toString().
              ?.transform()
//              ^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getStringOrThrow().(transform)
              ?: error("Object retrieved from field $field in current data row is null")
//               ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getStringOrThrow().(field)
      }
  
      private fun getColumnType(result: RowApi, prefetchedColumnTypes: Map<String, String>): String {
//                ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getColumnType().
//                              display_name getColumnType
//                              documentation ```kotlin\nprivate final fun getColumnType(result: RowApi, prefetchedColumnTypes: Map<String, String>): String\n```
//                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getColumnType().(result)
//                                     display_name result
//                                     documentation ```kotlin\nresult: RowApi\n```
//                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#
//                                              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getColumnType().(prefetchedColumnTypes)
//                                                                    display_name prefetchedColumnTypes
//                                                                    documentation ```kotlin\nprefetchedColumnTypes: Map<String, String>\n```
//                                                                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                                                           ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (currentDialect !is H2Dialect) return ""
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
  
          val columnName = result.getStringOrThrow("COLUMN_NAME")
//            ^^^^^^^^^^ definition local 10
//                       display_name columnName
//                       documentation ```kotlin\nlocal val columnName: String\n```
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getColumnType().(result)
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getStringOrThrow().
          val columnType = prefetchedColumnTypes[columnName]
//            ^^^^^^^^^^ definition local 11
//                       display_name columnType
//                       documentation ```kotlin\nlocal val columnType: String\n```
//                         ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getColumnType().(prefetchedColumnTypes)
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                               ^^^^^^^^^^ reference local 10
              ?: result.getStringOrThrow("TYPE_NAME") { uppercase() }
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getColumnType().(result)
//                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getStringOrThrow().
//                                                      ^^^^^^^^^ reference semanticdb maven . . kotlin/text/uppercase(+2).
          val dataType = result.getObject("DATA_TYPE")?.toString()?.toInt()
//            ^^^^^^^^ definition local 12
//                     display_name dataType
//                     documentation ```kotlin\nlocal val dataType: Int?\n```
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#getColumnType().(result)
//                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject(+1).
//                                                      ^^^^^^^^ reference semanticdb maven . . kotlin/Any#toString().
//                                                                  ^^^^^ reference semanticdb maven . . kotlin/text/toInt().
          return if (dataType == Types.ARRAY) {
//                   ^^^^^^^^ reference local 12
//                                     ^^^^^ reference semanticdb maven jdk 11 java/sql/Types#ARRAY.
              val baseType = columnType.substringBefore(" ARRAY")
//                ^^^^^^^^ definition local 13
//                         display_name baseType
//                         documentation ```kotlin\nlocal val baseType: String\n```
//                           ^^^^^^^^^^ reference local 11
//                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringBefore(+1).
              normalizedColumnType(baseType) + columnType.replaceBefore(" ARRAY", "")
//            ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().
//                                 ^^^^^^^^ reference local 13
//                                           ^ reference semanticdb maven . . kotlin/String#plus().
//                                             ^^^^^^^^^^ reference local 11
//                                                        ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/replaceBefore(+1).
          } else {
              normalizedColumnType(columnType)
//            ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().
//                                 ^^^^^^^^^^ reference local 11
          }
      }
  
      /** Returns the normalized column type. */
      private fun normalizedColumnType(columnType: String): String {
//                ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().
//                                     display_name normalizedColumnType
//                                     documentation ```kotlin\nprivate final fun normalizedColumnType(columnType: String): String\n```\n\n----\n\n Returns the normalized column type.
//                                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().(columnType)
//                                                display_name columnType
//                                                documentation ```kotlin\ncolumnType: String\n```
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
          val h2Mode = currentDialect.h2Mode
//            ^^^^^^ definition local 14
//                   display_name h2Mode
//                   documentation ```kotlin\nlocal val h2Mode: H2Dialect.H2CompatibilityMode?\n```
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
          return when {
              columnType.matches(Regex("CHARACTER VARYING(?:\\(\\d+\\))?")) -> when (h2Mode) {
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().(columnType)
//                       ^^^^^^^ reference semanticdb maven . . kotlin/text/matches().
//                               ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
//                                                                                   ^^^^^^ reference local 14
                  H2CompatibilityMode.Oracle -> columnType.replace("CHARACTER VARYING", "VARCHAR2")
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
//                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().(columnType)
//                                                         ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
                  else -> columnType.replace("CHARACTER VARYING", "VARCHAR")
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().(columnType)
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
              }
              columnType.matches(Regex("CHARACTER(?:\\(\\d+\\))?")) -> columnType.replace("CHARACTER", "CHAR")
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().(columnType)
//                       ^^^^^^^ reference semanticdb maven . . kotlin/text/matches().
//                               ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().(columnType)
//                                                                                ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
              columnType.matches(Regex("BINARY VARYING(?:\\(\\d+\\))?")) -> when (h2Mode) {
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().(columnType)
//                       ^^^^^^^ reference semanticdb maven . . kotlin/text/matches().
//                               ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
//                                                                                ^^^^^^ reference local 14
                  H2CompatibilityMode.PostgreSQL -> "bytea"
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#PostgreSQL.
                  H2CompatibilityMode.Oracle -> columnType.replace("BINARY VARYING", "RAW")
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
//                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().(columnType)
//                                                         ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
                  else -> columnType.replace("BINARY VARYING", "VARBINARY")
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().(columnType)
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
              }
              columnType == "BOOLEAN" -> when (h2Mode) {
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().(columnType)
//                                             ^^^^^^ reference local 14
                  H2CompatibilityMode.SQLServer -> "BIT"
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#SQLServer.
                  else -> columnType
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().(columnType)
              }
              columnType == "BINARY LARGE OBJECT" -> "BLOB"
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().(columnType)
              columnType == "CHARACTER LARGE OBJECT" -> "CLOB"
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().(columnType)
              columnType == "INTEGER" && h2Mode != H2CompatibilityMode.Oracle -> "INT"
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().(columnType)
//                                       ^^^^^^ reference local 14
//                                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
              else -> columnType
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedDatabaseMetadata#normalizedColumnType().(columnType)
          }
      }
  }
