  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  import org.jetbrains.exposed.v1.core.SqlExpressionBuilder.asLiteral
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlExpressionBuilder#
//                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SqlExpressionBuilder/asLiteral/
  import org.jetbrains.exposed.v1.core.vendors.*
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
  import java.math.BigDecimal
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/math/
//                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
  
  /**
   * Base class representing helper functions necessary for creating, altering, and dropping database schema objects.
   */
  abstract class SchemaUtilityApi {
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#
//                                display_name SchemaUtilityApi
//                                documentation ```kotlin\npublic abstract class SchemaUtilityApi : Any\n```\n\n----\n\n\n Base class representing helper functions necessary for creating, altering, and dropping database schema objects.\n
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#`<init>`().
//                                display_name SchemaUtilityApi
//                                documentation ```kotlin\npublic constructor(): SchemaUtilityApi\n```\n\n----\n\n\n Base class representing helper functions necessary for creating, altering, and dropping database schema objects.\n
      // TODO make companion object with public string fields
      @InternalApi
      protected val columnsLogMessage = "Extracting table columns"
//                  ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#columnsLogMessage.
//                                    display_name columnsLogMessage
//                                    documentation ```kotlin\n@InternalApi() protected final val columnsLogMessage: String\n```
//                  ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getColumnsLogMessage().
//                                    display_name columnsLogMessage
//                                    documentation ```kotlin\nprotected get(): String\n```
  
      @InternalApi
      protected val primaryKeysLogMessage = "Extracting primary keys"
//                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getPrimaryKeysLogMessage().
//                                        display_name primaryKeysLogMessage
//                                        documentation ```kotlin\nprotected get(): String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeysLogMessage.
//                                        display_name primaryKeysLogMessage
//                                        documentation ```kotlin\n@InternalApi() protected final val primaryKeysLogMessage: String\n```
  
      @InternalApi
      protected val constraintsLogMessage = "Extracting column constraints"
//                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#constraintsLogMessage.
//                                        display_name constraintsLogMessage
//                                        documentation ```kotlin\n@InternalApi() protected final val constraintsLogMessage: String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getConstraintsLogMessage().
//                                        display_name constraintsLogMessage
//                                        documentation ```kotlin\nprotected get(): String\n```
  
      @InternalApi
      protected val createTablesLogMessage = "Preparing create tables statements"
//                  ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createTablesLogMessage.
//                                         display_name createTablesLogMessage
//                                         documentation ```kotlin\n@InternalApi() protected final val createTablesLogMessage: String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getCreateTablesLogMessage().
//                                         display_name createTablesLogMessage
//                                         documentation ```kotlin\nprotected get(): String\n```
  
      @InternalApi
      protected val executeCreateTablesLogMessage = "Executing create tables statements"
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#executeCreateTablesLogMessage.
//                                                display_name executeCreateTablesLogMessage
//                                                documentation ```kotlin\n@InternalApi() protected final val executeCreateTablesLogMessage: String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getExecuteCreateTablesLogMessage().
//                                                display_name executeCreateTablesLogMessage
//                                                documentation ```kotlin\nprotected get(): String\n```
  
      @InternalApi
      protected val createSequencesLogMessage = "Preparing create sequences statements"
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createSequencesLogMessage.
//                                            display_name createSequencesLogMessage
//                                            documentation ```kotlin\n@InternalApi() protected final val createSequencesLogMessage: String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getCreateSequencesLogMessage().
//                                            display_name createSequencesLogMessage
//                                            documentation ```kotlin\nprotected get(): String\n```
  
      @InternalApi
      protected val alterTablesLogMessage = "Preparing alter tables statements"
//                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#alterTablesLogMessage.
//                                        display_name alterTablesLogMessage
//                                        documentation ```kotlin\n@InternalApi() protected final val alterTablesLogMessage: String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getAlterTablesLogMessage().
//                                        display_name alterTablesLogMessage
//                                        documentation ```kotlin\nprotected get(): String\n```
  
      @InternalApi
      protected val executeAlterTablesLogMessage = "Executing alter tables statements"
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#executeAlterTablesLogMessage.
//                                               display_name executeAlterTablesLogMessage
//                                               documentation ```kotlin\n@InternalApi() protected final val executeAlterTablesLogMessage: String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getExecuteAlterTablesLogMessage().
//                                               display_name executeAlterTablesLogMessage
//                                               documentation ```kotlin\nprotected get(): String\n```
  
      @InternalApi
      protected val mappingConsistenceLogMessage = "Checking mapping consistence"
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getMappingConsistenceLogMessage().
//                                               display_name mappingConsistenceLogMessage
//                                               documentation ```kotlin\nprotected get(): String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mappingConsistenceLogMessage.
//                                               display_name mappingConsistenceLogMessage
//                                               documentation ```kotlin\n@InternalApi() protected final val mappingConsistenceLogMessage: String\n```
  
      /** Returns this list of tables sorted according to the targets of their foreign key constraints, if any exist. */
      @InternalApi
      protected fun Iterable<Table>.sortByReferences(): List<Table> = TableDepthGraph(this).sorted()
//                                  ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#sortByReferences().
//                                                   display_name sortByReferences
//                                                   documentation ```kotlin\n@InternalApi() protected final fun Iterable<Table>.sortByReferences(): List<Table>\n```\n\n----\n\n Returns this list of tables sorted according to the targets of their foreign key constraints, if any exist.
//                                                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#`<init>`().
//                                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#sorted().
  
      /** Whether any table from this list has a sequence of foreign key constraints that cycle back to them. */
      @InternalApi
      protected fun List<Table>.hasCycle(): Boolean = TableDepthGraph(this).hasCycle()
//                              ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#hasCycle().
//                                       display_name hasCycle
//                                       documentation ```kotlin\n@InternalApi() protected final fun List<Table>.hasCycle(): Boolean\n```\n\n----\n\n Whether any table from this list has a sequence of foreign key constraints that cycle back to them.
//                                          ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#`<init>`().
//                                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#hasCycle().
  
      /** Returns DDL for [table] without a sequence as a Pair of CREATE (includes its indexes) and ALTER statements. */
      @InternalApi
      protected fun tableDdlWithoutExistingSequence(
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().
//                                                  display_name tableDdlWithoutExistingSequence
//                                                  documentation ```kotlin\n@InternalApi() protected final fun tableDdlWithoutExistingSequence(table: Table, existingSequence: Sequence?): Pair<List<String>, List<String>>\n```\n\n----\n\n Returns DDL for [table] without a sequence as a Pair of CREATE (includes its indexes) and ALTER statements.
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
          existingSequence: Sequence?
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(existingSequence)
//                         display_name existingSequence
//                         documentation ```kotlin\nexistingSequence: Sequence?\n```
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
      ): Pair<List<String>, List<String>> {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#
          val ddlWithoutExistingSequence = table.ddl.filter { statement ->
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 0
//                                       display_name ddlWithoutExistingSequence
//                                       documentation ```kotlin\nlocal val ddlWithoutExistingSequence: Pair<List<String>, List<String>>\n```
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(table)
//                                               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#ddl.
//                                               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#getDdl().
//                                                   ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                                            ^^^^^^^^^ definition semanticdb maven . . (statement)
//                                                                      display_name statement
//                                                                      documentation ```kotlin\nstatement: String\n```
              if (existingSequence != null) {
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(existingSequence)
                  !statement.lowercase().startsWith("create sequence") ||
//                ^ reference semanticdb maven . . kotlin/Boolean#not().
//                 ^^^^^^^^^ reference semanticdb maven . . (statement)
//                           ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
//                                       ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
                      !statement.contains(existingSequence.name)
//                    ^ reference semanticdb maven . . kotlin/Boolean#not().
//                     ^^^^^^^^^ reference semanticdb maven . . (statement)
//                               ^^^^^^^^ reference semanticdb maven . . kotlin/text/contains().
//                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(existingSequence)
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getName().
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#name.
              } else {
                  true
              }
          }.partition { it.startsWith("CREATE ") }
//          ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/partition(+9).
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                 display_name it
//                                                 documentation ```kotlin\nit: Table\n```
//                      ^^ reference semanticdb maven . . (it)
//                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
          val indicesDDL = table.indices.flatMap { it.createStatement() }
//            ^^^^^^^^^^ definition local 1
//                       display_name indicesDDL
//                       documentation ```kotlin\nlocal val indicesDDL: List<String>\n```
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(table)
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getIndices().
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#indices.
//                                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap(+10).
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                        display_name it
//                                                                        documentation ```kotlin\nit: Table\n```
//                                                 ^^ reference semanticdb maven . . (it)
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#createStatement().
          return Pair(ddlWithoutExistingSequence.first + indicesDDL, ddlWithoutExistingSequence.second)
//               ^^^^ reference semanticdb maven . . kotlin/Pair#`<init>`().
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 0
//                                               ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                               ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                     ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                       ^^^^^^^^^^ reference local 1
//                                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 0
//                                                                                              ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                                                                              ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
      }
  
      /** Returns the SQL statements that create this [ForeignKeyConstraint]. */
      @InternalApi
      protected fun ForeignKeyConstraint.createDdl(): List<String> = with(this) {
//                                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createDdl().
//                                                 display_name createDdl
//                                                 documentation ```kotlin\n@InternalApi() protected final fun ForeignKeyConstraint.createDdl(): List<String>\n```\n\n----\n\n Returns the SQL statements that create this [ForeignKeyConstraint].
//                                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                   ^^^^ reference semanticdb maven . . kotlin/with().
          val allFromColumnsBelongsToTheSameTable = from.all { it.table == fromTable }
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 2
//                                                display_name allFromColumnsBelongsToTheSameTable
//                                                documentation ```kotlin\nlocal val allFromColumnsBelongsToTheSameTable: Boolean\n```
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#from.
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFrom().
//                                                       ^^^ reference semanticdb maven . . kotlin/collections/all(+9).
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                     display_name it
//                                                                                     documentation ```kotlin\nit: Table\n```
//                                                             ^^ reference semanticdb maven . . (it)
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromTable.
//                                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromTable().
          require(allFromColumnsBelongsToTheSameTable) {
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 2
              "Not all referencing columns of $this belong to the same table"
          }
          val allTargetColumnsBelongToTheSameTable = target.all { it.table == targetTable }
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 3
//                                                 display_name allTargetColumnsBelongToTheSameTable
//                                                 documentation ```kotlin\nlocal val allTargetColumnsBelongToTheSameTable: Boolean\n```
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTarget().
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#target.
//                                                          ^^^ reference semanticdb maven . . kotlin/collections/all(+9).
//                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                          display_name it
//                                                                                          documentation ```kotlin\nit: Table\n```
//                                                                ^^ reference semanticdb maven . . (it)
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTable().
//                                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTable.
          require(allTargetColumnsBelongToTheSameTable) {
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 3
              "Not all referenced columns of $this belong to the same table"
          }
          require(from.size == target.size) { "$this referencing columns are not in accordance with referenced" }
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#from.
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFrom().
//                     ^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashSet#size.
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTarget().
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#target.
//                                    ^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashSet#size.
          require(deleteRule != null || updateRule != null) { "$this has no reference constraint actions" }
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#deleteRule.
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getDeleteRule().
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getUpdateRule().
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#updateRule.
          require(target.toHashSet().size == target.size) { "Not all referenced columns of $this are unique" }
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTarget().
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#target.
//                       ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/toHashSet(+9).
//                                   ^^^^ reference semanticdb maven jdk 11 java/util/HashSet#getSize().
//                                   ^^^^ reference semanticdb maven jdk 11 java/util/HashSet#size.
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTarget().
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#target.
//                                                  ^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashSet#size.
          return createStatement()
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#createStatement().
      }
  
      /** Adds CREATE/ALTER statements for all table columns that don't exist in the database, to [destination]. */
      @InternalApi
      protected fun <C : MutableCollection<String>> Table.mapMissingColumnStatementsTo(
//                   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().[C]
//                     display_name FirTypeParameterSymbol C
//                     documentation ```kotlin\nC : MutableCollection<String>\n```
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().
//                                                                                     display_name mapMissingColumnStatementsTo
//                                                                                     documentation ```kotlin\n@InternalApi() protected final fun <C : MutableCollection<String>> Table.mapMissingColumnStatementsTo(destination: C, existingColumns: List<ColumnMetadata>, existingPrimaryKey: PrimaryKeyMetadata?, alterTableAddColumnSupported: Boolean): C\n```\n\n----\n\n Adds CREATE/ALTER statements for all table columns that don't exist in the database, to [destination].
          destination: C,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(destination)
//                    display_name destination
//                    documentation ```kotlin\ndestination: C\n```
          existingColumns: List<ColumnMetadata>,
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(existingColumns)
//                        display_name existingColumns
//                        documentation ```kotlin\nexistingColumns: List<ColumnMetadata>\n```
//                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          existingPrimaryKey: PrimaryKeyMetadata?,
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(existingPrimaryKey)
//                           display_name existingPrimaryKey
//                           documentation ```kotlin\nexistingPrimaryKey: PrimaryKeyMetadata?\n```
//                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#
          alterTableAddColumnSupported: Boolean
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(alterTableAddColumnSupported)
//                                     display_name alterTableAddColumnSupported
//                                     documentation ```kotlin\nalterTableAddColumnSupported: Boolean\n```
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      ): C {
          // create columns
          val existingTableColumns = columns.mapNotNull { column ->
//            ^^^^^^^^^^^^^^^^^^^^ definition local 4
//                                 display_name existingTableColumns
//                                 documentation ```kotlin\nlocal val existingTableColumns: Map<Column<*>, ColumnMetadata>\n```
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                                           ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mapNotNull(+1).
//                                                        ^^^^^^ definition semanticdb maven . . (column)
//                                                               display_name column
//                                                               documentation ```kotlin\ncolumn: Column<*>\n```
              val existingColumn = existingColumns.find { column.nameUnquoted().equals(it.name, true) }
//                ^^^^^^^^^^^^^^ definition local 5
//                               display_name existingColumn
//                               documentation ```kotlin\nlocal val existingColumn: ColumnMetadata?\n```
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(existingColumns)
//                                                 ^^^^ reference semanticdb maven . . kotlin/collections/find(+9).
//                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                      display_name it
//                                                                                                      documentation ```kotlin\nit: Table\n```
//                                                        ^^^^^^ reference semanticdb maven . . (column)
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#nameUnquoted().
//                                                                              ^^^^^^ reference semanticdb maven . . kotlin/text/equals(+1).
//                                                                                     ^^ reference semanticdb maven . . (it)
//                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getName().
//                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#name.
              if (existingColumn != null) column to existingColumn else null
//                ^^^^^^^^^^^^^^ reference local 5
//                                        ^^^^^^ reference semanticdb maven . . (column)
//                                               ^^ reference semanticdb maven . . kotlin/to().
//                                                  ^^^^^^^^^^^^^^ reference local 5
          }.toMap()
//          ^^^^^ reference semanticdb maven . . kotlin/collections/toMap().
          val missingTableColumns = columns.filter { it !in existingTableColumns }
//            ^^^^^^^^^^^^^^^^^^^ definition local 6
//                                display_name missingTableColumns
//                                documentation ```kotlin\nlocal val missingTableColumns: List<Column<*>>\n```
//                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                                          ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                 display_name it
//                                                                                 documentation ```kotlin\nit: Table\n```
//                                                   ^^ reference semanticdb maven . . (it)
//                                                      ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                      ^^^ reference semanticdb maven . . kotlin/collections/contains(+10).
//                                                          ^^^^^^^^^^^^^^^^^^^^ reference local 4
          missingTableColumns.flatMapTo(destination) { it.ddl }
//        ^^^^^^^^^^^^^^^^^^^ reference local 6
//                            ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMapTo(+10).
//                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(destination)
//                                                   ^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                              display_name it
//                                                              documentation ```kotlin\nit: Table\n```
//                                                     ^^ reference semanticdb maven . . (it)
//                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#ddl.
//                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#getDdl().
          if (alterTableAddColumnSupported) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(alterTableAddColumnSupported)
              // create indexes with new columns
              indices.filter { index ->
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getIndices().
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#indices.
//                    ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                             ^^^^^ definition semanticdb maven . . (index)
//                                   display_name index
//                                   documentation ```kotlin\nindex: Index\n```
                  index.columns.any { missingTableColumns.contains(it) }
//                ^^^^^ reference semanticdb maven . . (index)
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                              ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                       display_name it
//                                                                       documentation ```kotlin\nit: Table\n```
//                                    ^^^^^^^^^^^^^^^^^^^ reference local 6
//                                                        ^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#contains().
//                                                                 ^^ reference semanticdb maven . . (it)
              }.forEach { destination.addAll(it.createStatement()) }
//              ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                   display_name it
//                                                                   documentation ```kotlin\nit: Table\n```
//                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(destination)
//                                    ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableCollection#addAll().
//                                           ^^ reference semanticdb maven . . (it)
//                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#createStatement().
              // sync existing columns
              existingTableColumns
//            ^^^^^^^^^^^^^^^^^^^^ reference local 4
                  .mapColumnDiffs()
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapColumnDiffs().
                  .flatMapTo(destination) { (col, changedState) ->
//                 ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMapTo(+12).
//                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(destination)
//                                          ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                              display_name <destruct>
//                                                              documentation ```kotlin\n<destruct>: Map.Entry<Column<*>, ColumnMetadata>\n```
//                                           ^^^ definition local 7
//                                               display_name col
//                                               documentation ```kotlin\nlocal val col: Column<*>\n```
//                                           ^^^ reference semanticdb maven . . (`<destruct>`)
//                                           ^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                                ^^^^^^^^^^^^ definition local 8
//                                                             display_name changedState
//                                                             documentation ```kotlin\nlocal val changedState: ColumnDiff\n```
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
                      col.modifyStatements(changedState)
//                    ^^^ reference local 7
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#modifyStatements().
//                                         ^^^^^^^^^^^^ reference local 8
                  }
              // add missing primary key
              primaryKeyDdl(missingTableColumns, existingPrimaryKey)?.let { destination.add(it) }
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeyDdl().
//                          ^^^^^^^^^^^^^^^^^^^ reference local 6
//                                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(existingPrimaryKey)
//                                                                    ^^^ reference semanticdb maven . . kotlin/let().
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                display_name it
//                                                                                                documentation ```kotlin\nit: Table\n```
//                                                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(destination)
//                                                                                      ^^^ reference semanticdb maven . . kotlin/collections/MutableCollection#add().
//                                                                                          ^^ reference semanticdb maven . . (it)
          }
          return destination
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(destination)
      }
  
      /** Adds CREATE/ALTER/DROP statements for all foreign key constraints that don't exist in the database, to [destination]. */
      @InternalApi
      protected fun <C : MutableCollection<String>> mapMissingConstraintsTo(
//                   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().[C]
//                     display_name FirTypeParameterSymbol C
//                     documentation ```kotlin\nC : MutableCollection<String>\n```
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().
//                                                                          display_name mapMissingConstraintsTo
//                                                                          documentation ```kotlin\n@InternalApi() protected final fun <C : MutableCollection<String>> mapMissingConstraintsTo(destination: C, allExistingConstraints: Map<Pair<Table, {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>>, List<ForeignKeyConstraint>>, vararg tables: Table): C\n```\n\n----\n\n Adds CREATE/ALTER/DROP statements for all foreign key constraints that don't exist in the database, to [destination].
          destination: C,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(destination)
//                    display_name destination
//                    documentation ```kotlin\ndestination: C\n```
          allExistingConstraints: Map<Pair<Table, LinkedHashSet<Column<*>>>, List<ForeignKeyConstraint>>,
//        ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(allExistingConstraints)
//                               display_name allExistingConstraints
//                               documentation ```kotlin\nallExistingConstraints: Map<Pair<Table, {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>>, List<ForeignKeyConstraint>>\n```
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
          vararg tables: Table
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(tables)
//                      display_name tables
//                      documentation ```kotlin\nvararg tables: Table\n```
//                       ^^^^^ reference semanticdb maven . . kotlin/Array#
      ): C {
          val foreignKeyConstraints = tables.flatMap { table ->
//            ^^^^^^^^^^^^^^^^^^^^^ definition local 9
//                                  display_name foreignKeyConstraints
//                                  documentation ```kotlin\nlocal val foreignKeyConstraints: List<Pair<ForeignKeyConstraint, ForeignKeyConstraint?>>\n```
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(tables)
//                                           ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap().
//                                                     ^^^^^ definition semanticdb maven . . (table)
//                                                           display_name table
//                                                           documentation ```kotlin\ntable: Table\n```
              table.foreignKeys.map { it to allExistingConstraints[table to it.from]?.firstOrNull() }
//            ^^^^^ reference semanticdb maven . . (table)
//                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKeys.
//                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getForeignKeys().
//                              ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                    display_name it
//                                                                                                    documentation ```kotlin\nit: Table\n```
//                                    ^^ reference semanticdb maven . . (it)
//                                       ^^ reference semanticdb maven . . kotlin/to().
//                                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(allExistingConstraints)
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                                 ^^^^^ reference semanticdb maven . . (table)
//                                                                       ^^ reference semanticdb maven . . kotlin/to().
//                                                                          ^^ reference semanticdb maven . . (it)
//                                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#from.
//                                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFrom().
//                                                                                    ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+19).
          }
          for ((foreignKey, existingConstraint) in foreignKeyConstraints) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 11
//                                              display_name <destruct>
//                                              documentation ```kotlin\nlocal val <destruct>: Pair<ForeignKeyConstraint, ForeignKeyConstraint?>\n```
//              ^^^^^^^^^^ reference local 11
//              ^^^^^^^^^^ definition local 12
//                         display_name foreignKey
//                         documentation ```kotlin\nlocal val foreignKey: ForeignKeyConstraint\n```
//              ^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                          ^^^^^^^^^^^^^^^^^^ reference local 11
//                          ^^^^^^^^^^^^^^^^^^ definition local 13
//                                             display_name existingConstraint
//                                             documentation ```kotlin\nlocal val existingConstraint: ForeignKeyConstraint?\n```
//                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                 ^^^^^^^^^^^^^^^^^^^^^ definition local 10
//                                                                       display_name <iterator>
//                                                                       documentation ```kotlin\nlocal val <iterator>: Iterator<Pair<ForeignKeyConstraint, ForeignKeyConstraint?>>\n```
//                                                 ^^^^^^^^^^^^^^^^^^^^^ reference local 10
//                                                 ^^^^^^^^^^^^^^^^^^^^^ reference local 9
//                                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#hasNext().
//                                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#next().
//                                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#iterator().
              if (existingConstraint == null) {
//                ^^^^^^^^^^^^^^^^^^ reference local 13
                  destination.addAll(foreignKey.createDdl())
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(destination)
//                            ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableCollection#addAll().
//                                   ^^^^^^^^^^ reference local 12
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createDdl().
                  continue
              }
              val noForeignKey = existingConstraint.targetTable != foreignKey.targetTable
//                ^^^^^^^^^^^^ definition local 14
//                             display_name noForeignKey
//                             documentation ```kotlin\nlocal val noForeignKey: Boolean\n```
//                               ^^^^^^^^^^^^^^^^^^ reference local 13
//                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTable().
//                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTable.
//                                                                 ^^^^^^^^^^ reference local 12
//                                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTable().
//                                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTable.
              val deleteRuleMismatch = foreignKey.deleteRule != existingConstraint.deleteRule
//                ^^^^^^^^^^^^^^^^^^ definition local 15
//                                   display_name deleteRuleMismatch
//                                   documentation ```kotlin\nlocal val deleteRuleMismatch: Boolean\n```
//                                     ^^^^^^^^^^ reference local 12
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#deleteRule.
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getDeleteRule().
//                                                              ^^^^^^^^^^^^^^^^^^ reference local 13
//                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#deleteRule.
//                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getDeleteRule().
              val updateRuleMismatch = foreignKey.updateRule != existingConstraint.updateRule
//                ^^^^^^^^^^^^^^^^^^ definition local 16
//                                   display_name updateRuleMismatch
//                                   documentation ```kotlin\nlocal val updateRuleMismatch: Boolean\n```
//                                     ^^^^^^^^^^ reference local 12
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getUpdateRule().
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#updateRule.
//                                                              ^^^^^^^^^^^^^^^^^^ reference local 13
//                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getUpdateRule().
//                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#updateRule.
              if (noForeignKey || deleteRuleMismatch || updateRuleMismatch) {
//                ^^^^^^^^^^^^ reference local 14
//                                ^^^^^^^^^^^^^^^^^^ reference local 15
//                                                      ^^^^^^^^^^^^^^^^^^ reference local 16
                  destination.addAll(existingConstraint.dropStatement())
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(destination)
//                            ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableCollection#addAll().
//                                   ^^^^^^^^^^^^^^^^^^ reference local 13
//                                                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#dropStatement().
                  destination.addAll(foreignKey.createDdl())
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(destination)
//                            ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableCollection#addAll().
//                                   ^^^^^^^^^^ reference local 12
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createDdl().
              }
          }
          return destination
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(destination)
      }
  
      /**
       * Filters all table indices and returns those that are defined on a table with more than one index.
       * If [withLogs] is `true`, DROP statements for these indices will also be logged.
       */
      @InternalApi
      protected fun Map<Table, List<Index>>.filterAndLogExcessIndices(withLogs: Boolean): List<Index> {
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessIndices().
//                                                                    display_name filterAndLogExcessIndices
//                                                                    documentation ```kotlin\n@InternalApi() protected final fun Map<Table, List<Index>>.filterAndLogExcessIndices(withLogs: Boolean): List<Index>\n```\n\n----\n\n\n Filters all table indices and returns those that are defined on a table with more than one index.\n If [withLogs] is `true`, DROP statements for these indices will also be logged.\n
//                                                                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessIndices().(withLogs)
//                                                                             display_name withLogs
//                                                                             documentation ```kotlin\nwithLogs: Boolean\n```
//                                                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                        ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          val excessiveIndices = flatMap { (_, indices) -> indices }
//            ^^^^^^^^^^^^^^^^ definition local 17
//                             display_name excessiveIndices
//                             documentation ```kotlin\nlocal val excessiveIndices: Map<Triple<Table, Boolean, String>, List<Index>>\n```
//                               ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap(+12).
//                                         ^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                      display_name <destruct>
//                                                      documentation ```kotlin\n<destruct>: Map.Entry<Column<*>, ColumnMetadata>\n```
//                                          ^ definition local 18
//                                            display_name <unused var>
//                                            documentation ```kotlin\nlocal val <unused var>: Table\n```
//                                          ^ reference semanticdb maven . . (`<destruct>`)
//                                          ^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                             ^^^^^^^ definition local 19
//                                                     display_name indices
//                                                     documentation ```kotlin\nlocal val indices: List<Index>\n```
//                                             ^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                             ^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
//                                                         ^^^^^^^ reference local 19
              .groupBy { index ->
//             ^^^^^^^ reference semanticdb maven . . kotlin/collections/groupBy(+18).
//                       ^^^^^ definition semanticdb maven . . (index)
//                             display_name index
//                             documentation ```kotlin\nindex: Index\n```
                  Triple(index.table, index.unique, index.columns.joinToString { column -> column.name })
//                ^^^^^^ reference semanticdb maven . . kotlin/Triple#`<init>`().
//                       ^^^^^ reference semanticdb maven . . (index)
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                                    ^^^^^ reference semanticdb maven . . (index)
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
//                                                  ^^^^^ reference semanticdb maven . . (index)
//                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                                                                ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                               ^^^^^^ definition semanticdb maven . . (column)
//                                                                                      display_name column
//                                                                                      documentation ```kotlin\ncolumn: Column<*>\n```
//                                                                                         ^^^^^^ reference semanticdb maven . . (column)
//                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
              }
              .filterValues { it.size > 1 }
//             ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterValues().
//                          ^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                          display_name it
//                                          documentation ```kotlin\nit: Table\n```
//                            ^^ reference semanticdb maven . . (it)
//                               ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                               ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                    ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
          if (excessiveIndices.isEmpty()) return emptyList()
//            ^^^^^^^^^^^^^^^^ reference local 17
//                             ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#isEmpty().
//                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
          val toDrop = HashSet<Index>()
//            ^^^^^^ definition local 20
//                   display_name toDrop
//                   documentation ```kotlin\nlocal val toDrop: {kotlin/collections/HashSet<org/jetbrains/exposed/v1/core/Index>=} HashSet<Index>\n```
//                     ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#`<init>`().
          if (withLogs) {
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessIndices().(withLogs)
              exposedLogger.warn("List of excessive indices:")
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
              excessiveIndices.forEach { (triple, indices) ->
//            ^^^^^^^^^^^^^^^^ reference local 17
//                             ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                                       ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                         display_name <destruct>
//                                                         documentation ```kotlin\n<destruct>: Map.Entry<Column<*>, ColumnMetadata>\n```
//                                        ^^^^^^ definition local 21
//                                               display_name triple
//                                               documentation ```kotlin\nlocal val triple: Triple<Table, Boolean, String>\n```
//                                        ^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                        ^^^^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                                ^^^^^^^ definition local 22
//                                                        display_name indices
//                                                        documentation ```kotlin\nlocal val indices: List<Index>\n```
//                                                ^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
                  val indexNames = indices.joinToString(", ") { index -> index.indexName }
//                    ^^^^^^^^^^ definition local 23
//                               display_name indexNames
//                               documentation ```kotlin\nlocal val indexNames: String\n```
//                                 ^^^^^^^ reference local 22
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                              ^^^^^ definition semanticdb maven . . (index)
//                                                                    display_name index
//                                                                    documentation ```kotlin\nindex: Index\n```
//                                                                       ^^^^^ reference semanticdb maven . . (index)
//                                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
                  exposedLogger.warn("\t\t\t'${triple.first.tableName}'.'${triple.third}' -> $indexNames")
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                              ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                             ^^^^^^ reference local 21
//                                                    ^^^^^ reference semanticdb maven . . kotlin/Triple#first.
//                                                    ^^^^^ reference semanticdb maven . . kotlin/Triple#getFirst().
//                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                         ^^^^^^ reference local 21
//                                                                                ^^^^^ reference semanticdb maven . . kotlin/Triple#getThird().
//                                                                                ^^^^^ reference semanticdb maven . . kotlin/Triple#third.
//                                                                                            ^^^^^^^^^^ reference local 23
              }
              exposedLogger.info("SQL Queries to remove excessive indices:")
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#info().
          }
          excessiveIndices.forEach { (_, indices) ->
//        ^^^^^^^^^^^^^^^^ reference local 17
//                         ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                                   ^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                display_name <destruct>
//                                                documentation ```kotlin\n<destruct>: Map.Entry<Column<*>, ColumnMetadata>\n```
//                                    ^ definition local 24
//                                      display_name <unused var>
//                                      documentation ```kotlin\nlocal val <unused var>: Triple<Table, Boolean, String>\n```
//                                    ^ reference semanticdb maven . . (`<destruct>`)
//                                    ^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                       ^^^^^^^ definition local 25
//                                               display_name indices
//                                               documentation ```kotlin\nlocal val indices: List<Index>\n```
//                                       ^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
              indices.take(indices.size - 1).forEach { index ->
//            ^^^^^^^ reference local 25
//                    ^^^^ reference semanticdb maven . . kotlin/collections/take(+9).
//                         ^^^^^^^ reference local 25
//                                 ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                 ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                      ^ reference semanticdb maven . . kotlin/Int#minus(+2).
//                                           ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                                     ^^^^^ definition semanticdb maven . . (index)
//                                                           display_name index
//                                                           documentation ```kotlin\nindex: Index\n```
                  toDrop.add(index)
//                ^^^^^^ reference local 20
//                       ^^^ reference semanticdb maven jdk 11 java/util/HashSet#add().
//                           ^^^^^ reference semanticdb maven . . (index)
                  if (withLogs) {
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessIndices().(withLogs)
                      exposedLogger.info("\t\t\t${index.dropStatement()};")
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                                  ^^^^ reference semanticdb maven . . org/slf4j/Logger#info().
//                                                ^^^^^ reference semanticdb maven . . (index)
//                                                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#dropStatement().
                  }
              }
          }
          return toDrop.toList()
//               ^^^^^^ reference local 20
//                      ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+10).
      }
  
      /**
       * Filters all table foreign keys and returns those that are defined on a table with more than one of this constraint.
       * If [withLogs] is `true`, DROP statements for these constraints will also be logged.
       */
      @InternalApi
      protected fun Map<Pair<Table, LinkedHashSet<Column<*>>>, List<ForeignKeyConstraint>>.filterAndLogExcessConstraints(
//                                                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessConstraints().
//                                                                                                                       display_name filterAndLogExcessConstraints
//                                                                                                                       documentation ```kotlin\n@InternalApi() protected final fun Map<Pair<Table, {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>>, List<ForeignKeyConstraint>>.filterAndLogExcessConstraints(withLogs: Boolean): List<ForeignKeyConstraint>\n```\n\n----\n\n\n Filters all table foreign keys and returns those that are defined on a table with more than one of this constraint.\n If [withLogs] is `true`, DROP statements for these constraints will also be logged.\n
          withLogs: Boolean
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessConstraints().(withLogs)
//                 display_name withLogs
//                 documentation ```kotlin\nwithLogs: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      ): List<ForeignKeyConstraint> {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          val excessiveConstraints = filterValues { it.size > 1 }
//            ^^^^^^^^^^^^^^^^^^^^ definition local 26
//                                 display_name excessiveConstraints
//                                 documentation ```kotlin\nlocal val excessiveConstraints: Map<Pair<Table, {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>>, List<ForeignKeyConstraint>>\n```
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterValues().
//                                                ^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                display_name it
//                                                                documentation ```kotlin\nit: Table\n```
//                                                  ^^ reference semanticdb maven . . (it)
//                                                     ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                                     ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                                          ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
          if (excessiveConstraints.isEmpty()) return emptyList()
//            ^^^^^^^^^^^^^^^^^^^^ reference local 26
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#isEmpty().
//                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
          val toDrop = HashSet<ForeignKeyConstraint>()
//            ^^^^^^ definition local 27
//                   display_name toDrop
//                   documentation ```kotlin\nlocal val toDrop: {kotlin/collections/HashSet<org/jetbrains/exposed/v1/core/ForeignKeyConstraint>=} HashSet<ForeignKeyConstraint>\n```
//                     ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#`<init>`().
          if (withLogs) {
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessConstraints().(withLogs)
              exposedLogger.warn("List of excessive foreign key constraints:")
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
              excessiveConstraints.forEach { (table, columns), fkConstraints ->
//            ^^^^^^^^^^^^^^^^^^^^ reference local 26
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#forEach().
//                                           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                            display_name <destruct>
//                                                            documentation ```kotlin\n<destruct>: Map.Entry<Column<*>, ColumnMetadata>\n```
//                                            ^^^^^ definition local 28
//                                                  display_name table
//                                                  documentation ```kotlin\nlocal val table: Table\n```
//                                            ^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                            ^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                   ^^^^^^^ definition local 29
//                                                           display_name columns
//                                                           documentation ```kotlin\nlocal val columns: {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>\n```
//                                                   ^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                   ^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                             ^^^^^^^^^^^^^ definition semanticdb maven . . (fkConstraints)
//                                                                           display_name fkConstraints
//                                                                           documentation ```kotlin\nfkConstraints: @EnhancedNullability List<ForeignKeyConstraint>\n```
                  val constraint = fkConstraints.first()
//                    ^^^^^^^^^^ definition local 30
//                               display_name constraint
//                               documentation ```kotlin\nlocal val constraint: ForeignKeyConstraint\n```
//                                 ^^^^^^^^^^^^^ reference semanticdb maven . . (fkConstraints)
//                                               ^^^^^ reference semanticdb maven . . kotlin/collections/first(+19).
                  val fkPartToLog = fkConstraints.joinToString(", ") { fkConstraint -> fkConstraint.fkName }
//                    ^^^^^^^^^^^ definition local 31
//                                display_name fkPartToLog
//                                documentation ```kotlin\nlocal val fkPartToLog: String\n```
//                                  ^^^^^^^^^^^^^ reference semanticdb maven . . (fkConstraints)
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                     ^^^^^^^^^^^^ definition semanticdb maven . . (fkConstraint)
//                                                                                  display_name fkConstraint
//                                                                                  documentation ```kotlin\nfkConstraint: ForeignKeyConstraint\n```
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . (fkConstraint)
//                                                                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fkName.
//                                                                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFkName().
                  exposedLogger.warn(
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                              ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
                      "\t\t\t'$table'.'$columns' -> '${constraint.fromTableName}':\t$fkPartToLog"
//                             ^^^^^ reference local 28
//                                      ^^^^^^^ reference local 29
//                                                     ^^^^^^^^^^ reference local 30
//                                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromTableName.
//                                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromTableName().
//                                                                                   ^^^^^^^^^^^ reference local 31
                  )
              }
              exposedLogger.info("SQL Queries to remove excessive keys:")
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#info().
          }
          excessiveConstraints.forEach { (_, fkConstraints) ->
//        ^^^^^^^^^^^^^^^^^^^^ reference local 26
//                             ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                                       ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                          display_name <destruct>
//                                                          documentation ```kotlin\n<destruct>: Map.Entry<Column<*>, ColumnMetadata>\n```
//                                        ^ definition local 32
//                                          display_name <unused var>
//                                          documentation ```kotlin\nlocal val <unused var>: Pair<Table, {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>>\n```
//                                        ^ reference semanticdb maven . . (`<destruct>`)
//                                        ^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                           ^^^^^^^^^^^^^ definition local 33
//                                                         display_name fkConstraints
//                                                         documentation ```kotlin\nlocal val fkConstraints: List<ForeignKeyConstraint>\n```
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
              fkConstraints.take(fkConstraints.size - 1).forEach { fkConstraint ->
//            ^^^^^^^^^^^^^ reference local 33
//                          ^^^^ reference semanticdb maven . . kotlin/collections/take(+9).
//                               ^^^^^^^^^^^^^ reference local 33
//                                             ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                             ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                                  ^ reference semanticdb maven . . kotlin/Int#minus(+2).
//                                                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                                                 ^^^^^^^^^^^^ definition semanticdb maven . . (fkConstraint)
//                                                                              display_name fkConstraint
//                                                                              documentation ```kotlin\nfkConstraint: ForeignKeyConstraint\n```
                  toDrop.add(fkConstraint)
//                ^^^^^^ reference local 27
//                       ^^^ reference semanticdb maven jdk 11 java/util/HashSet#add().
//                           ^^^^^^^^^^^^ reference semanticdb maven . . (fkConstraint)
                  if (withLogs) {
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessConstraints().(withLogs)
                      exposedLogger.info("\t\t\t${fkConstraint.dropStatement()};")
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                                  ^^^^ reference semanticdb maven . . org/slf4j/Logger#info().
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . (fkConstraint)
//                                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#dropStatement().
                  }
              }
          }
          return toDrop.toList()
//               ^^^^^^ reference local 27
//                      ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+10).
      }
  
      /**
       * Filters all table indices that are either missing from the database or exist in the database but are not mapped
       * in a table object. and returns those that are defined on a table with more than one of this constraint.
       * If [withLogs] is `true`, the corresponding statements for these indices will also be logged.
       *
       * @return Pair of CREATE statements for missing indices and, if [withDropIndices] is `true`, DROP statements ofr
       * unmapped indices; if [withDropIndices] is `false`, the second value will be an empty list.
       */
      @InternalApi
      protected fun Map<Table, List<Index>>.filterAndLogMissingAndUnmappedIndices(
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().
//                                                                                display_name filterAndLogMissingAndUnmappedIndices
//                                                                                documentation ```kotlin\n@InternalApi() protected final fun Map<Table, List<Index>>.filterAndLogMissingAndUnmappedIndices(existingFKConstraints: Set<Pair<Table, {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>>>, withDropIndices: Boolean, withLogs: Boolean, vararg tables: Table): Pair<List<Index>, List<Index>>\n```\n\n----\n\n\n Filters all table indices that are either missing from the database or exist in the database but are not mapped\n in a table object. and returns those that are defined on a table with more than one of this constraint.\n If [withLogs] is `true`, the corresponding statements for these indices will also be logged.\n\n @return Pair of CREATE statements for missing indices and, if [withDropIndices] is `true`, DROP statements ofr\n unmapped indices; if [withDropIndices] is `false`, the second value will be an empty list.\n
          existingFKConstraints: Set<Pair<Table, LinkedHashSet<Column<*>>>>,
//        ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(existingFKConstraints)
//                              display_name existingFKConstraints
//                              documentation ```kotlin\nexistingFKConstraints: Set<Pair<Table, {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>>>\n```
//                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Set#
          withDropIndices: Boolean,
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withDropIndices)
//                        display_name withDropIndices
//                        documentation ```kotlin\nwithDropIndices: Boolean\n```
//                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          withLogs: Boolean,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withLogs)
//                 display_name withLogs
//                 documentation ```kotlin\nwithLogs: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          vararg tables: Table
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(tables)
//                      display_name tables
//                      documentation ```kotlin\nvararg tables: Table\n```
//                       ^^^^^ reference semanticdb maven . . kotlin/Array#
      ): Pair<List<Index>, List<Index>> {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#
          fun List<Index>.filterForeignKeys() = if (currentDialect is MysqlDialect) {
//                        ^^^^^^^^^^^^^^^^^ definition local 34
//                                          display_name filterForeignKeys
//                                          documentation ```kotlin\nlocal final fun List<Index>.filterForeignKeys(): List<Index>\n```
//                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
              filterNot { it.table to LinkedHashSet(it.columns) in existingFKConstraints }
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterNot(+9).
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                         display_name it
//                                                                                         documentation ```kotlin\nit: Table\n```
//                        ^^ reference semanticdb maven . . (it)
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                                 ^^ reference semanticdb maven . . kotlin/to().
//                                    ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashSet#`<init>`().
//                                                  ^^ reference semanticdb maven . . (it)
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                                                              ^^ reference semanticdb maven . . kotlin/collections/Set#contains().
//                                                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(existingFKConstraints)
          } else {
              this
          }
  
          // SQLite: indices whose names start with "sqlite_" are meant for internal use
          fun List<Index>.filterInternalIndices() = if (currentDialect is SQLiteDialect) {
//                        ^^^^^^^^^^^^^^^^^^^^^ definition local 35
//                                              display_name filterInternalIndices
//                                              documentation ```kotlin\nlocal final fun List<Index>.filterInternalIndices(): List<Index>\n```
//                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
              filter { !it.indexName.startsWith("sqlite_") }
//            ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                           display_name it
//                                                           documentation ```kotlin\nit: Table\n```
//                     ^ reference semanticdb maven . . kotlin/Boolean#not().
//                      ^^ reference semanticdb maven . . (it)
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
//                                   ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
          } else {
              this
          }
  
          fun Table.existingIndices() = this@filterAndLogMissingAndUnmappedIndices[this].orEmpty()
//                  ^^^^^^^^^^^^^^^ definition local 36
//                                  display_name existingIndices
//                                  documentation ```kotlin\nlocal final fun Table.existingIndices(): List<Index>\n```
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                                                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/orEmpty(+2).
              .filterForeignKeys()
//             ^^^^^^^^^^^^^^^^^ reference local 34
              .filterInternalIndices()
//             ^^^^^^^^^^^^^^^^^^^^^ reference local 35
  
          fun Table.mappedIndices() = this.indices.filterForeignKeys().filterInternalIndices()
//                  ^^^^^^^^^^^^^ definition local 37
//                                display_name mappedIndices
//                                documentation ```kotlin\nlocal final fun Table.mappedIndices(): List<Index>\n```
//                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getIndices().
//                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#indices.
//                                                 ^^^^^^^^^^^^^^^^^ reference local 34
//                                                                     ^^^^^^^^^^^^^^^^^^^^^ reference local 35
          val missingIndices = HashSet<Index>()
//            ^^^^^^^^^^^^^^ definition local 38
//                           display_name missingIndices
//                           documentation ```kotlin\nlocal val missingIndices: {kotlin/collections/HashSet<org/jetbrains/exposed/v1/core/Index>=} HashSet<Index>\n```
//                             ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#`<init>`().
          val unMappedIndices = HashMap<String, MutableSet<Index>>()
//            ^^^^^^^^^^^^^^^ definition local 39
//                            display_name unMappedIndices
//                            documentation ```kotlin\nlocal val unMappedIndices: {kotlin/collections/HashMap<kotlin/String, kotlin/collections/MutableSet<org/jetbrains/exposed/v1/core/Index>>=} HashMap<String, MutableSet<Index>>\n```
//                              ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashMap#`<init>`().
          val nameDiffers = HashSet<Index>()
//            ^^^^^^^^^^^ definition local 40
//                        display_name nameDiffers
//                        documentation ```kotlin\nlocal val nameDiffers: {kotlin/collections/HashSet<org/jetbrains/exposed/v1/core/Index>=} HashSet<Index>\n```
//                          ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#`<init>`().
          tables.forEach { table ->
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(tables)
//               ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach().
//                         ^^^^^ definition semanticdb maven . . (table)
//                               display_name table
//                               documentation ```kotlin\ntable: Table\n```
              val existingTableIndices = table.existingIndices()
//                ^^^^^^^^^^^^^^^^^^^^ definition local 41
//                                     display_name existingTableIndices
//                                     documentation ```kotlin\nlocal val existingTableIndices: List<Index>\n```
//                                       ^^^^^ reference semanticdb maven . . (table)
//                                             ^^^^^^^^^^^^^^^ reference local 36
              val mappedIndices = table.mappedIndices()
//                ^^^^^^^^^^^^^ definition local 42
//                              display_name mappedIndices
//                              documentation ```kotlin\nlocal val mappedIndices: List<Index>\n```
//                                ^^^^^ reference semanticdb maven . . (table)
//                                      ^^^^^^^^^^^^^ reference local 37
              for (index in existingTableIndices) {
//                 ^^^^^ definition local 44
//                       display_name index
//                       documentation ```kotlin\nlocal val index: Index\n```
//                          ^^^^^^^^^^^^^^^^^^^^ reference local 41
//                          ^^^^^^^^^^^^^^^^^^^^ definition local 43
//                                               display_name <iterator>
//                                               documentation ```kotlin\nlocal val <iterator>: Iterator<Index>\n```
//                          ^^^^^^^^^^^^^^^^^^^^ reference local 43
//                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#hasNext().
//                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#next().
//                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#iterator().
                  val mappedIndex = mappedIndices.firstOrNull { it.onlyNameDiffer(index) } ?: continue
//                    ^^^^^^^^^^^ definition local 45
//                                display_name mappedIndex
//                                documentation ```kotlin\nlocal val mappedIndex: Index\n```
//                                  ^^^^^^^^^^^^^ reference local 42
//                                                ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+20).
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                         display_name it
//                                                                                         documentation ```kotlin\nit: Table\n```
//                                                              ^^ reference semanticdb maven . . (it)
//                                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#onlyNameDiffer().
//                                                                                ^^^^^ reference local 44
                  if (withLogs) {
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withLogs)
                      exposedLogger.info(
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                                  ^^^^ reference semanticdb maven . . org/slf4j/Logger#info().
                          "Index on table '${table.tableName}' differs only in name: in db ${index.indexName} " +
//                                           ^^^^^ reference semanticdb maven . . (table)
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                                           ^^^^^ reference local 44
//                                                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                                                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
                              "-> in mapping ${mappedIndex.indexName}"
//                                             ^^^^^^^^^^^ reference local 45
//                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
                      )
                  }
                  nameDiffers.add(index)
//                ^^^^^^^^^^^ reference local 40
//                            ^^^ reference semanticdb maven jdk 11 java/util/HashSet#add().
//                                ^^^^^ reference local 44
                  nameDiffers.add(mappedIndex)
//                ^^^^^^^^^^^ reference local 40
//                            ^^^ reference semanticdb maven jdk 11 java/util/HashSet#add().
//                                ^^^^^^^^^^^ reference local 45
              }
              unMappedIndices
//            ^^^^^^^^^^^^^^^ reference local 39
                  .getOrPut(table.nameInDatabaseCase()) { hashSetOf() }
//                 ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getOrPut(+1).
//                          ^^^^^ reference semanticdb maven . . (table)
//                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nameInDatabaseCase().
//                                                        ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/hashSetOf().
                  .addAll(existingTableIndices.subtract(mappedIndices))
//                 ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableSet#addAll().
//                        ^^^^^^^^^^^^^^^^^^^^ reference local 41
//                                             ^^^^^^^^ reference semanticdb maven . . kotlin/collections/subtract(+9).
//                                                      ^^^^^^^^^^^^^ reference local 42
              missingIndices.addAll(mappedIndices.subtract(existingTableIndices))
//            ^^^^^^^^^^^^^^ reference local 38
//                           ^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#addAll().
//                                  ^^^^^^^^^^^^^ reference local 42
//                                                ^^^^^^^^ reference semanticdb maven . . kotlin/collections/subtract(+9).
//                                                         ^^^^^^^^^^^^^^^^^^^^ reference local 41
          }
          val toCreate = missingIndices.subtract(nameDiffers)
//            ^^^^^^^^ definition local 46
//                     display_name toCreate
//                     documentation ```kotlin\nlocal val toCreate: Set<Index>\n```
//                       ^^^^^^^^^^^^^^ reference local 38
//                                      ^^^^^^^^ reference semanticdb maven . . kotlin/collections/subtract(+9).
//                                               ^^^^^^^^^^^ reference local 40
          toCreate.log("Indices missed from database (will be created):", withLogs)
//        ^^^^^^^^ reference local 46
//                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().
//                                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withLogs)
          val toDrop = mutableSetOf<Index>()
//            ^^^^^^ definition local 47
//                   display_name toDrop
//                   documentation ```kotlin\nlocal val toDrop: MutableSet<Index>\n```
//                     ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableSetOf().
          unMappedIndices.forEach { (name, indices) ->
//        ^^^^^^^^^^^^^^^ reference local 39
//                        ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                                  ^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                  display_name <destruct>
//                                                  documentation ```kotlin\n<destruct>: Map.Entry<Column<*>, ColumnMetadata>\n```
//                                   ^^^^ definition local 48
//                                        display_name name
//                                        documentation ```kotlin\nlocal val name: String\n```
//                                   ^^^^ reference semanticdb maven . . (`<destruct>`)
//                                   ^^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                         ^^^^^^^ definition local 49
//                                                 display_name indices
//                                                 documentation ```kotlin\nlocal val indices: MutableSet<Index>\n```
//                                         ^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
              indices.subtract(nameDiffers).also {
//            ^^^^^^^ reference local 49
//                    ^^^^^^^^ reference semanticdb maven . . kotlin/collections/subtract(+9).
//                             ^^^^^^^^^^^ reference local 40
//                                          ^^^^ reference semanticdb maven . . kotlin/also().
//                                               ^ definition semanticdb maven . . (it) 6:13
//                                                 display_name it
//                                                 documentation ```kotlin\nit: Table\n```
                  if (withDropIndices) toDrop.addAll(it)
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withDropIndices)
//                                     ^^^^^^ reference local 47
//                                            ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableSet#addAll().
//                                                   ^^ reference semanticdb maven . . (it)
                  it.log(
//                ^^ reference semanticdb maven . . (it)
//                   ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().
                      "Indices exist in database and not mapped in code on class '$name':",
//                                                                                 ^^^^ reference local 48
                      withLogs
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withLogs)
                  )
              }
          }
          return Pair(toCreate.toList(), toDrop.toList())
//               ^^^^ reference semanticdb maven . . kotlin/Pair#`<init>`().
//                    ^^^^^^^^ reference local 46
//                             ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+10).
//                                       ^^^^^^ reference local 47
//                                              ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+10).
      }
  
      /** If [withLogs] is `true`, this logs every item in this collection, prefixed by [mainMessage]. */
      @InternalApi
      protected fun <T> Collection<T>.log(mainMessage: String, withLogs: Boolean) {
//                   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().[T]
//                     display_name FirTypeParameterSymbol T
//                     documentation ```kotlin\nT\n```
//                                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().
//                                        display_name log
//                                        documentation ```kotlin\n@InternalApi() protected final fun <T> Collection<T>.log(mainMessage: String, withLogs: Boolean): Unit\n```\n\n----\n\n If [withLogs] is `true`, this logs every item in this collection, prefixed by [mainMessage].
//                                        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().(mainMessage)
//                                                    display_name mainMessage
//                                                    documentation ```kotlin\nmainMessage: String\n```
//                                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                             ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().(withLogs)
//                                                                      display_name withLogs
//                                                                      documentation ```kotlin\nwithLogs: Boolean\n```
//                                                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          if (withLogs && isNotEmpty()) {
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().(withLogs)
//                        ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
              exposedLogger.warn(joinToString(prefix = "$mainMessage\n\t\t", separator = "\n\t\t"))
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                               ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().(mainMessage)
          }
      }
  
      @OptIn(InternalApi::class)
      private fun Map<Column<*>, ColumnMetadata>.mapColumnDiffs(): Map<Column<*>, ColumnDiff> {
//                                               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapColumnDiffs().
//                                                              display_name mapColumnDiffs
//                                                              documentation ```kotlin\n@OptIn(...) private final fun Map<Column<*>, ColumnMetadata>.mapColumnDiffs(): Map<Column<*>, ColumnDiff>\n```
//                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
          val dialect = currentDialect
//            ^^^^^^^ definition local 50
//                    display_name dialect
//                    documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
          return mapValues { (col, existingCol) ->
//               ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mapValues().
//                           ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                              display_name <destruct>
//                                              documentation ```kotlin\n<destruct>: Map.Entry<Column<*>, ColumnMetadata>\n```
//                            ^^^ definition local 51
//                                display_name col
//                                documentation ```kotlin\nlocal val col: Column<*>\n```
//                            ^^^ reference semanticdb maven . . (`<destruct>`)
//                            ^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                 ^^^^^^^^^^^ definition local 52
//                                             display_name existingCol
//                                             documentation ```kotlin\nlocal val existingCol: ColumnMetadata\n```
//                                 ^^^^^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                 ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
              val columnType = col.columnType
//                ^^^^^^^^^^ definition local 53
//                           display_name columnType
//                           documentation ```kotlin\nlocal val columnType: IColumnType<out Any>\n```
//                             ^^^ reference local 51
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
              val columnDbDefaultIsAllowed = col.dbDefaultValue?.let { dialect.isAllowedAsColumnDefault(it) }
//                ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 54
//                                         display_name columnDbDefaultIsAllowed
//                                         documentation ```kotlin\nlocal val columnDbDefaultIsAllowed: Boolean?\n```
//                                           ^^^ reference local 51
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                               ^^^ reference semanticdb maven . . kotlin/let().
//                                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                            display_name it
//                                                                                                            documentation ```kotlin\nit: Table\n```
//                                                                     ^^^^^^^ reference local 50
//                                                                             ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#isAllowedAsColumnDefault().
//                                                                                                      ^^ reference semanticdb maven . . (it)
              val colNullable = if (columnDbDefaultIsAllowed == false) {
//                ^^^^^^^^^^^ definition local 55
//                            display_name colNullable
//                            documentation ```kotlin\nlocal val colNullable: Boolean\n```
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference local 54
                  true // Treat a disallowed default value as null because that is what Exposed does with it
              } else {
                  columnType.nullable
//                ^^^^^^^^^^ reference local 53
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
              }
              val incorrectType = if (currentDialect.supportsColumnTypeChange) isIncorrectType(existingCol, col) else false
//                ^^^^^^^^^^^^^ definition local 56
//                              display_name incorrectType
//                              documentation ```kotlin\nlocal val incorrectType: Boolean\n```
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsColumnTypeChange().
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsColumnTypeChange.
//                                                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectType().
//                                                                                             ^^^^^^^^^^^ reference local 52
//                                                                                                          ^^^ reference local 51
              val incorrectNullability = existingCol.nullable != colNullable
//                ^^^^^^^^^^^^^^^^^^^^ definition local 57
//                                     display_name incorrectNullability
//                                     documentation ```kotlin\nlocal val incorrectNullability: Boolean\n```
//                                       ^^^^^^^^^^^ reference local 52
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getNullable().
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#nullable.
//                                                               ^^^^^^^^^^^ reference local 55
              val incorrectAutoInc = isIncorrectAutoInc(existingCol, col)
//                ^^^^^^^^^^^^^^^^ definition local 58
//                                 display_name incorrectAutoInc
//                                 documentation ```kotlin\nlocal val incorrectAutoInc: Boolean\n```
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().
//                                                      ^^^^^^^^^^^ reference local 52
//                                                                   ^^^ reference local 51
              // 'isDatabaseGenerated' property means that the column has generation of the value on the database side,
              // and it could be default value, trigger or something else,
              // but we don't specify the default value on the table object.
              // So it could be better to avoid checking for changes in defaults for such columns, because in the most part
              // of cases we would try to remove existing (in database, but not in table object) default value
              val incorrectDefaults = if (col.isDatabaseGenerated) false else isIncorrectDefault(dialect, existingCol, col, columnDbDefaultIsAllowed)
//                ^^^^^^^^^^^^^^^^^ definition local 59
//                                  display_name incorrectDefaults
//                                  documentation ```kotlin\nlocal val incorrectDefaults: Boolean\n```
//                                        ^^^ reference local 51
//                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
//                                                                            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().
//                                                                                               ^^^^^^^ reference local 50
//                                                                                                        ^^^^^^^^^^^ reference local 52
//                                                                                                                     ^^^ reference local 51
//                                                                                                                          ^^^^^^^^^^^^^^^^^^^^^^^^ reference local 54
              val incorrectCaseSensitiveName = existingCol.name.inProperCase() != col.nameUnquoted().inProperCase()
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 60
//                                           display_name incorrectCaseSensitiveName
//                                           documentation ```kotlin\nlocal val incorrectCaseSensitiveName: Boolean\n```
//                                             ^^^^^^^^^^^ reference local 52
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getName().
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#name.
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
//                                                                                ^^^ reference local 51
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#nameUnquoted().
//                                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
              val incorrectSizeOrScale = if (incorrectType) false else isIncorrectSizeOrScale(existingCol, columnType)
//                ^^^^^^^^^^^^^^^^^^^^ definition local 61
//                                     display_name incorrectSizeOrScale
//                                     documentation ```kotlin\nlocal val incorrectSizeOrScale: Boolean\n```
//                                           ^^^^^^^^^^^^^ reference local 56
//                                                                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().
//                                                                                            ^^^^^^^^^^^ reference local 52
//                                                                                                         ^^^^^^^^^^ reference local 53
              ColumnDiff(
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().
                  incorrectNullability,
//                ^^^^^^^^^^^^^^^^^^^^ reference local 57
                  incorrectType,
//                ^^^^^^^^^^^^^ reference local 56
                  incorrectAutoInc,
//                ^^^^^^^^^^^^^^^^ reference local 58
                  incorrectDefaults,
//                ^^^^^^^^^^^^^^^^^ reference local 59
                  incorrectCaseSensitiveName,
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 60
                  incorrectSizeOrScale
//                ^^^^^^^^^^^^^^^^^^^^ reference local 61
              )
          }.filterValues { it.hasDifferences() }
//          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterValues().
//                       ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                               display_name it
//                                               documentation ```kotlin\nit: Table\n```
//                         ^^ reference semanticdb maven . . (it)
//                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#hasDifferences().
      }
  
      private fun isIncorrectType(columnMetadata: ColumnMetadata, column: Column<*>): Boolean {
//                ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectType().
//                                display_name isIncorrectType
//                                documentation ```kotlin\nprivate final fun isIncorrectType(columnMetadata: ColumnMetadata, column: Column<*>): Boolean\n```
//                                ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectType().(columnMetadata)
//                                               display_name columnMetadata
//                                               documentation ```kotlin\ncolumnMetadata: ColumnMetadata\n```
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#
//                                                                ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectType().(column)
//                                                                       display_name column
//                                                                       documentation ```kotlin\ncolumn: Column<*>\n```
//                                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          return !currentDialect.areEquivalentColumnTypes(columnMetadata.sqlType, columnMetadata.jdbcType, column.columnType.sqlType())
//               ^ reference semanticdb maven . . kotlin/Boolean#not().
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#areEquivalentColumnTypes().
//                                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectType().(columnMetadata)
//                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getSqlType().
//                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#sqlType.
//                                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectType().(columnMetadata)
//                                                                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getJdbcType().
//                                                                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#jdbcType.
//                                                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectType().(column)
//                                                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
      }
  
      private fun isIncorrectAutoInc(existingColumn: ColumnMetadata, column: Column<*>): Boolean {
//                ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().
//                                   display_name isIncorrectAutoInc
//                                   documentation ```kotlin\nprivate final fun isIncorrectAutoInc(existingColumn: ColumnMetadata, column: Column<*>): Boolean\n```
//                                   ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(existingColumn)
//                                                  display_name existingColumn
//                                                  documentation ```kotlin\nexistingColumn: ColumnMetadata\n```
//                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#
//                                                                   ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(column)
//                                                                          display_name column
//                                                                          documentation ```kotlin\ncolumn: Column<*>\n```
//                                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          val isAutoIncColumn = column.columnType.isAutoInc
//            ^^^^^^^^^^^^^^^ definition local 62
//                            display_name isAutoIncColumn
//                            documentation ```kotlin\nlocal val isAutoIncColumn: Boolean\n```
//                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(column)
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
          return when {
              !existingColumn.autoIncrement && isAutoIncColumn && column.autoIncColumnType?.sequence == null -> true
//            ^ reference semanticdb maven . . kotlin/Boolean#not().
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(existingColumn)
//                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#autoIncrement.
//                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getAutoIncrement().
//                                             ^^^^^^^^^^^^^^^ reference local 62
//                                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(column)
//                                                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//                                                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.
              existingColumn.autoIncrement && isAutoIncColumn && column.autoIncColumnType?.sequence != null -> true
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(existingColumn)
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#autoIncrement.
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getAutoIncrement().
//                                            ^^^^^^^^^^^^^^^ reference local 62
//                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(column)
//                                                                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                                                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//                                                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.
              existingColumn.autoIncrement && !isAutoIncColumn -> true
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(existingColumn)
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#autoIncrement.
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getAutoIncrement().
//                                            ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                             ^^^^^^^^^^^^^^^ reference local 62
              else -> false
          }
      }
  
      private fun isIncorrectDefault(
//                ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().
//                                   display_name isIncorrectDefault
//                                   documentation ```kotlin\nprivate final fun isIncorrectDefault(dialect: DatabaseDialect, existingColumn: ColumnMetadata, column: Column<*>, columnDbDefaultIsAllowed: Boolean?): Boolean\n```
          dialect: DatabaseDialect,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(dialect)
//                display_name dialect
//                documentation ```kotlin\ndialect: DatabaseDialect\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
          existingColumn: ColumnMetadata,
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(existingColumn)
//                       display_name existingColumn
//                       documentation ```kotlin\nexistingColumn: ColumnMetadata\n```
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#
          column: Column<*>,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(column)
//               display_name column
//               documentation ```kotlin\ncolumn: Column<*>\n```
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          columnDbDefaultIsAllowed: Boolean?
//        ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(columnDbDefaultIsAllowed)
//                                 display_name columnDbDefaultIsAllowed
//                                 documentation ```kotlin\ncolumnDbDefaultIsAllowed: Boolean?\n```
//                                  ^^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      ): Boolean {
//       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          val isExistingColumnDefaultNull = existingColumn.defaultDbValue == null
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 63
//                                        display_name isExistingColumnDefaultNull
//                                        documentation ```kotlin\nlocal val isExistingColumnDefaultNull: Boolean\n```
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(existingColumn)
//                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#defaultDbValue.
//                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getDefaultDbValue().
          val isDefinedColumnDefaultNull = columnDbDefaultIsAllowed != true ||
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 64
//                                       display_name isDefinedColumnDefaultNull
//                                       documentation ```kotlin\nlocal val isDefinedColumnDefaultNull: Boolean\n```
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(columnDbDefaultIsAllowed)
              (column.dbDefaultValue is LiteralOp<*> && (column.dbDefaultValue as? LiteralOp<*>)?.value == null)
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(column)
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(column)
//                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getValue().
//                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#value.
          return when {
              // Both values are null-like, no DDL update is needed
              isExistingColumnDefaultNull && isDefinedColumnDefaultNull -> false
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 63
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 64
              // Only one of the values is null-like, DDL update is needed
              isExistingColumnDefaultNull != isDefinedColumnDefaultNull -> true
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 63
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 64
              else -> {
                  val columnDefaultValue = column.dbDefaultValue?.let {
//                    ^^^^^^^^^^^^^^^^^^ definition local 65
//                                       display_name columnDefaultValue
//                                       documentation ```kotlin\nlocal val columnDefaultValue: String?\n```
//                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(column)
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                                ^^^ reference semanticdb maven . . kotlin/let().
//                                                                    ^ definition semanticdb maven . . (it) 2:17
//                                                                      display_name it
//                                                                      documentation ```kotlin\nit: Table\n```
                      dialect.dbDefaultToString(column, it)
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(dialect)
//                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().
//                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(column)
//                                                      ^^ reference semanticdb maven . . (it)
                  }
                  existingColumn.defaultDbValue != columnDefaultValue
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(existingColumn)
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#defaultDbValue.
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getDefaultDbValue().
//                                                 ^^^^^^^^^^^^^^^^^^ reference local 65
              }
          }
      }
  
      @Suppress("NestedBlockDepth", "ComplexMethod", "LongMethod")
      private fun DatabaseDialect.dbDefaultToString(column: Column<*>, exp: Expression<*>): String {
//                                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().
//                                                  display_name dbDefaultToString
//                                                  documentation ```kotlin\n@Suppress(...) private final fun DatabaseDialect.dbDefaultToString(column: Column<*>, exp: Expression<*>): String\n```
//                                                  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                                         display_name column
//                                                         documentation ```kotlin\ncolumn: Column<*>\n```
//                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                     ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
//                                                                         display_name exp
//                                                                         documentation ```kotlin\nexp: Expression<*>\n```
//                                                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
          return when (exp) {
//                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
              is LiteralOp<*> -> {
                  when (val value = exp.value) {
//                          ^^^^^ definition local 66
//                                display_name value
//                                documentation ```kotlin\nlocal val value: Any?\n```
//                                  ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getValue().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#value.
                      is Boolean -> when (this) {
                          is MysqlDialect -> if (value) "1" else "0"
//                                               ^^^^^ reference local 66
                          is PostgreSQLDialect -> value.toString()
//                                                ^^^^^ reference local 66
//                                                      ^^^^^^^^ reference semanticdb maven . . kotlin/Boolean#toString().
                          else -> dataTypeProvider.booleanToStatementString(value)
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanToStatementString().
//                                                                          ^^^^^ reference local 66
                      }
                      is String -> when {
                          this is PostgreSQLDialect -> when (column.columnType) {
//                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
                              is VarCharColumnType -> "'$value'::character varying"
//                                                       ^^^^^ reference local 66
                              is TextColumnType -> "'$value'::text"
//                                                    ^^^^^ reference local 66
                              else -> dataTypeProvider.processForDefaultValue(exp)
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                          }
                          this is OracleDialect || h2Mode == H2Dialect.H2CompatibilityMode.Oracle -> when {
//                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
                              column.columnType is VarCharColumnType && value == "" -> "NULL"
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                      ^^^^^ reference local 66
                              column.columnType is TextColumnType && value == "" -> "NULL"
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                   ^^^^^ reference local 66
                              else -> value
//                                    ^^^^^ reference local 66
                          }
                          else -> value
//                                ^^^^^ reference local 66
                      }
                      is Enum<*> -> when (exp.columnType) {
//                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
//                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
                          is EnumerationNameColumnType<*> -> when (this) {
                              is PostgreSQLDialect -> "'${value.name}'::character varying"
//                                                        ^^^^^ reference local 66
//                                                              ^^^^ reference semanticdb maven . . kotlin/Enum#getName().
//                                                              ^^^^ reference semanticdb maven . . kotlin/Enum#name.
                              else -> value.name
//                                    ^^^^^ reference local 66
//                                          ^^^^ reference semanticdb maven . . kotlin/Enum#getName().
//                                          ^^^^ reference semanticdb maven . . kotlin/Enum#name.
                          }
                          else -> dataTypeProvider.processForDefaultValue(exp)
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                      }
                      is BigDecimal -> when (this) {
                          is MysqlDialect -> value.setScale((exp.columnType as DecimalColumnType).scale).toString()
//                                           ^^^^^ reference local 66
//                                                 ^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#setScale().
//                                                           ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
//                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getScale().
//                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#scale.
//                                                                                                       ^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#toString().
                          else -> dataTypeProvider.processForDefaultValue(exp)
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                      }
                      is Byte -> when {
                          this is PostgreSQLDialect && value < 0 -> "'${dataTypeProvider.processForDefaultValue(exp)}'::integer"
//                                                     ^^^^^ reference local 66
//                                                           ^ reference semanticdb maven . . kotlin/Byte#compareTo(+2).
//                                                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                                                                       ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                                              ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                          else -> dataTypeProvider.processForDefaultValue(exp)
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                      }
                      is Short -> when {
                          this is PostgreSQLDialect && value < 0 -> "'${dataTypeProvider.processForDefaultValue(exp)}'::integer"
//                                                     ^^^^^ reference local 66
//                                                           ^ reference semanticdb maven . . kotlin/Short#compareTo(+2).
//                                                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                                                                       ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                                              ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                          else -> dataTypeProvider.processForDefaultValue(exp)
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                      }
                      is Int -> when {
                          this is PostgreSQLDialect && value < 0 -> "'${dataTypeProvider.processForDefaultValue(exp)}'::integer"
//                                                     ^^^^^ reference local 66
//                                                           ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                                                                       ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                                              ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                          else -> dataTypeProvider.processForDefaultValue(exp)
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                      }
                      is Long -> when {
                          this is SQLServerDialect && (value < 0 || value > Int.MAX_VALUE.toLong()) ->
//                                                     ^^^^^ reference local 66
//                                                           ^ reference semanticdb maven . . kotlin/Long#compareTo(+2).
//                                                                  ^^^^^ reference local 66
//                                                                        ^ reference semanticdb maven . . kotlin/Long#compareTo(+3).
//                                                                              ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                                              ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                                                        ^^^^^^ reference semanticdb maven . . kotlin/Int#toLong().
                              "${dataTypeProvider.processForDefaultValue(exp)}."
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                       ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                          this is PostgreSQLDialect && (value < 0 || value > Int.MAX_VALUE.toLong()) ->
//                                                      ^^^^^ reference local 66
//                                                            ^ reference semanticdb maven . . kotlin/Long#compareTo(+2).
//                                                                   ^^^^^ reference local 66
//                                                                         ^ reference semanticdb maven . . kotlin/Long#compareTo(+3).
//                                                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                                                         ^^^^^^ reference semanticdb maven . . kotlin/Int#toLong().
                              "'${dataTypeProvider.processForDefaultValue(exp)}'::bigint"
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                          else -> dataTypeProvider.processForDefaultValue(exp)
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                      }
                      is UInt -> when {
                          this is SQLServerDialect && value > Int.MAX_VALUE.toUInt() -> "${dataTypeProvider.processForDefaultValue(exp)}."
//                                                    ^^^^^ reference local 66
//                                                          ^ reference semanticdb maven . . kotlin/UInt#compareTo(+2).
//                                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                                          ^^^^^^ reference semanticdb maven . . kotlin/toUInt(+2).
//                                                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                                                                                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                                                                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                          this is PostgreSQLDialect && value > Int.MAX_VALUE.toUInt() -> "'${dataTypeProvider.processForDefaultValue(exp)}'::bigint"
//                                                     ^^^^^ reference local 66
//                                                           ^ reference semanticdb maven . . kotlin/UInt#compareTo(+2).
//                                                                 ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                                 ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                                           ^^^^^^ reference semanticdb maven . . kotlin/toUInt(+2).
//                                                                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                                                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                                                                                            ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                                                                   ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                          else -> dataTypeProvider.processForDefaultValue(exp)
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                      }
                      is ULong -> when {
                          this is SQLServerDialect && value > Int.MAX_VALUE.toULong() -> "${dataTypeProvider.processForDefaultValue(exp)}."
//                                                    ^^^^^ reference local 66
//                                                          ^ reference semanticdb maven . . kotlin/ULong#compareTo(+3).
//                                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                                          ^^^^^^^ reference semanticdb maven . . kotlin/toULong(+2).
//                                                                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                                                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                                                                                           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                                                                  ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                          this is PostgreSQLDialect && value > Int.MAX_VALUE.toULong() -> "'${dataTypeProvider.processForDefaultValue(exp)}'::bigint"
//                                                     ^^^^^ reference local 66
//                                                           ^ reference semanticdb maven . . kotlin/ULong#compareTo(+3).
//                                                                 ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                                 ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/toULong(+2).
//                                                                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                                                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                                                                                             ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                                                                    ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                          else -> dataTypeProvider.processForDefaultValue(exp)
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                      }
                      else -> {
                          when {
                              column.columnType is JsonColumnMarker -> {
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
                                  val processed = dataTypeProvider.processForDefaultValue(exp)
//                                    ^^^^^^^^^ definition local 67
//                                              display_name processed
//                                              documentation ```kotlin\nlocal val processed: String\n```
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                                  when (this) {
                                      is PostgreSQLDialect -> {
                                          if (column.columnType.usesBinaryFormat) {
//                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#getUsesBinaryFormat().
//                                                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#usesBinaryFormat.
                                              processed.replace(Regex("(\"|})(:|,)(\\[|\\{|\")"), "$1$2 $3")
//                                            ^^^^^^^^^ reference local 67
//                                                      ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+2).
//                                                              ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
                                          } else {
                                              processed
//                                            ^^^^^^^^^ reference local 67
                                          }
                                      }
                                      is MariaDBDialect -> processed.trim('\'')
//                                                         ^^^^^^^^^ reference local 67
//                                                                   ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
                                      is MysqlDialect -> "_utf8mb4\\'${processed.trim('(', ')', '\'')}\\'"
//                                                                     ^^^^^^^^^ reference local 67
//                                                                               ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
                                      else -> when {
                                          processed.startsWith('\'') && processed.endsWith('\'') -> processed.trim('\'')
//                                        ^^^^^^^^^ reference local 67
//                                                  ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith(+2).
//                                                                      ^^^^^^^^^ reference local 67
//                                                                                ^^^^^^^^ reference semanticdb maven . . kotlin/text/endsWith(+1).
//                                                                                                  ^^^^^^^^^ reference local 67
//                                                                                                            ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
                                          else -> processed
//                                                ^^^^^^^^^ reference local 67
                                      }
                                  }
                              }
                              column.columnType is ArrayColumnType<*, *> && this is PostgreSQLDialect -> {
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
                                  (value as List<*>)
//                                 ^^^^^ reference local 66
                                      .takeIf { it.isNotEmpty() }
//                                     ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                display_name it
//                                                                documentation ```kotlin\nit: Table\n```
//                                              ^^ reference semanticdb maven . . (it)
//                                                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
                                      ?.run {
//                                      ^^^ reference semanticdb maven . . kotlin/run(+1).
                                          val delegateColumnType = column.columnType.delegate as IColumnType<Any>
//                                            ^^^^^^^^^^^^^^^^^^ definition local 68
//                                                               display_name delegateColumnType
//                                                               documentation ```kotlin\nlocal val delegateColumnType: IColumnType<Any>\n```
//                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegate.
//                                                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegate().
                                          val delegateColumn = (column as Column<Any?>).withColumnType(delegateColumnType)
//                                            ^^^^^^^^^^^^^^ definition local 69
//                                                           display_name delegateColumn
//                                                           documentation ```kotlin\nlocal val delegateColumn: Column<Any?>\n```
//                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#withColumnType().
//                                                                                                     ^^^^^^^^^^^^^^^^^^ reference local 68
                                          val processed = map {
//                                            ^^^^^^^^^ definition local 70
//                                                      display_name processed
//                                                      documentation ```kotlin\nlocal val processed: List<String>\n```
//                                                        ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                            ^ definition semanticdb maven . . (it) 6:41
//                                                              display_name it
//                                                              documentation ```kotlin\nit: Table\n```
                                              if (delegateColumn.columnType is StringColumnType) {
//                                                ^^^^^^^^^^^^^^ reference local 69
//                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
                                                  "'$it'::text"
//                                                   ^^ reference semanticdb maven . . (it)
                                              } else {
                                                  dbDefaultToString(delegateColumn, delegateColumn.asLiteral(it))
//                                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().
//                                                                  ^^^^^^^^^^^^^^ reference local 69
//                                                                                  ^^^^^^^^^^^^^^ reference local 69
//                                                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().
//                                                                                                           ^^ reference semanticdb maven . . (it)
                                              }
                                          }
                                          "ARRAY$processed"
//                                               ^^^^^^^^^ reference local 70
                                      } ?: dataTypeProvider.processForDefaultValue(exp)
//                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                              }
                              column.columnType is IDateColumnType -> {
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
                                  val processed = dataTypeProvider.processForDefaultValue(exp)
//                                    ^^^^^^^^^ definition local 71
//                                              display_name processed
//                                              documentation ```kotlin\nlocal val processed: String\n```
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                                  if (processed.startsWith('\'') && processed.endsWith('\'')) {
//                                    ^^^^^^^^^ reference local 71
//                                              ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith(+2).
//                                                                  ^^^^^^^^^ reference local 71
//                                                                            ^^^^^^^^ reference semanticdb maven . . kotlin/text/endsWith(+1).
                                      processed.trim('\'')
//                                    ^^^^^^^^^ reference local 71
//                                              ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
                                  } else {
                                      processed
//                                    ^^^^^^^^^ reference local 71
                                  }
                              }
                              else -> dataTypeProvider.processForDefaultValue(exp)
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                          }
                      }
                  }
              }
              is Function<*> -> {
                  var processed = dataTypeProvider.processForDefaultValue(exp)
//                    ^^^^^^^^^ definition local 72
//                              display_name processed
//                              documentation ```kotlin\nlocal var processed: String\n```
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                  if (exp.columnType is IDateColumnType) {
//                    ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#columnType.
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#getColumnType().
                      if (processed.startsWith("CURRENT_TIMESTAMP") || processed == "GETDATE()") {
//                        ^^^^^^^^^ reference local 72
//                                  ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                                     ^^^^^^^^^ reference local 72
                          when (this) {
                              is SQLServerDialect -> processed = "getdate"
//                                                   ^^^^^^^^^ reference local 72
                              is MariaDBDialect -> processed = processed.lowercase()
//                                                 ^^^^^^^^^ reference local 72
//                                                             ^^^^^^^^^ reference local 72
//                                                                       ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
                          }
                      }
                      if (processed.trim('(').startsWith("CURRENT_DATE")) {
//                        ^^^^^^^^^ reference local 72
//                                  ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
//                                            ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
                          when (this) {
                              is MysqlDialect -> processed = "curdate()"
//                                               ^^^^^^^^^ reference local 72
                          }
                      }
                  }
                  processed
//                ^^^^^^^^^ reference local 72
              }
              else -> dataTypeProvider.processForDefaultValue(exp)
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
          }
      }
  
      private fun isIncorrectSizeOrScale(columnMeta: ColumnMetadata, columnType: IColumnType<*>): Boolean {
//                ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().
//                                       display_name isIncorrectSizeOrScale
//                                       documentation ```kotlin\nprivate final fun isIncorrectSizeOrScale(columnMeta: ColumnMetadata, columnType: IColumnType<*>): Boolean\n```
//                                       ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnMeta)
//                                                  display_name columnMeta
//                                                  documentation ```kotlin\ncolumnMeta: ColumnMetadata\n```
//                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#
//                                                                   ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnType)
//                                                                              display_name columnType
//                                                                              documentation ```kotlin\ncolumnType: IColumnType<*>\n```
//                                                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          // ColumnMetadata.scale can only be non-null if ColumnMetadata.size is non-null
          if (columnMeta.size == null) return false
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnMeta)
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getSize().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#size.
          val dialect = currentDialect
//            ^^^^^^^ definition local 73
//                    display_name dialect
//                    documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
          return when (columnType) {
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnType)
              is DecimalColumnType -> columnType.precision != columnMeta.size || columnType.scale != columnMeta.scale
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnType)
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getPrecision().
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#precision.
//                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnMeta)
//                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getSize().
//                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#size.
//                                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnType)
//                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getScale().
//                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#scale.
//                                                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnMeta)
//                                                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getScale().
//                                                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#scale.
              is CharColumnType -> columnType.colLength != columnMeta.size
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnType)
//                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#colLength.
//                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#getColLength().
//                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnMeta)
//                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getSize().
//                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#size.
              is VarCharColumnType -> columnType.colLength != columnMeta.size
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnType)
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#colLength.
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#getColLength().
//                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnMeta)
//                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getSize().
//                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#size.
              is BinaryColumnType -> if (dialect is PostgreSQLDialect || dialect.h2Mode == H2Dialect.H2CompatibilityMode.PostgreSQL) {
//                                       ^^^^^^^ reference local 73
//                                                                       ^^^^^^^ reference local 73
//                                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#PostgreSQL.
                  false
              } else {
                  columnType.length != columnMeta.size
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnType)
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#getLength().
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#length.
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnMeta)
//                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getSize().
//                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#size.
              }
              else -> false
          }
      }
  
      private fun Table.primaryKeyDdl(missingColumns: List<Column<*>>, existingKey: PrimaryKeyMetadata?): String? {
//                      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeyDdl().
//                                    display_name primaryKeyDdl
//                                    documentation ```kotlin\nprivate final fun Table.primaryKeyDdl(missingColumns: List<Column<*>>, existingKey: PrimaryKeyMetadata?): String?\n```
//                                    ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeyDdl().(missingColumns)
//                                                   display_name missingColumns
//                                                   documentation ```kotlin\nmissingColumns: List<Column<*>>\n```
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                     ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeyDdl().(existingKey)
//                                                                                 display_name existingKey
//                                                                                 documentation ```kotlin\nexistingKey: PrimaryKeyMetadata?\n```
//                                                                                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#
//                                                                                                        ^^^^^^^ reference semanticdb maven . . kotlin/String#
          val missingPK = primaryKey?.takeIf { pk ->
//            ^^^^^^^^^ definition local 74
//                      display_name missingPK
//                      documentation ```kotlin\nlocal val missingPK: Table.PrimaryKey?\n```
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                                    ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                             ^^ definition semanticdb maven . . (pk)
//                                                display_name pk
//                                                documentation ```kotlin\npk: Table.PrimaryKey\n```
              pk.columns.none { it in missingColumns }
//            ^^ reference semanticdb maven . . (pk)
//               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                       ^^^^ reference semanticdb maven . . kotlin/collections/none(+9).
//                            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                     display_name it
//                                                     documentation ```kotlin\nit: Table\n```
//                              ^^ reference semanticdb maven . . (it)
//                                 ^^ reference semanticdb maven . . kotlin/collections/List#contains().
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeyDdl().(missingColumns)
          }
          if (missingPK == null || existingKey != null) return null
//            ^^^^^^^^^ reference local 74
//                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeyDdl().(existingKey)
          val missingPKName = missingPK.name.takeIf { isCustomPKNameDefined() }
//            ^^^^^^^^^^^^^ definition local 75
//                          display_name missingPKName
//                          documentation ```kotlin\nlocal val missingPKName: String?\n```
//                            ^^^^^^^^^ reference local 74
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getName().
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#name.
//                                           ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                              display_name it
//                                                                              documentation ```kotlin\nit: Table\n```
//                                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#isCustomPKNameDefined().
          return currentDialect.addPrimaryKey(this, missingPKName, pkColumns = missingPK.columns)
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#addPrimaryKey().
//                                                  ^^^^^^^^^^^^^ reference local 75
//                                                                             ^^^^^^^^^ reference local 74
//                                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
      }
  
      /** Runs the provided [block] and returns the result. If [withLogs] is `true`, logs the time taken in milliseconds. */
      @InternalApi
      protected inline fun <R> logTimeSpent(message: String, withLogs: Boolean, block: () -> R): R {
//                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().[R]
//                            display_name FirTypeParameterSymbol R
//                            documentation ```kotlin\nR\n```
//                             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().
//                                          display_name logTimeSpent
//                                          documentation ```kotlin\n@InternalApi() protected final inline fun <R> logTimeSpent(message: String, withLogs: Boolean, block: () -> R): R\n```\n\n----\n\n Runs the provided [block] and returns the result. If [withLogs] is `true`, logs the time taken in milliseconds.
//                                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(message)
//                                                  display_name message
//                                                  documentation ```kotlin\nmessage: String\n```
//                                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                           ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(withLogs)
//                                                                    display_name withLogs
//                                                                    documentation ```kotlin\nwithLogs: Boolean\n```
//                                                                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(block)
//                                                                                    display_name block
//                                                                                    documentation ```kotlin\nblock: () -> R\n```
//                                                                                     ^^^^^^^ reference semanticdb maven . . kotlin/Function0#
          return if (withLogs) {
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(withLogs)
              val start = System.currentTimeMillis()
//                ^^^^^ definition local 76
//                      display_name start
//                      documentation ```kotlin\nlocal val start: Long\n```
//                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/System#currentTimeMillis().
              val answer = block()
//                ^^^^^^ definition local 77
//                       display_name answer
//                       documentation ```kotlin\nlocal val answer: R\n```
//                         ^^^^^ reference semanticdb maven . . kotlin/Function0#invoke().
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(block)
              exposedLogger.info(message + " took " + (System.currentTimeMillis() - start) + "ms")
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#info().
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(message)
//                                       ^ reference semanticdb maven . . kotlin/String#plus().
//                                                  ^ reference semanticdb maven . . kotlin/String#plus().
//                                                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/System#currentTimeMillis().
//                                                                                ^ reference semanticdb maven . . kotlin/Long#minus(+3).
//                                                                                  ^^^^^ reference local 76
//                                                                                         ^ reference semanticdb maven . . kotlin/String#plus().
              answer
//            ^^^^^^ reference local 77
          } else {
              block()
//            ^^^^^ reference semanticdb maven . . kotlin/Function0#invoke().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(block)
          }
      }
  
      // TODO extract tp separate file & move this top-level internal class
      private class TableDepthGraph(val tables: Iterable<Table>) {
//                  ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#
//                                  display_name TableDepthGraph
//                                  documentation ```kotlin\nprivate final class TableDepthGraph : Any\n```
//                  ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#`<init>`().
//                                  display_name TableDepthGraph
//                                  documentation ```kotlin\npublic constructor(tables: Iterable<Table>): SchemaUtilityApi.TableDepthGraph\n```
//                                      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#`<init>`().(tables)
//                                             display_name tables
//                                             documentation ```kotlin\ntables: Iterable<Table>\n```
//                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#`<init>`().(tables)
//                                      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getTables().
//                                             display_name tables
//                                             documentation ```kotlin\npublic get(): Iterable<Table>\n```
//                                      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#tables.
//                                             display_name tables
//                                             documentation ```kotlin\npublic final val tables: Iterable<Table>\n```
//                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
          val graph = fetchAllTables().let { tables ->
//            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getGraph().
//                  display_name graph
//                  documentation ```kotlin\npublic get(): Map<Table, List<Table>>\n```
//            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#graph.
//                  display_name graph
//                  documentation ```kotlin\npublic final val graph: Map<Table, List<Table>>\n```
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#fetchAllTables().
//                                     ^^^ reference semanticdb maven . . kotlin/let().
//                                           ^^^^^^ definition semanticdb maven . . (tables)
//                                                  display_name tables
//                                                  documentation ```kotlin\ntables: {kotlin/collections/HashSet<org/jetbrains/exposed/v1/core/Table>=} HashSet<Table>\n```
              if (tables.isEmpty()) {
//                ^^^^^^ reference semanticdb maven . . (tables)
//                       ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#isEmpty().
                  emptyMap()
//                ^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyMap().
              } else {
                  tables.associateWith { t ->
//                ^^^^^^ reference semanticdb maven . . (tables)
//                       ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/associateWith(+9).
//                                       ^ definition semanticdb maven . . (t)
//                                         display_name t
//                                         documentation ```kotlin\nt: Table\n```
                      t.foreignKeys.map { it.targetTable }
//                    ^ reference semanticdb maven . . (t)
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKeys.
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getForeignKeys().
//                                  ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                         display_name it
//                                                         documentation ```kotlin\nit: Table\n```
//                                        ^^ reference semanticdb maven . . (it)
//                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTable().
//                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTable.
                  }
              }
          }
  
          private fun fetchAllTables(): HashSet<Table> {
//                    ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#fetchAllTables().
//                                   display_name fetchAllTables
//                                   documentation ```kotlin\nprivate final fun fetchAllTables(): {kotlin/collections/HashSet<org/jetbrains/exposed/v1/core/Table>=} HashSet<Table>\n```
//                                      ^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#
              val result = HashSet<Table>()
//                ^^^^^^ definition local 78
//                       display_name result
//                       documentation ```kotlin\nlocal val result: {kotlin/collections/HashSet<org/jetbrains/exposed/v1/core/Table>=} HashSet<Table>\n```
//                         ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#`<init>`().
              fun parseTable(table: Table) {
//                ^^^^^^^^^^ definition local 79
//                           display_name parseTable
//                           documentation ```kotlin\nlocal final fun parseTable(table: Table): Unit\n```
//                           ^^^^^ definition local 80
//                                 display_name table
//                                 documentation ```kotlin\ntable: Table\n```
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
                  if (result.add(table)) {
//                    ^^^^^^ reference local 78
//                           ^^^ reference semanticdb maven jdk 11 java/util/HashSet#add().
//                               ^^^^^ reference local 80
                      table.foreignKeys.map { it.targetTable }.forEach(::parseTable)
//                    ^^^^^ reference local 80
//                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKeys.
//                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getForeignKeys().
//                                      ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                          ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                             display_name it
//                                                             documentation ```kotlin\nit: Table\n```
//                                            ^^ reference semanticdb maven . . (it)
//                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTable().
//                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTable.
//                                                             ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                                                       ^^^^^^^^^^ reference local 79
                  }
              }
              tables.forEach(::parseTable)
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getTables().
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#tables.
//                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                             ^^^^^^^^^^ reference local 79
              return result
//                   ^^^^^^ reference local 78
          }
  
          fun sorted(): List<Table> {
//            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#sorted().
//                   display_name sorted
//                   documentation ```kotlin\npublic final fun sorted(): List<Table>\n```
//                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
              if (!tables.iterator().hasNext()) return emptyList()
//                ^ reference semanticdb maven . . kotlin/Boolean#not().
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getTables().
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#tables.
//                        ^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#iterator().
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#hasNext().
//                                                     ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
              val visited = mutableSetOf<Table>()
//                ^^^^^^^ definition local 81
//                        display_name visited
//                        documentation ```kotlin\nlocal val visited: MutableSet<Table>\n```
//                          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableSetOf().
              val result = arrayListOf<Table>()
//                ^^^^^^ definition local 82
//                       display_name result
//                       documentation ```kotlin\nlocal val result: {kotlin/collections/ArrayList<org/jetbrains/exposed/v1/core/Table>=} ArrayList<Table>\n```
//                         ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/arrayListOf().
              fun traverse(table: Table) {
//                ^^^^^^^^ definition local 83
//                         display_name traverse
//                         documentation ```kotlin\nlocal final fun traverse(table: Table): Unit\n```
//                         ^^^^^ definition local 84
//                               display_name table
//                               documentation ```kotlin\ntable: Table\n```
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
                  if (table !in visited) {
//                    ^^^^^ reference local 84
//                          ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                          ^^^ reference semanticdb maven . . kotlin/collections/MutableSet#contains().
//                              ^^^^^^^ reference local 81
                      visited += table
//                    ^^^^^^^ reference local 81
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/plusAssign().
//                               ^^^^^ reference local 84
                      graph.getValue(table).forEach { t ->
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getGraph().
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#graph.
//                          ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getValue().
//                                   ^^^^^ reference local 84
//                                          ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                                    ^ definition semanticdb maven . . (t)
//                                                      display_name t
//                                                      documentation ```kotlin\nt: Table\n```
                          if (t !in visited) {
//                            ^ reference semanticdb maven . . (t)
//                              ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                              ^^^ reference semanticdb maven . . kotlin/collections/MutableSet#contains().
//                                  ^^^^^^^ reference local 81
                              traverse(t)
//                            ^^^^^^^^ reference local 83
//                                     ^ reference semanticdb maven . . (t)
                          }
                      }
                      result += table
//                    ^^^^^^ reference local 82
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/plusAssign().
//                              ^^^^^ reference local 84
                  }
              }
              tables.forEach(::traverse)
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getTables().
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#tables.
//                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                             ^^^^^^^^ reference local 83
              return result
//                   ^^^^^^ reference local 82
          }
  
          fun hasCycle(): Boolean {
//            ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#hasCycle().
//                     display_name hasCycle
//                     documentation ```kotlin\npublic final fun hasCycle(): Boolean\n```
//                        ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
              if (!tables.iterator().hasNext()) return false
//                ^ reference semanticdb maven . . kotlin/Boolean#not().
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getTables().
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#tables.
//                        ^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#iterator().
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#hasNext().
              val visited = mutableSetOf<Table>()
//                ^^^^^^^ definition local 85
//                        display_name visited
//                        documentation ```kotlin\nlocal val visited: MutableSet<Table>\n```
//                          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableSetOf().
              val recursion = mutableSetOf<Table>()
//                ^^^^^^^^^ definition local 86
//                          display_name recursion
//                          documentation ```kotlin\nlocal val recursion: MutableSet<Table>\n```
//                            ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableSetOf().
              val sortedTables = sorted()
//                ^^^^^^^^^^^^ definition local 87
//                             display_name sortedTables
//                             documentation ```kotlin\nlocal val sortedTables: List<Table>\n```
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#sorted().
              fun traverse(table: Table): Boolean {
//                ^^^^^^^^ definition local 88
//                         display_name traverse
//                         documentation ```kotlin\nlocal final fun traverse(table: Table): Boolean\n```
//                         ^^^^^ definition local 89
//                               display_name table
//                               documentation ```kotlin\ntable: Table\n```
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                        ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
                  if (table in recursion) return true
//                    ^^^^^ reference local 89
//                          ^^ reference semanticdb maven . . kotlin/collections/MutableSet#contains().
//                             ^^^^^^^^^ reference local 86
                  if (table in visited) return false
//                    ^^^^^ reference local 89
//                          ^^ reference semanticdb maven . . kotlin/collections/MutableSet#contains().
//                             ^^^^^^^ reference local 85
                  recursion += table
//                ^^^^^^^^^ reference local 86
//                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/plusAssign().
//                             ^^^^^ reference local 89
                  visited += table
//                ^^^^^^^ reference local 85
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/plusAssign().
//                           ^^^^^ reference local 89
                  return if (graph[table]!!.any { traverse(it) }) {
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getGraph().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#graph.
//                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                 ^^^^^ reference local 89
//                                          ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                                              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                               display_name it
//                                                               documentation ```kotlin\nit: Table\n```
//                                                ^^^^^^^^ reference local 88
//                                                         ^^ reference semanticdb maven . . (it)
                      true
                  } else {
                      recursion -= table
//                    ^^^^^^^^^ reference local 86
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/minusAssign().
//                                 ^^^^^ reference local 89
                      false
                  }
              }
              return sortedTables.any { traverse(it) }
//                   ^^^^^^^^^^^^ reference local 87
//                                ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                     display_name it
//                                                     documentation ```kotlin\nit: Table\n```
//                                      ^^^^^^^^ reference local 88
//                                               ^^ reference semanticdb maven . . (it)
          }
      }
  }
  
  /**
   * Utility functions that assist with creating, altering, and dropping table objects.
   *
   * None of the functions rely directly on the underlying driver.
   */
  @InternalApi
  object TableUtils : SchemaUtilityApi() {
//       ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#
//                  display_name TableUtils
//                  documentation ```kotlin\n@InternalApi() public final object TableUtils : SchemaUtilityApi\n```\n\n----\n\n\n Utility functions that assist with creating, altering, and dropping table objects.\n\n None of the functions rely directly on the underlying driver.\n
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#
//       ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#`<init>`().
//                  display_name TableUtils
//                  documentation ```kotlin\nprivate constructor(): TableUtils\n```\n\n----\n\n\n Utility functions that assist with creating, altering, and dropping table objects.\n\n None of the functions rely directly on the underlying driver.\n
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#
      /** Checks whether any of the [tables] have a sequence of foreign key constraints that cycle back to them. */
      internal fun checkCycle(vararg tables: Table) = tables.toList().hasCycle()
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#checkCycle().
//                            display_name checkCycle
//                            documentation ```kotlin\ninternal final fun checkCycle(vararg tables: Table): Boolean\n```\n\n----\n\n Checks whether any of the [tables] have a sequence of foreign key constraints that cycle back to them.
//                                   ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#checkCycle().(tables)
//                                          display_name tables
//                                          documentation ```kotlin\nvararg tables: Table\n```
//                                           ^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#checkCycle().(tables)
//                                                           ^^^^^^ reference semanticdb maven . . kotlin/collections/toList().
//                                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#hasCycle().
  
      /** Returns a list of [tables] sorted according to the targets of their foreign key constraints, if any exist. */
      fun sortTablesByReferences(tables: Iterable<Table>): List<Table> = tables.sortByReferences()
//        ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#sortTablesByReferences().
//                               display_name sortTablesByReferences
//                               documentation ```kotlin\npublic final fun sortTablesByReferences(tables: Iterable<Table>): List<Table>\n```\n\n----\n\n Returns a list of [tables] sorted according to the targets of their foreign key constraints, if any exist.
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#sortTablesByReferences().(tables)
//                                      display_name tables
//                                      documentation ```kotlin\ntables: Iterable<Table>\n```
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                         ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#sortTablesByReferences().(tables)
//                                                                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#sortByReferences().
  }
