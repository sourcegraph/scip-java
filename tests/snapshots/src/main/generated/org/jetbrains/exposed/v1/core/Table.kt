  @file:Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")
  
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
  import org.jetbrains.exposed.v1.exceptions.DuplicateColumnException
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#
  import java.math.BigDecimal
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/math/
//                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
  import java.util.*
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/util/
  import kotlin.internal.LowPriorityInOverloadResolution
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^^^^^ reference semanticdb maven . . kotlin/internal/
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/internal/LowPriorityInOverloadResolution#
  import kotlin.reflect.KClass
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^^^^ reference semanticdb maven . . kotlin/reflect/
//                      ^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#
  import kotlin.reflect.KMutableProperty1
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^^^^ reference semanticdb maven . . kotlin/reflect/
//                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KMutableProperty1#
  import kotlin.reflect.KParameter
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^^^^ reference semanticdb maven . . kotlin/reflect/
//                      ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KParameter#
  import kotlin.reflect.KProperty1
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^^^^ reference semanticdb maven . . kotlin/reflect/
//                      ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KProperty1#
  import kotlin.reflect.full.memberProperties
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^^^^ reference semanticdb maven . . kotlin/reflect/
//                      ^^^^ reference semanticdb maven . . kotlin/reflect/full/
//                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/memberProperties.
  import kotlin.reflect.full.primaryConstructor
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^^^^ reference semanticdb maven . . kotlin/reflect/
//                      ^^^^ reference semanticdb maven . . kotlin/reflect/full/
//                           ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/primaryConstructor.
  
  /** Pair of expressions used to match rows from two joined tables. */
  typealias JoinCondition = Pair<Expression<*>, Expression<*>>
//          ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/JoinCondition#
//                        display_name FirTypeAliasSymbol org/jetbrains/exposed/v1/core/JoinCondition
//                        documentation ```kotlin\npublic final typealias JoinCondition = Pair<Expression<*>, Expression<*>>\n\n```\n\n----\n\n Pair of expressions used to match rows from two joined tables.
  
  /** Represents a subset of fields from a given source. */
  typealias Select = Slice
//          ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Select#
//                 display_name FirTypeAliasSymbol org/jetbrains/exposed/v1/core/Select
//                 documentation ```kotlin\npublic final typealias Select = Slice\n\n```\n\n----\n\n Represents a subset of fields from a given source.
  
  /**
   * Represents a set of expressions, contained in the given column set.
   */
  interface FieldSet {
//          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#
//                   display_name FieldSet
//                   documentation ```kotlin\npublic abstract interface FieldSet : Any\n```\n\n----\n\n\n Represents a set of expressions, contained in the given column set.\n
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#
      /** Return the column set that contains this field set. */
      val source: ColumnSet
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getSource().
//               display_name source
//               documentation ```kotlin\npublic get(): ColumnSet\n```\n\n----\n\n Return the column set that contains this field set.
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#source.
//               display_name source
//               documentation ```kotlin\npublic abstract val source: ColumnSet\n```\n\n----\n\n Return the column set that contains this field set.
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
  
      /** Returns the field of this field set. */
      val fields: List<Expression<*>>
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#fields.
//               display_name fields
//               documentation ```kotlin\npublic abstract val fields: List<Expression<*>>\n```\n\n----\n\n Returns the field of this field set.
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getFields().
//               display_name fields
//               documentation ```kotlin\npublic get(): List<Expression<*>>\n```\n\n----\n\n Returns the field of this field set.
//                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
  
      /**
       * Returns all real fields, unrolling composite [CompositeColumn] if present
       */
      val realFields: List<Expression<*>>
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#realFields.
//                   display_name realFields
//                   documentation ```kotlin\npublic open val realFields: List<Expression<*>>\n```\n\n----\n\n\n Returns all real fields, unrolling composite [CompositeColumn] if present\n
//                    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          get() {
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getRealFields().
//            display_name realFields
//            documentation ```kotlin\npublic get(): List<Expression<*>>\n```
              val unrolled = ArrayList<Expression<*>>(fields.size)
//                ^^^^^^^^ definition local 0
//                         display_name unrolled
//                         documentation ```kotlin\nlocal val unrolled: ArrayList<Expression<*>>\n```
//                           ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`().
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#fields.
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getFields().
//                                                           ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                                           ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
  
              fields.forEach {
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#fields.
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getFields().
//                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                           ^ definition semanticdb maven . . (it) 8:13
//                             display_name it
//                             documentation ```kotlin\nit: CheckConstraint\n```
                  when {
                      it is CompositeColumn<*> -> unrolled.addAll(it.getRealColumns())
//                    ^^ reference semanticdb maven . . (it)
//                                                ^^^^^^^^ reference local 0
//                                                         ^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#addAll().
//                                                                ^^ reference semanticdb maven . . (it)
//                                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumns().
                      (it as? Column<*>)?.isEntityIdentifier() == true && it.table is CompositeIdTable -> {
//                     ^^ reference semanticdb maven . . (it)
//                                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isEntityIdentifier().
//                                                                        ^^ reference semanticdb maven . . (it)
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
                          unrolled.addAll(it.table.idColumns)
//                        ^^^^^^^^ reference local 0
//                                 ^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#addAll().
//                                        ^^ reference semanticdb maven . . (it)
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#getIdColumns().
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#idColumns.
                      }
                      else -> unrolled.add(it)
//                            ^^^^^^^^ reference local 0
//                                     ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add().
//                                         ^^ reference semanticdb maven . . (it)
                  }
              }
  
              return unrolled
//                   ^^^^^^^^ reference local 0
          }
  }
  
  /**
   * Represents a set of columns.
   */
  abstract class ColumnSet : FieldSet {
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                         display_name ColumnSet
//                         documentation ```kotlin\npublic abstract class ColumnSet : FieldSet\n```\n\n----\n\n\n Represents a set of columns.\n
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#`<init>`().
//                         display_name ColumnSet
//                         documentation ```kotlin\npublic constructor(): ColumnSet\n```\n\n----\n\n\n Represents a set of columns.\n
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#
      override val source: ColumnSet get() = this
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#source.
//                        display_name source
//                        documentation ```kotlin\npublic open override val source: ColumnSet\n```
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                   ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getSource().
//                                       display_name source
//                                       documentation ```kotlin\npublic get(): ColumnSet\n```
  
      /** Returns the columns of this column set. */
      abstract val columns: List<Column<*>>
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#columns.
//                         display_name columns
//                         documentation ```kotlin\npublic abstract val columns: List<Column<*>>\n```\n\n----\n\n Returns the columns of this column set.
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getColumns().
//                         display_name columns
//                         documentation ```kotlin\npublic get(): List<Column<*>>\n```\n\n----\n\n Returns the columns of this column set.
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
      override val fields: List<Expression<*>> get() = columns
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fields.
//                        display_name fields
//                        documentation ```kotlin\npublic open override val fields: List<Expression<*>>\n```
//                         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                             ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getFields().
//                                                 display_name fields
//                                                 documentation ```kotlin\npublic get(): List<Expression<*>>\n```
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#columns.
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getColumns().
  
      /** Appends the SQL representation of this column set to the specified [queryBuilder]. */
      abstract fun describe(s: Transaction, queryBuilder: QueryBuilder)
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().
//                          display_name describe
//                          documentation ```kotlin\npublic abstract fun describe(s: Transaction, queryBuilder: QueryBuilder): Unit\n\n```\n\n----\n\n Appends the SQL representation of this column set to the specified [queryBuilder].
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#describe().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().
//                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().(s)
//                            display_name s
//                            documentation ```kotlin\ns: Transaction\n```
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                          ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().(queryBuilder)
//                                                       display_name queryBuilder
//                                                       documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
  
      /**
       * Creates a join relation with [otherTable].
       * When all joining options are absent Exposed will try to resolve referencing columns by itself.
       *
       * @param otherTable [ColumnSet] to join with.
       * @param joinType See [JoinType] for available options.
       * @param onColumn The column from a current [ColumnSet], may be skipped then [additionalConstraint] will be used.
       * @param otherColumn The column from an [otherTable], may be skipped then [additionalConstraint] will be used.
       * @param additionalConstraint The condition to join which will be placed in ON part of SQL query.
       * @param lateral Set to true to enable a lateral join, allowing the subquery on the right side
       *        to access columns from preceding tables in the FROM clause.
       * @throws IllegalStateException If join could not be prepared. See exception message for more details.
       */
      abstract fun join(
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().
//                      display_name join
//                      documentation ```kotlin\npublic abstract fun join(otherTable: ColumnSet, joinType: JoinType, onColumn: Expression<*>? = ..., otherColumn: Expression<*>? = ..., lateral: Boolean = ..., additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...): Join\n\n```\n\n----\n\n\n Creates a join relation with [otherTable].\n When all joining options are absent Exposed will try to resolve referencing columns by itself.\n\n @param otherTable [ColumnSet] to join with.\n @param joinType See [JoinType] for available options.\n @param onColumn The column from a current [ColumnSet], may be skipped then [additionalConstraint] will be used.\n @param otherColumn The column from an [otherTable], may be skipped then [additionalConstraint] will be used.\n @param additionalConstraint The condition to join which will be placed in ON part of SQL query.\n @param lateral Set to true to enable a lateral join, allowing the subquery on the right side\n        to access columns from preceding tables in the FROM clause.\n @throws IllegalStateException If join could not be prepared. See exception message for more details.\n
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#join().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().
          otherTable: ColumnSet,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(otherTable)
//                   display_name otherTable
//                   documentation ```kotlin\notherTable: ColumnSet\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
          joinType: JoinType,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(joinType)
//                 display_name joinType
//                 documentation ```kotlin\njoinType: JoinType\n```
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
          onColumn: Expression<*>? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(onColumn)
//                 display_name onColumn
//                 documentation ```kotlin\nonColumn: Expression<*>? = ...\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          otherColumn: Expression<*>? = null,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(otherColumn)
//                    display_name otherColumn
//                    documentation ```kotlin\notherColumn: Expression<*>? = ...\n```
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          lateral: Boolean = false,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(lateral)
//                display_name lateral
//                documentation ```kotlin\nlateral: Boolean = ...\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(additionalConstraint)
//                             display_name additionalConstraint
//                             documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      ): Join
//       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
  
      /** Creates an inner join relation with [otherTable]. */
      abstract fun innerJoin(otherTable: ColumnSet): Join
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#innerJoin().
//                           display_name innerJoin
//                           documentation ```kotlin\npublic abstract fun innerJoin(otherTable: ColumnSet): Join\n\n```\n\n----\n\n Creates an inner join relation with [otherTable].
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Join#innerJoin().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#innerJoin().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#innerJoin().
//                           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#innerJoin().(otherTable)
//                                      display_name otherTable
//                                      documentation ```kotlin\notherTable: ColumnSet\n```
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
  
      /** Creates a left outer join relation with [otherTable]. */
      abstract fun leftJoin(otherTable: ColumnSet): Join
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#leftJoin().
//                          display_name leftJoin
//                          documentation ```kotlin\npublic abstract fun leftJoin(otherTable: ColumnSet): Join\n\n```\n\n----\n\n Creates a left outer join relation with [otherTable].
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Join#leftJoin().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#leftJoin().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#leftJoin().
//                          ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#leftJoin().(otherTable)
//                                     display_name otherTable
//                                     documentation ```kotlin\notherTable: ColumnSet\n```
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
  
      /** Creates a right outer join relation with [otherTable]. */
      abstract fun rightJoin(otherTable: ColumnSet): Join
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#rightJoin().
//                           display_name rightJoin
//                           documentation ```kotlin\npublic abstract fun rightJoin(otherTable: ColumnSet): Join\n\n```\n\n----\n\n Creates a right outer join relation with [otherTable].
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Join#rightJoin().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#rightJoin().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#rightJoin().
//                           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#rightJoin().(otherTable)
//                                      display_name otherTable
//                                      documentation ```kotlin\notherTable: ColumnSet\n```
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
  
      /** Creates a full outer join relation with [otherTable]. */
      abstract fun fullJoin(otherTable: ColumnSet): Join
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fullJoin().
//                          display_name fullJoin
//                          documentation ```kotlin\npublic abstract fun fullJoin(otherTable: ColumnSet): Join\n\n```\n\n----\n\n Creates a full outer join relation with [otherTable].
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Join#fullJoin().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#fullJoin().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#fullJoin().
//                          ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fullJoin().(otherTable)
//                                     display_name otherTable
//                                     documentation ```kotlin\notherTable: ColumnSet\n```
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
  
      /** Creates a cross join relation with [otherTable]. */
      abstract fun crossJoin(otherTable: ColumnSet): Join
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#crossJoin().
//                           display_name crossJoin
//                           documentation ```kotlin\npublic abstract fun crossJoin(otherTable: ColumnSet): Join\n\n```\n\n----\n\n Creates a cross join relation with [otherTable].
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Join#crossJoin().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#crossJoin().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#crossJoin().
//                           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#crossJoin().(otherTable)
//                                      display_name otherTable
//                                      documentation ```kotlin\notherTable: ColumnSet\n```
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
  }
  
  /**
   * Creates an inner join relation with [otherTable] using [onColumn] and [otherColumn] equality
   * and/or [additionalConstraint] as the join condition.
   *
   * @throws IllegalStateException if the join cannot be performed. See the exception message for more details.
   */
  fun <C1 : ColumnSet, C2 : ColumnSet> C1.innerJoin(
//     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().[C1]
//        display_name FirTypeParameterSymbol C1
//        documentation ```kotlin\nC1 : ColumnSet\n```
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().[C2]
//                        display_name FirTypeParameterSymbol C2
//                        documentation ```kotlin\nC2 : ColumnSet\n```
//                                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().
//                                                  display_name innerJoin
//                                                  documentation ```kotlin\npublic final fun <C1 : ColumnSet, C2 : ColumnSet> C1.innerJoin(otherTable: C2, onColumn: (C1.() -> Expression<*>)? = ..., otherColumn: (C2.() -> Expression<*>)? = ..., additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...): Join\n```\n\n----\n\n\n Creates an inner join relation with [otherTable] using [onColumn] and [otherColumn] equality\n and/or [additionalConstraint] as the join condition.\n\n @throws IllegalStateException if the join cannot be performed. See the exception message for more details.\n
      otherTable: C2,
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(otherTable)
//               display_name otherTable
//               documentation ```kotlin\notherTable: C2\n```
      onColumn: (C1.() -> Expression<*>)? = null,
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(onColumn)
//             display_name onColumn
//             documentation ```kotlin\nonColumn: (C1.() -> Expression<*>)? = ...\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      otherColumn: (C2.() -> Expression<*>)? = null,
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(otherColumn)
//                display_name otherColumn
//                documentation ```kotlin\notherColumn: (C2.() -> Expression<*>)? = ...\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(additionalConstraint)
//                         display_name additionalConstraint
//                         documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
  ): Join = join(otherTable, JoinType.INNER, onColumn?.invoke(this), otherColumn?.invoke(otherTable), false, additionalConstraint)
//   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(otherTable)
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#INNER.
//                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(onColumn)
//                                                     ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(otherColumn)
//                                                                                ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(otherTable)
//                                                                                                           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(additionalConstraint)
  
  /**
   * Creates a left outer join relation with [otherTable] using [onColumn] and [otherColumn] equality
   * and/or [additionalConstraint] as the join condition.
   *
   * @throws IllegalStateException if the join cannot be performed. See the exception message for more details.
   */
  fun <C1 : ColumnSet, C2 : ColumnSet> C1.leftJoin(
//     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().[C1]
//        display_name FirTypeParameterSymbol C1
//        documentation ```kotlin\nC1 : ColumnSet\n```
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().[C2]
//                        display_name FirTypeParameterSymbol C2
//                        documentation ```kotlin\nC2 : ColumnSet\n```
//                                        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().
//                                                 display_name leftJoin
//                                                 documentation ```kotlin\npublic final fun <C1 : ColumnSet, C2 : ColumnSet> C1.leftJoin(otherTable: C2, onColumn: (C1.() -> Expression<*>)? = ..., otherColumn: (C2.() -> Expression<*>)? = ..., additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...): Join\n```\n\n----\n\n\n Creates a left outer join relation with [otherTable] using [onColumn] and [otherColumn] equality\n and/or [additionalConstraint] as the join condition.\n\n @throws IllegalStateException if the join cannot be performed. See the exception message for more details.\n
      otherTable: C2,
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(otherTable)
//               display_name otherTable
//               documentation ```kotlin\notherTable: C2\n```
      onColumn: (C1.() -> Expression<*>)? = null,
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(onColumn)
//             display_name onColumn
//             documentation ```kotlin\nonColumn: (C1.() -> Expression<*>)? = ...\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      otherColumn: (C2.() -> Expression<*>)? = null,
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(otherColumn)
//                display_name otherColumn
//                documentation ```kotlin\notherColumn: (C2.() -> Expression<*>)? = ...\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(additionalConstraint)
//                         display_name additionalConstraint
//                         documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
  ): Join = join(otherTable, JoinType.LEFT, onColumn?.invoke(this), otherColumn?.invoke(otherTable), false, additionalConstraint)
//   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(otherTable)
//                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#LEFT.
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(onColumn)
//                                                    ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(otherColumn)
//                                                                               ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(otherTable)
//                                                                                                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(additionalConstraint)
  
  /**
   * Creates a right outer join relation with [otherTable] using [onColumn] and [otherColumn] equality
   * and/or [additionalConstraint] as the join condition.
   *
   * @throws IllegalStateException if the join cannot be performed. See the exception message for more details.
   */
  fun <C1 : ColumnSet, C2 : ColumnSet> C1.rightJoin(
//     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().[C1]
//        display_name FirTypeParameterSymbol C1
//        documentation ```kotlin\nC1 : ColumnSet\n```
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().[C2]
//                        display_name FirTypeParameterSymbol C2
//                        documentation ```kotlin\nC2 : ColumnSet\n```
//                                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().
//                                                  display_name rightJoin
//                                                  documentation ```kotlin\npublic final fun <C1 : ColumnSet, C2 : ColumnSet> C1.rightJoin(otherTable: C2, onColumn: (C1.() -> Expression<*>)? = ..., otherColumn: (C2.() -> Expression<*>)? = ..., additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...): Join\n```\n\n----\n\n\n Creates a right outer join relation with [otherTable] using [onColumn] and [otherColumn] equality\n and/or [additionalConstraint] as the join condition.\n\n @throws IllegalStateException if the join cannot be performed. See the exception message for more details.\n
      otherTable: C2,
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(otherTable)
//               display_name otherTable
//               documentation ```kotlin\notherTable: C2\n```
      onColumn: (C1.() -> Expression<*>)? = null,
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(onColumn)
//             display_name onColumn
//             documentation ```kotlin\nonColumn: (C1.() -> Expression<*>)? = ...\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      otherColumn: (C2.() -> Expression<*>)? = null,
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(otherColumn)
//                display_name otherColumn
//                documentation ```kotlin\notherColumn: (C2.() -> Expression<*>)? = ...\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(additionalConstraint)
//                         display_name additionalConstraint
//                         documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
  ): Join = join(otherTable, JoinType.RIGHT, onColumn?.invoke(this), otherColumn?.invoke(otherTable), false, additionalConstraint)
//   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(otherTable)
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#RIGHT.
//                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(onColumn)
//                                                     ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(otherColumn)
//                                                                                ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(otherTable)
//                                                                                                           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(additionalConstraint)
  
  /**
   * Creates a full outer join relation with [otherTable] using [onColumn] and [otherColumn] equality
   * and/or [additionalConstraint] as the join condition.
   *
   * @throws IllegalStateException if the join cannot be performed. See the exception message for more details.
   */
  fun <C1 : ColumnSet, C2 : ColumnSet> C1.fullJoin(
//     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().[C1]
//        display_name FirTypeParameterSymbol C1
//        documentation ```kotlin\nC1 : ColumnSet\n```
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().[C2]
//                        display_name FirTypeParameterSymbol C2
//                        documentation ```kotlin\nC2 : ColumnSet\n```
//                                        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().
//                                                 display_name fullJoin
//                                                 documentation ```kotlin\npublic final fun <C1 : ColumnSet, C2 : ColumnSet> C1.fullJoin(otherTable: C2, onColumn: (C1.() -> Expression<*>)? = ..., otherColumn: (C2.() -> Expression<*>)? = ..., additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...): Join\n```\n\n----\n\n\n Creates a full outer join relation with [otherTable] using [onColumn] and [otherColumn] equality\n and/or [additionalConstraint] as the join condition.\n\n @throws IllegalStateException if the join cannot be performed. See the exception message for more details.\n
      otherTable: C2,
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(otherTable)
//               display_name otherTable
//               documentation ```kotlin\notherTable: C2\n```
      onColumn: (C1.() -> Expression<*>)? = null,
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(onColumn)
//             display_name onColumn
//             documentation ```kotlin\nonColumn: (C1.() -> Expression<*>)? = ...\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      otherColumn: (C2.() -> Expression<*>)? = null,
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(otherColumn)
//                display_name otherColumn
//                documentation ```kotlin\notherColumn: (C2.() -> Expression<*>)? = ...\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(additionalConstraint)
//                         display_name additionalConstraint
//                         documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
  ): Join = join(otherTable, JoinType.FULL, onColumn?.invoke(this), otherColumn?.invoke(otherTable), false, additionalConstraint)
//   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(otherTable)
//                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#FULL.
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(onColumn)
//                                                    ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(otherColumn)
//                                                                               ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(otherTable)
//                                                                                                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(additionalConstraint)
  
  /**
   * Creates a cross join relation with [otherTable] using [onColumn] and [otherColumn] equality
   * and/or [additionalConstraint] as the join condition.
   *
   * @throws IllegalStateException if the join cannot be performed. See the exception message for more details.
   */
  fun <C1 : ColumnSet, C2 : ColumnSet> C1.crossJoin(
//     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().[C1]
//        display_name FirTypeParameterSymbol C1
//        documentation ```kotlin\nC1 : ColumnSet\n```
//                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().[C2]
//                        display_name FirTypeParameterSymbol C2
//                        documentation ```kotlin\nC2 : ColumnSet\n```
//                                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().
//                                                  display_name crossJoin
//                                                  documentation ```kotlin\npublic final fun <C1 : ColumnSet, C2 : ColumnSet> C1.crossJoin(otherTable: C2, onColumn: (C1.() -> Expression<*>)? = ..., otherColumn: (C2.() -> Expression<*>)? = ..., additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...): Join\n```\n\n----\n\n\n Creates a cross join relation with [otherTable] using [onColumn] and [otherColumn] equality\n and/or [additionalConstraint] as the join condition.\n\n @throws IllegalStateException if the join cannot be performed. See the exception message for more details.\n
      otherTable: C2,
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(otherTable)
//               display_name otherTable
//               documentation ```kotlin\notherTable: C2\n```
      onColumn: (C1.() -> Expression<*>)? = null,
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(onColumn)
//             display_name onColumn
//             documentation ```kotlin\nonColumn: (C1.() -> Expression<*>)? = ...\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      otherColumn: (C2.() -> Expression<*>)? = null,
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(otherColumn)
//                display_name otherColumn
//                documentation ```kotlin\notherColumn: (C2.() -> Expression<*>)? = ...\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(additionalConstraint)
//                         display_name additionalConstraint
//                         documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
  ): Join = join(otherTable, JoinType.CROSS, onColumn?.invoke(this), otherColumn?.invoke(otherTable), false, additionalConstraint)
//   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(otherTable)
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#CROSS.
//                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(onColumn)
//                                                     ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(otherColumn)
//                                                                                ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(otherTable)
//                                                                                                           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(additionalConstraint)
  
  /**
   * Represents a subset of [fields] from a given [source].
   */
  class Slice(override val source: ColumnSet, override val fields: List<Expression<*>>) : FieldSet
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#
//            display_name Slice
//            documentation ```kotlin\npublic final class Slice : FieldSet\n```\n\n----\n\n\n Represents a subset of [fields] from a given [source].\n
//            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#`<init>`().
//            display_name Slice
//            documentation ```kotlin\npublic constructor(source: ColumnSet, fields: List<Expression<*>>): Slice\n```
//                         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#`<init>`().(source)
//                                display_name source
//                                documentation ```kotlin\nsource: ColumnSet\n```
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#`<init>`().(source)
//                         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#getSource().
//                                display_name source
//                                documentation ```kotlin\npublic get(): ColumnSet\n```
//                         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#source.
//                                display_name source
//                                documentation ```kotlin\npublic open override val source: ColumnSet\n```
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#`<init>`().(fields)
//                                                                display_name fields
//                                                                documentation ```kotlin\nfields: List<Expression<*>>\n```
//                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#`<init>`().(fields)
//                                                         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#fields.
//                                                                display_name fields
//                                                                documentation ```kotlin\npublic open override val fields: List<Expression<*>>\n```
//                                                         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#getFields().
//                                                                display_name fields
//                                                                documentation ```kotlin\npublic get(): List<Expression<*>>\n```
//                                                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#
  
  /**
//^^^ reference semanticdb maven . . kotlin/Enum# 18:1
   * Represents column set join types.
   */
  enum class JoinType {
//           ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
//                    display_name JoinType
//                    documentation ```kotlin\npublic final enum class JoinType : Enum<JoinType>\n```\n\n----\n\n\n Represents column set join types.\n
//                    relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//           ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#`<init>`().
//                    display_name JoinType
//                    documentation ```kotlin\nprivate constructor(): JoinType\n```\n\n----\n\n\n Represents column set join types.\n
//           ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#entries.
//                    display_name entries
//                    documentation ```kotlin\npublic final static val entries: EnumEntries<JoinType>\n```\n\n----\n\n\n Represents column set join types.\n
//           ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#valueOf().
//                    display_name valueOf
//                    documentation ```kotlin\npublic final static fun valueOf(value: String): JoinType\n```\n\n----\n\n\n Represents column set join types.\n
//           ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#valueOf().(value)
//                    display_name value
//                    documentation ```kotlin\nvalue: String\n```\n\n----\n\n\n Represents column set join types.\n
//           ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#values().
//                    display_name values
//                    documentation ```kotlin\npublic final static fun values(): Array<JoinType>\n```\n\n----\n\n\n Represents column set join types.\n
//           ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/getEntries().
//                    display_name entries
//                    documentation ```kotlin\npublic get(): EnumEntries<JoinType>\n```\n\n----\n\n\n Represents column set join types.\n
      /** Inner join. */
      INNER,
  
      /** Left outer join. */
      LEFT,
  
      /** Right outer join. */
      RIGHT,
  
      /** Full outer join. */
      FULL,
  
      /** Cross join. */
      CROSS
  }
  
  /**
   * Represents a join relation between multiple column sets.
   */
  class Join(
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//           display_name Join
//           documentation ```kotlin\npublic final class Join : ColumnSet\n```\n\n----\n\n\n Represents a join relation between multiple column sets.\n
//           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`().
//           display_name Join
//           documentation ```kotlin\npublic constructor(table: ColumnSet): Join\n```\n\n----\n\n The column set to which others will be joined.
      /** The column set to which others will be joined. */
      val table: ColumnSet
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`().(table)
//              display_name table
//              documentation ```kotlin\ntable: ColumnSet\n```\n\n----\n\n The column set to which others will be joined.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`().(table)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getTable().
//              display_name table
//              documentation ```kotlin\npublic get(): ColumnSet\n```\n\n----\n\n The column set to which others will be joined.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#table.
//              display_name table
//              documentation ```kotlin\npublic final val table: ColumnSet\n```\n\n----\n\n The column set to which others will be joined.
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
  ) : ColumnSet() {
//    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
  
      override val columns: List<Column<*>>
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#columns.
//                         display_name columns
//                         documentation ```kotlin\npublic open override val columns: List<Column<*>>\n```
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          get() = joinParts.flatMapTo(
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getColumns().
//            display_name columns
//            documentation ```kotlin\npublic get(): List<Column<*>>\n```
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                          ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMapTo(+10).
              table.columns.toMutableList()
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getTable().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#table.
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#columns.
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getColumns().
//                          ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/toMutableList(+10).
          ) { it.joinPart.columns }
//          ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                  display_name it
//                                  documentation ```kotlin\nit: CheckConstraint\n```
//            ^^ reference semanticdb maven . . (it)
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#columns.
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getColumns().
  
      override val fields: List<Expression<*>>
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#fields.
//                        display_name fields
//                        documentation ```kotlin\npublic open override val fields: List<Expression<*>>\n```
//                         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          get() = joinParts.flatMapTo(table.fields.toMutableList()) {
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getFields().
//            display_name fields
//            documentation ```kotlin\npublic get(): List<Expression<*>>\n```
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                          ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMapTo(+10).
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getTable().
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#table.
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fields.
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getFields().
//                                                 ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/toMutableList(+10).
//                                                                  ^ definition semanticdb maven . . (it) 5:9
//                                                                    display_name it
//                                                                    documentation ```kotlin\nit: CheckConstraint\n```
              when (it.joinPart) {
//                  ^^ reference semanticdb maven . . (it)
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
                  is QueryAlias -> it.joinPart.aliasedFields
//                                 ^^ reference semanticdb maven . . (it)
//                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#aliasedFields.
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getAliasedFields().
                  else -> it.joinPart.fields
//                        ^^ reference semanticdb maven . . (it)
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fields.
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getFields().
              }
          }
  
      internal val joinParts: MutableList<JoinPart> = mutableListOf()
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                           display_name joinParts
//                           documentation ```kotlin\ninternal get(): MutableList<Join.JoinPart>\n```
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                           display_name joinParts
//                           documentation ```kotlin\ninternal final val joinParts: MutableList<Join.JoinPart>\n```
//                            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#
//                                                    ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
  
      constructor(
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1). 27:5
//                 display_name Join
//                 documentation ```kotlin\npublic constructor(table: ColumnSet, otherTable: ColumnSet, joinType: JoinType = ..., onColumn: Expression<*>? = ..., otherColumn: Expression<*>? = ..., lateral: Boolean = ..., additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...): Join\n```
          table: ColumnSet,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(table)
//              display_name table
//              documentation ```kotlin\ntable: ColumnSet\n```
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
          otherTable: ColumnSet,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(otherTable)
//                   display_name otherTable
//                   documentation ```kotlin\notherTable: ColumnSet\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
          joinType: JoinType = JoinType.INNER,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(joinType)
//                 display_name joinType
//                 documentation ```kotlin\njoinType: JoinType = ...\n```
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#INNER.
          onColumn: Expression<*>? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(onColumn)
//                 display_name onColumn
//                 documentation ```kotlin\nonColumn: Expression<*>? = ...\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          otherColumn: Expression<*>? = null,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(otherColumn)
//                    display_name otherColumn
//                    documentation ```kotlin\notherColumn: Expression<*>? = ...\n```
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          lateral: Boolean = false,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(lateral)
//                display_name lateral
//                documentation ```kotlin\nlateral: Boolean = ...\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(additionalConstraint)
//                             display_name additionalConstraint
//                             documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      ) : this(table) {
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(table)
          val newJoin = when {
//            ^^^^^^^ definition local 1
//                    display_name newJoin
//                    documentation ```kotlin\nlocal val newJoin: Join\n```
              onColumn != null && otherColumn != null -> {
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(onColumn)
//                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(otherColumn)
                  join(otherTable, joinType, onColumn, otherColumn, lateral, additionalConstraint)
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(otherTable)
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(joinType)
//                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(onColumn)
//                                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(otherColumn)
//                                                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(lateral)
//                                                                           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(additionalConstraint)
              }
  
              onColumn != null || otherColumn != null -> {
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(onColumn)
//                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(otherColumn)
                  error("Can't prepare join on $table and $otherTable when only column from a one side provided.")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(table)
//                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(otherTable)
              }
  
              additionalConstraint != null -> {
//            ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(additionalConstraint)
                  join(otherTable, joinType, emptyList(), additionalConstraint, lateral)
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(otherTable)
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(joinType)
//                                           ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
//                                                        ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(additionalConstraint)
//                                                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(lateral)
              }
  
              else -> {
                  implicitJoin(otherTable, joinType, lateral)
//                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(otherTable)
//                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(joinType)
//                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(lateral)
              }
          }
          joinParts.addAll(newJoin.joinParts)
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                  ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#addAll().
//                         ^^^^^^^ reference local 1
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
      }
  
      override fun describe(s: Transaction, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().
//                          display_name describe
//                          documentation ```kotlin\npublic open override fun describe(s: Transaction, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().
//                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().(s)
//                            display_name s
//                            documentation ```kotlin\ns: Transaction\n```
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                          ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().(queryBuilder)
//                                                       display_name queryBuilder
//                                                       documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                       ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().(queryBuilder)
//                                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
          table.describe(s, this)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getTable().
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#table.
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().
//                       ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().(s)
          for (p in joinParts) {
//             ^ definition local 3
//               display_name p
//               documentation ```kotlin\nlocal val p: Join.JoinPart\n```
//                  ^^^^^^^^^ definition local 2
//                            display_name <iterator>
//                            documentation ```kotlin\nlocal val <iterator>: MutableIterator<Join.JoinPart>\n```
//                  ^^^^^^^^^ reference local 2
//                  ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableIterator#hasNext().
//                  ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableIterator#next().
//                  ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#iterator().
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
              p.describe(s, this)
//            ^ reference local 3
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#describe().
//                       ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().(s)
          }
      }
  
      override fun join(
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().
//                      display_name join
//                      documentation ```kotlin\npublic open override fun join(otherTable: ColumnSet, joinType: JoinType, onColumn: Expression<*>?, otherColumn: Expression<*>?, lateral: Boolean, additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?): Join\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().
          otherTable: ColumnSet,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(otherTable)
//                   display_name otherTable
//                   documentation ```kotlin\notherTable: ColumnSet\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
          joinType: JoinType,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(joinType)
//                 display_name joinType
//                 documentation ```kotlin\njoinType: JoinType\n```
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
          onColumn: Expression<*>?,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(onColumn)
//                 display_name onColumn
//                 documentation ```kotlin\nonColumn: Expression<*>?\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          otherColumn: Expression<*>?,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(otherColumn)
//                    display_name otherColumn
//                    documentation ```kotlin\notherColumn: Expression<*>?\n```
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          lateral: Boolean,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(lateral)
//                display_name lateral
//                documentation ```kotlin\nlateral: Boolean\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(additionalConstraint)
//                             display_name additionalConstraint
//                             documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      ): Join {
//       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
          val cond = if (onColumn != null && otherColumn != null) {
//            ^^^^ definition local 4
//                 display_name cond
//                 documentation ```kotlin\nlocal val cond: List<{org/jetbrains/exposed/v1/core/JoinCondition=} Pair<Expression<*>, Expression<*>>>\n```
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(onColumn)
//                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(otherColumn)
              listOf(JoinCondition(onColumn, otherColumn))
//            ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#`<init>`().
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(onColumn)
//                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(otherColumn)
          } else {
              emptyList()
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
          }
          return join(otherTable, joinType, cond, additionalConstraint, lateral)
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(otherTable)
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(joinType)
//                                          ^^^^ reference local 4
//                                                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(additionalConstraint)
//                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(lateral)
      }
  
      override infix fun innerJoin(otherTable: ColumnSet): Join = implicitJoin(otherTable, JoinType.INNER)
//                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#innerJoin().
//                                 display_name innerJoin
//                                 documentation ```kotlin\npublic open override infix fun innerJoin(otherTable: ColumnSet): Join\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#innerJoin().
//                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#innerJoin().(otherTable)
//                                            display_name otherTable
//                                            documentation ```kotlin\notherTable: ColumnSet\n```
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().
//                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#innerJoin().(otherTable)
//                                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#INNER.
  
      override infix fun leftJoin(otherTable: ColumnSet): Join = implicitJoin(otherTable, JoinType.LEFT)
//                       ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#leftJoin().
//                                display_name leftJoin
//                                documentation ```kotlin\npublic open override infix fun leftJoin(otherTable: ColumnSet): Join\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#leftJoin().
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#leftJoin().(otherTable)
//                                           display_name otherTable
//                                           documentation ```kotlin\notherTable: ColumnSet\n```
//                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().
//                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#leftJoin().(otherTable)
//                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#LEFT.
  
      override infix fun rightJoin(otherTable: ColumnSet): Join = implicitJoin(otherTable, JoinType.RIGHT)
//                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#rightJoin().
//                                 display_name rightJoin
//                                 documentation ```kotlin\npublic open override infix fun rightJoin(otherTable: ColumnSet): Join\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#rightJoin().
//                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#rightJoin().(otherTable)
//                                            display_name otherTable
//                                            documentation ```kotlin\notherTable: ColumnSet\n```
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().
//                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#rightJoin().(otherTable)
//                                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#RIGHT.
  
      override infix fun fullJoin(otherTable: ColumnSet): Join = implicitJoin(otherTable, JoinType.FULL)
//                       ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#fullJoin().
//                                display_name fullJoin
//                                documentation ```kotlin\npublic open override infix fun fullJoin(otherTable: ColumnSet): Join\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fullJoin().
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#fullJoin().(otherTable)
//                                           display_name otherTable
//                                           documentation ```kotlin\notherTable: ColumnSet\n```
//                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().
//                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#fullJoin().(otherTable)
//                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#FULL.
  
      override infix fun crossJoin(otherTable: ColumnSet): Join = implicitJoin(otherTable, JoinType.CROSS)
//                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#crossJoin().
//                                 display_name crossJoin
//                                 documentation ```kotlin\npublic open override infix fun crossJoin(otherTable: ColumnSet): Join\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#crossJoin().
//                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#crossJoin().(otherTable)
//                                            display_name otherTable
//                                            documentation ```kotlin\notherTable: ColumnSet\n```
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().
//                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#crossJoin().(otherTable)
//                                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#CROSS.
  
      private fun implicitJoin(
//                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().
//                             display_name implicitJoin
//                             documentation ```kotlin\nprivate final fun implicitJoin(otherTable: ColumnSet, joinType: JoinType, lateral: Boolean = ...): Join\n```
          otherTable: ColumnSet,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(otherTable)
//                   display_name otherTable
//                   documentation ```kotlin\notherTable: ColumnSet\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
          joinType: JoinType,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(joinType)
//                 display_name joinType
//                 documentation ```kotlin\njoinType: JoinType\n```
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
          lateral: Boolean = false
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(lateral)
//                display_name lateral
//                documentation ```kotlin\nlateral: Boolean = ...\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      ): Join {
//       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
          val fkKeys = findKeys(this, otherTable) ?: findKeys(otherTable, this) ?: emptyList()
//            ^^^^^^ definition local 5
//                   display_name fkKeys
//                   documentation ```kotlin\nlocal val fkKeys: List<Pair<Column<*>, List<Column<*>>>>\n```
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(otherTable)
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().
//                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(otherTable)
//                                                                                 ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
          return when {
              joinType != JoinType.CROSS && fkKeys.isEmpty() -> {
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(joinType)
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#CROSS.
//                                          ^^^^^^ reference local 5
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#isEmpty().
                  error(
//                ^^^^^ reference semanticdb maven . . kotlin/error().
                      "Cannot join with $otherTable as there is no matching primary key/foreign key pair and constraint missing"
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(otherTable)
                  )
              }
  
              fkKeys.any { it.second.size > 1 } -> {
//            ^^^^^^ reference local 5
//                   ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                       ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                              display_name it
//                                              documentation ```kotlin\nit: CheckConstraint\n```
//                         ^^ reference semanticdb maven . . (it)
//                            ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                            ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                   ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                   ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                        ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
                  val references = fkKeys.joinToString(" & ") { "${it.first} -> ${it.second.joinToString()}" }
//                    ^^^^^^^^^^ definition local 6
//                               display_name references
//                               documentation ```kotlin\nlocal val references: String\n```
//                                 ^^^^^^ reference local 5
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                             display_name it
//                                                                                                             documentation ```kotlin\nit: CheckConstraint\n```
//                                                                 ^^ reference semanticdb maven . . (it)
//                                                                    ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                                    ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                                                ^^ reference semanticdb maven . . (it)
//                                                                                   ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                                                                   ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
                  error(
//                ^^^^^ reference semanticdb maven . . kotlin/error().
                      "Cannot join with $otherTable as there is multiple primary key <-> foreign key references.\n$references"
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(otherTable)
//                                                                                                                 ^^^^^^^^^^ reference local 6
                  )
              }
  
              else -> {
                  val cond = fkKeys.filter { it.second.size == 1 }.map { it.first to it.second.single() }
//                    ^^^^ definition local 7
//                         display_name cond
//                         documentation ```kotlin\nlocal val cond: List<Pair<Column<*>, Column<*>>>\n```
//                           ^^^^^^ reference local 5
//                                  ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                         ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                 display_name it
//                                                                 documentation ```kotlin\nit: CheckConstraint\n```
//                                           ^^ reference semanticdb maven . . (it)
//                                              ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                              ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                                     ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                                     ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                                                 ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                        display_name it
//                                                                                                        documentation ```kotlin\nit: CheckConstraint\n```
//                                                                       ^^ reference semanticdb maven . . (it)
//                                                                          ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                                          ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                                                ^^ reference semanticdb maven . . kotlin/to().
//                                                                                   ^^ reference semanticdb maven . . (it)
//                                                                                      ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                                                                      ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                                                                             ^^^^^^ reference semanticdb maven . . kotlin/collections/single(+19).
                  join(otherTable, joinType, cond, additionalConstraint = null, lateral = lateral)
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(otherTable)
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(joinType)
//                                           ^^^^ reference local 7
//                                                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(lateral)
              }
          }
      }
  
      @Suppress("MemberNameEqualsClassName")
      private fun join(part: JoinPart): Join = Join(table).also {
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+1).
//                     display_name join
//                     documentation ```kotlin\n@Suppress(...) private final fun join(part: Join.JoinPart): Join\n```
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+1).(part)
//                          display_name part
//                          documentation ```kotlin\npart: Join.JoinPart\n```
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`().
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getTable().
//                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#table.
//                                                         ^^^^ reference semanticdb maven . . kotlin/also().
//                                                              ^ definition semanticdb maven . . (it) 3:5
//                                                                display_name it
//                                                                documentation ```kotlin\nit: CheckConstraint\n```
          it.joinParts.addAll(this.joinParts)
//        ^^ reference semanticdb maven . . (it)
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                     ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#addAll().
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
          it.joinParts.add(part)
//        ^^ reference semanticdb maven . . (it)
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                     ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+1).(part)
      }
  
      @Suppress("MemberNameEqualsClassName")
      private fun join(
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).
//                     display_name join
//                     documentation ```kotlin\n@Suppress(...) private final fun join(otherTable: ColumnSet, joinType: JoinType, cond: List<{org/jetbrains/exposed/v1/core/JoinCondition=} Pair<Expression<*>, Expression<*>>>, additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?, lateral: Boolean = ...): Join\n```
          otherTable: ColumnSet,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(otherTable)
//                   display_name otherTable
//                   documentation ```kotlin\notherTable: ColumnSet\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
          joinType: JoinType,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(joinType)
//                 display_name joinType
//                 documentation ```kotlin\njoinType: JoinType\n```
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
          cond: List<JoinCondition>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(cond)
//             display_name cond
//             documentation ```kotlin\ncond: List<{org/jetbrains/exposed/v1/core/JoinCondition=} Pair<Expression<*>, Expression<*>>>\n```
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?,
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(additionalConstraint)
//                             display_name additionalConstraint
//                             documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
          lateral: Boolean = false
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(lateral)
//                display_name lateral
//                documentation ```kotlin\nlateral: Boolean = ...\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      ): Join = join(JoinPart(joinType, otherTable, cond, lateral, additionalConstraint))
//       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+1).
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().
//                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(joinType)
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(otherTable)
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(cond)
//                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(lateral)
//                                                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(additionalConstraint)
  
      private fun findKeys(a: ColumnSet, b: ColumnSet): List<Pair<Column<*>, List<Column<*>>>>? = a.columns
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().
//                         display_name findKeys
//                         documentation ```kotlin\nprivate final fun findKeys(a: ColumnSet, b: ColumnSet): List<Pair<Column<*>, List<Column<*>>>>?\n```
//                         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().(a)
//                           display_name a
//                           documentation ```kotlin\na: ColumnSet\n```
//                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().(b)
//                                         display_name b
//                                         documentation ```kotlin\nb: ColumnSet\n```
//                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                                                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().(a)
//                                                                                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#columns.
//                                                                                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getColumns().
          .map { a_pk -> a_pk to b.columns.filter { it.referee == a_pk } }
//         ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//               ^^^^ definition semanticdb maven . . (a_pk)
//                    display_name a_pk
//                    documentation ```kotlin\na_pk: Column<*>\n```
//                       ^^^^ reference semanticdb maven . . (a_pk)
//                            ^^ reference semanticdb maven . . kotlin/to().
//                               ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().(b)
//                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#columns.
//                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getColumns().
//                                         ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                                ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                       display_name it
//                                                                       documentation ```kotlin\nit: CheckConstraint\n```
//                                                  ^^ reference semanticdb maven . . (it)
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getReferee().
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#referee.
//                                                                ^^^^ reference semanticdb maven . . (a_pk)
          .filter { it.second.isNotEmpty() }
//         ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                           display_name it
//                                           documentation ```kotlin\nit: CheckConstraint\n```
//                  ^^ reference semanticdb maven . . (it)
//                     ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                     ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                            ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
          .takeIf { it.isNotEmpty() }
//         ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                    display_name it
//                                    documentation ```kotlin\nit: CheckConstraint\n```
//                  ^^ reference semanticdb maven . . (it)
//                     ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
  
      /** Return `true` if the specified [table] is already in this join, `false` otherwise. */
      fun alreadyInJoin(table: Table): Boolean = joinParts.any { it.joinPart == table }
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#alreadyInJoin().
//                      display_name alreadyInJoin
//                      documentation ```kotlin\npublic final fun alreadyInJoin(table: Table): Boolean\n```\n\n----\n\n Return `true` if the specified [table] is already in this join, `false` otherwise.
//                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#alreadyInJoin().(table)
//                            display_name table
//                            documentation ```kotlin\ntable: Table\n```
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                                                         ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                                                             ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                      display_name it
//                                                                                      documentation ```kotlin\nit: CheckConstraint\n```
//                                                               ^^ reference semanticdb maven . . (it)
//                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#alreadyInJoin().(table)
  
      /** Represents a component of an existing join relation. */
      internal class JoinPart(
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#
//                            display_name JoinPart
//                            documentation ```kotlin\ninternal final class JoinPart : Any\n```\n\n----\n\n Represents a component of an existing join relation.
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().
//                            display_name JoinPart
//                            documentation ```kotlin\npublic constructor(joinType: JoinType, joinPart: ColumnSet, conditions: List<{org/jetbrains/exposed/v1/core/JoinCondition=} Pair<Expression<*>, Expression<*>>>, lateral: Boolean = ..., additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...): Join.JoinPart\n```\n\n----\n\n The column set `JOIN` type.
          /** The column set `JOIN` type. */
          val joinType: JoinType,
//            ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(joinType)
//                     display_name joinType
//                     documentation ```kotlin\njoinType: JoinType\n```\n\n----\n\n The column set `JOIN` type.
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(joinType)
//            ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinType().
//                     display_name joinType
//                     documentation ```kotlin\npublic get(): JoinType\n```\n\n----\n\n The column set `JOIN` type.
//            ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinType.
//                     display_name joinType
//                     documentation ```kotlin\npublic final val joinType: JoinType\n```\n\n----\n\n The column set `JOIN` type.
//                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
          /** The column set to join to other components of the relation. */
          val joinPart: ColumnSet,
//            ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(joinPart)
//                     display_name joinPart
//                     documentation ```kotlin\njoinPart: ColumnSet\n```\n\n----\n\n The column set to join to other components of the relation.
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(joinPart)
//            ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                     display_name joinPart
//                     documentation ```kotlin\npublic get(): ColumnSet\n```\n\n----\n\n The column set to join to other components of the relation.
//            ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                     display_name joinPart
//                     documentation ```kotlin\npublic final val joinPart: ColumnSet\n```\n\n----\n\n The column set to join to other components of the relation.
//                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
          /** The [JoinCondition] expressions used to match rows from two joined tables. */
          val conditions: List<JoinCondition>,
//            ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(conditions)
//                       display_name conditions
//                       documentation ```kotlin\nconditions: List<{org/jetbrains/exposed/v1/core/JoinCondition=} Pair<Expression<*>, Expression<*>>>\n```\n\n----\n\n The [JoinCondition] expressions used to match rows from two joined tables.
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(conditions)
//            ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#conditions.
//                       display_name conditions
//                       documentation ```kotlin\npublic final val conditions: List<{org/jetbrains/exposed/v1/core/JoinCondition=} Pair<Expression<*>, Expression<*>>>\n```\n\n----\n\n The [JoinCondition] expressions used to match rows from two joined tables.
//            ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getConditions().
//                       display_name conditions
//                       documentation ```kotlin\npublic get(): List<{org/jetbrains/exposed/v1/core/JoinCondition=} Pair<Expression<*>, Expression<*>>>\n```\n\n----\n\n The [JoinCondition] expressions used to match rows from two joined tables.
//                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          /** Indicates whether the LATERAL keyword should be included in the JOIN operation. */
          val lateral: Boolean = false,
//            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(lateral)
//                    display_name lateral
//                    documentation ```kotlin\nlateral: Boolean = ...\n```\n\n----\n\n Indicates whether the LATERAL keyword should be included in the JOIN operation.
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(lateral)
//            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getLateral().
//                    display_name lateral
//                    documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Indicates whether the LATERAL keyword should be included in the JOIN operation.
//            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#lateral.
//                    display_name lateral
//                    documentation ```kotlin\npublic final val lateral: Boolean\n```\n\n----\n\n Indicates whether the LATERAL keyword should be included in the JOIN operation.
//                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          /** The conditions used to join tables, placed in the `ON` clause. */
          val additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = null
//            ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(additionalConstraint)
//                                 display_name additionalConstraint
//                                 documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```\n\n----\n\n The conditions used to join tables, placed in the `ON` clause.
//            ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(additionalConstraint)
//            ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#additionalConstraint.
//                                 display_name additionalConstraint
//                                 documentation ```kotlin\npublic final val additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?\n```\n\n----\n\n The conditions used to join tables, placed in the `ON` clause.
//            ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getAdditionalConstraint().
//                                 display_name additionalConstraint
//                                 documentation ```kotlin\npublic get(): (SqlExpressionBuilder.() -> Op<Boolean>)?\n```\n\n----\n\n The conditions used to join tables, placed in the `ON` clause.
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      ) {
          init {
              require(
//            ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
                  joinType == JoinType.CROSS || conditions.isNotEmpty() || additionalConstraint != null
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinType().
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinType.
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#CROSS.
//                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#conditions.
//                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getConditions().
//                                                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                                                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#additionalConstraint.
//                                                                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getAdditionalConstraint().
              ) { "Missing join condition on $${this.joinPart}" }
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
  
              require(joinPart !is Table || !lateral) {
//            ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                          ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getLateral().
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#lateral.
                  "The LATERAL join can only be used with a subquery; it cannot be used to join table ${(joinPart as Table).tableName} directly."
//                                                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                                                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                                                                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
              }
          }
  
          /** Appends the SQL representation of this join component to the specified [QueryBuilder]. */
          fun describe(transaction: Transaction, builder: QueryBuilder) = with(builder) {
//            ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#describe().
//                     display_name describe
//                     documentation ```kotlin\npublic final fun describe(transaction: Transaction, builder: QueryBuilder): Unit\n```\n\n----\n\n Appends the SQL representation of this join component to the specified [QueryBuilder].
//                     ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#describe().(transaction)
//                                 display_name transaction
//                                 documentation ```kotlin\ntransaction: Transaction\n```
//                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#describe().(builder)
//                                                       display_name builder
//                                                       documentation ```kotlin\nbuilder: QueryBuilder\n```
//                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                        ^^^^ reference semanticdb maven . . kotlin/with().
//                                                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#describe().(builder)
              append(" $joinType JOIN ")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinType().
//                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinType.
  
              if (lateral) {
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getLateral().
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#lateral.
                  append("LATERAL ")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
              }
  
              val isJoin = joinPart is Join
//                ^^^^^^ definition local 8
//                       display_name isJoin
//                       documentation ```kotlin\nlocal val isJoin: Boolean\n```
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
              if (isJoin) {
//                ^^^^^^ reference local 8
                  append("(")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
              }
              joinPart.describe(transaction, this)
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().
//                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#describe().(transaction)
              if (isJoin) {
//                ^^^^^^ reference local 8
                  append(")")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
              }
              if (joinType != JoinType.CROSS) {
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinType().
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinType.
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#CROSS.
                  append(" ON ")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                  appendConditions(this)
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#appendConditions().
              }
          }
  
          /** Appends the SQL representation of the conditions in the `ON` clause to the specified [QueryBuilder]. */
          fun appendConditions(builder: QueryBuilder) = builder {
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#appendConditions().
//                             display_name appendConditions
//                             documentation ```kotlin\npublic final fun appendConditions(builder: QueryBuilder): Unit\n```\n\n----\n\n Appends the SQL representation of the conditions in the `ON` clause to the specified [QueryBuilder].
//                             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#appendConditions().(builder)
//                                     display_name builder
//                                     documentation ```kotlin\nbuilder: QueryBuilder\n```
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#appendConditions().(builder)
//                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
              conditions.appendTo(this, " AND ") { (pkColumn, fkColumn) -> append(pkColumn, " = ", fkColumn) }
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#conditions.
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getConditions().
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                                      display_name <destruct>
//                                                                      documentation ```kotlin\n<destruct>: Pair<String, Op<Boolean>>\n```
//                                                  ^^^^^^^^ definition local 9
//                                                           display_name pkColumn
//                                                           documentation ```kotlin\nlocal val pkColumn: Expression<*>\n```
//                                                  ^^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                  ^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                            ^^^^^^^^ definition local 10
//                                                                     display_name fkColumn
//                                                                     documentation ```kotlin\nlocal val fkColumn: Expression<*>\n```
//                                                            ^^^^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                            ^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                                                ^^^^^^^^ reference local 9
//                                                                                                 ^^^^^^^^ reference local 10
              if (additionalConstraint != null) {
//                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#additionalConstraint.
//                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getAdditionalConstraint().
                  if (conditions.isNotEmpty()) {
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#conditions.
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getConditions().
//                               ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
                      append(" AND ")
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                  }
                  append(" (")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                  append(SqlExpressionBuilder.(additionalConstraint)())
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#additionalConstraint.
//                                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getAdditionalConstraint().
                  append(")")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
              }
          }
      }
  }
  
  /**
   * Base class for any simple table.
   *
   * If you want to reference your table use [IdTable] instead.
   *
   * @param name Table name, by default name will be resolved from a class name with "Table" suffix removed (if present)
   */
  @Suppress("TooManyFunctions", "LargeClass")
  open class Table(name: String = "") : ColumnSet(), DdlAware {
//           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                 display_name Table
//                 documentation ```kotlin\n@Suppress(...) public open class Table : ColumnSet, DdlAware\n```\n\n----\n\n\n Base class for any simple table.\n\n If you want to reference your table use [IdTable] instead.\n\n @param name Table name, by default name will be resolved from a class name with "Table" suffix removed (if present)\n
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#Dual#
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#`<init>`().
//                 display_name Table
//                 documentation ```kotlin\npublic constructor(name: String = ...): Table\n```
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#`<init>`().(name)
//                      display_name name
//                      documentation ```kotlin\nname: String = ...\n```
//                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#
      /** Returns the table name. */
      open val tableName: String = when {
//             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                       display_name tableName
//                       documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Returns the table name.
//             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                       display_name tableName
//                       documentation ```kotlin\npublic open val tableName: String\n```\n\n----\n\n Returns the table name.
//                        ^^^^^^ reference semanticdb maven . . kotlin/String#
          name.isNotEmpty() -> name
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#`<init>`().(name)
//             ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/isNotEmpty().
//                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#`<init>`().(name)
          javaClass.`package` == null -> javaClass.name.removeSuffix("Table")
//        ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//        ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                  ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#getPackage().
//                  ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#package.
//                                       ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//                                       ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                                                 ^^^^ reference semanticdb maven jdk 11 java/lang/Class#getName().
//                                                 ^^^^ reference semanticdb maven jdk 11 java/lang/Class#name.
//                                                      ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/removeSuffix(+1).
          else -> javaClass.name.removePrefix("${javaClass.`package`.name}.").substringAfter('$').removeSuffix("Table")
//                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                          ^^^^ reference semanticdb maven jdk 11 java/lang/Class#getName().
//                          ^^^^ reference semanticdb maven jdk 11 java/lang/Class#name.
//                               ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/removePrefix(+1).
//                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//                                               ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                                                         ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#getPackage().
//                                                         ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#package.
//                                                                   ^^^^ reference semanticdb maven jdk 11 java/lang/Package#getName().
//                                                                   ^^^^ reference semanticdb maven jdk 11 java/lang/Package#name.
//                                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringAfter().
//                                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/removeSuffix(+1).
      }
  
      /** Returns the schema name, or null if one does not exist for this table.
       *
       * If the table is quoted, a dot in the name is considered part of the table name and the whole string is taken to
       * be the table name as is, so there would be no schema. If it is not quoted, whatever is after the dot is
       * considered to be the table name, and whatever is before the dot is considered to be the schema.
       */
      val schemaName: String? = if (name.contains(".") && !name.isAlreadyQuoted()) {
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getSchemaName().
//                   display_name schemaName
//                   documentation ```kotlin\npublic get(): String?\n```\n\n----\n\n Returns the schema name, or null if one does not exist for this table.\n\n If the table is quoted, a dot in the name is considered part of the table name and the whole string is taken to\n be the table name as is, so there would be no schema. If it is not quoted, whatever is after the dot is\n considered to be the table name, and whatever is before the dot is considered to be the schema.\n
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#schemaName.
//                   display_name schemaName
//                   documentation ```kotlin\npublic final val schemaName: String?\n```\n\n----\n\n Returns the schema name, or null if one does not exist for this table.\n\n If the table is quoted, a dot in the name is considered part of the table name and the whole string is taken to\n be the table name as is, so there would be no schema. If it is not quoted, whatever is after the dot is\n considered to be the table name, and whatever is before the dot is considered to be the schema.\n
//                    ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#`<init>`().(name)
//                                       ^^^^^^^^ reference semanticdb maven . . kotlin/text/contains().
//                                                        ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#`<init>`().(name)
//                                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAlreadyQuoted().
          name.substringBeforeLast(".")
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#`<init>`().(name)
//             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringBeforeLast(+1).
      } else {
          null
      }
  
      /**
       * Returns the table name without schema.
       *
       * If the table is quoted, a dot in the name is considered part of the table name and the whole string is taken to
       * be the table name as is. If it is not quoted, whatever is after the dot is considered to be the table name.
       */
      @InternalApi
      val tableNameWithoutScheme: String
//        ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithoutScheme.
//                               display_name tableNameWithoutScheme
//                               documentation ```kotlin\n@InternalApi() public final val tableNameWithoutScheme: String\n```\n\n----\n\n\n Returns the table name without schema.\n\n If the table is quoted, a dot in the name is considered part of the table name and the whole string is taken to\n be the table name as is. If it is not quoted, whatever is after the dot is considered to be the table name.\n
//                                ^^^^^^ reference semanticdb maven . . kotlin/String#
          get() = if (!tableName.isAlreadyQuoted()) tableName.substringAfterLast(".") else tableName
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutScheme().
//            display_name tableNameWithoutScheme
//            documentation ```kotlin\npublic get(): String\n```
//                    ^ reference semanticdb maven . . kotlin/Boolean#not().
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAlreadyQuoted().
//                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringAfterLast(+1).
//                                                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
  
      /**
       * Returns the table name without schema, with all quotes removed.
       *
       * Used for two purposes:
       * 1. Forming primary and foreign key names
       * 2. Comparing table names from database metadata (except MySQL and MariaDB)
       * @see org.jetbrains.exposed.v1.sql.vendors.VendorDialect.metadataMatchesTable
       */
      @InternalApi
      val tableNameWithoutSchemeSanitized: String
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithoutSchemeSanitized.
//                                        display_name tableNameWithoutSchemeSanitized
//                                        documentation ```kotlin\n@InternalApi() public final val tableNameWithoutSchemeSanitized: String\n```\n\n----\n\n\n Returns the table name without schema, with all quotes removed.\n\n Used for two purposes:\n 1. Forming primary and foreign key names\n 2. Comparing table names from database metadata (except MySQL and MariaDB)\n @see org.jetbrains.exposed.v1.sql.vendors.VendorDialect.metadataMatchesTable\n
//                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
          get() = tableNameWithoutScheme.unquoted()
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutSchemeSanitized().
//            display_name tableNameWithoutSchemeSanitized
//            documentation ```kotlin\npublic get(): String\n```
//                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutScheme().
//                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithoutScheme.
//                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#unquoted().
  
      /**
       * Returns the full table name with all quotes removed. If the table name includes a dot-prefixed schema name,
       * the full name will be returned with '_' replacing the dot characters.
       */
      private val tableNameWithSchemaSanitized: String
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithSchemaSanitized.
//                                             display_name tableNameWithSchemaSanitized
//                                             documentation ```kotlin\nprivate final val tableNameWithSchemaSanitized: String\n```\n\n----\n\n\n Returns the full table name with all quotes removed. If the table name includes a dot-prefixed schema name,\n the full name will be returned with '_' replacing the dot characters.\n
//                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
          get() = tableName.unquoted().replace('.', '_')
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithSchemaSanitized().
//            display_name tableNameWithSchemaSanitized
//            documentation ```kotlin\nprivate get(): String\n```
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#unquoted().
//                                     ^^^^^^^ reference semanticdb maven . . kotlin/text/replace().
  
      private fun String.unquoted(): String = replace("\"", "").replace("'", "").replace("`", "")
//                       ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#unquoted().
//                                display_name unquoted
//                                documentation ```kotlin\nprivate final fun String.unquoted(): String\n```
//                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                            ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
//                                                              ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
//                                                                               ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
  
      private val _columns = mutableListOf<Column<*>>()
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_columns.
//                         display_name _columns
//                         documentation ```kotlin\nprivate final val _columns: MutableList<Column<*>>\n```
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_columns().
//                         display_name _columns
//                         documentation ```kotlin\nprivate get(): MutableList<Column<*>>\n```
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
  
      /** Returns all the columns defined on the table. */
      override val columns: List<Column<*>> get() = _columns
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                         display_name columns
//                         documentation ```kotlin\npublic open override val columns: List<Column<*>>\n```\n\n----\n\n Returns all the columns defined on the table.
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                          ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                                              display_name columns
//                                              documentation ```kotlin\npublic get(): List<Column<*>>\n```
//                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_columns.
//                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_columns().
  
      /** Returns the first auto-increment column on the table. */
      val autoIncColumn: Column<*>? get() = columns.firstOrNull { it.columnType.isAutoInc }
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncColumn.
//                      display_name autoIncColumn
//                      documentation ```kotlin\npublic final val autoIncColumn: Column<*>?\n```\n\n----\n\n Returns the first auto-increment column on the table.
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                  ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getAutoIncColumn().
//                                      display_name autoIncColumn
//                                      documentation ```kotlin\npublic get(): Column<*>?\n```
//                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                                                  ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+20).
//                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                          display_name it
//                                                                                          documentation ```kotlin\nit: CheckConstraint\n```
//                                                                ^^ reference semanticdb maven . . (it)
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//                                                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
  
      private val _indices = mutableListOf<Index>()
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_indices.
//                         display_name _indices
//                         documentation ```kotlin\nprivate final val _indices: MutableList<Index>\n```
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_indices().
//                         display_name _indices
//                         documentation ```kotlin\nprivate get(): MutableList<Index>\n```
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
  
      /** Returns all indices declared on the table. */
      val indices: List<Index> get() = _indices
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#indices.
//                display_name indices
//                documentation ```kotlin\npublic final val indices: List<Index>\n```\n\n----\n\n Returns all indices declared on the table.
//                 ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                             ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getIndices().
//                                 display_name indices
//                                 documentation ```kotlin\npublic get(): List<Index>\n```
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_indices.
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_indices().
  
      private val _foreignKeys = mutableListOf<ForeignKeyConstraint>()
//                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_foreignKeys.
//                             display_name _foreignKeys
//                             documentation ```kotlin\nprivate final val _foreignKeys: MutableList<ForeignKeyConstraint>\n```
//                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_foreignKeys().
//                             display_name _foreignKeys
//                             documentation ```kotlin\nprivate get(): MutableList<ForeignKeyConstraint>\n```
//                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
  
      /** Returns all foreign key constraints declared on the table. */
      val foreignKeys: List<ForeignKeyConstraint> get() = columns.mapNotNull { it.foreignKey } + _foreignKeys
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKeys.
//                    display_name foreignKeys
//                    documentation ```kotlin\npublic final val foreignKeys: List<ForeignKeyConstraint>\n```\n\n----\n\n Returns all foreign key constraints declared on the table.
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getForeignKeys().
//                                                    display_name foreignKeys
//                                                    documentation ```kotlin\npublic get(): List<ForeignKeyConstraint>\n```
//                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                                                                ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mapNotNull(+1).
//                                                                           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                             display_name it
//                                                                                             documentation ```kotlin\nit: CheckConstraint\n```
//                                                                             ^^ reference semanticdb maven . . (it)
//                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//                                                                                             ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_foreignKeys.
//                                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_foreignKeys().
  
      /**
       * Returns all sequences declared on the table, along with any auto-generated sequences that are not explicitly
       * declared by the user but associated with the table.
       */
      val sequences: List<Sequence>
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#sequences.
//                  display_name sequences
//                  documentation ```kotlin\npublic final val sequences: List<Sequence>\n```\n\n----\n\n\n Returns all sequences declared on the table, along with any auto-generated sequences that are not explicitly\n declared by the user but associated with the table.\n
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          get() = columns.filter { it.columnType.isAutoInc }.mapNotNull { column ->
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getSequences().
//            display_name sequences
//            documentation ```kotlin\npublic get(): List<Sequence>\n```
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                        ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                           display_name it
//                                                           documentation ```kotlin\nit: CheckConstraint\n```
//                                 ^^ reference semanticdb maven . . (it)
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
//                                                           ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mapNotNull(+1).
//                                                                        ^^^^^^ definition semanticdb maven . . (column)
//                                                                               display_name column
//                                                                               documentation ```kotlin\ncolumn: Column<*>\n```
              column.autoIncColumnType?.sequence
//            ^^^^^^ reference semanticdb maven . . (column)
//                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.
                  ?: column.takeIf { currentDialect is PostgreSQLDialect }?.let {
//                   ^^^^^^ reference semanticdb maven . . (column)
//                          ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                         display_name it
//                                                                         documentation ```kotlin\nit: CheckConstraint\n```
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                          ^^^ reference semanticdb maven . . kotlin/let().
//                                                                              ^ definition semanticdb maven . . (it) 8:17
//                                                                                display_name it
//                                                                                documentation ```kotlin\nit: CheckConstraint\n```
                      val fallbackSequenceName = fallbackSequenceName(tableName = tableName, columnName = it.name)
//                        ^^^^^^^^^^^^^^^^^^^^ definition local 11
//                                             display_name fallbackSequenceName
//                                             documentation ```kotlin\nlocal val fallbackSequenceName: String\n```
//                                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().
//                                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                                                        ^^ reference semanticdb maven . . (it)
//                                                                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
                      Sequence(
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().
                          fallbackSequenceName,
//                        ^^^^^^^^^^^^^^^^^^^^ reference local 11
                          startWith = 1,
                          minValue = 1,
                          maxValue = currentDialect.sequenceMaxValue
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSequenceMaxValue().
//                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#sequenceMaxValue.
                      )
                  }
          }
  
      private val checkConstraints = mutableListOf<Pair<String, Op<Boolean>>>()
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints.
//                                 display_name checkConstraints
//                                 documentation ```kotlin\nprivate final val checkConstraints: MutableList<Pair<String, Op<Boolean>>>\n```
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getCheckConstraints().
//                                 display_name checkConstraints
//                                 documentation ```kotlin\nprivate get(): MutableList<Pair<String, Op<Boolean>>>\n```
//                                   ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
  
      private val generatedUnsignedCheckPrefix
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedUnsignedCheckPrefix.
//                                             display_name generatedUnsignedCheckPrefix
//                                             documentation ```kotlin\nprivate final val generatedUnsignedCheckPrefix: String\n```
          get() = "chk_${tableNameWithSchemaSanitized}_unsigned_"
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedUnsignedCheckPrefix().
//            display_name generatedUnsignedCheckPrefix
//            documentation ```kotlin\nprivate get(): String\n```
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithSchemaSanitized().
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithSchemaSanitized.
  
      private val generatedSignedCheckPrefix
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                           display_name generatedSignedCheckPrefix
//                                           documentation ```kotlin\nprivate final val generatedSignedCheckPrefix: String\n```
          get() = "chk_${tableNameWithSchemaSanitized}_signed_"
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
//            display_name generatedSignedCheckPrefix
//            documentation ```kotlin\nprivate get(): String\n```
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithSchemaSanitized().
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithSchemaSanitized.
  
      /** Returns the list of CHECK constraints in this table. */
      fun checkConstraints(): List<CheckConstraint> {
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints(+1).
//                         display_name checkConstraints
//                         documentation ```kotlin\npublic final fun checkConstraints(): List<CheckConstraint>\n```\n\n----\n\n Returns the list of CHECK constraints in this table.
//                            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          val filteredChecks = checkConstraints.filterNot { (name, _) ->
//            ^^^^^^^^^^^^^^ definition local 12
//                           display_name filteredChecks
//                           documentation ```kotlin\nlocal val filteredChecks: MutableList<Pair<String, Op<Boolean>>>\n```
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints.
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getCheckConstraints().
//                                              ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterNot(+9).
//                                                          ^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                                    display_name <destruct>
//                                                                    documentation ```kotlin\n<destruct>: Pair<String, Op<Boolean>>\n```
//                                                           ^^^^ definition local 13
//                                                                display_name name
//                                                                documentation ```kotlin\nlocal val name: String\n```
//                                                           ^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                           ^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                                 ^ definition local 14
//                                                                   display_name <unused var>
//                                                                   documentation ```kotlin\nlocal val <unused var>: Op<Boolean>\n```
//                                                                 ^ reference semanticdb maven . . (`<destruct>`)
//                                                                 ^ reference semanticdb maven . . kotlin/Pair#component2().
              when (val dialect = currentDialect) {
//                      ^^^^^^^ definition local 15
//                              display_name dialect
//                              documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
                  is MysqlDialect -> name.startsWith(generatedUnsignedCheckPrefix) || name.startsWith(generatedSignedCheckPrefix)
//                                   ^^^^ reference local 13
//                                        ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedUnsignedCheckPrefix.
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedUnsignedCheckPrefix().
//                                                                                    ^^^^ reference local 13
//                                                                                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
                  is SQLServerDialect -> name.startsWith("${generatedUnsignedCheckPrefix}byte") ||
//                                       ^^^^ reference local 13
//                                            ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedUnsignedCheckPrefix.
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedUnsignedCheckPrefix().
                      name.startsWith("${generatedSignedCheckPrefix}short")
//                    ^^^^ reference local 13
//                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
                  is PostgreSQLDialect -> name.startsWith("${generatedSignedCheckPrefix}short")
//                                        ^^^^ reference local 13
//                                             ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
                  is H2Dialect -> when (dialect.h2Mode) {
//                                      ^^^^^^^ reference local 15
//                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode().
//                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode.
                      H2Dialect.H2CompatibilityMode.PostgreSQL -> name.startsWith("${generatedSignedCheckPrefix}short")
//                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#PostgreSQL.
//                                                                ^^^^ reference local 13
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
                      else -> name.startsWith(generatedSignedCheckPrefix)
//                            ^^^^ reference local 13
//                                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
                  }
                  else -> false
              }
          }.toMutableList().apply {
//          ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/toMutableList(+10).
//                          ^^^^^ reference semanticdb maven . . kotlin/apply().
              val isNotSQLiteOrOracle = currentDialect !is SQLiteDialect && currentDialect !is OracleDialect
//                ^^^^^^^^^^^^^^^^^^^ definition local 16
//                                    display_name isNotSQLiteOrOracle
//                                    documentation ```kotlin\nlocal val isNotSQLiteOrOracle: Boolean\n```
//                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
              val isNotOracle = currentDialect !is OracleDialect
//                ^^^^^^^^^^^ definition local 17
//                            display_name isNotOracle
//                            documentation ```kotlin\nlocal val isNotOracle: Boolean\n```
//                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
  
              if (isNotSQLiteOrOracle) removeAll { (name, _) -> name.startsWith("${generatedSignedCheckPrefix}integer") }
//                ^^^^^^^^^^^^^^^^^^^ reference local 16
//                                     ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/removeAll(+5).
//                                                 ^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                           display_name <destruct>
//                                                           documentation ```kotlin\n<destruct>: Pair<String, Op<Boolean>>\n```
//                                                  ^^^^ definition local 18
//                                                       display_name name
//                                                       documentation ```kotlin\nlocal val name: String\n```
//                                                  ^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                  ^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                        ^ definition local 19
//                                                          display_name <unused var>
//                                                          documentation ```kotlin\nlocal val <unused var>: Op<Boolean>\n```
//                                                        ^ reference semanticdb maven . . (`<destruct>`)
//                                                        ^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                              ^^^^ reference local 18
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
              if (isNotOracle) removeAll { (name, _) -> name.startsWith("${generatedSignedCheckPrefix}long") }
//                ^^^^^^^^^^^ reference local 17
//                             ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/removeAll(+5).
//                                         ^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                   display_name <destruct>
//                                                   documentation ```kotlin\n<destruct>: Pair<String, Op<Boolean>>\n```
//                                          ^^^^ definition local 20
//                                               display_name name
//                                               documentation ```kotlin\nlocal val name: String\n```
//                                          ^^^^ reference semanticdb maven . . (`<destruct>`)
//                                          ^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                ^ definition local 21
//                                                  display_name <unused var>
//                                                  documentation ```kotlin\nlocal val <unused var>: Op<Boolean>\n```
//                                                ^ reference semanticdb maven . . (`<destruct>`)
//                                                ^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                      ^^^^ reference local 20
//                                                           ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
          }
          return filteredChecks.mapIndexed { index, (name, op) ->
//               ^^^^^^^^^^^^^^ reference local 12
//                              ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mapIndexed(+9).
//                                           ^^^^^ definition semanticdb maven . . (index)
//                                                 display_name index
//                                                 documentation ```kotlin\nindex: Int\n```
//                                                  ^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                             display_name <destruct>
//                                                             documentation ```kotlin\n<destruct>: Pair<String, Op<Boolean>>\n```
//                                                   ^^^^ definition local 22
//                                                        display_name name
//                                                        documentation ```kotlin\nlocal val name: String\n```
//                                                   ^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                   ^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                         ^^ definition local 23
//                                                            display_name op
//                                                            documentation ```kotlin\nlocal val op: Op<Boolean>\n```
//                                                         ^^ reference semanticdb maven . . (`<destruct>`)
//                                                         ^^ reference semanticdb maven . . kotlin/Pair#component2().
              val resolvedName = name.ifBlank { "check_${tableNameWithSchemaSanitized}_$index" }
//                ^^^^^^^^^^^^ definition local 24
//                             display_name resolvedName
//                             documentation ```kotlin\nlocal val resolvedName: String\n```
//                               ^^^^ reference local 22
//                                    ^^^^^^^ reference semanticdb maven . . kotlin/text/ifBlank().
//                                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithSchemaSanitized().
//                                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithSchemaSanitized.
//                                                                                      ^^^^^ reference semanticdb maven . . (index)
              CheckConstraint.from(this@Table, resolvedName, op)
//                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#Companion#from().
//                                             ^^^^^^^^^^^^ reference local 24
//                                                           ^^ reference local 23
          }
      }
  
      /**
       * Returns the table name in proper case.
       * Should be called within transaction or default [tableName] will be returned.
       */
      @OptIn(InternalApi::class)
      fun nameInDatabaseCase(): String = tableName.inProperCase()
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nameInDatabaseCase().
//                           display_name nameInDatabaseCase
//                           documentation ```kotlin\n@OptIn(...) public final fun nameInDatabaseCase(): String\n```\n\n----\n\n\n Returns the table name in proper case.\n Should be called within transaction or default [tableName] will be returned.\n
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
  
      /**
       * Returns the table name, without schema and in proper case, with wrapping single- and double-quotation characters removed.
       *
       * **Note** If used with MySQL or MariaDB, the table name is returned unchanged, since these databases use a
       * backtick character as the identifier quotation.
       */
      fun nameInDatabaseCaseUnquoted(): String = if (currentDialect is MysqlDialect) {
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nameInDatabaseCaseUnquoted().
//                                   display_name nameInDatabaseCaseUnquoted
//                                   documentation ```kotlin\npublic final fun nameInDatabaseCaseUnquoted(): String\n```\n\n----\n\n\n Returns the table name, without schema and in proper case, with wrapping single- and double-quotation characters removed.\n\n **Note** If used with MySQL or MariaDB, the table name is returned unchanged, since these databases use a\n backtick character as the identifier quotation.\n
//                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
          @OptIn(InternalApi::class)
          tableNameWithoutScheme.inProperCase()
//        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutScheme().
//        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithoutScheme.
//                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
      } else {
          @OptIn(InternalApi::class)
          tableNameWithoutScheme.inProperCase().trim('\"', '\'')
//        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutScheme().
//        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithoutScheme.
//                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
//                                              ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
      }
  
      override fun describe(s: Transaction, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().
//                          display_name describe
//                          documentation ```kotlin\npublic open override fun describe(s: Transaction, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().
//                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().(s)
//                            display_name s
//                            documentation ```kotlin\ns: Transaction\n```
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                          ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().(queryBuilder)
//                                                       display_name queryBuilder
//                                                       documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                       ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().(queryBuilder)
          append(
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
              s.identity(this@Table)
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().(s)
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
          )
      }
  
      // Join operations
  
      override fun join(
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().
//                      display_name join
//                      documentation ```kotlin\npublic open override fun join(otherTable: ColumnSet, joinType: JoinType, onColumn: Expression<*>?, otherColumn: Expression<*>?, lateral: Boolean, additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?): Join\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().
          otherTable: ColumnSet,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(otherTable)
//                   display_name otherTable
//                   documentation ```kotlin\notherTable: ColumnSet\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
          joinType: JoinType,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(joinType)
//                 display_name joinType
//                 documentation ```kotlin\njoinType: JoinType\n```
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
          onColumn: Expression<*>?,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(onColumn)
//                 display_name onColumn
//                 documentation ```kotlin\nonColumn: Expression<*>?\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          otherColumn: Expression<*>?,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(otherColumn)
//                    display_name otherColumn
//                    documentation ```kotlin\notherColumn: Expression<*>?\n```
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          lateral: Boolean,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(lateral)
//                display_name lateral
//                documentation ```kotlin\nlateral: Boolean\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(additionalConstraint)
//                             display_name additionalConstraint
//                             documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      ): Join = Join(this, otherTable, joinType, onColumn, otherColumn, lateral, additionalConstraint)
//       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).
//                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(otherTable)
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(joinType)
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(onColumn)
//                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(otherColumn)
//                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(lateral)
//                                                                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(additionalConstraint)
  
      override infix fun innerJoin(otherTable: ColumnSet): Join = Join(this, otherTable, JoinType.INNER)
//                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#innerJoin().
//                                 display_name innerJoin
//                                 documentation ```kotlin\npublic open override infix fun innerJoin(otherTable: ColumnSet): Join\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#innerJoin().
//                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#innerJoin().(otherTable)
//                                            display_name otherTable
//                                            documentation ```kotlin\notherTable: ColumnSet\n```
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#innerJoin().(otherTable)
//                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#INNER.
  
      override infix fun leftJoin(otherTable: ColumnSet): Join = Join(this, otherTable, JoinType.LEFT)
//                       ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#leftJoin().
//                                display_name leftJoin
//                                documentation ```kotlin\npublic open override infix fun leftJoin(otherTable: ColumnSet): Join\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#leftJoin().
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#leftJoin().(otherTable)
//                                           display_name otherTable
//                                           documentation ```kotlin\notherTable: ColumnSet\n```
//                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).
//                                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#leftJoin().(otherTable)
//                                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#LEFT.
  
      override infix fun rightJoin(otherTable: ColumnSet): Join = Join(this, otherTable, JoinType.RIGHT)
//                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#rightJoin().
//                                 display_name rightJoin
//                                 documentation ```kotlin\npublic open override infix fun rightJoin(otherTable: ColumnSet): Join\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#rightJoin().
//                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#rightJoin().(otherTable)
//                                            display_name otherTable
//                                            documentation ```kotlin\notherTable: ColumnSet\n```
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#rightJoin().(otherTable)
//                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#RIGHT.
  
      override infix fun fullJoin(otherTable: ColumnSet): Join = Join(this, otherTable, JoinType.FULL)
//                       ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#fullJoin().
//                                display_name fullJoin
//                                documentation ```kotlin\npublic open override infix fun fullJoin(otherTable: ColumnSet): Join\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fullJoin().
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#fullJoin().(otherTable)
//                                           display_name otherTable
//                                           documentation ```kotlin\notherTable: ColumnSet\n```
//                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).
//                                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#fullJoin().(otherTable)
//                                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#FULL.
  
      override infix fun crossJoin(otherTable: ColumnSet): Join = Join(this, otherTable, JoinType.CROSS)
//                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#crossJoin().
//                                 display_name crossJoin
//                                 documentation ```kotlin\npublic open override infix fun crossJoin(otherTable: ColumnSet): Join\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#crossJoin().
//                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#crossJoin().(otherTable)
//                                            display_name otherTable
//                                            documentation ```kotlin\notherTable: ColumnSet\n```
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#crossJoin().(otherTable)
//                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#CROSS.
  
      // Column registration
  
      /** Adds a column of the specified [type] and with the specified [name] to the table. */
      fun <T> registerColumn(name: String, type: IColumnType<T & Any>): Column<T> = Column<T>(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//            ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                           display_name registerColumn
//                           documentation ```kotlin\npublic final fun <T> registerColumn(name: String, type: IColumnType<T & Any>): Column<T>\n```\n\n----\n\n Adds a column of the specified [type] and with the specified [name] to the table.
//                           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().(name)
//                                display_name name
//                                documentation ```kotlin\nname: String\n```
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().(type)
//                                              display_name type
//                                              documentation ```kotlin\ntype: IColumnType<T & Any>\n```
//                                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
          this,
          name,
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().(name)
          type
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().(type)
      ).also { _columns.addColumn(it) }
//      ^^^^ reference semanticdb maven . . kotlin/also().
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                      display_name it
//                                      documentation ```kotlin\nit: CheckConstraint\n```
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_columns.
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_columns().
//                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().
//                                ^^ reference semanticdb maven . . (it)
  
      /** Adds all wrapped column components of a [CompositeColumn] to the table. */
      fun <R, T : CompositeColumn<R>> registerCompositeColumn(column: T): T = column.apply {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerCompositeColumn().[R]
//           display_name FirTypeParameterSymbol R
//           documentation ```kotlin\nR\n```
//            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerCompositeColumn().[T]
//              display_name FirTypeParameterSymbol T
//              documentation ```kotlin\nT : CompositeColumn<R>\n```
//                                    ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerCompositeColumn().
//                                                            display_name registerCompositeColumn
//                                                            documentation ```kotlin\npublic final fun <R, T : CompositeColumn<R>> registerCompositeColumn(column: T): T\n```\n\n----\n\n Adds all wrapped column components of a [CompositeColumn] to the table.
//                                                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerCompositeColumn().(column)
//                                                                   display_name column
//                                                                   documentation ```kotlin\ncolumn: T\n```
//                                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerCompositeColumn().(column)
//                                                                                   ^^^^^ reference semanticdb maven . . kotlin/apply().
          getRealColumns().forEach {
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumns().
//                         ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                 ^ definition semanticdb maven . . (it) 4:9
//                                   display_name it
//                                   documentation ```kotlin\nit: CheckConstraint\n```
              _columns.addColumn(
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_columns.
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_columns().
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().
                  it
//                ^^ reference semanticdb maven . . (it)
              )
          }
      }
  
      /**
       * Replaces the specified [oldColumn] with the specified [newColumn] in the table.
       * Mostly used internally by the library.
       */
      fun <TColumn : Column<*>> replaceColumn(oldColumn: Column<*>, newColumn: TColumn): TColumn {
//         ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().[TColumn]
//                 display_name FirTypeParameterSymbol TColumn
//                 documentation ```kotlin\nTColumn : Column<*>\n```
//                              ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                            display_name replaceColumn
//                                            documentation ```kotlin\npublic final fun <TColumn : Column<*>> replaceColumn(oldColumn: Column<*>, newColumn: TColumn): TColumn\n```\n\n----\n\n\n Replaces the specified [oldColumn] with the specified [newColumn] in the table.\n Mostly used internally by the library.\n
//                                            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().(oldColumn)
//                                                      display_name oldColumn
//                                                      documentation ```kotlin\noldColumn: Column<*>\n```
//                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().(newColumn)
//                                                                            display_name newColumn
//                                                                            documentation ```kotlin\nnewColumn: TColumn\n```
          _columns.remove(oldColumn)
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_columns.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_columns().
//                 ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#remove().
//                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().(oldColumn)
          _columns.addColumn(newColumn)
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_columns.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_columns().
//                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().
//                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().(newColumn)
          return newColumn
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().(newColumn)
      }
  
      private fun MutableList<Column<*>>.addColumn(column: Column<*>) {
//                                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().
//                                                 display_name addColumn
//                                                 documentation ```kotlin\nprivate final fun MutableList<Column<*>>.addColumn(column: Column<*>): Unit\n```
//                                                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().(column)
//                                                        display_name column
//                                                        documentation ```kotlin\ncolumn: Column<*>\n```
//                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          if (this.any { it.name == column.name }) {
//                 ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                display_name it
//                                                documentation ```kotlin\nit: CheckConstraint\n```
//                       ^^ reference semanticdb maven . . (it)
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().(column)
//                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
              throw DuplicateColumnException(column.name, tableName)
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/DuplicateColumnException#`<init>`().
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().(column)
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
          }
          this.add(column)
//             ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().(column)
      }
  
      // Primary keys
  
      internal fun isCustomPKNameDefined(): Boolean = primaryKey?.let {
//                 ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#isCustomPKNameDefined().
//                                       display_name isCustomPKNameDefined
//                                       documentation ```kotlin\ninternal final fun isCustomPKNameDefined(): Boolean\n```
//                                          ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                                                                ^^^ reference semanticdb maven . . kotlin/let().
//                                                                    ^ definition semanticdb maven . . (it) 3:5
//                                                                      display_name it
//                                                                      documentation ```kotlin\nit: CheckConstraint\n```
          @OptIn(InternalApi::class)
          it.name != "pk_$tableNameWithoutSchemeSanitized"
//        ^^ reference semanticdb maven . . (it)
//           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getName().
//           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#name.
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutSchemeSanitized().
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithoutSchemeSanitized.
      } == true
  
      /**
       * Represents a primary key composed by the specified [columns], and with the specified [name].
       * If no name is specified, the table name with the "pk_" prefix will be used instead.
       *
       * @sample org.jetbrains.exposed.v1.tests.demo.sql.Users
       */
      inner class PrimaryKey(
//                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#
//                           display_name PrimaryKey
//                           documentation ```kotlin\npublic final inner class PrimaryKey : Any\n```\n\n----\n\n\n Represents a primary key composed by the specified [columns], and with the specified [name].\n If no name is specified, the table name with the "pk_" prefix will be used instead.\n\n @sample org.jetbrains.exposed.v1.tests.demo.sql.Users\n
//                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`().
//                           display_name PrimaryKey
//                           documentation ```kotlin\npublic Table.constructor(columns: Array<Column<*>>, name: String? = ...): Table.PrimaryKey\n```\n\n----\n\n Returns the columns that compose the primary key.
          /** Returns the columns that compose the primary key. */
          val columns: Array<Column<*>>,
//            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`().(columns)
//                    display_name columns
//                    documentation ```kotlin\ncolumns: Array<Column<*>>\n```\n\n----\n\n Returns the columns that compose the primary key.
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`().(columns)
//            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                    display_name columns
//                    documentation ```kotlin\npublic final val columns: Array<Column<*>>\n```\n\n----\n\n Returns the columns that compose the primary key.
//            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                    display_name columns
//                    documentation ```kotlin\npublic get(): Array<Column<*>>\n```\n\n----\n\n Returns the columns that compose the primary key.
//                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
          name: String? = null
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`().(name)
//             display_name name
//             documentation ```kotlin\nname: String? = ...\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/String#
      ) {
          /** Returns the name of the primary key. */
          val name: String by lazy {
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getName().
//                 display_name name
//                 documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Returns the name of the primary key.
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#name.
//                 display_name name
//                 documentation ```kotlin\npublic final val name: String\n```\n\n----\n\n Returns the name of the primary key.
//                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                            ^^^^ reference semanticdb maven . . kotlin/lazy().
//                            ^^^^^^ reference semanticdb maven . . kotlin/getValue(). 3:9
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getName(). 3:9
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#name. 3:9
              @OptIn(InternalApi::class)
              name ?: "pk_$tableNameWithoutSchemeSanitized"
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`().(name)
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutSchemeSanitized().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithoutSchemeSanitized.
          }
  
          constructor(firstColumn: Column<*>, vararg columns: Column<*>, name: String? = null) :
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1). 1:63
//                                                                                               display_name PrimaryKey
//                                                                                               documentation ```kotlin\npublic Table.constructor(firstColumn: Column<*>, vararg columns: Column<*>, name: String? = ...): Table.PrimaryKey\n```
//                    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).(firstColumn)
//                                display_name firstColumn
//                                documentation ```kotlin\nfirstColumn: Column<*>\n```
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                   ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).(columns)
//                                                           display_name columns
//                                                           documentation ```kotlin\nvararg columns: Column<*>\n```
//                                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).(name)
//                                                                            display_name name
//                                                                            documentation ```kotlin\nname: String? = ...\n```
//                                                                             ^^^^^^^ reference semanticdb maven . . kotlin/String#
              this(arrayOf(firstColumn) + columns.asList(), name)
//                 ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).(firstColumn)
//                                      ^ reference semanticdb maven . . kotlin/collections/plus(+9).
//                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).(columns)
//                                                ^^^^^^ reference semanticdb maven . . kotlin/collections/asList().
//                                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).(name)
  
          init {
              columns.sortWith(compareBy { !it.columnType.isAutoInc })
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                    ^^^^^^^^ reference semanticdb maven . . kotlin/collections/sortWith().
//                             ^^^^^^^^^ reference semanticdb maven . . kotlin/comparisons/compareBy(+1).
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                    display_name it
//                                                                    documentation ```kotlin\nit: CheckConstraint\n```
//                                         ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                          ^^ reference semanticdb maven . . (it)
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
          }
      }
  
      /**
       * Returns the primary key of the table if present, `null` otherwise.
       *
       * The primary key can be defined explicitly by overriding the property directly or by using one of the predefined
       * table types like `IntIdTable`, `LongIdTable`, or `UUIDIdTable`.
       */
      open val primaryKey: PrimaryKey? = null
//             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//                        display_name primaryKey
//                        documentation ```kotlin\npublic get(): Table.PrimaryKey?\n```\n\n----\n\n\n Returns the primary key of the table if present, `null` otherwise.\n\n The primary key can be defined explicitly by overriding the property directly or by using one of the predefined\n table types like `IntIdTable`, `LongIdTable`, or `UUIDIdTable`.\n
//             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                        display_name primaryKey
//                        documentation ```kotlin\npublic open val primaryKey: Table.PrimaryKey?\n```\n\n----\n\n\n Returns the primary key of the table if present, `null` otherwise.\n\n The primary key can be defined explicitly by overriding the property directly or by using one of the predefined\n table types like `IntIdTable`, `LongIdTable`, or `UUIDIdTable`.\n
//                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#
  
      // EntityID columns
  
      /** Converts the @receiver column to an [EntityID] column. */
      @Suppress("UNCHECKED_CAST")
      fun <T : Any> Column<T>.entityId(): Column<EntityID<T>> {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                            ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId().
//                                     display_name entityId
//                                     documentation ```kotlin\n@Suppress(...) public final fun <T : Any> Column<T>.entityId(): Column<EntityID<T>>\n```\n\n----\n\n Converts the @receiver column to an [EntityID] column.
//                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          val newColumn = Column<EntityID<T>>(table, name, EntityIDColumnType(this)).also {
//            ^^^^^^^^^ definition local 25
//                      display_name newColumn
//                      documentation ```kotlin\nlocal val newColumn: Column<EntityID<T>>\n```
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#`<init>`().
//                                                                                   ^^^^ reference semanticdb maven . . kotlin/also().
//                                                                                        ^ definition semanticdb maven . . (it) 4:9
//                                                                                          display_name it
//                                                                                          documentation ```kotlin\nit: CheckConstraint\n```
              it.defaultValueFun = defaultValueFun?.let { { EntityIDFunctionProvider.createEntityID(it(), table as IdTable<T>) } }
//            ^^ reference semanticdb maven . . (it)
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                  ^^^ reference semanticdb maven . . kotlin/let().
//                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                                 display_name it
//                                                                                                                                 documentation ```kotlin\nit: CheckConstraint\n```
//                                                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#createEntityID().
//                                                                                                  ^^ reference semanticdb maven . . (it)
//                                                                                                  ^^ reference semanticdb maven . . kotlin/Function0#invoke().
//                                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
              it.dbDefaultValue = dbDefaultValue?.let { default -> default as Expression<EntityID<T>> }
//            ^^ reference semanticdb maven . . (it)
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                ^^^ reference semanticdb maven . . kotlin/let().
//                                                      ^^^^^^^ definition semanticdb maven . . (default)
//                                                              display_name default
//                                                              documentation ```kotlin\ndefault: Expression<T>\n```
//                                                                 ^^^^^^^ reference semanticdb maven . . (default)
              it.extraDefinitions = extraDefinitions
//            ^^ reference semanticdb maven . . (it)
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
          }
          (table as IdTable<T>).addIdColumnInternal(newColumn)
//         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#addIdColumnInternal().
//                                                  ^^^^^^^^^ reference local 25
          return replaceColumn(this, newColumn)
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                   ^^^^^^^^^ reference local 25
      }
  
      /** Creates an [EntityID] column, with the specified [name], for storing the same objects as the specified [originalColumn]. */
      fun <ID : Any> entityId(name: String, originalColumn: Column<ID>): Column<EntityID<ID>> {
//         ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).[ID]
//            display_name FirTypeParameterSymbol ID
//            documentation ```kotlin\nID : Any\n```
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).
//                            display_name entityId
//                            documentation ```kotlin\npublic final fun <ID : Any> entityId(name: String, originalColumn: Column<ID>): Column<EntityID<ID>>\n```\n\n----\n\n Creates an [EntityID] column, with the specified [name], for storing the same objects as the specified [originalColumn].
//                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).(name)
//                                 display_name name
//                                 documentation ```kotlin\nname: String\n```
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                          ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).(originalColumn)
//                                                         display_name originalColumn
//                                                         documentation ```kotlin\noriginalColumn: Column<ID>\n```
//                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          val columnTypeCopy = originalColumn.columnType.cloneAsBaseType()
//            ^^^^^^^^^^^^^^ definition local 26
//                           display_name columnTypeCopy
//                           documentation ```kotlin\nlocal val columnTypeCopy: IColumnType<ID>\n```
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).(originalColumn)
//                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneAsBaseType().
          val answer = Column<EntityID<ID>>(
//            ^^^^^^ definition local 27
//                   display_name answer
//                   documentation ```kotlin\nlocal val answer: Column<EntityID<ID>>\n```
//                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
              this,
              name,
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).(name)
              EntityIDColumnType(Column<ID>(originalColumn.table, name, columnTypeCopy))
//            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#`<init>`().
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).(originalColumn)
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).(name)
//                                                                      ^^^^^^^^^^^^^^ reference local 26
          )
          _columns.addColumn(answer)
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_columns.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_columns().
//                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().
//                           ^^^^^^ reference local 27
          return answer
//               ^^^^^^ reference local 27
      }
  
      /** Creates an [EntityID] column, with the specified [name], for storing the identifier of the specified [table]. */
      @Suppress("UNCHECKED_CAST")
      fun <ID : Any> entityId(name: String, table: IdTable<ID>): Column<EntityID<ID>> {
//         ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).[ID]
//            display_name FirTypeParameterSymbol ID
//            documentation ```kotlin\nID : Any\n```
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).
//                            display_name entityId
//                            documentation ```kotlin\n@Suppress(...) public final fun <ID : Any> entityId(name: String, table: IdTable<ID>): Column<EntityID<ID>>\n```\n\n----\n\n Creates an [EntityID] column, with the specified [name], for storing the identifier of the specified [table].
//                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).(name)
//                                 display_name name
//                                 documentation ```kotlin\nname: String\n```
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).(table)
//                                                display_name table
//                                                documentation ```kotlin\ntable: IdTable<ID>\n```
//                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          val originalColumn = (table.id.columnType as EntityIDColumnType<*>).idColumn as Column<ID>
//            ^^^^^^^^^^^^^^ definition local 28
//                           display_name originalColumn
//                           documentation ```kotlin\nlocal val originalColumn: Column<ID>\n```
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).(table)
//                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#getId().
//                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#id.
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
          return entityId(name, originalColumn)
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).(name)
//                              ^^^^^^^^^^^^^^ reference local 28
      }
  
      /**
       * Returns a boolean operator comparing each of an IdTable's `idColumns` to its corresponding
       * value in [toCompare], using the specified SQL [booleanOperator].
       *
       * @throws IllegalStateException If this is not an [IdTable], or if [toCompare] is either not
       * a matching id type or it does not contain a key for each component column.
       */
      internal open fun mapIdComparison(
//                      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().
//                                      display_name mapIdComparison
//                                      documentation ```kotlin\ninternal open fun mapIdComparison(toCompare: Any?, booleanOperator: (Column<*>, Expression<*>) -> Op<Boolean>): Op<Boolean>\n```\n\n----\n\n\n Returns a boolean operator comparing each of an IdTable's `idColumns` to its corresponding\n value in [toCompare], using the specified SQL [booleanOperator].\n\n @throws IllegalStateException If this is not an [IdTable], or if [toCompare] is either not\n a matching id type or it does not contain a key for each component column.\n
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdComparison().
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#mapIdComparison().
          toCompare: Any?,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().(toCompare)
//                  display_name toCompare
//                  documentation ```kotlin\ntoCompare: Any?\n```
//                   ^^^^ reference semanticdb maven . . kotlin/Any#
          booleanOperator: (Column<*>, Expression<*>) -> Op<Boolean>
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().(booleanOperator)
//                        display_name booleanOperator
//                        documentation ```kotlin\nbooleanOperator: (Column<*>, Expression<*>) -> Op<Boolean>\n```
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
      ): Op<Boolean> {
//       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          require(this is IdTable<*>) { "idColumns for mapping are only available from IdTable instances" }
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
          val singleId = idColumns.single()
//            ^^^^^^^^ definition local 29
//                     display_name singleId
//                     documentation ```kotlin\nlocal val singleId: Column<out Any>\n```
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#getIdColumns().
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#idColumns.
//                                 ^^^^^^ reference semanticdb maven . . kotlin/collections/single(+18).
          return booleanOperator(singleId, singleId.wrap(toCompare))
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().(booleanOperator)
//                               ^^^^^^^^ reference local 29
//                                         ^^^^^^^^ reference local 29
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().(toCompare)
      }
  
      /** Returns a boolean operator with each of an IdTable's `idColumns` using the specified SQL [booleanOperator]. */
      internal open fun mapIdOperator(
//                      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().
//                                    display_name mapIdOperator
//                                    documentation ```kotlin\ninternal open fun mapIdOperator(booleanOperator: (Column<*>) -> Op<Boolean>): Op<Boolean>\n```\n\n----\n\n Returns a boolean operator with each of an IdTable's `idColumns` using the specified SQL [booleanOperator].
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdOperator().
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#mapIdOperator().
          booleanOperator: (Column<*>) -> Op<Boolean>
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().(booleanOperator)
//                        display_name booleanOperator
//                        documentation ```kotlin\nbooleanOperator: (Column<*>) -> Op<Boolean>\n```
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      ): Op<Boolean> {
//       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          require(this is IdTable<*>) { "idColumns for mapping are only available from IdTable instances" }
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
          return booleanOperator(idColumns.single())
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().(booleanOperator)
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#getIdColumns().
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#idColumns.
//                                         ^^^^^^ reference semanticdb maven . . kotlin/collections/single(+18).
      }
  
      // Numeric columns
  
      /** Creates a numeric column, with the specified [name], for storing 1-byte integers.
       * An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.
       */
      fun byte(name: String, checkConstraintName: String? = null): Column<Byte> = registerColumn(name, ByteColumnType()).apply {
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#byte().
//             display_name byte
//             documentation ```kotlin\npublic final fun byte(name: String, checkConstraintName: String? = ...): Column<Byte>\n```\n\n----\n\n Creates a numeric column, with the specified [name], for storing 1-byte integers.\n An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.\n
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#byte().(name)
//                  display_name name
//                  documentation ```kotlin\nname: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                           ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#byte().(checkConstraintName)
//                                               display_name checkConstraintName
//                                               documentation ```kotlin\ncheckConstraintName: String? = ...\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#byte().(name)
//                                                                                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ByteColumnType#`<init>`().
//                                                                                                                       ^^^^^ reference semanticdb maven . . kotlin/apply().
          check(checkConstraintName ?: "${generatedSignedCheckPrefix}byte_${this.unquotedName()}") { it.between(Byte.MIN_VALUE, Byte.MAX_VALUE) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#byte().(checkConstraintName)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//                                                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                                                display_name it
//                                                                                                                                                documentation ```kotlin\nit: CheckConstraint\n```
//                                                                                                   ^^ reference semanticdb maven . . (it)
//                                                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
//                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Byte#Companion#MIN_VALUE.
//                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Byte#Companion#getMIN_VALUE().
//                                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Byte#Companion#MAX_VALUE.
//                                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Byte#Companion#getMAX_VALUE().
      }
  
      /** Creates a numeric column, with the specified [name], for storing 1-byte unsigned integers.
       * An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.
       *
       * **Note:** If the database being used is not MySQL, MariaDB, or SQL Server, this column will use the
       * database's 2-byte integer type with a check constraint that ensures storage of only values
       * between 0 and [UByte.MAX_VALUE] inclusive.
       */
      fun ubyte(name: String, checkConstraintName: String? = null): Column<UByte> = registerColumn(name, UByteColumnType()).apply {
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ubyte().
//              display_name ubyte
//              documentation ```kotlin\npublic final fun ubyte(name: String, checkConstraintName: String? = ...): Column<UByte>\n```\n\n----\n\n Creates a numeric column, with the specified [name], for storing 1-byte unsigned integers.\n An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.\n\n **Note:** If the database being used is not MySQL, MariaDB, or SQL Server, this column will use the\n database's 2-byte integer type with a check constraint that ensures storage of only values\n between 0 and [UByte.MAX_VALUE] inclusive.\n
//              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ubyte().(name)
//                   display_name name
//                   documentation ```kotlin\nname: String\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ubyte().(checkConstraintName)
//                                                display_name checkConstraintName
//                                                documentation ```kotlin\ncheckConstraintName: String? = ...\n```
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ubyte().(name)
//                                                                                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UByteColumnType#`<init>`().
//                                                                                                                          ^^^^^ reference semanticdb maven . . kotlin/apply().
          check(checkConstraintName ?: "${generatedUnsignedCheckPrefix}byte_${this.unquotedName()}") { it.between(0u, UByte.MAX_VALUE) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ubyte().(checkConstraintName)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedUnsignedCheckPrefix.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedUnsignedCheckPrefix().
//                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//                                                                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                                       display_name it
//                                                                                                                                       documentation ```kotlin\nit: CheckConstraint\n```
//                                                                                                     ^^ reference semanticdb maven . . (it)
//                                                                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
//                                                                                                                          ^^^^^^^^^ reference semanticdb maven . . kotlin/UByte#Companion#MAX_VALUE.
//                                                                                                                          ^^^^^^^^^ reference semanticdb maven . . kotlin/UByte#Companion#getMAX_VALUE().
      }
  
      /** Creates a numeric column, with the specified [name], for storing 2-byte integers.
       * An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.
       */
      fun short(name: String, checkConstraintName: String? = null): Column<Short> = registerColumn(name, ShortColumnType()).apply {
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#short().
//              display_name short
//              documentation ```kotlin\npublic final fun short(name: String, checkConstraintName: String? = ...): Column<Short>\n```\n\n----\n\n Creates a numeric column, with the specified [name], for storing 2-byte integers.\n An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.\n
//              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#short().(name)
//                   display_name name
//                   documentation ```kotlin\nname: String\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#short().(checkConstraintName)
//                                                display_name checkConstraintName
//                                                documentation ```kotlin\ncheckConstraintName: String? = ...\n```
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#short().(name)
//                                                                                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ShortColumnType#`<init>`().
//                                                                                                                          ^^^^^ reference semanticdb maven . . kotlin/apply().
          check(checkConstraintName ?: "${generatedSignedCheckPrefix}short_${this.unquotedName()}") { it.between(Short.MIN_VALUE, Short.MAX_VALUE) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#short().(checkConstraintName)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//                                                                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                                                   display_name it
//                                                                                                                                                   documentation ```kotlin\nit: CheckConstraint\n```
//                                                                                                    ^^ reference semanticdb maven . . (it)
//                                                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
//                                                                                                                     ^^^^^^^^^ reference semanticdb maven . . kotlin/Short#Companion#MIN_VALUE.
//                                                                                                                     ^^^^^^^^^ reference semanticdb maven . . kotlin/Short#Companion#getMIN_VALUE().
//                                                                                                                                      ^^^^^^^^^ reference semanticdb maven . . kotlin/Short#Companion#MAX_VALUE.
//                                                                                                                                      ^^^^^^^^^ reference semanticdb maven . . kotlin/Short#Companion#getMAX_VALUE().
      }
  
      /** Creates a numeric column, with the specified [name], for storing 2-byte unsigned integers.
       * An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.
       *
       * **Note:** If the database being used is not MySQL or MariaDB, this column will use the database's 4-byte
       * integer type with a check constraint that ensures storage of only values between 0 and [UShort.MAX_VALUE] inclusive.
       */
      fun ushort(name: String, checkConstraintName: String? = null): Column<UShort> = registerColumn(name, UShortColumnType()).apply {
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ushort().
//               display_name ushort
//               documentation ```kotlin\npublic final fun ushort(name: String, checkConstraintName: String? = ...): Column<UShort>\n```\n\n----\n\n Creates a numeric column, with the specified [name], for storing 2-byte unsigned integers.\n An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.\n\n **Note:** If the database being used is not MySQL or MariaDB, this column will use the database's 4-byte\n integer type with a check constraint that ensures storage of only values between 0 and [UShort.MAX_VALUE] inclusive.\n
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ushort().(name)
//                    display_name name
//                    documentation ```kotlin\nname: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                             ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ushort().(checkConstraintName)
//                                                 display_name checkConstraintName
//                                                 documentation ```kotlin\ncheckConstraintName: String? = ...\n```
//                                                  ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                                                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ushort().(name)
//                                                                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UShortColumnType#`<init>`().
//                                                                                                                             ^^^^^ reference semanticdb maven . . kotlin/apply().
          check(checkConstraintName ?: "${generatedUnsignedCheckPrefix}short_${this.unquotedName()}") { it.between(0u, UShort.MAX_VALUE) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ushort().(checkConstraintName)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedUnsignedCheckPrefix.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedUnsignedCheckPrefix().
//                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//                                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                                         display_name it
//                                                                                                                                         documentation ```kotlin\nit: CheckConstraint\n```
//                                                                                                      ^^ reference semanticdb maven . . (it)
//                                                                                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
//                                                                                                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/UShort#Companion#MAX_VALUE.
//                                                                                                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/UShort#Companion#getMAX_VALUE().
      }
  
      /** Creates a numeric column, with the specified [name], for storing 4-byte integers.
       * An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.
       */
      fun integer(name: String, checkConstraintName: String? = null): Column<Int> = registerColumn(name, IntegerColumnType()).apply {
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#integer().
//                display_name integer
//                documentation ```kotlin\npublic final fun integer(name: String, checkConstraintName: String? = ...): Column<Int>\n```\n\n----\n\n Creates a numeric column, with the specified [name], for storing 4-byte integers.\n An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.\n
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#integer().(name)
//                     display_name name
//                     documentation ```kotlin\nname: String\n```
//                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                              ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#integer().(checkConstraintName)
//                                                  display_name checkConstraintName
//                                                  documentation ```kotlin\ncheckConstraintName: String? = ...\n```
//                                                   ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#integer().(name)
//                                                                                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#`<init>`().
//                                                                                                                            ^^^^^ reference semanticdb maven . . kotlin/apply().
          check(checkConstraintName ?: "${generatedSignedCheckPrefix}integer_${this.unquotedName()}") { it.between(Int.MIN_VALUE, Int.MAX_VALUE) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#integer().(checkConstraintName)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
//                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//                                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                                                 display_name it
//                                                                                                                                                 documentation ```kotlin\nit: CheckConstraint\n```
//                                                                                                      ^^ reference semanticdb maven . . (it)
//                                                                                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
//                                                                                                                     ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MIN_VALUE.
//                                                                                                                     ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMIN_VALUE().
//                                                                                                                                    ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                                                                                                    ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
      }
  
      /** Creates a numeric column, with the specified [name], for storing 4-byte unsigned integers.
       * An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.
       *
       * **Note:** If the database being used is not MySQL or MariaDB, this column will use the database's
       * 8-byte integer type with a check constraint that ensures storage of only values
       * between 0 and [UInt.MAX_VALUE] inclusive.
       */
      fun uinteger(name: String, checkConstraintName: String? = null): Column<UInt> = registerColumn(name, UIntegerColumnType()).apply {
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uinteger().
//                 display_name uinteger
//                 documentation ```kotlin\npublic final fun uinteger(name: String, checkConstraintName: String? = ...): Column<UInt>\n```\n\n----\n\n Creates a numeric column, with the specified [name], for storing 4-byte unsigned integers.\n An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.\n\n **Note:** If the database being used is not MySQL or MariaDB, this column will use the database's\n 8-byte integer type with a check constraint that ensures storage of only values\n between 0 and [UInt.MAX_VALUE] inclusive.\n
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uinteger().(name)
//                      display_name name
//                      documentation ```kotlin\nname: String\n```
//                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uinteger().(checkConstraintName)
//                                                   display_name checkConstraintName
//                                                   documentation ```kotlin\ncheckConstraintName: String? = ...\n```
//                                                    ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                                                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uinteger().(name)
//                                                                                                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UIntegerColumnType#`<init>`().
//                                                                                                                               ^^^^^ reference semanticdb maven . . kotlin/apply().
          check(checkConstraintName ?: "${generatedUnsignedCheckPrefix}integer_${this.unquotedName()}") { it.between(0u, UInt.MAX_VALUE) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uinteger().(checkConstraintName)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedUnsignedCheckPrefix.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedUnsignedCheckPrefix().
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                                         display_name it
//                                                                                                                                         documentation ```kotlin\nit: CheckConstraint\n```
//                                                                                                        ^^ reference semanticdb maven . . (it)
//                                                                                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
//                                                                                                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/UInt#Companion#MAX_VALUE.
//                                                                                                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/UInt#Companion#getMAX_VALUE().
      }
  
      /** Creates a numeric column, with the specified [name], for storing 8-byte integers.
       * An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.
       */
      fun long(name: String, checkConstraintName: String? = null): Column<Long> = registerColumn(name, LongColumnType()).apply {
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#long().
//             display_name long
//             documentation ```kotlin\npublic final fun long(name: String, checkConstraintName: String? = ...): Column<Long>\n```\n\n----\n\n Creates a numeric column, with the specified [name], for storing 8-byte integers.\n An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.\n
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#long().(name)
//                  display_name name
//                  documentation ```kotlin\nname: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                           ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#long().(checkConstraintName)
//                                               display_name checkConstraintName
//                                               documentation ```kotlin\ncheckConstraintName: String? = ...\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#long().(name)
//                                                                                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#`<init>`().
//                                                                                                                       ^^^^^ reference semanticdb maven . . kotlin/apply().
          check(checkConstraintName ?: "${generatedSignedCheckPrefix}long_${this.unquotedName()}") { it.between(Long.MIN_VALUE, Long.MAX_VALUE) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#long().(checkConstraintName)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//                                                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                                                display_name it
//                                                                                                                                                documentation ```kotlin\nit: CheckConstraint\n```
//                                                                                                   ^^ reference semanticdb maven . . (it)
//                                                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
//                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Long#Companion#MIN_VALUE.
//                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Long#Companion#getMIN_VALUE().
//                                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Long#Companion#MAX_VALUE.
//                                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Long#Companion#getMAX_VALUE().
      }
  
      /** Creates a numeric column, with the specified [name], for storing 8-byte unsigned integers.
       *
       * **Note:** For PostgreSQL, the maximum value this column will store is [Long.MAX_VALUE].
       */
      fun ulong(name: String): Column<ULong> = registerColumn(name, ULongColumnType())
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ulong().
//              display_name ulong
//              documentation ```kotlin\npublic final fun ulong(name: String): Column<ULong>\n```\n\n----\n\n Creates a numeric column, with the specified [name], for storing 8-byte unsigned integers.\n\n **Note:** For PostgreSQL, the maximum value this column will store is [Long.MAX_VALUE].\n
//              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ulong().(name)
//                   display_name name
//                   documentation ```kotlin\nname: String\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ulong().(name)
//                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ULongColumnType#`<init>`().
  
      /** Creates a numeric column, with the specified [name], for storing 4-byte (single precision) floating-point numbers. */
      fun float(name: String): Column<Float> = registerColumn(name, FloatColumnType())
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#float().
//              display_name float
//              documentation ```kotlin\npublic final fun float(name: String): Column<Float>\n```\n\n----\n\n Creates a numeric column, with the specified [name], for storing 4-byte (single precision) floating-point numbers.
//              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#float().(name)
//                   display_name name
//                   documentation ```kotlin\nname: String\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#float().(name)
//                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FloatColumnType#`<init>`().
  
      /** Creates a numeric column, with the specified [name], for storing 8-byte (double precision) floating-point numbers. */
      fun double(name: String): Column<Double> = registerColumn(name, DoubleColumnType())
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#double().
//               display_name double
//               documentation ```kotlin\npublic final fun double(name: String): Column<Double>\n```\n\n----\n\n Creates a numeric column, with the specified [name], for storing 8-byte (double precision) floating-point numbers.
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#double().(name)
//                    display_name name
//                    documentation ```kotlin\nname: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#double().(name)
//                                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DoubleColumnType#`<init>`().
  
      /**
       * Creates a numeric column, with the specified [name], for storing numbers with the specified [precision] and [scale].
       *
       * To store the decimal `123.45`, [precision] would have to be set to 5 (as there are five digits in total) and
       * [scale] to 2 (as there are two digits behind the decimal point).
       *
       * @param name Name of the column.
       * @param precision Total count of significant digits in the whole number, that is, the number of digits to both sides of the decimal point.
       * @param scale Count of decimal digits in the fractional part.
       */
      fun decimal(name: String, precision: Int, scale: Int): Column<BigDecimal> = registerColumn(
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().
//                display_name decimal
//                documentation ```kotlin\npublic final fun decimal(name: String, precision: Int, scale: Int): Column<BigDecimal>\n```\n\n----\n\n\n Creates a numeric column, with the specified [name], for storing numbers with the specified [precision] and [scale].\n\n To store the decimal `123.45`, [precision] would have to be set to 5 (as there are five digits in total) and\n [scale] to 2 (as there are two digits behind the decimal point).\n\n @param name Name of the column.\n @param precision Total count of significant digits in the whole number, that is, the number of digits to both sides of the decimal point.\n @param scale Count of decimal digits in the fractional part.\n
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().(name)
//                     display_name name
//                     documentation ```kotlin\nname: String\n```
//                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().(precision)
//                                        display_name precision
//                                        documentation ```kotlin\nprecision: Int\n```
//                                         ^^^ reference semanticdb maven . . kotlin/Int#
//                                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().(scale)
//                                                    display_name scale
//                                                    documentation ```kotlin\nscale: Int\n```
//                                                     ^^^ reference semanticdb maven . . kotlin/Int#
//                                                           ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
          name,
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().(name)
          DecimalColumnType(precision, scale)
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().(precision)
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().(scale)
      )
  
      // Character columns
  
      /** Creates a character column, with the specified [name], for storing single characters. */
      fun char(name: String): Column<Char> = registerColumn(name, CharacterColumnType())
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char().
//             display_name char
//             documentation ```kotlin\npublic final fun char(name: String): Column<Char>\n```\n\n----\n\n Creates a character column, with the specified [name], for storing single characters.
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char().(name)
//                  display_name name
//                  documentation ```kotlin\nname: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char().(name)
//                                                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharacterColumnType#`<init>`().
  
      /**
       * Creates a character column, with the specified [name], for storing strings with the specified [length] using the specified text [collate] type.
       * If no collate type is specified then the database default is used.
       */
      fun char(name: String, length: Int, collate: String? = null): Column<String> = registerColumn(
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).
//             display_name char
//             documentation ```kotlin\npublic final fun char(name: String, length: Int, collate: String? = ...): Column<String>\n```\n\n----\n\n\n Creates a character column, with the specified [name], for storing strings with the specified [length] using the specified text [collate] type.\n If no collate type is specified then the database default is used.\n
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).(name)
//                  display_name name
//                  documentation ```kotlin\nname: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).(length)
//                                  display_name length
//                                  documentation ```kotlin\nlength: Int\n```
//                                   ^^^ reference semanticdb maven . . kotlin/Int#
//                                        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).(collate)
//                                                display_name collate
//                                                documentation ```kotlin\ncollate: String? = ...\n```
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
          name,
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).(name)
          CharColumnType(length, collate)
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#`<init>`().
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).(length)
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).(collate)
      )
  
      /**
       * Creates a character column, with the specified [name], for storing strings with the specified maximum [length] using the specified text [collate] type.
       * If no collate type is specified then the database default is used.
       */
      fun varchar(name: String, length: Int, collate: String? = null): Column<String> = registerColumn(
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().
//                display_name varchar
//                documentation ```kotlin\npublic final fun varchar(name: String, length: Int, collate: String? = ...): Column<String>\n```\n\n----\n\n\n Creates a character column, with the specified [name], for storing strings with the specified maximum [length] using the specified text [collate] type.\n If no collate type is specified then the database default is used.\n
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().(name)
//                     display_name name
//                     documentation ```kotlin\nname: String\n```
//                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().(length)
//                                     display_name length
//                                     documentation ```kotlin\nlength: Int\n```
//                                      ^^^ reference semanticdb maven . . kotlin/Int#
//                                           ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().(collate)
//                                                   display_name collate
//                                                   documentation ```kotlin\ncollate: String? = ...\n```
//                                                    ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
          name,
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().(name)
          VarCharColumnType(length, collate)
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#`<init>`().
//                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().(length)
//                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().(collate)
      )
  
      /**
       * Creates a character column, with the specified [name], for storing strings of arbitrary length using the specified [collate] type.
       * If no collated type is specified, then the database default is used.
       *
       * Some database drivers do not load text content immediately (for performance and memory reasons),
       * which means that you can obtain column value only within the open transaction.
       * If you desire to make content available outside the transaction use [eagerLoading] param.
       */
      fun text(name: String, collate: String? = null, eagerLoading: Boolean = false): Column<String> =
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().
//             display_name text
//             documentation ```kotlin\npublic final fun text(name: String, collate: String? = ..., eagerLoading: Boolean = ...): Column<String>\n```\n\n----\n\n\n Creates a character column, with the specified [name], for storing strings of arbitrary length using the specified [collate] type.\n If no collated type is specified, then the database default is used.\n\n Some database drivers do not load text content immediately (for performance and memory reasons),\n which means that you can obtain column value only within the open transaction.\n If you desire to make content available outside the transaction use [eagerLoading] param.\n
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().(name)
//                  display_name name
//                  documentation ```kotlin\nname: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                           ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().(collate)
//                                   display_name collate
//                                   documentation ```kotlin\ncollate: String? = ...\n```
//                                    ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().(eagerLoading)
//                                                                 display_name eagerLoading
//                                                                 documentation ```kotlin\neagerLoading: Boolean = ...\n```
//                                                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          registerColumn(name, TextColumnType(collate, eagerLoading))
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().(name)
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
//                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().(collate)
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().(eagerLoading)
  
      /**
       * Creates a character column, with the specified [name], for storing strings of _medium_ length using the specified [collate] type.
       * If no collated type is specified, then the database default is used.
       *
       * Some database drivers do not load text content immediately (for performance and memory reasons),
       * which means that you can obtain column value only within the open transaction.
       * If you desire to make content available outside the transaction use [eagerLoading] param.
       */
      fun mediumText(name: String, collate: String? = null, eagerLoading: Boolean = false): Column<String> =
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().
//                   display_name mediumText
//                   documentation ```kotlin\npublic final fun mediumText(name: String, collate: String? = ..., eagerLoading: Boolean = ...): Column<String>\n```\n\n----\n\n\n Creates a character column, with the specified [name], for storing strings of _medium_ length using the specified [collate] type.\n If no collated type is specified, then the database default is used.\n\n Some database drivers do not load text content immediately (for performance and memory reasons),\n which means that you can obtain column value only within the open transaction.\n If you desire to make content available outside the transaction use [eagerLoading] param.\n
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().(name)
//                        display_name name
//                        documentation ```kotlin\nname: String\n```
//                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().(collate)
//                                         display_name collate
//                                         documentation ```kotlin\ncollate: String? = ...\n```
//                                          ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                          ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().(eagerLoading)
//                                                                       display_name eagerLoading
//                                                                       documentation ```kotlin\neagerLoading: Boolean = ...\n```
//                                                                        ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          registerColumn(name, MediumTextColumnType(collate, eagerLoading))
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().(name)
//                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/MediumTextColumnType#`<init>`().
//                                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().(collate)
//                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().(eagerLoading)
  
      /**
       * Creates a character column, with the specified [name], for storing strings of _large_ length using the specified [collate] type.
       * If no collated type is specified, then the database default is used.
       *
       * Some database drivers do not load text content immediately (for performance and memory reasons),
       * which means that you can obtain column value only within the open transaction.
       * If you desire to make content available outside the transaction use [eagerLoading] param.
       */
      fun largeText(name: String, collate: String? = null, eagerLoading: Boolean = false): Column<String> =
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().
//                  display_name largeText
//                  documentation ```kotlin\npublic final fun largeText(name: String, collate: String? = ..., eagerLoading: Boolean = ...): Column<String>\n```\n\n----\n\n\n Creates a character column, with the specified [name], for storing strings of _large_ length using the specified [collate] type.\n If no collated type is specified, then the database default is used.\n\n Some database drivers do not load text content immediately (for performance and memory reasons),\n which means that you can obtain column value only within the open transaction.\n If you desire to make content available outside the transaction use [eagerLoading] param.\n
//                  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().(name)
//                       display_name name
//                       documentation ```kotlin\nname: String\n```
//                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().(collate)
//                                        display_name collate
//                                        documentation ```kotlin\ncollate: String? = ...\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                         ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().(eagerLoading)
//                                                                      display_name eagerLoading
//                                                                      documentation ```kotlin\neagerLoading: Boolean = ...\n```
//                                                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          registerColumn(name, LargeTextColumnType(collate, eagerLoading))
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().(name)
//                             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LargeTextColumnType#`<init>`().
//                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().(collate)
//                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().(eagerLoading)
  
      // Binary columns
  
      /**
       * Creates a binary column, with the specified [name], for storing byte arrays of arbitrary size.
       *
       * **Note:** This function is only supported by SQLite, PostgreSQL, and H2 dialects.
       * For the rest, please specify a length.
       * For H2 dialects, the maximum size is 1,000,000,000 bytes.
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.DDLTests.testBinaryWithoutLength
       */
      fun binary(name: String): Column<ByteArray> = registerColumn(name, BasicBinaryColumnType())
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary().
//               display_name binary
//               documentation ```kotlin\npublic final fun binary(name: String): Column<ByteArray>\n```\n\n----\n\n\n Creates a binary column, with the specified [name], for storing byte arrays of arbitrary size.\n\n **Note:** This function is only supported by SQLite, PostgreSQL, and H2 dialects.\n For the rest, please specify a length.\n For H2 dialects, the maximum size is 1,000,000,000 bytes.\n\n @sample org.jetbrains.exposed.v1.tests.shared.DDLTests.testBinaryWithoutLength\n
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary().(name)
//                    display_name name
//                    documentation ```kotlin\nname: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary().(name)
//                                                                       ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#`<init>`().
  
      /**
       * Creates a binary column, with the specified [name], for storing byte arrays with the specified maximum [length].
       *
       * **Note:** The length of the binary column is not required in PostgreSQL and will be ignored.
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.DDLTests.testBinary
       */
      fun binary(name: String, length: Int): Column<ByteArray> = registerColumn(name, BinaryColumnType(length))
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary(+1).
//               display_name binary
//               documentation ```kotlin\npublic final fun binary(name: String, length: Int): Column<ByteArray>\n```\n\n----\n\n\n Creates a binary column, with the specified [name], for storing byte arrays with the specified maximum [length].\n\n **Note:** The length of the binary column is not required in PostgreSQL and will be ignored.\n\n @sample org.jetbrains.exposed.v1.tests.shared.DDLTests.testBinary\n
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary(+1).(name)
//                    display_name name
//                    documentation ```kotlin\nname: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary(+1).(length)
//                                    display_name length
//                                    documentation ```kotlin\nlength: Int\n```
//                                     ^^^ reference semanticdb maven . . kotlin/Int#
//                                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary(+1).(name)
//                                                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BinaryColumnType#`<init>`().
//                                                                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary(+1).(length)
  
      /**
       * Creates a binary column, with the specified [name], for storing BLOBs.
       * If [useObjectIdentifier] is `true`, then the column will use the `OID` type on PostgreSQL
       * for storing large binary objects. The parameter must not be `true` for other databases.
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.types.BlobColumnTypeTests.testBlob
       */
      fun blob(name: String, useObjectIdentifier: Boolean = false): Column<ExposedBlob> =
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#blob().
//             display_name blob
//             documentation ```kotlin\npublic final fun blob(name: String, useObjectIdentifier: Boolean = ...): Column<ExposedBlob>\n```\n\n----\n\n\n Creates a binary column, with the specified [name], for storing BLOBs.\n If [useObjectIdentifier] is `true`, then the column will use the `OID` type on PostgreSQL\n for storing large binary objects. The parameter must not be `true` for other databases.\n\n @sample org.jetbrains.exposed.v1.tests.shared.types.BlobColumnTypeTests.testBlob\n
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#blob().(name)
//                  display_name name
//                  documentation ```kotlin\nname: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                           ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#blob().(useObjectIdentifier)
//                                               display_name useObjectIdentifier
//                                               documentation ```kotlin\nuseObjectIdentifier: Boolean = ...\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          registerColumn(name, BlobColumnType(useObjectIdentifier))
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#blob().(name)
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#`<init>`().
//                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#blob().(useObjectIdentifier)
  
      /** Creates a binary column, with the specified [name], for storing UUIDs. */
      fun uuid(name: String): Column<UUID> = registerColumn(name, UUIDColumnType())
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uuid().
//             display_name uuid
//             documentation ```kotlin\npublic final fun uuid(name: String): Column<UUID>\n```\n\n----\n\n Creates a binary column, with the specified [name], for storing UUIDs.
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uuid().(name)
//                  display_name name
//                  documentation ```kotlin\nname: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uuid().(name)
//                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UUIDColumnType#`<init>`().
  
      // Boolean columns
  
      /** Creates a column, with the specified [name], for storing boolean values. */
      fun bool(name: String): Column<Boolean> = registerColumn(name, BooleanColumnType())
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#bool().
//             display_name bool
//             documentation ```kotlin\npublic final fun bool(name: String): Column<Boolean>\n```\n\n----\n\n Creates a column, with the specified [name], for storing boolean values.
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#bool().(name)
//                  display_name name
//                  documentation ```kotlin\nname: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#bool().(name)
//                                                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#`<init>`().
  
      // Enumeration columns
  
      /** Creates an enumeration column, with the specified [name], for storing enums of type [klass] by their ordinal. */
      fun <T : Enum<T>> enumeration(name: String, klass: KClass<T>): Column<T> = registerColumn(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Enum<T>\n```
//                      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().
//                                  display_name enumeration
//                                  documentation ```kotlin\npublic final fun <T : Enum<T>> enumeration(name: String, klass: KClass<T>): Column<T>\n```\n\n----\n\n Creates an enumeration column, with the specified [name], for storing enums of type [klass] by their ordinal.
//                                  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().(name)
//                                       display_name name
//                                       documentation ```kotlin\nname: String\n```
//                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().(klass)
//                                                      display_name klass
//                                                      documentation ```kotlin\nklass: KClass<T>\n```
//                                                       ^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#
//                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
          name,
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().(name)
          EnumerationColumnType(klass)
//        ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#`<init>`().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().(klass)
      )
  
      /** Creates an enumeration column, with the specified [name], for storing enums of type [T] by their ordinal. */
      inline fun <reified T : Enum<T>> enumeration(name: String) = enumeration(name, T::class)
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration(+1).[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nreified T : Enum<T>\n```
//                                     ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration(+1).
//                                                 display_name enumeration
//                                                 documentation ```kotlin\npublic final inline fun <reified T : Enum<T>> enumeration(name: String): Column<T>\n```\n\n----\n\n Creates an enumeration column, with the specified [name], for storing enums of type [T] by their ordinal.
//                                                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration(+1).(name)
//                                                      display_name name
//                                                      documentation ```kotlin\nname: String\n```
//                                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().
//                                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration(+1).(name)
  
      /**
       * Creates an enumeration column, with the specified [name], for storing enums of type [klass] by their name.
       * With the specified maximum [length] for each name value.
       */
      fun <T : Enum<T>> enumerationByName(name: String, length: Int, klass: KClass<T>): Column<T> =
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Enum<T>\n```
//                      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().
//                                        display_name enumerationByName
//                                        documentation ```kotlin\npublic final fun <T : Enum<T>> enumerationByName(name: String, length: Int, klass: KClass<T>): Column<T>\n```\n\n----\n\n\n Creates an enumeration column, with the specified [name], for storing enums of type [klass] by their name.\n With the specified maximum [length] for each name value.\n
//                                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().(name)
//                                             display_name name
//                                             documentation ```kotlin\nname: String\n```
//                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().(length)
//                                                             display_name length
//                                                             documentation ```kotlin\nlength: Int\n```
//                                                              ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                   ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().(klass)
//                                                                         display_name klass
//                                                                         documentation ```kotlin\nklass: KClass<T>\n```
//                                                                          ^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#
//                                                                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          registerColumn(name, EnumerationNameColumnType(klass, length))
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().(name)
//                             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#`<init>`().
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().(klass)
//                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().(length)
  
      /**
       * Creates an enumeration column, with the specified [name], for storing enums of type [T] by their name.
       * With the specified maximum [length] for each name value.
       */
      inline fun <reified T : Enum<T>> enumerationByName(name: String, length: Int) =
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nreified T : Enum<T>\n```
//                                     ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).
//                                                       display_name enumerationByName
//                                                       documentation ```kotlin\npublic final inline fun <reified T : Enum<T>> enumerationByName(name: String, length: Int): Column<T>\n```\n\n----\n\n\n Creates an enumeration column, with the specified [name], for storing enums of type [T] by their name.\n With the specified maximum [length] for each name value.\n
//                                                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).(name)
//                                                            display_name name
//                                                            documentation ```kotlin\nname: String\n```
//                                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).(length)
//                                                                            display_name length
//                                                                            documentation ```kotlin\nlength: Int\n```
//                                                                             ^^^ reference semanticdb maven . . kotlin/Int#
          enumerationByName(name, length, T::class)
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).(name)
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).(length)
  
      /**
       * Creates an enumeration column, with the custom SQL type [sql], for storing enums of type [T] using this database-specific type.
       *
       * See [Wiki](https://github.com/JetBrains/Exposed/wiki/DataTypes#how-to-use-database-enum-types) for more details.
       *
       * @param name Name of the column
       * @param sql SQL definition for the column
       * @param fromDb Function that converts a value received from a database to an enumeration instance [T]
       * @param toDb Function that converts an enumeration instance [T] to a value that will be stored to a database
       */
      fun <T : Enum<T>> customEnumeration(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Enum<T>\n```
//                      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().
//                                        display_name customEnumeration
//                                        documentation ```kotlin\npublic final fun <T : Enum<T>> customEnumeration(name: String, sql: String? = ..., fromDb: (Any) -> T, toDb: (T) -> Any): Column<T>\n```\n\n----\n\n\n Creates an enumeration column, with the custom SQL type [sql], for storing enums of type [T] using this database-specific type.\n\n See [Wiki](https://github.com/JetBrains/Exposed/wiki/DataTypes#how-to-use-database-enum-types) for more details.\n\n @param name Name of the column\n @param sql SQL definition for the column\n @param fromDb Function that converts a value received from a database to an enumeration instance [T]\n @param toDb Function that converts an enumeration instance [T] to a value that will be stored to a database\n
          name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
          sql: String? = null,
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(sql)
//            display_name sql
//            documentation ```kotlin\nsql: String? = ...\n```
//             ^^^^^^^ reference semanticdb maven . . kotlin/String#
          fromDb: (Any) -> T,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(fromDb)
//               display_name fromDb
//               documentation ```kotlin\nfromDb: (Any) -> T\n```
//                ^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
          toDb: (T) -> Any
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(toDb)
//             display_name toDb
//             documentation ```kotlin\ntoDb: (T) -> Any\n```
//              ^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      ): Column<T> = registerColumn(name, CustomEnumerationColumnType(name, sql, fromDb, toDb))
//       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(name)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#`<init>`().
//                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(name)
//                                                                          ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(sql)
//                                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(fromDb)
//                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(toDb)
  
      // Array columns
  
      /**
       * Creates an array column, with the specified [name], for storing elements of a `List` using a base [columnType].
       *
       * **Note** This column type is only supported by H2 and PostgreSQL dialects.
       *
       * @param name Name of the column.
       * @param columnType Base column type for the individual elements.
       * @param maximumCardinality The maximum amount of allowed elements. **Note** Providing an array size limit
       * when using the PostgreSQL dialect is allowed, but this value will be ignored by the database.
       */
      fun <E> array(name: String, columnType: ColumnType<E & Any>, maximumCardinality: Int? = null): Column<List<E>> =
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().[E]
//           display_name FirTypeParameterSymbol E
//           documentation ```kotlin\nE\n```
//            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().
//                  display_name array
//                  documentation ```kotlin\npublic final fun <E> array(name: String, columnType: ColumnType<E & Any>, maximumCardinality: Int? = ...): Column<List<E>>\n```\n\n----\n\n\n Creates an array column, with the specified [name], for storing elements of a `List` using a base [columnType].\n\n **Note** This column type is only supported by H2 and PostgreSQL dialects.\n\n @param name Name of the column.\n @param columnType Base column type for the individual elements.\n @param maximumCardinality The maximum amount of allowed elements. **Note** Providing an array size limit\n when using the PostgreSQL dialect is allowed, but this value will be ignored by the database.\n
//                  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().(name)
//                       display_name name
//                       documentation ```kotlin\nname: String\n```
//                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().(columnType)
//                                           display_name columnType
//                                           documentation ```kotlin\ncolumnType: ColumnType<E & Any>\n```
//                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                                                                 ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().(maximumCardinality)
//                                                                                    display_name maximumCardinality
//                                                                                    documentation ```kotlin\nmaximumCardinality: Int? = ...\n```
//                                                                                     ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          array<E, List<E>>(name, columnType, dimensions = 1, maximumCardinality = maximumCardinality?.let { listOf(it) })
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().(name)
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().(columnType)
//                                                                                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().(maximumCardinality)
//                                                                                                     ^^^ reference semanticdb maven . . kotlin/let().
//                                                                                                         ^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                        display_name it
//                                                                                                                        documentation ```kotlin\nit: CheckConstraint\n```
//                                                                                                           ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                                                                                  ^^ reference semanticdb maven . . (it)
  
      /**
       * Creates an array column, with the specified [name], for storing elements of a `List`.
       *
       * **Note** This column type is only supported by H2 and PostgreSQL dialects.
       *
       * **Note** The base column type associated with storing elements of type [E] will be resolved according to
       * the internal mapping in [resolveColumnType]. To avoid this type reflection, or if a mapping does not exist
       * for the elements being stored, please provide an explicit column type to the [array] overload. If the elements
       * to be stored are nullable, an explicit column type will also need to be provided.
       *
       * @param name Name of the column.
       * @param maximumCardinality The maximum amount of allowed elements. **Note** Providing an array size limit
       * when using the PostgreSQL dialect is allowed, but this value will be ignored by the database.
       * @throws IllegalStateException If no column type mapping is found.
       */
      inline fun <reified E : Any> array(name: String, maximumCardinality: Int? = null): Column<List<E>> =
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).[E]
//                          display_name FirTypeParameterSymbol E
//                          documentation ```kotlin\nreified E : Any\n```
//                                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).
//                                       display_name array
//                                       documentation ```kotlin\npublic final inline fun <reified E : Any> array(name: String, maximumCardinality: Int? = ...): Column<List<E>>\n```\n\n----\n\n\n Creates an array column, with the specified [name], for storing elements of a `List`.\n\n **Note** This column type is only supported by H2 and PostgreSQL dialects.\n\n **Note** The base column type associated with storing elements of type [E] will be resolved according to\n the internal mapping in [resolveColumnType]. To avoid this type reflection, or if a mapping does not exist\n for the elements being stored, please provide an explicit column type to the [array] overload. If the elements\n to be stored are nullable, an explicit column type will also need to be provided.\n\n @param name Name of the column.\n @param maximumCardinality The maximum amount of allowed elements. **Note** Providing an array size limit\n when using the PostgreSQL dialect is allowed, but this value will be ignored by the database.\n @throws IllegalStateException If no column type mapping is found.\n
//                                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).(name)
//                                            display_name name
//                                            documentation ```kotlin\nname: String\n```
//                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                     ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).(maximumCardinality)
//                                                                        display_name maximumCardinality
//                                                                        documentation ```kotlin\nmaximumCardinality: Int? = ...\n```
//                                                                         ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          array<E, List<E>>(name, maximumCardinality?.let { listOf(it) }, dimensions = 1)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).(name)
//                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).(maximumCardinality)
//                                                    ^^^ reference semanticdb maven . . kotlin/let().
//                                                        ^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                       display_name it
//                                                                       documentation ```kotlin\nit: CheckConstraint\n```
//                                                          ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                                 ^^ reference semanticdb maven . . (it)
  
      /**
       * Creates a multi-dimensional array column, with the specified [name], for storing elements of a nested `List`.
       * The number of dimensions is specified by the [dimensions] parameter.
       *
       * **Note:** This column type is only supported by PostgreSQL dialect.
       *
       * @param name Name of the column.
       * @param maximumCardinality The maximum cardinality (number of allowed elements) for each dimension in the array.
       * @param dimensions The number of dimensions of the array.
       *
       * **Note:** Providing an array size limit when using the PostgreSQL dialect is allowed, but this value will be ignored by the database.
       *
       * @return A column instance that represents a multi-dimensional list of elements of type [T].
       * @throws IllegalStateException If no column type mapping is found.
       */
      inline fun <reified T : Any, R : List<Any>> Table.array(name: String, maximumCardinality: List<Int>? = null, dimensions: Int): Column<R> {
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nreified T : Any\n```
//                                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).[R]
//                                   display_name FirTypeParameterSymbol R
//                                   documentation ```kotlin\nR : List<Any>\n```
//                                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).
//                                                            display_name array
//                                                            documentation ```kotlin\npublic final inline fun <reified T : Any, R : List<Any>> Table.array(name: String, maximumCardinality: List<Int>? = ..., dimensions: Int): Column<R>\n```\n\n----\n\n\n Creates a multi-dimensional array column, with the specified [name], for storing elements of a nested `List`.\n The number of dimensions is specified by the [dimensions] parameter.\n\n **Note:** This column type is only supported by PostgreSQL dialect.\n\n @param name Name of the column.\n @param maximumCardinality The maximum cardinality (number of allowed elements) for each dimension in the array.\n @param dimensions The number of dimensions of the array.\n\n **Note:** Providing an array size limit when using the PostgreSQL dialect is allowed, but this value will be ignored by the database.\n\n @return A column instance that represents a multi-dimensional list of elements of type [T].\n @throws IllegalStateException If no column type mapping is found.\n
//                                                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).(name)
//                                                                 display_name name
//                                                                 documentation ```kotlin\nname: String\n```
//                                                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                          ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).(maximumCardinality)
//                                                                                             display_name maximumCardinality
//                                                                                             documentation ```kotlin\nmaximumCardinality: List<Int>? = ...\n```
//                                                                                              ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                                                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).(dimensions)
//                                                                                                                            display_name dimensions
//                                                                                                                            documentation ```kotlin\ndimensions: Int\n```
//                                                                                                                             ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          @OptIn(InternalApi::class)
          return array(name, resolveColumnType(T::class), maximumCardinality, dimensions)
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).
//                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).(name)
//                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/resolveColumnType().
//                                                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).(maximumCardinality)
//                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).(dimensions)
      }
  
      /**
       * Creates a multi-dimensional array column, with the specified [name], for storing elements of a nested `List`.
       * The number of dimensions is specified by the [dimensions] parameter.
       *
       * **Note:** This column type is only supported by PostgreSQL dialect.
       *
       * @param name Name of the column.
       * @param maximumCardinality The maximum cardinality (number of allowed elements) for each dimension in the array.
       * @param dimensions The number of dimensions of the array.
       *
       * **Note:** Providing an array size limit when using the PostgreSQL dialect is allowed, but this value will be ignored by the database.
       *
       * @return A column instance that represents a multi-dimensional list of elements of type [E].
       * @throws IllegalStateException If no column type mapping is found.
       */
      fun <E, R : List<Any?>> Table.array(name: String, columnType: ColumnType<E & Any>, maximumCardinality: List<Int>? = null, dimensions: Int): Column<R> =
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).[E]
//           display_name FirTypeParameterSymbol E
//           documentation ```kotlin\nE\n```
//            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).[R]
//              display_name FirTypeParameterSymbol R
//              documentation ```kotlin\nR : List<Any?>\n```
//                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).
//                                        display_name array
//                                        documentation ```kotlin\npublic final fun <E, R : List<Any?>> Table.array(name: String, columnType: ColumnType<E & Any>, maximumCardinality: List<Int>? = ..., dimensions: Int): Column<R>\n```\n\n----\n\n\n Creates a multi-dimensional array column, with the specified [name], for storing elements of a nested `List`.\n The number of dimensions is specified by the [dimensions] parameter.\n\n **Note:** This column type is only supported by PostgreSQL dialect.\n\n @param name Name of the column.\n @param maximumCardinality The maximum cardinality (number of allowed elements) for each dimension in the array.\n @param dimensions The number of dimensions of the array.\n\n **Note:** Providing an array size limit when using the PostgreSQL dialect is allowed, but this value will be ignored by the database.\n\n @return A column instance that represents a multi-dimensional list of elements of type [E].\n @throws IllegalStateException If no column type mapping is found.\n
//                                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(name)
//                                             display_name name
//                                             documentation ```kotlin\nname: String\n```
//                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(columnType)
//                                                                 display_name columnType
//                                                                 documentation ```kotlin\ncolumnType: ColumnType<E & Any>\n```
//                                                                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                                                                                       ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(maximumCardinality)
//                                                                                                          display_name maximumCardinality
//                                                                                                          documentation ```kotlin\nmaximumCardinality: List<Int>? = ...\n```
//                                                                                                           ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                                                                              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(dimensions)
//                                                                                                                                         display_name dimensions
//                                                                                                                                         documentation ```kotlin\ndimensions: Int\n```
//                                                                                                                                          ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          registerColumn(name, ArrayColumnType(columnType, maximumCardinality, dimensions))
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(name)
//                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`().
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(columnType)
//                                                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(maximumCardinality)
//                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(dimensions)
  
      // Auto-generated values
  
      /**
       * Make @receiver column an auto-increment column to generate its values in a database.
       * **Note:** Only integer and long columns are supported (signed and unsigned types).
       * Some databases, like PostgreSQL, support auto-increment via sequences.
       * In this case a name should be provided using the [idSeqName] param and Exposed will create a sequence.
       * If a sequence already exists in the database just use its name in [idSeqName].
       *
       * @param idSeqName an optional parameter to provide a sequence name
       */
      fun <N : Any> Column<N>.autoIncrement(idSeqName: String? = null): Column<N> =
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement().[N]
//           display_name FirTypeParameterSymbol N
//           documentation ```kotlin\nN : Any\n```
//                            ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement().
//                                          display_name autoIncrement
//                                          documentation ```kotlin\npublic final fun <N : Any> Column<N>.autoIncrement(idSeqName: String? = ...): Column<N>\n```\n\n----\n\n\n Make @receiver column an auto-increment column to generate its values in a database.\n **Note:** Only integer and long columns are supported (signed and unsigned types).\n Some databases, like PostgreSQL, support auto-increment via sequences.\n In this case a name should be provided using the [idSeqName] param and Exposed will create a sequence.\n If a sequence already exists in the database just use its name in [idSeqName].\n\n @param idSeqName an optional parameter to provide a sequence name\n
//                                          ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement().(idSeqName)
//                                                    display_name idSeqName
//                                                    documentation ```kotlin\nidSeqName: String? = ...\n```
//                                                     ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          cloneWithAutoInc(idSeqName).also { replaceColumn(this, it) }
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc().
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement().(idSeqName)
//                                    ^^^^ reference semanticdb maven . . kotlin/also().
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                     display_name it
//                                                                     documentation ```kotlin\nit: CheckConstraint\n```
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                                               ^^ reference semanticdb maven . . (it)
  
      /**
       * Make @receiver column an auto-increment column to generate its values in a database.
       * **Note:** Only integer and long columns are supported (signed and unsigned types).
       * Some databases, like PostgreSQL, support auto-increment via sequences.
       * In this case, a sequence should be provided using the [sequence] param.
       *
       * @param sequence a parameter to provide a sequence
       */
      fun <N : Any> Column<N>.autoIncrement(sequence: Sequence): Column<N> =
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement(+1).[N]
//           display_name FirTypeParameterSymbol N
//           documentation ```kotlin\nN : Any\n```
//                            ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement(+1).
//                                          display_name autoIncrement
//                                          documentation ```kotlin\npublic final fun <N : Any> Column<N>.autoIncrement(sequence: Sequence): Column<N>\n```\n\n----\n\n\n Make @receiver column an auto-increment column to generate its values in a database.\n **Note:** Only integer and long columns are supported (signed and unsigned types).\n Some databases, like PostgreSQL, support auto-increment via sequences.\n In this case, a sequence should be provided using the [sequence] param.\n\n @param sequence a parameter to provide a sequence\n
//                                          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement(+1).(sequence)
//                                                   display_name sequence
//                                                   documentation ```kotlin\nsequence: Sequence\n```
//                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
//                                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          cloneWithAutoInc(sequence).also { replaceColumn(this, it) }
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc(+1).
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement(+1).(sequence)
//                                   ^^^^ reference semanticdb maven . . kotlin/also().
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                    display_name it
//                                                                    documentation ```kotlin\nit: CheckConstraint\n```
//                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                                              ^^ reference semanticdb maven . . (it)
  
      @Deprecated(
          message = "This function will be removed in future releases.",
          replaceWith = ReplaceWith("autoIncrement(idSeqName)"),
//                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/ReplaceWith#`<init>`().
          level = DeprecationLevel.WARNING
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#WARNING.
      )
      fun <N : Any> Column<EntityID<N>>.autoinc(idSeqName: String? = null): Column<EntityID<N>> =
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoinc().[N]
//           display_name FirTypeParameterSymbol N
//           documentation ```kotlin\nN : Any\n```
//                                      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoinc().
//                                              display_name autoinc
//                                              documentation ```kotlin\n@Deprecated(...) public final fun <N : Any> Column<EntityID<N>>.autoinc(idSeqName: String? = ...): Column<EntityID<N>>\n```
//                                              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoinc().(idSeqName)
//                                                        display_name idSeqName
//                                                        documentation ```kotlin\nidSeqName: String? = ...\n```
//                                                         ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          cloneWithAutoInc(idSeqName).also { replaceColumn(this, it) }
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc().
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoinc().(idSeqName)
//                                    ^^^^ reference semanticdb maven . . kotlin/also().
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                     display_name it
//                                                                     documentation ```kotlin\nit: CheckConstraint\n```
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                                               ^^ reference semanticdb maven . . (it)
  
      /** Sets the default value for this column in the database side. */
      fun <T> Column<T>.default(defaultValue: T): Column<T> = apply {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default().
//                              display_name default
//                              documentation ```kotlin\npublic final fun <T> Column<T>.default(defaultValue: T): Column<T>\n```\n\n----\n\n Sets the default value for this column in the database side.
//                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default().(defaultValue)
//                                           display_name defaultValue
//                                           documentation ```kotlin\ndefaultValue: T\n```
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                            ^^^^^ reference semanticdb maven . . kotlin/apply().
          dbDefaultValue = with(SqlExpressionBuilder) { asLiteral(defaultValue) }
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                         ^^^^ reference semanticdb maven . . kotlin/with().
//                                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().
//                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default().(defaultValue)
          defaultValueFun = { defaultValue }
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default().(defaultValue)
      }
  
      /** Sets the default value for this column in the database side. */
      fun <T> CompositeColumn<T>.default(defaultValue: T): CompositeColumn<T> = apply {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default(+1).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default(+1).
//                                       display_name default
//                                       documentation ```kotlin\npublic final fun <T> CompositeColumn<T>.default(defaultValue: T): CompositeColumn<T>\n```\n\n----\n\n Sets the default value for this column in the database side.
//                                       ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default(+1).(defaultValue)
//                                                    display_name defaultValue
//                                                    documentation ```kotlin\ndefaultValue: T\n```
//                                                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#
//                                                                              ^^^^^ reference semanticdb maven . . kotlin/apply().
          with(this@Table) {
//        ^^^^ reference semanticdb maven . . kotlin/with().
              this@default.getRealColumnsWithValues(defaultValue).forEach {
//                         ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumnsWithValues().
//                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default(+1).(defaultValue)
//                                                                ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                                                                        ^ definition semanticdb maven . . (it) 2:13
//                                                                          display_name it
//                                                                          documentation ```kotlin\nit: CheckConstraint\n```
                  (it.key as Column<Any>).default(it.value as Any)
//                 ^^ reference semanticdb maven . . (it)
//                    ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getKey().
//                    ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#key.
//                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default().
//                                                ^^ reference semanticdb maven . . (it)
//                                                   ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getValue().
//                                                   ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#value.
              }
          }
      }
  
      /** Sets the default value for this column in the database side. */
      fun <T> Column<T>.defaultExpression(defaultValue: Expression<T>): Column<T> = apply {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#defaultExpression().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#defaultExpression().
//                                        display_name defaultExpression
//                                        documentation ```kotlin\npublic final fun <T> Column<T>.defaultExpression(defaultValue: Expression<T>): Column<T>\n```\n\n----\n\n Sets the default value for this column in the database side.
//                                        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#defaultExpression().(defaultValue)
//                                                     display_name defaultValue
//                                                     documentation ```kotlin\ndefaultValue: Expression<T>\n```
//                                                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                  ^^^^^ reference semanticdb maven . . kotlin/apply().
          dbDefaultValue = defaultValue
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#defaultExpression().(defaultValue)
          defaultValueFun = null
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
      }
  
      /** Sets the default value for this column in the client side. */
      fun <T> Column<T>.clientDefault(defaultValue: () -> T): Column<T> = apply {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clientDefault().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clientDefault().
//                                    display_name clientDefault
//                                    documentation ```kotlin\npublic final fun <T> Column<T>.clientDefault(defaultValue: () -> T): Column<T>\n```\n\n----\n\n Sets the default value for this column in the client side.
//                                    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clientDefault().(defaultValue)
//                                                 display_name defaultValue
//                                                 documentation ```kotlin\ndefaultValue: () -> T\n```
//                                                  ^^^^^^^ reference semanticdb maven . . kotlin/Function0#
//                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                        ^^^^^ reference semanticdb maven . . kotlin/apply().
          dbDefaultValue = null
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
          defaultValueFun = defaultValue
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clientDefault().(defaultValue)
      }
  
      /**
       * Marks a column as `databaseGenerated` if the default value of the column is not known at the time of table creation
       * and/or if it depends on other columns. It makes it possible to omit setting it when inserting a new record,
       * without getting an error.
       * The value for the column can be set by creating a TRIGGER or with a DEFAULT clause or
       * by using GENERATED ALWAYS AS via [Column.withDefinition], for example.
       */
      fun <T> Column<T>.databaseGenerated(): Column<T> = apply {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#databaseGenerated().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#databaseGenerated().
//                                        display_name databaseGenerated
//                                        documentation ```kotlin\npublic final fun <T> Column<T>.databaseGenerated(): Column<T>\n```\n\n----\n\n\n Marks a column as `databaseGenerated` if the default value of the column is not known at the time of table creation\n and/or if it depends on other columns. It makes it possible to omit setting it when inserting a new record,\n without getting an error.\n The value for the column can be set by creating a TRIGGER or with a DEFAULT clause or\n by using GENERATED ALWAYS AS via [Column.withDefinition], for example.\n
//                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                       ^^^^^ reference semanticdb maven . . kotlin/apply().
          isDatabaseGenerated = true
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
      }
  
      /** UUID column will auto generate its value on a client side just before an insert. */
      fun Column<UUID>.autoGenerate(): Column<UUID> = clientDefault { UUID.randomUUID() }
//                     ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoGenerate().
//                                  display_name autoGenerate
//                                  documentation ```kotlin\npublic final fun Column<UUID>.autoGenerate(): Column<UUID>\n```\n\n----\n\n UUID column will auto generate its value on a client side just before an insert.
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clientDefault().
//                                                                         ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/UUID#randomUUID().
  
      // Column references
  
      /**
       * Creates a reference from this @receiver column to a [ref] column.
       *
       * This is a short infix version of `references()` with default `onDelete` and `onUpdate` behavior.
       *
       * @receiver A column from the current table where reference values will be stored.
       * @param ref A column from another table which will be used as a "parent".
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.JoinTests.testJoin04
       */
      infix fun <T : Any, S : T, C : Column<S>> C.references(ref: Column<T>): C = references(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Any\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().[S]
//                          display_name FirTypeParameterSymbol S
//                          documentation ```kotlin\nS : T\n```
//                               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().[C]
//                                 display_name FirTypeParameterSymbol C
//                                 documentation ```kotlin\nC : Column<S>\n```
//                                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().
//                                                           display_name references
//                                                           documentation ```kotlin\npublic final infix fun <T : Any, S : T, C : Column<S>> C.references(ref: Column<T>): C\n```\n\n----\n\n\n Creates a reference from this @receiver column to a [ref] column.\n\n This is a short infix version of `references()` with default `onDelete` and `onUpdate` behavior.\n\n @receiver A column from the current table where reference values will be stored.\n @param ref A column from another table which will be used as a "parent".\n @sample org.jetbrains.exposed.v1.tests.shared.dml.JoinTests.testJoin04\n
//                                                           ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().(ref)
//                                                               display_name ref
//                                                               documentation ```kotlin\nref: Column<T>\n```
//                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).
          ref,
//        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().(ref)
          null,
          null,
          null
      )
  
      /**
       * Creates a reference from this @receiver column to a [ref] column with [onDelete], [onUpdate], and [fkName] options.
       * [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting
       * or changing corresponding columns' values.
       * Such a relationship will be represented as a FOREIGN KEY constraint on table creation.
       *
       * @receiver A column from the current table where reference values will be stored.
       * @param ref A column from another table which will be used as a "parent".
       * @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.
       * @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.
       * @param fkName Optional foreign key constraint name.
       * @sample org.jetbrains.exposed.v1.tests.sqlite.ForeignKeyConstraintTests.testUpdateAndDeleteRulesReadCorrectlyWhenSpecifiedInChildTable
       */
      fun <T : Any, S : T, C : Column<S>> C.references(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).[S]
//                    display_name FirTypeParameterSymbol S
//                    documentation ```kotlin\nS : T\n```
//                         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).[C]
//                           display_name FirTypeParameterSymbol C
//                           documentation ```kotlin\nC : Column<S>\n```
//                                          ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).
//                                                     display_name references
//                                                     documentation ```kotlin\npublic final fun <T : Any, S : T, C : Column<S>> C.references(ref: Column<T>, onDelete: ReferenceOption? = ..., onUpdate: ReferenceOption? = ..., fkName: String? = ...): C\n```\n\n----\n\n\n Creates a reference from this @receiver column to a [ref] column with [onDelete], [onUpdate], and [fkName] options.\n [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting\n or changing corresponding columns' values.\n Such a relationship will be represented as a FOREIGN KEY constraint on table creation.\n\n @receiver A column from the current table where reference values will be stored.\n @param ref A column from another table which will be used as a "parent".\n @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.\n @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.\n @param fkName Optional foreign key constraint name.\n @sample org.jetbrains.exposed.v1.tests.sqlite.ForeignKeyConstraintTests.testUpdateAndDeleteRulesReadCorrectlyWhenSpecifiedInChildTable\n
          ref: Column<T>,
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(ref)
//            display_name ref
//            documentation ```kotlin\nref: Column<T>\n```
//             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
      ): C = apply {
//           ^^^^^ reference semanticdb maven . . kotlin/apply().
          this.foreignKey = ForeignKeyConstraint(
//             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`(+1).
              target = ref,
//                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(ref)
              from = this,
              onUpdate = onUpdate,
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(onUpdate)
              onDelete = onDelete,
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(onDelete)
              name = fkName
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(fkName)
          )
      }
  
      /**
       * Creates a reference from this @receiver column to a [ref] column with [onDelete], [onUpdate], and [fkName] options.
       * [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting
       * or changing corresponding columns' values.
       * Such a relationship will be represented as a FOREIGN KEY constraint on table creation.
       *
       * @receiver A column from the current table where reference values will be stored.
       * @param ref A column from another table which will be used as a "parent".
       * @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.
       * @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.
       * @param fkName Optional foreign key constraint name.
       * @sample org.jetbrains.exposed.v1.tests.shared.ddl.CreateMissingTablesAndColumnsTests.ExplicitTable
       */
      @JvmName("referencesById")
      fun <T : Any, S : T, C : Column<S>> C.references(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).[S]
//                    display_name FirTypeParameterSymbol S
//                    documentation ```kotlin\nS : T\n```
//                         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).[C]
//                           display_name FirTypeParameterSymbol C
//                           documentation ```kotlin\nC : Column<S>\n```
//                                          ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).
//                                                     display_name references
//                                                     documentation ```kotlin\n@JvmName(...) public final fun <T : Any, S : T, C : Column<S>> C.references(ref: Column<EntityID<T>>, onDelete: ReferenceOption? = ..., onUpdate: ReferenceOption? = ..., fkName: String? = ...): C\n```\n\n----\n\n\n Creates a reference from this @receiver column to a [ref] column with [onDelete], [onUpdate], and [fkName] options.\n [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting\n or changing corresponding columns' values.\n Such a relationship will be represented as a FOREIGN KEY constraint on table creation.\n\n @receiver A column from the current table where reference values will be stored.\n @param ref A column from another table which will be used as a "parent".\n @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.\n @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.\n @param fkName Optional foreign key constraint name.\n @sample org.jetbrains.exposed.v1.tests.shared.ddl.CreateMissingTablesAndColumnsTests.ExplicitTable\n
          ref: Column<EntityID<T>>,
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(ref)
//            display_name ref
//            documentation ```kotlin\nref: Column<EntityID<T>>\n```
//             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
      ): C = apply {
//           ^^^^^ reference semanticdb maven . . kotlin/apply().
          this.foreignKey = ForeignKeyConstraint(
//             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`(+1).
              target = ref,
//                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(ref)
              from = this,
              onUpdate = onUpdate,
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(onUpdate)
              onDelete = onDelete,
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(onDelete)
              name = fkName
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(fkName)
          )
      }
  
      /**
       * Creates a column with the specified [name] with a reference to the [refColumn] column and with [onDelete],
       * [onUpdate], and [fkName] options.
       * [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting
       * or changing corresponding columns' values.
       * Such a relationship will be represented as a FOREIGN KEY constraint on table creation.
       *
       * @param name Name of the column.
       * @param refColumn A column from another table which will be used as a "parent".
       * @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.
       * @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.
       * @param fkName Optional foreign key constraint name.
       * @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Orders
       */
      fun <T : Any> reference(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().
//                            display_name reference
//                            documentation ```kotlin\npublic final fun <T : Any> reference(name: String, refColumn: Column<T>, onDelete: ReferenceOption? = ..., onUpdate: ReferenceOption? = ..., fkName: String? = ...): Column<T>\n```\n\n----\n\n\n Creates a column with the specified [name] with a reference to the [refColumn] column and with [onDelete],\n [onUpdate], and [fkName] options.\n [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting\n or changing corresponding columns' values.\n Such a relationship will be represented as a FOREIGN KEY constraint on table creation.\n\n @param name Name of the column.\n @param refColumn A column from another table which will be used as a "parent".\n @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.\n @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.\n @param fkName Optional foreign key constraint name.\n @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Orders\n
          name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
          refColumn: Column<T>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(refColumn)
//                  display_name refColumn
//                  documentation ```kotlin\nrefColumn: Column<T>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
      ): Column<T> {
//       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          val column = Column(
//            ^^^^^^ definition local 30
//                   display_name column
//                   documentation ```kotlin\nlocal val column: Column<T>\n```
//                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
              this,
              name,
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(name)
              refColumn.columnType.cloneAsBaseType()
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(refColumn)
//                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneAsBaseType().
          ).references(refColumn, onDelete, onUpdate, fkName)
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(refColumn)
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(onDelete)
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(onUpdate)
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(fkName)
          _columns.addColumn(column)
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_columns.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_columns().
//                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().
//                           ^^^^^^ reference local 30
          return column
//               ^^^^^^ reference local 30
      }
  
      /**
       * Creates a column with the specified [name] with a reference to the [refColumn] column and with [onDelete],
       * [onUpdate], and [fkName] options.
       * [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting
       * or changing corresponding columns' values.
       * Such a relationship will be represented as a FOREIGN KEY constraint on table creation.
       *
       * @param name Name of the column.
       * @param refColumn A column from another table which will be used as a "parent".
       * @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.
       * @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.
       * @param fkName Optional foreign key constraint name.
       * @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Schools
       */
      @Suppress("UNCHECKED_CAST")
      @JvmName("referenceByIdColumn")
      fun <T : Any, E : EntityID<T>> reference(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).[E]
//                    display_name FirTypeParameterSymbol E
//                    documentation ```kotlin\nE : EntityID<T>\n```
//                                   ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).
//                                             display_name reference
//                                             documentation ```kotlin\n@Suppress(...) @JvmName(...) public final fun <T : Any, E : EntityID<T>> reference(name: String, refColumn: Column<E>, onDelete: ReferenceOption? = ..., onUpdate: ReferenceOption? = ..., fkName: String? = ...): Column<E>\n```\n\n----\n\n\n Creates a column with the specified [name] with a reference to the [refColumn] column and with [onDelete],\n [onUpdate], and [fkName] options.\n [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting\n or changing corresponding columns' values.\n Such a relationship will be represented as a FOREIGN KEY constraint on table creation.\n\n @param name Name of the column.\n @param refColumn A column from another table which will be used as a "parent".\n @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.\n @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.\n @param fkName Optional foreign key constraint name.\n @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Schools\n
          name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
          refColumn: Column<E>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(refColumn)
//                  display_name refColumn
//                  documentation ```kotlin\nrefColumn: Column<E>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
      ): Column<E> {
//       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          val entityIDColumn = entityId(name, (refColumn.columnType as EntityIDColumnType<T>).idColumn) as Column<E>
//            ^^^^^^^^^^^^^^ definition local 31
//                           display_name entityIDColumn
//                           documentation ```kotlin\nlocal val entityIDColumn: Column<E>\n```
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(name)
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(refColumn)
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
          return entityIDColumn.references(refColumn, onDelete, onUpdate, fkName)
//               ^^^^^^^^^^^^^^ reference local 31
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).
//                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(refColumn)
//                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(onDelete)
//                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(onUpdate)
//                                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(fkName)
      }
  
      /**
       * Creates a column with the specified [name] with a reference to the `id` column in [foreign] table and with
       * [onDelete], [onUpdate], and [fkName] options.
       * [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting
       * or changing corresponding columns' values.
       * Such a relationship will be represented as a FOREIGN KEY constraint on table creation.
       *
       * @param name Name of the column.
       * @param foreign A table with an `id` column which will be used as a "parent".
       * @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.
       * @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.
       * @param fkName Optional foreign key constraint name.
       * @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Schools
       */
      fun <T : Any> reference(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).
//                            display_name reference
//                            documentation ```kotlin\npublic final fun <T : Any> reference(name: String, foreign: IdTable<T>, onDelete: ReferenceOption? = ..., onUpdate: ReferenceOption? = ..., fkName: String? = ...): Column<EntityID<T>>\n```\n\n----\n\n\n Creates a column with the specified [name] with a reference to the `id` column in [foreign] table and with\n [onDelete], [onUpdate], and [fkName] options.\n [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting\n or changing corresponding columns' values.\n Such a relationship will be represented as a FOREIGN KEY constraint on table creation.\n\n @param name Name of the column.\n @param foreign A table with an `id` column which will be used as a "parent".\n @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.\n @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.\n @param fkName Optional foreign key constraint name.\n @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Schools\n
          name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
          foreign: IdTable<T>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(foreign)
//                display_name foreign
//                documentation ```kotlin\nforeign: IdTable<T>\n```
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
      ): Column<EntityID<T>> {
//       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          require(foreign !is CompositeIdTable || foreign.idColumns.size == 1) {
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(foreign)
//                                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(foreign)
//                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#getIdColumns().
//                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#idColumns.
//                                                                  ^^^^ reference semanticdb maven . . kotlin/collections/Set#getSize().
//                                                                  ^^^^ reference semanticdb maven . . kotlin/collections/Set#size.
              "Use foreignKey() to create a foreign key constraint involving multiple key columns."
          }
          return entityId(name, foreign).references(foreign.id, onDelete, onUpdate, fkName)
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(name)
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(foreign)
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).
//                                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(foreign)
//                                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#getId().
//                                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#id.
//                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(onDelete)
//                                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(onUpdate)
//                                                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(fkName)
      }
  
      /**
       * Creates a column with the specified [name] with an optional reference to the [refColumn] column with [onDelete], [onUpdate], and [fkName] options.
       * [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting
       * or changing corresponding columns' values.
       * Such a relationship will be represented as a FOREIGN KEY constraint on table creation.
       *
       * @param name Name of the column.
       * @param refColumn A column from another table which will be used as a "parent".
       * @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.
       * @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.
       * @param fkName Optional foreign key constraint name.
       * @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Posts
       */
      fun <T : Any> optReference(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().
//                               display_name optReference
//                               documentation ```kotlin\npublic final fun <T : Any> optReference(name: String, refColumn: Column<T>, onDelete: ReferenceOption? = ..., onUpdate: ReferenceOption? = ..., fkName: String? = ...): Column<T?>\n```\n\n----\n\n\n Creates a column with the specified [name] with an optional reference to the [refColumn] column with [onDelete], [onUpdate], and [fkName] options.\n [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting\n or changing corresponding columns' values.\n Such a relationship will be represented as a FOREIGN KEY constraint on table creation.\n\n @param name Name of the column.\n @param refColumn A column from another table which will be used as a "parent".\n @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.\n @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.\n @param fkName Optional foreign key constraint name.\n @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Posts\n
          name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
          refColumn: Column<T>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(refColumn)
//                  display_name refColumn
//                  documentation ```kotlin\nrefColumn: Column<T>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
      ): Column<T?> = reference(name, refColumn, onDelete, onUpdate, fkName).nullable()
//       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(name)
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(refColumn)
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(onDelete)
//                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(onUpdate)
//                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(fkName)
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().
  
      /**
       * Creates a column with the specified [name] with an optional reference to the [refColumn] column with [onDelete], [onUpdate], and [fkName] options.
       * [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting
       * or changing corresponding columns' values.
       * Such a relationship will be represented as a FOREIGN KEY constraint on table creation.
       *
       * @param name Name of the column.
       * @param refColumn A column from another table which will be used as a "parent".
       * @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.
       * @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.
       * @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Posts
       */
      @JvmName("optReferenceByIdColumn")
      fun <T : Any, E : EntityID<T>> optReference(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).[E]
//                    display_name FirTypeParameterSymbol E
//                    documentation ```kotlin\nE : EntityID<T>\n```
//                                   ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).
//                                                display_name optReference
//                                                documentation ```kotlin\n@JvmName(...) public final fun <T : Any, E : EntityID<T>> optReference(name: String, refColumn: Column<E>, onDelete: ReferenceOption? = ..., onUpdate: ReferenceOption? = ..., fkName: String? = ...): Column<E?>\n```\n\n----\n\n\n Creates a column with the specified [name] with an optional reference to the [refColumn] column with [onDelete], [onUpdate], and [fkName] options.\n [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting\n or changing corresponding columns' values.\n Such a relationship will be represented as a FOREIGN KEY constraint on table creation.\n\n @param name Name of the column.\n @param refColumn A column from another table which will be used as a "parent".\n @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.\n @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.\n @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Posts\n
          name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
          refColumn: Column<E>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(refColumn)
//                  display_name refColumn
//                  documentation ```kotlin\nrefColumn: Column<E>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
      ): Column<E?> = reference(name, refColumn, onDelete, onUpdate, fkName).nullable()
//       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(name)
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(refColumn)
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(onDelete)
//                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(onUpdate)
//                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(fkName)
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().
  
      /**
       * Creates a column with the specified [name] with an optional reference to the `id` column in [foreign] table with [onDelete], [onUpdate], and [fkName] options.
       * [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting
       * or changing corresponding columns' values.
       * Such a relationship will be represented as a FOREIGN KEY constraint on table creation.
       *
       * @param name Name of the column.
       * @param foreign A table with an `id` column which will be used as a "parent".
       * @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.
       * @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.
       * @param fkName Optional foreign key constraint name.
       * @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Schools
       */
      fun <T : Any> optReference(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).
//                               display_name optReference
//                               documentation ```kotlin\npublic final fun <T : Any> optReference(name: String, foreign: IdTable<T>, onDelete: ReferenceOption? = ..., onUpdate: ReferenceOption? = ..., fkName: String? = ...): Column<EntityID<T>?>\n```\n\n----\n\n\n Creates a column with the specified [name] with an optional reference to the `id` column in [foreign] table with [onDelete], [onUpdate], and [fkName] options.\n [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting\n or changing corresponding columns' values.\n Such a relationship will be represented as a FOREIGN KEY constraint on table creation.\n\n @param name Name of the column.\n @param foreign A table with an `id` column which will be used as a "parent".\n @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.\n @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.\n @param fkName Optional foreign key constraint name.\n @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Schools\n
          name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
          foreign: IdTable<T>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(foreign)
//                display_name foreign
//                documentation ```kotlin\nforeign: IdTable<T>\n```
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
      ): Column<EntityID<T>?> = reference(name, foreign, onDelete, onUpdate, fkName).nullable()
//       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(name)
//                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(foreign)
//                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(onDelete)
//                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(onUpdate)
//                                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(fkName)
//                                                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().
  
      // Miscellaneous
  
      /** Marks this column as nullable. */
      fun <T : Any> Column<T>.nullable(): Column<T?> {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                            ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().
//                                     display_name nullable
//                                     documentation ```kotlin\npublic final fun <T : Any> Column<T>.nullable(): Column<T?>\n```\n\n----\n\n Marks this column as nullable.
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          val newColumn = Column<T?>(table, name, columnType)
//            ^^^^^^^^^ definition local 32
//                      display_name newColumn
//                      documentation ```kotlin\nlocal val newColumn: Column<T?>\n```
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
          newColumn.foreignKey = foreignKey
//        ^^^^^^^^^ reference local 32
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
          newColumn.defaultValueFun = defaultValueFun
//        ^^^^^^^^^ reference local 32
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
          @Suppress("UNCHECKED_CAST")
          newColumn.dbDefaultValue = dbDefaultValue as Expression<T?>?
//        ^^^^^^^^^ reference local 32
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
          newColumn.isDatabaseGenerated = isDatabaseGenerated
//        ^^^^^^^^^ reference local 32
//                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
//                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
          newColumn.columnType.nullable = true
//        ^^^^^^^^^ reference local 32
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
          newColumn.extraDefinitions = extraDefinitions
//        ^^^^^^^^^ reference local 32
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
          return replaceColumn(this, newColumn)
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                   ^^^^^^^^^ reference local 32
      }
  
      /** Marks this [CompositeColumn] as nullable. */
      @Suppress("UNCHECKED_CAST")
      @LowPriorityInOverloadResolution
      fun <T : Any, C : CompositeColumn<T>> C.nullable(): CompositeColumn<T?> = apply {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable(+1).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable(+1).[C]
//                    display_name FirTypeParameterSymbol C
//                    documentation ```kotlin\nC : CompositeColumn<T>\n```
//                                            ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable(+1).
//                                                     display_name nullable
//                                                     documentation ```kotlin\n@Suppress(...) @<ERROR TYPE REF: HIDDEN: kotlin/internal/LowPriorityInOverloadResolution is invisible>() public final fun <T : Any, C : CompositeColumn<T>> C.nullable(): CompositeColumn<T?>\n```\n\n----\n\n Marks this [CompositeColumn] as nullable.
//                                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#
//                                                                              ^^^^^ reference semanticdb maven . . kotlin/apply().
          nullable = true
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getNullable().
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#nullable.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#setNullable().
          getRealColumns().filter { !it.columnType.nullable }.forEach { (it as Column<Any>).nullable() }
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumns().
//                         ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                            display_name it
//                                                            documentation ```kotlin\nit: CheckConstraint\n```
//                                  ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                   ^^ reference semanticdb maven . . (it)
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
//                                                            ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                       display_name it
//                                                                                                       documentation ```kotlin\nit: CheckConstraint\n```
//                                                                       ^^ reference semanticdb maven . . (it)
//                                                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().
      } as CompositeColumn<T?>
  
      /**
       * Appends a database-specific column [definition] to this column's SQL in a CREATE TABLE statement.
       *
       * The specified [definition] is appended after the column's name, type, and default value (if any),
       * but before any column constraint definitions. If multiple definition arguments are passed, they
       * will be joined as string representations separated by a single space character.
       */
      fun <T> Column<T>.withDefinition(vararg definition: Any): Column<T> = apply {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#withDefinition().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#withDefinition().
//                                     display_name withDefinition
//                                     documentation ```kotlin\npublic final fun <T> Column<T>.withDefinition(vararg definition: Any): Column<T>\n```\n\n----\n\n\n Appends a database-specific column [definition] to this column's SQL in a CREATE TABLE statement.\n\n The specified [definition] is appended after the column's name, type, and default value (if any),\n but before any column constraint definitions. If multiple definition arguments are passed, they\n will be joined as string representations separated by a single space character.\n
//                                            ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#withDefinition().(definition)
//                                                       display_name definition
//                                                       documentation ```kotlin\nvararg definition: Any\n```
//                                                        ^^^ reference semanticdb maven . . kotlin/Array#
//                                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                          ^^^^^ reference semanticdb maven . . kotlin/apply().
          extraDefinitions.addAll(definition)
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
//                         ^^^^^^ reference semanticdb maven . . kotlin/collections/addAll(+2).
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#withDefinition().(definition)
      }
  
      /**
       * Transforms a column by specifying transformation functions.
       *
       * Sample:
       * ```kotlin
       * object TestTable : IntIdTable() {
       *     val stringToInteger = integer("stringToInteger")
       *         .transform(wrap = { it.toString() }, unwrap = { it.toInt() })
       * }
       * ```
       *
       * @param Wrapped The type into which the value of the underlying column will be transformed.
       * @param Unwrapped The type of the original column.
       * @param wrap A function to transform from the source type [Unwrapped] to the target type [Wrapped].
       * @param unwrap A function to transform from the target type [Wrapped] to the source type [Unwrapped].
       * @return A new column of type [Wrapped] with the applied transformations.
       */
      fun <Unwrapped : Any, Wrapped : Any> Column<Unwrapped>.transform(
//         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().[Unwrapped]
//                   display_name FirTypeParameterSymbol Unwrapped
//                   documentation ```kotlin\nUnwrapped : Any\n```
//                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().[Wrapped]
//                                  display_name FirTypeParameterSymbol Wrapped
//                                  documentation ```kotlin\nWrapped : Any\n```
//                                                           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().
//                                                                     display_name transform
//                                                                     documentation ```kotlin\npublic final fun <Unwrapped : Any, Wrapped : Any> Column<Unwrapped>.transform(wrap: (Unwrapped) -> Wrapped, unwrap: (Wrapped) -> Unwrapped): Column<Wrapped>\n```\n\n----\n\n\n Transforms a column by specifying transformation functions.\n\n Sample:\n ```kotlin\n object TestTable : IntIdTable() {\n     val stringToInteger = integer("stringToInteger")\n         .transform(wrap = { it.toString() }, unwrap = { it.toInt() })\n }\n ```\n\n @param Wrapped The type into which the value of the underlying column will be transformed.\n @param Unwrapped The type of the original column.\n @param wrap A function to transform from the source type [Unwrapped] to the target type [Wrapped].\n @param unwrap A function to transform from the target type [Wrapped] to the source type [Unwrapped].\n @return A new column of type [Wrapped] with the applied transformations.\n
          wrap: (Unwrapped) -> Wrapped,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().(wrap)
//             display_name wrap
//             documentation ```kotlin\nwrap: (Unwrapped) -> Wrapped\n```
//              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
          unwrap: (Wrapped) -> Unwrapped
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().(unwrap)
//               display_name unwrap
//               documentation ```kotlin\nunwrap: (Wrapped) -> Unwrapped\n```
//                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      ): Column<Wrapped> = transform(columnTransformer(unwrap, wrap))
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).
//                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/columnTransformer().
//                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().(unwrap)
//                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().(wrap)
  
      /**
       * Transforms a column by specifying a transformer.
       *
       * Sample:
       * ```kotlin
       * object StringToIntListTransformer : ColumnTransformer<String, List<Int>> {
       *     override fun wrap(value: String): List<Int> {
       *         val result = value.split(",").map { it.toInt() }
       *         return result
       *     }
       *
       *     override fun unwrap(value: List<Int>): String = value.joinToString(",")
       * }
       *
       * object TestTable : IntIdTable() {
       *     val numbers = text("numbers").transform(StringToIntListTransformer)
       * }
       * ```
       *
       * @param Wrapped The type into which the value of the underlying column will be transformed.
       * @param Unwrapped The type of the original column.
       * @param transformer An instance of [ColumnTransformer] to handle the transformations.
       * @return A new column of type [Wrapped] with the applied transformations.
       */
      fun <Unwrapped : Any, Wrapped : Any> Column<Unwrapped>.transform(
//         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).[Unwrapped]
//                   display_name FirTypeParameterSymbol Unwrapped
//                   documentation ```kotlin\nUnwrapped : Any\n```
//                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).[Wrapped]
//                                  display_name FirTypeParameterSymbol Wrapped
//                                  documentation ```kotlin\nWrapped : Any\n```
//                                                           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).
//                                                                     display_name transform
//                                                                     documentation ```kotlin\npublic final fun <Unwrapped : Any, Wrapped : Any> Column<Unwrapped>.transform(transformer: ColumnTransformer<Unwrapped, Wrapped>): Column<Wrapped>\n```\n\n----\n\n\n Transforms a column by specifying a transformer.\n\n Sample:\n ```kotlin\n object StringToIntListTransformer : ColumnTransformer<String, List<Int>> {\n     override fun wrap(value: String): List<Int> {\n         val result = value.split(",").map { it.toInt() }\n         return result\n     }\n\n     override fun unwrap(value: List<Int>): String = value.joinToString(",")\n }\n\n object TestTable : IntIdTable() {\n     val numbers = text("numbers").transform(StringToIntListTransformer)\n }\n ```\n\n @param Wrapped The type into which the value of the underlying column will be transformed.\n @param Unwrapped The type of the original column.\n @param transformer An instance of [ColumnTransformer] to handle the transformations.\n @return A new column of type [Wrapped] with the applied transformations.\n
          transformer: ColumnTransformer<Unwrapped, Wrapped>
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).(transformer)
//                    display_name transformer
//                    documentation ```kotlin\ntransformer: ColumnTransformer<Unwrapped, Wrapped>\n```
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#
      ): Column<Wrapped> {
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          val newColumn = copyWithAnotherColumnType(ColumnWithTransform(this.columnType, transformer)) {
//            ^^^^^^^^^ definition local 33
//                      display_name newColumn
//                      documentation ```kotlin\nlocal val newColumn: Column<Wrapped>\n```
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().
//                                                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#`<init>`().
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).(transformer)
              defaultValueFun = this@transform.defaultValueFun?.let { { transformer.wrap(it()) } }
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                              ^^^ reference semanticdb maven . . kotlin/let().
//                                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                 display_name it
//                                                                                                 documentation ```kotlin\nit: CheckConstraint\n```
//                                                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).(transformer)
//                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#wrap().
//                                                                                       ^^ reference semanticdb maven . . (it)
//                                                                                       ^^ reference semanticdb maven . . kotlin/Function0#invoke().
          }
          return replaceColumn(this, newColumn)
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                   ^^^^^^^^^ reference local 33
      }
  
      /**
       * Transforms a nullable column by specifying transformation functions.
       *
       * Sample:
       * ```kotlin
       * object TestTable : IntIdTable() {
       *     val nullableStringToInteger = integer("nullableStringToInteger")
       *         .nullable()
       *         .transform(wrap = { it?.toString() }, unwrap = { it?.toInt() })
       * }
       * ```
       *
       * @param Wrapped The type into which the value of the underlying column will be transformed.
       * @param Unwrapped The type of the original column.
       * @param wrap A function to transform from the source type [Unwrapped] to the target type [Wrapped].
       * @param unwrap A function to transform from the target type [Wrapped] to the source type [Unwrapped].
       * @return A new column of type [Wrapped]`?` with the applied transformations.
       */
      @JvmName("transformNullable")
      fun <Unwrapped : Any, Wrapped : Any> Column<Unwrapped?>.transform(
//         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).[Unwrapped]
//                   display_name FirTypeParameterSymbol Unwrapped
//                   documentation ```kotlin\nUnwrapped : Any\n```
//                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).[Wrapped]
//                                  display_name FirTypeParameterSymbol Wrapped
//                                  documentation ```kotlin\nWrapped : Any\n```
//                                                            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).
//                                                                      display_name transform
//                                                                      documentation ```kotlin\n@JvmName(...) public final fun <Unwrapped : Any, Wrapped : Any> Column<Unwrapped?>.transform(wrap: (Unwrapped?) -> Wrapped?, unwrap: (Wrapped?) -> Unwrapped?): Column<Wrapped?>\n```\n\n----\n\n\n Transforms a nullable column by specifying transformation functions.\n\n Sample:\n ```kotlin\n object TestTable : IntIdTable() {\n     val nullableStringToInteger = integer("nullableStringToInteger")\n         .nullable()\n         .transform(wrap = { it?.toString() }, unwrap = { it?.toInt() })\n }\n ```\n\n @param Wrapped The type into which the value of the underlying column will be transformed.\n @param Unwrapped The type of the original column.\n @param wrap A function to transform from the source type [Unwrapped] to the target type [Wrapped].\n @param unwrap A function to transform from the target type [Wrapped] to the source type [Unwrapped].\n @return A new column of type [Wrapped]`?` with the applied transformations.\n
          wrap: (Unwrapped?) -> Wrapped?,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).(wrap)
//             display_name wrap
//             documentation ```kotlin\nwrap: (Unwrapped?) -> Wrapped?\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
          unwrap: (Wrapped?) -> Unwrapped?
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).(unwrap)
//               display_name unwrap
//               documentation ```kotlin\nunwrap: (Wrapped?) -> Unwrapped?\n```
//                ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      ): Column<Wrapped?> = transform(columnTransformer(unwrap, wrap))
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).
//                                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/columnTransformer().
//                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).(unwrap)
//                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).(wrap)
  
      /**
       * Transforms a nullable column by specifying a transformer.
       *
       * Sample:
       * ```kotlin
       * object StringToIntListTransformer : ColumnTransformer<String?, List<Int>?> {
       *     override fun wrap(value: String?): List<Int>? = value?.split(",")?.map { it.toInt() }
       *
       *     override fun unwrap(value: List<Int>): String = value?.joinToString(",")
       * }
       *
       * object TestTable : IntIdTable() {
       *     val numbers = text("numbers").nullable().transform(StringToIntListTransformer)
       * }
       * ```
       *
       * @param Wrapped The type into which the value of the underlying column will be transformed.
       * @param Unwrapped The type of the original column.
       * @param transformer An instance of [ColumnTransformer] to handle the transformations.
       * @return A new column of type [Wrapped]`?` with the applied transformations.
       */
      @JvmName("transformNullable")
      fun <Unwrapped : Any, Wrapped : Any> Column<Unwrapped?>.transform(
//         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).[Unwrapped]
//                   display_name FirTypeParameterSymbol Unwrapped
//                   documentation ```kotlin\nUnwrapped : Any\n```
//                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).[Wrapped]
//                                  display_name FirTypeParameterSymbol Wrapped
//                                  documentation ```kotlin\nWrapped : Any\n```
//                                                            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).
//                                                                      display_name transform
//                                                                      documentation ```kotlin\n@JvmName(...) public final fun <Unwrapped : Any, Wrapped : Any> Column<Unwrapped?>.transform(transformer: ColumnTransformer<Unwrapped?, Wrapped?>): Column<Wrapped?>\n```\n\n----\n\n\n Transforms a nullable column by specifying a transformer.\n\n Sample:\n ```kotlin\n object StringToIntListTransformer : ColumnTransformer<String?, List<Int>?> {\n     override fun wrap(value: String?): List<Int>? = value?.split(",")?.map { it.toInt() }\n\n     override fun unwrap(value: List<Int>): String = value?.joinToString(",")\n }\n\n object TestTable : IntIdTable() {\n     val numbers = text("numbers").nullable().transform(StringToIntListTransformer)\n }\n ```\n\n @param Wrapped The type into which the value of the underlying column will be transformed.\n @param Unwrapped The type of the original column.\n @param transformer An instance of [ColumnTransformer] to handle the transformations.\n @return A new column of type [Wrapped]`?` with the applied transformations.\n
          transformer: ColumnTransformer<Unwrapped?, Wrapped?>
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).(transformer)
//                    display_name transformer
//                    documentation ```kotlin\ntransformer: ColumnTransformer<Unwrapped?, Wrapped?>\n```
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#
      ): Column<Wrapped?> {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          val newColumn = copyWithAnotherColumnType<Wrapped?>(NullableColumnWithTransform(this.columnType, transformer)) {
//            ^^^^^^^^^ definition local 34
//                      display_name newColumn
//                      documentation ```kotlin\nlocal val newColumn: Column<Wrapped?>\n```
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#`<init>`().
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).(transformer)
              defaultValueFun = this@transform.defaultValueFun?.let { { it()?.let { value -> transformer.wrap(value) } } }
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                              ^^^ reference semanticdb maven . . kotlin/let().
//                                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                         display_name it
//                                                                                                                         documentation ```kotlin\nit: CheckConstraint\n```
//                                                                      ^^ reference semanticdb maven . . (it)
//                                                                      ^^ reference semanticdb maven . . kotlin/Function0#invoke().
//                                                                            ^^^ reference semanticdb maven . . kotlin/let().
//                                                                                  ^^^^^ definition semanticdb maven . . (value)
//                                                                                        display_name value
//                                                                                        documentation ```kotlin\nvalue: Unwrapped\n```
//                                                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).(transformer)
//                                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#wrap().
//                                                                                                            ^^^^^ reference semanticdb maven . . (value)
          }
          return replaceColumn(this, newColumn)
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                   ^^^^^^^^^ reference local 34
      }
  
      /**
       * Applies a special transformation that allows a non-nullable database column
       * to accept and/or return values as `null` on the client side.
       *
       * This transformation does not alter the column's definition in the database,
       * which will still be `NON NULL`. It enables reflecting non-null values
       * from the database as `null` in Kotlin (e.g., converting an empty string from a
       * non-nullable text column, empty lists, negative IDs, etc., to `null`).
       *
       * @param Wrapped The type into which the value of the underlying column will be transformed.
       * @param Unwrapped The type of the original column.
       * @param wrap A function to transform from the source type [Unwrapped] to the target type [Wrapped].
       * @param unwrap A function to transform from the target type [Wrapped] to the source type [Unwrapped].
       * @return A new column of type [Wrapped]`?` with the applied transformations.
       */
      @JvmName("nullTransform")
      fun <Unwrapped : Any, Wrapped : Any> Column<Unwrapped>.nullTransform(
//         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().[Unwrapped]
//                   display_name FirTypeParameterSymbol Unwrapped
//                   documentation ```kotlin\nUnwrapped : Any\n```
//                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().[Wrapped]
//                                  display_name FirTypeParameterSymbol Wrapped
//                                  documentation ```kotlin\nWrapped : Any\n```
//                                                           ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().
//                                                                         display_name nullTransform
//                                                                         documentation ```kotlin\n@JvmName(...) public final fun <Unwrapped : Any, Wrapped : Any> Column<Unwrapped>.nullTransform(wrap: (Unwrapped) -> Wrapped?, unwrap: (Wrapped?) -> Unwrapped): Column<Wrapped?>\n```\n\n----\n\n\n Applies a special transformation that allows a non-nullable database column\n to accept and/or return values as `null` on the client side.\n\n This transformation does not alter the column's definition in the database,\n which will still be `NON NULL`. It enables reflecting non-null values\n from the database as `null` in Kotlin (e.g., converting an empty string from a\n non-nullable text column, empty lists, negative IDs, etc., to `null`).\n\n @param Wrapped The type into which the value of the underlying column will be transformed.\n @param Unwrapped The type of the original column.\n @param wrap A function to transform from the source type [Unwrapped] to the target type [Wrapped].\n @param unwrap A function to transform from the target type [Wrapped] to the source type [Unwrapped].\n @return A new column of type [Wrapped]`?` with the applied transformations.\n
          wrap: (Unwrapped) -> Wrapped?,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().(wrap)
//             display_name wrap
//             documentation ```kotlin\nwrap: (Unwrapped) -> Wrapped?\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
          unwrap: (Wrapped?) -> Unwrapped
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().(unwrap)
//               display_name unwrap
//               documentation ```kotlin\nunwrap: (Wrapped?) -> Unwrapped\n```
//                ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      ): Column<Wrapped?> = nullTransform(columnTransformer(unwrap, wrap))
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).
//                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/columnTransformer().
//                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().(unwrap)
//                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().(wrap)
  
      /**
       * Applies a special transformation that allows a non-nullable database column
       * to accept and/or return values as `null` on the client side.
       *
       * This transformation does not alter the column's definition in the database,
       * which will still be `NON NULL`. It enables reflecting non-null values
       * from the database as `null` in Kotlin (e.g., converting an empty string from a
       * non-nullable text column, empty lists, negative IDs, etc., to `null`).
       *
       * @param Wrapped The type into which the value of the underlying column will be transformed.
       * @param Unwrapped The type of the original column.
       * @param transformer An instance of [ColumnTransformer] to handle the transformations.
       * @return A new column of type [Wrapped]`?` with the applied transformations.
       */
      @JvmName("nullTransform")
      fun <Unwrapped : Any, Wrapped : Any> Column<Unwrapped>.nullTransform(
//         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).[Unwrapped]
//                   display_name FirTypeParameterSymbol Unwrapped
//                   documentation ```kotlin\nUnwrapped : Any\n```
//                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).[Wrapped]
//                                  display_name FirTypeParameterSymbol Wrapped
//                                  documentation ```kotlin\nWrapped : Any\n```
//                                                           ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).
//                                                                         display_name nullTransform
//                                                                         documentation ```kotlin\n@JvmName(...) public final fun <Unwrapped : Any, Wrapped : Any> Column<Unwrapped>.nullTransform(transformer: ColumnTransformer<Unwrapped, Wrapped?>): Column<Wrapped?>\n```\n\n----\n\n\n Applies a special transformation that allows a non-nullable database column\n to accept and/or return values as `null` on the client side.\n\n This transformation does not alter the column's definition in the database,\n which will still be `NON NULL`. It enables reflecting non-null values\n from the database as `null` in Kotlin (e.g., converting an empty string from a\n non-nullable text column, empty lists, negative IDs, etc., to `null`).\n\n @param Wrapped The type into which the value of the underlying column will be transformed.\n @param Unwrapped The type of the original column.\n @param transformer An instance of [ColumnTransformer] to handle the transformations.\n @return A new column of type [Wrapped]`?` with the applied transformations.\n
          transformer: ColumnTransformer<Unwrapped, Wrapped?>
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).(transformer)
//                    display_name transformer
//                    documentation ```kotlin\ntransformer: ColumnTransformer<Unwrapped, Wrapped?>\n```
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#
      ): Column<Wrapped?> {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          val newColumn = copyWithAnotherColumnType<Wrapped?>(NullableColumnWithTransform(this.columnType, transformer)) {
//            ^^^^^^^^^ definition local 35
//                      display_name newColumn
//                      documentation ```kotlin\nlocal val newColumn: Column<Wrapped?>\n```
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#`<init>`().
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).(transformer)
              defaultValueFun = this@nullTransform.defaultValueFun?.let { { it().let { value -> transformer.wrap(value) } } }
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                                  ^^^ reference semanticdb maven . . kotlin/let().
//                                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                            display_name it
//                                                                                                                            documentation ```kotlin\nit: CheckConstraint\n```
//                                                                          ^^ reference semanticdb maven . . (it)
//                                                                          ^^ reference semanticdb maven . . kotlin/Function0#invoke().
//                                                                               ^^^ reference semanticdb maven . . kotlin/let().
//                                                                                     ^^^^^ definition semanticdb maven . . (value)
//                                                                                           display_name value
//                                                                                           documentation ```kotlin\nvalue: Unwrapped\n```
//                                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).(transformer)
//                                                                                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#wrap().
//                                                                                                               ^^^^^ reference semanticdb maven . . (value)
          }
          return replaceColumn(this, newColumn)
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                   ^^^^^^^^^ reference local 35
      }
  
      // Indices
  
      /**
       * Creates an index.
       *
       * @param isUnique Whether the index is unique or not.
       * @param columns Columns that compose the index.
       */
      fun index(isUnique: Boolean = false, vararg columns: Column<*>) {
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index().
//              display_name index
//              documentation ```kotlin\npublic final fun index(isUnique: Boolean = ..., vararg columns: Column<*>): Unit\n```\n\n----\n\n\n Creates an index.\n\n @param isUnique Whether the index is unique or not.\n @param columns Columns that compose the index.\n
//              ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index().(isUnique)
//                       display_name isUnique
//                       documentation ```kotlin\nisUnique: Boolean = ...\n```
//                        ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index().(columns)
//                                                        display_name columns
//                                                        documentation ```kotlin\nvararg columns: Column<*>\n```
//                                                         ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
          index(null, isUnique, *columns)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index().(isUnique)
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index().(columns)
      }
  
      /**
       * Creates an index.
       *
       * @param customIndexName Name of the index.
       * @param isUnique Whether the index is unique or not.
       * @param columns Columns that compose the index.
       * @param functions Functions that compose the index.
       * @param indexType A custom index type (e.g., "BTREE" or "HASH").
       * @param filterCondition Index filtering conditions (also known as "partial index") declaration.
       */
      fun index(
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).
//              display_name index
//              documentation ```kotlin\npublic final fun index(customIndexName: String? = ..., isUnique: Boolean = ..., vararg columns: Column<*>, functions: List<ExpressionWithColumnType<*>>? = ..., indexType: String? = ..., filterCondition: {org/jetbrains/exposed/v1/core/FilterCondition=} (SqlExpressionBuilder.() -> Op<Boolean>)? = ...): Unit\n```\n\n----\n\n\n Creates an index.\n\n @param customIndexName Name of the index.\n @param isUnique Whether the index is unique or not.\n @param columns Columns that compose the index.\n @param functions Functions that compose the index.\n @param indexType A custom index type (e.g., "BTREE" or "HASH").\n @param filterCondition Index filtering conditions (also known as "partial index") declaration.\n
          customIndexName: String? = null,
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(customIndexName)
//                        display_name customIndexName
//                        documentation ```kotlin\ncustomIndexName: String? = ...\n```
//                         ^^^^^^^ reference semanticdb maven . . kotlin/String#
          isUnique: Boolean = false,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(isUnique)
//                 display_name isUnique
//                 documentation ```kotlin\nisUnique: Boolean = ...\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          vararg columns: Column<*>,
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(columns)
//                       display_name columns
//                       documentation ```kotlin\nvararg columns: Column<*>\n```
//                        ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
          functions: List<ExpressionWithColumnType<*>>? = null,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(functions)
//                  display_name functions
//                  documentation ```kotlin\nfunctions: List<ExpressionWithColumnType<*>>? = ...\n```
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          indexType: String? = null,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(indexType)
//                  display_name indexType
//                  documentation ```kotlin\nindexType: String? = ...\n```
//                   ^^^^^^^ reference semanticdb maven . . kotlin/String#
          filterCondition: FilterCondition = null
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(filterCondition)
//                        display_name filterCondition
//                        documentation ```kotlin\nfilterCondition: {org/jetbrains/exposed/v1/core/FilterCondition=} (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      ) {
          _indices.add(
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_indices.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_indices().
//                 ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
              Index(
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().
                  columns.toList(),
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(columns)
//                        ^^^^^^ reference semanticdb maven . . kotlin/collections/toList().
                  isUnique,
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(isUnique)
                  customIndexName,
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(customIndexName)
                  indexType,
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(indexType)
                  filterCondition?.invoke(SqlExpressionBuilder),
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(filterCondition)
//                                 ^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
                  functions,
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(functions)
                  functions?.let { this }
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(functions)
//                           ^^^ reference semanticdb maven . . kotlin/let().
//                               ^^^^^^^^ definition semanticdb maven . . (it)
//                                        display_name it
//                                        documentation ```kotlin\nit: CheckConstraint\n```
              )
          )
      }
  
      /**
       * Creates an index composed by this column only.
       *
       * @param customIndexName Name of the index.
       * @param isUnique Whether the index is unique or not.
       */
      fun <T> Column<T>.index(customIndexName: String? = null, isUnique: Boolean = false): Column<T> =
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).
//                            display_name index
//                            documentation ```kotlin\npublic final fun <T> Column<T>.index(customIndexName: String? = ..., isUnique: Boolean = ...): Column<T>\n```\n\n----\n\n\n Creates an index composed by this column only.\n\n @param customIndexName Name of the index.\n @param isUnique Whether the index is unique or not.\n
//                            ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).(customIndexName)
//                                            display_name customIndexName
//                                            documentation ```kotlin\ncustomIndexName: String? = ...\n```
//                                             ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                             ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).(isUnique)
//                                                                      display_name isUnique
//                                                                      documentation ```kotlin\nisUnique: Boolean = ...\n```
//                                                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          apply { table.index(customIndexName, isUnique, this) }
//        ^^^^^ reference semanticdb maven . . kotlin/apply().
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).(customIndexName)
//                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).(isUnique)
  
      /**
       * Creates a unique index composed by this column only.
       *
       * @param customIndexName Name of the index.
       */
      fun <T> Column<T>.uniqueIndex(customIndexName: String? = null): Column<T> =
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex().
//                                  display_name uniqueIndex
//                                  documentation ```kotlin\npublic final fun <T> Column<T>.uniqueIndex(customIndexName: String? = ...): Column<T>\n```\n\n----\n\n\n Creates a unique index composed by this column only.\n\n @param customIndexName Name of the index.\n
//                                  ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex().(customIndexName)
//                                                  display_name customIndexName
//                                                  documentation ```kotlin\ncustomIndexName: String? = ...\n```
//                                                   ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          index(customIndexName, true)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex().(customIndexName)
  
      /**
       * Creates a unique index.
       *
       * @param columns Columns that compose the index.
       * @param filterCondition Index filtering conditions (also known as "partial index") declaration.
       */
      fun uniqueIndex(vararg columns: Column<*>, filterCondition: FilterCondition = null) {
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+1).
//                    display_name uniqueIndex
//                    documentation ```kotlin\npublic final fun uniqueIndex(vararg columns: Column<*>, filterCondition: {org/jetbrains/exposed/v1/core/FilterCondition=} (SqlExpressionBuilder.() -> Op<Boolean>)? = ...): Unit\n```\n\n----\n\n\n Creates a unique index.\n\n @param columns Columns that compose the index.\n @param filterCondition Index filtering conditions (also known as "partial index") declaration.\n
//                           ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+1).(columns)
//                                   display_name columns
//                                   documentation ```kotlin\nvararg columns: Column<*>\n```
//                                    ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+1).(filterCondition)
//                                                               display_name filterCondition
//                                                               documentation ```kotlin\nfilterCondition: {org/jetbrains/exposed/v1/core/FilterCondition=} (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                                                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
          index(null, true, *columns, filterCondition = filterCondition)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).
//                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+1).(columns)
//                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+1).(filterCondition)
      }
  
      /**
       * Creates a unique index.
       *
       * @param customIndexName Name of the index.
       * @param columns Columns that compose the index.
       * @param functions Functions that compose the index.
       * @param filterCondition Index filtering conditions (also known as "partial index") declaration.
       */
      fun uniqueIndex(
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).
//                    display_name uniqueIndex
//                    documentation ```kotlin\npublic final fun uniqueIndex(customIndexName: String? = ..., vararg columns: Column<*>, functions: List<ExpressionWithColumnType<*>>? = ..., filterCondition: {org/jetbrains/exposed/v1/core/FilterCondition=} (SqlExpressionBuilder.() -> Op<Boolean>)? = ...): Unit\n```\n\n----\n\n\n Creates a unique index.\n\n @param customIndexName Name of the index.\n @param columns Columns that compose the index.\n @param functions Functions that compose the index.\n @param filterCondition Index filtering conditions (also known as "partial index") declaration.\n
          customIndexName: String? = null,
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(customIndexName)
//                        display_name customIndexName
//                        documentation ```kotlin\ncustomIndexName: String? = ...\n```
//                         ^^^^^^^ reference semanticdb maven . . kotlin/String#
          vararg columns: Column<*>,
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(columns)
//                       display_name columns
//                       documentation ```kotlin\nvararg columns: Column<*>\n```
//                        ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
          functions: List<ExpressionWithColumnType<*>>? = null,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(functions)
//                  display_name functions
//                  documentation ```kotlin\nfunctions: List<ExpressionWithColumnType<*>>? = ...\n```
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          filterCondition: FilterCondition = null
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(filterCondition)
//                        display_name filterCondition
//                        documentation ```kotlin\nfilterCondition: {org/jetbrains/exposed/v1/core/FilterCondition=} (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      ) {
          index(customIndexName, true, *columns, functions = functions, filterCondition = filterCondition)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(customIndexName)
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(columns)
//                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(functions)
//                                                                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(filterCondition)
      }
  
      /**
       * Creates a composite foreign key.
       *
       * @param from Columns in this referencing child table that compose the foreign key.
       * Their order should match the order of columns in the referenced parent table's primary key.
       * @param target Primary key of the referenced parent table.
       * @param onUpdate [ReferenceOption] when performing update operations.
       * @param onDelete [ReferenceOption] when performing delete operations.
       * @param name Custom foreign key constraint name.
       * @sample org.jetbrains.exposed.v1.tests.shared.ddl.CreateMissingTablesAndColumnsTests.CompositeForeignKeyTable
       */
      fun foreignKey(
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().
//                   display_name foreignKey
//                   documentation ```kotlin\npublic final fun foreignKey(vararg from: Column<*>, target: Table.PrimaryKey, onUpdate: ReferenceOption? = ..., onDelete: ReferenceOption? = ..., name: String? = ...): Unit\n```\n\n----\n\n\n Creates a composite foreign key.\n\n @param from Columns in this referencing child table that compose the foreign key.\n Their order should match the order of columns in the referenced parent table's primary key.\n @param target Primary key of the referenced parent table.\n @param onUpdate [ReferenceOption] when performing update operations.\n @param onDelete [ReferenceOption] when performing delete operations.\n @param name Custom foreign key constraint name.\n @sample org.jetbrains.exposed.v1.tests.shared.ddl.CreateMissingTablesAndColumnsTests.CompositeForeignKeyTable\n
          vararg from: Column<*>,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(from)
//                    display_name from
//                    documentation ```kotlin\nvararg from: Column<*>\n```
//                     ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
          target: PrimaryKey,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(target)
//               display_name target
//               documentation ```kotlin\ntarget: Table.PrimaryKey\n```
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          name: String? = null
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(name)
//             display_name name
//             documentation ```kotlin\nname: String? = ...\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/String#
      ) {
          require(from.size == target.columns.size) {
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(from)
//                     ^^^^ reference semanticdb maven . . kotlin/Array#getSize().
//                     ^^^^ reference semanticdb maven . . kotlin/Array#size.
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(target)
//                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                                            ^^^^ reference semanticdb maven . . kotlin/Array#getSize().
//                                            ^^^^ reference semanticdb maven . . kotlin/Array#size.
              val fkName = if (name != null) " ($name)" else ""
//                ^^^^^^ definition local 36
//                       display_name fkName
//                       documentation ```kotlin\nlocal val fkName: String\n```
//                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(name)
//                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(name)
              "Foreign key$fkName has ${from.size} columns, while referenced primary key (${target.name}) has ${target.columns.size}"
//                         ^^^^^^ reference local 36
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(from)
//                                           ^^^^ reference semanticdb maven . . kotlin/Array#getSize().
//                                           ^^^^ reference semanticdb maven . . kotlin/Array#size.
//                                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(target)
//                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getName().
//                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#name.
//                                                                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(target)
//                                                                                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                                                                                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                                                                                                                             ^^^^ reference semanticdb maven . . kotlin/Array#getSize().
//                                                                                                                             ^^^^ reference semanticdb maven . . kotlin/Array#size.
          }
          _foreignKeys.add(ForeignKeyConstraint(from.zip(target.columns).toMap(), onUpdate, onDelete, name))
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_foreignKeys.
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_foreignKeys().
//                     ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`().
//                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(from)
//                                                   ^^^ reference semanticdb maven . . kotlin/collections/zip().
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(target)
//                                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                                                                       ^^^^^ reference semanticdb maven . . kotlin/collections/toMap().
//                                                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(onUpdate)
//                                                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(onDelete)
//                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(name)
      }
  
      /**
       * Creates a composite foreign key.
       *
       * @param references Pairs of child table and parent table columns that compose the foreign key.
       * The first value of each pair should be a column from this referencing child table,
       * with the second value being a column from the referenced parent table.
       * All referencing columns must belong to this table.
       * All referenced columns must belong to the same table.
       * @param onUpdate [ReferenceOption] when performing update operations.
       * @param onDelete [ReferenceOption] when performing delete operations.
       * @param name Custom foreign key constraint name.
       * @sample org.jetbrains.exposed.v1.tests.shared.DDLTests.testCompositeFKReferencingUniqueIndex
       */
      fun foreignKey(
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).
//                   display_name foreignKey
//                   documentation ```kotlin\npublic final fun foreignKey(vararg references: Pair<Column<*>, Column<*>>, onUpdate: ReferenceOption? = ..., onDelete: ReferenceOption? = ..., name: String? = ...): Unit\n```\n\n----\n\n\n Creates a composite foreign key.\n\n @param references Pairs of child table and parent table columns that compose the foreign key.\n The first value of each pair should be a column from this referencing child table,\n with the second value being a column from the referenced parent table.\n All referencing columns must belong to this table.\n All referenced columns must belong to the same table.\n @param onUpdate [ReferenceOption] when performing update operations.\n @param onDelete [ReferenceOption] when performing delete operations.\n @param name Custom foreign key constraint name.\n @sample org.jetbrains.exposed.v1.tests.shared.DDLTests.testCompositeFKReferencingUniqueIndex\n
          vararg references: Pair<Column<*>, Column<*>>,
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(references)
//                          display_name references
//                          documentation ```kotlin\nvararg references: Pair<Column<*>, Column<*>>\n```
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          name: String? = null
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(name)
//             display_name name
//             documentation ```kotlin\nname: String? = ...\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/String#
      ) {
          _foreignKeys.add(ForeignKeyConstraint(references.toMap(), onUpdate, onDelete, name))
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_foreignKeys.
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_foreignKeys().
//                     ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`().
//                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(references)
//                                                         ^^^^^ reference semanticdb maven . . kotlin/collections/toMap(+2).
//                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(onUpdate)
//                                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(onDelete)
//                                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(name)
      }
  
      // Check constraints
  
      /**
       * Creates a check constraint in this column.
       * @param name The name to identify the constraint, optional. Must be **unique** (case-insensitive) to this table,
       * otherwise, the constraint will not be created. All names are [trimmed][String.trim], blank names are ignored and
       * the database engine decides the default name.
       * @param op The expression against which the newly inserted values will be compared.
       */
      fun <T> Column<T>.check(name: String = "", op: SqlExpressionBuilder.(Column<T>) -> Op<Boolean>): Column<T> = apply {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
//                            display_name check
//                            documentation ```kotlin\npublic final fun <T> Column<T>.check(name: String = ..., op: SqlExpressionBuilder.(Column<T>) -> Op<Boolean>): Column<T>\n```\n\n----\n\n\n Creates a check constraint in this column.\n @param name The name to identify the constraint, optional. Must be **unique** (case-insensitive) to this table,\n otherwise, the constraint will not be created. All names are [trimmed][String.trim], blank names are ignored and\n the database engine decides the default name.\n @param op The expression against which the newly inserted values will be compared.\n
//                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().(name)
//                                 display_name name
//                                 documentation ```kotlin\nname: String = ...\n```
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                               ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().(op)
//                                                  display_name op
//                                                  documentation ```kotlin\nop: SqlExpressionBuilder.(Column<T>) -> Op<Boolean>\n```
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
//                                                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                                                 ^^^^^ reference semanticdb maven . . kotlin/apply().
          if (name.isEmpty() || table.checkConstraints.none { it.first.equals(name, true) }) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().(name)
//                 ^^^^^^^ reference semanticdb maven . . kotlin/text/isEmpty().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints.
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getCheckConstraints().
//                                                     ^^^^ reference semanticdb maven . . kotlin/collections/none(+19).
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                          display_name it
//                                                                                          documentation ```kotlin\nit: CheckConstraint\n```
//                                                            ^^ reference semanticdb maven . . (it)
//                                                               ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                               ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                                     ^^^^^^ reference semanticdb maven . . kotlin/text/equals(+1).
//                                                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().(name)
              table.checkConstraints.add(name to SqlExpressionBuilder.op(this))
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints.
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getCheckConstraints().
//                                   ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().(name)
//                                            ^^ reference semanticdb maven . . kotlin/to().
//                                                                    ^^ reference semanticdb maven . . kotlin/Function2#invoke().
//                                                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().(op)
          } else {
              exposedLogger
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
                  .warn("A CHECK constraint with name '$name' was ignored because there is already one with that name")
//                 ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().(name)
          }
      }
  
      /**
       * Creates a check constraint in this table.
       * @param name The name to identify the constraint, optional. Must be **unique** (case-insensitive) to this table,
       * otherwise, the constraint will not be created. All names are [trimmed][String.trim], blank names are ignored and
       * the database engine decides the default name.
       * @param op The expression against which the newly inserted values will be compared.
       */
      fun check(name: String = "", op: SqlExpressionBuilder.() -> Op<Boolean>) {
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).
//              display_name check
//              documentation ```kotlin\npublic final fun check(name: String = ..., op: SqlExpressionBuilder.() -> Op<Boolean>): Unit\n```\n\n----\n\n\n Creates a check constraint in this table.\n @param name The name to identify the constraint, optional. Must be **unique** (case-insensitive) to this table,\n otherwise, the constraint will not be created. All names are [trimmed][String.trim], blank names are ignored and\n the database engine decides the default name.\n @param op The expression against which the newly inserted values will be compared.\n
//              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).(name)
//                   display_name name
//                   documentation ```kotlin\nname: String = ...\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                 ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).(op)
//                                    display_name op
//                                    documentation ```kotlin\nop: SqlExpressionBuilder.() -> Op<Boolean>\n```
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
          if (name.isEmpty() || checkConstraints.none { it.first.equals(name, true) }) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).(name)
//                 ^^^^^^^ reference semanticdb maven . . kotlin/text/isEmpty().
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints.
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getCheckConstraints().
//                                               ^^^^ reference semanticdb maven . . kotlin/collections/none(+19).
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                    display_name it
//                                                                                    documentation ```kotlin\nit: CheckConstraint\n```
//                                                      ^^ reference semanticdb maven . . (it)
//                                                         ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                         ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                               ^^^^^^ reference semanticdb maven . . kotlin/text/equals(+1).
//                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).(name)
              checkConstraints.add(name to SqlExpressionBuilder.op())
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints.
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getCheckConstraints().
//                             ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).(name)
//                                      ^^ reference semanticdb maven . . kotlin/to().
//                                                              ^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).(op)
          } else {
              exposedLogger
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
                  .warn("A CHECK constraint with name '$name' was ignored because there is already one with that name")
//                 ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).(name)
          }
      }
  
      // Cloning utils
  
      private fun <T : Any> T.clone(replaceArgs: Map<KProperty1<T, *>, Any> = emptyMap()): T = javaClass.kotlin.run {
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clone().[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT : Any\n```
//                            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clone().
//                                  display_name clone
//                                  documentation ```kotlin\nprivate final fun <T : Any> T.clone(replaceArgs: Map<KProperty1<T, *>, Any> = ...): T\n```
//                                  ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clone().(replaceArgs)
//                                              display_name replaceArgs
//                                              documentation ```kotlin\nreplaceArgs: Map<KProperty1<T, *>, Any> = ...\n```
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                                                            ^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyMap().
//                                                                                             ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//                                                                                             ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                                                                                                       ^^^^^^ reference semanticdb maven . . kotlin/jvm/getKotlin().
//                                                                                                       ^^^^^^ reference semanticdb maven . . kotlin/jvm/kotlin.
//                                                                                                              ^^^ reference semanticdb maven . . kotlin/run(+1).
          val consParams = primaryConstructor!!.parameters
//            ^^^^^^^^^^ definition local 37
//                       display_name consParams
//                       documentation ```kotlin\nlocal val consParams: List<KParameter>\n```
//                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/getPrimaryConstructor().
//                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/primaryConstructor.
//                                              ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KFunction#getParameters().
//                                              ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KFunction#parameters.
          val mutableProperties = memberProperties.filterIsInstance<KMutableProperty1<T, Any?>>()
//            ^^^^^^^^^^^^^^^^^ definition local 38
//                              display_name mutableProperties
//                              documentation ```kotlin\nlocal val mutableProperties: List<KMutableProperty1<T, Any?>>\n```
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/getMemberProperties().
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/memberProperties.
//                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterIsInstance(+3).
          val allValues = memberProperties
//            ^^^^^^^^^ definition local 39
//                      display_name allValues
//                      documentation ```kotlin\nlocal val allValues: Map<String, Any?>\n```
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/getMemberProperties().
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/memberProperties.
              .filter { it in mutableProperties || it.name in consParams.map(KParameter::name) }
//             ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                               display_name it
//                                                                                               documentation ```kotlin\nit: CheckConstraint\n```
//                      ^^ reference semanticdb maven . . (it)
//                         ^^ reference semanticdb maven . . kotlin/collections/contains(+9).
//                            ^^^^^^^^^^^^^^^^^ reference local 38
//                                                 ^^ reference semanticdb maven . . (it)
//                                                    ^^^^ reference semanticdb maven . . kotlin/reflect/KProperty1#getName().
//                                                    ^^^^ reference semanticdb maven . . kotlin/reflect/KProperty1#name.
//                                                         ^^ reference semanticdb maven . . kotlin/collections/List#contains().
//                                                            ^^^^^^^^^^ reference local 37
//                                                                       ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                                                       ^^^^ reference semanticdb maven . . kotlin/reflect/KParameter#getName().
//                                                                                       ^^^^ reference semanticdb maven . . kotlin/reflect/KParameter#name.
              .associate { it.name to (replaceArgs[it] ?: it.get(this@clone)) }
//             ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/associate(+9).
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                              display_name it
//                                                                              documentation ```kotlin\nit: CheckConstraint\n```
//                         ^^ reference semanticdb maven . . (it)
//                            ^^^^ reference semanticdb maven . . kotlin/reflect/KProperty1#getName().
//                            ^^^^ reference semanticdb maven . . kotlin/reflect/KProperty1#name.
//                                 ^^ reference semanticdb maven . . kotlin/to().
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clone().(replaceArgs)
//                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                 ^^ reference semanticdb maven . . (it)
//                                                        ^^ reference semanticdb maven . . (it)
//                                                           ^^^ reference semanticdb maven . . kotlin/reflect/KProperty1#get().
          primaryConstructor!!.callBy(consParams.associateWith { allValues[it.name] }).also { newInstance ->
//        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/getPrimaryConstructor().
//        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/primaryConstructor.
//                             ^^^^^^ reference semanticdb maven . . kotlin/reflect/KFunction#callBy().
//                                    ^^^^^^^^^^ reference local 37
//                                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/associateWith(+9).
//                                                             ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                    display_name it
//                                                                                    documentation ```kotlin\nit: CheckConstraint\n```
//                                                               ^^^^^^^^^ reference local 39
//                                                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/get().
//                                                                         ^^ reference semanticdb maven . . (it)
//                                                                            ^^^^ reference semanticdb maven . . kotlin/reflect/KParameter#getName().
//                                                                            ^^^^ reference semanticdb maven . . kotlin/reflect/KParameter#name.
//                                                                                     ^^^^ reference semanticdb maven . . kotlin/also().
//                                                                                            ^^^^^^^^^^^ definition semanticdb maven . . (newInstance)
//                                                                                                        display_name newInstance
//                                                                                                        documentation ```kotlin\nnewInstance: T\n```
              for (prop in mutableProperties) {
//                 ^^^^ definition local 41
//                      display_name prop
//                      documentation ```kotlin\nlocal val prop: KMutableProperty1<T, Any?>\n```
//                         ^^^^^^^^^^^^^^^^^ reference local 38
//                         ^^^^^^^^^^^^^^^^^ definition local 40
//                                           display_name <iterator>
//                                           documentation ```kotlin\nlocal val <iterator>: Iterator<KMutableProperty1<T, Any?>>\n```
//                         ^^^^^^^^^^^^^^^^^ reference local 40
//                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#hasNext().
//                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#next().
//                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#iterator().
                  prop.set(newInstance, allValues[prop.name])
//                ^^^^ reference local 41
//                     ^^^ reference semanticdb maven . . kotlin/reflect/KMutableProperty1#set().
//                         ^^^^^^^^^^^ reference semanticdb maven . . (newInstance)
//                                      ^^^^^^^^^ reference local 39
//                                      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                ^^^^ reference local 41
//                                                     ^^^^ reference semanticdb maven . . kotlin/reflect/KMutableProperty1#getName().
//                                                     ^^^^ reference semanticdb maven . . kotlin/reflect/KMutableProperty1#name.
              }
          }
      }
  
      private fun <T> IColumnType<T>.cloneAsBaseType(): IColumnType<T> = ((this as? AutoIncColumnType)?.delegate ?: this).clone()
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneAsBaseType().[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                                   ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneAsBaseType().
//                                                   display_name cloneAsBaseType
//                                                   documentation ```kotlin\nprivate final fun <T> IColumnType<T>.cloneAsBaseType(): IColumnType<T>\n```
//                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#delegate.
//                                                                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getDelegate().
//                                                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clone().
  
      private fun <T> Column<T>.cloneWithAutoInc(idSeqName: String?): Column<T> = when (columnType) {
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc().[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc().
//                                               display_name cloneWithAutoInc
//                                               documentation ```kotlin\nprivate final fun <T> Column<T>.cloneWithAutoInc(idSeqName: String?): Column<T>\n```
//                                               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc().(idSeqName)
//                                                         display_name idSeqName
//                                                         documentation ```kotlin\nidSeqName: String?\n```
//                                                          ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
          is AutoIncColumnType -> this
          is ColumnType -> {
              val fallbackSequenceName = fallbackSequenceName(tableName = tableName, columnName = name)
//                ^^^^^^^^^^^^^^^^^^^^ definition local 42
//                                     display_name fallbackSequenceName
//                                     documentation ```kotlin\nlocal val fallbackSequenceName: String\n```
//                                       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().
//                                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
              this.withColumnType(
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#withColumnType().
                  AutoIncColumnType(columnType, idSeqName, fallbackSequenceName)
//                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`().
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc().(idSeqName)
//                                                         ^^^^^^^^^^^^^^^^^^^^ reference local 42
              )
          }
  
          else -> error("Unsupported column type for auto-increment $columnType")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
      }
  
      private fun <T> Column<T>.cloneWithAutoInc(sequence: Sequence): Column<T> = when (columnType) {
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc(+1).[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc(+1).
//                                               display_name cloneWithAutoInc
//                                               documentation ```kotlin\nprivate final fun <T> Column<T>.cloneWithAutoInc(sequence: Sequence): Column<T>\n```
//                                               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc(+1).(sequence)
//                                                        display_name sequence
//                                                        documentation ```kotlin\nsequence: Sequence\n```
//                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
//                                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
          is AutoIncColumnType -> this
          is ColumnType -> this.withColumnType(AutoIncColumnType(columnType, sequence))
//                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#withColumnType().
//                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`(+1).
//                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc(+1).(sequence)
          else -> error("Unsupported column type for auto-increment $columnType")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
      }
  
      // DDL statements
  
      @OptIn(InternalApi::class)
      internal fun primaryKeyConstraint(): String? {
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKeyConstraint().
//                                      display_name primaryKeyConstraint
//                                      documentation ```kotlin\n@OptIn(...) internal final fun primaryKeyConstraint(): String?\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/String#
          return primaryKey?.let { primaryKey ->
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                           ^^^ reference semanticdb maven . . kotlin/let().
//                                 ^^^^^^^^^^ definition semanticdb maven . . (primaryKey)
//                                            display_name primaryKey
//                                            documentation ```kotlin\nprimaryKey: Table.PrimaryKey\n```
              val tr = CoreTransactionManager.currentTransaction()
//                ^^ definition local 43
//                   display_name tr
//                   documentation ```kotlin\nlocal val tr: Transaction\n```
//                                            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
              val constraint = tr.db.identifierManager.cutIfNecessaryAndQuote(primaryKey.name)
//                ^^^^^^^^^^ definition local 44
//                           display_name constraint
//                           documentation ```kotlin\nlocal val constraint: String\n```
//                             ^^ reference local 43
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
//                                                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                                                                            ^^^^^^^^^^ reference semanticdb maven . . (primaryKey)
//                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getName().
//                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#name.
              return primaryKey.columns
//                   ^^^^^^^^^^ reference semanticdb maven . . (primaryKey)
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
                  .joinToString(prefix = "CONSTRAINT $constraint PRIMARY KEY (", postfix = ")", transform = tr::identity)
//                 ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString().
//                                                    ^^^^^^^^^^ reference local 44
//                                                                                                          ^^ reference local 43
//                                                                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
          }
      }
  
      override fun createStatement(): List<String> {
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#createStatement().
//                                 display_name createStatement
//                                 documentation ```kotlin\npublic open override fun createStatement(): List<String>\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#createStatement().
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#createStatement().
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          @OptIn(InternalApi::class)
          val addForeignKeysInAlterPart = TableUtils.checkCycle(this) && currentDialect !is SQLiteDialect
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 45
//                                      display_name addForeignKeysInAlterPart
//                                      documentation ```kotlin\n@OptIn(...) local val addForeignKeysInAlterPart: Boolean\n```
//                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#checkCycle().
//                                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
  
          val foreignKeyConstraints = foreignKeys
//            ^^^^^^^^^^^^^^^^^^^^^ definition local 46
//                                  display_name foreignKeyConstraints
//                                  documentation ```kotlin\nlocal val foreignKeyConstraints: List<ForeignKeyConstraint>\n```
//                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKeys.
//                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getForeignKeys().
  
          @OptIn(InternalApi::class)
          val createTable = buildString {
//            ^^^^^^^^^^^ definition local 47
//                        display_name createTable
//                        documentation ```kotlin\n@OptIn(...) local val createTable: String\n```
//                          ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
              append("CREATE TABLE ")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              if (currentDialect.supportsIfNotExists) {
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsIfNotExists().
//                               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsIfNotExists.
                  append("IF NOT EXISTS ")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              }
              append(CoreTransactionManager.currentTransaction().identity(this@Table))
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
  
              if (columns.isNotEmpty()) {
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                        ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
                  columns.joinTo(this, prefix = " (") { column ->
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                        ^^^^^^ reference semanticdb maven . . kotlin/collections/joinTo(+9).
//                                                      ^^^^^^ definition semanticdb maven . . (column)
//                                                             display_name column
//                                                             documentation ```kotlin\ncolumn: Column<*>\n```
                      column.descriptionDdl(false)
//                    ^^^^^^ reference semanticdb maven . . (column)
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#descriptionDdl().
                  }
  
                  if (columns.any { it.isPrimaryConstraintWillBeDefined }) {
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                            ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                        display_name it
//                                                                        documentation ```kotlin\nit: CheckConstraint\n```
//                                  ^^ reference semanticdb maven . . (it)
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsPrimaryConstraintWillBeDefined().
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isPrimaryConstraintWillBeDefined.
                      primaryKeyConstraint()?.let { append(", $it") }
//                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKeyConstraint().
//                                            ^^^ reference semanticdb maven . . kotlin/let().
//                                                ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                    display_name it
//                                                                    documentation ```kotlin\nit: CheckConstraint\n```
//                                                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                                             ^^ reference semanticdb maven . . (it)
                  }
  
                  if (!addForeignKeysInAlterPart && foreignKeyConstraints.isNotEmpty()) {
//                    ^ reference semanticdb maven . . kotlin/Boolean#not().
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 45
//                                                  ^^^^^^^^^^^^^^^^^^^^^ reference local 46
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
                      foreignKeyConstraints.joinTo(this, prefix = ", ", separator = ", ") { it.foreignKeyPart }
//                    ^^^^^^^^^^^^^^^^^^^^^ reference local 46
//                                          ^^^^^^ reference semanticdb maven . . kotlin/collections/joinTo(+9).
//                                                                                        ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                              display_name it
//                                                                                                              documentation ```kotlin\nit: CheckConstraint\n```
//                                                                                          ^^ reference semanticdb maven . . (it)
//                                                                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#foreignKeyPart.
//                                                                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getForeignKeyPart().
                  }
  
                  if (checkConstraints.isNotEmpty()) {
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getCheckConstraints().
//                                     ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
                      checkConstraints().map { it.checkPart }.ifEmpty { null }?.joinTo(this, prefix = ", ")
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints(+1).
//                                       ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                            display_name it
//                                                            documentation ```kotlin\nit: CheckConstraint\n```
//                                             ^^ reference semanticdb maven . . (it)
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#checkPart.
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getCheckPart().
//                                                            ^^^^^^^ reference semanticdb maven . . kotlin/collections/ifEmpty(+1).
//                                                                              ^^^^^^ reference semanticdb maven . . kotlin/collections/joinTo(+9).
                  }
  
                  append(")")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              }
          }
  
          val createConstraint = if (addForeignKeysInAlterPart) {
//            ^^^^^^^^^^^^^^^^ definition local 48
//                             display_name createConstraint
//                             documentation ```kotlin\nlocal val createConstraint: List<String>\n```
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 45
              foreignKeyConstraints.flatMap { it.createStatement() }
//            ^^^^^^^^^^^^^^^^^^^^^ reference local 46
//                                  ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap(+10).
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                   display_name it
//                                                                   documentation ```kotlin\nit: CheckConstraint\n```
//                                            ^^ reference semanticdb maven . . (it)
//                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#createStatement().
          } else {
              emptyList()
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
          }
  
          return createAutoIncColumnSequence() + createTable + createConstraint
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#createAutoIncColumnSequence().
//                                             ^ reference semanticdb maven . . kotlin/collections/plus(+28).
//                                               ^^^^^^^^^^^ reference local 47
//                                                           ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                             ^^^^^^^^^^^^^^^^ reference local 48
      }
  
      private fun createAutoIncColumnSequence(): List<String> {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#createAutoIncColumnSequence().
//                                            display_name createAutoIncColumnSequence
//                                            documentation ```kotlin\nprivate final fun createAutoIncColumnSequence(): List<String>\n```
//                                               ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          return autoIncColumn?.autoIncColumnType?.sequence?.createStatement().orEmpty()
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncColumn.
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getAutoIncColumn().
//                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.
//                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#createStatement().
//                                                                             ^^^^^^^ reference semanticdb maven . . kotlin/collections/orEmpty(+2).
      }
  
      override fun modifyStatement(): List<String> =
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#modifyStatement().
//                                 display_name modifyStatement
//                                 documentation ```kotlin\npublic open override fun modifyStatement(): List<String>\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#modifyStatement().
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#modifyStatement().
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          throw UnsupportedOperationException("Use modify on columns and indices")
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/UnsupportedOperationException#`<init>`().
  
      override fun dropStatement(): List<String> {
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#dropStatement().
//                               display_name dropStatement
//                               documentation ```kotlin\npublic open override fun dropStatement(): List<String>\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#dropStatement().
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#dropStatement().
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          @OptIn(InternalApi::class)
          val dropTable = buildString {
//            ^^^^^^^^^ definition local 49
//                      display_name dropTable
//                      documentation ```kotlin\n@OptIn(...) local val dropTable: String\n```
//                        ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
              append("DROP TABLE ")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              if (currentDialect.supportsIfNotExists) {
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsIfNotExists().
//                               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsIfNotExists.
                  append("IF EXISTS ")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              }
              append(CoreTransactionManager.currentTransaction().identity(this@Table))
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
              if (currentDialectIfAvailable is OracleDialect) {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
                  append(" CASCADE CONSTRAINTS")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              } else if (currentDialectIfAvailable is PostgreSQLDialect && TableUtils.checkCycle(this@Table)) {
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
//                                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#checkCycle().
                  append(" CASCADE")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              }
          }
  
          val dropSequence = autoIncColumn?.autoIncColumnType?.sequence?.dropStatement().orEmpty()
//            ^^^^^^^^^^^^ definition local 50
//                         display_name dropSequence
//                         documentation ```kotlin\nlocal val dropSequence: List<String>\n```
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncColumn.
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getAutoIncColumn().
//                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.
//                                                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#dropStatement().
//                                                                                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/orEmpty(+2).
  
          return listOf(dropTable) + dropSequence
//               ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                      ^^^^^^^^^ reference local 49
//                                 ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                   ^^^^^^^^^^^^ reference local 50
      }
  
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#equals().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          if (this === other) return true
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#equals().(other)
          if (other !is Table) return false
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#equals().(other)
  
          if (tableName != other.tableName) return false
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#equals().(other)
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
  
          return true
      }
  
      override fun hashCode(): Int = tableName.hashCode()
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#hashCode().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
//                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                             ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().
  
      /**
       * Represents a special dummy `DUAL` table that is accessible by all users.
       *
       * This can be useful when needing to execute queries that do not rely on a specific table object.
       * **Note:** `DUAL` tables are only automatically supported by Oracle. Please check the documentation.
       */
      object Dual : Table("dual")
//           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#Dual#
//                display_name Dual
//                documentation ```kotlin\npublic final object Dual : Table\n```\n\n----\n\n\n Represents a special dummy `DUAL` table that is accessible by all users.\n\n This can be useful when needing to execute queries that do not rely on a specific table object.\n **Note:** `DUAL` tables are only automatically supported by Oracle. Please check the documentation.\n
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#Dual#`<init>`().
//                display_name Dual
//                documentation ```kotlin\nprivate constructor(): Table.Dual\n```\n\n----\n\n\n Represents a special dummy `DUAL` table that is accessible by all users.\n\n This can be useful when needing to execute queries that do not rely on a specific table object.\n **Note:** `DUAL` tables are only automatically supported by Oracle. Please check the documentation.\n
//                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
  }
  
  /** Returns the list of tables to which the columns in this column set belong. */
  fun ColumnSet.targetTables(): List<Table> = when (this) {
//              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/targetTables().
//                           display_name targetTables
//                           documentation ```kotlin\npublic final fun ColumnSet.targetTables(): List<Table>\n```\n\n----\n\n Returns the list of tables to which the columns in this column set belong.
//                              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
      is Alias<*> -> listOf(this.delegate)
//                   ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
      is QueryAlias -> this.query.set.source.targetTables()
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getQuery().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#query.
//                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getSet().
//                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#set.
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getSource().
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#source.
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/targetTables().
      is Table -> listOf(this)
//                ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
      is Join -> this.table.targetTables() + this.joinParts.flatMap { it.joinPart.targetTables() }
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getTable().
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#table.
//                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/targetTables().
//                                         ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                                                          ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap(+10).
//                                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                 display_name it
//                                                                                                 documentation ```kotlin\nit: CheckConstraint\n```
//                                                                    ^^ reference semanticdb maven . . (it)
//                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/targetTables().
      else -> error("No target provided for update")
//            ^^^^^ reference semanticdb maven . . kotlin/error().
  }
  
  private fun String.isAlreadyQuoted(): Boolean =
//                   ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/isAlreadyQuoted().
//                                   display_name isAlreadyQuoted
//                                   documentation ```kotlin\nprivate final fun String.isAlreadyQuoted(): Boolean\n```
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      listOf("\"", "'", "`").any { quoteString ->
//    ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf(+1).
//                           ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                                 ^^^^^^^^^^^ definition semanticdb maven . . (quoteString)
//                                             display_name quoteString
//                                             documentation ```kotlin\nquoteString: String\n```
          startsWith(quoteString) && endsWith(quoteString)
//        ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                   ^^^^^^^^^^^ reference semanticdb maven . . (quoteString)
//                                   ^^^^^^^^ reference semanticdb maven . . kotlin/text/endsWith().
//                                            ^^^^^^^^^^^ reference semanticdb maven . . (quoteString)
      }
  
  internal fun fallbackSequenceName(tableName: String, columnName: String): String {
//             ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().
//                                  display_name fallbackSequenceName
//                                  documentation ```kotlin\ninternal final fun fallbackSequenceName(tableName: String, columnName: String): String\n```
//                                  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().(tableName)
//                                            display_name tableName
//                                            documentation ```kotlin\ntableName: String\n```
//                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                     ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().(columnName)
//                                                                display_name columnName
//                                                                documentation ```kotlin\ncolumnName: String\n```
//                                                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
      val q = if (tableName.contains('.')) "\"" else ""
//        ^ definition local 51
//          display_name q
//          documentation ```kotlin\nlocal val q: String\n```
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().(tableName)
//                          ^^^^^^^^ reference semanticdb maven . . kotlin/text/contains(+1).
      return "$q${tableName.replace("\"", "")}_${columnName}_seq$q"
//             ^ reference local 51
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().(tableName)
//                          ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
//                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().(columnName)
//                                                               ^ reference local 51
  }
  
  private fun <T> Column<T>.unquotedName() = name.trim('\"', '\'', '`')
//             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().[T]
//               display_name FirTypeParameterSymbol T
//               documentation ```kotlin\nT\n```
//                          ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//                                       display_name unquotedName
//                                       documentation ```kotlin\nprivate final fun <T> Column<T>.unquotedName(): String\n```
//                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
