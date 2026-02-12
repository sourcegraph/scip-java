  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  import org.jetbrains.exposed.v1.core.dao.id.EntityID
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
//                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
  import org.jetbrains.exposed.v1.core.dao.id.EntityIDFunctionProvider
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#
  import org.jetbrains.exposed.v1.core.dao.id.IdTable
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
//                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
  import org.jetbrains.exposed.v1.core.statements.api.ExposedBlob
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/
//                                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#
  import org.jetbrains.exposed.v1.core.statements.api.PreparedStatementApi
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/
//                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
  import org.jetbrains.exposed.v1.core.statements.api.RowApi
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#
  import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#
  import org.jetbrains.exposed.v1.core.vendors.*
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
  import java.io.InputStream
//       ^^^^ reference semanticdb maven . . java/
//            ^^ reference semanticdb maven . . java/io/
//               ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/InputStream#
  import java.math.BigDecimal
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/math/
//                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
  import java.math.BigInteger
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/math/
//                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigInteger#
  import java.math.MathContext
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/math/
//                 ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/MathContext#
  import java.math.RoundingMode
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/math/
//                 ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/RoundingMode#
  import java.nio.ByteBuffer
//       ^^^^ reference semanticdb maven . . java/
//            ^^^ reference semanticdb maven . . java/nio/
//                ^^^^^^^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#
  import java.sql.Blob
//       ^^^^ reference semanticdb maven . . java/
//            ^^^ reference semanticdb maven . . java/sql/
//                ^^^^ reference semanticdb maven jdk 11 java/sql/Blob#
  import java.sql.Clob
//       ^^^^ reference semanticdb maven . . java/
//            ^^^ reference semanticdb maven . . java/sql/
//                ^^^^ reference semanticdb maven jdk 11 java/sql/Clob#
  import java.util.*
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/util/
  import kotlin.reflect.KClass
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^^^^ reference semanticdb maven . . kotlin/reflect/
//                      ^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#
  import kotlin.reflect.full.isSubclassOf
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^^^^ reference semanticdb maven . . kotlin/reflect/
//                      ^^^^ reference semanticdb maven . . kotlin/reflect/full/
//                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/isSubclassOf().
  
  /**
   * Interface common to all column types.
   */
  @Suppress("TooManyFunctions")
  interface IColumnType<T> {
//          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                      display_name IColumnType
//                      documentation ```kotlin\n@Suppress(...) public abstract interface IColumnType<T> : Any\n```\n\n----\n\n\n Interface common to all column types.\n
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#[T]
//                        display_name FirTypeParameterSymbol T
//                        documentation ```kotlin\nT\n```
      /** Returns `true` if the column type is nullable, `false` otherwise. */
      var nullable: Boolean
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                 display_name nullable
//                 documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Returns `true` if the column type is nullable, `false` otherwise.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                 display_name nullable
//                 documentation ```kotlin\npublic abstract var nullable: Boolean\n```\n\n----\n\n Returns `true` if the column type is nullable, `false` otherwise.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
//                 display_name nullable
//                 documentation ```kotlin\npublic set(value: Boolean): Unit\n```\n\n----\n\n Returns `true` if the column type is nullable, `false` otherwise.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().(value)
//                 display_name value
//                 documentation ```kotlin\nvalue: Boolean\n```\n\n----\n\n Returns `true` if the column type is nullable, `false` otherwise.
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      /** Returns the SQL type of this column. */
      fun sqlType(): String
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
//                display_name sqlType
//                documentation ```kotlin\npublic abstract fun sqlType(): String\n\n```\n\n----\n\n Returns the SQL type of this column.
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sqlType().
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
  
      /**
       * Converts the specified [value] (from the database) to an object of the appropriated type, for this column type.
       * Default implementation returns the same instance.
       */
      fun valueFromDB(value: Any): T?
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueFromDB().
//                    display_name valueFromDB
//                    documentation ```kotlin\npublic abstract fun valueFromDB(value: Any): T?\n\n```\n\n----\n\n\n Converts the specified [value] (from the database) to an object of the appropriated type, for this column type.\n Default implementation returns the same instance.\n
//                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueFromDB().(value)
//                          display_name value
//                          documentation ```kotlin\nvalue: Any\n```
//                           ^^^ reference semanticdb maven . . kotlin/Any#
  
      /** Returns an object compatible with the database, from the specified [value], for this column type. */
      fun valueToDB(value: T?): Any? = value?.let(::notNullValueToDB)
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueToDB().
//                  display_name valueToDB
//                  documentation ```kotlin\npublic open fun valueToDB(value: T?): Any?\n```\n\n----\n\n Returns an object compatible with the database, from the specified [value], for this column type.
//                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueToDB().(value)
//                        display_name value
//                        documentation ```kotlin\nvalue: T?\n```
//                              ^^^^ reference semanticdb maven . . kotlin/Any#
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueToDB().(value)
//                                            ^^^ reference semanticdb maven . . kotlin/let().
//                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#notNullValueToDB().
  
      /** Returns an object compatible with the database, from the specified **non-null** [value], for this column type. */
      fun notNullValueToDB(value: T & Any): Any = value
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#notNullValueToDB().
//                         display_name notNullValueToDB
//                         documentation ```kotlin\npublic open fun notNullValueToDB(value: T & Any): Any\n```\n\n----\n\n Returns an object compatible with the database, from the specified **non-null** [value], for this column type.
//                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#notNullValueToDB().(value)
//                               display_name value
//                               documentation ```kotlin\nvalue: T & Any\n```
//                                          ^^^ reference semanticdb maven . . kotlin/Any#
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#notNullValueToDB().(value)
  
      /**
       * Returns the SQL representation of the specified [value], for this column type.
       * If the value is `null` and the column is not nullable, an exception will be thrown.
       * Used when generating an SQL statement and when logging that statement.
       */
      fun valueToString(value: T?): String = when (value) {
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueToString().
//                      display_name valueToString
//                      documentation ```kotlin\npublic open fun valueToString(value: T?): String\n```\n\n----\n\n\n Returns the SQL representation of the specified [value], for this column type.\n If the value is `null` and the column is not nullable, an exception will be thrown.\n Used when generating an SQL statement and when logging that statement.\n
//                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueToString().(value)
//                            display_name value
//                            documentation ```kotlin\nvalue: T?\n```
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueToString().(value)
          null -> {
              check(nullable) { "NULL in non-nullable column" }
//            ^^^^^ reference semanticdb maven . . kotlin/check(+1).
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
              "NULL"
          }
  
          else -> nonNullValueToString(value)
//                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nonNullValueToString().
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueToString().(value)
      }
  
      /** Returns the SQL representation of the specified **non-null** [value], for this column type. */
      fun nonNullValueToString(value: T & Any): String = notNullValueToDB(value).toString()
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nonNullValueToString().
//                             display_name nonNullValueToString
//                             documentation ```kotlin\npublic open fun nonNullValueToString(value: T & Any): String\n```\n\n----\n\n Returns the SQL representation of the specified **non-null** [value], for this column type.
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nonNullValueToString().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: T & Any\n```
//                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#notNullValueToDB().
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nonNullValueToString().(value)
//                                                                               ^^^^^^^^ reference semanticdb maven . . kotlin/Any#toString().
  
      /**
       * Returns the String representation of the specified [value] when [value] is set as the default for
       * the column.
       * If the value is `null` and the column is not nullable, an exception will be thrown.
       * Used for metadata default value comparison.
       */
      fun valueAsDefaultString(value: T?): String = when (value) {
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueAsDefaultString().
//                             display_name valueAsDefaultString
//                             documentation ```kotlin\npublic open fun valueAsDefaultString(value: T?): String\n```\n\n----\n\n\n Returns the String representation of the specified [value] when [value] is set as the default for\n the column.\n If the value is `null` and the column is not nullable, an exception will be thrown.\n Used for metadata default value comparison.\n
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueAsDefaultString().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: T?\n```
//                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueAsDefaultString().(value)
          null -> {
              check(nullable) { "NULL in non-nullable column" }
//            ^^^^^ reference semanticdb maven . . kotlin/check(+1).
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
              "NULL"
          }
  
          else -> nonNullValueAsDefaultString(value)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nonNullValueAsDefaultString().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueAsDefaultString().(value)
      }
  
      /**
       * Returns the String representation of the specified **non-null** [value] when [value] is set as the default for
       * the column.
       */
      fun nonNullValueAsDefaultString(value: T & Any): String = nonNullValueToString(value)
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nonNullValueAsDefaultString().
//                                    display_name nonNullValueAsDefaultString
//                                    documentation ```kotlin\npublic open fun nonNullValueAsDefaultString(value: T & Any): String\n```\n\n----\n\n\n Returns the String representation of the specified **non-null** [value] when [value] is set as the default for\n the column.\n
//                                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nonNullValueAsDefaultString().(value)
//                                          display_name value
//                                          documentation ```kotlin\nvalue: T & Any\n```
//                                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nonNullValueToString().
//                                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nonNullValueAsDefaultString().(value)
  
      /** Returns the object at the specified [index] in the [rs]. */
      // TODO Could we avoid breaking change here for users?
      // TODO What should do the users with custom column types that override this method?
      fun readObject(rs: RowApi, index: Int): Any? = rs.getObject(index, null, this)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#readObject().
//                   display_name readObject
//                   documentation ```kotlin\npublic open fun readObject(rs: RowApi, index: Int): Any?\n```\n\n----\n\n Returns the object at the specified [index] in the [rs].
//                   ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#readObject().(rs)
//                      display_name rs
//                      documentation ```kotlin\nrs: RowApi\n```
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#
//                               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#readObject().(index)
//                                     display_name index
//                                     documentation ```kotlin\nindex: Int\n```
//                                      ^^^ reference semanticdb maven . . kotlin/Int#
//                                            ^^^^ reference semanticdb maven . . kotlin/Any#
//                                                   ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#readObject().(rs)
//                                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject(+4).
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#readObject().(index)
  
      /** Sets the [value] at the specified [index] into the [stmt]. */
      fun setParameter(stmt: PreparedStatementApi, index: Int, value: Any?) {
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setParameter().
//                     display_name setParameter
//                     documentation ```kotlin\npublic open fun setParameter(stmt: PreparedStatementApi, index: Int, value: Any?): Unit\n```\n\n----\n\n Sets the [value] at the specified [index] into the [stmt].
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setParameter().(stmt)
//                          display_name stmt
//                          documentation ```kotlin\nstmt: PreparedStatementApi\n```
//                           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
//                                                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setParameter().(index)
//                                                       display_name index
//                                                       documentation ```kotlin\nindex: Int\n```
//                                                        ^^^ reference semanticdb maven . . kotlin/Int#
//                                                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setParameter().(value)
//                                                                   display_name value
//                                                                   documentation ```kotlin\nvalue: Any?\n```
//                                                                    ^^^^ reference semanticdb maven . . kotlin/Any#
          if (value == null || value is Op.NULL) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setParameter().(value)
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setParameter().(value)
              stmt.setNull(index, this)
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setParameter().(stmt)
//                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setNull().
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setParameter().(index)
          } else {
              stmt.set(index, value, this)
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setParameter().(stmt)
//                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set(+1).
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setParameter().(index)
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setParameter().(value)
          }
      }
  
      /**
       * Function checks that provided value is suites the column type and throws [IllegalArgumentException] otherwise.
       * [value] can be of any type (including [Expression])
       * */
      @Throws(IllegalArgumentException::class)
      fun validateValueBeforeUpdate(value: T?) {
//        ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#validateValueBeforeUpdate().
//                                  display_name validateValueBeforeUpdate
//                                  documentation ```kotlin\n@Throws(...) public open fun validateValueBeforeUpdate(value: T?): Unit\n```\n\n----\n\n\n Function checks that provided value is suites the column type and throws [IllegalArgumentException] otherwise.\n [value] can be of any type (including [Expression])\n
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#validateValueBeforeUpdate().(value)
//                                        display_name value
//                                        documentation ```kotlin\nvalue: T?\n```
      }
  
      /**
       * Defines the appearance of parameter markers in prepared SQL statements.
       *
       * The default parameter marker is `?`, but it can be overridden in specific cases.
       *
       * For example, H2 uses `? FORMAT JSON` for JSON columns,
       * in Postgres a parameter marker can be explicitly cast to a specific type, etc.
       */
      fun parameterMarker(value: T?) = "?"
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#parameterMarker().
//                        display_name parameterMarker
//                        documentation ```kotlin\npublic open fun parameterMarker(value: T?): String\n```\n\n----\n\n\n Defines the appearance of parameter markers in prepared SQL statements.\n\n The default parameter marker is `?`, but it can be overridden in specific cases.\n\n For example, H2 uses `? FORMAT JSON` for JSON columns,\n in Postgres a parameter marker can be explicitly cast to a specific type, etc.\n
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#parameterMarker().(value)
//                              display_name value
//                              documentation ```kotlin\nvalue: T?\n```
  }
  
  /**
   * Standard column type.
   */
  abstract class ColumnType<T>(override var nullable: Boolean = false) : IColumnType<T> {
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                          display_name ColumnType
//                          documentation ```kotlin\npublic abstract class ColumnType<T> : IColumnType<T>\n```\n\n----\n\n\n Standard column type.\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/`<anonymous object at 6775>`#
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#`<init>`().
//                          display_name ColumnType
//                          documentation ```kotlin\npublic constructor<T>(nullable: Boolean = ...): ColumnType<T>\n```
//                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#[T]
//                            display_name FirTypeParameterSymbol T
//                            documentation ```kotlin\nT\n```
//                                          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#`<init>`().(nullable)
//                                                   display_name nullable
//                                                   documentation ```kotlin\nnullable: Boolean = ...\n```
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#`<init>`().(nullable)
//                                          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#getNullable().
//                                                   display_name nullable
//                                                   documentation ```kotlin\npublic get(): Boolean\n```
//                                          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nullable.
//                                                   display_name nullable
//                                                   documentation ```kotlin\npublic open override var nullable: Boolean\n```
//                                          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setNullable().
//                                                   display_name nullable
//                                                   documentation ```kotlin\npublic set(value: Boolean): Unit\n```
//                                          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setNullable().(value)
//                                                   display_name value
//                                                   documentation ```kotlin\nvalue: Boolean\n```
//                                                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
      override fun toString(): String = sqlType()
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#toString().
//                          display_name toString
//                          documentation ```kotlin\npublic open override fun toString(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#equals().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#equals().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#equals().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#equals().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#equals().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#equals().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          if (this === other) return true
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().(other)
          if (javaClass != other?.javaClass) return false
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().(other)
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
  
          other as ColumnType<*>
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().(other)
  
          return nullable == other.nullable
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#getNullable().
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nullable.
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setNullable().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().(other)
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#getNullable().
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nullable.
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setNullable().
      }
  
      override fun hashCode(): Int = 31 * javaClass.hashCode() + nullable.hashCode()
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#hashCode().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#hashCode().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#hashCode().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#hashCode().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#hashCode().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#hashCode().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
//                                      ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                                        ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//                                        ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                                                  ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().
//                                                             ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#getNullable().
//                                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nullable.
//                                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setNullable().
//                                                                        ^^^^^^^^ reference semanticdb maven . . kotlin/Boolean#hashCode().
  }
  
  /**
   * Auto-increment column type.
   */
  class AutoIncColumnType<T>(
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#
//                        display_name AutoIncColumnType
//                        documentation ```kotlin\npublic final class AutoIncColumnType<T> : IColumnType<T>\n```\n\n----\n\n\n Auto-increment column type.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`().
//                        display_name AutoIncColumnType
//                        documentation ```kotlin\npublic constructor<T>(delegate: ColumnType<T>, _autoincSeq: String?, fallbackSeqName: String): AutoIncColumnType<T>\n```\n\n----\n\n Returns the base column type of this auto-increment column.
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT\n```
      /** Returns the base column type of this auto-increment column. */
      val delegate: ColumnType<T>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`().(delegate)
//                 display_name delegate
//                 documentation ```kotlin\ndelegate: ColumnType<T>\n```\n\n----\n\n Returns the base column type of this auto-increment column.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`().(delegate)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#delegate.
//                 display_name delegate
//                 documentation ```kotlin\npublic final val delegate: ColumnType<T>\n```\n\n----\n\n Returns the base column type of this auto-increment column.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getDelegate().
//                 display_name delegate
//                 documentation ```kotlin\npublic get(): ColumnType<T>\n```\n\n----\n\n Returns the base column type of this auto-increment column.
//                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      private val _autoincSeq: String?,
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#_autoincSeq.
//                            display_name _autoincSeq
//                            documentation ```kotlin\nprivate final val _autoincSeq: String?\n```
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`().(_autoincSeq)
//                            display_name _autoincSeq
//                            documentation ```kotlin\n_autoincSeq: String?\n```
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`().(_autoincSeq)
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#get_autoincSeq().
//                            display_name _autoincSeq
//                            documentation ```kotlin\nprivate get(): String?\n```
//                             ^^^^^^^ reference semanticdb maven . . kotlin/String#
      private val fallbackSeqName: String
//                ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`().(fallbackSeqName)
//                                display_name fallbackSeqName
//                                documentation ```kotlin\nfallbackSeqName: String\n```
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`().(fallbackSeqName)
//                ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#fallbackSeqName.
//                                display_name fallbackSeqName
//                                documentation ```kotlin\nprivate final val fallbackSeqName: String\n```
//                ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getFallbackSeqName().
//                                display_name fallbackSeqName
//                                documentation ```kotlin\nprivate get(): String\n```
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
  ) : IColumnType<T> by delegate {
//    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`().(delegate)
  
      private var _sequence: Sequence? = null
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#_sequence.
//                          display_name _sequence
//                          documentation ```kotlin\nprivate final var _sequence: Sequence?\n```
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#get_sequence().
//                          display_name _sequence
//                          documentation ```kotlin\nprivate get(): Sequence?\n```
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#set_sequence().
//                          display_name _sequence
//                          documentation ```kotlin\nprivate set(value: Sequence?): Unit\n```
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#set_sequence().(value)
//                          display_name value
//                          documentation ```kotlin\nvalue: Sequence?\n```
//                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
  
      /** The sequence used to generate new values for this auto-increment column. */
      val sequence: Sequence?
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.
//                 display_name sequence
//                 documentation ```kotlin\npublic final val sequence: Sequence?\n```\n\n----\n\n The sequence used to generate new values for this auto-increment column.
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
          get() = _sequence ?: autoincSeq?.let {
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//            display_name sequence
//            documentation ```kotlin\npublic get(): Sequence?\n```
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#_sequence.
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#get_sequence().
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#set_sequence().
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#autoincSeq.
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getAutoincSeq().
//                                         ^^^ reference semanticdb maven . . kotlin/let().
//                                             ^ definition semanticdb maven . . (it) 7:9
//                                               display_name it
//                                               documentation ```kotlin\nit: Any?\n```
              Sequence(
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().
                  it,
//                ^^ reference semanticdb maven . . (it)
                  startWith = 1,
                  minValue = 1,
                  maxValue = currentDialect.sequenceMaxValue
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSequenceMaxValue().
//                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#sequenceMaxValue.
              )
          }
  
      constructor(delegate: ColumnType<T>, sequence: Sequence) : this(delegate, sequence.name, sequence.name) {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`(+1). 2:5
//                                                                                                              display_name AutoIncColumnType
//                                                                                                              documentation ```kotlin\npublic constructor<T>(delegate: ColumnType<T>, sequence: Sequence): AutoIncColumnType<T>\n```
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`(+1).(delegate)
//                         display_name delegate
//                         documentation ```kotlin\ndelegate: ColumnType<T>\n```
//                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                                         ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`(+1).(sequence)
//                                                  display_name sequence
//                                                  documentation ```kotlin\nsequence: Sequence\n```
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
//                                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`(+1).(delegate)
//                                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`(+1).(sequence)
//                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getName().
//                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#name.
//                                                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`(+1).(sequence)
//                                                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getName().
//                                                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#name.
          _sequence = sequence
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#_sequence.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#get_sequence().
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#set_sequence().
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`(+1).(sequence)
      }
  
      /** The name of the sequence used to generate new values for this auto-increment column. */
      val autoincSeq: String?
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#autoincSeq.
//                   display_name autoincSeq
//                   documentation ```kotlin\npublic final val autoincSeq: String?\n```\n\n----\n\n The name of the sequence used to generate new values for this auto-increment column.
//                    ^^^^^^^ reference semanticdb maven . . kotlin/String#
          get() = _autoincSeq.takeIf { currentDialect.supportsCreateSequence }
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getAutoincSeq().
//            display_name autoincSeq
//            documentation ```kotlin\npublic get(): String?\n```
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#_autoincSeq.
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#get_autoincSeq().
//                            ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                             display_name it
//                                                                             documentation ```kotlin\nit: Any?\n```
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsCreateSequence().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsCreateSequence.
              ?: fallbackSeqName.takeIf { currentDialect.needsSequenceToAutoInc }
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#fallbackSeqName.
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getFallbackSeqName().
//                               ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                display_name it
//                                                                                documentation ```kotlin\nit: Any?\n```
//                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                       ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getNeedsSequenceToAutoInc().
//                                                       ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#needsSequenceToAutoInc.
  
      /** The SQL expression that advances the sequence of this auto-increment column. */
      val nextValExpression: NextVal<*>?
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#nextValExpression.
//                          display_name nextValExpression
//                          documentation ```kotlin\npublic final val nextValExpression: NextVal<*>?\n```\n\n----\n\n The SQL expression that advances the sequence of this auto-increment column.
//                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#
          get() = autoincSeq?.let {
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getNextValExpression().
//            display_name nextValExpression
//            documentation ```kotlin\npublic get(): NextVal<*>?\n```
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#autoincSeq.
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getAutoincSeq().
//                            ^^^ reference semanticdb maven . . kotlin/let().
//                                ^ definition semanticdb maven . . (it) 2:9
//                                  display_name it
//                                  documentation ```kotlin\nit: Any?\n```
              if (delegate is IntegerColumnType) sequence?.nextIntVal() else sequence?.nextLongVal()
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#delegate.
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getDelegate().
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.
//                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/nextIntVal().
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.
//                                                                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/nextLongVal().
          }
  
      private fun resolveAutoIncType(columnType: IColumnType<*>): String = when {
//                ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#resolveAutoIncType().
//                                   display_name resolveAutoIncType
//                                   documentation ```kotlin\nprivate final fun resolveAutoIncType(columnType: IColumnType<*>): String\n```
//                                   ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#resolveAutoIncType().(columnType)
//                                              display_name columnType
//                                              documentation ```kotlin\ncolumnType: IColumnType<*>\n```
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                                ^^^^^^ reference semanticdb maven . . kotlin/String#
          columnType is EntityIDColumnType<*> -> resolveAutoIncType(columnType.idColumn.columnType)
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#resolveAutoIncType().(columnType)
//                                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#resolveAutoIncType().
//                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#resolveAutoIncType().(columnType)
//                                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
          columnType is IntegerColumnType && autoincSeq != null -> currentDialect.dataTypeProvider.integerType()
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#resolveAutoIncType().(columnType)
//                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#autoincSeq.
//                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getAutoincSeq().
//                                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerType().
          columnType is IntegerColumnType -> currentDialect.dataTypeProvider.integerAutoincType()
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#resolveAutoIncType().(columnType)
//                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                           ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerAutoincType().
          columnType is LongColumnType && autoincSeq != null -> currentDialect.dataTypeProvider.longType()
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#resolveAutoIncType().(columnType)
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#autoincSeq.
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getAutoincSeq().
//                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#longType().
          columnType is LongColumnType -> currentDialect.dataTypeProvider.longAutoincType()
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#resolveAutoIncType().(columnType)
//                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#longAutoincType().
          else -> guessAutoIncTypeBy(columnType.sqlType())
//                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#guessAutoIncTypeBy().
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#resolveAutoIncType().(columnType)
//                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
      } ?: error("Unsupported type $delegate for auto-increment")
//         ^^^^^ reference semanticdb maven . . kotlin/error().
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#delegate.
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getDelegate().
  
      private fun guessAutoIncTypeBy(sqlType: String): String? = when (sqlType) {
//                ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#guessAutoIncTypeBy().
//                                   display_name guessAutoIncTypeBy
//                                   documentation ```kotlin\nprivate final fun guessAutoIncTypeBy(sqlType: String): String?\n```
//                                   ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#guessAutoIncTypeBy().(sqlType)
//                                           display_name sqlType
//                                           documentation ```kotlin\nsqlType: String\n```
//                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                     ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#guessAutoIncTypeBy().(sqlType)
          currentDialect.dataTypeProvider.longType() -> currentDialect.dataTypeProvider.longAutoincType()
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#longType().
//                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#longAutoincType().
          currentDialect.dataTypeProvider.integerType() -> currentDialect.dataTypeProvider.integerAutoincType()
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerType().
//                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerAutoincType().
          currentDialect.dataTypeProvider.ulongType() -> currentDialect.dataTypeProvider.ulongAutoincType()
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongType().
//                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongAutoincType().
          currentDialect.dataTypeProvider.uintegerType() -> currentDialect.dataTypeProvider.uintegerAutoincType()
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uintegerType().
//                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                                          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uintegerAutoincType().
          else -> null
      }
  
      override fun sqlType(): String = resolveAutoIncType(delegate)
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#resolveAutoIncType().
//                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#delegate.
//                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getDelegate().
  
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          return when {
              other == null -> false
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#equals().(other)
              this === other -> true
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#equals().(other)
              this::class != other::class -> false
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#equals().(other)
              other !is AutoIncColumnType<*> -> false
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#equals().(other)
              delegate != other.delegate -> false
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#delegate.
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getDelegate().
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#equals().(other)
//                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#delegate.
//                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getDelegate().
              _autoincSeq != other._autoincSeq -> false
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#_autoincSeq.
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#get_autoincSeq().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#equals().(other)
//                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#_autoincSeq.
//                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#get_autoincSeq().
              fallbackSeqName != other.fallbackSeqName -> false
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#fallbackSeqName.
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getFallbackSeqName().
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#equals().(other)
//                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#fallbackSeqName.
//                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getFallbackSeqName().
              sequence != other.sequence -> false
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#equals().(other)
//                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.
              else -> true
          }
      }
  
      override fun hashCode(): Int {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
          var result = delegate.hashCode()
//            ^^^^^^ definition local 0
//                   display_name result
//                   documentation ```kotlin\nlocal var result: Int\n```
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#delegate.
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getDelegate().
//                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#hashCode().
          result = 31 * result + (_autoincSeq?.hashCode() ?: 0)
//        ^^^^^^ reference local 0
//                    ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                      ^^^^^^ reference local 0
//                             ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#_autoincSeq.
//                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#get_autoincSeq().
//                                             ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().
          result = 31 * result + fallbackSeqName.hashCode()
//        ^^^^^^ reference local 0
//                    ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                      ^^^^^^ reference local 0
//                             ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#fallbackSeqName.
//                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getFallbackSeqName().
//                                               ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().
          result = 31 * result + (_sequence?.hashCode() ?: 0)
//        ^^^^^^ reference local 0
//                    ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                      ^^^^^^ reference local 0
//                             ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#_sequence.
//                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#get_sequence().
//                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#set_sequence().
//                                           ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().
          return result
//               ^^^^^^ reference local 0
      }
  }
  
  /** Returns `true` if this is an auto-increment column, `false` otherwise. */
  val IColumnType<*>.isAutoInc: Boolean
//                   ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
//                             display_name isAutoInc
//                             documentation ```kotlin\npublic final val IColumnType<*>.isAutoInc: Boolean\n```\n\n----\n\n Returns `true` if this is an auto-increment column, `false` otherwise.
//                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      get() = this is AutoIncColumnType || (this is EntityIDColumnType<*> && idColumn.columnType.isAutoInc)
//    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//        display_name isAutoInc
//        documentation ```kotlin\npublic get(): Boolean\n```
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//                                                                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
  
  /** Returns this column's type cast as [AutoIncColumnType] or `null` if the cast fails. */
  val Column<*>.autoIncColumnType: AutoIncColumnType<*>?
//              ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                display_name autoIncColumnType
//                                documentation ```kotlin\npublic final val Column<*>.autoIncColumnType: AutoIncColumnType<*>?\n```\n\n----\n\n Returns this column's type cast as [AutoIncColumnType] or `null` if the cast fails.
//                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#
      get() = (columnType as? AutoIncColumnType)
//    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//        display_name autoIncColumnType
//        documentation ```kotlin\npublic get(): AutoIncColumnType<*>?\n```
//             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
          ?: (columnType as? EntityIDColumnType<*>)?.idColumn?.columnType as? AutoIncColumnType
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
  
  internal fun IColumnType<*>.rawSqlType(): IColumnType<*> = when {
//                            ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/rawSqlType().
//                                       display_name rawSqlType
//                                       documentation ```kotlin\ninternal final fun IColumnType<*>.rawSqlType(): IColumnType<*>\n```
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
      this is AutoIncColumnType -> delegate
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#delegate.
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getDelegate().
      this is EntityIDColumnType<*> && idColumn.columnType is AutoIncColumnType -> idColumn.columnType.delegate
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#delegate.
//                                                                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getDelegate().
      else -> this
  }
  
  /** Returns whether this column is registered to an [IdTable] and is that table's `id` column. */
  internal fun Column<*>.isEntityIdentifier(): Boolean {
//                       ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/isEntityIdentifier().
//                                          display_name isEntityIdentifier
//                                          documentation ```kotlin\ninternal final fun Column<*>.isEntityIdentifier(): Boolean\n```\n\n----\n\n Returns whether this column is registered to an [IdTable] and is that table's `id` column.
//                                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      if (columnType !is EntityIDColumnType<*>) return false
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
  
      val tableToCheck = ((table as? Alias<*>)?.delegate ?: table) as? IdTable<*>
//        ^^^^^^^^^^^^ definition local 1
//                     display_name tableToCheck
//                     documentation ```kotlin\nlocal val tableToCheck: IdTable<*>?\n```
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
      return tableToCheck?.id == columnType.idColumn
//           ^^^^^^^^^^^^ reference local 1
//                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#getId().
//                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#id.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
  }
  
  /**
   * Identity column type for storing unique [EntityID] values.
   */
  class EntityIDColumnType<T : Any>(
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#
//                         display_name EntityIDColumnType
//                         documentation ```kotlin\npublic final class EntityIDColumnType<T : Any> : ColumnType<EntityID<T>>\n```\n\n----\n\n\n Identity column type for storing unique [EntityID] values.\n
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#`<init>`().
//                         display_name EntityIDColumnType
//                         documentation ```kotlin\npublic constructor<T : Any>(idColumn: Column<T>): EntityIDColumnType<T>\n```\n\n----\n\n The underlying wrapped column storing the identity values.
//                         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#[T]
//                           display_name FirTypeParameterSymbol T
//                           documentation ```kotlin\nT : Any\n```
      /** The underlying wrapped column storing the identity values. */
      val idColumn: Column<T>
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#`<init>`().(idColumn)
//                 display_name idColumn
//                 documentation ```kotlin\nidColumn: Column<T>\n```\n\n----\n\n The underlying wrapped column storing the identity values.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#`<init>`().(idColumn)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                 display_name idColumn
//                 documentation ```kotlin\npublic get(): Column<T>\n```\n\n----\n\n The underlying wrapped column storing the identity values.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                 display_name idColumn
//                 documentation ```kotlin\npublic final val idColumn: Column<T>\n```\n\n----\n\n The underlying wrapped column storing the identity values.
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
  ) : ColumnType<EntityID<T>>() {
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
  
      init {
          require(idColumn.table is IdTable<*>) { "EntityId supported only for IdTables" }
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
      }
  
      override fun sqlType(): String = idColumn.columnType.sqlType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
  
      override fun notNullValueToDB(value: EntityID<T>): Any = idColumn.columnType.notNullValueToDB(value.value)
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#notNullValueToDB().
//                                  display_name notNullValueToDB
//                                  documentation ```kotlin\npublic open override fun notNullValueToDB(value: EntityID<T>): Any\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#notNullValueToDB().
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#notNullValueToDB().(value)
//                                        display_name value
//                                        documentation ```kotlin\nvalue: EntityID<T>\n```
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
//                                                       ^^^ reference semanticdb maven . . kotlin/Any#
//                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#notNullValueToDB().
//                                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#notNullValueToDB().(value)
//                                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
  
      override fun nonNullValueToString(value: EntityID<T>): String = idColumn.columnType.nonNullValueToString(value.value)
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#nonNullValueToString().
//                                      display_name nonNullValueToString
//                                      documentation ```kotlin\npublic open override fun nonNullValueToString(value: EntityID<T>): String\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nonNullValueToString().
//                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#nonNullValueToString().(value)
//                                            display_name value
//                                            documentation ```kotlin\nvalue: EntityID<T>\n```
//                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
//                                                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                        ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nonNullValueToString().
//                                                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#nonNullValueToString().(value)
//                                                                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                                                                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
  
      @Suppress("UNCHECKED_CAST")
      override fun valueFromDB(value: Any): EntityID<T> = EntityIDFunctionProvider.createEntityID(
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\n@Suppress(...) public open override fun valueFromDB(value: Any): EntityID<T>\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
//                                                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#createEntityID().
          when (value) {
//              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#valueFromDB().(value)
              is EntityID<*> -> value.value as T
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#valueFromDB().(value)
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
              else -> idColumn.columnType.valueFromDB(value) as T
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueFromDB().
//                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#valueFromDB().(value)
          },
          idColumn.table as IdTable<T>
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
      )
  
      override fun readObject(rs: RowApi, index: Int): Any? = idColumn.columnType.readObject(rs, index)
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#readObject().
//                            display_name readObject
//                            documentation ```kotlin\npublic open override fun readObject(rs: RowApi, index: Int): Any?\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#readObject().
//                            ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#readObject().(rs)
//                               display_name rs
//                               documentation ```kotlin\nrs: RowApi\n```
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#
//                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#readObject().(index)
//                                              display_name index
//                                              documentation ```kotlin\nindex: Int\n```
//                                               ^^^ reference semanticdb maven . . kotlin/Int#
//                                                     ^^^^ reference semanticdb maven . . kotlin/Any#
//                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#readObject().
//                                                                                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#readObject().(rs)
//                                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#readObject().(index)
  
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          if (other !is EntityIDColumnType<*>) return false
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#equals().(other)
  
          return idColumn == other.idColumn
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#equals().(other)
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
      }
  
      override fun hashCode(): Int = 31 * super.hashCode() + idColumn.hashCode()
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
//                                      ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#hashCode().
//                                                         ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#hashCode().
  }
  
  /**
   * An interface defining the transformation between a source column type and a target type.
   *
   * @param Wrapped The type of the column values after transformation
   * @param Unwrapped The type of the column values without transformation
   */
  interface ColumnTransformer<Unwrapped, Wrapped> {
//          ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#
//                            display_name ColumnTransformer
//                            documentation ```kotlin\npublic abstract interface ColumnTransformer<Unwrapped, Wrapped> : Any\n```\n\n----\n\n\n An interface defining the transformation between a source column type and a target type.\n\n @param Wrapped The type of the column values after transformation\n @param Unwrapped The type of the column values without transformation\n
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 11564>`#
//                            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#[Unwrapped]
//                                      display_name FirTypeParameterSymbol Unwrapped
//                                      documentation ```kotlin\nUnwrapped\n```
//                                       ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#[Wrapped]
//                                               display_name FirTypeParameterSymbol Wrapped
//                                               documentation ```kotlin\nWrapped\n```
      /**
       * Returns the underlying column value without a transformation applied ([Wrapped] -> [Unwrapped]).
       */
      fun unwrap(value: Wrapped): Unwrapped
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#unwrap().
//               display_name unwrap
//               documentation ```kotlin\npublic abstract fun unwrap(value: Wrapped): Unwrapped\n\n```\n\n----\n\n\n Returns the underlying column value without a transformation applied ([Wrapped] -> [Unwrapped]).\n
//               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 11564>`#unwrap().
//               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#unwrap().(value)
//                     display_name value
//                     documentation ```kotlin\nvalue: Wrapped\n```
  
      /**
       * Applies transformation to the underlying column value ([Unwrapped] -> [Wrapped])
       */
      fun wrap(value: Unwrapped): Wrapped
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#wrap().
//             display_name wrap
//             documentation ```kotlin\npublic abstract fun wrap(value: Unwrapped): Wrapped\n\n```\n\n----\n\n\n Applies transformation to the underlying column value ([Unwrapped] -> [Wrapped])\n
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 11564>`#wrap().
//             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#wrap().(value)
//                   display_name value
//                   documentation ```kotlin\nvalue: Unwrapped\n```
  }
  
  fun <Unwrapped, Wrapped> columnTransformer(
//     ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/columnTransformer().[Unwrapped]
//               display_name FirTypeParameterSymbol Unwrapped
//               documentation ```kotlin\nUnwrapped\n```
//                ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/columnTransformer().[Wrapped]
//                        display_name FirTypeParameterSymbol Wrapped
//                        documentation ```kotlin\nWrapped\n```
//                         ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/columnTransformer().
//                                           display_name columnTransformer
//                                           documentation ```kotlin\npublic final fun <Unwrapped, Wrapped> columnTransformer(unwrap: (@R|kotlin/ParameterName|(name = String(value))  Wrapped) -> Unwrapped, wrap: (@R|kotlin/ParameterName|(name = String(value))  Unwrapped) -> Wrapped): ColumnTransformer<Unwrapped, Wrapped>\n```
      unwrap: (value: Wrapped) -> Unwrapped,
//    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/columnTransformer().(unwrap)
//           display_name unwrap
//           documentation ```kotlin\nunwrap: (@R|kotlin/ParameterName|(name = String(value))  Wrapped) -> Unwrapped\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      wrap: (value: Unwrapped) -> Wrapped
//    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/columnTransformer().(wrap)
//         display_name wrap
//         documentation ```kotlin\nwrap: (@R|kotlin/ParameterName|(name = String(value))  Unwrapped) -> Wrapped\n```
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
  ): ColumnTransformer<Unwrapped, Wrapped> {
//   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#
      return object : ColumnTransformer<Unwrapped, Wrapped> {
//           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 11564>`#
//                  display_name <anonymous>
//                  documentation ```kotlin\nobject : ColumnTransformer<Unwrapped, Wrapped>\n```
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#
//           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 11564>`#`<init>`().
//                  display_name <anonymous>
//                  documentation ```kotlin\nprivate constructor(): <anonymous><Unwrapped, Wrapped>\n```
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#
          override fun unwrap(value: Wrapped): Unwrapped = unwrap(value)
//                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 11564>`#unwrap().
//                            display_name unwrap
//                            documentation ```kotlin\npublic open override fun unwrap(value: Wrapped): Unwrapped\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#unwrap().
//                            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 11564>`#unwrap().(value)
//                                  display_name value
//                                  documentation ```kotlin\nvalue: Wrapped\n```
//                                                         ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/columnTransformer().(unwrap)
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 11564>`#unwrap().(value)
          override fun wrap(value: Unwrapped): Wrapped = wrap(value)
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 11564>`#wrap().
//                          display_name wrap
//                          documentation ```kotlin\npublic open override fun wrap(value: Unwrapped): Wrapped\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#wrap().
//                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 11564>`#wrap().(value)
//                                display_name value
//                                documentation ```kotlin\nvalue: Unwrapped\n```
//                                                       ^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/columnTransformer().(wrap)
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 11564>`#wrap().(value)
      }
  }
  
  /**
   * A class that handles the transformation between a source column type and a target type.
   *
   * [ColumnWithTransform] extends [ColumnType] and can be used to define columns.
   *
   * It does not apply transformations to `null` values. `null` values are passed directly
   * to the delegated column type. If you need to transform `null` values, use [NullableColumnWithTransform] instead.
   *
   * @param Wrapped The type to which the column value of type [Unwrapped] is transformed
   * @param Unwrapped The type of the column
   * @param delegate The original column's [IColumnType]
   * @param transformer Instance of [ColumnTransformer] that makes actual data transformation
   */
  open class ColumnWithTransform<Unwrapped, Wrapped>(
//           ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#
//                               display_name ColumnWithTransform
//                               documentation ```kotlin\npublic open class ColumnWithTransform<Unwrapped, Wrapped> : ColumnType<Wrapped & Any>\n```\n\n----\n\n\n A class that handles the transformation between a source column type and a target type.\n\n [ColumnWithTransform] extends [ColumnType] and can be used to define columns.\n\n It does not apply transformations to `null` values. `null` values are passed directly\n to the delegated column type. If you need to transform `null` values, use [NullableColumnWithTransform] instead.\n\n @param Wrapped The type to which the column value of type [Unwrapped] is transformed\n @param Unwrapped The type of the column\n @param delegate The original column's [IColumnType]\n @param transformer Instance of [ColumnTransformer] that makes actual data transformation\n
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#
//           ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#`<init>`().
//                               display_name ColumnWithTransform
//                               documentation ```kotlin\npublic constructor<Unwrapped, Wrapped>(delegate: IColumnType<Unwrapped & Any>, transformer: ColumnTransformer<Unwrapped, Wrapped>): ColumnWithTransform<Unwrapped, Wrapped>\n```
//                               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#[Unwrapped]
//                                         display_name FirTypeParameterSymbol Unwrapped
//                                         documentation ```kotlin\nUnwrapped\n```
//                                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#[Wrapped]
//                                                  display_name FirTypeParameterSymbol Wrapped
//                                                  documentation ```kotlin\nWrapped\n```
      val delegate: IColumnType<Unwrapped & Any>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#`<init>`().(delegate)
//                 display_name delegate
//                 documentation ```kotlin\ndelegate: IColumnType<Unwrapped & Any>\n```
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#`<init>`().(delegate)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#delegate.
//                 display_name delegate
//                 documentation ```kotlin\npublic final val delegate: IColumnType<Unwrapped & Any>\n```
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getDelegate().
//                 display_name delegate
//                 documentation ```kotlin\npublic get(): IColumnType<Unwrapped & Any>\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
      val transformer: ColumnTransformer<Unwrapped, Wrapped>
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#`<init>`().(transformer)
//                    display_name transformer
//                    documentation ```kotlin\ntransformer: ColumnTransformer<Unwrapped, Wrapped>\n```
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#`<init>`().(transformer)
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getTransformer().
//                    display_name transformer
//                    documentation ```kotlin\npublic get(): ColumnTransformer<Unwrapped, Wrapped>\n```
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#transformer.
//                    display_name transformer
//                    documentation ```kotlin\npublic final val transformer: ColumnTransformer<Unwrapped, Wrapped>\n```
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#
  ) : ColumnType<Wrapped & Any>() {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
  
      /**
       * Recursively unwraps the given value by applying the delegate's transformation.
       *
       * This method will recursively call unwrap on the inner delegate if the delegate
       * is also an instance of [ColumnWithTransform]. This is useful for handling nested
       * transformations.
       *
       * @param value The value to unwrap. Could be null.
       * @return The unwrapped value. Returns the value transformed by the transformer if it's not null.
       */
      open fun unwrapRecursive(value: Wrapped?): Any? {
//             ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#unwrapRecursive().
//                             display_name unwrapRecursive
//                             documentation ```kotlin\npublic open fun unwrapRecursive(value: Wrapped?): Any?\n```\n\n----\n\n\n Recursively unwraps the given value by applying the delegate's transformation.\n\n This method will recursively call unwrap on the inner delegate if the delegate\n is also an instance of [ColumnWithTransform]. This is useful for handling nested\n transformations.\n\n @param value The value to unwrap. Could be null.\n @return The unwrapped value. Returns the value transformed by the transformer if it's not null.\n
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#unwrapRecursive().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#unwrapRecursive().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Wrapped?\n```
//                                               ^^^^ reference semanticdb maven . . kotlin/Any#
          return if (delegate is ColumnWithTransform<*, *>) {
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#delegate.
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getDelegate().
              (delegate as ColumnWithTransform<Any, Unwrapped>).unwrapRecursive(transformer.unwrap(value as Wrapped))
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#delegate.
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getDelegate().
//                                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#unwrapRecursive().
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getTransformer().
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#transformer.
//                                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#unwrap().
//                                                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#unwrapRecursive().(value)
          } else {
              value?.let { transformer.unwrap(value) }
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#unwrapRecursive().(value)
//                   ^^^ reference semanticdb maven . . kotlin/let().
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                     display_name it
//                                                     documentation ```kotlin\nit: Any?\n```
//                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getTransformer().
//                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#transformer.
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#unwrap().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#unwrapRecursive().(value)
          }
      }
  
      /**
       * Gets the original column type that this column with transformation wraps around.
       *
       * This property will recursively unwrap the delegate column type if the delegate
       * is also an instance of [ColumnWithTransform]. This ensures that you get the
       * original column type, regardless of the number of nested transformations.
       *
       * @return The original column's [IColumnType].
       */
      val originalColumnType: IColumnType<Any>
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#originalColumnType.
//                           display_name originalColumnType
//                           documentation ```kotlin\npublic final val originalColumnType: IColumnType<Any>\n```\n\n----\n\n\n Gets the original column type that this column with transformation wraps around.\n\n This property will recursively unwrap the delegate column type if the delegate\n is also an instance of [ColumnWithTransform]. This ensures that you get the\n original column type, regardless of the number of nested transformations.\n\n @return The original column's [IColumnType].\n
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
          get() = when {
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getOriginalColumnType().
//            display_name originalColumnType
//            documentation ```kotlin\npublic get(): IColumnType<Any>\n```
              delegate is ColumnWithTransform<*, *> -> delegate.originalColumnType
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#delegate.
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getDelegate().
//                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#delegate.
//                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getDelegate().
//                                                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getOriginalColumnType().
//                                                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#originalColumnType.
              else -> delegate as IColumnType<Any>
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#delegate.
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getDelegate().
          }
  
      override fun sqlType(): String = delegate.sqlType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#delegate.
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getDelegate().
//                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
  
      override var nullable: Boolean
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#nullable.
//                          display_name nullable
//                          documentation ```kotlin\npublic open override var nullable: Boolean\n```
//                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          get() = delegate.nullable
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getNullable().
//            display_name nullable
//            documentation ```kotlin\npublic get(): Boolean\n```
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#delegate.
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getDelegate().
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
          set(value) {
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#setNullable().
//            display_name nullable
//            documentation ```kotlin\npublic set(value: Boolean): Unit\n```
//            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#setNullable().(value)
//                  display_name value
//                  documentation ```kotlin\nvalue: Boolean\n```
              delegate.nullable = value
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#delegate.
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getDelegate().
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#setNullable().(value)
          }
  
      override fun valueFromDB(value: Any): Wrapped? {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): Wrapped?\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
          return delegate.valueFromDB(value)?.let { transformer.wrap(it) }
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#delegate.
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getDelegate().
//                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueFromDB().
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#valueFromDB().(value)
//                                            ^^^ reference semanticdb maven . . kotlin/let().
//                                                ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                         display_name it
//                                                                         documentation ```kotlin\nit: Any?\n```
//                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getTransformer().
//                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#transformer.
//                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#wrap().
//                                                                   ^^ reference semanticdb maven . . (it)
      }
  
      override fun valueToDB(value: Wrapped?): Any? {
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#valueToDB().
//                           display_name valueToDB
//                           documentation ```kotlin\npublic open override fun valueToDB(value: Wrapped?): Any?\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueToDB().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#valueToDB().
//                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#valueToDB().(value)
//                                 display_name value
//                                 documentation ```kotlin\nvalue: Wrapped?\n```
//                                             ^^^^ reference semanticdb maven . . kotlin/Any#
          return delegate.valueToDB(value?.let { transformer.unwrap(it) })
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#delegate.
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getDelegate().
//                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueToDB().
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#valueToDB().(value)
//                                         ^^^ reference semanticdb maven . . kotlin/let().
//                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                        display_name it
//                                                                        documentation ```kotlin\nit: Any?\n```
//                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getTransformer().
//                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#transformer.
//                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#unwrap().
//                                                                  ^^ reference semanticdb maven . . (it)
      }
  
      override fun notNullValueToDB(value: Wrapped & Any): Any {
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#notNullValueToDB().
//                                  display_name notNullValueToDB
//                                  documentation ```kotlin\npublic open override fun notNullValueToDB(value: Wrapped & Any): Any\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#notNullValueToDB().
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#notNullValueToDB().(value)
//                                        display_name value
//                                        documentation ```kotlin\nvalue: Wrapped & Any\n```
//                                                         ^^^ reference semanticdb maven . . kotlin/Any#
          return delegate.notNullValueToDB(transformer.unwrap(value)!!)
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#delegate.
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getDelegate().
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#notNullValueToDB().
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getTransformer().
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#transformer.
//                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#unwrap().
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#notNullValueToDB().(value)
      }
  
      override fun readObject(rs: RowApi, index: Int): Any? = delegate.readObject(rs, index)
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#readObject().
//                            display_name readObject
//                            documentation ```kotlin\npublic open override fun readObject(rs: RowApi, index: Int): Any?\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#readObject().
//                            ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#readObject().(rs)
//                               display_name rs
//                               documentation ```kotlin\nrs: RowApi\n```
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#
//                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#readObject().(index)
//                                              display_name index
//                                              documentation ```kotlin\nindex: Int\n```
//                                               ^^^ reference semanticdb maven . . kotlin/Int#
//                                                     ^^^^ reference semanticdb maven . . kotlin/Any#
//                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#delegate.
//                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getDelegate().
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#readObject().
//                                                                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#readObject().(rs)
//                                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#readObject().(index)
  
      override fun setParameter(stmt: PreparedStatementApi, index: Int, value: Any?) {
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#setParameter().
//                              display_name setParameter
//                              documentation ```kotlin\npublic open override fun setParameter(stmt: PreparedStatementApi, index: Int, value: Any?): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setParameter().
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#setParameter().(stmt)
//                                   display_name stmt
//                                   documentation ```kotlin\nstmt: PreparedStatementApi\n```
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
//                                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#setParameter().(index)
//                                                                display_name index
//                                                                documentation ```kotlin\nindex: Int\n```
//                                                                 ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#setParameter().(value)
//                                                                            display_name value
//                                                                            documentation ```kotlin\nvalue: Any?\n```
//                                                                             ^^^^ reference semanticdb maven . . kotlin/Any#
          return delegate.setParameter(stmt, index, value)
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#delegate.
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getDelegate().
//                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setParameter().
//                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#setParameter().(stmt)
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#setParameter().(index)
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#setParameter().(value)
      }
  
      override fun parameterMarker(value: Wrapped?): String {
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#parameterMarker().
//                                 display_name parameterMarker
//                                 documentation ```kotlin\npublic open override fun parameterMarker(value: Wrapped?): String\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#parameterMarker().
//                                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#parameterMarker().(value)
//                                       display_name value
//                                       documentation ```kotlin\nvalue: Wrapped?\n```
//                                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
          return delegate.parameterMarker(value?.let { transformer.unwrap(it) })
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#delegate.
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getDelegate().
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#parameterMarker().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#parameterMarker().(value)
//                                               ^^^ reference semanticdb maven . . kotlin/let().
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                              display_name it
//                                                                              documentation ```kotlin\nit: Any?\n```
//                                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getTransformer().
//                                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#transformer.
//                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#unwrap().
//                                                                        ^^ reference semanticdb maven . . (it)
      }
  }
  
  /**
   * A class that handles the transformation between a source column type and a target type,
   * but also supports transformations involving `null` values.
   *
   * [NullableColumnWithTransform] extends [ColumnType] and can be used to define columns
   * that can transform `null` to `non-null` values and vice versa.
   *
   * @param Wrapped The type to which the column value of type [Unwrapped] is transformed
   * @param Unwrapped The type of the column
   * @param delegate The original column's [IColumnType]
   * @param transformer Instance of [ColumnTransformer] that makes actual data transformation
   */
  open class NullableColumnWithTransform<Unwrapped, Wrapped>(
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#
//                                       display_name NullableColumnWithTransform
//                                       documentation ```kotlin\npublic open class NullableColumnWithTransform<Unwrapped, Wrapped> : ColumnWithTransform<Unwrapped, Wrapped>\n```\n\n----\n\n\n A class that handles the transformation between a source column type and a target type,\n but also supports transformations involving `null` values.\n\n [NullableColumnWithTransform] extends [ColumnType] and can be used to define columns\n that can transform `null` to `non-null` values and vice versa.\n\n @param Wrapped The type to which the column value of type [Unwrapped] is transformed\n @param Unwrapped The type of the column\n @param delegate The original column's [IColumnType]\n @param transformer Instance of [ColumnTransformer] that makes actual data transformation\n
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#`<init>`().
//                                       display_name NullableColumnWithTransform
//                                       documentation ```kotlin\npublic constructor<Unwrapped, Wrapped>(delegate: IColumnType<Unwrapped & Any>, transformer: ColumnTransformer<Unwrapped, Wrapped>): NullableColumnWithTransform<Unwrapped, Wrapped>\n```
//                                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#[Unwrapped]
//                                                 display_name FirTypeParameterSymbol Unwrapped
//                                                 documentation ```kotlin\nUnwrapped\n```
//                                                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#[Wrapped]
//                                                          display_name FirTypeParameterSymbol Wrapped
//                                                          documentation ```kotlin\nWrapped\n```
      delegate: IColumnType<Unwrapped & Any>,
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#`<init>`().(delegate)
//             display_name delegate
//             documentation ```kotlin\ndelegate: IColumnType<Unwrapped & Any>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
      transformer: ColumnTransformer<Unwrapped, Wrapped>
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#`<init>`().(transformer)
//                display_name transformer
//                documentation ```kotlin\ntransformer: ColumnTransformer<Unwrapped, Wrapped>\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#
  ) : ColumnWithTransform<Unwrapped, Wrapped>(delegate, transformer) {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#
//                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#`<init>`().(delegate)
//                                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#`<init>`().(transformer)
      /**
       * Recursively unwraps the given value by applying the delegate's transformation.
       *
       * This method will recursively call unwrap on the inner delegate if the delegate
       * is also an instance of [ColumnWithTransform]. This is useful for handling nested
       * transformations. Unlike [ColumnWithTransform.unwrapRecursive], this method allows
       * transformation involving `null` values.
       *
       * @param value The value to unwrap. Could be `null`.
       * @return The unwrapped value. Returns the value transformed by the transformer, which
       * could be `null` if the transformer design allows it.
       */
      override fun unwrapRecursive(value: Wrapped?): Any? {
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#unwrapRecursive().
//                                 display_name unwrapRecursive
//                                 documentation ```kotlin\npublic open override fun unwrapRecursive(value: Wrapped?): Any?\n```\n\n----\n\n\n Recursively unwraps the given value by applying the delegate's transformation.\n\n This method will recursively call unwrap on the inner delegate if the delegate\n is also an instance of [ColumnWithTransform]. This is useful for handling nested\n transformations. Unlike [ColumnWithTransform.unwrapRecursive], this method allows\n transformation involving `null` values.\n\n @param value The value to unwrap. Could be `null`.\n @return The unwrapped value. Returns the value transformed by the transformer, which\n could be `null` if the transformer design allows it.\n
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#unwrapRecursive().
//                                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#unwrapRecursive().(value)
//                                       display_name value
//                                       documentation ```kotlin\nvalue: Wrapped?\n```
//                                                   ^^^^ reference semanticdb maven . . kotlin/Any#
          return if (delegate is ColumnWithTransform<*, *>) {
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#delegate.
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#getDelegate().
              (delegate as ColumnWithTransform<Any, Unwrapped>).unwrapRecursive(transformer.unwrap(value as Wrapped))
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#delegate.
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#getDelegate().
//                                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#unwrapRecursive().
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#getTransformer().
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#transformer.
//                                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#unwrap().
//                                                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#unwrapRecursive().(value)
          } else {
              transformer.unwrap(value as Wrapped)
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#getTransformer().
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#transformer.
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#unwrap().
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#unwrapRecursive().(value)
          }
      }
  
      override fun valueFromDB(value: Any): Wrapped? {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): Wrapped?\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
          return transformer.wrap(delegate.valueFromDB(value) as Unwrapped)
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#getTransformer().
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#transformer.
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#wrap().
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#delegate.
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#getDelegate().
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueFromDB().
//                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#valueFromDB().(value)
      }
  
      override fun valueToDB(value: Wrapped?): Any? {
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#valueToDB().
//                           display_name valueToDB
//                           documentation ```kotlin\npublic open override fun valueToDB(value: Wrapped?): Any?\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#valueToDB().
//                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#valueToDB().(value)
//                                 display_name value
//                                 documentation ```kotlin\nvalue: Wrapped?\n```
//                                             ^^^^ reference semanticdb maven . . kotlin/Any#
          // All the values go through the transformer since it can map null values to non-null values
          return delegate.valueToDB(transformer.unwrap(value as Wrapped))
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#delegate.
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#getDelegate().
//                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueToDB().
//                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#getTransformer().
//                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#transformer.
//                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#unwrap().
//                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#valueToDB().(value)
      }
  
      override fun valueToString(value: Wrapped?): String {
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#valueToString().
//                               display_name valueToString
//                               documentation ```kotlin\npublic open override fun valueToString(value: Wrapped?): String\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#valueToString().
//                               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#valueToString().(value)
//                                     display_name value
//                                     documentation ```kotlin\nvalue: Wrapped?\n```
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
          return delegate.valueToString(transformer.unwrap(value as Wrapped))
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#delegate.
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#getDelegate().
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueToString().
//                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#getTransformer().
//                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#transformer.
//                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#unwrap().
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#valueToString().(value)
      }
  }
  
  // Numeric columns
  
  /**
   * Numeric column for storing 1-byte integers.
   */
  class ByteColumnType : ColumnType<Byte>() {
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#
//                     display_name ByteColumnType
//                     documentation ```kotlin\npublic final class ByteColumnType : ColumnType<Byte>\n```\n\n----\n\n\n Numeric column for storing 1-byte integers.\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#`<init>`().
//                     display_name ByteColumnType
//                     documentation ```kotlin\npublic constructor(): ByteColumnType\n```\n\n----\n\n\n Numeric column for storing 1-byte integers.\n
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = currentDialect.dataTypeProvider.byteType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#byteType().
  
      override fun valueFromDB(value: Any): Byte = when (value) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): Byte\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^ reference semanticdb maven . . kotlin/Byte#
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#valueFromDB().(value)
          is Byte -> value
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#valueFromDB().(value)
          is Number -> value.toByte()
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#valueFromDB().(value)
//                           ^^^^^^ reference semanticdb maven . . kotlin/Number#toByte().
          is String -> value.toByte()
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#valueFromDB().(value)
//                           ^^^^^^ reference semanticdb maven . . kotlin/text/toByte().
          else -> error("Unexpected value of type Byte: $value of ${value::class.qualifiedName}")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#valueFromDB().(value)
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#valueFromDB().(value)
//                                                                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
      }
  
      override fun valueToDB(value: Byte?): Any? {
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#valueToDB().
//                           display_name valueToDB
//                           documentation ```kotlin\npublic open override fun valueToDB(value: Byte?): Any?\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueToDB().
//                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#valueToDB().(value)
//                                 display_name value
//                                 documentation ```kotlin\nvalue: Byte?\n```
//                                  ^^^^^ reference semanticdb maven . . kotlin/Byte#
//                                          ^^^^ reference semanticdb maven . . kotlin/Any#
          return if (currentDialect is SQLServerDialect) {
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
              // Workaround for SQL Server JDBC driver mysterious error for in-range values if there's a CHECK constraint
              value?.toShort()
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#valueToDB().(value)
//                   ^^^^^^^ reference semanticdb maven . . kotlin/Byte#toShort().
          } else {
              super.valueToDB(value)
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueToDB().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#valueToDB().(value)
          }
      }
  }
  
  /**
   * Numeric column for storing unsigned 1-byte integers.
   *
   * **Note:** If the database being used is not MySQL, MariaDB, or SQL Server, this column will represent the
   * database's 2-byte integer type with a check constraint that ensures storage of only values
   * between 0 and [UByte.MAX_VALUE] inclusive.
   */
  class UByteColumnType : ColumnType<UByte>() {
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#
//                      display_name UByteColumnType
//                      documentation ```kotlin\npublic final class UByteColumnType : ColumnType<UByte>\n```\n\n----\n\n\n Numeric column for storing unsigned 1-byte integers.\n\n **Note:** If the database being used is not MySQL, MariaDB, or SQL Server, this column will represent the\n database's 2-byte integer type with a check constraint that ensures storage of only values\n between 0 and [UByte.MAX_VALUE] inclusive.\n
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#`<init>`().
//                      display_name UByteColumnType
//                      documentation ```kotlin\npublic constructor(): UByteColumnType\n```\n\n----\n\n\n Numeric column for storing unsigned 1-byte integers.\n\n **Note:** If the database being used is not MySQL, MariaDB, or SQL Server, this column will represent the\n database's 2-byte integer type with a check constraint that ensures storage of only values\n between 0 and [UByte.MAX_VALUE] inclusive.\n
//                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = currentDialect.dataTypeProvider.ubyteType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ubyteType().
  
      override fun valueFromDB(value: Any): UByte {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): UByte\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^^ reference semanticdb maven . . kotlin/UByte#
          return when (value) {
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#valueFromDB().(value)
              is UByte -> value
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#valueFromDB().(value)
              is Byte -> value.toUByte()
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#valueFromDB().(value)
//                             ^^^^^^^ reference semanticdb maven . . kotlin/toUByte().
              is Number -> value.toShort().toUByte()
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#valueFromDB().(value)
//                               ^^^^^^^ reference semanticdb maven . . kotlin/Number#toShort().
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/toUByte(+1).
              is String -> value.toUByte()
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#valueFromDB().(value)
//                               ^^^^^^^ reference semanticdb maven . . kotlin/text/toUByte().
              else -> error("Unexpected value of type Byte: $value of ${value::class.qualifiedName}")
//                    ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#valueFromDB().(value)
//                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#valueFromDB().(value)
//                                                                                   ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                                   ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
          }
      }
  
      override fun setParameter(stmt: PreparedStatementApi, index: Int, value: Any?) {
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#setParameter().
//                              display_name setParameter
//                              documentation ```kotlin\npublic open override fun setParameter(stmt: PreparedStatementApi, index: Int, value: Any?): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setParameter().
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#setParameter().(stmt)
//                                   display_name stmt
//                                   documentation ```kotlin\nstmt: PreparedStatementApi\n```
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
//                                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#setParameter().(index)
//                                                                display_name index
//                                                                documentation ```kotlin\nindex: Int\n```
//                                                                 ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#setParameter().(value)
//                                                                            display_name value
//                                                                            documentation ```kotlin\nvalue: Any?\n```
//                                                                             ^^^^ reference semanticdb maven . . kotlin/Any#
          val v = when (value) {
//            ^ definition local 2
//              display_name v
//              documentation ```kotlin\nlocal val v: Any?\n```
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#setParameter().(value)
              is UByte -> value.toShort()
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#setParameter().(value)
//                              ^^^^^^^ reference semanticdb maven . . kotlin/UByte#toShort().
              else -> value
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#setParameter().(value)
          }
          super.setParameter(stmt, index, v)
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setParameter().
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#setParameter().(stmt)
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#setParameter().(index)
//                                        ^ reference local 2
      }
  
      override fun notNullValueToDB(value: UByte): Any = value.toShort()
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#notNullValueToDB().
//                                  display_name notNullValueToDB
//                                  documentation ```kotlin\npublic open override fun notNullValueToDB(value: UByte): Any\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#notNullValueToDB().
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#notNullValueToDB().(value)
//                                        display_name value
//                                        documentation ```kotlin\nvalue: UByte\n```
//                                         ^^^^^ reference semanticdb maven . . kotlin/UByte#
//                                                 ^^^ reference semanticdb maven . . kotlin/Any#
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#notNullValueToDB().(value)
//                                                             ^^^^^^^ reference semanticdb maven . . kotlin/UByte#toShort().
  }
  
  /**
   * Numeric column for storing 2-byte integers.
   */
  class ShortColumnType : ColumnType<Short>() {
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#
//                      display_name ShortColumnType
//                      documentation ```kotlin\npublic final class ShortColumnType : ColumnType<Short>\n```\n\n----\n\n\n Numeric column for storing 2-byte integers.\n
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#`<init>`().
//                      display_name ShortColumnType
//                      documentation ```kotlin\npublic constructor(): ShortColumnType\n```\n\n----\n\n\n Numeric column for storing 2-byte integers.\n
//                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = currentDialect.dataTypeProvider.shortType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#shortType().
      override fun valueFromDB(value: Any): Short = when (value) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): Short\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^^ reference semanticdb maven . . kotlin/Short#
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#valueFromDB().(value)
          is Short -> value
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#valueFromDB().(value)
          is Number -> value.toShort()
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#valueFromDB().(value)
//                           ^^^^^^^ reference semanticdb maven . . kotlin/Number#toShort().
          is String -> value.toShort()
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#valueFromDB().(value)
//                           ^^^^^^^ reference semanticdb maven . . kotlin/text/toShort().
          else -> error("Unexpected value of type Short: $value of ${value::class.qualifiedName}")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#valueFromDB().(value)
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#valueFromDB().(value)
//                                                                                ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                                ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
      }
  }
  
  /**
   * Numeric column for storing unsigned 2-byte integers.
   *
   * **Note:** If the database being used is not MySQL or MariaDB, this column will represent the database's 4-byte
   * integer type with a check constraint that ensures storage of only values between 0 and [UShort.MAX_VALUE] inclusive.
   */
  class UShortColumnType : ColumnType<UShort>() {
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#
//                       display_name UShortColumnType
//                       documentation ```kotlin\npublic final class UShortColumnType : ColumnType<UShort>\n```\n\n----\n\n\n Numeric column for storing unsigned 2-byte integers.\n\n **Note:** If the database being used is not MySQL or MariaDB, this column will represent the database's 4-byte\n integer type with a check constraint that ensures storage of only values between 0 and [UShort.MAX_VALUE] inclusive.\n
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#`<init>`().
//                       display_name UShortColumnType
//                       documentation ```kotlin\npublic constructor(): UShortColumnType\n```\n\n----\n\n\n Numeric column for storing unsigned 2-byte integers.\n\n **Note:** If the database being used is not MySQL or MariaDB, this column will represent the database's 4-byte\n integer type with a check constraint that ensures storage of only values between 0 and [UShort.MAX_VALUE] inclusive.\n
//                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = currentDialect.dataTypeProvider.ushortType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ushortType().
      override fun valueFromDB(value: Any): UShort {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): UShort\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^^^ reference semanticdb maven . . kotlin/UShort#
          return when (value) {
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#valueFromDB().(value)
              is UShort -> value
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#valueFromDB().(value)
              is Short -> value.toUShort()
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#valueFromDB().(value)
//                              ^^^^^^^^ reference semanticdb maven . . kotlin/toUShort(+1).
              is Number -> value.toInt().toUShort()
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#valueFromDB().(value)
//                               ^^^^^ reference semanticdb maven . . kotlin/Number#toInt().
//                                       ^^^^^^^^ reference semanticdb maven . . kotlin/toUShort(+2).
              is String -> value.toUShort()
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#valueFromDB().(value)
//                               ^^^^^^^^ reference semanticdb maven . . kotlin/text/toUShort().
              else -> error("Unexpected value of type Short: $value of ${value::class.qualifiedName}")
//                    ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#valueFromDB().(value)
//                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#valueFromDB().(value)
//                                                                                    ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                                    ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
          }
      }
  
      override fun setParameter(stmt: PreparedStatementApi, index: Int, value: Any?) {
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#setParameter().
//                              display_name setParameter
//                              documentation ```kotlin\npublic open override fun setParameter(stmt: PreparedStatementApi, index: Int, value: Any?): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setParameter().
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#setParameter().(stmt)
//                                   display_name stmt
//                                   documentation ```kotlin\nstmt: PreparedStatementApi\n```
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
//                                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#setParameter().(index)
//                                                                display_name index
//                                                                documentation ```kotlin\nindex: Int\n```
//                                                                 ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#setParameter().(value)
//                                                                            display_name value
//                                                                            documentation ```kotlin\nvalue: Any?\n```
//                                                                             ^^^^ reference semanticdb maven . . kotlin/Any#
          val v = when (value) {
//            ^ definition local 3
//              display_name v
//              documentation ```kotlin\nlocal val v: Any?\n```
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#setParameter().(value)
              is UShort -> value.toInt()
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#setParameter().(value)
//                               ^^^^^ reference semanticdb maven . . kotlin/UShort#toInt().
              else -> value
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#setParameter().(value)
          }
          super.setParameter(stmt, index, v)
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setParameter().
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#setParameter().(stmt)
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#setParameter().(index)
//                                        ^ reference local 3
      }
  
      override fun notNullValueToDB(value: UShort): Any = value.toInt()
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#notNullValueToDB().
//                                  display_name notNullValueToDB
//                                  documentation ```kotlin\npublic open override fun notNullValueToDB(value: UShort): Any\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#notNullValueToDB().
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#notNullValueToDB().(value)
//                                        display_name value
//                                        documentation ```kotlin\nvalue: UShort\n```
//                                         ^^^^^^ reference semanticdb maven . . kotlin/UShort#
//                                                  ^^^ reference semanticdb maven . . kotlin/Any#
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#notNullValueToDB().(value)
//                                                              ^^^^^ reference semanticdb maven . . kotlin/UShort#toInt().
  }
  
  /**
   * Numeric column for storing 4-byte integers.
   */
  class IntegerColumnType : ColumnType<Int>() {
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#
//                        display_name IntegerColumnType
//                        documentation ```kotlin\npublic final class IntegerColumnType : ColumnType<Int>\n```\n\n----\n\n\n Numeric column for storing 4-byte integers.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#`<init>`().
//                        display_name IntegerColumnType
//                        documentation ```kotlin\npublic constructor(): IntegerColumnType\n```\n\n----\n\n\n Numeric column for storing 4-byte integers.\n
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = currentDialect.dataTypeProvider.integerType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerType().
      override fun valueFromDB(value: Any): Int = when (value) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): Int\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^ reference semanticdb maven . . kotlin/Int#
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#valueFromDB().(value)
          is Int -> value
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#valueFromDB().(value)
          is Number -> value.toInt()
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#valueFromDB().(value)
//                           ^^^^^ reference semanticdb maven . . kotlin/Number#toInt().
          is String -> value.toInt()
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#valueFromDB().(value)
//                           ^^^^^ reference semanticdb maven . . kotlin/text/toInt().
          else -> error("Unexpected value of type Int: $value of ${value::class.qualifiedName}")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#valueFromDB().(value)
//                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#valueFromDB().(value)
//                                                                              ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                              ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
      }
  }
  
  /**
   * Numeric column for storing unsigned 4-byte integers.
   *
   * **Note:** If the database being used is not MySQL or MariaDB, this column will use the database's
   * 8-byte integer type with a check constraint that ensures storage of only values
   * between 0 and [UInt.MAX_VALUE] inclusive.
   */
  class UIntegerColumnType : ColumnType<UInt>() {
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#
//                         display_name UIntegerColumnType
//                         documentation ```kotlin\npublic final class UIntegerColumnType : ColumnType<UInt>\n```\n\n----\n\n\n Numeric column for storing unsigned 4-byte integers.\n\n **Note:** If the database being used is not MySQL or MariaDB, this column will use the database's\n 8-byte integer type with a check constraint that ensures storage of only values\n between 0 and [UInt.MAX_VALUE] inclusive.\n
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#`<init>`().
//                         display_name UIntegerColumnType
//                         documentation ```kotlin\npublic constructor(): UIntegerColumnType\n```\n\n----\n\n\n Numeric column for storing unsigned 4-byte integers.\n\n **Note:** If the database being used is not MySQL or MariaDB, this column will use the database's\n 8-byte integer type with a check constraint that ensures storage of only values\n between 0 and [UInt.MAX_VALUE] inclusive.\n
//                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = currentDialect.dataTypeProvider.uintegerType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uintegerType().
      override fun valueFromDB(value: Any): UInt {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): UInt\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^ reference semanticdb maven . . kotlin/UInt#
          return when (value) {
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#valueFromDB().(value)
              is UInt -> value
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#valueFromDB().(value)
              is Int -> value.toUInt()
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#valueFromDB().(value)
//                            ^^^^^^ reference semanticdb maven . . kotlin/toUInt(+2).
              is Number -> value.toLong().toUInt()
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#valueFromDB().(value)
//                               ^^^^^^ reference semanticdb maven . . kotlin/Number#toLong().
//                                        ^^^^^^ reference semanticdb maven . . kotlin/toUInt(+3).
              is String -> value.toUInt()
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#valueFromDB().(value)
//                               ^^^^^^ reference semanticdb maven . . kotlin/text/toUInt().
              else -> error("Unexpected value of type Int: $value of ${value::class.qualifiedName}")
//                    ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#valueFromDB().(value)
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#valueFromDB().(value)
//                                                                                  ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                                  ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
          }
      }
  
      override fun setParameter(stmt: PreparedStatementApi, index: Int, value: Any?) {
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#setParameter().
//                              display_name setParameter
//                              documentation ```kotlin\npublic open override fun setParameter(stmt: PreparedStatementApi, index: Int, value: Any?): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setParameter().
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#setParameter().(stmt)
//                                   display_name stmt
//                                   documentation ```kotlin\nstmt: PreparedStatementApi\n```
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
//                                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#setParameter().(index)
//                                                                display_name index
//                                                                documentation ```kotlin\nindex: Int\n```
//                                                                 ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#setParameter().(value)
//                                                                            display_name value
//                                                                            documentation ```kotlin\nvalue: Any?\n```
//                                                                             ^^^^ reference semanticdb maven . . kotlin/Any#
          val v = when (value) {
//            ^ definition local 4
//              display_name v
//              documentation ```kotlin\nlocal val v: Any?\n```
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#setParameter().(value)
              is UInt -> value.toLong()
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#setParameter().(value)
//                             ^^^^^^ reference semanticdb maven . . kotlin/UInt#toLong().
              else -> value
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#setParameter().(value)
          }
          super.setParameter(stmt, index, v)
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setParameter().
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#setParameter().(stmt)
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#setParameter().(index)
//                                        ^ reference local 4
      }
  
      override fun notNullValueToDB(value: UInt): Any = value.toLong()
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#notNullValueToDB().
//                                  display_name notNullValueToDB
//                                  documentation ```kotlin\npublic open override fun notNullValueToDB(value: UInt): Any\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#notNullValueToDB().
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#notNullValueToDB().(value)
//                                        display_name value
//                                        documentation ```kotlin\nvalue: UInt\n```
//                                         ^^^^ reference semanticdb maven . . kotlin/UInt#
//                                                ^^^ reference semanticdb maven . . kotlin/Any#
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#notNullValueToDB().(value)
//                                                            ^^^^^^ reference semanticdb maven . . kotlin/UInt#toLong().
  }
  
  /**
   * Numeric column for storing 8-byte integers.
   */
  class LongColumnType : ColumnType<Long>() {
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#
//                     display_name LongColumnType
//                     documentation ```kotlin\npublic final class LongColumnType : ColumnType<Long>\n```\n\n----\n\n\n Numeric column for storing 8-byte integers.\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#`<init>`().
//                     display_name LongColumnType
//                     documentation ```kotlin\npublic constructor(): LongColumnType\n```\n\n----\n\n\n Numeric column for storing 8-byte integers.\n
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = currentDialect.dataTypeProvider.longType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#longType().
      override fun valueFromDB(value: Any): Long = when (value) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): Long\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^ reference semanticdb maven . . kotlin/Long#
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#valueFromDB().(value)
          is Long -> value
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#valueFromDB().(value)
          is Number -> value.toLong()
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#valueFromDB().(value)
//                           ^^^^^^ reference semanticdb maven . . kotlin/Number#toLong().
          is String -> value.toLong()
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#valueFromDB().(value)
//                           ^^^^^^ reference semanticdb maven . . kotlin/text/toLong().
          else -> error("Unexpected value of type Long: $value of ${value::class.qualifiedName}")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#valueFromDB().(value)
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#valueFromDB().(value)
//                                                                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
      }
  }
  
  /**
   * Numeric column for storing unsigned 8-byte integers.
   */
  class ULongColumnType : ColumnType<ULong>() {
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#
//                      display_name ULongColumnType
//                      documentation ```kotlin\npublic final class ULongColumnType : ColumnType<ULong>\n```\n\n----\n\n\n Numeric column for storing unsigned 8-byte integers.\n
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#`<init>`().
//                      display_name ULongColumnType
//                      documentation ```kotlin\npublic constructor(): ULongColumnType\n```\n\n----\n\n\n Numeric column for storing unsigned 8-byte integers.\n
//                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = currentDialect.dataTypeProvider.ulongType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongType().
      override fun valueFromDB(value: Any): ULong {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): ULong\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^^ reference semanticdb maven . . kotlin/ULong#
          return when (value) {
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#valueFromDB().(value)
              is ULong -> value
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#valueFromDB().(value)
              is Long -> value.takeIf { it >= 0 }?.toULong()
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#valueFromDB().(value)
//                             ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                    ^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                display_name it
//                                                documentation ```kotlin\nit: Any?\n```
//                                      ^^ reference semanticdb maven . . (it)
//                                         ^^ reference semanticdb maven . . kotlin/Long#compareTo(+2).
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/toULong(+3).
              is Double -> value.takeIf { it >= 0 }?.toULong() // For SQLite
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#valueFromDB().(value)
//                               ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                      ^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                  display_name it
//                                                  documentation ```kotlin\nit: Any?\n```
//                                        ^^ reference semanticdb maven . . (it)
//                                           ^^ reference semanticdb maven . . kotlin/Double#compareTo(+2).
//                                                   ^^^^^^^ reference semanticdb maven . . kotlin/toULong(+5).
              is Number -> {
                  valueFromDB(value.toString())
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#valueFromDB().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#valueFromDB().(value)
//                                  ^^^^^^^^ reference semanticdb maven . . kotlin/Any#toString().
              }
  
              is String -> {
                  value.toBigInteger().takeIf {
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#valueFromDB().(value)
//                      ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/toBigInteger().
//                                     ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                            ^ definition semanticdb maven . . (it) 2:17
//                                              display_name it
//                                              documentation ```kotlin\nit: Any?\n```
                      it >= "0".toBigInteger() && it <= ULong.MAX_VALUE.toString().toBigInteger()
//                    ^^ reference semanticdb maven . . (it)
//                       ^^ reference semanticdb maven jdk 11 java/math/BigInteger#compareTo().
//                              ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/toBigInteger().
//                                                ^^ reference semanticdb maven . . (it)
//                                                   ^^ reference semanticdb maven jdk 11 java/math/BigInteger#compareTo().
//                                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/ULong#Companion#MAX_VALUE.
//                                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/ULong#Companion#getMAX_VALUE().
//                                                                      ^^^^^^^^ reference semanticdb maven . . kotlin/ULong#toString().
//                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/toBigInteger().
                  }?.toString()?.toULong()
//                   ^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigInteger#toString().
//                               ^^^^^^^ reference semanticdb maven . . kotlin/text/toULong().
              }
  
              else -> error("Unexpected value of type Long: $value of ${value::class.qualifiedName}")
//                    ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#valueFromDB().(value)
//                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#valueFromDB().(value)
//                                                                                   ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                                   ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
          } ?: error("Negative value but type is ULong: $value")
//             ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#valueFromDB().(value)
      }
  
      override fun notNullValueToDB(value: ULong): Any {
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#notNullValueToDB().
//                                  display_name notNullValueToDB
//                                  documentation ```kotlin\npublic open override fun notNullValueToDB(value: ULong): Any\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#notNullValueToDB().
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#notNullValueToDB().(value)
//                                        display_name value
//                                        documentation ```kotlin\nvalue: ULong\n```
//                                         ^^^^^ reference semanticdb maven . . kotlin/ULong#
//                                                 ^^^ reference semanticdb maven . . kotlin/Any#
          val dialect = currentDialect
//            ^^^^^^^ definition local 5
//                    display_name dialect
//                    documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
          return when {
              // PostgreSQLNG does not throw `out of range` error, so it's handled here to prevent storing invalid values
              dialect is PostgreSQLNGDialect -> {
//            ^^^^^^^ reference local 5
                  value.takeIf { it >= 0uL && it <= Long.MAX_VALUE.toULong() }?.toLong()
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#notNullValueToDB().(value)
//                      ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                             display_name it
//                                                                             documentation ```kotlin\nit: Any?\n```
//                               ^^ reference semanticdb maven . . (it)
//                                  ^^ reference semanticdb maven . . kotlin/ULong#compareTo(+3).
//                                            ^^ reference semanticdb maven . . (it)
//                                               ^^ reference semanticdb maven . . kotlin/ULong#compareTo(+3).
//                                                       ^^^^^^^^^ reference semanticdb maven . . kotlin/Long#Companion#MAX_VALUE.
//                                                       ^^^^^^^^^ reference semanticdb maven . . kotlin/Long#Companion#getMAX_VALUE().
//                                                                 ^^^^^^^ reference semanticdb maven . . kotlin/toULong(+3).
//                                                                              ^^^^^^ reference semanticdb maven . . kotlin/ULong#toLong().
                      ?: error("Value out of range: $value")
//                       ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#notNullValueToDB().(value)
              }
  
              dialect is PostgreSQLDialect -> BigInteger(value.toString())
//            ^^^^^^^ reference local 5
//                                            ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigInteger#`<init>`().
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#notNullValueToDB().(value)
//                                                             ^^^^^^^^ reference semanticdb maven . . kotlin/ULong#toString().
              // Long is also an accepted mapping, but this would require handling as above for Oor errors
              dialect is H2Dialect -> BigDecimal(value.toString())
//            ^^^^^^^ reference local 5
//                                    ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#`<init>`().
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#notNullValueToDB().(value)
//                                                     ^^^^^^^^ reference semanticdb maven . . kotlin/ULong#toString().
  
              else -> value.toString()
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#notNullValueToDB().(value)
//                          ^^^^^^^^ reference semanticdb maven . . kotlin/ULong#toString().
          }
      }
  }
  
  /**
   * Numeric column for storing 4-byte (single precision) floating-point numbers.
   */
  class FloatColumnType : ColumnType<Float>() {
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#
//                      display_name FloatColumnType
//                      documentation ```kotlin\npublic final class FloatColumnType : ColumnType<Float>\n```\n\n----\n\n\n Numeric column for storing 4-byte (single precision) floating-point numbers.\n
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#`<init>`().
//                      display_name FloatColumnType
//                      documentation ```kotlin\npublic constructor(): FloatColumnType\n```\n\n----\n\n\n Numeric column for storing 4-byte (single precision) floating-point numbers.\n
//                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = currentDialect.dataTypeProvider.floatType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#floatType().
      override fun valueFromDB(value: Any): Float = when (value) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): Float\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^^ reference semanticdb maven . . kotlin/Float#
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#valueFromDB().(value)
          is Float -> value
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#valueFromDB().(value)
          is Number -> value.toFloat()
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#valueFromDB().(value)
//                           ^^^^^^^ reference semanticdb maven . . kotlin/Number#toFloat().
          is String -> value.toFloat()
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#valueFromDB().(value)
//                           ^^^^^^^ reference semanticdb maven . . kotlin/text/toFloat().
          else -> error("Unexpected value of type Float: $value of ${value::class.qualifiedName}")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#valueFromDB().(value)
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#valueFromDB().(value)
//                                                                                ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                                ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
      }
  
      override fun nonNullValueAsDefaultString(value: Float): String {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#nonNullValueAsDefaultString().
//                                             display_name nonNullValueAsDefaultString
//                                             documentation ```kotlin\npublic open override fun nonNullValueAsDefaultString(value: Float): String\n```
//                                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nonNullValueAsDefaultString().
//                                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#nonNullValueAsDefaultString().(value)
//                                                   display_name value
//                                                   documentation ```kotlin\nvalue: Float\n```
//                                                    ^^^^^ reference semanticdb maven . . kotlin/Float#
//                                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
          return value.toString().let {
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#nonNullValueAsDefaultString().(value)
//                     ^^^^^^^^ reference semanticdb maven . . kotlin/Float#toString().
//                                ^^^ reference semanticdb maven . . kotlin/let().
//                                    ^ definition semanticdb maven . . (it) 8:9
//                                      display_name it
//                                      documentation ```kotlin\nit: Any?\n```
              when {
                  // MySQL returns floating-point numbers from metadata without a decimal part as integer strings, whereas other databases
                  // append a trailing zero.
                  // For example, the value 30f would be `"30"` in MySQL but `"30.0"` in other databases.
                  currentDialect is MysqlDialect && it.endsWith(".0") -> it.replace(".0", "")
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                  ^^ reference semanticdb maven . . (it)
//                                                     ^^^^^^^^ reference semanticdb maven . . kotlin/text/endsWith().
//                                                                       ^^ reference semanticdb maven . . (it)
//                                                                          ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
                  else -> it
//                        ^^ reference semanticdb maven . . (it)
              }
          }
      }
  }
  
  /**
   * Numeric column for storing 8-byte (double precision) floating-point numbers.
   */
  class DoubleColumnType : ColumnType<Double>() {
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#
//                       display_name DoubleColumnType
//                       documentation ```kotlin\npublic final class DoubleColumnType : ColumnType<Double>\n```\n\n----\n\n\n Numeric column for storing 8-byte (double precision) floating-point numbers.\n
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#`<init>`().
//                       display_name DoubleColumnType
//                       documentation ```kotlin\npublic constructor(): DoubleColumnType\n```\n\n----\n\n\n Numeric column for storing 8-byte (double precision) floating-point numbers.\n
//                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = currentDialect.dataTypeProvider.doubleType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#doubleType().
      override fun valueFromDB(value: Any): Double = when (value) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): Double\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^^^ reference semanticdb maven . . kotlin/Double#
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#valueFromDB().(value)
          is Double -> value
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#valueFromDB().(value)
          // Cast as string to prevent precision loss
          is Float -> value.toString().toDouble()
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#valueFromDB().(value)
//                          ^^^^^^^^ reference semanticdb maven . . kotlin/Float#toString().
//                                     ^^^^^^^^ reference semanticdb maven . . kotlin/text/toDouble().
          is Number -> value.toDouble()
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#valueFromDB().(value)
//                           ^^^^^^^^ reference semanticdb maven . . kotlin/Number#toDouble().
          is String -> value.toDouble()
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#valueFromDB().(value)
//                           ^^^^^^^^ reference semanticdb maven . . kotlin/text/toDouble().
          else -> error("Unexpected value of type Double: $value of ${value::class.qualifiedName}")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#valueFromDB().(value)
//                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#valueFromDB().(value)
//                                                                                 ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                                 ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
      }
  
      override fun nonNullValueAsDefaultString(value: Double): String {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#nonNullValueAsDefaultString().
//                                             display_name nonNullValueAsDefaultString
//                                             documentation ```kotlin\npublic open override fun nonNullValueAsDefaultString(value: Double): String\n```
//                                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nonNullValueAsDefaultString().
//                                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#nonNullValueAsDefaultString().(value)
//                                                   display_name value
//                                                   documentation ```kotlin\nvalue: Double\n```
//                                                    ^^^^^^ reference semanticdb maven . . kotlin/Double#
//                                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
          return value.toString().let {
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#nonNullValueAsDefaultString().(value)
//                     ^^^^^^^^ reference semanticdb maven . . kotlin/Double#toString().
//                                ^^^ reference semanticdb maven . . kotlin/let().
//                                    ^ definition semanticdb maven . . (it) 8:9
//                                      display_name it
//                                      documentation ```kotlin\nit: Any?\n```
              when {
                  // MySQL returns floating-point numbers from metadata without a decimal part as integer strings, whereas other databases
                  // append a trailing zero.
                  // For example, the value 30f would be `"30"` in MySQL but `"30.0"` in other databases.
                  currentDialect is MysqlDialect && it.endsWith(".0") -> it.replace(".0", "")
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                  ^^ reference semanticdb maven . . (it)
//                                                     ^^^^^^^^ reference semanticdb maven . . kotlin/text/endsWith().
//                                                                       ^^ reference semanticdb maven . . (it)
//                                                                          ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
                  else -> it
//                        ^^ reference semanticdb maven . . (it)
              }
          }
      }
  }
  
  /**
   * Numeric column for storing numbers with the specified [precision] and [scale].
   */
  class DecimalColumnType(
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#
//                        display_name DecimalColumnType
//                        documentation ```kotlin\npublic final class DecimalColumnType : ColumnType<BigDecimal>\n```\n\n----\n\n\n Numeric column for storing numbers with the specified [precision] and [scale].\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                        display_name DecimalColumnType
//                        documentation ```kotlin\npublic constructor(precision: Int, scale: Int): DecimalColumnType\n```\n\n----\n\n Total count of significant digits in the whole number.
      /** Total count of significant digits in the whole number. */
      val precision: Int,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().(precision)
//                  display_name precision
//                  documentation ```kotlin\nprecision: Int\n```\n\n----\n\n Total count of significant digits in the whole number.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().(precision)
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getPrecision().
//                  display_name precision
//                  documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n Total count of significant digits in the whole number.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#precision.
//                  display_name precision
//                  documentation ```kotlin\npublic final val precision: Int\n```\n\n----\n\n Total count of significant digits in the whole number.
//                   ^^^ reference semanticdb maven . . kotlin/Int#
      /** Count of decimal digits in the fractional part. */
      val scale: Int
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().(scale)
//              display_name scale
//              documentation ```kotlin\nscale: Int\n```\n\n----\n\n Count of decimal digits in the fractional part.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().(scale)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getScale().
//              display_name scale
//              documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n Count of decimal digits in the fractional part.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#scale.
//              display_name scale
//              documentation ```kotlin\npublic final val scale: Int\n```\n\n----\n\n Count of decimal digits in the fractional part.
//               ^^^ reference semanticdb maven . . kotlin/Int#
  ) : ColumnType<BigDecimal>() {
//    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = "DECIMAL($precision, $scale)"
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getPrecision().
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#precision.
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getScale().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#scale.
  
      override fun valueFromDB(value: Any): BigDecimal = when (value) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): BigDecimal\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#valueFromDB().(value)
          is BigDecimal -> value
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#valueFromDB().(value)
          is Double -> {
              if (value.isNaN()) {
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#valueFromDB().(value)
//                      ^^^^^ reference semanticdb maven . . kotlin/isNaN().
                  // TODO check for all `throw SQLException` in the code?
                  // TODO could some of them replaced wit other errors?
                  error("Unexpected value of type Double: NaN of ${value::class.qualifiedName}")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#valueFromDB().(value)
//                                                                              ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                              ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
              } else {
                  value.toBigDecimal()
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#valueFromDB().(value)
//                      ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/toBigDecimal(+6).
              }
          }
  
          is Float -> {
              if (value.isNaN()) {
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#valueFromDB().(value)
//                      ^^^^^ reference semanticdb maven . . kotlin/isNaN(+1).
                  error("Unexpected value of type Float: NaN of ${value::class.qualifiedName}")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#valueFromDB().(value)
//                                                                             ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                             ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
              } else {
                  value.toBigDecimal()
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#valueFromDB().(value)
//                      ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/toBigDecimal(+4).
              }
          }
  
          is Long -> value.toBigDecimal()
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#valueFromDB().(value)
//                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/toBigDecimal(+2).
          is Int -> value.toBigDecimal()
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#valueFromDB().(value)
//                        ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/toBigDecimal().
          is Short -> value.toLong().toBigDecimal()
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#valueFromDB().(value)
//                          ^^^^^^ reference semanticdb maven . . kotlin/Short#toLong().
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/toBigDecimal(+2).
          else -> error("Unexpected value of type Decimal: $value of ${value::class.qualifiedName}")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#valueFromDB().(value)
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#valueFromDB().(value)
//                                                                                  ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                                  ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
      }.setScale(scale, RoundingMode.HALF_EVEN)
//      ^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#setScale().
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getScale().
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#scale.
//                                   ^^^^^^^^^ reference semanticdb maven jdk 11 java/math/RoundingMode#HALF_EVEN.
  
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          if (this === other) return true
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#equals().(other)
          if (javaClass != other?.javaClass) return false
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#equals().(other)
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
          if (!super.equals(other)) return false
//            ^ reference semanticdb maven . . kotlin/Boolean#not().
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#equals().(other)
  
          other as DecimalColumnType
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#equals().(other)
  
          if (precision != other.precision) return false
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getPrecision().
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#precision.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#equals().(other)
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getPrecision().
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#precision.
          if (scale != other.scale) return false
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getScale().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#scale.
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#equals().(other)
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getScale().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#scale.
  
          return true
      }
  
      override fun hashCode(): Int {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
          var result = super.hashCode()
//            ^^^^^^ definition local 6
//                   display_name result
//                   documentation ```kotlin\nlocal var result: Int\n```
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#hashCode().
          result = 31 * result + precision
//        ^^^^^^ reference local 6
//                    ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                      ^^^^^^ reference local 6
//                             ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getPrecision().
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#precision.
          result = 31 * result + scale
//        ^^^^^^ reference local 6
//                    ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                      ^^^^^^ reference local 6
//                             ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getScale().
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#scale.
          return result
//               ^^^^^^ reference local 6
      }
  
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion# 2:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#`<init>`(). 2:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): DecimalColumnType.Companion\n```
          internal val INSTANCE = DecimalColumnType(MathContext.DECIMAL64.precision, 20)
//                     ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                              display_name INSTANCE
//                              documentation ```kotlin\ninternal final val INSTANCE: DecimalColumnType\n```
//                     ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
//                              display_name INSTANCE
//                              documentation ```kotlin\ninternal get(): DecimalColumnType\n```
//                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                                                              ^^^^^^^^^ reference semanticdb maven jdk 11 java/math/MathContext#DECIMAL64.
//                                                                        ^^^^^^^^^ reference semanticdb maven jdk 11 java/math/MathContext#getPrecision().
//                                                                        ^^^^^^^^^ reference semanticdb maven jdk 11 java/math/MathContext#precision.
      }
  }
  
  // Character columns
  
  /**
   * Character column for storing single characters.
   */
  class CharacterColumnType : ColumnType<Char>() {
//      ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#
//                          display_name CharacterColumnType
//                          documentation ```kotlin\npublic final class CharacterColumnType : ColumnType<Char>\n```\n\n----\n\n\n Character column for storing single characters.\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#`<init>`().
//                          display_name CharacterColumnType
//                          documentation ```kotlin\npublic constructor(): CharacterColumnType\n```\n\n----\n\n\n Character column for storing single characters.\n
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = "CHAR"
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
      override fun valueFromDB(value: Any): Char = when (value) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): Char\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^ reference semanticdb maven . . kotlin/Char#
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#valueFromDB().(value)
          is Char -> value
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#valueFromDB().(value)
          is Number -> value.toInt().toChar()
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#valueFromDB().(value)
//                           ^^^^^ reference semanticdb maven . . kotlin/Number#toInt().
//                                   ^^^^^^ reference semanticdb maven . . kotlin/Int#toChar().
          is String -> value.single()
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#valueFromDB().(value)
//                           ^^^^^^ reference semanticdb maven . . kotlin/text/single().
          else -> error("Unexpected value of type Char: $value of ${value::class.qualifiedName}")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#valueFromDB().(value)
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#valueFromDB().(value)
//                                                                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
      }
  
      override fun notNullValueToDB(value: Char): Any = value.toString()
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#notNullValueToDB().
//                                  display_name notNullValueToDB
//                                  documentation ```kotlin\npublic open override fun notNullValueToDB(value: Char): Any\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#notNullValueToDB().
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#notNullValueToDB().(value)
//                                        display_name value
//                                        documentation ```kotlin\nvalue: Char\n```
//                                         ^^^^ reference semanticdb maven . . kotlin/Char#
//                                                ^^^ reference semanticdb maven . . kotlin/Any#
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#notNullValueToDB().(value)
//                                                            ^^^^^^^^ reference semanticdb maven . . kotlin/Char#toString().
  
      override fun nonNullValueToString(value: Char): String = "'$value'"
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#nonNullValueToString().
//                                      display_name nonNullValueToString
//                                      documentation ```kotlin\npublic open override fun nonNullValueToString(value: Char): String\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nonNullValueToString().
//                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#nonNullValueToString().(value)
//                                            display_name value
//                                            documentation ```kotlin\nvalue: Char\n```
//                                             ^^^^ reference semanticdb maven . . kotlin/Char#
//                                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#nonNullValueToString().(value)
  }
  
  /**
   * Base character column for storing strings using the specified text [collate] type.
   */
  abstract class StringColumnType(
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#
//                                display_name StringColumnType
//                                documentation ```kotlin\npublic abstract class StringColumnType : ColumnType<String>\n```\n\n----\n\n\n Base character column for storing strings using the specified text [collate] type.\n
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#CharColumnType#
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#`<init>`().
//                                display_name StringColumnType
//                                documentation ```kotlin\npublic constructor(collate: String? = ...): StringColumnType\n```\n\n----\n\n Returns the collate type used in by this column.
      /** Returns the collate type used in by this column. */
      val collate: String? = null
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#`<init>`().(collate)
//                display_name collate
//                documentation ```kotlin\ncollate: String? = ...\n```\n\n----\n\n Returns the collate type used in by this column.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#`<init>`().(collate)
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#collate.
//                display_name collate
//                documentation ```kotlin\npublic final val collate: String?\n```\n\n----\n\n Returns the collate type used in by this column.
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#getCollate().
//                display_name collate
//                documentation ```kotlin\npublic get(): String?\n```\n\n----\n\n Returns the collate type used in by this column.
//                 ^^^^^^^ reference semanticdb maven . . kotlin/String#
  ) : ColumnType<String>() {
//    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      /** Returns the specified [value] with special characters escaped. */
      protected fun escape(value: String): String = value.map { charactersToEscape[it] ?: it }.joinToString("")
//                  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#escape().
//                         display_name escape
//                         documentation ```kotlin\nprotected final fun escape(value: String): String\n```\n\n----\n\n Returns the specified [value] with special characters escaped.
//                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#escape().(value)
//                               display_name value
//                               documentation ```kotlin\nvalue: String\n```
//                                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#escape().(value)
//                                                        ^^^ reference semanticdb maven . . kotlin/text/map().
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                             display_name it
//                                                                                             documentation ```kotlin\nit: Any?\n```
//                                                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#Companion#charactersToEscape.
//                                                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#Companion#getCharactersToEscape().
//                                                              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                                                 ^^ reference semanticdb maven . . (it)
//                                                                                        ^^ reference semanticdb maven . . (it)
//                                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
  
      /** Returns the specified [value] with special characters escaped and wrapped in quotations, if necessary. */
      protected fun escapeAndQuote(value: String): String = when (currentDialect) {
//                  ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#escapeAndQuote().
//                                 display_name escapeAndQuote
//                                 documentation ```kotlin\nprotected final fun escapeAndQuote(value: String): String\n```\n\n----\n\n Returns the specified [value] with special characters escaped and wrapped in quotations, if necessary.
//                                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#escapeAndQuote().(value)
//                                       display_name value
//                                       documentation ```kotlin\nvalue: String\n```
//                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
          is PostgreSQLDialect -> "\"${escape(value)}\""
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#escape().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#escapeAndQuote().(value)
          else -> escape(value)
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#escape().
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#escapeAndQuote().(value)
      }
  
      override fun valueFromDB(value: Any): String = when (value) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): String\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#valueFromDB().(value)
          is Clob -> value.characterStream.readText()
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#valueFromDB().(value)
//                         ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/sql/Clob#characterStream.
//                         ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/sql/Clob#getCharacterStream().
//                                         ^^^^^^^^ reference semanticdb maven . . kotlin/io/readText(+1).
          is ByteArray -> String(value)
//                        ^^^^^^ reference semanticdb maven . . kotlin/text/String(+3).
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#valueFromDB().(value)
          else -> value.toString()
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#valueFromDB().(value)
//                      ^^^^^^^^ reference semanticdb maven . . kotlin/Any#toString().
      }
  
      override fun nonNullValueToString(value: String): String = buildString {
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#nonNullValueToString().
//                                      display_name nonNullValueToString
//                                      documentation ```kotlin\npublic open override fun nonNullValueToString(value: String): String\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nonNullValueToString().
//                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#nonNullValueToString().(value)
//                                            display_name value
//                                            documentation ```kotlin\nvalue: String\n```
//                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                               ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
          append('\'')
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
          append(escape(value))
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#escape().
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#nonNullValueToString().(value)
          append('\'')
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
      }
  
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#equals().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          if (this === other) return true
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#equals().(other)
          if (javaClass != other?.javaClass) return false
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#equals().(other)
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
          if (!super.equals(other)) return false
//            ^ reference semanticdb maven . . kotlin/Boolean#not().
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#equals().(other)
  
          other as StringColumnType
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#equals().(other)
  
          return collate == other.collate
//               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#collate.
//               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#getCollate().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#equals().(other)
//                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#collate.
//                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#getCollate().
      }
  
      override fun hashCode(): Int {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#hashCode().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#hashCode().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
          var result = super.hashCode()
//            ^^^^^^ definition local 7
//                   display_name result
//                   documentation ```kotlin\nlocal var result: Int\n```
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#hashCode().
          result = 31 * result + (collate?.hashCode() ?: 0)
//        ^^^^^^ reference local 7
//                    ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                      ^^^^^^ reference local 7
//                             ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#collate.
//                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#getCollate().
//                                         ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().
          return result
//               ^^^^^^ reference local 7
      }
  
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#Companion# 6:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#Companion#`<init>`(). 6:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): StringColumnType.Companion\n```
          private val charactersToEscape = mapOf(
//                    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#Companion#charactersToEscape.
//                                       display_name charactersToEscape
//                                       documentation ```kotlin\nprivate final val charactersToEscape: Map<Char, String>\n```
//                    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#Companion#getCharactersToEscape().
//                                       display_name charactersToEscape
//                                       documentation ```kotlin\nprivate get(): Map<Char, String>\n```
//                                         ^^^^^ reference semanticdb maven . . kotlin/collections/mapOf(+1).
              '\'' to "\'\'",
//                 ^^ reference semanticdb maven . . kotlin/to().
              '\r' to "\\r",
//                 ^^ reference semanticdb maven . . kotlin/to().
              '\n' to "\\n"
//                 ^^ reference semanticdb maven . . kotlin/to().
          )
      }
  }
  
  /**
   * Character column for storing strings with the exact [colLength] length using the specified [collate] type.
   */
  open class CharColumnType(
//           ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#
//                          display_name CharColumnType
//                          documentation ```kotlin\npublic open class CharColumnType : StringColumnType\n```\n\n----\n\n\n Character column for storing strings with the exact [colLength] length using the specified [collate] type.\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#
//           ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#`<init>`().
//                          display_name CharColumnType
//                          documentation ```kotlin\npublic constructor(colLength: Int = ..., collate: String? = ...): CharColumnType\n```\n\n----\n\n Returns the maximum length of this column.
      /** Returns the maximum length of this column. */
      val colLength: Int = 255,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#`<init>`().(colLength)
//                  display_name colLength
//                  documentation ```kotlin\ncolLength: Int = ...\n```\n\n----\n\n Returns the maximum length of this column.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#`<init>`().(colLength)
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#colLength.
//                  display_name colLength
//                  documentation ```kotlin\npublic final val colLength: Int\n```\n\n----\n\n Returns the maximum length of this column.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#getColLength().
//                  display_name colLength
//                  documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n Returns the maximum length of this column.
//                   ^^^ reference semanticdb maven . . kotlin/Int#
      collate: String? = null
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#`<init>`().(collate)
//            display_name collate
//            documentation ```kotlin\ncollate: String? = ...\n```
//             ^^^^^^^ reference semanticdb maven . . kotlin/String#
  ) : StringColumnType(collate) {
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#`<init>`().(collate)
      override fun sqlType(): String = buildString {
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
          append("CHAR($colLength)")
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#colLength.
//                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#getColLength().
          if (collate != null) {
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#collate.
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#getCollate().
              append(" COLLATE ${escapeAndQuote(collate)}")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#escapeAndQuote().
//                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#collate.
//                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#getCollate().
          }
      }
  
      override fun validateValueBeforeUpdate(value: String?) {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#validateValueBeforeUpdate().
//                                           display_name validateValueBeforeUpdate
//                                           documentation ```kotlin\npublic open override fun validateValueBeforeUpdate(value: String?): Unit\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#validateValueBeforeUpdate().
//                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#validateValueBeforeUpdate().(value)
//                                                 display_name value
//                                                 documentation ```kotlin\nvalue: String?\n```
//                                                  ^^^^^^^ reference semanticdb maven . . kotlin/String#
          if (value is String) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#validateValueBeforeUpdate().(value)
              val valueLength = value.codePointCount(0, value.length)
//                ^^^^^^^^^^^ definition local 8
//                            display_name valueLength
//                            documentation ```kotlin\nlocal val valueLength: Int\n```
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#validateValueBeforeUpdate().(value)
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/codePointCount().
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#validateValueBeforeUpdate().(value)
//                                                            ^^^^^^ reference semanticdb maven . . kotlin/String#getLength().
//                                                            ^^^^^^ reference semanticdb maven . . kotlin/String#length.
              require(valueLength <= colLength) {
//            ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                    ^^^^^^^^^^^ reference local 8
//                                ^^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#colLength.
//                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#getColLength().
                  "Value can't be stored to database column because exceeds length ($valueLength > $colLength)"
//                                                                                   ^^^^^^^^^^^ reference local 8
//                                                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#colLength.
//                                                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#getColLength().
              }
          }
      }
  
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          if (this === other) return true
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#equals().(other)
          if (javaClass != other?.javaClass) return false
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#equals().(other)
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
          if (!super.equals(other)) return false
//            ^ reference semanticdb maven . . kotlin/Boolean#not().
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#equals().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#equals().(other)
  
          other as CharColumnType
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#equals().(other)
  
          if (colLength != other.colLength) return false
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#colLength.
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#getColLength().
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#equals().(other)
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#colLength.
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#getColLength().
  
          if (collate != other.collate) return false
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#collate.
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#getCollate().
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#equals().(other)
//                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#collate.
//                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#getCollate().
          return true
      }
  
      override fun hashCode(): Int {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
          var result = super.hashCode()
//            ^^^^^^ definition local 9
//                   display_name result
//                   documentation ```kotlin\nlocal var result: Int\n```
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#hashCode().
          result = 31 * result + colLength
//        ^^^^^^ reference local 9
//                    ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                      ^^^^^^ reference local 9
//                             ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#colLength.
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#getColLength().
          return result
//               ^^^^^^ reference local 9
      }
  }
  
  /**
   * Character column for storing strings with the specified maximum [colLength] using the specified [collate] type.
   */
  open class VarCharColumnType(
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#
//                             display_name VarCharColumnType
//                             documentation ```kotlin\npublic open class VarCharColumnType : StringColumnType\n```\n\n----\n\n\n Character column for storing strings with the specified maximum [colLength] using the specified [collate] type.\n
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#`<init>`().
//                             display_name VarCharColumnType
//                             documentation ```kotlin\npublic constructor(colLength: Int = ..., collate: String? = ...): VarCharColumnType\n```\n\n----\n\n Returns the maximum length of this column.
      /** Returns the maximum length of this column. */
      val colLength: Int = 255,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#`<init>`().(colLength)
//                  display_name colLength
//                  documentation ```kotlin\ncolLength: Int = ...\n```\n\n----\n\n Returns the maximum length of this column.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#`<init>`().(colLength)
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#colLength.
//                  display_name colLength
//                  documentation ```kotlin\npublic final val colLength: Int\n```\n\n----\n\n Returns the maximum length of this column.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#getColLength().
//                  display_name colLength
//                  documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n Returns the maximum length of this column.
//                   ^^^ reference semanticdb maven . . kotlin/Int#
      collate: String? = null
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#`<init>`().(collate)
//            display_name collate
//            documentation ```kotlin\ncollate: String? = ...\n```
//             ^^^^^^^ reference semanticdb maven . . kotlin/String#
  ) : StringColumnType(collate) {
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#`<init>`().(collate)
      open fun preciseType() = currentDialect.dataTypeProvider.varcharType(colLength)
//             ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#preciseType().
//                         display_name preciseType
//                         documentation ```kotlin\npublic open fun preciseType(): String\n```
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#varcharType().
//                                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#colLength.
//                                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#getColLength().
  
      override fun sqlType(): String = buildString {
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
          append(preciseType())
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#preciseType().
          if (collate != null) {
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#collate.
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#getCollate().
              append(" COLLATE ${escapeAndQuote(collate)}")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#escapeAndQuote().
//                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#collate.
//                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#getCollate().
          }
      }
  
      override fun validateValueBeforeUpdate(value: String?) {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#validateValueBeforeUpdate().
//                                           display_name validateValueBeforeUpdate
//                                           documentation ```kotlin\npublic open override fun validateValueBeforeUpdate(value: String?): Unit\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#validateValueBeforeUpdate().
//                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#validateValueBeforeUpdate().(value)
//                                                 display_name value
//                                                 documentation ```kotlin\nvalue: String?\n```
//                                                  ^^^^^^^ reference semanticdb maven . . kotlin/String#
          if (value is String) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#validateValueBeforeUpdate().(value)
              val valueLength = value.codePointCount(0, value.length)
//                ^^^^^^^^^^^ definition local 10
//                            display_name valueLength
//                            documentation ```kotlin\nlocal val valueLength: Int\n```
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#validateValueBeforeUpdate().(value)
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/codePointCount().
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#validateValueBeforeUpdate().(value)
//                                                            ^^^^^^ reference semanticdb maven . . kotlin/String#getLength().
//                                                            ^^^^^^ reference semanticdb maven . . kotlin/String#length.
              require(valueLength <= colLength) {
//            ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                    ^^^^^^^^^^^ reference local 10
//                                ^^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#colLength.
//                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#getColLength().
                  "Value can't be stored to database column because exceeds length ($valueLength > $colLength)"
//                                                                                   ^^^^^^^^^^^ reference local 10
//                                                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#colLength.
//                                                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#getColLength().
              }
          }
      }
  
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          if (this === other) return true
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#equals().(other)
          if (javaClass != other?.javaClass) return false
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#equals().(other)
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
          if (!super.equals(other)) return false
//            ^ reference semanticdb maven . . kotlin/Boolean#not().
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#equals().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#equals().(other)
  
          other as VarCharColumnType
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#equals().(other)
  
          return colLength == other.colLength
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#colLength.
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#getColLength().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#equals().(other)
//                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#colLength.
//                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#getColLength().
      }
  
      override fun hashCode(): Int {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
          var result = super.hashCode()
//            ^^^^^^ definition local 11
//                   display_name result
//                   documentation ```kotlin\nlocal var result: Int\n```
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#hashCode().
          result = 31 * result + colLength
//        ^^^^^^ reference local 11
//                    ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                      ^^^^^^ reference local 11
//                             ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#colLength.
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#getColLength().
          return result
//               ^^^^^^ reference local 11
      }
  }
  
  /**
   * Character column for storing strings of arbitrary length using the specified [collate] type.
   */
  open class TextColumnType(
//           ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#
//                          display_name TextColumnType
//                          documentation ```kotlin\npublic open class TextColumnType : StringColumnType\n```\n\n----\n\n\n Character column for storing strings of arbitrary length using the specified [collate] type.\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/LargeTextColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/MediumTextColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#
//           ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
//                          display_name TextColumnType
//                          documentation ```kotlin\npublic constructor(collate: String? = ..., eagerLoading: Boolean = ...): TextColumnType\n```\n\n----\n\n Whether content will be loaded immediately when data is retrieved from the database.
      collate: String? = null,
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().(collate)
//            display_name collate
//            documentation ```kotlin\ncollate: String? = ...\n```
//             ^^^^^^^ reference semanticdb maven . . kotlin/String#
      /** Whether content will be loaded immediately when data is retrieved from the database. */
      val eagerLoading: Boolean = false
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().(eagerLoading)
//                     display_name eagerLoading
//                     documentation ```kotlin\neagerLoading: Boolean = ...\n```\n\n----\n\n Whether content will be loaded immediately when data is retrieved from the database.
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().(eagerLoading)
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#eagerLoading.
//                     display_name eagerLoading
//                     documentation ```kotlin\npublic final val eagerLoading: Boolean\n```\n\n----\n\n Whether content will be loaded immediately when data is retrieved from the database.
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#getEagerLoading().
//                     display_name eagerLoading
//                     documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether content will be loaded immediately when data is retrieved from the database.
//                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  ) : StringColumnType(collate) {
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().(collate)
      /** The exact SQL type representing this character type. */
      open fun preciseType() = currentDialect.dataTypeProvider.textType()
//             ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#preciseType().
//                         display_name preciseType
//                         documentation ```kotlin\npublic open fun preciseType(): String\n```\n\n----\n\n The exact SQL type representing this character type.
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/LargeTextColumnType#preciseType().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/MediumTextColumnType#preciseType().
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#textType().
  
      override fun sqlType(): String = buildString {
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
          append(preciseType())
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#preciseType().
          if (collate != null) {
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#collate.
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#getCollate().
              append(" COLLATE ${escapeAndQuote(collate)}")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#escapeAndQuote().
//                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#collate.
//                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#getCollate().
          }
      }
  
      override fun readObject(rs: RowApi, index: Int): Any? {
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#readObject().
//                            display_name readObject
//                            documentation ```kotlin\npublic open override fun readObject(rs: RowApi, index: Int): Any?\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#readObject().
//                            ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#readObject().(rs)
//                               display_name rs
//                               documentation ```kotlin\nrs: RowApi\n```
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#
//                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#readObject().(index)
//                                              display_name index
//                                              documentation ```kotlin\nindex: Int\n```
//                                               ^^^ reference semanticdb maven . . kotlin/Int#
//                                                     ^^^^ reference semanticdb maven . . kotlin/Any#
          val value = super.readObject(rs, index)
//            ^^^^^ definition local 12
//                  display_name value
//                  documentation ```kotlin\nlocal val value: Any?\n```
//                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#readObject().
//                                     ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#readObject().(rs)
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#readObject().(index)
          return if (eagerLoading && value != null) {
//                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#eagerLoading.
//                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#getEagerLoading().
//                                   ^^^^^ reference local 12
              valueFromDB(value)
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#valueFromDB().
//                        ^^^^^ reference local 12
          } else {
              value
//            ^^^^^ reference local 12
          }
      }
  }
  
  open class MediumTextColumnType(
//           ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/MediumTextColumnType#
//                                display_name MediumTextColumnType
//                                documentation ```kotlin\npublic open class MediumTextColumnType : TextColumnType\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#
//           ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/MediumTextColumnType#`<init>`().
//                                display_name MediumTextColumnType
//                                documentation ```kotlin\npublic constructor(collate: String? = ..., eagerLoading: Boolean = ...): MediumTextColumnType\n```
      collate: String? = null,
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/MediumTextColumnType#`<init>`().(collate)
//            display_name collate
//            documentation ```kotlin\ncollate: String? = ...\n```
//             ^^^^^^^ reference semanticdb maven . . kotlin/String#
      eagerLoading: Boolean = false
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/MediumTextColumnType#`<init>`().(eagerLoading)
//                 display_name eagerLoading
//                 documentation ```kotlin\neagerLoading: Boolean = ...\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  ) : TextColumnType(collate, eagerLoading) {
//    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/MediumTextColumnType#`<init>`().(collate)
//                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/MediumTextColumnType#`<init>`().(eagerLoading)
      override fun preciseType(): String = currentDialect.dataTypeProvider.mediumTextType()
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/MediumTextColumnType#preciseType().
//                             display_name preciseType
//                             documentation ```kotlin\npublic open override fun preciseType(): String\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#preciseType().
//                                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#mediumTextType().
  }
  
  open class LargeTextColumnType(
//           ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LargeTextColumnType#
//                               display_name LargeTextColumnType
//                               documentation ```kotlin\npublic open class LargeTextColumnType : TextColumnType\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#
//           ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LargeTextColumnType#`<init>`().
//                               display_name LargeTextColumnType
//                               documentation ```kotlin\npublic constructor(collate: String? = ..., eagerLoading: Boolean = ...): LargeTextColumnType\n```
      collate: String? = null,
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LargeTextColumnType#`<init>`().(collate)
//            display_name collate
//            documentation ```kotlin\ncollate: String? = ...\n```
//             ^^^^^^^ reference semanticdb maven . . kotlin/String#
      eagerLoading: Boolean = false
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LargeTextColumnType#`<init>`().(eagerLoading)
//                 display_name eagerLoading
//                 documentation ```kotlin\neagerLoading: Boolean = ...\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  ) : TextColumnType(collate, eagerLoading) {
//    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LargeTextColumnType#`<init>`().(collate)
//                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LargeTextColumnType#`<init>`().(eagerLoading)
      override fun preciseType(): String = currentDialect.dataTypeProvider.largeTextType()
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LargeTextColumnType#preciseType().
//                             display_name preciseType
//                             documentation ```kotlin\npublic open override fun preciseType(): String\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#preciseType().
//                                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#largeTextType().
  }
  
  // Binary columns
  
  /**
   * Binary column for storing binary strings of variable and _unlimited_ length.
   */
  open class BasicBinaryColumnType : ColumnType<ByteArray>() {
//           ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#
//                                 display_name BasicBinaryColumnType
//                                 documentation ```kotlin\npublic open class BasicBinaryColumnType : ColumnType<ByteArray>\n```\n\n----\n\n\n Binary column for storing binary strings of variable and _unlimited_ length.\n
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//           ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#`<init>`().
//                                 display_name BasicBinaryColumnType
//                                 documentation ```kotlin\npublic constructor(): BasicBinaryColumnType\n```\n\n----\n\n\n Binary column for storing binary strings of variable and _unlimited_ length.\n
//                                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = currentDialect.dataTypeProvider.binaryType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#sqlType().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType().
  
      override fun valueFromDB(value: Any): ByteArray = when (value) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): ByteArray\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^^^^^^ reference semanticdb maven . . kotlin/ByteArray#
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#valueFromDB().(value)
          is Blob -> value.binaryStream.use { it.readBytes() }
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#valueFromDB().(value)
//                         ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/sql/Blob#binaryStream.
//                         ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/sql/Blob#getBinaryStream().
//                                      ^^^ reference semanticdb maven . . kotlin/io/use().
//                                          ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                             display_name it
//                                                             documentation ```kotlin\nit: Any?\n```
//                                            ^^ reference semanticdb maven . . (it)
//                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/io/readBytes(+2).
          is InputStream -> value.use { it.readBytes() }
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#valueFromDB().(value)
//                                ^^^ reference semanticdb maven . . kotlin/io/use().
//                                    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                       display_name it
//                                                       documentation ```kotlin\nit: Any?\n```
//                                      ^^ reference semanticdb maven . . (it)
//                                         ^^^^^^^^^ reference semanticdb maven . . kotlin/io/readBytes(+2).
          is ByteArray -> value
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#valueFromDB().(value)
          is String -> value.toByteArray()
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#valueFromDB().(value)
//                           ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/toByteArray().
          is ByteBuffer -> value.array()
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#valueFromDB().(value)
//                               ^^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#array().
          else -> error("Unexpected value $value of type ${value::class.qualifiedName}")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#valueFromDB().(value)
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#valueFromDB().(value)
//                                                                      ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                      ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
      }
  
      override fun nonNullValueToString(value: ByteArray): String = value.toString(Charsets.UTF_8)
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#nonNullValueToString().
//                                      display_name nonNullValueToString
//                                      documentation ```kotlin\npublic open override fun nonNullValueToString(value: ByteArray): String\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nonNullValueToString().
//                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#nonNullValueToString().(value)
//                                            display_name value
//                                            documentation ```kotlin\nvalue: ByteArray\n```
//                                             ^^^^^^^^^ reference semanticdb maven . . kotlin/ByteArray#
//                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#nonNullValueToString().(value)
//                                                                        ^^^^^^^^ reference semanticdb maven . . kotlin/collections/toString().
//                                                                                          ^^^^^ reference semanticdb maven . . kotlin/text/Charsets#UTF_8.
//                                                                                          ^^^^^ reference semanticdb maven . . kotlin/text/Charsets#getUTF_8().
  }
  
  /**
   * Binary column for storing binary strings of a specific [length].
   */
  open class BinaryColumnType(
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#
//                            display_name BinaryColumnType
//                            documentation ```kotlin\npublic open class BinaryColumnType : BasicBinaryColumnType\n```\n\n----\n\n\n Binary column for storing binary strings of a specific [length].\n
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#`<init>`().
//                            display_name BinaryColumnType
//                            documentation ```kotlin\npublic constructor(length: Int): BinaryColumnType\n```\n\n----\n\n Returns the length of the column-
      /** Returns the length of the column- */
      val length: Int
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#`<init>`().(length)
//               display_name length
//               documentation ```kotlin\nlength: Int\n```\n\n----\n\n Returns the length of the column-
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#`<init>`().(length)
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#getLength().
//               display_name length
//               documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n Returns the length of the column-
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#length.
//               display_name length
//               documentation ```kotlin\npublic final val length: Int\n```\n\n----\n\n Returns the length of the column-
//                ^^^ reference semanticdb maven . . kotlin/Int#
  ) : BasicBinaryColumnType() {
//    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#
      override fun sqlType(): String = currentDialect.dataTypeProvider.binaryType(length)
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType(+1).
//                                                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#getLength().
//                                                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#length.
  
      override fun validateValueBeforeUpdate(value: ByteArray?) {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#validateValueBeforeUpdate().
//                                           display_name validateValueBeforeUpdate
//                                           documentation ```kotlin\npublic open override fun validateValueBeforeUpdate(value: ByteArray?): Unit\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#validateValueBeforeUpdate().
//                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#validateValueBeforeUpdate().(value)
//                                                 display_name value
//                                                 documentation ```kotlin\nvalue: ByteArray?\n```
//                                                  ^^^^^^^^^^ reference semanticdb maven . . kotlin/ByteArray#
          if (value is ByteArray) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#validateValueBeforeUpdate().(value)
              val valueLength = value.size
//                ^^^^^^^^^^^ definition local 13
//                            display_name valueLength
//                            documentation ```kotlin\nlocal val valueLength: Int\n```
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#validateValueBeforeUpdate().(value)
//                                    ^^^^ reference semanticdb maven . . kotlin/ByteArray#getSize().
//                                    ^^^^ reference semanticdb maven . . kotlin/ByteArray#size.
              require(valueLength <= length) {
//            ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                    ^^^^^^^^^^^ reference local 13
//                                ^^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#getLength().
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#length.
                  "Value can't be stored to database column because exceeds length ($valueLength > $length)"
//                                                                                   ^^^^^^^^^^^ reference local 13
//                                                                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#getLength().
//                                                                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#length.
              }
          }
      }
  
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          if (this === other) return true
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#equals().(other)
          if (javaClass != other?.javaClass) return false
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#equals().(other)
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
          if (!super.equals(other)) return false
//            ^ reference semanticdb maven . . kotlin/Boolean#not().
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#equals().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#equals().(other)
  
          other as BinaryColumnType
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#equals().(other)
  
          return length == other.length
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#getLength().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#length.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#equals().(other)
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#getLength().
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#length.
      }
  
      override fun hashCode(): Int {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
          var result = super.hashCode()
//            ^^^^^^ definition local 14
//                   display_name result
//                   documentation ```kotlin\nlocal var result: Int\n```
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#hashCode().
          result = 31 * result + length
//        ^^^^^^ reference local 14
//                    ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                      ^^^^^^ reference local 14
//                             ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#getLength().
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#length.
          return result
//               ^^^^^^ reference local 14
      }
  }
  
  /**
   * Binary column for storing BLOBs.
   */
  class BlobColumnType(
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#
//                     display_name BlobColumnType
//                     documentation ```kotlin\npublic final class BlobColumnType : ColumnType<ExposedBlob>\n```\n\n----\n\n\n Binary column for storing BLOBs.\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#`<init>`().
//                     display_name BlobColumnType
//                     documentation ```kotlin\npublic constructor(useObjectIdentifier: Boolean = ...): BlobColumnType\n```\n\n----\n\n Returns whether an OID column should be used instead of BYTEA. This value only applies to PostgreSQL databases.
      /** Returns whether an OID column should be used instead of BYTEA. This value only applies to PostgreSQL databases. */
      val useObjectIdentifier: Boolean = false
//        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#`<init>`().(useObjectIdentifier)
//                            display_name useObjectIdentifier
//                            documentation ```kotlin\nuseObjectIdentifier: Boolean = ...\n```\n\n----\n\n Returns whether an OID column should be used instead of BYTEA. This value only applies to PostgreSQL databases.
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#`<init>`().(useObjectIdentifier)
//        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#getUseObjectIdentifier().
//                            display_name useObjectIdentifier
//                            documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Returns whether an OID column should be used instead of BYTEA. This value only applies to PostgreSQL databases.
//        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#useObjectIdentifier.
//                            display_name useObjectIdentifier
//                            documentation ```kotlin\npublic final val useObjectIdentifier: Boolean\n```\n\n----\n\n Returns whether an OID column should be used instead of BYTEA. This value only applies to PostgreSQL databases.
//                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  ) : ColumnType<ExposedBlob>() {
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = when {
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
          useObjectIdentifier && currentDialect is PostgreSQLDialect -> "oid"
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#getUseObjectIdentifier().
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#useObjectIdentifier.
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
          useObjectIdentifier -> error("Storing BLOBs using OID columns is only supported by PostgreSQL")
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#getUseObjectIdentifier().
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#useObjectIdentifier.
//                               ^^^^^ reference semanticdb maven . . kotlin/error().
          else -> currentDialect.dataTypeProvider.blobType()
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#blobType().
      }
  
      override fun valueFromDB(value: Any): ExposedBlob = when (value) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): ExposedBlob\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#valueFromDB().(value)
          is ExposedBlob -> value
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#valueFromDB().(value)
          is InputStream -> ExposedBlob(value)
//                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#`<init>`().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#valueFromDB().(value)
          is ByteArray -> ExposedBlob(value)
//                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#`<init>`(+1).
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#valueFromDB().(value)
          is Blob -> ExposedBlob(value.binaryStream)
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#`<init>`().
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#valueFromDB().(value)
//                                     ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/sql/Blob#binaryStream.
//                                     ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/sql/Blob#getBinaryStream().
          is ByteBuffer -> ExposedBlob(value.array())
//                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#`<init>`(+1).
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#valueFromDB().(value)
//                                           ^^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#array().
          else -> error("Unexpected value of type Blob: $value of ${value::class.qualifiedName}")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#valueFromDB().(value)
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#valueFromDB().(value)
//                                                                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
      }
  
      override fun nonNullValueToString(value: ExposedBlob): String {
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#nonNullValueToString().
//                                      display_name nonNullValueToString
//                                      documentation ```kotlin\npublic open override fun nonNullValueToString(value: ExposedBlob): String\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nonNullValueToString().
//                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#nonNullValueToString().(value)
//                                            display_name value
//                                            documentation ```kotlin\nvalue: ExposedBlob\n```
//                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#
//                                                           ^^^^^^ reference semanticdb maven . . kotlin/String#
          // For H2 Blobs the original dataTypeProvider must be taken (even if H2 in other DB mode)
          return ((currentDialect as? H2Dialect)?.originalDataTypeProvider ?: currentDialect.dataTypeProvider)
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getOriginalDataTypeProvider().
//                                                ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#originalDataTypeProvider.
//                                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
              .hexToDb(value.hexString())
//             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#hexToDb().
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#nonNullValueToString().(value)
//                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#hexString().
      }
  
      override fun readObject(rs: RowApi, index: Int) = when {
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#readObject().
//                            display_name readObject
//                            documentation ```kotlin\npublic open override fun readObject(rs: RowApi, index: Int): Any?\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#readObject().
//                            ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#readObject().(rs)
//                               display_name rs
//                               documentation ```kotlin\nrs: RowApi\n```
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#
//                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#readObject().(index)
//                                              display_name index
//                                              documentation ```kotlin\nindex: Int\n```
//                                               ^^^ reference semanticdb maven . . kotlin/Int#
          currentDialect is PostgreSQLDialect && useObjectIdentifier -> {
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#getUseObjectIdentifier().
//                                               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#useObjectIdentifier.
              rs.getObject(index, java.sql.Blob::class.java)?.binaryStream?.let(::ExposedBlob)
//            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#readObject().(rs)
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject(+2).
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#readObject().(index)
//                                                     ^^^^ reference semanticdb maven . . kotlin/jvm/getJava().
//                                                     ^^^^ reference semanticdb maven . . kotlin/jvm/java.
//                                                            ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/sql/Blob#binaryStream.
//                                                            ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/sql/Blob#getBinaryStream().
//                                                                          ^^^ reference semanticdb maven . . kotlin/let().
//                                                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#`<init>`().
          }
          else -> rs.getObject(index)
//                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#readObject().(rs)
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject().
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#readObject().(index)
      }
  
      override fun setParameter(stmt: PreparedStatementApi, index: Int, value: Any?) {
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#setParameter().
//                              display_name setParameter
//                              documentation ```kotlin\npublic open override fun setParameter(stmt: PreparedStatementApi, index: Int, value: Any?): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setParameter().
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#setParameter().(stmt)
//                                   display_name stmt
//                                   documentation ```kotlin\nstmt: PreparedStatementApi\n```
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
//                                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#setParameter().(index)
//                                                                display_name index
//                                                                documentation ```kotlin\nindex: Int\n```
//                                                                 ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#setParameter().(value)
//                                                                            display_name value
//                                                                            documentation ```kotlin\nvalue: Any?\n```
//                                                                             ^^^^ reference semanticdb maven . . kotlin/Any#
          when (val toSetValue = (value as? ExposedBlob)?.inputStream ?: value) {
//                  ^^^^^^^^^^ definition local 15
//                             display_name toSetValue
//                             documentation ```kotlin\nlocal val toSetValue: Any?\n```
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#setParameter().(value)
//                                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#getInputStream().
//                                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#inputStream.
//                                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#setInputStream().
//                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#setParameter().(value)
              is InputStream -> stmt.setInputStream(index, toSetValue, useObjectIdentifier)
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#setParameter().(stmt)
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setInputStream().
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#setParameter().(index)
//                                                         ^^^^^^^^^^ reference local 15
//                                                                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#getUseObjectIdentifier().
//                                                                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#useObjectIdentifier.
              null, is Op.NULL -> stmt.setNull(index, this)
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#setParameter().(stmt)
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setNull().
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#setParameter().(index)
              else -> super.setParameter(stmt, index, toSetValue)
//                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setParameter().
//                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#setParameter().(stmt)
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#setParameter().(index)
//                                                    ^^^^^^^^^^ reference local 15
          }
      }
  }
  
  /**
   * Binary column for storing [UUID].
   */
  class UUIDColumnType : ColumnType<UUID>() {
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#
//                     display_name UUIDColumnType
//                     documentation ```kotlin\npublic final class UUIDColumnType : ColumnType<UUID>\n```\n\n----\n\n\n Binary column for storing [UUID].\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#`<init>`().
//                     display_name UUIDColumnType
//                     documentation ```kotlin\npublic constructor(): UUIDColumnType\n```\n\n----\n\n\n Binary column for storing [UUID].\n
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = currentDialect.dataTypeProvider.uuidType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidType().
  
      override fun valueFromDB(value: Any): UUID = when {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): UUID\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^ reference semanticdb maven jdk 11 java/util/UUID#
          value is UUID -> value
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#valueFromDB().(value)
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#valueFromDB().(value)
          value is ByteArray -> ByteBuffer.wrap(value).let { b -> UUID(b.long, b.long) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#valueFromDB().(value)
//                                         ^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#wrap().
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#valueFromDB().(value)
//                                                     ^^^ reference semanticdb maven . . kotlin/let().
//                                                           ^ definition semanticdb maven . . (b)
//                                                             display_name b
//                                                             documentation ```kotlin\nb: ByteBuffer\n```
//                                                                ^^^^ reference semanticdb maven jdk 11 java/util/UUID#`<init>`().
//                                                                     ^ reference semanticdb maven . . (b)
//                                                                       ^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#getLong().
//                                                                       ^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#long.
//                                                                             ^ reference semanticdb maven . . (b)
//                                                                               ^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#getLong().
//                                                                               ^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#long.
          value is String && value.matches(uuidRegexp) -> UUID.fromString(value)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#valueFromDB().(value)
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#valueFromDB().(value)
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/text/matches().
//                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#Companion#getUuidRegexp().
//                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#Companion#uuidRegexp.
//                                                             ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/UUID#fromString().
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#valueFromDB().(value)
          value is String -> ByteBuffer.wrap(value.toByteArray()).let { b -> UUID(b.long, b.long) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#valueFromDB().(value)
//                                      ^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#wrap().
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#valueFromDB().(value)
//                                                 ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/toByteArray().
//                                                                ^^^ reference semanticdb maven . . kotlin/let().
//                                                                      ^ definition semanticdb maven . . (b)
//                                                                        display_name b
//                                                                        documentation ```kotlin\nb: ByteBuffer\n```
//                                                                           ^^^^ reference semanticdb maven jdk 11 java/util/UUID#`<init>`().
//                                                                                ^ reference semanticdb maven . . (b)
//                                                                                  ^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#getLong().
//                                                                                  ^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#long.
//                                                                                        ^ reference semanticdb maven . . (b)
//                                                                                          ^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#getLong().
//                                                                                          ^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#long.
          value is ByteBuffer -> value.let { b -> UUID(b.long, b.long) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#valueFromDB().(value)
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#valueFromDB().(value)
//                                     ^^^ reference semanticdb maven . . kotlin/let().
//                                           ^ definition semanticdb maven . . (b)
//                                             display_name b
//                                             documentation ```kotlin\nb: ByteBuffer\n```
//                                                ^^^^ reference semanticdb maven jdk 11 java/util/UUID#`<init>`().
//                                                     ^ reference semanticdb maven . . (b)
//                                                       ^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#getLong().
//                                                       ^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#long.
//                                                             ^ reference semanticdb maven . . (b)
//                                                               ^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#getLong().
//                                                               ^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#long.
          else -> error("Unexpected value of type UUID: $value of ${value::class.qualifiedName}")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#valueFromDB().(value)
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#valueFromDB().(value)
//                                                                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
      }
  
      override fun notNullValueToDB(value: UUID): Any {
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#notNullValueToDB().
//                                  display_name notNullValueToDB
//                                  documentation ```kotlin\npublic open override fun notNullValueToDB(value: UUID): Any\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#notNullValueToDB().
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#notNullValueToDB().(value)
//                                        display_name value
//                                        documentation ```kotlin\nvalue: UUID\n```
//                                         ^^^^ reference semanticdb maven jdk 11 java/util/UUID#
//                                                ^^^ reference semanticdb maven . . kotlin/Any#
          return ((currentDialect as? H2Dialect)?.originalDataTypeProvider ?: currentDialect.dataTypeProvider)
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getOriginalDataTypeProvider().
//                                                ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#originalDataTypeProvider.
//                                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
              .uuidToDB(value)
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidToDB().
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#notNullValueToDB().(value)
      }
  
      override fun nonNullValueToString(value: UUID): String = "'$value'"
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#nonNullValueToString().
//                                      display_name nonNullValueToString
//                                      documentation ```kotlin\npublic open override fun nonNullValueToString(value: UUID): String\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nonNullValueToString().
//                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#nonNullValueToString().(value)
//                                            display_name value
//                                            documentation ```kotlin\nvalue: UUID\n```
//                                             ^^^^ reference semanticdb maven jdk 11 java/util/UUID#
//                                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#nonNullValueToString().(value)
  
      @Suppress("MagicNumber")
      override fun readObject(rs: RowApi, index: Int): Any? {
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#readObject().
//                            display_name readObject
//                            documentation ```kotlin\n@Suppress(...) public open override fun readObject(rs: RowApi, index: Int): Any?\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#readObject().
//                            ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#readObject().(rs)
//                               display_name rs
//                               documentation ```kotlin\nrs: RowApi\n```
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#
//                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#readObject().(index)
//                                              display_name index
//                                              documentation ```kotlin\nindex: Int\n```
//                                               ^^^ reference semanticdb maven . . kotlin/Int#
//                                                     ^^^^ reference semanticdb maven . . kotlin/Any#
          @OptIn(InternalApi::class)
          val db = CoreTransactionManager.currentTransaction().db
//            ^^ definition local 16
//               display_name db
//               documentation ```kotlin\n@OptIn(...) local val db: DatabaseApi\n```
//                                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
          if (currentDialect is MariaDBDialect && !db.version.covers(10)) {
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                 ^^ reference local 16
//                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getVersion().
//                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#version.
//                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+3).
              return rs.getObject(index, java.sql.Array::class.java)
//                   ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#readObject().(rs)
//                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject(+2).
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#readObject().(index)
//                                                             ^^^^ reference semanticdb maven . . kotlin/jvm/getJava().
//                                                             ^^^^ reference semanticdb maven . . kotlin/jvm/java.
          }
          return super.readObject(rs, index)
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#readObject().
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#readObject().(rs)
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#readObject().(index)
      }
  
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#Companion# 3:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#Companion#`<init>`(). 3:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): UUIDColumnType.Companion\n```
          private val uuidRegexp =
//                    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#Companion#getUuidRegexp().
//                               display_name uuidRegexp
//                               documentation ```kotlin\nprivate get(): Regex\n```
//                    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#Companion#uuidRegexp.
//                               display_name uuidRegexp
//                               documentation ```kotlin\nprivate final val uuidRegexp: Regex\n```
              Regex("[0-9A-F]{8}-[0-9A-F]{4}-[0-9A-F]{4}-[0-9A-F]{4}-[0-9A-F]{12}", RegexOption.IGNORE_CASE)
//            ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+2).
//                                                                                              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/RegexOption#IGNORE_CASE.
      }
  }
  
  // Boolean columns
  
  /**
   * Boolean column for storing boolean values.
   */
  class BooleanColumnType : ColumnType<Boolean>() {
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#
//                        display_name BooleanColumnType
//                        documentation ```kotlin\npublic final class BooleanColumnType : ColumnType<Boolean>\n```\n\n----\n\n\n Boolean column for storing boolean values.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#`<init>`().
//                        display_name BooleanColumnType
//                        documentation ```kotlin\npublic constructor(): BooleanColumnType\n```\n\n----\n\n\n Boolean column for storing boolean values.\n
//                          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = currentDialect.dataTypeProvider.booleanType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanType().
  
      override fun valueFromDB(value: Any): Boolean = when (value) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\npublic open override fun valueFromDB(value: Any): Boolean\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                          ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#valueFromDB().(value)
          is Number -> value.toLong() != 0L
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#valueFromDB().(value)
//                           ^^^^^^ reference semanticdb maven . . kotlin/Number#toLong().
          is String -> currentDialect.dataTypeProvider.booleanFromStringToBoolean(value)
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanFromStringToBoolean().
//                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#valueFromDB().(value)
          else -> value.toString().toBoolean()
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#valueFromDB().(value)
//                      ^^^^^^^^ reference semanticdb maven . . kotlin/Any#toString().
//                                 ^^^^^^^^^ reference semanticdb maven . . kotlin/text/toBoolean().
      }
  
      override fun nonNullValueToString(value: Boolean): String =
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#nonNullValueToString().
//                                      display_name nonNullValueToString
//                                      documentation ```kotlin\npublic open override fun nonNullValueToString(value: Boolean): String\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nonNullValueToString().
//                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#nonNullValueToString().(value)
//                                            display_name value
//                                            documentation ```kotlin\nvalue: Boolean\n```
//                                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
          currentDialect.dataTypeProvider.booleanToStatementString(value)
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanToStatementString().
//                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#nonNullValueToString().(value)
  
      override fun notNullValueToDB(value: Boolean): Any = when {
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#notNullValueToDB().
//                                  display_name notNullValueToDB
//                                  documentation ```kotlin\npublic open override fun notNullValueToDB(value: Boolean): Any\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#notNullValueToDB().
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#notNullValueToDB().(value)
//                                        display_name value
//                                        documentation ```kotlin\nvalue: Boolean\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                   ^^^ reference semanticdb maven . . kotlin/Any#
          (currentDialect is OracleDialect || currentDialect.h2Mode == H2Dialect.H2CompatibilityMode.Oracle) ->
//         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
              nonNullValueToString(value)
//            ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#nonNullValueToString().
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#notNullValueToDB().(value)
  
          else -> value
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#notNullValueToDB().(value)
      }
  
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#Companion# 2:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#Companion#`<init>`(). 2:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): BooleanColumnType.Companion\n```
          internal val INSTANCE = BooleanColumnType()
//                     ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#Companion#INSTANCE.
//                              display_name INSTANCE
//                              documentation ```kotlin\ninternal final val INSTANCE: BooleanColumnType\n```
//                     ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#Companion#getINSTANCE().
//                              display_name INSTANCE
//                              documentation ```kotlin\ninternal get(): BooleanColumnType\n```
//                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#`<init>`().
      }
  }
  
  // Enumeration columns
  
  /**
   * Enumeration column for storing enums of type [klass] by their ordinal.
   */
  class EnumerationColumnType<T : Enum<T>>(
//      ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#
//                            display_name EnumerationColumnType
//                            documentation ```kotlin\npublic final class EnumerationColumnType<T : Enum<T>> : ColumnType<T>\n```\n\n----\n\n\n Enumeration column for storing enums of type [klass] by their ordinal.\n
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#`<init>`().
//                            display_name EnumerationColumnType
//                            documentation ```kotlin\npublic constructor<T : Enum<T>>(klass: KClass<T>): EnumerationColumnType<T>\n```\n\n----\n\n Returns the enum class used in this column type.
//                            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#[T]
//                              display_name FirTypeParameterSymbol T
//                              documentation ```kotlin\nT : Enum<T>\n```
      /** Returns the enum class used in this column type. */
      val klass: KClass<T>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#`<init>`().(klass)
//              display_name klass
//              documentation ```kotlin\nklass: KClass<T>\n```\n\n----\n\n Returns the enum class used in this column type.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#`<init>`().(klass)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#getKlass().
//              display_name klass
//              documentation ```kotlin\npublic get(): KClass<T>\n```\n\n----\n\n Returns the enum class used in this column type.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#klass.
//              display_name klass
//              documentation ```kotlin\npublic final val klass: KClass<T>\n```\n\n----\n\n Returns the enum class used in this column type.
//               ^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#
  ) : ColumnType<T>() {
//    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = currentDialect.dataTypeProvider.integerType()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerType().
      private val enumConstants by lazy { klass.java.enumConstants!! }
//                ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#enumConstants.
//                              display_name enumConstants
//                              documentation ```kotlin\nprivate final val enumConstants: ft<Array<T!>, Array<out T!>>\n```
//                ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#getEnumConstants().
//                              display_name enumConstants
//                              documentation ```kotlin\nprivate get(): ft<Array<T!>, Array<out T!>>\n```
//                                 ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#enumConstants.
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#getEnumConstants().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#getKlass().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#klass.
//                                              ^^^^ reference semanticdb maven . . kotlin/jvm/getJava().
//                                              ^^^^ reference semanticdb maven . . kotlin/jvm/java.
//                                                   ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#enumConstants.
//                                                   ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#getEnumConstants().
  
      @Suppress("UNCHECKED_CAST")
      override fun valueFromDB(value: Any): T = when (value) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\n@Suppress(...) public open override fun valueFromDB(value: Any): T\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#valueFromDB().(value)
          is Number -> enumConstants[value.toInt()]
//                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#enumConstants.
//                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#getEnumConstants().
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#get().
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#valueFromDB().(value)
//                                         ^^^^^ reference semanticdb maven . . kotlin/Number#toInt().
          is Enum<*> -> value as T
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#valueFromDB().(value)
          else -> error("$value of ${value::class.qualifiedName} is not valid for enum ${klass.simpleName}")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#valueFromDB().(value)
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#valueFromDB().(value)
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
//                                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#getKlass().
//                                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#klass.
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getSimpleName().
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#simpleName.
      }
  
      override fun notNullValueToDB(value: T): Int = value.ordinal
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#notNullValueToDB().
//                                  display_name notNullValueToDB
//                                  documentation ```kotlin\npublic open override fun notNullValueToDB(value: T): Int\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#notNullValueToDB().
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#notNullValueToDB().(value)
//                                        display_name value
//                                        documentation ```kotlin\nvalue: T\n```
//                                             ^^^ reference semanticdb maven . . kotlin/Int#
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#notNullValueToDB().(value)
//                                                         ^^^^^^^ reference semanticdb maven . . kotlin/Enum#getOrdinal().
//                                                         ^^^^^^^ reference semanticdb maven . . kotlin/Enum#ordinal.
  
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          if (this === other) return true
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#equals().(other)
          if (javaClass != other?.javaClass) return false
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#equals().(other)
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
          if (!super.equals(other)) return false
//            ^ reference semanticdb maven . . kotlin/Boolean#not().
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#equals().(other)
  
          other as EnumerationColumnType<*>
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#equals().(other)
  
          return klass == other.klass
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#getKlass().
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#klass.
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#equals().(other)
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#getKlass().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#klass.
      }
  
      override fun hashCode(): Int {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
          var result = super.hashCode()
//            ^^^^^^ definition local 17
//                   display_name result
//                   documentation ```kotlin\nlocal var result: Int\n```
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#hashCode().
          result = 31 * result + klass.hashCode()
//        ^^^^^^ reference local 17
//                    ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                      ^^^^^^ reference local 17
//                             ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#getKlass().
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#klass.
//                                     ^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#hashCode().
          return result
//               ^^^^^^ reference local 17
      }
  }
  
  /**
   * Enumeration column for storing enums of type [klass] by their name.
   */
  class EnumerationNameColumnType<T : Enum<T>>(
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#
//                                display_name EnumerationNameColumnType
//                                documentation ```kotlin\npublic final class EnumerationNameColumnType<T : Enum<T>> : ColumnType<T>\n```\n\n----\n\n\n Enumeration column for storing enums of type [klass] by their name.\n
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#`<init>`().
//                                display_name EnumerationNameColumnType
//                                documentation ```kotlin\npublic constructor<T : Enum<T>>(klass: KClass<T>, colLength: Int): EnumerationNameColumnType<T>\n```\n\n----\n\n Returns the enum class used in this column type.
//                                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#[T]
//                                  display_name FirTypeParameterSymbol T
//                                  documentation ```kotlin\nT : Enum<T>\n```
      /** Returns the enum class used in this column type. */
      val klass: KClass<T>,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#`<init>`().(klass)
//              display_name klass
//              documentation ```kotlin\nklass: KClass<T>\n```\n\n----\n\n Returns the enum class used in this column type.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#`<init>`().(klass)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#getKlass().
//              display_name klass
//              documentation ```kotlin\npublic get(): KClass<T>\n```\n\n----\n\n Returns the enum class used in this column type.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#klass.
//              display_name klass
//              documentation ```kotlin\npublic final val klass: KClass<T>\n```\n\n----\n\n Returns the enum class used in this column type.
//               ^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#
      val colLength: Int
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#`<init>`().(colLength)
//                  display_name colLength
//                  documentation ```kotlin\ncolLength: Int\n```
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#`<init>`().(colLength)
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#colLength.
//                  display_name colLength
//                  documentation ```kotlin\npublic final val colLength: Int\n```
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#getColLength().
//                  display_name colLength
//                  documentation ```kotlin\npublic get(): Int\n```
//                   ^^^ reference semanticdb maven . . kotlin/Int#
  ) : ColumnType<T>() {
//    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      private val enumConstants by lazy { klass.java.enumConstants!!.associateBy { it.name } }
//                ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#enumConstants.
//                              display_name enumConstants
//                              documentation ```kotlin\nprivate final val enumConstants: Map<String, T!>\n```
//                ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#getEnumConstants().
//                              display_name enumConstants
//                              documentation ```kotlin\nprivate get(): Map<String, T!>\n```
//                                 ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#enumConstants.
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#getEnumConstants().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#getKlass().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#klass.
//                                              ^^^^ reference semanticdb maven . . kotlin/jvm/getJava().
//                                              ^^^^ reference semanticdb maven . . kotlin/jvm/java.
//                                                   ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#enumConstants.
//                                                   ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#getEnumConstants().
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/associateBy().
//                                                                               ^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                           display_name it
//                                                                                           documentation ```kotlin\nit: Any?\n```
//                                                                                 ^^ reference semanticdb maven . . (it)
//                                                                                    ^^^^ reference semanticdb maven . . kotlin/Enum#getName().
//                                                                                    ^^^^ reference semanticdb maven . . kotlin/Enum#name.
  
      override fun sqlType(): String = currentDialect.dataTypeProvider.varcharType(colLength)
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#varcharType().
//                                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#colLength.
//                                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#getColLength().
  
      @Suppress("UNCHECKED_CAST")
      override fun valueFromDB(value: Any): T = when (value) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\n@Suppress(...) public open override fun valueFromDB(value: Any): T\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#valueFromDB().(value)
          is String -> {
              enumConstants[value] ?: error("$value can't be associated with any from enum ${klass.qualifiedName}")
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#enumConstants.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#getEnumConstants().
//            ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#valueFromDB().(value)
//                                    ^^^^^ reference semanticdb maven . . kotlin/error().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#valueFromDB().(value)
//                                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#getKlass().
//                                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#klass.
//                                                                                                 ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                                                 ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
          }
  
          is Enum<*> -> value as T
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#valueFromDB().(value)
          else -> error("$value of ${value::class.qualifiedName} is not valid for enum ${klass.qualifiedName}")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#valueFromDB().(value)
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#valueFromDB().(value)
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
//                                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#getKlass().
//                                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#klass.
//                                                                                             ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                                                             ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
      }
  
      override fun notNullValueToDB(value: T): Any = value.name
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#notNullValueToDB().
//                                  display_name notNullValueToDB
//                                  documentation ```kotlin\npublic open override fun notNullValueToDB(value: T): Any\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#notNullValueToDB().
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#notNullValueToDB().(value)
//                                        display_name value
//                                        documentation ```kotlin\nvalue: T\n```
//                                             ^^^ reference semanticdb maven . . kotlin/Any#
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#notNullValueToDB().(value)
//                                                         ^^^^ reference semanticdb maven . . kotlin/Enum#getName().
//                                                         ^^^^ reference semanticdb maven . . kotlin/Enum#name.
  
      override fun nonNullValueToString(value: T): String = buildString {
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#nonNullValueToString().
//                                      display_name nonNullValueToString
//                                      documentation ```kotlin\npublic open override fun nonNullValueToString(value: T): String\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nonNullValueToString().
//                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#nonNullValueToString().(value)
//                                            display_name value
//                                            documentation ```kotlin\nvalue: T\n```
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                          ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
          append('\'')
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
          append(escape(value.name))
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#escape().
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#nonNullValueToString().(value)
//                            ^^^^ reference semanticdb maven . . kotlin/Enum#getName().
//                            ^^^^ reference semanticdb maven . . kotlin/Enum#name.
          append('\'')
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
      }
  
      override fun validateValueBeforeUpdate(value: T?) {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#validateValueBeforeUpdate().
//                                           display_name validateValueBeforeUpdate
//                                           documentation ```kotlin\npublic open override fun validateValueBeforeUpdate(value: T?): Unit\n```
//                                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#validateValueBeforeUpdate().
//                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#validateValueBeforeUpdate().(value)
//                                                 display_name value
//                                                 documentation ```kotlin\nvalue: T?\n```
          if (value != null) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#validateValueBeforeUpdate().(value)
              val valueLength = value.name.codePointCount(0, value.name.length)
//                ^^^^^^^^^^^ definition local 18
//                            display_name valueLength
//                            documentation ```kotlin\nlocal val valueLength: Int\n```
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#validateValueBeforeUpdate().(value)
//                                    ^^^^ reference semanticdb maven . . kotlin/Enum#getName().
//                                    ^^^^ reference semanticdb maven . . kotlin/Enum#name.
//                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/codePointCount().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#validateValueBeforeUpdate().(value)
//                                                                 ^^^^ reference semanticdb maven . . kotlin/Enum#getName().
//                                                                 ^^^^ reference semanticdb maven . . kotlin/Enum#name.
//                                                                      ^^^^^^ reference semanticdb maven . . kotlin/String#getLength().
//                                                                      ^^^^^^ reference semanticdb maven . . kotlin/String#length.
              require(valueLength <= colLength) {
//            ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                    ^^^^^^^^^^^ reference local 18
//                                ^^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#colLength.
//                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#getColLength().
                  "Value can't be stored to database column because exceeds length ($valueLength > $colLength)"
//                                                                                   ^^^^^^^^^^^ reference local 18
//                                                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#colLength.
//                                                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#getColLength().
              }
          }
      }
  
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          if (this === other) return true
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#equals().(other)
          if (javaClass != other?.javaClass) return false
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#equals().(other)
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
          if (!super.equals(other)) return false
//            ^ reference semanticdb maven . . kotlin/Boolean#not().
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#equals().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#equals().(other)
  
          other as EnumerationNameColumnType<*>
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#equals().(other)
  
          return klass == other.klass
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#getKlass().
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#klass.
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#equals().(other)
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#getKlass().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#klass.
      }
  
      override fun hashCode(): Int {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
          var result = super.hashCode()
//            ^^^^^^ definition local 19
//                   display_name result
//                   documentation ```kotlin\nlocal var result: Int\n```
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#hashCode().
          result = 31 * result + klass.hashCode()
//        ^^^^^^ reference local 19
//                    ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                      ^^^^^^ reference local 19
//                             ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#getKlass().
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#klass.
//                                     ^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#hashCode().
          return result
//               ^^^^^^ reference local 19
      }
  
      private fun escape(value: String): String = value.map { charactersToEscape[it] ?: it }.joinToString("")
//                ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#escape().
//                       display_name escape
//                       documentation ```kotlin\nprivate final fun escape(value: String): String\n```
//                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#escape().(value)
//                             display_name value
//                             documentation ```kotlin\nvalue: String\n```
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#escape().(value)
//                                                      ^^^ reference semanticdb maven . . kotlin/text/map().
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                           display_name it
//                                                                                           documentation ```kotlin\nit: Any?\n```
//                                                            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#Companion#charactersToEscape.
//                                                            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#Companion#getCharactersToEscape().
//                                                            ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                                               ^^ reference semanticdb maven . . (it)
//                                                                                      ^^ reference semanticdb maven . . (it)
//                                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
  
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#Companion# 6:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#Companion#`<init>`(). 6:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): EnumerationNameColumnType.Companion\n```
          private val charactersToEscape = mapOf(
//                    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#Companion#charactersToEscape.
//                                       display_name charactersToEscape
//                                       documentation ```kotlin\nprivate final val charactersToEscape: Map<Char, String>\n```
//                    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#Companion#getCharactersToEscape().
//                                       display_name charactersToEscape
//                                       documentation ```kotlin\nprivate get(): Map<Char, String>\n```
//                                         ^^^^^ reference semanticdb maven . . kotlin/collections/mapOf(+1).
              '\'' to "\'\'",
//                 ^^ reference semanticdb maven . . kotlin/to().
              '\r' to "\\r",
//                 ^^ reference semanticdb maven . . kotlin/to().
              '\n' to "\\n"
//                 ^^ reference semanticdb maven . . kotlin/to().
          )
      }
  }
  
  /**
   * Enumeration column for storing enums of type [T] using the custom SQL type [sql].
   */
  class CustomEnumerationColumnType<T : Enum<T>>(
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#
//                                  display_name CustomEnumerationColumnType
//                                  documentation ```kotlin\npublic final class CustomEnumerationColumnType<T : Enum<T>> : ColumnType<T>\n```\n\n----\n\n\n Enumeration column for storing enums of type [T] using the custom SQL type [sql].\n
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#`<init>`().
//                                  display_name CustomEnumerationColumnType
//                                  documentation ```kotlin\npublic constructor<T : Enum<T>>(name: String, sql: String?, fromDb: (Any) -> T, toDb: (T) -> Any): CustomEnumerationColumnType<T>\n```\n\n----\n\n Returns the name of this column type instance.
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#[T]
//                                    display_name FirTypeParameterSymbol T
//                                    documentation ```kotlin\nT : Enum<T>\n```
      /** Returns the name of this column type instance. */
      val name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#`<init>`().(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```\n\n----\n\n Returns the name of this column type instance.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#`<init>`().(name)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#getName().
//             display_name name
//             documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Returns the name of this column type instance.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#name.
//             display_name name
//             documentation ```kotlin\npublic final val name: String\n```\n\n----\n\n Returns the name of this column type instance.
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
      /** Returns the SQL definition used for this column type. */
      val sql: String?,
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#`<init>`().(sql)
//            display_name sql
//            documentation ```kotlin\nsql: String?\n```\n\n----\n\n Returns the SQL definition used for this column type.
//        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#`<init>`().(sql)
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#getSql().
//            display_name sql
//            documentation ```kotlin\npublic get(): String?\n```\n\n----\n\n Returns the SQL definition used for this column type.
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#sql.
//            display_name sql
//            documentation ```kotlin\npublic final val sql: String?\n```\n\n----\n\n Returns the SQL definition used for this column type.
//             ^^^^^^^ reference semanticdb maven . . kotlin/String#
      /** Returns the function that converts a value received from a database to an enumeration instance [T]. */
      val fromDb: (Any) -> T,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#`<init>`().(fromDb)
//               display_name fromDb
//               documentation ```kotlin\nfromDb: (Any) -> T\n```\n\n----\n\n Returns the function that converts a value received from a database to an enumeration instance [T].
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#`<init>`().(fromDb)
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#fromDb.
//               display_name fromDb
//               documentation ```kotlin\npublic final val fromDb: (Any) -> T\n```\n\n----\n\n Returns the function that converts a value received from a database to an enumeration instance [T].
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#getFromDb().
//               display_name fromDb
//               documentation ```kotlin\npublic get(): (Any) -> T\n```\n\n----\n\n Returns the function that converts a value received from a database to an enumeration instance [T].
//                ^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      /** Returns the function that converts an enumeration instance [T] to a value that will be stored to a database. */
      val toDb: (T) -> Any
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#`<init>`().(toDb)
//             display_name toDb
//             documentation ```kotlin\ntoDb: (T) -> Any\n```\n\n----\n\n Returns the function that converts an enumeration instance [T] to a value that will be stored to a database.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#`<init>`().(toDb)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#getToDb().
//             display_name toDb
//             documentation ```kotlin\npublic get(): (T) -> Any\n```\n\n----\n\n Returns the function that converts an enumeration instance [T] to a value that will be stored to a database.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#toDb.
//             display_name toDb
//             documentation ```kotlin\npublic final val toDb: (T) -> Any\n```\n\n----\n\n Returns the function that converts an enumeration instance [T] to a value that will be stored to a database.
//              ^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
  ) : ColumnType<T>() {
//    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      override fun sqlType(): String = sql ?: error("Column $name should exist in database")
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#getSql().
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#sql.
//                                            ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#getName().
//                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#name.
  
      @Suppress("UNCHECKED_CAST")
      override fun valueFromDB(value: Any): T = if (value::class.isSubclassOf(Enum::class)) value as T else fromDb(value)
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\n@Suppress(...) public open override fun valueFromDB(value: Any): T\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#valueFromDB().(value)
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/isSubclassOf().
//                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#valueFromDB().(value)
//                                                                                                          ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#fromDb.
//                                                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#getFromDb().
//                                                                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#valueFromDB().(value)
  
      override fun notNullValueToDB(value: T): Any = toDb(value)
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#notNullValueToDB().
//                                  display_name notNullValueToDB
//                                  documentation ```kotlin\npublic open override fun notNullValueToDB(value: T): Any\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#notNullValueToDB().
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#notNullValueToDB().(value)
//                                        display_name value
//                                        documentation ```kotlin\nvalue: T\n```
//                                             ^^^ reference semanticdb maven . . kotlin/Any#
//                                                   ^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#getToDb().
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#toDb.
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#notNullValueToDB().(value)
  
      override fun nonNullValueToString(value: T): String = buildString {
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#nonNullValueToString().
//                                      display_name nonNullValueToString
//                                      documentation ```kotlin\npublic open override fun nonNullValueToString(value: T): String\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nonNullValueToString().
//                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#nonNullValueToString().(value)
//                                            display_name value
//                                            documentation ```kotlin\nvalue: T\n```
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                          ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
          append('\'')
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
          append(escape(notNullValueToDB(value).toString()))
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#escape().
//                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#notNullValueToDB().
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#nonNullValueToString().(value)
//                                              ^^^^^^^^ reference semanticdb maven . . kotlin/Any#toString().
          append('\'')
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
      }
  
      private fun escape(value: String): String = value.map { charactersToEscape[it] ?: it }.joinToString("")
//                ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#escape().
//                       display_name escape
//                       documentation ```kotlin\nprivate final fun escape(value: String): String\n```
//                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#escape().(value)
//                             display_name value
//                             documentation ```kotlin\nvalue: String\n```
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#escape().(value)
//                                                      ^^^ reference semanticdb maven . . kotlin/text/map().
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                           display_name it
//                                                                                           documentation ```kotlin\nit: Any?\n```
//                                                            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#Companion#charactersToEscape.
//                                                            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#Companion#getCharactersToEscape().
//                                                            ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                                               ^^ reference semanticdb maven . . (it)
//                                                                                      ^^ reference semanticdb maven . . (it)
//                                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
  
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#Companion# 6:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#Companion#`<init>`(). 6:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): CustomEnumerationColumnType.Companion\n```
          private val charactersToEscape = mapOf(
//                    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#Companion#charactersToEscape.
//                                       display_name charactersToEscape
//                                       documentation ```kotlin\nprivate final val charactersToEscape: Map<Char, String>\n```
//                    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#Companion#getCharactersToEscape().
//                                       display_name charactersToEscape
//                                       documentation ```kotlin\nprivate get(): Map<Char, String>\n```
//                                         ^^^^^ reference semanticdb maven . . kotlin/collections/mapOf(+1).
              '\'' to "\'\'",
//                 ^^ reference semanticdb maven . . kotlin/to().
              '\r' to "\\r",
//                 ^^ reference semanticdb maven . . kotlin/to().
              '\n' to "\\n"
//                 ^^ reference semanticdb maven . . kotlin/to().
          )
      }
  }
  
  // Array columns
  
  /**
   * Multi-dimensional array column type for storing a collection of nested elements.
   *
   * @property delegate The base column type associated with this array column's individual elements.
   * @property dimensions The number of dimensions of the multi-dimensional array.
   * @property maximumCardinality The maximum cardinality (number of allowed elements) for each dimension of the array.
   *
   * **Note:** The maximum cardinality is considered for each dimension, but it is ignored by the PostgreSQL database.
   */
  class ArrayColumnType<T, R : List<Any?>>(
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#
//                      display_name ArrayColumnType
//                      documentation ```kotlin\npublic final class ArrayColumnType<T, R : List<Any?>> : ColumnType<R>\n```\n\n----\n\n\n Multi-dimensional array column type for storing a collection of nested elements.\n\n @property delegate The base column type associated with this array column's individual elements.\n @property dimensions The number of dimensions of the multi-dimensional array.\n @property maximumCardinality The maximum cardinality (number of allowed elements) for each dimension of the array.\n\n **Note:** The maximum cardinality is considered for each dimension, but it is ignored by the PostgreSQL database.\n
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`().
//                      display_name ArrayColumnType
//                      documentation ```kotlin\npublic constructor<T, R : List<Any?>>(delegate: IColumnType<T & Any>, maximumCardinality: List<Int>? = ..., dimensions: Int = ...): ArrayColumnType<T, R>\n```
//                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#[T]
//                        display_name FirTypeParameterSymbol T
//                        documentation ```kotlin\nT\n```
//                         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#[R]
//                           display_name FirTypeParameterSymbol R
//                           documentation ```kotlin\nR : List<Any?>\n```
      val delegate: IColumnType<T & Any>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`().(delegate)
//                 display_name delegate
//                 documentation ```kotlin\ndelegate: IColumnType<T & Any>\n```
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`().(delegate)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegate.
//                 display_name delegate
//                 documentation ```kotlin\npublic final val delegate: IColumnType<T & Any>\n```
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegate().
//                 display_name delegate
//                 documentation ```kotlin\npublic get(): IColumnType<T & Any>\n```
//                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
      val maximumCardinality: List<Int>? = null,
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`().(maximumCardinality)
//                           display_name maximumCardinality
//                           documentation ```kotlin\nmaximumCardinality: List<Int>? = ...\n```
//        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`().(maximumCardinality)
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getMaximumCardinality().
//                           display_name maximumCardinality
//                           documentation ```kotlin\npublic get(): List<Int>?\n```
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#maximumCardinality.
//                           display_name maximumCardinality
//                           documentation ```kotlin\npublic final val maximumCardinality: List<Int>?\n```
//                            ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
      val dimensions: Int = 1
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`().(dimensions)
//                   display_name dimensions
//                   documentation ```kotlin\ndimensions: Int = ...\n```
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`().(dimensions)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#dimensions.
//                   display_name dimensions
//                   documentation ```kotlin\npublic final val dimensions: Int\n```
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDimensions().
//                   display_name dimensions
//                   documentation ```kotlin\npublic get(): Int\n```
//                    ^^^ reference semanticdb maven . . kotlin/Int#
  ) : ColumnType<R>() {
//    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
  
      private val nullElementString = "null"
//                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getNullElementString().
//                                  display_name nullElementString
//                                  documentation ```kotlin\nprivate get(): String\n```
//                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#nullElementString.
//                                  display_name nullElementString
//                                  documentation ```kotlin\nprivate final val nullElementString: String\n```
  
      /**
//    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1). 6:136
//        display_name ArrayColumnType
//        documentation ```kotlin\npublic constructor<T, R : List<Any?>>(delegate: ColumnType<T & Any>, maximumCardinality: Int? = ...): ArrayColumnType<T, R>\n```\n\n----\n\n\n Constructor with maximum cardinality for a single dimension.\n\n @param delegate The base column type associated with this array column's individual elements.\n @param maximumCardinality The maximum cardinality (number of allowed elements) for the array.\n
       * Constructor with maximum cardinality for a single dimension.
       *
       * @param delegate The base column type associated with this array column's individual elements.
       * @param maximumCardinality The maximum cardinality (number of allowed elements) for the array.
       */
      constructor(delegate: ColumnType<T & Any>, maximumCardinality: Int? = null) : this(delegate, maximumCardinality?.let { listOf(it) })
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).(delegate)
//                         display_name delegate
//                         documentation ```kotlin\ndelegate: ColumnType<T & Any>\n```
//                          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                                               ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).(maximumCardinality)
//                                                                  display_name maximumCardinality
//                                                                  documentation ```kotlin\nmaximumCardinality: Int? = ...\n```
//                                                                   ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).(delegate)
//                                                                                                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).(maximumCardinality)
//                                                                                                                     ^^^ reference semanticdb maven . . kotlin/let().
//                                                                                                                         ^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                                        display_name it
//                                                                                                                                        documentation ```kotlin\nit: Any?\n```
//                                                                                                                           ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                                                                                                  ^^ reference semanticdb maven . . (it)
  
      /**
       * The SQL type definition of the delegate column type without any potential array dimensions.
       */
      val delegateType: String
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegateType.
//                     display_name delegateType
//                     documentation ```kotlin\npublic final val delegateType: String\n```\n\n----\n\n\n The SQL type definition of the delegate column type without any potential array dimensions.\n
//                      ^^^^^^ reference semanticdb maven . . kotlin/String#
          get() = delegate.sqlType().substringBefore('(')
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegateType().
//            display_name delegateType
//            documentation ```kotlin\npublic get(): String\n```
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegate.
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegate().
//                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
//                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringBefore().
  
      override fun sqlType(): String = buildString {
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#sqlType().
//                         display_name sqlType
//                         documentation ```kotlin\npublic open override fun sqlType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
          if (maximumCardinality != null) {
//            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getMaximumCardinality().
//            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#maximumCardinality.
              require(maximumCardinality.size == dimensions) {
//            ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getMaximumCardinality().
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#maximumCardinality.
//                                       ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                       ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#dimensions.
//                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDimensions().
                  "The size of cardinality list must be equal to the amount of array dimensions. " +
                      "Dimensions: $dimensions, cardinality size: ${maximumCardinality.size}"
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#dimensions.
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDimensions().
//                                                                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getMaximumCardinality().
//                                                                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#maximumCardinality.
//                                                                                     ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                                                                     ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
              }
          }
          append(delegate.sqlType())
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegate.
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegate().
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
          when {
              currentDialect is H2Dialect -> {
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
                  require(dimensions == 1) {
//                ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#dimensions.
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDimensions().
                      "H2 does not support multidimensional arrays. " +
                          "`dimensions` parameter for H2 database must be 1"
                  }
                  append(" ARRAY", maximumCardinality?.let { "[${it.first()}]" } ?: "")
//                ^^^^^^ reference semanticdb maven . . kotlin/text/append(+4).
//                                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getMaximumCardinality().
//                                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#maximumCardinality.
//                                                     ^^^ reference semanticdb maven . . kotlin/let().
//                                                         ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                               display_name it
//                                                                               documentation ```kotlin\nit: Any?\n```
//                                                               ^^ reference semanticdb maven . . (it)
//                                                                  ^^^^^ reference semanticdb maven . . kotlin/collections/first(+19).
              }
  
              else -> append(maximumCardinality?.let { cardinality -> cardinality.joinToString("") { "[$it]" } } ?: "[]".repeat(dimensions))
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                           ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getMaximumCardinality().
//                           ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#maximumCardinality.
//                                               ^^^ reference semanticdb maven . . kotlin/let().
//                                                     ^^^^^^^^^^^ definition semanticdb maven . . (cardinality)
//                                                                 display_name cardinality
//                                                                 documentation ```kotlin\ncardinality: List<Int>\n```
//                                                                    ^^^^^^^^^^^ reference semanticdb maven . . (cardinality)
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                                 ^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                             display_name it
//                                                                                                             documentation ```kotlin\nit: Any?\n```
//                                                                                                      ^^ reference semanticdb maven . . (it)
//                                                                                                                       ^^^^^^ reference semanticdb maven . . kotlin/text/repeat().
//                                                                                                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#dimensions.
//                                                                                                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDimensions().
          }
      }
  
      override fun notNullValueToDB(value: R): Any {
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#notNullValueToDB().
//                                  display_name notNullValueToDB
//                                  documentation ```kotlin\npublic open override fun notNullValueToDB(value: R): Any\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#notNullValueToDB().
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#notNullValueToDB().(value)
//                                        display_name value
//                                        documentation ```kotlin\nvalue: R\n```
//                                             ^^^ reference semanticdb maven . . kotlin/Any#
          return recursiveNotNullValueToDB(value, dimensions)
//               ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNotNullValueToDB().
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#notNullValueToDB().(value)
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#dimensions.
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDimensions().
      }
  
      private fun recursiveNotNullValueToDB(value: Any, level: Int): Array<Any?> = when {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNotNullValueToDB().
//                                          display_name recursiveNotNullValueToDB
//                                          documentation ```kotlin\nprivate final fun recursiveNotNullValueToDB(value: Any, level: Int): Array<Any?>\n```
//                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNotNullValueToDB().(value)
//                                                display_name value
//                                                documentation ```kotlin\nvalue: Any\n```
//                                                 ^^^ reference semanticdb maven . . kotlin/Any#
//                                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNotNullValueToDB().(level)
//                                                            display_name level
//                                                            documentation ```kotlin\nlevel: Int\n```
//                                                             ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
          level > 1 -> (value as List<Any>).map { recursiveNotNullValueToDB(it, level - 1) }.toTypedArray()
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNotNullValueToDB().(level)
//              ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNotNullValueToDB().(value)
//                                          ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                           display_name it
//                                                                                           documentation ```kotlin\nit: Any?\n```
//                                                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNotNullValueToDB().
//                                                                          ^^ reference semanticdb maven . . (it)
//                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNotNullValueToDB().(level)
//                                                                                    ^ reference semanticdb maven . . kotlin/Int#minus(+2).
//                                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/toTypedArray().
          else -> (value as List<T>).map { it?.let { delegate.notNullValueToDB(it) } }.toTypedArray()
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNotNullValueToDB().(value)
//                                   ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                     display_name it
//                                                                                     documentation ```kotlin\nit: Any?\n```
//                                         ^^ reference semanticdb maven . . (it)
//                                             ^^^ reference semanticdb maven . . kotlin/let().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                   display_name it
//                                                                                   documentation ```kotlin\nit: Any?\n```
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegate.
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegate().
//                                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#notNullValueToDB().
//                                                                             ^^ reference semanticdb maven . . (it)
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/toTypedArray().
      }
  
      @Suppress("UNCHECKED_CAST")
      override fun valueFromDB(value: Any): R? {
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#valueFromDB().
//                             display_name valueFromDB
//                             documentation ```kotlin\n@Suppress(...) public open override fun valueFromDB(value: Any): R?\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#valueFromDB().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#valueFromDB().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Any\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Any#
          return when (value) {
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#valueFromDB().(value)
              is Array<*> -> recursiveValueFromDB(value, dimensions) as R?
//                           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveValueFromDB().
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#valueFromDB().(value)
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#dimensions.
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDimensions().
              is java.sql.Array -> recursiveValueFromDB(value.array, dimensions) as R?
//                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveValueFromDB().
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#valueFromDB().(value)
//                                                            ^^^^^ reference semanticdb maven jdk 11 java/sql/Array#array.
//                                                            ^^^^^ reference semanticdb maven jdk 11 java/sql/Array#getArray().
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#dimensions.
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDimensions().
              else -> value as R?
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#valueFromDB().(value)
          }
      }
  
      private fun recursiveValueFromDB(value: Any?, level: Int): List<Any?> = when {
//                ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveValueFromDB().
//                                     display_name recursiveValueFromDB
//                                     documentation ```kotlin\nprivate final fun recursiveValueFromDB(value: Any?, level: Int): List<Any?>\n```
//                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveValueFromDB().(value)
//                                           display_name value
//                                           documentation ```kotlin\nvalue: Any?\n```
//                                            ^^^^ reference semanticdb maven . . kotlin/Any#
//                                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveValueFromDB().(level)
//                                                        display_name level
//                                                        documentation ```kotlin\nlevel: Int\n```
//                                                         ^^^ reference semanticdb maven . . kotlin/Int#
//                                                               ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          level > 1 -> (value as Array<Any?>).map { recursiveValueFromDB(it, level - 1) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveValueFromDB().(level)
//              ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveValueFromDB().(value)
//                                            ^^^ reference semanticdb maven . . kotlin/collections/map().
//                                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                        display_name it
//                                                                                        documentation ```kotlin\nit: Any?\n```
//                                                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveValueFromDB().
//                                                                       ^^ reference semanticdb maven . . (it)
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveValueFromDB().(level)
//                                                                                 ^ reference semanticdb maven . . kotlin/Int#minus(+2).
          else -> (value as Array<Any?>).map { it?.let { delegate.valueFromDB(it) } }
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveValueFromDB().(value)
//                                       ^^^ reference semanticdb maven . . kotlin/collections/map().
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                    display_name it
//                                                                                    documentation ```kotlin\nit: Any?\n```
//                                             ^^ reference semanticdb maven . . (it)
//                                                 ^^^ reference semanticdb maven . . kotlin/let().
//                                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                  display_name it
//                                                                                  documentation ```kotlin\nit: Any?\n```
//                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegate.
//                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegate().
//                                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueFromDB().
//                                                                            ^^ reference semanticdb maven . . (it)
      }
  
      override fun readObject(rs: RowApi, index: Int): Any? = rs.getObject(index)
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#readObject().
//                            display_name readObject
//                            documentation ```kotlin\npublic open override fun readObject(rs: RowApi, index: Int): Any?\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#readObject().
//                            ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#readObject().(rs)
//                               display_name rs
//                               documentation ```kotlin\nrs: RowApi\n```
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#
//                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#readObject().(index)
//                                              display_name index
//                                              documentation ```kotlin\nindex: Int\n```
//                                               ^^^ reference semanticdb maven . . kotlin/Int#
//                                                     ^^^^ reference semanticdb maven . . kotlin/Any#
//                                                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#readObject().(rs)
//                                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/RowApi#getObject().
//                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#readObject().(index)
  
      override fun setParameter(stmt: PreparedStatementApi, index: Int, value: Any?) {
//                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().
//                              display_name setParameter
//                              documentation ```kotlin\npublic open override fun setParameter(stmt: PreparedStatementApi, index: Int, value: Any?): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setParameter().
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(stmt)
//                                   display_name stmt
//                                   documentation ```kotlin\nstmt: PreparedStatementApi\n```
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
//                                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(index)
//                                                                display_name index
//                                                                documentation ```kotlin\nindex: Int\n```
//                                                                 ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(value)
//                                                                            display_name value
//                                                                            documentation ```kotlin\nvalue: Any?\n```
//                                                                             ^^^^ reference semanticdb maven . . kotlin/Any#
          when {
              value is Array<*> && isArrayOfByteArrays(value) ->
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(value)
//                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isArrayOfByteArrays().
//                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(value)
                  stmt.setArray(index, this, Array(value.size) { value[it] as ByteArray })
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(stmt)
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray(+1).
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(index)
//                                           ^^^^^ reference semanticdb maven . . kotlin/Array#`<init>`().
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(value)
//                                                       ^^^^ reference semanticdb maven . . kotlin/Array#getSize().
//                                                       ^^^^ reference semanticdb maven . . kotlin/Array#size.
//                                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                        display_name it
//                                                                                        documentation ```kotlin\nit: Any?\n```
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(value)
//                                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#get().
//                                                                     ^^ reference semanticdb maven . . (it)
  
              value is Array<*> -> stmt.setArray(index, this, value)
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(value)
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(stmt)
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray(+1).
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(index)
//                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(value)
              else -> super.setParameter(stmt, index, value)
//                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#setParameter().
//                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(stmt)
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(index)
//                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#setParameter().(value)
          }
      }
  
      override fun nonNullValueToString(value: R): String {
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#nonNullValueToString().
//                                      display_name nonNullValueToString
//                                      documentation ```kotlin\npublic open override fun nonNullValueToString(value: R): String\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nonNullValueToString().
//                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#nonNullValueToString().(value)
//                                            display_name value
//                                            documentation ```kotlin\nvalue: R\n```
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
          return arrayLiteralPrefix() + recursiveNonNullValueToString(value, dimensions)
//               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#arrayLiteralPrefix().
//                                    ^ reference semanticdb maven . . kotlin/String#plus().
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueToString().
//                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#nonNullValueToString().(value)
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#dimensions.
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDimensions().
      }
  
      private fun recursiveNonNullValueToString(value: Any?, level: Int): String = when {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueToString().
//                                              display_name recursiveNonNullValueToString
//                                              documentation ```kotlin\nprivate final fun recursiveNonNullValueToString(value: Any?, level: Int): String\n```
//                                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueToString().(value)
//                                                    display_name value
//                                                    documentation ```kotlin\nvalue: Any?\n```
//                                                     ^^^^ reference semanticdb maven . . kotlin/Any#
//                                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueToString().(level)
//                                                                 display_name level
//                                                                 documentation ```kotlin\nlevel: Int\n```
//                                                                  ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
          level > 1 -> (value as List<Any?>).joinToString(",", "[", "]") { recursiveNonNullValueToString(it, level - 1) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueToString().(level)
//              ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueToString().(value)
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                        display_name it
//                                                                                                                        documentation ```kotlin\nit: Any?\n```
//                                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueToString().
//                                                                                                       ^^ reference semanticdb maven . . (it)
//                                                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueToString().(level)
//                                                                                                                 ^ reference semanticdb maven . . kotlin/Int#minus(+2).
          else -> (value as List<T>).joinToString(",", "[", "]") { it?.let { delegate.nonNullValueToString(it) } ?: nullElementString }
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueToString().(value)
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                                      display_name it
//                                                                                                                                      documentation ```kotlin\nit: Any?\n```
//                                                                 ^^ reference semanticdb maven . . (it)
//                                                                     ^^^ reference semanticdb maven . . kotlin/let().
//                                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                               display_name it
//                                                                                                               documentation ```kotlin\nit: Any?\n```
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegate.
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegate().
//                                                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nonNullValueToString().
//                                                                                                         ^^ reference semanticdb maven . . (it)
//                                                                                                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getNullElementString().
//                                                                                                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#nullElementString.
      }
  
      override fun nonNullValueAsDefaultString(value: R): String {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#nonNullValueAsDefaultString().
//                                             display_name nonNullValueAsDefaultString
//                                             documentation ```kotlin\npublic open override fun nonNullValueAsDefaultString(value: R): String\n```
//                                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#nonNullValueAsDefaultString().
//                                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#nonNullValueAsDefaultString().(value)
//                                                   display_name value
//                                                   documentation ```kotlin\nvalue: R\n```
//                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
          return arrayLiteralPrefix() + recursiveNonNullValueAsDefaultString(value, dimensions)
//               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#arrayLiteralPrefix().
//                                    ^ reference semanticdb maven . . kotlin/String#plus().
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueAsDefaultString().
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#nonNullValueAsDefaultString().(value)
//                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#dimensions.
//                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDimensions().
      }
  
      private fun recursiveNonNullValueAsDefaultString(value: Any?, level: Int): String = when {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueAsDefaultString().
//                                                     display_name recursiveNonNullValueAsDefaultString
//                                                     documentation ```kotlin\nprivate final fun recursiveNonNullValueAsDefaultString(value: Any?, level: Int): String\n```
//                                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueAsDefaultString().(value)
//                                                           display_name value
//                                                           documentation ```kotlin\nvalue: Any?\n```
//                                                            ^^^^ reference semanticdb maven . . kotlin/Any#
//                                                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueAsDefaultString().(level)
//                                                                        display_name level
//                                                                        documentation ```kotlin\nlevel: Int\n```
//                                                                         ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
          level > 1 -> (value as List<Any?>).joinToString(",", "[", "]") { recursiveNonNullValueAsDefaultString(it, level - 1) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueAsDefaultString().(level)
//              ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueAsDefaultString().(value)
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                               display_name it
//                                                                                                                               documentation ```kotlin\nit: Any?\n```
//                                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueAsDefaultString().
//                                                                                                              ^^ reference semanticdb maven . . (it)
//                                                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueAsDefaultString().(level)
//                                                                                                                        ^ reference semanticdb maven . . kotlin/Int#minus(+2).
          else -> (value as List<T>).joinToString(",", "[", "]") { it?.let { delegate.nonNullValueAsDefaultString(it) } ?: nullElementString }
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#recursiveNonNullValueAsDefaultString().(value)
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                                             display_name it
//                                                                                                                                             documentation ```kotlin\nit: Any?\n```
//                                                                 ^^ reference semanticdb maven . . (it)
//                                                                     ^^^ reference semanticdb maven . . kotlin/let().
//                                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                      display_name it
//                                                                                                                      documentation ```kotlin\nit: Any?\n```
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegate.
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegate().
//                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nonNullValueAsDefaultString().
//                                                                                                                ^^ reference semanticdb maven . . (it)
//                                                                                                                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getNullElementString().
//                                                                                                                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#nullElementString.
      }
  
      private fun arrayLiteralPrefix(): String {
//                ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#arrayLiteralPrefix().
//                                   display_name arrayLiteralPrefix
//                                   documentation ```kotlin\nprivate final fun arrayLiteralPrefix(): String\n```
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
          return when {
              currentDialect is H2Dialect -> "ARRAY "
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
              else -> "ARRAY"
          }
      }
  
      private fun castH2ParameterMarker(columnType: IColumnType<*>): String? {
//                ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#castH2ParameterMarker().
//                                      display_name castH2ParameterMarker
//                                      documentation ```kotlin\nprivate final fun castH2ParameterMarker(columnType: IColumnType<*>): String?\n```
//                                      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#castH2ParameterMarker().(columnType)
//                                                 display_name columnType
//                                                 documentation ```kotlin\ncolumnType: IColumnType<*>\n```
//                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                                   ^^^^^^^ reference semanticdb maven . . kotlin/String#
          return when (columnType) {
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#castH2ParameterMarker().(columnType)
              // Here is the list of types that could be resolved by `resolveColumnType()`.
              // In the common case it must not work for all the possible types. It also does not work with BigDecimal.
              // This cast is needed for array types inside upsert(merge statement), otherwise statement causes "Data conversion error converting" error.
              is ByteColumnType, is UByteColumnType, is BooleanColumnType, is ShortColumnType, is UShortColumnType,
              is IntegerColumnType, is UIntegerColumnType, is LongColumnType, is ULongColumnType, is FloatColumnType,
              is DoubleColumnType, is StringColumnType, is CharacterColumnType, is BasicBinaryColumnType, is UUIDColumnType ->
                  "cast(? as ${columnType.sqlType()} array)"
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#castH2ParameterMarker().(columnType)
//                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#sqlType().
              else -> null
          }
      }
  
      override fun parameterMarker(value: R?): String {
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#parameterMarker().
//                                 display_name parameterMarker
//                                 documentation ```kotlin\npublic open override fun parameterMarker(value: R?): String\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#parameterMarker().
//                                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#parameterMarker().(value)
//                                       display_name value
//                                       documentation ```kotlin\nvalue: R?\n```
//                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (currentDialect is H2Dialect) {
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
              val columnType = if (delegate is ColumnWithTransform<*, *>) delegate.originalColumnType else delegate
//                ^^^^^^^^^^ definition local 20
//                           display_name columnType
//                           documentation ```kotlin\nlocal val columnType: IColumnType<out Any>\n```
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegate.
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegate().
//                                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegate.
//                                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegate().
//                                                                                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getOriginalColumnType().
//                                                                                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#originalColumnType.
//                                                                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegate.
//                                                                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegate().
              return castH2ParameterMarker(columnType) ?: super.parameterMarker(value)
//                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#castH2ParameterMarker().
//                                         ^^^^^^^^^^ reference local 20
//                                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#parameterMarker().
//                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#parameterMarker().(value)
          }
  
          // For PostgreSQL, add a cast for date arrays to ensure they're properly recognized
          if (currentDialect is PostgreSQLDialect && delegate is IDateColumnType) {
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegate.
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegate().
              val pgType = if (delegate.hasTimePart) "timestamp[]" else "date[]"
//                ^^^^^^ definition local 21
//                       display_name pgType
//                       documentation ```kotlin\nlocal val pgType: String\n```
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegate.
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegate().
//                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IDateColumnType#getHasTimePart().
//                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IDateColumnType#hasTimePart.
              return "?::$pgType"
//                        ^^^^^^ reference local 21
          }
  
          return super.parameterMarker(value)
//                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#parameterMarker().
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#parameterMarker().(value)
      }
  }
  
  private fun isArrayOfByteArrays(value: Array<*>) =
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/isArrayOfByteArrays().
//                                display_name isArrayOfByteArrays
//                                documentation ```kotlin\nprivate final fun isArrayOfByteArrays(value: Array<*>): Boolean\n```
//                                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/isArrayOfByteArrays().(value)
//                                      display_name value
//                                      documentation ```kotlin\nvalue: Array<*>\n```
//                                       ^^^^^^^^ reference semanticdb maven . . kotlin/Array#
      value.all { it is ByteArray }
//    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isArrayOfByteArrays().(value)
//          ^^^ reference semanticdb maven . . kotlin/collections/all().
//              ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                  display_name it
//                                  documentation ```kotlin\nit: Any?\n```
//                ^^ reference semanticdb maven . . (it)
  
  // Date/Time columns
  
  /**
   * Marker interface for date/datetime related column types.
   **/
  interface IDateColumnType {
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IDateColumnType#
//                          display_name IDateColumnType
//                          documentation ```kotlin\npublic abstract interface IDateColumnType : Any\n```\n\n----\n\n\n Marker interface for date/datetime related column types.\n
      val hasTimePart: Boolean
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IDateColumnType#getHasTimePart().
//                    display_name hasTimePart
//                    documentation ```kotlin\npublic get(): Boolean\n```
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IDateColumnType#hasTimePart.
//                    display_name hasTimePart
//                    documentation ```kotlin\npublic abstract val hasTimePart: Boolean\n```
//                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  }
  
  // JSON/JSONB columns
  
  /**
   * Marker interface for json/jsonb related column types.
   */
  interface JsonColumnMarker {
//          ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#
//                           display_name JsonColumnMarker
//                           documentation ```kotlin\npublic abstract interface JsonColumnMarker : Any\n```\n\n----\n\n\n Marker interface for json/jsonb related column types.\n
      val usesBinaryFormat: Boolean
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#getUsesBinaryFormat().
//                         display_name usesBinaryFormat
//                         documentation ```kotlin\npublic get(): Boolean\n```
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#usesBinaryFormat.
//                         display_name usesBinaryFormat
//                         documentation ```kotlin\npublic abstract val usesBinaryFormat: Boolean\n```
//                          ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  }
  
  /**
   * Returns the [ColumnType] commonly associated with storing values of type [T], or the [defaultType] if a mapping
   * does not exist for type [T].
   *
   * @throws IllegalStateException If no column type mapping is found and a [defaultType] is not provided.
   */
  @InternalApi
  fun <T : Any> resolveColumnType(
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/resolveColumnType().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : Any\n```
//              ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/resolveColumnType().
//                                display_name resolveColumnType
//                                documentation ```kotlin\n@InternalApi() public final fun <T : Any> resolveColumnType(klass: KClass<T>, defaultType: ColumnType<*>? = ...): ColumnType<T>\n```\n\n----\n\n\n Returns the [ColumnType] commonly associated with storing values of type [T], or the [defaultType] if a mapping\n does not exist for type [T].\n\n @throws IllegalStateException If no column type mapping is found and a [defaultType] is not provided.\n
      klass: KClass<T>,
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/resolveColumnType().(klass)
//          display_name klass
//          documentation ```kotlin\nklass: KClass<T>\n```
//           ^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#
      defaultType: ColumnType<*>? = null
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/resolveColumnType().(defaultType)
//                display_name defaultType
//                documentation ```kotlin\ndefaultType: ColumnType<*>? = ...\n```
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
  ): ColumnType<T> {
//   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
      val type = when (klass) {
//        ^^^^ definition local 22
//             display_name type
//             documentation ```kotlin\nlocal val type: ColumnType<T>?\n```
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/resolveColumnType().(klass)
          Boolean::class -> BooleanColumnType()
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#`<init>`().
          Byte::class -> ByteColumnType()
//                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#`<init>`().
          UByte::class -> UByteColumnType()
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#`<init>`().
          Short::class -> ShortColumnType()
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#`<init>`().
          UShort::class -> UShortColumnType()
//                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#`<init>`().
          Int::class -> IntegerColumnType()
//                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#`<init>`().
          UInt::class -> UIntegerColumnType()
//                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#`<init>`().
          Long::class -> LongColumnType()
//                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#`<init>`().
          ULong::class -> ULongColumnType()
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#`<init>`().
          Float::class -> FloatColumnType()
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#`<init>`().
          Double::class -> DoubleColumnType()
//                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#`<init>`().
          String::class -> TextColumnType()
//                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
          Char::class -> CharacterColumnType()
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#`<init>`().
          ByteArray::class -> BasicBinaryColumnType()
//                            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#`<init>`().
          BigDecimal::class -> DecimalColumnType.INSTANCE
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
          UUID::class -> UUIDColumnType()
//                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#`<init>`().
          else -> defaultType
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/resolveColumnType().(defaultType)
      } as? ColumnType<T>
  
      return type ?: error(
//           ^^^^ reference local 22
//                   ^^^^^ reference semanticdb maven . . kotlin/error().
          "A column type could not be associated with ${klass.qualifiedName}. Provide an explicit column type argument."
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/resolveColumnType().(klass)
//                                                            ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getQualifiedName().
//                                                            ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#qualifiedName.
      )
  }
