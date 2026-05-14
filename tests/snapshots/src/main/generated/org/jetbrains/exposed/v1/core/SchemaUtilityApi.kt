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
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#`<init>`().
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
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#columnsLogMessage.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getColumnsLogMessage().
      // TODO make companion object with public string fields
      @InternalApi
      protected val columnsLogMessage = "Extracting table columns"
//                  ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#columnsLogMessage.
//                                    display_name columnsLogMessage
//                                    documentation ```kotlin\n@InternalApi() protected final val columnsLogMessage: String\n```
//                  ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getColumnsLogMessage().
//                                    display_name columnsLogMessage
//                                    documentation ```kotlin\nprotected get(): String\n```
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#columnsLogMessage.
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getColumnsLogMessage().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeysLogMessage.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getPrimaryKeysLogMessage().
      @InternalApi
      protected val primaryKeysLogMessage = "Extracting primary keys"
//                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getPrimaryKeysLogMessage().
//                                        display_name primaryKeysLogMessage
//                                        documentation ```kotlin\nprotected get(): String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeysLogMessage.
//                                        display_name primaryKeysLogMessage
//                                        documentation ```kotlin\n@InternalApi() protected final val primaryKeysLogMessage: String\n```
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeysLogMessage.
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getPrimaryKeysLogMessage().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#constraintsLogMessage.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getConstraintsLogMessage().
      @InternalApi
      protected val constraintsLogMessage = "Extracting column constraints"
//                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#constraintsLogMessage.
//                                        display_name constraintsLogMessage
//                                        documentation ```kotlin\n@InternalApi() protected final val constraintsLogMessage: String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getConstraintsLogMessage().
//                                        display_name constraintsLogMessage
//                                        documentation ```kotlin\nprotected get(): String\n```
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#constraintsLogMessage.
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getConstraintsLogMessage().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createTablesLogMessage.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getCreateTablesLogMessage().
      @InternalApi
      protected val createTablesLogMessage = "Preparing create tables statements"
//                  ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createTablesLogMessage.
//                                         display_name createTablesLogMessage
//                                         documentation ```kotlin\n@InternalApi() protected final val createTablesLogMessage: String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getCreateTablesLogMessage().
//                                         display_name createTablesLogMessage
//                                         documentation ```kotlin\nprotected get(): String\n```
//                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createTablesLogMessage.
//                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getCreateTablesLogMessage().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#executeCreateTablesLogMessage.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getExecuteCreateTablesLogMessage().
      @InternalApi
      protected val executeCreateTablesLogMessage = "Executing create tables statements"
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#executeCreateTablesLogMessage.
//                                                display_name executeCreateTablesLogMessage
//                                                documentation ```kotlin\n@InternalApi() protected final val executeCreateTablesLogMessage: String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getExecuteCreateTablesLogMessage().
//                                                display_name executeCreateTablesLogMessage
//                                                documentation ```kotlin\nprotected get(): String\n```
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#executeCreateTablesLogMessage.
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getExecuteCreateTablesLogMessage().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createSequencesLogMessage.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getCreateSequencesLogMessage().
      @InternalApi
      protected val createSequencesLogMessage = "Preparing create sequences statements"
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createSequencesLogMessage.
//                                            display_name createSequencesLogMessage
//                                            documentation ```kotlin\n@InternalApi() protected final val createSequencesLogMessage: String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getCreateSequencesLogMessage().
//                                            display_name createSequencesLogMessage
//                                            documentation ```kotlin\nprotected get(): String\n```
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createSequencesLogMessage.
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getCreateSequencesLogMessage().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#alterTablesLogMessage.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getAlterTablesLogMessage().
      @InternalApi
      protected val alterTablesLogMessage = "Preparing alter tables statements"
//                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#alterTablesLogMessage.
//                                        display_name alterTablesLogMessage
//                                        documentation ```kotlin\n@InternalApi() protected final val alterTablesLogMessage: String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getAlterTablesLogMessage().
//                                        display_name alterTablesLogMessage
//                                        documentation ```kotlin\nprotected get(): String\n```
//                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#alterTablesLogMessage.
//                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getAlterTablesLogMessage().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#executeAlterTablesLogMessage.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getExecuteAlterTablesLogMessage().
      @InternalApi
      protected val executeAlterTablesLogMessage = "Executing alter tables statements"
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#executeAlterTablesLogMessage.
//                                               display_name executeAlterTablesLogMessage
//                                               documentation ```kotlin\n@InternalApi() protected final val executeAlterTablesLogMessage: String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getExecuteAlterTablesLogMessage().
//                                               display_name executeAlterTablesLogMessage
//                                               documentation ```kotlin\nprotected get(): String\n```
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#executeAlterTablesLogMessage.
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getExecuteAlterTablesLogMessage().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mappingConsistenceLogMessage.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getMappingConsistenceLogMessage().
      @InternalApi
      protected val mappingConsistenceLogMessage = "Checking mapping consistence"
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getMappingConsistenceLogMessage().
//                                               display_name mappingConsistenceLogMessage
//                                               documentation ```kotlin\nprotected get(): String\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mappingConsistenceLogMessage.
//                                               display_name mappingConsistenceLogMessage
//                                               documentation ```kotlin\n@InternalApi() protected final val mappingConsistenceLogMessage: String\n```
//                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mappingConsistenceLogMessage.
//                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#getMappingConsistenceLogMessage().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#sortByReferences().
      /** Returns this list of tables sorted according to the targets of their foreign key constraints, if any exist. */
      @InternalApi
      protected fun Iterable<Table>.sortByReferences(): List<Table> = TableDepthGraph(this).sorted()
//                                  ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#sortByReferences().
//                                                   display_name sortByReferences
//                                                   documentation ```kotlin\n@InternalApi() protected final fun Iterable<Table>.sortByReferences(): List<Table>\n```\n\n----\n\n Returns this list of tables sorted according to the targets of their foreign key constraints, if any exist.
//                                                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#`<init>`().
//                                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#sorted().
//                                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#sortByReferences().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#hasCycle().
      /** Whether any table from this list has a sequence of foreign key constraints that cycle back to them. */
      @InternalApi
      protected fun List<Table>.hasCycle(): Boolean = TableDepthGraph(this).hasCycle()
//                              ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#hasCycle().
//                                       display_name hasCycle
//                                       documentation ```kotlin\n@InternalApi() protected final fun List<Table>.hasCycle(): Boolean\n```\n\n----\n\n Whether any table from this list has a sequence of foreign key constraints that cycle back to them.
//                                          ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#`<init>`().
//                                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#hasCycle().
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#hasCycle().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().
      /** Returns DDL for [table] without a sequence as a Pair of CREATE (includes its indexes) and ALTER statements. */
      @InternalApi
      protected fun tableDdlWithoutExistingSequence(
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().
//                                                  display_name tableDdlWithoutExistingSequence
//                                                  documentation ```kotlin\n@InternalApi() protected final fun tableDdlWithoutExistingSequence(table: Table, existingSequence: Sequence?): Pair<List<String>, List<String>>\n```\n\n----\n\n Returns DDL for [table] without a sequence as a Pair of CREATE (includes its indexes) and ALTER statements.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(table)
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(table)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(existingSequence)
          existingSequence: Sequence?
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(existingSequence)
//                         display_name existingSequence
//                         documentation ```kotlin\nexistingSequence: Sequence?\n```
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(existingSequence)
      ): Pair<List<String>, List<String>> {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#
//        ⌄ enclosing_range_start local 0
//                                                            ⌄ enclosing_range_start local 1
          val ddlWithoutExistingSequence = table.ddl.filter { statement ->
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 0
//                                       display_name ddlWithoutExistingSequence
//                                       documentation ```kotlin\nlocal val ddlWithoutExistingSequence: Pair<List<String>, List<String>>\n```
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(table)
//                                               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#ddl.
//                                               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#getDdl().
//                                                   ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                                            ^^^^^^^^^ definition local 1
//                                                                      display_name statement
//                                                                      documentation ```kotlin\nstatement: String\n```
//                                                                    ⌃ enclosing_range_end local 1
              if (existingSequence != null) {
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(existingSequence)
                  !statement.lowercase().startsWith("create sequence") ||
//                ^ reference semanticdb maven . . kotlin/Boolean#not().
//                 ^^^^^^^^^ reference local 1
//                           ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
//                                       ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
                      !statement.contains(existingSequence.name)
//                    ^ reference semanticdb maven . . kotlin/Boolean#not().
//                     ^^^^^^^^^ reference local 1
//                               ^^^^^^^^ reference semanticdb maven . . kotlin/text/contains().
//                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(existingSequence)
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getName().
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#name.
              } else {
                  true
              }
//                    ⌄ enclosing_range_start local 2
          }.partition { it.startsWith("CREATE ") }
//          ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/partition(+9).
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 2
//                                                 display_name it
//                                                 documentation ```kotlin\nit: String\n```
//                      ^^ reference local 2
//                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                               ⌃ enclosing_range_end local 0
//                                               ⌃ enclosing_range_end local 2
//        ⌄ enclosing_range_start local 3
//                                               ⌄ enclosing_range_start local 4
          val indicesDDL = table.indices.flatMap { it.createStatement() }
//            ^^^^^^^^^^ definition local 3
//                       display_name indicesDDL
//                       documentation ```kotlin\nlocal val indicesDDL: List<String>\n```
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().(table)
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getIndices().
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#indices.
//                                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap(+10).
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 4
//                                                                        display_name it
//                                                                        documentation ```kotlin\nit: Index\n```
//                                                 ^^ reference local 4
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#createStatement().
//                                                                      ⌃ enclosing_range_end local 3
//                                                                      ⌃ enclosing_range_end local 4
          return Pair(ddlWithoutExistingSequence.first + indicesDDL, ddlWithoutExistingSequence.second)
//               ^^^^ reference semanticdb maven . . kotlin/Pair#`<init>`().
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 0
//                                               ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                               ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                     ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                       ^^^^^^^^^^ reference local 3
//                                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 0
//                                                                                              ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                                                                              ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#tableDdlWithoutExistingSequence().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createDdl().
      /** Returns the SQL statements that create this [ForeignKeyConstraint]. */
      @InternalApi
      protected fun ForeignKeyConstraint.createDdl(): List<String> = with(this) {
//                                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createDdl().
//                                                 display_name createDdl
//                                                 documentation ```kotlin\n@InternalApi() protected final fun ForeignKeyConstraint.createDdl(): List<String>\n```\n\n----\n\n Returns the SQL statements that create this [ForeignKeyConstraint].
//                                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                   ^^^^ reference semanticdb maven . . kotlin/with().
//        ⌄ enclosing_range_start local 5
//                                                           ⌄ enclosing_range_start local 6
          val allFromColumnsBelongsToTheSameTable = from.all { it.table == fromTable }
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 5
//                                                display_name allFromColumnsBelongsToTheSameTable
//                                                documentation ```kotlin\nlocal val allFromColumnsBelongsToTheSameTable: Boolean\n```
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#from.
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFrom().
//                                                       ^^^ reference semanticdb maven . . kotlin/collections/all(+9).
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 6
//                                                                                     display_name it
//                                                                                     documentation ```kotlin\nit: Column<*>\n```
//                                                             ^^ reference local 6
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromTable.
//                                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromTable().
//                                                                                   ⌃ enclosing_range_end local 5
//                                                                                   ⌃ enclosing_range_end local 6
          require(allFromColumnsBelongsToTheSameTable) {
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 5
              "Not all referencing columns of $this belong to the same table"
          }
//        ⌄ enclosing_range_start local 7
//                                                              ⌄ enclosing_range_start local 8
          val allTargetColumnsBelongToTheSameTable = target.all { it.table == targetTable }
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 7
//                                                 display_name allTargetColumnsBelongToTheSameTable
//                                                 documentation ```kotlin\nlocal val allTargetColumnsBelongToTheSameTable: Boolean\n```
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTarget().
//                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#target.
//                                                          ^^^ reference semanticdb maven . . kotlin/collections/all(+9).
//                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 8
//                                                                                          display_name it
//                                                                                          documentation ```kotlin\nit: Column<*>\n```
//                                                                ^^ reference local 8
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTable().
//                                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTable.
//                                                                                        ⌃ enclosing_range_end local 7
//                                                                                        ⌃ enclosing_range_end local 8
          require(allTargetColumnsBelongToTheSameTable) {
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 7
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createDdl().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().
      /** Adds CREATE/ALTER statements for all table columns that don't exist in the database, to [destination]. */
      @InternalApi
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().[C]
      protected fun <C : MutableCollection<String>> Table.mapMissingColumnStatementsTo(
//                   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().[C]
//                     display_name FirTypeParameterSymbol C
//                     documentation ```kotlin\nC : MutableCollection<String>\n```
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().
//                                                                                     display_name mapMissingColumnStatementsTo
//                                                                                     documentation ```kotlin\n@InternalApi() protected final fun <C : MutableCollection<String>> Table.mapMissingColumnStatementsTo(destination: C, existingColumns: List<ColumnMetadata>, existingPrimaryKey: PrimaryKeyMetadata?, alterTableAddColumnSupported: Boolean): C\n```\n\n----\n\n Adds CREATE/ALTER statements for all table columns that don't exist in the database, to [destination].
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().[C]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(destination)
          destination: C,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(destination)
//                    display_name destination
//                    documentation ```kotlin\ndestination: C\n```
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(destination)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(existingColumns)
          existingColumns: List<ColumnMetadata>,
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(existingColumns)
//                        display_name existingColumns
//                        documentation ```kotlin\nexistingColumns: List<ColumnMetadata>\n```
//                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(existingColumns)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(existingPrimaryKey)
          existingPrimaryKey: PrimaryKeyMetadata?,
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(existingPrimaryKey)
//                           display_name existingPrimaryKey
//                           documentation ```kotlin\nexistingPrimaryKey: PrimaryKeyMetadata?\n```
//                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(existingPrimaryKey)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(alterTableAddColumnSupported)
          alterTableAddColumnSupported: Boolean
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(alterTableAddColumnSupported)
//                                     display_name alterTableAddColumnSupported
//                                     documentation ```kotlin\nalterTableAddColumnSupported: Boolean\n```
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(alterTableAddColumnSupported)
      ): C {
          // create columns
//        ⌄ enclosing_range_start local 9
//                                                        ⌄ enclosing_range_start local 10
          val existingTableColumns = columns.mapNotNull { column ->
//            ^^^^^^^^^^^^^^^^^^^^ definition local 9
//                                 display_name existingTableColumns
//                                 documentation ```kotlin\nlocal val existingTableColumns: Map<Column<*>, ColumnMetadata>\n```
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                                           ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mapNotNull(+1).
//                                                        ^^^^^^ definition local 10
//                                                               display_name column
//                                                               documentation ```kotlin\ncolumn: Column<*>\n```
//                                                             ⌃ enclosing_range_end local 10
//            ⌄ enclosing_range_start local 11
//                                                      ⌄ enclosing_range_start local 12
              val existingColumn = existingColumns.find { column.nameUnquoted().equals(it.name, true) }
//                ^^^^^^^^^^^^^^ definition local 11
//                               display_name existingColumn
//                               documentation ```kotlin\nlocal val existingColumn: ColumnMetadata?\n```
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(existingColumns)
//                                                 ^^^^ reference semanticdb maven . . kotlin/collections/find(+9).
//                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 12
//                                                                                                      display_name it
//                                                                                                      documentation ```kotlin\nit: ColumnMetadata\n```
//                                                        ^^^^^^ reference local 10
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#nameUnquoted().
//                                                                              ^^^^^^ reference semanticdb maven . . kotlin/text/equals(+1).
//                                                                                     ^^ reference local 12
//                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getName().
//                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#name.
//                                                                                                    ⌃ enclosing_range_end local 11
//                                                                                                    ⌃ enclosing_range_end local 12
              if (existingColumn != null) column to existingColumn else null
//                ^^^^^^^^^^^^^^ reference local 11
//                                        ^^^^^^ reference local 10
//                                               ^^ reference semanticdb maven . . kotlin/to().
//                                                  ^^^^^^^^^^^^^^ reference local 11
          }.toMap()
//          ^^^^^ reference semanticdb maven . . kotlin/collections/toMap().
//                ⌃ enclosing_range_end local 9
//        ⌄ enclosing_range_start local 13
//                                                 ⌄ enclosing_range_start local 14
          val missingTableColumns = columns.filter { it !in existingTableColumns }
//            ^^^^^^^^^^^^^^^^^^^ definition local 13
//                                display_name missingTableColumns
//                                documentation ```kotlin\nlocal val missingTableColumns: List<Column<*>>\n```
//                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                                          ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 14
//                                                                                 display_name it
//                                                                                 documentation ```kotlin\nit: Column<*>\n```
//                                                   ^^ reference local 14
//                                                      ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                      ^^^ reference semanticdb maven . . kotlin/collections/contains(+10).
//                                                          ^^^^^^^^^^^^^^^^^^^^ reference local 9
//                                                                               ⌃ enclosing_range_end local 13
//                                                                               ⌃ enclosing_range_end local 14
//                                                   ⌄ enclosing_range_start local 15
          missingTableColumns.flatMapTo(destination) { it.ddl }
//        ^^^^^^^^^^^^^^^^^^^ reference local 13
//                            ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMapTo(+10).
//                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(destination)
//                                                   ^^^^^^^^^^ definition local 15
//                                                              display_name it
//                                                              documentation ```kotlin\nit: Column<*>\n```
//                                                     ^^ reference local 15
//                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#ddl.
//                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#getDdl().
//                                                            ⌃ enclosing_range_end local 15
          if (alterTableAddColumnSupported) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(alterTableAddColumnSupported)
              // create indexes with new columns
//                             ⌄ enclosing_range_start local 16
              indices.filter { index ->
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getIndices().
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#indices.
//                    ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                             ^^^^^ definition local 16
//                                   display_name index
//                                   documentation ```kotlin\nindex: Index\n```
//                                 ⌃ enclosing_range_end local 16
//                                  ⌄ enclosing_range_start local 17
                  index.columns.any { missingTableColumns.contains(it) }
//                ^^^^^ reference local 16
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                              ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 17
//                                                                       display_name it
//                                                                       documentation ```kotlin\nit: Column<*>\n```
//                                    ^^^^^^^^^^^^^^^^^^^ reference local 13
//                                                        ^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#contains().
//                                                                 ^^ reference local 17
//                                                                     ⌃ enclosing_range_end local 17
//                      ⌄ enclosing_range_start local 18
              }.forEach { destination.addAll(it.createStatement()) }
//              ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 18
//                                                                   display_name it
//                                                                   documentation ```kotlin\nit: Index\n```
//                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(destination)
//                                    ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableCollection#addAll().
//                                           ^^ reference local 18
//                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#createStatement().
//                                                                 ⌃ enclosing_range_end local 18
              // sync existing columns
              existingTableColumns
//            ^^^^^^^^^^^^^^^^^^^^ reference local 9
                  .mapColumnDiffs()
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapColumnDiffs().
//                                          ⌄ enclosing_range_start local 19
//                                           ⌄ enclosing_range_start local 20
//                                                ⌄ enclosing_range_start local 21
                  .flatMapTo(destination) { (col, changedState) ->
//                 ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMapTo(+12).
//                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(destination)
//                                          ^^^^^^^^^^^^^^^^^^^ definition local 19
//                                                              display_name <destruct>
//                                                              documentation ```kotlin\n<destruct>: Map.Entry<Column<*>, ColumnDiff>\n```
//                                           ^^^ reference local 19
//                                           ^^^ definition local 20
//                                               display_name col
//                                               documentation ```kotlin\nlocal val col: Column<*>\n```
//                                           ^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                                ^^^^^^^^^^^^ reference local 19
//                                                ^^^^^^^^^^^^ definition local 21
//                                                             display_name changedState
//                                                             documentation ```kotlin\nlocal val changedState: ColumnDiff\n```
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
//                                             ⌃ enclosing_range_end local 20
//                                                           ⌃ enclosing_range_end local 21
//                                                            ⌃ enclosing_range_end local 19
                      col.modifyStatements(changedState)
//                    ^^^ reference local 20
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#modifyStatements().
//                                         ^^^^^^^^^^^^ reference local 21
                  }
              // add missing primary key
//                                                                        ⌄ enclosing_range_start local 22
              primaryKeyDdl(missingTableColumns, existingPrimaryKey)?.let { destination.add(it) }
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeyDdl().
//                          ^^^^^^^^^^^^^^^^^^^ reference local 13
//                                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(existingPrimaryKey)
//                                                                    ^^^ reference semanticdb maven . . kotlin/let().
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^^ definition local 22
//                                                                                                display_name it
//                                                                                                documentation ```kotlin\nit: String\n```
//                                                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(destination)
//                                                                                      ^^^ reference semanticdb maven . . kotlin/collections/MutableCollection#add().
//                                                                                          ^^ reference local 22
//                                                                                              ⌃ enclosing_range_end local 22
          }
          return destination
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().(destination)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingColumnStatementsTo().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().
      /** Adds CREATE/ALTER/DROP statements for all foreign key constraints that don't exist in the database, to [destination]. */
      @InternalApi
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().[C]
      protected fun <C : MutableCollection<String>> mapMissingConstraintsTo(
//                   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().[C]
//                     display_name FirTypeParameterSymbol C
//                     documentation ```kotlin\nC : MutableCollection<String>\n```
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().
//                                                                          display_name mapMissingConstraintsTo
//                                                                          documentation ```kotlin\n@InternalApi() protected final fun <C : MutableCollection<String>> mapMissingConstraintsTo(destination: C, allExistingConstraints: Map<Pair<Table, {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>>, List<ForeignKeyConstraint>>, vararg tables: Table): C\n```\n\n----\n\n Adds CREATE/ALTER/DROP statements for all foreign key constraints that don't exist in the database, to [destination].
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().[C]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(destination)
          destination: C,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(destination)
//                    display_name destination
//                    documentation ```kotlin\ndestination: C\n```
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(destination)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(allExistingConstraints)
          allExistingConstraints: Map<Pair<Table, LinkedHashSet<Column<*>>>, List<ForeignKeyConstraint>>,
//        ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(allExistingConstraints)
//                               display_name allExistingConstraints
//                               documentation ```kotlin\nallExistingConstraints: Map<Pair<Table, {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>>, List<ForeignKeyConstraint>>\n```
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(allExistingConstraints)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(tables)
          vararg tables: Table
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(tables)
//                      display_name tables
//                      documentation ```kotlin\nvararg tables: Table\n```
//                       ^^^^^ reference semanticdb maven . . kotlin/Array#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(tables)
      ): C {
//        ⌄ enclosing_range_start local 23
//                                                     ⌄ enclosing_range_start local 24
          val foreignKeyConstraints = tables.flatMap { table ->
//            ^^^^^^^^^^^^^^^^^^^^^ definition local 23
//                                  display_name foreignKeyConstraints
//                                  documentation ```kotlin\nlocal val foreignKeyConstraints: List<Pair<ForeignKeyConstraint, ForeignKeyConstraint?>>\n```
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(tables)
//                                           ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap().
//                                                     ^^^^^ definition local 24
//                                                           display_name table
//                                                           documentation ```kotlin\ntable: Table\n```
//                                                         ⌃ enclosing_range_end local 24
//                                  ⌄ enclosing_range_start local 25
              table.foreignKeys.map { it to allExistingConstraints[table to it.from]?.firstOrNull() }
//            ^^^^^ reference local 24
//                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKeys.
//                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getForeignKeys().
//                              ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 25
//                                                                                                    display_name it
//                                                                                                    documentation ```kotlin\nit: ForeignKeyConstraint\n```
//                                    ^^ reference local 25
//                                       ^^ reference semanticdb maven . . kotlin/to().
//                                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(allExistingConstraints)
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                                 ^^^^^ reference local 24
//                                                                       ^^ reference semanticdb maven . . kotlin/to().
//                                                                          ^^ reference local 25
//                                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#from.
//                                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFrom().
//                                                                                    ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+19).
//                                                                                                  ⌃ enclosing_range_end local 25
          }
//        ⌃ enclosing_range_end local 23
//             ⌄ enclosing_range_start local 27
//              ⌄ enclosing_range_start local 28
//                          ⌄ enclosing_range_start local 29
//                                                 ⌄ enclosing_range_start local 26
          for ((foreignKey, existingConstraint) in foreignKeyConstraints) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 27
//                                              display_name <destruct>
//                                              documentation ```kotlin\nlocal val <destruct>: Pair<ForeignKeyConstraint, ForeignKeyConstraint?>\n```
//              ^^^^^^^^^^ reference local 27
//              ^^^^^^^^^^ definition local 28
//                         display_name foreignKey
//                         documentation ```kotlin\nlocal val foreignKey: ForeignKeyConstraint\n```
//              ^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                          ^^^^^^^^^^^^^^^^^^ reference local 27
//                          ^^^^^^^^^^^^^^^^^^ definition local 29
//                                             display_name existingConstraint
//                                             documentation ```kotlin\nlocal val existingConstraint: ForeignKeyConstraint?\n```
//                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                 ^^^^^^^^^^^^^^^^^^^^^ reference local 23
//                                                 ^^^^^^^^^^^^^^^^^^^^^ definition local 26
//                                                                       display_name <iterator>
//                                                                       documentation ```kotlin\nlocal val <iterator>: Iterator<Pair<ForeignKeyConstraint, ForeignKeyConstraint?>>\n```
//                                                 ^^^^^^^^^^^^^^^^^^^^^ reference local 26
//                                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#hasNext().
//                                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#next().
//                                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#iterator().
//                       ⌃ enclosing_range_end local 28
//                                           ⌃ enclosing_range_end local 29
//                                            ⌃ enclosing_range_end local 27
//                                                                     ⌃ enclosing_range_end local 26
              if (existingConstraint == null) {
//                ^^^^^^^^^^^^^^^^^^ reference local 29
                  destination.addAll(foreignKey.createDdl())
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(destination)
//                            ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableCollection#addAll().
//                                   ^^^^^^^^^^ reference local 28
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createDdl().
                  continue
              }
//            ⌄ enclosing_range_start local 30
              val noForeignKey = existingConstraint.targetTable != foreignKey.targetTable
//                ^^^^^^^^^^^^ definition local 30
//                             display_name noForeignKey
//                             documentation ```kotlin\nlocal val noForeignKey: Boolean\n```
//                               ^^^^^^^^^^^^^^^^^^ reference local 29
//                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTable().
//                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTable.
//                                                                 ^^^^^^^^^^ reference local 28
//                                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTable().
//                                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTable.
//                                                                                      ⌃ enclosing_range_end local 30
//            ⌄ enclosing_range_start local 31
              val deleteRuleMismatch = foreignKey.deleteRule != existingConstraint.deleteRule
//                ^^^^^^^^^^^^^^^^^^ definition local 31
//                                   display_name deleteRuleMismatch
//                                   documentation ```kotlin\nlocal val deleteRuleMismatch: Boolean\n```
//                                     ^^^^^^^^^^ reference local 28
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#deleteRule.
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getDeleteRule().
//                                                              ^^^^^^^^^^^^^^^^^^ reference local 29
//                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#deleteRule.
//                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getDeleteRule().
//                                                                                          ⌃ enclosing_range_end local 31
//            ⌄ enclosing_range_start local 32
              val updateRuleMismatch = foreignKey.updateRule != existingConstraint.updateRule
//                ^^^^^^^^^^^^^^^^^^ definition local 32
//                                   display_name updateRuleMismatch
//                                   documentation ```kotlin\nlocal val updateRuleMismatch: Boolean\n```
//                                     ^^^^^^^^^^ reference local 28
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getUpdateRule().
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#updateRule.
//                                                              ^^^^^^^^^^^^^^^^^^ reference local 29
//                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getUpdateRule().
//                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#updateRule.
//                                                                                          ⌃ enclosing_range_end local 32
              if (noForeignKey || deleteRuleMismatch || updateRuleMismatch) {
//                ^^^^^^^^^^^^ reference local 30
//                                ^^^^^^^^^^^^^^^^^^ reference local 31
//                                                      ^^^^^^^^^^^^^^^^^^ reference local 32
                  destination.addAll(existingConstraint.dropStatement())
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(destination)
//                            ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableCollection#addAll().
//                                   ^^^^^^^^^^^^^^^^^^ reference local 29
//                                                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#dropStatement().
                  destination.addAll(foreignKey.createDdl())
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(destination)
//                            ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableCollection#addAll().
//                                   ^^^^^^^^^^ reference local 28
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#createDdl().
              }
          }
          return destination
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().(destination)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapMissingConstraintsTo().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessIndices().
      /**
       * Filters all table indices and returns those that are defined on a table with more than one index.
       * If [withLogs] is `true`, DROP statements for these indices will also be logged.
       */
      @InternalApi
//                                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessIndices().(withLogs)
      protected fun Map<Table, List<Index>>.filterAndLogExcessIndices(withLogs: Boolean): List<Index> {
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessIndices().
//                                                                    display_name filterAndLogExcessIndices
//                                                                    documentation ```kotlin\n@InternalApi() protected final fun Map<Table, List<Index>>.filterAndLogExcessIndices(withLogs: Boolean): List<Index>\n```\n\n----\n\n\n Filters all table indices and returns those that are defined on a table with more than one index.\n If [withLogs] is `true`, DROP statements for these indices will also be logged.\n
//                                                                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessIndices().(withLogs)
//                                                                             display_name withLogs
//                                                                             documentation ```kotlin\nwithLogs: Boolean\n```
//                                                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                        ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessIndices().(withLogs)
//        ⌄ enclosing_range_start local 33
//                                         ⌄ enclosing_range_start local 34
//                                          ⌄ enclosing_range_start local 35
//                                             ⌄ enclosing_range_start local 36
          val excessiveIndices = flatMap { (_, indices) -> indices }
//            ^^^^^^^^^^^^^^^^ definition local 33
//                             display_name excessiveIndices
//                             documentation ```kotlin\nlocal val excessiveIndices: Map<Triple<Table, Boolean, String>, List<Index>>\n```
//                               ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap(+12).
//                                         ^^^^^^^^^^^^ definition local 34
//                                                      display_name <destruct>
//                                                      documentation ```kotlin\n<destruct>: Map.Entry<Table, List<Index>>\n```
//                                          ^ reference local 34
//                                          ^ definition local 35
//                                            display_name <unused var>
//                                            documentation ```kotlin\nlocal val <unused var>: Table\n```
//                                          ^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                             ^^^^^^^ reference local 34
//                                             ^^^^^^^ definition local 36
//                                                     display_name indices
//                                                     documentation ```kotlin\nlocal val indices: List<Index>\n```
//                                             ^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
//                                                         ^^^^^^^ reference local 36
//                                          ⌃ enclosing_range_end local 35
//                                                   ⌃ enclosing_range_end local 36
//                                                    ⌃ enclosing_range_end local 34
//                       ⌄ enclosing_range_start local 37
              .groupBy { index ->
//             ^^^^^^^ reference semanticdb maven . . kotlin/collections/groupBy(+18).
//                       ^^^^^ definition local 37
//                             display_name index
//                             documentation ```kotlin\nindex: Index\n```
//                           ⌃ enclosing_range_end local 37
//                                                                               ⌄ enclosing_range_start local 38
                  Triple(index.table, index.unique, index.columns.joinToString { column -> column.name })
//                ^^^^^^ reference semanticdb maven . . kotlin/Triple#`<init>`().
//                       ^^^^^ reference local 37
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                                    ^^^^^ reference local 37
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
//                                                  ^^^^^ reference local 37
//                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                                                                ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                               ^^^^^^ definition local 38
//                                                                                      display_name column
//                                                                                      documentation ```kotlin\ncolumn: Column<*>\n```
//                                                                                         ^^^^^^ reference local 38
//                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                                    ⌃ enclosing_range_end local 38
              }
//                          ⌄ enclosing_range_start local 39
              .filterValues { it.size > 1 }
//             ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterValues().
//                          ^^^^^^^^^^^^^^^ definition local 39
//                                          display_name it
//                                          documentation ```kotlin\nit: List<Index>\n```
//                            ^^ reference local 39
//                               ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                               ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                    ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                        ⌃ enclosing_range_end local 33
//                                        ⌃ enclosing_range_end local 39
          if (excessiveIndices.isEmpty()) return emptyList()
//            ^^^^^^^^^^^^^^^^ reference local 33
//                             ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#isEmpty().
//                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
//        ⌄ enclosing_range_start local 40
          val toDrop = HashSet<Index>()
//            ^^^^^^ definition local 40
//                   display_name toDrop
//                   documentation ```kotlin\nlocal val toDrop: {kotlin/collections/HashSet<org/jetbrains/exposed/v1/core/Index>=} HashSet<Index>\n```
//                     ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#`<init>`().
//                                    ⌃ enclosing_range_end local 40
          if (withLogs) {
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessIndices().(withLogs)
              exposedLogger.warn("List of excessive indices:")
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                       ⌄ enclosing_range_start local 41
//                                        ⌄ enclosing_range_start local 42
//                                                ⌄ enclosing_range_start local 43
              excessiveIndices.forEach { (triple, indices) ->
//            ^^^^^^^^^^^^^^^^ reference local 33
//                             ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                                       ^^^^^^^^^^^^^^^^^ definition local 41
//                                                         display_name <destruct>
//                                                         documentation ```kotlin\n<destruct>: Map.Entry<Triple<Table, Boolean, String>, List<Index>>\n```
//                                        ^^^^^^ reference local 41
//                                        ^^^^^^ definition local 42
//                                               display_name triple
//                                               documentation ```kotlin\nlocal val triple: Triple<Table, Boolean, String>\n```
//                                        ^^^^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                                ^^^^^^^ reference local 41
//                                                ^^^^^^^ definition local 43
//                                                        display_name indices
//                                                        documentation ```kotlin\nlocal val indices: List<Index>\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
//                                             ⌃ enclosing_range_end local 42
//                                                      ⌃ enclosing_range_end local 43
//                                                       ⌃ enclosing_range_end local 41
//                ⌄ enclosing_range_start local 44
//                                                              ⌄ enclosing_range_start local 45
                  val indexNames = indices.joinToString(", ") { index -> index.indexName }
//                    ^^^^^^^^^^ definition local 44
//                               display_name indexNames
//                               documentation ```kotlin\nlocal val indexNames: String\n```
//                                 ^^^^^^^ reference local 43
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                              ^^^^^ definition local 45
//                                                                    display_name index
//                                                                    documentation ```kotlin\nindex: Index\n```
//                                                                       ^^^^^ reference local 45
//                                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
//                                                                  ⌃ enclosing_range_end local 45
//                                                                                       ⌃ enclosing_range_end local 44
                  exposedLogger.warn("\t\t\t'${triple.first.tableName}'.'${triple.third}' -> $indexNames")
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                              ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                             ^^^^^^ reference local 42
//                                                    ^^^^^ reference semanticdb maven . . kotlin/Triple#first.
//                                                    ^^^^^ reference semanticdb maven . . kotlin/Triple#getFirst().
//                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                         ^^^^^^ reference local 42
//                                                                                ^^^^^ reference semanticdb maven . . kotlin/Triple#getThird().
//                                                                                ^^^^^ reference semanticdb maven . . kotlin/Triple#third.
//                                                                                            ^^^^^^^^^^ reference local 44
              }
              exposedLogger.info("SQL Queries to remove excessive indices:")
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#info().
          }
//                                   ⌄ enclosing_range_start local 46
//                                    ⌄ enclosing_range_start local 47
//                                       ⌄ enclosing_range_start local 48
          excessiveIndices.forEach { (_, indices) ->
//        ^^^^^^^^^^^^^^^^ reference local 33
//                         ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                                   ^^^^^^^^^^^^ definition local 46
//                                                display_name <destruct>
//                                                documentation ```kotlin\n<destruct>: Map.Entry<Triple<Table, Boolean, String>, List<Index>>\n```
//                                    ^ reference local 46
//                                    ^ definition local 47
//                                      display_name <unused var>
//                                      documentation ```kotlin\nlocal val <unused var>: Triple<Table, Boolean, String>\n```
//                                    ^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                       ^^^^^^^ reference local 46
//                                       ^^^^^^^ definition local 48
//                                               display_name indices
//                                               documentation ```kotlin\nlocal val indices: List<Index>\n```
//                                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
//                                    ⌃ enclosing_range_end local 47
//                                             ⌃ enclosing_range_end local 48
//                                              ⌃ enclosing_range_end local 46
//                                                     ⌄ enclosing_range_start local 49
              indices.take(indices.size - 1).forEach { index ->
//            ^^^^^^^ reference local 48
//                    ^^^^ reference semanticdb maven . . kotlin/collections/take(+9).
//                         ^^^^^^^ reference local 48
//                                 ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                 ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                      ^ reference semanticdb maven . . kotlin/Int#minus(+2).
//                                           ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                                     ^^^^^ definition local 49
//                                                           display_name index
//                                                           documentation ```kotlin\nindex: Index\n```
//                                                         ⌃ enclosing_range_end local 49
                  toDrop.add(index)
//                ^^^^^^ reference local 40
//                       ^^^ reference semanticdb maven jdk 11 java/util/HashSet#add().
//                           ^^^^^ reference local 49
                  if (withLogs) {
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessIndices().(withLogs)
                      exposedLogger.info("\t\t\t${index.dropStatement()};")
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                                  ^^^^ reference semanticdb maven . . org/slf4j/Logger#info().
//                                                ^^^^^ reference local 49
//                                                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#dropStatement().
                  }
              }
          }
          return toDrop.toList()
//               ^^^^^^ reference local 40
//                      ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+10).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessIndices().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessConstraints().
      /**
       * Filters all table foreign keys and returns those that are defined on a table with more than one of this constraint.
       * If [withLogs] is `true`, DROP statements for these constraints will also be logged.
       */
      @InternalApi
      protected fun Map<Pair<Table, LinkedHashSet<Column<*>>>, List<ForeignKeyConstraint>>.filterAndLogExcessConstraints(
//                                                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessConstraints().
//                                                                                                                       display_name filterAndLogExcessConstraints
//                                                                                                                       documentation ```kotlin\n@InternalApi() protected final fun Map<Pair<Table, {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>>, List<ForeignKeyConstraint>>.filterAndLogExcessConstraints(withLogs: Boolean): List<ForeignKeyConstraint>\n```\n\n----\n\n\n Filters all table foreign keys and returns those that are defined on a table with more than one of this constraint.\n If [withLogs] is `true`, DROP statements for these constraints will also be logged.\n
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessConstraints().(withLogs)
          withLogs: Boolean
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessConstraints().(withLogs)
//                 display_name withLogs
//                 documentation ```kotlin\nwithLogs: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessConstraints().(withLogs)
      ): List<ForeignKeyConstraint> {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//        ⌄ enclosing_range_start local 50
//                                                ⌄ enclosing_range_start local 51
          val excessiveConstraints = filterValues { it.size > 1 }
//            ^^^^^^^^^^^^^^^^^^^^ definition local 50
//                                 display_name excessiveConstraints
//                                 documentation ```kotlin\nlocal val excessiveConstraints: Map<Pair<Table, {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>>, List<ForeignKeyConstraint>>\n```
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterValues().
//                                                ^^^^^^^^^^^^^^^ definition local 51
//                                                                display_name it
//                                                                documentation ```kotlin\nit: List<ForeignKeyConstraint>\n```
//                                                  ^^ reference local 51
//                                                     ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                                     ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                                          ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                                              ⌃ enclosing_range_end local 50
//                                                              ⌃ enclosing_range_end local 51
          if (excessiveConstraints.isEmpty()) return emptyList()
//            ^^^^^^^^^^^^^^^^^^^^ reference local 50
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#isEmpty().
//                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
//        ⌄ enclosing_range_start local 52
          val toDrop = HashSet<ForeignKeyConstraint>()
//            ^^^^^^ definition local 52
//                   display_name toDrop
//                   documentation ```kotlin\nlocal val toDrop: {kotlin/collections/HashSet<org/jetbrains/exposed/v1/core/ForeignKeyConstraint>=} HashSet<ForeignKeyConstraint>\n```
//                     ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#`<init>`().
//                                                   ⌃ enclosing_range_end local 52
          if (withLogs) {
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessConstraints().(withLogs)
              exposedLogger.warn("List of excessive foreign key constraints:")
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                           ⌄ enclosing_range_start local 53
//                                            ⌄ enclosing_range_start local 55
//                                                   ⌄ enclosing_range_start local 56
//                                                             ⌄ enclosing_range_start local 54
              excessiveConstraints.forEach { (table, columns), fkConstraints ->
//            ^^^^^^^^^^^^^^^^^^^^ reference local 50
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#forEach().
//                                           ^^^^^^^^^^^^^^^^ definition local 53
//                                                            display_name <destruct>
//                                                            documentation ```kotlin\n<destruct>: @EnhancedNullability Pair<Table, {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>>\n```
//                                            ^^^^^ reference local 53
//                                            ^^^^^ definition local 55
//                                                  display_name table
//                                                  documentation ```kotlin\nlocal val table: Table\n```
//                                            ^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                   ^^^^^^^ reference local 53
//                                                   ^^^^^^^ definition local 56
//                                                           display_name columns
//                                                           documentation ```kotlin\nlocal val columns: {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>\n```
//                                                   ^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                             ^^^^^^^^^^^^^ definition local 54
//                                                                           display_name fkConstraints
//                                                                           documentation ```kotlin\nfkConstraints: @EnhancedNullability List<ForeignKeyConstraint>\n```
//                                                ⌃ enclosing_range_end local 55
//                                                         ⌃ enclosing_range_end local 56
//                                                          ⌃ enclosing_range_end local 53
//                                                                         ⌃ enclosing_range_end local 54
//                ⌄ enclosing_range_start local 57
                  val constraint = fkConstraints.first()
//                    ^^^^^^^^^^ definition local 57
//                               display_name constraint
//                               documentation ```kotlin\nlocal val constraint: ForeignKeyConstraint\n```
//                                 ^^^^^^^^^^^^^ reference local 54
//                                               ^^^^^ reference semanticdb maven . . kotlin/collections/first(+19).
//                                                     ⌃ enclosing_range_end local 57
//                ⌄ enclosing_range_start local 58
//                                                                     ⌄ enclosing_range_start local 59
                  val fkPartToLog = fkConstraints.joinToString(", ") { fkConstraint -> fkConstraint.fkName }
//                    ^^^^^^^^^^^ definition local 58
//                                display_name fkPartToLog
//                                documentation ```kotlin\nlocal val fkPartToLog: String\n```
//                                  ^^^^^^^^^^^^^ reference local 54
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                     ^^^^^^^^^^^^ definition local 59
//                                                                                  display_name fkConstraint
//                                                                                  documentation ```kotlin\nfkConstraint: ForeignKeyConstraint\n```
//                                                                                     ^^^^^^^^^^^^ reference local 59
//                                                                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fkName.
//                                                                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFkName().
//                                                                                ⌃ enclosing_range_end local 59
//                                                                                                         ⌃ enclosing_range_end local 58
                  exposedLogger.warn(
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                              ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
                      "\t\t\t'$table'.'$columns' -> '${constraint.fromTableName}':\t$fkPartToLog"
//                             ^^^^^ reference local 55
//                                      ^^^^^^^ reference local 56
//                                                     ^^^^^^^^^^ reference local 57
//                                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromTableName.
//                                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromTableName().
//                                                                                   ^^^^^^^^^^^ reference local 58
                  )
              }
              exposedLogger.info("SQL Queries to remove excessive keys:")
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#info().
          }
//                                       ⌄ enclosing_range_start local 60
//                                        ⌄ enclosing_range_start local 61
//                                           ⌄ enclosing_range_start local 62
          excessiveConstraints.forEach { (_, fkConstraints) ->
//        ^^^^^^^^^^^^^^^^^^^^ reference local 50
//                             ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                                       ^^^^^^^^^^^^^^^^^^ definition local 60
//                                                          display_name <destruct>
//                                                          documentation ```kotlin\n<destruct>: Map.Entry<Pair<Table, {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>>, List<ForeignKeyConstraint>>\n```
//                                        ^ reference local 60
//                                        ^ definition local 61
//                                          display_name <unused var>
//                                          documentation ```kotlin\nlocal val <unused var>: Pair<Table, {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>>\n```
//                                        ^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                           ^^^^^^^^^^^^^ reference local 60
//                                           ^^^^^^^^^^^^^ definition local 62
//                                                         display_name fkConstraints
//                                                         documentation ```kotlin\nlocal val fkConstraints: List<ForeignKeyConstraint>\n```
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
//                                        ⌃ enclosing_range_end local 61
//                                                       ⌃ enclosing_range_end local 62
//                                                        ⌃ enclosing_range_end local 60
//                                                                 ⌄ enclosing_range_start local 63
              fkConstraints.take(fkConstraints.size - 1).forEach { fkConstraint ->
//            ^^^^^^^^^^^^^ reference local 62
//                          ^^^^ reference semanticdb maven . . kotlin/collections/take(+9).
//                               ^^^^^^^^^^^^^ reference local 62
//                                             ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                             ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                                  ^ reference semanticdb maven . . kotlin/Int#minus(+2).
//                                                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                                                 ^^^^^^^^^^^^ definition local 63
//                                                                              display_name fkConstraint
//                                                                              documentation ```kotlin\nfkConstraint: ForeignKeyConstraint\n```
//                                                                            ⌃ enclosing_range_end local 63
                  toDrop.add(fkConstraint)
//                ^^^^^^ reference local 52
//                       ^^^ reference semanticdb maven jdk 11 java/util/HashSet#add().
//                           ^^^^^^^^^^^^ reference local 63
                  if (withLogs) {
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessConstraints().(withLogs)
                      exposedLogger.info("\t\t\t${fkConstraint.dropStatement()};")
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                                  ^^^^ reference semanticdb maven . . org/slf4j/Logger#info().
//                                                ^^^^^^^^^^^^ reference local 63
//                                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#dropStatement().
                  }
              }
          }
          return toDrop.toList()
//               ^^^^^^ reference local 52
//                      ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+10).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogExcessConstraints().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().
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
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(existingFKConstraints)
          existingFKConstraints: Set<Pair<Table, LinkedHashSet<Column<*>>>>,
//        ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(existingFKConstraints)
//                              display_name existingFKConstraints
//                              documentation ```kotlin\nexistingFKConstraints: Set<Pair<Table, {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>>>\n```
//                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Set#
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(existingFKConstraints)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withDropIndices)
          withDropIndices: Boolean,
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withDropIndices)
//                        display_name withDropIndices
//                        documentation ```kotlin\nwithDropIndices: Boolean\n```
//                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withDropIndices)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withLogs)
          withLogs: Boolean,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withLogs)
//                 display_name withLogs
//                 documentation ```kotlin\nwithLogs: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withLogs)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(tables)
          vararg tables: Table
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(tables)
//                      display_name tables
//                      documentation ```kotlin\nvararg tables: Table\n```
//                       ^^^^^ reference semanticdb maven . . kotlin/Array#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(tables)
      ): Pair<List<Index>, List<Index>> {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#
//        ⌄ enclosing_range_start local 64
          fun List<Index>.filterForeignKeys() = if (currentDialect is MysqlDialect) {
//                        ^^^^^^^^^^^^^^^^^ definition local 64
//                                          display_name filterForeignKeys
//                                          documentation ```kotlin\nlocal final fun List<Index>.filterForeignKeys(): List<Index>\n```
//                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                      ⌄ enclosing_range_start local 65
              filterNot { it.table to LinkedHashSet(it.columns) in existingFKConstraints }
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterNot(+9).
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 65
//                                                                                         display_name it
//                                                                                         documentation ```kotlin\nit: Index\n```
//                        ^^ reference local 65
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                                 ^^ reference semanticdb maven . . kotlin/to().
//                                    ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashSet#`<init>`().
//                                                  ^^ reference local 65
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                                                              ^^ reference semanticdb maven . . kotlin/collections/Set#contains().
//                                                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(existingFKConstraints)
//                                                                                       ⌃ enclosing_range_end local 65
          } else {
              this
          }
//        ⌃ enclosing_range_end local 64
  
//        ⌄ enclosing_range_start local 66
          // SQLite: indices whose names start with "sqlite_" are meant for internal use
          fun List<Index>.filterInternalIndices() = if (currentDialect is SQLiteDialect) {
//                        ^^^^^^^^^^^^^^^^^^^^^ definition local 66
//                                              display_name filterInternalIndices
//                                              documentation ```kotlin\nlocal final fun List<Index>.filterInternalIndices(): List<Index>\n```
//                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#
//                   ⌄ enclosing_range_start local 67
              filter { !it.indexName.startsWith("sqlite_") }
//            ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 67
//                                                           display_name it
//                                                           documentation ```kotlin\nit: Index\n```
//                     ^ reference semanticdb maven . . kotlin/Boolean#not().
//                      ^^ reference local 67
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
//                                   ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                         ⌃ enclosing_range_end local 67
          } else {
              this
          }
//        ⌃ enclosing_range_end local 66
  
//        ⌄ enclosing_range_start local 68
          fun Table.existingIndices() = this@filterAndLogMissingAndUnmappedIndices[this].orEmpty()
//                  ^^^^^^^^^^^^^^^ definition local 68
//                                  display_name existingIndices
//                                  documentation ```kotlin\nlocal final fun Table.existingIndices(): List<Index>\n```
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                                                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/orEmpty(+2).
              .filterForeignKeys()
//             ^^^^^^^^^^^^^^^^^ reference local 64
              .filterInternalIndices()
//             ^^^^^^^^^^^^^^^^^^^^^ reference local 66
//                                   ⌃ enclosing_range_end local 68
  
//        ⌄ enclosing_range_start local 69
          fun Table.mappedIndices() = this.indices.filterForeignKeys().filterInternalIndices()
//                  ^^^^^^^^^^^^^ definition local 69
//                                display_name mappedIndices
//                                documentation ```kotlin\nlocal final fun Table.mappedIndices(): List<Index>\n```
//                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getIndices().
//                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#indices.
//                                                 ^^^^^^^^^^^^^^^^^ reference local 64
//                                                                     ^^^^^^^^^^^^^^^^^^^^^ reference local 66
//                                                                                           ⌃ enclosing_range_end local 69
//        ⌄ enclosing_range_start local 70
          val missingIndices = HashSet<Index>()
//            ^^^^^^^^^^^^^^ definition local 70
//                           display_name missingIndices
//                           documentation ```kotlin\nlocal val missingIndices: {kotlin/collections/HashSet<org/jetbrains/exposed/v1/core/Index>=} HashSet<Index>\n```
//                             ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#`<init>`().
//                                            ⌃ enclosing_range_end local 70
//        ⌄ enclosing_range_start local 71
          val unMappedIndices = HashMap<String, MutableSet<Index>>()
//            ^^^^^^^^^^^^^^^ definition local 71
//                            display_name unMappedIndices
//                            documentation ```kotlin\nlocal val unMappedIndices: {kotlin/collections/HashMap<kotlin/String, kotlin/collections/MutableSet<org/jetbrains/exposed/v1/core/Index>>=} HashMap<String, MutableSet<Index>>\n```
//                              ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashMap#`<init>`().
//                                                                 ⌃ enclosing_range_end local 71
//        ⌄ enclosing_range_start local 72
          val nameDiffers = HashSet<Index>()
//            ^^^^^^^^^^^ definition local 72
//                        display_name nameDiffers
//                        documentation ```kotlin\nlocal val nameDiffers: {kotlin/collections/HashSet<org/jetbrains/exposed/v1/core/Index>=} HashSet<Index>\n```
//                          ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#`<init>`().
//                                         ⌃ enclosing_range_end local 72
//                         ⌄ enclosing_range_start local 73
          tables.forEach { table ->
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(tables)
//               ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach().
//                         ^^^^^ definition local 73
//                               display_name table
//                               documentation ```kotlin\ntable: Table\n```
//                             ⌃ enclosing_range_end local 73
//            ⌄ enclosing_range_start local 74
              val existingTableIndices = table.existingIndices()
//                ^^^^^^^^^^^^^^^^^^^^ definition local 74
//                                     display_name existingTableIndices
//                                     documentation ```kotlin\nlocal val existingTableIndices: List<Index>\n```
//                                       ^^^^^ reference local 73
//                                             ^^^^^^^^^^^^^^^ reference local 68
//                                                             ⌃ enclosing_range_end local 74
//            ⌄ enclosing_range_start local 75
              val mappedIndices = table.mappedIndices()
//                ^^^^^^^^^^^^^ definition local 75
//                              display_name mappedIndices
//                              documentation ```kotlin\nlocal val mappedIndices: List<Index>\n```
//                                ^^^^^ reference local 73
//                                      ^^^^^^^^^^^^^ reference local 69
//                                                    ⌃ enclosing_range_end local 75
//                 ⌄ enclosing_range_start local 77
//                          ⌄ enclosing_range_start local 76
              for (index in existingTableIndices) {
//                 ^^^^^ definition local 77
//                       display_name index
//                       documentation ```kotlin\nlocal val index: Index\n```
//                          ^^^^^^^^^^^^^^^^^^^^ reference local 74
//                          ^^^^^^^^^^^^^^^^^^^^ definition local 76
//                                               display_name <iterator>
//                                               documentation ```kotlin\nlocal val <iterator>: Iterator<Index>\n```
//                          ^^^^^^^^^^^^^^^^^^^^ reference local 76
//                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#hasNext().
//                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#next().
//                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#iterator().
//                     ⌃ enclosing_range_end local 77
//                                             ⌃ enclosing_range_end local 76
//                ⌄ enclosing_range_start local 78
//                                                            ⌄ enclosing_range_start local 79
                  val mappedIndex = mappedIndices.firstOrNull { it.onlyNameDiffer(index) } ?: continue
//                    ^^^^^^^^^^^ definition local 78
//                                display_name mappedIndex
//                                documentation ```kotlin\nlocal val mappedIndex: Index\n```
//                                  ^^^^^^^^^^^^^ reference local 75
//                                                ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+20).
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 79
//                                                                                         display_name it
//                                                                                         documentation ```kotlin\nit: Index\n```
//                                                              ^^ reference local 79
//                                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#onlyNameDiffer().
//                                                                                ^^^^^ reference local 77
//                                                                                       ⌃ enclosing_range_end local 79
//                                                                                                   ⌃ enclosing_range_end local 78
                  if (withLogs) {
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withLogs)
                      exposedLogger.info(
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                                  ^^^^ reference semanticdb maven . . org/slf4j/Logger#info().
                          "Index on table '${table.tableName}' differs only in name: in db ${index.indexName} " +
//                                           ^^^^^ reference local 73
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                                           ^^^^^ reference local 77
//                                                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                                                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
                              "-> in mapping ${mappedIndex.indexName}"
//                                             ^^^^^^^^^^^ reference local 78
//                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
                      )
                  }
                  nameDiffers.add(index)
//                ^^^^^^^^^^^ reference local 72
//                            ^^^ reference semanticdb maven jdk 11 java/util/HashSet#add().
//                                ^^^^^ reference local 77
                  nameDiffers.add(mappedIndex)
//                ^^^^^^^^^^^ reference local 72
//                            ^^^ reference semanticdb maven jdk 11 java/util/HashSet#add().
//                                ^^^^^^^^^^^ reference local 78
              }
              unMappedIndices
//            ^^^^^^^^^^^^^^^ reference local 71
                  .getOrPut(table.nameInDatabaseCase()) { hashSetOf() }
//                 ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getOrPut(+1).
//                          ^^^^^ reference local 73
//                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nameInDatabaseCase().
//                                                        ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/hashSetOf().
                  .addAll(existingTableIndices.subtract(mappedIndices))
//                 ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableSet#addAll().
//                        ^^^^^^^^^^^^^^^^^^^^ reference local 74
//                                             ^^^^^^^^ reference semanticdb maven . . kotlin/collections/subtract(+9).
//                                                      ^^^^^^^^^^^^^ reference local 75
              missingIndices.addAll(mappedIndices.subtract(existingTableIndices))
//            ^^^^^^^^^^^^^^ reference local 70
//                           ^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#addAll().
//                                  ^^^^^^^^^^^^^ reference local 75
//                                                ^^^^^^^^ reference semanticdb maven . . kotlin/collections/subtract(+9).
//                                                         ^^^^^^^^^^^^^^^^^^^^ reference local 74
          }
//        ⌄ enclosing_range_start local 80
          val toCreate = missingIndices.subtract(nameDiffers)
//            ^^^^^^^^ definition local 80
//                     display_name toCreate
//                     documentation ```kotlin\nlocal val toCreate: Set<Index>\n```
//                       ^^^^^^^^^^^^^^ reference local 70
//                                      ^^^^^^^^ reference semanticdb maven . . kotlin/collections/subtract(+9).
//                                               ^^^^^^^^^^^ reference local 72
//                                                          ⌃ enclosing_range_end local 80
          toCreate.log("Indices missed from database (will be created):", withLogs)
//        ^^^^^^^^ reference local 80
//                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().
//                                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withLogs)
//        ⌄ enclosing_range_start local 81
          val toDrop = mutableSetOf<Index>()
//            ^^^^^^ definition local 81
//                   display_name toDrop
//                   documentation ```kotlin\nlocal val toDrop: MutableSet<Index>\n```
//                     ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableSetOf().
//                                         ⌃ enclosing_range_end local 81
//                                  ⌄ enclosing_range_start local 82
//                                   ⌄ enclosing_range_start local 83
//                                         ⌄ enclosing_range_start local 84
          unMappedIndices.forEach { (name, indices) ->
//        ^^^^^^^^^^^^^^^ reference local 71
//                        ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                                  ^^^^^^^^^^^^^^^ definition local 82
//                                                  display_name <destruct>
//                                                  documentation ```kotlin\n<destruct>: Map.Entry<String, MutableSet<Index>>\n```
//                                   ^^^^ reference local 82
//                                   ^^^^ definition local 83
//                                        display_name name
//                                        documentation ```kotlin\nlocal val name: String\n```
//                                   ^^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                         ^^^^^^^ reference local 82
//                                         ^^^^^^^ definition local 84
//                                                 display_name indices
//                                                 documentation ```kotlin\nlocal val indices: MutableSet<Index>\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
//                                      ⌃ enclosing_range_end local 83
//                                               ⌃ enclosing_range_end local 84
//                                                ⌃ enclosing_range_end local 82
//                                               ⌄ enclosing_range_start local 85
              indices.subtract(nameDiffers).also {
//            ^^^^^^^ reference local 84
//                    ^^^^^^^^ reference semanticdb maven . . kotlin/collections/subtract(+9).
//                             ^^^^^^^^^^^ reference local 72
//                                          ^^^^ reference semanticdb maven . . kotlin/also().
//                                               ^ definition local 85 6:13
//                                                 display_name it
//                                                 documentation ```kotlin\nit: Set<Index>\n```
                  if (withDropIndices) toDrop.addAll(it)
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withDropIndices)
//                                     ^^^^^^ reference local 81
//                                            ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableSet#addAll().
//                                                   ^^ reference local 85
                  it.log(
//                ^^ reference local 85
//                   ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().
                      "Indices exist in database and not mapped in code on class '$name':",
//                                                                                 ^^^^ reference local 83
                      withLogs
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().(withLogs)
                  )
              }
//            ⌃ enclosing_range_end local 85
          }
          return Pair(toCreate.toList(), toDrop.toList())
//               ^^^^ reference semanticdb maven . . kotlin/Pair#`<init>`().
//                    ^^^^^^^^ reference local 80
//                             ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+10).
//                                       ^^^^^^ reference local 81
//                                              ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+10).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#filterAndLogMissingAndUnmappedIndices().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().
      /** If [withLogs] is `true`, this logs every item in this collection, prefixed by [mainMessage]. */
      @InternalApi
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().[T]
//                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().(mainMessage)
//                                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().(withLogs)
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
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().[T]
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().(mainMessage)
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().(withLogs)
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#log().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapColumnDiffs().
      @OptIn(InternalApi::class)
      private fun Map<Column<*>, ColumnMetadata>.mapColumnDiffs(): Map<Column<*>, ColumnDiff> {
//                                               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapColumnDiffs().
//                                                              display_name mapColumnDiffs
//                                                              documentation ```kotlin\n@OptIn(...) private final fun Map<Column<*>, ColumnMetadata>.mapColumnDiffs(): Map<Column<*>, ColumnDiff>\n```
//                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//        ⌄ enclosing_range_start local 86
          val dialect = currentDialect
//            ^^^^^^^ definition local 86
//                    display_name dialect
//                    documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                   ⌃ enclosing_range_end local 86
//                           ⌄ enclosing_range_start local 87
//                            ⌄ enclosing_range_start local 88
//                                 ⌄ enclosing_range_start local 89
          return mapValues { (col, existingCol) ->
//               ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mapValues().
//                           ^^^^^^^^^^^^^^^^^^ definition local 87
//                                              display_name <destruct>
//                                              documentation ```kotlin\n<destruct>: Map.Entry<Column<*>, ColumnMetadata>\n```
//                            ^^^ reference local 87
//                            ^^^ definition local 88
//                                display_name col
//                                documentation ```kotlin\nlocal val col: Column<*>\n```
//                            ^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                 ^^^^^^^^^^^ reference local 87
//                                 ^^^^^^^^^^^ definition local 89
//                                             display_name existingCol
//                                             documentation ```kotlin\nlocal val existingCol: ColumnMetadata\n```
//                                 ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
//                              ⌃ enclosing_range_end local 88
//                                           ⌃ enclosing_range_end local 89
//                                            ⌃ enclosing_range_end local 87
//            ⌄ enclosing_range_start local 90
              val columnType = col.columnType
//                ^^^^^^^^^^ definition local 90
//                           display_name columnType
//                           documentation ```kotlin\nlocal val columnType: IColumnType<out Any>\n```
//                             ^^^ reference local 88
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                          ⌃ enclosing_range_end local 90
//            ⌄ enclosing_range_start local 91
//                                                                   ⌄ enclosing_range_start local 92
              val columnDbDefaultIsAllowed = col.dbDefaultValue?.let { dialect.isAllowedAsColumnDefault(it) }
//                ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 91
//                                         display_name columnDbDefaultIsAllowed
//                                         documentation ```kotlin\nlocal val columnDbDefaultIsAllowed: Boolean?\n```
//                                           ^^^ reference local 88
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                               ^^^ reference semanticdb maven . . kotlin/let().
//                                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 92
//                                                                                                            display_name it
//                                                                                                            documentation ```kotlin\nit: Expression<out Any?>\n```
//                                                                     ^^^^^^^ reference local 86
//                                                                             ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#isAllowedAsColumnDefault().
//                                                                                                      ^^ reference local 92
//                                                                                                          ⌃ enclosing_range_end local 91
//                                                                                                          ⌃ enclosing_range_end local 92
//            ⌄ enclosing_range_start local 93
              val colNullable = if (columnDbDefaultIsAllowed == false) {
//                ^^^^^^^^^^^ definition local 93
//                            display_name colNullable
//                            documentation ```kotlin\nlocal val colNullable: Boolean\n```
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference local 91
                  true // Treat a disallowed default value as null because that is what Exposed does with it
              } else {
                  columnType.nullable
//                ^^^^^^^^^^ reference local 90
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
              }
//            ⌃ enclosing_range_end local 93
//            ⌄ enclosing_range_start local 94
              val incorrectType = if (currentDialect.supportsColumnTypeChange) isIncorrectType(existingCol, col) else false
//                ^^^^^^^^^^^^^ definition local 94
//                              display_name incorrectType
//                              documentation ```kotlin\nlocal val incorrectType: Boolean\n```
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsColumnTypeChange().
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsColumnTypeChange.
//                                                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectType().
//                                                                                             ^^^^^^^^^^^ reference local 89
//                                                                                                          ^^^ reference local 88
//                                                                                                                        ⌃ enclosing_range_end local 94
//            ⌄ enclosing_range_start local 95
              val incorrectNullability = existingCol.nullable != colNullable
//                ^^^^^^^^^^^^^^^^^^^^ definition local 95
//                                     display_name incorrectNullability
//                                     documentation ```kotlin\nlocal val incorrectNullability: Boolean\n```
//                                       ^^^^^^^^^^^ reference local 89
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getNullable().
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#nullable.
//                                                               ^^^^^^^^^^^ reference local 93
//                                                                         ⌃ enclosing_range_end local 95
//            ⌄ enclosing_range_start local 96
              val incorrectAutoInc = isIncorrectAutoInc(existingCol, col)
//                ^^^^^^^^^^^^^^^^ definition local 96
//                                 display_name incorrectAutoInc
//                                 documentation ```kotlin\nlocal val incorrectAutoInc: Boolean\n```
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().
//                                                      ^^^^^^^^^^^ reference local 89
//                                                                   ^^^ reference local 88
//                                                                      ⌃ enclosing_range_end local 96
              // 'isDatabaseGenerated' property means that the column has generation of the value on the database side,
              // and it could be default value, trigger or something else,
              // but we don't specify the default value on the table object.
              // So it could be better to avoid checking for changes in defaults for such columns, because in the most part
              // of cases we would try to remove existing (in database, but not in table object) default value
//            ⌄ enclosing_range_start local 97
              val incorrectDefaults = if (col.isDatabaseGenerated) false else isIncorrectDefault(dialect, existingCol, col, columnDbDefaultIsAllowed)
//                ^^^^^^^^^^^^^^^^^ definition local 97
//                                  display_name incorrectDefaults
//                                  documentation ```kotlin\nlocal val incorrectDefaults: Boolean\n```
//                                        ^^^ reference local 88
//                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
//                                                                            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().
//                                                                                               ^^^^^^^ reference local 86
//                                                                                                        ^^^^^^^^^^^ reference local 89
//                                                                                                                     ^^^ reference local 88
//                                                                                                                          ^^^^^^^^^^^^^^^^^^^^^^^^ reference local 91
//                                                                                                                                                  ⌃ enclosing_range_end local 97
//            ⌄ enclosing_range_start local 98
              val incorrectCaseSensitiveName = existingCol.name.inProperCase() != col.nameUnquoted().inProperCase()
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 98
//                                           display_name incorrectCaseSensitiveName
//                                           documentation ```kotlin\nlocal val incorrectCaseSensitiveName: Boolean\n```
//                                             ^^^^^^^^^^^ reference local 89
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getName().
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#name.
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
//                                                                                ^^^ reference local 88
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#nameUnquoted().
//                                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
//                                                                                                                ⌃ enclosing_range_end local 98
//            ⌄ enclosing_range_start local 99
              val incorrectSizeOrScale = if (incorrectType) false else isIncorrectSizeOrScale(existingCol, columnType)
//                ^^^^^^^^^^^^^^^^^^^^ definition local 99
//                                     display_name incorrectSizeOrScale
//                                     documentation ```kotlin\nlocal val incorrectSizeOrScale: Boolean\n```
//                                           ^^^^^^^^^^^^^ reference local 94
//                                                                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().
//                                                                                            ^^^^^^^^^^^ reference local 89
//                                                                                                         ^^^^^^^^^^ reference local 90
//                                                                                                                   ⌃ enclosing_range_end local 99
              ColumnDiff(
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#`<init>`().
                  incorrectNullability,
//                ^^^^^^^^^^^^^^^^^^^^ reference local 95
                  incorrectType,
//                ^^^^^^^^^^^^^ reference local 94
                  incorrectAutoInc,
//                ^^^^^^^^^^^^^^^^ reference local 96
                  incorrectDefaults,
//                ^^^^^^^^^^^^^^^^^ reference local 97
                  incorrectCaseSensitiveName,
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 98
                  incorrectSizeOrScale
//                ^^^^^^^^^^^^^^^^^^^^ reference local 99
              )
//                       ⌄ enclosing_range_start local 100
          }.filterValues { it.hasDifferences() }
//          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterValues().
//                       ^^^^^^^^^^^^^^^^^^^^^^^ definition local 100
//                                               display_name it
//                                               documentation ```kotlin\nit: ColumnDiff\n```
//                         ^^ reference local 100
//                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#hasDifferences().
//                                             ⌃ enclosing_range_end local 100
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#mapColumnDiffs().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectType().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectType().(columnMetadata)
//                                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectType().(column)
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
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectType().(columnMetadata)
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectType().(column)
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().
//                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(existingColumn)
//                                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(column)
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
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(existingColumn)
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(column)
//        ⌄ enclosing_range_start local 101
          val isAutoIncColumn = column.columnType.isAutoInc
//            ^^^^^^^^^^^^^^^ definition local 101
//                            display_name isAutoIncColumn
//                            documentation ```kotlin\nlocal val isAutoIncColumn: Boolean\n```
//                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(column)
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
//                                                        ⌃ enclosing_range_end local 101
          return when {
              !existingColumn.autoIncrement && isAutoIncColumn && column.autoIncColumnType?.sequence == null -> true
//            ^ reference semanticdb maven . . kotlin/Boolean#not().
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(existingColumn)
//                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#autoIncrement.
//                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getAutoIncrement().
//                                             ^^^^^^^^^^^^^^^ reference local 101
//                                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(column)
//                                                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//                                                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.
              existingColumn.autoIncrement && isAutoIncColumn && column.autoIncColumnType?.sequence != null -> true
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().(existingColumn)
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#autoIncrement.
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getAutoIncrement().
//                                            ^^^^^^^^^^^^^^^ reference local 101
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
//                                             ^^^^^^^^^^^^^^^ reference local 101
              else -> false
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectAutoInc().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().
      private fun isIncorrectDefault(
//                ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().
//                                   display_name isIncorrectDefault
//                                   documentation ```kotlin\nprivate final fun isIncorrectDefault(dialect: DatabaseDialect, existingColumn: ColumnMetadata, column: Column<*>, columnDbDefaultIsAllowed: Boolean?): Boolean\n```
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(dialect)
          dialect: DatabaseDialect,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(dialect)
//                display_name dialect
//                documentation ```kotlin\ndialect: DatabaseDialect\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(dialect)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(existingColumn)
          existingColumn: ColumnMetadata,
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(existingColumn)
//                       display_name existingColumn
//                       documentation ```kotlin\nexistingColumn: ColumnMetadata\n```
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(existingColumn)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(column)
          column: Column<*>,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(column)
//               display_name column
//               documentation ```kotlin\ncolumn: Column<*>\n```
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(column)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(columnDbDefaultIsAllowed)
          columnDbDefaultIsAllowed: Boolean?
//        ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(columnDbDefaultIsAllowed)
//                                 display_name columnDbDefaultIsAllowed
//                                 documentation ```kotlin\ncolumnDbDefaultIsAllowed: Boolean?\n```
//                                  ^^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(columnDbDefaultIsAllowed)
      ): Boolean {
//       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//        ⌄ enclosing_range_start local 102
          val isExistingColumnDefaultNull = existingColumn.defaultDbValue == null
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 102
//                                        display_name isExistingColumnDefaultNull
//                                        documentation ```kotlin\nlocal val isExistingColumnDefaultNull: Boolean\n```
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(existingColumn)
//                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#defaultDbValue.
//                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getDefaultDbValue().
//                                                                              ⌃ enclosing_range_end local 102
//        ⌄ enclosing_range_start local 103
          val isDefinedColumnDefaultNull = columnDbDefaultIsAllowed != true ||
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 103
//                                       display_name isDefinedColumnDefaultNull
//                                       documentation ```kotlin\nlocal val isDefinedColumnDefaultNull: Boolean\n```
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(columnDbDefaultIsAllowed)
              (column.dbDefaultValue is LiteralOp<*> && (column.dbDefaultValue as? LiteralOp<*>)?.value == null)
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(column)
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(column)
//                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getValue().
//                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#value.
//                                                                                                             ⌃ enclosing_range_end local 103
          return when {
              // Both values are null-like, no DDL update is needed
              isExistingColumnDefaultNull && isDefinedColumnDefaultNull -> false
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 102
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 103
              // Only one of the values is null-like, DDL update is needed
              isExistingColumnDefaultNull != isDefinedColumnDefaultNull -> true
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 102
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 103
              else -> {
//                ⌄ enclosing_range_start local 104
//                                                                    ⌄ enclosing_range_start local 105
                  val columnDefaultValue = column.dbDefaultValue?.let {
//                    ^^^^^^^^^^^^^^^^^^ definition local 104
//                                       display_name columnDefaultValue
//                                       documentation ```kotlin\nlocal val columnDefaultValue: String?\n```
//                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(column)
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                                ^^^ reference semanticdb maven . . kotlin/let().
//                                                                    ^ definition local 105 2:17
//                                                                      display_name it
//                                                                      documentation ```kotlin\nit: Expression<out Any?>\n```
                      dialect.dbDefaultToString(column, it)
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(dialect)
//                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().
//                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(column)
//                                                      ^^ reference local 105
                  }
//                ⌃ enclosing_range_end local 104
//                ⌃ enclosing_range_end local 105
                  existingColumn.defaultDbValue != columnDefaultValue
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().(existingColumn)
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#defaultDbValue.
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getDefaultDbValue().
//                                                 ^^^^^^^^^^^^^^^^^^ reference local 104
              }
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectDefault().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().
      @Suppress("NestedBlockDepth", "ComplexMethod", "LongMethod")
//                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
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
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
//                     ⌄ enclosing_range_start local 106
          return when (exp) {
//                     ^^^ definition local 106
//                         display_name <when-subject>
//                         documentation ```kotlin\nlocal val <when-subject>: Expression<*>\n```
//                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
//                       ⌃ enclosing_range_end local 106
              is LiteralOp<*> -> {
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                      ⌄ enclosing_range_start local 107
                  when (val value = exp.value) {
//                          ^^^^^ definition local 107
//                                display_name value
//                                documentation ```kotlin\nlocal val value: Any?\n```
//                                  ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getValue().
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#value.
//                                          ⌃ enclosing_range_end local 107
//                                        ⌄ enclosing_range_start local 108
                      is Boolean -> when (this) {
//                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                        ^^^^ definition local 108
//                                             display_name <when-subject>
//                                             documentation ```kotlin\nlocal val <when-subject>: DatabaseDialect\n```
//                                           ⌃ enclosing_range_end local 108
                          is MysqlDialect -> if (value) "1" else "0"
//                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                                               ^^^^^ reference local 107
                          is PostgreSQLDialect -> value.toString()
//                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                                                ^^^^^ reference local 107
//                                                      ^^^^^^^^ reference semanticdb maven . . kotlin/Boolean#toString().
                          else -> dataTypeProvider.booleanToStatementString(value)
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanToStatementString().
//                                                                          ^^^^^ reference local 107
                      }
                      is String -> when {
//                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                           ⌄ enclosing_range_start local 109
                          this is PostgreSQLDialect -> when (column.columnType) {
//                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                                           ^^^^^^^^^^^^^^^^^ definition local 109
//                                                                             display_name <when-subject>
//                                                                             documentation ```kotlin\nlocal val <when-subject>: IColumnType<out Any>\n```
//                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                           ⌃ enclosing_range_end local 109
                              is VarCharColumnType -> "'$value'::character varying"
//                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#
//                                                       ^^^^^ reference local 107
                              is TextColumnType -> "'$value'::text"
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#
//                                                    ^^^^^ reference local 107
                              else -> dataTypeProvider.processForDefaultValue(exp)
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                          }
                          this is OracleDialect || h2Mode == H2Dialect.H2CompatibilityMode.Oracle -> when {
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
                              column.columnType is VarCharColumnType && value == "" -> "NULL"
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#
//                                                                      ^^^^^ reference local 107
                              column.columnType is TextColumnType && value == "" -> "NULL"
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#
//                                                                   ^^^^^ reference local 107
                              else -> value
//                                    ^^^^^ reference local 107
                          }
                          else -> value
//                                ^^^^^ reference local 107
                      }
//                                        ⌄ enclosing_range_start local 110
                      is Enum<*> -> when (exp.columnType) {
//                       ^^^^^^^ reference semanticdb maven . . kotlin/Enum#
//                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
//                                        ^^^^^^^^^^^^^^ definition local 110
//                                                       display_name <when-subject>
//                                                       documentation ```kotlin\nlocal val <when-subject>: IColumnType<out Any>\n```
//                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                                     ⌃ enclosing_range_end local 110
//                                                                 ⌄ enclosing_range_start local 111
                          is EnumerationNameColumnType<*> -> when (this) {
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#
//                                                                 ^^^^ definition local 111
//                                                                      display_name <when-subject>
//                                                                      documentation ```kotlin\nlocal val <when-subject>: DatabaseDialect\n```
//                                                                    ⌃ enclosing_range_end local 111
                              is PostgreSQLDialect -> "'${value.name}'::character varying"
//                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                                                        ^^^^^ reference local 107
//                                                              ^^^^ reference semanticdb maven . . kotlin/Enum#getName().
//                                                              ^^^^ reference semanticdb maven . . kotlin/Enum#name.
                              else -> value.name
//                                    ^^^^^ reference local 107
//                                          ^^^^ reference semanticdb maven . . kotlin/Enum#getName().
//                                          ^^^^ reference semanticdb maven . . kotlin/Enum#name.
                          }
                          else -> dataTypeProvider.processForDefaultValue(exp)
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                      }
//                                           ⌄ enclosing_range_start local 112
                      is BigDecimal -> when (this) {
//                       ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
//                                           ^^^^ definition local 112
//                                                display_name <when-subject>
//                                                documentation ```kotlin\nlocal val <when-subject>: DatabaseDialect\n```
//                                              ⌃ enclosing_range_end local 112
                          is MysqlDialect -> value.setScale((exp.columnType as DecimalColumnType).scale).toString()
//                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                                           ^^^^^ reference local 107
//                                                 ^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#setScale().
//                                                           ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
//                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#columnType.
//                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getColumnType().
//                                                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#
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
//                       ^^^^ reference semanticdb maven . . kotlin/Byte#
                          this is PostgreSQLDialect && value < 0 -> "'${dataTypeProvider.processForDefaultValue(exp)}'::integer"
//                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                                                     ^^^^^ reference local 107
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
//                       ^^^^^ reference semanticdb maven . . kotlin/Short#
                          this is PostgreSQLDialect && value < 0 -> "'${dataTypeProvider.processForDefaultValue(exp)}'::integer"
//                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                                                     ^^^^^ reference local 107
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
//                       ^^^ reference semanticdb maven . . kotlin/Int#
                          this is PostgreSQLDialect && value < 0 -> "'${dataTypeProvider.processForDefaultValue(exp)}'::integer"
//                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                                                     ^^^^^ reference local 107
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
//                       ^^^^ reference semanticdb maven . . kotlin/Long#
                          this is SQLServerDialect && (value < 0 || value > Int.MAX_VALUE.toLong()) ->
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#
//                                                     ^^^^^ reference local 107
//                                                           ^ reference semanticdb maven . . kotlin/Long#compareTo(+2).
//                                                                  ^^^^^ reference local 107
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
//                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                                                      ^^^^^ reference local 107
//                                                            ^ reference semanticdb maven . . kotlin/Long#compareTo(+2).
//                                                                   ^^^^^ reference local 107
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
//                       ^^^^ reference semanticdb maven . . kotlin/UInt#
                          this is SQLServerDialect && value > Int.MAX_VALUE.toUInt() -> "${dataTypeProvider.processForDefaultValue(exp)}."
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#
//                                                    ^^^^^ reference local 107
//                                                          ^ reference semanticdb maven . . kotlin/UInt#compareTo(+2).
//                                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                                          ^^^^^^ reference semanticdb maven . . kotlin/toUInt(+2).
//                                                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                                                                                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                                                                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                          this is PostgreSQLDialect && value > Int.MAX_VALUE.toUInt() -> "'${dataTypeProvider.processForDefaultValue(exp)}'::bigint"
//                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                                                     ^^^^^ reference local 107
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
//                       ^^^^^ reference semanticdb maven . . kotlin/ULong#
                          this is SQLServerDialect && value > Int.MAX_VALUE.toULong() -> "${dataTypeProvider.processForDefaultValue(exp)}."
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#
//                                                    ^^^^^ reference local 107
//                                                          ^ reference semanticdb maven . . kotlin/ULong#compareTo(+3).
//                                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                                          ^^^^^^^ reference semanticdb maven . . kotlin/toULong(+2).
//                                                                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                                                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                                                                                           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                                                                  ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
                          this is PostgreSQLDialect && value > Int.MAX_VALUE.toULong() -> "'${dataTypeProvider.processForDefaultValue(exp)}'::bigint"
//                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                                                     ^^^^^ reference local 107
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
//                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#
//                                ⌄ enclosing_range_start local 113
                                  val processed = dataTypeProvider.processForDefaultValue(exp)
//                                    ^^^^^^^^^ definition local 113
//                                              display_name processed
//                                              documentation ```kotlin\nlocal val processed: String\n```
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
//                                                                                           ⌃ enclosing_range_end local 113
//                                      ⌄ enclosing_range_start local 114
                                  when (this) {
//                                      ^^^^ definition local 114
//                                           display_name <when-subject>
//                                           documentation ```kotlin\nlocal val <when-subject>: DatabaseDialect\n```
//                                         ⌃ enclosing_range_end local 114
                                      is PostgreSQLDialect -> {
//                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
                                          if (column.columnType.usesBinaryFormat) {
//                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#getUsesBinaryFormat().
//                                                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JsonColumnMarker#usesBinaryFormat.
                                              processed.replace(Regex("(\"|})(:|,)(\\[|\\{|\")"), "$1$2 $3")
//                                            ^^^^^^^^^ reference local 113
//                                                      ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+2).
//                                                              ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
                                          } else {
                                              processed
//                                            ^^^^^^^^^ reference local 113
                                          }
                                      }
                                      is MariaDBDialect -> processed.trim('\'')
//                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#
//                                                         ^^^^^^^^^ reference local 113
//                                                                   ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
                                      is MysqlDialect -> "_utf8mb4\\'${processed.trim('(', ')', '\'')}\\'"
//                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                                                                     ^^^^^^^^^ reference local 113
//                                                                               ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
                                      else -> when {
                                          processed.startsWith('\'') && processed.endsWith('\'') -> processed.trim('\'')
//                                        ^^^^^^^^^ reference local 113
//                                                  ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith(+2).
//                                                                      ^^^^^^^^^ reference local 113
//                                                                                ^^^^^^^^ reference semanticdb maven . . kotlin/text/endsWith(+1).
//                                                                                                  ^^^^^^^^^ reference local 113
//                                                                                                            ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
                                          else -> processed
//                                                ^^^^^^^^^ reference local 113
                                      }
                                  }
                              }
                              column.columnType is ArrayColumnType<*, *> && this is PostgreSQLDialect -> {
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#
//                                                                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
                                  (value as List<*>)
//                                 ^^^^^ reference local 107
//                                          ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                            ⌄ enclosing_range_start local 115
                                      .takeIf { it.isNotEmpty() }
//                                     ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                            ^^^^^^^^^^^^^^^^^^^ definition local 115
//                                                                display_name it
//                                                                documentation ```kotlin\nit: List<*>\n```
//                                              ^^ reference local 115
//                                                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                                              ⌃ enclosing_range_end local 115
                                      ?.run {
//                                      ^^^ reference semanticdb maven . . kotlin/run(+1).
//                                        ⌄ enclosing_range_start local 116
                                          val delegateColumnType = column.columnType.delegate as IColumnType<Any>
//                                            ^^^^^^^^^^^^^^^^^^ definition local 116
//                                                               display_name delegateColumnType
//                                                               documentation ```kotlin\nlocal val delegateColumnType: IColumnType<Any>\n```
//                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegate.
//                                                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegate().
//                                                                                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                                                                              ⌃ enclosing_range_end local 116
//                                        ⌄ enclosing_range_start local 117
                                          val delegateColumn = (column as Column<Any?>).withColumnType(delegateColumnType)
//                                            ^^^^^^^^^^^^^^ definition local 117
//                                                           display_name delegateColumn
//                                                           documentation ```kotlin\nlocal val delegateColumn: Column<Any?>\n```
//                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(column)
//                                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#withColumnType().
//                                                                                                     ^^^^^^^^^^^^^^^^^^ reference local 116
//                                                                                                                       ⌃ enclosing_range_end local 117
//                                        ⌄ enclosing_range_start local 118
//                                                            ⌄ enclosing_range_start local 119
                                          val processed = map {
//                                            ^^^^^^^^^ definition local 118
//                                                      display_name processed
//                                                      documentation ```kotlin\nlocal val processed: List<String>\n```
//                                                        ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                            ^ definition local 119 6:41
//                                                              display_name it
//                                                              documentation ```kotlin\nit: Any?\n```
                                              if (delegateColumn.columnType is StringColumnType) {
//                                                ^^^^^^^^^^^^^^ reference local 117
//                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StringColumnType#
                                                  "'$it'::text"
//                                                   ^^ reference local 119
                                              } else {
                                                  dbDefaultToString(delegateColumn, delegateColumn.asLiteral(it))
//                                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().
//                                                                  ^^^^^^^^^^^^^^ reference local 117
//                                                                                  ^^^^^^^^^^^^^^ reference local 117
//                                                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().
//                                                                                                           ^^ reference local 119
                                              }
                                          }
//                                        ⌃ enclosing_range_end local 118
//                                        ⌃ enclosing_range_end local 119
                                          "ARRAY$processed"
//                                               ^^^^^^^^^ reference local 118
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
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IDateColumnType#
//                                ⌄ enclosing_range_start local 120
                                  val processed = dataTypeProvider.processForDefaultValue(exp)
//                                    ^^^^^^^^^ definition local 120
//                                              display_name processed
//                                              documentation ```kotlin\nlocal val processed: String\n```
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
//                                                                                           ⌃ enclosing_range_end local 120
                                  if (processed.startsWith('\'') && processed.endsWith('\'')) {
//                                    ^^^^^^^^^ reference local 120
//                                              ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith(+2).
//                                                                  ^^^^^^^^^ reference local 120
//                                                                            ^^^^^^^^ reference semanticdb maven . . kotlin/text/endsWith(+1).
                                      processed.trim('\'')
//                                    ^^^^^^^^^ reference local 120
//                                              ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
                                  } else {
                                      processed
//                                    ^^^^^^^^^ reference local 120
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
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                ⌄ enclosing_range_start local 121
                  var processed = dataTypeProvider.processForDefaultValue(exp)
//                    ^^^^^^^^^ definition local 121
//                              display_name processed
//                              documentation ```kotlin\nlocal var processed: String\n```
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
//                                                                           ⌃ enclosing_range_end local 121
                  if (exp.columnType is IDateColumnType) {
//                    ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#columnType.
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#getColumnType().
//                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IDateColumnType#
                      if (processed.startsWith("CURRENT_TIMESTAMP") || processed == "GETDATE()") {
//                        ^^^^^^^^^ reference local 121
//                                  ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                                     ^^^^^^^^^ reference local 121
//                              ⌄ enclosing_range_start local 122
                          when (this) {
//                              ^^^^ definition local 122
//                                   display_name <when-subject>
//                                   documentation ```kotlin\nlocal val <when-subject>: DatabaseDialect\n```
//                                 ⌃ enclosing_range_end local 122
                              is SQLServerDialect -> processed = "getdate"
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#
//                                                   ^^^^^^^^^ reference local 121
                              is MariaDBDialect -> processed = processed.lowercase()
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#
//                                                 ^^^^^^^^^ reference local 121
//                                                             ^^^^^^^^^ reference local 121
//                                                                       ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
                          }
                      }
                      if (processed.trim('(').startsWith("CURRENT_DATE")) {
//                        ^^^^^^^^^ reference local 121
//                                  ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
//                                            ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                              ⌄ enclosing_range_start local 123
                          when (this) {
//                              ^^^^ definition local 123
//                                   display_name <when-subject>
//                                   documentation ```kotlin\nlocal val <when-subject>: DatabaseDialect\n```
//                                 ⌃ enclosing_range_end local 123
                              is MysqlDialect -> processed = "curdate()"
//                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                                               ^^^^^^^^^ reference local 121
                          }
                      }
                  }
                  processed
//                ^^^^^^^^^ reference local 121
              }
              else -> dataTypeProvider.processForDefaultValue(exp)
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().(exp)
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#dbDefaultToString().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnMeta)
//                                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnType)
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
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnMeta)
//                                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnType)
          // ColumnMetadata.scale can only be non-null if ColumnMetadata.size is non-null
          if (columnMeta.size == null) return false
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnMeta)
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getSize().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#size.
//        ⌄ enclosing_range_start local 124
          val dialect = currentDialect
//            ^^^^^^^ definition local 124
//                    display_name dialect
//                    documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                   ⌃ enclosing_range_end local 124
//                     ⌄ enclosing_range_start local 125
          return when (columnType) {
//                     ^^^^^^^^^^ definition local 125
//                                display_name <when-subject>
//                                documentation ```kotlin\nlocal val <when-subject>: IColumnType<*>\n```
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnType)
//                              ⌃ enclosing_range_end local 125
              is DecimalColumnType -> columnType.precision != columnMeta.size || columnType.scale != columnMeta.scale
//               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#
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
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnType)
//                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#colLength.
//                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#getColLength().
//                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnMeta)
//                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getSize().
//                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#size.
              is VarCharColumnType -> columnType.colLength != columnMeta.size
//               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnType)
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#colLength.
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#getColLength().
//                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().(columnMeta)
//                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#getSize().
//                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/ColumnMetadata#size.
              is BinaryColumnType -> if (dialect is PostgreSQLDialect || dialect.h2Mode == H2Dialect.H2CompatibilityMode.PostgreSQL) {
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#
//                                       ^^^^^^^ reference local 124
//                                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                                                                       ^^^^^^^ reference local 124
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#isIncorrectSizeOrScale().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeyDdl().
//                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeyDdl().(missingColumns)
//                                                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeyDdl().(existingKey)
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
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeyDdl().(missingColumns)
//                                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeyDdl().(existingKey)
//        ⌄ enclosing_range_start local 126
//                                             ⌄ enclosing_range_start local 127
          val missingPK = primaryKey?.takeIf { pk ->
//            ^^^^^^^^^ definition local 126
//                      display_name missingPK
//                      documentation ```kotlin\nlocal val missingPK: Table.PrimaryKey?\n```
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                                    ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                             ^^ definition local 127
//                                                display_name pk
//                                                documentation ```kotlin\npk: Table.PrimaryKey\n```
//                                              ⌃ enclosing_range_end local 127
//                            ⌄ enclosing_range_start local 128
              pk.columns.none { it in missingColumns }
//            ^^ reference local 127
//               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                       ^^^^ reference semanticdb maven . . kotlin/collections/none(+9).
//                            ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 128
//                                                     display_name it
//                                                     documentation ```kotlin\nit: Column<*>\n```
//                              ^^ reference local 128
//                                 ^^ reference semanticdb maven . . kotlin/collections/List#contains().
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeyDdl().(missingColumns)
//                                                   ⌃ enclosing_range_end local 128
          }
//        ⌃ enclosing_range_end local 126
          if (missingPK == null || existingKey != null) return null
//            ^^^^^^^^^ reference local 126
//                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeyDdl().(existingKey)
//        ⌄ enclosing_range_start local 129
//                                                  ⌄ enclosing_range_start local 130
          val missingPKName = missingPK.name.takeIf { isCustomPKNameDefined() }
//            ^^^^^^^^^^^^^ definition local 129
//                          display_name missingPKName
//                          documentation ```kotlin\nlocal val missingPKName: String?\n```
//                            ^^^^^^^^^ reference local 126
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getName().
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#name.
//                                           ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 130
//                                                                              display_name it
//                                                                              documentation ```kotlin\nit: String\n```
//                                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#isCustomPKNameDefined().
//                                                                            ⌃ enclosing_range_end local 129
//                                                                            ⌃ enclosing_range_end local 130
          return currentDialect.addPrimaryKey(this, missingPKName, pkColumns = missingPK.columns)
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#addPrimaryKey().
//                                                  ^^^^^^^^^^^^^ reference local 129
//                                                                             ^^^^^^^^^ reference local 126
//                                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#primaryKeyDdl().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().
      /** Runs the provided [block] and returns the result. If [withLogs] is `true`, logs the time taken in milliseconds. */
      @InternalApi
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().[R]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(message)
//                                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(withLogs)
//                                                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(block)
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
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().[R]
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(message)
//                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(withLogs)
//                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(block)
          return if (withLogs) {
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(withLogs)
//            ⌄ enclosing_range_start local 131
              val start = System.currentTimeMillis()
//                ^^^^^ definition local 131
//                      display_name start
//                      documentation ```kotlin\nlocal val start: Long\n```
//                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/System#currentTimeMillis().
//                                                 ⌃ enclosing_range_end local 131
//            ⌄ enclosing_range_start local 132
              val answer = block()
//                ^^^^^^ definition local 132
//                       display_name answer
//                       documentation ```kotlin\nlocal val answer: R\n```
//                         ^^^^^ reference semanticdb maven . . kotlin/Function0#invoke().
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(block)
//                               ⌃ enclosing_range_end local 132
              exposedLogger.info(message + " took " + (System.currentTimeMillis() - start) + "ms")
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#info().
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(message)
//                                       ^ reference semanticdb maven . . kotlin/String#plus().
//                                                  ^ reference semanticdb maven . . kotlin/String#plus().
//                                                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/System#currentTimeMillis().
//                                                                                ^ reference semanticdb maven . . kotlin/Long#minus(+3).
//                                                                                  ^^^^^ reference local 131
//                                                                                         ^ reference semanticdb maven . . kotlin/String#plus().
              answer
//            ^^^^^^ reference local 132
          } else {
              block()
//            ^^^^^ reference semanticdb maven . . kotlin/Function0#invoke().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().(block)
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#logTimeSpent().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#
      // TODO extract tp separate file & move this top-level internal class
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#`<init>`().
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#`<init>`().(tables)
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#tables.
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getTables().
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
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#`<init>`().(tables)
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#tables.
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getTables().
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#`<init>`().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#graph.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getGraph().
//                                           ⌄ enclosing_range_start local 133
          val graph = fetchAllTables().let { tables ->
//            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getGraph().
//                  display_name graph
//                  documentation ```kotlin\npublic get(): Map<Table, List<Table>>\n```
//            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#graph.
//                  display_name graph
//                  documentation ```kotlin\npublic final val graph: Map<Table, List<Table>>\n```
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#fetchAllTables().
//                                     ^^^ reference semanticdb maven . . kotlin/let().
//                                           ^^^^^^ definition local 133
//                                                  display_name tables
//                                                  documentation ```kotlin\ntables: {kotlin/collections/HashSet<org/jetbrains/exposed/v1/core/Table>=} HashSet<Table>\n```
//                                                ⌃ enclosing_range_end local 133
              if (tables.isEmpty()) {
//                ^^^^^^ reference local 133
//                       ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#isEmpty().
                  emptyMap()
//                ^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyMap().
              } else {
//                                       ⌄ enclosing_range_start local 134
                  tables.associateWith { t ->
//                ^^^^^^ reference local 133
//                       ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/associateWith(+9).
//                                       ^ definition local 134
//                                         display_name t
//                                         documentation ```kotlin\nt: Table\n```
//                                       ⌃ enclosing_range_end local 134
//                                      ⌄ enclosing_range_start local 135
                      t.foreignKeys.map { it.targetTable }
//                    ^ reference local 134
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKeys.
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getForeignKeys().
//                                  ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                      ^^^^^^^^^^^^^^^^^^ definition local 135
//                                                         display_name it
//                                                         documentation ```kotlin\nit: ForeignKeyConstraint\n```
//                                        ^^ reference local 135
//                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTable().
//                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTable.
//                                                       ⌃ enclosing_range_end local 135
                  }
              }
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#graph.
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getGraph().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#fetchAllTables().
          private fun fetchAllTables(): HashSet<Table> {
//                    ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#fetchAllTables().
//                                   display_name fetchAllTables
//                                   documentation ```kotlin\nprivate final fun fetchAllTables(): {kotlin/collections/HashSet<org/jetbrains/exposed/v1/core/Table>=} HashSet<Table>\n```
//                                      ^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#
//            ⌄ enclosing_range_start local 136
              val result = HashSet<Table>()
//                ^^^^^^ definition local 136
//                       display_name result
//                       documentation ```kotlin\nlocal val result: {kotlin/collections/HashSet<org/jetbrains/exposed/v1/core/Table>=} HashSet<Table>\n```
//                         ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#`<init>`().
//                                        ⌃ enclosing_range_end local 136
//            ⌄ enclosing_range_start local 137
//                           ⌄ enclosing_range_start local 138
              fun parseTable(table: Table) {
//                ^^^^^^^^^^ definition local 137
//                           display_name parseTable
//                           documentation ```kotlin\nlocal final fun parseTable(table: Table): Unit\n```
//                           ^^^^^ definition local 138
//                                 display_name table
//                                 documentation ```kotlin\ntable: Table\n```
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                      ⌃ enclosing_range_end local 138
                  if (result.add(table)) {
//                    ^^^^^^ reference local 136
//                           ^^^ reference semanticdb maven jdk 11 java/util/HashSet#add().
//                               ^^^^^ reference local 138
//                                          ⌄ enclosing_range_start local 139
                      table.foreignKeys.map { it.targetTable }.forEach(::parseTable)
//                    ^^^^^ reference local 138
//                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKeys.
//                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getForeignKeys().
//                                      ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                          ^^^^^^^^^^^^^^^^^^ definition local 139
//                                                             display_name it
//                                                             documentation ```kotlin\nit: ForeignKeyConstraint\n```
//                                            ^^ reference local 139
//                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTable().
//                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTable.
//                                                             ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                                                       ^^^^^^^^^^ reference local 137
//                                                           ⌃ enclosing_range_end local 139
                  }
              }
//            ⌃ enclosing_range_end local 137
              tables.forEach(::parseTable)
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getTables().
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#tables.
//                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                             ^^^^^^^^^^ reference local 137
              return result
//                   ^^^^^^ reference local 136
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#fetchAllTables().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#sorted().
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
//            ⌄ enclosing_range_start local 140
              val visited = mutableSetOf<Table>()
//                ^^^^^^^ definition local 140
//                        display_name visited
//                        documentation ```kotlin\nlocal val visited: MutableSet<Table>\n```
//                          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableSetOf().
//                                              ⌃ enclosing_range_end local 140
//            ⌄ enclosing_range_start local 141
              val result = arrayListOf<Table>()
//                ^^^^^^ definition local 141
//                       display_name result
//                       documentation ```kotlin\nlocal val result: {kotlin/collections/ArrayList<org/jetbrains/exposed/v1/core/Table>=} ArrayList<Table>\n```
//                         ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/arrayListOf().
//                                            ⌃ enclosing_range_end local 141
//            ⌄ enclosing_range_start local 142
//                         ⌄ enclosing_range_start local 143
              fun traverse(table: Table) {
//                ^^^^^^^^ definition local 142
//                         display_name traverse
//                         documentation ```kotlin\nlocal final fun traverse(table: Table): Unit\n```
//                         ^^^^^ definition local 143
//                               display_name table
//                               documentation ```kotlin\ntable: Table\n```
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                    ⌃ enclosing_range_end local 143
                  if (table !in visited) {
//                    ^^^^^ reference local 143
//                          ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                          ^^^ reference semanticdb maven . . kotlin/collections/MutableSet#contains().
//                              ^^^^^^^ reference local 140
                      visited += table
//                    ^^^^^^^ reference local 140
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/plusAssign().
//                               ^^^^^ reference local 143
//                                                    ⌄ enclosing_range_start local 144
                      graph.getValue(table).forEach { t ->
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getGraph().
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#graph.
//                          ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getValue().
//                                   ^^^^^ reference local 143
//                                          ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                                    ^ definition local 144
//                                                      display_name t
//                                                      documentation ```kotlin\nt: Table\n```
//                                                    ⌃ enclosing_range_end local 144
                          if (t !in visited) {
//                            ^ reference local 144
//                              ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                              ^^^ reference semanticdb maven . . kotlin/collections/MutableSet#contains().
//                                  ^^^^^^^ reference local 140
                              traverse(t)
//                            ^^^^^^^^ reference local 142
//                                     ^ reference local 144
                          }
                      }
                      result += table
//                    ^^^^^^ reference local 141
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/plusAssign().
//                              ^^^^^ reference local 143
                  }
              }
//            ⌃ enclosing_range_end local 142
              tables.forEach(::traverse)
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getTables().
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#tables.
//                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                             ^^^^^^^^ reference local 142
              return result
//                   ^^^^^^ reference local 141
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#sorted().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#hasCycle().
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
//            ⌄ enclosing_range_start local 145
              val visited = mutableSetOf<Table>()
//                ^^^^^^^ definition local 145
//                        display_name visited
//                        documentation ```kotlin\nlocal val visited: MutableSet<Table>\n```
//                          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableSetOf().
//                                              ⌃ enclosing_range_end local 145
//            ⌄ enclosing_range_start local 146
              val recursion = mutableSetOf<Table>()
//                ^^^^^^^^^ definition local 146
//                          display_name recursion
//                          documentation ```kotlin\nlocal val recursion: MutableSet<Table>\n```
//                            ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableSetOf().
//                                                ⌃ enclosing_range_end local 146
//            ⌄ enclosing_range_start local 147
              val sortedTables = sorted()
//                ^^^^^^^^^^^^ definition local 147
//                             display_name sortedTables
//                             documentation ```kotlin\nlocal val sortedTables: List<Table>\n```
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#sorted().
//                                      ⌃ enclosing_range_end local 147
//            ⌄ enclosing_range_start local 148
//                         ⌄ enclosing_range_start local 149
              fun traverse(table: Table): Boolean {
//                ^^^^^^^^ definition local 148
//                         display_name traverse
//                         documentation ```kotlin\nlocal final fun traverse(table: Table): Boolean\n```
//                         ^^^^^ definition local 149
//                               display_name table
//                               documentation ```kotlin\ntable: Table\n```
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                        ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                    ⌃ enclosing_range_end local 149
                  if (table in recursion) return true
//                    ^^^^^ reference local 149
//                          ^^ reference semanticdb maven . . kotlin/collections/MutableSet#contains().
//                             ^^^^^^^^^ reference local 146
                  if (table in visited) return false
//                    ^^^^^ reference local 149
//                          ^^ reference semanticdb maven . . kotlin/collections/MutableSet#contains().
//                             ^^^^^^^ reference local 145
                  recursion += table
//                ^^^^^^^^^ reference local 146
//                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/plusAssign().
//                             ^^^^^ reference local 149
                  visited += table
//                ^^^^^^^ reference local 145
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/plusAssign().
//                           ^^^^^ reference local 149
//                                              ⌄ enclosing_range_start local 150
                  return if (graph[table]!!.any { traverse(it) }) {
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#getGraph().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#graph.
//                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                 ^^^^^ reference local 149
//                                          ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                                              ^^^^^^^^^^^^^^^^ definition local 150
//                                                               display_name it
//                                                               documentation ```kotlin\nit: Table\n```
//                                                ^^^^^^^^ reference local 148
//                                                         ^^ reference local 150
//                                                             ⌃ enclosing_range_end local 150
                      true
                  } else {
                      recursion -= table
//                    ^^^^^^^^^ reference local 146
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/minusAssign().
//                                 ^^^^^ reference local 149
                      false
                  }
              }
//            ⌃ enclosing_range_end local 148
//                                    ⌄ enclosing_range_start local 151
              return sortedTables.any { traverse(it) }
//                   ^^^^^^^^^^^^ reference local 147
//                                ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                                    ^^^^^^^^^^^^^^^^ definition local 151
//                                                     display_name it
//                                                     documentation ```kotlin\nit: Table\n```
//                                      ^^^^^^^^ reference local 148
//                                               ^^ reference local 151
//                                                   ⌃ enclosing_range_end local 151
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#hasCycle().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#TableDepthGraph#
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SchemaUtilityApi#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#`<init>`().
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
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#checkCycle().
      /** Checks whether any of the [tables] have a sequence of foreign key constraints that cycle back to them. */
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#checkCycle().(tables)
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
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#checkCycle().(tables)
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#checkCycle().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#sortTablesByReferences().
      /** Returns a list of [tables] sorted according to the targets of their foreign key constraints, if any exist. */
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#sortTablesByReferences().(tables)
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
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#sortTablesByReferences().(tables)
//                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#sortTablesByReferences().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#`<init>`().
