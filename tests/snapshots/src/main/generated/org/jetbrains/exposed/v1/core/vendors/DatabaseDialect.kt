  package org.jetbrains.exposed.v1.core.vendors
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
  
  import org.jetbrains.exposed.v1.core.*
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#
  
  /**
   * Common interface for all database dialects.
   */
  @Suppress("TooManyFunctions")
  interface DatabaseDialect {
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
//                          display_name DatabaseDialect
//                          documentation ```kotlin\n@Suppress(...) public abstract interface DatabaseDialect : Any\n```\n\n----\n\n\n Common interface for all database dialects.\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
      /** Name of this dialect. */
      val name: String
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//             display_name name
//             documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Name of this dialect.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
//             display_name name
//             documentation ```kotlin\npublic abstract val name: String\n```\n\n----\n\n Name of this dialect.
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Data type provider of this dialect. */
      val dataTypeProvider: DataTypeProvider
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                         display_name dataTypeProvider
//                         documentation ```kotlin\npublic abstract val dataTypeProvider: DataTypeProvider\n```\n\n----\n\n Data type provider of this dialect.
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                         display_name dataTypeProvider
//                         documentation ```kotlin\npublic get(): DataTypeProvider\n```\n\n----\n\n Data type provider of this dialect.
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
  
      /** Function provider of this dialect. */
      val functionProvider: FunctionProvider
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                         display_name functionProvider
//                         documentation ```kotlin\npublic abstract val functionProvider: FunctionProvider\n```\n\n----\n\n Function provider of this dialect.
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                         display_name functionProvider
//                         documentation ```kotlin\npublic get(): FunctionProvider\n```\n\n----\n\n Function provider of this dialect.
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
  
      /** Returns `true` if the dialect supports the `IF EXISTS`/`IF NOT EXISTS` option when creating, altering or dropping objects, `false` otherwise. */
      val supportsIfNotExists: Boolean get() = true
//        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsIfNotExists.
//                            display_name supportsIfNotExists
//                            documentation ```kotlin\npublic open val supportsIfNotExists: Boolean\n```\n\n----\n\n Returns `true` if the dialect supports the `IF EXISTS`/`IF NOT EXISTS` option when creating, altering or dropping objects, `false` otherwise.
//                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                     ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsIfNotExists().
//                                         display_name supportsIfNotExists
//                                         documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns `true` if the dialect supports the creation of sequences, `false` otherwise. */
      val supportsCreateSequence: Boolean get() = true
//        ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsCreateSequence.
//                               display_name supportsCreateSequence
//                               documentation ```kotlin\npublic open val supportsCreateSequence: Boolean\n```\n\n----\n\n Returns `true` if the dialect supports the creation of sequences, `false` otherwise.
//                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsCreateSequence().
//                                            display_name supportsCreateSequence
//                                            documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns `true` if the dialect requires the use of a sequence to create an auto-increment column, `false` otherwise. */
      val needsSequenceToAutoInc: Boolean get() = false
//        ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#needsSequenceToAutoInc.
//                               display_name needsSequenceToAutoInc
//                               documentation ```kotlin\npublic open val needsSequenceToAutoInc: Boolean\n```\n\n----\n\n Returns `true` if the dialect requires the use of a sequence to create an auto-increment column, `false` otherwise.
//                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getNeedsSequenceToAutoInc().
//                                            display_name needsSequenceToAutoInc
//                                            documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns the default reference option for the dialect. */
      val defaultReferenceOption: ReferenceOption get() = ReferenceOption.RESTRICT
//        ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#defaultReferenceOption.
//                               display_name defaultReferenceOption
//                               documentation ```kotlin\npublic open val defaultReferenceOption: ReferenceOption\n```\n\n----\n\n Returns the default reference option for the dialect.
//                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDefaultReferenceOption().
//                                                    display_name defaultReferenceOption
//                                                    documentation ```kotlin\npublic get(): ReferenceOption\n```
//                                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#RESTRICT.
  
      /** Returns `true` if the dialect requires the use of quotes when using symbols in object names, `false` otherwise. */
      val needsQuotesWhenSymbolsInNames: Boolean get() = true
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#needsQuotesWhenSymbolsInNames.
//                                      display_name needsQuotesWhenSymbolsInNames
//                                      documentation ```kotlin\npublic open val needsQuotesWhenSymbolsInNames: Boolean\n```\n\n----\n\n Returns `true` if the dialect requires the use of quotes when using symbols in object names, `false` otherwise.
//                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                               ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getNeedsQuotesWhenSymbolsInNames().
//                                                   display_name needsQuotesWhenSymbolsInNames
//                                                   documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns `true` if the dialect supports returning multiple generated keys as a result of an insert operation, `false` otherwise. */
      val supportsMultipleGeneratedKeys: Boolean
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsMultipleGeneratedKeys().
//                                      display_name supportsMultipleGeneratedKeys
//                                      documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Returns `true` if the dialect supports returning multiple generated keys as a result of an insert operation, `false` otherwise.
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsMultipleGeneratedKeys.
//                                      display_name supportsMultipleGeneratedKeys
//                                      documentation ```kotlin\npublic abstract val supportsMultipleGeneratedKeys: Boolean\n```\n\n----\n\n Returns `true` if the dialect supports returning multiple generated keys as a result of an insert operation, `false` otherwise.
//                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      /** Returns `true` if the dialect supports returning generated keys obtained from a sequence. */
      val supportsSequenceAsGeneratedKeys: Boolean get() = supportsCreateSequence
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsSequenceAsGeneratedKeys.
//                                        display_name supportsSequenceAsGeneratedKeys
//                                        documentation ```kotlin\npublic open val supportsSequenceAsGeneratedKeys: Boolean\n```\n\n----\n\n Returns `true` if the dialect supports returning generated keys obtained from a sequence.
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                 ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsSequenceAsGeneratedKeys().
//                                                     display_name supportsSequenceAsGeneratedKeys
//                                                     documentation ```kotlin\npublic get(): Boolean\n```
//                                                         ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsCreateSequence().
//                                                         ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsCreateSequence.
  
      /** Returns `true` if the dialect supports only returning generated keys that are identity columns. */
      val supportsOnlyIdentifiersInGeneratedKeys: Boolean get() = false
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsOnlyIdentifiersInGeneratedKeys.
//                                               display_name supportsOnlyIdentifiersInGeneratedKeys
//                                               documentation ```kotlin\npublic open val supportsOnlyIdentifiersInGeneratedKeys: Boolean\n```\n\n----\n\n Returns `true` if the dialect supports only returning generated keys that are identity columns.
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsOnlyIdentifiersInGeneratedKeys().
//                                                            display_name supportsOnlyIdentifiersInGeneratedKeys
//                                                            documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns `true` if the dialect supports an upsert operation returning an affected-row value of 0, 1, or 2. */
      val supportsTernaryAffectedRowValues: Boolean get() = false
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsTernaryAffectedRowValues.
//                                         display_name supportsTernaryAffectedRowValues
//                                         documentation ```kotlin\npublic open val supportsTernaryAffectedRowValues: Boolean\n```\n\n----\n\n Returns `true` if the dialect supports an upsert operation returning an affected-row value of 0, 1, or 2.
//                                          ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                  ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsTernaryAffectedRowValues().
//                                                      display_name supportsTernaryAffectedRowValues
//                                                      documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns`true` if the dialect supports schema creation. */
      val supportsCreateSchema: Boolean get() = true
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsCreateSchema.
//                             display_name supportsCreateSchema
//                             documentation ```kotlin\npublic open val supportsCreateSchema: Boolean\n```\n\n----\n\n Returns`true` if the dialect supports schema creation.
//                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsCreateSchema().
//                                          display_name supportsCreateSchema
//                                          documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns `true` if the dialect supports subqueries within a UNION/EXCEPT/INTERSECT statement. */
      val supportsSubqueryUnions: Boolean get() = false
//        ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsSubqueryUnions.
//                               display_name supportsSubqueryUnions
//                               documentation ```kotlin\npublic open val supportsSubqueryUnions: Boolean\n```\n\n----\n\n Returns `true` if the dialect supports subqueries within a UNION/EXCEPT/INTERSECT statement.
//                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsSubqueryUnions().
//                                            display_name supportsSubqueryUnions
//                                            documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns `true` if the dialect provides a special dummy DUAL table, accessible by all users. */
      val supportsDualTableConcept: Boolean get() = false
//        ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsDualTableConcept.
//                                 display_name supportsDualTableConcept
//                                 documentation ```kotlin\npublic open val supportsDualTableConcept: Boolean\n```\n\n----\n\n Returns `true` if the dialect provides a special dummy DUAL table, accessible by all users.
//                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                          ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsDualTableConcept().
//                                              display_name supportsDualTableConcept
//                                              documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns `true` if the dialect provides options to configure how nulls are sorted compared to non-null values. */
      val supportsOrderByNullsFirstLast: Boolean get() = false
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsOrderByNullsFirstLast.
//                                      display_name supportsOrderByNullsFirstLast
//                                      documentation ```kotlin\npublic open val supportsOrderByNullsFirstLast: Boolean\n```\n\n----\n\n Returns `true` if the dialect provides options to configure how nulls are sorted compared to non-null values.
//                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                               ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsOrderByNullsFirstLast().
//                                                   display_name supportsOrderByNullsFirstLast
//                                                   documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns `true` if the dialect supports window function definitions with GROUPS mode in frame clause */
      val supportsWindowFrameGroupsMode: Boolean get() = false
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsWindowFrameGroupsMode.
//                                      display_name supportsWindowFrameGroupsMode
//                                      documentation ```kotlin\npublic open val supportsWindowFrameGroupsMode: Boolean\n```\n\n----\n\n Returns `true` if the dialect supports window function definitions with GROUPS mode in frame clause
//                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                               ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsWindowFrameGroupsMode().
//                                                   display_name supportsWindowFrameGroupsMode
//                                                   documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns `true` if the dialect supports using the ON UPDATE clause with a foreign key constraint. */
      val supportsOnUpdate: Boolean get() = true
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsOnUpdate.
//                         display_name supportsOnUpdate
//                         documentation ```kotlin\npublic open val supportsOnUpdate: Boolean\n```\n\n----\n\n Returns `true` if the dialect supports using the ON UPDATE clause with a foreign key constraint.
//                          ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                  ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsOnUpdate().
//                                      display_name supportsOnUpdate
//                                      documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns `true` if the dialect supports the SET DEFAULT action as part of a foreign key constraint clause. */
      val supportsSetDefaultReferenceOption: Boolean get() = true
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsSetDefaultReferenceOption.
//                                          display_name supportsSetDefaultReferenceOption
//                                          documentation ```kotlin\npublic open val supportsSetDefaultReferenceOption: Boolean\n```\n\n----\n\n Returns `true` if the dialect supports the SET DEFAULT action as part of a foreign key constraint clause.
//                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                   ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsSetDefaultReferenceOption().
//                                                       display_name supportsSetDefaultReferenceOption
//                                                       documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns `true` if the dialect supports the RESTRICT action as part of a foreign key constraint clause. */
      val supportsRestrictReferenceOption: Boolean get() = true
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsRestrictReferenceOption.
//                                        display_name supportsRestrictReferenceOption
//                                        documentation ```kotlin\npublic open val supportsRestrictReferenceOption: Boolean\n```\n\n----\n\n Returns `true` if the dialect supports the RESTRICT action as part of a foreign key constraint clause.
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                 ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsRestrictReferenceOption().
//                                                     display_name supportsRestrictReferenceOption
//                                                     documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns a mapping of dialect-specific characters to be escaped when used alongside the LIKE operator. */
      val likePatternSpecialChars: Map<Char, Char?> get() = defaultLikePatternSpecialChars
//        ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#likePatternSpecialChars.
//                                display_name likePatternSpecialChars
//                                documentation ```kotlin\npublic open val likePatternSpecialChars: Map<Char, Char?>\n```\n\n----\n\n Returns a mapping of dialect-specific characters to be escaped when used alongside the LIKE operator.
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                  ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getLikePatternSpecialChars().
//                                                      display_name likePatternSpecialChars
//                                                      documentation ```kotlin\npublic get(): Map<Char, Char?>\n```
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#Companion#defaultLikePatternSpecialChars.
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#Companion#getDefaultLikePatternSpecialChars().
  
      /** Returns true if autoCommit should be enabled to create/drop a database. */
      val requiresAutoCommitOnCreateDrop: Boolean get() = false
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#requiresAutoCommitOnCreateDrop.
//                                       display_name requiresAutoCommitOnCreateDrop
//                                       documentation ```kotlin\npublic open val requiresAutoCommitOnCreateDrop: Boolean\n```\n\n----\n\n Returns true if autoCommit should be enabled to create/drop a database.
//                                        ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getRequiresAutoCommitOnCreateDrop().
//                                                    display_name requiresAutoCommitOnCreateDrop
//                                                    documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns the allowed maximum sequence value for a dialect, as a [Long]. */
      val sequenceMaxValue: Long get() = Long.MAX_VALUE
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#sequenceMaxValue.
//                         display_name sequenceMaxValue
//                         documentation ```kotlin\npublic open val sequenceMaxValue: Long\n```\n\n----\n\n Returns the allowed maximum sequence value for a dialect, as a [Long].
//                          ^^^^ reference semanticdb maven . . kotlin/Long#
//                               ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSequenceMaxValue().
//                                   display_name sequenceMaxValue
//                                   documentation ```kotlin\npublic get(): Long\n```
//                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/Long#Companion#MAX_VALUE.
//                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/Long#Companion#getMAX_VALUE().
  
      /** Returns whether Exposed currently supports column type change in migrations for this dialect. */
      val supportsColumnTypeChange: Boolean get() = false
//        ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsColumnTypeChange.
//                                 display_name supportsColumnTypeChange
//                                 documentation ```kotlin\npublic open val supportsColumnTypeChange: Boolean\n```\n\n----\n\n Returns whether Exposed currently supports column type change in migrations for this dialect.
//                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                          ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsColumnTypeChange().
//                                              display_name supportsColumnTypeChange
//                                              documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns `true` if the dialect supports `SELECT FOR UPDATE` statements, `false` otherwise. */
      val supportsSelectForUpdate: Boolean get() = false
//        ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsSelectForUpdate.
//                                display_name supportsSelectForUpdate
//                                documentation ```kotlin\npublic open val supportsSelectForUpdate: Boolean\n```\n\n----\n\n Returns `true` if the dialect supports `SELECT FOR UPDATE` statements, `false` otherwise.
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                         ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsSelectForUpdate().
//                                             display_name supportsSelectForUpdate
//                                             documentation ```kotlin\npublic get(): Boolean\n```
  
      /** Returns `true` if the specified [e] is allowed as a default column value in the dialect, `false` otherwise. */
      fun isAllowedAsColumnDefault(e: Expression<*>): Boolean = e is LiteralOp<*>
//        ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#isAllowedAsColumnDefault().
//                                 display_name isAllowedAsColumnDefault
//                                 documentation ```kotlin\npublic open fun isAllowedAsColumnDefault(e: Expression<*>): Boolean\n```\n\n----\n\n Returns `true` if the specified [e] is allowed as a default column value in the dialect, `false` otherwise.
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#isAllowedAsColumnDefault().
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isAllowedAsColumnDefault().
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#isAllowedAsColumnDefault().
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#isAllowedAsColumnDefault().
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#isAllowedAsColumnDefault().
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#isAllowedAsColumnDefault().
//                                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#isAllowedAsColumnDefault().(e)
//                                   display_name e
//                                   documentation ```kotlin\ne: Expression<*>\n```
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                              ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#isAllowedAsColumnDefault().(e)
  
      // Specific SQL statements
  
      /** Returns the SQL statement that creates the specified [index]. */
      fun createIndex(index: Index): String
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createIndex().
//                    display_name createIndex
//                    documentation ```kotlin\npublic abstract fun createIndex(index: Index): String\n\n```\n\n----\n\n Returns the SQL statement that creates the specified [index].
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().
//                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createIndex().(index)
//                          display_name index
//                          documentation ```kotlin\nindex: Index\n```
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#
//                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Returns the SQL statement that drops the specified [indexName] from the specified [tableName]. */
      fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropIndex().
//                  display_name dropIndex
//                  documentation ```kotlin\npublic abstract fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String\n\n```\n\n----\n\n Returns the SQL statement that drops the specified [indexName] from the specified [tableName].
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().
//                  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropIndex().(tableName)
//                            display_name tableName
//                            documentation ```kotlin\ntableName: String\n```
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropIndex().(indexName)
//                                               display_name indexName
//                                               documentation ```kotlin\nindexName: String\n```
//                                                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropIndex().(isUnique)
//                                                                 display_name isUnique
//                                                                 documentation ```kotlin\nisUnique: Boolean\n```
//                                                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                           ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropIndex().(isPartialOrFunctional)
//                                                                                                 display_name isPartialOrFunctional
//                                                                                                 documentation ```kotlin\nisPartialOrFunctional: Boolean\n```
//                                                                                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Returns the SQL statement that modifies the specified [column]. */
      fun modifyColumn(column: Column<*>, columnDiff: ColumnDiff): List<String>
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#modifyColumn().
//                     display_name modifyColumn
//                     documentation ```kotlin\npublic abstract fun modifyColumn(column: Column<*>, columnDiff: ColumnDiff): List<String>\n\n```\n\n----\n\n Returns the SQL statement that modifies the specified [column].
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().
//                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#modifyColumn().(column)
//                            display_name column
//                            documentation ```kotlin\ncolumn: Column<*>\n```
//                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#modifyColumn().(columnDiff)
//                                                   display_name columnDiff
//                                                   documentation ```kotlin\ncolumnDiff: ColumnDiff\n```
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#
//                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
  
      /** Returns the SQL statement that adds a primary key specified [pkName] to an existing [table]. */
      fun addPrimaryKey(table: Table, pkName: String?, vararg pkColumns: Column<*>): String
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#addPrimaryKey().
//                      display_name addPrimaryKey
//                      documentation ```kotlin\npublic abstract fun addPrimaryKey(table: Table, pkName: String?, vararg pkColumns: Column<*>): String\n\n```\n\n----\n\n Returns the SQL statement that adds a primary key specified [pkName] to an existing [table].
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().
//                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#addPrimaryKey().(table)
//                            display_name table
//                            documentation ```kotlin\ntable: Table\n```
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#addPrimaryKey().(pkName)
//                                           display_name pkName
//                                           documentation ```kotlin\npkName: String?\n```
//                                            ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#addPrimaryKey().(pkColumns)
//                                                                      display_name pkColumns
//                                                                      documentation ```kotlin\nvararg pkColumns: Column<*>\n```
//                                                                       ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Returns the SQL statement that creates a database with the specified [name]. */
      @OptIn(InternalApi::class)
      fun createDatabase(name: String) = "CREATE DATABASE IF NOT EXISTS ${name.inProperCase()}"
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createDatabase().
//                       display_name createDatabase
//                       documentation ```kotlin\n@OptIn(...) public open fun createDatabase(name: String): String\n```\n\n----\n\n Returns the SQL statement that creates a database with the specified [name].
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createDatabase().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createDatabase().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createDatabase().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createDatabase().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createDatabase().
//                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createDatabase().(name)
//                            display_name name
//                            documentation ```kotlin\nname: String\n```
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createDatabase().(name)
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
  
      /** Returns the SQL query that retrieves a set of existing databases. */
      fun listDatabases(): String = "SHOW DATABASES"
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#listDatabases().
//                      display_name listDatabases
//                      documentation ```kotlin\npublic open fun listDatabases(): String\n```\n\n----\n\n Returns the SQL query that retrieves a set of existing databases.
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#listDatabases().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#listDatabases().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#listDatabases().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#listDatabases().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#listDatabases().
//                         ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Returns the SQL statement that drops the database with the specified [name]. */
      @OptIn(InternalApi::class)
      fun dropDatabase(name: String) = "DROP DATABASE IF EXISTS ${name.inProperCase()}"
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropDatabase().
//                     display_name dropDatabase
//                     documentation ```kotlin\n@OptIn(...) public open fun dropDatabase(name: String): String\n```\n\n----\n\n Returns the SQL statement that drops the database with the specified [name].
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#dropDatabase().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropDatabase().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropDatabase().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropDatabase().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropDatabase().
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropDatabase().(name)
//                          display_name name
//                          documentation ```kotlin\nname: String\n```
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropDatabase().(name)
//                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
  
      /** Returns the SQL statement that sets the current schema to the specified [schema]. */
      fun setSchema(schema: Schema): String = "SET SCHEMA ${schema.identifier}"
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#setSchema().
//                  display_name setSchema
//                  documentation ```kotlin\npublic open fun setSchema(schema: Schema): String\n```\n\n----\n\n Returns the SQL statement that sets the current schema to the specified [schema].
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#setSchema().
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#setSchema().
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#setSchema().
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#setSchema().
//                  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#setSchema().(schema)
//                         display_name schema
//                         documentation ```kotlin\nschema: Schema\n```
//                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
//                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#setSchema().(schema)
//                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getIdentifier().
//                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#identifier.
  
      /** Returns the SQL statement that creates the specified [schema]. */
      fun createSchema(schema: Schema): String = buildString {
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createSchema().
//                     display_name createSchema
//                     documentation ```kotlin\npublic open fun createSchema(schema: Schema): String\n```\n\n----\n\n Returns the SQL statement that creates the specified [schema].
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createSchema().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createSchema().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createSchema().
//                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createSchema().(schema)
//                            display_name schema
//                            documentation ```kotlin\nschema: Schema\n```
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                               ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
          append("CREATE SCHEMA IF NOT EXISTS ")
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
          append(schema.identifier)
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createSchema().(schema)
//                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getIdentifier().
//                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#identifier.
          appendIfNotNull(" AUTHORIZATION ", schema.authorization)
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createSchema().(schema)
//                                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#authorization.
//                                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getAuthorization().
      }
  
      /** Returns the SQL statement that drops the specified [schema], as well as all its objects if [cascade] is `true`. */
      fun dropSchema(schema: Schema, cascade: Boolean): String = buildString {
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropSchema().
//                   display_name dropSchema
//                   documentation ```kotlin\npublic open fun dropSchema(schema: Schema, cascade: Boolean): String\n```\n\n----\n\n Returns the SQL statement that drops the specified [schema], as well as all its objects if [cascade] is `true`.
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropSchema().
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropSchema().
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropSchema().
//                   ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropSchema().(schema)
//                          display_name schema
//                          documentation ```kotlin\nschema: Schema\n```
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
//                                   ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropSchema().(cascade)
//                                           display_name cascade
//                                           documentation ```kotlin\ncascade: Boolean\n```
//                                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                               ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
          append("DROP SCHEMA IF EXISTS ", schema.identifier)
//        ^^^^^^ reference semanticdb maven . . kotlin/text/append(+4).
//                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropSchema().(schema)
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getIdentifier().
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#identifier.
  
          if (cascade) {
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropSchema().(cascade)
              append(" CASCADE")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
          }
      }
  
      // TODO move it to JDBC or R2DBC metadata
      /** Returns whether the [columnMetadataSqlType] type and the [columnType] are equivalent.
       *
       * [columnMetadataJdbcType], the value of which comes from [java.sql.Types], is taken into consideration if needed by a specific database.
       * @see [H2Dialect.areEquivalentColumnTypes]
       */
      fun areEquivalentColumnTypes(columnMetadataSqlType: String, columnMetadataJdbcType: Int, columnType: String): Boolean =
//        ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#areEquivalentColumnTypes().
//                                 display_name areEquivalentColumnTypes
//                                 documentation ```kotlin\npublic open fun areEquivalentColumnTypes(columnMetadataSqlType: String, columnMetadataJdbcType: Int, columnType: String): Boolean\n```\n\n----\n\n Returns whether the [columnMetadataSqlType] type and the [columnType] are equivalent.\n\n [columnMetadataJdbcType], the value of which comes from [java.sql.Types], is taken into consideration if needed by a specific database.\n @see [H2Dialect.areEquivalentColumnTypes]\n
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().
//                                 ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#areEquivalentColumnTypes().(columnMetadataSqlType)
//                                                       display_name columnMetadataSqlType
//                                                       documentation ```kotlin\ncolumnMetadataSqlType: String\n```
//                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#areEquivalentColumnTypes().(columnMetadataJdbcType)
//                                                                                       display_name columnMetadataJdbcType
//                                                                                       documentation ```kotlin\ncolumnMetadataJdbcType: Int\n```
//                                                                                        ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#areEquivalentColumnTypes().(columnType)
//                                                                                                        display_name columnType
//                                                                                                        documentation ```kotlin\ncolumnType: String\n```
//                                                                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          columnMetadataSqlType.equals(columnType, ignoreCase = true)
//        ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#areEquivalentColumnTypes().(columnMetadataSqlType)
//                              ^^^^^^ reference semanticdb maven . . kotlin/text/equals(+1).
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#areEquivalentColumnTypes().(columnType)
  
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#Companion# 2:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#Companion#`<init>`(). 2:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): DatabaseDialect.Companion\n```
          private val defaultLikePatternSpecialChars = mapOf('%' to null, '_' to null)
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#Companion#defaultLikePatternSpecialChars.
//                                                   display_name defaultLikePatternSpecialChars
//                                                   documentation ```kotlin\nprivate final val defaultLikePatternSpecialChars: Map<Char, Nothing?>\n```
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#Companion#getDefaultLikePatternSpecialChars().
//                                                   display_name defaultLikePatternSpecialChars
//                                                   documentation ```kotlin\nprivate get(): Map<Char, Nothing?>\n```
//                                                     ^^^^^ reference semanticdb maven . . kotlin/collections/mapOf(+1).
//                                                               ^^ reference semanticdb maven . . kotlin/to().
//                                                                            ^^ reference semanticdb maven . . kotlin/to().
      }
  }
  
  private val explicitDialect = ThreadLocal<DatabaseDialect?>()
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/explicitDialect.
//                            display_name explicitDialect
//                            documentation ```kotlin\nprivate final val explicitDialect: ThreadLocal<DatabaseDialect?>\n```
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getExplicitDialect().
//                            display_name explicitDialect
//                            documentation ```kotlin\nprivate get(): ThreadLocal<DatabaseDialect?>\n```
//                              ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/ThreadLocal#`<init>`().
  
  internal fun <T> withDialect(dialect: DatabaseDialect, body: () -> T): T {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/withDialect().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/withDialect().
//                             display_name withDialect
//                             documentation ```kotlin\ninternal final fun <T> withDialect(dialect: DatabaseDialect, body: () -> T): T\n```
//                             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/withDialect().(dialect)
//                                     display_name dialect
//                                     documentation ```kotlin\ndialect: DatabaseDialect\n```
//                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
//                                                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/withDialect().(body)
//                                                            display_name body
//                                                            documentation ```kotlin\nbody: () -> T\n```
//                                                             ^^^^^^^ reference semanticdb maven . . kotlin/Function0#
      return try {
          explicitDialect.set(dialect)
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/explicitDialect.
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getExplicitDialect().
//                        ^^^ reference semanticdb maven jdk 11 java/lang/ThreadLocal#set().
//                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/withDialect().(dialect)
          body()
//        ^^^^ reference semanticdb maven . . kotlin/Function0#invoke().
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/withDialect().(body)
      } finally {
          explicitDialect.set(null)
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/explicitDialect.
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getExplicitDialect().
//                        ^^^ reference semanticdb maven jdk 11 java/lang/ThreadLocal#set().
      }
  }
  
  /** Returns the dialect used in the current transaction, may throw an exception if there is no current transaction. */
  val currentDialect: DatabaseDialect
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                   display_name currentDialect
//                   documentation ```kotlin\npublic final val currentDialect: DatabaseDialect\n```\n\n----\n\n Returns the dialect used in the current transaction, may throw an exception if there is no current transaction.
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
      get() {
//    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//        display_name currentDialect
//        documentation ```kotlin\npublic get(): DatabaseDialect\n```
          @OptIn(InternalApi::class)
          return explicitDialect.get() ?: CoreTransactionManager.currentTransaction().db.dialect
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/explicitDialect.
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getExplicitDialect().
//                               ^^^ reference semanticdb maven jdk 11 java/lang/ThreadLocal#get().
//                                                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
      }
  
  @OptIn(InternalApi::class)
  internal val currentDialectIfAvailable: DatabaseDialect?
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//                                       display_name currentDialectIfAvailable
//                                       documentation ```kotlin\n@OptIn(...) internal final val currentDialectIfAvailable: DatabaseDialect?\n```
//                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
      get() = if (CoreTransactionManager.getDefaultDatabaseOrFirst() != null && CoreTransactionManager.currentTransactionOrNull() != null) {
//    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
//        display_name currentDialectIfAvailable
//        documentation ```kotlin\ninternal get(): DatabaseDialect?\n```
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#getDefaultDatabaseOrFirst().
//                                                                                                     ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransactionOrNull().
          currentDialect
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
      } else {
          null
      }
  
  @OptIn(InternalApi::class)
  @InternalApi
  fun String.inProperCase(): String =
//           ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
//                        display_name inProperCase
//                        documentation ```kotlin\n@OptIn(...) @InternalApi() public final fun String.inProperCase(): String\n```
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
      CoreTransactionManager.currentTransactionOrNull()?.db?.identifierManager?.inProperCase(this@inProperCase) ?: this
//                           ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransactionOrNull().
//                                                       ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                       ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                                                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
//                                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#inProperCase().
