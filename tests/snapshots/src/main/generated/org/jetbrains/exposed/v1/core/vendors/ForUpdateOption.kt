  package org.jetbrains.exposed.v1.core.vendors
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
  
  import org.jetbrains.exposed.v1.core.InternalApi
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/InternalApi#
  import org.jetbrains.exposed.v1.core.Table
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
  /**
   * Clauses that perform a locking read at row-level for SELECT statements.
   *
   * @sample org.jetbrains.exposed.v1.tests.postgresql.PostgresqlTests.testForUpdateOptionsSyntax
   */
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#`<init>`().
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#`<init>`().(querySuffix)
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#querySuffix.
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#getQuerySuffix().
  sealed class ForUpdateOption(open val querySuffix: String) {
//             ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
//                             display_name ForUpdateOption
//                             documentation ```kotlin\npublic sealed class ForUpdateOption : Any\n```\n\n----\n\n\n Clauses that perform a locking read at row-level for SELECT statements.\n\n @sample org.jetbrains.exposed.v1.tests.postgresql.PostgresqlTests.testForUpdateOptionsSyntax\n
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdate#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MariaDB#LockInShareMode#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#LockInShareMode#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#NoForUpdateOption#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateNoWait#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateWait#
//             ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#`<init>`().
//                             display_name ForUpdateOption
//                             documentation ```kotlin\nprotected constructor(querySuffix: String): ForUpdateOption\n```
//                                      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#`<init>`().(querySuffix)
//                                                  display_name querySuffix
//                                                  documentation ```kotlin\nquerySuffix: String\n```
//                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#`<init>`().(querySuffix)
//                                      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#getQuerySuffix().
//                                                  display_name querySuffix
//                                                  documentation ```kotlin\npublic get(): String\n```
//                                      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#querySuffix.
//                                                  display_name querySuffix
//                                                  documentation ```kotlin\npublic open val querySuffix: String\n```
//                                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#`<init>`().(querySuffix)
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#querySuffix.
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#getQuerySuffix().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#NoForUpdateOption#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#NoForUpdateOption#`<init>`().
      @InternalApi
      data object NoForUpdateOption : ForUpdateOption("") {
//                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#NoForUpdateOption#
//                                  display_name NoForUpdateOption
//                                  documentation ```kotlin\n@InternalApi() public final data object NoForUpdateOption : ForUpdateOption\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
//                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#NoForUpdateOption#`<init>`().
//                                  display_name NoForUpdateOption
//                                  documentation ```kotlin\nprivate constructor(): ForUpdateOption.NoForUpdateOption\n```
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#NoForUpdateOption#querySuffix.
//                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#NoForUpdateOption#getQuerySuffix().
          override val querySuffix: String get() = error("querySuffix should not be called for NoForUpdateOption object")
//                     ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#NoForUpdateOption#querySuffix.
//                                 display_name querySuffix
//                                 documentation ```kotlin\npublic open override val querySuffix: String\n```
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                         ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#NoForUpdateOption#getQuerySuffix().
//                                             display_name querySuffix
//                                             documentation ```kotlin\npublic get(): String\n```
//                                                 ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#NoForUpdateOption#querySuffix.
//                                                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#NoForUpdateOption#getQuerySuffix().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#NoForUpdateOption#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#NoForUpdateOption#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#
      /** Interface that can be implemented in each database if they support modes **/
      interface ForUpdateOrShareMode {
//              ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#
//                                   display_name ForUpdateOrShareMode
//                                   documentation ```kotlin\npublic abstract interface ForUpdateOrShareMode : Any\n```\n\n----\n\n Interface that can be implemented in each database if they support modes
//                                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#
//                                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#statement.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#getStatement().
          val statement: String
//            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#getStatement().
//                      display_name statement
//                      documentation ```kotlin\npublic get(): String\n```
//            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#statement.
//                      display_name statement
//                      documentation ```kotlin\npublic abstract val statement: String\n```
//                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#statement.
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#getStatement().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
      /** Common class since this is being used by at least two DBs **/
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#`<init>`().
      abstract class ForUpdateBase(
//                   ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
//                                 display_name ForUpdateBase
//                                 documentation ```kotlin\npublic abstract class ForUpdateBase : ForUpdateOption\n```\n\n----\n\n Common class since this is being used by at least two DBs
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForUpdate#
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForUpdate#
//                   ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#`<init>`().
//                                 display_name ForUpdateBase
//                                 documentation ```kotlin\npublic constructor(querySuffix: String, mode: ForUpdateOption.ForUpdateOrShareMode? = ..., vararg ofTables: Table): ForUpdateOption.ForUpdateBase\n```
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#`<init>`().(querySuffix)
          querySuffix: String,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#`<init>`().(querySuffix)
//                    display_name querySuffix
//                    documentation ```kotlin\nquerySuffix: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#`<init>`().(querySuffix)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#`<init>`().(mode)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#mode.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#getMode().
          private val mode: ForUpdateOrShareMode? = null,
//                    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#`<init>`().(mode)
//                         display_name mode
//                         documentation ```kotlin\nmode: ForUpdateOption.ForUpdateOrShareMode? = ...\n```
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#`<init>`().(mode)
//                    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#getMode().
//                         display_name mode
//                         documentation ```kotlin\nprivate get(): ForUpdateOption.ForUpdateOrShareMode?\n```
//                    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#mode.
//                         display_name mode
//                         documentation ```kotlin\nprivate final val mode: ForUpdateOption.ForUpdateOrShareMode?\n```
//                          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#`<init>`().(mode)
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#mode.
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#getMode().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#`<init>`().(ofTables)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#ofTables.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#getOfTables().
          private vararg val ofTables: Table
//                           ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#`<init>`().(ofTables)
//                                    display_name ofTables
//                                    documentation ```kotlin\nvararg ofTables: Table\n```
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#`<init>`().(ofTables)
//                           ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#getOfTables().
//                                    display_name ofTables
//                                    documentation ```kotlin\nprivate get(): Array<out Table>\n```
//                           ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#ofTables.
//                                    display_name ofTables
//                                    documentation ```kotlin\nprivate final val ofTables: Array<out Table>\n```
//                                     ^^^^^ reference semanticdb maven . . kotlin/Array#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#`<init>`().(ofTables)
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#ofTables.
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#getOfTables().
      ) : ForUpdateOption("") {
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#`<init>`().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#preparedQuerySuffix.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#getPreparedQuerySuffix().
          private val preparedQuerySuffix = buildString {
//                    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#getPreparedQuerySuffix().
//                                        display_name preparedQuerySuffix
//                                        documentation ```kotlin\nprivate get(): String\n```
//                    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#preparedQuerySuffix.
//                                        display_name preparedQuerySuffix
//                                        documentation ```kotlin\nprivate final val preparedQuerySuffix: String\n```
//                                          ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
              append(querySuffix)
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#`<init>`().(querySuffix)
//                            ⌄ enclosing_range_start local 0
//                                                       ⌄ enclosing_range_start local 1
              ofTables.takeIf { it.isNotEmpty() }?.let { tables ->
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#getOfTables().
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#ofTables.
//                     ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                            ^^^^^^^^^^^^^^^^^^^ definition local 0
//                                                display_name it
//                                                documentation ```kotlin\nit: Array<out Table>\n```
//                              ^^ reference local 0
//                                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty().
//                                                 ^^^ reference semanticdb maven . . kotlin/let().
//                                                       ^^^^^^ definition local 1
//                                                              display_name tables
//                                                              documentation ```kotlin\ntables: Array<out Table>\n```
//                                              ⌃ enclosing_range_end local 0
//                                                            ⌃ enclosing_range_end local 1
                  append(" OF ")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                                     ⌄ enclosing_range_start local 2
                  tables.joinTo(this, separator = ",") { it.tableName }
//                ^^^^^^ reference local 1
//                       ^^^^^^ reference semanticdb maven . . kotlin/collections/joinTo().
//                                                     ^^^^^^^^^^^^^^^^ definition local 2
//                                                                      display_name it
//                                                                      documentation ```kotlin\nit: Table\n```
//                                                       ^^ reference local 2
//                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                    ⌃ enclosing_range_end local 2
              }
//                      ⌄ enclosing_range_start local 3
              mode?.let {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#getMode().
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#mode.
//                  ^^^ reference semanticdb maven . . kotlin/let().
//                      ^ definition local 3 2:13
//                        display_name it
//                        documentation ```kotlin\nit: ForUpdateOption.ForUpdateOrShareMode\n```
                  append(" ${it.statement}")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                           ^^ reference local 3
//                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#getStatement().
//                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#statement.
              }
//            ⌃ enclosing_range_end local 3
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#preparedQuerySuffix.
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#getPreparedQuerySuffix().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#querySuffix.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#getQuerySuffix().
          final override val querySuffix: String = preparedQuerySuffix
//                           ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#getQuerySuffix().
//                                       display_name querySuffix
//                                       documentation ```kotlin\npublic get(): String\n```
//                           ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#querySuffix.
//                                       display_name querySuffix
//                                       documentation ```kotlin\npublic final override val querySuffix: String\n```
//                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#getPreparedQuerySuffix().
//                                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#preparedQuerySuffix.
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#querySuffix.
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#getQuerySuffix().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdate#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdate#`<init>`().
      /** Common clause that locks the rows retrieved by a SELECT statement against concurrent updates. */
      data object ForUpdate : ForUpdateOption("FOR UPDATE")
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdate#
//                          display_name ForUpdate
//                          documentation ```kotlin\npublic final data object ForUpdate : ForUpdateOption\n```\n\n----\n\n Common clause that locks the rows retrieved by a SELECT statement against concurrent updates.
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdate#`<init>`().
//                          display_name ForUpdate
//                          documentation ```kotlin\nprivate constructor(): ForUpdateOption.ForUpdate\n```\n\n----\n\n Common clause that locks the rows retrieved by a SELECT statement against concurrent updates.
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdate#
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdate#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#`<init>`().
      // https://dev.mysql.com/doc/refman/8.0/en/innodb-locking-reads.html for clarification
      object MySQL {
//           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#
//                 display_name MySQL
//                 documentation ```kotlin\npublic final object MySQL : Any\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#`<init>`().
//                 display_name MySQL
//                 documentation ```kotlin\nprivate constructor(): ForUpdateOption.MySQL\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#values().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#valueOf().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#valueOf().(value)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#entries.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getEntries().
          /** Optional modes that determine what should happen if the retrieved rows are not immediately available. */
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Enum# 8:9
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE# 8:9
          // https://dev.mysql.com/doc/refman/8.4/en/select.html
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#`<init>`().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#`<init>`().(statement)
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#statement.
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#getStatement().
          enum class MODE(override val statement: String) : ForUpdateOrShareMode {
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#
//                        display_name MODE
//                        documentation ```kotlin\npublic final enum class MODE : ForUpdateOption.ForUpdateOrShareMode, Enum<ForUpdateOption.MySQL.MODE>\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 1988>`#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 2083>`#
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#`<init>`().
//                        display_name MODE
//                        documentation ```kotlin\nprivate constructor(statement: String): ForUpdateOption.MySQL.MODE\n```
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#entries.
//                        display_name entries
//                        documentation ```kotlin\npublic final static val entries: EnumEntries<ForUpdateOption.MySQL.MODE>\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#valueOf().
//                        display_name valueOf
//                        documentation ```kotlin\npublic final static fun valueOf(value: String): ForUpdateOption.MySQL.MODE\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#valueOf().(value)
//                        display_name value
//                        documentation ```kotlin\nvalue: String\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#values().
//                        display_name values
//                        documentation ```kotlin\npublic final static fun values(): Array<ForUpdateOption.MySQL.MODE>\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getEntries().
//                        display_name entries
//                        documentation ```kotlin\npublic get(): EnumEntries<ForUpdateOption.PostgreSQL.MODE>\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//                                     ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#`<init>`().(statement)
//                                               display_name statement
//                                               documentation ```kotlin\nstatement: String\n```
//                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#`<init>`().(statement)
//                                     ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#getStatement().
//                                               display_name statement
//                                               documentation ```kotlin\npublic get(): String\n```
//                                     ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#statement.
//                                               display_name statement
//                                               documentation ```kotlin\npublic open override val statement: String\n```
//                                                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#`<init>`().(statement)
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#statement.
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#getStatement().
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#`<init>`().
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 1988>`#
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 1988>`#`<init>`().
              /** Indicates that an error should be reported. */
              NO_WAIT("NOWAIT"),
//            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 1988>`#
//                    display_name <anonymous>
//                    documentation ```kotlin\nobject : ForUpdateOption.MySQL.MODE\n```\n\n----\n\n Indicates that an error should be reported.
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#
//            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 1988>`#`<init>`().
//                    display_name NO_WAIT
//                    documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n Indicates that an error should be reported.
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 1988>`#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 1988>`#`<init>`().
  
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 2083>`#
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 2083>`#`<init>`().
              /** Indicates that the unavailable rows should be skipped. */
              SKIP_LOCKED("SKIP LOCKED")
//            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 2083>`#
//                        display_name <anonymous>
//                        documentation ```kotlin\nobject : ForUpdateOption.MySQL.MODE\n```\n\n----\n\n Indicates that the unavailable rows should be skipped.
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#
//            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 2083>`#`<init>`().
//                        display_name SKIP_LOCKED
//                        documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n Indicates that the unavailable rows should be skipped.
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 2083>`#
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 2083>`#`<init>`().
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#values().
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#valueOf().
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#valueOf().(value)
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#entries.
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getEntries().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForUpdate#
          /** MySQL clause that locks the rows retrieved as though for update. */
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForUpdate#`<init>`().
          class ForUpdate(
//              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForUpdate#
//                        display_name ForUpdate
//                        documentation ```kotlin\npublic final class ForUpdate : ForUpdateOption.ForUpdateBase\n```\n\n----\n\n MySQL clause that locks the rows retrieved as though for update.
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
//              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForUpdate#`<init>`().
//                        display_name ForUpdate
//                        documentation ```kotlin\npublic constructor(mode: ForUpdateOption.MySQL.MODE? = ..., vararg ofTables: Table): ForUpdateOption.MySQL.ForUpdate\n```
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForUpdate#`<init>`().(mode)
              mode: MODE? = null,
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForUpdate#`<init>`().(mode)
//                 display_name mode
//                 documentation ```kotlin\nmode: ForUpdateOption.MySQL.MODE? = ...\n```
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForUpdate#`<init>`().(mode)
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForUpdate#`<init>`().(ofTables)
              vararg ofTables: Table
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForUpdate#`<init>`().(ofTables)
//                            display_name ofTables
//                            documentation ```kotlin\nvararg ofTables: Table\n```
//                             ^^^^^ reference semanticdb maven . . kotlin/Array#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForUpdate#`<init>`().(ofTables)
          ) : ForUpdateBase("FOR UPDATE", mode, ofTables = ofTables)
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForUpdate#`<init>`().(mode)
//                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForUpdate#`<init>`().(ofTables)
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForUpdate#`<init>`().
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForUpdate#
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#
          /** MySQL clause that acquires a shared lock for each row retrieved. */
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#`<init>`().
          open class ForShare(
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#
//                            display_name ForShare
//                            documentation ```kotlin\npublic open class ForShare : ForUpdateOption.ForUpdateBase\n```\n\n----\n\n MySQL clause that acquires a shared lock for each row retrieved.
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#Companion#
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#`<init>`().
//                            display_name ForShare
//                            documentation ```kotlin\npublic constructor(mode: ForUpdateOption.MySQL.MODE? = ..., vararg ofTables: Table): ForUpdateOption.MySQL.ForShare\n```
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#`<init>`().(mode)
              mode: MODE? = null,
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#`<init>`().(mode)
//                 display_name mode
//                 documentation ```kotlin\nmode: ForUpdateOption.MySQL.MODE? = ...\n```
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#MODE#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#`<init>`().(mode)
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#`<init>`().(ofTables)
              vararg ofTables: Table
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#`<init>`().(ofTables)
//                            display_name ofTables
//                            documentation ```kotlin\nvararg ofTables: Table\n```
//                             ^^^^^ reference semanticdb maven . . kotlin/Array#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#`<init>`().(ofTables)
          ) : ForUpdateBase("FOR SHARE", mode, ofTables = ofTables) {
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
//                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#`<init>`().(mode)
//                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#`<init>`().(ofTables)
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#`<init>`().
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#Companion#
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#Companion#`<init>`().
              companion object : ForShare()
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#Companion#
//                                          display_name Companion
//                                          documentation ```kotlin\npublic final companion object Companion : ForUpdateOption.MySQL.ForShare\n```
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#Companion#`<init>`().
//                                          display_name Companion
//                                          documentation ```kotlin\nprivate constructor(): ForUpdateOption.MySQL.ForShare.Companion\n```
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#Companion#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#Companion#`<init>`().
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#ForShare#
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#LockInShareMode#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#LockInShareMode#`<init>`().
          /** This MySQL clause is equivalent to [ForShare] but exists for backward compatibility. */
          data object LockInShareMode : ForUpdateOption("LOCK IN SHARE MODE")
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#LockInShareMode#
//                                    display_name LockInShareMode
//                                    documentation ```kotlin\npublic final data object LockInShareMode : ForUpdateOption\n```\n\n----\n\n This MySQL clause is equivalent to [ForShare] but exists for backward compatibility.
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#LockInShareMode#`<init>`().
//                                    display_name LockInShareMode
//                                    documentation ```kotlin\nprivate constructor(): ForUpdateOption.MySQL.LockInShareMode\n```\n\n----\n\n This MySQL clause is equivalent to [ForShare] but exists for backward compatibility.
//                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#LockInShareMode#
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#LockInShareMode#`<init>`().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MySQL#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MariaDB#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MariaDB#`<init>`().
      // https://mariadb.com/kb/en/select/#lock-in-share-modefor-update
      object MariaDB {
//           ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MariaDB#
//                   display_name MariaDB
//                   documentation ```kotlin\npublic final object MariaDB : Any\n```\n\n----\n\n MariaDB clause that acquires a shared lock for each row retrieved.
//           ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MariaDB#`<init>`().
//                   display_name MariaDB
//                   documentation ```kotlin\nprivate constructor(): ForUpdateOption.MariaDB\n```\n\n----\n\n MariaDB clause that acquires a shared lock for each row retrieved.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MariaDB#LockInShareMode#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MariaDB#LockInShareMode#`<init>`().
          /** MariaDB clause that acquires a shared lock for each row retrieved. */
          data object LockInShareMode : ForUpdateOption("LOCK IN SHARE MODE")
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MariaDB#LockInShareMode#
//                                    display_name LockInShareMode
//                                    documentation ```kotlin\npublic final data object LockInShareMode : ForUpdateOption\n```\n\n----\n\n MariaDB clause that acquires a shared lock for each row retrieved.
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MariaDB#LockInShareMode#`<init>`().
//                                    display_name LockInShareMode
//                                    documentation ```kotlin\nprivate constructor(): ForUpdateOption.MariaDB.LockInShareMode\n```\n\n----\n\n MariaDB clause that acquires a shared lock for each row retrieved.
//                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MariaDB#LockInShareMode#
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MariaDB#LockInShareMode#`<init>`().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MariaDB#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#MariaDB#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#`<init>`().
      // https://www.postgresql.org/docs/current/sql-select.html
      // https://www.postgresql.org/docs/12/explicit-locking.html#LOCKING-ROWS for clarification
      object PostgreSQL {
//           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#
//                      display_name PostgreSQL
//                      documentation ```kotlin\npublic final object PostgreSQL : Any\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#`<init>`().
//                      display_name PostgreSQL
//                      documentation ```kotlin\nprivate constructor(): ForUpdateOption.PostgreSQL\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#values().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#valueOf().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#valueOf().(value)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#entries.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getEntries().
          /** Optional modes that determine what should happen if the retrieved rows are not immediately available. */
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Enum# 7:9
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE# 7:9
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#`<init>`().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#`<init>`().(statement)
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#statement.
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#getStatement().
          enum class MODE(override val statement: String) : ForUpdateOrShareMode {
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#
//                        display_name MODE
//                        documentation ```kotlin\npublic final enum class MODE : ForUpdateOption.ForUpdateOrShareMode, Enum<ForUpdateOption.PostgreSQL.MODE>\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 3563>`#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 3658>`#
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#`<init>`().
//                        display_name MODE
//                        documentation ```kotlin\nprivate constructor(statement: String): ForUpdateOption.PostgreSQL.MODE\n```
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#entries.
//                        display_name entries
//                        documentation ```kotlin\npublic final static val entries: EnumEntries<ForUpdateOption.PostgreSQL.MODE>\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#valueOf().
//                        display_name valueOf
//                        documentation ```kotlin\npublic final static fun valueOf(value: String): ForUpdateOption.PostgreSQL.MODE\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#valueOf().(value)
//                        display_name value
//                        documentation ```kotlin\nvalue: String\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#values().
//                        display_name values
//                        documentation ```kotlin\npublic final static fun values(): Array<ForUpdateOption.PostgreSQL.MODE>\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getEntries().
//                        display_name entries
//                        documentation ```kotlin\npublic get(): EnumEntries<ForUpdateOption.PostgreSQL.MODE>\n```\n\n----\n\n Optional modes that determine what should happen if the retrieved rows are not immediately available.
//                                     ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#`<init>`().(statement)
//                                               display_name statement
//                                               documentation ```kotlin\nstatement: String\n```
//                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#`<init>`().(statement)
//                                     ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#getStatement().
//                                               display_name statement
//                                               documentation ```kotlin\npublic get(): String\n```
//                                     ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#statement.
//                                               display_name statement
//                                               documentation ```kotlin\npublic open override val statement: String\n```
//                                                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateOrShareMode#
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#`<init>`().(statement)
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#statement.
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#getStatement().
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#`<init>`().
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 3563>`#
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 3563>`#`<init>`().
              /** Indicates that an error should be reported. */
              NO_WAIT("NOWAIT"),
//            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 3563>`#
//                    display_name <anonymous>
//                    documentation ```kotlin\nobject : ForUpdateOption.PostgreSQL.MODE\n```\n\n----\n\n Indicates that an error should be reported.
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#
//            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 3563>`#`<init>`().
//                    display_name NO_WAIT
//                    documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n Indicates that an error should be reported.
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 3563>`#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 3563>`#`<init>`().
  
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 3658>`#
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 3658>`#`<init>`().
              /** Indicates that the unavailable rows should be skipped. */
              SKIP_LOCKED("SKIP LOCKED")
//            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 3658>`#
//                        display_name <anonymous>
//                        documentation ```kotlin\nobject : ForUpdateOption.PostgreSQL.MODE\n```\n\n----\n\n Indicates that the unavailable rows should be skipped.
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#
//            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 3658>`#`<init>`().
//                        display_name SKIP_LOCKED
//                        documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n Indicates that the unavailable rows should be skipped.
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 3658>`#
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 3658>`#`<init>`().
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#values().
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#valueOf().
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#valueOf().(value)
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#entries.
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getEntries().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForUpdate#
          /** PostgreSQL clause that locks the rows retrieved as though for update. */
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForUpdate#`<init>`().
          class ForUpdate(
//              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForUpdate#
//                        display_name ForUpdate
//                        documentation ```kotlin\npublic final class ForUpdate : ForUpdateOption.ForUpdateBase\n```\n\n----\n\n PostgreSQL clause that locks the rows retrieved as though for update.
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
//              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForUpdate#`<init>`().
//                        display_name ForUpdate
//                        documentation ```kotlin\npublic constructor(mode: ForUpdateOption.PostgreSQL.MODE? = ..., vararg ofTables: Table): ForUpdateOption.PostgreSQL.ForUpdate\n```
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForUpdate#`<init>`().(mode)
              mode: MODE? = null,
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForUpdate#`<init>`().(mode)
//                 display_name mode
//                 documentation ```kotlin\nmode: ForUpdateOption.PostgreSQL.MODE? = ...\n```
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForUpdate#`<init>`().(mode)
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForUpdate#`<init>`().(ofTables)
              vararg ofTables: Table
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForUpdate#`<init>`().(ofTables)
//                            display_name ofTables
//                            documentation ```kotlin\nvararg ofTables: Table\n```
//                             ^^^^^ reference semanticdb maven . . kotlin/Array#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForUpdate#`<init>`().(ofTables)
          ) : ForUpdateBase("FOR UPDATE", mode, ofTables = ofTables)
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForUpdate#`<init>`().(mode)
//                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForUpdate#`<init>`().(ofTables)
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForUpdate#`<init>`().
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForUpdate#
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#
          /** PostgreSQL clause that locks the rows retrieved, but at a weaker strength than [ForUpdate]. */
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#`<init>`().
          open class ForNoKeyUpdate(
//                   ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#
//                                  display_name ForNoKeyUpdate
//                                  documentation ```kotlin\npublic open class ForNoKeyUpdate : ForUpdateOption.ForUpdateBase\n```\n\n----\n\n PostgreSQL clause that locks the rows retrieved, but at a weaker strength than [ForUpdate].
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#Companion#
//                   ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#`<init>`().
//                                  display_name ForNoKeyUpdate
//                                  documentation ```kotlin\npublic constructor(mode: ForUpdateOption.PostgreSQL.MODE? = ..., vararg ofTables: Table): ForUpdateOption.PostgreSQL.ForNoKeyUpdate\n```
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#`<init>`().(mode)
              mode: MODE? = null,
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#`<init>`().(mode)
//                 display_name mode
//                 documentation ```kotlin\nmode: ForUpdateOption.PostgreSQL.MODE? = ...\n```
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#`<init>`().(mode)
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#`<init>`().(ofTables)
              vararg ofTables: Table
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#`<init>`().(ofTables)
//                            display_name ofTables
//                            documentation ```kotlin\nvararg ofTables: Table\n```
//                             ^^^^^ reference semanticdb maven . . kotlin/Array#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#`<init>`().(ofTables)
          ) : ForUpdateBase("FOR NO KEY UPDATE", mode, ofTables = ofTables) {
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
//                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#`<init>`().(mode)
//                                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#`<init>`().(ofTables)
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#`<init>`().
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#Companion#
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#Companion#`<init>`().
              companion object : ForNoKeyUpdate()
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#Companion#
//                                                display_name Companion
//                                                documentation ```kotlin\npublic final companion object Companion : ForUpdateOption.PostgreSQL.ForNoKeyUpdate\n```
//                                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#Companion#`<init>`().
//                                                display_name Companion
//                                                documentation ```kotlin\nprivate constructor(): ForUpdateOption.PostgreSQL.ForNoKeyUpdate.Companion\n```
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#Companion#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#Companion#`<init>`().
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForNoKeyUpdate#
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#
          /** PostgreSQL clause that acquires a shared lock for each row retrieved. */
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#`<init>`().
          open class ForShare(
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#
//                            display_name ForShare
//                            documentation ```kotlin\npublic open class ForShare : ForUpdateOption.ForUpdateBase\n```\n\n----\n\n PostgreSQL clause that acquires a shared lock for each row retrieved.
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#Companion#
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#`<init>`().
//                            display_name ForShare
//                            documentation ```kotlin\npublic constructor(mode: ForUpdateOption.PostgreSQL.MODE? = ..., vararg ofTables: Table): ForUpdateOption.PostgreSQL.ForShare\n```
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#`<init>`().(mode)
              mode: MODE? = null,
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#`<init>`().(mode)
//                 display_name mode
//                 documentation ```kotlin\nmode: ForUpdateOption.PostgreSQL.MODE? = ...\n```
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#`<init>`().(mode)
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#`<init>`().(ofTables)
              vararg ofTables: Table
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#`<init>`().(ofTables)
//                            display_name ofTables
//                            documentation ```kotlin\nvararg ofTables: Table\n```
//                             ^^^^^ reference semanticdb maven . . kotlin/Array#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#`<init>`().(ofTables)
          ) : ForUpdateBase("FOR SHARE", mode, ofTables = ofTables) {
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
//                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#`<init>`().(mode)
//                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#`<init>`().(ofTables)
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#`<init>`().
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#Companion#
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#Companion#`<init>`().
              companion object : ForShare()
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#Companion#
//                                          display_name Companion
//                                          documentation ```kotlin\npublic final companion object Companion : ForUpdateOption.PostgreSQL.ForShare\n```
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#Companion#`<init>`().
//                                          display_name Companion
//                                          documentation ```kotlin\nprivate constructor(): ForUpdateOption.PostgreSQL.ForShare.Companion\n```
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#Companion#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#Companion#`<init>`().
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForShare#
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#
          /** PostgreSQL clause that acquires a shared lock for each row, but at a weaker strength than [ForShare]. */
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#`<init>`().
          open class ForKeyShare(
//                   ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#
//                               display_name ForKeyShare
//                               documentation ```kotlin\npublic open class ForKeyShare : ForUpdateOption.ForUpdateBase\n```\n\n----\n\n PostgreSQL clause that acquires a shared lock for each row, but at a weaker strength than [ForShare].
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#Companion#
//                   ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#`<init>`().
//                               display_name ForKeyShare
//                               documentation ```kotlin\npublic constructor(mode: ForUpdateOption.PostgreSQL.MODE? = ..., vararg ofTables: Table): ForUpdateOption.PostgreSQL.ForKeyShare\n```
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#`<init>`().(mode)
              mode: MODE? = null,
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#`<init>`().(mode)
//                 display_name mode
//                 documentation ```kotlin\nmode: ForUpdateOption.PostgreSQL.MODE? = ...\n```
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#MODE#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#`<init>`().(mode)
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#`<init>`().(ofTables)
              vararg ofTables: Table
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#`<init>`().(ofTables)
//                            display_name ofTables
//                            documentation ```kotlin\nvararg ofTables: Table\n```
//                             ^^^^^ reference semanticdb maven . . kotlin/Array#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#`<init>`().(ofTables)
          ) : ForUpdateBase("FOR KEY SHARE", mode, ofTables = ofTables) {
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#ForUpdateBase#
//                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#`<init>`().(mode)
//                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#`<init>`().(ofTables)
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#`<init>`().
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#Companion#
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#Companion#`<init>`().
              companion object : ForKeyShare()
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#Companion#
//                                             display_name Companion
//                                             documentation ```kotlin\npublic final companion object Companion : ForUpdateOption.PostgreSQL.ForKeyShare\n```
//                                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#Companion#`<init>`().
//                                             display_name Companion
//                                             documentation ```kotlin\nprivate constructor(): ForUpdateOption.PostgreSQL.ForKeyShare.Companion\n```
//                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#Companion#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#Companion#`<init>`().
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#ForKeyShare#
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#PostgreSQL#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#`<init>`().
      // https://docs.oracle.com/cd/B19306_01/server.102/b14200/statements_10002.htm#i2066346
      object Oracle {
//           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#
//                  display_name Oracle
//                  documentation ```kotlin\npublic final object Oracle : Any\n```\n\n----\n\n Oracle clause that never waits to acquire a row lock.
//           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#`<init>`().
//                  display_name Oracle
//                  documentation ```kotlin\nprivate constructor(): ForUpdateOption.Oracle\n```\n\n----\n\n Oracle clause that never waits to acquire a row lock.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateNoWait#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateNoWait#`<init>`().
          /** Oracle clause that never waits to acquire a row lock. */
          data object ForUpdateNoWait : ForUpdateOption("FOR UPDATE NOWAIT")
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateNoWait#
//                                    display_name ForUpdateNoWait
//                                    documentation ```kotlin\npublic final data object ForUpdateNoWait : ForUpdateOption\n```\n\n----\n\n Oracle clause that never waits to acquire a row lock.
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateNoWait#`<init>`().
//                                    display_name ForUpdateNoWait
//                                    documentation ```kotlin\nprivate constructor(): ForUpdateOption.Oracle.ForUpdateNoWait\n```\n\n----\n\n Oracle clause that never waits to acquire a row lock.
//                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateNoWait#
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateNoWait#`<init>`().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateWait#
          /** Oracle clause that waits for the provided timeout until the row becomes available. */
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateWait#`<init>`().
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateWait#`<init>`().(timeout)
          class ForUpdateWait(timeout: Int) : ForUpdateOption("FOR UPDATE WAIT $timeout")
//              ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateWait#
//                            display_name ForUpdateWait
//                            documentation ```kotlin\npublic final class ForUpdateWait : ForUpdateOption\n```\n\n----\n\n Oracle clause that waits for the provided timeout until the row becomes available.
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
//              ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateWait#`<init>`().
//                            display_name ForUpdateWait
//                            documentation ```kotlin\npublic constructor(timeout: Int): ForUpdateOption.Oracle.ForUpdateWait\n```
//                            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateWait#`<init>`().(timeout)
//                                    display_name timeout
//                                    documentation ```kotlin\ntimeout: Int\n```
//                                     ^^^ reference semanticdb maven . . kotlin/Int#
//                                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
//                                                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateWait#`<init>`().(timeout)
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateWait#`<init>`().(timeout)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateWait#`<init>`().
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#ForUpdateWait#
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#Oracle#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ForUpdateOption#
