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
  import org.jetbrains.exposed.v1.exceptions.UnsupportedByDialectException
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#
  import java.nio.ByteBuffer
//       ^^^^ reference semanticdb maven . . java/
//            ^^^ reference semanticdb maven . . java/nio/
//                ^^^^^^^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#
  import java.util.*
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/util/
  
  /**
   * Provides definitions for all the supported SQL data types.
   * By default, definitions from the SQL standard are provided but if a vendor doesn't support a specific type, or it is
   * implemented differently, the corresponding function should be overridden.
   */
  abstract class DataTypeProvider {
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
//                                display_name DataTypeProvider
//                                documentation ```kotlin\npublic abstract class DataTypeProvider : Any\n```\n\n----\n\n\n Provides definitions for all the supported SQL data types.\n By default, definitions from the SQL standard are provided but if a vendor doesn't support a specific type, or it is\n implemented differently, the corresponding function should be overridden.\n
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#`<init>`().
//                                display_name DataTypeProvider
//                                documentation ```kotlin\npublic constructor(): DataTypeProvider\n```\n\n----\n\n\n Provides definitions for all the supported SQL data types.\n By default, definitions from the SQL standard are provided but if a vendor doesn't support a specific type, or it is\n implemented differently, the corresponding function should be overridden.\n
      // Numeric types
  
      /** Numeric type for storing 1-byte integers. */
      open fun byteType(): String = "TINYINT"
//             ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#byteType().
//                      display_name byteType
//                      documentation ```kotlin\npublic open fun byteType(): String\n```\n\n----\n\n Numeric type for storing 1-byte integers.
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#byteType().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#byteType().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#byteType().
//                         ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Numeric type for storing 1-byte unsigned integers.
       *
       * **Note:** If the database being used is not MySQL, MariaDB, or SQL Server, this will represent the 2-byte
       * integer type.
       */
      open fun ubyteType(): String = "SMALLINT"
//             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ubyteType().
//                       display_name ubyteType
//                       documentation ```kotlin\npublic open fun ubyteType(): String\n```\n\n----\n\n Numeric type for storing 1-byte unsigned integers.\n\n **Note:** If the database being used is not MySQL, MariaDB, or SQL Server, this will represent the 2-byte\n integer type.\n
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ubyteType().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ubyteType().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#ubyteType().
//                          ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Numeric type for storing 2-byte integers. */
      open fun shortType(): String = "SMALLINT"
//             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#shortType().
//                       display_name shortType
//                       documentation ```kotlin\npublic open fun shortType(): String\n```\n\n----\n\n Numeric type for storing 2-byte integers.
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#shortType().
//                          ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Numeric type for storing 2-byte unsigned integers.
       *
       * **Note:** If the database being used is not MySQL or MariaDB, this will represent the 4-byte integer type.
       */
      open fun ushortType(): String = "INT"
//             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ushortType().
//                        display_name ushortType
//                        documentation ```kotlin\npublic open fun ushortType(): String\n```\n\n----\n\n Numeric type for storing 2-byte unsigned integers.\n\n **Note:** If the database being used is not MySQL or MariaDB, this will represent the 4-byte integer type.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ushortType().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ushortType().
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Numeric type for storing 4-byte integers. */
      open fun integerType(): String = "INT"
//             ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerType().
//                         display_name integerType
//                         documentation ```kotlin\npublic open fun integerType(): String\n```\n\n----\n\n Numeric type for storing 4-byte integers.
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#integerType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Numeric type for storing 4-byte unsigned integers.
       *
       * **Note:** If the database being used is not MySQL or MariaDB, this will represent the 8-byte integer type.
       */
      open fun uintegerType(): String = "BIGINT"
//             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uintegerType().
//                          display_name uintegerType
//                          documentation ```kotlin\npublic open fun uintegerType(): String\n```\n\n----\n\n Numeric type for storing 4-byte unsigned integers.\n\n **Note:** If the database being used is not MySQL or MariaDB, this will represent the 8-byte integer type.\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#uintegerType().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uintegerType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Numeric type for storing 4-byte integers, marked as auto-increment. */
      open fun integerAutoincType(): String = "INT AUTO_INCREMENT"
//             ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerAutoincType().
//                                display_name integerAutoincType
//                                documentation ```kotlin\npublic open fun integerAutoincType(): String\n```\n\n----\n\n Numeric type for storing 4-byte integers, marked as auto-increment.
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#integerAutoincType().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#integerAutoincType().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#integerAutoincType().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#integerAutoincType().
//                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Numeric type for storing 4-byte unsigned integers, marked as auto-increment.
       *
       * **Note:** If the database being used is not MySQL or MariaDB, this will represent the 8-byte integer type.
       */
      open fun uintegerAutoincType(): String = "BIGINT AUTO_INCREMENT"
//             ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uintegerAutoincType().
//                                 display_name uintegerAutoincType
//                                 documentation ```kotlin\npublic open fun uintegerAutoincType(): String\n```\n\n----\n\n Numeric type for storing 4-byte unsigned integers, marked as auto-increment.\n\n **Note:** If the database being used is not MySQL or MariaDB, this will represent the 8-byte integer type.\n
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#uintegerAutoincType().
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uintegerAutoincType().
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Numeric type for storing 8-byte integers. */
      open fun longType(): String = "BIGINT"
//             ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#longType().
//                      display_name longType
//                      documentation ```kotlin\npublic open fun longType(): String\n```\n\n----\n\n Numeric type for storing 8-byte integers.
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#longType().
//                         ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Numeric type for storing 8-byte unsigned integers. */
      open fun ulongType(): String = "NUMERIC(20)"
//             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongType().
//                       display_name ulongType
//                       documentation ```kotlin\npublic open fun ulongType(): String\n```\n\n----\n\n Numeric type for storing 8-byte unsigned integers.
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ulongType().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ulongType().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#ulongType().
//                          ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Numeric type for storing 8-byte integers, and marked as auto-increment. */
      open fun longAutoincType(): String = "BIGINT AUTO_INCREMENT"
//             ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#longAutoincType().
//                             display_name longAutoincType
//                             documentation ```kotlin\npublic open fun longAutoincType(): String\n```\n\n----\n\n Numeric type for storing 8-byte integers, and marked as auto-increment.
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#longAutoincType().
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#longAutoincType().
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#longAutoincType().
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#longAutoincType().
//                                ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Numeric type for storing 8-byte unsigned integers, marked as auto-increment. */
      open fun ulongAutoincType(): String = "NUMERIC(20) AUTO_INCREMENT"
//             ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongAutoincType().
//                              display_name ulongAutoincType
//                              documentation ```kotlin\npublic open fun ulongAutoincType(): String\n```\n\n----\n\n Numeric type for storing 8-byte unsigned integers, marked as auto-increment.
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#ulongAutoincType().
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#ulongAutoincType().
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#ulongAutoincType().
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#ulongAutoincType().
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#ulongAutoincType().
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Numeric type for storing 4-byte (single precision) floating-point numbers. */
      open fun floatType(): String = "FLOAT"
//             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#floatType().
//                       display_name floatType
//                       documentation ```kotlin\npublic open fun floatType(): String\n```\n\n----\n\n Numeric type for storing 4-byte (single precision) floating-point numbers.
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#floatType().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#floatType().
//                          ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Numeric type for storing 8-byte (double precision) floating-point numbers. */
      open fun doubleType(): String = "DOUBLE PRECISION"
//             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#doubleType().
//                        display_name doubleType
//                        documentation ```kotlin\npublic open fun doubleType(): String\n```\n\n----\n\n Numeric type for storing 8-byte (double precision) floating-point numbers.
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      // Character types
  
      /** Character type for storing strings of variable length up to a maximum. */
      open fun varcharType(colLength: Int): String = "VARCHAR($colLength)"
//             ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#varcharType().
//                         display_name varcharType
//                         documentation ```kotlin\npublic open fun varcharType(colLength: Int): String\n```\n\n----\n\n Character type for storing strings of variable length up to a maximum.
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#varcharType().
//                         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#varcharType().(colLength)
//                                   display_name colLength
//                                   documentation ```kotlin\ncolLength: Int\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Int#
//                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#varcharType().(colLength)
  
      /** Character type for storing strings of variable length.
       * Some database (postgresql) use the same data type name to provide virtually _unlimited_ length. */
      open fun textType(): String = "TEXT"
//             ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#textType().
//                      display_name textType
//                      documentation ```kotlin\npublic open fun textType(): String\n```\n\n----\n\n Character type for storing strings of variable length.\n Some database (postgresql) use the same data type name to provide virtually _unlimited_ length.
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#textType().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#textType().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#textType().
//                         ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Character type for storing strings of _medium_ length. */
      open fun mediumTextType(): String = "TEXT"
//             ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#mediumTextType().
//                            display_name mediumTextType
//                            documentation ```kotlin\npublic open fun mediumTextType(): String\n```\n\n----\n\n Character type for storing strings of _medium_ length.
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#mediumTextType().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#mediumTextType().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#mediumTextType().
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Character type for storing strings of variable and _large_ length. */
      open fun largeTextType(): String = "TEXT"
//             ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#largeTextType().
//                           display_name largeTextType
//                           documentation ```kotlin\npublic open fun largeTextType(): String\n```\n\n----\n\n Character type for storing strings of variable and _large_ length.
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#largeTextType().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#largeTextType().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#largeTextType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      // Binary data types
  
      /** Binary type for storing binary strings of variable and _unlimited_ length. */
      abstract fun binaryType(): String
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType().
//                            display_name binaryType
//                            documentation ```kotlin\npublic abstract fun binaryType(): String\n\n```\n\n----\n\n Binary type for storing binary strings of variable and _unlimited_ length.
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#binaryType().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#binaryType().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#binaryType().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#binaryType().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#binaryType().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#binaryType().
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Binary type for storing binary strings of a specific [length]. */
      open fun binaryType(length: Int): String = if (length == Int.MAX_VALUE) "VARBINARY(MAX)" else "VARBINARY($length)"
//             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType(+1).
//                        display_name binaryType
//                        documentation ```kotlin\npublic open fun binaryType(length: Int): String\n```\n\n----\n\n Binary type for storing binary strings of a specific [length].
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#binaryType(+1).
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#binaryType(+1).
//                        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType(+1).(length)
//                               display_name length
//                               documentation ```kotlin\nlength: Int\n```
//                                ^^^ reference semanticdb maven . . kotlin/Int#
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType(+1).(length)
//                                                                 ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                                 ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType(+1).(length)
  
      /** Binary type for storing BLOBs. */
      open fun blobType(): String = "BLOB"
//             ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#blobType().
//                      display_name blobType
//                      documentation ```kotlin\npublic open fun blobType(): String\n```\n\n----\n\n Binary type for storing BLOBs.
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#blobType().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#blobType().
//                         ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Binary type for storing [UUID]. */
      open fun uuidType(): String = "BINARY(16)"
//             ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidType().
//                      display_name uuidType
//                      documentation ```kotlin\npublic open fun uuidType(): String\n```\n\n----\n\n Binary type for storing [UUID].
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#uuidType().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uuidType().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#uuidType().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#uuidType().
//                         ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Returns a database-compatible object from the specified UUID [value]. */
      @Suppress("MagicNumber")
      open fun uuidToDB(value: UUID): Any =
//             ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidToDB().
//                      display_name uuidToDB
//                      documentation ```kotlin\n@Suppress(...) public open fun uuidToDB(value: UUID): Any\n```\n\n----\n\n Returns a database-compatible object from the specified UUID [value].
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#uuidToDB().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#uuidToDB().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#uuidToDB().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#uuidToDB().
//                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidToDB().(value)
//                            display_name value
//                            documentation ```kotlin\nvalue: UUID\n```
//                             ^^^^ reference semanticdb maven jdk 11 java/util/UUID#
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
          ByteBuffer.allocate(16).putLong(value.mostSignificantBits).putLong(value.leastSignificantBits).array()
//                   ^^^^^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#allocate().
//                                ^^^^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#putLong().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidToDB().(value)
//                                              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/UUID#getMostSignificantBits().
//                                              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/UUID#mostSignificantBits.
//                                                                   ^^^^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#putLong().
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidToDB().(value)
//                                                                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/UUID#getLeastSignificantBits().
//                                                                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/UUID#leastSignificantBits.
//                                                                                                       ^^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#array().
  
      // Date/Time types
  
      /** Data type for storing both date and time without a time zone. */
      open fun dateTimeType(): String = "DATETIME"
//             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#dateTimeType().
//                          display_name dateTimeType
//                          documentation ```kotlin\npublic open fun dateTimeType(): String\n```\n\n----\n\n Data type for storing both date and time without a time zone.
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#dateTimeType().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#dateTimeType().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#dateTimeType().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#dateTimeType().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#dateTimeType().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#dateTimeType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Data type for storing date and time without a time zone, represented as a 'timestamp' (not 'datetime'). */
      open fun timestampType(): String = dateTimeType()
//             ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#timestampType().
//                           display_name timestampType
//                           documentation ```kotlin\npublic open fun timestampType(): String\n```\n\n----\n\n Data type for storing date and time without a time zone, represented as a 'timestamp' (not 'datetime').
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#timestampType().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDataTypeProvider#timestampType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#dateTimeType().
  
      /** Data type for storing both date and time with a time zone. */
      open fun timestampWithTimeZoneType(): String = "TIMESTAMP WITH TIME ZONE"
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#timestampWithTimeZoneType().
//                                       display_name timestampWithTimeZoneType
//                                       documentation ```kotlin\npublic open fun timestampWithTimeZoneType(): String\n```\n\n----\n\n Data type for storing both date and time with a time zone.
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#timestampWithTimeZoneType().
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#timestampWithTimeZoneType().
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#timestampWithTimeZoneType().
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#timestampWithTimeZoneType().
//                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Time type for storing time without a time zone. */
      open fun timeType(): String = "TIME"
//             ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#timeType().
//                      display_name timeType
//                      documentation ```kotlin\npublic open fun timeType(): String\n```\n\n----\n\n Time type for storing time without a time zone.
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#timeType().
//                         ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Data type for storing date without time or a time zone. */
      open fun dateType(): String = "DATE"
//             ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#dateType().
//                      display_name dateType
//                      documentation ```kotlin\npublic open fun dateType(): String\n```\n\n----\n\n Data type for storing date without time or a time zone.
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#dateType().
//                         ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      // Boolean type
  
      /** Data type for storing boolean values. */
      open fun booleanType(): String = "BOOLEAN"
//             ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanType().
//                         display_name booleanType
//                         documentation ```kotlin\npublic open fun booleanType(): String\n```\n\n----\n\n Data type for storing boolean values.
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanType().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#booleanType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Returns the SQL representation of the specified [bool] value. */
      open fun booleanToStatementString(bool: Boolean): String = bool.toString().uppercase()
//             ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanToStatementString().
//                                      display_name booleanToStatementString
//                                      documentation ```kotlin\npublic open fun booleanToStatementString(bool: Boolean): String\n```\n\n----\n\n Returns the SQL representation of the specified [bool] value.
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanToStatementString().
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#booleanToStatementString().
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#booleanToStatementString().
//                                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanToStatementString().(bool)
//                                           display_name bool
//                                           documentation ```kotlin\nbool: Boolean\n```
//                                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanToStatementString().(bool)
//                                                                    ^^^^^^^^ reference semanticdb maven . . kotlin/Boolean#toString().
//                                                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/text/uppercase(+2).
  
      /** Returns the boolean value of the specified SQL [value]. */
      open fun booleanFromStringToBoolean(value: String): Boolean = value.toBoolean()
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanFromStringToBoolean().
//                                        display_name booleanFromStringToBoolean
//                                        documentation ```kotlin\npublic open fun booleanFromStringToBoolean(value: String): Boolean\n```\n\n----\n\n Returns the boolean value of the specified SQL [value].
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#booleanFromStringToBoolean().
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#booleanFromStringToBoolean().
//                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanFromStringToBoolean().(value)
//                                              display_name value
//                                              documentation ```kotlin\nvalue: String\n```
//                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                        ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanFromStringToBoolean().(value)
//                                                                        ^^^^^^^^^ reference semanticdb maven . . kotlin/text/toBoolean().
  
      // JSON types
  
      /** Data type for storing JSON in a non-binary text format. */
      open fun jsonType(): String = "JSON"
//             ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#jsonType().
//                      display_name jsonType
//                      documentation ```kotlin\npublic open fun jsonType(): String\n```\n\n----\n\n Data type for storing JSON in a non-binary text format.
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#jsonType().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#jsonType().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#jsonType().
//                         ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /** Data type for storing JSON in a decomposed binary format. */
      open fun jsonBType(): String =
//             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#jsonBType().
//                       display_name jsonBType
//                       documentation ```kotlin\npublic open fun jsonBType(): String\n```\n\n----\n\n Data type for storing JSON in a decomposed binary format.
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#jsonBType().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#jsonBType().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#jsonBType().
//                          ^^^^^^ reference semanticdb maven . . kotlin/String#
          throw UnsupportedByDialectException("This vendor does not support binary JSON data type", currentDialect)
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
//                                                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
  
      // Misc.
  
      /** Returns the SQL representation of the specified expression, for it to be used as a column default value. */
      open fun processForDefaultValue(e: Expression<*>): String = when {
//             ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                    display_name processForDefaultValue
//                                    documentation ```kotlin\npublic open fun processForDefaultValue(e: Expression<*>): String\n```\n\n----\n\n Returns the SQL representation of the specified expression, for it to be used as a column default value.
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#processForDefaultValue().
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#processForDefaultValue().
//                                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().(e)
//                                      display_name e
//                                      documentation ```kotlin\ne: Expression<*>\n```
//                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
          e is LiteralOp<*> -> (e.columnType as IColumnType<Any?>).valueAsDefaultString(e.value)
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().(e)
//                              ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().(e)
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueAsDefaultString().
//                                                                                      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().(e)
//                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getValue().
//                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#value.
          e is Function<*> -> "$e"
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().(e)
//                              ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().(e)
          currentDialect is MysqlDialect -> "$e"
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().(e)
          currentDialect is SQLServerDialect -> "$e"
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().(e)
          else -> "($e)"
//                   ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().(e)
      }
  
      /** Returns the SQL representation of the specified [expression], to be used in an ORDER BY clause. */
      open fun precessOrderByClause(queryBuilder: QueryBuilder, expression: Expression<*>, sortOrder: SortOrder) {
//             ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().
//                                  display_name precessOrderByClause
//                                  documentation ```kotlin\npublic open fun precessOrderByClause(queryBuilder: QueryBuilder, expression: Expression<*>, sortOrder: SortOrder): Unit\n```\n\n----\n\n Returns the SQL representation of the specified [expression], to be used in an ORDER BY clause.
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#precessOrderByClause().
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().
//                                  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().(queryBuilder)
//                                               display_name queryBuilder
//                                               documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().(expression)
//                                                                         display_name expression
//                                                                         documentation ```kotlin\nexpression: Expression<*>\n```
//                                                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().(sortOrder)
//                                                                                                   display_name sortOrder
//                                                                                                   documentation ```kotlin\nsortOrder: SortOrder\n```
//                                                                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#
          queryBuilder.append((expression as? IExpressionAlias<*>)?.alias ?: expression, " ", sortOrder.code)
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().(queryBuilder)
//                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().(expression)
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#alias.
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getAlias().
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().(expression)
//                                                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().(sortOrder)
//                                                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#code.
//                                                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#getCode().
      }
  
      /** Returns the hex-encoded value to be inserted into the database. */
      abstract fun hexToDb(hexString: String): String
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#hexToDb().
//                         display_name hexToDb
//                         documentation ```kotlin\npublic abstract fun hexToDb(hexString: String): String\n\n```\n\n----\n\n Returns the hex-encoded value to be inserted into the database.
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2DataTypeProvider#hexToDb().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDataTypeProvider#hexToDb().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDataTypeProvider#hexToDb().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDataTypeProvider#hexToDb().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#hexToDb().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDataTypeProvider#hexToDb().
//                         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#hexToDb().(hexString)
//                                   display_name hexString
//                                   documentation ```kotlin\nhexString: String\n```
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
  }
