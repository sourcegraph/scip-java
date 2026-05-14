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
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/JoinCondition#
  /** Pair of expressions used to match rows from two joined tables. */
  typealias JoinCondition = Pair<Expression<*>, Expression<*>>
//          ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/JoinCondition#
//                        display_name FirTypeAliasSymbol org/jetbrains/exposed/v1/core/JoinCondition
//                        documentation ```kotlin\npublic final typealias JoinCondition = Pair<Expression<*>, Expression<*>>\n\n```\n\n----\n\n Pair of expressions used to match rows from two joined tables.
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/JoinCondition#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Select#
  /** Represents a subset of fields from a given source. */
  typealias Select = Slice
//          ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Select#
//                 display_name FirTypeAliasSymbol org/jetbrains/exposed/v1/core/Select
//                 documentation ```kotlin\npublic final typealias Select = Slice\n\n```\n\n----\n\n Represents a subset of fields from a given source.
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Select#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#
  /**
   * Represents a set of expressions, contained in the given column set.
   */
  interface FieldSet {
//          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#
//                   display_name FieldSet
//                   documentation ```kotlin\npublic abstract interface FieldSet : Any\n```\n\n----\n\n\n Represents a set of expressions, contained in the given column set.\n
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#source.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getSource().
      /** Return the column set that contains this field set. */
      val source: ColumnSet
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getSource().
//               display_name source
//               documentation ```kotlin\npublic get(): ColumnSet\n```\n\n----\n\n Return the column set that contains this field set.
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#source.
//               display_name source
//               documentation ```kotlin\npublic abstract val source: ColumnSet\n```\n\n----\n\n Return the column set that contains this field set.
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#source.
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getSource().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#fields.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getFields().
      /** Returns the field of this field set. */
      val fields: List<Expression<*>>
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#fields.
//               display_name fields
//               documentation ```kotlin\npublic abstract val fields: List<Expression<*>>\n```\n\n----\n\n Returns the field of this field set.
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getFields().
//               display_name fields
//               documentation ```kotlin\npublic get(): List<Expression<*>>\n```\n\n----\n\n Returns the field of this field set.
//                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#fields.
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getFields().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#realFields.
      /**
       * Returns all real fields, unrolling composite [CompositeColumn] if present
       */
      val realFields: List<Expression<*>>
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#realFields.
//                   display_name realFields
//                   documentation ```kotlin\npublic open val realFields: List<Expression<*>>\n```\n\n----\n\n\n Returns all real fields, unrolling composite [CompositeColumn] if present\n
//                    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getRealFields().
          get() {
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getRealFields().
//            display_name realFields
//            documentation ```kotlin\npublic get(): List<Expression<*>>\n```
//            ⌄ enclosing_range_start local 0
              val unrolled = ArrayList<Expression<*>>(fields.size)
//                ^^^^^^^^ definition local 0
//                         display_name unrolled
//                         documentation ```kotlin\nlocal val unrolled: ArrayList<Expression<*>>\n```
//                           ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`().
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#fields.
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getFields().
//                                                           ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                                           ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                                               ⌃ enclosing_range_end local 0
  
//                           ⌄ enclosing_range_start local 1
              fields.forEach {
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#fields.
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getFields().
//                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                           ^ definition local 1 8:13
//                             display_name it
//                             documentation ```kotlin\nit: Expression<*>\n```
                  when {
                      it is CompositeColumn<*> -> unrolled.addAll(it.getRealColumns())
//                    ^^ reference local 1
//                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#
//                                                ^^^^^^^^ reference local 0
//                                                         ^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#addAll().
//                                                                ^^ reference local 1
//                                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumns().
                      (it as? Column<*>)?.isEntityIdentifier() == true && it.table is CompositeIdTable -> {
//                     ^^ reference local 1
//                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isEntityIdentifier().
//                                                                        ^^ reference local 1
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#
                          unrolled.addAll(it.table.idColumns)
//                        ^^^^^^^^ reference local 0
//                                 ^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#addAll().
//                                        ^^ reference local 1
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#getIdColumns().
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#idColumns.
                      }
                      else -> unrolled.add(it)
//                            ^^^^^^^^ reference local 0
//                                     ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add().
//                                         ^^ reference local 1
                  }
              }
//            ⌃ enclosing_range_end local 1
  
              return unrolled
//                   ^^^^^^^^ reference local 0
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#realFields.
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getRealFields().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#`<init>`().
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
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#source.
//                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getSource().
      override val source: ColumnSet get() = this
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#source.
//                        display_name source
//                        documentation ```kotlin\npublic open override val source: ColumnSet\n```
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                                   ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getSource().
//                                       display_name source
//                                       documentation ```kotlin\npublic get(): ColumnSet\n```
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#source.
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getSource().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#columns.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getColumns().
      /** Returns the columns of this column set. */
      abstract val columns: List<Column<*>>
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#columns.
//                         display_name columns
//                         documentation ```kotlin\npublic abstract val columns: List<Column<*>>\n```\n\n----\n\n Returns the columns of this column set.
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getColumns().
//                         display_name columns
//                         documentation ```kotlin\npublic get(): List<Column<*>>\n```\n\n----\n\n Returns the columns of this column set.
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#columns.
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getColumns().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fields.
//                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getFields().
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
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fields.
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getFields().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().
      /** Appends the SQL representation of this column set to the specified [queryBuilder]. */
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().(s)
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().(queryBuilder)
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
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().(s)
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().(queryBuilder)
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().
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
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(otherTable)
          otherTable: ColumnSet,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(otherTable)
//                   display_name otherTable
//                   documentation ```kotlin\notherTable: ColumnSet\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(otherTable)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(joinType)
          joinType: JoinType,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(joinType)
//                 display_name joinType
//                 documentation ```kotlin\njoinType: JoinType\n```
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(joinType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(onColumn)
          onColumn: Expression<*>? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(onColumn)
//                 display_name onColumn
//                 documentation ```kotlin\nonColumn: Expression<*>? = ...\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(onColumn)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(otherColumn)
          otherColumn: Expression<*>? = null,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(otherColumn)
//                    display_name otherColumn
//                    documentation ```kotlin\notherColumn: Expression<*>? = ...\n```
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(otherColumn)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(lateral)
          lateral: Boolean = false,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(lateral)
//                display_name lateral
//                documentation ```kotlin\nlateral: Boolean = ...\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(lateral)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(additionalConstraint)
          additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(additionalConstraint)
//                             display_name additionalConstraint
//                             documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().(additionalConstraint)
      ): Join
//       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#innerJoin().
      /** Creates an inner join relation with [otherTable]. */
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#innerJoin().(otherTable)
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
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#innerJoin().(otherTable)
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#innerJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#leftJoin().
      /** Creates a left outer join relation with [otherTable]. */
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#leftJoin().(otherTable)
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
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#leftJoin().(otherTable)
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#leftJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#rightJoin().
      /** Creates a right outer join relation with [otherTable]. */
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#rightJoin().(otherTable)
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
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#rightJoin().(otherTable)
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#rightJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fullJoin().
      /** Creates a full outer join relation with [otherTable]. */
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fullJoin().(otherTable)
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
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fullJoin().(otherTable)
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fullJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#crossJoin().
      /** Creates a cross join relation with [otherTable]. */
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#crossJoin().(otherTable)
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
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#crossJoin().(otherTable)
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#crossJoin().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().
  /**
   * Creates an inner join relation with [otherTable] using [onColumn] and [otherColumn] equality
   * and/or [additionalConstraint] as the join condition.
   *
   * @throws IllegalStateException if the join cannot be performed. See the exception message for more details.
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().[C1]
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().[C2]
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().[C1]
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().[C2]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(otherTable)
      otherTable: C2,
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(otherTable)
//               display_name otherTable
//               documentation ```kotlin\notherTable: C2\n```
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(otherTable)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(onColumn)
      onColumn: (C1.() -> Expression<*>)? = null,
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(onColumn)
//             display_name onColumn
//             documentation ```kotlin\nonColumn: (C1.() -> Expression<*>)? = ...\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(onColumn)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(otherColumn)
      otherColumn: (C2.() -> Expression<*>)? = null,
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(otherColumn)
//                display_name otherColumn
//                documentation ```kotlin\notherColumn: (C2.() -> Expression<*>)? = ...\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(otherColumn)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(additionalConstraint)
      additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(additionalConstraint)
//                         display_name additionalConstraint
//                         documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().(additionalConstraint)
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
//                                                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/innerJoin().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().
  /**
   * Creates a left outer join relation with [otherTable] using [onColumn] and [otherColumn] equality
   * and/or [additionalConstraint] as the join condition.
   *
   * @throws IllegalStateException if the join cannot be performed. See the exception message for more details.
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().[C1]
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().[C2]
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().[C1]
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().[C2]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(otherTable)
      otherTable: C2,
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(otherTable)
//               display_name otherTable
//               documentation ```kotlin\notherTable: C2\n```
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(otherTable)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(onColumn)
      onColumn: (C1.() -> Expression<*>)? = null,
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(onColumn)
//             display_name onColumn
//             documentation ```kotlin\nonColumn: (C1.() -> Expression<*>)? = ...\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(onColumn)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(otherColumn)
      otherColumn: (C2.() -> Expression<*>)? = null,
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(otherColumn)
//                display_name otherColumn
//                documentation ```kotlin\notherColumn: (C2.() -> Expression<*>)? = ...\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(otherColumn)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(additionalConstraint)
      additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(additionalConstraint)
//                         display_name additionalConstraint
//                         documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().(additionalConstraint)
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
//                                                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/leftJoin().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().
  /**
   * Creates a right outer join relation with [otherTable] using [onColumn] and [otherColumn] equality
   * and/or [additionalConstraint] as the join condition.
   *
   * @throws IllegalStateException if the join cannot be performed. See the exception message for more details.
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().[C1]
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().[C2]
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().[C1]
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().[C2]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(otherTable)
      otherTable: C2,
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(otherTable)
//               display_name otherTable
//               documentation ```kotlin\notherTable: C2\n```
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(otherTable)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(onColumn)
      onColumn: (C1.() -> Expression<*>)? = null,
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(onColumn)
//             display_name onColumn
//             documentation ```kotlin\nonColumn: (C1.() -> Expression<*>)? = ...\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(onColumn)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(otherColumn)
      otherColumn: (C2.() -> Expression<*>)? = null,
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(otherColumn)
//                display_name otherColumn
//                documentation ```kotlin\notherColumn: (C2.() -> Expression<*>)? = ...\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(otherColumn)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(additionalConstraint)
      additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(additionalConstraint)
//                         display_name additionalConstraint
//                         documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().(additionalConstraint)
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
//                                                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/rightJoin().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().
  /**
   * Creates a full outer join relation with [otherTable] using [onColumn] and [otherColumn] equality
   * and/or [additionalConstraint] as the join condition.
   *
   * @throws IllegalStateException if the join cannot be performed. See the exception message for more details.
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().[C1]
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().[C2]
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().[C1]
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().[C2]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(otherTable)
      otherTable: C2,
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(otherTable)
//               display_name otherTable
//               documentation ```kotlin\notherTable: C2\n```
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(otherTable)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(onColumn)
      onColumn: (C1.() -> Expression<*>)? = null,
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(onColumn)
//             display_name onColumn
//             documentation ```kotlin\nonColumn: (C1.() -> Expression<*>)? = ...\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(onColumn)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(otherColumn)
      otherColumn: (C2.() -> Expression<*>)? = null,
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(otherColumn)
//                display_name otherColumn
//                documentation ```kotlin\notherColumn: (C2.() -> Expression<*>)? = ...\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(otherColumn)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(additionalConstraint)
      additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(additionalConstraint)
//                         display_name additionalConstraint
//                         documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().(additionalConstraint)
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
//                                                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/fullJoin().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().
  /**
   * Creates a cross join relation with [otherTable] using [onColumn] and [otherColumn] equality
   * and/or [additionalConstraint] as the join condition.
   *
   * @throws IllegalStateException if the join cannot be performed. See the exception message for more details.
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().[C1]
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().[C2]
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
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().[C1]
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().[C2]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(otherTable)
      otherTable: C2,
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(otherTable)
//               display_name otherTable
//               documentation ```kotlin\notherTable: C2\n```
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(otherTable)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(onColumn)
      onColumn: (C1.() -> Expression<*>)? = null,
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(onColumn)
//             display_name onColumn
//             documentation ```kotlin\nonColumn: (C1.() -> Expression<*>)? = ...\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(onColumn)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(otherColumn)
      otherColumn: (C2.() -> Expression<*>)? = null,
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(otherColumn)
//                display_name otherColumn
//                documentation ```kotlin\notherColumn: (C2.() -> Expression<*>)? = ...\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(otherColumn)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(additionalConstraint)
      additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(additionalConstraint)
//                         display_name additionalConstraint
//                         documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().(additionalConstraint)
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
//                                                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/crossJoin().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#
  /**
   * Represents a subset of [fields] from a given [source].
   */
//           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#`<init>`().
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#`<init>`().(source)
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#source.
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#getSource().
//                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#`<init>`().(fields)
//                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#fields.
//                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#getFields().
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
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#`<init>`().(source)
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#source.
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#getSource().
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#`<init>`().(fields)
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#fields.
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#getFields().
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#`<init>`().
//                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Slice#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#`<init>`().
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#values().
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#valueOf().
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#valueOf().(value)
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#entries.
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/getEntries().
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
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#`<init>`().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#values().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#valueOf().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#valueOf().(value)
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#entries.
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/getEntries().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
  /**
   * Represents a join relation between multiple column sets.
   */
//          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`().
  class Join(
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//           display_name Join
//           documentation ```kotlin\npublic final class Join : ColumnSet\n```\n\n----\n\n\n Represents a join relation between multiple column sets.\n
//           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`().
//           display_name Join
//           documentation ```kotlin\npublic constructor(table: ColumnSet): Join\n```\n\n----\n\n The column set to which others will be joined.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`().(table)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#table.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getTable().
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
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`().(table)
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#table.
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getTable().
  ) : ColumnSet() {
//    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#columns.
      override val columns: List<Column<*>>
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#columns.
//                         display_name columns
//                         documentation ```kotlin\npublic open override val columns: List<Column<*>>\n```
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getColumns().
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
//          ⌄ enclosing_range_start local 2
          ) { it.joinPart.columns }
//          ^^^^^^^^^^^^^^^^^^^^^^^ definition local 2
//                                  display_name it
//                                  documentation ```kotlin\nit: Join.JoinPart\n```
//            ^^ reference local 2
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#columns.
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getColumns().
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#columns.
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getColumns().
//                                ⌃ enclosing_range_end local 2
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#fields.
      override val fields: List<Expression<*>>
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#fields.
//                        display_name fields
//                        documentation ```kotlin\npublic open override val fields: List<Expression<*>>\n```
//                         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getFields().
//                                                                  ⌄ enclosing_range_start local 3
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
//                                                                  ^ definition local 3 5:9
//                                                                    display_name it
//                                                                    documentation ```kotlin\nit: Join.JoinPart\n```
//                  ⌄ enclosing_range_start local 4
              when (it.joinPart) {
//                  ^^ reference local 3
//                  ^^^^^^^^^^^ definition local 4
//                              display_name <when-subject>
//                              documentation ```kotlin\nlocal val <when-subject>: ColumnSet\n```
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                            ⌃ enclosing_range_end local 4
                  is QueryAlias -> it.joinPart.aliasedFields
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#
//                                 ^^ reference local 3
//                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#aliasedFields.
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getAliasedFields().
                  else -> it.joinPart.fields
//                        ^^ reference local 3
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#fields.
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getFields().
              }
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#fields.
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getFields().
//        ⌃ enclosing_range_end local 3
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
      internal val joinParts: MutableList<JoinPart> = mutableListOf()
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                           display_name joinParts
//                           documentation ```kotlin\ninternal get(): MutableList<Join.JoinPart>\n```
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                           display_name joinParts
//                           documentation ```kotlin\ninternal final val joinParts: MutableList<Join.JoinPart>\n```
//                            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#
//                                                    ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).
      constructor(
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1). 27:5
//                 display_name Join
//                 documentation ```kotlin\npublic constructor(table: ColumnSet, otherTable: ColumnSet, joinType: JoinType = ..., onColumn: Expression<*>? = ..., otherColumn: Expression<*>? = ..., lateral: Boolean = ..., additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...): Join\n```
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(table)
          table: ColumnSet,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(table)
//              display_name table
//              documentation ```kotlin\ntable: ColumnSet\n```
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(table)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(otherTable)
          otherTable: ColumnSet,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(otherTable)
//                   display_name otherTable
//                   documentation ```kotlin\notherTable: ColumnSet\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(otherTable)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(joinType)
          joinType: JoinType = JoinType.INNER,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(joinType)
//                 display_name joinType
//                 documentation ```kotlin\njoinType: JoinType = ...\n```
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#INNER.
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(joinType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(onColumn)
          onColumn: Expression<*>? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(onColumn)
//                 display_name onColumn
//                 documentation ```kotlin\nonColumn: Expression<*>? = ...\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(onColumn)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(otherColumn)
          otherColumn: Expression<*>? = null,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(otherColumn)
//                    display_name otherColumn
//                    documentation ```kotlin\notherColumn: Expression<*>? = ...\n```
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(otherColumn)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(lateral)
          lateral: Boolean = false,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(lateral)
//                display_name lateral
//                documentation ```kotlin\nlateral: Boolean = ...\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(lateral)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(additionalConstraint)
          additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = null,
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(additionalConstraint)
//                             display_name additionalConstraint
//                             documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(additionalConstraint)
      ) : this(table) {
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).(table)
//        ⌄ enclosing_range_start local 5
          val newJoin = when {
//            ^^^^^^^ definition local 5
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
//        ⌃ enclosing_range_end local 5
          joinParts.addAll(newJoin.joinParts)
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                  ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#addAll().
//                         ^^^^^^^ reference local 5
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().(s)
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().(queryBuilder)
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
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().(s)
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().(queryBuilder)
          table.describe(s, this)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getTable().
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#table.
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().
//                       ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().(s)
//             ⌄ enclosing_range_start local 7
//                  ⌄ enclosing_range_start local 6
          for (p in joinParts) {
//             ^ definition local 7
//               display_name p
//               documentation ```kotlin\nlocal val p: Join.JoinPart\n```
//                  ^^^^^^^^^ definition local 6
//                            display_name <iterator>
//                            documentation ```kotlin\nlocal val <iterator>: MutableIterator<Join.JoinPart>\n```
//                  ^^^^^^^^^ reference local 6
//                  ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableIterator#hasNext().
//                  ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableIterator#next().
//                  ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#iterator().
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//             ⌃ enclosing_range_end local 7
//                          ⌃ enclosing_range_end local 6
              p.describe(s, this)
//            ^ reference local 7
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#describe().
//                       ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().(s)
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#describe().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().
      override fun join(
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().
//                      display_name join
//                      documentation ```kotlin\npublic open override fun join(otherTable: ColumnSet, joinType: JoinType, onColumn: Expression<*>?, otherColumn: Expression<*>?, lateral: Boolean, additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?): Join\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(otherTable)
          otherTable: ColumnSet,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(otherTable)
//                   display_name otherTable
//                   documentation ```kotlin\notherTable: ColumnSet\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(otherTable)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(joinType)
          joinType: JoinType,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(joinType)
//                 display_name joinType
//                 documentation ```kotlin\njoinType: JoinType\n```
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(joinType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(onColumn)
          onColumn: Expression<*>?,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(onColumn)
//                 display_name onColumn
//                 documentation ```kotlin\nonColumn: Expression<*>?\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(onColumn)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(otherColumn)
          otherColumn: Expression<*>?,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(otherColumn)
//                    display_name otherColumn
//                    documentation ```kotlin\notherColumn: Expression<*>?\n```
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(otherColumn)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(lateral)
          lateral: Boolean,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(lateral)
//                display_name lateral
//                documentation ```kotlin\nlateral: Boolean\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(lateral)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(additionalConstraint)
          additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(additionalConstraint)
//                             display_name additionalConstraint
//                             documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(additionalConstraint)
      ): Join {
//       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//        ⌄ enclosing_range_start local 8
          val cond = if (onColumn != null && otherColumn != null) {
//            ^^^^ definition local 8
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
//        ⌃ enclosing_range_end local 8
          return join(otherTable, joinType, cond, additionalConstraint, lateral)
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(otherTable)
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(joinType)
//                                          ^^^^ reference local 8
//                                                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(additionalConstraint)
//                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().(lateral)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#innerJoin().
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#innerJoin().(otherTable)
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
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#innerJoin().(otherTable)
//                                                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#innerJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#leftJoin().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#leftJoin().(otherTable)
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
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#leftJoin().(otherTable)
//                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#leftJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#rightJoin().
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#rightJoin().(otherTable)
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
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#rightJoin().(otherTable)
//                                                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#rightJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#fullJoin().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#fullJoin().(otherTable)
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
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#fullJoin().(otherTable)
//                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#fullJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#crossJoin().
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#crossJoin().(otherTable)
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
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#crossJoin().(otherTable)
//                                                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#crossJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().
      private fun implicitJoin(
//                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().
//                             display_name implicitJoin
//                             documentation ```kotlin\nprivate final fun implicitJoin(otherTable: ColumnSet, joinType: JoinType, lateral: Boolean = ...): Join\n```
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(otherTable)
          otherTable: ColumnSet,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(otherTable)
//                   display_name otherTable
//                   documentation ```kotlin\notherTable: ColumnSet\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(otherTable)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(joinType)
          joinType: JoinType,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(joinType)
//                 display_name joinType
//                 documentation ```kotlin\njoinType: JoinType\n```
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(joinType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(lateral)
          lateral: Boolean = false
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(lateral)
//                display_name lateral
//                documentation ```kotlin\nlateral: Boolean = ...\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(lateral)
      ): Join {
//       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//        ⌄ enclosing_range_start local 9
          val fkKeys = findKeys(this, otherTable) ?: findKeys(otherTable, this) ?: emptyList()
//            ^^^^^^ definition local 9
//                   display_name fkKeys
//                   documentation ```kotlin\nlocal val fkKeys: List<Pair<Column<*>, List<Column<*>>>>\n```
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(otherTable)
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().
//                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(otherTable)
//                                                                                 ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
//                                                                                           ⌃ enclosing_range_end local 9
          return when {
              joinType != JoinType.CROSS && fkKeys.isEmpty() -> {
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(joinType)
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#CROSS.
//                                          ^^^^^^ reference local 9
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#isEmpty().
                  error(
//                ^^^^^ reference semanticdb maven . . kotlin/error().
                      "Cannot join with $otherTable as there is no matching primary key/foreign key pair and constraint missing"
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(otherTable)
                  )
              }
  
//                       ⌄ enclosing_range_start local 10
              fkKeys.any { it.second.size > 1 } -> {
//            ^^^^^^ reference local 9
//                   ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                       ^^^^^^^^^^^^^^^^^^^^^^ definition local 10
//                                              display_name it
//                                              documentation ```kotlin\nit: Pair<Column<*>, List<Column<*>>>\n```
//                         ^^ reference local 10
//                            ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                            ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                   ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                   ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                        ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                            ⌃ enclosing_range_end local 10
//                ⌄ enclosing_range_start local 11
//                                                            ⌄ enclosing_range_start local 12
                  val references = fkKeys.joinToString(" & ") { "${it.first} -> ${it.second.joinToString()}" }
//                    ^^^^^^^^^^ definition local 11
//                               display_name references
//                               documentation ```kotlin\nlocal val references: String\n```
//                                 ^^^^^^ reference local 9
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 12
//                                                                                                             display_name it
//                                                                                                             documentation ```kotlin\nit: Pair<Column<*>, List<Column<*>>>\n```
//                                                                 ^^ reference local 12
//                                                                    ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                                    ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                                                ^^ reference local 12
//                                                                                   ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                                                                   ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                                           ⌃ enclosing_range_end local 11
//                                                                                                           ⌃ enclosing_range_end local 12
                  error(
//                ^^^^^ reference semanticdb maven . . kotlin/error().
                      "Cannot join with $otherTable as there is multiple primary key <-> foreign key references.\n$references"
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(otherTable)
//                                                                                                                 ^^^^^^^^^^ reference local 11
                  )
              }
  
              else -> {
//                ⌄ enclosing_range_start local 13
//                                         ⌄ enclosing_range_start local 14
//                                                                     ⌄ enclosing_range_start local 15
                  val cond = fkKeys.filter { it.second.size == 1 }.map { it.first to it.second.single() }
//                    ^^^^ definition local 13
//                         display_name cond
//                         documentation ```kotlin\nlocal val cond: List<Pair<Column<*>, Column<*>>>\n```
//                           ^^^^^^ reference local 9
//                                  ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                         ^^^^^^^^^^^^^^^^^^^^^^^ definition local 14
//                                                                 display_name it
//                                                                 documentation ```kotlin\nit: Pair<Column<*>, List<Column<*>>>\n```
//                                           ^^ reference local 14
//                                              ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                              ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                                     ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                                     ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                                                 ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 15
//                                                                                                        display_name it
//                                                                                                        documentation ```kotlin\nit: Pair<Column<*>, List<Column<*>>>\n```
//                                                                       ^^ reference local 15
//                                                                          ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                                          ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                                                ^^ reference semanticdb maven . . kotlin/to().
//                                                                                   ^^ reference local 15
//                                                                                      ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                                                                      ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                                                                             ^^^^^^ reference semanticdb maven . . kotlin/collections/single(+19).
//                                                               ⌃ enclosing_range_end local 14
//                                                                                                      ⌃ enclosing_range_end local 13
//                                                                                                      ⌃ enclosing_range_end local 15
                  join(otherTable, joinType, cond, additionalConstraint = null, lateral = lateral)
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(otherTable)
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(joinType)
//                                           ^^^^ reference local 13
//                                                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().(lateral)
              }
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#implicitJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+1).
      @Suppress("MemberNameEqualsClassName")
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+1).(part)
//                                                              ⌄ enclosing_range_start local 16
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
//                                                              ^ definition local 16 3:5
//                                                                display_name it
//                                                                documentation ```kotlin\nit: Join\n```
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+1).(part)
          it.joinParts.addAll(this.joinParts)
//        ^^ reference local 16
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                     ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#addAll().
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
          it.joinParts.add(part)
//        ^^ reference local 16
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                     ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+1).(part)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+1).
//    ⌃ enclosing_range_end local 16
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).
      @Suppress("MemberNameEqualsClassName")
      private fun join(
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).
//                     display_name join
//                     documentation ```kotlin\n@Suppress(...) private final fun join(otherTable: ColumnSet, joinType: JoinType, cond: List<{org/jetbrains/exposed/v1/core/JoinCondition=} Pair<Expression<*>, Expression<*>>>, additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?, lateral: Boolean = ...): Join\n```
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(otherTable)
          otherTable: ColumnSet,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(otherTable)
//                   display_name otherTable
//                   documentation ```kotlin\notherTable: ColumnSet\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(otherTable)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(joinType)
          joinType: JoinType,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(joinType)
//                 display_name joinType
//                 documentation ```kotlin\njoinType: JoinType\n```
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(joinType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(cond)
          cond: List<JoinCondition>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(cond)
//             display_name cond
//             documentation ```kotlin\ncond: List<{org/jetbrains/exposed/v1/core/JoinCondition=} Pair<Expression<*>, Expression<*>>>\n```
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(cond)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(additionalConstraint)
          additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?,
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(additionalConstraint)
//                             display_name additionalConstraint
//                             documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(additionalConstraint)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(lateral)
          lateral: Boolean = false
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(lateral)
//                display_name lateral
//                documentation ```kotlin\nlateral: Boolean = ...\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(lateral)
      ): Join = join(JoinPart(joinType, otherTable, cond, lateral, additionalConstraint))
//       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+1).
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().
//                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(joinType)
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(otherTable)
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(cond)
//                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(lateral)
//                                                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).(additionalConstraint)
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#join(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().(a)
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().(b)
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
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().(a)
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().(b)
//               ⌄ enclosing_range_start local 17
//                                                ⌄ enclosing_range_start local 18
          .map { a_pk -> a_pk to b.columns.filter { it.referee == a_pk } }
//         ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//               ^^^^ definition local 17
//                    display_name a_pk
//                    documentation ```kotlin\na_pk: Column<*>\n```
//                       ^^^^ reference local 17
//                            ^^ reference semanticdb maven . . kotlin/to().
//                               ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().(b)
//                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#columns.
//                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#getColumns().
//                                         ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                                ^^^^^^^^^^^^^^^^^^^^^^ definition local 18
//                                                                       display_name it
//                                                                       documentation ```kotlin\nit: Column<*>\n```
//                                                  ^^ reference local 18
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getReferee().
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#referee.
//                                                                ^^^^ reference local 17
//                  ⌃ enclosing_range_end local 17
//                                                                     ⌃ enclosing_range_end local 18
//                ⌄ enclosing_range_start local 19
          .filter { it.second.isNotEmpty() }
//         ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 19
//                                           display_name it
//                                           documentation ```kotlin\nit: Pair<Column<*>, List<Column<*>>>\n```
//                  ^^ reference local 19
//                     ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                     ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                            ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                         ⌃ enclosing_range_end local 19
//                ⌄ enclosing_range_start local 20
          .takeIf { it.isNotEmpty() }
//         ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                ^^^^^^^^^^^^^^^^^^^ definition local 20
//                                    display_name it
//                                    documentation ```kotlin\nit: List<Pair<Column<*>, List<Column<*>>>>\n```
//                  ^^ reference local 20
//                     ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#findKeys().
//                                  ⌃ enclosing_range_end local 20
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#alreadyInJoin().
      /** Return `true` if the specified [table] is already in this join, `false` otherwise. */
//                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#alreadyInJoin().(table)
//                                                             ⌄ enclosing_range_start local 21
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
//                                                             ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 21
//                                                                                      display_name it
//                                                                                      documentation ```kotlin\nit: Join.JoinPart\n```
//                                                               ^^ reference local 21
//                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#alreadyInJoin().(table)
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#alreadyInJoin().(table)
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#alreadyInJoin().
//                                                                                    ⌃ enclosing_range_end local 21
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#
      /** Represents a component of an existing join relation. */
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().
      internal class JoinPart(
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#
//                            display_name JoinPart
//                            documentation ```kotlin\ninternal final class JoinPart : Any\n```\n\n----\n\n Represents a component of an existing join relation.
//                   ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().
//                            display_name JoinPart
//                            documentation ```kotlin\npublic constructor(joinType: JoinType, joinPart: ColumnSet, conditions: List<{org/jetbrains/exposed/v1/core/JoinCondition=} Pair<Expression<*>, Expression<*>>>, lateral: Boolean = ..., additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)? = ...): Join.JoinPart\n```\n\n----\n\n The column set `JOIN` type.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(joinType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinType.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinType().
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
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(joinType)
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinType.
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinType().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(joinPart)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
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
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(joinPart)
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(conditions)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#conditions.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getConditions().
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
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(conditions)
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#conditions.
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getConditions().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(lateral)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#lateral.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getLateral().
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
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(lateral)
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#lateral.
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getLateral().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(additionalConstraint)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#additionalConstraint.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getAdditionalConstraint().
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
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().(additionalConstraint)
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#additionalConstraint.
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getAdditionalConstraint().
      ) {
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#`<init>`().
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
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                          ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getLateral().
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#lateral.
                  "The LATERAL join can only be used with a subquery; it cannot be used to join table ${(joinPart as Table).tableName} directly."
//                                                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                                                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                                                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                                                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
              }
          }
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#describe().
          /** Appends the SQL representation of this join component to the specified [QueryBuilder]. */
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#describe().(transaction)
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#describe().(builder)
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
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#describe().(transaction)
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#describe().(builder)
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
  
//            ⌄ enclosing_range_start local 22
              val isJoin = joinPart is Join
//                ^^^^^^ definition local 22
//                       display_name isJoin
//                       documentation ```kotlin\nlocal val isJoin: Boolean\n```
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                        ⌃ enclosing_range_end local 22
              if (isJoin) {
//                ^^^^^^ reference local 22
                  append("(")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
              }
              joinPart.describe(transaction, this)
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().
//                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#describe().(transaction)
              if (isJoin) {
//                ^^^^^^ reference local 22
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
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#describe().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#appendConditions().
          /** Appends the SQL representation of the conditions in the `ON` clause to the specified [QueryBuilder]. */
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#appendConditions().(builder)
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
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#appendConditions().(builder)
//                                                 ⌄ enclosing_range_start local 23
//                                                  ⌄ enclosing_range_start local 24
//                                                            ⌄ enclosing_range_start local 25
              conditions.appendTo(this, " AND ") { (pkColumn, fkColumn) -> append(pkColumn, " = ", fkColumn) }
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#conditions.
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getConditions().
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                                 ^^^^^^^^^^^^^^^^^^^^ definition local 23
//                                                                      display_name <destruct>
//                                                                      documentation ```kotlin\n<destruct>: {org/jetbrains/exposed/v1/core/JoinCondition=} Pair<Expression<*>, Expression<*>>\n```
//                                                  ^^^^^^^^ reference local 23
//                                                  ^^^^^^^^ definition local 24
//                                                           display_name pkColumn
//                                                           documentation ```kotlin\nlocal val pkColumn: Expression<*>\n```
//                                                  ^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                            ^^^^^^^^ reference local 23
//                                                            ^^^^^^^^ definition local 25
//                                                                     display_name fkColumn
//                                                                     documentation ```kotlin\nlocal val fkColumn: Expression<*>\n```
//                                                            ^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                                                ^^^^^^^^ reference local 24
//                                                                                                 ^^^^^^^^ reference local 25
//                                                         ⌃ enclosing_range_end local 24
//                                                                   ⌃ enclosing_range_end local 25
//                                                                    ⌃ enclosing_range_end local 23
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
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#appendConditions().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
  /**
   * Base class for any simple table.
   *
   * If you want to reference your table use [IdTable] instead.
   *
   * @param name Table name, by default name will be resolved from a class name with "Table" suffix removed (if present)
   */
  @Suppress("TooManyFunctions", "LargeClass")
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#`<init>`().
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#`<init>`().(name)
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
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#`<init>`().(name)
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#schemaName.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getSchemaName().
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#schemaName.
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getSchemaName().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithoutScheme.
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
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutScheme().
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
//                                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithoutScheme.
//                                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutScheme().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithoutSchemeSanitized.
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
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutSchemeSanitized().
          get() = tableNameWithoutScheme.unquoted()
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutSchemeSanitized().
//            display_name tableNameWithoutSchemeSanitized
//            documentation ```kotlin\npublic get(): String\n```
//                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutScheme().
//                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithoutScheme.
//                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#unquoted().
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithoutSchemeSanitized.
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutSchemeSanitized().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithSchemaSanitized.
      /**
       * Returns the full table name with all quotes removed. If the table name includes a dot-prefixed schema name,
       * the full name will be returned with '_' replacing the dot characters.
       */
      private val tableNameWithSchemaSanitized: String
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithSchemaSanitized.
//                                             display_name tableNameWithSchemaSanitized
//                                             documentation ```kotlin\nprivate final val tableNameWithSchemaSanitized: String\n```\n\n----\n\n\n Returns the full table name with all quotes removed. If the table name includes a dot-prefixed schema name,\n the full name will be returned with '_' replacing the dot characters.\n
//                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithSchemaSanitized().
          get() = tableName.unquoted().replace('.', '_')
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithSchemaSanitized().
//            display_name tableNameWithSchemaSanitized
//            documentation ```kotlin\nprivate get(): String\n```
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#unquoted().
//                                     ^^^^^^^ reference semanticdb maven . . kotlin/text/replace().
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithSchemaSanitized.
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithSchemaSanitized().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#unquoted().
      private fun String.unquoted(): String = replace("\"", "").replace("'", "").replace("`", "")
//                       ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#unquoted().
//                                display_name unquoted
//                                documentation ```kotlin\nprivate final fun String.unquoted(): String\n```
//                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                            ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
//                                                              ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
//                                                                               ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
//                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#unquoted().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_columns.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_columns().
      private val _columns = mutableListOf<Column<*>>()
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_columns.
//                         display_name _columns
//                         documentation ```kotlin\nprivate final val _columns: MutableList<Column<*>>\n```
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_columns().
//                         display_name _columns
//                         documentation ```kotlin\nprivate get(): MutableList<Column<*>>\n```
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_columns.
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_columns().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
      /** Returns all the columns defined on the table. */
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
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
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncColumn.
      /** Returns the first auto-increment column on the table. */
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getAutoIncColumn().
//                                                              ⌄ enclosing_range_start local 26
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
//                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 26
//                                                                                          display_name it
//                                                                                          documentation ```kotlin\nit: Column<*>\n```
//                                                                ^^ reference local 26
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//                                                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncColumn.
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getAutoIncColumn().
//                                                                                        ⌃ enclosing_range_end local 26
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_indices.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_indices().
      private val _indices = mutableListOf<Index>()
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_indices.
//                         display_name _indices
//                         documentation ```kotlin\nprivate final val _indices: MutableList<Index>\n```
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_indices().
//                         display_name _indices
//                         documentation ```kotlin\nprivate get(): MutableList<Index>\n```
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_indices.
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_indices().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#indices.
      /** Returns all indices declared on the table. */
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getIndices().
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
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#indices.
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getIndices().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_foreignKeys.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_foreignKeys().
      private val _foreignKeys = mutableListOf<ForeignKeyConstraint>()
//                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_foreignKeys.
//                             display_name _foreignKeys
//                             documentation ```kotlin\nprivate final val _foreignKeys: MutableList<ForeignKeyConstraint>\n```
//                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_foreignKeys().
//                             display_name _foreignKeys
//                             documentation ```kotlin\nprivate get(): MutableList<ForeignKeyConstraint>\n```
//                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_foreignKeys.
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_foreignKeys().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKeys.
      /** Returns all foreign key constraints declared on the table. */
//                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getForeignKeys().
//                                                                           ⌄ enclosing_range_start local 27
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
//                                                                           ^^^^^^^^^^^^^^^^^ definition local 27
//                                                                                             display_name it
//                                                                                             documentation ```kotlin\nit: Column<*>\n```
//                                                                             ^^ reference local 27
//                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//                                                                                             ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_foreignKeys.
//                                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_foreignKeys().
//                                                                                           ⌃ enclosing_range_end local 27
//                                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKeys.
//                                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getForeignKeys().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#sequences.
      /**
       * Returns all sequences declared on the table, along with any auto-generated sequences that are not explicitly
       * declared by the user but associated with the table.
       */
      val sequences: List<Sequence>
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#sequences.
//                  display_name sequences
//                  documentation ```kotlin\npublic final val sequences: List<Sequence>\n```\n\n----\n\n\n Returns all sequences declared on the table, along with any auto-generated sequences that are not explicitly\n declared by the user but associated with the table.\n
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getSequences().
//                               ⌄ enclosing_range_start local 28
//                                                                        ⌄ enclosing_range_start local 29
          get() = columns.filter { it.columnType.isAutoInc }.mapNotNull { column ->
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getSequences().
//            display_name sequences
//            documentation ```kotlin\npublic get(): List<Sequence>\n```
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                        ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 28
//                                                           display_name it
//                                                           documentation ```kotlin\nit: Column<*>\n```
//                                 ^^ reference local 28
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
//                                                           ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mapNotNull(+1).
//                                                                        ^^^^^^ definition local 29
//                                                                               display_name column
//                                                                               documentation ```kotlin\ncolumn: Column<*>\n```
//                                                         ⌃ enclosing_range_end local 28
//                                                                             ⌃ enclosing_range_end local 29
              column.autoIncColumnType?.sequence
//            ^^^^^^ reference local 29
//                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.
//                                 ⌄ enclosing_range_start local 30
//                                                                              ⌄ enclosing_range_start local 31
                  ?: column.takeIf { currentDialect is PostgreSQLDialect }?.let {
//                   ^^^^^^ reference local 29
//                          ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 30
//                                                                         display_name it
//                                                                         documentation ```kotlin\nit: Column<*>\n```
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                                                                          ^^^ reference semanticdb maven . . kotlin/let().
//                                                                              ^ definition local 31 8:17
//                                                                                display_name it
//                                                                                documentation ```kotlin\nit: Column<*>\n```
//                                                                       ⌃ enclosing_range_end local 30
//                    ⌄ enclosing_range_start local 32
                      val fallbackSequenceName = fallbackSequenceName(tableName = tableName, columnName = it.name)
//                        ^^^^^^^^^^^^^^^^^^^^ definition local 32
//                                             display_name fallbackSequenceName
//                                             documentation ```kotlin\nlocal val fallbackSequenceName: String\n```
//                                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().
//                                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                                                        ^^ reference local 31
//                                                                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                                                               ⌃ enclosing_range_end local 32
                      Sequence(
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().
                          fallbackSequenceName,
//                        ^^^^^^^^^^^^^^^^^^^^ reference local 32
                          startWith = 1,
                          minValue = 1,
                          maxValue = currentDialect.sequenceMaxValue
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSequenceMaxValue().
//                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#sequenceMaxValue.
                      )
                  }
//                ⌃ enclosing_range_end local 31
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#sequences.
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getSequences().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getCheckConstraints().
      private val checkConstraints = mutableListOf<Pair<String, Op<Boolean>>>()
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints.
//                                 display_name checkConstraints
//                                 documentation ```kotlin\nprivate final val checkConstraints: MutableList<Pair<String, Op<Boolean>>>\n```
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getCheckConstraints().
//                                 display_name checkConstraints
//                                 documentation ```kotlin\nprivate get(): MutableList<Pair<String, Op<Boolean>>>\n```
//                                   ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
//                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints.
//                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getCheckConstraints().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedUnsignedCheckPrefix.
      private val generatedUnsignedCheckPrefix
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedUnsignedCheckPrefix.
//                                             display_name generatedUnsignedCheckPrefix
//                                             documentation ```kotlin\nprivate final val generatedUnsignedCheckPrefix: String\n```
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedUnsignedCheckPrefix().
          get() = "chk_${tableNameWithSchemaSanitized}_unsigned_"
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedUnsignedCheckPrefix().
//            display_name generatedUnsignedCheckPrefix
//            documentation ```kotlin\nprivate get(): String\n```
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithSchemaSanitized().
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithSchemaSanitized.
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedUnsignedCheckPrefix.
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedUnsignedCheckPrefix().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
      private val generatedSignedCheckPrefix
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                           display_name generatedSignedCheckPrefix
//                                           documentation ```kotlin\nprivate final val generatedSignedCheckPrefix: String\n```
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
          get() = "chk_${tableNameWithSchemaSanitized}_signed_"
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
//            display_name generatedSignedCheckPrefix
//            documentation ```kotlin\nprivate get(): String\n```
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithSchemaSanitized().
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithSchemaSanitized.
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints(+1).
      /** Returns the list of CHECK constraints in this table. */
      fun checkConstraints(): List<CheckConstraint> {
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints(+1).
//                         display_name checkConstraints
//                         documentation ```kotlin\npublic final fun checkConstraints(): List<CheckConstraint>\n```\n\n----\n\n Returns the list of CHECK constraints in this table.
//                            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//        ⌄ enclosing_range_start local 33
//                                                          ⌄ enclosing_range_start local 34
//                                                           ⌄ enclosing_range_start local 35
//                                                                 ⌄ enclosing_range_start local 36
          val filteredChecks = checkConstraints.filterNot { (name, _) ->
//            ^^^^^^^^^^^^^^ definition local 33
//                           display_name filteredChecks
//                           documentation ```kotlin\nlocal val filteredChecks: MutableList<Pair<String, Op<Boolean>>>\n```
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints.
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getCheckConstraints().
//                                              ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterNot(+9).
//                                                          ^^^^^^^^^ definition local 34
//                                                                    display_name <destruct>
//                                                                    documentation ```kotlin\n<destruct>: Pair<String, Op<Boolean>>\n```
//                                                           ^^^^ reference local 34
//                                                           ^^^^ definition local 35
//                                                                display_name name
//                                                                documentation ```kotlin\nlocal val name: String\n```
//                                                           ^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                                 ^ reference local 34
//                                                                 ^ definition local 36
//                                                                   display_name <unused var>
//                                                                   documentation ```kotlin\nlocal val <unused var>: Op<Boolean>\n```
//                                                                 ^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                              ⌃ enclosing_range_end local 35
//                                                                 ⌃ enclosing_range_end local 36
//                                                                  ⌃ enclosing_range_end local 34
//                  ⌄ enclosing_range_start local 37
              when (val dialect = currentDialect) {
//                      ^^^^^^^ definition local 37
//                              display_name dialect
//                              documentation ```kotlin\nlocal val dialect: DatabaseDialect\n```
//                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                             ⌃ enclosing_range_end local 37
                  is MysqlDialect -> name.startsWith(generatedUnsignedCheckPrefix) || name.startsWith(generatedSignedCheckPrefix)
//                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                                   ^^^^ reference local 35
//                                        ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedUnsignedCheckPrefix.
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedUnsignedCheckPrefix().
//                                                                                    ^^^^ reference local 35
//                                                                                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
                  is SQLServerDialect -> name.startsWith("${generatedUnsignedCheckPrefix}byte") ||
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#
//                                       ^^^^ reference local 35
//                                            ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedUnsignedCheckPrefix.
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedUnsignedCheckPrefix().
                      name.startsWith("${generatedSignedCheckPrefix}short")
//                    ^^^^ reference local 35
//                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
                  is PostgreSQLDialect -> name.startsWith("${generatedSignedCheckPrefix}short")
//                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                                        ^^^^ reference local 35
//                                             ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
//                                      ⌄ enclosing_range_start local 38
                  is H2Dialect -> when (dialect.h2Mode) {
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
//                                      ^^^^^^^ reference local 37
//                                      ^^^^^^^^^^^^^^ definition local 38
//                                                     display_name <when-subject>
//                                                     documentation ```kotlin\nlocal val <when-subject>: H2Dialect.H2CompatibilityMode?\n```
//                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#getH2Mode().
//                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#h2Mode.
//                                                   ⌃ enclosing_range_end local 38
                      H2Dialect.H2CompatibilityMode.PostgreSQL -> name.startsWith("${generatedSignedCheckPrefix}short")
//                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#PostgreSQL.
//                                                                ^^^^ reference local 35
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
                      else -> name.startsWith(generatedSignedCheckPrefix)
//                            ^^^^ reference local 35
//                                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
                  }
                  else -> false
              }
          }.toMutableList().apply {
//          ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/toMutableList(+10).
//                          ^^^^^ reference semanticdb maven . . kotlin/apply().
//            ⌄ enclosing_range_start local 39
              val isNotSQLiteOrOracle = currentDialect !is SQLiteDialect && currentDialect !is OracleDialect
//                ^^^^^^^^^^^^^^^^^^^ definition local 39
//                                    display_name isNotSQLiteOrOracle
//                                    documentation ```kotlin\nlocal val isNotSQLiteOrOracle: Boolean\n```
//                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#
//                                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                                                                                                         ⌃ enclosing_range_end local 39
//            ⌄ enclosing_range_start local 40
              val isNotOracle = currentDialect !is OracleDialect
//                ^^^^^^^^^^^ definition local 40
//                            display_name isNotOracle
//                            documentation ```kotlin\nlocal val isNotOracle: Boolean\n```
//                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                 ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                                                             ⌃ enclosing_range_end local 40
  
//                                                 ⌄ enclosing_range_start local 41
//                                                  ⌄ enclosing_range_start local 42
//                                                        ⌄ enclosing_range_start local 43
              if (isNotSQLiteOrOracle) removeAll { (name, _) -> name.startsWith("${generatedSignedCheckPrefix}integer") }
//                ^^^^^^^^^^^^^^^^^^^ reference local 39
//                                     ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/removeAll(+5).
//                                                 ^^^^^^^^^ definition local 41
//                                                           display_name <destruct>
//                                                           documentation ```kotlin\n<destruct>: Pair<String, Op<Boolean>>\n```
//                                                  ^^^^ reference local 41
//                                                  ^^^^ definition local 42
//                                                       display_name name
//                                                       documentation ```kotlin\nlocal val name: String\n```
//                                                  ^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                        ^ reference local 41
//                                                        ^ definition local 43
//                                                          display_name <unused var>
//                                                          documentation ```kotlin\nlocal val <unused var>: Op<Boolean>\n```
//                                                        ^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                              ^^^^ reference local 42
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
//                                                     ⌃ enclosing_range_end local 42
//                                                        ⌃ enclosing_range_end local 43
//                                                         ⌃ enclosing_range_end local 41
//                                         ⌄ enclosing_range_start local 44
//                                          ⌄ enclosing_range_start local 45
//                                                ⌄ enclosing_range_start local 46
              if (isNotOracle) removeAll { (name, _) -> name.startsWith("${generatedSignedCheckPrefix}long") }
//                ^^^^^^^^^^^ reference local 40
//                             ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/removeAll(+5).
//                                         ^^^^^^^^^ definition local 44
//                                                   display_name <destruct>
//                                                   documentation ```kotlin\n<destruct>: Pair<String, Op<Boolean>>\n```
//                                          ^^^^ reference local 44
//                                          ^^^^ definition local 45
//                                               display_name name
//                                               documentation ```kotlin\nlocal val name: String\n```
//                                          ^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                ^ reference local 44
//                                                ^ definition local 46
//                                                  display_name <unused var>
//                                                  documentation ```kotlin\nlocal val <unused var>: Op<Boolean>\n```
//                                                ^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                      ^^^^ reference local 45
//                                                           ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
//                                             ⌃ enclosing_range_end local 45
//                                                ⌃ enclosing_range_end local 46
//                                                 ⌃ enclosing_range_end local 44
          }
//        ⌃ enclosing_range_end local 33
//                                           ⌄ enclosing_range_start local 47
//                                                  ⌄ enclosing_range_start local 48
//                                                   ⌄ enclosing_range_start local 49
//                                                         ⌄ enclosing_range_start local 50
          return filteredChecks.mapIndexed { index, (name, op) ->
//               ^^^^^^^^^^^^^^ reference local 33
//                              ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mapIndexed(+9).
//                                           ^^^^^ definition local 47
//                                                 display_name index
//                                                 documentation ```kotlin\nindex: Int\n```
//                                                  ^^^^^^^^^^ definition local 48
//                                                             display_name <destruct>
//                                                             documentation ```kotlin\n<destruct>: Pair<String, Op<Boolean>>\n```
//                                                   ^^^^ reference local 48
//                                                   ^^^^ definition local 49
//                                                        display_name name
//                                                        documentation ```kotlin\nlocal val name: String\n```
//                                                   ^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                         ^^ reference local 48
//                                                         ^^ definition local 50
//                                                            display_name op
//                                                            documentation ```kotlin\nlocal val op: Op<Boolean>\n```
//                                                         ^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                               ⌃ enclosing_range_end local 47
//                                                      ⌃ enclosing_range_end local 49
//                                                          ⌃ enclosing_range_end local 50
//                                                           ⌃ enclosing_range_end local 48
//            ⌄ enclosing_range_start local 51
              val resolvedName = name.ifBlank { "check_${tableNameWithSchemaSanitized}_$index" }
//                ^^^^^^^^^^^^ definition local 51
//                             display_name resolvedName
//                             documentation ```kotlin\nlocal val resolvedName: String\n```
//                               ^^^^ reference local 49
//                                    ^^^^^^^ reference semanticdb maven . . kotlin/text/ifBlank().
//                                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithSchemaSanitized().
//                                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithSchemaSanitized.
//                                                                                      ^^^^^ reference local 47
//                                                                                             ⌃ enclosing_range_end local 51
              CheckConstraint.from(this@Table, resolvedName, op)
//                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#Companion#from().
//                                             ^^^^^^^^^^^^ reference local 51
//                                                           ^^ reference local 50
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nameInDatabaseCase().
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
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nameInDatabaseCase().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nameInDatabaseCaseUnquoted().
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
//                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nameInDatabaseCaseUnquoted().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().(s)
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().(queryBuilder)
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
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().(s)
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().(queryBuilder)
          append(
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
              s.identity(this@Table)
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().(s)
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
          )
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().
  
      // Join operations
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().
      override fun join(
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().
//                      display_name join
//                      documentation ```kotlin\npublic open override fun join(otherTable: ColumnSet, joinType: JoinType, onColumn: Expression<*>?, otherColumn: Expression<*>?, lateral: Boolean, additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?): Join\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#join().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(otherTable)
          otherTable: ColumnSet,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(otherTable)
//                   display_name otherTable
//                   documentation ```kotlin\notherTable: ColumnSet\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(otherTable)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(joinType)
          joinType: JoinType,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(joinType)
//                 display_name joinType
//                 documentation ```kotlin\njoinType: JoinType\n```
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(joinType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(onColumn)
          onColumn: Expression<*>?,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(onColumn)
//                 display_name onColumn
//                 documentation ```kotlin\nonColumn: Expression<*>?\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(onColumn)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(otherColumn)
          otherColumn: Expression<*>?,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(otherColumn)
//                    display_name otherColumn
//                    documentation ```kotlin\notherColumn: Expression<*>?\n```
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(otherColumn)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(lateral)
          lateral: Boolean,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(lateral)
//                display_name lateral
//                documentation ```kotlin\nlateral: Boolean\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(lateral)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(additionalConstraint)
          additionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(additionalConstraint)
//                             display_name additionalConstraint
//                             documentation ```kotlin\nadditionalConstraint: (SqlExpressionBuilder.() -> Op<Boolean>)?\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(additionalConstraint)
      ): Join = Join(this, otherTable, joinType, onColumn, otherColumn, lateral, additionalConstraint)
//       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#`<init>`(+1).
//                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(otherTable)
//                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(joinType)
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(onColumn)
//                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(otherColumn)
//                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(lateral)
//                                                                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().(additionalConstraint)
//                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#join().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#innerJoin().
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#innerJoin().(otherTable)
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
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#innerJoin().(otherTable)
//                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#innerJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#leftJoin().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#leftJoin().(otherTable)
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
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#leftJoin().(otherTable)
//                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#leftJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#rightJoin().
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#rightJoin().(otherTable)
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
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#rightJoin().(otherTable)
//                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#rightJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#fullJoin().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#fullJoin().(otherTable)
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
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#fullJoin().(otherTable)
//                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#fullJoin().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#crossJoin().
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#crossJoin().(otherTable)
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
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#crossJoin().(otherTable)
//                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#crossJoin().
  
      // Column registration
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
      /** Adds a column of the specified [type] and with the specified [name] to the table. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().(name)
//                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().(type)
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
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().[T]
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().(name)
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().(type)
          this,
          name,
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().(name)
          type
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().(type)
//           ⌄ enclosing_range_start local 52
      ).also { _columns.addColumn(it) }
//      ^^^^ reference semanticdb maven . . kotlin/also().
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 52
//                                      display_name it
//                                      documentation ```kotlin\nit: Column<T>\n```
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_columns.
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_columns().
//                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().
//                                ^^ reference local 52
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                    ⌃ enclosing_range_end local 52
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerCompositeColumn().
      /** Adds all wrapped column components of a [CompositeColumn] to the table. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerCompositeColumn().[R]
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerCompositeColumn().[T]
//                                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerCompositeColumn().(column)
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
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerCompositeColumn().[R]
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerCompositeColumn().[T]
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerCompositeColumn().(column)
//                                 ⌄ enclosing_range_start local 53
          getRealColumns().forEach {
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumns().
//                         ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                 ^ definition local 53 4:9
//                                   display_name it
//                                   documentation ```kotlin\nit: Column<*>\n```
              _columns.addColumn(
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_columns.
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_columns().
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().
                  it
//                ^^ reference local 53
              )
          }
//        ⌃ enclosing_range_end local 53
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerCompositeColumn().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
      /**
       * Replaces the specified [oldColumn] with the specified [newColumn] in the table.
       * Mostly used internally by the library.
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().[TColumn]
//                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().(oldColumn)
//                                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().(newColumn)
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
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().[TColumn]
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().(oldColumn)
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().(newColumn)
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().(column)
      private fun MutableList<Column<*>>.addColumn(column: Column<*>) {
//                                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().
//                                                 display_name addColumn
//                                                 documentation ```kotlin\nprivate final fun MutableList<Column<*>>.addColumn(column: Column<*>): Unit\n```
//                                                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().(column)
//                                                        display_name column
//                                                        documentation ```kotlin\ncolumn: Column<*>\n```
//                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().(column)
//                     ⌄ enclosing_range_start local 54
          if (this.any { it.name == column.name }) {
//                 ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 54
//                                                display_name it
//                                                documentation ```kotlin\nit: Column<*>\n```
//                       ^^ reference local 54
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().(column)
//                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                              ⌃ enclosing_range_end local 54
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().
  
      // Primary keys
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#isCustomPKNameDefined().
//                                                                    ⌄ enclosing_range_start local 55
      internal fun isCustomPKNameDefined(): Boolean = primaryKey?.let {
//                 ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#isCustomPKNameDefined().
//                                       display_name isCustomPKNameDefined
//                                       documentation ```kotlin\ninternal final fun isCustomPKNameDefined(): Boolean\n```
//                                          ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                                                                ^^^ reference semanticdb maven . . kotlin/let().
//                                                                    ^ definition local 55 3:5
//                                                                      display_name it
//                                                                      documentation ```kotlin\nit: Table.PrimaryKey\n```
          @OptIn(InternalApi::class)
          it.name != "pk_$tableNameWithoutSchemeSanitized"
//        ^^ reference local 55
//           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getName().
//           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#name.
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutSchemeSanitized().
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithoutSchemeSanitized.
      } == true
//    ⌃ enclosing_range_end local 55
//            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#isCustomPKNameDefined().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#
      /**
       * Represents a primary key composed by the specified [columns], and with the specified [name].
       * If no name is specified, the table name with the "pk_" prefix will be used instead.
       *
       * @sample org.jetbrains.exposed.v1.tests.demo.sql.Users
       */
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`().
      inner class PrimaryKey(
//                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#
//                           display_name PrimaryKey
//                           documentation ```kotlin\npublic final inner class PrimaryKey : Any\n```\n\n----\n\n\n Represents a primary key composed by the specified [columns], and with the specified [name].\n If no name is specified, the table name with the "pk_" prefix will be used instead.\n\n @sample org.jetbrains.exposed.v1.tests.demo.sql.Users\n
//                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`().
//                           display_name PrimaryKey
//                           documentation ```kotlin\npublic Table.constructor(columns: Array<Column<*>>, name: String? = ...): Table.PrimaryKey\n```\n\n----\n\n Returns the columns that compose the primary key.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`().(columns)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
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
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`().(columns)
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`().(name)
          name: String? = null
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`().(name)
//             display_name name
//             documentation ```kotlin\nname: String? = ...\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`().(name)
      ) {
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#name.
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getName().
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
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#name.
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getName().
  
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).
//                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).(firstColumn)
//                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).(columns)
//                                                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).(name)
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
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).(firstColumn)
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).(columns)
//                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).(name)
              this(arrayOf(firstColumn) + columns.asList(), name)
//                 ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).(firstColumn)
//                                      ^ reference semanticdb maven . . kotlin/collections/plus(+9).
//                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).(columns)
//                                                ^^^^^^ reference semanticdb maven . . kotlin/collections/asList().
//                                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).(name)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#`<init>`(+1).
  
          init {
//                                       ⌄ enclosing_range_start local 56
              columns.sortWith(compareBy { !it.columnType.isAutoInc })
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                    ^^^^^^^^ reference semanticdb maven . . kotlin/collections/sortWith().
//                             ^^^^^^^^^ reference semanticdb maven . . kotlin/comparisons/compareBy(+1).
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 56
//                                                                    display_name it
//                                                                    documentation ```kotlin\nit: Column<*>\n```
//                                         ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                          ^^ reference local 56
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getIsAutoInc().
//                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isAutoInc.
//                                                                  ⌃ enclosing_range_end local 56
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
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
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
  
      // EntityID columns
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId().
      /** Converts the @receiver column to an [EntityID] column. */
      @Suppress("UNCHECKED_CAST")
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId().[T]
      fun <T : Any> Column<T>.entityId(): Column<EntityID<T>> {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                            ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId().
//                                     display_name entityId
//                                     documentation ```kotlin\n@Suppress(...) public final fun <T : Any> Column<T>.entityId(): Column<EntityID<T>>\n```\n\n----\n\n Converts the @receiver column to an [EntityID] column.
//                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId().[T]
//        ⌄ enclosing_range_start local 57
//                                                                                        ⌄ enclosing_range_start local 58
          val newColumn = Column<EntityID<T>>(table, name, EntityIDColumnType(this)).also {
//            ^^^^^^^^^ definition local 57
//                      display_name newColumn
//                      documentation ```kotlin\nlocal val newColumn: Column<EntityID<T>>\n```
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#`<init>`().
//                                                                                   ^^^^ reference semanticdb maven . . kotlin/also().
//                                                                                        ^ definition local 58 4:9
//                                                                                          display_name it
//                                                                                          documentation ```kotlin\nit: Column<EntityID<T>>\n```
//                                                      ⌄ enclosing_range_start local 59
              it.defaultValueFun = defaultValueFun?.let { { EntityIDFunctionProvider.createEntityID(it(), table as IdTable<T>) } }
//            ^^ reference local 58
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                  ^^^ reference semanticdb maven . . kotlin/let().
//                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 59
//                                                                                                                                 display_name it
//                                                                                                                                 documentation ```kotlin\nit: () -> T\n```
//                                                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#createEntityID().
//                                                                                                  ^^ reference local 59
//                                                                                                  ^^ reference semanticdb maven . . kotlin/Function0#invoke().
//                                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                                                                               ⌃ enclosing_range_end local 59
//                                                      ⌄ enclosing_range_start local 60
              it.dbDefaultValue = dbDefaultValue?.let { default -> default as Expression<EntityID<T>> }
//            ^^ reference local 58
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                ^^^ reference semanticdb maven . . kotlin/let().
//                                                      ^^^^^^^ definition local 60
//                                                              display_name default
//                                                              documentation ```kotlin\ndefault: Expression<T>\n```
//                                                                 ^^^^^^^ reference local 60
//                                                                            ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                            ⌃ enclosing_range_end local 60
              it.extraDefinitions = extraDefinitions
//            ^^ reference local 58
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
          }
//        ⌃ enclosing_range_end local 57
//        ⌃ enclosing_range_end local 58
          (table as IdTable<T>).addIdColumnInternal(newColumn)
//         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#addIdColumnInternal().
//                                                  ^^^^^^^^^ reference local 57
          return replaceColumn(this, newColumn)
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                   ^^^^^^^^^ reference local 57
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).
      /** Creates an [EntityID] column, with the specified [name], for storing the same objects as the specified [originalColumn]. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).[ID]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).(name)
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).(originalColumn)
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
//                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).[ID]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).(name)
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).(originalColumn)
//        ⌄ enclosing_range_start local 61
          val columnTypeCopy = originalColumn.columnType.cloneAsBaseType()
//            ^^^^^^^^^^^^^^ definition local 61
//                           display_name columnTypeCopy
//                           documentation ```kotlin\nlocal val columnTypeCopy: IColumnType<ID>\n```
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).(originalColumn)
//                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneAsBaseType().
//                                                                       ⌃ enclosing_range_end local 61
//        ⌄ enclosing_range_start local 62
          val answer = Column<EntityID<ID>>(
//            ^^^^^^ definition local 62
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
//                                                                      ^^^^^^^^^^^^^^ reference local 61
          )
//        ⌃ enclosing_range_end local 62
          _columns.addColumn(answer)
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_columns.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_columns().
//                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().
//                           ^^^^^^ reference local 62
          return answer
//               ^^^^^^ reference local 62
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).
      /** Creates an [EntityID] column, with the specified [name], for storing the identifier of the specified [table]. */
      @Suppress("UNCHECKED_CAST")
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).[ID]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).(name)
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).(table)
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
//                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).[ID]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).(name)
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).(table)
//        ⌄ enclosing_range_start local 63
          val originalColumn = (table.id.columnType as EntityIDColumnType<*>).idColumn as Column<ID>
//            ^^^^^^^^^^^^^^ definition local 63
//                           display_name originalColumn
//                           documentation ```kotlin\nlocal val originalColumn: Column<ID>\n```
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).(table)
//                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#getId().
//                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#id.
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                     ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#
//                                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                                 ⌃ enclosing_range_end local 63
          return entityId(name, originalColumn)
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).(name)
//                              ^^^^^^^^^^^^^^ reference local 63
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().
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
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().(toCompare)
          toCompare: Any?,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().(toCompare)
//                  display_name toCompare
//                  documentation ```kotlin\ntoCompare: Any?\n```
//                   ^^^^ reference semanticdb maven . . kotlin/Any#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().(toCompare)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().(booleanOperator)
          booleanOperator: (Column<*>, Expression<*>) -> Op<Boolean>
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().(booleanOperator)
//                        display_name booleanOperator
//                        documentation ```kotlin\nbooleanOperator: (Column<*>, Expression<*>) -> Op<Boolean>\n```
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().(booleanOperator)
      ): Op<Boolean> {
//       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          require(this is IdTable<*>) { "idColumns for mapping are only available from IdTable instances" }
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//        ⌄ enclosing_range_start local 64
          val singleId = idColumns.single()
//            ^^^^^^^^ definition local 64
//                     display_name singleId
//                     documentation ```kotlin\nlocal val singleId: Column<out Any>\n```
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#getIdColumns().
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#idColumns.
//                                 ^^^^^^ reference semanticdb maven . . kotlin/collections/single(+18).
//                                        ⌃ enclosing_range_end local 64
          return booleanOperator(singleId, singleId.wrap(toCompare))
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().(booleanOperator)
//                               ^^^^^^^^ reference local 64
//                                         ^^^^^^^^ reference local 64
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().(toCompare)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().
      /** Returns a boolean operator with each of an IdTable's `idColumns` using the specified SQL [booleanOperator]. */
      internal open fun mapIdOperator(
//                      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().
//                                    display_name mapIdOperator
//                                    documentation ```kotlin\ninternal open fun mapIdOperator(booleanOperator: (Column<*>) -> Op<Boolean>): Op<Boolean>\n```\n\n----\n\n Returns a boolean operator with each of an IdTable's `idColumns` using the specified SQL [booleanOperator].
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#mapIdOperator().
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#mapIdOperator().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().(booleanOperator)
          booleanOperator: (Column<*>) -> Op<Boolean>
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().(booleanOperator)
//                        display_name booleanOperator
//                        documentation ```kotlin\nbooleanOperator: (Column<*>) -> Op<Boolean>\n```
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().(booleanOperator)
      ): Op<Boolean> {
//       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
          require(this is IdTable<*>) { "idColumns for mapping are only available from IdTable instances" }
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
          return booleanOperator(idColumns.single())
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().(booleanOperator)
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#getIdColumns().
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#idColumns.
//                                         ^^^^^^ reference semanticdb maven . . kotlin/collections/single(+18).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().
  
      // Numeric columns
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#byte().
      /** Creates a numeric column, with the specified [name], for storing 1-byte integers.
       * An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.
       */
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#byte().(name)
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#byte().(checkConstraintName)
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
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#byte().(name)
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#byte().(checkConstraintName)
//                                                                                                 ⌄ enclosing_range_start local 65
          check(checkConstraintName ?: "${generatedSignedCheckPrefix}byte_${this.unquotedName()}") { it.between(Byte.MIN_VALUE, Byte.MAX_VALUE) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#byte().(checkConstraintName)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//                                                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 65
//                                                                                                                                                display_name it
//                                                                                                                                                documentation ```kotlin\nit: Column<Byte>\n```
//                                                                                                   ^^ reference local 65
//                                                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
//                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Byte#Companion#MIN_VALUE.
//                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Byte#Companion#getMIN_VALUE().
//                                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Byte#Companion#MAX_VALUE.
//                                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Byte#Companion#getMAX_VALUE().
//                                                                                                                                              ⌃ enclosing_range_end local 65
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#byte().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ubyte().
      /** Creates a numeric column, with the specified [name], for storing 1-byte unsigned integers.
       * An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.
       *
       * **Note:** If the database being used is not MySQL, MariaDB, or SQL Server, this column will use the
       * database's 2-byte integer type with a check constraint that ensures storage of only values
       * between 0 and [UByte.MAX_VALUE] inclusive.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ubyte().(name)
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ubyte().(checkConstraintName)
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
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ubyte().(name)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ubyte().(checkConstraintName)
//                                                                                                   ⌄ enclosing_range_start local 66
          check(checkConstraintName ?: "${generatedUnsignedCheckPrefix}byte_${this.unquotedName()}") { it.between(0u, UByte.MAX_VALUE) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ubyte().(checkConstraintName)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedUnsignedCheckPrefix.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedUnsignedCheckPrefix().
//                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//                                                                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 66
//                                                                                                                                       display_name it
//                                                                                                                                       documentation ```kotlin\nit: Column<UByte>\n```
//                                                                                                     ^^ reference local 66
//                                                                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
//                                                                                                                          ^^^^^^^^^ reference semanticdb maven . . kotlin/UByte#Companion#MAX_VALUE.
//                                                                                                                          ^^^^^^^^^ reference semanticdb maven . . kotlin/UByte#Companion#getMAX_VALUE().
//                                                                                                                                     ⌃ enclosing_range_end local 66
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ubyte().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#short().
      /** Creates a numeric column, with the specified [name], for storing 2-byte integers.
       * An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#short().(name)
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#short().(checkConstraintName)
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
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#short().(name)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#short().(checkConstraintName)
//                                                                                                  ⌄ enclosing_range_start local 67
          check(checkConstraintName ?: "${generatedSignedCheckPrefix}short_${this.unquotedName()}") { it.between(Short.MIN_VALUE, Short.MAX_VALUE) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#short().(checkConstraintName)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//                                                                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 67
//                                                                                                                                                   display_name it
//                                                                                                                                                   documentation ```kotlin\nit: Column<Short>\n```
//                                                                                                    ^^ reference local 67
//                                                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
//                                                                                                                     ^^^^^^^^^ reference semanticdb maven . . kotlin/Short#Companion#MIN_VALUE.
//                                                                                                                     ^^^^^^^^^ reference semanticdb maven . . kotlin/Short#Companion#getMIN_VALUE().
//                                                                                                                                      ^^^^^^^^^ reference semanticdb maven . . kotlin/Short#Companion#MAX_VALUE.
//                                                                                                                                      ^^^^^^^^^ reference semanticdb maven . . kotlin/Short#Companion#getMAX_VALUE().
//                                                                                                                                                 ⌃ enclosing_range_end local 67
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#short().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ushort().
      /** Creates a numeric column, with the specified [name], for storing 2-byte unsigned integers.
       * An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.
       *
       * **Note:** If the database being used is not MySQL or MariaDB, this column will use the database's 4-byte
       * integer type with a check constraint that ensures storage of only values between 0 and [UShort.MAX_VALUE] inclusive.
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ushort().(name)
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ushort().(checkConstraintName)
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
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ushort().(name)
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ushort().(checkConstraintName)
//                                                                                                    ⌄ enclosing_range_start local 68
          check(checkConstraintName ?: "${generatedUnsignedCheckPrefix}short_${this.unquotedName()}") { it.between(0u, UShort.MAX_VALUE) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ushort().(checkConstraintName)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedUnsignedCheckPrefix.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedUnsignedCheckPrefix().
//                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//                                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 68
//                                                                                                                                         display_name it
//                                                                                                                                         documentation ```kotlin\nit: Column<UShort>\n```
//                                                                                                      ^^ reference local 68
//                                                                                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
//                                                                                                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/UShort#Companion#MAX_VALUE.
//                                                                                                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/UShort#Companion#getMAX_VALUE().
//                                                                                                                                       ⌃ enclosing_range_end local 68
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ushort().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#integer().
      /** Creates a numeric column, with the specified [name], for storing 4-byte integers.
       * An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.
       */
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#integer().(name)
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#integer().(checkConstraintName)
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
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#integer().(name)
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#integer().(checkConstraintName)
//                                                                                                    ⌄ enclosing_range_start local 69
          check(checkConstraintName ?: "${generatedSignedCheckPrefix}integer_${this.unquotedName()}") { it.between(Int.MIN_VALUE, Int.MAX_VALUE) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#integer().(checkConstraintName)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
//                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//                                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 69
//                                                                                                                                                 display_name it
//                                                                                                                                                 documentation ```kotlin\nit: Column<Int>\n```
//                                                                                                      ^^ reference local 69
//                                                                                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
//                                                                                                                     ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MIN_VALUE.
//                                                                                                                     ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMIN_VALUE().
//                                                                                                                                    ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                                                                                                    ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                                                                                                               ⌃ enclosing_range_end local 69
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#integer().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uinteger().
      /** Creates a numeric column, with the specified [name], for storing 4-byte unsigned integers.
       * An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.
       *
       * **Note:** If the database being used is not MySQL or MariaDB, this column will use the database's
       * 8-byte integer type with a check constraint that ensures storage of only values
       * between 0 and [UInt.MAX_VALUE] inclusive.
       */
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uinteger().(name)
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uinteger().(checkConstraintName)
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
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uinteger().(name)
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uinteger().(checkConstraintName)
//                                                                                                      ⌄ enclosing_range_start local 70
          check(checkConstraintName ?: "${generatedUnsignedCheckPrefix}integer_${this.unquotedName()}") { it.between(0u, UInt.MAX_VALUE) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uinteger().(checkConstraintName)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedUnsignedCheckPrefix.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedUnsignedCheckPrefix().
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 70
//                                                                                                                                         display_name it
//                                                                                                                                         documentation ```kotlin\nit: Column<UInt>\n```
//                                                                                                        ^^ reference local 70
//                                                                                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
//                                                                                                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/UInt#Companion#MAX_VALUE.
//                                                                                                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/UInt#Companion#getMAX_VALUE().
//                                                                                                                                       ⌃ enclosing_range_end local 70
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uinteger().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#long().
      /** Creates a numeric column, with the specified [name], for storing 8-byte integers.
       * An optional [checkConstraintName] can be passed to allow customizing the check constraint name when needed.
       */
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#long().(name)
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#long().(checkConstraintName)
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
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#long().(name)
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#long().(checkConstraintName)
//                                                                                                 ⌄ enclosing_range_start local 71
          check(checkConstraintName ?: "${generatedSignedCheckPrefix}long_${this.unquotedName()}") { it.between(Long.MIN_VALUE, Long.MAX_VALUE) }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#long().(checkConstraintName)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#generatedSignedCheckPrefix.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getGeneratedSignedCheckPrefix().
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//                                                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 71
//                                                                                                                                                display_name it
//                                                                                                                                                documentation ```kotlin\nit: Column<Long>\n```
//                                                                                                   ^^ reference local 71
//                                                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
//                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Long#Companion#MIN_VALUE.
//                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Long#Companion#getMIN_VALUE().
//                                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Long#Companion#MAX_VALUE.
//                                                                                                                                   ^^^^^^^^^ reference semanticdb maven . . kotlin/Long#Companion#getMAX_VALUE().
//                                                                                                                                              ⌃ enclosing_range_end local 71
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#long().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ulong().
      /** Creates a numeric column, with the specified [name], for storing 8-byte unsigned integers.
       *
       * **Note:** For PostgreSQL, the maximum value this column will store is [Long.MAX_VALUE].
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ulong().(name)
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
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ulong().(name)
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#ulong().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#float().
      /** Creates a numeric column, with the specified [name], for storing 4-byte (single precision) floating-point numbers. */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#float().(name)
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
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#float().(name)
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#float().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#double().
      /** Creates a numeric column, with the specified [name], for storing 8-byte (double precision) floating-point numbers. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#double().(name)
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
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#double().(name)
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#double().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().
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
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().(name)
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().(precision)
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().(scale)
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
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().(name)
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().(precision)
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().(scale)
          name,
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().(name)
          DecimalColumnType(precision, scale)
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().(precision)
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().(scale)
      )
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#decimal().
  
      // Character columns
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char().
      /** Creates a character column, with the specified [name], for storing single characters. */
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char().(name)
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
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char().(name)
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).
      /**
       * Creates a character column, with the specified [name], for storing strings with the specified [length] using the specified text [collate] type.
       * If no collate type is specified then the database default is used.
       */
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).(name)
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).(length)
//                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).(collate)
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
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).(name)
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).(length)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).(collate)
          name,
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).(name)
          CharColumnType(length, collate)
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharColumnType#`<init>`().
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).(length)
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).(collate)
      )
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#char(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().
      /**
       * Creates a character column, with the specified [name], for storing strings with the specified maximum [length] using the specified text [collate] type.
       * If no collate type is specified then the database default is used.
       */
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().(name)
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().(length)
//                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().(collate)
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
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().(name)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().(length)
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().(collate)
          name,
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().(name)
          VarCharColumnType(length, collate)
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarCharColumnType#`<init>`().
//                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().(length)
//                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().(collate)
      )
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#varchar().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().
      /**
       * Creates a character column, with the specified [name], for storing strings of arbitrary length using the specified [collate] type.
       * If no collated type is specified, then the database default is used.
       *
       * Some database drivers do not load text content immediately (for performance and memory reasons),
       * which means that you can obtain column value only within the open transaction.
       * If you desire to make content available outside the transaction use [eagerLoading] param.
       */
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().(name)
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().(collate)
//                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().(eagerLoading)
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
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().(name)
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().(collate)
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().(eagerLoading)
          registerColumn(name, TextColumnType(collate, eagerLoading))
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().(name)
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
//                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().(collate)
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().(eagerLoading)
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#text().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().
      /**
       * Creates a character column, with the specified [name], for storing strings of _medium_ length using the specified [collate] type.
       * If no collated type is specified, then the database default is used.
       *
       * Some database drivers do not load text content immediately (for performance and memory reasons),
       * which means that you can obtain column value only within the open transaction.
       * If you desire to make content available outside the transaction use [eagerLoading] param.
       */
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().(name)
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().(collate)
//                                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().(eagerLoading)
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
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().(name)
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().(collate)
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().(eagerLoading)
          registerColumn(name, MediumTextColumnType(collate, eagerLoading))
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().(name)
//                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/MediumTextColumnType#`<init>`().
//                                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().(collate)
//                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().(eagerLoading)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mediumText().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().
      /**
       * Creates a character column, with the specified [name], for storing strings of _large_ length using the specified [collate] type.
       * If no collated type is specified, then the database default is used.
       *
       * Some database drivers do not load text content immediately (for performance and memory reasons),
       * which means that you can obtain column value only within the open transaction.
       * If you desire to make content available outside the transaction use [eagerLoading] param.
       */
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().(name)
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().(collate)
//                                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().(eagerLoading)
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
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().(name)
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().(collate)
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().(eagerLoading)
          registerColumn(name, LargeTextColumnType(collate, eagerLoading))
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().(name)
//                             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LargeTextColumnType#`<init>`().
//                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().(collate)
//                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().(eagerLoading)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#largeText().
  
      // Binary columns
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary().
      /**
       * Creates a binary column, with the specified [name], for storing byte arrays of arbitrary size.
       *
       * **Note:** This function is only supported by SQLite, PostgreSQL, and H2 dialects.
       * For the rest, please specify a length.
       * For H2 dialects, the maximum size is 1,000,000,000 bytes.
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.DDLTests.testBinaryWithoutLength
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary().(name)
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
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary().(name)
//                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary(+1).
      /**
       * Creates a binary column, with the specified [name], for storing byte arrays with the specified maximum [length].
       *
       * **Note:** The length of the binary column is not required in PostgreSQL and will be ignored.
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.DDLTests.testBinary
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary(+1).(name)
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary(+1).(length)
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
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary(+1).(name)
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary(+1).(length)
//                                                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#binary(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#blob().
      /**
       * Creates a binary column, with the specified [name], for storing BLOBs.
       * If [useObjectIdentifier] is `true`, then the column will use the `OID` type on PostgreSQL
       * for storing large binary objects. The parameter must not be `true` for other databases.
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.types.BlobColumnTypeTests.testBlob
       */
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#blob().(name)
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#blob().(useObjectIdentifier)
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
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#blob().(name)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#blob().(useObjectIdentifier)
          registerColumn(name, BlobColumnType(useObjectIdentifier))
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#blob().(name)
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BlobColumnType#`<init>`().
//                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#blob().(useObjectIdentifier)
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#blob().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uuid().
      /** Creates a binary column, with the specified [name], for storing UUIDs. */
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uuid().(name)
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
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uuid().(name)
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uuid().
  
      // Boolean columns
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#bool().
      /** Creates a column, with the specified [name], for storing boolean values. */
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#bool().(name)
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
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#bool().(name)
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#bool().
  
      // Enumeration columns
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().
      /** Creates an enumeration column, with the specified [name], for storing enums of type [klass] by their ordinal. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().(name)
//                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().(klass)
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
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().[T]
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().(name)
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().(klass)
          name,
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().(name)
          EnumerationColumnType(klass)
//        ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationColumnType#`<init>`().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().(klass)
      )
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration(+1).
      /** Creates an enumeration column, with the specified [name], for storing enums of type [T] by their ordinal. */
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration(+1).[T]
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration(+1).(name)
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
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration(+1).[T]
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration(+1).(name)
//                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumeration(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().
      /**
       * Creates an enumeration column, with the specified [name], for storing enums of type [klass] by their name.
       * With the specified maximum [length] for each name value.
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().[T]
//                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().(name)
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().(length)
//                                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().(klass)
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
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().[T]
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().(name)
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().(length)
//                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().(klass)
          registerColumn(name, EnumerationNameColumnType(klass, length))
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().(name)
//                             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EnumerationNameColumnType#`<init>`().
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().(klass)
//                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().(length)
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).
      /**
       * Creates an enumeration column, with the specified [name], for storing enums of type [T] by their name.
       * With the specified maximum [length] for each name value.
       */
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).[T]
//                                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).(name)
//                                                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).(length)
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
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).[T]
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).(name)
//                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).(length)
          enumerationByName(name, length, T::class)
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName().
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).(name)
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).(length)
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#enumerationByName(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().[T]
      fun <T : Enum<T>> customEnumeration(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Enum<T>\n```
//                      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().
//                                        display_name customEnumeration
//                                        documentation ```kotlin\npublic final fun <T : Enum<T>> customEnumeration(name: String, sql: String? = ..., fromDb: (Any) -> T, toDb: (T) -> Any): Column<T>\n```\n\n----\n\n\n Creates an enumeration column, with the custom SQL type [sql], for storing enums of type [T] using this database-specific type.\n\n See [Wiki](https://github.com/JetBrains/Exposed/wiki/DataTypes#how-to-use-database-enum-types) for more details.\n\n @param name Name of the column\n @param sql SQL definition for the column\n @param fromDb Function that converts a value received from a database to an enumeration instance [T]\n @param toDb Function that converts an enumeration instance [T] to a value that will be stored to a database\n
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(name)
          name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(name)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(sql)
          sql: String? = null,
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(sql)
//            display_name sql
//            documentation ```kotlin\nsql: String? = ...\n```
//             ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(sql)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(fromDb)
          fromDb: (Any) -> T,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(fromDb)
//               display_name fromDb
//               documentation ```kotlin\nfromDb: (Any) -> T\n```
//                ^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(fromDb)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(toDb)
          toDb: (T) -> Any
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(toDb)
//             display_name toDb
//             documentation ```kotlin\ntoDb: (T) -> Any\n```
//              ^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(toDb)
      ): Column<T> = registerColumn(name, CustomEnumerationColumnType(name, sql, fromDb, toDb))
//       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(name)
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomEnumerationColumnType#`<init>`().
//                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(name)
//                                                                          ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(sql)
//                                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(fromDb)
//                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().(toDb)
//                                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#customEnumeration().
  
      // Array columns
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().[E]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().(name)
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().(columnType)
//                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().(maximumCardinality)
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
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().[E]
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().(name)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().(columnType)
//                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().(maximumCardinality)
//                                                                                                         ⌄ enclosing_range_start local 72
          array<E, List<E>>(name, columnType, dimensions = 1, maximumCardinality = maximumCardinality?.let { listOf(it) })
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().(name)
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().(columnType)
//                                                                                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().(maximumCardinality)
//                                                                                                     ^^^ reference semanticdb maven . . kotlin/let().
//                                                                                                         ^^^^^^^^^^^^^^ definition local 72
//                                                                                                                        display_name it
//                                                                                                                        documentation ```kotlin\nit: Int\n```
//                                                                                                           ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                                                                                  ^^ reference local 72
//                                                                                                                      ⌃ enclosing_range_end local 72
//                                                                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).
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
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).[E]
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).(name)
//                                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).(maximumCardinality)
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
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).[E]
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).(name)
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).(maximumCardinality)
//                                                        ⌄ enclosing_range_start local 73
          array<E, List<E>>(name, maximumCardinality?.let { listOf(it) }, dimensions = 1)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).(name)
//                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).(maximumCardinality)
//                                                    ^^^ reference semanticdb maven . . kotlin/let().
//                                                        ^^^^^^^^^^^^^^ definition local 73
//                                                                       display_name it
//                                                                       documentation ```kotlin\nit: Int\n```
//                                                          ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                                 ^^ reference local 73
//                                                                     ⌃ enclosing_range_end local 73
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).
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
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).[T]
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).[R]
//                                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).(name)
//                                                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).(maximumCardinality)
//                                                                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).(dimensions)
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
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).[T]
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).[R]
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).(name)
//                                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).(maximumCardinality)
//                                                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).(dimensions)
          @OptIn(InternalApi::class)
          return array(name, resolveColumnType(T::class), maximumCardinality, dimensions)
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).
//                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).(name)
//                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/resolveColumnType().
//                                                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).(maximumCardinality)
//                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).(dimensions)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).[E]
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).[R]
//                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(name)
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(columnType)
//                                                                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(maximumCardinality)
//                                                                                                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(dimensions)
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
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).[E]
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).[R]
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(name)
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(columnType)
//                                                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(maximumCardinality)
//                                                                                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(dimensions)
          registerColumn(name, ArrayColumnType(columnType, maximumCardinality, dimensions))
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#registerColumn().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(name)
//                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#`<init>`().
//                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(columnType)
//                                                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(maximumCardinality)
//                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).(dimensions)
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#array(+3).
  
      // Auto-generated values
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement().
      /**
       * Make @receiver column an auto-increment column to generate its values in a database.
       * **Note:** Only integer and long columns are supported (signed and unsigned types).
       * Some databases, like PostgreSQL, support auto-increment via sequences.
       * In this case a name should be provided using the [idSeqName] param and Exposed will create a sequence.
       * If a sequence already exists in the database just use its name in [idSeqName].
       *
       * @param idSeqName an optional parameter to provide a sequence name
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement().[N]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement().(idSeqName)
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
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement().[N]
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement().(idSeqName)
//                                         ⌄ enclosing_range_start local 74
          cloneWithAutoInc(idSeqName).also { replaceColumn(this, it) }
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc().
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement().(idSeqName)
//                                    ^^^^ reference semanticdb maven . . kotlin/also().
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 74
//                                                                     display_name it
//                                                                     documentation ```kotlin\nit: Column<N>\n```
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                                               ^^ reference local 74
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement().
//                                                                   ⌃ enclosing_range_end local 74
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement(+1).
      /**
       * Make @receiver column an auto-increment column to generate its values in a database.
       * **Note:** Only integer and long columns are supported (signed and unsigned types).
       * Some databases, like PostgreSQL, support auto-increment via sequences.
       * In this case, a sequence should be provided using the [sequence] param.
       *
       * @param sequence a parameter to provide a sequence
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement(+1).[N]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement(+1).(sequence)
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
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement(+1).[N]
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement(+1).(sequence)
//                                        ⌄ enclosing_range_start local 75
          cloneWithAutoInc(sequence).also { replaceColumn(this, it) }
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc(+1).
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement(+1).(sequence)
//                                   ^^^^ reference semanticdb maven . . kotlin/also().
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 75
//                                                                    display_name it
//                                                                    documentation ```kotlin\nit: Column<N>\n```
//                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                                              ^^ reference local 75
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncrement(+1).
//                                                                  ⌃ enclosing_range_end local 75
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoinc().
      @Deprecated(
          message = "This function will be removed in future releases.",
          replaceWith = ReplaceWith("autoIncrement(idSeqName)"),
//                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/ReplaceWith#`<init>`().
          level = DeprecationLevel.WARNING
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#WARNING.
      )
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoinc().[N]
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoinc().(idSeqName)
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
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoinc().[N]
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoinc().(idSeqName)
//                                         ⌄ enclosing_range_start local 76
          cloneWithAutoInc(idSeqName).also { replaceColumn(this, it) }
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc().
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoinc().(idSeqName)
//                                    ^^^^ reference semanticdb maven . . kotlin/also().
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 76
//                                                                     display_name it
//                                                                     documentation ```kotlin\nit: Column<EntityID<N>>\n```
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                                               ^^ reference local 76
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoinc().
//                                                                   ⌃ enclosing_range_end local 76
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default().
      /** Sets the default value for this column in the database side. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default().[T]
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default().(defaultValue)
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
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default().[T]
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default().(defaultValue)
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default(+1).
      /** Sets the default value for this column in the database side. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default(+1).[T]
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default(+1).(defaultValue)
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
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default(+1).[T]
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default(+1).(defaultValue)
          with(this@Table) {
//        ^^^^ reference semanticdb maven . . kotlin/with().
//                                                                        ⌄ enclosing_range_start local 77
              this@default.getRealColumnsWithValues(defaultValue).forEach {
//                         ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumnsWithValues().
//                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default(+1).(defaultValue)
//                                                                ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                                                                        ^ definition local 77 2:13
//                                                                          display_name it
//                                                                          documentation ```kotlin\nit: Map.Entry<Column<*>, Any?>\n```
                  (it.key as Column<Any>).default(it.value as Any)
//                 ^^ reference local 77
//                    ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getKey().
//                    ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#key.
//                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default().
//                                                ^^ reference local 77
//                                                   ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getValue().
//                                                   ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#value.
//                                                            ^^^ reference semanticdb maven . . kotlin/Any#
              }
//            ⌃ enclosing_range_end local 77
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#default(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#defaultExpression().
      /** Sets the default value for this column in the database side. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#defaultExpression().[T]
//                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#defaultExpression().(defaultValue)
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
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#defaultExpression().[T]
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#defaultExpression().(defaultValue)
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#defaultExpression().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clientDefault().
      /** Sets the default value for this column in the client side. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clientDefault().[T]
//                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clientDefault().(defaultValue)
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
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clientDefault().[T]
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clientDefault().(defaultValue)
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clientDefault().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#databaseGenerated().
      /**
       * Marks a column as `databaseGenerated` if the default value of the column is not known at the time of table creation
       * and/or if it depends on other columns. It makes it possible to omit setting it when inserting a new record,
       * without getting an error.
       * The value for the column can be set by creating a TRIGGER or with a DEFAULT clause or
       * by using GENERATED ALWAYS AS via [Column.withDefinition], for example.
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#databaseGenerated().[T]
      fun <T> Column<T>.databaseGenerated(): Column<T> = apply {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#databaseGenerated().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#databaseGenerated().
//                                        display_name databaseGenerated
//                                        documentation ```kotlin\npublic final fun <T> Column<T>.databaseGenerated(): Column<T>\n```\n\n----\n\n\n Marks a column as `databaseGenerated` if the default value of the column is not known at the time of table creation\n and/or if it depends on other columns. It makes it possible to omit setting it when inserting a new record,\n without getting an error.\n The value for the column can be set by creating a TRIGGER or with a DEFAULT clause or\n by using GENERATED ALWAYS AS via [Column.withDefinition], for example.\n
//                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                       ^^^^^ reference semanticdb maven . . kotlin/apply().
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#databaseGenerated().[T]
          isDatabaseGenerated = true
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#databaseGenerated().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoGenerate().
      /** UUID column will auto generate its value on a client side just before an insert. */
      fun Column<UUID>.autoGenerate(): Column<UUID> = clientDefault { UUID.randomUUID() }
//                     ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoGenerate().
//                                  display_name autoGenerate
//                                  documentation ```kotlin\npublic final fun Column<UUID>.autoGenerate(): Column<UUID>\n```\n\n----\n\n UUID column will auto generate its value on a client side just before an insert.
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clientDefault().
//                                                                         ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/UUID#randomUUID().
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoGenerate().
  
      // Column references
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().
      /**
       * Creates a reference from this @receiver column to a [ref] column.
       *
       * This is a short infix version of `references()` with default `onDelete` and `onUpdate` behavior.
       *
       * @receiver A column from the current table where reference values will be stored.
       * @param ref A column from another table which will be used as a "parent".
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.JoinTests.testJoin04
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().[S]
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().[C]
//                                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().(ref)
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
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().[T]
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().[S]
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().[C]
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().(ref)
          ref,
//        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().(ref)
          null,
          null,
          null
      )
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).[T]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).[S]
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).[C]
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
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).[T]
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).[S]
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).[C]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(ref)
          ref: Column<T>,
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(ref)
//            display_name ref
//            documentation ```kotlin\nref: Column<T>\n```
//             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(ref)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(onDelete)
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(onDelete)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(onUpdate)
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(onUpdate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(fkName)
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).(fkName)
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).[T]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).[S]
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).[C]
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
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).[T]
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).[S]
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).[C]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(ref)
          ref: Column<EntityID<T>>,
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(ref)
//            display_name ref
//            documentation ```kotlin\nref: Column<EntityID<T>>\n```
//             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(ref)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(onDelete)
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(onDelete)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(onUpdate)
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(onUpdate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(fkName)
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).(fkName)
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().[T]
      fun <T : Any> reference(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().
//                            display_name reference
//                            documentation ```kotlin\npublic final fun <T : Any> reference(name: String, refColumn: Column<T>, onDelete: ReferenceOption? = ..., onUpdate: ReferenceOption? = ..., fkName: String? = ...): Column<T>\n```\n\n----\n\n\n Creates a column with the specified [name] with a reference to the [refColumn] column and with [onDelete],\n [onUpdate], and [fkName] options.\n [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting\n or changing corresponding columns' values.\n Such a relationship will be represented as a FOREIGN KEY constraint on table creation.\n\n @param name Name of the column.\n @param refColumn A column from another table which will be used as a "parent".\n @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.\n @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.\n @param fkName Optional foreign key constraint name.\n @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Orders\n
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(name)
          name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(name)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(refColumn)
          refColumn: Column<T>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(refColumn)
//                  display_name refColumn
//                  documentation ```kotlin\nrefColumn: Column<T>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(refColumn)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(onDelete)
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(onDelete)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(onUpdate)
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(onUpdate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(fkName)
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().(fkName)
      ): Column<T> {
//       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//        ⌄ enclosing_range_start local 78
          val column = Column(
//            ^^^^^^ definition local 78
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
//                                                          ⌃ enclosing_range_end local 78
          _columns.addColumn(column)
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#_columns.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#get_columns().
//                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#addColumn().
//                           ^^^^^^ reference local 78
          return column
//               ^^^^^^ reference local 78
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).[T]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).[E]
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
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).[T]
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(name)
          name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(name)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(refColumn)
          refColumn: Column<E>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(refColumn)
//                  display_name refColumn
//                  documentation ```kotlin\nrefColumn: Column<E>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(refColumn)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(onDelete)
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(onDelete)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(onUpdate)
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(onUpdate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(fkName)
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(fkName)
      ): Column<E> {
//       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//        ⌄ enclosing_range_start local 79
          val entityIDColumn = entityId(name, (refColumn.columnType as EntityIDColumnType<T>).idColumn) as Column<E>
//            ^^^^^^^^^^^^^^ definition local 79
//                           display_name entityIDColumn
//                           documentation ```kotlin\nlocal val entityIDColumn: Column<E>\n```
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#entityId(+1).
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(name)
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(refColumn)
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                     ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#
//                                                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                                                 ⌃ enclosing_range_end local 79
          return entityIDColumn.references(refColumn, onDelete, onUpdate, fkName)
//               ^^^^^^^^^^^^^^ reference local 79
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#references(+1).
//                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(refColumn)
//                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(onDelete)
//                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(onUpdate)
//                                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).(fkName)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).[T]
      fun <T : Any> reference(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).
//                            display_name reference
//                            documentation ```kotlin\npublic final fun <T : Any> reference(name: String, foreign: IdTable<T>, onDelete: ReferenceOption? = ..., onUpdate: ReferenceOption? = ..., fkName: String? = ...): Column<EntityID<T>>\n```\n\n----\n\n\n Creates a column with the specified [name] with a reference to the `id` column in [foreign] table and with\n [onDelete], [onUpdate], and [fkName] options.\n [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting\n or changing corresponding columns' values.\n Such a relationship will be represented as a FOREIGN KEY constraint on table creation.\n\n @param name Name of the column.\n @param foreign A table with an `id` column which will be used as a "parent".\n @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.\n @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.\n @param fkName Optional foreign key constraint name.\n @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Schools\n
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(name)
          name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(name)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(foreign)
          foreign: IdTable<T>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(foreign)
//                display_name foreign
//                documentation ```kotlin\nforeign: IdTable<T>\n```
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(foreign)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(onDelete)
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(onDelete)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(onUpdate)
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(onUpdate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(fkName)
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(fkName)
      ): Column<EntityID<T>> {
//       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          require(foreign !is CompositeIdTable || foreign.idColumns.size == 1) {
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).(foreign)
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().[T]
      fun <T : Any> optReference(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().
//                               display_name optReference
//                               documentation ```kotlin\npublic final fun <T : Any> optReference(name: String, refColumn: Column<T>, onDelete: ReferenceOption? = ..., onUpdate: ReferenceOption? = ..., fkName: String? = ...): Column<T?>\n```\n\n----\n\n\n Creates a column with the specified [name] with an optional reference to the [refColumn] column with [onDelete], [onUpdate], and [fkName] options.\n [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting\n or changing corresponding columns' values.\n Such a relationship will be represented as a FOREIGN KEY constraint on table creation.\n\n @param name Name of the column.\n @param refColumn A column from another table which will be used as a "parent".\n @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.\n @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.\n @param fkName Optional foreign key constraint name.\n @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Posts\n
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(name)
          name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(name)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(refColumn)
          refColumn: Column<T>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(refColumn)
//                  display_name refColumn
//                  documentation ```kotlin\nrefColumn: Column<T>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(refColumn)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(onDelete)
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(onDelete)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(onUpdate)
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(onUpdate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(fkName)
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(fkName)
      ): Column<T?> = reference(name, refColumn, onDelete, onUpdate, fkName).nullable()
//       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference().
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(name)
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(refColumn)
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(onDelete)
//                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(onUpdate)
//                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().(fkName)
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).[T]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).[E]
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
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).[T]
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(name)
          name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(name)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(refColumn)
          refColumn: Column<E>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(refColumn)
//                  display_name refColumn
//                  documentation ```kotlin\nrefColumn: Column<E>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(refColumn)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(onDelete)
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(onDelete)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(onUpdate)
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(onUpdate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(fkName)
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(fkName)
      ): Column<E?> = reference(name, refColumn, onDelete, onUpdate, fkName).nullable()
//       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+1).
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(name)
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(refColumn)
//                                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(onDelete)
//                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(onUpdate)
//                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).(fkName)
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).[T]
      fun <T : Any> optReference(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).
//                               display_name optReference
//                               documentation ```kotlin\npublic final fun <T : Any> optReference(name: String, foreign: IdTable<T>, onDelete: ReferenceOption? = ..., onUpdate: ReferenceOption? = ..., fkName: String? = ...): Column<EntityID<T>?>\n```\n\n----\n\n\n Creates a column with the specified [name] with an optional reference to the `id` column in [foreign] table with [onDelete], [onUpdate], and [fkName] options.\n [onDelete] and [onUpdate] options describe the behavior for how links between tables will be checked when deleting\n or changing corresponding columns' values.\n Such a relationship will be represented as a FOREIGN KEY constraint on table creation.\n\n @param name Name of the column.\n @param foreign A table with an `id` column which will be used as a "parent".\n @param onDelete Optional [ReferenceOption] for cases when a linked row from a parent table will be deleted.\n @param onUpdate Optional [ReferenceOption] for cases when a value in a referenced column will be changed.\n @param fkName Optional foreign key constraint name.\n @sample org.jetbrains.exposed.v1.tests.shared.entities.EntityTests.Schools\n
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(name)
          name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(name)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(foreign)
          foreign: IdTable<T>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(foreign)
//                display_name foreign
//                documentation ```kotlin\nforeign: IdTable<T>\n```
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(foreign)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(onDelete)
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(onDelete)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(onUpdate)
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(onUpdate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(fkName)
          fkName: String? = null
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(fkName)
//               display_name fkName
//               documentation ```kotlin\nfkName: String? = ...\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(fkName)
      ): Column<EntityID<T>?> = reference(name, foreign, onDelete, onUpdate, fkName).nullable()
//       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#reference(+2).
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(name)
//                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(foreign)
//                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(onDelete)
//                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(onUpdate)
//                                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).(fkName)
//                                                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().
//                                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#optReference(+2).
  
      // Miscellaneous
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().
      /** Marks this column as nullable. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().[T]
      fun <T : Any> Column<T>.nullable(): Column<T?> {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                            ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().
//                                     display_name nullable
//                                     documentation ```kotlin\npublic final fun <T : Any> Column<T>.nullable(): Column<T?>\n```\n\n----\n\n Marks this column as nullable.
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().[T]
//        ⌄ enclosing_range_start local 80
          val newColumn = Column<T?>(table, name, columnType)
//            ^^^^^^^^^ definition local 80
//                      display_name newColumn
//                      documentation ```kotlin\nlocal val newColumn: Column<T?>\n```
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#`<init>`().
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                          ⌃ enclosing_range_end local 80
          newColumn.foreignKey = foreignKey
//        ^^^^^^^^^ reference local 80
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
          newColumn.defaultValueFun = defaultValueFun
//        ^^^^^^^^^ reference local 80
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
          @Suppress("UNCHECKED_CAST")
          newColumn.dbDefaultValue = dbDefaultValue as Expression<T?>?
//        ^^^^^^^^^ reference local 80
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
          newColumn.isDatabaseGenerated = isDatabaseGenerated
//        ^^^^^^^^^ reference local 80
//                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
//                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsDatabaseGenerated().
//                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isDatabaseGenerated.
//                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setIsDatabaseGenerated().
          newColumn.columnType.nullable = true
//        ^^^^^^^^^ reference local 80
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
          newColumn.extraDefinitions = extraDefinitions
//        ^^^^^^^^^ reference local 80
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
          return replaceColumn(this, newColumn)
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                   ^^^^^^^^^ reference local 80
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable(+1).
      /** Marks this [CompositeColumn] as nullable. */
      @Suppress("UNCHECKED_CAST")
      @LowPriorityInOverloadResolution
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable(+1).[T]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable(+1).[C]
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
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable(+1).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable(+1).[C]
          nullable = true
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getNullable().
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#nullable.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#setNullable().
//                                ⌄ enclosing_range_start local 81
//                                                                    ⌄ enclosing_range_start local 82
          getRealColumns().filter { !it.columnType.nullable }.forEach { (it as Column<Any>).nullable() }
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumns().
//                         ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 81
//                                                            display_name it
//                                                            documentation ```kotlin\nit: Column<*>\n```
//                                  ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                   ^^ reference local 81
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
//                                                            ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 82
//                                                                                                       display_name it
//                                                                                                       documentation ```kotlin\nit: Column<*>\n```
//                                                                       ^^ reference local 82
//                                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable().
//                                                          ⌃ enclosing_range_end local 81
//                                                                                                     ⌃ enclosing_range_end local 82
      } as CompositeColumn<T?>
//         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullable(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#withDefinition().
      /**
       * Appends a database-specific column [definition] to this column's SQL in a CREATE TABLE statement.
       *
       * The specified [definition] is appended after the column's name, type, and default value (if any),
       * but before any column constraint definitions. If multiple definition arguments are passed, they
       * will be joined as string representations separated by a single space character.
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#withDefinition().[T]
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#withDefinition().(definition)
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
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#withDefinition().[T]
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#withDefinition().(definition)
          extraDefinitions.addAll(definition)
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#extraDefinitions.
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getExtraDefinitions().
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setExtraDefinitions().
//                         ^^^^^^ reference semanticdb maven . . kotlin/collections/addAll(+2).
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#withDefinition().(definition)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#withDefinition().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().[Unwrapped]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().[Wrapped]
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
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().[Unwrapped]
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().[Wrapped]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().(wrap)
          wrap: (Unwrapped) -> Wrapped,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().(wrap)
//             display_name wrap
//             documentation ```kotlin\nwrap: (Unwrapped) -> Wrapped\n```
//              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().(wrap)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().(unwrap)
          unwrap: (Wrapped) -> Unwrapped
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().(unwrap)
//               display_name unwrap
//               documentation ```kotlin\nunwrap: (Wrapped) -> Unwrapped\n```
//                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().(unwrap)
      ): Column<Wrapped> = transform(columnTransformer(unwrap, wrap))
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).
//                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/columnTransformer().
//                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().(unwrap)
//                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().(wrap)
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).[Unwrapped]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).[Wrapped]
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
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).[Unwrapped]
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).[Wrapped]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).(transformer)
          transformer: ColumnTransformer<Unwrapped, Wrapped>
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).(transformer)
//                    display_name transformer
//                    documentation ```kotlin\ntransformer: ColumnTransformer<Unwrapped, Wrapped>\n```
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).(transformer)
      ): Column<Wrapped> {
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//        ⌄ enclosing_range_start local 83
          val newColumn = copyWithAnotherColumnType(ColumnWithTransform(this.columnType, transformer)) {
//            ^^^^^^^^^ definition local 83
//                      display_name newColumn
//                      documentation ```kotlin\nlocal val newColumn: Column<Wrapped>\n```
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().
//                                                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#`<init>`().
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).(transformer)
//                                                                  ⌄ enclosing_range_start local 84
              defaultValueFun = this@transform.defaultValueFun?.let { { transformer.wrap(it()) } }
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                              ^^^ reference semanticdb maven . . kotlin/let().
//                                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 84
//                                                                                                 display_name it
//                                                                                                 documentation ```kotlin\nit: () -> Unwrapped\n```
//                                                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).(transformer)
//                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#wrap().
//                                                                                       ^^ reference local 84
//                                                                                       ^^ reference semanticdb maven . . kotlin/Function0#invoke().
//                                                                                               ⌃ enclosing_range_end local 84
          }
//        ⌃ enclosing_range_end local 83
          return replaceColumn(this, newColumn)
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                   ^^^^^^^^^ reference local 83
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).[Unwrapped]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).[Wrapped]
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
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).[Unwrapped]
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).[Wrapped]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).(wrap)
          wrap: (Unwrapped?) -> Wrapped?,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).(wrap)
//             display_name wrap
//             documentation ```kotlin\nwrap: (Unwrapped?) -> Wrapped?\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).(wrap)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).(unwrap)
          unwrap: (Wrapped?) -> Unwrapped?
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).(unwrap)
//               display_name unwrap
//               documentation ```kotlin\nunwrap: (Wrapped?) -> Unwrapped?\n```
//                ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).(unwrap)
      ): Column<Wrapped?> = transform(columnTransformer(unwrap, wrap))
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).
//                                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/columnTransformer().
//                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).(unwrap)
//                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).(wrap)
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).[Unwrapped]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).[Wrapped]
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
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).[Unwrapped]
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).[Wrapped]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).(transformer)
          transformer: ColumnTransformer<Unwrapped?, Wrapped?>
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).(transformer)
//                    display_name transformer
//                    documentation ```kotlin\ntransformer: ColumnTransformer<Unwrapped?, Wrapped?>\n```
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).(transformer)
      ): Column<Wrapped?> {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//        ⌄ enclosing_range_start local 85
          val newColumn = copyWithAnotherColumnType<Wrapped?>(NullableColumnWithTransform(this.columnType, transformer)) {
//            ^^^^^^^^^ definition local 85
//                      display_name newColumn
//                      documentation ```kotlin\nlocal val newColumn: Column<Wrapped?>\n```
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#`<init>`().
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).(transformer)
//                                                                  ⌄ enclosing_range_start local 86
//                                                                                  ⌄ enclosing_range_start local 87
              defaultValueFun = this@transform.defaultValueFun?.let { { it()?.let { value -> transformer.wrap(value) } } }
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                              ^^^ reference semanticdb maven . . kotlin/let().
//                                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 86
//                                                                                                                         display_name it
//                                                                                                                         documentation ```kotlin\nit: () -> Unwrapped?\n```
//                                                                      ^^ reference local 86
//                                                                      ^^ reference semanticdb maven . . kotlin/Function0#invoke().
//                                                                            ^^^ reference semanticdb maven . . kotlin/let().
//                                                                                  ^^^^^ definition local 87
//                                                                                        display_name value
//                                                                                        documentation ```kotlin\nvalue: Unwrapped\n```
//                                                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).(transformer)
//                                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#wrap().
//                                                                                                            ^^^^^ reference local 87
//                                                                                      ⌃ enclosing_range_end local 87
//                                                                                                                       ⌃ enclosing_range_end local 86
          }
//        ⌃ enclosing_range_end local 85
          return replaceColumn(this, newColumn)
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                   ^^^^^^^^^ reference local 85
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#transform(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().[Unwrapped]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().[Wrapped]
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
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().[Unwrapped]
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().[Wrapped]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().(wrap)
          wrap: (Unwrapped) -> Wrapped?,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().(wrap)
//             display_name wrap
//             documentation ```kotlin\nwrap: (Unwrapped) -> Wrapped?\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().(wrap)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().(unwrap)
          unwrap: (Wrapped?) -> Unwrapped
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().(unwrap)
//               display_name unwrap
//               documentation ```kotlin\nunwrap: (Wrapped?) -> Unwrapped\n```
//                ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().(unwrap)
      ): Column<Wrapped?> = nullTransform(columnTransformer(unwrap, wrap))
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).
//                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/columnTransformer().
//                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().(unwrap)
//                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().(wrap)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).
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
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).[Unwrapped]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).[Wrapped]
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
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).[Unwrapped]
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).[Wrapped]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).(transformer)
          transformer: ColumnTransformer<Unwrapped, Wrapped?>
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).(transformer)
//                    display_name transformer
//                    documentation ```kotlin\ntransformer: ColumnTransformer<Unwrapped, Wrapped?>\n```
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).(transformer)
      ): Column<Wrapped?> {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//        ⌄ enclosing_range_start local 88
          val newColumn = copyWithAnotherColumnType<Wrapped?>(NullableColumnWithTransform(this.columnType, transformer)) {
//            ^^^^^^^^^ definition local 88
//                      display_name newColumn
//                      documentation ```kotlin\nlocal val newColumn: Column<Wrapped?>\n```
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#copyWithAnotherColumnType().
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#`<init>`().
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).(transformer)
//                                                                      ⌄ enclosing_range_start local 89
//                                                                                     ⌄ enclosing_range_start local 90
              defaultValueFun = this@nullTransform.defaultValueFun?.let { { it().let { value -> transformer.wrap(value) } } }
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                                  ^^^ reference semanticdb maven . . kotlin/let().
//                                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 89
//                                                                                                                            display_name it
//                                                                                                                            documentation ```kotlin\nit: () -> Unwrapped\n```
//                                                                          ^^ reference local 89
//                                                                          ^^ reference semanticdb maven . . kotlin/Function0#invoke().
//                                                                               ^^^ reference semanticdb maven . . kotlin/let().
//                                                                                     ^^^^^ definition local 90
//                                                                                           display_name value
//                                                                                           documentation ```kotlin\nvalue: Unwrapped\n```
//                                                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).(transformer)
//                                                                                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnTransformer#wrap().
//                                                                                                               ^^^^^ reference local 90
//                                                                                         ⌃ enclosing_range_end local 90
//                                                                                                                          ⌃ enclosing_range_end local 89
          }
//        ⌃ enclosing_range_end local 88
          return replaceColumn(this, newColumn)
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#replaceColumn().
//                                   ^^^^^^^^^ reference local 88
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nullTransform(+1).
  
      // Indices
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index().
      /**
       * Creates an index.
       *
       * @param isUnique Whether the index is unique or not.
       * @param columns Columns that compose the index.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index().(isUnique)
//                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index().(columns)
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
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index().(isUnique)
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index().(columns)
          index(null, isUnique, *columns)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index().(isUnique)
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index().(columns)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).
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
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(customIndexName)
          customIndexName: String? = null,
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(customIndexName)
//                        display_name customIndexName
//                        documentation ```kotlin\ncustomIndexName: String? = ...\n```
//                         ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(customIndexName)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(isUnique)
          isUnique: Boolean = false,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(isUnique)
//                 display_name isUnique
//                 documentation ```kotlin\nisUnique: Boolean = ...\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(isUnique)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(columns)
          vararg columns: Column<*>,
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(columns)
//                       display_name columns
//                       documentation ```kotlin\nvararg columns: Column<*>\n```
//                        ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(columns)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(functions)
          functions: List<ExpressionWithColumnType<*>>? = null,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(functions)
//                  display_name functions
//                  documentation ```kotlin\nfunctions: List<ExpressionWithColumnType<*>>? = ...\n```
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(functions)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(indexType)
          indexType: String? = null,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(indexType)
//                  display_name indexType
//                  documentation ```kotlin\nindexType: String? = ...\n```
//                   ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(indexType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(filterCondition)
          filterCondition: FilterCondition = null
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(filterCondition)
//                        display_name filterCondition
//                        documentation ```kotlin\nfilterCondition: {org/jetbrains/exposed/v1/core/FilterCondition=} (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(filterCondition)
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
//                               ⌄ enclosing_range_start local 91
                  functions?.let { this }
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).(functions)
//                           ^^^ reference semanticdb maven . . kotlin/let().
//                               ^^^^^^^^ definition local 91
//                                        display_name it
//                                        documentation ```kotlin\nit: List<ExpressionWithColumnType<*>>\n```
//                                      ⌃ enclosing_range_end local 91
              )
          )
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).
      /**
       * Creates an index composed by this column only.
       *
       * @param customIndexName Name of the index.
       * @param isUnique Whether the index is unique or not.
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).(customIndexName)
//                                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).(isUnique)
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
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).[T]
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).(customIndexName)
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).(isUnique)
          apply { table.index(customIndexName, isUnique, this) }
//        ^^^^^ reference semanticdb maven . . kotlin/apply().
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).(customIndexName)
//                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).(isUnique)
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex().
      /**
       * Creates a unique index composed by this column only.
       *
       * @param customIndexName Name of the index.
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex().[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex().(customIndexName)
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
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex().[T]
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex().(customIndexName)
          index(customIndexName, true)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+2).
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex().(customIndexName)
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+1).
      /**
       * Creates a unique index.
       *
       * @param columns Columns that compose the index.
       * @param filterCondition Index filtering conditions (also known as "partial index") declaration.
       */
//                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+1).(columns)
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+1).(filterCondition)
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
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+1).(columns)
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+1).(filterCondition)
          index(null, true, *columns, filterCondition = filterCondition)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).
//                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+1).(columns)
//                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+1).(filterCondition)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).
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
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(customIndexName)
          customIndexName: String? = null,
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(customIndexName)
//                        display_name customIndexName
//                        documentation ```kotlin\ncustomIndexName: String? = ...\n```
//                         ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(customIndexName)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(columns)
          vararg columns: Column<*>,
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(columns)
//                       display_name columns
//                       documentation ```kotlin\nvararg columns: Column<*>\n```
//                        ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(columns)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(functions)
          functions: List<ExpressionWithColumnType<*>>? = null,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(functions)
//                  display_name functions
//                  documentation ```kotlin\nfunctions: List<ExpressionWithColumnType<*>>? = ...\n```
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(functions)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(filterCondition)
          filterCondition: FilterCondition = null
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(filterCondition)
//                        display_name filterCondition
//                        documentation ```kotlin\nfilterCondition: {org/jetbrains/exposed/v1/core/FilterCondition=} (SqlExpressionBuilder.() -> Op<Boolean>)? = ...\n```
//                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(filterCondition)
      ) {
          index(customIndexName, true, *columns, functions = functions, filterCondition = filterCondition)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#index(+1).
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(customIndexName)
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(columns)
//                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(functions)
//                                                                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).(filterCondition)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#uniqueIndex(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().
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
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(from)
          vararg from: Column<*>,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(from)
//                    display_name from
//                    documentation ```kotlin\nvararg from: Column<*>\n```
//                     ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(from)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(target)
          target: PrimaryKey,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(target)
//               display_name target
//               documentation ```kotlin\ntarget: Table.PrimaryKey\n```
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(target)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(onUpdate)
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(onUpdate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(onDelete)
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(onDelete)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(name)
          name: String? = null
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(name)
//             display_name name
//             documentation ```kotlin\nname: String? = ...\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(name)
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
//            ⌄ enclosing_range_start local 92
              val fkName = if (name != null) " ($name)" else ""
//                ^^^^^^ definition local 92
//                       display_name fkName
//                       documentation ```kotlin\nlocal val fkName: String\n```
//                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(name)
//                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().(name)
//                                                            ⌃ enclosing_range_end local 92
              "Foreign key$fkName has ${from.size} columns, while referenced primary key (${target.name}) has ${target.columns.size}"
//                         ^^^^^^ reference local 92
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).
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
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(references)
          vararg references: Pair<Column<*>, Column<*>>,
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(references)
//                          display_name references
//                          documentation ```kotlin\nvararg references: Pair<Column<*>, Column<*>>\n```
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(references)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(onUpdate)
          onUpdate: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(onUpdate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(onDelete)
          onDelete: ReferenceOption? = null,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(onDelete)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(name)
          name: String? = null
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(name)
//             display_name name
//             documentation ```kotlin\nname: String? = ...\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).(name)
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKey(+1).
  
      // Check constraints
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
      /**
       * Creates a check constraint in this column.
       * @param name The name to identify the constraint, optional. Must be **unique** (case-insensitive) to this table,
       * otherwise, the constraint will not be created. All names are [trimmed][String.trim], blank names are ignored and
       * the database engine decides the default name.
       * @param op The expression against which the newly inserted values will be compared.
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().(name)
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().(op)
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
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().[T]
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().(name)
//                                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().(op)
//                                                          ⌄ enclosing_range_start local 93
          if (name.isEmpty() || table.checkConstraints.none { it.first.equals(name, true) }) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().(name)
//                 ^^^^^^^ reference semanticdb maven . . kotlin/text/isEmpty().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints.
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getCheckConstraints().
//                                                     ^^^^ reference semanticdb maven . . kotlin/collections/none(+19).
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 93
//                                                                                          display_name it
//                                                                                          documentation ```kotlin\nit: Pair<String, Op<Boolean>>\n```
//                                                            ^^ reference local 93
//                                                               ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                               ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                                     ^^^^^^ reference semanticdb maven . . kotlin/text/equals(+1).
//                                                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().(name)
//                                                                                        ⌃ enclosing_range_end local 93
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).
      /**
       * Creates a check constraint in this table.
       * @param name The name to identify the constraint, optional. Must be **unique** (case-insensitive) to this table,
       * otherwise, the constraint will not be created. All names are [trimmed][String.trim], blank names are ignored and
       * the database engine decides the default name.
       * @param op The expression against which the newly inserted values will be compared.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).(name)
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).(op)
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
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).(name)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).(op)
//                                                    ⌄ enclosing_range_start local 94
          if (name.isEmpty() || checkConstraints.none { it.first.equals(name, true) }) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).(name)
//                 ^^^^^^^ reference semanticdb maven . . kotlin/text/isEmpty().
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints.
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getCheckConstraints().
//                                               ^^^^ reference semanticdb maven . . kotlin/collections/none(+19).
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 94
//                                                                                    display_name it
//                                                                                    documentation ```kotlin\nit: Pair<String, Op<Boolean>>\n```
//                                                      ^^ reference local 94
//                                                         ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                         ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                               ^^^^^^ reference semanticdb maven . . kotlin/text/equals(+1).
//                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).(name)
//                                                                                  ⌃ enclosing_range_end local 94
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#check(+1).
  
      // Cloning utils
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clone().
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clone().[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clone().(replaceArgs)
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
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clone().[T]
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clone().(replaceArgs)
//        ⌄ enclosing_range_start local 95
          val consParams = primaryConstructor!!.parameters
//            ^^^^^^^^^^ definition local 95
//                       display_name consParams
//                       documentation ```kotlin\nlocal val consParams: List<KParameter>\n```
//                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/getPrimaryConstructor().
//                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/primaryConstructor.
//                                              ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KFunction#getParameters().
//                                              ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KFunction#parameters.
//                                                       ⌃ enclosing_range_end local 95
//        ⌄ enclosing_range_start local 96
          val mutableProperties = memberProperties.filterIsInstance<KMutableProperty1<T, Any?>>()
//            ^^^^^^^^^^^^^^^^^ definition local 96
//                              display_name mutableProperties
//                              documentation ```kotlin\nlocal val mutableProperties: List<KMutableProperty1<T, Any?>>\n```
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/getMemberProperties().
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/memberProperties.
//                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterIsInstance(+3).
//                                                                                              ⌃ enclosing_range_end local 96
//        ⌄ enclosing_range_start local 97
          val allValues = memberProperties
//            ^^^^^^^^^ definition local 97
//                      display_name allValues
//                      documentation ```kotlin\nlocal val allValues: Map<String, Any?>\n```
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/getMemberProperties().
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/memberProperties.
//                    ⌄ enclosing_range_start local 98
              .filter { it in mutableProperties || it.name in consParams.map(KParameter::name) }
//             ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 98
//                                                                                               display_name it
//                                                                                               documentation ```kotlin\nit: KProperty1<T, *>\n```
//                      ^^ reference local 98
//                         ^^ reference semanticdb maven . . kotlin/collections/contains(+9).
//                            ^^^^^^^^^^^^^^^^^ reference local 96
//                                                 ^^ reference local 98
//                                                    ^^^^ reference semanticdb maven . . kotlin/reflect/KProperty1#getName().
//                                                    ^^^^ reference semanticdb maven . . kotlin/reflect/KProperty1#name.
//                                                         ^^ reference semanticdb maven . . kotlin/collections/List#contains().
//                                                            ^^^^^^^^^^ reference local 95
//                                                                       ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                                                       ^^^^ reference semanticdb maven . . kotlin/reflect/KParameter#getName().
//                                                                                       ^^^^ reference semanticdb maven . . kotlin/reflect/KParameter#name.
//                                                                                             ⌃ enclosing_range_end local 98
//                       ⌄ enclosing_range_start local 99
              .associate { it.name to (replaceArgs[it] ?: it.get(this@clone)) }
//             ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/associate(+9).
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 99
//                                                                              display_name it
//                                                                              documentation ```kotlin\nit: KProperty1<T, *>\n```
//                         ^^ reference local 99
//                            ^^^^ reference semanticdb maven . . kotlin/reflect/KProperty1#getName().
//                            ^^^^ reference semanticdb maven . . kotlin/reflect/KProperty1#name.
//                                 ^^ reference semanticdb maven . . kotlin/to().
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clone().(replaceArgs)
//                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                 ^^ reference local 99
//                                                        ^^ reference local 99
//                                                           ^^^ reference semanticdb maven . . kotlin/reflect/KProperty1#get().
//                                                                            ⌃ enclosing_range_end local 97
//                                                                            ⌃ enclosing_range_end local 99
//                                                             ⌄ enclosing_range_start local 100
//                                                                                            ⌄ enclosing_range_start local 101
          primaryConstructor!!.callBy(consParams.associateWith { allValues[it.name] }).also { newInstance ->
//        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/getPrimaryConstructor().
//        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/full/primaryConstructor.
//                             ^^^^^^ reference semanticdb maven . . kotlin/reflect/KFunction#callBy().
//                                    ^^^^^^^^^^ reference local 95
//                                               ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/associateWith(+9).
//                                                             ^^^^^^^^^^^^^^^^^^^^^^ definition local 100
//                                                                                    display_name it
//                                                                                    documentation ```kotlin\nit: KParameter\n```
//                                                               ^^^^^^^^^ reference local 97
//                                                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/get().
//                                                                         ^^ reference local 100
//                                                                            ^^^^ reference semanticdb maven . . kotlin/reflect/KParameter#getName().
//                                                                            ^^^^ reference semanticdb maven . . kotlin/reflect/KParameter#name.
//                                                                                     ^^^^ reference semanticdb maven . . kotlin/also().
//                                                                                            ^^^^^^^^^^^ definition local 101
//                                                                                                        display_name newInstance
//                                                                                                        documentation ```kotlin\nnewInstance: T\n```
//                                                                                  ⌃ enclosing_range_end local 100
//                                                                                                      ⌃ enclosing_range_end local 101
//                 ⌄ enclosing_range_start local 103
//                         ⌄ enclosing_range_start local 102
              for (prop in mutableProperties) {
//                 ^^^^ definition local 103
//                      display_name prop
//                      documentation ```kotlin\nlocal val prop: KMutableProperty1<T, Any?>\n```
//                         ^^^^^^^^^^^^^^^^^ definition local 102
//                                           display_name <iterator>
//                                           documentation ```kotlin\nlocal val <iterator>: Iterator<KMutableProperty1<T, Any?>>\n```
//                         ^^^^^^^^^^^^^^^^^ reference local 102
//                         ^^^^^^^^^^^^^^^^^ reference local 96
//                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#hasNext().
//                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#next().
//                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#iterator().
//                    ⌃ enclosing_range_end local 103
//                                         ⌃ enclosing_range_end local 102
                  prop.set(newInstance, allValues[prop.name])
//                ^^^^ reference local 103
//                     ^^^ reference semanticdb maven . . kotlin/reflect/KMutableProperty1#set().
//                         ^^^^^^^^^^^ reference local 101
//                                      ^^^^^^^^^ reference local 97
//                                      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                ^^^^ reference local 103
//                                                     ^^^^ reference semanticdb maven . . kotlin/reflect/KMutableProperty1#getName().
//                                                     ^^^^ reference semanticdb maven . . kotlin/reflect/KMutableProperty1#name.
              }
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clone().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneAsBaseType().
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneAsBaseType().[T]
      private fun <T> IColumnType<T>.cloneAsBaseType(): IColumnType<T> = ((this as? AutoIncColumnType)?.delegate ?: this).clone()
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneAsBaseType().[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                                   ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneAsBaseType().
//                                                   display_name cloneAsBaseType
//                                                   documentation ```kotlin\nprivate final fun <T> IColumnType<T>.cloneAsBaseType(): IColumnType<T>\n```
//                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#
//                                                                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#delegate.
//                                                                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getDelegate().
//                                                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#clone().
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneAsBaseType().[T]
//                                                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneAsBaseType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc().
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc().[T]
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc().(idSeqName)
//                                                                                      ⌄ enclosing_range_start local 104
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
//                                                                                      ^^^^^^^^^^ definition local 104
//                                                                                                 display_name <when-subject>
//                                                                                                 documentation ```kotlin\nlocal val <when-subject>: IColumnType<T & Any>\n```
//                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc().[T]
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc().(idSeqName)
//                                                                                               ⌃ enclosing_range_end local 104
          is AutoIncColumnType -> this
//           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#
          is ColumnType -> {
//           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//            ⌄ enclosing_range_start local 105
              val fallbackSequenceName = fallbackSequenceName(tableName = tableName, columnName = name)
//                ^^^^^^^^^^^^^^^^^^^^ definition local 105
//                                     display_name fallbackSequenceName
//                                     documentation ```kotlin\nlocal val fallbackSequenceName: String\n```
//                                       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().
//                                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                                                    ⌃ enclosing_range_end local 105
              this.withColumnType(
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#withColumnType().
                  AutoIncColumnType(columnType, idSeqName, fallbackSequenceName)
//                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#`<init>`().
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc().(idSeqName)
//                                                         ^^^^^^^^^^^^^^^^^^^^ reference local 105
              )
          }
  
          else -> error("Unsupported column type for auto-increment $columnType")
//                ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc(+1).
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc(+1).[T]
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc(+1).(sequence)
//                                                                                      ⌄ enclosing_range_start local 106
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
//                                                                                      ^^^^^^^^^^ definition local 106
//                                                                                                 display_name <when-subject>
//                                                                                                 documentation ```kotlin\nlocal val <when-subject>: IColumnType<T & Any>\n```
//                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc(+1).[T]
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc(+1).(sequence)
//                                                                                               ⌃ enclosing_range_end local 106
          is AutoIncColumnType -> this
//           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#
          is ColumnType -> this.withColumnType(AutoIncColumnType(columnType, sequence))
//           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#cloneWithAutoInc(+1).
  
      // DDL statements
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKeyConstraint().
      @OptIn(InternalApi::class)
      internal fun primaryKeyConstraint(): String? {
//                 ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKeyConstraint().
//                                      display_name primaryKeyConstraint
//                                      documentation ```kotlin\n@OptIn(...) internal final fun primaryKeyConstraint(): String?\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                 ⌄ enclosing_range_start local 107
          return primaryKey?.let { primaryKey ->
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                           ^^^ reference semanticdb maven . . kotlin/let().
//                                 ^^^^^^^^^^ definition local 107
//                                            display_name primaryKey
//                                            documentation ```kotlin\nprimaryKey: Table.PrimaryKey\n```
//                                          ⌃ enclosing_range_end local 107
//            ⌄ enclosing_range_start local 108
              val tr = CoreTransactionManager.currentTransaction()
//                ^^ definition local 108
//                   display_name tr
//                   documentation ```kotlin\nlocal val tr: Transaction\n```
//                                            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                               ⌃ enclosing_range_end local 108
//            ⌄ enclosing_range_start local 109
              val constraint = tr.db.identifierManager.cutIfNecessaryAndQuote(primaryKey.name)
//                ^^^^^^^^^^ definition local 109
//                           display_name constraint
//                           documentation ```kotlin\nlocal val constraint: String\n```
//                             ^^ reference local 108
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
//                                                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                                                                            ^^^^^^^^^^ reference local 107
//                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getName().
//                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#name.
//                                                                                           ⌃ enclosing_range_end local 109
              return primaryKey.columns
//                   ^^^^^^^^^^ reference local 107
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
                  .joinToString(prefix = "CONSTRAINT $constraint PRIMARY KEY (", postfix = ")", transform = tr::identity)
//                 ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString().
//                                                    ^^^^^^^^^^ reference local 109
//                                                                                                          ^^ reference local 108
//                                                                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKeyConstraint().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#createStatement().
      override fun createStatement(): List<String> {
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#createStatement().
//                                 display_name createStatement
//                                 documentation ```kotlin\npublic open override fun createStatement(): List<String>\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#createStatement().
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#createStatement().
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//        ⌄ enclosing_range_start local 110
          @OptIn(InternalApi::class)
          val addForeignKeysInAlterPart = TableUtils.checkCycle(this) && currentDialect !is SQLiteDialect
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 110
//                                      display_name addForeignKeysInAlterPart
//                                      documentation ```kotlin\n@OptIn(...) local val addForeignKeysInAlterPart: Boolean\n```
//                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#checkCycle().
//                                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#
//                                                                                                      ⌃ enclosing_range_end local 110
  
//        ⌄ enclosing_range_start local 111
          val foreignKeyConstraints = foreignKeys
//            ^^^^^^^^^^^^^^^^^^^^^ definition local 111
//                                  display_name foreignKeyConstraints
//                                  documentation ```kotlin\nlocal val foreignKeyConstraints: List<ForeignKeyConstraint>\n```
//                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#foreignKeys.
//                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getForeignKeys().
//                                              ⌃ enclosing_range_end local 111
  
//        ⌄ enclosing_range_start local 112
          @OptIn(InternalApi::class)
          val createTable = buildString {
//            ^^^^^^^^^^^ definition local 112
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
//                                                      ⌄ enclosing_range_start local 113
                  columns.joinTo(this, prefix = " (") { column ->
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                        ^^^^^^ reference semanticdb maven . . kotlin/collections/joinTo(+9).
//                                                      ^^^^^^ definition local 113
//                                                             display_name column
//                                                             documentation ```kotlin\ncolumn: Column<*>\n```
//                                                           ⌃ enclosing_range_end local 113
                      column.descriptionDdl(false)
//                    ^^^^^^ reference local 113
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#descriptionDdl().
                  }
  
//                                ⌄ enclosing_range_start local 114
                  if (columns.any { it.isPrimaryConstraintWillBeDefined }) {
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                            ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 114
//                                                                        display_name it
//                                                                        documentation ```kotlin\nit: Column<*>\n```
//                                  ^^ reference local 114
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getIsPrimaryConstraintWillBeDefined().
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#isPrimaryConstraintWillBeDefined.
//                                                                      ⌃ enclosing_range_end local 114
//                                                ⌄ enclosing_range_start local 115
                      primaryKeyConstraint()?.let { append(", $it") }
//                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKeyConstraint().
//                                            ^^^ reference semanticdb maven . . kotlin/let().
//                                                ^^^^^^^^^^^^^^^^^^^ definition local 115
//                                                                    display_name it
//                                                                    documentation ```kotlin\nit: String\n```
//                                                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                                             ^^ reference local 115
//                                                                  ⌃ enclosing_range_end local 115
                  }
  
                  if (!addForeignKeysInAlterPart && foreignKeyConstraints.isNotEmpty()) {
//                    ^ reference semanticdb maven . . kotlin/Boolean#not().
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 110
//                                                  ^^^^^^^^^^^^^^^^^^^^^ reference local 111
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                                                                        ⌄ enclosing_range_start local 116
                      foreignKeyConstraints.joinTo(this, prefix = ", ", separator = ", ") { it.foreignKeyPart }
//                    ^^^^^^^^^^^^^^^^^^^^^ reference local 111
//                                          ^^^^^^ reference semanticdb maven . . kotlin/collections/joinTo(+9).
//                                                                                        ^^^^^^^^^^^^^^^^^^^^^ definition local 116
//                                                                                                              display_name it
//                                                                                                              documentation ```kotlin\nit: ForeignKeyConstraint\n```
//                                                                                          ^^ reference local 116
//                                                                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#foreignKeyPart.
//                                                                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getForeignKeyPart().
//                                                                                                            ⌃ enclosing_range_end local 116
                  }
  
                  if (checkConstraints.isNotEmpty()) {
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getCheckConstraints().
//                                     ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                           ⌄ enclosing_range_start local 117
                      checkConstraints().map { it.checkPart }.ifEmpty { null }?.joinTo(this, prefix = ", ")
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#checkConstraints(+1).
//                                       ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                           ^^^^^^^^^^^^^^^^ definition local 117
//                                                            display_name it
//                                                            documentation ```kotlin\nit: CheckConstraint\n```
//                                             ^^ reference local 117
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#checkPart.
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getCheckPart().
//                                                            ^^^^^^^ reference semanticdb maven . . kotlin/collections/ifEmpty(+1).
//                                                                              ^^^^^^ reference semanticdb maven . . kotlin/collections/joinTo(+9).
//                                                          ⌃ enclosing_range_end local 117
                  }
  
                  append(")")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              }
          }
//        ⌃ enclosing_range_end local 112
  
//        ⌄ enclosing_range_start local 118
          val createConstraint = if (addForeignKeysInAlterPart) {
//            ^^^^^^^^^^^^^^^^ definition local 118
//                             display_name createConstraint
//                             documentation ```kotlin\nlocal val createConstraint: List<String>\n```
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 110
//                                          ⌄ enclosing_range_start local 119
              foreignKeyConstraints.flatMap { it.createStatement() }
//            ^^^^^^^^^^^^^^^^^^^^^ reference local 111
//                                  ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap(+10).
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 119
//                                                                   display_name it
//                                                                   documentation ```kotlin\nit: ForeignKeyConstraint\n```
//                                            ^^ reference local 119
//                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#createStatement().
//                                                                 ⌃ enclosing_range_end local 119
          } else {
              emptyList()
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
          }
//        ⌃ enclosing_range_end local 118
  
          return createAutoIncColumnSequence() + createTable + createConstraint
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#createAutoIncColumnSequence().
//                                             ^ reference semanticdb maven . . kotlin/collections/plus(+28).
//                                               ^^^^^^^^^^^ reference local 112
//                                                           ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                             ^^^^^^^^^^^^^^^^ reference local 118
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#createStatement().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#createAutoIncColumnSequence().
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
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#createAutoIncColumnSequence().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#modifyStatement().
      override fun modifyStatement(): List<String> =
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#modifyStatement().
//                                 display_name modifyStatement
//                                 documentation ```kotlin\npublic open override fun modifyStatement(): List<String>\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#modifyStatement().
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#modifyStatement().
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          throw UnsupportedOperationException("Use modify on columns and indices")
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/UnsupportedOperationException#`<init>`().
//                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#modifyStatement().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#dropStatement().
      override fun dropStatement(): List<String> {
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Table#dropStatement().
//                               display_name dropStatement
//                               documentation ```kotlin\npublic open override fun dropStatement(): List<String>\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#dropStatement().
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#dropStatement().
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//        ⌄ enclosing_range_start local 120
          @OptIn(InternalApi::class)
          val dropTable = buildString {
//            ^^^^^^^^^ definition local 120
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
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
                  append(" CASCADE CONSTRAINTS")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              } else if (currentDialectIfAvailable is PostgreSQLDialect && TableUtils.checkCycle(this@Table)) {
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
//                                                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TableUtils#checkCycle().
                  append(" CASCADE")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              }
          }
//        ⌃ enclosing_range_end local 120
  
//        ⌄ enclosing_range_start local 121
          val dropSequence = autoIncColumn?.autoIncColumnType?.sequence?.dropStatement().orEmpty()
//            ^^^^^^^^^^^^ definition local 121
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
//                                                                                               ⌃ enclosing_range_end local 121
  
          return listOf(dropTable) + dropSequence
//               ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                      ^^^^^^^^^ reference local 120
//                                 ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                   ^^^^^^^^^^^^ reference local 121
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#dropStatement().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#equals().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#equals().(other)
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
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#equals().(other)
          if (this === other) return true
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#equals().(other)
          if (other !is Table) return false
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#equals().(other)
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
  
          if (tableName != other.tableName) return false
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#equals().(other)
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
  
          return true
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#equals().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#hashCode().
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
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#hashCode().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#Dual#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Table#Dual#`<init>`().
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
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#Dual#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#Dual#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/targetTables().
  /** Returns the list of tables to which the columns in this column set belong. */
//                                                  ⌄ enclosing_range_start local 122
  fun ColumnSet.targetTables(): List<Table> = when (this) {
//              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/targetTables().
//                           display_name targetTables
//                           documentation ```kotlin\npublic final fun ColumnSet.targetTables(): List<Table>\n```\n\n----\n\n Returns the list of tables to which the columns in this column set belong.
//                              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                  ^^^^ definition local 122
//                                                       display_name <when-subject>
//                                                       documentation ```kotlin\nlocal val <when-subject>: ColumnSet\n```
//                                                     ⌃ enclosing_range_end local 122
      is Alias<*> -> listOf(this.delegate)
//       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#
//                   ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
      is QueryAlias -> this.query.set.source.targetTables()
//       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getQuery().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#query.
//                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#getSet().
//                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#set.
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#getSource().
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FieldSet#source.
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/targetTables().
      is Table -> listOf(this)
//       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                                  ⌄ enclosing_range_start local 123
      is Join -> this.table.targetTables() + this.joinParts.flatMap { it.joinPart.targetTables() }
//       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getTable().
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#table.
//                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/targetTables().
//                                         ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                                                          ^^^^^^^ reference semanticdb maven . . kotlin/collections/flatMap(+10).
//                                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 123
//                                                                                                 display_name it
//                                                                                                 documentation ```kotlin\nit: Join.JoinPart\n```
//                                                                    ^^ reference local 123
//                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/targetTables().
//                                                                                               ⌃ enclosing_range_end local 123
      else -> error("No target provided for update")
//            ^^^^^ reference semanticdb maven . . kotlin/error().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/targetTables().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/isAlreadyQuoted().
  private fun String.isAlreadyQuoted(): Boolean =
//                   ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/isAlreadyQuoted().
//                                   display_name isAlreadyQuoted
//                                   documentation ```kotlin\nprivate final fun String.isAlreadyQuoted(): Boolean\n```
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                 ⌄ enclosing_range_start local 124
      listOf("\"", "'", "`").any { quoteString ->
//    ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf(+1).
//                           ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                                 ^^^^^^^^^^^ definition local 124
//                                             display_name quoteString
//                                             documentation ```kotlin\nquoteString: String\n```
//                                           ⌃ enclosing_range_end local 124
          startsWith(quoteString) && endsWith(quoteString)
//        ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                   ^^^^^^^^^^^ reference local 124
//                                   ^^^^^^^^ reference semanticdb maven . . kotlin/text/endsWith().
//                                            ^^^^^^^^^^^ reference local 124
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/isAlreadyQuoted().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().(tableName)
//                                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().(columnName)
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
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().(tableName)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().(columnName)
//    ⌄ enclosing_range_start local 125
      val q = if (tableName.contains('.')) "\"" else ""
//        ^ definition local 125
//          display_name q
//          documentation ```kotlin\nlocal val q: String\n```
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().(tableName)
//                          ^^^^^^^^ reference semanticdb maven . . kotlin/text/contains(+1).
//                                                    ⌃ enclosing_range_end local 125
      return "$q${tableName.replace("\"", "")}_${columnName}_seq$q"
//             ^ reference local 125
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().(tableName)
//                          ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
//                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().(columnName)
//                                                               ^ reference local 125
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/fallbackSequenceName().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().[T]
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
//             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().[T]
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/unquotedName().
