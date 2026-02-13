  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  import org.jetbrains.exposed.v1.core.statements.Statement
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
  import org.jetbrains.exposed.v1.core.statements.StatementType
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
  import org.jetbrains.exposed.v1.core.statements.api.ResultApi
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/
//                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ResultApi#
  import org.jetbrains.exposed.v1.core.statements.api.RowApi
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#
  
  /**
   * Represents the SQL query that obtains information about a statement execution plan.
   *
   * @param analyze Whether the statement whose execution plan is being queried should actually be executed as well.
   * @param options String of comma-separated parameters to append after the `EXPLAIN` keyword.
   */
  open class ExplainQuery(
//           ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#
//                        display_name ExplainQuery
//                        documentation ```kotlin\npublic open class ExplainQuery : Statement<ResultApi>\n```\n\n----\n\n\n Represents the SQL query that obtains information about a statement execution plan.\n\n @param analyze Whether the statement whose execution plan is being queried should actually be executed as well.\n @param options String of comma-separated parameters to append after the `EXPLAIN` keyword.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
//           ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#`<init>`().
//                        display_name ExplainQuery
//                        documentation ```kotlin\npublic constructor(analyze: Boolean, options: String?, internalStatement: Statement<*>): ExplainQuery\n```
      val analyze: Boolean,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#`<init>`().(analyze)
//                display_name analyze
//                documentation ```kotlin\nanalyze: Boolean\n```
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#`<init>`().(analyze)
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#analyze.
//                display_name analyze
//                documentation ```kotlin\npublic final val analyze: Boolean\n```
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#getAnalyze().
//                display_name analyze
//                documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      val options: String?,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#`<init>`().(options)
//                display_name options
//                documentation ```kotlin\noptions: String?\n```
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#`<init>`().(options)
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#getOptions().
//                display_name options
//                documentation ```kotlin\npublic get(): String?\n```
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#options.
//                display_name options
//                documentation ```kotlin\npublic final val options: String?\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/String#
      private val internalStatement: Statement<*>
//                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#`<init>`().(internalStatement)
//                                  display_name internalStatement
//                                  documentation ```kotlin\ninternalStatement: Statement<*>\n```
//                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#`<init>`().(internalStatement)
//                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#getInternalStatement().
//                                  display_name internalStatement
//                                  documentation ```kotlin\nprivate get(): Statement<*>\n```
//                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#internalStatement.
//                                  display_name internalStatement
//                                  documentation ```kotlin\nprivate final val internalStatement: Statement<*>\n```
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
  ) : Statement<ResultApi>(StatementType.SHOW, emptyList()) {
//    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
//                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#SHOW.
//                                             ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
      override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>> = internalStatement.arguments()
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#arguments().
//                           display_name arguments
//                           documentation ```kotlin\npublic open override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>>\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#arguments().
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#getInternalStatement().
//                                                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#internalStatement.
//                                                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#arguments().
  
      override fun prepareSQL(transaction: Transaction, prepared: Boolean): String {
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#prepareSQL().
//                            display_name prepareSQL
//                            documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#prepareSQL().
//                            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#prepareSQL().(transaction)
//                                        display_name transaction
//                                        documentation ```kotlin\ntransaction: Transaction\n```
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#prepareSQL().(prepared)
//                                                               display_name prepared
//                                                               documentation ```kotlin\nprepared: Boolean\n```
//                                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
          val internalSql = internalStatement.prepareSQL(transaction, prepared)
//            ^^^^^^^^^^^ definition local 0
//                        display_name internalSql
//                        documentation ```kotlin\nlocal val internalSql: String\n```
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#getInternalStatement().
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#internalStatement.
//                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#prepareSQL().
//                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#prepareSQL().(transaction)
//                                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#prepareSQL().(prepared)
          return transaction.db.dialect.functionProvider.explain(analyze, options, internalSql, transaction)
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#prepareSQL().(transaction)
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
//                                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#analyze.
//                                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#getAnalyze().
//                                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#getOptions().
//                                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#options.
//                                                                                 ^^^^^^^^^^^ reference local 0
//                                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#prepareSQL().(transaction)
      }
  }
  
  /**
   * A row of data representing a single record retrieved from a database result set about a statement execution plan.
   *
   * @param fieldIndex Mapping of the field names stored on this row to their index positions.
   */
  class ExplainResultRow(
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#
//                       display_name ExplainResultRow
//                       documentation ```kotlin\npublic final class ExplainResultRow : Any\n```\n\n----\n\n\n A row of data representing a single record retrieved from a database result set about a statement execution plan.\n\n @param fieldIndex Mapping of the field names stored on this row to their index positions.\n
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#`<init>`().
//                       display_name ExplainResultRow
//                       documentation ```kotlin\npublic constructor(fieldIndex: Map<String, Int>, data: Array<Any?>): ExplainResultRow\n```
      val fieldIndex: Map<String, Int>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#`<init>`().(fieldIndex)
//                   display_name fieldIndex
//                   documentation ```kotlin\nfieldIndex: Map<String, Int>\n```
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#`<init>`().(fieldIndex)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#fieldIndex.
//                   display_name fieldIndex
//                   documentation ```kotlin\npublic final val fieldIndex: Map<String, Int>\n```
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#getFieldIndex().
//                   display_name fieldIndex
//                   documentation ```kotlin\npublic get(): Map<String, Int>\n```
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
      private val data: Array<Any?>
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#`<init>`().(data)
//                     display_name data
//                     documentation ```kotlin\ndata: Array<Any?>\n```
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#`<init>`().(data)
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#data.
//                     display_name data
//                     documentation ```kotlin\nprivate final val data: Array<Any?>\n```
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#getData().
//                     display_name data
//                     documentation ```kotlin\nprivate get(): Array<Any?>\n```
//                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
  ) {
      override fun toString(): String = fieldIndex.entries.joinToString { "${it.key}=${data[it.value]}" }
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#toString().
//                          display_name toString
//                          documentation ```kotlin\npublic open override fun toString(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#fieldIndex.
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#getFieldIndex().
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#entries.
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#getEntries().
//                                                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                        display_name it
//                                                                                                        documentation ```kotlin\nit: Map.Entry<String, Int>\n```
//                                                                           ^^ reference semanticdb maven . . (it)
//                                                                              ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getKey().
//                                                                              ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#key.
//                                                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#data.
//                                                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#getData().
//                                                                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#get().
//                                                                                          ^^ reference semanticdb maven . . (it)
//                                                                                             ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getValue().
//                                                                                             ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#value.
  
      @Suppress("SwallowedException")
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#Companion# 10:5
//                                    display_name Companion
//                                    documentation ```kotlin\n@Suppress(...) public final companion object Companion : Any\n```\n\n----\n\n Creates an [ExplainResultRow] storing all fields in [fieldIndex] with their values retrieved from a [RowApi].
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#Companion#`<init>`(). 10:5
//                                    display_name Companion
//                                    documentation ```kotlin\nprivate constructor(): ExplainResultRow.Companion\n```\n\n----\n\n Creates an [ExplainResultRow] storing all fields in [fieldIndex] with their values retrieved from a [RowApi].
      companion object {
          /** Creates an [ExplainResultRow] storing all fields in [fieldIndex] with their values retrieved from a [RowApi]. */
          fun create(rs: RowApi, fieldIndex: Map<String, Int>): ExplainResultRow {
//            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#Companion#create().
//                   display_name create
//                   documentation ```kotlin\npublic final fun create(rs: RowApi, fieldIndex: Map<String, Int>): ExplainResultRow\n```\n\n----\n\n Creates an [ExplainResultRow] storing all fields in [fieldIndex] with their values retrieved from a [RowApi].
//                   ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#Companion#create().(rs)
//                      display_name rs
//                      documentation ```kotlin\nrs: RowApi\n```
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#
//                               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#Companion#create().(fieldIndex)
//                                          display_name fieldIndex
//                                          documentation ```kotlin\nfieldIndex: Map<String, Int>\n```
//                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#
              val fieldValues = arrayOfNulls<Any?>(fieldIndex.size)
//                ^^^^^^^^^^^ definition local 1
//                            display_name fieldValues
//                            documentation ```kotlin\nlocal val fieldValues: Array<Any?>\n```
//                              ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/arrayOfNulls().
//                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#Companion#create().(fieldIndex)
//                                                            ^^^^ reference semanticdb maven . . kotlin/collections/Map#getSize().
//                                                            ^^^^ reference semanticdb maven . . kotlin/collections/Map#size.
              fieldIndex.values.forEach { index ->
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#Companion#create().(fieldIndex)
//                       ^^^^^^ reference semanticdb maven . . kotlin/collections/Map#getValues().
//                       ^^^^^^ reference semanticdb maven . . kotlin/collections/Map#values.
//                              ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                        ^^^^^ definition semanticdb maven . . (index)
//                                              display_name index
//                                              documentation ```kotlin\nindex: Int\n```
                  fieldValues[index] = rs.getObject(index + 1, null, TextColumnType())
//                ^^^^^^^^^^^ reference local 1
//                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#set().
//                            ^^^^^ reference semanticdb maven . . (index)
//                                     ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#Companion#create().(rs)
//                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject(+4).
//                                                  ^^^^^ reference semanticdb maven . . (index)
//                                                        ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
              }
              return ExplainResultRow(fieldIndex, fieldValues)
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#`<init>`().
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainResultRow#Companion#create().(fieldIndex)
//                                                ^^^^^^^^^^^ reference local 1
          }
      }
  }
