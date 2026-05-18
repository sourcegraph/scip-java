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
  import org.jetbrains.exposed.v1.core.statements.MergeStatement
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#
  import org.jetbrains.exposed.v1.core.statements.MergeStatement.ClauseAction.DELETE
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement/ClauseAction/
//                                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement/ClauseAction/DELETE/
  import org.jetbrains.exposed.v1.core.statements.MergeStatement.ClauseAction.INSERT
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement/ClauseAction/
//                                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement/ClauseAction/INSERT/
  import org.jetbrains.exposed.v1.core.statements.MergeStatement.ClauseAction.UPDATE
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement/ClauseAction/
//                                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement/ClauseAction/UPDATE/
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
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#`<init>`().
  @Suppress("TooManyFunctions")
  internal object OracleDataTypeProvider : DataTypeProvider() {
//                ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#
//                                       display_name OracleDataTypeProvider
//                                       documentation ```kotlin\n@Suppress(...) internal final object OracleDataTypeProvider : DataTypeProvider\n```
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
//                ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#`<init>`().
//                                       display_name OracleDataTypeProvider
//                                       documentation ```kotlin\nprivate constructor(): OracleDataTypeProvider\n```
//                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#byteType().
      override fun byteType(): String = if (currentDialect.h2Mode == H2Dialect.H2CompatibilityMode.Oracle) {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#byteType().
//                          display_name byteType
//                          documentation ```kotlin\npublic open override fun byteType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#byteType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
          "TINYINT"
      } else {
          "NUMBER(3)"
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#byteType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ubyteType().
      override fun ubyteType(): String = "NUMBER(3)"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ubyteType().
//                           display_name ubyteType
//                           documentation ```kotlin\npublic open override fun ubyteType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ubyteType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ubyteType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#shortType().
      override fun shortType(): String = if (currentDialect.h2Mode == H2Dialect.H2CompatibilityMode.Oracle) {
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#shortType().
//                           display_name shortType
//                           documentation ```kotlin\npublic open override fun shortType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#shortType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
          "SMALLINT"
      } else {
          "NUMBER(5)"
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#shortType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ushortType().
      override fun ushortType(): String = "NUMBER(5)"
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ushortType().
//                            display_name ushortType
//                            documentation ```kotlin\npublic open override fun ushortType(): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ushortType().
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ushortType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#integerType().
      override fun integerType(): String = if (currentDialect.h2Mode == H2Dialect.H2CompatibilityMode.Oracle) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#integerType().
//                             display_name integerType
//                             documentation ```kotlin\npublic open override fun integerType(): String\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerType().
//                                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
          "INTEGER"
      } else {
          "NUMBER(10)"
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#integerType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#integerAutoincType().
      override fun integerAutoincType(): String = integerType()
//                 ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#integerAutoincType().
//                                    display_name integerAutoincType
//                                    documentation ```kotlin\npublic open override fun integerAutoincType(): String\n```
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerAutoincType().
//                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#integerType().
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#integerAutoincType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uintegerType().
      override fun uintegerType(): String = "NUMBER(10)"
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uintegerType().
//                              display_name uintegerType
//                              documentation ```kotlin\npublic open override fun uintegerType(): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uintegerType().
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uintegerType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uintegerAutoincType().
      override fun uintegerAutoincType(): String = "NUMBER(10)"
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uintegerAutoincType().
//                                     display_name uintegerAutoincType
//                                     documentation ```kotlin\npublic open override fun uintegerAutoincType(): String\n```
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uintegerAutoincType().
//                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uintegerAutoincType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#longType().
      override fun longType(): String = if (currentDialect.h2Mode == H2Dialect.H2CompatibilityMode.Oracle) {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#longType().
//                          display_name longType
//                          documentation ```kotlin\npublic open override fun longType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#longType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
          "BIGINT"
      } else {
          "NUMBER(19)"
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#longType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#longAutoincType().
      override fun longAutoincType(): String = longType()
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#longAutoincType().
//                                 display_name longAutoincType
//                                 documentation ```kotlin\npublic open override fun longAutoincType(): String\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#longAutoincType().
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#longType().
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#longAutoincType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ulongType().
      override fun ulongType(): String = "NUMBER(20)"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ulongType().
//                           display_name ulongType
//                           documentation ```kotlin\npublic open override fun ulongType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ulongType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ulongAutoincType().
      override fun ulongAutoincType(): String = "NUMBER(20)"
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ulongAutoincType().
//                                  display_name ulongAutoincType
//                                  documentation ```kotlin\npublic open override fun ulongAutoincType(): String\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongAutoincType().
//                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ulongAutoincType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#varcharType().
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#varcharType().(colLength)
      override fun varcharType(colLength: Int): String = "VARCHAR2($colLength CHAR)"
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#varcharType().
//                             display_name varcharType
//                             documentation ```kotlin\npublic open override fun varcharType(colLength: Int): String\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#varcharType().
//                             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#varcharType().(colLength)
//                                       display_name colLength
//                                       documentation ```kotlin\ncolLength: Int\n```
//                                        ^^^ reference semanticdb maven . . kotlin/Int#
//                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#varcharType().(colLength)
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#varcharType().(colLength)
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#varcharType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#textType().
      override fun textType(): String = "CLOB"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#textType().
//                          display_name textType
//                          documentation ```kotlin\npublic open override fun textType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#textType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#textType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#mediumTextType().
      override fun mediumTextType(): String = textType()
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#mediumTextType().
//                                display_name mediumTextType
//                                documentation ```kotlin\npublic open override fun mediumTextType(): String\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#mediumTextType().
//                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#textType().
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#mediumTextType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#largeTextType().
      override fun largeTextType(): String = textType()
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#largeTextType().
//                               display_name largeTextType
//                               documentation ```kotlin\npublic open override fun largeTextType(): String\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#largeTextType().
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#textType().
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#largeTextType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#timeType().
      override fun timeType(): String = dateTimeType()
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#timeType().
//                          display_name timeType
//                          documentation ```kotlin\npublic open override fun timeType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#timeType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#dateTimeType().
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#timeType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#binaryType().
      override fun binaryType(): String {
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#binaryType().
//                            display_name binaryType
//                            documentation ```kotlin\npublic open override fun binaryType(): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType().
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
          exposedLogger.error("Binary type is unsupported for Oracle. Please use blob column type instead.")
//        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                      ^^^^^ reference semanticdb maven . . org/slf4j/Logger#error().
          error("Binary type is unsupported for Oracle. Please use blob column type instead.")
//        ^^^^^ reference semanticdb maven . . kotlin/error().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#binaryType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#binaryType(+1).
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#binaryType(+1).(length)
      override fun binaryType(length: Int): String {
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#binaryType(+1).
//                            display_name binaryType
//                            documentation ```kotlin\npublic open override fun binaryType(length: Int): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType(+1).
//                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#binaryType(+1).(length)
//                                   display_name length
//                                   documentation ```kotlin\nlength: Int\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Int#
//                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#binaryType(+1).(length)
          @Suppress("MagicNumber")
          return if (length < 2000) "RAW($length)" else binaryType()
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#binaryType(+1).(length)
//                          ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#binaryType(+1).(length)
//                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#binaryType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#binaryType(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uuidType().
      override fun uuidType(): String {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uuidType().
//                          display_name uuidType
//                          documentation ```kotlin\npublic open override fun uuidType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
          return if ((currentDialect as? H2Dialect)?.h2Mode == H2Dialect.H2CompatibilityMode.Oracle) {
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode().
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode.
//                                                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
              "UUID"
          } else {
              "RAW(16)"
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uuidType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uuidToDB().
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uuidToDB().(value)
      override fun uuidToDB(value: UUID): Any {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uuidToDB().
//                          display_name uuidToDB
//                          documentation ```kotlin\npublic open override fun uuidToDB(value: UUID): Any\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidToDB().
//                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uuidToDB().(value)
//                                display_name value
//                                documentation ```kotlin\nvalue: UUID\n```
//                                 ^^^^ reference semanticdb maven jdk 11 java/util/UUID#
//                                        ^^^ reference semanticdb maven . . kotlin/Any#
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uuidToDB().(value)
          return if ((currentDialect as? H2Dialect)?.h2Mode == H2Dialect.H2CompatibilityMode.Oracle) {
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode().
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode.
//                                                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
              H2DataTypeProvider.uuidToDB(value)
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#uuidToDB().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uuidToDB().(value)
          } else {
              super.uuidToDB(value)
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidToDB().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uuidToDB().(value)
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uuidToDB().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#dateTimeType().
      override fun dateTimeType(): String = "TIMESTAMP"
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#dateTimeType().
//                              display_name dateTimeType
//                              documentation ```kotlin\npublic open override fun dateTimeType(): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#dateTimeType().
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#dateTimeType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanType().
      override fun booleanType(): String = "CHAR(1)"
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanType().
//                             display_name booleanType
//                             documentation ```kotlin\npublic open override fun booleanType(): String\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanType().
//                                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanType().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanToStatementString().
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanToStatementString().(bool)
      override fun booleanToStatementString(bool: Boolean) = if (bool) "1" else "0"
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanToStatementString().
//                                          display_name booleanToStatementString
//                                          documentation ```kotlin\npublic open override fun booleanToStatementString(bool: Boolean): String\n```
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanToStatementString().
//                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanToStatementString().(bool)
//                                               display_name bool
//                                               documentation ```kotlin\nbool: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanToStatementString().(bool)
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanToStatementString().(bool)
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanToStatementString().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanFromStringToBoolean().
//                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanFromStringToBoolean().(value)
      override fun booleanFromStringToBoolean(value: String): Boolean = try {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanFromStringToBoolean().
//                                            display_name booleanFromStringToBoolean
//                                            documentation ```kotlin\npublic open override fun booleanFromStringToBoolean(value: String): Boolean\n```
//                                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanFromStringToBoolean().
//                                            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanFromStringToBoolean().(value)
//                                                  display_name value
//                                                  documentation ```kotlin\nvalue: String\n```
//                                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanFromStringToBoolean().(value)
          value.toLong() != 0L
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanFromStringToBoolean().(value)
//              ^^^^^^ reference semanticdb maven . . kotlin/text/toLong().
//             ⌄ enclosing_range_start local 0
      } catch (ex: NumberFormatException) {
//             ^^ definition local 0
//                display_name ex
//                documentation ```kotlin\nex: {kotlin/NumberFormatException=} NumberFormatException\n```
//                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/NumberFormatException#
//                                     ⌃ enclosing_range_end local 0
          @Suppress("SwallowedException")
          try {
              value.lowercase().toBooleanStrict()
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanFromStringToBoolean().(value)
//                  ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/toBooleanStrict().
//                 ⌄ enclosing_range_start local 1
          } catch (ex: IllegalArgumentException) {
//                 ^^ definition local 1
//                    display_name ex
//                    documentation ```kotlin\nex: {kotlin/IllegalArgumentException=} IllegalArgumentException\n```
//                     ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalArgumentException#
//                                            ⌃ enclosing_range_end local 1
              error("Unexpected value of type Boolean: $value")
//            ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanFromStringToBoolean().(value)
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanFromStringToBoolean().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#jsonType().
      override fun jsonType(): String = "VARCHAR2(4000)"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#jsonType().
//                          display_name jsonType
//                          documentation ```kotlin\npublic open override fun jsonType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#jsonType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#jsonType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#hexToDb().
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#hexToDb().(hexString)
      override fun hexToDb(hexString: String): String = "HEXTORAW('$hexString')"
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#hexToDb().
//                         display_name hexToDb
//                         documentation ```kotlin\npublic open override fun hexToDb(hexString: String): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#hexToDb().
//                         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#hexToDb().(hexString)
//                                   display_name hexString
//                                   documentation ```kotlin\nhexString: String\n```
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#hexToDb().(hexString)
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#hexToDb().(hexString)
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#hexToDb().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#`<init>`().
  internal object OracleFunctionProvider : FunctionProvider() {
//                ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#
//                                       display_name OracleFunctionProvider
//                                       documentation ```kotlin\ninternal final object OracleFunctionProvider : FunctionProvider\n```\n\n----\n\n\n SQL function that generates a random value uniformly distributed between 0 (inclusive) and 1 (exclusive).\n\n **Note:** Oracle ignores the [seed]. You have to use the `dbms_random.seed` function manually.\n
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
//                ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#`<init>`().
//                                       display_name OracleFunctionProvider
//                                       documentation ```kotlin\nprivate constructor(): OracleFunctionProvider\n```\n\n----\n\n\n SQL function that generates a random value uniformly distributed between 0 (inclusive) and 1 (exclusive).\n\n **Note:** Oracle ignores the [seed]. You have to use the `dbms_random.seed` function manually.\n
//                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#random().
      /**
       * SQL function that generates a random value uniformly distributed between 0 (inclusive) and 1 (exclusive).
       *
       * **Note:** Oracle ignores the [seed]. You have to use the `dbms_random.seed` function manually.
       */
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#random().(seed)
      override fun random(seed: Int?): String = "dbms_random.value"
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#random().
//                        display_name random
//                        documentation ```kotlin\npublic open override fun random(seed: Int?): String\n```\n\n----\n\n\n SQL function that generates a random value uniformly distributed between 0 (inclusive) and 1 (exclusive).\n\n **Note:** Oracle ignores the [seed]. You have to use the `dbms_random.seed` function manually.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#random().
//                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#random().(seed)
//                             display_name seed
//                             documentation ```kotlin\nseed: Int?\n```
//                              ^^^^ reference semanticdb maven . . kotlin/Int#
//                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#random().(seed)
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#random().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#charLength().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#charLength().[T]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#charLength().(expr)
//                                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#charLength().(queryBuilder)
      override fun <T : String?> charLength(expr: Expression<T>, queryBuilder: QueryBuilder) = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#charLength().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#charLength().
//                                          display_name charLength
//                                          documentation ```kotlin\npublic open override fun <T : String?> charLength(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().
//                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#charLength().(expr)
//                                               display_name expr
//                                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#charLength().(queryBuilder)
//                                                                            display_name queryBuilder
//                                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#charLength().(queryBuilder)
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#charLength().[T]
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#charLength().(expr)
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#charLength().(queryBuilder)
          append("LENGTH(", expr, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#charLength().(expr)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#charLength().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().[T]
      override fun <T : String?> substring(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().
//                                         display_name substring
//                                         documentation ```kotlin\npublic open override fun <T : String?> substring(expr: Expression<T>, start: Expression<Int>, length: Expression<Int>, builder: QueryBuilder, prefix: String): Unit\n```
//                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(expr)
          expr: Expression<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(expr)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(start)
          start: Expression<Int>,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(start)
//              display_name start
//              documentation ```kotlin\nstart: Expression<Int>\n```
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(start)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(length)
          length: Expression<Int>,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(length)
//               display_name length
//               documentation ```kotlin\nlength: Expression<Int>\n```
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(length)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(builder)
          builder: QueryBuilder,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(builder)
//                display_name builder
//                documentation ```kotlin\nbuilder: QueryBuilder\n```
//                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(builder)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(prefix)
          prefix: String
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(prefix)
//               display_name prefix
//               documentation ```kotlin\nprefix: String\n```
//                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(prefix)
      ): Unit = super.substring(expr, start, length, builder, "SUBSTR")
//       ^^^^ reference semanticdb maven . . kotlin/Unit#
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(expr)
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(start)
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(length)
//                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().(builder)
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().
      override fun concat(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().
//                        display_name concat
//                        documentation ```kotlin\npublic open override fun concat(separator: String, queryBuilder: QueryBuilder, vararg expr: Expression<*>): Unit\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().(separator)
          separator: String,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().(separator)
//                  display_name separator
//                  documentation ```kotlin\nseparator: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().(separator)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().(queryBuilder)
          queryBuilder: QueryBuilder,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().(queryBuilder)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().(expr)
          vararg expr: Expression<*>
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().(expr)
//                    display_name expr
//                    documentation ```kotlin\nvararg expr: Expression<*>\n```
//                     ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().(expr)
      ): Unit = queryBuilder {
//       ^^^^ reference semanticdb maven . . kotlin/Unit#
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().(queryBuilder)
          if (separator == "") {
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().(separator)
//                                              ⌄ enclosing_range_start local 2
              expr.appendTo(separator = " || ") { +it }
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().(expr)
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                                              ^^^^^^^ definition local 2
//                                                      display_name it
//                                                      documentation ```kotlin\nit: CapturedType(out Expression<*>)\n```
//                                                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                                 ^^ reference local 2
//                                                    ⌃ enclosing_range_end local 2
          } else {
//                                                              ⌄ enclosing_range_start local 3
              expr.appendTo(separator = " || '$separator' || ") { +it }
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().(expr)
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().(separator)
//                                                              ^^^^^^^ definition local 3
//                                                                      display_name it
//                                                                      documentation ```kotlin\nit: CapturedType(out Expression<*>)\n```
//                                                                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                                                 ^^ reference local 3
//                                                                    ⌃ enclosing_range_end local 3
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().[T]
      override fun <T : String?> groupConcat(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().
//                                           display_name groupConcat
//                                           documentation ```kotlin\npublic open override fun <T : String?> groupConcat(expr: GroupConcat<T>, queryBuilder: QueryBuilder): Unit\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().(expr)
          expr: GroupConcat<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: GroupConcat<T>\n```
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().(expr)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().(queryBuilder)
      ): Unit = queryBuilder {
//       ^^^^ reference semanticdb maven . . kotlin/Unit#
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().(queryBuilder)
//        ⌄ enclosing_range_start local 4
          @OptIn(InternalApi::class)
          val tr = CoreTransactionManager.currentTransaction()
//            ^^ definition local 4
//               display_name tr
//               documentation ```kotlin\n@OptIn(...) local val tr: Transaction\n```
//                                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                           ⌃ enclosing_range_end local 4
          if (expr.distinct) tr.throwUnsupportedException("Oracle doesn't support DISTINCT in LISTAGG")
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().(expr)
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#distinct.
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getDistinct().
//                           ^^ reference local 4
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          if (expr.orderBy.size > 1) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().(expr)
//                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
//                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//                         ^^^^ reference semanticdb maven . . kotlin/Array#getSize().
//                         ^^^^ reference semanticdb maven . . kotlin/Array#size.
//                              ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
              tr.throwUnsupportedException("Oracle supports only single column in ORDER BY clause in LISTAGG")
//            ^^ reference local 4
//               ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          append("LISTAGG(")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr.expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().(expr)
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#expr.
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getExpr().
//                            ⌄ enclosing_range_start local 5
          expr.separator?.let {
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().(expr)
//             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getSeparator().
//             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#separator.
//                        ^^^ reference semanticdb maven . . kotlin/let().
//                            ^ definition local 5 2:9
//                              display_name it
//                              documentation ```kotlin\nit: String\n```
              append(", '$it'")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                        ^^ reference local 5
          }
//        ⌃ enclosing_range_end local 5
          +")"
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                           ⌄ enclosing_range_start local 6
//                                            ⌄ enclosing_range_start local 7
//                                                 ⌄ enclosing_range_start local 8
          expr.orderBy.singleOrNull()?.let { (col, order) ->
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().(expr)
//             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
//             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//                     ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull().
//                                     ^^^ reference semanticdb maven . . kotlin/let().
//                                           ^^^^^^^^^^^^ definition local 6
//                                                        display_name <destruct>
//                                                        documentation ```kotlin\n<destruct>: Pair<Expression<*>, SortOrder>\n```
//                                            ^^^ reference local 6
//                                            ^^^ definition local 7
//                                                display_name col
//                                                documentation ```kotlin\nlocal val col: Expression<*>\n```
//                                            ^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                 ^^^^^ reference local 6
//                                                 ^^^^^ definition local 8
//                                                       display_name order
//                                                       documentation ```kotlin\nlocal val order: SortOrder\n```
//                                                 ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                              ⌃ enclosing_range_end local 7
//                                                     ⌃ enclosing_range_end local 8
//                                                      ⌃ enclosing_range_end local 6
              append(" WITHIN GROUP (ORDER BY ", col, " ", order.name, ")")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                               ^^^ reference local 7
//                                                         ^^^^^ reference local 8
//                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#getName().
//                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#name.
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().[T]
      override fun <T : String?> locate(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().
//                                      display_name locate
//                                      documentation ```kotlin\npublic open override fun <T : String?> locate(queryBuilder: QueryBuilder, expr: Expression<T>, substring: String): Unit\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().(queryBuilder)
          queryBuilder: QueryBuilder,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().(queryBuilder)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().(expr)
          expr: Expression<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().(expr)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().(substring)
          substring: String
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().(substring)
//                  display_name substring
//                  documentation ```kotlin\nsubstring: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().(substring)
      ) = queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().(queryBuilder)
          append("INSTR(", expr, ",\'", substring, "\')")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().(expr)
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().(substring)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#date().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#date().[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#date().(expr)
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#date().(queryBuilder)
      override fun <T> date(expr: Expression<T>, queryBuilder: QueryBuilder) = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#date().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#date().
//                          display_name date
//                          documentation ```kotlin\npublic open override fun <T> date(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#date().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#date().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#date().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#date().[T]
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#date().(expr)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#date().(queryBuilder)
          append("CAST(", expr, " AS DATE)")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#date().(expr)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#date().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#time().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#time().[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#time().(expr)
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#time().(queryBuilder)
      override fun <T> time(expr: Expression<T>, queryBuilder: QueryBuilder) = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#time().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#time().
//                          display_name time
//                          documentation ```kotlin\npublic open override fun <T> time(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#time().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#time().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#time().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#time().[T]
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#time().(expr)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#time().(queryBuilder)
          append("('1970-01-01 ' || TO_CHAR(", expr, ", 'HH24:MI:SS.FF6'))")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#time().(expr)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#time().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#year().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#year().[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#year().(expr)
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#year().(queryBuilder)
      override fun <T> year(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#year().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#year().
//                          display_name year
//                          documentation ```kotlin\npublic open override fun <T> year(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#year().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#year().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                            ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#year().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#year().[T]
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#year().(expr)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#year().(queryBuilder)
          append("Extract(YEAR FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#year().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#year().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#month().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#month().[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#month().(expr)
//                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#month().(queryBuilder)
      override fun <T> month(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#month().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#month().
//                           display_name month
//                           documentation ```kotlin\npublic open override fun <T> month(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().
//                           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#month().(expr)
//                                display_name expr
//                                documentation ```kotlin\nexpr: Expression<T>\n```
//                                 ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#month().(queryBuilder)
//                                                             display_name queryBuilder
//                                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#month().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#month().[T]
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#month().(expr)
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#month().(queryBuilder)
          append("Extract(MONTH FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#month().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#month().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#day().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#day().[T]
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#day().(expr)
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#day().(queryBuilder)
      override fun <T> day(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#day().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#day().
//                         display_name day
//                         documentation ```kotlin\npublic open override fun <T> day(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().
//                         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#day().(expr)
//                              display_name expr
//                              documentation ```kotlin\nexpr: Expression<T>\n```
//                               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#day().(queryBuilder)
//                                                           display_name queryBuilder
//                                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#day().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#day().[T]
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#day().(expr)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#day().(queryBuilder)
          append("Extract(DAY FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#day().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#day().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#hour().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#hour().[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#hour().(expr)
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#hour().(queryBuilder)
      override fun <T> hour(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#hour().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#hour().
//                          display_name hour
//                          documentation ```kotlin\npublic open override fun <T> hour(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#hour().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#hour().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                            ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#hour().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#hour().[T]
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#hour().(expr)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#hour().(queryBuilder)
          append("Extract(HOUR FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#hour().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#hour().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#minute().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#minute().[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#minute().(expr)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#minute().(queryBuilder)
      override fun <T> minute(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#minute().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#minute().
//                            display_name minute
//                            documentation ```kotlin\npublic open override fun <T> minute(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().
//                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#minute().(expr)
//                                 display_name expr
//                                 documentation ```kotlin\nexpr: Expression<T>\n```
//                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#minute().(queryBuilder)
//                                                              display_name queryBuilder
//                                                              documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                              ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#minute().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#minute().[T]
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#minute().(expr)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#minute().(queryBuilder)
          append("Extract(MINUTE FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#minute().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#minute().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#second().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#second().[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#second().(expr)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#second().(queryBuilder)
      override fun <T> second(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#second().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#second().
//                            display_name second
//                            documentation ```kotlin\npublic open override fun <T> second(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().
//                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#second().(expr)
//                                 display_name expr
//                                 documentation ```kotlin\nexpr: Expression<T>\n```
//                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#second().(queryBuilder)
//                                                              display_name queryBuilder
//                                                              documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                              ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#second().(queryBuilder)
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#second().[T]
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#second().(expr)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#second().(queryBuilder)
          append("Extract(SECOND FROM ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#second().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#second().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().[T]
      override fun <T> jsonExtract(
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                     ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().
//                                 display_name jsonExtract
//                                 documentation ```kotlin\npublic open override fun <T> jsonExtract(expression: Expression<T>, vararg path: String, toScalar: Boolean, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(expression)
          expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(path)
          vararg path: String,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(path)
//                    display_name path
//                    documentation ```kotlin\nvararg path: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/Array#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(path)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(toScalar)
          toScalar: Boolean,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(toScalar)
//                 display_name toScalar
//                 documentation ```kotlin\ntoScalar: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(toScalar)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(jsonType)
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(jsonType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(queryBuilder)
      ) {
          @OptIn(InternalApi::class)
          if (path.size > 1) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(path)
//                 ^^^^ reference semanticdb maven . . kotlin/Array#getSize().
//                 ^^^^ reference semanticdb maven . . kotlin/Array#size.
//                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
              CoreTransactionManager.currentTransaction().throwUnsupportedException("Oracle does not support multiple JSON path arguments")
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(queryBuilder)
              append(if (toScalar) "JSON_VALUE" else "JSON_QUERY")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(toScalar)
              append("(", expression, ", ")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(expression)
              append("'$", path.firstOrNull() ?: "", "'")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().(path)
//                              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull().
              append(")")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().
      override fun jsonExists(
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().
//                            display_name jsonExists
//                            documentation ```kotlin\npublic open override fun jsonExists(expression: Expression<*>, vararg path: String, optional: String?, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(expression)
          expression: Expression<*>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<*>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(path)
          vararg path: String,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(path)
//                    display_name path
//                    documentation ```kotlin\nvararg path: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/Array#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(path)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(optional)
          optional: String?,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(optional)
//                 display_name optional
//                 documentation ```kotlin\noptional: String?\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(optional)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(jsonType)
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(jsonType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(queryBuilder)
      ) {
          @OptIn(InternalApi::class)
          if (path.size > 1) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(path)
//                 ^^^^ reference semanticdb maven . . kotlin/Array#getSize().
//                 ^^^^ reference semanticdb maven . . kotlin/Array#size.
//                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
              CoreTransactionManager.currentTransaction().throwUnsupportedException("Oracle does not support multiple JSON path arguments")
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(queryBuilder)
              append("JSON_EXISTS(", expression, ", ")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(expression)
              append("'$", path.firstOrNull() ?: "", "'")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(path)
//                              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull().
//                          ⌄ enclosing_range_start local 9
              optional?.let {
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().(optional)
//                      ^^^ reference semanticdb maven . . kotlin/let().
//                          ^ definition local 9 2:13
//                            display_name it
//                            documentation ```kotlin\nit: String\n```
                  append(" $it")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                          ^^ reference local 9
              }
//            ⌃ enclosing_range_end local 9
              append(")")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().
      override fun update(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().
//                        display_name update
//                        documentation ```kotlin\npublic open override fun update(target: Table, columnsAndValues: List<Pair<Column<*>, Any?>>, limit: Int?, where: Op<Boolean>?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(target)
          target: Table,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(target)
//               display_name target
//               documentation ```kotlin\ntarget: Table\n```
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(target)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(columnsAndValues)
          columnsAndValues: List<Pair<Column<*>, Any?>>,
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(columnsAndValues)
//                         display_name columnsAndValues
//                         documentation ```kotlin\ncolumnsAndValues: List<Pair<Column<*>, Any?>>\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(columnsAndValues)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(limit)
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(limit)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(where)
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
//        ⌄ enclosing_range_start local 10
          val def = super.update(target, columnsAndValues, null, where, transaction)
//            ^^^ definition local 10
//                display_name def
//                documentation ```kotlin\nlocal val def: String\n```
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(target)
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(columnsAndValues)
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(where)
//                                                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(transaction)
//                                                                                 ⌃ enclosing_range_end local 10
          return def.appendLimitClause(limit, endsWithWhere = where != null)
//               ^^^ reference local 10
//                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(limit)
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().(where)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).
      override fun update(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).
//                        display_name update
//                        documentation ```kotlin\npublic open override fun update(targets: Join, columnsAndValues: List<Pair<Column<*>, Any?>>, limit: Int?, where: Op<Boolean>?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(targets)
          targets: Join,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(targets)
//                display_name targets
//                documentation ```kotlin\ntargets: Join\n```
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(targets)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(columnsAndValues)
          columnsAndValues: List<Pair<Column<*>, Any?>>,
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(columnsAndValues)
//                         display_name columnsAndValues
//                         documentation ```kotlin\ncolumnsAndValues: List<Pair<Column<*>, Any?>>\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(columnsAndValues)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(limit)
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(limit)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(where)
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(transaction)
      ): String = with(QueryBuilder(true)) {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                ^^^^ reference semanticdb maven . . kotlin/with().
//                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                             ⌄ enclosing_range_start local 11
          columnsAndValues.map { it.first.table }.distinct().singleOrNull()
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(columnsAndValues)
//                         ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                             ^^^^^^^^^^^^^^^^^^ definition local 11
//                                                display_name it
//                                                documentation ```kotlin\nit: Pair<Column<*>, Any?>\n```
//                               ^^ reference local 11
//                                  ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                  ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                ^^^^^^^^ reference semanticdb maven . . kotlin/collections/distinct(+9).
//                                                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull(+19).
//                                              ⌃ enclosing_range_end local 11
              ?: transaction.throwUnsupportedException("Oracle supports a join updates with a single table columns to update.")
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(transaction)
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          targets.checkJoinTypes(StatementType.UPDATE)
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(targets)
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().
//                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#UPDATE.
          +"UPDATE ("
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//        ⌄ enclosing_range_start local 12
//                                                       ⌄ enclosing_range_start local 13
          val columnsToSelect = columnsAndValues.flatMap {
//            ^^^^^^^^^^^^^^^ definition local 12
//                            display_name columnsToSelect
//                            documentation ```kotlin\nlocal val columnsToSelect: Map<Expression<out Any?>, it(IExpressionAlias<out Any?> & Expression<out Any?>)>\n```
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(columnsAndValues)
//                                               ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap(+10).
//                                                       ^ definition local 13 2:9
//                                                         display_name it
//                                                         documentation ```kotlin\nit: Pair<Column<*>, Any?>\n```
              listOfNotNull(it.first, it.second as? Expression<*>)
//            ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/listOfNotNull(+1).
//                          ^^ reference local 13
//                             ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                             ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                    ^^ reference local 13
//                                       ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                       ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                       ⌄ enclosing_range_start local 14
//                              ⌄ enclosing_range_start local 15
          }.mapIndexed { index, expression ->
//          ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mapIndexed(+9).
//                       ^^^^^ definition local 14
//                             display_name index
//                             documentation ```kotlin\nindex: Int\n```
//                              ^^^^^^^^^^ definition local 15
//                                         display_name expression
//                                         documentation ```kotlin\nexpression: Expression<out Any?>\n```
//        ⌃ enclosing_range_end local 13
//                           ⌃ enclosing_range_end local 14
//                                       ⌃ enclosing_range_end local 15
              expression to ((expression as? ExpressionWithColumnType<*>)?.alias("c$index") ?: expression.alias("c$index"))
//            ^^^^^^^^^^ reference local 15
//                       ^^ reference semanticdb maven . . kotlin/to().
//                            ^^^^^^^^^^ reference local 15
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+3).
//                                                                                  ^^^^^ reference local 14
//                                                                                             ^^^^^^^^^^ reference local 15
//                                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+2).
//                                                                                                                 ^^^^^ reference local 14
          }.toMap()
//          ^^^^^ reference semanticdb maven . . kotlin/collections/toMap().
//                ⌃ enclosing_range_end local 12
  
          // TODO check if it could be replaced with buildStatement
          // TODO The old version:
          // TODO val subQuery = targets.select(columnsToSelect.values.toList())
          // TODO        where?.let {
          // TODO            subQuery.adjustWhere { it }
          // TODO        }
          // TODO        subQuery.prepareSQL(this)
          // TODO        +") x"
          +"SELECT "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                        ⌄ enclosing_range_start local 16
          columnsToSelect.values.appendTo { +it }
//        ^^^^^^^^^^^^^^^ reference local 12
//                        ^^^^^^ reference semanticdb maven . . kotlin/collections/Map#getValues().
//                        ^^^^^^ reference semanticdb maven . . kotlin/collections/Map#values.
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                        ^^^^^^^ definition local 16
//                                                display_name it
//                                                documentation ```kotlin\nit: it(IExpressionAlias<out Any?> & Expression<out Any?>)\n```
//                                          ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                           ^^ reference local 16
//                                              ⌃ enclosing_range_end local 16
          +" FROM "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          @OptIn(InternalApi::class)
          targets.describe(CoreTransactionManager.currentTransaction(), this)
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(targets)
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().
//                                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                   ⌄ enclosing_range_start local 17
          where?.let {
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(where)
//               ^^^ reference semanticdb maven . . kotlin/let().
//                   ^ definition local 17 3:9
//                     display_name it
//                     documentation ```kotlin\nit: Op<Boolean>\n```
              +" WHERE "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              +it
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//             ^^ reference local 17
          }
//        ⌃ enclosing_range_end local 17
          +") x"
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
  
//                                                            ⌄ enclosing_range_start local 18
//                                                             ⌄ enclosing_range_start local 19
//                                                                  ⌄ enclosing_range_start local 20
          columnsAndValues.appendTo(this, prefix = " SET ") { (col, value) ->
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(columnsAndValues)
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                                            ^^^^^^^^^^^^ definition local 18
//                                                                         display_name <destruct>
//                                                                         documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                                             ^^^ reference local 18
//                                                             ^^^ definition local 19
//                                                                 display_name col
//                                                                 documentation ```kotlin\nlocal val col: Column<*>\n```
//                                                             ^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                                  ^^^^^ reference local 18
//                                                                  ^^^^^ definition local 20
//                                                                        display_name value
//                                                                        documentation ```kotlin\nlocal val value: Any?\n```
//                                                                  ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                               ⌃ enclosing_range_end local 19
//                                                                      ⌃ enclosing_range_end local 20
//                                                                       ⌃ enclosing_range_end local 18
//            ⌄ enclosing_range_start local 21
              val alias = columnsToSelect.getValue(col)
//                ^^^^^ definition local 21
//                      display_name alias
//                      documentation ```kotlin\nlocal val alias: it(IExpressionAlias<out Any?> & Expression<out Any?>)\n```
//                        ^^^^^^^^^^^^^^^ reference local 12
//                                        ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getValue().
//                                                 ^^^ reference local 19
//                                                    ⌃ enclosing_range_end local 21
              +alias.alias
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//             ^^^^^ reference local 21
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#alias.
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getAlias().
              +"="
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                           ⌄ enclosing_range_start local 22
              (value as? Expression<*>)?.let {
//             ^^^^^ reference local 20
//                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                       ^^^ reference semanticdb maven . . kotlin/let().
//                                           ^ definition local 22 2:13
//                                             display_name it
//                                             documentation ```kotlin\nit: Expression<*>\n```
                  +columnsToSelect.getValue(it).alias
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                 ^^^^^^^^^^^^^^^ reference local 12
//                                 ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getValue().
//                                          ^^ reference local 22
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#alias.
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getAlias().
              } ?: registerArgument(col, value)
//                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                                  ^^^ reference local 19
//                                       ^^^^^ reference local 20
//            ⌃ enclosing_range_end local 22
          }
  
//                   ⌄ enclosing_range_start local 23
          limit?.let {
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).(limit)
//               ^^^ reference semanticdb maven . . kotlin/let().
//                   ^ definition local 23 2:9
//                     display_name it
//                     documentation ```kotlin\nit: Int\n```
              +" WHERE ROWNUM <= $it"
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                ^^ reference local 23
          }
//        ⌃ enclosing_range_end local 23
  
          toString()
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().
      override fun upsert(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().
//                        display_name upsert
//                        documentation ```kotlin\npublic open override fun upsert(table: Table, data: List<Pair<Column<*>, Any?>>, expression: String, onUpdate: List<Pair<Column<*>, Any?>>, keyColumns: List<Column<*>>, where: Op<Boolean>?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(table)
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(table)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(data)
          data: List<Pair<Column<*>, Any?>>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(data)
//             display_name data
//             documentation ```kotlin\ndata: List<Pair<Column<*>, Any?>>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(data)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(expression)
          expression: String,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: String\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(onUpdate)
          onUpdate: List<Pair<Column<*>, Any?>>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: List<Pair<Column<*>, Any?>>\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(onUpdate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(keyColumns)
          keyColumns: List<Column<*>>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(keyColumns)
//                   display_name keyColumns
//                   documentation ```kotlin\nkeyColumns: List<Column<*>>\n```
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(keyColumns)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(where)
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
//        ⌄ enclosing_range_start local 24
          val statement = super.upsert(table, data, expression, onUpdate, keyColumns, where, transaction)
//            ^^^^^^^^^ definition local 24
//                      display_name statement
//                      documentation ```kotlin\nlocal val statement: String\n```
//                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(table)
//                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(data)
//                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(expression)
//                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(onUpdate)
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(keyColumns)
//                                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(where)
//                                                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(transaction)
//                                                                                                      ⌃ enclosing_range_end local 24
  
//        ⌄ enclosing_range_start local 25
//                                                                                                            ⌄ enclosing_range_start local 26
//                                                                                                             ⌄ enclosing_range_start local 27
//                                                                                                                     ⌄ enclosing_range_start local 28
          val dualTable = data.appendTo(QueryBuilder(true), prefix = "(SELECT ", postfix = " FROM DUAL) S") { (column, value) ->
//            ^^^^^^^^^ definition local 25
//                      display_name dualTable
//                      documentation ```kotlin\nlocal val dualTable: String\n```
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(data)
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                                                                                                            ^^^^^^^^^^^^^^^ definition local 26
//                                                                                                                            display_name <destruct>
//                                                                                                                            documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                                                                                             ^^^^^^ reference local 26
//                                                                                                             ^^^^^^ definition local 27
//                                                                                                                    display_name column
//                                                                                                                    documentation ```kotlin\nlocal val column: Column<*>\n```
//                                                                                                             ^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                                                                                     ^^^^^ reference local 26
//                                                                                                                     ^^^^^ definition local 28
//                                                                                                                           display_name value
//                                                                                                                           documentation ```kotlin\nlocal val value: Any?\n```
//                                                                                                                     ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                                                                                  ⌃ enclosing_range_end local 27
//                                                                                                                         ⌃ enclosing_range_end local 28
//                                                                                                                          ⌃ enclosing_range_end local 26
              registerArgument(column, value)
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                             ^^^^^^ reference local 27
//                                     ^^^^^ reference local 28
              +" AS "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              append(transaction.identity(column))
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().(transaction)
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                        ^^^^^^ reference local 27
          }.toString()
//          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
//                   ⌃ enclosing_range_end local 25
  
//        ⌄ enclosing_range_start local 29
//             ⌄ enclosing_range_start local 30
//                           ⌄ enclosing_range_start local 31
          val (leftReserved, rightReserved) = " USING " to " ON "
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 29
//                                                                display_name <destruct>
//                                                                documentation ```kotlin\nlocal val <destruct>: Pair<String, String>\n```
//             ^^^^^^^^^^^^ reference local 29
//             ^^^^^^^^^^^^ definition local 30
//                          display_name leftReserved
//                          documentation ```kotlin\nlocal val leftReserved: String\n```
//             ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                           ^^^^^^^^^^^^^ reference local 29
//                           ^^^^^^^^^^^^^ definition local 31
//                                         display_name rightReserved
//                                         documentation ```kotlin\nlocal val rightReserved: String\n```
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                      ^^ reference semanticdb maven . . kotlin/to().
//                        ⌃ enclosing_range_end local 30
//                                       ⌃ enclosing_range_end local 31
//                                                              ⌃ enclosing_range_end local 29
//        ⌄ enclosing_range_start local 32
          val leftBoundary = statement.indexOf(leftReserved) + leftReserved.length
//            ^^^^^^^^^^^^ definition local 32
//                         display_name leftBoundary
//                         documentation ```kotlin\nlocal val leftBoundary: Int\n```
//                           ^^^^^^^^^ reference local 24
//                                     ^^^^^^^ reference semanticdb maven . . kotlin/text/indexOf(+2).
//                                             ^^^^^^^^^^^^ reference local 30
//                                                           ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                                                             ^^^^^^^^^^^^ reference local 30
//                                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#getLength().
//                                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#length.
//                                                                               ⌃ enclosing_range_end local 32
//        ⌄ enclosing_range_start local 33
          val rightBoundary = statement.indexOf(rightReserved)
//            ^^^^^^^^^^^^^ definition local 33
//                          display_name rightBoundary
//                          documentation ```kotlin\nlocal val rightBoundary: Int\n```
//                            ^^^^^^^^^ reference local 24
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/text/indexOf(+2).
//                                              ^^^^^^^^^^^^^ reference local 31
//                                                           ⌃ enclosing_range_end local 33
          return statement.replaceRange(leftBoundary, rightBoundary, dualTable)
//               ^^^^^^^^^ reference local 24
//                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/replaceRange(+1).
//                                      ^^^^^^^^^^^^ reference local 32
//                                                    ^^^^^^^^^^^^^ reference local 33
//                                                                   ^^^^^^^^^ reference local 25
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().
      override fun delete(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().
//                        display_name delete
//                        documentation ```kotlin\npublic open override fun delete(ignore: Boolean, table: Table, where: String?, limit: Int?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(ignore)
          ignore: Boolean,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(ignore)
//               display_name ignore
//               documentation ```kotlin\nignore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(ignore)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(table)
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(table)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(where)
          where: String?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(where)
//              display_name where
//              documentation ```kotlin\nwhere: String?\n```
//               ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(limit)
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(limit)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
//        ⌄ enclosing_range_start local 34
          val def = super.delete(ignore, table, where, null, transaction)
//            ^^^ definition local 34
//                display_name def
//                documentation ```kotlin\nlocal val def: String\n```
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(ignore)
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(table)
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(where)
//                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(transaction)
//                                                                      ⌃ enclosing_range_end local 34
          return def.appendLimitClause(limit, endsWithWhere = where != null)
//               ^^^ reference local 34
//                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(limit)
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().(where)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().
//                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().(limit)
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().(endsWithWhere)
      private fun String.appendLimitClause(limit: Int?, endsWithWhere: Boolean): String {
//                       ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().
//                                         display_name appendLimitClause
//                                         documentation ```kotlin\nprivate final fun String.appendLimitClause(limit: Int?, endsWithWhere: Boolean): String\n```
//                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().(limit)
//                                               display_name limit
//                                               documentation ```kotlin\nlimit: Int?\n```
//                                                ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().(endsWithWhere)
//                                                                    display_name endsWithWhere
//                                                                    documentation ```kotlin\nendsWithWhere: Boolean\n```
//                                                                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().(limit)
//                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().(endsWithWhere)
          return when {
              limit != null && endsWithWhere -> "$this AND ROWNUM <= $limit"
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().(limit)
//                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().(endsWithWhere)
//                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().(limit)
              limit != null -> "$this WHERE ROWNUM <= $limit"
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().(limit)
//                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().(limit)
              else -> this
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#appendLimitClause().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).
      override fun delete(
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).
//                        display_name delete
//                        documentation ```kotlin\npublic open override fun delete(ignore: Boolean, targets: Join, targetTables: List<Table>, where: Op<Boolean>?, limit: Int?, transaction: Transaction): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(ignore)
          ignore: Boolean,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(ignore)
//               display_name ignore
//               documentation ```kotlin\nignore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(ignore)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(targets)
          targets: Join,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(targets)
//                display_name targets
//                documentation ```kotlin\ntargets: Join\n```
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(targets)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(targetTables)
          targetTables: List<Table>,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(targetTables)
//                     display_name targetTables
//                     documentation ```kotlin\ntargetTables: List<Table>\n```
//                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(targetTables)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(where)
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(limit)
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(limit)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (ignore) {
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(ignore)
              transaction.throwUnsupportedException("Oracle doesn't support IGNORE in DELETE from join relation")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
//        ⌄ enclosing_range_start local 35
          val tableToDelete = targetTables.singleOrNull()
//            ^^^^^^^^^^^^^ definition local 35
//                          display_name tableToDelete
//                          documentation ```kotlin\nlocal val tableToDelete: Table\n```
//                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(targetTables)
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull(+19).
              ?: transaction.throwUnsupportedException(
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(transaction)
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
                  "Oracle doesn't support DELETE from join relation with multiple tables to delete from"
              )
//            ⌃ enclosing_range_end local 35
          targets.checkJoinTypes(StatementType.DELETE)
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(targets)
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().
//                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#DELETE.
  
          // TODO the same as above
          @OptIn(InternalApi::class)
          return with(QueryBuilder(true)) {
//               ^^^^ reference semanticdb maven . . kotlin/with().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
              +"DELETE (SELECT "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                           ⌄ enclosing_range_start local 36
              tableToDelete.columns.appendTo { +it }
//            ^^^^^^^^^^^^^ reference local 35
//                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                           ^^^^^^^ definition local 36
//                                                   display_name it
//                                                   documentation ```kotlin\nit: Column<*>\n```
//                                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                              ^^ reference local 36
//                                                 ⌃ enclosing_range_end local 36
              +" FROM "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              targets.describe(CoreTransactionManager.currentTransaction(), this)
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(targets)
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().
//                                                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                       ⌄ enclosing_range_start local 37
              where?.let {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(where)
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^ definition local 37 3:13
//                         display_name it
//                         documentation ```kotlin\nit: Op<Boolean>\n```
                  +" WHERE "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                  +it
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                 ^^ reference local 37
              }
//            ⌃ enclosing_range_end local 37
              +") x"
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                       ⌄ enclosing_range_start local 38
              limit?.let {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).(limit)
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^ definition local 38 2:13
//                         display_name it
//                         documentation ```kotlin\nit: Int\n```
                  +" WHERE ROWNUM <= $it"
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                    ^^ reference local 38
              }
//            ⌃ enclosing_range_end local 38
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().(size)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().(offset)
//                                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().(alreadyOrdered)
      override fun queryLimitAndOffset(size: Int?, offset: Long, alreadyOrdered: Boolean): String = buildString {
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().
//                                     display_name queryLimitAndOffset
//                                     documentation ```kotlin\npublic open override fun queryLimitAndOffset(size: Int?, offset: Long, alreadyOrdered: Boolean): String\n```
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().
//                                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().(size)
//                                          display_name size
//                                          documentation ```kotlin\nsize: Int?\n```
//                                           ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().(offset)
//                                                        display_name offset
//                                                        documentation ```kotlin\noffset: Long\n```
//                                                         ^^^^ reference semanticdb maven . . kotlin/Long#
//                                                               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().(alreadyOrdered)
//                                                                              display_name alreadyOrdered
//                                                                              documentation ```kotlin\nalreadyOrdered: Boolean\n```
//                                                                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                                  ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().(size)
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().(offset)
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().(alreadyOrdered)
          if (offset > 0) {
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().(offset)
//                   ^ reference semanticdb maven . . kotlin/Long#compareTo(+2).
              append("OFFSET $offset ROWS")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().(offset)
          }
//                  ⌄ enclosing_range_start local 39
          size?.let {
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().(size)
//              ^^^ reference semanticdb maven . . kotlin/let().
//                  ^ definition local 39 3:9
//                    display_name it
//                    documentation ```kotlin\nit: Int\n```
              if (offset > 0) append(" ")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().(offset)
//                       ^ reference semanticdb maven . . kotlin/Long#compareTo(+2).
//                            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              append("FETCH FIRST $size ROWS ONLY")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().(size)
          }
//        ⌃ enclosing_range_end local 39
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().
      override fun explain(
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().
//                         display_name explain
//                         documentation ```kotlin\npublic open override fun explain(analyze: Boolean, options: String?, internalStatement: String, transaction: Transaction): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().(analyze)
          analyze: Boolean,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().(analyze)
//                display_name analyze
//                documentation ```kotlin\nanalyze: Boolean\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().(analyze)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().(options)
          options: String?,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().(options)
//                display_name options
//                documentation ```kotlin\noptions: String?\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().(options)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().(internalStatement)
          internalStatement: String,
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().(internalStatement)
//                          display_name internalStatement
//                          documentation ```kotlin\ninternalStatement: String\n```
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().(internalStatement)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          transaction.throwUnsupportedException(
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().(transaction)
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
              "EXPLAIN queries are not currently supported for Oracle. Please log a YouTrack feature extension request."
          )
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(dest)
//                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(source)
//                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(transaction)
//                                                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(clauses)
//                                                                                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(on)
      override fun merge(dest: Table, source: Table, transaction: Transaction, clauses: List<MergeStatement.Clause>, on: Op<Boolean>?): String {
//                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().
//                       display_name merge
//                       documentation ```kotlin\npublic open override fun merge(dest: Table, source: Table, transaction: Transaction, clauses: List<MergeStatement.Clause>, on: Op<Boolean>?): String\n```
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().
//                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(dest)
//                            display_name dest
//                            documentation ```kotlin\ndest: Table\n```
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(source)
//                                           display_name source
//                                           documentation ```kotlin\nsource: Table\n```
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                   ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(transaction)
//                                                               display_name transaction
//                                                               documentation ```kotlin\ntransaction: Transaction\n```
//                                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                                             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(clauses)
//                                                                                     display_name clauses
//                                                                                     documentation ```kotlin\nclauses: List<MergeStatement.Clause>\n```
//                                                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                                                                   ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(on)
//                                                                                                                      display_name on
//                                                                                                                      documentation ```kotlin\non: Op<Boolean>?\n```
//                                                                                                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                                                                                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(dest)
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(source)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(transaction)
//                                                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(clauses)
//                                                                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(on)
          validateMergeCommandClauses(transaction, clauses)
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().
//                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(transaction)
//                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(clauses)
          return super.merge(dest, source, transaction, clauses, on)
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(dest)
//                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(source)
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(transaction)
//                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(clauses)
//                                                               ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().(on)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().
      override fun mergeSelect(
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().
//                             display_name mergeSelect
//                             documentation ```kotlin\npublic open override fun mergeSelect(dest: Table, source: QueryAlias, transaction: Transaction, clauses: List<MergeStatement.Clause>, on: Op<Boolean>, prepared: Boolean): String\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(dest)
          dest: Table,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(dest)
//             display_name dest
//             documentation ```kotlin\ndest: Table\n```
//              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(dest)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(source)
          source: QueryAlias,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(source)
//               display_name source
//               documentation ```kotlin\nsource: QueryAlias\n```
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(source)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(transaction)
          transaction: Transaction,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(transaction)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(clauses)
          clauses: List<MergeStatement.Clause>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(clauses)
//                display_name clauses
//                documentation ```kotlin\nclauses: List<MergeStatement.Clause>\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(clauses)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(on)
          on: Op<Boolean>,
//        ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(on)
//           display_name on
//           documentation ```kotlin\non: Op<Boolean>\n```
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(on)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(prepared)
          prepared: Boolean
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(prepared)
//                 display_name prepared
//                 documentation ```kotlin\nprepared: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(prepared)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          validateMergeCommandClauses(transaction, clauses)
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().
//                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(transaction)
//                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(clauses)
          return super.mergeSelect(dest, source, transaction, clauses, on, prepared)
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(dest)
//                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(source)
//                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(transaction)
//                                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(clauses)
//                                                                     ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(on)
//                                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().(prepared)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().
//                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(transaction)
//                                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(clauses)
  private fun validateMergeCommandClauses(transaction: Transaction, clauses: List<MergeStatement.Clause>) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().
//                                        display_name validateMergeCommandClauses
//                                        documentation ```kotlin\nprivate final fun validateMergeCommandClauses(transaction: Transaction, clauses: List<MergeStatement.Clause>): Unit\n```
//                                        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(transaction)
//                                                    display_name transaction
//                                                    documentation ```kotlin\ntransaction: Transaction\n```
//                                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(clauses)
//                                                                          display_name clauses
//                                                                          documentation ```kotlin\nclauses: List<MergeStatement.Clause>\n```
//                                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(transaction)
//                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(clauses)
      when {
//                      ⌄ enclosing_range_start local 40
          clauses.count { it.action == INSERT } > 1 ->
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(clauses)
//                ^^^^^ reference semanticdb maven . . kotlin/collections/count(+20).
//                      ^^^^^^^^^^^^^^^^^^^^^^^ definition local 40
//                                              display_name it
//                                              documentation ```kotlin\nit: MergeStatement.Clause\n```
//                        ^^ reference local 40
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#action.
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAction().
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#INSERT.
//                                              ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                            ⌃ enclosing_range_end local 40
              transaction.throwUnsupportedException("Multiple insert clauses are not supported by DB.")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                      ⌄ enclosing_range_start local 41
          clauses.count { it.action == UPDATE } > 1 ->
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(clauses)
//                ^^^^^ reference semanticdb maven . . kotlin/collections/count(+20).
//                      ^^^^^^^^^^^^^^^^^^^^^^^ definition local 41
//                                              display_name it
//                                              documentation ```kotlin\nit: MergeStatement.Clause\n```
//                        ^^ reference local 41
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#action.
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAction().
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#UPDATE.
//                                              ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                            ⌃ enclosing_range_end local 41
              transaction.throwUnsupportedException("Multiple update clauses are not supported by DB.")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                      ⌄ enclosing_range_start local 42
          clauses.count { it.action == DELETE } > 0 ->
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(clauses)
//                ^^^^^ reference semanticdb maven . . kotlin/collections/count(+20).
//                      ^^^^^^^^^^^^^^^^^^^^^^^ definition local 42
//                                              display_name it
//                                              documentation ```kotlin\nit: MergeStatement.Clause\n```
//                        ^^ reference local 42
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#action.
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAction().
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#DELETE.
//                                              ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                            ⌃ enclosing_range_end local 42
              transaction.throwUnsupportedException("Delete clauses are not supported by DB. You must use 'delete where' inside 'update' clause")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
      }
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#`<init>`().
  /**
   * Oracle dialect implementation.
   */
  open class OracleDialect : VendorDialect(dialectName, OracleDataTypeProvider, OracleFunctionProvider) {
//           ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                         display_name OracleDialect
//                         documentation ```kotlin\npublic open class OracleDialect : VendorDialect\n```\n\n----\n\n\n Oracle dialect implementation.\n
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
//           ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#`<init>`().
//                         display_name OracleDialect
//                         documentation ```kotlin\npublic constructor(): OracleDialect\n```\n\n----\n\n\n Oracle dialect implementation.\n
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsIfNotExists.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsIfNotExists().
      override val supportsIfNotExists: Boolean = false
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsIfNotExists().
//                                     display_name supportsIfNotExists
//                                     documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsIfNotExists.
//                                     display_name supportsIfNotExists
//                                     documentation ```kotlin\npublic open override val supportsIfNotExists: Boolean\n```
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsIfNotExists.
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsIfNotExists().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#needsSequenceToAutoInc.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getNeedsSequenceToAutoInc().
      override val needsSequenceToAutoInc: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getNeedsSequenceToAutoInc().
//                                        display_name needsSequenceToAutoInc
//                                        documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#needsSequenceToAutoInc.
//                                        display_name needsSequenceToAutoInc
//                                        documentation ```kotlin\npublic open override val needsSequenceToAutoInc: Boolean\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#needsSequenceToAutoInc.
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getNeedsSequenceToAutoInc().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#defaultReferenceOption.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getDefaultReferenceOption().
      override val defaultReferenceOption: ReferenceOption = ReferenceOption.NO_ACTION
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#defaultReferenceOption.
//                                        display_name defaultReferenceOption
//                                        documentation ```kotlin\npublic open override val defaultReferenceOption: ReferenceOption\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getDefaultReferenceOption().
//                                        display_name defaultReferenceOption
//                                        documentation ```kotlin\npublic get(): ReferenceOption\n```
//                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#NO_ACTION.
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#defaultReferenceOption.
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getDefaultReferenceOption().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#needsQuotesWhenSymbolsInNames.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getNeedsQuotesWhenSymbolsInNames().
      override val needsQuotesWhenSymbolsInNames: Boolean = false
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getNeedsQuotesWhenSymbolsInNames().
//                                               display_name needsQuotesWhenSymbolsInNames
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#needsQuotesWhenSymbolsInNames.
//                                               display_name needsQuotesWhenSymbolsInNames
//                                               documentation ```kotlin\npublic open override val needsQuotesWhenSymbolsInNames: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#needsQuotesWhenSymbolsInNames.
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getNeedsQuotesWhenSymbolsInNames().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsMultipleGeneratedKeys.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsMultipleGeneratedKeys().
      override val supportsMultipleGeneratedKeys: Boolean = false
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsMultipleGeneratedKeys().
//                                               display_name supportsMultipleGeneratedKeys
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsMultipleGeneratedKeys.
//                                               display_name supportsMultipleGeneratedKeys
//                                               documentation ```kotlin\npublic open override val supportsMultipleGeneratedKeys: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsMultipleGeneratedKeys.
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsMultipleGeneratedKeys().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsOnlyIdentifiersInGeneratedKeys.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsOnlyIdentifiersInGeneratedKeys().
      override val supportsOnlyIdentifiersInGeneratedKeys: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsOnlyIdentifiersInGeneratedKeys().
//                                                        display_name supportsOnlyIdentifiersInGeneratedKeys
//                                                        documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsOnlyIdentifiersInGeneratedKeys.
//                                                        display_name supportsOnlyIdentifiersInGeneratedKeys
//                                                        documentation ```kotlin\npublic open override val supportsOnlyIdentifiersInGeneratedKeys: Boolean\n```
//                                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsOnlyIdentifiersInGeneratedKeys.
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsOnlyIdentifiersInGeneratedKeys().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsDualTableConcept.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsDualTableConcept().
      override val supportsDualTableConcept: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsDualTableConcept().
//                                          display_name supportsDualTableConcept
//                                          documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsDualTableConcept.
//                                          display_name supportsDualTableConcept
//                                          documentation ```kotlin\npublic open override val supportsDualTableConcept: Boolean\n```
//                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsDualTableConcept.
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsDualTableConcept().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsOrderByNullsFirstLast.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsOrderByNullsFirstLast().
      override val supportsOrderByNullsFirstLast: Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsOrderByNullsFirstLast().
//                                               display_name supportsOrderByNullsFirstLast
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsOrderByNullsFirstLast.
//                                               display_name supportsOrderByNullsFirstLast
//                                               documentation ```kotlin\npublic open override val supportsOrderByNullsFirstLast: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsOrderByNullsFirstLast.
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsOrderByNullsFirstLast().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsOnUpdate.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsOnUpdate().
      override val supportsOnUpdate: Boolean = false
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsOnUpdate().
//                                  display_name supportsOnUpdate
//                                  documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsOnUpdate.
//                                  display_name supportsOnUpdate
//                                  documentation ```kotlin\npublic open override val supportsOnUpdate: Boolean\n```
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsOnUpdate.
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsOnUpdate().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsSetDefaultReferenceOption.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsSetDefaultReferenceOption().
      override val supportsSetDefaultReferenceOption: Boolean = false
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsSetDefaultReferenceOption().
//                                                   display_name supportsSetDefaultReferenceOption
//                                                   documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsSetDefaultReferenceOption.
//                                                   display_name supportsSetDefaultReferenceOption
//                                                   documentation ```kotlin\npublic open override val supportsSetDefaultReferenceOption: Boolean\n```
//                                                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsSetDefaultReferenceOption.
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsSetDefaultReferenceOption().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsRestrictReferenceOption.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsRestrictReferenceOption().
      // Preventing the deletion of a parent row if a child row references it is the default behaviour in Oracle.
      override val supportsRestrictReferenceOption: Boolean = false
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsRestrictReferenceOption().
//                                                 display_name supportsRestrictReferenceOption
//                                                 documentation ```kotlin\npublic get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsRestrictReferenceOption.
//                                                 display_name supportsRestrictReferenceOption
//                                                 documentation ```kotlin\npublic open override val supportsRestrictReferenceOption: Boolean\n```
//                                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#supportsRestrictReferenceOption.
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#getSupportsRestrictReferenceOption().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#isAllowedAsColumnDefault().
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#isAllowedAsColumnDefault().(e)
      override fun isAllowedAsColumnDefault(e: Expression<*>): Boolean = true
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#isAllowedAsColumnDefault().
//                                          display_name isAllowedAsColumnDefault
//                                          documentation ```kotlin\npublic open override fun isAllowedAsColumnDefault(e: Expression<*>): Boolean\n```
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#isAllowedAsColumnDefault().
//                                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#isAllowedAsColumnDefault().(e)
//                                            display_name e
//                                            documentation ```kotlin\ne: Expression<*>\n```
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#isAllowedAsColumnDefault().(e)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#isAllowedAsColumnDefault().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().(tableName)
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().(indexName)
//                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().(isUnique)
//                                                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().(isPartialOrFunctional)
      override fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String {
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().
//                           display_name dropIndex
//                           documentation ```kotlin\npublic open override fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().
//                           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().(tableName)
//                                     display_name tableName
//                                     documentation ```kotlin\ntableName: String\n```
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().(indexName)
//                                                        display_name indexName
//                                                        documentation ```kotlin\nindexName: String\n```
//                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().(isUnique)
//                                                                          display_name isUnique
//                                                                          documentation ```kotlin\nisUnique: Boolean\n```
//                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                    ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().(isPartialOrFunctional)
//                                                                                                          display_name isPartialOrFunctional
//                                                                                                          documentation ```kotlin\nisPartialOrFunctional: Boolean\n```
//                                                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().(tableName)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().(indexName)
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().(isUnique)
//                                                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().(isPartialOrFunctional)
          return "DROP INDEX ${identifierManager.cutIfNecessaryAndQuote(indexName)}"
//                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                               ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                                                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().(indexName)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#modifyColumn().
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#modifyColumn().(column)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#modifyColumn().(columnDiff)
      override fun modifyColumn(column: Column<*>, columnDiff: ColumnDiff): List<String> {
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#modifyColumn().
//                              display_name modifyColumn
//                              documentation ```kotlin\npublic open override fun modifyColumn(column: Column<*>, columnDiff: ColumnDiff): List<String>\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().
//                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#modifyColumn().(column)
//                                     display_name column
//                                     documentation ```kotlin\ncolumn: Column<*>\n```
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#modifyColumn().(columnDiff)
//                                                            display_name columnDiff
//                                                            documentation ```kotlin\ncolumnDiff: ColumnDiff\n```
//                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#modifyColumn().(column)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#modifyColumn().(columnDiff)
//        ⌄ enclosing_range_start local 43
//                                                                ⌄ enclosing_range_start local 44
          val result = super.modifyColumn(column, columnDiff).map {
//            ^^^^^^ definition local 43
//                   display_name result
//                   documentation ```kotlin\nlocal val result: List<String>\n```
//                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#modifyColumn().(column)
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#modifyColumn().(columnDiff)
//                                                            ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                                ^ definition local 44 2:9
//                                                                  display_name it
//                                                                  documentation ```kotlin\nit: String\n```
              it.replace("MODIFY COLUMN", "MODIFY")
//            ^^ reference local 44
//               ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
          }
//        ⌃ enclosing_range_end local 43
//        ⌃ enclosing_range_end local 44
          return if (!columnDiff.nullability) {
//                   ^ reference semanticdb maven . . kotlin/Boolean#not().
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#modifyColumn().(columnDiff)
//                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getNullability().
//                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#nullability.
//            ⌄ enclosing_range_start local 45
              val nullableState = if (column.columnType.nullable) "NULL " else "NOT NULL"
//                ^^^^^^^^^^^^^ definition local 45
//                              display_name nullableState
//                              documentation ```kotlin\nlocal val nullableState: String\n```
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#modifyColumn().(column)
//                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
//                                                                                      ⌃ enclosing_range_end local 45
//                       ⌄ enclosing_range_start local 46
              result.map {
//            ^^^^^^ reference local 43
//                   ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                       ^ definition local 46 2:13
//                         display_name it
//                         documentation ```kotlin\nit: String\n```
                  it.replace(nullableState, "")
//                ^^ reference local 46
//                   ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
//                           ^^^^^^^^^^^^^ reference local 45
              }
//            ⌃ enclosing_range_end local 46
          } else {
              result
//            ^^^^^^ reference local 43
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#modifyColumn().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createDatabase().
      @OptIn(InternalApi::class)
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createDatabase().(name)
      override fun createDatabase(name: String): String = "CREATE DATABASE ${name.inProperCase()}"
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createDatabase().
//                                display_name createDatabase
//                                documentation ```kotlin\n@OptIn(...) public open override fun createDatabase(name: String): String\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createDatabase().
//                                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createDatabase().(name)
//                                     display_name name
//                                     documentation ```kotlin\nname: String\n```
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createDatabase().(name)
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createDatabase().(name)
//                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createDatabase().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#listDatabases().
      override fun listDatabases(): String = error("This operation is not supported by Oracle dialect")
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#listDatabases().
//                               display_name listDatabases
//                               documentation ```kotlin\npublic open override fun listDatabases(): String\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#listDatabases().
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                           ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#listDatabases().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropDatabase().
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropDatabase().(name)
      override fun dropDatabase(name: String): String = "DROP DATABASE"
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropDatabase().
//                              display_name dropDatabase
//                              documentation ```kotlin\npublic open override fun dropDatabase(name: String): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropDatabase().
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropDatabase().(name)
//                                   display_name name
//                                   documentation ```kotlin\nname: String\n```
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropDatabase().(name)
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropDatabase().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#setSchema().
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#setSchema().(schema)
      override fun setSchema(schema: Schema): String = "ALTER SESSION SET CURRENT_SCHEMA = ${schema.identifier}"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#setSchema().
//                           display_name setSchema
//                           documentation ```kotlin\npublic open override fun setSchema(schema: Schema): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#setSchema().
//                           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#setSchema().(schema)
//                                  display_name schema
//                                  documentation ```kotlin\nschema: Schema\n```
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
//                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#setSchema().(schema)
//                                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getIdentifier().
//                                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#identifier.
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#setSchema().(schema)
//                                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#setSchema().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createSchema().
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createSchema().(schema)
      override fun createSchema(schema: Schema): String = buildString {
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createSchema().
//                              display_name createSchema
//                              documentation ```kotlin\npublic open override fun createSchema(schema: Schema): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createSchema().
//                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createSchema().(schema)
//                                     display_name schema
//                                     documentation ```kotlin\nschema: Schema\n```
//                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
//                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                        ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createSchema().(schema)
          if ((schema.quota == null) xor (schema.on == null)) {
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createSchema().(schema)
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getQuota().
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#quota.
//                                   ^^^ reference semanticdb maven . . kotlin/Boolean#xor().
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createSchema().(schema)
//                                               ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getOn().
//                                               ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#on.
              @Suppress("UseRequire")
              throw IllegalArgumentException("You must either provide both <quota> and <on> options or non of them")
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalArgumentException#`<init>`().
          }
  
          append("CREATE USER ", schema.identifier)
//        ^^^^^^ reference semanticdb maven . . kotlin/text/append(+4).
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createSchema().(schema)
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getIdentifier().
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#identifier.
          append(" IDENTIFIED BY ", schema.password)
//        ^^^^^^ reference semanticdb maven . . kotlin/text/append(+4).
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createSchema().(schema)
//                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getPassword().
//                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#password.
          appendIfNotNull(" DEFAULT TABLESPACE ", schema.defaultTablespace)
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().
//                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createSchema().(schema)
//                                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#defaultTablespace.
//                                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getDefaultTablespace().
          appendIfNotNull(" TEMPORARY TABLESPACE ", schema.temporaryTablespace)
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().
//                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createSchema().(schema)
//                                                         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getTemporaryTablespace().
//                                                         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#temporaryTablespace.
          appendIfNotNull(" QUOTA ", schema.quota)
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createSchema().(schema)
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getQuota().
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#quota.
          appendIfNotNull(" ON ", schema.on)
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createSchema().(schema)
//                                       ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getOn().
//                                       ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#on.
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#createSchema().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropSchema().
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropSchema().(schema)
//                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropSchema().(cascade)
      override fun dropSchema(schema: Schema, cascade: Boolean): String = buildString {
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropSchema().
//                            display_name dropSchema
//                            documentation ```kotlin\npublic open override fun dropSchema(schema: Schema, cascade: Boolean): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropSchema().
//                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropSchema().(schema)
//                                   display_name schema
//                                   documentation ```kotlin\nschema: Schema\n```
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
//                                            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropSchema().(cascade)
//                                                    display_name cascade
//                                                    documentation ```kotlin\ncascade: Boolean\n```
//                                                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                        ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropSchema().(schema)
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropSchema().(cascade)
          append("DROP USER ", schema.identifier)
//        ^^^^^^ reference semanticdb maven . . kotlin/text/append(+4).
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropSchema().(schema)
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getIdentifier().
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#identifier.
  
          if (cascade) {
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropSchema().(cascade)
              append(" CASCADE")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropSchema().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#Companion#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#Companion#`<init>`().
      companion object : DialectNameProvider("Oracle")
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#Companion#
//                                                     display_name Companion
//                                                     documentation ```kotlin\npublic final companion object Companion : VendorDialect.DialectNameProvider\n```
//                                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#Companion#`<init>`().
//                                                     display_name Companion
//                                                     documentation ```kotlin\nprivate constructor(): OracleDialect.Companion\n```
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#Companion#
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#Companion#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#`<init>`().
