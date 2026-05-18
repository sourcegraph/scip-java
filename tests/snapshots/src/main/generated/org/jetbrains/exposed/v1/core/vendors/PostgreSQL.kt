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
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#`<init>`().
  internal object PostgreSQLDataTypeProvider : DataTypeProvider() {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#
//                                           display_name PostgreSQLDataTypeProvider
//                                           documentation ```kotlin\ninternal final object PostgreSQLDataTypeProvider : DataTypeProvider\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#`<init>`().
//                                           display_name PostgreSQLDataTypeProvider
//                                           documentation ```kotlin\nprivate constructor(): PostgreSQLDataTypeProvider\n```
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#byteType().
      override fun byteType(): String = "SMALLINT"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#byteType().
//                          display_name byteType
//                          documentation ```kotlin\npublic open override fun byteType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#byteType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#byteType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#floatType().
      override fun floatType(): String = "REAL"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#floatType().
//                           display_name floatType
//                           documentation ```kotlin\npublic open override fun floatType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#floatType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#floatType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#ulongType().
      override fun ulongType(): String = "BIGINT"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#ulongType().
//                           display_name ulongType
//                           documentation ```kotlin\npublic open override fun ulongType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#ulongType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#integerAutoincType().
      override fun integerAutoincType(): String = "SERIAL"
//                 ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#integerAutoincType().
//                                    display_name integerAutoincType
//                                    documentation ```kotlin\npublic open override fun integerAutoincType(): String\n```
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerAutoincType().
//                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#integerAutoincType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#longAutoincType().
      override fun longAutoincType(): String = "BIGSERIAL"
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#longAutoincType().
//                                 display_name longAutoincType
//                                 documentation ```kotlin\npublic open override fun longAutoincType(): String\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#longAutoincType().
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#longAutoincType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#ulongAutoincType().
      override fun ulongAutoincType(): String = "BIGSERIAL"
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#ulongAutoincType().
//                                  display_name ulongAutoincType
//                                  documentation ```kotlin\npublic open override fun ulongAutoincType(): String\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongAutoincType().
//                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#ulongAutoincType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#uuidType().
      override fun uuidType(): String = "uuid"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#uuidType().
//                          display_name uuidType
//                          documentation ```kotlin\npublic open override fun uuidType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#uuidType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#binaryType().
      override fun binaryType(): String = "bytea"
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#binaryType().
//                            display_name binaryType
//                            documentation ```kotlin\npublic open override fun binaryType(): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType().
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#binaryType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#binaryType(+1).
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#binaryType(+1).(length)
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
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#binaryType(+1).(length)
          exposedLogger.warn("The length of the binary column is not required.")
//        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                      ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
          return binaryType()
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#binaryType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#binaryType(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#blobType().
      override fun blobType(): String = "bytea"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#blobType().
//                          display_name blobType
//                          documentation ```kotlin\npublic open override fun blobType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#blobType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#blobType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#uuidToDB().
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#uuidToDB().(value)
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
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#uuidToDB().(value)
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#uuidToDB().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#dateTimeType().
      override fun dateTimeType(): String = "TIMESTAMP"
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#dateTimeType().
//                              display_name dateTimeType
//                              documentation ```kotlin\npublic open override fun dateTimeType(): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#dateTimeType().
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#dateTimeType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#jsonBType().
      override fun jsonBType(): String = "JSONB"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#jsonBType().
//                           display_name jsonBType
//                           documentation ```kotlin\npublic open override fun jsonBType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#jsonBType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#jsonBType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().
//                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
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
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
          e is LiteralOp<*> && e.columnType is JsonColumnMarker && (currentDialect as? H2Dialect) == null -> {
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#
//                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
//            ⌄ enclosing_range_start local 0
              val cast = if (e.columnType.usesBinaryFormat) "::jsonb" else "::json"
//                ^^^^ definition local 0
//                     display_name cast
//                     documentation ```kotlin\nlocal val cast: String\n```
//                           ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#getUsesBinaryFormat().
//                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#usesBinaryFormat.
//                                                                                ⌃ enclosing_range_end local 0
              "${super.processForDefaultValue(e)}$cast"
//                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                                                ^^^^ reference local 0
          }
          e is LiteralOp<*> && e.columnType is BlobColumnType && e.columnType.useObjectIdentifier && (currentDialect as? H2Dialect) == null -> {
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#
//                                                               ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#getUseObjectIdentifier().
//                                                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#useObjectIdentifier.
//                                                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
              "lo_from_bytea(0, ${super.processForDefaultValue(e)} :: bytea)"
//                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
          }
          e is LiteralOp<*> && e.columnType is ArrayColumnType<*, *> -> {
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                             ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#
//            ⌄ enclosing_range_start local 1
              val processed = super.processForDefaultValue(e)
//                ^^^^^^^^^ definition local 1
//                          display_name processed
//                          documentation ```kotlin\nlocal val processed: String\n```
//                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                         ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                                                          ⌃ enclosing_range_end local 1
              processed
//            ^^^^^^^^^ reference local 1
//                            ⌄ enclosing_range_start local 2
                  .takeUnless { it == "ARRAY[]" }
//                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/takeUnless().
//                            ^^^^^^^^^^^^^^^^^^^ definition local 2
//                                                display_name it
//                                                documentation ```kotlin\nit: String\n```
//                              ^^ reference local 2
//                                              ⌃ enclosing_range_end local 2
                  ?: run {
//                   ^^^ reference semanticdb maven . . kotlin/run(+1).
//                    ⌄ enclosing_range_start local 3
                      val cast = e.columnType.delegateType.lowercase()
//                        ^^^^ definition local 3
//                             display_name cast
//                             documentation ```kotlin\nlocal val cast: String\n```
//                               ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegateType.
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegateType().
//                                                         ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
//                                                                   ⌃ enclosing_range_end local 3
                      "$processed::$cast[]"
//                      ^^^^^^^^^ reference local 1
//                                  ^^^^ reference local 3
                  }
          }
          else -> super.processForDefaultValue(e)
//                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().(e)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#hexToDb().
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#hexToDb().(hexString)
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
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#hexToDb().(hexString)
//                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#hexToDb().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#`<init>`().
  internal object PostgreSQLFunctionProvider : FunctionProvider() {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#
//                                           display_name PostgreSQLFunctionProvider
//                                           documentation ```kotlin\ninternal final object PostgreSQLFunctionProvider : FunctionProvider\n```\n\n----\n\n\n Implementation of [FunctionProvider.locate]\n Note: search is case-sensitive\n
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#`<init>`().
//                                           display_name PostgreSQLFunctionProvider
//                                           documentation ```kotlin\nprivate constructor(): PostgreSQLFunctionProvider\n```\n\n----\n\n\n Implementation of [FunctionProvider.locate]\n Note: search is case-sensitive\n
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#nextVal().
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#nextVal().(seq)
//                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#nextVal().(builder)
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
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#nextVal().(seq)
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#nextVal().(builder)
          append("NEXTVAL('", seq.identifier, "')")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#nextVal().(seq)
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getIdentifier().
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#identifier.
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#nextVal().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().[T]
//                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().(expr)
//                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().(queryBuilder)
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
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().[T]
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().(expr)
//                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().(queryBuilder)
//        ⌄ enclosing_range_start local 4
          @OptIn(InternalApi::class)
          val tr = CoreTransactionManager.currentTransaction()
//            ^^ definition local 4
//               display_name tr
//               documentation ```kotlin\n@OptIn(...) local val tr: Transaction\n```
//                                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                           ⌃ enclosing_range_end local 4
//                     ⌄ enclosing_range_start local 5
          return when (expr.separator) {
//                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().(expr)
//                     ^^^^^^^^^^^^^^ definition local 5
//                                    display_name <when-subject>
//                                    documentation ```kotlin\nlocal val <when-subject>: String?\n```
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getSeparator().
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#separator.
//                                  ⌃ enclosing_range_end local 5
              null -> tr.throwUnsupportedException("PostgreSQL requires explicit separator in STRING_AGG function.")
//                    ^^ reference local 4
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
//                                                                 ⌄ enclosing_range_start local 6
                      expr.orderBy.appendTo(prefix = " ORDER BY ") {
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().(expr)
//                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
//                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                                                                 ^ definition local 6 2:21
//                                                                   display_name it
//                                                                   documentation ```kotlin\nit: CapturedType(out Pair<Expression<*>, SortOrder>)\n```
                          append(it.first, " ", it.second.name)
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                               ^^ reference local 6
//                                  ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                  ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                              ^^ reference local 6
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#getName().
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#name.
                      }
//                    ⌃ enclosing_range_end local 6
                  }
                  append(")")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
              }
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().
      /**
       * Implementation of [FunctionProvider.locate]
       * Note: search is case-sensitive
       * */
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().[T]
      override fun <T : String?> locate(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().
//                                      display_name locate
//                                      documentation ```kotlin\npublic open override fun <T : String?> locate(queryBuilder: QueryBuilder, expr: Expression<T>, substring: String): Unit\n```\n\n----\n\n\n Implementation of [FunctionProvider.locate]\n Note: search is case-sensitive\n
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(queryBuilder)
          queryBuilder: QueryBuilder,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(queryBuilder)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(expr)
          expr: Expression<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(expr)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(substring)
          substring: String
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(substring)
//                  display_name substring
//                  documentation ```kotlin\nsubstring: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(substring)
      ) = queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(queryBuilder)
          append("POSITION(\'", substring, "\' IN ", expr, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(substring)
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().(expr)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().[T]
      override fun <T : String?> regexp(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().
//                                      display_name regexp
//                                      documentation ```kotlin\npublic open override fun <T : String?> regexp(expr1: Expression<T>, pattern: Expression<String>, caseSensitive: Boolean, queryBuilder: QueryBuilder): Unit\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(expr1)
          expr1: Expression<T>,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(expr1)
//              display_name expr1
//              documentation ```kotlin\nexpr1: Expression<T>\n```
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(expr1)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(pattern)
          pattern: Expression<String>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(pattern)
//                display_name pattern
//                documentation ```kotlin\npattern: Expression<String>\n```
//                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(pattern)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(caseSensitive)
          caseSensitive: Boolean,
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(caseSensitive)
//                      display_name caseSensitive
//                      documentation ```kotlin\ncaseSensitive: Boolean\n```
//                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(caseSensitive)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().(queryBuilder)
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().(expr)
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().(queryBuilder)
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().[T]
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().(expr)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().(queryBuilder)
          append("CAST(", expr, " AS DATE)")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().(expr)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().(expr)
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().(queryBuilder)
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().[T]
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().(expr)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().(queryBuilder)
          append("TO_CHAR(", expr, ", 'HH24:MI:SS.US')")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().(expr)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().(expr)
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().(queryBuilder)
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().[T]
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().(expr)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().(queryBuilder)
          append("Extract(YEAR FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().(expr)
//                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().(queryBuilder)
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().[T]
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().(expr)
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().(queryBuilder)
          append("Extract(MONTH FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().[T]
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().(expr)
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().(queryBuilder)
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().[T]
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().(expr)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().(queryBuilder)
          append("Extract(DAY FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().(expr)
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().(queryBuilder)
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().[T]
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().(expr)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().(queryBuilder)
          append("Extract(HOUR FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().(expr)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().(queryBuilder)
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().[T]
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().(expr)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().(queryBuilder)
          append("Extract(MINUTE FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().(expr)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().(queryBuilder)
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().[T]
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().(expr)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().(queryBuilder)
          append("Extract(SECOND FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().[T]
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(expression)
//                                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(lower)
//                                                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(upper)
//                                                                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(queryBuilder)
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().[T]
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(expression)
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(lower)
//                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(upper)
//                                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(queryBuilder)
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(queryBuilder)
              append(expression, "[")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(expression)
//                       ⌄ enclosing_range_start local 7
              lower?.let { +it.toString() }
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(lower)
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^^^^^^^^^^^^^^^^^^ definition local 7
//                                          display_name it
//                                          documentation ```kotlin\nit: Int\n```
//                         ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                          ^^ reference local 7
//                             ^^^^^^^^ reference semanticdb maven . . kotlin/Int#toString().
//                                        ⌃ enclosing_range_end local 7
              +":"
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                       ⌄ enclosing_range_start local 8
              upper?.let { +it.toString() }
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().(upper)
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^^^^^^^^^^^^^^^^^^ definition local 8
//                                          display_name it
//                                          documentation ```kotlin\nit: Int\n```
//                         ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                          ^^ reference local 8
//                             ^^^^^^^^ reference semanticdb maven . . kotlin/Int#toString().
//                                        ⌃ enclosing_range_end local 8
              +"]"
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().[T]
      override fun <T> jsonExtract(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().
//                                 display_name jsonExtract
//                                 documentation ```kotlin\npublic open override fun <T> jsonExtract(expression: Expression<T>, vararg path: String, toScalar: Boolean, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(expression)
          expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(path)
          vararg path: String,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(path)
//                    display_name path
//                    documentation ```kotlin\nvararg path: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/Array#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(path)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(toScalar)
          toScalar: Boolean,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(toScalar)
//                 display_name toScalar
//                 documentation ```kotlin\ntoScalar: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(toScalar)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(jsonType)
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(jsonType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(queryBuilder)
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
//                                               ⌄ enclosing_range_start local 9
          path.ifEmpty { arrayOf("$") }.appendTo { +"'$it'" }
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().(path)
//             ^^^^^^^ reference semanticdb maven . . kotlin/collections/ifEmpty().
//                       ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                                               ^^^^^^^^^^^^ definition local 9
//                                                            display_name it
//                                                            documentation ```kotlin\nit: CapturedType(out String)\n```
//                                                 ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                                     ^^ reference local 9
//                                                          ⌃ enclosing_range_end local 9
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().
      override fun jsonContains(
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().
//                              display_name jsonContains
//                              documentation ```kotlin\npublic open override fun jsonContains(target: Expression<*>, candidate: Expression<*>, path: String?, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(target)
          target: Expression<*>,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(target)
//               display_name target
//               documentation ```kotlin\ntarget: Expression<*>\n```
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(target)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(candidate)
          candidate: Expression<*>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(candidate)
//                  display_name candidate
//                  documentation ```kotlin\ncandidate: Expression<*>\n```
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(candidate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(path)
          path: String?,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(path)
//             display_name path
//             documentation ```kotlin\npath: String?\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(path)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(jsonType)
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(jsonType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(queryBuilder)
      ) {
          @OptIn(InternalApi::class)
//                  ⌄ enclosing_range_start local 10
          path?.let {
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(path)
//              ^^^ reference semanticdb maven . . kotlin/let().
//                  ^ definition local 10 2:9
//                    display_name it
//                    documentation ```kotlin\nit: String\n```
              CoreTransactionManager.currentTransaction().throwUnsupportedException("PostgreSQL does not support a JSON path argument")
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
//        ⌃ enclosing_range_end local 10
//        ⌄ enclosing_range_start local 11
          val isNotJsonB = !(jsonType as JsonColumnMarker).usesBinaryFormat
//            ^^^^^^^^^^ definition local 11
//                       display_name isNotJsonB
//                       documentation ```kotlin\nlocal val isNotJsonB: Boolean\n```
//                         ^ reference semanticdb maven . . kotlin/Boolean#not().
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(jsonType)
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#
//                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#getUsesBinaryFormat().
//                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#usesBinaryFormat.
//                                                                        ⌃ enclosing_range_end local 11
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(queryBuilder)
              append(target)
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(target)
              if (isNotJsonB) append("::jsonb")
//                ^^^^^^^^^^ reference local 11
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
              append(" @> ", candidate)
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().(candidate)
              if (isNotJsonB) append("::jsonb")
//                ^^^^^^^^^^ reference local 11
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().
      override fun jsonExists(
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().
//                            display_name jsonExists
//                            documentation ```kotlin\npublic open override fun jsonExists(expression: Expression<*>, vararg path: String, optional: String?, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(expression)
          expression: Expression<*>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<*>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(path)
          vararg path: String,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(path)
//                    display_name path
//                    documentation ```kotlin\nvararg path: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/Array#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(path)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(optional)
          optional: String?,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(optional)
//                 display_name optional
//                 documentation ```kotlin\noptional: String?\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(optional)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(jsonType)
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(jsonType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(queryBuilder)
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
//        ⌄ enclosing_range_start local 12
          val isNotJsonB = !(jsonType as JsonColumnMarker).usesBinaryFormat
//            ^^^^^^^^^^ definition local 12
//                       display_name isNotJsonB
//                       documentation ```kotlin\nlocal val isNotJsonB: Boolean\n```
//                         ^ reference semanticdb maven . . kotlin/Boolean#not().
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(jsonType)
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#
//                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#getUsesBinaryFormat().
//                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#usesBinaryFormat.
//                                                                        ⌃ enclosing_range_end local 12
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(queryBuilder)
              append("JSONB_PATH_EXISTS(")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
              if (isNotJsonB) {
//                ^^^^^^^^^^ reference local 12
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
//                          ⌄ enclosing_range_start local 13
              optional?.let {
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().(optional)
//                      ^^^ reference semanticdb maven . . kotlin/let().
//                          ^ definition local 13 2:13
//                            display_name it
//                            documentation ```kotlin\nit: String\n```
                  append(", '$it'")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                            ^^ reference local 13
              }
//            ⌃ enclosing_range_end local 13
              append(")")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#ON_CONFLICT_IGNORE.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#getON_CONFLICT_IGNORE().
      private const val ON_CONFLICT_IGNORE = "ON CONFLICT DO NOTHING"
//                      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#ON_CONFLICT_IGNORE.
//                                         display_name ON_CONFLICT_IGNORE
//                                         documentation ```kotlin\nprivate final const val ON_CONFLICT_IGNORE: String\n```
//                      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#getON_CONFLICT_IGNORE().
//                                         display_name ON_CONFLICT_IGNORE
//                                         documentation ```kotlin\nprivate get(): String\n```
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#ON_CONFLICT_IGNORE.
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#getON_CONFLICT_IGNORE().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().
      override fun insert(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().
//                        display_name insert
//                        documentation ```kotlin\npublic open override fun insert(ignore: Boolean, table: Table, columns: List<Column<*>>, expr: String, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(ignore)
          ignore: Boolean,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(ignore)
//               display_name ignore
//               documentation ```kotlin\nignore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(ignore)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(table)
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(table)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(columns)
          columns: List<Column<*>>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(columns)
//                display_name columns
//                documentation ```kotlin\ncolumns: List<Column<*>>\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(columns)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(expr)
          expr: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(expr)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
//        ⌄ enclosing_range_start local 14
          val def = super.insert(false, table, columns, expr, transaction)
//            ^^^ definition local 14
//                display_name def
//                documentation ```kotlin\nlocal val def: String\n```
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(table)
//                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(columns)
//                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(expr)
//                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(transaction)
//                                                                       ⌃ enclosing_range_end local 14
          return if (ignore) "$def $ON_CONFLICT_IGNORE" else def
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().(ignore)
//                             ^^^ reference local 14
//                                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#ON_CONFLICT_IGNORE.
//                                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#getON_CONFLICT_IGNORE().
//                                                           ^^^ reference local 14
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().
      override fun update(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().
//                        display_name update
//                        documentation ```kotlin\npublic open override fun update(targets: Join, columnsAndValues: List<Pair<Column<*>, Any?>>, limit: Int?, where: Op<Boolean>?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(targets)
          targets: Join,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(targets)
//                display_name targets
//                documentation ```kotlin\ntargets: Join\n```
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(targets)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(columnsAndValues)
          columnsAndValues: List<Pair<Column<*>, Any?>>,
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(columnsAndValues)
//                         display_name columnsAndValues
//                         documentation ```kotlin\ncolumnsAndValues: List<Pair<Column<*>, Any?>>\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(columnsAndValues)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(limit)
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(limit)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(where)
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(transaction)
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
//        ⌄ enclosing_range_start local 15
//                                                 ⌄ enclosing_range_start local 16
          val tableToUpdate = columnsAndValues.map { it.first.table }.distinct().singleOrNull()
//            ^^^^^^^^^^^^^ definition local 15
//                          display_name tableToUpdate
//                          documentation ```kotlin\nlocal val tableToUpdate: Table\n```
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(columnsAndValues)
//                                             ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                 ^^^^^^^^^^^^^^^^^^ definition local 16
//                                                                    display_name it
//                                                                    documentation ```kotlin\nit: Pair<Column<*>, Any?>\n```
//                                                   ^^ reference local 16
//                                                      ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                      ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                    ^^^^^^^^ reference semanticdb maven . . kotlin/collections/distinct(+9).
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull(+19).
//                                                                  ⌃ enclosing_range_end local 16
              ?: transaction.throwUnsupportedException("PostgreSQL supports a join updates with a single table columns to update.")
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(transaction)
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                                                                                                ⌃ enclosing_range_end local 15
          targets.checkJoinTypes(StatementType.UPDATE)
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(targets)
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().
//                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#UPDATE.
          +"UPDATE "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          tableToUpdate.describe(transaction, this)
//        ^^^^^^^^^^^^^ reference local 15
//                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().
//                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(transaction)
          +" SET "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                          ⌄ enclosing_range_start local 17
//                                           ⌄ enclosing_range_start local 18
//                                                ⌄ enclosing_range_start local 19
          columnsAndValues.appendTo(this) { (col, value) ->
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(columnsAndValues)
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                          ^^^^^^^^^^^^ definition local 17
//                                                       display_name <destruct>
//                                                       documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                           ^^^ reference local 17
//                                           ^^^ definition local 18
//                                               display_name col
//                                               documentation ```kotlin\nlocal val col: Column<*>\n```
//                                           ^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                ^^^^^ reference local 17
//                                                ^^^^^ definition local 19
//                                                      display_name value
//                                                      documentation ```kotlin\nlocal val value: Any?\n```
//                                                ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                             ⌃ enclosing_range_end local 18
//                                                    ⌃ enclosing_range_end local 19
//                                                     ⌃ enclosing_range_end local 17
              append("${transaction.identity(col)}=")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(transaction)
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                           ^^^ reference local 18
              registerArgument(col, value)
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                             ^^^ reference local 18
//                                  ^^^^^ reference local 19
          }
  
          appendJoinPartForUpdateClause(tableToUpdate, targets, transaction)
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().
//                                      ^^^^^^^^^^^^^ reference local 15
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(targets)
//                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(transaction)
  
//                   ⌄ enclosing_range_start local 20
          where?.let {
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().(where)
//               ^^^ reference semanticdb maven . . kotlin/let().
//                   ^ definition local 20 3:9
//                     display_name it
//                     documentation ```kotlin\nit: Op<Boolean>\n```
              +" AND "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              +it
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//             ^^ reference local 20
          }
//        ⌃ enclosing_range_end local 20
          toString()
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().
      override fun upsert(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().
//                        display_name upsert
//                        documentation ```kotlin\npublic open override fun upsert(table: Table, data: List<Pair<Column<*>, Any?>>, expression: String, onUpdate: List<Pair<Column<*>, Any?>>, keyColumns: List<Column<*>>, where: Op<Boolean>?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(table)
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(table)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(data)
          data: List<Pair<Column<*>, Any?>>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(data)
//             display_name data
//             documentation ```kotlin\ndata: List<Pair<Column<*>, Any?>>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(data)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(expression)
          expression: String,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: String\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(onUpdate)
          onUpdate: List<Pair<Column<*>, Any?>>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: List<Pair<Column<*>, Any?>>\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(onUpdate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(keyColumns)
          keyColumns: List<Column<*>>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(keyColumns)
//                   display_name keyColumns
//                   documentation ```kotlin\nkeyColumns: List<Column<*>>\n```
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(keyColumns)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(where)
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(transaction)
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
//                                                               ⌄ enclosing_range_start local 21
              keyColumns.appendTo(prefix = "(", postfix = ")") { column ->
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(keyColumns)
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                               ^^^^^^ definition local 21
//                                                                      display_name column
//                                                                      documentation ```kotlin\ncolumn: Column<*>\n```
//                                                                    ⌃ enclosing_range_end local 21
                  append(transaction.identity(column))
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(transaction)
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                            ^^^^^^ reference local 21
              }
  
              +" DO UPDATE SET "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                ⌄ enclosing_range_start local 22
//                                 ⌄ enclosing_range_start local 23
//                                                 ⌄ enclosing_range_start local 24
              onUpdate.appendTo { (columnToUpdate, updateExpression) ->
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(onUpdate)
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 22
//                                                                   display_name <destruct>
//                                                                   documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                 ^^^^^^^^^^^^^^ reference local 22
//                                 ^^^^^^^^^^^^^^ definition local 23
//                                                display_name columnToUpdate
//                                                documentation ```kotlin\nlocal val columnToUpdate: Column<*>\n```
//                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                 ^^^^^^^^^^^^^^^^ reference local 22
//                                                 ^^^^^^^^^^^^^^^^ definition local 24
//                                                                  display_name updateExpression
//                                                                  documentation ```kotlin\nlocal val updateExpression: Any?\n```
//                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                              ⌃ enclosing_range_end local 23
//                                                                ⌃ enclosing_range_end local 24
//                                                                 ⌃ enclosing_range_end local 22
                  append("${transaction.identity(columnToUpdate)}=")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(transaction)
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                               ^^^^^^^^^^^^^^ reference local 23
                  registerArgument(columnToUpdate, updateExpression)
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                                 ^^^^^^^^^^^^^^ reference local 23
//                                                 ^^^^^^^^^^^^^^^^ reference local 24
              }
  
//                       ⌄ enclosing_range_start local 25
              where?.let {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().(where)
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^ definition local 25 3:13
//                         display_name it
//                         documentation ```kotlin\nit: Op<Boolean>\n```
                  +" WHERE "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                  +it
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                 ^^ reference local 25
              }
//            ⌃ enclosing_range_end local 25
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insertValue().
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insertValue().(columnName)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insertValue().(queryBuilder)
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
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insertValue().(columnName)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insertValue().(queryBuilder)
          queryBuilder { +"EXCLUDED.$columnName" }
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insertValue().(queryBuilder)
//                       ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insertValue().(columnName)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insertValue().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().
      override fun delete(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().
//                        display_name delete
//                        documentation ```kotlin\npublic open override fun delete(ignore: Boolean, targets: Join, targetTables: List<Table>, where: Op<Boolean>?, limit: Int?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(ignore)
          ignore: Boolean,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(ignore)
//               display_name ignore
//               documentation ```kotlin\nignore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(ignore)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(targets)
          targets: Join,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(targets)
//                display_name targets
//                documentation ```kotlin\ntargets: Join\n```
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(targets)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(targetTables)
          targetTables: List<Table>,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(targetTables)
//                     display_name targetTables
//                     documentation ```kotlin\ntargetTables: List<Table>\n```
//                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(targetTables)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(where)
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(limit)
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(limit)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(transaction)
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
//        ⌄ enclosing_range_start local 26
          val tableToDelete = targetTables.singleOrNull()
//            ^^^^^^^^^^^^^ definition local 26
//                          display_name tableToDelete
//                          documentation ```kotlin\nlocal val tableToDelete: Table\n```
//                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(targetTables)
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull(+19).
              ?: transaction.throwUnsupportedException(
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(transaction)
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
                  "PostgreSQL doesn't support DELETE from join relation with multiple tables to delete from"
              )
//            ⌃ enclosing_range_end local 26
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
//            ^^^^^^^^^^^^^ reference local 26
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(transaction)
              +" USING "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              appendJoinPart(tableToDelete, targets, transaction)
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().
//                           ^^^^^^^^^^^^^ reference local 26
//                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(targets)
//                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(transaction)
//                       ⌄ enclosing_range_start local 27
              where?.let {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().(where)
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^ definition local 27 3:13
//                         display_name it
//                         documentation ```kotlin\nit: Op<Boolean>\n```
                  +" AND "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                  +it
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                 ^^ reference local 27
              }
//            ⌃ enclosing_range_end local 27
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().
      override fun explain(
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().
//                         display_name explain
//                         documentation ```kotlin\npublic open override fun explain(analyze: Boolean, options: String?, internalStatement: String, transaction: Transaction): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(analyze)
          analyze: Boolean,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(analyze)
//                display_name analyze
//                documentation ```kotlin\nanalyze: Boolean\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(analyze)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(options)
          options: String?,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(options)
//                display_name options
//                documentation ```kotlin\noptions: String?\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(options)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(internalStatement)
          internalStatement: String,
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(internalStatement)
//                          display_name internalStatement
//                          documentation ```kotlin\ninternalStatement: String\n```
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(internalStatement)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().(transaction)
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#appendOptionsToExplain().
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#appendOptionsToExplain().(options)
      override fun StringBuilder.appendOptionsToExplain(options: String) {
//                               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#appendOptionsToExplain().
//                                                      display_name appendOptionsToExplain
//                                                      documentation ```kotlin\nprotected open override fun {kotlin/text/StringBuilder=} StringBuilder.appendOptionsToExplain(options: String): Unit\n```
//                                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendOptionsToExplain().
//                                                      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#appendOptionsToExplain().(options)
//                                                              display_name options
//                                                              documentation ```kotlin\noptions: String\n```
//                                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#appendOptionsToExplain().(options)
          append("($options) ")
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#appendOptionsToExplain().(options)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#appendOptionsToExplain().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().
      override fun returning(
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().
//                           display_name returning
//                           documentation ```kotlin\npublic open override fun returning(mainSql: String, returning: List<Expression<*>>, transaction: Transaction): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(mainSql)
          mainSql: String,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(mainSql)
//                display_name mainSql
//                documentation ```kotlin\nmainSql: String\n```
//                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(mainSql)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(returning)
          returning: List<Expression<*>>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(returning)
//                  display_name returning
//                  documentation ```kotlin\nreturning: List<Expression<*>>\n```
//                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(returning)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          return with(QueryBuilder(true)) {
//               ^^^^ reference semanticdb maven . . kotlin/with().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
              +"$mainSql RETURNING "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(mainSql)
//                               ⌄ enclosing_range_start local 28
              returning.appendTo { +it }
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().(returning)
//                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                               ^^^^^^^ definition local 28
//                                       display_name it
//                                       documentation ```kotlin\nit: Expression<*>\n```
//                                 ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                  ^^ reference local 28
//                                     ⌃ enclosing_range_end local 28
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
  /**
   * PostgreSQL dialect implementation.
   */
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#`<init>`().
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#`<init>`().(name)
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#name.
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getName().
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
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#`<init>`().(name)
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#name.
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getName().
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsSubqueryUnions.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsSubqueryUnions().
      override val supportsSubqueryUnions: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsSubqueryUnions().
//                                        display_name supportsSubqueryUnions
//                                        documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsSubqueryUnions.
//                                        display_name supportsSubqueryUnions
//                                        documentation ```kotlin\npublic open override val supportsSubqueryUnions: Boolean\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsSubqueryUnions.
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsSubqueryUnions().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsOrderByNullsFirstLast.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsOrderByNullsFirstLast().
      override val supportsOrderByNullsFirstLast: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsOrderByNullsFirstLast().
//                                               display_name supportsOrderByNullsFirstLast
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsOrderByNullsFirstLast.
//                                               display_name supportsOrderByNullsFirstLast
//                                               documentation ```kotlin\npublic open override val supportsOrderByNullsFirstLast: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsOrderByNullsFirstLast.
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsOrderByNullsFirstLast().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#requiresAutoCommitOnCreateDrop.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getRequiresAutoCommitOnCreateDrop().
      override val requiresAutoCommitOnCreateDrop: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getRequiresAutoCommitOnCreateDrop().
//                                                display_name requiresAutoCommitOnCreateDrop
//                                                documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#requiresAutoCommitOnCreateDrop.
//                                                display_name requiresAutoCommitOnCreateDrop
//                                                documentation ```kotlin\npublic open override val requiresAutoCommitOnCreateDrop: Boolean\n```
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#requiresAutoCommitOnCreateDrop.
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getRequiresAutoCommitOnCreateDrop().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsWindowFrameGroupsMode.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsWindowFrameGroupsMode().
      override val supportsWindowFrameGroupsMode: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsWindowFrameGroupsMode().
//                                               display_name supportsWindowFrameGroupsMode
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsWindowFrameGroupsMode.
//                                               display_name supportsWindowFrameGroupsMode
//                                               documentation ```kotlin\npublic open override val supportsWindowFrameGroupsMode: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsWindowFrameGroupsMode.
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsWindowFrameGroupsMode().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsSelectForUpdate.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsSelectForUpdate().
      override val supportsSelectForUpdate: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsSelectForUpdate().
//                                         display_name supportsSelectForUpdate
//                                         documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsSelectForUpdate.
//                                         display_name supportsSelectForUpdate
//                                         documentation ```kotlin\npublic open override val supportsSelectForUpdate: Boolean\n```
//                                          ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#supportsSelectForUpdate.
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#getSupportsSelectForUpdate().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#isAllowedAsColumnDefault().
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#isAllowedAsColumnDefault().(e)
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
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#isAllowedAsColumnDefault().(e)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#isAllowedAsColumnDefault().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(columnDiff)
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
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(columnDiff)
//        ⌄ enclosing_range_start local 29
          @OptIn(InternalApi::class)
          val list = mutableListOf(
//            ^^^^ definition local 29
//                 display_name list
//                 documentation ```kotlin\n@OptIn(...) local val list: MutableList<String>\n```
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf(+1).
              buildString {
//            ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
//                ⌄ enclosing_range_start local 30
                  val tr = CoreTransactionManager.currentTransaction()
//                    ^^ definition local 30
//                       display_name tr
//                       documentation ```kotlin\nlocal val tr: Transaction\n```
//                                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                                   ⌃ enclosing_range_end local 30
                  append("ALTER TABLE ${tr.identity(column.table)} ")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                      ^^ reference local 30
//                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                ⌄ enclosing_range_start local 31
                  val colName = tr.identity(column)
//                    ^^^^^^^ definition local 31
//                            display_name colName
//                            documentation ```kotlin\nlocal val colName: String\n```
//                              ^^ reference local 30
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                ⌃ enclosing_range_end local 31
  
                  if (columnDiff.autoInc && column.autoIncColumnType != null) {
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(columnDiff)
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#autoInc.
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getAutoInc().
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                    ⌄ enclosing_range_start local 32
                      val sequence = column.autoIncColumnType?.sequence
//                        ^^^^^^^^ definition local 32
//                                 display_name sequence
//                                 documentation ```kotlin\nlocal val sequence: Sequence?\n```
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.
//                                                                    ⌃ enclosing_range_end local 32
                      if (sequence != null) {
//                        ^^^^^^^^ reference local 32
                          append("ALTER COLUMN $colName TYPE ${column.columnType.sqlType()}")
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                              ^^^^^^^ reference local 31
//                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
                          append(", ALTER COLUMN $colName DROP DEFAULT")
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                                ^^^^^^^ reference local 31
                      } else {
//                        ⌄ enclosing_range_start local 33
                          val fallbackSequenceName = fallbackSequenceName(tableName = column.table.tableName, columnName = column.name)
//                            ^^^^^^^^^^^^^^^^^^^^ definition local 33
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
//                                                                                                                                    ⌃ enclosing_range_end local 33
                          append("ALTER COLUMN $colName SET DEFAULT nextval('$fallbackSequenceName')")
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                              ^^^^^^^ reference local 31
//                                                                            ^^^^^^^^^^^^^^^^^^^^ reference local 33
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
//                                          ^^^^^^^ reference local 31
//                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
                      append(", ALTER COLUMN $colName DROP DEFAULT")
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                            ^^^^^^^ reference local 31
                  } else {
                      append("ALTER COLUMN $colName TYPE ${column.columnType.sqlType()}")
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                          ^^^^^^^ reference local 31
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
//                                            ^^^^^^^ reference local 31
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
//                                               ⌄ enclosing_range_start local 34
                      column.dbDefaultValue?.let {
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                           ^^^ reference semanticdb maven . . kotlin/let().
//                                               ^ definition local 34 2:21
//                                                 display_name it
//                                                 documentation ```kotlin\nit: Expression<out Any?>\n```
                          append(", ALTER COLUMN $colName SET DEFAULT ${PostgreSQLDataTypeProvider.processForDefaultValue(it)}")
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                                ^^^^^^^ reference local 31
//                                                                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().
//                                                                                                                        ^^ reference local 34
                      } ?: run {
//                         ^^^ reference semanticdb maven . . kotlin/run(+1).
//                    ⌃ enclosing_range_end local 34
                          append(", ALTER COLUMN $colName DROP DEFAULT")
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                                ^^^^^^^ reference local 31
                      }
                  }
              }
          )
//        ⌃ enclosing_range_end local 29
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
//            ^^^^ reference local 29
//                 ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
                  buildString {
//                ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
//                    ⌄ enclosing_range_start local 35
                      val fallbackSequenceName = fallbackSequenceName(tableName = column.table.tableName, columnName = column.name)
//                        ^^^^^^^^^^^^^^^^^^^^ definition local 35
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
//                                                                                                                                ⌃ enclosing_range_end local 35
//                    ⌄ enclosing_range_start local 36
                      val q = if (column.table.tableName.contains('.')) "\"" else ""
//                        ^ definition local 36
//                          display_name q
//                          documentation ```kotlin\nlocal val q: String\n```
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                       ^^^^^^^^ reference semanticdb maven . . kotlin/text/contains(+1).
//                                                                                 ⌃ enclosing_range_end local 36
                      append("ALTER SEQUENCE $fallbackSequenceName OWNED BY $q${column.table.tableName.replace("\"", "")}.${column.name}$q")
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                            ^^^^^^^^^^^^^^^^^^^^ reference local 35
//                                                                           ^ reference local 36
//                                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                                                     ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
//                                                                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().(column)
//                                                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                                                                                       ^ reference local 36
                  }
              )
          }
          return list
//               ^^^^ reference local 29
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createDatabase().
      @OptIn(InternalApi::class)
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createDatabase().(name)
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
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createDatabase().(name)
//                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createDatabase().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#listDatabases().
      override fun listDatabases(): String = "SELECT datname FROM pg_database"
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#listDatabases().
//                               display_name listDatabases
//                               documentation ```kotlin\npublic open override fun listDatabases(): String\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#listDatabases().
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#listDatabases().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropDatabase().
      @OptIn(InternalApi::class)
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropDatabase().(name)
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
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropDatabase().(name)
//                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropDatabase().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#setSchema().
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#setSchema().(schema)
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
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#setSchema().(schema)
//                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#setSchema().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(name)
//                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(table)
//                                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(columns)
//                                                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(type)
//                                                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(filterCondition)
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
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(name)
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(table)
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(columns)
//                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(type)
//                                                                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(filterCondition)
          return "CREATE INDEX $name ON $table USING $type $columns$filterCondition"
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(name)
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(table)
//                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(type)
//                                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(columns)
//                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().(filterCondition)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(tableName)
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(indexName)
//                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(isUnique)
//                                                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(isPartialOrFunctional)
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
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(tableName)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(indexName)
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(isUnique)
//                                                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().(isPartialOrFunctional)
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#Companion#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#Companion#`<init>`().
      companion object : DialectNameProvider("PostgreSQL")
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#Companion#
//                                                         display_name Companion
//                                                         documentation ```kotlin\npublic final companion object Companion : VendorDialect.DialectNameProvider\n```
//                                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#Companion#`<init>`().
//                                                         display_name Companion
//                                                         documentation ```kotlin\nprivate constructor(): PostgreSQLDialect.Companion\n```
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#Companion#
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#Companion#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#`<init>`().
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
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#requiresAutoCommitOnCreateDrop.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#getRequiresAutoCommitOnCreateDrop().
      override val requiresAutoCommitOnCreateDrop: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#getRequiresAutoCommitOnCreateDrop().
//                                                display_name requiresAutoCommitOnCreateDrop
//                                                documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#requiresAutoCommitOnCreateDrop.
//                                                display_name requiresAutoCommitOnCreateDrop
//                                                documentation ```kotlin\npublic open override val requiresAutoCommitOnCreateDrop: Boolean\n```
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#requiresAutoCommitOnCreateDrop.
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#getRequiresAutoCommitOnCreateDrop().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#Companion#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#Companion#`<init>`().
      companion object : DialectNameProvider("PostgreSQLNG")
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#Companion#
//                                                           display_name Companion
//                                                           documentation ```kotlin\npublic final companion object Companion : VendorDialect.DialectNameProvider\n```
//                                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#Companion#`<init>`().
//                                                           display_name Companion
//                                                           documentation ```kotlin\nprivate constructor(): PostgreSQLNGDialect.Companion\n```
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#Companion#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#Companion#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#`<init>`().
