  package org.jetbrains.exposed.v1.core.ops
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/
  
  import org.jetbrains.exposed.v1.core.ComplexExpression
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
  import org.jetbrains.exposed.v1.core.Expression
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
  import org.jetbrains.exposed.v1.core.Op
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
  import org.jetbrains.exposed.v1.core.QueryBuilder
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
  import org.jetbrains.exposed.v1.core.Table
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
  
  /**
   * Represents an SQL operator that checks if [expr] is equal to any element from a single-column [table].
   *
   * **Note** This operation is only supported by MySQL, PostgreSQL, and H2 dialects.
   */
  class InTableOp(
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#
//                display_name InTableOp
//                documentation ```kotlin\npublic final class InTableOp : Op<Boolean>, ComplexExpression\n```\n\n----\n\n\n Represents an SQL operator that checks if [expr] is equal to any element from a single-column [table].\n\n **Note** This operation is only supported by MySQL, PostgreSQL, and H2 dialects.\n
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#`<init>`().
//                display_name InTableOp
//                documentation ```kotlin\npublic constructor(expr: Expression<*>, table: Table, isInTable: Boolean = ...): InTableOp\n```\n\n----\n\n Returns the expression compared to each element in the table's column.
      /** Returns the expression compared to each element in the table's column. */
      val expr: Expression<*>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<*>\n```\n\n----\n\n Returns the expression compared to each element in the table's column.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: Expression<*>\n```\n\n----\n\n Returns the expression compared to each element in the table's column.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): Expression<*>\n```\n\n----\n\n Returns the expression compared to each element in the table's column.
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
      /** Returns the single-column table to check against. */
      val table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#`<init>`().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```\n\n----\n\n Returns the single-column table to check against.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#`<init>`().(table)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#getTable().
//              display_name table
//              documentation ```kotlin\npublic get(): Table\n```\n\n----\n\n Returns the single-column table to check against.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#table.
//              display_name table
//              documentation ```kotlin\npublic final val table: Table\n```\n\n----\n\n Returns the single-column table to check against.
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
      /** Returns `false` if the check is inverted, `true` otherwise. */
      val isInTable: Boolean = true
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#`<init>`().(isInTable)
//                  display_name isInTable
//                  documentation ```kotlin\nisInTable: Boolean = ...\n```\n\n----\n\n Returns `false` if the check is inverted, `true` otherwise.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#`<init>`().(isInTable)
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#getIsInTable().
//                  display_name isInTable
//                  documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Returns `false` if the check is inverted, `true` otherwise.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#isInTable.
//                  display_name isInTable
//                  documentation ```kotlin\npublic final val isInTable: Boolean\n```\n\n----\n\n Returns `false` if the check is inverted, `true` otherwise.
//                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  ) : Op<Boolean>(), ComplexExpression {
//    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
      override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#toQueryBuilder().(queryBuilder)
          +expr
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#expr.
//         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#getExpr().
          +" "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          +if (isInTable) "" else "NOT "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#getIsInTable().
//             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#isInTable.
          +"IN ("
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          +"TABLE "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          +table.tableName
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#getTable().
//         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#table.
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
          +')'
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus().
      }
  }
