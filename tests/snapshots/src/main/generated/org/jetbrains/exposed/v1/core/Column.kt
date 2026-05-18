  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
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
  import org.jetbrains.exposed.v1.exceptions.throwUnsupportedException
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/comparator.
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/getComparator().
//                                                          ⌄ enclosing_range_start local 0
//                                                                                  ⌄ enclosing_range_start local 1
  private val comparator: Comparator<Column<*>> = compareBy({ it.table.tableName }, { it.name })
//            ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/comparator.
//                       display_name comparator
//                       documentation ```kotlin\nprivate final val comparator: {kotlin/Comparator<org/jetbrains/exposed/v1/core/Column<*>>=} Comparator<Column<*>>\n```
//            ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/getComparator().
//                       display_name comparator
//                       documentation ```kotlin\nprivate get(): {kotlin/Comparator<org/jetbrains/exposed/v1/core/Column<*>>=} Comparator<Column<*>>\n```
//                        ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Comparator#
//                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/comparisons/compareBy().
//                                                          ^^^^^^^^^^^^^^^^^^^^^^ definition local 0
//                                                                                 display_name it
//                                                                                 documentation ```kotlin\nit: Column<*>\n```
//                                                            ^^ reference local 0
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                                  ^^^^^^^^^^^ definition local 1
//                                                                                              display_name it
//                                                                                              documentation ```kotlin\nit: Column<*>\n```
//                                                                                    ^^ reference local 1
//                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                               ⌃ enclosing_range_end local 0
//                                                                                            ⌃ enclosing_range_end local 1
//                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/comparator.
//                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/getComparator().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
  /**
   * Represents a column.
   */
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#[T]
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
  class Column<T>(
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//             display_name Column
//             documentation ```kotlin\npublic final class Column<T> : ExpressionWithColumnType<T>, DdlAware, Comparable<Column<*>>\n```\n\n----\n\n\n Represents a column.\n
//             relationship is_reference is_implementation semanticdb maven . . kotlin/Comparable#
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
//             display_name Column
//             documentation ```kotlin\npublic constructor<T>(table: Table, name: String, columnType: IColumnType<T & Any>): Column<T>\n```\n\n----\n\n Table where the columns are declared.
//             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#[T]
//               display_name FirTypeParameterSymbol T
//               documentation ```kotlin\nT\n```
//             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().(table)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
      /** Table where the columns are declared. */
      val table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```\n\n----\n\n Table where the columns are declared.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().(table)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//              display_name table
//              documentation ```kotlin\npublic get(): Table\n```\n\n----\n\n Table where the columns are declared.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//              display_name table
//              documentation ```kotlin\npublic final val table: Table\n```\n\n----\n\n Table where the columns are declared.
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().(table)
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().(name)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
      /** Name of the column. */
      val name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```\n\n----\n\n Name of the column.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().(name)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//             display_name name
//             documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Name of the column.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//             display_name name
//             documentation ```kotlin\npublic final val name: String\n```\n\n----\n\n Name of the column.
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().(name)
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().(columnType)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
      /** Data type of the column. */
      override val columnType: IColumnType<T & Any>
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().(columnType)
//                            display_name columnType
//                            documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```\n\n----\n\n Data type of the column.
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().(columnType)
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                            display_name columnType
//                            documentation ```kotlin\npublic open override val columnType: IColumnType<T & Any>\n```\n\n----\n\n Data type of the column.
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                            display_name columnType
//                            documentation ```kotlin\npublic get(): IColumnType<T & Any>\n```\n\n----\n\n Data type of the column.
//                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().(columnType)
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
  ) : ExpressionWithColumnType<T>(), DdlAware, Comparable<Column<*>> {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#
//                                             ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Comparable#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().(value)
      /** The foreign key constraint on this column, or `null` if the column is not referencing. */
      var foreignKey: ForeignKeyConstraint? = null
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                   display_name foreignKey
//                   documentation ```kotlin\npublic final var foreignKey: ForeignKeyConstraint?\n```\n\n----\n\n The foreign key constraint on this column, or `null` if the column is not referencing.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                   display_name foreignKey
//                   documentation ```kotlin\npublic get(): ForeignKeyConstraint?\n```\n\n----\n\n The foreign key constraint on this column, or `null` if the column is not referencing.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//                   display_name foreignKey
//                   documentation ```kotlin\npublic set(value: ForeignKeyConstraint?): Unit\n```\n\n----\n\n The foreign key constraint on this column, or `null` if the column is not referencing.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().(value)
//                   display_name value
//                   documentation ```kotlin\nvalue: ForeignKeyConstraint?\n```\n\n----\n\n The foreign key constraint on this column, or `null` if the column is not referencing.
//                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().(value)
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#referee.
      /** Returns the column that this column references. */
      val referee: Column<*>?
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#referee.
//                display_name referee
//                documentation ```kotlin\npublic final val referee: Column<*>?\n```\n\n----\n\n Returns the column that this column references.
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getReferee().
          get() = foreignKey?.targetOf(this)
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getReferee().
//            display_name referee
//            documentation ```kotlin\npublic get(): Column<*>?\n```
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetOf().
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#referee.
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getReferee().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#referee(+1).
      /** Returns the column that this column references, cast as a column of type [S], or `null` if the cast fails. */
      @Suppress("UNCHECKED_CAST")
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#referee(+1).[S]
      fun <S : T> referee(): Column<S>? = referee as? Column<S>
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#referee(+1).[S]
//           display_name FirTypeParameterSymbol S
//           documentation ```kotlin\nS : T\n```
//                ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#referee(+1).
//                        display_name referee
//                        documentation ```kotlin\n@Suppress(...) public final fun <S : T> referee(): Column<S>?\n```\n\n----\n\n Returns the column that this column references, cast as a column of type [S], or `null` if the cast fails.
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getReferee().
//                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#referee.
//                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#referee(+1).[S]
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#referee(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().(value)
      /** Returns the function that calculates the default value for this column. */
      var defaultValueFun: (() -> T)? = null
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                        display_name defaultValueFun
//                        documentation ```kotlin\npublic final var defaultValueFun: (() -> T)?\n```\n\n----\n\n Returns the function that calculates the default value for this column.
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                        display_name defaultValueFun
//                        documentation ```kotlin\npublic get(): (() -> T)?\n```\n\n----\n\n Returns the function that calculates the default value for this column.
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                        display_name defaultValueFun
//                        documentation ```kotlin\npublic set(value: (() -> T)?): Unit\n```\n\n----\n\n Returns the function that calculates the default value for this column.
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().(value)
//                        display_name value
//                        documentation ```kotlin\nvalue: (() -> T)?\n```\n\n----\n\n Returns the function that calculates the default value for this column.
//                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/Function0#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().(value)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().(value)
      internal var dbDefaultValue: Expression<T>? = null
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                display_name dbDefaultValue
//                                documentation ```kotlin\ninternal final var dbDefaultValue: Expression<T>?\n```
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                display_name dbDefaultValue
//                                documentation ```kotlin\ninternal get(): Expression<T>?\n```
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                display_name dbDefaultValue
//                                documentation ```kotlin\ninternal set(value: Expression<T>?): Unit\n```
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().(value)
//                                display_name value
//                                documentation ```kotlin\nvalue: Expression<T>?\n```
//                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().(value)
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueInDb().
      /** Returns the default value for this column on the database-side. */
      fun defaultValueInDb() = dbDefaultValue
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueInDb().
//                         display_name defaultValueInDb
//                         documentation ```kotlin\npublic final fun defaultValueInDb(): Expression<T>?\n```\n\n----\n\n Returns the default value for this column on the database-side.
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueInDb().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().(value)
      internal var isDatabaseGenerated: Boolean = false
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//                                     display_name isDatabaseGenerated
//                                     documentation ```kotlin\ninternal get(): Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//                                     display_name isDatabaseGenerated
//                                     documentation ```kotlin\ninternal final var isDatabaseGenerated: Boolean\n```
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
//                                     display_name isDatabaseGenerated
//                                     documentation ```kotlin\ninternal set(value: Boolean): Unit\n```
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().(value)
//                                     display_name value
//                                     documentation ```kotlin\nvalue: Boolean\n```
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().(value)
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated(+1).
      /** Returns whether this column's value will be generated in the database. */
      fun isDatabaseGenerated() = isDatabaseGenerated
//        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated(+1).
//                            display_name isDatabaseGenerated
//                            documentation ```kotlin\npublic final fun isDatabaseGenerated(): Boolean\n```\n\n----\n\n Returns whether this column's value will be generated in the database.
//                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().(value)
      internal var extraDefinitions = mutableListOf<Any>()
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//                                  display_name extraDefinitions
//                                  documentation ```kotlin\ninternal final var extraDefinitions: MutableList<Any>\n```
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//                                  display_name extraDefinitions
//                                  documentation ```kotlin\ninternal get(): MutableList<Any>\n```
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
//                                  display_name extraDefinitions
//                                  documentation ```kotlin\ninternal set(value: MutableList<Any>): Unit\n```
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().(value)
//                                  display_name value
//                                  documentation ```kotlin\nvalue: MutableList<Any>\n```
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().(value)
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#toQueryBuilder().
      /** Appends the SQL representation of this column to the specified [queryBuilder]. */
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n Appends the SQL representation of this column to the specified [queryBuilder].
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#toQueryBuilder().(queryBuilder)
          @OptIn(InternalApi::class)
          CoreTransactionManager.currentTransaction().fullIdentity(this@Column, queryBuilder)
//                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity(+1).
//                                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#toQueryBuilder().(queryBuilder)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#nameInDatabaseCase().
      /** Returns the column name in proper case. */
      @OptIn(InternalApi::class)
      fun nameInDatabaseCase(): String = name.inProperCase()
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#nameInDatabaseCase().
//                           display_name nameInDatabaseCase
//                           documentation ```kotlin\n@OptIn(...) public final fun nameInDatabaseCase(): String\n```\n\n----\n\n Returns the column name in proper case.
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#nameInDatabaseCase().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#nameUnquoted().
      /**
       * Returns the column name with wrapping double-quotation characters removed.
       *
       * **Note** If used with MySQL or MariaDB, the column name is returned unchanged, since these databases use a
       * backtick character as the identifier quotation.
       */
      fun nameUnquoted(): String = if (currentDialect is MysqlDialect) name else name.trim('\"')
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#nameUnquoted().
//                     display_name nameUnquoted
//                     documentation ```kotlin\npublic final fun nameUnquoted(): String\n```\n\n----\n\n\n Returns the column name with wrapping double-quotation characters removed.\n\n **Note** If used with MySQL or MariaDB, the column name is returned unchanged, since these databases use a\n backtick character as the identifier quotation.\n
//                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                                    ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
//                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#nameUnquoted().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isLastColumnInPK.
      private val isLastColumnInPK: Boolean
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isLastColumnInPK.
//                                 display_name isLastColumnInPK
//                                 documentation ```kotlin\nprivate final val isLastColumnInPK: Boolean\n```
//                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsLastColumnInPK().
          get() = this == table.primaryKey?.columns?.last()
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsLastColumnInPK().
//            display_name isLastColumnInPK
//            documentation ```kotlin\nprivate get(): Boolean\n```
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                                                   ^^^^ reference semanticdb maven . . kotlin/collections/last().
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isLastColumnInPK.
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsLastColumnInPK().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isPrimaryConstraintWillBeDefined.
      internal val isPrimaryConstraintWillBeDefined: Boolean
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isPrimaryConstraintWillBeDefined.
//                                                  display_name isPrimaryConstraintWillBeDefined
//                                                  documentation ```kotlin\ninternal final val isPrimaryConstraintWillBeDefined: Boolean\n```
//                                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsPrimaryConstraintWillBeDefined().
          get() = when {
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsPrimaryConstraintWillBeDefined().
//            display_name isPrimaryConstraintWillBeDefined
//            documentation ```kotlin\ninternal get(): Boolean\n```
              currentDialect is SQLiteDialect && columnType.isAutoInc -> false
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#
//                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
              table.isCustomPKNameDefined() -> isLastColumnInPK
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#isCustomPKNameDefined().
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsLastColumnInPK().
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isLastColumnInPK.
              isOneColumnPK() -> false
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isOneColumnPK().
              else -> isLastColumnInPK
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsLastColumnInPK().
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isLastColumnInPK.
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isPrimaryConstraintWillBeDefined.
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsPrimaryConstraintWillBeDefined().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#createStatement().
      override fun createStatement(): List<String> {
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#createStatement().
//                                 display_name createStatement
//                                 documentation ```kotlin\npublic open override fun createStatement(): List<String>\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#createStatement().
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//        ⌄ enclosing_range_start local 2
          @OptIn(InternalApi::class)
          val alterTablePrefix = "ALTER TABLE ${CoreTransactionManager.currentTransaction().identity(table)} ADD"
//            ^^^^^^^^^^^^^^^^ definition local 2
//                             display_name alterTablePrefix
//                             documentation ```kotlin\n@OptIn(...) local val alterTablePrefix: String\n```
//                                                                     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                                              ⌃ enclosing_range_end local 2
//        ⌄ enclosing_range_start local 3
          val isH2withCustomPKConstraint = currentDialect is H2Dialect && isLastColumnInPK
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 3
//                                       display_name isH2withCustomPKConstraint
//                                       documentation ```kotlin\nlocal val isH2withCustomPKConstraint: Boolean\n```
//                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
//                                                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsLastColumnInPK().
//                                                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isLastColumnInPK.
//                                                                                       ⌃ enclosing_range_end local 3
//        ⌄ enclosing_range_start local 4
          val isOracle = currentDialect is OracleDialect
//            ^^^^^^^^ definition local 4
//                     display_name isOracle
//                     documentation ```kotlin\nlocal val isOracle: Boolean\n```
//                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                                                     ⌃ enclosing_range_end local 4
//        ⌄ enclosing_range_start local 5
          val columnDefinition = when {
//            ^^^^^^^^^^^^^^^^ definition local 5
//                             display_name columnDefinition
//                             documentation ```kotlin\nlocal val columnDefinition: String\n```
              isPrimaryConstraintWillBeDefined && isLastColumnInPK && !isH2withCustomPKConstraint && !isOracle ->
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsPrimaryConstraintWillBeDefined().
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isPrimaryConstraintWillBeDefined.
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsLastColumnInPK().
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isLastColumnInPK.
//                                                                    ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 3
//                                                                                                   ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                                                    ^^^^^^^^ reference local 4
                  descriptionDdl(false) + ", ADD ${table.primaryKeyConstraint()}"
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#descriptionDdl().
//                                      ^ reference semanticdb maven . . kotlin/String#plus().
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKeyConstraint().
  
              isH2withCustomPKConstraint -> descriptionDdl(true)
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 3
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#descriptionDdl().
              else -> descriptionDdl(false)
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#descriptionDdl().
          }
//        ⌃ enclosing_range_end local 5
  
//        ⌄ enclosing_range_start local 6
          val addConstr = if (isH2withCustomPKConstraint || (isOracle && isPrimaryConstraintWillBeDefined)) {
//            ^^^^^^^^^ definition local 6
//                      display_name addConstr
//                      documentation ```kotlin\nlocal val addConstr: String?\n```
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 3
//                                                           ^^^^^^^^ reference local 4
//                                                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsPrimaryConstraintWillBeDefined().
//                                                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isPrimaryConstraintWillBeDefined.
              "$alterTablePrefix ${table.primaryKeyConstraint()}"
//              ^^^^^^^^^^^^^^^^ reference local 2
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKeyConstraint().
          } else {
              null
          }
//        ⌃ enclosing_range_end local 6
          return listOfNotNull("$alterTablePrefix $columnDefinition", addConstr)
//               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/listOfNotNull(+1).
//                               ^^^^^^^^^^^^^^^^ reference local 2
//                                                 ^^^^^^^^^^^^^^^^ reference local 5
//                                                                    ^^^^^^^^^ reference local 6
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#createStatement().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#modifyStatements().
      /** Returns the SQL statements that modify this column according to differences in the provided [ColumnDiff]. */
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#modifyStatements().(columnDiff)
      fun modifyStatements(columnDiff: ColumnDiff): List<String> = currentDialect.modifyColumn(this, columnDiff)
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#modifyStatements().
//                         display_name modifyStatements
//                         documentation ```kotlin\npublic final fun modifyStatements(columnDiff: ColumnDiff): List<String>\n```\n\n----\n\n Returns the SQL statements that modify this column according to differences in the provided [ColumnDiff].
//                         ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#modifyStatements().(columnDiff)
//                                    display_name columnDiff
//                                    documentation ```kotlin\ncolumnDiff: ColumnDiff\n```
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#
//                                                  ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#modifyColumn().
//                                                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#modifyStatements().(columnDiff)
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#modifyStatements().(columnDiff)
//                                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#modifyStatements().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#modifyStatement().
      override fun modifyStatement(): List<String> = currentDialect.modifyColumn(this, ColumnDiff.AllChanged)
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#modifyStatement().
//                                 display_name modifyStatement
//                                 documentation ```kotlin\npublic open override fun modifyStatement(): List<String>\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#modifyStatement().
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#modifyColumn().
//                                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#AllChanged.
//                                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#Companion#getAllChanged().
//                                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#modifyStatement().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dropStatement().
      override fun dropStatement(): List<String> {
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dropStatement().
//                               display_name dropStatement
//                               documentation ```kotlin\npublic open override fun dropStatement(): List<String>\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#dropStatement().
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//        ⌄ enclosing_range_start local 7
          @OptIn(InternalApi::class)
          val tr = CoreTransactionManager.currentTransaction()
//            ^^ definition local 7
//               display_name tr
//               documentation ```kotlin\n@OptIn(...) local val tr: Transaction\n```
//                                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                           ⌃ enclosing_range_end local 7
          return listOf("ALTER TABLE ${tr.identity(table)} DROP COLUMN ${tr.identity(this)}")
//               ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                     ^^ reference local 7
//                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                       ^^ reference local 7
//                                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dropStatement().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isOneColumnPK().
      internal fun isOneColumnPK(): Boolean = this == table.primaryKey?.columns?.singleOrNull()
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isOneColumnPK().
//                               display_name isOneColumnPK
//                               documentation ```kotlin\ninternal final fun isOneColumnPK(): Boolean\n```
//                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull().
//                                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isOneColumnPK().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#descriptionDdl().
      /** Returns the SQL representation of this column. */
      @Suppress("ComplexMethod")
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#descriptionDdl().(modify)
      fun descriptionDdl(modify: Boolean = false): String = buildString {
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#descriptionDdl().
//                       display_name descriptionDdl
//                       documentation ```kotlin\n@Suppress(...) public final fun descriptionDdl(modify: Boolean = ...): String\n```\n\n----\n\n Returns the SQL representation of this column.
//                       ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#descriptionDdl().(modify)
//                              display_name modify
//                              documentation ```kotlin\nmodify: Boolean = ...\n```
//                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                          ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#descriptionDdl().(modify)
//        ⌄ enclosing_range_start local 8
          @OptIn(InternalApi::class)
          val tr = CoreTransactionManager.currentTransaction()
//            ^^ definition local 8
//               display_name tr
//               documentation ```kotlin\n@OptIn(...) local val tr: Transaction\n```
//                                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                           ⌃ enclosing_range_end local 8
//        ⌄ enclosing_range_start local 9
          val column = this@Column
//            ^^^^^^ definition local 9
//                   display_name column
//                   documentation ```kotlin\nlocal val column: Column<T>\n```
//                               ⌃ enclosing_range_end local 9
          append(tr.identity(column))
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//               ^^ reference local 8
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                           ^^^^^^ reference local 9
          append(" ")
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//        ⌄ enclosing_range_start local 10
          val isPKColumn = table.primaryKey?.columns?.contains(column) == true
//            ^^^^^^^^^^ definition local 10
//                       display_name isPKColumn
//                       documentation ```kotlin\nlocal val isPKColumn: Boolean\n```
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                                                    ^^^^^^^^ reference semanticdb maven . . kotlin/collections/contains().
//                                                             ^^^^^^ reference local 9
//                                                                           ⌃ enclosing_range_end local 10
//        ⌄ enclosing_range_start local 11
          val isSQLiteAutoIncColumn = currentDialect is SQLiteDialect && columnType.isAutoInc
//            ^^^^^^^^^^^^^^^^^^^^^ definition local 11
//                                  display_name isSQLiteAutoIncColumn
//                                  documentation ```kotlin\nlocal val isSQLiteAutoIncColumn: Boolean\n```
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//                                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
//                                                                                          ⌃ enclosing_range_end local 11
  
          when {
              !isPKColumn && isSQLiteAutoIncColumn -> tr.throwUnsupportedException("Auto-increment could be applied only to primary key column")
//            ^ reference semanticdb maven . . kotlin/Boolean#not().
//             ^^^^^^^^^^ reference local 10
//                           ^^^^^^^^^^^^^^^^^^^^^ reference local 11
//                                                    ^^ reference local 8
//                                                       ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
              isSQLiteAutoIncColumn && !isOneColumnPK() -> tr.throwUnsupportedException("Auto-increment could be applied only to a single column primary key")
//            ^^^^^^^^^^^^^^^^^^^^^ reference local 11
//                                     ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isOneColumnPK().
//                                                         ^^ reference local 8
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
              isSQLiteAutoIncColumn && table.isCustomPKNameDefined() -> {
//            ^^^^^^^^^^^^^^^^^^^^^ reference local 11
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                           ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#isCustomPKNameDefined().
//                ⌄ enclosing_range_start local 12
                  val rawType = columnType.sqlType().substringBefore("PRIMARY KEY")
//                    ^^^^^^^ definition local 12
//                            display_name rawType
//                            documentation ```kotlin\nlocal val rawType: String\n```
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
//                                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringBefore(+1).
//                                                                                ⌃ enclosing_range_end local 12
//                ⌄ enclosing_range_start local 13
                  val constraintPart = table.primaryKeyConstraint()!!.substringBefore("(")
//                    ^^^^^^^^^^^^^^ definition local 13
//                                   display_name constraintPart
//                                   documentation ```kotlin\nlocal val constraintPart: String\n```
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKeyConstraint().
//                                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringBefore(+1).
//                                                                                       ⌃ enclosing_range_end local 13
                  append("$rawType $constraintPart AUTOINCREMENT")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                         ^^^^^^^ reference local 12
//                                  ^^^^^^^^^^^^^^ reference local 13
              }
  
              else -> append(columnType.sqlType())
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
          }
  
//        ⌄ enclosing_range_start local 14
          val defaultValue = dbDefaultValue
//            ^^^^^^^^^^^^ definition local 14
//                         display_name defaultValue
//                         documentation ```kotlin\nlocal val defaultValue: Expression<T>?\n```
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                        ⌃ enclosing_range_end local 14
          if (defaultValue != null) {
//            ^^^^^^^^^^^^ reference local 14
//            ⌄ enclosing_range_start local 15
              val expressionSQL = currentDialect.dataTypeProvider.processForDefaultValue(defaultValue)
//                ^^^^^^^^^^^^^ definition local 15
//                              display_name expressionSQL
//                              documentation ```kotlin\nlocal val expressionSQL: String\n```
//                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                       ^^^^^^^^^^^^ reference local 14
//                                                                                                   ⌃ enclosing_range_end local 15
              if (!currentDialect.isAllowedAsColumnDefault(defaultValue)) {
//                ^ reference semanticdb maven . . kotlin/Boolean#not().
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#isAllowedAsColumnDefault().
//                                                         ^^^^^^^^^^^^ reference local 14
//                ⌄ enclosing_range_start local 16
                  val clientDefault = when {
//                    ^^^^^^^^^^^^^ definition local 16
//                                  display_name clientDefault
//                                  documentation ```kotlin\nlocal val clientDefault: String\n```
                      defaultValueFun != null && dbDefaultValue == null -> " Expression will be evaluated on the client."
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
                      !columnType.nullable -> " Column will be created with NULL marker."
//                    ^ reference semanticdb maven . . kotlin/Boolean#not().
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
                      else -> ""
                  }
//                ⌃ enclosing_range_end local 16
                  exposedLogger.error("${currentDialect.name} ${tr.db.version} doesn't support expression '$expressionSQL' as default value.$clientDefault")
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                              ^^^^^ reference semanticdb maven . . org/slf4j/Logger#error().
//                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
//                                                              ^^ reference local 8
//                                                                 ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                                 ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getVersion().
//                                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#version.
//                                                                                                          ^^^^^^^^^^^^^ reference local 15
//                                                                                                                                           ^^^^^^^^^^^^^ reference local 16
              } else {
                  if (currentDialect is SQLServerDialect) {
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#
                      // Create a DEFAULT constraint with an explicit name to facilitate removing it later if needed
//                    ⌄ enclosing_range_start local 17
                      @OptIn(InternalApi::class)
                      val tableName = column.table.tableNameWithoutScheme
//                        ^^^^^^^^^ definition local 17
//                                  display_name tableName
//                                  documentation ```kotlin\n@OptIn(...) local val tableName: String\n```
//                                    ^^^^^^ reference local 9
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutScheme().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithoutScheme.
//                                                                      ⌃ enclosing_range_end local 17
//                    ⌄ enclosing_range_start local 18
                      val columnName = column.name
//                        ^^^^^^^^^^ definition local 18
//                                   display_name columnName
//                                   documentation ```kotlin\nlocal val columnName: String\n```
//                                     ^^^^^^ reference local 9
//                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                               ⌃ enclosing_range_end local 18
//                    ⌄ enclosing_range_start local 19
                      val constraintName = "DF_${tableName}_$columnName"
//                        ^^^^^^^^^^^^^^ definition local 19
//                                       display_name constraintName
//                                       documentation ```kotlin\nlocal val constraintName: String\n```
//                                               ^^^^^^^^^ reference local 17
//                                                           ^^^^^^^^^^ reference local 18
//                                                                     ⌃ enclosing_range_end local 19
                      append(" CONSTRAINT $constraintName DEFAULT $expressionSQL")
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                         ^^^^^^^^^^^^^^ reference local 19
//                                                                 ^^^^^^^^^^^^^ reference local 15
                  } else {
                      append(" DEFAULT $expressionSQL")
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                      ^^^^^^^^^^^^^ reference local 15
                  }
              }
          }
  
          if (extraDefinitions.isNotEmpty()) {
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
//                             ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                                                                ⌄ enclosing_range_start local 20
              append(extraDefinitions.joinToString(separator = " ", prefix = " ") { "$it" })
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                ^^^^^^^^^ definition local 20
//                                                                                          display_name it
//                                                                                          documentation ```kotlin\nit: Any\n```
//                                                                                    ^^ reference local 20
//                                                                                        ⌃ enclosing_range_end local 20
          }
  
          if (columnType.nullable || (defaultValue != null && defaultValueFun == null && !currentDialect.isAllowedAsColumnDefault(defaultValue))) {
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
//                                    ^^^^^^^^^^^^ reference local 14
//                                                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                                                       ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                                       ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#isAllowedAsColumnDefault().
//                                                                                                                                ^^^^^^^^^^^^ reference local 14
              append(" NULL")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
          } else if (!isPKColumn || (currentDialect is SQLiteDialect && !isSQLiteAutoIncColumn)) {
//                   ^ reference semanticdb maven . . kotlin/Boolean#not().
//                    ^^^^^^^^^^ reference local 10
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#
//                                                                      ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                       ^^^^^^^^^^^^^^^^^^^^^ reference local 11
              append(" NOT NULL")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
          }
  
          if (!modify && isOneColumnPK() && !isPrimaryConstraintWillBeDefined && !isSQLiteAutoIncColumn) {
//            ^ reference semanticdb maven . . kotlin/Boolean#not().
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#descriptionDdl().(modify)
//                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isOneColumnPK().
//                                          ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsPrimaryConstraintWillBeDefined().
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isPrimaryConstraintWillBeDefined.
//                                                                               ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                                ^^^^^^^^^^^^^^^^^^^^^ reference local 11
              append(" PRIMARY KEY")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#descriptionDdl().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().[R]
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().(columnType)
//                                                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().(body)
      internal fun <R> copyWithAnotherColumnType(columnType: ColumnType<R & Any>, body: (Column<R>.() -> Unit)? = null): Column<R> {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().[R]
//                    display_name FirTypeParameterSymbol R
//                    documentation ```kotlin\nR\n```
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().
//                                               display_name copyWithAnotherColumnType
//                                               documentation ```kotlin\ninternal final fun <R> copyWithAnotherColumnType(columnType: ColumnType<R & Any>, body: (Column<R>.() -> Unit)? = ...): Column<R>\n```
//                                               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().(columnType)
//                                                          display_name columnType
//                                                          documentation ```kotlin\ncolumnType: ColumnType<R & Any>\n```
//                                                           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                                                                                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().(body)
//                                                                                     display_name body
//                                                                                     documentation ```kotlin\nbody: (Column<R>.() -> Unit)? = ...\n```
//                                                                                      ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().[R]
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().(columnType)
//                                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().(body)
//        ⌄ enclosing_range_start local 21
          val newColumn: Column<R> = Column(table, name, columnType)
//            ^^^^^^^^^ definition local 21
//                      display_name newColumn
//                      documentation ```kotlin\nlocal val newColumn: Column<R>\n```
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().(columnType)
//                                                                 ⌃ enclosing_range_end local 21
          newColumn.foreignKey = foreignKey
//        ^^^^^^^^^ reference local 21
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
          @Suppress("UNCHECKED_CAST")
          newColumn.dbDefaultValue = dbDefaultValue as Expression<R>?
//        ^^^^^^^^^ reference local 21
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          newColumn.isDatabaseGenerated = isDatabaseGenerated
//        ^^^^^^^^^ reference local 21
//                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
//                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
          newColumn.extraDefinitions = extraDefinitions
//        ^^^^^^^^^ reference local 21
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
//                  ⌄ enclosing_range_start local 22
          body?.let { newColumn.it() }
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().(body)
//              ^^^ reference semanticdb maven . . kotlin/let().
//                  ^^^^^^^^^^^^^^^^^^ definition local 22
//                                     display_name it
//                                     documentation ```kotlin\nit: Column<R>.() -> Unit\n```
//                    ^^^^^^^^^ reference local 21
//                              ^^ reference local 22
//                              ^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                   ⌃ enclosing_range_end local 22
  
          if (defaultValueFun != null) {
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
              require(newColumn.defaultValueFun != null) { "defaultValueFun was lost on cloning the column" }
//            ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                    ^^^^^^^^^ reference local 21
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
          }
          return newColumn
//               ^^^^^^^^^ reference local 21
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#withColumnType().
      /**
       * Returns a copy of this column, but with the given column type.
       */
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#withColumnType().(columnType)
      fun withColumnType(columnType: IColumnType<T & Any>) = Column<T>(
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#withColumnType().
//                       display_name withColumnType
//                       documentation ```kotlin\npublic final fun withColumnType(columnType: IColumnType<T & Any>): Column<T>\n```\n\n----\n\n\n Returns a copy of this column, but with the given column type.\n
//                       ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#withColumnType().(columnType)
//                                  display_name columnType
//                                  documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```
//                                   ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#withColumnType().(columnType)
          table = this.table,
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
          name = this.name,
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
          columnType = columnType
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#withColumnType().(columnType)
//           ⌄ enclosing_range_start local 23
      ).also {
//      ^^^^ reference semanticdb maven . . kotlin/also().
//           ^ definition local 23 6:5
//             display_name it
//             documentation ```kotlin\nit: Column<T>\n```
          it.foreignKey = this.foreignKey
//        ^^ reference local 23
//           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
          it.defaultValueFun = this.defaultValueFun
//        ^^ reference local 23
//           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
          it.dbDefaultValue = this.dbDefaultValue
//        ^^ reference local 23
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
          it.isDatabaseGenerated = this.isDatabaseGenerated
//        ^^ reference local 23
//           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
//                                      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//                                      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//                                      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
          it.extraDefinitions = this.extraDefinitions
//        ^^ reference local 23
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#withColumnType().
//    ⌃ enclosing_range_end local 23
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#compareTo().
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#compareTo().(other)
      override fun compareTo(other: Column<*>): Int = comparator.compare(this, other)
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#compareTo().
//                           display_name compareTo
//                           documentation ```kotlin\npublic open override operator fun compareTo(other: Column<*>): Int\n```
//                           relationship is_reference is_implementation semanticdb maven . . kotlin/Comparable#compareTo().
//                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#compareTo().(other)
//                                 display_name other
//                                 documentation ```kotlin\nother: Column<*>\n```
//                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                              ^^^ reference semanticdb maven . . kotlin/Int#
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/comparator.
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getComparator().
//                                                               ^^^^^^^ reference semanticdb maven jdk 11 java/util/Comparator#compare().
//                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#compareTo().(other)
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#compareTo().(other)
//                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#compareTo().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#equals().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#equals().(other)
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#equals().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#equals().(other)
          if (this === other) return true
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#equals().(other)
          if (other !is Column<*>) return false
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#equals().(other)
//                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
  
          if (table != other.table) return false
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#equals().(other)
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
          if (name != other.name) return false
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#equals().(other)
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
  
          return true
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#equals().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#hashCode().
      override fun hashCode(): Int = table.hashCode() * 31 + name.hashCode()
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#hashCode().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#hashCode().
//                                                    ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                                                         ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#hashCode().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Column#toString().
      override fun toString(): String = "${table.javaClass.name}.$name"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Column#toString().
//                          display_name toString
//                          documentation ```kotlin\npublic open override fun toString(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toString().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                                                         ^^^^ reference semanticdb maven jdk 11 java/lang/Class#getName().
//                                                         ^^^^ reference semanticdb maven jdk 11 java/lang/Class#name.
//                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#toString().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
