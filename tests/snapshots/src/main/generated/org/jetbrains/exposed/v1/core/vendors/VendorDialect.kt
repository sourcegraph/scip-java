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
  import org.jetbrains.exposed.v1.core.Function
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
  import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
  /**
   * Base implementation of a vendor dialect
   */
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().
  abstract class VendorDialect(
//               ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
//                             display_name VendorDialect
//                             documentation ```kotlin\npublic abstract class VendorDialect : DatabaseDialect\n```\n\n----\n\n\n Base implementation of a vendor dialect\n
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#
//               ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().
//                             display_name VendorDialect
//                             documentation ```kotlin\npublic constructor(name: String, dataTypeProvider: DataTypeProvider, functionProvider: FunctionProvider): VendorDialect\n```
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(name)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#name.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getName().
      override val name: String,
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(name)
//                      display_name name
//                      documentation ```kotlin\nname: String\n```
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(name)
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getName().
//                      display_name name
//                      documentation ```kotlin\npublic get(): String\n```
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#name.
//                      display_name name
//                      documentation ```kotlin\npublic open override val name: String\n```
//                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(name)
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#name.
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getName().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(dataTypeProvider)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
      override val dataTypeProvider: DataTypeProvider,
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(dataTypeProvider)
//                                  display_name dataTypeProvider
//                                  documentation ```kotlin\ndataTypeProvider: DataTypeProvider\n```
//                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(dataTypeProvider)
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                  display_name dataTypeProvider
//                                  documentation ```kotlin\npublic open override val dataTypeProvider: DataTypeProvider\n```
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                  display_name dataTypeProvider
//                                  documentation ```kotlin\npublic get(): DataTypeProvider\n```
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(dataTypeProvider)
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(functionProvider)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#functionProvider.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getFunctionProvider().
      override val functionProvider: FunctionProvider
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(functionProvider)
//                                  display_name functionProvider
//                                  documentation ```kotlin\nfunctionProvider: FunctionProvider\n```
//                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(functionProvider)
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#functionProvider.
//                                  display_name functionProvider
//                                  documentation ```kotlin\npublic open override val functionProvider: FunctionProvider\n```
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getFunctionProvider().
//                                  display_name functionProvider
//                                  documentation ```kotlin\npublic get(): FunctionProvider\n```
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(functionProvider)
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#functionProvider.
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getFunctionProvider().
  ) : DatabaseDialect {
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
      protected val identifierManager
//                  ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                    display_name identifierManager
//                                    documentation ```kotlin\nprotected final val identifierManager: IdentifierManagerApi\n```
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
          @OptIn(InternalApi::class)
          get() = CoreTransactionManager.currentTransaction().db.identifierManager
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//            display_name identifierManager
//            documentation ```kotlin\n@OptIn(...) protected get(): IdentifierManagerApi\n```
//                                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
//                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
      @Suppress("UnnecessaryAbstractClass")
//                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#`<init>`().
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#`<init>`().(dialectName)
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
      abstract class DialectNameProvider(val dialectName: String)
//                   ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//                                       display_name DialectNameProvider
//                                       documentation ```kotlin\n@Suppress(...) public abstract class DialectNameProvider : Any\n```
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#Companion#
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#Companion#
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#Companion#
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#Companion#
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#Companion#
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#Companion#
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#Companion#
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#Companion#
//                   ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#`<init>`().
//                                       display_name DialectNameProvider
//                                       documentation ```kotlin\npublic constructor(dialectName: String): VendorDialect.DialectNameProvider\n```
//                                           ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#`<init>`().(dialectName)
//                                                       display_name dialectName
//                                                       documentation ```kotlin\ndialectName: String\n```
//                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#`<init>`().(dialectName)
//                                           ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                                                       display_name dialectName
//                                                       documentation ```kotlin\npublic final val dialectName: String\n```
//                                           ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
//                                                       display_name dialectName
//                                                       documentation ```kotlin\npublic get(): String\n```
//                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#`<init>`().(dialectName)
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#supportsMultipleGeneratedKeys.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getSupportsMultipleGeneratedKeys().
      override val supportsMultipleGeneratedKeys: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getSupportsMultipleGeneratedKeys().
//                                               display_name supportsMultipleGeneratedKeys
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#supportsMultipleGeneratedKeys.
//                                               display_name supportsMultipleGeneratedKeys
//                                               documentation ```kotlin\npublic open override val supportsMultipleGeneratedKeys: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#supportsMultipleGeneratedKeys.
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getSupportsMultipleGeneratedKeys().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#filterCondition().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#filterCondition().(index)
      fun filterCondition(index: Index): String? {
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#filterCondition().
//                        display_name filterCondition
//                        documentation ```kotlin\npublic final fun filterCondition(index: Index): String?\n```
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#filterCondition().(index)
//                              display_name index
//                              documentation ```kotlin\nindex: Index\n```
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#
//                                       ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#filterCondition().(index)
//                                          ⌄ enclosing_range_start local 0
          return index.filterCondition?.let {
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#filterCondition().(index)
//                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#filterCondition.
//                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFilterCondition().
//                                      ^^^ reference semanticdb maven . . kotlin/let().
//                                          ^ definition local 0 13:9
//                                            display_name it
//                                            documentation ```kotlin\nit: Op<Boolean>\n```
//                  ⌄ enclosing_range_start local 1
              when (currentDialect) {
//                  ^^^^^^^^^^^^^^ definition local 1
//                                 display_name <when-subject>
//                                 documentation ```kotlin\nlocal val <when-subject>: DatabaseDialect\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                               ⌃ enclosing_range_end local 1
                  is PostgreSQLDialect, is SQLServerDialect, is SQLiteDialect -> {
//                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#
//                                                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#
                      QueryBuilder(false)
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
                          .append(" WHERE ").append(it)
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                                                  ^^ reference local 0
                          .toString()
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
                  }
  
                  else -> {
                      exposedLogger.warn("Index creation with a filter condition is not supported in ${currentDialect.name}")
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                                  ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                                                                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//                                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
                      return null
                  }
              }
          } ?: ""
//        ⌃ enclosing_range_end local 0
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#filterCondition().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#indexFunctionToString().
//                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#indexFunctionToString().(function)
      private fun indexFunctionToString(function: Function<*>): String {
//                ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#indexFunctionToString().
//                                      display_name indexFunctionToString
//                                      documentation ```kotlin\nprivate final fun indexFunctionToString(function: Function<*>): String\n```
//                                      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#indexFunctionToString().(function)
//                                               display_name function
//                                               documentation ```kotlin\nfunction: Function<*>\n```
//                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#indexFunctionToString().(function)
//        ⌄ enclosing_range_start local 2
          val baseString = function.toString()
//            ^^^^^^^^^^ definition local 2
//                       display_name baseString
//                       documentation ```kotlin\nlocal val baseString: String\n```
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#indexFunctionToString().(function)
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toString().
//                                           ⌃ enclosing_range_end local 2
//                     ⌄ enclosing_range_start local 3
          return when (currentDialect) {
//                     ^^^^^^^^^^^^^^ definition local 3
//                                    display_name <when-subject>
//                                    documentation ```kotlin\nlocal val <when-subject>: DatabaseDialect\n```
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                  ⌃ enclosing_range_end local 3
              // SQLite & Oracle do not support "." operator (with table prefix) in index expressions
              is SQLiteDialect, is OracleDialect -> baseString.replace(Regex("""^*[^( ]*\."""), "")
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#
//                                 ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                                                  ^^^^^^^^^^ reference local 2
//                                                             ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+2).
//                                                                     ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
              is MysqlDialect -> if (baseString.first() != '(') "($baseString)" else baseString
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                                   ^^^^^^^^^^ reference local 2
//                                              ^^^^^ reference semanticdb maven . . kotlin/text/first().
//                                                                 ^^^^^^^^^^ reference local 2
//                                                                                   ^^^^^^^^^^ reference local 2
              else -> baseString
//                    ^^^^^^^^^^ reference local 2
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#indexFunctionToString().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().
      /**
       * Uniqueness might be required for foreign key constraints.
       *
       * In PostgreSQL (https://www.postgresql.org/docs/current/indexes-unique.html), UNIQUE means B-tree only.
       * Unique constraints can not be partial
       * Unique indexes can be partial
       */
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
      override fun createIndex(index: Index): String {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().
//                             display_name createIndex
//                             documentation ```kotlin\npublic open override fun createIndex(index: Index): String\n```\n\n----\n\n\n Uniqueness might be required for foreign key constraints.\n\n In PostgreSQL (https://www.postgresql.org/docs/current/indexes-unique.html), UNIQUE means B-tree only.\n Unique constraints can not be partial\n Unique indexes can be partial\n
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createIndex().
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createIndex().
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createIndex().
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndex().
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                                   display_name index
//                                   documentation ```kotlin\nindex: Index\n```
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#
//                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//        ⌄ enclosing_range_start local 4
          @OptIn(InternalApi::class)
          val t = CoreTransactionManager.currentTransaction()
//            ^ definition local 4
//              display_name t
//              documentation ```kotlin\n@OptIn(...) local val t: Transaction\n```
//                                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                          ⌃ enclosing_range_end local 4
//        ⌄ enclosing_range_start local 5
          val quotedTableName = t.identity(index.table)
//            ^^^^^^^^^^^^^^^ definition local 5
//                            display_name quotedTableName
//                            documentation ```kotlin\nlocal val quotedTableName: String\n```
//                              ^ reference local 4
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                                                    ⌃ enclosing_range_end local 5
//        ⌄ enclosing_range_start local 6
          val quotedIndexName = t.db.identifierManager.cutIfNecessaryAndQuote(index.indexName)
//            ^^^^^^^^^^^^^^^ definition local 6
//                            display_name quotedIndexName
//                            documentation ```kotlin\nlocal val quotedIndexName: String\n```
//                              ^ reference local 4
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
//                                                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
//                                                                                           ⌃ enclosing_range_end local 6
//        ⌄ enclosing_range_start local 7
          val keyFields = index.columns.plus(index.functions ?: emptyList())
//            ^^^^^^^^^ definition local 7
//                      display_name keyFields
//                      documentation ```kotlin\nlocal val keyFields: List<ExpressionWithColumnType<*>>\n```
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                                      ^^^^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
//                                                              ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
//                                                                         ⌃ enclosing_range_end local 7
//        ⌄ enclosing_range_start local 8
//                                                                             ⌄ enclosing_range_start local 9
          val fieldsList = keyFields.joinToString(prefix = "(", postfix = ")") {
//            ^^^^^^^^^^ definition local 8
//                       display_name fieldsList
//                       documentation ```kotlin\nlocal val fieldsList: String\n```
//                         ^^^^^^^^^ reference local 7
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                             ^ definition local 9 11:9
//                                                                               display_name it
//                                                                               documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                  ⌄ enclosing_range_start local 10
              when (it) {
//                  ^^ definition local 10
//                     display_name <when-subject>
//                     documentation ```kotlin\nlocal val <when-subject>: ExpressionWithColumnType<*>\n```
//                  ^^ reference local 9
//                   ⌃ enclosing_range_end local 10
                  is Column<*> -> t.identity(it)
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                ^ reference local 4
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                           ^^ reference local 9
                  is Function<*> -> indexFunctionToString(it)
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                                  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#indexFunctionToString().
//                                                        ^^ reference local 9
                  // returned by existingIndices() mapping String metadata to stringLiteral()
                  is LiteralOp<*> -> it.value.toString().trim('"')
//                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                   ^^ reference local 9
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getValue().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#value.
//                                            ^^^^^^^^ reference semanticdb maven . . kotlin/toString().
//                                                       ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
                  else -> {
                      exposedLogger.warn("Unexpected defining key field will be passed as String: $it")
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                                  ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                                                                                 ^^ reference local 9
                      it.toString()
//                    ^^ reference local 9
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toString().
                  }
              }
          }
//        ⌃ enclosing_range_end local 8
//        ⌃ enclosing_range_end local 9
//        ⌄ enclosing_range_start local 11
          val includesOnlyColumns = index.functions?.isEmpty() != false
//            ^^^^^^^^^^^^^^^^^^^ definition local 11
//                                display_name includesOnlyColumns
//                                documentation ```kotlin\nlocal val includesOnlyColumns: Boolean\n```
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
//                                                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#isEmpty().
//                                                                    ⌃ enclosing_range_end local 11
//        ⌄ enclosing_range_start local 12
          val maybeFilterCondition = filterCondition(index) ?: return ""
//            ^^^^^^^^^^^^^^^^^^^^ definition local 12
//                                 display_name maybeFilterCondition
//                                 documentation ```kotlin\nlocal val maybeFilterCondition: String\n```
//                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#filterCondition().
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                                                                     ⌃ enclosing_range_end local 12
  
          return when {
              // unique and no filter -> constraint, the type is not supported
              index.unique && maybeFilterCondition.isEmpty() && includesOnlyColumns -> {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
//                            ^^^^^^^^^^^^^^^^^^^^ reference local 12
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/text/isEmpty().
//                                                              ^^^^^^^^^^^^^^^^^^^ reference local 11
                  "ALTER TABLE $quotedTableName ADD CONSTRAINT $quotedIndexName UNIQUE $fieldsList"
//                              ^^^^^^^^^^^^^^^ reference local 5
//                                                              ^^^^^^^^^^^^^^^ reference local 6
//                                                                                      ^^^^^^^^^^ reference local 8
              }
              // unique and filter -> index only, the type is not supported
              index.unique -> {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
                  "CREATE UNIQUE INDEX $quotedIndexName ON $quotedTableName $fieldsList$maybeFilterCondition"
//                                      ^^^^^^^^^^^^^^^ reference local 6
//                                                          ^^^^^^^^^^^^^^^ reference local 5
//                                                                           ^^^^^^^^^^ reference local 8
//                                                                                      ^^^^^^^^^^^^^^^^^^^^ reference local 12
              }
              // type -> can't be unique or constraint
              index.indexType != null -> {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexType().
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexType.
                  createIndexWithType(
//                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().
                      name = quotedIndexName, table = quotedTableName,
//                           ^^^^^^^^^^^^^^^ reference local 6
//                                                    ^^^^^^^^^^^^^^^ reference local 5
                      columns = fieldsList, type = index.indexType, filterCondition = maybeFilterCondition
//                              ^^^^^^^^^^ reference local 8
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexType().
//                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexType.
//                                                                                    ^^^^^^^^^^^^^^^^^^^^ reference local 12
                  )
              }
  
              else -> {
                  "CREATE INDEX $quotedIndexName ON $quotedTableName $fieldsList$maybeFilterCondition"
//                               ^^^^^^^^^^^^^^^ reference local 6
//                                                   ^^^^^^^^^^^^^^^ reference local 5
//                                                                    ^^^^^^^^^^ reference local 8
//                                                                               ^^^^^^^^^^^^^^^^^^^^ reference local 12
              }
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().
//                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(name)
//                                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(table)
//                                                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(columns)
//                                                                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(type)
//                                                                                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(filterCondition)
      protected open fun createIndexWithType(name: String, table: String, columns: String, type: String, filterCondition: String): String {
//                       ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().
//                                           display_name createIndexWithType
//                                           documentation ```kotlin\nprotected open fun createIndexWithType(name: String, table: String, columns: String, type: String, filterCondition: String): String\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndexWithType().
//                                           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(name)
//                                                display_name name
//                                                documentation ```kotlin\nname: String\n```
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(table)
//                                                               display_name table
//                                                               documentation ```kotlin\ntable: String\n```
//                                                                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(columns)
//                                                                                display_name columns
//                                                                                documentation ```kotlin\ncolumns: String\n```
//                                                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(type)
//                                                                                              display_name type
//                                                                                              documentation ```kotlin\ntype: String\n```
//                                                                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                                       ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(filterCondition)
//                                                                                                                       display_name filterCondition
//                                                                                                                       documentation ```kotlin\nfilterCondition: String\n```
//                                                                                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(name)
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(table)
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(columns)
//                                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(type)
//                                                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(filterCondition)
          return "CREATE INDEX $name ON $table $columns USING $type$filterCondition"
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(name)
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(table)
//                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(columns)
//                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(type)
//                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(filterCondition)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(tableName)
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(indexName)
//                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(isUnique)
//                                                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(isPartialOrFunctional)
      override fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String {
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().
//                           display_name dropIndex
//                           documentation ```kotlin\npublic open override fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropIndex().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropIndex().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().
//                           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(tableName)
//                                     display_name tableName
//                                     documentation ```kotlin\ntableName: String\n```
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(indexName)
//                                                        display_name indexName
//                                                        documentation ```kotlin\nindexName: String\n```
//                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(isUnique)
//                                                                          display_name isUnique
//                                                                          documentation ```kotlin\nisUnique: Boolean\n```
//                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                    ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(isPartialOrFunctional)
//                                                                                                          display_name isPartialOrFunctional
//                                                                                                          documentation ```kotlin\nisPartialOrFunctional: Boolean\n```
//                                                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(tableName)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(indexName)
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(isUnique)
//                                                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(isPartialOrFunctional)
          return "ALTER TABLE ${identifierManager.quoteIfNecessary(tableName)} DROP CONSTRAINT ${identifierManager.cutIfNecessaryAndQuote(indexName)}"
//                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(tableName)
//                                                                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                                                                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                                                                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                                                                                                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(indexName)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().(column)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().(columnDiff)
      override fun modifyColumn(column: Column<*>, columnDiff: ColumnDiff): List<String> =
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().
//                              display_name modifyColumn
//                              documentation ```kotlin\npublic open override fun modifyColumn(column: Column<*>, columnDiff: ColumnDiff): List<String>\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#modifyColumn().
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#modifyColumn().
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#modifyColumn().
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().
//                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().(column)
//                                     display_name column
//                                     documentation ```kotlin\ncolumn: Column<*>\n```
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().(columnDiff)
//                                                            display_name columnDiff
//                                                            documentation ```kotlin\ncolumnDiff: ColumnDiff\n```
//                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().(column)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().(columnDiff)
          @OptIn(InternalApi::class)
          listOf("ALTER TABLE ${CoreTransactionManager.currentTransaction().identity(column.table)} MODIFY COLUMN ${column.descriptionDdl(true)}")
//        ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().(column)
//                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().(column)
//                                                                                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#descriptionDdl().
//                                                                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(table)
//                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(pkName)
//                                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(pkColumns)
      override fun addPrimaryKey(table: Table, pkName: String?, vararg pkColumns: Column<*>): String {
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().
//                               display_name addPrimaryKey
//                               documentation ```kotlin\npublic open override fun addPrimaryKey(table: Table, pkName: String?, vararg pkColumns: Column<*>): String\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#addPrimaryKey().
//                               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(table)
//                                     display_name table
//                                     documentation ```kotlin\ntable: Table\n```
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(pkName)
//                                                    display_name pkName
//                                                    documentation ```kotlin\npkName: String?\n```
//                                                     ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                     ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(pkColumns)
//                                                                               display_name pkColumns
//                                                                               documentation ```kotlin\nvararg pkColumns: Column<*>\n```
//                                                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(table)
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(pkName)
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(pkColumns)
//        ⌄ enclosing_range_start local 13
          @OptIn(InternalApi::class)
          val transaction = CoreTransactionManager.currentTransaction()
//            ^^^^^^^^^^^ definition local 13
//                        display_name transaction
//                        documentation ```kotlin\n@OptIn(...) local val transaction: Transaction\n```
//                                                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                                    ⌃ enclosing_range_end local 13
//        ⌄ enclosing_range_start local 14
//                                                                          ⌄ enclosing_range_start local 15
          val columns = pkColumns.joinToString(prefix = "(", postfix = ")") { transaction.identity(it) }
//            ^^^^^^^ definition local 14
//                    display_name columns
//                    documentation ```kotlin\nlocal val columns: String\n```
//                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(pkColumns)
//                                ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString().
//                                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 15
//                                                                                                       display_name it
//                                                                                                       documentation ```kotlin\nit: Column<*>\n```
//                                                                            ^^^^^^^^^^^ reference local 13
//                                                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                                                                 ^^ reference local 15
//                                                                                                     ⌃ enclosing_range_end local 14
//                                                                                                     ⌃ enclosing_range_end local 15
//        ⌄ enclosing_range_start local 16
//                                     ⌄ enclosing_range_start local 17
          val constraint = pkName?.let { " CONSTRAINT ${identifierManager.quoteIfNecessary(it)} " } ?: " "
//            ^^^^^^^^^^ definition local 16
//                       display_name constraint
//                       documentation ```kotlin\nlocal val constraint: String\n```
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(pkName)
//                                 ^^^ reference semanticdb maven . . kotlin/let().
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 17
//                                                                                                  display_name it
//                                                                                                  documentation ```kotlin\nit: String\n```
//                                                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                                                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                                                                                         ^^ reference local 17
//                                                                                                ⌃ enclosing_range_end local 17
//                                                                                                       ⌃ enclosing_range_end local 16
          return "ALTER TABLE ${transaction.identity(table)} ADD${constraint}PRIMARY KEY $columns"
//                              ^^^^^^^^^^^ reference local 13
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(table)
//                                                                ^^^^^^^^^^ reference local 16
//                                                                                        ^^^^^^^ reference local 14
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
