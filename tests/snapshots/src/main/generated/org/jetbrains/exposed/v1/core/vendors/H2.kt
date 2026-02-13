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
  import org.jetbrains.exposed.v1.core.statements.StatementType
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
  import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#
  import org.jetbrains.exposed.v1.exceptions.throwUnsupportedException
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
  import java.sql.Types
//       ^^^^ reference semanticdb maven . . java/
//            ^^^ reference semanticdb maven . . java/sql/
//                ^^^^^ reference semanticdb maven jdk 11 java/sql/Types#
  import java.util.*
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/util/
  
  internal object H2DataTypeProvider : DataTypeProvider() {
//                ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#
//                                   display_name H2DataTypeProvider
//                                   documentation ```kotlin\ninternal final object H2DataTypeProvider : DataTypeProvider\n```
//                                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
//                ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#`<init>`().
//                                   display_name H2DataTypeProvider
//                                   documentation ```kotlin\nprivate constructor(): H2DataTypeProvider\n```
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
      override fun binaryType(): String = "VARBINARY"
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#binaryType().
//                            display_name binaryType
//                            documentation ```kotlin\npublic open override fun binaryType(): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType().
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      override fun uuidType(): String = "UUID"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#uuidType().
//                          display_name uuidType
//                          documentation ```kotlin\npublic open override fun uuidType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      override fun uuidToDB(value: UUID): Any = value
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#uuidToDB().
//                          display_name uuidToDB
//                          documentation ```kotlin\npublic open override fun uuidToDB(value: UUID): Any\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidToDB().
//                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#uuidToDB().(value)
//                                display_name value
//                                documentation ```kotlin\nvalue: UUID\n```
//                                 ^^^^ reference semanticdb maven jdk 11 java/util/UUID#
//                                        ^^^ reference semanticdb maven . . kotlin/Any#
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#uuidToDB().(value)
  
      override fun dateTimeType(): String = "DATETIME(9)"
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#dateTimeType().
//                              display_name dateTimeType
//                              documentation ```kotlin\npublic open override fun dateTimeType(): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#dateTimeType().
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      override fun timestampType(): String = "TIMESTAMP(9)"
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#timestampType().
//                               display_name timestampType
//                               documentation ```kotlin\npublic open override fun timestampType(): String\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#timestampType().
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      override fun timestampWithTimeZoneType(): String = "TIMESTAMP(9) WITH TIME ZONE"
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#timestampWithTimeZoneType().
//                                           display_name timestampWithTimeZoneType
//                                           documentation ```kotlin\npublic open override fun timestampWithTimeZoneType(): String\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#timestampWithTimeZoneType().
//                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      override fun jsonBType(): String = "JSON"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#jsonBType().
//                           display_name jsonBType
//                           documentation ```kotlin\npublic open override fun jsonBType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#jsonBType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      override fun hexToDb(hexString: String): String = "X'$hexString'"
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#hexToDb().
//                         display_name hexToDb
//                         documentation ```kotlin\npublic open override fun hexToDb(hexString: String): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#hexToDb().
//                         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#hexToDb().(hexString)
//                                   display_name hexString
//                                   documentation ```kotlin\nhexString: String\n```
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#hexToDb().(hexString)
  }
  
  internal object H2FunctionProvider : FunctionProvider() {
//                ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#
//                                   display_name H2FunctionProvider
//                                   documentation ```kotlin\ninternal final object H2FunctionProvider : FunctionProvider\n```\n\n----\n\n\n Implementation of [FunctionProvider.locate]\n Note: search is case-sensitive\n
//                                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
//                ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#`<init>`().
//                                   display_name H2FunctionProvider
//                                   documentation ```kotlin\nprivate constructor(): H2FunctionProvider\n```\n\n----\n\n\n Implementation of [FunctionProvider.locate]\n Note: search is case-sensitive\n
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
      private val DatabaseDialect.isH2Oracle: Boolean
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#isH2Oracle.
//                                           display_name isH2Oracle
//                                           documentation ```kotlin\nprivate final val DatabaseDialect.isH2Oracle: Boolean\n```
//                                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          get() = h2Mode == H2Dialect.H2CompatibilityMode.Oracle
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#getIsH2Oracle().
//            display_name isH2Oracle
//            documentation ```kotlin\nprivate get(): Boolean\n```
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
  
      override fun nextVal(seq: Sequence, builder: QueryBuilder) =
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#nextVal().
//                         display_name nextVal
//                         documentation ```kotlin\npublic open override fun nextVal(seq: Sequence, builder: QueryBuilder): Unit\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().
//                         ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#nextVal().(seq)
//                             display_name seq
//                             documentation ```kotlin\nseq: Sequence\n```
//                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
//                                        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#nextVal().(builder)
//                                                display_name builder
//                                                documentation ```kotlin\nbuilder: QueryBuilder\n```
//                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
          @OptIn(InternalApi::class)
          when ((CoreTransactionManager.currentTransaction().db.dialect as H2Dialect).majorVersion) {
//                                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getMajorVersion().
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#majorVersion.
              H2Dialect.H2MajorVersion.One -> super.nextVal(seq, builder)
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2MajorVersion#One.
//                                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().
//                                                          ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#nextVal().(seq)
//                                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#nextVal().(builder)
              H2Dialect.H2MajorVersion.Two -> builder {
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2MajorVersion#Two.
//                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#nextVal().(builder)
                  append("NEXT VALUE FOR ${seq.identifier}")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                         ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#nextVal().(seq)
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getIdentifier().
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#identifier.
              }
          }
  
      override fun <T> arraySlice(expression: Expression<T>, lower: Int?, upper: Int?, queryBuilder: QueryBuilder) {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#arraySlice().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#arraySlice().
//                                display_name arraySlice
//                                documentation ```kotlin\npublic open override fun <T> arraySlice(expression: Expression<T>, lower: Int?, upper: Int?, queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#arraySlice().(expression)
//                                           display_name expression
//                                           documentation ```kotlin\nexpression: Expression<T>\n```
//                                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#arraySlice().(lower)
//                                                                 display_name lower
//                                                                 documentation ```kotlin\nlower: Int?\n```
//                                                                  ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#arraySlice().(upper)
//                                                                              display_name upper
//                                                                              documentation ```kotlin\nupper: Int?\n```
//                                                                               ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                     ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#arraySlice().(queryBuilder)
//                                                                                                  display_name queryBuilder
//                                                                                                  documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#arraySlice().(queryBuilder)
              append("ARRAY_SLICE(", expression, ",$lower,$upper)")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#arraySlice().(expression)
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#arraySlice().(lower)
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#arraySlice().(upper)
          }
      }
  
      override fun insert(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().
//                        display_name insert
//                        documentation ```kotlin\npublic open override fun insert(ignore: Boolean, table: Table, columns: List<Column<*>>, expr: String, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
          ignore: Boolean,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(ignore)
//               display_name ignore
//               documentation ```kotlin\nignore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
          columns: List<Column<*>>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(columns)
//                display_name columns
//                documentation ```kotlin\ncolumns: List<Column<*>>\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          expr: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          val uniqueCols = mutableSetOf<Column<*>>()
//            ^^^^^^^^^^ definition local 0
//                       display_name uniqueCols
//                       documentation ```kotlin\nlocal val uniqueCols: MutableSet<Column<*>>\n```
//                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableSetOf().
          table.indices.filter { it.unique }.flatMapTo(uniqueCols) { it.columns }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(table)
//              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getIndices().
//              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#indices.
//                      ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                             ^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                           display_name it
//                                           documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                               ^^ reference semanticdb maven . . (it)
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
//                                           ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMapTo(+10).
//                                                     ^^^^^^^^^^ reference local 0
//                                                                 ^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                display_name it
//                                                                                documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                                   ^^ reference semanticdb maven . . (it)
//                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
          table.primaryKey?.columns?.let { primaryKeys ->
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(table)
//              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                                   ^^^ reference semanticdb maven . . kotlin/let().
//                                         ^^^^^^^^^^^ definition semanticdb maven . . (primaryKeys)
//                                                     display_name primaryKeys
//                                                     documentation ```kotlin\nprimaryKeys: Array<Column<*>>\n```
              uniqueCols += primaryKeys
//            ^^^^^^^^^^ reference local 0
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/plusAssign(+2).
//                          ^^^^^^^^^^^ reference semanticdb maven . . (primaryKeys)
          }
          val h2Dialect = transaction.db.dialect as H2Dialect
//            ^^^^^^^^^ definition local 1
//                      display_name h2Dialect
//                      documentation ```kotlin\nlocal val h2Dialect: H2Dialect\n```
//                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(transaction)
//                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
          val version = h2Dialect.version
//            ^^^^^^^ definition local 2
//                    display_name version
//                    documentation ```kotlin\nlocal val version: String\n```
//                      ^^^^^^^^^ reference local 1
//                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getVersion().
//                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#version.
          val isMySQLMode = h2Dialect.h2Mode == H2Dialect.H2CompatibilityMode.MySQL
//            ^^^^^^^^^^^ definition local 3
//                        display_name isMySQLMode
//                        documentation ```kotlin\nlocal val isMySQLMode: Boolean\n```
//                          ^^^^^^^^^ reference local 1
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode().
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode.
//                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MySQL.
          return when {
              // INSERT IGNORE support added in H2 version 1.4.197 (2018-03-18)
              ignore && uniqueCols.isNotEmpty() && isMySQLMode && version < "1.4.197" -> {
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(ignore)
//                      ^^^^^^^^^^ reference local 0
//                                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                                 ^^^^^^^^^^^ reference local 3
//                                                                ^^^^^^^ reference local 2
//                                                                        ^ reference semanticdb maven . . kotlin/String#compareTo().
                  val def = super.insert(false, table, columns, expr, transaction)
//                    ^^^ definition local 4
//                        display_name def
//                        documentation ```kotlin\nlocal val def: String\n```
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(table)
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(columns)
//                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(expr)
//                                                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(transaction)
                  def + " ON DUPLICATE KEY UPDATE " + uniqueCols.joinToString { "${transaction.identity(it)}=VALUES(${transaction.identity(it)})" }
//                ^^^ reference local 4
//                    ^ reference semanticdb maven . . kotlin/String#plus().
//                                                  ^ reference semanticdb maven . . kotlin/String#plus().
//                                                    ^^^^^^^^^^ reference local 0
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                                                  display_name it
//                                                                                                                                                  documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(transaction)
//                                                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                                                                      ^^ reference semanticdb maven . . (it)
//                                                                                                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(transaction)
//                                                                                                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                                                                                                         ^^ reference semanticdb maven . . (it)
              }
              ignore && uniqueCols.isNotEmpty() && isMySQLMode -> {
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(ignore)
//                      ^^^^^^^^^^ reference local 0
//                                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                                 ^^^^^^^^^^^ reference local 3
                  super.insert(false, table, columns, expr, transaction).replace("INSERT", "INSERT IGNORE")
//                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(table)
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(columns)
//                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(expr)
//                                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(transaction)
//                                                                       ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
              }
              ignore -> transaction.throwUnsupportedException("INSERT IGNORE supported only on H2 v1.4.197+ with MODE=MYSQL.")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(ignore)
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(transaction)
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
              else -> super.insert(false, table, columns, expr, transaction)
//                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(table)
//                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(columns)
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(expr)
//                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().(transaction)
          }
      }
  
      override fun update(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().
//                        display_name update
//                        documentation ```kotlin\npublic open override fun update(targets: Join, columnsAndValues: List<Pair<Column<*>, Any?>>, limit: Int?, where: Op<Boolean>?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).
          targets: Join,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(targets)
//                display_name targets
//                documentation ```kotlin\ntargets: Join\n```
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
          columnsAndValues: List<Pair<Column<*>, Any?>>,
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(columnsAndValues)
//                         display_name columnsAndValues
//                         documentation ```kotlin\ncolumnsAndValues: List<Pair<Column<*>, Any?>>\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
      ): String = with(QueryBuilder(true)) {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                ^^^^ reference semanticdb maven . . kotlin/with().
//                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
          if (limit != null) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(limit)
              transaction.throwUnsupportedException("H2 doesn't support LIMIT in UPDATE with join clause.")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          if (where != null && !transaction.db.dialect.isH2Oracle) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(where)
//                             ^ reference semanticdb maven . . kotlin/Boolean#not().
//                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(transaction)
//                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
//                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#getIsH2Oracle().
//                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#isH2Oracle.
              transaction.throwUnsupportedException("H2 doesn't support WHERE in UPDATE with join clause.")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          val tableToUpdate = columnsAndValues.map { it.first.table }.distinct().singleOrNull()
//            ^^^^^^^^^^^^^ definition local 5
//                          display_name tableToUpdate
//                          documentation ```kotlin\nlocal val tableToUpdate: Table\n```
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(columnsAndValues)
//                                             ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                 ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                    display_name it
//                                                                    documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                   ^^ reference semanticdb maven . . (it)
//                                                      ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                      ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                    ^^^^^^^^ reference semanticdb maven . . kotlin/collections/distinct(+9).
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull(+19).
              ?: transaction.throwUnsupportedException(
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(transaction)
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
                  "H2 doesn't support UPDATE with join clause that uses columns from multiple tables."
              )
          val joinPart = targets.joinParts.singleOrNull()
//            ^^^^^^^^ definition local 6
//                     display_name joinPart
//                     documentation ```kotlin\nlocal val joinPart: Join.JoinPart\n```
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(targets)
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull(+19).
              ?: transaction.throwUnsupportedException(
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(transaction)
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
                  "H2 doesn't support UPDATE with join clause that uses multiple tables to join."
              )
          targets.checkJoinTypes(StatementType.UPDATE)
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(targets)
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().
//                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#UPDATE.
  
          appendMergeIntoUsingJoinClause(tableToUpdate, targets, joinPart, transaction)
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#appendMergeIntoUsingJoinClause().
//                                       ^^^^^^^^^^^^^ reference local 5
//                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(targets)
//                                                               ^^^^^^^^ reference local 6
//                                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(transaction)
          +" WHEN MATCHED THEN UPDATE SET "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          columnsAndValues.appendTo(this) { (col, value) ->
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(columnsAndValues)
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                          ^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                       display_name <destruct>
//                                                       documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                           ^^^ definition local 7
//                                               display_name col
//                                               documentation ```kotlin\nlocal val col: Column<*>\n```
//                                           ^^^ reference semanticdb maven . . (`<destruct>`)
//                                           ^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                ^^^^^ definition local 8
//                                                      display_name value
//                                                      documentation ```kotlin\nlocal val value: Any?\n```
//                                                ^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
              append("${transaction.fullIdentity(col)}=")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(transaction)
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity().
//                                               ^^^ reference local 7
              registerArgument(col, value)
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                             ^^^ reference local 7
//                                  ^^^^^ reference local 8
          }
  
          where?.let {
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().(where)
//               ^^^ reference semanticdb maven . . kotlin/let().
//                   ^ definition semanticdb maven . . (it) 3:9
//                     display_name it
//                     documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
              +" WHERE "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              +it
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//             ^^ reference semanticdb maven . . (it)
          }
          toString()
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
      }
  
      private fun QueryBuilder.appendMergeIntoUsingJoinClause(
//                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#appendMergeIntoUsingJoinClause().
//                                                            display_name appendMergeIntoUsingJoinClause
//                                                            documentation ```kotlin\nprivate final fun QueryBuilder.appendMergeIntoUsingJoinClause(target: Table, join: Join, joinPart: Join.JoinPart, transaction: Transaction): Unit\n```
          target: Table,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#appendMergeIntoUsingJoinClause().(target)
//               display_name target
//               documentation ```kotlin\ntarget: Table\n```
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
          join: Join,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#appendMergeIntoUsingJoinClause().(join)
//             display_name join
//             documentation ```kotlin\njoin: Join\n```
//              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
          joinPart: Join.JoinPart,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#appendMergeIntoUsingJoinClause().(joinPart)
//                 display_name joinPart
//                 documentation ```kotlin\njoinPart: Join.JoinPart\n```
//                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#appendMergeIntoUsingJoinClause().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
      ) {
          +"MERGE INTO "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          target.describe(transaction, this)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#appendMergeIntoUsingJoinClause().(target)
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().
//                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#appendMergeIntoUsingJoinClause().(transaction)
          +" USING "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          (joinPart.joinPart.takeIf { it != target } ?: join.table).describe(transaction, this)
//         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#appendMergeIntoUsingJoinClause().(joinPart)
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                           ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                  ^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                   display_name it
//                                                   documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                    ^^ reference semanticdb maven . . (it)
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#appendMergeIntoUsingJoinClause().(target)
//                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#appendMergeIntoUsingJoinClause().(join)
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getTable().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#table.
//                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().
//                                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#appendMergeIntoUsingJoinClause().(transaction)
          +" ON "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          joinPart.appendConditions(this)
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#appendMergeIntoUsingJoinClause().(joinPart)
//                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#appendConditions().
      }
  
      override fun delete(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().
//                        display_name delete
//                        documentation ```kotlin\npublic open override fun delete(ignore: Boolean, targets: Join, targetTables: List<Table>, where: Op<Boolean>?, limit: Int?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).
          ignore: Boolean,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(ignore)
//               display_name ignore
//               documentation ```kotlin\nignore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          targets: Join,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(targets)
//                display_name targets
//                documentation ```kotlin\ntargets: Join\n```
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
          targetTables: List<Table>,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(targetTables)
//                     display_name targetTables
//                     documentation ```kotlin\ntargetTables: List<Table>\n```
//                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (ignore) {
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(ignore)
              transaction.throwUnsupportedException("H2 doesn't support IGNORE in DELETE from join relation")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          if (limit != null) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(limit)
              transaction.throwUnsupportedException("H2 doesn't support LIMIT in DELETE from join relation")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          val tableToDelete = targetTables.singleOrNull()
//            ^^^^^^^^^^^^^ definition local 9
//                          display_name tableToDelete
//                          documentation ```kotlin\nlocal val tableToDelete: Table\n```
//                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(targetTables)
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull(+19).
              ?: transaction.throwUnsupportedException(
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(transaction)
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
                  "H2 doesn't support DELETE from join relation with multiple tables to delete from"
              )
          val joinPart = targets.joinParts.singleOrNull()
//            ^^^^^^^^ definition local 10
//                     display_name joinPart
//                     documentation ```kotlin\nlocal val joinPart: Join.JoinPart\n```
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(targets)
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull(+19).
              ?: transaction.throwUnsupportedException(
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(transaction)
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
                  "H2 doesn't support DELETE from join relation that uses multiple tables to join"
              )
          targets.checkJoinTypes(StatementType.DELETE)
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(targets)
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().
//                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#DELETE.
  
          return with(QueryBuilder(true)) {
//               ^^^^ reference semanticdb maven . . kotlin/with().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
              appendMergeIntoUsingJoinClause(tableToDelete, targets, joinPart, transaction)
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#appendMergeIntoUsingJoinClause().
//                                           ^^^^^^^^^^^^^ reference local 9
//                                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(targets)
//                                                                   ^^^^^^^^ reference local 10
//                                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(transaction)
              +" WHEN MATCHED"
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              where?.let {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().(where)
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^ definition semanticdb maven . . (it) 3:13
//                         display_name it
//                         documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
                  +" AND "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                  +it
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                 ^^ reference semanticdb maven . . (it)
              }
              +" THEN DELETE"
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
  
      /**
       * Implementation of [FunctionProvider.locate]
       * Note: search is case-sensitive
       * */
      override fun <T : String?> locate(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#locate().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#locate().
//                                      display_name locate
//                                      documentation ```kotlin\npublic open override fun <T : String?> locate(queryBuilder: QueryBuilder, expr: Expression<T>, substring: String): Unit\n```\n\n----\n\n\n Implementation of [FunctionProvider.locate]\n Note: search is case-sensitive\n
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().
          queryBuilder: QueryBuilder,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#locate().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
          expr: Expression<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#locate().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          substring: String
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#locate().(substring)
//                  display_name substring
//                  documentation ```kotlin\nsubstring: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
      ) = queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#locate().(queryBuilder)
          append("LOCATE(\'", substring, "\',", expr, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#locate().(substring)
//                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#locate().(expr)
      }
  
      override fun explain(
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#explain().
//                         display_name explain
//                         documentation ```kotlin\npublic open override fun explain(analyze: Boolean, options: String?, internalStatement: String, transaction: Transaction): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
          analyze: Boolean,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#explain().(analyze)
//                display_name analyze
//                documentation ```kotlin\nanalyze: Boolean\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          options: String?,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#explain().(options)
//                display_name options
//                documentation ```kotlin\noptions: String?\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/String#
          internalStatement: String,
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#explain().(internalStatement)
//                          display_name internalStatement
//                          documentation ```kotlin\ninternalStatement: String\n```
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#explain().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (options != null) {
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#explain().(options)
              transaction.throwUnsupportedException("H2 does not support options other than ANALYZE in EXPLAIN queries.")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#explain().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          return super.explain(analyze, null, internalStatement, transaction)
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
//                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#explain().(analyze)
//                                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#explain().(internalStatement)
//                                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#explain().(transaction)
      }
  
      override fun <T> date(expr: Expression<T>, queryBuilder: QueryBuilder) = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#date().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#date().
//                          display_name date
//                          documentation ```kotlin\npublic open override fun <T> date(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#date().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#date().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#date().(queryBuilder)
          append("CAST(", expr, " AS DATE)")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#date().(expr)
      }
  
      override fun <T> time(expr: Expression<T>, queryBuilder: QueryBuilder) = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#time().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#time().
//                          display_name time
//                          documentation ```kotlin\npublic open override fun <T> time(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#time().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#time().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#time().(queryBuilder)
          append("FORMATDATETIME(", expr, ", 'HH:mm:ss.SSSSSSSSS')")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#time().(expr)
      }
  }
  
  /**
   * H2 dialect implementation.
   */
  open class H2Dialect : VendorDialect(dialectName, H2DataTypeProvider, H2FunctionProvider) {
//           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
//                     display_name H2Dialect
//                     documentation ```kotlin\npublic open class H2Dialect : VendorDialect\n```\n\n----\n\n\n H2 dialect implementation.\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
//           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#`<init>`().
//                     display_name H2Dialect
//                     documentation ```kotlin\npublic constructor(): H2Dialect\n```\n\n----\n\n\n H2 dialect implementation.\n
//                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
  
      override fun toString(): String = "H2Dialect[$dialectName, $h2Mode]"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#toString().
//                          display_name toString
//                          documentation ```kotlin\npublic open override fun toString(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
//                                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode().
//                                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode.
  
      enum class H2MajorVersion {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Enum# 2:5
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2MajorVersion#
//                              display_name H2MajorVersion
//                              documentation ```kotlin\npublic final enum class H2MajorVersion : Enum<H2Dialect.H2MajorVersion>\n```
//                              relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2MajorVersion#`<init>`().
//                              display_name H2MajorVersion
//                              documentation ```kotlin\nprivate constructor(): H2Dialect.H2MajorVersion\n```
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2MajorVersion#entries.
//                              display_name entries
//                              documentation ```kotlin\npublic final static val entries: EnumEntries<H2Dialect.H2MajorVersion>\n```
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2MajorVersion#valueOf().
//                              display_name valueOf
//                              documentation ```kotlin\npublic final static fun valueOf(value: String): H2Dialect.H2MajorVersion\n```
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2MajorVersion#valueOf().(value)
//                              display_name value
//                              documentation ```kotlin\nvalue: String\n```
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2MajorVersion#values().
//                              display_name values
//                              documentation ```kotlin\npublic final static fun values(): Array<H2Dialect.H2MajorVersion>\n```
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getEntries().
//                              display_name entries
//                              documentation ```kotlin\npublic get(): EnumEntries<H2Dialect.H2CompatibilityMode>\n```\n\n----\n\n H2 database compatibility modes that emulate the behavior of other specific databases.
          One, Two
      }
  
      @OptIn(InternalApi::class)
      internal val version by lazy {
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getVersion().
//                         display_name version
//                         documentation ```kotlin\ninternal get(): String\n```
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#version.
//                         display_name version
//                         documentation ```kotlin\n@OptIn(...) internal final val version: String\n```
//                            ^^^^ reference semanticdb maven . . kotlin/lazy().
//                            ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 2:5
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getVersion(). 2:5
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#version. 2:5
          exactH2Version(CoreTransactionManager.currentTransaction())
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#exactH2Version().
//                                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
      }
  
      val majorVersion: H2MajorVersion by lazy {
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getMajorVersion().
//                     display_name majorVersion
//                     documentation ```kotlin\npublic get(): H2Dialect.H2MajorVersion\n```
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#majorVersion.
//                     display_name majorVersion
//                     documentation ```kotlin\npublic final val majorVersion: H2Dialect.H2MajorVersion\n```
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2MajorVersion#
//                                        ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                        ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 6:5
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getMajorVersion(). 6:5
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#majorVersion. 6:5
          when {
              version.startsWith("1.") -> H2MajorVersion.One
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getVersion().
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#version.
//                    ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                       ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2MajorVersion#One.
              version.startsWith("2.") -> H2MajorVersion.Two
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getVersion().
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#version.
//                    ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                       ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2MajorVersion#Two.
              else -> error("Unsupported H2 version: $version")
//                    ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getVersion().
//                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#version.
          }
      }
  
      /** Indicates whether the H2 Database Engine version is greater than or equal to 2.0. */
      val isSecondVersion get() = majorVersion == H2MajorVersion.Two
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#isSecondVersion.
//                        display_name isSecondVersion
//                        documentation ```kotlin\npublic final val isSecondVersion: Boolean\n```\n\n----\n\n Indicates whether the H2 Database Engine version is greater than or equal to 2.0.
//                        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getIsSecondVersion().
//                            display_name isSecondVersion
//                            documentation ```kotlin\npublic get(): Boolean\n```
//                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getMajorVersion().
//                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#majorVersion.
//                                                               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2MajorVersion#Two.
  
      private fun exactH2Version(transaction: Transaction): String = transaction.db.version.toString()
//                ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#exactH2Version().
//                               display_name exactH2Version
//                               documentation ```kotlin\nprivate final fun exactH2Version(transaction: Transaction): String\n```
//                               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#exactH2Version().(transaction)
//                                           display_name transaction
//                                           documentation ```kotlin\ntransaction: Transaction\n```
//                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#exactH2Version().(transaction)
//                                                                               ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                                               ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getVersion().
//                                                                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#version.
//                                                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#toString().
  
      /** H2 database compatibility modes that emulate the behavior of other specific databases. */
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Enum# 3:5
      enum class H2CompatibilityMode {
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#
//                                   display_name H2CompatibilityMode
//                                   documentation ```kotlin\npublic final enum class H2CompatibilityMode : Enum<H2Dialect.H2CompatibilityMode>\n```\n\n----\n\n H2 database compatibility modes that emulate the behavior of other specific databases.
//                                   relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#`<init>`().
//                                   display_name H2CompatibilityMode
//                                   documentation ```kotlin\nprivate constructor(): H2Dialect.H2CompatibilityMode\n```\n\n----\n\n H2 database compatibility modes that emulate the behavior of other specific databases.
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#entries.
//                                   display_name entries
//                                   documentation ```kotlin\npublic final static val entries: EnumEntries<H2Dialect.H2CompatibilityMode>\n```\n\n----\n\n H2 database compatibility modes that emulate the behavior of other specific databases.
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#valueOf().
//                                   display_name valueOf
//                                   documentation ```kotlin\npublic final static fun valueOf(value: String): H2Dialect.H2CompatibilityMode\n```\n\n----\n\n H2 database compatibility modes that emulate the behavior of other specific databases.
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#valueOf().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: String\n```\n\n----\n\n H2 database compatibility modes that emulate the behavior of other specific databases.
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#values().
//                                   display_name values
//                                   documentation ```kotlin\npublic final static fun values(): Array<H2Dialect.H2CompatibilityMode>\n```\n\n----\n\n H2 database compatibility modes that emulate the behavior of other specific databases.
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getEntries().
//                                   display_name entries
//                                   documentation ```kotlin\npublic get(): EnumEntries<H2Dialect.H2CompatibilityMode>\n```\n\n----\n\n H2 database compatibility modes that emulate the behavior of other specific databases.
          MySQL, MariaDB, SQLServer, Oracle, PostgreSQL
      }
  
      /** The specific database name that an H2 compatibility mode delegates to. */
      val delegatedDialectNameProvider: DialectNameProvider? by lazy {
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#delegatedDialectNameProvider.
//                                     display_name delegatedDialectNameProvider
//                                     documentation ```kotlin\npublic final val delegatedDialectNameProvider: VendorDialect.DialectNameProvider?\n```\n\n----\n\n The specific database name that an H2 compatibility mode delegates to.
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getDelegatedDialectNameProvider().
//                                     display_name delegatedDialectNameProvider
//                                     documentation ```kotlin\npublic get(): VendorDialect.DialectNameProvider?\n```\n\n----\n\n The specific database name that an H2 compatibility mode delegates to.
//                                      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//                                                              ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                              ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 9:5
//                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#delegatedDialectNameProvider. 9:5
//                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getDelegatedDialectNameProvider(). 9:5
          when (h2Mode) {
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode().
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode.
              H2CompatibilityMode.MySQL -> MysqlDialect
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MySQL.
              H2CompatibilityMode.MariaDB -> MariaDBDialect
//                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MariaDB.
              H2CompatibilityMode.PostgreSQL -> PostgreSQLDialect
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#PostgreSQL.
              H2CompatibilityMode.Oracle -> OracleDialect
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
              H2CompatibilityMode.SQLServer -> SQLServerDialect
//                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#SQLServer.
              else -> null
          }
      }
  
      private var delegatedDialect: DatabaseDialect? = null
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#delegatedDialect.
//                                 display_name delegatedDialect
//                                 documentation ```kotlin\nprivate final var delegatedDialect: DatabaseDialect?\n```
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getDelegatedDialect().
//                                 display_name delegatedDialect
//                                 documentation ```kotlin\nprivate get(): DatabaseDialect?\n```
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#setDelegatedDialect().
//                                 display_name delegatedDialect
//                                 documentation ```kotlin\nprivate set(value: DatabaseDialect?): Unit\n```
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#setDelegatedDialect().(value)
//                                 display_name value
//                                 documentation ```kotlin\nvalue: DatabaseDialect?\n```
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
  
      @OptIn(InternalApi::class)
      private fun resolveDelegatedDialect(): DatabaseDialect? {
//                ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                        display_name resolveDelegatedDialect
//                                        documentation ```kotlin\n@OptIn(...) private final fun resolveDelegatedDialect(): DatabaseDialect?\n```
//                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
          return delegatedDialect ?: delegatedDialectNameProvider?.dialectName?.lowercase()?.let {
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#delegatedDialect.
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getDelegatedDialect().
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#setDelegatedDialect().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#delegatedDialectNameProvider.
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getDelegatedDialectNameProvider().
//                                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
//                                                                              ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
//                                                                                           ^^^ reference semanticdb maven . . kotlin/let().
//                                                                                               ^ definition semanticdb maven . . (it) 4:9
//                                                                                                 display_name it
//                                                                                                 documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
              val dialect = DatabaseApi.dialects[it]?.invoke() ?: error("Can't resolve dialect for $it")
//                ^^^^^^^ definition local 11
//                        display_name dialect
//                        documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#get().
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#Companion#dialects.
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#Companion#getDialects().
//                                               ^^ reference semanticdb maven . . (it)
//                                                    ^^^^^^ reference semanticdb maven . . kotlin/Function0#invoke().
//                                                                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                                                                  ^^ reference semanticdb maven . . (it)
              delegatedDialect = dialect
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#delegatedDialect.
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getDelegatedDialect().
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#setDelegatedDialect().
//                               ^^^^^^^ reference local 11
              dialect
//            ^^^^^^^ reference local 11
          }
      }
  
      /** The regular H2 mode implementation of [FunctionProvider] instead of a delegated mode implementation. */
      val originalFunctionProvider: FunctionProvider = H2FunctionProvider
//        ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getOriginalFunctionProvider().
//                                 display_name originalFunctionProvider
//                                 documentation ```kotlin\npublic get(): FunctionProvider\n```\n\n----\n\n The regular H2 mode implementation of [FunctionProvider] instead of a delegated mode implementation.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#originalFunctionProvider.
//                                 display_name originalFunctionProvider
//                                 documentation ```kotlin\npublic final val originalFunctionProvider: FunctionProvider\n```\n\n----\n\n The regular H2 mode implementation of [FunctionProvider] instead of a delegated mode implementation.
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
  
      override val functionProvider: FunctionProvider by lazy {
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#functionProvider.
//                                  display_name functionProvider
//                                  documentation ```kotlin\npublic open override val functionProvider: FunctionProvider\n```
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getFunctionProvider().
//                                  display_name functionProvider
//                                  documentation ```kotlin\npublic get(): FunctionProvider\n```
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
//                                                       ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                       ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 2:5
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#functionProvider. 2:5
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getFunctionProvider(). 2:5
          resolveDelegatedDialect()?.takeIf { it !is MysqlDialect }?.functionProvider ?: originalFunctionProvider
//        ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                   ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                          ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                  display_name it
//                                                                  documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                            ^^ reference semanticdb maven . . (it)
//                                                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                                                                       ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getOriginalFunctionProvider().
//                                                                                       ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#originalFunctionProvider.
      }
  
      /** The regular H2 mode implementation of [DataTypeProvider] instead of a delegated mode implementation. */
      val originalDataTypeProvider: DataTypeProvider = H2DataTypeProvider
//        ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getOriginalDataTypeProvider().
//                                 display_name originalDataTypeProvider
//                                 documentation ```kotlin\npublic get(): DataTypeProvider\n```\n\n----\n\n The regular H2 mode implementation of [DataTypeProvider] instead of a delegated mode implementation.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#originalDataTypeProvider.
//                                 display_name originalDataTypeProvider
//                                 documentation ```kotlin\npublic final val originalDataTypeProvider: DataTypeProvider\n```\n\n----\n\n The regular H2 mode implementation of [DataTypeProvider] instead of a delegated mode implementation.
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
  
      override val dataTypeProvider: DataTypeProvider by lazy {
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#dataTypeProvider.
//                                  display_name dataTypeProvider
//                                  documentation ```kotlin\npublic open override val dataTypeProvider: DataTypeProvider\n```
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getDataTypeProvider().
//                                  display_name dataTypeProvider
//                                  documentation ```kotlin\npublic get(): DataTypeProvider\n```
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
//                                                       ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                       ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 2:5
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#dataTypeProvider. 2:5
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getDataTypeProvider(). 2:5
          resolveDelegatedDialect()?.takeIf { it !is MysqlDialect }?.dataTypeProvider ?: originalDataTypeProvider
//        ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                   ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                          ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                  display_name it
//                                                                  documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                            ^^ reference semanticdb maven . . (it)
//                                                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                                       ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getOriginalDataTypeProvider().
//                                                                                       ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#originalDataTypeProvider.
      }
  
      /** The H2 database compatibility mode retrieved from metadata. */
      val h2Mode: H2CompatibilityMode? by lazy {
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode().
//               display_name h2Mode
//               documentation ```kotlin\npublic get(): H2Dialect.H2CompatibilityMode?\n```\n\n----\n\n The H2 database compatibility mode retrieved from metadata.
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode.
//               display_name h2Mode
//               documentation ```kotlin\npublic final val h2Mode: H2Dialect.H2CompatibilityMode?\n```\n\n----\n\n The H2 database compatibility mode retrieved from metadata.
//                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#
//                                        ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                        ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 12:5
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode(). 12:5
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode. 12:5
          @OptIn(InternalApi::class)
          val modeValue = CoreTransactionManager.currentTransaction().db.dialectMode
//            ^^^^^^^^^ definition local 12
//                      display_name modeValue
//                      documentation ```kotlin\n@OptIn(...) local val modeValue: String?\n```
//                                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialectMode.
//                                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialectMode().
          when {
              modeValue == null -> null
//            ^^^^^^^^^ reference local 12
              modeValue.equals("MySQL", ignoreCase = true) -> H2CompatibilityMode.MySQL
//            ^^^^^^^^^ reference local 12
//                      ^^^^^^ reference semanticdb maven . . kotlin/text/equals(+1).
//                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MySQL.
              modeValue.equals("MariaDB", ignoreCase = true) -> H2CompatibilityMode.MariaDB
//            ^^^^^^^^^ reference local 12
//                      ^^^^^^ reference semanticdb maven . . kotlin/text/equals(+1).
//                                                                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MariaDB.
              modeValue.equals("MSSQLServer", ignoreCase = true) -> H2CompatibilityMode.SQLServer
//            ^^^^^^^^^ reference local 12
//                      ^^^^^^ reference semanticdb maven . . kotlin/text/equals(+1).
//                                                                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#SQLServer.
              modeValue.equals("Oracle", ignoreCase = true) -> H2CompatibilityMode.Oracle
//            ^^^^^^^^^ reference local 12
//                      ^^^^^^ reference semanticdb maven . . kotlin/text/equals(+1).
//                                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
              modeValue.equals("PostgreSQL", ignoreCase = true) -> H2CompatibilityMode.PostgreSQL
//            ^^^^^^^^^ reference local 12
//                      ^^^^^^ reference semanticdb maven . . kotlin/text/equals(+1).
//                                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#PostgreSQL.
              else -> null
          }
      }
  
      override val name: String by lazy {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getName().
//                      display_name name
//                      documentation ```kotlin\npublic get(): String\n```
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#name.
//                      display_name name
//                      documentation ```kotlin\npublic open override val name: String\n```
//                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                 ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                 ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 5:5
//                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getName(). 5:5
//                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#name. 5:5
          when (h2Mode) {
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode().
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode.
              null -> dialectName
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
              else -> "$dialectName (${h2Mode!!.name} Mode)"
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode().
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode.
//                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#getName().
//                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#name.
          }
      }
  
      override val supportsMultipleGeneratedKeys: Boolean by lazy { resolveDelegatedDialect()?.supportsMultipleGeneratedKeys ?: false }
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsMultipleGeneratedKeys().
//                                               display_name supportsMultipleGeneratedKeys
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsMultipleGeneratedKeys.
//                                               display_name supportsMultipleGeneratedKeys
//                                               documentation ```kotlin\npublic open override val supportsMultipleGeneratedKeys: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                           ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsMultipleGeneratedKeys().
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsMultipleGeneratedKeys.
//                                                                  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                                                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsMultipleGeneratedKeys().
//                                                                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsMultipleGeneratedKeys.
      override val supportsOnlyIdentifiersInGeneratedKeys: Boolean by lazy { resolveDelegatedDialect()?.supportsOnlyIdentifiersInGeneratedKeys ?: true }
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsOnlyIdentifiersInGeneratedKeys().
//                                                        display_name supportsOnlyIdentifiersInGeneratedKeys
//                                                        documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsOnlyIdentifiersInGeneratedKeys.
//                                                        display_name supportsOnlyIdentifiersInGeneratedKeys
//                                                        documentation ```kotlin\npublic open override val supportsOnlyIdentifiersInGeneratedKeys: Boolean\n```
//                                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                    ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsOnlyIdentifiersInGeneratedKeys().
//                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsOnlyIdentifiersInGeneratedKeys.
//                                                                           ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsOnlyIdentifiersInGeneratedKeys().
//                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsOnlyIdentifiersInGeneratedKeys.
      override val supportsIfNotExists: Boolean by lazy { resolveDelegatedDialect()?.supportsIfNotExists ?: super.supportsIfNotExists }
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsIfNotExists().
//                                     display_name supportsIfNotExists
//                                     documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsIfNotExists.
//                                     display_name supportsIfNotExists
//                                     documentation ```kotlin\npublic open override val supportsIfNotExists: Boolean\n```
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                 ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsIfNotExists().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsIfNotExists.
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                                                                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsIfNotExists().
//                                                                                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsIfNotExists.
//                                                                                                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsIfNotExists().
//                                                                                                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsIfNotExists.
      override val supportsCreateSequence: Boolean by lazy { resolveDelegatedDialect()?.supportsCreateSequence ?: super.supportsCreateSequence }
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsCreateSequence().
//                                        display_name supportsCreateSequence
//                                        documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsCreateSequence.
//                                        display_name supportsCreateSequence
//                                        documentation ```kotlin\npublic open override val supportsCreateSequence: Boolean\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                    ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsCreateSequence().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsCreateSequence.
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsCreateSequence().
//                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsCreateSequence.
//                                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsCreateSequence().
//                                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsCreateSequence.
      override val needsSequenceToAutoInc: Boolean by lazy { resolveDelegatedDialect()?.needsSequenceToAutoInc ?: super.needsSequenceToAutoInc }
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getNeedsSequenceToAutoInc().
//                                        display_name needsSequenceToAutoInc
//                                        documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#needsSequenceToAutoInc.
//                                        display_name needsSequenceToAutoInc
//                                        documentation ```kotlin\npublic open override val needsSequenceToAutoInc: Boolean\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                    ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getNeedsSequenceToAutoInc().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#needsSequenceToAutoInc.
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getNeedsSequenceToAutoInc().
//                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#needsSequenceToAutoInc.
//                                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getNeedsSequenceToAutoInc().
//                                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#needsSequenceToAutoInc.
      override val defaultReferenceOption: ReferenceOption by lazy { resolveDelegatedDialect()?.defaultReferenceOption ?: super.defaultReferenceOption }
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#defaultReferenceOption.
//                                        display_name defaultReferenceOption
//                                        documentation ```kotlin\npublic open override val defaultReferenceOption: ReferenceOption\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getDefaultReferenceOption().
//                                        display_name defaultReferenceOption
//                                        documentation ```kotlin\npublic get(): ReferenceOption\n```
//                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                                            ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#defaultReferenceOption.
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getDefaultReferenceOption().
//                                                                   ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                                                                              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#defaultReferenceOption.
//                                                                                              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDefaultReferenceOption().
//                                                                                                                              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#defaultReferenceOption.
//                                                                                                                              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDefaultReferenceOption().
      override val supportsSequenceAsGeneratedKeys: Boolean by lazy {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsSequenceAsGeneratedKeys().
//                                                 display_name supportsSequenceAsGeneratedKeys
//                                                 documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsSequenceAsGeneratedKeys.
//                                                 display_name supportsSequenceAsGeneratedKeys
//                                                 documentation ```kotlin\npublic open override val supportsSequenceAsGeneratedKeys: Boolean\n```
//                                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                             ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                             ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 2:5
//                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsSequenceAsGeneratedKeys(). 2:5
//                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsSequenceAsGeneratedKeys. 2:5
          resolveDelegatedDialect()?.supportsSequenceAsGeneratedKeys ?: super.supportsSequenceAsGeneratedKeys
//        ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsSequenceAsGeneratedKeys().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsSequenceAsGeneratedKeys.
//                                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsSequenceAsGeneratedKeys().
//                                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsSequenceAsGeneratedKeys.
      }
      override val supportsTernaryAffectedRowValues: Boolean by lazy {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsTernaryAffectedRowValues().
//                                                  display_name supportsTernaryAffectedRowValues
//                                                  documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsTernaryAffectedRowValues.
//                                                  display_name supportsTernaryAffectedRowValues
//                                                  documentation ```kotlin\npublic open override val supportsTernaryAffectedRowValues: Boolean\n```
//                                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                              ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                              ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 2:5
//                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsTernaryAffectedRowValues(). 2:5
//                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsTernaryAffectedRowValues. 2:5
          resolveDelegatedDialect()?.supportsTernaryAffectedRowValues ?: super.supportsTernaryAffectedRowValues
//        ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsTernaryAffectedRowValues().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsTernaryAffectedRowValues.
//                                                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsTernaryAffectedRowValues().
//                                                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsTernaryAffectedRowValues.
      }
      override val supportsCreateSchema: Boolean by lazy { resolveDelegatedDialect()?.supportsCreateSchema ?: super.supportsCreateSchema }
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsCreateSchema().
//                                      display_name supportsCreateSchema
//                                      documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsCreateSchema.
//                                      display_name supportsCreateSchema
//                                      documentation ```kotlin\npublic open override val supportsCreateSchema: Boolean\n```
//                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                  ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsCreateSchema().
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsCreateSchema.
//                                                         ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsCreateSchema().
//                                                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsCreateSchema.
//                                                                                                                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsCreateSchema().
//                                                                                                                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsCreateSchema.
      override val supportsSubqueryUnions: Boolean by lazy { resolveDelegatedDialect()?.supportsSubqueryUnions ?: super.supportsSubqueryUnions }
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsSubqueryUnions().
//                                        display_name supportsSubqueryUnions
//                                        documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsSubqueryUnions.
//                                        display_name supportsSubqueryUnions
//                                        documentation ```kotlin\npublic open override val supportsSubqueryUnions: Boolean\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                    ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsSubqueryUnions().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsSubqueryUnions.
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsSubqueryUnions().
//                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsSubqueryUnions.
//                                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsSubqueryUnions().
//                                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsSubqueryUnions.
      override val supportsDualTableConcept: Boolean by lazy { resolveDelegatedDialect()?.supportsDualTableConcept ?: super.supportsDualTableConcept }
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsDualTableConcept().
//                                          display_name supportsDualTableConcept
//                                          documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsDualTableConcept.
//                                          display_name supportsDualTableConcept
//                                          documentation ```kotlin\npublic open override val supportsDualTableConcept: Boolean\n```
//                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                      ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsDualTableConcept().
//                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsDualTableConcept.
//                                                             ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsDualTableConcept().
//                                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsDualTableConcept.
//                                                                                                                          ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsDualTableConcept().
//                                                                                                                          ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsDualTableConcept.
      override val supportsOrderByNullsFirstLast: Boolean by lazy { resolveDelegatedDialect()?.supportsOrderByNullsFirstLast ?: super.supportsOrderByNullsFirstLast }
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsOrderByNullsFirstLast().
//                                               display_name supportsOrderByNullsFirstLast
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsOrderByNullsFirstLast.
//                                               display_name supportsOrderByNullsFirstLast
//                                               documentation ```kotlin\npublic open override val supportsOrderByNullsFirstLast: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                           ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsOrderByNullsFirstLast().
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsOrderByNullsFirstLast.
//                                                                  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                                                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsOrderByNullsFirstLast().
//                                                                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsOrderByNullsFirstLast.
//                                                                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsOrderByNullsFirstLast().
//                                                                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsOrderByNullsFirstLast.
      override val supportsWindowFrameGroupsMode: Boolean by lazy { resolveDelegatedDialect()?.supportsWindowFrameGroupsMode ?: super.supportsWindowFrameGroupsMode }
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsWindowFrameGroupsMode().
//                                               display_name supportsWindowFrameGroupsMode
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsWindowFrameGroupsMode.
//                                               display_name supportsWindowFrameGroupsMode
//                                               documentation ```kotlin\npublic open override val supportsWindowFrameGroupsMode: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                           ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsWindowFrameGroupsMode().
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsWindowFrameGroupsMode.
//                                                                  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#resolveDelegatedDialect().
//                                                                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsWindowFrameGroupsMode().
//                                                                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsWindowFrameGroupsMode.
//                                                                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsWindowFrameGroupsMode().
//                                                                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsWindowFrameGroupsMode.
      override val supportsColumnTypeChange: Boolean get() = isSecondVersion
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#supportsColumnTypeChange.
//                                          display_name supportsColumnTypeChange
//                                          documentation ```kotlin\npublic open override val supportsColumnTypeChange: Boolean\n```
//                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                   ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getSupportsColumnTypeChange().
//                                                       display_name supportsColumnTypeChange
//                                                       documentation ```kotlin\npublic get(): Boolean\n```
//                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getIsSecondVersion().
//                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#isSecondVersion.
  
      override fun isAllowedAsColumnDefault(e: Expression<*>): Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#isAllowedAsColumnDefault().
//                                          display_name isAllowedAsColumnDefault
//                                          documentation ```kotlin\npublic open override fun isAllowedAsColumnDefault(e: Expression<*>): Boolean\n```
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#isAllowedAsColumnDefault().
//                                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#isAllowedAsColumnDefault().(e)
//                                            display_name e
//                                            documentation ```kotlin\ne: Expression<*>\n```
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      override fun createIndex(index: Index): String {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createIndex().
//                             display_name createIndex
//                             documentation ```kotlin\npublic open override fun createIndex(index: Index): String\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createIndex().(index)
//                                   display_name index
//                                   documentation ```kotlin\nindex: Index\n```
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#
//                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (
              (majorVersion == H2MajorVersion.One || h2Mode == H2CompatibilityMode.Oracle) &&
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getMajorVersion().
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#majorVersion.
//                                            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2MajorVersion#One.
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode().
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode.
//                                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
              index.columns.any { it.columnType is TextColumnType }
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createIndex().(index)
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                          ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                  display_name it
//                                                                  documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                ^^ reference semanticdb maven . . (it)
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
          ) {
              exposedLogger.warn("Index on ${index.table.tableName} for ${index.columns.joinToString { it.name }} can't be created on CLOB in H2")
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createIndex().(index)
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createIndex().(index)
//                                                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                                                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                                   ^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                               display_name it
//                                                                                                               documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                                                                     ^^ reference semanticdb maven . . (it)
//                                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
              return ""
          }
          if (index.indexType != null) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createIndex().(index)
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexType().
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexType.
              exposedLogger.warn(
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
                  "Index of type ${index.indexType} on ${index.table.tableName} for ${index.columns.joinToString { it.name }} can't be created in H2"
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createIndex().(index)
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexType().
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexType.
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createIndex().(index)
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createIndex().(index)
//                                                                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                                                                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                                               ^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                           display_name it
//                                                                                                                           documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                                                                                 ^^ reference semanticdb maven . . (it)
//                                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
              )
              return ""
          }
          if (index.functions != null) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createIndex().(index)
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
              exposedLogger.warn(
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
                  "Functional index on ${index.table.tableName} using ${index.functions.joinToString { it.toString() }} can't be created in H2"
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createIndex().(index)
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createIndex().(index)
//                                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//                                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
//                                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                                   ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                     display_name it
//                                                                                                                     documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                                                                     ^^ reference semanticdb maven . . (it)
//                                                                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toString().
              )
              return ""
          }
          return super.createIndex(index)
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createIndex().(index)
      }
  
      @OptIn(InternalApi::class)
      override fun createDatabase(name: String) = "CREATE SCHEMA IF NOT EXISTS ${name.inProperCase()}"
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createDatabase().
//                                display_name createDatabase
//                                documentation ```kotlin\n@OptIn(...) public open override fun createDatabase(name: String): String\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createDatabase().
//                                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createDatabase().(name)
//                                     display_name name
//                                     documentation ```kotlin\nname: String\n```
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createDatabase().(name)
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
  
      override fun listDatabases(): String = "SHOW SCHEMAS"
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#listDatabases().
//                               display_name listDatabases
//                               documentation ```kotlin\npublic open override fun listDatabases(): String\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#listDatabases().
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      override fun modifyColumn(column: Column<*>, columnDiff: ColumnDiff): List<String> =
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#modifyColumn().
//                              display_name modifyColumn
//                              documentation ```kotlin\npublic open override fun modifyColumn(column: Column<*>, columnDiff: ColumnDiff): List<String>\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().
//                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#modifyColumn().(column)
//                                     display_name column
//                                     documentation ```kotlin\ncolumn: Column<*>\n```
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#modifyColumn().(columnDiff)
//                                                            display_name columnDiff
//                                                            documentation ```kotlin\ncolumnDiff: ColumnDiff\n```
//                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          super.modifyColumn(column, columnDiff).map { it.replace("MODIFY COLUMN", "ALTER COLUMN") }
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#modifyColumn().(column)
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#modifyColumn().(columnDiff)
//                                               ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                   display_name it
//                                                                                                   documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                     ^^ reference semanticdb maven . . (it)
//                                                        ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
  
      @OptIn(InternalApi::class)
      override fun dropDatabase(name: String) = "DROP SCHEMA IF EXISTS ${name.inProperCase()}"
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#dropDatabase().
//                              display_name dropDatabase
//                              documentation ```kotlin\n@OptIn(...) public open override fun dropDatabase(name: String): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropDatabase().
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#dropDatabase().(name)
//                                   display_name name
//                                   documentation ```kotlin\nname: String\n```
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#dropDatabase().(name)
//                                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
  
      @Suppress("CyclomaticComplexMethod")
      override fun areEquivalentColumnTypes(columnMetadataSqlType: String, columnMetadataJdbcType: Int, columnType: String): Boolean {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().
//                                          display_name areEquivalentColumnTypes
//                                          documentation ```kotlin\n@Suppress(...) public open override fun areEquivalentColumnTypes(columnMetadataSqlType: String, columnMetadataJdbcType: Int, columnType: String): Boolean\n```
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#areEquivalentColumnTypes().
//                                          ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().(columnMetadataSqlType)
//                                                                display_name columnMetadataSqlType
//                                                                documentation ```kotlin\ncolumnMetadataSqlType: String\n```
//                                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                         ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().(columnMetadataJdbcType)
//                                                                                                display_name columnMetadataJdbcType
//                                                                                                documentation ```kotlin\ncolumnMetadataJdbcType: Int\n```
//                                                                                                 ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                                      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().(columnType)
//                                                                                                                 display_name columnType
//                                                                                                                 documentation ```kotlin\ncolumnType: String\n```
//                                                                                                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          if (super.areEquivalentColumnTypes(columnMetadataSqlType, columnMetadataJdbcType, columnType)) {
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#areEquivalentColumnTypes().
//                                           ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().(columnMetadataSqlType)
//                                                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().(columnMetadataJdbcType)
//                                                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().(columnType)
              return true
          }
  
          val columnMetadataSqlType = columnMetadataSqlType.uppercase()
//            ^^^^^^^^^^^^^^^^^^^^^ definition local 13
//                                  display_name columnMetadataSqlType
//                                  documentation ```kotlin\nlocal val columnMetadataSqlType: String\n```
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().(columnMetadataSqlType)
//                                                          ^^^^^^^^^ reference semanticdb maven . . kotlin/text/uppercase(+2).
          val columnType = columnType.uppercase()
//            ^^^^^^^^^^ definition local 14
//                       display_name columnType
//                       documentation ```kotlin\nlocal val columnType: String\n```
//                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().(columnType)
//                                    ^^^^^^^^^ reference semanticdb maven . . kotlin/text/uppercase(+2).
  
          if (columnMetadataJdbcType == Types.ARRAY) {
//            ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().(columnMetadataJdbcType)
//                                            ^^^^^ reference semanticdb maven jdk 11 java/sql/Types#ARRAY.
              val baseType = columnMetadataSqlType.substringBefore(" ARRAY")
//                ^^^^^^^^ definition local 15
//                         display_name baseType
//                         documentation ```kotlin\nlocal val baseType: String\n```
//                           ^^^^^^^^^^^^^^^^^^^^^ reference local 13
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringBefore(+1).
              return areEquivalentColumnTypes(baseType, Types.OTHER, columnType.substringBefore(" ARRAY")) &&
//                   ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().
//                                            ^^^^^^^^ reference local 15
//                                                            ^^^^^ reference semanticdb maven jdk 11 java/sql/Types#OTHER.
//                                                                   ^^^^^^^^^^ reference local 14
//                                                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringBefore(+1).
                  areEquivalentColumnTypes(columnMetadataSqlType.replaceBefore("ARRAY", ""), Types.OTHER, columnType.replaceBefore("ARRAY", ""))
//                ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().
//                                         ^^^^^^^^^^^^^^^^^^^^^ reference local 13
//                                                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/replaceBefore(+1).
//                                                                                                 ^^^^^ reference semanticdb maven jdk 11 java/sql/Types#OTHER.
//                                                                                                        ^^^^^^^^^^ reference local 14
//                                                                                                                   ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/replaceBefore(+1).
          }
  
          if (columnType == "TEXT" && columnMetadataSqlType == "VARCHAR") {
//            ^^^^^^^^^^ reference local 14
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference local 13
              return true
          }
  
          if (listOf(columnMetadataSqlType, columnType).all { it.matches(Regex("VARCHAR(?:\\((?:MAX|\\d+)\\))?")) }) {
//            ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf(+1).
//                   ^^^^^^^^^^^^^^^^^^^^^ reference local 13
//                                          ^^^^^^^^^^ reference local 14
//                                                      ^^^ reference semanticdb maven . . kotlin/collections/all(+9).
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                  display_name it
//                                                                                                                  documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                            ^^ reference semanticdb maven . . (it)
//                                                               ^^^^^^^ reference semanticdb maven . . kotlin/text/matches().
//                                                                       ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
              return true
          }
  
          if (listOf(columnMetadataSqlType, columnType).all { it.matches(Regex("VARBINARY(?:\\((?:MAX|\\d+)\\))?")) }) {
//            ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf(+1).
//                   ^^^^^^^^^^^^^^^^^^^^^ reference local 13
//                                          ^^^^^^^^^^ reference local 14
//                                                      ^^^ reference semanticdb maven . . kotlin/collections/all(+9).
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                    display_name it
//                                                                                                                    documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                            ^^ reference semanticdb maven . . (it)
//                                                               ^^^^^^^ reference semanticdb maven . . kotlin/text/matches().
//                                                                       ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
              return true
          }
  
          return when (h2Mode) {
//                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode().
//                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode.
              H2CompatibilityMode.PostgreSQL -> {
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#PostgreSQL.
                  when {
                      // Auto-increment difference is dealt with elsewhere
                      (columnType == "SERIAL" && columnMetadataSqlType == "INT") || (columnType == "BIGSERIAL" && columnMetadataSqlType == "BIGINT") -> true
//                     ^^^^^^^^^^ reference local 14
//                                               ^^^^^^^^^^^^^^^^^^^^^ reference local 13
//                                                                                   ^^^^^^^^^^ reference local 14
//                                                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference local 13
                      else -> false
                  }
              }
              H2CompatibilityMode.Oracle -> {
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
                  when {
                      columnType == "DATE" && columnMetadataSqlType == "TIMESTAMP(0)" -> true
//                    ^^^^^^^^^^ reference local 14
//                                            ^^^^^^^^^^^^^^^^^^^^^ reference local 13
                      // Unlike Oracle, H2 Oracle mode does not distinguish between VARCHAR2(4000) and VARCHAR2(4000 CHAR).
                      // It treats the length as a character count and does not enforce a separate byte limit.
                      listOf(columnMetadataSqlType, columnType).all { it.matches(Regex("VARCHAR2(?:\\((?:MAX|\\d+)(?:\\s+CHAR)?\\))?")) } -> true
//                    ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf(+1).
//                           ^^^^^^^^^^^^^^^^^^^^^ reference local 13
//                                                  ^^^^^^^^^^ reference local 14
//                                                              ^^^ reference semanticdb maven . . kotlin/collections/all(+9).
//                                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                                        display_name it
//                                                                                                                                        documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                                    ^^ reference semanticdb maven . . (it)
//                                                                       ^^^^^^^ reference semanticdb maven . . kotlin/text/matches().
//                                                                               ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
                      else -> {
                          // H2 maps NUMBER to NUMERIC
                          val numberRegex = Regex("NUMBER(?:\\((\\d+)(?:,\\s?(\\d+))?\\))?")
//                            ^^^^^^^^^^^ definition local 16
//                                        display_name numberRegex
//                                        documentation ```kotlin\nlocal val numberRegex: Regex\n```
//                                          ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
                          val numericRegex = Regex("NUMERIC(?:\\((\\d+)(?:,\\s?(\\d+))?\\))?")
//                            ^^^^^^^^^^^^ definition local 17
//                                         display_name numericRegex
//                                         documentation ```kotlin\nlocal val numericRegex: Regex\n```
//                                           ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
                          val numberMatch = numberRegex.find(columnType)
//                            ^^^^^^^^^^^ definition local 18
//                                        display_name numberMatch
//                                        documentation ```kotlin\nlocal val numberMatch: MatchResult?\n```
//                                          ^^^^^^^^^^^ reference local 16
//                                                      ^^^^ reference semanticdb maven . . kotlin/text/Regex#find().
//                                                           ^^^^^^^^^^ reference local 14
                          val numericMatch = numericRegex.find(columnMetadataSqlType)
//                            ^^^^^^^^^^^^ definition local 19
//                                         display_name numericMatch
//                                         documentation ```kotlin\nlocal val numericMatch: MatchResult?\n```
//                                           ^^^^^^^^^^^^ reference local 17
//                                                        ^^^^ reference semanticdb maven . . kotlin/text/Regex#find().
//                                                             ^^^^^^^^^^^^^^^^^^^^^ reference local 13
                          if (numberMatch != null && numericMatch != null) {
//                            ^^^^^^^^^^^ reference local 18
//                                                   ^^^^^^^^^^^^ reference local 19
                              numberMatch.groupValues[1] == numericMatch.groupValues[1] // compare precision
//                            ^^^^^^^^^^^ reference local 18
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#get().
//                                        ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/MatchResult#getGroupValues().
//                                        ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/MatchResult#groupValues.
//                                                          ^^^^^^^^^^^^ reference local 19
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#get().
//                                                                       ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/MatchResult#getGroupValues().
//                                                                       ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/MatchResult#groupValues.
                          } else {
                              false
                          }
                      }
                  }
              }
              H2CompatibilityMode.SQLServer ->
//                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#SQLServer.
                  when {
                      columnType.equals("uniqueidentifier", ignoreCase = true) && columnMetadataSqlType == "UUID" -> true
//                    ^^^^^^^^^^ reference local 14
//                               ^^^^^^ reference semanticdb maven . . kotlin/text/equals(+1).
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference local 13
                      // Auto-increment difference is dealt with elsewhere
                      columnType.contains(" IDENTITY") ->
//                    ^^^^^^^^^^ reference local 14
//                               ^^^^^^^^ reference semanticdb maven . . kotlin/text/contains().
                          areEquivalentColumnTypes(columnMetadataSqlType, columnMetadataJdbcType, columnType.substringBefore(" IDENTITY"))
//                        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().
//                                                 ^^^^^^^^^^^^^^^^^^^^^ reference local 13
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().(columnMetadataJdbcType)
//                                                                                                ^^^^^^^^^^ reference local 14
//                                                                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringBefore(+1).
                      // H2 maps DATETIME2 to TIMESTAMP
                      columnType.matches(Regex("DATETIME2(?:\\(\\d+\\))?")) &&
//                    ^^^^^^^^^^ reference local 14
//                               ^^^^^^^ reference semanticdb maven . . kotlin/text/matches().
//                                       ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
                          columnMetadataSqlType.matches(Regex("TIMESTAMP(?:\\(\\d+\\))?")) -> true
//                        ^^^^^^^^^^^^^^^^^^^^^ reference local 13
//                                              ^^^^^^^ reference semanticdb maven . . kotlin/text/matches().
//                                                      ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
                      // H2 maps NVARCHAR to VARCHAR
                      columnType.matches(Regex("NVARCHAR(?:\\((\\d+|MAX)\\))?")) &&
//                    ^^^^^^^^^^ reference local 14
//                               ^^^^^^^ reference semanticdb maven . . kotlin/text/matches().
//                                       ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
                          columnMetadataSqlType.matches(Regex("VARCHAR(?:\\((\\d+|MAX)\\))?")) -> true
//                        ^^^^^^^^^^^^^^^^^^^^^ reference local 13
//                                              ^^^^^^^ reference semanticdb maven . . kotlin/text/matches().
//                                                      ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
                      else -> false
                  }
              null, H2CompatibilityMode.MySQL, H2CompatibilityMode.MariaDB ->
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MySQL.
//                                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#MariaDB.
                  when {
                      // Auto-increment difference is dealt with elsewhere
                      columnType.contains(" AUTO_INCREMENT") ->
//                    ^^^^^^^^^^ reference local 14
//                               ^^^^^^^^ reference semanticdb maven . . kotlin/text/contains().
                          areEquivalentColumnTypes(columnMetadataSqlType, columnMetadataJdbcType, columnType.substringBefore(" AUTO_INCREMENT"))
//                        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().
//                                                 ^^^^^^^^^^^^^^^^^^^^^ reference local 13
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#areEquivalentColumnTypes().(columnMetadataJdbcType)
//                                                                                                ^^^^^^^^^^ reference local 14
//                                                                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringBefore(+1).
                      // H2 maps DATETIME to TIMESTAMP
                      columnType.matches(Regex("DATETIME(?:\\(\\d+\\))?")) &&
//                    ^^^^^^^^^^ reference local 14
//                               ^^^^^^^ reference semanticdb maven . . kotlin/text/matches().
//                                       ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
                          columnMetadataSqlType.matches(Regex("TIMESTAMP(?:\\(\\d+\\))?")) -> true
//                        ^^^^^^^^^^^^^^^^^^^^^ reference local 13
//                                              ^^^^^^^ reference semanticdb maven . . kotlin/text/matches().
//                                                      ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
                      else -> false
                  }
          }
      }
  
      companion object : DialectNameProvider("H2")
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#Companion#
//                                                 display_name Companion
//                                                 documentation ```kotlin\npublic final companion object Companion : VendorDialect.DialectNameProvider\n```
//                                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#Companion#`<init>`().
//                                                 display_name Companion
//                                                 documentation ```kotlin\nprivate constructor(): H2Dialect.Companion\n```
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
  }
  
  /** The current H2 database compatibility mode or `null` if the current database is not H2. */
  val DatabaseDialect.h2Mode: H2Dialect.H2CompatibilityMode? get() = (this as? H2Dialect)?.h2Mode
//                    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                           display_name h2Mode
//                           documentation ```kotlin\npublic final val DatabaseDialect.h2Mode: H2Dialect.H2CompatibilityMode?\n```\n\n----\n\n The current H2 database compatibility mode or `null` if the current database is not H2.
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#
//                                                           ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                               display_name h2Mode
//                                                               documentation ```kotlin\npublic get(): H2Dialect.H2CompatibilityMode?\n```
//                                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode().
//                                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode.
