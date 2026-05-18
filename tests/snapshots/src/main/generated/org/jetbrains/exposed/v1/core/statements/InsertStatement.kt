  package org.jetbrains.exposed.v1.core.statements
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
  
  import org.jetbrains.exposed.v1.core.*
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  import kotlin.properties.Delegates
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^^^^^^^ reference semanticdb maven . . kotlin/properties/
//                         ^^^^^^^^^ reference semanticdb maven . . kotlin/properties/Delegates#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#
  /**
   * Represents the SQL statement that inserts a new row into a table.
   *
   * @param table Table to insert the new row into.
   * @param isIgnore Whether to ignore errors or not.
   * **Note** [isIgnore] is not supported by all vendors. Please check the documentation.
   */
  @Suppress("ForbiddenComment", "AnnotationSpacing")
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#[Key]
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().
  open class InsertStatement<Key : Any>(
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#
//                           display_name InsertStatement
//                           documentation ```kotlin\n@Suppress(...) public open class InsertStatement<Key : Any> : UpdateBuilder<Int>\n```\n\n----\n\n\n Represents the SQL statement that inserts a new row into a table.\n\n @param table Table to insert the new row into.\n @param isIgnore Whether to ignore errors or not.\n **Note** [isIgnore] is not supported by all vendors. Please check the documentation.\n
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchInsertStatement#
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().
//                           display_name InsertStatement
//                           documentation ```kotlin\npublic constructor<Key : Any>(table: Table, isIgnore: Boolean = ...): InsertStatement<Key>\n```
//                           ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#[Key]
//                               display_name FirTypeParameterSymbol Key
//                               documentation ```kotlin\nKey : Any\n```
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#[Key]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().(table)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#table.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getTable().
      val table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().(table)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getTable().
//              display_name table
//              documentation ```kotlin\npublic get(): Table\n```
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#table.
//              display_name table
//              documentation ```kotlin\npublic final val table: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().(table)
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#table.
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getTable().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().(isIgnore)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isIgnore.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getIsIgnore().
      val isIgnore: Boolean = false
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().(isIgnore)
//                 display_name isIgnore
//                 documentation ```kotlin\nisIgnore: Boolean = ...\n```
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().(isIgnore)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getIsIgnore().
//                 display_name isIgnore
//                 documentation ```kotlin\npublic get(): Boolean\n```
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isIgnore.
//                 display_name isIgnore
//                 documentation ```kotlin\npublic final val isIgnore: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().(isIgnore)
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isIgnore.
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getIsIgnore().
  ) : UpdateBuilder<Int>(StatementType.INSERT, listOf(table)) {
//    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#INSERT.
//                                             ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().(table)
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#insertedCount.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getInsertedCount().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setInsertedCount().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setInsertedCount().(insertedCount)
      /**
       * The number of rows affected by the insert operation.
       *
       * When returned by a `BatchInsertStatement` or `BatchUpsertStatement`, the returned value is calculated using the
       * sum of the individual values generated by each statement.
       *
       * **Note**: Some vendors support returning the affected-row value of 2 if an existing row is updated by an upsert
       * operation; please check the documentation.
       */
      var insertedCount: Int by Delegates.notNull()
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getInsertedCount().
//                      display_name insertedCount
//                      documentation ```kotlin\npublic get(): Int\n```\n\n----\n\n\n The number of rows affected by the insert operation.\n\n When returned by a `BatchInsertStatement` or `BatchUpsertStatement`, the returned value is calculated using the\n sum of the individual values generated by each statement.\n\n **Note**: Some vendors support returning the affected-row value of 2 if an existing row is updated by an upsert\n operation; please check the documentation.\n
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#insertedCount.
//                      display_name insertedCount
//                      documentation ```kotlin\npublic final var insertedCount: Int\n```\n\n----\n\n\n The number of rows affected by the insert operation.\n\n When returned by a `BatchInsertStatement` or `BatchUpsertStatement`, the returned value is calculated using the\n sum of the individual values generated by each statement.\n\n **Note**: Some vendors support returning the affected-row value of 2 if an existing row is updated by an upsert\n operation; please check the documentation.\n
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setInsertedCount().
//                      display_name insertedCount
//                      documentation ```kotlin\npublic set(<set-?>: Int): Unit\n```\n\n----\n\n\n The number of rows affected by the insert operation.\n\n When returned by a `BatchInsertStatement` or `BatchUpsertStatement`, the returned value is calculated using the\n sum of the individual values generated by each statement.\n\n **Note**: Some vendors support returning the affected-row value of 2 if an existing row is updated by an upsert\n operation; please check the documentation.\n
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setInsertedCount().(insertedCount)
//                      display_name insertedCount
//                      documentation ```kotlin\n<set-?>: Int\n```\n\n----\n\n\n The number of rows affected by the insert operation.\n\n When returned by a `BatchInsertStatement` or `BatchUpsertStatement`, the returned value is calculated using the\n sum of the individual values generated by each statement.\n\n **Note**: Some vendors support returning the affected-row value of 2 if an existing row is updated by an upsert\n operation; please check the documentation.\n
//                       ^^^ reference semanticdb maven . . kotlin/Int#
//                              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/properties/ReadWriteProperty#getValue().
//                              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/properties/ReadWriteProperty#setValue().
//                              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getInsertedCount().
//                              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#insertedCount.
//                              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setInsertedCount().
//                              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setInsertedCount().(insertedCount)
//                                        ^^^^^^^ reference semanticdb maven . . kotlin/properties/Delegates#notNull().
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#insertedCount.
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getInsertedCount().
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setInsertedCount().
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setInsertedCount().(insertedCount)
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#resultedValues.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getResultedValues().
      /** The [ResultRow]s generated by processing the database result set retrieved after executing the statement. */
      var resultedValues: List<ResultRow>? = null
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getResultedValues().
//                       display_name resultedValues
//                       documentation ```kotlin\npublic get(): List<ResultRow>?\n```\n\n----\n\n The [ResultRow]s generated by processing the database result set retrieved after executing the statement.
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#resultedValues.
//                       display_name resultedValues
//                       documentation ```kotlin\npublic final var resultedValues: List<ResultRow>?\n```\n\n----\n\n The [ResultRow]s generated by processing the database result set retrieved after executing the statement.
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setResultedValues().(value)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setResultedValues().
          @InternalApi
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setResultedValues().(value) 1:11
//                     display_name value
//                     documentation ```kotlin\nvalue: List<ResultRow>?\n```
          set
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setResultedValues().
//            display_name resultedValues
//            documentation ```kotlin\n@InternalApi() public set(value: List<ResultRow>?): Unit\n```
//          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#resultedValues.
//          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getResultedValues().
//          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setResultedValues().(value)
//          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setResultedValues().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get().[T]
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get().(column)
      infix operator fun <T> get(column: Column<T>): T {
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get().[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT\n```
//                           ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get().
//                               display_name get
//                               documentation ```kotlin\npublic final operator infix fun <T> get(column: Column<T>): T\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get().(column)
//                                      display_name column
//                                      documentation ```kotlin\ncolumn: Column<T>\n```
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get().[T]
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get().(column)
//        ⌄ enclosing_range_start local 0
          val row = resultedValues?.firstOrNull() ?: error("No key generated")
//            ^^^ definition local 0
//                display_name row
//                documentation ```kotlin\nlocal val row: ResultRow\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getResultedValues().
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#resultedValues.
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setResultedValues().
//                                  ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+19).
//                                                   ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                                           ⌃ enclosing_range_end local 0
          return row[column]
//               ^^^ reference local 0
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get().(column)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get(+1).
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get(+1).[T]
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get(+1).(column)
      infix operator fun <T> get(column: CompositeColumn<T>): T {
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get(+1).[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT\n```
//                           ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get(+1).
//                               display_name get
//                               documentation ```kotlin\npublic final operator infix fun <T> get(column: CompositeColumn<T>): T\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get(+1).(column)
//                                      display_name column
//                                      documentation ```kotlin\ncolumn: CompositeColumn<T>\n```
//                                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get(+1).[T]
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get(+1).(column)
//        ⌄ enclosing_range_start local 1
          val row = resultedValues?.firstOrNull() ?: error("No key generated")
//            ^^^ definition local 1
//                display_name row
//                documentation ```kotlin\nlocal val row: ResultRow\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getResultedValues().
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#resultedValues.
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setResultedValues().
//                                  ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+19).
//                                                   ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                                           ⌃ enclosing_range_end local 1
          return row[column]
//               ^^^ reference local 1
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#get().
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get(+1).(column)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#get(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getOrNull().
      /**
       * Returns the value of a given [column] from the first stored [ResultRow], or `null` if either no results were
       * retrieved from the database or if the column cannot be found in the row.
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getOrNull().[T]
//                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getOrNull().(column)
      fun <T> getOrNull(column: Column<T>): T? = resultedValues?.firstOrNull()?.getOrNull(column)
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getOrNull().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getOrNull().
//                      display_name getOrNull
//                      documentation ```kotlin\npublic final fun <T> getOrNull(column: Column<T>): T?\n```\n\n----\n\n\n Returns the value of a given [column] from the first stored [ResultRow], or `null` if either no results were\n retrieved from the database or if the column cannot be found in the row.\n
//                      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getOrNull().(column)
//                             display_name column
//                             documentation ```kotlin\ncolumn: Column<T>\n```
//                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getResultedValues().
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#resultedValues.
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setResultedValues().
//                                                               ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+19).
//                                                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ResultRow#getOrNull().
//                                                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getOrNull().(column)
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getOrNull().[T]
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getOrNull().(column)
//                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getOrNull().
      // TODO: log issue about unifying process result method for jdbc and r2dbc
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndDefaults().
      @OptIn(InternalApi::class)
      @Suppress("NestedBlockDepth")
      @Deprecated(
          "This function is used in derived classes to build a list of arguments. " +
              "It's recommended to avoid including all default and nullable values in insert statements, " +
              "as these values can often be generated automatically by the database. " +
              "There are no usages of that function inside Exposed. Saved as deprecated for back compatability",
          level = DeprecationLevel.WARNING
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#WARNING.
      )
//                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndDefaults().(values)
      protected open fun valuesAndDefaults(values: Map<Column<*>, Any?> = this.values): Map<Column<*>, Any?> {
//                       ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndDefaults().
//                                         display_name valuesAndDefaults
//                                         documentation ```kotlin\n@OptIn(...) @Suppress(...) @Deprecated(...) protected open fun valuesAndDefaults(values: Map<Column<*>, Any?> = ...): Map<Column<*>, Any?>\n```
//                                         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndDefaults().(values)
//                                                display_name values
//                                                documentation ```kotlin\nvalues: Map<Column<*>, Any?> = ...\n```
//                                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getValues().
//                                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#values.
//                                                                                      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndDefaults().(values)
//        ⌄ enclosing_range_start local 2
          val result = values.toMutableMap()
//            ^^^^^^ definition local 2
//                   display_name result
//                   documentation ```kotlin\nlocal val result: MutableMap<Column<*>, Any?>\n```
//                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndDefaults().(values)
//                            ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/toMutableMap().
//                                         ⌃ enclosing_range_end local 2
//                          ⌄ enclosing_range_start local 3
          targets.forEach { table ->
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getTargets().
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#targets.
//                ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                          ^^^^^ definition local 3
//                                display_name table
//                                documentation ```kotlin\ntable: Table\n```
//                              ⌃ enclosing_range_end local 3
//                                    ⌄ enclosing_range_start local 4
              table.columns.forEach { column ->
//            ^^^^^ reference local 3
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                          ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                    ^^^^^^ definition local 4
//                                           display_name column
//                                           documentation ```kotlin\ncolumn: Column<*>\n```
//                                         ⌃ enclosing_range_end local 4
                  if ((column.dbDefaultValue != null || column.defaultValueFun != null) && column !in values.keys) {
//                     ^^^^^^ reference local 4
//                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                      ^^^^^^ reference local 4
//                                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                                                         ^^^^^^ reference local 4
//                                                                                                ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                                                ^^^ reference semanticdb maven . . kotlin/collections/Set#contains().
//                                                                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndDefaults().(values)
//                                                                                                           ^^^^ reference semanticdb maven . . kotlin/collections/Map#getKeys().
//                                                                                                           ^^^^ reference semanticdb maven . . kotlin/collections/Map#keys.
//                    ⌄ enclosing_range_start local 5
                      val value = when {
//                        ^^^^^ definition local 5
//                              display_name value
//                              documentation ```kotlin\nlocal val value: Any?\n```
                          column.defaultValueFun != null -> column.defaultValueFun!!()
//                        ^^^^^^ reference local 4
//                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                          ^^^^^^ reference local 4
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function0#invoke().
//                                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
                          else -> DefaultValueMarker
                      }
//                    ⌃ enclosing_range_end local 5
                      result[column] = value
//                    ^^^^^^ reference local 2
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//                           ^^^^^^ reference local 4
//                                     ^^^^^ reference local 5
                  }
              }
          }
          return result
//               ^^^^^^ reference local 2
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndDefaults().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().
      @Deprecated(
          "This function has been obsolete since version 0.57.0, " +
              "following the removal of default values from insert statements. " +
              "It's safe to remove any overrides of this function from your code.",
          level = DeprecationLevel.WARNING
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#WARNING.
      )
//                                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().(column)
//                                                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().(value)
      protected open fun isColumnValuePreferredFromResultSet(column: Column<*>, value: Any?): Boolean {
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().
//                                                           display_name isColumnValuePreferredFromResultSet
//                                                           documentation ```kotlin\n@Deprecated(...) protected open fun isColumnValuePreferredFromResultSet(column: Column<*>, value: Any?): Boolean\n```
//                                                           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().(column)
//                                                                  display_name column
//                                                                  documentation ```kotlin\ncolumn: Column<*>\n```
//                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().(value)
//                                                                                    display_name value
//                                                                                    documentation ```kotlin\nvalue: Any?\n```
//                                                                                     ^^^^ reference semanticdb maven . . kotlin/Any#
//                                                                                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().(column)
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().(value)
          return column.columnType.isAutoInc || value is NextVal<*>
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().(column)
//                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().(value)
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isColumnValuePreferredFromResultSet().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#clientDefaultColumns().
      protected fun clientDefaultColumns() = targets
//                  ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#clientDefaultColumns().
//                                       display_name clientDefaultColumns
//                                       documentation ```kotlin\nprotected final fun clientDefaultColumns(): List<Column<*>>\n```
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getTargets().
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#targets.
          // The current check for existing client side without db side default value
//                 ⌄ enclosing_range_start local 6
//                                       ⌄ enclosing_range_start local 7
          .flatMap { it.columns.filter { column -> column.dbDefaultValue == null && column.defaultValueFun != null } }
//         ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap(+10).
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 6
//                                                                                                                     display_name it
//                                                                                                                     documentation ```kotlin\nit: Table\n```
//                   ^^ reference local 6
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                              ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                       ^^^^^^ definition local 7
//                                              display_name column
//                                              documentation ```kotlin\ncolumn: Column<*>\n```
//                                                 ^^^^^^ reference local 7
//                                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                                                  ^^^^^^ reference local 7
//                                                                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                                                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                                                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                            ⌃ enclosing_range_end local 7
//                                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#clientDefaultColumns().
//                                                                                                                   ⌃ enclosing_range_end local 6
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndClientDefaults().
      @OptIn(InternalApi::class)
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndClientDefaults().(values)
      protected fun valuesAndClientDefaults(values: Map<Column<*>, Any?> = this.values): Map<Column<*>, Any?> {
//                  ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndClientDefaults().
//                                          display_name valuesAndClientDefaults
//                                          documentation ```kotlin\n@OptIn(...) protected final fun valuesAndClientDefaults(values: Map<Column<*>, Any?> = ...): Map<Column<*>, Any?>\n```
//                                          ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndClientDefaults().(values)
//                                                 display_name values
//                                                 documentation ```kotlin\nvalues: Map<Column<*>, Any?> = ...\n```
//                                                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getValues().
//                                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#values.
//                                                                                       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndClientDefaults().(values)
//        ⌄ enclosing_range_start local 8
          val clientDefaultValues = clientDefaultColumns()
//            ^^^^^^^^^^^^^^^^^^^ definition local 8
//                                display_name clientDefaultValues
//                                documentation ```kotlin\nlocal val clientDefaultValues: List<Pair<Column<*>, Any?>>\n```
//                                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#clientDefaultColumns().
//                      ⌄ enclosing_range_start local 9
              .filter { column -> column !in values.keys }
//             ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                      ^^^^^^ definition local 9
//                             display_name column
//                             documentation ```kotlin\ncolumn: Column<*>\n```
//                                ^^^^^^ reference local 9
//                                       ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                                       ^^^ reference semanticdb maven . . kotlin/collections/Set#contains().
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndClientDefaults().(values)
//                                                  ^^^^ reference semanticdb maven . . kotlin/collections/Map#getKeys().
//                                                  ^^^^ reference semanticdb maven . . kotlin/collections/Map#keys.
//                           ⌃ enclosing_range_end local 9
//                   ⌄ enclosing_range_start local 10
              .map { column -> column to column.defaultValueFun!!() }
//             ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                   ^^^^^^ definition local 10
//                          display_name column
//                          documentation ```kotlin\ncolumn: Column<*>\n```
//                             ^^^^^^ reference local 10
//                                    ^^ reference semanticdb maven . . kotlin/to().
//                                       ^^^^^^ reference local 10
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function0#invoke().
//                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                        ⌃ enclosing_range_end local 10
//                                                                  ⌃ enclosing_range_end local 8
  
          return clientDefaultValues.toMap() + values
//               ^^^^^^^^^^^^^^^^^^^ reference local 8
//                                   ^^^^^ reference semanticdb maven . . kotlin/collections/toMap().
//                                           ^ reference semanticdb maven . . kotlin/collections/plus(+39).
//                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndClientDefaults().(values)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndClientDefaults().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().(transaction)
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().(prepared)
      override fun prepareSQL(transaction: Transaction, prepared: Boolean): String {
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().
//                            display_name prepareSQL
//                            documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchReplaceStatement#prepareSQL().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#prepareSQL().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReplaceStatement#prepareSQL().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#prepareSQL().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#prepareSQL().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#prepareSQL().
//                            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().(transaction)
//                                        display_name transaction
//                                        documentation ```kotlin\ntransaction: Transaction\n```
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().(prepared)
//                                                               display_name prepared
//                                                               documentation ```kotlin\nprepared: Boolean\n```
//                                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().(transaction)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().(prepared)
//        ⌄ enclosing_range_start local 11
          val values = arguments!!.first()
//            ^^^^^^ definition local 11
//                   display_name values
//                   documentation ```kotlin\nlocal val values: List<Pair<Column<*>, Any?>>\n```
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments.
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getArguments().
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setArguments().
//                                 ^^^^^ reference semanticdb maven . . kotlin/collections/first(+19).
//                                       ⌃ enclosing_range_end local 11
//        ⌄ enclosing_range_start local 12
          val sql = values.toSqlString(prepared)
//            ^^^ definition local 12
//                display_name sql
//                documentation ```kotlin\nlocal val sql: String\n```
//                  ^^^^^^ reference local 11
//                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#toSqlString().
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().(prepared)
//                                             ⌃ enclosing_range_end local 12
          return transaction.db.dialect.functionProvider
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().(transaction)
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                                ⌄ enclosing_range_start local 13
              .insert(isIgnore, table, values.map { it.first }, sql, transaction)
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getIsIgnore().
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#isIgnore.
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getTable().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#table.
//                                     ^^^^^^ reference local 11
//                                            ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                ^^^^^^^^^^^^ definition local 13
//                                                             display_name it
//                                                             documentation ```kotlin\nit: Pair<Column<*>, Any?>\n```
//                                                  ^^ reference local 13
//                                                     ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                     ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                              ^^^ reference local 12
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().(transaction)
//                                                           ⌃ enclosing_range_end local 13
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#prepareSQL().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#toSqlString().
//                                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#toSqlString().(prepared)
      protected fun List<Pair<Column<*>, Any?>>.toSqlString(prepared: Boolean): String {
//                                              ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#toSqlString().
//                                                          display_name toSqlString
//                                                          documentation ```kotlin\nprotected final fun List<Pair<Column<*>, Any?>>.toSqlString(prepared: Boolean): String\n```
//                                                          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#toSqlString().(prepared)
//                                                                   display_name prepared
//                                                                   documentation ```kotlin\nprepared: Boolean\n```
//                                                                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#toSqlString().(prepared)
//        ⌄ enclosing_range_start local 14
          val builder = QueryBuilder(prepared)
//            ^^^^^^^ definition local 14
//                    display_name builder
//                    documentation ```kotlin\nlocal val builder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#toSqlString().(prepared)
//                                           ⌃ enclosing_range_end local 14
          return if (isEmpty()) {
//                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#isEmpty().
              ""
          } else {
              with(builder) {
//            ^^^^ reference semanticdb maven . . kotlin/with().
//                 ^^^^^^^ reference local 14
//                                                                                ⌄ enclosing_range_start local 15
//                                                                                 ⌄ enclosing_range_start local 16
//                                                                                         ⌄ enclosing_range_start local 17
                  this@toSqlString.appendTo(prefix = "VALUES (", postfix = ")") { (column, value) ->
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                                                ^^^^^^^^^^^^^^^ definition local 15
//                                                                                                display_name <destruct>
//                                                                                                documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                                                                 ^^^^^^ reference local 15
//                                                                                 ^^^^^^ definition local 16
//                                                                                        display_name column
//                                                                                        documentation ```kotlin\nlocal val column: Column<*>\n```
//                                                                                 ^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                                                         ^^^^^ reference local 15
//                                                                                         ^^^^^ definition local 17
//                                                                                               display_name value
//                                                                                               documentation ```kotlin\nlocal val value: Any?\n```
//                                                                                         ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                                                      ⌃ enclosing_range_end local 16
//                                                                                             ⌃ enclosing_range_end local 17
//                                                                                              ⌃ enclosing_range_end local 15
                      registerArgument(column, value)
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                                     ^^^^^^ reference local 16
//                                             ^^^^^ reference local 17
                  }
                  toString()
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
              }
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#toSqlString().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setArguments().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setArguments().(value)
      open var arguments: List<List<Pair<Column<*>, Any?>>>? = null
//             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments.
//                       display_name arguments
//                       documentation ```kotlin\npublic open var arguments: List<List<Pair<Column<*>, Any?>>>?\n```
//             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setArguments().
//                       display_name arguments
//                       documentation ```kotlin\npublic set(value: List<List<Pair<Column<*>, Any?>>>?): Unit\n```
//             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setArguments().(value)
//                       display_name value
//                       documentation ```kotlin\nvalue: List<List<Pair<Column<*>, Any?>>>?\n```
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getArguments().
          get() = field ?: run {
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getArguments().
//            display_name arguments
//            documentation ```kotlin\npublic get(): List<List<Pair<Column<*>, Any?>>>?\n```
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/field.
//                         ^^^ reference semanticdb maven . . kotlin/run(+1).
              listOf(valuesAndClientDefaults().toList())
//            ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                   ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#valuesAndClientDefaults().
//                                             ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+11).
                  .apply { field = this }
//                 ^^^^^ reference semanticdb maven . . kotlin/apply().
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/field.
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments.
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setArguments().
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setArguments().(value)
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getArguments().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments(+1).
      override fun arguments(): List<Iterable<Pair<IColumnType<*>, Any?>>> {
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments(+1).
//                           display_name arguments
//                           documentation ```kotlin\npublic open override fun arguments(): List<Iterable<Pair<IColumnType<*>, Any?>>>\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpsertStatement#arguments().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/SQLServerBatchInsertStatement#arguments().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#arguments().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertStatement#arguments().
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                ⌄ enclosing_range_start local 18
          return arguments?.map { args ->
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments.
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getArguments().
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setArguments().
//                          ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                ^^^^ definition local 18
//                                     display_name args
//                                     documentation ```kotlin\nargs: List<Pair<Column<*>, Any?>>\n```
//                                   ⌃ enclosing_range_end local 18
//            ⌄ enclosing_range_start local 19
              val builder = QueryBuilder(true)
//                ^^^^^^^ definition local 19
//                        display_name builder
//                        documentation ```kotlin\nlocal val builder: QueryBuilder\n```
//                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                                           ⌃ enclosing_range_end local 19
//                          ⌄ enclosing_range_start local 20
//                           ⌄ enclosing_range_start local 21
//                              ⌄ enclosing_range_start local 22
              args.filter { (_, value) ->
//            ^^^^ reference local 18
//                 ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                          ^^^^^^^^^^ definition local 20
//                                     display_name <destruct>
//                                     documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                           ^ reference local 20
//                           ^ definition local 21
//                             display_name <unused var>
//                             documentation ```kotlin\nlocal val <unused var>: Column<*>\n```
//                           ^ reference semanticdb maven . . kotlin/Pair#component1().
//                              ^^^^^ reference local 20
//                              ^^^^^ definition local 22
//                                    display_name value
//                                    documentation ```kotlin\nlocal val value: Any?\n```
//                              ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                           ⌃ enclosing_range_end local 21
//                                  ⌃ enclosing_range_end local 22
//                                   ⌃ enclosing_range_end local 20
                  value != DefaultValueMarker
//                ^^^^^ reference local 22
//                        ⌄ enclosing_range_start local 23
//                         ⌄ enclosing_range_start local 24
//                                 ⌄ enclosing_range_start local 25
              }.forEach { (column, value) ->
//              ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                        ^^^^^^^^^^^^^^^ definition local 23
//                                        display_name <destruct>
//                                        documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                         ^^^^^^ reference local 23
//                         ^^^^^^ definition local 24
//                                display_name column
//                                documentation ```kotlin\nlocal val column: Column<*>\n```
//                         ^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                 ^^^^^ reference local 23
//                                 ^^^^^ definition local 25
//                                       display_name value
//                                       documentation ```kotlin\nlocal val value: Any?\n```
//                                 ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                              ⌃ enclosing_range_end local 24
//                                     ⌃ enclosing_range_end local 25
//                                      ⌃ enclosing_range_end local 23
                  builder.registerArgument(column, value)
//                ^^^^^^^ reference local 19
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                                         ^^^^^^ reference local 24
//                                                 ^^^^^ reference local 25
              }
              builder.args
//            ^^^^^^^ reference local 19
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#args.
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getArgs().
          } ?: emptyList()
//             ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#columnsWithDatabaseDefaults().
      /**
       * Returns the list of columns with default values that can not be taken locally.
       * It is the columns defined with `defaultExpression()`, `databaseGenerated()`
       */
      @InternalApi
      fun columnsWithDatabaseDefaults() = targets
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#columnsWithDatabaseDefaults().
//                                    display_name columnsWithDatabaseDefaults
//                                    documentation ```kotlin\n@InternalApi() public final fun columnsWithDatabaseDefaults(): List<Column<*>>\n```\n\n----\n\n\n Returns the list of columns with default values that can not be taken locally.\n It is the columns defined with `defaultExpression()`, `databaseGenerated()`\n
//                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getTargets().
//                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#targets.
//                 ⌄ enclosing_range_start local 26
          .flatMap { it.columns }
//         ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap(+10).
//                 ^^^^^^^^^^^^^^ definition local 26
//                                display_name it
//                                documentation ```kotlin\nit: Table\n```
//                   ^^ reference local 26
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                              ⌃ enclosing_range_end local 26
//                ⌄ enclosing_range_start local 27
          .filter { it.defaultValueFun == null && it.dbDefaultValue != null }
//         ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 27
//                                                                            display_name it
//                                                                            documentation ```kotlin\nit: Column<*>\n```
//                  ^^ reference local 27
//                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                ^^ reference local 27
//                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#columnsWithDatabaseDefaults().
//                                                                          ⌃ enclosing_range_end local 27
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#
