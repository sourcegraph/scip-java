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
  import java.util.*
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/util/
  
  internal object PostgreSQLDataTypeProvider : DataTypeProvider() {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#
//                                           display_name PostgreSQLDataTypeProvider
//                                           documentation ```kotlin\ninternal final object PostgreSQLDataTypeProvider : DataTypeProvider\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#`<init>`().
//                                           display_name PostgreSQLDataTypeProvider
//                                           documentation ```kotlin\nprivate constructor(): PostgreSQLDataTypeProvider\n```
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
      override fun byteType(): String = "SMALLINT"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#byteType().
//                          display_name byteType
//                          documentation ```kotlin\npublic open override fun byteType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#byteType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun floatType(): String = "REAL"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#floatType().
//                           display_name floatType
//                           documentation ```kotlin\npublic open override fun floatType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#floatType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun ulongType(): String = "BIGINT"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#ulongType().
//                           display_name ulongType
//                           documentation ```kotlin\npublic open override fun ulongType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun integerAutoincType(): String = "SERIAL"
//                 ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#integerAutoincType().
//                                    display_name integerAutoincType
//                                    documentation ```kotlin\npublic open override fun integerAutoincType(): String\n```
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerAutoincType().
//                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun longAutoincType(): String = "BIGSERIAL"
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#longAutoincType().
//                                 display_name longAutoincType
//                                 documentation ```kotlin\npublic open override fun longAutoincType(): String\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#longAutoincType().
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun ulongAutoincType(): String = "BIGSERIAL"
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#ulongAutoincType().
//                                  display_name ulongAutoincType
//                                  documentation ```kotlin\npublic open override fun ulongAutoincType(): String\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongAutoincType().
//                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun uuidType(): String = "uuid"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#uuidType().
//                          display_name uuidType
//                          documentation ```kotlin\npublic open override fun uuidType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun binaryType(): String = "bytea"
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#binaryType().
//                            display_name binaryType
//                            documentation ```kotlin\npublic open override fun binaryType(): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType().
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun binaryType(length: Int): String {
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#binaryType(+1).
//                            display_name binaryType
//                            documentation ```kotlin\npublic open override fun binaryType(length: Int): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType(+1).
//                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#binaryType(+1).(length)
//                                   display_name length
//                                   documentation ```kotlin\nlength: Int\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Int#
//                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
          exposedLogger.warn("The length of the binary column is not required.")
//        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                      ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
          return binaryType()
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#binaryType().
      }
  
      override fun blobType(): String = "bytea"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#blobType().
//                          display_name blobType
//                          documentation ```kotlin\npublic open override fun blobType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#blobType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun uuidToDB(value: UUID): Any = value
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#uuidToDB().
//                          display_name uuidToDB
//                          documentation ```kotlin\npublic open override fun uuidToDB(value: UUID): Any\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidToDB().
//                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#uuidToDB().(value)
//                                display_name value
//                                documentation ```kotlin\nvalue: UUID\n```
//                                 ^^^^ reference semanticdb maven jdk 11 java/util/UUID#
//                                        ^^^ reference semanticdb maven . . kotlin/Any#
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#uuidToDB().(value)
      override fun dateTimeType(): String = "TIMESTAMP"
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#dateTimeType().
//                              display_name dateTimeType
//                              documentation ```kotlin\npublic open override fun dateTimeType(): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#dateTimeType().
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun jsonBType(): String = "JSONB"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#jsonBType().
//                           display_name jsonBType
//                           documentation ```kotlin\npublic open override fun jsonBType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#jsonBType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      override fun processForDefaultValue(e: Expression<*>): String = when {
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().
//                                        display_name processForDefaultValue
//                                        documentation ```kotlin\npublic open override fun processForDefaultValue(e: Expression<*>): String\n```
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                                          display_name e
//                                          documentation ```kotlin\ne: Expression<*>\n```
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                           ^^^^^^ reference semanticdb maven . . kotlin/String#
          e is LiteralOp<*> && e.columnType is JsonColumnMarker && (currentDialect as? H2Dialect) == null -> {
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
              val cast = if (e.columnType.usesBinaryFormat) "::jsonb" else "::json"
//                ^^^^ definition local 0
//                     display_name cast
//                     documentation ```kotlin\nlocal val cast: String\n```
//                           ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#getUsesBinaryFormat().
//                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#usesBinaryFormat.
              "${super.processForDefaultValue(e)}$cast"
//                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                                                ^^^^ reference local 0
          }
          e is LiteralOp<*> && e.columnType is BlobColumnType && e.columnType.useObjectIdentifier && (currentDialect as? H2Dialect) == null -> {
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                                               ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#getUseObjectIdentifier().
//                                                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#useObjectIdentifier.
//                                                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
              "lo_from_bytea(0, ${super.processForDefaultValue(e)} :: bytea)"
//                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
          }
          e is LiteralOp<*> && e.columnType is ArrayColumnType<*, *> -> {
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
              val processed = super.processForDefaultValue(e)
//                ^^^^^^^^^ definition local 1
//                          display_name processed
//                          documentation ```kotlin\nlocal val processed: String\n```
//                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                         ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
              processed
//            ^^^^^^^^^ reference local 1
                  .takeUnless { it == "ARRAY[]" }
//                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/takeUnless().
//                            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                display_name it
//                                                documentation ```kotlin\nit: Expression<out Any?>\n```
//                              ^^ reference semanticdb maven . . (it)
                  ?: run {
//                   ^^^ reference semanticdb maven . . kotlin/run(+1).
                      val cast = e.columnType.delegateType.lowercase()
//                        ^^^^ definition local 2
//                             display_name cast
//                             documentation ```kotlin\nlocal val cast: String\n```
//                               ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegateType.
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegateType().
//                                                         ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
                      "$processed::$cast[]"
//                      ^^^^^^^^^ reference local 1
//                                  ^^^^ reference local 2
                  }
          }
          else -> super.processForDefaultValue(e)
//                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
      }
  
      override fun hexToDb(hexString: String): String = """E'\\x$hexString'"""
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#hexToDb().
//                         display_name hexToDb
//                         documentation ```kotlin\npublic open override fun hexToDb(hexString: String): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#hexToDb().
//                         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#hexToDb().(hexString)
//                                   display_name hexString
//                                   documentation ```kotlin\nhexString: String\n```
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#hexToDb().(hexString)
  }
  
  internal object PostgreSQLFunctionProvider : FunctionProvider() {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#
//                                           display_name PostgreSQLFunctionProvider
//                                           documentation ```kotlin\ninternal final object PostgreSQLFunctionProvider : FunctionProvider\n```\n\n----\n\n\n Implementation of [FunctionProvider.locate]\n Note: search is case-sensitive\n
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#`<init>`().
//                                           display_name PostgreSQLFunctionProvider
//                                           documentation ```kotlin\nprivate constructor(): PostgreSQLFunctionProvider\n```\n\n----\n\n\n Implementation of [FunctionProvider.locate]\n Note: search is case-sensitive\n
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
  
      override fun nextVal(seq: Sequence, builder: QueryBuilder): Unit = builder {
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#nextVal().
//                         display_name nextVal
//                         documentation ```kotlin\npublic open override fun nextVal(seq: Sequence, builder: QueryBuilder): Unit\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().
//                         ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#nextVal().(seq)
//                             display_name seq
//                             documentation ```kotlin\nseq: Sequence\n```
//                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
//                                        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#nextVal().(builder)
//                                                display_name builder
//                                                documentation ```kotlin\nbuilder: QueryBuilder\n```
//                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#nextVal().(builder)
          append("NEXTVAL('", seq.identifier, "')")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#nextVal().(seq)
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getIdentifier().
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#identifier.
      }
  
      override fun <T : String?> groupConcat(expr: GroupConcat<T>, queryBuilder: QueryBuilder) {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().
//                                           display_name groupConcat
//                                           documentation ```kotlin\npublic open override fun <T : String?> groupConcat(expr: GroupConcat<T>, queryBuilder: QueryBuilder): Unit\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().
//                                           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().(expr)
//                                                display_name expr
//                                                documentation ```kotlin\nexpr: GroupConcat<T>\n```
//                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#
//                                                                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().(queryBuilder)
//                                                                              display_name queryBuilder
//                                                                              documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
          @OptIn(InternalApi::class)
          val tr = CoreTransactionManager.currentTransaction()
//            ^^ definition local 3
//               display_name tr
//               documentation ```kotlin\n@OptIn(...) local val tr: Transaction\n```
//                                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
          return when (expr.separator) {
//                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().(expr)
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getSeparator().
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#separator.
              null -> tr.throwUnsupportedException("PostgreSQL requires explicit separator in STRING_AGG function.")
//                    ^^ reference local 3
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
              else -> queryBuilder {
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().(queryBuilder)
                  append("STRING_AGG(")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                  if (expr.distinct) append(" DISTINCT ")
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().(expr)
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#distinct.
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getDistinct().
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                  append(expr.expr, ", '", expr.separator, "'")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().(expr)
//                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#expr.
//                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getExpr().
//                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().(expr)
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getSeparator().
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#separator.
                  if (expr.orderBy.isNotEmpty()) {
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().(expr)
//                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
//                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//                                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty().
                      expr.orderBy.appendTo(prefix = " ORDER BY ") {
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().(expr)
//                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
//                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                                                                 ^ definition semanticdb maven . . (it) 2:21
//                                                                   display_name it
//                                                                   documentation ```kotlin\nit: Expression<out Any?>\n```
                          append(it.first, " ", it.second.name)
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                               ^^ reference semanticdb maven . . (it)
//                                  ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                  ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                              ^^ reference semanticdb maven . . (it)
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#getName().
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#name.
                      }
                  }
                  append(")")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
              }
          }
      }
  
      /**
       * Implementation of [FunctionProvider.locate]
       * Note: search is case-sensitive
       * */
      override fun <T : String?> locate(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().
//                                      display_name locate
//                                      documentation ```kotlin\npublic open override fun <T : String?> locate(queryBuilder: QueryBuilder, expr: Expression<T>, substring: String): Unit\n```\n\n----\n\n\n Implementation of [FunctionProvider.locate]\n Note: search is case-sensitive\n
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().
          queryBuilder: QueryBuilder,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
          expr: Expression<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          substring: String
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(substring)
//                  display_name substring
//                  documentation ```kotlin\nsubstring: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
      ) = queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(queryBuilder)
          append("POSITION(\'", substring, "\' IN ", expr, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(substring)
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(expr)
      }
  
      override fun <T : String?> regexp(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().
//                                      display_name regexp
//                                      documentation ```kotlin\npublic open override fun <T : String?> regexp(expr1: Expression<T>, pattern: Expression<String>, caseSensitive: Boolean, queryBuilder: QueryBuilder): Unit\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().
          expr1: Expression<T>,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(expr1)
//              display_name expr1
//              documentation ```kotlin\nexpr1: Expression<T>\n```
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          pattern: Expression<String>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(pattern)
//                display_name pattern
//                documentation ```kotlin\npattern: Expression<String>\n```
//                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          caseSensitive: Boolean,
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(caseSensitive)
//                      display_name caseSensitive
//                      documentation ```kotlin\ncaseSensitive: Boolean\n```
//                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
      ): Unit = queryBuilder {
//       ^^^^ reference semanticdb maven . . kotlin/Unit#
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(queryBuilder)
          append(expr1)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(expr1)
          if (caseSensitive) {
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(caseSensitive)
              append(" ~ ")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          } else {
              append(" ~* ")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          }
          append(pattern)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(pattern)
      }
  
      override fun <T> date(expr: Expression<T>, queryBuilder: QueryBuilder) = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().
//                          display_name date
//                          documentation ```kotlin\npublic open override fun <T> date(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().(queryBuilder)
          append("CAST(", expr, " AS DATE)")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().(expr)
      }
  
      override fun <T> time(expr: Expression<T>, queryBuilder: QueryBuilder) = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().
//                          display_name time
//                          documentation ```kotlin\npublic open override fun <T> time(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().(queryBuilder)
          append("TO_CHAR(", expr, ", 'HH24:MI:SS.US')")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().(expr)
      }
  
      override fun <T> year(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().
//                          display_name year
//                          documentation ```kotlin\npublic open override fun <T> year(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                            ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().(queryBuilder)
          append("Extract(YEAR FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
  
      override fun <T> month(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().
//                           display_name month
//                           documentation ```kotlin\npublic open override fun <T> month(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().
//                           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().(expr)
//                                display_name expr
//                                documentation ```kotlin\nexpr: Expression<T>\n```
//                                 ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().(queryBuilder)
//                                                             display_name queryBuilder
//                                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().(queryBuilder)
          append("Extract(MONTH FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
  
      override fun <T> day(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().
//                         display_name day
//                         documentation ```kotlin\npublic open override fun <T> day(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().
//                         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().(expr)
//                              display_name expr
//                              documentation ```kotlin\nexpr: Expression<T>\n```
//                               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().(queryBuilder)
//                                                           display_name queryBuilder
//                                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().(queryBuilder)
          append("Extract(DAY FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
  
      override fun <T> hour(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().
//                          display_name hour
//                          documentation ```kotlin\npublic open override fun <T> hour(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                            ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().(queryBuilder)
          append("Extract(HOUR FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
  
      override fun <T> minute(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().
//                            display_name minute
//                            documentation ```kotlin\npublic open override fun <T> minute(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().
//                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().(expr)
//                                 display_name expr
//                                 documentation ```kotlin\nexpr: Expression<T>\n```
//                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().(queryBuilder)
//                                                              display_name queryBuilder
//                                                              documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                              ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().(queryBuilder)
          append("Extract(MINUTE FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
  
      override fun <T> second(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().
//                            display_name second
//                            documentation ```kotlin\npublic open override fun <T> second(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().
//                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().(expr)
//                                 display_name expr
//                                 documentation ```kotlin\nexpr: Expression<T>\n```
//                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().(queryBuilder)
//                                                              display_name queryBuilder
//                                                              documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                              ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().(queryBuilder)
          append("Extract(SECOND FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
  
      override fun <T> arraySlice(expression: Expression<T>, lower: Int?, upper: Int?, queryBuilder: QueryBuilder) {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().
//                                display_name arraySlice
//                                documentation ```kotlin\npublic open override fun <T> arraySlice(expression: Expression<T>, lower: Int?, upper: Int?, queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(expression)
//                                           display_name expression
//                                           documentation ```kotlin\nexpression: Expression<T>\n```
//                                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(lower)
//                                                                 display_name lower
//                                                                 documentation ```kotlin\nlower: Int?\n```
//                                                                  ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(upper)
//                                                                              display_name upper
//                                                                              documentation ```kotlin\nupper: Int?\n```
//                                                                               ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                     ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(queryBuilder)
//                                                                                                  display_name queryBuilder
//                                                                                                  documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(queryBuilder)
              append(expression, "[")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(expression)
              lower?.let { +it.toString() }
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(lower)
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                          display_name it
//                                          documentation ```kotlin\nit: Expression<out Any?>\n```
//                         ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                          ^^ reference semanticdb maven . . (it)
//                             ^^^^^^^^ reference semanticdb maven . . kotlin/Int#toString().
              +":"
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              upper?.let { +it.toString() }
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(upper)
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                          display_name it
//                                          documentation ```kotlin\nit: Expression<out Any?>\n```
//                         ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                          ^^ reference semanticdb maven . . (it)
//                             ^^^^^^^^ reference semanticdb maven . . kotlin/Int#toString().
              +"]"
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          }
      }
  
      override fun <T> jsonExtract(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().
//                                 display_name jsonExtract
//                                 documentation ```kotlin\npublic open override fun <T> jsonExtract(expression: Expression<T>, vararg path: String, toScalar: Boolean, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().
          expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          vararg path: String,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(path)
//                    display_name path
//                    documentation ```kotlin\nvararg path: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/Array#
          toScalar: Boolean,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(toScalar)
//                 display_name toScalar
//                 documentation ```kotlin\ntoScalar: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
      ) = queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(queryBuilder)
          append("${jsonType.sqlType()}_EXTRACT_PATH")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(jsonType)
//                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
          if (toScalar) append("_TEXT")
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(toScalar)
//                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append("(", expression, ", ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(expression)
          path.ifEmpty { arrayOf("$") }.appendTo { +"'$it'" }
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(path)
//             ^^^^^^^ reference semanticdb maven . . kotlin/collections/ifEmpty().
//                       ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                            display_name it
//                                                            documentation ```kotlin\nit: Expression<out Any?>\n```
//                                                 ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                                     ^^ reference semanticdb maven . . (it)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
  
      override fun jsonContains(
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().
//                              display_name jsonContains
//                              documentation ```kotlin\npublic open override fun jsonContains(target: Expression<*>, candidate: Expression<*>, path: String?, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().
          target: Expression<*>,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(target)
//               display_name target
//               documentation ```kotlin\ntarget: Expression<*>\n```
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          candidate: Expression<*>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(candidate)
//                  display_name candidate
//                  documentation ```kotlin\ncandidate: Expression<*>\n```
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          path: String?,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(path)
//             display_name path
//             documentation ```kotlin\npath: String?\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/String#
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
      ) {
          @OptIn(InternalApi::class)
          path?.let {
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(path)
//              ^^^ reference semanticdb maven . . kotlin/let().
//                  ^ definition semanticdb maven . . (it) 2:9
//                    display_name it
//                    documentation ```kotlin\nit: Expression<out Any?>\n```
              CoreTransactionManager.currentTransaction().throwUnsupportedException("PostgreSQL does not support a JSON path argument")
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          val isNotJsonB = !(jsonType as JsonColumnMarker).usesBinaryFormat
//            ^^^^^^^^^^ definition local 4
//                       display_name isNotJsonB
//                       documentation ```kotlin\nlocal val isNotJsonB: Boolean\n```
//                         ^ reference semanticdb maven . . kotlin/Boolean#not().
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(jsonType)
//                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#getUsesBinaryFormat().
//                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#usesBinaryFormat.
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(queryBuilder)
              append(target)
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(target)
              if (isNotJsonB) append("::jsonb")
//                ^^^^^^^^^^ reference local 4
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
              append(" @> ", candidate)
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(candidate)
              if (isNotJsonB) append("::jsonb")
//                ^^^^^^^^^^ reference local 4
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          }
      }
  
      override fun jsonExists(
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().
//                            display_name jsonExists
//                            documentation ```kotlin\npublic open override fun jsonExists(expression: Expression<*>, vararg path: String, optional: String?, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().
          expression: Expression<*>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<*>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          vararg path: String,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(path)
//                    display_name path
//                    documentation ```kotlin\nvararg path: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/Array#
          optional: String?,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(optional)
//                 display_name optional
//                 documentation ```kotlin\noptional: String?\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/String#
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
      ) {
          @OptIn(InternalApi::class)
          if (path.size > 1) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(path)
//                 ^^^^ reference semanticdb maven . . kotlin/Array#getSize().
//                 ^^^^ reference semanticdb maven . . kotlin/Array#size.
//                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
              CoreTransactionManager.currentTransaction().throwUnsupportedException("PostgreSQL does not support multiple JSON path arguments")
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          val isNotJsonB = !(jsonType as JsonColumnMarker).usesBinaryFormat
//            ^^^^^^^^^^ definition local 5
//                       display_name isNotJsonB
//                       documentation ```kotlin\nlocal val isNotJsonB: Boolean\n```
//                         ^ reference semanticdb maven . . kotlin/Boolean#not().
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(jsonType)
//                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#getUsesBinaryFormat().
//                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#usesBinaryFormat.
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(queryBuilder)
              append("JSONB_PATH_EXISTS(")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
              if (isNotJsonB) {
//                ^^^^^^^^^^ reference local 5
                  append("CAST(", expression, " as jsonb), ")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(expression)
              } else {
                  append(expression, ", ")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(expression)
              }
              append("'$", path.firstOrNull() ?: "", "'")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(path)
//                              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull().
              optional?.let {
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(optional)
//                      ^^^ reference semanticdb maven . . kotlin/let().
//                          ^ definition semanticdb maven . . (it) 2:13
//                            display_name it
//                            documentation ```kotlin\nit: Expression<out Any?>\n```
                  append(", '$it'")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                            ^^ reference semanticdb maven . . (it)
              }
              append(")")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          }
      }
  
      private const val ON_CONFLICT_IGNORE = "ON CONFLICT DO NOTHING"
//                      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#ON_CONFLICT_IGNORE.
//                                         display_name ON_CONFLICT_IGNORE
//                                         documentation ```kotlin\nprivate final const val ON_CONFLICT_IGNORE: String\n```
//                      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#getON_CONFLICT_IGNORE().
//                                         display_name ON_CONFLICT_IGNORE
//                                         documentation ```kotlin\nprivate get(): String\n```
  
      override fun insert(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().
//                        display_name insert
//                        documentation ```kotlin\npublic open override fun insert(ignore: Boolean, table: Table, columns: List<Column<*>>, expr: String, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
          ignore: Boolean,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(ignore)
//               display_name ignore
//               documentation ```kotlin\nignore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
          columns: List<Column<*>>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(columns)
//                display_name columns
//                documentation ```kotlin\ncolumns: List<Column<*>>\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          expr: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          val def = super.insert(false, table, columns, expr, transaction)
//            ^^^ definition local 6
//                display_name def
//                documentation ```kotlin\nlocal val def: String\n```
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(table)
//                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(columns)
//                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(expr)
//                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(transaction)
          return if (ignore) "$def $ON_CONFLICT_IGNORE" else def
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(ignore)
//                             ^^^ reference local 6
//                                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#ON_CONFLICT_IGNORE.
//                                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#getON_CONFLICT_IGNORE().
//                                                           ^^^ reference local 6
      }
  
      override fun update(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().
//                        display_name update
//                        documentation ```kotlin\npublic open override fun update(targets: Join, columnsAndValues: List<Pair<Column<*>, Any?>>, limit: Int?, where: Op<Boolean>?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).
          targets: Join,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(targets)
//                display_name targets
//                documentation ```kotlin\ntargets: Join\n```
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
          columnsAndValues: List<Pair<Column<*>, Any?>>,
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(columnsAndValues)
//                         display_name columnsAndValues
//                         documentation ```kotlin\ncolumnsAndValues: List<Pair<Column<*>, Any?>>\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
      ): String = with(QueryBuilder(true)) {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                ^^^^ reference semanticdb maven . . kotlin/with().
//                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
          if (limit != null) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(limit)
              transaction.throwUnsupportedException("PostgreSQL doesn't support LIMIT in UPDATE clause.")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          val tableToUpdate = columnsAndValues.map { it.first.table }.distinct().singleOrNull()
//            ^^^^^^^^^^^^^ definition local 7
//                          display_name tableToUpdate
//                          documentation ```kotlin\nlocal val tableToUpdate: Table\n```
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(columnsAndValues)
//                                             ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                 ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                    display_name it
//                                                                    documentation ```kotlin\nit: Expression<out Any?>\n```
//                                                   ^^ reference semanticdb maven . . (it)
//                                                      ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                      ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                    ^^^^^^^^ reference semanticdb maven . . kotlin/collections/distinct(+9).
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull(+19).
              ?: transaction.throwUnsupportedException("PostgreSQL supports a join updates with a single table columns to update.")
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(transaction)
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          targets.checkJoinTypes(StatementType.UPDATE)
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(targets)
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().
//                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#UPDATE.
          +"UPDATE "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          tableToUpdate.describe(transaction, this)
//        ^^^^^^^^^^^^^ reference local 7
//                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().
//                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(transaction)
          +" SET "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          columnsAndValues.appendTo(this) { (col, value) ->
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(columnsAndValues)
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                          ^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                       display_name <destruct>
//                                                       documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                           ^^^ definition local 8
//                                               display_name col
//                                               documentation ```kotlin\nlocal val col: Column<*>\n```
//                                           ^^^ reference semanticdb maven . . (`<destruct>`)
//                                           ^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                ^^^^^ definition local 9
//                                                      display_name value
//                                                      documentation ```kotlin\nlocal val value: Any?\n```
//                                                ^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
              append("${transaction.identity(col)}=")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(transaction)
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                           ^^^ reference local 8
              registerArgument(col, value)
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                             ^^^ reference local 8
//                                  ^^^^^ reference local 9
          }
  
          appendJoinPartForUpdateClause(tableToUpdate, targets, transaction)
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().
//                                      ^^^^^^^^^^^^^ reference local 7
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(targets)
//                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(transaction)
  
          where?.let {
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(where)
//               ^^^ reference semanticdb maven . . kotlin/let().
//                   ^ definition semanticdb maven . . (it) 3:9
//                     display_name it
//                     documentation ```kotlin\nit: Expression<out Any?>\n```
              +" AND "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              +it
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//             ^^ reference semanticdb maven . . (it)
          }
          toString()
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
      }
  
      override fun upsert(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().
//                        display_name upsert
//                        documentation ```kotlin\npublic open override fun upsert(table: Table, data: List<Pair<Column<*>, Any?>>, expression: String, onUpdate: List<Pair<Column<*>, Any?>>, keyColumns: List<Column<*>>, where: Op<Boolean>?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
          data: List<Pair<Column<*>, Any?>>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(data)
//             display_name data
//             documentation ```kotlin\ndata: List<Pair<Column<*>, Any?>>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          expression: String,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: String\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
          onUpdate: List<Pair<Column<*>, Any?>>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: List<Pair<Column<*>, Any?>>\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          keyColumns: List<Column<*>>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(keyColumns)
//                   display_name keyColumns
//                   documentation ```kotlin\nkeyColumns: List<Column<*>>\n```
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (keyColumns.isEmpty()) {
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(keyColumns)
//                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#isEmpty().
              transaction.throwUnsupportedException("UPSERT requires a unique key or constraint as a conflict target")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
  
          return with(QueryBuilder(true)) {
//               ^^^^ reference semanticdb maven . . kotlin/with().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
              +insert(false, table, data.unzip().first, expression, transaction)
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(table)
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(data)
//                                       ^^^^^ reference semanticdb maven . . kotlin/collections/unzip(+1).
//                                               ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                               ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(expression)
//                                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(transaction)
  
              +" ON CONFLICT "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              keyColumns.appendTo(prefix = "(", postfix = ")") { column ->
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(keyColumns)
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                               ^^^^^^ definition semanticdb maven . . (column)
//                                                                      display_name column
//                                                                      documentation ```kotlin\ncolumn: Column<*>\n```
                  append(transaction.identity(column))
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(transaction)
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                            ^^^^^^ reference semanticdb maven . . (column)
              }
  
              +" DO UPDATE SET "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              onUpdate.appendTo { (columnToUpdate, updateExpression) ->
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(onUpdate)
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                                   display_name <destruct>
//                                                                   documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                 ^^^^^^^^^^^^^^ definition local 10
//                                                display_name columnToUpdate
//                                                documentation ```kotlin\nlocal val columnToUpdate: Column<*>\n```
//                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                 ^^^^^^^^^^^^^^^^ definition local 11
//                                                                  display_name updateExpression
//                                                                  documentation ```kotlin\nlocal val updateExpression: Any?\n```
//                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
                  append("${transaction.identity(columnToUpdate)}=")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(transaction)
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                               ^^^^^^^^^^^^^^ reference local 10
                  registerArgument(columnToUpdate, updateExpression)
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                                 ^^^^^^^^^^^^^^ reference local 10
//                                                 ^^^^^^^^^^^^^^^^ reference local 11
              }
  
              where?.let {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(where)
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^ definition semanticdb maven . . (it) 3:13
//                         display_name it
//                         documentation ```kotlin\nit: Expression<out Any?>\n```
                  +" WHERE "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                  +it
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                 ^^ reference semanticdb maven . . (it)
              }
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
  
      override fun insertValue(columnName: String, queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insertValue().
//                             display_name insertValue
//                             documentation ```kotlin\npublic open override fun insertValue(columnName: String, queryBuilder: QueryBuilder): Unit\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insertValue().
//                             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insertValue().(columnName)
//                                        display_name columnName
//                                        documentation ```kotlin\ncolumnName: String\n```
//                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insertValue().(queryBuilder)
//                                                              display_name queryBuilder
//                                                              documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
          queryBuilder { +"EXCLUDED.$columnName" }
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insertValue().(queryBuilder)
//                       ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insertValue().(columnName)
      }
  
      override fun delete(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().
//                        display_name delete
//                        documentation ```kotlin\npublic open override fun delete(ignore: Boolean, targets: Join, targetTables: List<Table>, where: Op<Boolean>?, limit: Int?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).
          ignore: Boolean,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(ignore)
//               display_name ignore
//               documentation ```kotlin\nignore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          targets: Join,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(targets)
//                display_name targets
//                documentation ```kotlin\ntargets: Join\n```
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
          targetTables: List<Table>,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(targetTables)
//                     display_name targetTables
//                     documentation ```kotlin\ntargetTables: List<Table>\n```
//                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (ignore) {
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(ignore)
              transaction.throwUnsupportedException("PostgreSQL doesn't support IGNORE in DELETE from join relation")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          if (limit != null) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(limit)
              transaction.throwUnsupportedException("PostgreSQL doesn't support LIMIT in DELETE from join relation")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          val tableToDelete = targetTables.singleOrNull()
//            ^^^^^^^^^^^^^ definition local 12
//                          display_name tableToDelete
//                          documentation ```kotlin\nlocal val tableToDelete: Table\n```
//                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(targetTables)
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull(+19).
              ?: transaction.throwUnsupportedException(
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(transaction)
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
                  "PostgreSQL doesn't support DELETE from join relation with multiple tables to delete from"
              )
          targets.checkJoinTypes(StatementType.DELETE)
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(targets)
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().
//                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#DELETE.
  
          return with(QueryBuilder(true)) {
//               ^^^^ reference semanticdb maven . . kotlin/with().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
              +"DELETE FROM "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              tableToDelete.describe(transaction, this)
//            ^^^^^^^^^^^^^ reference local 12
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(transaction)
              +" USING "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              appendJoinPart(tableToDelete, targets, transaction)
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().
//                           ^^^^^^^^^^^^^ reference local 12
//                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(targets)
//                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(transaction)
              where?.let {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(where)
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^ definition semanticdb maven . . (it) 3:13
//                         display_name it
//                         documentation ```kotlin\nit: Expression<out Any?>\n```
                  +" AND "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                  +it
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                 ^^ reference semanticdb maven . . (it)
              }
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
  
      override fun explain(
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().
//                         display_name explain
//                         documentation ```kotlin\npublic open override fun explain(analyze: Boolean, options: String?, internalStatement: String, transaction: Transaction): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
          analyze: Boolean,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(analyze)
//                display_name analyze
//                documentation ```kotlin\nanalyze: Boolean\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          options: String?,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(options)
//                display_name options
//                documentation ```kotlin\noptions: String?\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/String#
          internalStatement: String,
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(internalStatement)
//                          display_name internalStatement
//                          documentation ```kotlin\ninternalStatement: String\n```
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          return if (analyze && options != null) {
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(analyze)
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(options)
              super.explain(false, "ANALYZE TRUE, $options", internalStatement, transaction)
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
//                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(options)
//                                                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(internalStatement)
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(transaction)
          } else {
              super.explain(analyze, options, internalStatement, transaction)
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
//                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(analyze)
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(options)
//                                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(internalStatement)
//                                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(transaction)
          }
      }
  
      override fun StringBuilder.appendOptionsToExplain(options: String) {
//                               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#appendOptionsToExplain().
//                                                      display_name appendOptionsToExplain
//                                                      documentation ```kotlin\nprotected open override fun {kotlin/text/StringBuilder=} StringBuilder.appendOptionsToExplain(options: String): Unit\n```
//                                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendOptionsToExplain().
//                                                      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#appendOptionsToExplain().(options)
//                                                              display_name options
//                                                              documentation ```kotlin\noptions: String\n```
//                                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
          append("($options) ")
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#appendOptionsToExplain().(options)
      }
  
      override fun returning(
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().
//                           display_name returning
//                           documentation ```kotlin\npublic open override fun returning(mainSql: String, returning: List<Expression<*>>, transaction: Transaction): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().
          mainSql: String,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(mainSql)
//                display_name mainSql
//                documentation ```kotlin\nmainSql: String\n```
//                 ^^^^^^ reference semanticdb maven . . kotlin/String#
          returning: List<Expression<*>>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(returning)
//                  display_name returning
//                  documentation ```kotlin\nreturning: List<Expression<*>>\n```
//                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          return with(QueryBuilder(true)) {
//               ^^^^ reference semanticdb maven . . kotlin/with().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
              +"$mainSql RETURNING "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(mainSql)
              returning.appendTo { +it }
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(returning)
//                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                               ^^^^^^^ definition semanticdb maven . . (it)
//                                       display_name it
//                                       documentation ```kotlin\nit: Expression<out Any?>\n```
//                                 ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                  ^^ reference semanticdb maven . . (it)
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
  }
  
  /**
   * PostgreSQL dialect implementation.
   */
  open class PostgreSQLDialect(override val name: String = dialectName) : VendorDialect(dialectName, PostgreSQLDataTypeProvider, PostgreSQLFunctionProvider) {
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                             display_name PostgreSQLDialect
//                             documentation ```kotlin\npublic open class PostgreSQLDialect : VendorDialect\n```\n\n----\n\n\n PostgreSQL dialect implementation.\n
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#`<init>`().
//                             display_name PostgreSQLDialect
//                             documentation ```kotlin\npublic constructor(name: String = ...): PostgreSQLDialect\n```
//                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#`<init>`().(name)
//                                               display_name name
//                                               documentation ```kotlin\nname: String = ...\n```
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#`<init>`().(name)
//                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getName().
//                                               display_name name
//                                               documentation ```kotlin\npublic get(): String\n```
//                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#name.
//                                               display_name name
//                                               documentation ```kotlin\npublic open override val name: String\n```
//                                                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
//                                                                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
//                                                                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                                                                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
      override val supportsSubqueryUnions: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsSubqueryUnions().
//                                        display_name supportsSubqueryUnions
//                                        documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsSubqueryUnions.
//                                        display_name supportsSubqueryUnions
//                                        documentation ```kotlin\npublic open override val supportsSubqueryUnions: Boolean\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      override val supportsOrderByNullsFirstLast: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsOrderByNullsFirstLast().
//                                               display_name supportsOrderByNullsFirstLast
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsOrderByNullsFirstLast.
//                                               display_name supportsOrderByNullsFirstLast
//                                               documentation ```kotlin\npublic open override val supportsOrderByNullsFirstLast: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      override val requiresAutoCommitOnCreateDrop: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getRequiresAutoCommitOnCreateDrop().
//                                                display_name requiresAutoCommitOnCreateDrop
//                                                documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#requiresAutoCommitOnCreateDrop.
//                                                display_name requiresAutoCommitOnCreateDrop
//                                                documentation ```kotlin\npublic open override val requiresAutoCommitOnCreateDrop: Boolean\n```
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      override val supportsWindowFrameGroupsMode: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsWindowFrameGroupsMode().
//                                               display_name supportsWindowFrameGroupsMode
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsWindowFrameGroupsMode.
//                                               display_name supportsWindowFrameGroupsMode
//                                               documentation ```kotlin\npublic open override val supportsWindowFrameGroupsMode: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      override val supportsSelectForUpdate: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsSelectForUpdate().
//                                         display_name supportsSelectForUpdate
//                                         documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsSelectForUpdate.
//                                         display_name supportsSelectForUpdate
//                                         documentation ```kotlin\npublic open override val supportsSelectForUpdate: Boolean\n```
//                                          ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      override fun isAllowedAsColumnDefault(e: Expression<*>): Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#isAllowedAsColumnDefault().
//                                          display_name isAllowedAsColumnDefault
//                                          documentation ```kotlin\npublic open override fun isAllowedAsColumnDefault(e: Expression<*>): Boolean\n```
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#isAllowedAsColumnDefault().
//                                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#isAllowedAsColumnDefault().(e)
//                                            display_name e
//                                            documentation ```kotlin\ne: Expression<*>\n```
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      override fun modifyColumn(column: Column<*>, columnDiff: ColumnDiff): List<String> {
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().
//                              display_name modifyColumn
//                              documentation ```kotlin\npublic open override fun modifyColumn(column: Column<*>, columnDiff: ColumnDiff): List<String>\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().
//                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                     display_name column
//                                     documentation ```kotlin\ncolumn: Column<*>\n```
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(columnDiff)
//                                                            display_name columnDiff
//                                                            documentation ```kotlin\ncolumnDiff: ColumnDiff\n```
//                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          @OptIn(InternalApi::class)
          val list = mutableListOf(
//            ^^^^ definition local 13
//                 display_name list
//                 documentation ```kotlin\n@OptIn(...) local val list: MutableList<String>\n```
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf(+1).
              buildString {
//            ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
                  val tr = CoreTransactionManager.currentTransaction()
//                    ^^ definition local 14
//                       display_name tr
//                       documentation ```kotlin\nlocal val tr: Transaction\n```
//                                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
                  append("ALTER TABLE ${tr.identity(column.table)} ")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                      ^^ reference local 14
//                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
                  val colName = tr.identity(column)
//                    ^^^^^^^ definition local 15
//                            display_name colName
//                            documentation ```kotlin\nlocal val colName: String\n```
//                              ^^ reference local 14
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
  
                  if (columnDiff.autoInc && column.autoIncColumnType != null) {
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(columnDiff)
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#autoInc.
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getAutoInc().
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
                      val sequence = column.autoIncColumnType?.sequence
//                        ^^^^^^^^ definition local 16
//                                 display_name sequence
//                                 documentation ```kotlin\nlocal val sequence: Sequence?\n```
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.
                      if (sequence != null) {
//                        ^^^^^^^^ reference local 16
                          append("ALTER COLUMN $colName TYPE ${column.columnType.sqlType()}")
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                              ^^^^^^^ reference local 15
//                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
                          append(", ALTER COLUMN $colName DROP DEFAULT")
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                                ^^^^^^^ reference local 15
                      } else {
                          val fallbackSequenceName = fallbackSequenceName(tableName = column.table.tableName, columnName = column.name)
//                            ^^^^^^^^^^^^^^^^^^^^ definition local 17
//                                                 display_name fallbackSequenceName
//                                                 documentation ```kotlin\nlocal val fallbackSequenceName: String\n```
//                                                   ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().
//                                                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
                          append("ALTER COLUMN $colName SET DEFAULT nextval('$fallbackSequenceName')")
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                              ^^^^^^^ reference local 15
//                                                                            ^^^^^^^^^^^^^^^^^^^^ reference local 17
                      }
                  } else if (columnDiff.autoInc && column.autoIncColumnType == null) {
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(columnDiff)
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#autoInc.
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getAutoInc().
//                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
                      // based on logic in SchemaUtils.isIncorrectAutoInc this should only be possible if the existing
                      // column in database is auto-incrementing while defined table is not
                      append("ALTER COLUMN $colName TYPE ${column.columnType.sqlType()}")
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                          ^^^^^^^ reference local 15
//                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
                      append(", ALTER COLUMN $colName DROP DEFAULT")
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                            ^^^^^^^ reference local 15
                  } else {
                      append("ALTER COLUMN $colName TYPE ${column.columnType.sqlType()}")
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                          ^^^^^^^ reference local 15
//                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
                  }
  
                  if (columnDiff.nullability) {
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(columnDiff)
//                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getNullability().
//                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#nullability.
                      append(", ALTER COLUMN $colName ")
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                            ^^^^^^^ reference local 15
                      if (column.columnType.nullable) {
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
                          append("DROP ")
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
                      } else {
                          append("SET ")
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
                      }
                      append("NOT NULL")
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
                  }
                  if (columnDiff.defaults) {
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(columnDiff)
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#defaults.
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getDefaults().
                      column.dbDefaultValue?.let {
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                           ^^^ reference semanticdb maven . . kotlin/let().
//                                               ^ definition semanticdb maven . . (it) 2:21
//                                                 display_name it
//                                                 documentation ```kotlin\nit: Expression<out Any?>\n```
                          append(", ALTER COLUMN $colName SET DEFAULT ${PostgreSQLDataTypeProvider.processForDefaultValue(it)}")
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                                ^^^^^^^ reference local 15
//                                                                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().
//                                                                                                                        ^^ reference semanticdb maven . . (it)
                      } ?: run {
//                         ^^^ reference semanticdb maven . . kotlin/run(+1).
                          append(", ALTER COLUMN $colName DROP DEFAULT")
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                                ^^^^^^^ reference local 15
                      }
                  }
              }
          )
          if (columnDiff.autoInc && column.autoIncColumnType != null && column.autoIncColumnType?.sequence == null) {
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(columnDiff)
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#autoInc.
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getAutoInc().
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                                                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//                                                                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.
              list.add(
//            ^^^^ reference local 13
//                 ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
                  buildString {
//                ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
                      val fallbackSequenceName = fallbackSequenceName(tableName = column.table.tableName, columnName = column.name)
//                        ^^^^^^^^^^^^^^^^^^^^ definition local 18
//                                             display_name fallbackSequenceName
//                                             documentation ```kotlin\nlocal val fallbackSequenceName: String\n```
//                                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().
//                                                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                                                                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
                      val q = if (column.table.tableName.contains('.')) "\"" else ""
//                        ^ definition local 19
//                          display_name q
//                          documentation ```kotlin\nlocal val q: String\n```
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                       ^^^^^^^^ reference semanticdb maven . . kotlin/text/contains(+1).
                      append("ALTER SEQUENCE $fallbackSequenceName OWNED BY $q${column.table.tableName.replace("\"", "")}.${column.name}$q")
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                            ^^^^^^^^^^^^^^^^^^^^ reference local 18
//                                                                           ^ reference local 19
//                                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                                                     ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
//                                                                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                                                                                       ^ reference local 19
                  }
              )
          }
          return list
//               ^^^^ reference local 13
      }
  
      @OptIn(InternalApi::class)
      override fun createDatabase(name: String): String = "CREATE DATABASE ${name.inProperCase()}"
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createDatabase().
//                                display_name createDatabase
//                                documentation ```kotlin\n@OptIn(...) public open override fun createDatabase(name: String): String\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createDatabase().
//                                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createDatabase().(name)
//                                     display_name name
//                                     documentation ```kotlin\nname: String\n```
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createDatabase().(name)
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
  
      override fun listDatabases(): String = "SELECT datname FROM pg_database"
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#listDatabases().
//                               display_name listDatabases
//                               documentation ```kotlin\npublic open override fun listDatabases(): String\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#listDatabases().
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      @OptIn(InternalApi::class)
      override fun dropDatabase(name: String): String = "DROP DATABASE ${name.inProperCase()}"
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropDatabase().
//                              display_name dropDatabase
//                              documentation ```kotlin\n@OptIn(...) public open override fun dropDatabase(name: String): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropDatabase().
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropDatabase().(name)
//                                   display_name name
//                                   documentation ```kotlin\nname: String\n```
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropDatabase().(name)
//                                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
  
      override fun setSchema(schema: Schema): String = "SET search_path TO ${schema.identifier}"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#setSchema().
//                           display_name setSchema
//                           documentation ```kotlin\npublic open override fun setSchema(schema: Schema): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#setSchema().
//                           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#setSchema().(schema)
//                                  display_name schema
//                                  documentation ```kotlin\nschema: Schema\n```
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
//                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#setSchema().(schema)
//                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getIdentifier().
//                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#identifier.
  
      override fun createIndexWithType(name: String, table: String, columns: String, type: String, filterCondition: String): String {
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().
//                                     display_name createIndexWithType
//                                     documentation ```kotlin\nprotected open override fun createIndexWithType(name: String, table: String, columns: String, type: String, filterCondition: String): String\n```
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().
//                                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(name)
//                                          display_name name
//                                          documentation ```kotlin\nname: String\n```
//                                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                   ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(table)
//                                                         display_name table
//                                                         documentation ```kotlin\ntable: String\n```
//                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(columns)
//                                                                          display_name columns
//                                                                          documentation ```kotlin\ncolumns: String\n```
//                                                                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(type)
//                                                                                        display_name type
//                                                                                        documentation ```kotlin\ntype: String\n```
//                                                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(filterCondition)
//                                                                                                                 display_name filterCondition
//                                                                                                                 documentation ```kotlin\nfilterCondition: String\n```
//                                                                                                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                                                           ^^^^^^ reference semanticdb maven . . kotlin/String#
          return "CREATE INDEX $name ON $table USING $type $columns$filterCondition"
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(name)
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(table)
//                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(type)
//                                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(columns)
//                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(filterCondition)
      }
  
      override fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String {
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().
//                           display_name dropIndex
//                           documentation ```kotlin\npublic open override fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().
//                           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(tableName)
//                                     display_name tableName
//                                     documentation ```kotlin\ntableName: String\n```
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(indexName)
//                                                        display_name indexName
//                                                        documentation ```kotlin\nindexName: String\n```
//                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(isUnique)
//                                                                          display_name isUnique
//                                                                          documentation ```kotlin\nisUnique: Boolean\n```
//                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                    ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(isPartialOrFunctional)
//                                                                                                          display_name isPartialOrFunctional
//                                                                                                          documentation ```kotlin\nisPartialOrFunctional: Boolean\n```
//                                                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
          return if (isUnique && !isPartialOrFunctional) {
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(isUnique)
//                               ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(isPartialOrFunctional)
              "ALTER TABLE IF EXISTS ${identifierManager.quoteIfNecessary(tableName)} DROP CONSTRAINT IF EXISTS ${identifierManager.quoteIfNecessary(indexName)}"
//                                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(tableName)
//                                                                                                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                                                                                                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                                                                                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                                                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(indexName)
          } else {
              "DROP INDEX IF EXISTS ${identifierManager.cutIfNecessaryAndQuote(indexName)}"
//                                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(indexName)
          }
      }
  
      companion object : DialectNameProvider("PostgreSQL")
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#Companion#
//                                                         display_name Companion
//                                                         documentation ```kotlin\npublic final companion object Companion : VendorDialect.DialectNameProvider\n```
//                                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#Companion#`<init>`().
//                                                         display_name Companion
//                                                         documentation ```kotlin\nprivate constructor(): PostgreSQLDialect.Companion\n```
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
  }
  
  /**
   * PostgreSQL dialect implementation using the pgjdbc-ng jdbc driver.
   *
   * The driver accepts basic URLs in the following format : jdbc:pgsql://localhost:5432/db
   */
  open class PostgreSQLNGDialect : PostgreSQLDialect(dialectName) {
//           ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#
//                               display_name PostgreSQLNGDialect
//                               documentation ```kotlin\npublic open class PostgreSQLNGDialect : PostgreSQLDialect\n```\n\n----\n\n\n PostgreSQL dialect implementation using the pgjdbc-ng jdbc driver.\n\n The driver accepts basic URLs in the following format : jdbc:pgsql://localhost:5432/db\n
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//           ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#`<init>`().
//                               display_name PostgreSQLNGDialect
//                               documentation ```kotlin\npublic constructor(): PostgreSQLNGDialect\n```\n\n----\n\n\n PostgreSQL dialect implementation using the pgjdbc-ng jdbc driver.\n\n The driver accepts basic URLs in the following format : jdbc:pgsql://localhost:5432/db\n
//                                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
      override val requiresAutoCommitOnCreateDrop: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#getRequiresAutoCommitOnCreateDrop().
//                                                display_name requiresAutoCommitOnCreateDrop
//                                                documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#requiresAutoCommitOnCreateDrop.
//                                                display_name requiresAutoCommitOnCreateDrop
//                                                documentation ```kotlin\npublic open override val requiresAutoCommitOnCreateDrop: Boolean\n```
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      companion object : DialectNameProvider("PostgreSQLNG")
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#Companion#
//                                                           display_name Companion
//                                                           documentation ```kotlin\npublic final companion object Companion : VendorDialect.DialectNameProvider\n```
//                                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#Companion#`<init>`().
//                                                           display_name Companion
//                                                           documentation ```kotlin\nprivate constructor(): PostgreSQLNGDialect.Companion\n```
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
  }
