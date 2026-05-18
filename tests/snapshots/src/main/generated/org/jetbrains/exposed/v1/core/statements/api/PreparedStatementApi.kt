  package org.jetbrains.exposed.v1.core.statements.api
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/
  
  import org.jetbrains.exposed.v1.core.*
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  import java.io.InputStream
//       ^^^^ reference semanticdb maven . . java/
//            ^^ reference semanticdb maven . . java/io/
//               ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/InputStream#
  import java.math.BigDecimal
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/math/
//                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
  import java.math.MathContext
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/math/
//                 ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/MathContext#
  import java.util.*
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/util/
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
  /** Represents a precompiled SQL statement. */
  @Suppress("TooManyFunctions")
  interface PreparedStatementApi {
//          ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
//                               display_name PreparedStatementApi
//                               documentation ```kotlin\n@Suppress(...) public abstract interface PreparedStatementApi : Any\n```\n\n----\n\n Represents a precompiled SQL statement.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#fillParameters().
      /**
       * Sets the value for each column or expression in [args] into the appropriate statement parameter and
       * returns the number of parameters filled.
       */
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#fillParameters().(args)
      fun fillParameters(args: Iterable<Pair<IColumnType<*>, Any?>>): Int {
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#fillParameters().
//                       display_name fillParameters
//                       documentation ```kotlin\npublic open fun fillParameters(args: Iterable<Pair<IColumnType<*>, Any?>>): Int\n```\n\n----\n\n\n Sets the value for each column or expression in [args] into the appropriate statement parameter and\n returns the number of parameters filled.\n
//                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#fillParameters().(args)
//                            display_name args
//                            documentation ```kotlin\nargs: Iterable<Pair<IColumnType<*>, Any?>>\n```
//                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                    ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#fillParameters().(args)
//                              ⌄ enclosing_range_start local 0
//                                     ⌄ enclosing_range_start local 1
//                                      ⌄ enclosing_range_start local 2
//                                         ⌄ enclosing_range_start local 3
          args.forEachIndexed { index, (c, v) ->
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#fillParameters().(args)
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/forEachIndexed(+9).
//                              ^^^^^ definition local 0
//                                    display_name index
//                                    documentation ```kotlin\nindex: Int\n```
//                                     ^^^^^^ definition local 1
//                                            display_name <destruct>
//                                            documentation ```kotlin\n<destruct>: Pair<IColumnType<*>, Any?>\n```
//                                      ^ reference local 1
//                                      ^ definition local 2
//                                        display_name c
//                                        documentation ```kotlin\nlocal val c: IColumnType<*>\n```
//                                      ^ reference semanticdb maven . . kotlin/Pair#component1().
//                                         ^ reference local 1
//                                         ^ definition local 3
//                                           display_name v
//                                           documentation ```kotlin\nlocal val v: Any?\n```
//                                         ^ reference semanticdb maven . . kotlin/Pair#component2().
//                                  ⌃ enclosing_range_end local 0
//                                      ⌃ enclosing_range_end local 2
//                                         ⌃ enclosing_range_end local 3
//                                          ⌃ enclosing_range_end local 1
              c.setParameter(this, index + 1, (c as IColumnType<Any>).valueToDB(v))
//            ^ reference local 2
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setParameter().
//                                 ^^^^^ reference local 0
//                                       ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                                             ^ reference local 2
//                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueToDB().
//                                                                              ^ reference local 3
          }
  
          return args.count() + 1
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#fillParameters().(args)
//                    ^^^^^ reference semanticdb maven . . kotlin/collections/count(+18).
//                            ^ reference semanticdb maven . . kotlin/Int#plus(+2).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#fillParameters().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set().
      @Deprecated(
          message = "This operator function will be removed in future releases. " +
              "Replace with the method `set(index, value, this)` that accepts a third argument for the IColumnType of the parameter value being bound.",
          level = DeprecationLevel.ERROR
//                                 ^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#ERROR.
      )
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set().(index)
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set().(value)
      operator fun set(index: Int, value: Any) {
//                 ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set().
//                     display_name set
//                     documentation ```kotlin\n@Deprecated(...) public open operator fun set(index: Int, value: Any): Unit\n```
//                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set().(index)
//                           display_name index
//                           documentation ```kotlin\nindex: Int\n```
//                            ^^^ reference semanticdb maven . . kotlin/Int#
//                                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set().(value)
//                                       display_name value
//                                       documentation ```kotlin\nvalue: Any\n```
//                                        ^^^ reference semanticdb maven . . kotlin/Any#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set().(index)
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set().(value)
          set(index, value, VarCharColumnType())
//        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set(+1).
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set().(index)
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set().(value)
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#`<init>`().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set(+1).
      /**
       * Sets the statement parameter at the [index] position to the provided non-null [value],
       * with a type determined by its associated [columnType].
       */
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set(+1).(index)
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set(+1).(value)
//                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set(+1).(columnType)
      fun set(index: Int, value: Any, columnType: IColumnType<*>)
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set(+1).
//            display_name set
//            documentation ```kotlin\npublic abstract fun set(index: Int, value: Any, columnType: IColumnType<*>): Unit\n\n```\n\n----\n\n\n Sets the statement parameter at the [index] position to the provided non-null [value],\n with a type determined by its associated [columnType].\n
//            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set(+1).(index)
//                  display_name index
//                  documentation ```kotlin\nindex: Int\n```
//                   ^^^ reference semanticdb maven . . kotlin/Int#
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set(+1).(value)
//                              display_name value
//                              documentation ```kotlin\nvalue: Any\n```
//                               ^^^ reference semanticdb maven . . kotlin/Any#
//                                    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set(+1).(columnType)
//                                               display_name columnType
//                                               documentation ```kotlin\ncolumnType: IColumnType<*>\n```
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set(+1).(index)
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set(+1).(value)
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set(+1).(columnType)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#set(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setNull().
      /** Sets the statement parameter at the [index] position to SQL NULL, if allowed wih the specified [columnType]. */
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setNull().(index)
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setNull().(columnType)
      fun setNull(index: Int, columnType: IColumnType<*>)
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setNull().
//                display_name setNull
//                documentation ```kotlin\npublic abstract fun setNull(index: Int, columnType: IColumnType<*>): Unit\n\n```\n\n----\n\n Sets the statement parameter at the [index] position to SQL NULL, if allowed wih the specified [columnType].
//                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setNull().(index)
//                      display_name index
//                      documentation ```kotlin\nindex: Int\n```
//                       ^^^ reference semanticdb maven . . kotlin/Int#
//                            ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setNull().(columnType)
//                                       display_name columnType
//                                       documentation ```kotlin\ncolumnType: IColumnType<*>\n```
//                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setNull().(index)
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setNull().(columnType)
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setNull().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setInputStream().
      /**
       * Sets the statement parameter at the [index] position to the provided [inputStream],
       * either directly as a BLOB if `setAsBlobObject` is `true` or as determined by the driver.
       */
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setInputStream().(index)
//                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setInputStream().(inputStream)
//                                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setInputStream().(setAsBlobObject)
      fun setInputStream(index: Int, inputStream: InputStream, setAsBlobObject: Boolean)
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setInputStream().
//                       display_name setInputStream
//                       documentation ```kotlin\npublic abstract fun setInputStream(index: Int, inputStream: InputStream, setAsBlobObject: Boolean): Unit\n\n```\n\n----\n\n\n Sets the statement parameter at the [index] position to the provided [inputStream],\n either directly as a BLOB if `setAsBlobObject` is `true` or as determined by the driver.\n
//                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setInputStream().(index)
//                             display_name index
//                             documentation ```kotlin\nindex: Int\n```
//                              ^^^ reference semanticdb maven . . kotlin/Int#
//                                   ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setInputStream().(inputStream)
//                                               display_name inputStream
//                                               documentation ```kotlin\ninputStream: InputStream\n```
//                                                ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/InputStream#
//                                                             ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setInputStream().(setAsBlobObject)
//                                                                             display_name setAsBlobObject
//                                                                             documentation ```kotlin\nsetAsBlobObject: Boolean\n```
//                                                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setInputStream().(index)
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setInputStream().(inputStream)
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setInputStream().(setAsBlobObject)
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setInputStream().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray().
      @Deprecated(
          message = "This function will be removed in future releases. " +
              "Replace with the method `setArray(index, this, array)` that accepts an ArrayColumnType as the second argument instead of a string type representation.",
          level = DeprecationLevel.ERROR
//                                 ^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#ERROR.
      )
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray().(index)
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray().(type)
//                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray().(array)
      fun setArray(index: Int, type: String, array: Array<*>)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray().
//                 display_name setArray
//                 documentation ```kotlin\n@Deprecated(...) public abstract fun setArray(index: Int, type: String, array: Array<*>): Unit\n\n```
//                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray().(index)
//                       display_name index
//                       documentation ```kotlin\nindex: Int\n```
//                        ^^^ reference semanticdb maven . . kotlin/Int#
//                             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray().(type)
//                                  display_name type
//                                  documentation ```kotlin\ntype: String\n```
//                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray().(array)
//                                                 display_name array
//                                                 documentation ```kotlin\narray: Array<*>\n```
//                                                  ^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray().(index)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray().(type)
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray().(array)
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray(+1).
      /**
       * Sets the statement parameter at the [index] position to the provided [array],
       * with a type determined by its associated array column [type].
       */
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray(+1).(index)
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray(+1).(type)
//                                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray(+1).(array)
      fun setArray(index: Int, type: ArrayColumnType<*, *>, array: Array<*>)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray(+1).
//                 display_name setArray
//                 documentation ```kotlin\npublic abstract fun setArray(index: Int, type: ArrayColumnType<*, *>, array: Array<*>): Unit\n\n```\n\n----\n\n\n Sets the statement parameter at the [index] position to the provided [array],\n with a type determined by its associated array column [type].\n
//                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray(+1).(index)
//                       display_name index
//                       documentation ```kotlin\nindex: Int\n```
//                        ^^^ reference semanticdb maven . . kotlin/Int#
//                             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray(+1).(type)
//                                  display_name type
//                                  documentation ```kotlin\ntype: ArrayColumnType<*, *>\n```
//                                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#
//                                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray(+1).(array)
//                                                                display_name array
//                                                                documentation ```kotlin\narray: Array<*>\n```
//                                                                 ^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray(+1).(index)
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray(+1).(type)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray(+1).(array)
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#setArray(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#getArrayColumnType().
      @Suppress("MagicNumber")
      @InternalApi
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#getArrayColumnType().(type)
      fun getArrayColumnType(type: String): ArrayColumnType<*, *> {
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#getArrayColumnType().
//                           display_name getArrayColumnType
//                           documentation ```kotlin\n@Suppress(...) @InternalApi() public open fun getArrayColumnType(type: String): ArrayColumnType<*, *>\n```
//                           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#getArrayColumnType().(type)
//                                display_name type
//                                documentation ```kotlin\ntype: String\n```
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#getArrayColumnType().(type)
          if (type == "CHAR") {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#getArrayColumnType().(type)
              return ArrayColumnType<Char, List<Char>>(CharacterColumnType())
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#`<init>`().
          }
  
          if (type.startsWith("DECIMAL")) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#getArrayColumnType().(type)
//                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//            ⌄ enclosing_range_start local 4
              val specs = type.substringAfter("DECIMAL").trim('(', ')')
//                ^^^^^ definition local 4
//                      display_name specs
//                      documentation ```kotlin\nlocal val specs: List<Int?>?\n```
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#getArrayColumnType().(type)
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringAfter(+1).
//                                                       ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
//                            ⌄ enclosing_range_start local 5
                  .takeUnless { it.isEmpty() }
//                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/takeUnless().
//                            ^^^^^^^^^^^^^^^^ definition local 5
//                                             display_name it
//                                             documentation ```kotlin\nit: String\n```
//                              ^^ reference local 5
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/text/isEmpty().
//                                           ⌃ enclosing_range_end local 5
                  ?.split(", ")
//                  ^^^^^ reference semanticdb maven . . kotlin/text/split(+1).
//                      ⌄ enclosing_range_start local 6
                  ?.map { it.toIntOrNull() }
//                  ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                      ^^^^^^^^^^^^^^^^^^^^ definition local 6
//                                           display_name it
//                                           documentation ```kotlin\nit: String\n```
//                        ^^ reference local 6
//                           ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/toIntOrNull().
//                                         ⌃ enclosing_range_end local 4
//                                         ⌃ enclosing_range_end local 6
              // same default values used in exposed-core DecimalColumnType()
//            ⌄ enclosing_range_start local 7
              val precision = specs?.firstOrNull() ?: MathContext.DECIMAL64.precision
//                ^^^^^^^^^ definition local 7
//                          display_name precision
//                          documentation ```kotlin\nlocal val precision: Int\n```
//                            ^^^^^ reference local 4
//                                   ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+19).
//                                                                ^^^^^^^^^ reference semanticdb maven jdk 11 java/math/MathContext#DECIMAL64.
//                                                                          ^^^^^^^^^ reference semanticdb maven jdk 11 java/math/MathContext#getPrecision().
//                                                                          ^^^^^^^^^ reference semanticdb maven jdk 11 java/math/MathContext#precision.
//                                                                                  ⌃ enclosing_range_end local 7
//            ⌄ enclosing_range_start local 8
              val scale = specs?.lastOrNull() ?: 20
//                ^^^^^ definition local 8
//                      display_name scale
//                      documentation ```kotlin\nlocal val scale: Int\n```
//                        ^^^^^ reference local 4
//                               ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/lastOrNull(+19).
//                                                ⌃ enclosing_range_end local 8
              return ArrayColumnType<BigDecimal, List<BigDecimal>>(DecimalColumnType(precision, scale))
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                                                                                   ^^^^^^^^^ reference local 7
//                                                                                              ^^^^^ reference local 8
          }
  
//        ⌄ enclosing_range_start local 9
          val dialect = org.jetbrains.exposed.v1.core.vendors.currentDialect
//            ^^^^^^^ definition local 9
//                    display_name dialect
//                    documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                         ⌃ enclosing_range_end local 9
//                     ⌄ enclosing_range_start local 10
          return when (type) {
//                     ^^^^ definition local 10
//                          display_name <when-subject>
//                          documentation ```kotlin\nlocal val <when-subject>: String\n```
//                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#getArrayColumnType().(type)
//                        ⌃ enclosing_range_end local 10
              dialect.dataTypeProvider.byteType() -> ArrayColumnType<Byte, List<Byte>>(ByteColumnType())
//            ^^^^^^^ reference local 9
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#byteType().
//                                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#`<init>`().
              dialect.dataTypeProvider.ubyteType() -> ArrayColumnType<UByte, List<UByte>>(UByteColumnType())
//            ^^^^^^^ reference local 9
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ubyteType().
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#`<init>`().
              dialect.dataTypeProvider.shortType() -> ArrayColumnType<Short, List<Short>>(ShortColumnType())
//            ^^^^^^^ reference local 9
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#shortType().
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#`<init>`().
              dialect.dataTypeProvider.ushortType() -> ArrayColumnType<UShort, List<UShort>>(UShortColumnType())
//            ^^^^^^^ reference local 9
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ushortType().
//                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#`<init>`().
              dialect.dataTypeProvider.integerType() -> ArrayColumnType<Int, List<Int>>(IntegerColumnType())
//            ^^^^^^^ reference local 9
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerType().
//                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                                                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#`<init>`().
              dialect.dataTypeProvider.uintegerType() -> ArrayColumnType<UInt, List<UInt>>(UIntegerColumnType())
//            ^^^^^^^ reference local 9
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uintegerType().
//                                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                                                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#`<init>`().
              dialect.dataTypeProvider.longType() -> ArrayColumnType<Long, List<Long>>(LongColumnType())
//            ^^^^^^^ reference local 9
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#longType().
//                                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#`<init>`().
              dialect.dataTypeProvider.ulongType() -> ArrayColumnType<ULong, List<ULong>>(ULongColumnType())
//            ^^^^^^^ reference local 9
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongType().
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#`<init>`().
              dialect.dataTypeProvider.floatType() -> ArrayColumnType<Float, List<Float>>(FloatColumnType())
//            ^^^^^^^ reference local 9
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#floatType().
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#`<init>`().
              dialect.dataTypeProvider.doubleType() -> ArrayColumnType<Double, List<Double>>(DoubleColumnType())
//            ^^^^^^^ reference local 9
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#doubleType().
//                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#`<init>`().
              dialect.dataTypeProvider.binaryType() -> ArrayColumnType<ByteArray, List<ByteArray>>(BasicBinaryColumnType())
//            ^^^^^^^ reference local 9
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType().
//                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                                                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#`<init>`().
              dialect.dataTypeProvider.booleanType() -> ArrayColumnType<Boolean, List<Boolean>>(BooleanColumnType())
//            ^^^^^^^ reference local 9
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanType().
//                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                                                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#`<init>`().
              dialect.dataTypeProvider.uuidType() -> ArrayColumnType<UUID, List<UUID>>(UUIDColumnType())
//            ^^^^^^^ reference local 9
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidType().
//                                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#`<init>`().
              else -> ArrayColumnType<String, List<String>>(VarCharColumnType())
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`(+1).
//                                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#`<init>`().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#getArrayColumnType().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/PreparedStatementApi#
