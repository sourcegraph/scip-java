  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  import org.jetbrains.exposed.v1.core.SqlExpressionBuilder.wrap
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlExpressionBuilder#
//                                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlExpressionBuilder/wrap/
  import org.jetbrains.exposed.v1.core.dao.id.CompositeID
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
//                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
  import org.jetbrains.exposed.v1.core.dao.id.CompositeIdTable
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
//                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#
  import org.jetbrains.exposed.v1.core.dao.id.EntityID
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
//                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
  import org.jetbrains.exposed.v1.core.dao.id.IdTable
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
//                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
  import org.jetbrains.exposed.v1.core.vendors.OracleDialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
  import org.jetbrains.exposed.v1.core.vendors.SQLServerDialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#
  import org.jetbrains.exposed.v1.core.vendors.currentDialectIfAvailable
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#
  /** Represents a temporary SQL identifier, [alias], for a [delegate] table. */
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#`<init>`().
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#`<init>`().(delegate)
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#`<init>`().(alias)
//                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#alias.
//                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getAlias().
  class Alias<out T : Table>(val delegate: T, val alias: String) : Table() {
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#
//            display_name Alias
//            documentation ```kotlin\npublic final class Alias<out T : Table> : Table\n```\n\n----\n\n Represents a temporary SQL identifier, [alias], for a [delegate] table.
//            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#`<init>`().
//            display_name Alias
//            documentation ```kotlin\npublic constructor<out T : Table>(delegate: T, alias: String): Alias<T>\n```
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nout T : Table\n```
//                               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#`<init>`().(delegate)
//                                        display_name delegate
//                                        documentation ```kotlin\ndelegate: T\n```
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#`<init>`().(delegate)
//                               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                                        display_name delegate
//                                        documentation ```kotlin\npublic final val delegate: T\n```
//                               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                                        display_name delegate
//                                        documentation ```kotlin\npublic get(): T\n```
//                                                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#`<init>`().(alias)
//                                                      display_name alias
//                                                      documentation ```kotlin\nalias: String\n```
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#`<init>`().(alias)
//                                                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#alias.
//                                                      display_name alias
//                                                      documentation ```kotlin\npublic final val alias: String\n```
//                                                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getAlias().
//                                                      display_name alias
//                                                      documentation ```kotlin\npublic get(): String\n```
//                                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#[T]
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#`<init>`().(delegate)
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#`<init>`().(alias)
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#alias.
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getAlias().
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#tableName.
//                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getTableName().
      override val tableName: String get() = alias
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#tableName.
//                           display_name tableName
//                           documentation ```kotlin\npublic open override val tableName: String\n```
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                   ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getTableName().
//                                       display_name tableName
//                                       documentation ```kotlin\npublic get(): String\n```
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#alias.
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getAlias().
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#tableName.
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getTableName().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#tableNameWithAlias.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getTableNameWithAlias().
      /** The table name along with its [alias]. */
      val tableNameWithAlias: String = "${delegate.tableName} $alias"
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getTableNameWithAlias().
//                           display_name tableNameWithAlias
//                           documentation ```kotlin\npublic get(): String\n```\n\n----\n\n The table name along with its [alias].
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#tableNameWithAlias.
//                           display_name tableNameWithAlias
//                           documentation ```kotlin\npublic final val tableNameWithAlias: String\n```\n\n----\n\n The table name along with its [alias].
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#alias.
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getAlias().
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#tableNameWithAlias.
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getTableNameWithAlias().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#clone().
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#clone().[T]
//                                                                                     ⌄ enclosing_range_start local 0
      private fun <T> Column<T>.clone() = Column<T>(this@Alias, name, columnType).also {
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#clone().[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#clone().
//                                    display_name clone
//                                    documentation ```kotlin\nprivate final fun <T> Column<T>.clone(): Column<T>\n```
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
//                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                ^^^^ reference semanticdb maven . . kotlin/also().
//                                                                                     ^ definition local 0 6:5
//                                                                                       display_name it
//                                                                                       documentation ```kotlin\nit: Column<T>\n```
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#clone().[T]
          it.defaultValueFun = defaultValueFun
//        ^^ reference local 0
//           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
          it.dbDefaultValue = dbDefaultValue
//        ^^ reference local 0
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
          it.isDatabaseGenerated = isDatabaseGenerated
//        ^^ reference local 0
//           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
//                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
          it.foreignKey = foreignKey
//        ^^ reference local 0
//           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
          it.extraDefinitions = extraDefinitions
//        ^^ reference local 0
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#clone().
//    ⌃ enclosing_range_end local 0
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#originalColumn().
      /**
       * Returns the original column from the [delegate] table, or `null` if the [column] is not associated
       * with this table alias.
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#originalColumn().[R]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#originalColumn().(column)
      fun <R> originalColumn(column: Column<R>): Column<R>? {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#originalColumn().[R]
//           display_name FirTypeParameterSymbol R
//           documentation ```kotlin\nR\n```
//            ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#originalColumn().
//                           display_name originalColumn
//                           documentation ```kotlin\npublic final fun <R> originalColumn(column: Column<R>): Column<R>?\n```\n\n----\n\n\n Returns the original column from the [delegate] table, or `null` if the [column] is not associated\n with this table alias.\n
//                           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#originalColumn().(column)
//                                  display_name column
//                                  documentation ```kotlin\ncolumn: Column<R>\n```
//                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#originalColumn().[R]
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#originalColumn().(column)
          @Suppress("UNCHECKED_CAST")
          return if (column.table == this) {
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#originalColumn().(column)
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                   ⌄ enclosing_range_start local 1
              delegate.columns.first { column.name == it.name } as Column<R>
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                             ^^^^^ reference semanticdb maven . . kotlin/collections/first(+20).
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 1
//                                                              display_name it
//                                                              documentation ```kotlin\nit: Column<*>\n```
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#originalColumn().(column)
//                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                    ^^ reference local 1
//                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                            ⌃ enclosing_range_end local 1
          } else {
              null
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#originalColumn().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#fields.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getFields().
//                                                                   ⌄ enclosing_range_start local 2
      override val fields: List<Expression<*>> = delegate.fields.map { (it as? Column<*>)?.clone() ?: it }
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#fields.
//                        display_name fields
//                        documentation ```kotlin\npublic open override val fields: List<Expression<*>>\n```
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getFields().
//                        display_name fields
//                        documentation ```kotlin\npublic get(): List<Expression<*>>\n```
//                         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fields.
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getFields().
//                                                               ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 2
//                                                                                                         display_name it
//                                                                                                         documentation ```kotlin\nit: Expression<*>\n```
//                                                                      ^^ reference local 2
//                                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#clone().
//                                                                                                    ^^ reference local 2
//                                                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#fields.
//                                                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getFields().
//                                                                                                       ⌃ enclosing_range_end local 2
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#columns.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getColumns().
      override val columns: List<Column<*>> = fields.filterIsInstance<Column<*>>()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#columns.
//                         display_name columns
//                         documentation ```kotlin\npublic open override val columns: List<Column<*>>\n```
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getColumns().
//                         display_name columns
//                         documentation ```kotlin\npublic get(): List<Column<*>>\n```
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#fields.
//                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getFields().
//                                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterIsInstance(+3).
//                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#columns.
//                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getColumns().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#primaryKey.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getPrimaryKey().
      override val primaryKey: PrimaryKey? = delegate.primaryKey?.columns
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getPrimaryKey().
//                            display_name primaryKey
//                            documentation ```kotlin\npublic get(): Table.PrimaryKey?\n```
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#primaryKey.
//                            display_name primaryKey
//                            documentation ```kotlin\npublic open override val primaryKey: Table.PrimaryKey?\n```
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#
//                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                                                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                                                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                                 ⌄ enclosing_range_start local 3
          ?.firstNotNullOfOrNull { delegateColumn ->
//          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstNotNullOfOrNull().
//                                 ^^^^^^^^^^^^^^ definition local 3
//                                                display_name delegateColumn
//                                                documentation ```kotlin\ndelegateColumn: Column<*>\n```
//                                              ⌃ enclosing_range_end local 3
//                         ⌄ enclosing_range_start local 4
              columns.find { it.name == delegateColumn.name }
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#columns.
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getColumns().
//                    ^^^^ reference semanticdb maven . . kotlin/collections/find(+9).
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 4
//                                                            display_name it
//                                                            documentation ```kotlin\nit: Column<*>\n```
//                           ^^ reference local 4
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                      ^^^^^^^^^^^^^^ reference local 3
//                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                          ⌃ enclosing_range_end local 4
//               ⌄ enclosing_range_start local 5
          }?.let { PrimaryKey(it) }
//           ^^^ reference semanticdb maven . . kotlin/let().
//               ^^^^^^^^^^^^^^^^^^ definition local 5
//                                  display_name it
//                                  documentation ```kotlin\nit: Column<*>\n```
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).
//                            ^^ reference local 5
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#primaryKey.
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getPrimaryKey().
//                                ⌃ enclosing_range_end local 5
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#createStatement().
      override fun createStatement() = throw UnsupportedOperationException("Unsupported for aliases")
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#createStatement().
//                                 display_name createStatement
//                                 documentation ```kotlin\npublic open override fun createStatement(): Nothing\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#createStatement().
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/UnsupportedOperationException#`<init>`().
//                                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#createStatement().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#dropStatement().
      override fun dropStatement() = throw UnsupportedOperationException("Unsupported for aliases")
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#dropStatement().
//                               display_name dropStatement
//                               documentation ```kotlin\npublic open override fun dropStatement(): Nothing\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#dropStatement().
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/UnsupportedOperationException#`<init>`().
//                                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#dropStatement().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#modifyStatement().
      override fun modifyStatement() = throw UnsupportedOperationException("Unsupported for aliases")
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#modifyStatement().
//                                 display_name modifyStatement
//                                 documentation ```kotlin\npublic open override fun modifyStatement(): Nothing\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#modifyStatement().
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/UnsupportedOperationException#`<init>`().
//                                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#modifyStatement().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#equals().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#equals().(other)
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#equals().(other)
          if (other !is Alias<*>) return false
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#equals().(other)
//                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#
          return this.tableNameWithAlias == other.tableNameWithAlias
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getTableNameWithAlias().
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#tableNameWithAlias.
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#equals().(other)
//                                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getTableNameWithAlias().
//                                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#tableNameWithAlias.
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#equals().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#hashCode().
      override fun hashCode(): Int = tableNameWithAlias.hashCode()
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getTableNameWithAlias().
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#tableNameWithAlias.
//                                                      ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#hashCode().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#get().
      @Suppress("UNCHECKED_CAST")
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#get().[T]
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#get().(original)
      operator fun <T : Any?> get(original: Column<T>): Column<T> {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#get().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#get().
//                                display_name get
//                                documentation ```kotlin\n@Suppress(...) public final operator fun <T> get(original: Column<T>): Column<T>\n```
//                                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#get().(original)
//                                         display_name original
//                                         documentation ```kotlin\noriginal: Column<T>\n```
//                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#get().[T]
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#get().(original)
          // CompositeIdTable id is not a typical database-registered column
//        ⌄ enclosing_range_start local 6
          val delegateColumn = if (delegate is CompositeIdTable && original.isEntityIdentifier()) {
//            ^^^^^^^^^^^^^^ definition local 6
//                           display_name delegateColumn
//                           documentation ```kotlin\nlocal val delegateColumn: Column<out Any?>?\n```
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#
//                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#get().(original)
//                                                                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isEntityIdentifier().
              delegate.id
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                     ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#getId().
//                     ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#id.
          } else {
//                                  ⌄ enclosing_range_start local 7
              delegate.columns.find { it == original }
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                             ^^^^ reference semanticdb maven . . kotlin/collections/find(+9).
//                                  ^^^^^^^^^^^^^^^^^^ definition local 7
//                                                     display_name it
//                                                     documentation ```kotlin\nit: Column<*>\n```
//                                    ^^ reference local 7
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#get().(original)
//                                                   ⌃ enclosing_range_end local 7
          }
//        ⌃ enclosing_range_end local 6
//                                   ⌄ enclosing_range_start local 8
          return delegateColumn?.let { it.clone() as? Column<T> }
//               ^^^^^^^^^^^^^^ reference local 6
//                               ^^^ reference semanticdb maven . . kotlin/let().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 8
//                                                                display_name it
//                                                                documentation ```kotlin\nit: Column<out Any?>\n```
//                                     ^^ reference local 8
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#clone().
//                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                              ⌃ enclosing_range_end local 8
              ?: error("Column not found in original table")
//               ^^^^^ reference semanticdb maven . . kotlin/error().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#get().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().
      @Suppress("UNCHECKED_CAST")
      override fun mapIdComparison(
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().
//                                 display_name mapIdComparison
//                                 documentation ```kotlin\n@Suppress(...) internal open override fun mapIdComparison(toCompare: Any?, booleanOperator: (Column<*>, Expression<*>) -> Op<Boolean>): Op<Boolean>\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().(toCompare)
          toCompare: Any?,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().(toCompare)
//                  display_name toCompare
//                  documentation ```kotlin\ntoCompare: Any?\n```
//                   ^^^^ reference semanticdb maven . . kotlin/Any#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().(toCompare)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().(booleanOperator)
          booleanOperator: (Column<*>, Expression<*>) -> Op<Boolean>,
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().(booleanOperator)
//                        display_name booleanOperator
//                        documentation ```kotlin\nbooleanOperator: (Column<*>, Expression<*>) -> Op<Boolean>\n```
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().(booleanOperator)
//                           ⌄ enclosing_range_start local 9
      ): Op<Boolean> = when (delegate) {
//       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                           ^^^^^^^^ definition local 9
//                                    display_name <when-subject>
//                                    documentation ```kotlin\nlocal val <when-subject>: T\n```
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                                  ⌃ enclosing_range_end local 9
          is CompositeIdTable -> {
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#
              (toCompare as? EntityID<CompositeID>) ?: error("toCompare must be an EntityID<CompositeID> value")
//             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().(toCompare)
//                           ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
//                                                     ^^^^^ reference semanticdb maven . . kotlin/error().
//                                    ⌄ enclosing_range_start local 10
              delegateIdColumns.map { column ->
//            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegateIdColumns.
//            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegateIdColumns().
//                              ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                    ^^^^^^ definition local 10
//                                           display_name column
//                                           documentation ```kotlin\ncolumn: Column<*>\n```
//                                         ⌃ enclosing_range_end local 10
//                ⌄ enclosing_range_start local 11
                  val delegateColumn = originalColumn(column)
//                    ^^^^^^^^^^^^^^ definition local 11
//                                   display_name delegateColumn
//                                   documentation ```kotlin\nlocal val delegateColumn: Column<*>?\n```
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#originalColumn().
//                                                    ^^^^^^ reference local 10
//                                                          ⌃ enclosing_range_end local 11
//                ⌄ enclosing_range_start local 12
                  val otherValue = if (delegateColumn in toCompare.value.values) {
//                    ^^^^^^^^^^ definition local 12
//                               display_name otherValue
//                               documentation ```kotlin\nlocal val otherValue: EntityID<Any>\n```
//                                     ^^^^^^^^^^^^^^ reference local 11
//                                                    ^^ reference semanticdb maven . . kotlin/collections/contains(+10).
//                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().(toCompare)
//                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
//                                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
                      toCompare.value[delegateColumn as Column<EntityID<Any>>]
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().(toCompare)
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
//                                    ^^^^^^^^^^^^^^ reference local 11
//                                                      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
                  } else {
                      error("Comparison CompositeID is missing a key mapping for ${delegateColumn?.name}")
//                    ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                                                 ^^^^^^^^^^^^^^ reference local 11
//                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
                  }
//                ⌃ enclosing_range_end local 12
                  booleanOperator(column, column.wrap(otherValue.value as? EntityID<*> ?: otherValue))
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().(booleanOperator)
//                                ^^^^^^ reference local 10
//                                        ^^^^^^ reference local 10
//                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                    ^^^^^^^^^^ reference local 12
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
//                                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
//                                                                                        ^^^^^^^^^^ reference local 12
              }.compoundAnd()
//              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/compoundAnd().
          }
          is IdTable<*> -> {
//           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//            ⌄ enclosing_range_start local 13
              val singleId = delegateIdColumns.single()
//                ^^^^^^^^ definition local 13
//                         display_name singleId
//                         documentation ```kotlin\nlocal val singleId: Column<*>\n```
//                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegateIdColumns.
//                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegateIdColumns().
//                                             ^^^^^^ reference semanticdb maven . . kotlin/collections/single(+19).
//                                                    ⌃ enclosing_range_end local 13
              booleanOperator(singleId, singleId.wrap(toCompare))
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().(booleanOperator)
//                            ^^^^^^^^ reference local 13
//                                      ^^^^^^^^ reference local 13
//                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().(toCompare)
          }
          else -> error("idColumns for mapping are only available from IdTable instances")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdOperator().
      override fun mapIdOperator(
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdOperator().
//                               display_name mapIdOperator
//                               documentation ```kotlin\ninternal open override fun mapIdOperator(booleanOperator: (Column<*>) -> Op<Boolean>): Op<Boolean>\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdOperator().(booleanOperator)
          booleanOperator: (Column<*>) -> Op<Boolean>
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdOperator().(booleanOperator)
//                        display_name booleanOperator
//                        documentation ```kotlin\nbooleanOperator: (Column<*>) -> Op<Boolean>\n```
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdOperator().(booleanOperator)
      ): Op<Boolean> {
//       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          require(delegate is IdTable<*>) { "idColumns for mapping are only available from IdTable instances" }
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                     ⌄ enclosing_range_start local 14
          return delegateIdColumns.map { booleanOperator(it) }.compoundAnd()
//               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegateIdColumns.
//               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegateIdColumns().
//                                 ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                     ^^^^^^^^^^^^^^^^^^^^^^^ definition local 14
//                                                             display_name it
//                                                             documentation ```kotlin\nit: Column<*>\n```
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdOperator().(booleanOperator)
//                                                       ^^ reference local 14
//                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/compoundAnd().
//                                                           ⌃ enclosing_range_end local 14
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdOperator().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegateIdColumns.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegateIdColumns().
      private val delegateIdColumns: List<Column<*>> = columns
//                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegateIdColumns.
//                                  display_name delegateIdColumns
//                                  documentation ```kotlin\nprivate final val delegateIdColumns: List<Column<*>>\n```
//                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegateIdColumns().
//                                  display_name delegateIdColumns
//                                  documentation ```kotlin\nprivate get(): List<Column<*>>\n```
//                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#columns.
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getColumns().
//                ⌄ enclosing_range_start local 15
          .takeIf { delegate is IdTable<*> }
//         ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 15
//                                           display_name it
//                                           documentation ```kotlin\nit: List<Column<*>>\n```
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                         ⌃ enclosing_range_end local 15
//                 ⌄ enclosing_range_start local 16
          ?.filter { originalColumn(it) in (delegate as IdTable<*>).idColumns }
//          ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 16
//                                                                              display_name it
//                                                                              documentation ```kotlin\nit: Column<*>\n```
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#originalColumn().
//                                  ^^ reference local 16
//                                      ^^ reference semanticdb maven . . kotlin/collections/contains(+9).
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
//                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#getIdColumns().
//                                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#idColumns.
//                                                                            ⌃ enclosing_range_end local 16
          .orEmpty()
//         ^^^^^^^ reference semanticdb maven . . kotlin/collections/orEmpty(+2).
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegateIdColumns.
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegateIdColumns().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#
  /** Interface common to all [Expression]s with temporary SQL identifiers. */
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#[T]
  interface IExpressionAlias<T> {
//          ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#
//                           display_name IExpressionAlias
//                           documentation ```kotlin\npublic abstract interface IExpressionAlias<T> : Any\n```\n\n----\n\n Interface common to all [Expression]s with temporary SQL identifiers.
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#
//                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#[T]
//                             display_name FirTypeParameterSymbol T
//                             documentation ```kotlin\nT\n```
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#delegate.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getDelegate().
      /** The aliased expression. */
      val delegate: Expression<T>
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#delegate.
//                 display_name delegate
//                 documentation ```kotlin\npublic abstract val delegate: Expression<T>\n```\n\n----\n\n The aliased expression.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getDelegate().
//                 display_name delegate
//                 documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n The aliased expression.
//                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#delegate.
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getDelegate().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#alias.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getAlias().
      /** The temporary SQL identifier string. */
      val alias: String
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#alias.
//              display_name alias
//              documentation ```kotlin\npublic abstract val alias: String\n```\n\n----\n\n The temporary SQL identifier string.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getAlias().
//              display_name alias
//              documentation ```kotlin\npublic get(): String\n```\n\n----\n\n The temporary SQL identifier string.
//               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#alias.
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getAlias().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#queryBuilder().
      /** Appends the SQL representation of this aliased expression to the specified [queryBuilder]. */
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#queryBuilder().(queryBuilder)
      fun queryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#queryBuilder().
//                     display_name queryBuilder
//                     documentation ```kotlin\npublic open fun queryBuilder(queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n Appends the SQL representation of this aliased expression to the specified [queryBuilder].
//                     ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#queryBuilder().(queryBuilder)
//                                  display_name queryBuilder
//                                  documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#queryBuilder().(queryBuilder)
//                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#queryBuilder().(queryBuilder)
          if (delegate is ComparisonOp &&
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#delegate.
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getDelegate().
//                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComparisonOp#
              (currentDialectIfAvailable is SQLServerDialect || currentDialectIfAvailable is OracleDialect)
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
//                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#
//                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
//                                                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
          ) {
              +"(CASE WHEN "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              append(delegate)
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#delegate.
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getDelegate().
              +" THEN 1 ELSE 0 END)"
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          } else {
              append(delegate)
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#delegate.
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getDelegate().
          }
          append(" $alias")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#alias.
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getAlias().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#queryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#aliasOnlyExpression().
      /** Returns an [Expression] containing only the string representation of this [alias]. */
      fun aliasOnlyExpression(): Expression<T> =
//        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#aliasOnlyExpression().
//                            display_name aliasOnlyExpression
//                            documentation ```kotlin\npublic open fun aliasOnlyExpression(): Expression<T>\n```\n\n----\n\n Returns an [Expression] containing only the string representation of this [alias].
//                               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                      ⌄ enclosing_range_start local 17
          (delegate as? ExpressionWithColumnType<T>)?.columnType?.let { columnType ->
//         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#delegate.
//         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getDelegate().
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                                                ^^^ reference semanticdb maven . . kotlin/let().
//                                                                      ^^^^^^^^^^ definition local 17
//                                                                                 display_name columnType
//                                                                                 documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```
//                                                                               ⌃ enclosing_range_end local 17
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5656>`#
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5656>`#`<init>`().
              object : Function<T>(columnType) {
//            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5656>`#
//                   display_name <anonymous>
//                   documentation ```kotlin\nobject : Function<T>\n```
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5656>`#`<init>`().
//                   display_name <anonymous>
//                   documentation ```kotlin\nprivate constructor(): <anonymous><T>\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                                 ^^^^^^^^^^ reference local 17
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5656>`#toQueryBuilder().
//                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5656>`#toQueryBuilder().(queryBuilder)
                  override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder { append(alias) }
//                             ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5656>`#toQueryBuilder().
//                                            display_name toQueryBuilder
//                                            documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                            ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5656>`#toQueryBuilder().(queryBuilder)
//                                                         display_name queryBuilder
//                                                         documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5656>`#toQueryBuilder().(queryBuilder)
//                                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#alias.
//                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getAlias().
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5656>`#toQueryBuilder().(queryBuilder)
//                                                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5656>`#toQueryBuilder().
              }
//            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5656>`#
//            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5656>`#`<init>`().
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5823>`#
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5823>`#`<init>`().
          } ?: object : Expression<T>() {
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5823>`#
//                    display_name <anonymous>
//                    documentation ```kotlin\nobject : Expression<T>\n```
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5823>`#`<init>`().
//                    display_name <anonymous>
//                    documentation ```kotlin\nprivate constructor(): <anonymous><T>\n```
//                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5823>`#toQueryBuilder().
//                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5823>`#toQueryBuilder().(queryBuilder)
              override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder { append(alias) }
//                         ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5823>`#toQueryBuilder().
//                                        display_name toQueryBuilder
//                                        documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toQueryBuilder().
//                                        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5823>`#toQueryBuilder().(queryBuilder)
//                                                     display_name queryBuilder
//                                                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5823>`#toQueryBuilder().(queryBuilder)
//                                                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#alias.
//                                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getAlias().
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5823>`#toQueryBuilder().(queryBuilder)
//                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5823>`#toQueryBuilder().
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#aliasOnlyExpression().
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5823>`#
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5823>`#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#
  /** Represents a temporary SQL identifier, [alias], for a [delegate] expression. */
//                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#`<init>`().
  class ExpressionAlias<T>(
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#
//                      display_name ExpressionAlias
//                      documentation ```kotlin\npublic final class ExpressionAlias<T> : Expression<T>, IExpressionAlias<T>\n```\n\n----\n\n Represents a temporary SQL identifier, [alias], for a [delegate] expression.
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#`<init>`().
//                      display_name ExpressionAlias
//                      documentation ```kotlin\npublic constructor<T>(delegate: Expression<T>, alias: String): ExpressionAlias<T>\n```
//                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#[T]
//                        display_name FirTypeParameterSymbol T
//                        documentation ```kotlin\nT\n```
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#`<init>`().(delegate)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#delegate.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#getDelegate().
      override val delegate: Expression<T>,
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#`<init>`().(delegate)
//                          display_name delegate
//                          documentation ```kotlin\ndelegate: Expression<T>\n```
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#`<init>`().(delegate)
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#delegate.
//                          display_name delegate
//                          documentation ```kotlin\npublic open override val delegate: Expression<T>\n```
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#getDelegate().
//                          display_name delegate
//                          documentation ```kotlin\npublic get(): Expression<T>\n```
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#`<init>`().(delegate)
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#delegate.
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#getDelegate().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#`<init>`().(alias)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#alias.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#getAlias().
      override val alias: String
//                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#`<init>`().(alias)
//                       display_name alias
//                       documentation ```kotlin\nalias: String\n```
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#`<init>`().(alias)
//                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#alias.
//                       display_name alias
//                       documentation ```kotlin\npublic open override val alias: String\n```
//                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#getAlias().
//                       display_name alias
//                       documentation ```kotlin\npublic get(): String\n```
//                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#`<init>`().(alias)
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#alias.
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#getAlias().
  ) : Expression<T>(), IExpressionAlias<T> {
//    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) = this.queryBuilder(queryBuilder)
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#queryBuilder().
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#toQueryBuilder().(queryBuilder)
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#toQueryBuilder().(queryBuilder)
//                                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#
  /** Represents a temporary SQL identifier, [alias], for a [delegate] expression with column type. */
//                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#[T]
//                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#`<init>`().
  class ExpressionWithColumnTypeAlias<T>(
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#
//                                    display_name ExpressionWithColumnTypeAlias
//                                    documentation ```kotlin\npublic final class ExpressionWithColumnTypeAlias<T> : ExpressionWithColumnType<T>, IExpressionAlias<T>\n```\n\n----\n\n Represents a temporary SQL identifier, [alias], for a [delegate] expression with column type.
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#`<init>`().
//                                    display_name ExpressionWithColumnTypeAlias
//                                    documentation ```kotlin\npublic constructor<T>(delegate: ExpressionWithColumnType<T>, alias: String): ExpressionWithColumnTypeAlias<T>\n```
//                                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#[T]
//                                      display_name FirTypeParameterSymbol T
//                                      documentation ```kotlin\nT\n```
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#`<init>`().(delegate)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#delegate.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#getDelegate().
      override val delegate: ExpressionWithColumnType<T>,
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#`<init>`().(delegate)
//                          display_name delegate
//                          documentation ```kotlin\ndelegate: ExpressionWithColumnType<T>\n```
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#`<init>`().(delegate)
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#delegate.
//                          display_name delegate
//                          documentation ```kotlin\npublic open override val delegate: ExpressionWithColumnType<T>\n```
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#getDelegate().
//                          display_name delegate
//                          documentation ```kotlin\npublic get(): ExpressionWithColumnType<T>\n```
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#`<init>`().(delegate)
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#delegate.
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#getDelegate().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#`<init>`().(alias)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#alias.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#getAlias().
      override val alias: String
//                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#`<init>`().(alias)
//                       display_name alias
//                       documentation ```kotlin\nalias: String\n```
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#`<init>`().(alias)
//                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#alias.
//                       display_name alias
//                       documentation ```kotlin\npublic open override val alias: String\n```
//                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#getAlias().
//                       display_name alias
//                       documentation ```kotlin\npublic get(): String\n```
//                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#`<init>`().(alias)
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#alias.
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#getAlias().
  ) : ExpressionWithColumnType<T>(), IExpressionAlias<T> {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#columnType.
      override val columnType: IColumnType<T & Any>
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#columnType.
//                            display_name columnType
//                            documentation ```kotlin\npublic open override val columnType: IColumnType<T & Any>\n```
//                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#getColumnType().
          get() = delegate.columnType
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#getColumnType().
//            display_name columnType
//            documentation ```kotlin\npublic get(): IColumnType<T & Any>\n```
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#delegate.
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#getDelegate().
//                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#columnType.
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#getColumnType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) = this.queryBuilder(queryBuilder)
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#queryBuilder().
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#toQueryBuilder().(queryBuilder)
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#toQueryBuilder().(queryBuilder)
//                                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#
  /** Represents a temporary SQL identifier, [alias], for a [query]. */
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#`<init>`().
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#`<init>`().(query)
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#query.
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getQuery().
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#`<init>`().(alias)
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#alias.
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getAlias().
  class QueryAlias(val query: AbstractQuery<*>, val alias: String) : ColumnSet() {
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#
//                 display_name QueryAlias
//                 documentation ```kotlin\npublic final class QueryAlias : ColumnSet\n```\n\n----\n\n Represents a temporary SQL identifier, [alias], for a [query].
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#`<init>`().
//                 display_name QueryAlias
//                 documentation ```kotlin\npublic constructor(query: AbstractQuery<*>, alias: String): QueryAlias\n```
//                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#`<init>`().(query)
//                           display_name query
//                           documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#`<init>`().(query)
//                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getQuery().
//                           display_name query
//                           documentation ```kotlin\npublic get(): AbstractQuery<*>\n```
//                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#query.
//                           display_name query
//                           documentation ```kotlin\npublic final val query: AbstractQuery<*>\n```
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#`<init>`().(alias)
//                                                        display_name alias
//                                                        documentation ```kotlin\nalias: String\n```
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#`<init>`().(alias)
//                                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#alias.
//                                                        display_name alias
//                                                        documentation ```kotlin\npublic final val alias: String\n```
//                                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getAlias().
//                                                        display_name alias
//                                                        documentation ```kotlin\npublic get(): String\n```
//                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#`<init>`().(query)
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#query.
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getQuery().
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#`<init>`().(alias)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#alias.
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getAlias().
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#describe().
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#describe().(s)
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#describe().(queryBuilder)
      override fun describe(s: Transaction, queryBuilder: QueryBuilder) = queryBuilder {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#describe().
//                          display_name describe
//                          documentation ```kotlin\npublic open override fun describe(s: Transaction, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().
//                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#describe().(s)
//                            display_name s
//                            documentation ```kotlin\ns: Transaction\n```
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                          ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#describe().(queryBuilder)
//                                                       display_name queryBuilder
//                                                       documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#describe().(queryBuilder)
//                                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#describe().(s)
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#describe().(queryBuilder)
          append("(")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          query.prepareSQL(queryBuilder)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getQuery().
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#query.
//              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().
//                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#describe().(queryBuilder)
          append(") ", alias)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#alias.
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getAlias().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#describe().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#fields.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getFields().
//                                                                      ⌄ enclosing_range_start local 18
      override val fields: List<Expression<*>> = query.set.fields.map { expression ->
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#fields.
//                        display_name fields
//                        documentation ```kotlin\npublic open override val fields: List<Expression<*>>\n```
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getFields().
//                        display_name fields
//                        documentation ```kotlin\npublic get(): List<Expression<*>>\n```
//                         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getQuery().
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#query.
//                                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getSet().
//                                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#set.
//                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#fields.
//                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getFields().
//                                                                ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                                      ^^^^^^^^^^ definition local 18
//                                                                                 display_name expression
//                                                                                 documentation ```kotlin\nexpression: Expression<*>\n```
//                                                                               ⌃ enclosing_range_end local 18
//              ⌄ enclosing_range_start local 19
          when (expression) {
//              ^^^^^^^^^^ reference local 18
//              ^^^^^^^^^^ definition local 19
//                         display_name <when-subject>
//                         documentation ```kotlin\nlocal val <when-subject>: Expression<*>\n```
//                       ⌃ enclosing_range_end local 19
              is Column<*> -> expression.clone()
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                            ^^^^^^^^^^ reference local 18
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#clone().
              is IExpressionAlias<*> -> expression.aliasOnlyExpression()
//               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#
//                                      ^^^^^^^^^^ reference local 18
//                                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#aliasOnlyExpression().
              else -> expression
//                    ^^^^^^^^^^ reference local 18
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#fields.
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getFields().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#aliasedFields.
      internal val aliasedFields: List<Expression<*>>
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#aliasedFields.
//                               display_name aliasedFields
//                               documentation ```kotlin\ninternal final val aliasedFields: List<Expression<*>>\n```
//                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getAliasedFields().
//                                       ⌄ enclosing_range_start local 20
          get() = query.set.fields.map { expression ->
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getAliasedFields().
//            display_name aliasedFields
//            documentation ```kotlin\ninternal get(): List<Expression<*>>\n```
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getQuery().
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#query.
//                      ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getSet().
//                      ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#set.
//                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#fields.
//                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getFields().
//                                 ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                       ^^^^^^^^^^ definition local 20
//                                                  display_name expression
//                                                  documentation ```kotlin\nexpression: Expression<*>\n```
//                                                ⌃ enclosing_range_end local 20
//                  ⌄ enclosing_range_start local 21
              when (expression) {
//                  ^^^^^^^^^^ reference local 20
//                  ^^^^^^^^^^ definition local 21
//                             display_name <when-subject>
//                             documentation ```kotlin\nlocal val <when-subject>: Expression<*>\n```
//                           ⌃ enclosing_range_end local 21
                  is Column<*> -> expression.clone()
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                ^^^^^^^^^^ reference local 20
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#clone().
                  is IExpressionAlias<*> -> expression.delegate.alias("$alias.${expression.alias}").aliasOnlyExpression()
//                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#
//                                          ^^^^^^^^^^ reference local 20
//                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#delegate.
//                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getDelegate().
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+2).
//                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#alias.
//                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getAlias().
//                                                                              ^^^^^^^^^^ reference local 20
//                                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#alias.
//                                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IExpressionAlias#getAlias().
//                                                                                                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#aliasOnlyExpression().
                  else -> expression
//                        ^^^^^^^^^^ reference local 20
              }
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#aliasedFields.
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getAliasedFields().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#columns.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getColumns().
      override val columns: List<Column<*>> = fields.filterIsInstance<Column<*>>()
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#columns.
//                         display_name columns
//                         documentation ```kotlin\npublic open override val columns: List<Column<*>>\n```
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getColumns().
//                         display_name columns
//                         documentation ```kotlin\npublic get(): List<Column<*>>\n```
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#fields.
//                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getFields().
//                                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterIsInstance(+3).
//                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#columns.
//                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getColumns().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get().
      @Suppress("UNCHECKED_CAST")
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get().[T]
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get().(original)
      operator fun <T : Any?> get(original: Column<T>): Column<T> =
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get().[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get().
//                                display_name get
//                                documentation ```kotlin\n@Suppress(...) public final operator fun <T> get(original: Column<T>): Column<T>\n```
//                                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get().(original)
//                                         display_name original
//                                         documentation ```kotlin\noriginal: Column<T>\n```
//                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get().[T]
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get().(original)
//                                      ⌄ enclosing_range_start local 22
          query.set.source.columns.find { it == original }?.clone() as? Column<T>
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getQuery().
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#query.
//              ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getSet().
//              ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#set.
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getSource().
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#source.
//                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#columns.
//                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getColumns().
//                                 ^^^^ reference semanticdb maven . . kotlin/collections/find(+9).
//                                      ^^^^^^^^^^^^^^^^^^ definition local 22
//                                                         display_name it
//                                                         documentation ```kotlin\nit: Column<*>\n```
//                                        ^^ reference local 22
//                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get().(original)
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#clone().
//                                                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                       ⌃ enclosing_range_end local 22
              ?: error("Column not found in original table")
//               ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+1).
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+1).[T]
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+1).(original)
      operator fun <T : Any?> get(original: Expression<T>): Expression<T> {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+1).[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+1).
//                                display_name get
//                                documentation ```kotlin\npublic final operator fun <T> get(original: Expression<T>): Expression<T>\n```
//                                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+1).(original)
//                                         display_name original
//                                         documentation ```kotlin\noriginal: Expression<T>\n```
//                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+1).[T]
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+1).(original)
//        ⌄ enclosing_range_start local 23
          val aliases = query.set.fields.filterIsInstance<ExpressionAlias<T>>()
//            ^^^^^^^ definition local 23
//                    display_name aliases
//                    documentation ```kotlin\nlocal val aliases: List<ExpressionAlias<T>>\n```
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getQuery().
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#query.
//                            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getSet().
//                            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#set.
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#fields.
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getFields().
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterIsInstance(+3).
//                                                                            ⌃ enclosing_range_end local 23
//                            ⌄ enclosing_range_start local 24
//                                                    ⌄ enclosing_range_start local 25
          return aliases.find { it == original }?.let {
//               ^^^^^^^ reference local 23
//                       ^^^^ reference semanticdb maven . . kotlin/collections/find(+9).
//                            ^^^^^^^^^^^^^^^^^^ definition local 24
//                                               display_name it
//                                               documentation ```kotlin\nit: ExpressionAlias<T>\n```
//                              ^^ reference local 24
//                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+1).(original)
//                                                ^^^ reference semanticdb maven . . kotlin/let().
//                                                    ^ definition local 25 2:9
//                                                      display_name it
//                                                      documentation ```kotlin\nit: ExpressionAlias<T>\n```
//                                             ⌃ enclosing_range_end local 24
              it.delegate.alias("$alias.${it.alias}").aliasOnlyExpression()
//            ^^ reference local 25
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#delegate.
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#getDelegate().
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+2).
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#alias.
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getAlias().
//                                        ^^ reference local 25
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#alias.
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#getAlias().
//                                                    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#aliasOnlyExpression().
//                          ⌄ enclosing_range_start local 26
          } ?: aliases.find { it.delegate == original }?.aliasOnlyExpression()
//             ^^^^^^^ reference local 23
//                     ^^^^ reference semanticdb maven . . kotlin/collections/find(+9).
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 26
//                                                      display_name it
//                                                      documentation ```kotlin\nit: ExpressionAlias<T>\n```
//                            ^^ reference local 26
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#delegate.
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#getDelegate().
//                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+1).(original)
//                                                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#aliasOnlyExpression().
//        ⌃ enclosing_range_end local 25
//                                                    ⌃ enclosing_range_end local 26
              ?: error("Field not found in original table fields")
//               ^^^^^ reference semanticdb maven . . kotlin/error().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+2).
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+2).[T]
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+2).(original)
      operator fun <T : Any?> get(original: ExpressionWithColumnType<T>): ExpressionWithColumnType<T> {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+2).[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT\n```
//                            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+2).
//                                display_name get
//                                documentation ```kotlin\npublic final operator fun <T> get(original: ExpressionWithColumnType<T>): ExpressionWithColumnType<T>\n```
//                                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+2).(original)
//                                         display_name original
//                                         documentation ```kotlin\noriginal: ExpressionWithColumnType<T>\n```
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+2).[T]
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+2).(original)
//        ⌄ enclosing_range_start local 27
          val aliases = query.set.fields.filterIsInstance<ExpressionWithColumnTypeAlias<T>>()
//            ^^^^^^^ definition local 27
//                    display_name aliases
//                    documentation ```kotlin\nlocal val aliases: List<ExpressionWithColumnTypeAlias<T>>\n```
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getQuery().
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#query.
//                            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getSet().
//                            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#set.
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#fields.
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getFields().
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterIsInstance(+3).
//                                                                                          ⌃ enclosing_range_end local 27
          return (
//                         ⌄ enclosing_range_start local 28
//                                                 ⌄ enclosing_range_start local 29
              aliases.find { it == original }?.let {
//            ^^^^^^^ reference local 27
//                    ^^^^ reference semanticdb maven . . kotlin/collections/find(+9).
//                         ^^^^^^^^^^^^^^^^^^ definition local 28
//                                            display_name it
//                                            documentation ```kotlin\nit: ExpressionWithColumnTypeAlias<T>\n```
//                           ^^ reference local 28
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+2).(original)
//                                             ^^^ reference semanticdb maven . . kotlin/let().
//                                                 ^ definition local 29 2:13
//                                                   display_name it
//                                                   documentation ```kotlin\nit: ExpressionWithColumnTypeAlias<T>\n```
//                                          ⌃ enclosing_range_end local 28
                  it.delegate.alias("$alias.${it.alias}").aliasOnlyExpression()
//                ^^ reference local 29
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#delegate.
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#getDelegate().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+3).
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#alias.
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getAlias().
//                                            ^^ reference local 29
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#alias.
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#getAlias().
//                                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#aliasOnlyExpression().
//                              ⌄ enclosing_range_start local 30
              } ?: aliases.find { it.delegate == original }?.aliasOnlyExpression()
//                 ^^^^^^^ reference local 27
//                         ^^^^ reference semanticdb maven . . kotlin/collections/find(+9).
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 30
//                                                          display_name it
//                                                          documentation ```kotlin\nit: ExpressionWithColumnTypeAlias<T>\n```
//                                ^^ reference local 30
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#delegate.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#getDelegate().
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+2).(original)
//                                                           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#aliasOnlyExpression().
//            ⌃ enclosing_range_end local 29
//                                                        ⌃ enclosing_range_end local 30
              ) as? ExpressionWithColumnType<T>
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
              ?: error("Field not found in original table fields")
//               ^^^^^ reference semanticdb maven . . kotlin/error().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#get(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().
      override fun join(
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().
//                      display_name join
//                      documentation ```kotlin\npublic open override fun join(otherTable: ColumnSet, joinType: JoinType, onColumn: Expression<*>?, otherColumn: Expression<*>?, lateral: Boolean, additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?): Join\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(otherTable)
          otherTable: ColumnSet,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(otherTable)
//                   display_name otherTable
//                   documentation ```kotlin\notherTable: ColumnSet\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(otherTable)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(joinType)
          joinType: JoinType,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(joinType)
//                 display_name joinType
//                 documentation ```kotlin\njoinType: JoinType\n```
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(joinType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(onColumn)
          onColumn: Expression<*>?,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(onColumn)
//                 display_name onColumn
//                 documentation ```kotlin\nonColumn: Expression<*>?\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(onColumn)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(otherColumn)
          otherColumn: Expression<*>?,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(otherColumn)
//                    display_name otherColumn
//                    documentation ```kotlin\notherColumn: Expression<*>?\n```
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(otherColumn)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(lateral)
          lateral: Boolean,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(lateral)
//                display_name lateral
//                documentation ```kotlin\nlateral: Boolean\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(lateral)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(additionalConstraint)
          additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?,
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(additionalConstraint)
//                             display_name additionalConstraint
//                             documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(additionalConstraint)
      ): Join =
//       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
          Join(this, otherTable, joinType, onColumn, otherColumn, lateral, additionalConstraint)
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(otherTable)
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(joinType)
//                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(onColumn)
//                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(otherColumn)
//                                                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(lateral)
//                                                                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().(additionalConstraint)
//                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#innerJoin().
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#innerJoin().(otherTable)
      override infix fun innerJoin(otherTable: ColumnSet): Join = Join(this, otherTable, JoinType.INNER)
//                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#innerJoin().
//                                 display_name innerJoin
//                                 documentation ```kotlin\npublic open override infix fun innerJoin(otherTable: ColumnSet): Join\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#innerJoin().
//                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#innerJoin().(otherTable)
//                                            display_name otherTable
//                                            documentation ```kotlin\notherTable: ColumnSet\n```
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#innerJoin().(otherTable)
//                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#INNER.
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#innerJoin().(otherTable)
//                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#innerJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#leftJoin().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#leftJoin().(otherTable)
      override infix fun leftJoin(otherTable: ColumnSet): Join = Join(this, otherTable, JoinType.LEFT)
//                       ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#leftJoin().
//                                display_name leftJoin
//                                documentation ```kotlin\npublic open override infix fun leftJoin(otherTable: ColumnSet): Join\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#leftJoin().
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#leftJoin().(otherTable)
//                                           display_name otherTable
//                                           documentation ```kotlin\notherTable: ColumnSet\n```
//                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).
//                                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#leftJoin().(otherTable)
//                                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#LEFT.
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#leftJoin().(otherTable)
//                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#leftJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#rightJoin().
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#rightJoin().(otherTable)
      override infix fun rightJoin(otherTable: ColumnSet): Join = Join(this, otherTable, JoinType.RIGHT)
//                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#rightJoin().
//                                 display_name rightJoin
//                                 documentation ```kotlin\npublic open override infix fun rightJoin(otherTable: ColumnSet): Join\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#rightJoin().
//                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#rightJoin().(otherTable)
//                                            display_name otherTable
//                                            documentation ```kotlin\notherTable: ColumnSet\n```
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#rightJoin().(otherTable)
//                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#RIGHT.
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#rightJoin().(otherTable)
//                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#rightJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#fullJoin().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#fullJoin().(otherTable)
      override infix fun fullJoin(otherTable: ColumnSet): Join = Join(this, otherTable, JoinType.FULL)
//                       ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#fullJoin().
//                                display_name fullJoin
//                                documentation ```kotlin\npublic open override infix fun fullJoin(otherTable: ColumnSet): Join\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fullJoin().
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#fullJoin().(otherTable)
//                                           display_name otherTable
//                                           documentation ```kotlin\notherTable: ColumnSet\n```
//                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).
//                                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#fullJoin().(otherTable)
//                                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#FULL.
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#fullJoin().(otherTable)
//                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#fullJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#crossJoin().
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#crossJoin().(otherTable)
      override infix fun crossJoin(otherTable: ColumnSet): Join = Join(this, otherTable, JoinType.CROSS)
//                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#crossJoin().
//                                 display_name crossJoin
//                                 documentation ```kotlin\npublic open override infix fun crossJoin(otherTable: ColumnSet): Join\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#crossJoin().
//                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#crossJoin().(otherTable)
//                                            display_name otherTable
//                                            documentation ```kotlin\notherTable: ColumnSet\n```
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#crossJoin().(otherTable)
//                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#CROSS.
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#crossJoin().(otherTable)
//                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#crossJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#clone().
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#clone().[T]
      private fun <T> Column<T>.clone() = Column<T>(table.alias(alias), name, columnType)
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#clone().[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#clone().
//                                    display_name clone
//                                    documentation ```kotlin\nprivate final fun <T> Column<T>.clone(): Column<T>\n```
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/alias().
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#alias.
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getAlias().
//                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#clone().[T]
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#clone().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/alias().
  /**
   * Creates a temporary identifier, [alias], for [this] table.
   *
   * The alias will be used on the database-side if the alias object is used to generate an SQL statement,
   * instead of [this] table object.
   *
   * @sample org.jetbrains.exposed.v1.tests.shared.dml.JoinTests.testJoinWithAlias01
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/alias().[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/alias().(alias)
  fun <T : Table> T.alias(alias: String) = Alias(this, alias)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/alias().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : Table\n```
//                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/alias().
//                        display_name alias
//                        documentation ```kotlin\npublic final fun <T : Table> T.alias(alias: String): Alias<T>\n```\n\n----\n\n\n Creates a temporary identifier, [alias], for [this] table.\n\n The alias will be used on the database-side if the alias object is used to generate an SQL statement,\n instead of [this] table object.\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.JoinTests.testJoinWithAlias01\n
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/alias().(alias)
//                              display_name alias
//                              documentation ```kotlin\nalias: String\n```
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#`<init>`().
//                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/alias().(alias)
//             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/alias().[T]
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/alias().(alias)
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/alias().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+1).
  /**
   * Creates a temporary identifier, [alias], for [this] query.
   *
   * The alias will be used on the database-side if the alias object is used to generate an SQL statement,
   * instead of [this] query object.
   *
   * @sample org.jetbrains.exposed.v1.tests.shared.AliasesTests.testJoinSubQuery01
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+1).[T]
//                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+1).(alias)
  fun <T : AbstractQuery<*>> T.alias(alias: String) = QueryAlias(this, alias)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+1).[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : AbstractQuery<*>\n```
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+1).
//                                   display_name alias
//                                   documentation ```kotlin\npublic final fun <T : AbstractQuery<*>> T.alias(alias: String): QueryAlias\n```\n\n----\n\n\n Creates a temporary identifier, [alias], for [this] query.\n\n The alias will be used on the database-side if the alias object is used to generate an SQL statement,\n instead of [this] query object.\n\n @sample org.jetbrains.exposed.v1.tests.shared.AliasesTests.testJoinSubQuery01\n
//                                   ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+1).(alias)
//                                         display_name alias
//                                         documentation ```kotlin\nalias: String\n```
//                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#`<init>`().
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+1).(alias)
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+1).[T]
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+1).(alias)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+1).
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+2).
  /**
   * Creates a temporary identifier, [alias], for [this] expression.
   *
   * The alias will be used on the database-side if the alias object is used to generate an SQL statement,
   * instead of [this] expression object.
   *
   * @sample org.jetbrains.exposed.v1.tests.shared.AliasesTests.testJoinSubQuery01
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+2).[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+2).(alias)
  fun <T> Expression<T>.alias(alias: String) = ExpressionAlias(this, alias)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+2).[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT\n```
//                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+2).
//                            display_name alias
//                            documentation ```kotlin\npublic final fun <T> Expression<T>.alias(alias: String): ExpressionAlias<T>\n```\n\n----\n\n\n Creates a temporary identifier, [alias], for [this] expression.\n\n The alias will be used on the database-side if the alias object is used to generate an SQL statement,\n instead of [this] expression object.\n\n @sample org.jetbrains.exposed.v1.tests.shared.AliasesTests.testJoinSubQuery01\n
//                            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+2).(alias)
//                                  display_name alias
//                                  documentation ```kotlin\nalias: String\n```
//                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#`<init>`().
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+2).(alias)
//     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+2).[T]
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+2).(alias)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+2).
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+3).
  /**
   * Creates a temporary identifier, [alias], for [this] expression with column type.
   *
   * The alias will be used on the database-side if the alias object is used to generate an SQL statement,
   * instead of [this] expression with column type object.
   *
   * @sample org.jetbrains.exposed.v1.tests.shared.AliasesTests.testExpressionWithColumnTypeAlias
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+3).[T]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+3).(alias)
  fun <T> ExpressionWithColumnType<T>.alias(alias: String) = ExpressionWithColumnTypeAlias(this, alias)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+3).[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT\n```
//                                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+3).
//                                          display_name alias
//                                          documentation ```kotlin\npublic final fun <T> ExpressionWithColumnType<T>.alias(alias: String): ExpressionWithColumnTypeAlias<T>\n```\n\n----\n\n\n Creates a temporary identifier, [alias], for [this] expression with column type.\n\n The alias will be used on the database-side if the alias object is used to generate an SQL statement,\n instead of [this] expression with column type object.\n\n @sample org.jetbrains.exposed.v1.tests.shared.AliasesTests.testExpressionWithColumnTypeAlias\n
//                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+3).(alias)
//                                                display_name alias
//                                                documentation ```kotlin\nalias: String\n```
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#`<init>`().
//                                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+3).(alias)
//     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+3).[T]
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+3).(alias)
//                                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+3).
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().
  /**
   * Creates a join relation with a query.
   *
   * @param on The condition to join that will be placed in the `ON` clause.
   * @param joinType The `JOIN` clause type used to combine rows. Defaults to [JoinType.INNER].
   * @param joinPart The query to join with.
   * @sample org.jetbrains.exposed.v1.tests.shared.AliasesTests.testJoinSubQuery02
   */
  fun Join.joinQuery(
//         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().
//                   display_name joinQuery
//                   documentation ```kotlin\npublic final fun Join.joinQuery(on: (SqlExpressionBuilder.(QueryAlias) -> Op<Boolean>)? = ..., joinType: JoinType = ..., lateral: Boolean = ..., joinPart: () -> AbstractQuery<*>): Join\n```\n\n----\n\n\n Creates a join relation with a query.\n\n @param on The condition to join that will be placed in the `ON` clause.\n @param joinType The `JOIN` clause type used to combine rows. Defaults to [JoinType.INNER].\n @param joinPart The query to join with.\n @sample org.jetbrains.exposed.v1.tests.shared.AliasesTests.testJoinSubQuery02\n
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(on)
      on: (SqlExpressionBuilder.(QueryAlias) -> Op<Boolean>)? = null,
//    ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(on)
//       display_name on
//       documentation ```kotlin\non: (SqlExpressionBuilder.(QueryAlias) -> Op<Boolean>)? = ...\n```
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(on)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(joinType)
      joinType: JoinType = JoinType.INNER,
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(joinType)
//             display_name joinType
//             documentation ```kotlin\njoinType: JoinType = ...\n```
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#INNER.
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(joinType)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(lateral)
      lateral: Boolean = false,
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(lateral)
//            display_name lateral
//            documentation ```kotlin\nlateral: Boolean = ...\n```
//             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(lateral)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(joinPart)
      joinPart: () -> AbstractQuery<*>
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(joinPart)
//             display_name joinPart
//             documentation ```kotlin\njoinPart: () -> AbstractQuery<*>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function0#
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(joinPart)
  ): Join {
//   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//    ⌄ enclosing_range_start local 31
//                                                      ⌄ enclosing_range_start local 32
      val qAlias = joinPart().alias("q${joinParts.count { it.joinPart is QueryAlias }}")
//        ^^^^^^ definition local 31
//               display_name qAlias
//               documentation ```kotlin\nlocal val qAlias: QueryAlias\n```
//                 ^^^^^^^^ reference semanticdb maven . . kotlin/Function0#invoke().
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(joinPart)
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/alias(+1).
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                                                ^^^^^ reference semanticdb maven . . kotlin/collections/count(+20).
//                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 32
//                                                                                    display_name it
//                                                                                    documentation ```kotlin\nit: Join.JoinPart\n```
//                                                        ^^ reference local 32
//                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#
//                                                                                  ⌃ enclosing_range_end local 32
//                                                                                     ⌃ enclosing_range_end local 31
//                                                                                    ⌄ enclosing_range_start local 33
      return join(qAlias, joinType, lateral = lateral, additionalConstraint = on?.let { { it(qAlias) } })
//           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().
//                ^^^^^^ reference local 31
//                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(joinType)
//                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(lateral)
//                                                                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().(on)
//                                                                                ^^^ reference semanticdb maven . . kotlin/let().
//                                                                                    ^^^^^^^^^^^^^^^^^^ definition local 33
//                                                                                                       display_name it
//                                                                                                       documentation ```kotlin\nit: SqlExpressionBuilder.(QueryAlias) -> Op<Boolean>\n```
//                                                                                        ^^ reference local 33
//                                                                                        ^^ reference semanticdb maven . . kotlin/Function2#invoke().
//                                                                                           ^^^^^^ reference local 31
//                                                                                                     ⌃ enclosing_range_end local 33
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).
  /**
   * Creates a join relation between [this] table and a query.
   *
   * @param on The condition to join that will be placed in the `ON` clause.
   * @param joinType The `JOIN` clause type used to combine rows. Defaults to [JoinType.INNER].
   * @param joinPart The query to join with.
   */
  fun Table.joinQuery(
//          ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).
//                    display_name joinQuery
//                    documentation ```kotlin\npublic final fun Table.joinQuery(on: (SqlExpressionBuilder.(QueryAlias) -> Op<Boolean>)? = ..., joinType: JoinType = ..., lateral: Boolean = ..., joinPart: () -> AbstractQuery<*>): Join\n```\n\n----\n\n\n Creates a join relation between [this] table and a query.\n\n @param on The condition to join that will be placed in the `ON` clause.\n @param joinType The `JOIN` clause type used to combine rows. Defaults to [JoinType.INNER].\n @param joinPart The query to join with.\n
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(on)
      on: (SqlExpressionBuilder.(QueryAlias) -> Op<Boolean>)? = null,
//    ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(on)
//       display_name on
//       documentation ```kotlin\non: (SqlExpressionBuilder.(QueryAlias) -> Op<Boolean>)? = ...\n```
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(on)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(joinType)
      joinType: JoinType = JoinType.INNER,
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(joinType)
//             display_name joinType
//             documentation ```kotlin\njoinType: JoinType = ...\n```
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#INNER.
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(joinType)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(lateral)
      lateral: Boolean = false,
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(lateral)
//            display_name lateral
//            documentation ```kotlin\nlateral: Boolean = ...\n```
//             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(lateral)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(joinPart)
      joinPart: () -> AbstractQuery<*>
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(joinPart)
//             display_name joinPart
//             documentation ```kotlin\njoinPart: () -> AbstractQuery<*>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function0#
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(joinPart)
  ) =
      Join(this).joinQuery(on, joinType, lateral, joinPart)
//    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`().
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery().
//                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(on)
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(joinType)
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(lateral)
//                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).(joinPart)
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/joinQuery(+1).
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/lastQueryAlias.
  /**
   * Returns the most recent [QueryAlias] instance used to create this join relation, or `null` if a query was not joined.
   *
   * @sample org.jetbrains.exposed.v1.tests.shared.AliasesTests.testJoinSubQuery02
   */
  val Join.lastQueryAlias: QueryAlias?
//         ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/lastQueryAlias.
//                        display_name lastQueryAlias
//                        documentation ```kotlin\npublic final val Join.lastQueryAlias: QueryAlias?\n```\n\n----\n\n\n Returns the most recent [QueryAlias] instance used to create this join relation, or `null` if a query was not joined.\n\n @sample org.jetbrains.exposed.v1.tests.shared.AliasesTests.testJoinSubQuery02\n
//                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/getLastQueryAlias().
//                                 ⌄ enclosing_range_start local 34
      get() = joinParts.mapNotNull { it.joinPart as? QueryAlias }.lastOrNull()
//    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/getLastQueryAlias().
//        display_name lastQueryAlias
//        documentation ```kotlin\npublic get(): QueryAlias?\n```
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                      ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mapNotNull(+1).
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 34
//                                                                display_name it
//                                                                documentation ```kotlin\nit: Join.JoinPart\n```
//                                   ^^ reference local 34
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#
//                                                                ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/lastOrNull(+19).
//                                                              ⌃ enclosing_range_end local 34
//                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/lastQueryAlias.
//                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/getLastQueryAlias().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/wrapAsExpression().
  /**
   * Wraps a [query] as an [Expression] so that it can be used as part of an SQL statement or in another query clause.
   *
   * @sample org.jetbrains.exposed.v1.tests.shared.dml.OrderByTests.testOrderByExpressions
   * @sample org.jetbrains.exposed.v1.tests.shared.dml.InsertTests.testInsertWithColumnExpression
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/wrapAsExpression().[T]
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/wrapAsExpression().(query)
//                                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 13554>`#
//                                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 13554>`#`<init>`().
  fun <T : Any> wrapAsExpression(query: AbstractQuery<*>) = object : Expression<T?>() {
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/wrapAsExpression().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : Any\n```
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/wrapAsExpression().
//                               display_name wrapAsExpression
//                               documentation ```kotlin\npublic final fun <T : Any> wrapAsExpression(query: AbstractQuery<*>): Expression<T?>\n```\n\n----\n\n\n Wraps a [query] as an [Expression] so that it can be used as part of an SQL statement or in another query clause.\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.OrderByTests.testOrderByExpressions\n @sample org.jetbrains.exposed.v1.tests.shared.dml.InsertTests.testInsertWithColumnExpression\n
//                               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/wrapAsExpression().(query)
//                                     display_name query
//                                     documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                          ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 13554>`#
//                                                                 display_name <anonymous>
//                                                                 documentation ```kotlin\nobject : Expression<T?>\n```
//                                                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                          ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 13554>`#`<init>`().
//                                                                 display_name <anonymous>
//                                                                 documentation ```kotlin\nprivate constructor(): <anonymous><T>\n```
//                                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/wrapAsExpression().[T]
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/wrapAsExpression().(query)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 13554>`#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 13554>`#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 13554>`#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 13554>`#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 13554>`#toQueryBuilder().(queryBuilder)
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 13554>`#toQueryBuilder().(queryBuilder)
          append("(")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          query.prepareSQL(this)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/wrapAsExpression().(query)
//              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 13554>`#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/wrapAsExpression().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 13554>`#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 13554>`#`<init>`().
