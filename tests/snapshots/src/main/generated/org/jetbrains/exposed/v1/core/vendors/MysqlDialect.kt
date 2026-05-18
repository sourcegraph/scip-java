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
  import org.jetbrains.exposed.v1.exceptions.UnsupportedByDialectException
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#
  import org.jetbrains.exposed.v1.exceptions.throwUnsupportedException
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#`<init>`().
  internal open class MysqlDataTypeProvider : DataTypeProvider() {
//                    ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#
//                                          display_name MysqlDataTypeProvider
//                                          documentation ```kotlin\ninternal open class MysqlDataTypeProvider : DataTypeProvider\n```\n\n----\n\n Character type for storing strings of variable and _unlimited_ length.
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#
//                    ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#`<init>`().
//                                          display_name MysqlDataTypeProvider
//                                          documentation ```kotlin\npublic constructor(): MysqlDataTypeProvider\n```\n\n----\n\n Character type for storing strings of variable and _unlimited_ length.
//                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#binaryType().
      override fun binaryType(): String {
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#binaryType().
//                            display_name binaryType
//                            documentation ```kotlin\npublic open override fun binaryType(): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType().
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
          exposedLogger.error("The length of the Binary column is missing.")
//        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                      ^^^^^ reference semanticdb maven . . org/slf4j/Logger#error().
          error("The length of the Binary column is missing.")
//        ^^^^^ reference semanticdb maven . . kotlin/error().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#binaryType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#dateTimeType().
      override fun dateTimeType(): String = if ((currentDialect as? MysqlDialect)?.isFractionDateTimeSupported() == true) "DATETIME(6)" else "DATETIME"
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#dateTimeType().
//                              display_name dateTimeType
//                              documentation ```kotlin\npublic open override fun dateTimeType(): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#dateTimeType().
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isFractionDateTimeSupported().
//                                                                                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#dateTimeType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#timestampWithTimeZoneType().
      override fun timestampWithTimeZoneType(): String =
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#timestampWithTimeZoneType().
//                                           display_name timestampWithTimeZoneType
//                                           documentation ```kotlin\npublic open override fun timestampWithTimeZoneType(): String\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#timestampWithTimeZoneType().
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#timestampWithTimeZoneType().
//                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
          if ((currentDialect as? MysqlDialect)?.isTimeZoneOffsetSupported() == true) {
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isTimeZoneOffsetSupported().
              "TIMESTAMP(6)"
          } else {
              throw UnsupportedByDialectException("This vendor does not support timestamp with time zone data type for this version", currentDialect)
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
//                                                                                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#timestampWithTimeZoneType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ubyteType().
      override fun ubyteType(): String = "TINYINT UNSIGNED"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ubyteType().
//                           display_name ubyteType
//                           documentation ```kotlin\npublic open override fun ubyteType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ubyteType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ubyteType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ushortType().
      override fun ushortType(): String = "SMALLINT UNSIGNED"
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ushortType().
//                            display_name ushortType
//                            documentation ```kotlin\npublic open override fun ushortType(): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ushortType().
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ushortType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#uintegerType().
      override fun uintegerType(): String = "INT UNSIGNED"
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#uintegerType().
//                              display_name uintegerType
//                              documentation ```kotlin\npublic open override fun uintegerType(): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uintegerType().
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#uintegerType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#uintegerAutoincType().
      override fun uintegerAutoincType(): String = "INT UNSIGNED AUTO_INCREMENT"
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#uintegerAutoincType().
//                                     display_name uintegerAutoincType
//                                     documentation ```kotlin\npublic open override fun uintegerAutoincType(): String\n```
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uintegerAutoincType().
//                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#uintegerAutoincType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ulongType().
      override fun ulongType(): String = "BIGINT UNSIGNED"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ulongType().
//                           display_name ulongType
//                           documentation ```kotlin\npublic open override fun ulongType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ulongType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ulongAutoincType().
      override fun ulongAutoincType(): String = "BIGINT UNSIGNED AUTO_INCREMENT"
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ulongAutoincType().
//                                  display_name ulongAutoincType
//                                  documentation ```kotlin\npublic open override fun ulongAutoincType(): String\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongAutoincType().
//                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ulongAutoincType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#textType().
      override fun textType(): String = "text"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#textType().
//                          display_name textType
//                          documentation ```kotlin\npublic open override fun textType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#textType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#textType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#mediumTextType().
      /** Character type for storing strings of variable and _unlimited_ length. */
      override fun mediumTextType(): String = "MEDIUMTEXT"
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#mediumTextType().
//                                display_name mediumTextType
//                                documentation ```kotlin\npublic open override fun mediumTextType(): String\n```\n\n----\n\n Character type for storing strings of variable and _unlimited_ length.
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#mediumTextType().
//                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#mediumTextType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#largeTextType().
      /** Character type for storing strings of variable and _unlimited_ length. */
      override fun largeTextType(): String = "LONGTEXT"
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#largeTextType().
//                               display_name largeTextType
//                               documentation ```kotlin\npublic open override fun largeTextType(): String\n```\n\n----\n\n Character type for storing strings of variable and _unlimited_ length.
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#largeTextType().
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#largeTextType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#booleanFromStringToBoolean().
//                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#booleanFromStringToBoolean().(value)
//                                                                            ⌄ enclosing_range_start local 0
      override fun booleanFromStringToBoolean(value: String): Boolean = when (value) {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#booleanFromStringToBoolean().
//                                            display_name booleanFromStringToBoolean
//                                            documentation ```kotlin\npublic open override fun booleanFromStringToBoolean(value: String): Boolean\n```
//                                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanFromStringToBoolean().
//                                            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#booleanFromStringToBoolean().(value)
//                                                  display_name value
//                                                  documentation ```kotlin\nvalue: String\n```
//                                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                            ^^^^^ definition local 0
//                                                                                  display_name <when-subject>
//                                                                                  documentation ```kotlin\nlocal val <when-subject>: String\n```
//                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#booleanFromStringToBoolean().(value)
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#booleanFromStringToBoolean().(value)
//                                                                                ⌃ enclosing_range_end local 0
          "0" -> false
          "1" -> true
          else -> value.toBoolean()
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#booleanFromStringToBoolean().(value)
//                      ^^^^^^^^^ reference semanticdb maven . . kotlin/text/toBoolean().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#booleanFromStringToBoolean().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#jsonBType().
      override fun jsonBType(): String = "JSON"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#jsonBType().
//                           display_name jsonBType
//                           documentation ```kotlin\npublic open override fun jsonBType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#jsonBType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#jsonBType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().
//                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().(e)
      override fun processForDefaultValue(e: Expression<*>): String = when {
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().
//                                        display_name processForDefaultValue
//                                        documentation ```kotlin\npublic open override fun processForDefaultValue(e: Expression<*>): String\n```
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#processForDefaultValue().
//                                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().(e)
//                                          display_name e
//                                          documentation ```kotlin\ne: Expression<*>\n```
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().(e)
          e is LiteralOp<*> && e.columnType is JsonColumnMarker -> when {
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().(e)
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().(e)
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#
              ((currentDialect as? MysqlDialect)?.fullVersion ?: "0") >= "8.0.13" -> "(${super.processForDefaultValue(e)})"
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#fullVersion.
//                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getFullVersion().
//                                                                    ^^ reference semanticdb maven . . kotlin/String#compareTo().
//                                                                                             ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                                                    ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().(e)
              else -> throw UnsupportedByDialectException(
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
                  "MySQL versions prior to 8.0.13 do not accept default values on JSON columns",
                  currentDialect
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
              )
          }
          // The default value specified in a DEFAULT clause can be a literal constant or an expression. With one
          // exception, enclose expression default values within parentheses to distinguish them from literal constant
          // default values. The exception is that, for TIMESTAMP and DATETIME columns, you can specify the
          // CURRENT_TIMESTAMP function as the default, without enclosing parentheses.
          // https://dev.mysql.com/doc/refman/8.0/en/data-type-defaults.html#data-type-defaults-explicit
          e is ExpressionWithColumnType<*> && e.columnType is IDateColumnType && e.toString().startsWith("CURRENT_TIMESTAMP") ->
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().(e)
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().(e)
//                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IDateColumnType#
//                                                                               ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().(e)
//                                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toString().
//                                                                                            ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
              super.processForDefaultValue(e)
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                         ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().(e)
          e !is LiteralOp<*> && ((currentDialect as? MysqlDialect)?.fullVersion ?: "0") >= "8.0.13" ->
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().(e)
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#fullVersion.
//                                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getFullVersion().
//                                                                                      ^^ reference semanticdb maven . . kotlin/String#compareTo().
              "(${super.processForDefaultValue(e)})"
//                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().(e)
          else -> super.processForDefaultValue(e)
//                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().(e)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().
//                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(queryBuilder)
//                                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(expression)
//                                                                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(sortOrder)
      override fun precessOrderByClause(queryBuilder: QueryBuilder, expression: Expression<*>, sortOrder: SortOrder) {
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().
//                                      display_name precessOrderByClause
//                                      documentation ```kotlin\npublic open override fun precessOrderByClause(queryBuilder: QueryBuilder, expression: Expression<*>, sortOrder: SortOrder): Unit\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().
//                                      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(queryBuilder)
//                                                   display_name queryBuilder
//                                                   documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                  ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(expression)
//                                                                             display_name expression
//                                                                             documentation ```kotlin\nexpression: Expression<*>\n```
//                                                                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(sortOrder)
//                                                                                                       display_name sortOrder
//                                                                                                       documentation ```kotlin\nsortOrder: SortOrder\n```
//                                                                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(queryBuilder)
//                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(expression)
//                                                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(sortOrder)
//              ⌄ enclosing_range_start local 1
          when (sortOrder) {
//              ^^^^^^^^^ definition local 1
//                        display_name <when-subject>
//                        documentation ```kotlin\nlocal val <when-subject>: SortOrder\n```
//              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(sortOrder)
//                      ⌃ enclosing_range_end local 1
              SortOrder.ASC, SortOrder.DESC -> super.precessOrderByClause(queryBuilder, expression, sortOrder)
//                      ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#ASC.
//                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#DESC.
//                                                   ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().
//                                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(queryBuilder)
//                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(expression)
//                                                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(sortOrder)
              SortOrder.ASC_NULLS_FIRST -> super.precessOrderByClause(queryBuilder, expression, SortOrder.ASC)
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#ASC_NULLS_FIRST.
//                                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(queryBuilder)
//                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(expression)
//                                                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#ASC.
              SortOrder.DESC_NULLS_LAST -> super.precessOrderByClause(queryBuilder, expression, SortOrder.DESC)
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#DESC_NULLS_LAST.
//                                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(queryBuilder)
//                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(expression)
//                                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#DESC.
              else -> {
//                ⌄ enclosing_range_start local 2
                  val exp = (expression as? IExpressionAlias<*>)?.alias ?: expression
//                    ^^^ definition local 2
//                        display_name exp
//                        documentation ```kotlin\nlocal val exp: Any\n```
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(expression)
//                                          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#alias.
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getAlias().
//                                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(expression)
//                                                                                  ⌃ enclosing_range_end local 2
//                ⌄ enclosing_range_start local 3
                  val nullExp = if (sortOrder == SortOrder.ASC_NULLS_LAST) " IS NULL" else " IS NOT NULL"
//                    ^^^^^^^ definition local 3
//                            display_name nullExp
//                            documentation ```kotlin\nlocal val nullExp: String\n```
//                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(sortOrder)
//                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#ASC_NULLS_LAST.
//                                                                                                      ⌃ enclosing_range_end local 3
//                ⌄ enclosing_range_start local 4
                  val order = if (sortOrder == SortOrder.ASC_NULLS_LAST) SortOrder.ASC else SortOrder.DESC
//                    ^^^^^ definition local 4
//                          display_name order
//                          documentation ```kotlin\nlocal val order: SortOrder\n```
//                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(sortOrder)
//                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#ASC_NULLS_LAST.
//                                                                                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#ASC.
//                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#DESC.
//                                                                                                       ⌃ enclosing_range_end local 4
                  queryBuilder.append(exp, nullExp, ", ", exp, " ", order.code)
//                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().(queryBuilder)
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                    ^^^ reference local 2
//                                         ^^^^^^^ reference local 3
//                                                        ^^^ reference local 2
//                                                                  ^^^^^ reference local 4
//                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#code.
//                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#getCode().
              }
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#hexToDb().
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#hexToDb().(hexString)
      override fun hexToDb(hexString: String): String = "0x$hexString"
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#hexToDb().
//                         display_name hexToDb
//                         documentation ```kotlin\npublic open override fun hexToDb(hexString: String): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#hexToDb().
//                         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#hexToDb().(hexString)
//                                   display_name hexString
//                                   documentation ```kotlin\nhexString: String\n```
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#hexToDb().(hexString)
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#hexToDb().(hexString)
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#hexToDb().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#Companion#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#Companion#`<init>`().
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#Companion# 2:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#Companion#`<init>`(). 2:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): MysqlDataTypeProvider.Companion\n```
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#Companion#INSTANCE.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#Companion#getINSTANCE().
          internal val INSTANCE = MysqlDataTypeProvider()
//                     ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#Companion#INSTANCE.
//                              display_name INSTANCE
//                              documentation ```kotlin\ninternal final val INSTANCE: MysqlDataTypeProvider\n```
//                     ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#Companion#getINSTANCE().
//                              display_name INSTANCE
//                              documentation ```kotlin\ninternal get(): MysqlDataTypeProvider\n```
//                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#`<init>`().
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#Companion#INSTANCE.
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#Companion#getINSTANCE().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#Companion#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#Companion#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#`<init>`().
  internal open class MysqlFunctionProvider : FunctionProvider() {
//                    ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#
//                                          display_name MysqlFunctionProvider
//                                          documentation ```kotlin\ninternal open class MysqlFunctionProvider : FunctionProvider\n```
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#
//                    ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#`<init>`().
//                                          display_name MysqlFunctionProvider
//                                          documentation ```kotlin\npublic constructor(): MysqlFunctionProvider\n```
//                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#random().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#random().(seed)
      override fun random(seed: Int?): String = "RAND(${seed?.toString().orEmpty()})"
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#random().
//                        display_name random
//                        documentation ```kotlin\npublic open override fun random(seed: Int?): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#random().
//                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#random().(seed)
//                             display_name seed
//                             documentation ```kotlin\nseed: Int?\n```
//                              ^^^^ reference semanticdb maven . . kotlin/Int#
//                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#random().(seed)
//                                                            ^^^^^^^^ reference semanticdb maven . . kotlin/Int#toString().
//                                                                       ^^^^^^^ reference semanticdb maven . . kotlin/text/orEmpty().
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#random().(seed)
//                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#random().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().(expr)
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#expr.
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#getExpr().
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().(pattern)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#pattern.
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#getPattern().
//                                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().(mode)
//                                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#mode.
//                                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#getMode().
      private class MATCH(val expr: Expression<*>, val pattern: String, val mode: MatchMode) : Op<Boolean>() {
//                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#
//                        display_name MATCH
//                        documentation ```kotlin\nprivate final class MATCH : Op<Boolean>\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().
//                        display_name MATCH
//                        documentation ```kotlin\npublic constructor(expr: Expression<*>, pattern: String, mode: FunctionProvider.MatchMode): MysqlFunctionProvider.MATCH\n```
//                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().(expr)
//                                 display_name expr
//                                 documentation ```kotlin\nexpr: Expression<*>\n```
//                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().(expr)
//                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#expr.
//                                 display_name expr
//                                 documentation ```kotlin\npublic final val expr: Expression<*>\n```
//                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#getExpr().
//                                 display_name expr
//                                 documentation ```kotlin\npublic get(): Expression<*>\n```
//                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                     ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().(pattern)
//                                                             display_name pattern
//                                                             documentation ```kotlin\npattern: String\n```
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().(pattern)
//                                                     ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#getPattern().
//                                                             display_name pattern
//                                                             documentation ```kotlin\npublic get(): String\n```
//                                                     ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#pattern.
//                                                             display_name pattern
//                                                             documentation ```kotlin\npublic final val pattern: String\n```
//                                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().(mode)
//                                                                               display_name mode
//                                                                               documentation ```kotlin\nmode: FunctionProvider.MatchMode\n```
//                                                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().(mode)
//                                                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#getMode().
//                                                                               display_name mode
//                                                                               documentation ```kotlin\npublic get(): FunctionProvider.MatchMode\n```
//                                                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#mode.
//                                                                               display_name mode
//                                                                               documentation ```kotlin\npublic final val mode: FunctionProvider.MatchMode\n```
//                                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#MatchMode#
//                                                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().(expr)
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#expr.
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#getExpr().
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().(pattern)
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#pattern.
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#getPattern().
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().(mode)
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#mode.
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#getMode().
//                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#toQueryBuilder().
//                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#toQueryBuilder().(queryBuilder)
          override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//                     ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#toQueryBuilder().
//                                    display_name toQueryBuilder
//                                    documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                                    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#toQueryBuilder().(queryBuilder)
//                                                 display_name queryBuilder
//                                                 documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#toQueryBuilder().(queryBuilder)
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#toQueryBuilder().(queryBuilder)
              append("MATCH(", expr, ") AGAINST ('", pattern, "' ", mode.mode(), ")")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#expr.
//                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#getExpr().
//                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#getPattern().
//                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#pattern.
//                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#getMode().
//                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#mode.
//                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#MatchMode#mode().
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#toQueryBuilder().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#values().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#valueOf().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#valueOf().(value)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#entries.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getEntries().
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#`<init>`().
//                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#`<init>`().(operator)
//                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#operator.
//                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#getOperator().
      private enum class MysqlMatchMode(val operator: String) : MatchMode {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Enum# 5:5
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode# 5:5
//                       ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#
//                                      display_name MysqlMatchMode
//                                      documentation ```kotlin\nprivate final enum class MysqlMatchMode : FunctionProvider.MatchMode, Enum<MysqlFunctionProvider.MysqlMatchMode>\n```
//                                      relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#MatchMode#
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 4932>`#
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 4967>`#
//                       ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#`<init>`().
//                                      display_name MysqlMatchMode
//                                      documentation ```kotlin\nprivate constructor(operator: String): MysqlFunctionProvider.MysqlMatchMode\n```
//                       ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#entries.
//                                      display_name entries
//                                      documentation ```kotlin\npublic final static val entries: EnumEntries<MysqlFunctionProvider.MysqlMatchMode>\n```
//                       ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#valueOf().
//                                      display_name valueOf
//                                      documentation ```kotlin\npublic final static fun valueOf(value: String): MysqlFunctionProvider.MysqlMatchMode\n```
//                       ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#valueOf().(value)
//                                      display_name value
//                                      documentation ```kotlin\nvalue: String\n```
//                       ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#values().
//                                      display_name values
//                                      documentation ```kotlin\npublic final static fun values(): Array<MysqlFunctionProvider.MysqlMatchMode>\n```
//                       ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getEntries().
//                                      display_name entries
//                                      documentation ```kotlin\npublic get(): EnumEntries<MysqlFunctionProvider.MysqlMatchMode>\n```
//                                          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#`<init>`().(operator)
//                                                   display_name operator
//                                                   documentation ```kotlin\noperator: String\n```
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#`<init>`().(operator)
//                                          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#getOperator().
//                                                   display_name operator
//                                                   documentation ```kotlin\npublic get(): String\n```
//                                          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#operator.
//                                                   display_name operator
//                                                   documentation ```kotlin\npublic final val operator: String\n```
//                                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#MatchMode#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#`<init>`().(operator)
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#operator.
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#getOperator().
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#`<init>`().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 4932>`#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 4932>`#`<init>`().
          STRICT("IN BOOLEAN MODE"),
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 4932>`#
//               display_name <anonymous>
//               documentation ```kotlin\nobject : MysqlFunctionProvider.MysqlMatchMode\n```
//               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 4932>`#`<init>`().
//               display_name STRICT
//               documentation ```kotlin\nprivate constructor(): <anonymous>\n```
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 4932>`#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 4932>`#`<init>`().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 4967>`#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 4967>`#`<init>`().
          NATURAL_LANGUAGE("IN NATURAL LANGUAGE MODE");
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 4967>`#
//                         display_name <anonymous>
//                         documentation ```kotlin\nobject : MysqlFunctionProvider.MysqlMatchMode\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 4967>`#`<init>`().
//                         display_name NATURAL_LANGUAGE
//                         documentation ```kotlin\nprivate constructor(): <anonymous>\n```
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 4967>`#
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/`<anonymous object at 4967>`#`<init>`().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#mode().
          override fun mode() = operator
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#mode().
//                          display_name mode
//                          documentation ```kotlin\npublic open override fun mode(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#MatchMode#mode().
//                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#getOperator().
//                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#operator.
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#mode().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#values().
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#valueOf().
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#valueOf().(value)
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#entries.
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getEntries().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#match().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#match().[T]
//                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#match().(pattern)
//                                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#match().(mode)
      override fun <T : String?> Expression<T>.match(pattern: String, mode: MatchMode?): Op<Boolean> =
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#match().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#match().
//                                                   display_name match
//                                                   documentation ```kotlin\npublic open override fun <T : String?> Expression<T>.match(pattern: String, mode: FunctionProvider.MatchMode?): Op<Boolean>\n```
//                                                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#match().
//                                                   ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#match().(pattern)
//                                                           display_name pattern
//                                                           documentation ```kotlin\npattern: String\n```
//                                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#match().(mode)
//                                                                         display_name mode
//                                                                         documentation ```kotlin\nmode: FunctionProvider.MatchMode?\n```
//                                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#MatchMode#
//                                                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#match().[T]
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#match().(pattern)
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#match().(mode)
          MATCH(this, pattern, mode ?: MysqlMatchMode.STRICT)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MATCH#`<init>`().
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#match().(pattern)
//                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#match().(mode)
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#STRICT.
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#match().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().[T]
      override fun <T : String?> locate(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().
//                                      display_name locate
//                                      documentation ```kotlin\npublic open override fun <T : String?> locate(queryBuilder: QueryBuilder, expr: Expression<T>, substring: String): Unit\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#locate().
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().(queryBuilder)
          queryBuilder: QueryBuilder,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().(queryBuilder)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().(expr)
          expr: Expression<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().(expr)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().(substring)
          substring: String
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().(substring)
//                  display_name substring
//                  documentation ```kotlin\nsubstring: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().(substring)
      ) = queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().(queryBuilder)
          append("LOCATE(\'", substring, "\',", expr, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().(substring)
//                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().(expr)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().[T]
      override fun <T : String?> regexp(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().
//                                      display_name regexp
//                                      documentation ```kotlin\npublic open override fun <T : String?> regexp(expr1: Expression<T>, pattern: Expression<String>, caseSensitive: Boolean, queryBuilder: QueryBuilder): Unit\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#regexp().
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(expr1)
          expr1: Expression<T>,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(expr1)
//              display_name expr1
//              documentation ```kotlin\nexpr1: Expression<T>\n```
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(expr1)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(pattern)
          pattern: Expression<String>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(pattern)
//                display_name pattern
//                documentation ```kotlin\npattern: Expression<String>\n```
//                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(pattern)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(caseSensitive)
          caseSensitive: Boolean,
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(caseSensitive)
//                      display_name caseSensitive
//                      documentation ```kotlin\ncaseSensitive: Boolean\n```
//                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(caseSensitive)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(queryBuilder)
      ) {
          return if ((currentDialect as MysqlDialect).isMysql8) {
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getIsMysql8().
//                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isMysql8.
              super.regexp(expr1, pattern, caseSensitive, queryBuilder)
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(expr1)
//                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(pattern)
//                                         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(caseSensitive)
//                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(queryBuilder)
          } else {
              queryBuilder { append(expr1, " REGEXP ", pattern) }
//            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(queryBuilder)
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(expr1)
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().(pattern)
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().[T]
      override fun <T> jsonExtract(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().
//                                 display_name jsonExtract
//                                 documentation ```kotlin\npublic open override fun <T> jsonExtract(expression: Expression<T>, vararg path: String, toScalar: Boolean, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(expression)
          expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(path)
          vararg path: String,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(path)
//                    display_name path
//                    documentation ```kotlin\nvararg path: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/Array#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(path)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(toScalar)
          toScalar: Boolean,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(toScalar)
//                 display_name toScalar
//                 documentation ```kotlin\ntoScalar: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(toScalar)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(jsonType)
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(jsonType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(queryBuilder)
      ) = queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(queryBuilder)
          if (toScalar) append("JSON_UNQUOTE(")
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(toScalar)
//                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append("JSON_EXTRACT(", expression, ", ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(expression)
//                                              ⌄ enclosing_range_start local 5
          path.ifEmpty { arrayOf("") }.appendTo { +"\"$$it\"" }
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(path)
//             ^^^^^^^ reference semanticdb maven . . kotlin/collections/ifEmpty().
//                       ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                                              ^^^^^^^^^^^^^^^ definition local 5
//                                                              display_name it
//                                                              documentation ```kotlin\nit: CapturedType(out String)\n```
//                                                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                                      ^^ reference local 5
//                                                            ⌃ enclosing_range_end local 5
          append(")${if (toScalar) ")" else ""}")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().(toScalar)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().
      override fun jsonContains(
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().
//                              display_name jsonContains
//                              documentation ```kotlin\npublic open override fun jsonContains(target: Expression<*>, candidate: Expression<*>, path: String?, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(target)
          target: Expression<*>,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(target)
//               display_name target
//               documentation ```kotlin\ntarget: Expression<*>\n```
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(target)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(candidate)
          candidate: Expression<*>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(candidate)
//                  display_name candidate
//                  documentation ```kotlin\ncandidate: Expression<*>\n```
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(candidate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(path)
          path: String?,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(path)
//             display_name path
//             documentation ```kotlin\npath: String?\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(path)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(jsonType)
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(jsonType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(queryBuilder)
      ) = queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(queryBuilder)
          append("JSON_CONTAINS(", target, ", ", candidate)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(target)
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(candidate)
//                  ⌄ enclosing_range_start local 6
          path?.let {
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().(path)
//              ^^^ reference semanticdb maven . . kotlin/let().
//                  ^ definition local 6 2:9
//                    display_name it
//                    documentation ```kotlin\nit: String\n```
              append(", '$$it'")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                         ^^ reference local 6
          }
//        ⌃ enclosing_range_end local 6
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().
      override fun jsonExists(
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().
//                            display_name jsonExists
//                            documentation ```kotlin\npublic open override fun jsonExists(expression: Expression<*>, vararg path: String, optional: String?, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(expression)
          expression: Expression<*>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<*>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(path)
          vararg path: String,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(path)
//                    display_name path
//                    documentation ```kotlin\nvararg path: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/Array#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(path)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(optional)
          optional: String?,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(optional)
//                 display_name optional
//                 documentation ```kotlin\noptional: String?\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(optional)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(jsonType)
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(jsonType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(queryBuilder)
      ) {
//        ⌄ enclosing_range_start local 7
          val oneOrAll = optional?.lowercase()
//            ^^^^^^^^ definition local 7
//                     display_name oneOrAll
//                     documentation ```kotlin\nlocal val oneOrAll: String?\n```
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(optional)
//                                 ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
//                                           ⌃ enclosing_range_end local 7
          @OptIn(InternalApi::class)
          if (oneOrAll != "one" && oneOrAll != "all") {
//            ^^^^^^^^ reference local 7
//                                 ^^^^^^^^ reference local 7
              CoreTransactionManager.currentTransaction().throwUnsupportedException("MySQL requires a single optional argument: 'one' or 'all'")
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(queryBuilder)
              append("JSON_CONTAINS_PATH(", expression, ", ")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(expression)
              append("'$oneOrAll', ")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                      ^^^^^^^^ reference local 7
//                                                  ⌄ enclosing_range_start local 8
              path.ifEmpty { arrayOf("") }.appendTo { +"'$$it'" }
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().(path)
//                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/ifEmpty().
//                           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                                                  ^^^^^^^^^^^^^ definition local 8
//                                                                display_name it
//                                                                documentation ```kotlin\nit: CapturedType(out String)\n```
//                                                    ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                                         ^^ reference local 8
//                                                              ⌃ enclosing_range_end local 8
              append(")")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().
      override fun replace(
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().
//                         display_name replace
//                         documentation ```kotlin\npublic open override fun replace(table: Table, columns: List<Column<*>>, expression: String, transaction: Transaction, prepared: Boolean): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(table)
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(table)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(columns)
          columns: List<Column<*>>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(columns)
//                display_name columns
//                documentation ```kotlin\ncolumns: List<Column<*>>\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(columns)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(expression)
          expression: String,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: String\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(transaction)
          transaction: Transaction,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(transaction)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(prepared)
          prepared: Boolean
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(prepared)
//                 display_name prepared
//                 documentation ```kotlin\nprepared: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(prepared)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
//        ⌄ enclosing_range_start local 9
          val insertStatement = super.insert(false, table, columns, expression, transaction)
//            ^^^^^^^^^^^^^^^ definition local 9
//                            display_name insertStatement
//                            documentation ```kotlin\nlocal val insertStatement: String\n```
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(table)
//                                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(columns)
//                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(expression)
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().(transaction)
//                                                                                         ⌃ enclosing_range_end local 9
          return insertStatement.replace("INSERT", "REPLACE")
//               ^^^^^^^^^^^^^^^ reference local 9
//                               ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#CharColumnType#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#CharColumnType#`<init>`().
      private object CharColumnType : StringColumnType() {
//                   ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#CharColumnType#
//                                  display_name CharColumnType
//                                  documentation ```kotlin\nprivate final object CharColumnType : StringColumnType\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#
//                   ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#CharColumnType#`<init>`().
//                                  display_name CharColumnType
//                                  documentation ```kotlin\nprivate constructor(): MysqlFunctionProvider.CharColumnType\n```
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#CharColumnType#sqlType().
          override fun sqlType(): String = "CHAR"
//                     ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#CharColumnType#sqlType().
//                             display_name sqlType
//                             documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#CharColumnType#sqlType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#CharColumnType#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#CharColumnType#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().
//                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().(expr)
//                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().(type)
//                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().(builder)
//                                                                                                ⌄ enclosing_range_start local 10
      override fun cast(expr: Expression<*>, type: IColumnType<*>, builder: QueryBuilder) = when (type) {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().
//                      display_name cast
//                      documentation ```kotlin\npublic open override fun cast(expr: Expression<*>, type: IColumnType<*>, builder: QueryBuilder): Unit\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().
//                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().(expr)
//                           display_name expr
//                           documentation ```kotlin\nexpr: Expression<*>\n```
//                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().(type)
//                                                display_name type
//                                                documentation ```kotlin\ntype: IColumnType<*>\n```
//                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().(builder)
//                                                                         display_name builder
//                                                                         documentation ```kotlin\nbuilder: QueryBuilder\n```
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                                                ^^^^ definition local 10
//                                                                                                     display_name <when-subject>
//                                                                                                     documentation ```kotlin\nlocal val <when-subject>: IColumnType<*>\n```
//                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().(type)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().(expr)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().(type)
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().(builder)
//                                                                                                   ⌃ enclosing_range_end local 10
          is StringColumnType -> super.cast(expr, CharColumnType, builder)
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#
//                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().(expr)
//                                                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().(builder)
          else -> super.cast(expr, type, builder)
//                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().(expr)
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().(type)
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().(builder)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#DEFAULT_VALUE_EXPRESSION.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#getDEFAULT_VALUE_EXPRESSION().
      override val DEFAULT_VALUE_EXPRESSION: String = "() VALUES ()"
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#DEFAULT_VALUE_EXPRESSION.
//                                          display_name DEFAULT_VALUE_EXPRESSION
//                                          documentation ```kotlin\npublic open override val DEFAULT_VALUE_EXPRESSION: String\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#getDEFAULT_VALUE_EXPRESSION().
//                                          display_name DEFAULT_VALUE_EXPRESSION
//                                          documentation ```kotlin\npublic get(): String\n```
//                                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#DEFAULT_VALUE_EXPRESSION.
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#getDEFAULT_VALUE_EXPRESSION().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(ignore)
//                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(table)
//                                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(columns)
//                                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(expr)
//                                                                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(transaction)
      override fun insert(ignore: Boolean, table: Table, columns: List<Column<*>>, expr: String, transaction: Transaction): String {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().
//                        display_name insert
//                        documentation ```kotlin\npublic open override fun insert(ignore: Boolean, table: Table, columns: List<Column<*>>, expr: String, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(ignore)
//                               display_name ignore
//                               documentation ```kotlin\nignore: Boolean\n```
//                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(table)
//                                               display_name table
//                                               documentation ```kotlin\ntable: Table\n```
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                       ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(columns)
//                                                               display_name columns
//                                                               documentation ```kotlin\ncolumns: List<Column<*>>\n```
//                                                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(expr)
//                                                                                      display_name expr
//                                                                                      documentation ```kotlin\nexpr: String\n```
//                                                                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(transaction)
//                                                                                                           display_name transaction
//                                                                                                           documentation ```kotlin\ntransaction: Transaction\n```
//                                                                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                                                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(ignore)
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(table)
//                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(columns)
//                                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(expr)
//                                                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(transaction)
//        ⌄ enclosing_range_start local 11
          val def = super.insert(false, table, columns, expr, transaction)
//            ^^^ definition local 11
//                display_name def
//                documentation ```kotlin\nlocal val def: String\n```
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(table)
//                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(columns)
//                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(expr)
//                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(transaction)
//                                                                       ⌃ enclosing_range_end local 11
          return if (ignore) def.replaceFirst("INSERT", "INSERT IGNORE") else def
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().(ignore)
//                           ^^^ reference local 11
//                               ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/replaceFirst(+1).
//                                                                            ^^^ reference local 11
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(ignore)
//                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(table)
//                                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(where)
//                                                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(limit)
//                                                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(transaction)
      override fun delete(ignore: Boolean, table: Table, where: String?, limit: Int?, transaction: Transaction): String {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().
//                        display_name delete
//                        documentation ```kotlin\npublic open override fun delete(ignore: Boolean, table: Table, where: String?, limit: Int?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().
//                        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(ignore)
//                               display_name ignore
//                               documentation ```kotlin\nignore: Boolean\n```
//                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(table)
//                                               display_name table
//                                               documentation ```kotlin\ntable: Table\n```
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(where)
//                                                             display_name where
//                                                             documentation ```kotlin\nwhere: String?\n```
//                                                              ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(limit)
//                                                                             display_name limit
//                                                                             documentation ```kotlin\nlimit: Int?\n```
//                                                                              ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(transaction)
//                                                                                                display_name transaction
//                                                                                                documentation ```kotlin\ntransaction: Transaction\n```
//                                                                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                                                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(ignore)
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(table)
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(where)
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(limit)
//                                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(transaction)
//        ⌄ enclosing_range_start local 12
          val def = super.delete(false, table, where, limit, transaction)
//            ^^^ definition local 12
//                display_name def
//                documentation ```kotlin\nlocal val def: String\n```
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(table)
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(where)
//                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(limit)
//                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(transaction)
//                                                                      ⌃ enclosing_range_end local 12
          return if (ignore) def.replaceFirst("DELETE", "DELETE IGNORE") else def
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().(ignore)
//                           ^^^ reference local 12
//                               ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/replaceFirst(+1).
//                                                                            ^^^ reference local 12
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().
      override fun update(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().
//                        display_name update
//                        documentation ```kotlin\npublic open override fun update(targets: Join, columnsAndValues: List<Pair<Column<*>, Any?>>, limit: Int?, where: Op<Boolean>?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#update().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(targets)
          targets: Join,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(targets)
//                display_name targets
//                documentation ```kotlin\ntargets: Join\n```
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(targets)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(columnsAndValues)
          columnsAndValues: List<Pair<Column<*>, Any?>>,
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(columnsAndValues)
//                         display_name columnsAndValues
//                         documentation ```kotlin\ncolumnsAndValues: List<Pair<Column<*>, Any?>>\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(columnsAndValues)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(limit)
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(limit)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(where)
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (limit != null) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(limit)
              transaction.throwUnsupportedException("MySQL doesn't support LIMIT in UPDATE with join clause.")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
  
          return with(QueryBuilder(true)) {
//               ^^^^ reference semanticdb maven . . kotlin/with().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
              +"UPDATE "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              targets.describe(transaction, this)
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(targets)
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(transaction)
              +" SET "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                              ⌄ enclosing_range_start local 13
//                                               ⌄ enclosing_range_start local 14
//                                                    ⌄ enclosing_range_start local 15
              columnsAndValues.appendTo(this) { (col, value) ->
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(columnsAndValues)
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                              ^^^^^^^^^^^^ definition local 13
//                                                           display_name <destruct>
//                                                           documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                               ^^^ reference local 13
//                                               ^^^ definition local 14
//                                                   display_name col
//                                                   documentation ```kotlin\nlocal val col: Column<*>\n```
//                                               ^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                    ^^^^^ reference local 13
//                                                    ^^^^^ definition local 15
//                                                          display_name value
//                                                          documentation ```kotlin\nlocal val value: Any?\n```
//                                                    ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                 ⌃ enclosing_range_end local 14
//                                                        ⌃ enclosing_range_end local 15
//                                                         ⌃ enclosing_range_end local 13
                  append("${transaction.fullIdentity(col)}=")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(transaction)
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity().
//                                                   ^^^ reference local 14
                  registerArgument(col, value)
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                                 ^^^ reference local 14
//                                      ^^^^^ reference local 15
              }
  
//                       ⌄ enclosing_range_start local 16
              where?.let {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().(where)
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^ definition local 16 3:13
//                         display_name it
//                         documentation ```kotlin\nit: Op<Boolean>\n```
                  +" WHERE "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                  +it
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                 ^^ reference local 16
              }
//            ⌃ enclosing_range_end local 16
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().
      override fun upsert(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().
//                        display_name upsert
//                        documentation ```kotlin\npublic open override fun upsert(table: Table, data: List<Pair<Column<*>, Any?>>, expression: String, onUpdate: List<Pair<Column<*>, Any?>>, keyColumns: List<Column<*>>, where: Op<Boolean>?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(table)
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(table)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(data)
          data: List<Pair<Column<*>, Any?>>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(data)
//             display_name data
//             documentation ```kotlin\ndata: List<Pair<Column<*>, Any?>>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(data)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(expression)
          expression: String,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: String\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(onUpdate)
          onUpdate: List<Pair<Column<*>, Any?>>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: List<Pair<Column<*>, Any?>>\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(onUpdate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(keyColumns)
          keyColumns: List<Column<*>>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(keyColumns)
//                   display_name keyColumns
//                   documentation ```kotlin\nkeyColumns: List<Column<*>>\n```
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(keyColumns)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(where)
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (keyColumns.isNotEmpty()) {
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(keyColumns)
//                       ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
              transaction.throwUnsupportedException("MySQL doesn't support specifying conflict keys in UPSERT clause")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          if (where != null) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(where)
              transaction.throwUnsupportedException("MySQL doesn't support WHERE in UPSERT clause")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
  
          return with(QueryBuilder(true)) {
//               ^^^^ reference semanticdb maven . . kotlin/with().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
              +insert(false, table, data.unzip().first, expression, transaction)
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(table)
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(data)
//                                       ^^^^^ reference semanticdb maven . . kotlin/collections/unzip(+1).
//                                               ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                               ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(expression)
//                                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(transaction)
              if (isUpsertAliasSupported(transaction.db.dialect)) {
//                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#isUpsertAliasSupported().
//                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(transaction)
//                                                   ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                   ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
                  +" AS NEW"
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              }
  
              +" ON DUPLICATE KEY UPDATE "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                ⌄ enclosing_range_start local 17
//                                 ⌄ enclosing_range_start local 18
//                                                 ⌄ enclosing_range_start local 19
              onUpdate.appendTo { (columnToUpdate, updateExpression) ->
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(onUpdate)
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 17
//                                                                   display_name <destruct>
//                                                                   documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                 ^^^^^^^^^^^^^^ reference local 17
//                                 ^^^^^^^^^^^^^^ definition local 18
//                                                display_name columnToUpdate
//                                                documentation ```kotlin\nlocal val columnToUpdate: Column<*>\n```
//                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                 ^^^^^^^^^^^^^^^^ reference local 17
//                                                 ^^^^^^^^^^^^^^^^ definition local 19
//                                                                  display_name updateExpression
//                                                                  documentation ```kotlin\nlocal val updateExpression: Any?\n```
//                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                              ⌃ enclosing_range_end local 18
//                                                                ⌃ enclosing_range_end local 19
//                                                                 ⌃ enclosing_range_end local 17
                  append("${transaction.identity(columnToUpdate)}=")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().(transaction)
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                               ^^^^^^^^^^^^^^ reference local 18
                  registerArgument(columnToUpdate, updateExpression)
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                                 ^^^^^^^^^^^^^^ reference local 18
//                                                 ^^^^^^^^^^^^^^^^ reference local 19
              }
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).
      override fun delete(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).
//                        display_name delete
//                        documentation ```kotlin\npublic open override fun delete(ignore: Boolean, targets: Join, targetTables: List<Table>, where: Op<Boolean>?, limit: Int?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(ignore)
          ignore: Boolean,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(ignore)
//               display_name ignore
//               documentation ```kotlin\nignore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(ignore)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(targets)
          targets: Join,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(targets)
//                display_name targets
//                documentation ```kotlin\ntargets: Join\n```
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(targets)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(targetTables)
          targetTables: List<Table>,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(targetTables)
//                     display_name targetTables
//                     documentation ```kotlin\ntargetTables: List<Table>\n```
//                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(targetTables)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(where)
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(limit)
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(limit)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (limit != null) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(limit)
              transaction.throwUnsupportedException("${currentDialect.name} doesn't support LIMIT in DELETE from join relation")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
          }
          return with(QueryBuilder(true)) {
//               ^^^^ reference semanticdb maven . . kotlin/with().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
              +"DELETE "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              if (ignore) {
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(ignore)
                  +"IGNORE "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              }
//                                    ⌄ enclosing_range_start local 20
              targetTables.appendTo { target ->
//            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(targetTables)
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                    ^^^^^^ definition local 20
//                                           display_name target
//                                           documentation ```kotlin\ntarget: Table\n```
//                                         ⌃ enclosing_range_end local 20
//                      ⌄ enclosing_range_start local 21
                  when (target) {
//                      ^^^^^^ reference local 20
//                      ^^^^^^ definition local 21
//                             display_name <when-subject>
//                             documentation ```kotlin\nlocal val <when-subject>: Table\n```
//                           ⌃ enclosing_range_end local 21
                      is Alias<*> -> +target.alias
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#
//                                   ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                    ^^^^^^ reference local 20
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#alias.
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getAlias().
                      else -> target.describe(transaction, this)
//                            ^^^^^^ reference local 20
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().
//                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(transaction)
                  }
              }
              +" FROM "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              targets.describe(transaction, this)
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(targets)
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(transaction)
//                       ⌄ enclosing_range_start local 22
              where?.let {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).(where)
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^ definition local 22 3:13
//                         display_name it
//                         documentation ```kotlin\nit: Op<Boolean>\n```
                  +" WHERE "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                  +it
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                 ^^ reference local 22
              }
//            ⌃ enclosing_range_end local 22
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insertValue().
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insertValue().(columnName)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insertValue().(queryBuilder)
      override fun insertValue(columnName: String, queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insertValue().
//                             display_name insertValue
//                             documentation ```kotlin\npublic open override fun insertValue(columnName: String, queryBuilder: QueryBuilder): Unit\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insertValue().
//                             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insertValue().(columnName)
//                                        display_name columnName
//                                        documentation ```kotlin\ncolumnName: String\n```
//                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insertValue().(queryBuilder)
//                                                              display_name queryBuilder
//                                                              documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insertValue().(columnName)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insertValue().(queryBuilder)
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insertValue().(queryBuilder)
              if (isUpsertAliasSupported(currentDialect)) {
//                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#isUpsertAliasSupported().
//                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
                  +"NEW.$columnName"
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insertValue().(columnName)
              } else {
                  +"VALUES($columnName)"
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insertValue().(columnName)
              }
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insertValue().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#isUpsertAliasSupported().
//                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#isUpsertAliasSupported().(dialect)
//                                                                               ⌄ enclosing_range_start local 23
      open fun isUpsertAliasSupported(dialect: DatabaseDialect): Boolean = when (dialect) {
//             ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#isUpsertAliasSupported().
//                                    display_name isUpsertAliasSupported
//                                    documentation ```kotlin\npublic open fun isUpsertAliasSupported(dialect: DatabaseDialect): Boolean\n```
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#isUpsertAliasSupported().
//                                    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#isUpsertAliasSupported().(dialect)
//                                            display_name dialect
//                                            documentation ```kotlin\ndialect: DatabaseDialect\n```
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
//                                                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                               ^^^^^^^ definition local 23
//                                                                                       display_name <when-subject>
//                                                                                       documentation ```kotlin\nlocal val <when-subject>: DatabaseDialect\n```
//                                                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#isUpsertAliasSupported().(dialect)
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#isUpsertAliasSupported().(dialect)
//                                                                                     ⌃ enclosing_range_end local 23
          is MysqlDialect -> dialect.fullVersion >= "8.0.19"
//           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#isUpsertAliasSupported().(dialect)
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#fullVersion.
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getFullVersion().
//                                               ^^ reference semanticdb maven . . kotlin/String#compareTo().
          else -> false // H2_MySQL mode also uses this function provider & requires older unsupported version
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#isUpsertAliasSupported().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#time().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#time().[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#time().(expr)
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#time().(queryBuilder)
      override fun <T> time(expr: Expression<T>, queryBuilder: QueryBuilder) = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#time().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#time().
//                          display_name time
//                          documentation ```kotlin\npublic open override fun <T> time(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#time().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#time().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#time().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#time().[T]
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#time().(expr)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#time().(queryBuilder)
          append("SUBSTRING_INDEX(", expr, ", ' ', -1)")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#time().(expr)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#time().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().(size)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().(offset)
//                                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().(alreadyOrdered)
      override fun queryLimitAndOffset(size: Int?, offset: Long, alreadyOrdered: Boolean): String {
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().
//                                     display_name queryLimitAndOffset
//                                     documentation ```kotlin\npublic open override fun queryLimitAndOffset(size: Int?, offset: Long, alreadyOrdered: Boolean): String\n```
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().
//                                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().(size)
//                                          display_name size
//                                          documentation ```kotlin\nsize: Int?\n```
//                                           ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().(offset)
//                                                        display_name offset
//                                                        documentation ```kotlin\noffset: Long\n```
//                                                         ^^^^ reference semanticdb maven . . kotlin/Long#
//                                                               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().(alreadyOrdered)
//                                                                              display_name alreadyOrdered
//                                                                              documentation ```kotlin\nalreadyOrdered: Boolean\n```
//                                                                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().(size)
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().(offset)
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().(alreadyOrdered)
          @OptIn(InternalApi::class)
          if (size == null && offset > 0) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().(size)
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().(offset)
//                                   ^ reference semanticdb maven . . kotlin/Long#compareTo(+2).
              CoreTransactionManager.currentTransaction().throwUnsupportedException(
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
                  "${currentDialect.name} doesn't support OFFSET clause without LIMIT"
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
              )
          }
          return super.queryLimitAndOffset(size, offset, alreadyOrdered)
//                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().
//                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().(size)
//                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().(offset)
//                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().(alreadyOrdered)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#`<init>`().
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion# 2:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#`<init>`(). 2:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): MysqlFunctionProvider.Companion\n```
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#INSTANCE.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#getINSTANCE().
          internal val INSTANCE = MysqlFunctionProvider()
//                     ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#INSTANCE.
//                              display_name INSTANCE
//                              documentation ```kotlin\ninternal final val INSTANCE: MysqlFunctionProvider\n```
//                     ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#getINSTANCE().
//                              display_name INSTANCE
//                              documentation ```kotlin\ninternal get(): MysqlFunctionProvider\n```
//                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#`<init>`().
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#INSTANCE.
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#getINSTANCE().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#`<init>`().
  /**
   * MySQL dialect implementation.
   */
  open class MysqlDialect : VendorDialect(dialectName, MysqlDataTypeProvider.INSTANCE, MysqlFunctionProvider.INSTANCE) {
//           ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                        display_name MysqlDialect
//                        documentation ```kotlin\npublic open class MysqlDialect : VendorDialect\n```\n\n----\n\n\n MySQL dialect implementation.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
//           ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#`<init>`().
//                        display_name MysqlDialect
//                        documentation ```kotlin\npublic constructor(): MysqlDialect\n```\n\n----\n\n\n MySQL dialect implementation.\n
//                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
//                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#Companion#INSTANCE.
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#Companion#getINSTANCE().
//                                                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#INSTANCE.
//                                                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#Companion#getINSTANCE().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isMysql8.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getIsMysql8().
      @OptIn(InternalApi::class)
      internal val isMysql8: Boolean by lazy {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getIsMysql8().
//                          display_name isMysql8
//                          documentation ```kotlin\ninternal get(): Boolean\n```
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isMysql8.
//                          display_name isMysql8
//                          documentation ```kotlin\n@OptIn(...) internal final val isMysql8: Boolean\n```
//                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                      ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                      ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 2:5
//                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getIsMysql8(). 2:5
//                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isMysql8. 2:5
          CoreTransactionManager.currentTransaction().db.version.covers("8.0")
//                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getVersion().
//                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#version.
//                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isMysql8.
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getIsMysql8().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#fullVersion.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getFullVersion().
      @OptIn(InternalApi::class)
      internal val fullVersion: String by lazy {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#fullVersion.
//                             display_name fullVersion
//                             documentation ```kotlin\n@OptIn(...) internal final val fullVersion: String\n```
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getFullVersion().
//                             display_name fullVersion
//                             documentation ```kotlin\ninternal get(): String\n```
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                        ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                        ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 2:5
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#fullVersion. 2:5
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getFullVersion(). 2:5
          CoreTransactionManager.currentTransaction().db.fullVersion
//                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#fullVersion.
//                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getFullVersion().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#fullVersion.
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getFullVersion().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#supportsCreateSequence.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getSupportsCreateSequence().
      override val supportsCreateSequence: Boolean = false
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getSupportsCreateSequence().
//                                        display_name supportsCreateSequence
//                                        documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#supportsCreateSequence.
//                                        display_name supportsCreateSequence
//                                        documentation ```kotlin\npublic open override val supportsCreateSequence: Boolean\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#supportsCreateSequence.
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getSupportsCreateSequence().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#supportsTernaryAffectedRowValues.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getSupportsTernaryAffectedRowValues().
      override val supportsTernaryAffectedRowValues: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getSupportsTernaryAffectedRowValues().
//                                                  display_name supportsTernaryAffectedRowValues
//                                                  documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#supportsTernaryAffectedRowValues.
//                                                  display_name supportsTernaryAffectedRowValues
//                                                  documentation ```kotlin\npublic open override val supportsTernaryAffectedRowValues: Boolean\n```
//                                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#supportsTernaryAffectedRowValues.
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getSupportsTernaryAffectedRowValues().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#supportsSubqueryUnions.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getSupportsSubqueryUnions().
      override val supportsSubqueryUnions: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getSupportsSubqueryUnions().
//                                        display_name supportsSubqueryUnions
//                                        documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#supportsSubqueryUnions.
//                                        display_name supportsSubqueryUnions
//                                        documentation ```kotlin\npublic open override val supportsSubqueryUnions: Boolean\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#supportsSubqueryUnions.
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getSupportsSubqueryUnions().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#supportsOrderByNullsFirstLast.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getSupportsOrderByNullsFirstLast().
      override val supportsOrderByNullsFirstLast: Boolean = false
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getSupportsOrderByNullsFirstLast().
//                                               display_name supportsOrderByNullsFirstLast
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#supportsOrderByNullsFirstLast.
//                                               display_name supportsOrderByNullsFirstLast
//                                               documentation ```kotlin\npublic open override val supportsOrderByNullsFirstLast: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#supportsOrderByNullsFirstLast.
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getSupportsOrderByNullsFirstLast().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#supportsSetDefaultReferenceOption.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getSupportsSetDefaultReferenceOption().
      override val supportsSetDefaultReferenceOption: Boolean = false
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getSupportsSetDefaultReferenceOption().
//                                                   display_name supportsSetDefaultReferenceOption
//                                                   documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#supportsSetDefaultReferenceOption.
//                                                   display_name supportsSetDefaultReferenceOption
//                                                   documentation ```kotlin\npublic open override val supportsSetDefaultReferenceOption: Boolean\n```
//                                                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#supportsSetDefaultReferenceOption.
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getSupportsSetDefaultReferenceOption().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isFractionDateTimeSupported().
      /** Returns `true` if the MySQL database version is greater than or equal to 5.6. */
      @Suppress("MagicNumber")
      open fun isFractionDateTimeSupported(): Boolean {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isFractionDateTimeSupported().
//                                         display_name isFractionDateTimeSupported
//                                         documentation ```kotlin\n@Suppress(...) public open fun isFractionDateTimeSupported(): Boolean\n```\n\n----\n\n Returns `true` if the MySQL database version is greater than or equal to 5.6.
//                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#isFractionDateTimeSupported().
//                                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          @OptIn(InternalApi::class)
          return CoreTransactionManager.currentTransaction().db.version.covers(5, 6)
//                                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getVersion().
//                                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#version.
//                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+3).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isFractionDateTimeSupported().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isTimeZoneOffsetSupported().
      /** Returns `true` if a MySQL database is being used and its version is greater than or equal to 8.0. */
      open fun isTimeZoneOffsetSupported(): Boolean = isMysql8
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isTimeZoneOffsetSupported().
//                                       display_name isTimeZoneOffsetSupported
//                                       documentation ```kotlin\npublic open fun isTimeZoneOffsetSupported(): Boolean\n```\n\n----\n\n Returns `true` if a MySQL database is being used and its version is greater than or equal to 8.0.
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#isTimeZoneOffsetSupported().
//                                          ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getIsMysql8().
//                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isMysql8.
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isTimeZoneOffsetSupported().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#notAcceptableDefaults.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getNotAcceptableDefaults().
      protected val notAcceptableDefaults = mutableListOf("CURRENT_DATE()", "CURRENT_DATE")
//                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getNotAcceptableDefaults().
//                                        display_name notAcceptableDefaults
//                                        documentation ```kotlin\nprotected get(): MutableList<String>\n```
//                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#notAcceptableDefaults.
//                                        display_name notAcceptableDefaults
//                                        documentation ```kotlin\nprotected final val notAcceptableDefaults: MutableList<String>\n```
//                                          ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf(+1).
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#notAcceptableDefaults.
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getNotAcceptableDefaults().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isAllowedAsColumnDefault().
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isAllowedAsColumnDefault().(e)
      override fun isAllowedAsColumnDefault(e: Expression<*>): Boolean {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isAllowedAsColumnDefault().
//                                          display_name isAllowedAsColumnDefault
//                                          documentation ```kotlin\npublic open override fun isAllowedAsColumnDefault(e: Expression<*>): Boolean\n```
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#isAllowedAsColumnDefault().
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#isAllowedAsColumnDefault().
//                                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isAllowedAsColumnDefault().(e)
//                                            display_name e
//                                            documentation ```kotlin\ne: Expression<*>\n```
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isAllowedAsColumnDefault().(e)
          if (super.isAllowedAsColumnDefault(e)) return true
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#isAllowedAsColumnDefault().
//                                           ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isAllowedAsColumnDefault().(e)
          if (fullVersion >= "8.0.13") {
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#fullVersion.
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getFullVersion().
//                        ^^ reference semanticdb maven . . kotlin/String#compareTo().
              return true
          }
  
          // This check is quite optimistic, it will not allow to create a varchar columns with "CURRENT_DATE" default value for example
          // Comparing to the previous variant with white list of functions the new variant does not reject valid values,
          // it could be checked on the test UpsertTests::testUpsertWithColumnExpressions()
          return e.toString().trim() !in notAcceptableDefaults
//               ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isAllowedAsColumnDefault().(e)
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toString().
//                            ^^^^ reference semanticdb maven . . kotlin/text/trim(+5).
//                                   ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                                   ^^^ reference semanticdb maven . . kotlin/collections/MutableList#contains().
//                                       ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getNotAcceptableDefaults().
//                                       ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#notAcceptableDefaults.
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isAllowedAsColumnDefault().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createIndex().
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createIndex().(index)
      override fun createIndex(index: Index): String {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createIndex().
//                             display_name createIndex
//                             documentation ```kotlin\npublic open override fun createIndex(index: Index): String\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#createIndex().
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createIndex().(index)
//                                   display_name index
//                                   documentation ```kotlin\nindex: Index\n```
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#
//                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createIndex().(index)
          if (index.functions != null && !isMysql8) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createIndex().(index)
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
//                                       ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getIsMysql8().
//                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isMysql8.
              exposedLogger.warn(
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                                                                                   ⌄ enclosing_range_start local 24
                  "Functional index on ${index.table.tableName} using ${index.functions.joinToString { it.toString() }} can't be created in MySQL prior to 8.0"
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createIndex().(index)
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createIndex().(index)
//                                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//                                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
//                                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                                   ^^^^^^^^^^^^^^^^^ definition local 24
//                                                                                                                     display_name it
//                                                                                                                     documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                                                                     ^^ reference local 24
//                                                                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toString().
//                                                                                                                   ⌃ enclosing_range_end local 24
              )
              return ""
          }
          return super.createIndex(index)
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createIndex().(index)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createIndex().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().(tableName)
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().(indexName)
//                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().(isUnique)
//                                                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().(isPartialOrFunctional)
      override fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String =
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().
//                           display_name dropIndex
//                           documentation ```kotlin\npublic open override fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().
//                           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().(tableName)
//                                     display_name tableName
//                                     documentation ```kotlin\ntableName: String\n```
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().(indexName)
//                                                        display_name indexName
//                                                        documentation ```kotlin\nindexName: String\n```
//                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().(isUnique)
//                                                                          display_name isUnique
//                                                                          documentation ```kotlin\nisUnique: Boolean\n```
//                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                    ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().(isPartialOrFunctional)
//                                                                                                          display_name isPartialOrFunctional
//                                                                                                          documentation ```kotlin\nisPartialOrFunctional: Boolean\n```
//                                                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().(tableName)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().(indexName)
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().(isUnique)
//                                                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().(isPartialOrFunctional)
          "ALTER TABLE ${identifierManager.quoteIfNecessary(tableName)} DROP INDEX ${identifierManager.cutIfNecessaryAndQuote(indexName)}"
//                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().(tableName)
//                                                                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                                                                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                                                                                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                                                                                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().(indexName)
//                                                                                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#setSchema().
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#setSchema().(schema)
      override fun setSchema(schema: Schema): String = "USE ${schema.identifier}"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#setSchema().
//                           display_name setSchema
//                           documentation ```kotlin\npublic open override fun setSchema(schema: Schema): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#setSchema().
//                           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#setSchema().(schema)
//                                  display_name schema
//                                  documentation ```kotlin\nschema: Schema\n```
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
//                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#setSchema().(schema)
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getIdentifier().
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#identifier.
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#setSchema().(schema)
//                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#setSchema().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createSchema().
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createSchema().(schema)
      override fun createSchema(schema: Schema): String = buildString {
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createSchema().
//                              display_name createSchema
//                              documentation ```kotlin\npublic open override fun createSchema(schema: Schema): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createSchema().
//                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createSchema().(schema)
//                                     display_name schema
//                                     documentation ```kotlin\nschema: Schema\n```
//                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
//                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                        ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createSchema().(schema)
          append("CREATE SCHEMA IF NOT EXISTS ", schema.identifier)
//        ^^^^^^ reference semanticdb maven . . kotlin/text/append(+4).
//                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createSchema().(schema)
//                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getIdentifier().
//                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#identifier.
  
          if (schema.authorization != null) {
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createSchema().(schema)
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#authorization.
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getAuthorization().
              throw UnsupportedByDialectException(
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
                  "${currentDialect.name} do not have database owners. " +
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
                      "You can use GRANT to allow or deny rights on database.",
                  currentDialect
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
              )
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createSchema().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropSchema().
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropSchema().(schema)
//                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropSchema().(cascade)
      override fun dropSchema(schema: Schema, cascade: Boolean): String = "DROP SCHEMA IF EXISTS ${schema.identifier}"
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropSchema().
//                            display_name dropSchema
//                            documentation ```kotlin\npublic open override fun dropSchema(schema: Schema, cascade: Boolean): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropSchema().
//                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropSchema().(schema)
//                                   display_name schema
//                                   documentation ```kotlin\nschema: Schema\n```
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
//                                            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropSchema().(cascade)
//                                                    display_name cascade
//                                                    documentation ```kotlin\ncascade: Boolean\n```
//                                                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropSchema().(schema)
//                                                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getIdentifier().
//                                                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#identifier.
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropSchema().(schema)
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropSchema().(cascade)
//                                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropSchema().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#Companion#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#Companion#`<init>`().
      companion object : DialectNameProvider("MySQL")
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#Companion#
//                                                    display_name Companion
//                                                    documentation ```kotlin\npublic final companion object Companion : VendorDialect.DialectNameProvider\n```
//                                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#Companion#`<init>`().
//                                                    display_name Companion
//                                                    documentation ```kotlin\nprivate constructor(): MysqlDialect.Companion\n```
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#Companion#
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#Companion#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#`<init>`().
