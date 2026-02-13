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
  
  /**
   * The base implementation of SQL merge command that is used by statements like [MergeSelectStatement], [MergeTableStatement]
   *
   * @property table The destination [Table] where records will be merged into.
   */
  abstract class MergeStatement(val table: Table) : Statement<Int>(
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#
//                              display_name MergeStatement
//                              documentation ```kotlin\npublic abstract class MergeStatement : Statement<Int>\n```\n\n----\n\n\n The base implementation of SQL merge command that is used by statements like [MergeSelectStatement], [MergeTableStatement]\n\n @property table The destination [Table] where records will be merged into.\n
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#`<init>`().
//                              display_name MergeStatement
//                              documentation ```kotlin\npublic constructor(table: Table): MergeStatement\n```
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#`<init>`().(table)
//                                        display_name table
//                                        documentation ```kotlin\ntable: Table\n```
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#`<init>`().(table)
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#getTable().
//                                        display_name table
//                                        documentation ```kotlin\npublic get(): Table\n```
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#table.
//                                        display_name table
//                                        documentation ```kotlin\npublic final val table: Table\n```
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
      StatementType.MERGE, listOf(table)
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#MERGE.
//                         ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#`<init>`().(table)
  ) {
      protected val clauses = mutableListOf<Clause>()
//                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#clauses.
//                          display_name clauses
//                          documentation ```kotlin\nprotected final val clauses: MutableList<MergeStatement.Clause>\n```
//                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#getClauses().
//                          display_name clauses
//                          documentation ```kotlin\nprotected get(): MutableList<MergeStatement.Clause>\n```
//                            ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
  
      override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>> {
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#arguments().
//                           display_name arguments
//                           documentation ```kotlin\npublic open override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>>\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#arguments().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#arguments().
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
          val result = QueryBuilder(true).run {
//            ^^^^^^ definition local 0
//                   display_name result
//                   documentation ```kotlin\nlocal val result: List<List<Pair<IColumnType<*>, Any?>>>\n```
//                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                                        ^^^ reference semanticdb maven . . kotlin/run(+1).
              clauses.flatMap { it.arguments }.forEach { (column, value) ->
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#clauses.
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#getClauses().
//                    ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap(+10).
//                            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                             display_name it
//                                             documentation ```kotlin\nit: MergeStatement.Clause\n```
//                              ^^ reference semanticdb maven . . (it)
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#arguments.
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getArguments().
//                                             ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                                       ^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                                       display_name <destruct>
//                                                                       documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                                        ^^^^^^ definition local 1
//                                                               display_name column
//                                                               documentation ```kotlin\nlocal val column: Column<*>\n```
//                                                        ^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                        ^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                                ^^^^^ definition local 2
//                                                                      display_name value
//                                                                      documentation ```kotlin\nlocal val value: Any?\n```
//                                                                ^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                                ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
                  if (value !is Column<*> && value !is Expression<*>) {
//                    ^^^^^ reference local 2
//                                           ^^^^^ reference local 2
                      registerArgument(column, value)
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                                     ^^^^^^ reference local 1
//                                             ^^^^^ reference local 2
                  }
              }
              if (args.isNotEmpty()) listOf(args) else emptyList()
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#args.
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getArgs().
//                     ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                   ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#args.
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getArgs().
//                                                     ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
          }
          return result
//               ^^^^^^ reference local 0
      }
  
      /**
       * Defines an insert operation to be performed when there is no matching record in the destination table.
       *
       * @param overridingUserValue Postgres only. Indicates whether to use the `OVERRIDING USER VALUE` clause for the insert.
       * @param overridingSystemValue Postgres only. Indicates whether to use the `OVERRIDING SYSTEM VALUE` clause for the insert.
       * @param and An additional optional condition [Op<Boolean>] to refine when the insert should take place.
       * @param body A lambda to configure the [InsertStatement] in which the required columns and corresponding
       * values are specified for the insert operation.
       */
      fun whenNotMatchedInsert(
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenNotMatchedInsert().
//                             display_name whenNotMatchedInsert
//                             documentation ```kotlin\npublic final fun whenNotMatchedInsert(and: Op<Boolean>? = ..., overridingUserValue: Boolean = ..., overridingSystemValue: Boolean = ..., body: (InsertStatement<Int>) -> Unit): Unit\n```\n\n----\n\n\n Defines an insert operation to be performed when there is no matching record in the destination table.\n\n @param overridingUserValue Postgres only. Indicates whether to use the `OVERRIDING USER VALUE` clause for the insert.\n @param overridingSystemValue Postgres only. Indicates whether to use the `OVERRIDING SYSTEM VALUE` clause for the insert.\n @param and An additional optional condition [Op<Boolean>] to refine when the insert should take place.\n @param body A lambda to configure the [InsertStatement] in which the required columns and corresponding\n values are specified for the insert operation.\n
          and: Op<Boolean>? = null,
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenNotMatchedInsert().(and)
//            display_name and
//            documentation ```kotlin\nand: Op<Boolean>? = ...\n```
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          overridingUserValue: Boolean = false,
//        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenNotMatchedInsert().(overridingUserValue)
//                            display_name overridingUserValue
//                            documentation ```kotlin\noverridingUserValue: Boolean = ...\n```
//                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          overridingSystemValue: Boolean = false,
//        ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenNotMatchedInsert().(overridingSystemValue)
//                              display_name overridingSystemValue
//                              documentation ```kotlin\noverridingSystemValue: Boolean = ...\n```
//                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          body: (InsertStatement<Int>) -> Unit
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenNotMatchedInsert().(body)
//             display_name body
//             documentation ```kotlin\nbody: (InsertStatement<Int>) -> Unit\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      ) {
          val arguments = InsertStatement<Int>(table).apply(body).arguments!!.first()
//            ^^^^^^^^^ definition local 3
//                      display_name arguments
//                      documentation ```kotlin\nlocal val arguments: List<Pair<Column<*>, Any?>>\n```
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#`<init>`().
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#getTable().
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#table.
//                                                    ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenNotMatchedInsert().(body)
//                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#arguments.
//                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#getArguments().
//                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#setArguments().
//                                                                            ^^^^^ reference semanticdb maven . . kotlin/collections/first(+19).
          clauses.add(
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#clauses.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#getClauses().
//                ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
              Clause(ClauseCondition.NOT_MATCHED, ClauseAction.INSERT, arguments, and, null, overridingSystemValue, overridingUserValue)
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseCondition#NOT_MATCHED.
//                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#INSERT.
//                                                                     ^^^^^^^^^ reference local 3
//                                                                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenNotMatchedInsert().(and)
//                                                                                           ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenNotMatchedInsert().(overridingSystemValue)
//                                                                                                                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenNotMatchedInsert().(overridingUserValue)
          )
      }
  
      /**
       * Defines an update operation to be executed when a matching record is found in the destination table.
       *
       * @param and An additional optional condition [Op<Boolean>] to specify when the update should occur.
       * @param deleteWhere Applicable only to Oracle SQL. A condition [Op<Boolean>] used to indicate condition of row deletion.
       * Oracle SQL does not support separate "delete" clause.
       * @param body A lambda to define the [UpdateStatement] which sets the values of columns in the matching
       * records.
       */
      fun whenMatchedUpdate(and: Op<Boolean>? = null, deleteWhere: Op<Boolean>? = null, body: (UpdateStatement) -> Unit) {
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenMatchedUpdate().
//                          display_name whenMatchedUpdate
//                          documentation ```kotlin\npublic final fun whenMatchedUpdate(and: Op<Boolean>? = ..., deleteWhere: Op<Boolean>? = ..., body: (UpdateStatement) -> Unit): Unit\n```\n\n----\n\n\n Defines an update operation to be executed when a matching record is found in the destination table.\n\n @param and An additional optional condition [Op<Boolean>] to specify when the update should occur.\n @param deleteWhere Applicable only to Oracle SQL. A condition [Op<Boolean>] used to indicate condition of row deletion.\n Oracle SQL does not support separate "delete" clause.\n @param body A lambda to define the [UpdateStatement] which sets the values of columns in the matching\n records.\n
//                          ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenMatchedUpdate().(and)
//                              display_name and
//                              documentation ```kotlin\nand: Op<Boolean>? = ...\n```
//                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenMatchedUpdate().(deleteWhere)
//                                                                display_name deleteWhere
//                                                                documentation ```kotlin\ndeleteWhere: Op<Boolean>? = ...\n```
//                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                                                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenMatchedUpdate().(body)
//                                                                                           display_name body
//                                                                                           documentation ```kotlin\nbody: (UpdateStatement) -> Unit\n```
//                                                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
          val arguments = UpdateStatement(table, limit = 1).apply(body).firstDataSet
//            ^^^^^^^^^ definition local 4
//                      display_name arguments
//                      documentation ```kotlin\nlocal val arguments: List<Pair<Column<*>, Any?>>\n```
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#`<init>`().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#getTable().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#table.
//                                                          ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenMatchedUpdate().(body)
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#firstDataSet.
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#getFirstDataSet().
          clauses.add(Clause(ClauseCondition.MATCHED, ClauseAction.UPDATE, arguments, and, deleteWhere))
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#clauses.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#getClauses().
//                ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseCondition#MATCHED.
//                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#UPDATE.
//                                                                         ^^^^^^^^^ reference local 4
//                                                                                    ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenMatchedUpdate().(and)
//                                                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenMatchedUpdate().(deleteWhere)
      }
  
      /**
       * Specifies a delete operation to be executed when a matching record is found in the destination table.
       *
       * @param and An additional optional condition [Op<Boolean>] to determine when the delete operation
       * should be performed.
       */
      fun whenMatchedDelete(and: Op<Boolean>? = null) {
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenMatchedDelete().
//                          display_name whenMatchedDelete
//                          documentation ```kotlin\npublic final fun whenMatchedDelete(and: Op<Boolean>? = ...): Unit\n```\n\n----\n\n\n Specifies a delete operation to be executed when a matching record is found in the destination table.\n\n @param and An additional optional condition [Op<Boolean>] to determine when the delete operation\n should be performed.\n
//                          ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenMatchedDelete().(and)
//                              display_name and
//                              documentation ```kotlin\nand: Op<Boolean>? = ...\n```
//                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          clauses.add(Clause(ClauseCondition.MATCHED, ClauseAction.DELETE, emptyList(), and))
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#clauses.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#getClauses().
//                ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseCondition#MATCHED.
//                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#DELETE.
//                                                                         ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
//                                                                                      ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenMatchedDelete().(and)
      }
  
      /**
       * Postgres only. Specifies that no operation should be performed when a matching record is found in the destination table.
       *
       * @param and An additional optional condition [Op<Boolean>] to determine when the do-nothing operation
       * should be performed.
       */
      fun whenMatchedDoNothing(and: Op<Boolean>? = null) {
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenMatchedDoNothing().
//                             display_name whenMatchedDoNothing
//                             documentation ```kotlin\npublic final fun whenMatchedDoNothing(and: Op<Boolean>? = ...): Unit\n```\n\n----\n\n\n Postgres only. Specifies that no operation should be performed when a matching record is found in the destination table.\n\n @param and An additional optional condition [Op<Boolean>] to determine when the do-nothing operation\n should be performed.\n
//                             ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenMatchedDoNothing().(and)
//                                 display_name and
//                                 documentation ```kotlin\nand: Op<Boolean>? = ...\n```
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          clauses.add(Clause(ClauseCondition.MATCHED, ClauseAction.DO_NOTHING, emptyList(), and))
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#clauses.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#getClauses().
//                ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseCondition#MATCHED.
//                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#DO_NOTHING.
//                                                                             ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
//                                                                                          ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenMatchedDoNothing().(and)
      }
  
      /**
       * Postgres only. Specifies that no operation should be performed when no matching record is found in the destination table.
       *
       * @param and An additional optional condition [Op<Boolean>] to determine when the do-nothing operation
       * should be performed.
       */
      fun whenNotMatchedDoNothing(and: Op<Boolean>? = null) {
//        ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenNotMatchedDoNothing().
//                                display_name whenNotMatchedDoNothing
//                                documentation ```kotlin\npublic final fun whenNotMatchedDoNothing(and: Op<Boolean>? = ...): Unit\n```\n\n----\n\n\n Postgres only. Specifies that no operation should be performed when no matching record is found in the destination table.\n\n @param and An additional optional condition [Op<Boolean>] to determine when the do-nothing operation\n should be performed.\n
//                                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenNotMatchedDoNothing().(and)
//                                    display_name and
//                                    documentation ```kotlin\nand: Op<Boolean>? = ...\n```
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          clauses.add(Clause(ClauseCondition.NOT_MATCHED, ClauseAction.DO_NOTHING, emptyList(), and))
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#clauses.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#getClauses().
//                ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().
//                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseCondition#NOT_MATCHED.
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#DO_NOTHING.
//                                                                                 ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
//                                                                                              ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#whenNotMatchedDoNothing().(and)
      }
  
      data class Clause(
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#
//                      display_name Clause
//                      documentation ```kotlin\npublic final data class Clause : Any\n```\n\n----\n\n deleteWhere is applicable only to Oracle SQL database which has no dedicated "when delete" clause
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().
//                      display_name Clause
//                      documentation ```kotlin\npublic constructor(type: MergeStatement.ClauseCondition, action: MergeStatement.ClauseAction, arguments: List<Pair<Column<*>, Any?>>, and: Op<Boolean>?, deleteWhere: Op<Boolean>? = ..., overridingSystemValue: Boolean = ..., overridingUserValue: Boolean = ...): MergeStatement.Clause\n```\n\n----\n\n deleteWhere is applicable only to Oracle SQL database which has no dedicated "when delete" clause
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#copy().
//                      display_name copy
//                      documentation ```kotlin\npublic final fun copy(type: MergeStatement.ClauseCondition = ..., action: MergeStatement.ClauseAction = ..., arguments: List<Pair<Column<*>, Any?>> = ..., and: Op<Boolean>? = ..., deleteWhere: Op<Boolean>? = ..., overridingSystemValue: Boolean = ..., overridingUserValue: Boolean = ...): MergeStatement.Clause\n\n```\n\n----\n\n deleteWhere is applicable only to Oracle SQL database which has no dedicated "when delete" clause
          val type: ClauseCondition,
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().(type)
//                 display_name type
//                 documentation ```kotlin\ntype: MergeStatement.ClauseCondition\n```
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().(type)
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#component1().
//                 display_name component1
//                 documentation ```kotlin\npublic final operator fun component1(): MergeStatement.ClauseCondition\n\n```
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#copy().(type)
//                 display_name type
//                 documentation ```kotlin\ntype: MergeStatement.ClauseCondition = ...\n```
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getType().
//                 display_name type
//                 documentation ```kotlin\npublic get(): MergeStatement.ClauseCondition\n```
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getType().
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#type.
//                 display_name type
//                 documentation ```kotlin\npublic final val type: MergeStatement.ClauseCondition\n```
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#type.
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseCondition#
          val action: ClauseAction,
//            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().(action)
//                   display_name action
//                   documentation ```kotlin\naction: MergeStatement.ClauseAction\n```
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().(action)
//            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#action.
//                   display_name action
//                   documentation ```kotlin\npublic final val action: MergeStatement.ClauseAction\n```
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#action.
//            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#component2().
//                   display_name component2
//                   documentation ```kotlin\npublic final operator fun component2(): MergeStatement.ClauseAction\n\n```
//            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#copy().(action)
//                   display_name action
//                   documentation ```kotlin\naction: MergeStatement.ClauseAction = ...\n```
//            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAction().
//                   display_name action
//                   documentation ```kotlin\npublic get(): MergeStatement.ClauseAction\n```
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAction().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#
          val arguments: List<Pair<Column<*>, Any?>>,
//            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().(arguments)
//                      display_name arguments
//                      documentation ```kotlin\narguments: List<Pair<Column<*>, Any?>>\n```
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().(arguments)
//            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#arguments.
//                      display_name arguments
//                      documentation ```kotlin\npublic final val arguments: List<Pair<Column<*>, Any?>>\n```
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#arguments.
//            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#component3().
//                      display_name component3
//                      documentation ```kotlin\npublic final operator fun component3(): List<Pair<Column<*>, Any?>>\n\n```
//            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#copy().(arguments)
//                      display_name arguments
//                      documentation ```kotlin\narguments: List<Pair<Column<*>, Any?>> = ...\n```
//            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getArguments().
//                      display_name arguments
//                      documentation ```kotlin\npublic get(): List<Pair<Column<*>, Any?>>\n```
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getArguments().
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          val and: Op<Boolean>?,
//            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().(and)
//                display_name and
//                documentation ```kotlin\nand: Op<Boolean>?\n```
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().(and)
//            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#and.
//                display_name and
//                documentation ```kotlin\npublic final val and: Op<Boolean>?\n```
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#and.
//            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#component4().
//                display_name component4
//                documentation ```kotlin\npublic final operator fun component4(): Op<Boolean>?\n\n```
//            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#copy().(and)
//                display_name and
//                documentation ```kotlin\nand: Op<Boolean>? = ...\n```
//            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAnd().
//                display_name and
//                documentation ```kotlin\npublic get(): Op<Boolean>?\n```
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAnd().
//                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          /** deleteWhere is applicable only to Oracle SQL database which has no dedicated "when delete" clause */
          val deleteWhere: Op<Boolean>? = null,
//            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().(deleteWhere)
//                        display_name deleteWhere
//                        documentation ```kotlin\ndeleteWhere: Op<Boolean>? = ...\n```\n\n----\n\n deleteWhere is applicable only to Oracle SQL database which has no dedicated "when delete" clause
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().(deleteWhere)
//            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#component5().
//                        display_name component5
//                        documentation ```kotlin\npublic final operator fun component5(): Op<Boolean>?\n\n```\n\n----\n\n deleteWhere is applicable only to Oracle SQL database which has no dedicated "when delete" clause
//            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#copy().(deleteWhere)
//                        display_name deleteWhere
//                        documentation ```kotlin\ndeleteWhere: Op<Boolean>? = ...\n```\n\n----\n\n deleteWhere is applicable only to Oracle SQL database which has no dedicated "when delete" clause
//            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#deleteWhere.
//                        display_name deleteWhere
//                        documentation ```kotlin\npublic final val deleteWhere: Op<Boolean>?\n```\n\n----\n\n deleteWhere is applicable only to Oracle SQL database which has no dedicated "when delete" clause
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#deleteWhere.
//            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getDeleteWhere().
//                        display_name deleteWhere
//                        documentation ```kotlin\npublic get(): Op<Boolean>?\n```\n\n----\n\n deleteWhere is applicable only to Oracle SQL database which has no dedicated "when delete" clause
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getDeleteWhere().
//                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          /** Postgres clause modifier to override the system value */
          val overridingSystemValue: Boolean = false,
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().(overridingSystemValue)
//                                  display_name overridingSystemValue
//                                  documentation ```kotlin\noverridingSystemValue: Boolean = ...\n```\n\n----\n\n Postgres clause modifier to override the system value
//            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().(overridingSystemValue)
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#component6().
//                                  display_name component6
//                                  documentation ```kotlin\npublic final operator fun component6(): Boolean\n\n```\n\n----\n\n Postgres clause modifier to override the system value
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#copy().(overridingSystemValue)
//                                  display_name overridingSystemValue
//                                  documentation ```kotlin\noverridingSystemValue: Boolean = ...\n```\n\n----\n\n Postgres clause modifier to override the system value
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getOverridingSystemValue().
//                                  display_name overridingSystemValue
//                                  documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Postgres clause modifier to override the system value
//            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getOverridingSystemValue().
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#overridingSystemValue.
//                                  display_name overridingSystemValue
//                                  documentation ```kotlin\npublic final val overridingSystemValue: Boolean\n```\n\n----\n\n Postgres clause modifier to override the system value
//            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#overridingSystemValue.
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          /** Postgres clause modifier to override the user value */
          val overridingUserValue: Boolean = false,
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().(overridingUserValue)
//                                display_name overridingUserValue
//                                documentation ```kotlin\noverridingUserValue: Boolean = ...\n```\n\n----\n\n Postgres clause modifier to override the user value
//            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#`<init>`().(overridingUserValue)
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#component7().
//                                display_name component7
//                                documentation ```kotlin\npublic final operator fun component7(): Boolean\n\n```\n\n----\n\n Postgres clause modifier to override the user value
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#copy().(overridingUserValue)
//                                display_name overridingUserValue
//                                documentation ```kotlin\noverridingUserValue: Boolean = ...\n```\n\n----\n\n Postgres clause modifier to override the user value
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getOverridingUserValue().
//                                display_name overridingUserValue
//                                documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Postgres clause modifier to override the user value
//            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getOverridingUserValue().
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#overridingUserValue.
//                                display_name overridingUserValue
//                                documentation ```kotlin\npublic final val overridingUserValue: Boolean\n```\n\n----\n\n Postgres clause modifier to override the user value
//            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#overridingUserValue.
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      )
  
      enum class ClauseCondition {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Enum# 2:5
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseCondition#
//                               display_name ClauseCondition
//                               documentation ```kotlin\npublic final enum class ClauseCondition : Enum<MergeStatement.ClauseCondition>\n```
//                               relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseCondition#`<init>`().
//                               display_name ClauseCondition
//                               documentation ```kotlin\nprivate constructor(): MergeStatement.ClauseCondition\n```
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseCondition#entries.
//                               display_name entries
//                               documentation ```kotlin\npublic final static val entries: EnumEntries<MergeStatement.ClauseCondition>\n```
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseCondition#valueOf().
//                               display_name valueOf
//                               documentation ```kotlin\npublic final static fun valueOf(value: String): MergeStatement.ClauseCondition\n```
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseCondition#valueOf().(value)
//                               display_name value
//                               documentation ```kotlin\nvalue: String\n```
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseCondition#values().
//                               display_name values
//                               documentation ```kotlin\npublic final static fun values(): Array<MergeStatement.ClauseCondition>\n```
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getEntries().
//                               display_name entries
//                               documentation ```kotlin\npublic get(): EnumEntries<MergeStatement.ClauseAction>\n```
          MATCHED, NOT_MATCHED
      }
  
      enum class ClauseAction {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Enum# 2:5
//               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#
//                            display_name ClauseAction
//                            documentation ```kotlin\npublic final enum class ClauseAction : Enum<MergeStatement.ClauseAction>\n```
//                            relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#`<init>`().
//                            display_name ClauseAction
//                            documentation ```kotlin\nprivate constructor(): MergeStatement.ClauseAction\n```
//               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#entries.
//                            display_name entries
//                            documentation ```kotlin\npublic final static val entries: EnumEntries<MergeStatement.ClauseAction>\n```
//               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#valueOf().
//                            display_name valueOf
//                            documentation ```kotlin\npublic final static fun valueOf(value: String): MergeStatement.ClauseAction\n```
//               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#valueOf().(value)
//                            display_name value
//                            documentation ```kotlin\nvalue: String\n```
//               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#values().
//                            display_name values
//                            documentation ```kotlin\npublic final static fun values(): Array<MergeStatement.ClauseAction>\n```
//               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getEntries().
//                            display_name entries
//                            documentation ```kotlin\npublic get(): EnumEntries<MergeStatement.ClauseAction>\n```
          INSERT, UPDATE, DELETE, DO_NOTHING
      }
  }
  
  /**
   * Represents an SQL MERGE statement. It encapsulates the logic to perform conditional updates, insertions,
   * or deletions.
   *
   * Here is only the part specific for the Table as a source implementation.
   * Look into [MergeStatement] to find the base implementation of that command.
   *
   * @param dest The destination [Table] where records will be merged into.
   * @property source The source [Table] from which records are taken to compare with `dest`.
   * @property on The join condition [Op<Boolean>] that specifies how to match records in both `source` and `dest`.
   */
  open class MergeTableStatement(
//           ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#
//                               display_name MergeTableStatement
//                               documentation ```kotlin\npublic open class MergeTableStatement : MergeStatement\n```\n\n----\n\n\n Represents an SQL MERGE statement. It encapsulates the logic to perform conditional updates, insertions,\n or deletions.\n\n Here is only the part specific for the Table as a source implementation.\n Look into [MergeStatement] to find the base implementation of that command.\n\n @param dest The destination [Table] where records will be merged into.\n @property source The source [Table] from which records are taken to compare with `dest`.\n @property on The join condition [Op<Boolean>] that specifies how to match records in both `source` and `dest`.\n
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#
//           ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#`<init>`().
//                               display_name MergeTableStatement
//                               documentation ```kotlin\npublic constructor(dest: Table, source: Table, on: Op<Boolean>?): MergeTableStatement\n```
      dest: Table,
//    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#`<init>`().(dest)
//         display_name dest
//         documentation ```kotlin\ndest: Table\n```
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
      private val source: Table,
//                ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#`<init>`().(source)
//                       display_name source
//                       documentation ```kotlin\nsource: Table\n```
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#`<init>`().(source)
//                ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#getSource().
//                       display_name source
//                       documentation ```kotlin\nprivate get(): Table\n```
//                ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#source.
//                       display_name source
//                       documentation ```kotlin\nprivate final val source: Table\n```
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
      private val on: Op<Boolean>?
//                ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#`<init>`().(on)
//                   display_name on
//                   documentation ```kotlin\non: Op<Boolean>?\n```
//                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#`<init>`().(on)
//                ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#getOn().
//                   display_name on
//                   documentation ```kotlin\nprivate get(): Op<Boolean>?\n```
//                ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#on.
//                   display_name on
//                   documentation ```kotlin\nprivate final val on: Op<Boolean>?\n```
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
  ) : MergeStatement(dest) {
//    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#
//                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#`<init>`().(dest)
      override fun prepareSQL(transaction: Transaction, prepared: Boolean): String {
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#prepareSQL().
//                            display_name prepareSQL
//                            documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#prepareSQL().
//                            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#prepareSQL().(transaction)
//                                        display_name transaction
//                                        documentation ```kotlin\ntransaction: Transaction\n```
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#prepareSQL().(prepared)
//                                                               display_name prepared
//                                                               documentation ```kotlin\nprepared: Boolean\n```
//                                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
          return transaction.db.dialect.functionProvider.merge(table, source, transaction, clauses, on)
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#prepareSQL().(transaction)
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#getTable().
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#table.
//                                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#getSource().
//                                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#source.
//                                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#prepareSQL().(transaction)
//                                                                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#clauses.
//                                                                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#getClauses().
//                                                                                                  ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#getOn().
//                                                                                                  ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#on.
      }
  }
  
  /**
   * Represents an SQL MERGE statement. It encapsulates the logic to perform conditional updates, insertions,
   * or deletions.
   *
   * Here is only the part specific for the Query as a source implementation.
   * Look into [MergeStatement] to find the base implementation of that command.
   *
   * @param dest The destination [Table] where records will be merged into.
   * @property selectQuery The source [QueryAlias] from which records are taken to compare with `dest`.
   * @property on The join condition [Op<Boolean>] that specifies how to match records in both `source` and `dest`.
   */
  open class MergeSelectStatement(
//           ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#
//                                display_name MergeSelectStatement
//                                documentation ```kotlin\npublic open class MergeSelectStatement : MergeStatement\n```\n\n----\n\n\n Represents an SQL MERGE statement. It encapsulates the logic to perform conditional updates, insertions,\n or deletions.\n\n Here is only the part specific for the Query as a source implementation.\n Look into [MergeStatement] to find the base implementation of that command.\n\n @param dest The destination [Table] where records will be merged into.\n @property selectQuery The source [QueryAlias] from which records are taken to compare with `dest`.\n @property on The join condition [Op<Boolean>] that specifies how to match records in both `source` and `dest`.\n
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#
//           ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#`<init>`().
//                                display_name MergeSelectStatement
//                                documentation ```kotlin\npublic constructor(dest: Table, selectQuery: QueryAlias, on: Op<Boolean>): MergeSelectStatement\n```
      dest: Table,
//    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#`<init>`().(dest)
//         display_name dest
//         documentation ```kotlin\ndest: Table\n```
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
      private val selectQuery: QueryAlias,
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#`<init>`().(selectQuery)
//                            display_name selectQuery
//                            documentation ```kotlin\nselectQuery: QueryAlias\n```
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#`<init>`().(selectQuery)
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#getSelectQuery().
//                            display_name selectQuery
//                            documentation ```kotlin\nprivate get(): QueryAlias\n```
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#selectQuery.
//                            display_name selectQuery
//                            documentation ```kotlin\nprivate final val selectQuery: QueryAlias\n```
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#
      val on: Op<Boolean>
//        ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#`<init>`().(on)
//           display_name on
//           documentation ```kotlin\non: Op<Boolean>\n```
//        ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#`<init>`().(on)
//        ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#getOn().
//           display_name on
//           documentation ```kotlin\npublic get(): Op<Boolean>\n```
//        ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#on.
//           display_name on
//           documentation ```kotlin\npublic final val on: Op<Boolean>\n```
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
  ) : MergeStatement(dest) {
//    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#
//                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#`<init>`().(dest)
      override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>> {
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#arguments().
//                           display_name arguments
//                           documentation ```kotlin\npublic open override fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>>\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#arguments().
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
          val queryArguments = selectQuery.query.arguments().firstOrNull() ?: emptyList()
//            ^^^^^^^^^^^^^^ definition local 5
//                           display_name queryArguments
//                           documentation ```kotlin\nlocal val queryArguments: List<Pair<IColumnType<*>, Any?>>\n```
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#getSelectQuery().
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#selectQuery.
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getQuery().
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#query.
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#arguments().
//                                                           ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+19).
//                                                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
          val mergeStatementArguments = super.arguments().firstOrNull() ?: emptyList()
//            ^^^^^^^^^^^^^^^^^^^^^^^ definition local 6
//                                    display_name mergeStatementArguments
//                                    documentation ```kotlin\nlocal val mergeStatementArguments: Iterable<Pair<IColumnType<*>, Any?>>\n```
//                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#arguments().
//                                                        ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+18).
//                                                                         ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
          return listOf(
//               ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
              queryArguments + mergeStatementArguments
//            ^^^^^^^^^^^^^^ reference local 5
//                           ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                             ^^^^^^^^^^^^^^^^^^^^^^^ reference local 6
          )
      }
  
      override fun prepareSQL(transaction: Transaction, prepared: Boolean): String {
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#prepareSQL().
//                            display_name prepareSQL
//                            documentation ```kotlin\npublic open override fun prepareSQL(transaction: Transaction, prepared: Boolean): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#prepareSQL().
//                            ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#prepareSQL().(transaction)
//                                        display_name transaction
//                                        documentation ```kotlin\ntransaction: Transaction\n```
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#prepareSQL().(prepared)
//                                                               display_name prepared
//                                                               documentation ```kotlin\nprepared: Boolean\n```
//                                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
          return transaction.db.dialect.functionProvider.mergeSelect(table, selectQuery, transaction, clauses, on, prepared)
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#prepareSQL().(transaction)
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#getTable().
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#table.
//                                                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#getSelectQuery().
//                                                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#selectQuery.
//                                                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#prepareSQL().(transaction)
//                                                                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#clauses.
//                                                                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#getClauses().
//                                                                                                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#getOn().
//                                                                                                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#on.
//                                                                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#prepareSQL().(prepared)
      }
  }
